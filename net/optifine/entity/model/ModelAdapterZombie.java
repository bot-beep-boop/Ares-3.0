package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.entity.monster.EntityZombie;

public class ModelAdapterZombie extends ModelAdapterBiped {
   public IEntityRenderer makeEntityRender(ModelBase var1, float var2) {
      RenderManager var3 = Minecraft.getMinecraft().getRenderManager();
      RenderZombie var4 = new RenderZombie(var3);
      Render.setModelBipedMain(var4, (ModelBiped)var1);
      var4.mainModel = var1;
      var4.shadowSize = var2;
      return var4;
   }

   public ModelAdapterZombie() {
      super(EntityZombie.class, "zombie", 0.5F);
   }

   public ModelBase makeModel() {
      return new ModelZombie();
   }
}
