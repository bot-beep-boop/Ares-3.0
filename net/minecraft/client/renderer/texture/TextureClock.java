package net.minecraft.client.renderer.texture;

import net.minecraft.client.Minecraft;
import net.minecraft.util.MathHelper;

public class TextureClock extends TextureAtlasSprite {
   private double angleDelta;
   private double currentAngle;

   public TextureClock(String var1) {
      super(var1);
   }

   public void updateAnimation() {
      if (!this.framesTextureData.isEmpty()) {
         Minecraft var1 = Minecraft.getMinecraft();
         double var2 = 0.0D;
         if (var1.theWorld != null && var1.thePlayer != null) {
            var2 = (double)var1.theWorld.getCelestialAngle(1.0F);
            if (!var1.theWorld.provider.isSurfaceWorld()) {
               var2 = Math.random();
            }
         }

         double var4;
         for(var4 = var2 - this.currentAngle; var4 < -0.5D; ++var4) {
         }

         while(var4 >= 0.5D) {
            --var4;
         }

         var4 = MathHelper.clamp_double(var4, -1.0D, 1.0D);
         this.angleDelta += var4 * 0.1D;
         this.angleDelta *= 0.8D;
         this.currentAngle += this.angleDelta;

         int var6;
         for(var6 = (int)((this.currentAngle + 1.0D) * (double)this.framesTextureData.size()) % this.framesTextureData.size(); var6 < 0; var6 = (var6 + this.framesTextureData.size()) % this.framesTextureData.size()) {
         }

         if (var6 != this.frameCounter) {
            this.frameCounter = var6;
            TextureUtil.uploadTextureMipmap((int[][])this.framesTextureData.get(this.frameCounter), this.width, this.height, this.originX, this.originY, false, false);
         }
      }

   }
}
