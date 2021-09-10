package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderCaveSpider;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityCaveSpider;

public class ModelAdapterCaveSpider extends ModelAdapterSpider {
   public IEntityRenderer makeEntityRender(ModelBase var1, float var2) {
      RenderManager var3 = Minecraft.getMinecraft().getRenderManager();
      RenderCaveSpider var4 = new RenderCaveSpider(var3);
      var4.mainModel = var1;
      var4.shadowSize = var2;
      return var4;
   }

   public ModelAdapterCaveSpider() {
      super(EntityCaveSpider.class, "cave_spider", 0.7F);
   }
}
