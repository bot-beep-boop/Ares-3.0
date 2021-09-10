package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.entity.RenderCow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityCow;

public class ModelAdapterCow extends ModelAdapterQuadruped {
   public ModelBase makeModel() {
      return new ModelCow();
   }

   public ModelAdapterCow() {
      super(EntityCow.class, "cow", 0.7F);
   }

   public IEntityRenderer makeEntityRender(ModelBase var1, float var2) {
      RenderManager var3 = Minecraft.getMinecraft().getRenderManager();
      return new RenderCow(var3, var1, var2);
   }
}
