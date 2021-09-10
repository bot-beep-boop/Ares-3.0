package net.minecraft.client.renderer.chunk;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RegionRenderCacheBuilder;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumWorldBlockLayer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChunkRenderWorker implements Runnable {
   private final RegionRenderCacheBuilder regionRenderCacheBuilder;
   private static final Logger LOGGER = LogManager.getLogger();
   private final ChunkRenderDispatcher chunkRenderDispatcher;

   public ChunkRenderWorker(ChunkRenderDispatcher var1) {
      this(var1, (RegionRenderCacheBuilder)null);
   }

   private void freeRenderBuilder(ChunkCompileTaskGenerator var1) {
      if (this.regionRenderCacheBuilder == null) {
         this.chunkRenderDispatcher.freeRenderBuilder(var1.getRegionRenderCacheBuilder());
      }

   }

   protected void processTask(ChunkCompileTaskGenerator var1) throws InterruptedException {
      var1.getLock().lock();
      boolean var18 = false;

      label280: {
         Entity var2;
         try {
            var18 = true;
            if (var1.getStatus() != ChunkCompileTaskGenerator.Status.PENDING) {
               if (!var1.isFinished()) {
                  LOGGER.warn("Chunk render task was " + var1.getStatus() + " when I expected it to be pending; ignoring task");
                  var18 = false;
               } else {
                  var18 = false;
               }
               break label280;
            }

            var1.setStatus(ChunkCompileTaskGenerator.Status.COMPILING);
            var1.getLock().unlock();
            var2 = Minecraft.getMinecraft().getRenderViewEntity();
            if (var2 == null) {
               var1.finish();
               var18 = false;
               return;
            }

            var18 = false;
         } finally {
            if (var18) {
               var1.getLock().unlock();
            }
         }

         var1.setRegionRenderCacheBuilder(this.getRegionRenderCacheBuilder());
         float var3 = (float)var2.posX;
         float var4 = (float)var2.posY + var2.getEyeHeight();
         float var5 = (float)var2.posZ;
         ChunkCompileTaskGenerator.Type var6 = var1.getType();
         if (var6 == ChunkCompileTaskGenerator.Type.REBUILD_CHUNK) {
            var1.getRenderChunk().rebuildChunk(var3, var4, var5, var1);
         } else if (var6 == ChunkCompileTaskGenerator.Type.RESORT_TRANSPARENCY) {
            var1.getRenderChunk().resortTransparency(var3, var4, var5, var1);
         }

         var1.getLock().lock();
         boolean var15 = false;

         label291: {
            CompiledChunk var7;
            ArrayList var8;
            label264: {
               label263: {
                  int var10;
                  int var11;
                  EnumWorldBlockLayer[] var12;
                  try {
                     var15 = true;
                     if (var1.getStatus() != ChunkCompileTaskGenerator.Status.COMPILING) {
                        if (!var1.isFinished()) {
                           LOGGER.warn("Chunk render task was " + var1.getStatus() + " when I expected it to be compiling; aborting task");
                        }

                        this.freeRenderBuilder(var1);
                        var15 = false;
                        break label291;
                     }

                     var1.setStatus(ChunkCompileTaskGenerator.Status.UPLOADING);
                     var1.getLock().unlock();
                     var7 = var1.getCompiledChunk();
                     var8 = Lists.newArrayList();
                     if (var6 != ChunkCompileTaskGenerator.Type.REBUILD_CHUNK) {
                        var15 = false;
                        break label263;
                     }

                     var11 = (var12 = EnumWorldBlockLayer.values()).length;
                     var10 = 0;
                     var15 = false;
                  } finally {
                     if (var15) {
                        var1.getLock().unlock();
                     }
                  }

                  while(true) {
                     if (var10 >= var11) {
                        break label264;
                     }

                     EnumWorldBlockLayer var9 = var12[var10];
                     if (var7.isLayerStarted(var9)) {
                        var8.add(this.chunkRenderDispatcher.uploadChunk(var9, var1.getRegionRenderCacheBuilder().getWorldRendererByLayer(var9), var1.getRenderChunk(), var7));
                     }

                     ++var10;
                  }
               }

               if (var6 == ChunkCompileTaskGenerator.Type.RESORT_TRANSPARENCY) {
                  var8.add(this.chunkRenderDispatcher.uploadChunk(EnumWorldBlockLayer.TRANSLUCENT, var1.getRegionRenderCacheBuilder().getWorldRendererByLayer(EnumWorldBlockLayer.TRANSLUCENT), var1.getRenderChunk(), var7));
               }
            }

            ListenableFuture var21 = Futures.allAsList(var8);
            var1.addFinishRunnable(new Runnable(this, var21) {
               private final ListenableFuture val$listenablefuture;
               final ChunkRenderWorker this$0;

               {
                  this.this$0 = var1;
                  this.val$listenablefuture = var2;
               }

               public void run() {
                  this.val$listenablefuture.cancel(false);
               }
            });
            Futures.addCallback(var21, new FutureCallback<List<Object>>(this, var1, var7) {
               private final ChunkCompileTaskGenerator val$generator;
               final ChunkRenderWorker this$0;
               private final CompiledChunk val$lvt_7_1_;

               public void onSuccess(List<Object> var1) {
                  ChunkRenderWorker.access$0(this.this$0, this.val$generator);
                  this.val$generator.getLock().lock();

                  try {
                     if (this.val$generator.getStatus() != ChunkCompileTaskGenerator.Status.UPLOADING) {
                        if (!this.val$generator.isFinished()) {
                           ChunkRenderWorker.access$1().warn("Chunk render task was " + this.val$generator.getStatus() + " when I expected it to be uploading; aborting task");
                        }

                        return;
                     }

                     this.val$generator.setStatus(ChunkCompileTaskGenerator.Status.DONE);
                  } finally {
                     this.val$generator.getLock().unlock();
                  }

                  this.val$generator.getRenderChunk().setCompiledChunk(this.val$lvt_7_1_);
               }

               public void onFailure(Throwable var1) {
                  ChunkRenderWorker.access$0(this.this$0, this.val$generator);
                  if (!(var1 instanceof CancellationException) && !(var1 instanceof InterruptedException)) {
                     Minecraft.getMinecraft().crashed(CrashReport.makeCrashReport(var1, "Rendering chunk"));
                  }

               }

               {
                  this.this$0 = var1;
                  this.val$generator = var2;
                  this.val$lvt_7_1_ = var3;
               }

               public void onSuccess(Object var1) {
                  this.onSuccess((List)var1);
               }
            });
            return;
         }

         var1.getLock().unlock();
         return;
      }

      var1.getLock().unlock();
   }

   public void run() {
      while(true) {
         try {
            this.processTask(this.chunkRenderDispatcher.getNextChunkUpdate());
         } catch (InterruptedException var3) {
            LOGGER.debug("Stopping due to interrupt");
            return;
         } catch (Throwable var4) {
            CrashReport var2 = CrashReport.makeCrashReport(var4, "Batching chunks");
            Minecraft.getMinecraft().crashed(Minecraft.getMinecraft().addGraphicsAndWorldToCrashReport(var2));
            return;
         }
      }
   }

   static void access$0(ChunkRenderWorker var0, ChunkCompileTaskGenerator var1) {
      var0.freeRenderBuilder(var1);
   }

   public ChunkRenderWorker(ChunkRenderDispatcher var1, RegionRenderCacheBuilder var2) {
      this.chunkRenderDispatcher = var1;
      this.regionRenderCacheBuilder = var2;
   }

   private RegionRenderCacheBuilder getRegionRenderCacheBuilder() throws InterruptedException {
      return this.regionRenderCacheBuilder != null ? this.regionRenderCacheBuilder : this.chunkRenderDispatcher.allocateRenderBuilder();
   }

   static Logger access$1() {
      return LOGGER;
   }
}
