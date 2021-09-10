package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.util.ResourceLocation;

public class RenderGiantZombie extends RenderLiving<EntityGiantZombie> {
   private float scale;
   private static final ResourceLocation zombieTextures = new ResourceLocation("textures/entity/zombie/zombie.png");

   protected void preRenderCallback(EntityGiantZombie var1, float var2) {
      GlStateManager.scale(this.scale, this.scale, this.scale);
   }

   protected ResourceLocation getEntityTexture(Entity var1) {
      return this.getEntityTexture((EntityGiantZombie)var1);
   }

   public RenderGiantZombie(RenderManager var1, ModelBase var2, float var3, float var4) {
      super(var1, var2, var3 * var4);
      this.scale = var4;
      this.addLayer(new LayerHeldItem(this));
      this.addLayer(new LayerBipedArmor(this, this) {
         final RenderGiantZombie this$0;

         {
            this.this$0 = var1;
         }

         protected void initArmor() {
            this.modelLeggings = new ModelZombie(0.5F, true);
            this.modelArmor = new ModelZombie(1.0F, true);
         }
      });
   }

   public void transformHeldFull3DItemLayer() {
      GlStateManager.translate(0.0F, 0.1875F, 0.0F);
   }

   protected void preRenderCallback(EntityLivingBase var1, float var2) {
      this.preRenderCallback((EntityGiantZombie)var1, var2);
   }

   protected ResourceLocation getEntityTexture(EntityGiantZombie var1) {
      return zombieTextures;
   }
}
