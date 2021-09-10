package net.minecraft.client.renderer;

import java.util.Iterator;
import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.src.Config;
import net.minecraft.util.EnumWorldBlockLayer;
import net.optifine.render.VboRegion;
import net.optifine.shaders.ShadersRender;
import org.lwjgl.opengl.GL11;

public class VboRenderList extends ChunkRenderContainer {
   private double viewEntityZ;
   private double viewEntityY;
   private double viewEntityX;

   public void setupArrayPointers() {
      if (Config.isShaders()) {
         ShadersRender.setupArrayPointersVbo();
      } else {
         GL11.glVertexPointer(3, 5126, 28, 0L);
         GL11.glColorPointer(4, 5121, 28, 12L);
         GL11.glTexCoordPointer(2, 5126, 28, 16L);
         OpenGlHelper.setClientActiveTexture(OpenGlHelper.lightmapTexUnit);
         GL11.glTexCoordPointer(2, 5122, 28, 24L);
         OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
      }

   }

   public void renderChunkLayer(EnumWorldBlockLayer var1) {
      if (this.initialized) {
         if (!Config.isRenderRegions()) {
            Iterator var10 = this.renderChunks.iterator();

            while(var10.hasNext()) {
               RenderChunk var9 = (RenderChunk)var10.next();
               VertexBuffer var11 = var9.getVertexBufferByLayer(var1.ordinal());
               GlStateManager.pushMatrix();
               this.preRenderChunk(var9);
               var9.multModelviewMatrix();
               var11.bindBuffer();
               this.setupArrayPointers();
               var11.drawArrays(7);
               GlStateManager.popMatrix();
            }
         } else {
            int var2 = Integer.MIN_VALUE;
            int var3 = Integer.MIN_VALUE;
            VboRegion var4 = null;
            Iterator var6 = this.renderChunks.iterator();

            while(true) {
               if (!var6.hasNext()) {
                  if (var4 != null) {
                     this.drawRegion(var2, var3, var4);
                  }
                  break;
               }

               RenderChunk var5 = (RenderChunk)var6.next();
               VertexBuffer var7 = var5.getVertexBufferByLayer(var1.ordinal());
               VboRegion var8 = var7.getVboRegion();
               if (var8 != var4 || var2 != var5.regionX || var3 != var5.regionZ) {
                  if (var4 != null) {
                     this.drawRegion(var2, var3, var4);
                  }

                  var2 = var5.regionX;
                  var3 = var5.regionZ;
                  var4 = var8;
               }

               var7.drawArrays(7);
            }
         }

         OpenGlHelper.glBindBuffer(OpenGlHelper.GL_ARRAY_BUFFER, 0);
         GlStateManager.resetColor();
         this.renderChunks.clear();
      }

   }

   public void initialize(double var1, double var3, double var5) {
      this.viewEntityX = var1;
      this.viewEntityY = var3;
      this.viewEntityZ = var5;
      super.initialize(var1, var3, var5);
   }

   public void preRenderRegion(int var1, int var2, int var3) {
      GlStateManager.translate((float)((double)var1 - this.viewEntityX), (float)((double)var2 - this.viewEntityY), (float)((double)var3 - this.viewEntityZ));
   }

   private void drawRegion(int var1, int var2, VboRegion var3) {
      GlStateManager.pushMatrix();
      this.preRenderRegion(var1, 0, var2);
      var3.finishDraw(this);
      GlStateManager.popMatrix();
   }
}
