package net.minecraft.client.renderer;

import java.nio.IntBuffer;
import java.util.Iterator;
import net.minecraft.client.renderer.chunk.ListedRenderChunk;
import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.src.Config;
import net.minecraft.util.EnumWorldBlockLayer;
import org.lwjgl.opengl.GL11;

public class RenderList extends ChunkRenderContainer {
   private double viewEntityZ;
   private double viewEntityX;
   private double viewEntityY;
   IntBuffer bufferLists = GLAllocation.createDirectIntBuffer(16);

   public void renderChunkLayer(EnumWorldBlockLayer var1) {
      if (this.initialized) {
         if (!Config.isRenderRegions()) {
            Iterator var9 = this.renderChunks.iterator();

            while(var9.hasNext()) {
               RenderChunk var8 = (RenderChunk)var9.next();
               ListedRenderChunk var10 = (ListedRenderChunk)var8;
               GlStateManager.pushMatrix();
               this.preRenderChunk(var8);
               GL11.glCallList(var10.getDisplayList(var1, var10.getCompiledChunk()));
               GlStateManager.popMatrix();
            }
         } else {
            int var2 = Integer.MIN_VALUE;
            int var3 = Integer.MIN_VALUE;
            Iterator var5 = this.renderChunks.iterator();

            while(true) {
               if (!var5.hasNext()) {
                  if (this.bufferLists.position() > 0) {
                     this.drawRegion(var2, var3, this.bufferLists);
                  }
                  break;
               }

               RenderChunk var4 = (RenderChunk)var5.next();
               ListedRenderChunk var6 = (ListedRenderChunk)var4;
               if (var2 != var4.regionX || var3 != var4.regionZ) {
                  if (this.bufferLists.position() > 0) {
                     this.drawRegion(var2, var3, this.bufferLists);
                  }

                  var2 = var4.regionX;
                  var3 = var4.regionZ;
               }

               if (this.bufferLists.position() >= this.bufferLists.capacity()) {
                  IntBuffer var7 = GLAllocation.createDirectIntBuffer(this.bufferLists.capacity() * 2);
                  this.bufferLists.flip();
                  var7.put(this.bufferLists);
                  this.bufferLists = var7;
               }

               this.bufferLists.put(var6.getDisplayList(var1, var6.getCompiledChunk()));
            }
         }

         if (Config.isMultiTexture()) {
            GlStateManager.bindCurrentTexture();
         }

         GlStateManager.resetColor();
         this.renderChunks.clear();
      }

   }

   public void preRenderRegion(int var1, int var2, int var3) {
      GlStateManager.translate((float)((double)var1 - this.viewEntityX), (float)((double)var2 - this.viewEntityY), (float)((double)var3 - this.viewEntityZ));
   }

   private void drawRegion(int var1, int var2, IntBuffer var3) {
      GlStateManager.pushMatrix();
      this.preRenderRegion(var1, 0, var2);
      var3.flip();
      GlStateManager.callLists(var3);
      var3.clear();
      GlStateManager.popMatrix();
   }

   public void initialize(double var1, double var3, double var5) {
      this.viewEntityX = var1;
      this.viewEntityY = var3;
      this.viewEntityZ = var5;
      super.initialize(var1, var3, var5);
   }
}
