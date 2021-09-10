package net.optifine;

import java.nio.ByteBuffer;
import java.util.Properties;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;
import net.optifine.util.TextureUtils;
import org.lwjgl.opengl.GL11;

public class TextureAnimation {
   private ByteBuffer interpolateData = null;
   private int frameHeight = 0;
   byte[] srcData = null;
   private boolean active = true;
   ResourceLocation dstTexLoc = null;
   private int dstTextId = -1;
   private int dstY = 0;
   private String srcTex = null;
   private ByteBuffer imageData = null;
   private String dstTex = null;
   private int currentFrameIndex = 0;
   private boolean valid = true;
   private int dstX = 0;
   private int interpolateSkip = 0;
   private int frameWidth = 0;
   private boolean interpolate = false;
   private TextureAnimationFrame[] frames = null;

   public int getFrameCount() {
      return this.frames.length;
   }

   public boolean nextFrame() {
      TextureAnimationFrame var1 = this.getCurrentFrame();
      if (var1 == null) {
         return false;
      } else {
         ++var1.counter;
         if (var1.counter < var1.duration) {
            return this.interpolate;
         } else {
            var1.counter = 0;
            ++this.currentFrameIndex;
            if (this.currentFrameIndex >= this.frames.length) {
               this.currentFrameIndex = 0;
            }

            return true;
         }
      }
   }

   public String getDstTex() {
      return this.dstTex;
   }

   public void updateTexture() {
      if (this.valid) {
         if (this.dstTextId < 0) {
            ITextureObject var1 = TextureUtils.getTexture(this.dstTexLoc);
            if (var1 == null) {
               this.valid = false;
               return;
            }

            this.dstTextId = var1.getGlTextureId();
         }

         if (this.imageData == null) {
            this.imageData = GLAllocation.createDirectByteBuffer(this.srcData.length);
            this.imageData.put(this.srcData);
            this.imageData.flip();
            this.srcData = null;
         }

         this.active = SmartAnimations.isActive() ? SmartAnimations.isTextureRendered(this.dstTextId) : true;
         if (this.nextFrame() && this.active) {
            int var7 = this.frameWidth * this.frameHeight * 4;
            TextureAnimationFrame var2 = this.getCurrentFrame();
            if (var2 != null) {
               int var3 = var7 * var2.index;
               if (var3 + var7 <= this.imageData.limit()) {
                  if (this.interpolate && var2.counter > 0) {
                     if (this.interpolateSkip <= 1 || var2.counter % this.interpolateSkip == 0) {
                        TextureAnimationFrame var4 = this.getFrame(this.currentFrameIndex + 1);
                        double var5 = 1.0D * (double)var2.counter / (double)var2.duration;
                        this.updateTextureInerpolate(var2, var4, var5);
                     }
                  } else {
                     this.imageData.position(var3);
                     GlStateManager.bindTexture(this.dstTextId);
                     GL11.glTexSubImage2D(3553, 0, this.dstX, this.dstY, this.frameWidth, this.frameHeight, 6408, 5121, this.imageData);
                  }
               }
            }
         }
      }

   }

   private int mix(int var1, int var2, double var3) {
      return (int)((double)var1 * (1.0D - var3) + (double)var2 * var3);
   }

   public TextureAnimation(String var1, byte[] var2, String var3, ResourceLocation var4, int var5, int var6, int var7, int var8, Properties var9) {
      this.srcTex = var1;
      this.dstTex = var3;
      this.dstTexLoc = var4;
      this.dstX = var5;
      this.dstY = var6;
      this.frameWidth = var7;
      this.frameHeight = var8;
      int var10 = var7 * var8 * 4;
      if (var2.length % var10 != 0) {
         Config.warn("Invalid animated texture length: " + var2.length + ", frameWidth: " + var7 + ", frameHeight: " + var8);
      }

      this.srcData = var2;
      int var11 = var2.length / var10;
      if (var9.get("tile.0") != null) {
         for(int var12 = 0; var9.get("tile." + var12) != null; ++var12) {
            var11 = var12 + 1;
         }
      }

      String var20 = (String)var9.get("duration");
      int var13 = Math.max(Config.parseInt(var20, 1), 1);
      this.frames = new TextureAnimationFrame[var11];

      for(int var14 = 0; var14 < this.frames.length; ++var14) {
         String var15 = (String)var9.get("tile." + var14);
         int var16 = Config.parseInt(var15, var14);
         String var17 = (String)var9.get("duration." + var14);
         int var18 = Math.max(Config.parseInt(var17, var13), 1);
         TextureAnimationFrame var19 = new TextureAnimationFrame(var16, var18);
         this.frames[var14] = var19;
      }

      this.interpolate = Config.parseBoolean(var9.getProperty("interpolate"), false);
      this.interpolateSkip = Config.parseInt(var9.getProperty("skip"), 0);
      if (this.interpolate) {
         this.interpolateData = GLAllocation.createDirectByteBuffer(var10);
      }

   }

   public ResourceLocation getDstTexLoc() {
      return this.dstTexLoc;
   }

   public TextureAnimationFrame getFrame(int var1) {
      if (this.frames.length <= 0) {
         return null;
      } else {
         if (var1 < 0 || var1 >= this.frames.length) {
            var1 = 0;
         }

         TextureAnimationFrame var2 = this.frames[var1];
         return var2;
      }
   }

   public boolean isActive() {
      return this.active;
   }

   private void updateTextureInerpolate(TextureAnimationFrame var1, TextureAnimationFrame var2, double var3) {
      int var5 = this.frameWidth * this.frameHeight * 4;
      int var6 = var5 * var1.index;
      if (var6 + var5 <= this.imageData.limit()) {
         int var7 = var5 * var2.index;
         if (var7 + var5 <= this.imageData.limit()) {
            this.interpolateData.clear();

            for(int var8 = 0; var8 < var5; ++var8) {
               int var9 = this.imageData.get(var6 + var8) & 255;
               int var10 = this.imageData.get(var7 + var8) & 255;
               int var11 = this.mix(var9, var10, var3);
               byte var12 = (byte)var11;
               this.interpolateData.put(var12);
            }

            this.interpolateData.flip();
            GlStateManager.bindTexture(this.dstTextId);
            GL11.glTexSubImage2D(3553, 0, this.dstX, this.dstY, this.frameWidth, this.frameHeight, 6408, 5121, this.interpolateData);
         }
      }
   }

   public TextureAnimationFrame getCurrentFrame() {
      return this.getFrame(this.currentFrameIndex);
   }

   public String getSrcTex() {
      return this.srcTex;
   }
}
