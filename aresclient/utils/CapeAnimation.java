package com.aresclient.utils;

import net.minecraft.util.ResourceLocation;

public class CapeAnimation {
   private final int framesPerSecond;
   private long nextUpdate;
   private int currentFrame = 1;
   private final ResourceLocation[] textures;

   public static ResourceLocation location(String var0) {
      return new ResourceLocation("", var0);
   }

   public void newUpdateTimeStamp() {
      this.nextUpdate = System.currentTimeMillis() + (long)(this.framesPerSecond * 50);
   }

   public void update() {
      if (System.currentTimeMillis() > this.nextUpdate) {
         this.newUpdateTimeStamp();
         ++this.currentFrame;
         if (this.currentFrame > this.textures.length - 1) {
            this.currentFrame = 1;
         }
      }

   }

   public ResourceLocation getTexture() {
      return this.textures[this.currentFrame];
   }

   public CapeAnimation(String var1, int var2, int var3) {
      this.framesPerSecond = var3;
      this.newUpdateTimeStamp();
      this.textures = new ResourceLocation[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         this.textures[var4] = location(var1 + var4 + ").png");
      }

   }
}
