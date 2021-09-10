package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelSkeleton;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.entity.monster.EntitySkeleton;

public class ModelAdapterSkeleton extends ModelAdapterBiped {
   public ModelAdapterSkeleton() {
      super(EntitySkeleton.class, "skeleton", 0.7F);
   }

   public ModelBase makeModel() {
      return new ModelSkeleton();
   }

   public IEntityRenderer makeEntityRender(ModelBase var1, float var2) {
      RenderManager var3 = Minecraft.getMinecraft().getRenderManager();
      RenderSkeleton var4 = new RenderSkeleton(var3);
      Render.setModelBipedMain(var4, (ModelBiped)var1);
      var4.mainModel = var1;
      var4.shadowSize = var2;
      return var4;
   }
}
