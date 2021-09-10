package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSheep2;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSheep;
import net.minecraft.entity.passive.EntitySheep;

public class ModelAdapterSheep extends ModelAdapterQuadruped {
   public IEntityRenderer makeEntityRender(ModelBase var1, float var2) {
      RenderManager var3 = Minecraft.getMinecraft().getRenderManager();
      return new RenderSheep(var3, var1, var2);
   }

   public ModelBase makeModel() {
      return new ModelSheep2();
   }

   public ModelAdapterSheep() {
      super(EntitySheep.class, "sheep", 0.7F);
   }
}
