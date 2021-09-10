package net.optifine.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

public class CloudRenderer {
   private Minecraft mc;
   private Vec3 cloudColor;
   private boolean updated = false;
   private boolean renderFancy = false;
   private Vec3 updateCloudColor = new Vec3(-1.0D, -1.0D, -1.0D);
   private int updateCloudTickCounter = 0;
   float partialTicks;
   private double updatePlayerY = 0.0D;
   int cloudTickCounter;
   private int glListClouds = -1;
   private double updatePlayerX = 0.0D;
   private double updatePlayerZ = 0.0D;
   private boolean updateRenderFancy = false;

   public void prepareToRender(boolean var1, int var2, float var3, Vec3 var4) {
      this.renderFancy = var1;
      this.cloudTickCounter = var2;
      this.partialTicks = var3;
      this.cloudColor = var4;
   }

   public void reset() {
      this.updated = false;
   }

   public void renderGlList() {
      Entity var1 = this.mc.getRenderViewEntity();
      double var2 = var1.prevPosX + (var1.posX - var1.prevPosX) * (double)this.partialTicks;
      double var4 = var1.prevPosY + (var1.posY - var1.prevPosY) * (double)this.partialTicks;
      double var6 = var1.prevPosZ + (var1.posZ - var1.prevPosZ) * (double)this.partialTicks;
      double var8 = (double)((float)(this.cloudTickCounter - this.updateCloudTickCounter) + this.partialTicks);
      float var10 = (float)(var2 - this.updatePlayerX + var8 * 0.03D);
      float var11 = (float)(var4 - this.updatePlayerY);
      float var12 = (float)(var6 - this.updatePlayerZ);
      GlStateManager.pushMatrix();
      if (this.renderFancy) {
         GlStateManager.translate(-var10 / 12.0F, -var11, -var12 / 12.0F);
      } else {
         GlStateManager.translate(-var10, -var11, -var12);
      }

      GlStateManager.callList(this.glListClouds);
      GlStateManager.popMatrix();
      GlStateManager.resetColor();
   }

   public void endUpdateGlList() {
      GL11.glEndList();
      this.updateRenderFancy = this.renderFancy;
      this.updateCloudTickCounter = this.cloudTickCounter;
      this.updateCloudColor = this.cloudColor;
      this.updatePlayerX = this.mc.getRenderViewEntity().prevPosX;
      this.updatePlayerY = this.mc.getRenderViewEntity().prevPosY;
      this.updatePlayerZ = this.mc.getRenderViewEntity().prevPosZ;
      this.updated = true;
      GlStateManager.resetColor();
   }

   public boolean shouldUpdateGlList() {
      if (!this.updated) {
         return true;
      } else if (this.renderFancy != this.updateRenderFancy) {
         return true;
      } else if (this.cloudTickCounter >= this.updateCloudTickCounter + 20) {
         return true;
      } else if (Math.abs(this.cloudColor.xCoord - this.updateCloudColor.xCoord) > 0.003D) {
         return true;
      } else if (Math.abs(this.cloudColor.yCoord - this.updateCloudColor.yCoord) > 0.003D) {
         return true;
      } else if (Math.abs(this.cloudColor.zCoord - this.updateCloudColor.zCoord) > 0.003D) {
         return true;
      } else {
         Entity var1 = this.mc.getRenderViewEntity();
         boolean var2 = this.updatePlayerY + (double)var1.getEyeHeight() < 128.0D + (double)(this.mc.gameSettings.ofCloudsHeight * 128.0F);
         boolean var3 = var1.prevPosY + (double)var1.getEyeHeight() < 128.0D + (double)(this.mc.gameSettings.ofCloudsHeight * 128.0F);
         return var3 ^ var2;
      }
   }

   public void startUpdateGlList() {
      GL11.glNewList(this.glListClouds, 4864);
   }

   public CloudRenderer(Minecraft var1) {
      this.mc = var1;
      this.glListClouds = GLAllocation.generateDisplayLists(1);
   }
}
