package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelEnderMite;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.util.ResourceLocation;

public class RenderEndermite extends RenderLiving<EntityEndermite> {
   private static final ResourceLocation ENDERMITE_TEXTURES = new ResourceLocation("textures/entity/endermite.png");

   protected float getDeathMaxRotation(EntityLivingBase var1) {
      return this.getDeathMaxRotation((EntityEndermite)var1);
   }

   protected float getDeathMaxRotation(EntityEndermite var1) {
      return 180.0F;
   }

   protected ResourceLocation getEntityTexture(Entity var1) {
      return this.getEntityTexture((EntityEndermite)var1);
   }

   protected ResourceLocation getEntityTexture(EntityEndermite var1) {
      return ENDERMITE_TEXTURES;
   }

   public RenderEndermite(RenderManager var1) {
      super(var1, new ModelEnderMite(), 0.3F);
   }
}
