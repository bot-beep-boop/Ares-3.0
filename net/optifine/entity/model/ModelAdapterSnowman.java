package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelSnowMan;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowMan;
import net.minecraft.entity.monster.EntitySnowman;

public class ModelAdapterSnowman extends ModelAdapter {
   public String[] getModelRendererNames() {
      return new String[]{"body", "body_bottom", "head", "right_hand", "left_hand"};
   }

   public ModelAdapterSnowman() {
      super(EntitySnowman.class, "snow_golem", 0.5F);
   }

   public IEntityRenderer makeEntityRender(ModelBase var1, float var2) {
      RenderManager var3 = Minecraft.getMinecraft().getRenderManager();
      RenderSnowMan var4 = new RenderSnowMan(var3);
      var4.mainModel = var1;
      var4.shadowSize = var2;
      return var4;
   }

   public ModelRenderer getModelRenderer(ModelBase var1, String var2) {
      if (!(var1 instanceof ModelSnowMan)) {
         return null;
      } else {
         ModelSnowMan var3 = (ModelSnowMan)var1;
         if (var2.equals("body")) {
            return var3.body;
         } else if (var2.equals("body_bottom")) {
            return var3.bottomBody;
         } else if (var2.equals("head")) {
            return var3.head;
         } else if (var2.equals("left_hand")) {
            return var3.leftHand;
         } else {
            return var2.equals("right_hand") ? var3.rightHand : null;
         }
      }
   }

   public ModelBase makeModel() {
      return new ModelSnowMan();
   }
}
