package net.minecraft.client.renderer.chunk;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import net.minecraft.client.renderer.RegionRenderCacheBuilder;

public class ChunkCompileTaskGenerator {
   private CompiledChunk compiledChunk;
   private final RenderChunk renderChunk;
   private final List<Runnable> listFinishRunnables = Lists.newArrayList();
   private ChunkCompileTaskGenerator.Status status;
   private RegionRenderCacheBuilder regionRenderCacheBuilder;
   private final ReentrantLock lock = new ReentrantLock();
   private final ChunkCompileTaskGenerator.Type type;
   private boolean finished;

   public ChunkCompileTaskGenerator.Status getStatus() {
      return this.status;
   }

   public void setStatus(ChunkCompileTaskGenerator.Status var1) {
      this.lock.lock();

      try {
         this.status = var1;
         this.lock.unlock();
      } finally {
         this.lock.unlock();
      }
   }

   public RenderChunk getRenderChunk() {
      return this.renderChunk;
   }

   public ChunkCompileTaskGenerator(RenderChunk var1, ChunkCompileTaskGenerator.Type var2) {
      this.status = ChunkCompileTaskGenerator.Status.PENDING;
      this.renderChunk = var1;
      this.type = var2;
   }

   public void setRegionRenderCacheBuilder(RegionRenderCacheBuilder var1) {
      this.regionRenderCacheBuilder = var1;
   }

   public void addFinishRunnable(Runnable var1) {
      this.lock.lock();

      try {
         this.listFinishRunnables.add(var1);
         if (this.finished) {
            var1.run();
         }
      } finally {
         this.lock.unlock();
      }

   }

   public void finish() {
      this.lock.lock();

      try {
         if (this.type == ChunkCompileTaskGenerator.Type.REBUILD_CHUNK && this.status != ChunkCompileTaskGenerator.Status.DONE) {
            this.renderChunk.setNeedsUpdate(true);
         }

         this.finished = true;
         this.status = ChunkCompileTaskGenerator.Status.DONE;
         Iterator var2 = this.listFinishRunnables.iterator();

         while(var2.hasNext()) {
            Runnable var1 = (Runnable)var2.next();
            var1.run();
         }

         this.lock.unlock();
      } finally {
         this.lock.unlock();
      }
   }

   public void setCompiledChunk(CompiledChunk var1) {
      this.compiledChunk = var1;
   }

   public boolean isFinished() {
      return this.finished;
   }

   public ChunkCompileTaskGenerator.Type getType() {
      return this.type;
   }

   public RegionRenderCacheBuilder getRegionRenderCacheBuilder() {
      return this.regionRenderCacheBuilder;
   }

   public CompiledChunk getCompiledChunk() {
      return this.compiledChunk;
   }

   public ReentrantLock getLock() {
      return this.lock;
   }

   public static enum Type {
      REBUILD_CHUNK;

      private static final ChunkCompileTaskGenerator.Type[] ENUM$VALUES = new ChunkCompileTaskGenerator.Type[]{REBUILD_CHUNK, RESORT_TRANSPARENCY};
      RESORT_TRANSPARENCY;
   }

   public static enum Status {
      DONE,
      UPLOADING,
      PENDING;

      private static final ChunkCompileTaskGenerator.Status[] ENUM$VALUES = new ChunkCompileTaskGenerator.Status[]{PENDING, COMPILING, UPLOADING, DONE};
      COMPILING;
   }
}
