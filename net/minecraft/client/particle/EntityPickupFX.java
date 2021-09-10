package net.minecraft.client.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.src.Config;
import net.minecraft.world.World;
import net.optifine.shaders.Program;
import net.optifine.shaders.Shaders;

public class EntityPickupFX extends EntityFX {
   private int age;
   private int maxAge;
   private RenderManager field_174842_aB = Minecraft.getMinecraft().getRenderManager();
   private float field_174841_aA;
   private Entity field_174843_ax;
   private Entity field_174840_a;

   public void renderParticle(WorldRenderer var1, Entity var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      Program var9 = null;
      if (Config.isShaders()) {
         var9 = Shaders.activeProgram;
         Shaders.nextEntity(this.field_174840_a);
      }

      float var10 = ((float)this.age + var3) / (float)this.maxAge;
      var10 *= var10;
      double var11 = this.field_174840_a.posX;
      double var13 = this.field_174840_a.posY;
      double var15 = this.field_174840_a.posZ;
      double var17 = this.field_174843_ax.lastTickPosX + (this.field_174843_ax.posX - this.field_174843_ax.lastTickPosX) * (double)var3;
      double var19 = this.field_174843_ax.lastTickPosY + (this.field_174843_ax.posY - this.field_174843_ax.lastTickPosY) * (double)var3 + (double)this.field_174841_aA;
      double var21 = this.field_174843_ax.lastTickPosZ + (this.field_174843_ax.posZ - this.field_174843_ax.lastTickPosZ) * (double)var3;
      double var23 = var11 + (var17 - var11) * (double)var10;
      double var25 = var13 + (var19 - var13) * (double)var10;
      double var27 = var15 + (var21 - var15) * (double)var10;
      int var29 = this.getBrightnessForRender(var3);
      int var30 = var29 % 65536;
      int var31 = var29 / 65536;
      OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)var30 / 1.0F, (float)var31 / 1.0F);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      var23 -= interpPosX;
      var25 -= interpPosY;
      var27 -= interpPosZ;
      this.field_174842_aB.renderEntityWithPosYaw(this.field_174840_a, (double)((float)var23), (double)((float)var25), (double)((float)var27), this.field_174840_a.rotationYaw, var3);
      if (Config.isShaders()) {
         Shaders.setEntityId((Entity)null);
         Shaders.useProgram(var9);
      }

   }

   public EntityPickupFX(World var1, Entity var2, Entity var3, float var4) {
      super(var1, var2.posX, var2.posY, var2.posZ, var2.motionX, var2.motionY, var2.motionZ);
      this.field_174840_a = var2;
      this.field_174843_ax = var3;
      this.maxAge = 3;
      this.field_174841_aA = var4;
   }

   public void onUpdate() {
      ++this.age;
      if (this.age == this.maxAge) {
         this.setDead();
      }

   }

   public int getFXLayer() {
      return 3;
   }
}
