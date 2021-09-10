package net.minecraft.client.renderer.chunk;

import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RegionRenderCacheBuilder;
import net.minecraft.client.renderer.VertexBufferUploader;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.WorldVertexBufferUploader;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.MathHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;

public class ChunkRenderDispatcher {
   private static final ThreadFactory threadFactory = (new ThreadFactoryBuilder()).setNameFormat("Chunk Batcher %d").setDaemon(true).build();
   private static final Logger logger = LogManager.getLogger();
   private final WorldVertexBufferUploader worldVertexUploader;
   private final BlockingQueue<ChunkCompileTaskGenerator> queueChunkUpdates;
   private final int countRenderBuilders;
   private final List<ChunkRenderWorker> listThreadedWorkers;
   private final Queue<ListenableFutureTask<?>> queueChunkUploads;
   private List<RegionRenderCacheBuilder> listPausedBuilders;
   private final BlockingQueue<RegionRenderCacheBuilder> queueFreeRenderBuilders;
   private final VertexBufferUploader vertexUploader;
   private final ChunkRenderWorker renderWorker;

   public void stopChunkUpdates() {
      this.clearChunkUpdates();

      while(this.runChunkUploads(0L)) {
      }

      ArrayList var1 = Lists.newArrayList();

      while(var1.size() != this.countRenderBuilders) {
         try {
            var1.add(this.allocateRenderBuilder());
         } catch (InterruptedException var3) {
         }
      }

      this.queueFreeRenderBuilders.addAll(var1);
   }

   public String getDebugInfo() {
      return String.format("pC: %03d, pU: %1d, aB: %1d", this.queueChunkUpdates.size(), this.queueChunkUploads.size(), this.queueFreeRenderBuilders.size());
   }

   static BlockingQueue access$0(ChunkRenderDispatcher var0) {
      return var0.queueChunkUpdates;
   }

   public ChunkCompileTaskGenerator getNextChunkUpdate() throws InterruptedException {
      return (ChunkCompileTaskGenerator)this.queueChunkUpdates.take();
   }

   public void clearChunkUpdates() {
      while(!this.queueChunkUpdates.isEmpty()) {
         ChunkCompileTaskGenerator var1 = (ChunkCompileTaskGenerator)this.queueChunkUpdates.poll();
         if (var1 != null) {
            var1.finish();
         }
      }

   }

   public boolean hasChunkUpdates() {
      return this.queueChunkUpdates.isEmpty() && this.queueChunkUploads.isEmpty();
   }

   private void uploadVertexBuffer(WorldRenderer var1, VertexBuffer var2) {
      this.vertexUploader.setVertexBuffer(var2);
      this.vertexUploader.draw(var1);
   }

   public void freeRenderBuilder(RegionRenderCacheBuilder var1) {
      this.queueFreeRenderBuilders.add(var1);
   }

   public void resumeChunkUpdates() {
      this.queueFreeRenderBuilders.addAll(this.listPausedBuilders);
      this.listPausedBuilders.clear();
   }

   private void uploadDisplayList(WorldRenderer var1, int var2, RenderChunk var3) {
      GL11.glNewList(var2, 4864);
      GlStateManager.pushMatrix();
      var3.multModelviewMatrix();
      this.worldVertexUploader.draw(var1);
      GlStateManager.popMatrix();
      GL11.glEndList();
   }

   public ChunkRenderDispatcher(int var1) {
      this.listThreadedWorkers = Lists.newArrayList();
      this.queueChunkUpdates = Queues.newArrayBlockingQueue(100);
      this.worldVertexUploader = new WorldVertexBufferUploader();
      this.vertexUploader = new VertexBufferUploader();
      this.queueChunkUploads = Queues.newArrayDeque();
      this.listPausedBuilders = new ArrayList();
      int var2 = Math.max(1, (int)((double)Runtime.getRuntime().maxMemory() * 0.3D) / 10485760);
      int var3 = Math.max(1, MathHelper.clamp_int(Runtime.getRuntime().availableProcessors() - 2, 1, var2 / 5));
      if (var1 < 0) {
         this.countRenderBuilders = MathHelper.clamp_int(var3 * 8, 1, var2);
      } else {
         this.countRenderBuilders = var1;
      }

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         ChunkRenderWorker var5 = new ChunkRenderWorker(this);
         Thread var6 = threadFactory.newThread(var5);
         var6.start();
         this.listThreadedWorkers.add(var5);
      }

      this.queueFreeRenderBuilders = Queues.newArrayBlockingQueue(this.countRenderBuilders);

      for(var4 = 0; var4 < this.countRenderBuilders; ++var4) {
         this.queueFreeRenderBuilders.add(new RegionRenderCacheBuilder());
      }

      this.renderWorker = new ChunkRenderWorker(this, new RegionRenderCacheBuilder());
   }

   public ChunkRenderDispatcher() {
      this(-1);
   }

   public boolean updateTransparencyLater(RenderChunk var1) {
      var1.getLockCompileTask().lock();

      boolean var6;
      try {
         ChunkCompileTaskGenerator var3 = var1.makeCompileTaskTransparency();
         boolean var4;
         if (var3 == null) {
            var4 = true;
            var1.getLockCompileTask().unlock();
            return var4;
         }

         var3.addFinishRunnable(new Runnable(this, var3) {
            private final ChunkCompileTaskGenerator val$chunkcompiletaskgenerator;
            final ChunkRenderDispatcher this$0;

            public void run() {
               ChunkRenderDispatcher.access$0(this.this$0).remove(this.val$chunkcompiletaskgenerator);
            }

            {
               this.this$0 = var1;
               this.val$chunkcompiletaskgenerator = var2;
            }
         });
         var4 = this.queueChunkUpdates.offer(var3);
         var6 = var4;
      } finally {
         var1.getLockCompileTask().unlock();
      }

      return var6;
   }

   public ListenableFuture<Object> uploadChunk(EnumWorldBlockLayer var1, WorldRenderer var2, RenderChunk var3, CompiledChunk var4) {
      if (Minecraft.getMinecraft().isCallingFromMinecraftThread()) {
         if (OpenGlHelper.useVbo()) {
            this.uploadVertexBuffer(var2, var3.getVertexBufferByLayer(var1.ordinal()));
         } else {
            this.uploadDisplayList(var2, ((ListedRenderChunk)var3).getDisplayList(var1, var4), var3);
         }

         var2.setTranslation(0.0D, 0.0D, 0.0D);
         return Futures.immediateFuture((Object)null);
      } else {
         ListenableFutureTask var5 = ListenableFutureTask.create(new Runnable(this, var1, var2, var3, var4) {
            private final CompiledChunk val$compiledChunkIn;
            private final WorldRenderer val$p_178503_2_;
            private final EnumWorldBlockLayer val$player;
            final ChunkRenderDispatcher this$0;
            private final RenderChunk val$chunkRenderer;

            public void run() {
               this.this$0.uploadChunk(this.val$player, this.val$p_178503_2_, this.val$chunkRenderer, this.val$compiledChunkIn);
            }

            {
               this.this$0 = var1;
               this.val$player = var2;
               this.val$p_178503_2_ = var3;
               this.val$chunkRenderer = var4;
               this.val$compiledChunkIn = var5;
            }
         }, (Object)null);
         synchronized(this.queueChunkUploads) {
            this.queueChunkUploads.add(var5);
            return var5;
         }
      }
   }

   public void pauseChunkUpdates() {
      while(this.listPausedBuilders.size() != this.countRenderBuilders) {
         try {
            this.runChunkUploads(Long.MAX_VALUE);
            RegionRenderCacheBuilder var1 = (RegionRenderCacheBuilder)this.queueFreeRenderBuilders.poll(100L, TimeUnit.MILLISECONDS);
            if (var1 != null) {
               this.listPausedBuilders.add(var1);
            }
         } catch (InterruptedException var2) {
         }
      }

   }

   public boolean updateChunkNow(RenderChunk var1) {
      var1.getLockCompileTask().lock();

      try {
         ChunkCompileTaskGenerator var3 = var1.makeCompileTaskChunk();

         try {
            this.renderWorker.processTask(var3);
         } catch (InterruptedException var8) {
         }

         boolean var2 = true;
         var1.getLockCompileTask().unlock();
         return var2;
      } finally {
         var1.getLockCompileTask().unlock();
      }
   }

   public RegionRenderCacheBuilder allocateRenderBuilder() throws InterruptedException {
      return (RegionRenderCacheBuilder)this.queueFreeRenderBuilders.take();
   }

   public boolean runChunkUploads(long var1) {
      boolean var3 = false;

      long var6;
      do {
         boolean var4 = false;
         ListenableFutureTask var5 = null;
         synchronized(this.queueChunkUploads) {
            var5 = (ListenableFutureTask)this.queueChunkUploads.poll();
         }

         if (var5 != null) {
            var5.run();
            var4 = true;
            var3 = true;
         }

         if (var1 == 0L || !var4) {
            break;
         }

         var6 = var1 - System.nanoTime();
      } while(var6 >= 0L);

      return var3;
   }

   public boolean updateChunkLater(RenderChunk var1) {
      var1.getLockCompileTask().lock();

      try {
         ChunkCompileTaskGenerator var3 = var1.makeCompileTaskChunk();
         var3.addFinishRunnable(new Runnable(this, var3) {
            private final ChunkCompileTaskGenerator val$chunkcompiletaskgenerator;
            final ChunkRenderDispatcher this$0;

            {
               this.this$0 = var1;
               this.val$chunkcompiletaskgenerator = var2;
            }

            public void run() {
               ChunkRenderDispatcher.access$0(this.this$0).remove(this.val$chunkcompiletaskgenerator);
            }
         });
         boolean var4 = this.queueChunkUpdates.offer(var3);
         if (!var4) {
            var3.finish();
         }

         var1.getLockCompileTask().unlock();
         return var4;
      } finally {
         var1.getLockCompileTask().unlock();
      }
   }
}
