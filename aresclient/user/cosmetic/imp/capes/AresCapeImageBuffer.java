package com.aresclient.user.cosmetic.imp.capes;

import java.awt.image.BufferedImage;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraft.util.ResourceLocation;

public class AresCapeImageBuffer extends ImageBufferDownload {
   private ResourceLocation resourceLocation;
   private boolean elytraOfCape;
   private AbstractClientPlayer player;

   public AresCapeImageBuffer(AbstractClientPlayer var1, ResourceLocation var2) {
      this.player = var1;
      this.resourceLocation = var2;
   }

   public void cleanup() {
      this.player = null;
   }

   public boolean isElytraOfCape() {
      return this.elytraOfCape;
   }

   public BufferedImage parseUserSkin(BufferedImage var1) {
      return var1;
   }

   public void skinAvailable() {
      if (this.player != null) {
         this.player.setLocationOfAresCape(this.resourceLocation);
         this.player.setElytraOfCape(this.elytraOfCape);
      }

      this.cleanup();
   }
}
