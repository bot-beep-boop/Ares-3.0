package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelEnderman;
import net.minecraft.client.renderer.entity.RenderEnderman;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityEnderman;

public class ModelAdapterEnderman extends ModelAdapterBiped {
   public ModelBase makeModel() {
      return new ModelEnderman(0.0F);
   }

   public IEntityRenderer makeEntityRender(ModelBase var1, float var2) {
      RenderManager var3 = Minecraft.getMinecraft().getRenderManager();
      RenderEnderman var4 = new RenderEnderman(var3);
      var4.mainModel = var1;
      var4.shadowSize = var2;
      return var4;
   }

   public ModelAdapterEnderman() {
      super(EntityEnderman.class, "enderman", 0.5F);
   }
}
