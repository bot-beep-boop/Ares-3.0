package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderCreeper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityCreeper;

public class ModelAdapterCreeper extends ModelAdapter {
   public ModelBase makeModel() {
      return new ModelCreeper();
   }

   public String[] getModelRendererNames() {
      return new String[]{"head", "armor", "body", "leg1", "leg2", "leg3", "leg4"};
   }

   public ModelRenderer getModelRenderer(ModelBase var1, String var2) {
      if (!(var1 instanceof ModelCreeper)) {
         return null;
      } else {
         ModelCreeper var3 = (ModelCreeper)var1;
         if (var2.equals("head")) {
            return var3.head;
         } else if (var2.equals("armor")) {
            return var3.creeperArmor;
         } else if (var2.equals("body")) {
            return var3.body;
         } else if (var2.equals("leg1")) {
            return var3.leg1;
         } else if (var2.equals("leg2")) {
            return var3.leg2;
         } else if (var2.equals("leg3")) {
            return var3.leg3;
         } else {
            return var2.equals("leg4") ? var3.leg4 : null;
         }
      }
   }

   public ModelAdapterCreeper() {
      super(EntityCreeper.class, "creeper", 0.5F);
   }

   public IEntityRenderer makeEntityRender(ModelBase var1, float var2) {
      RenderManager var3 = Minecraft.getMinecraft().getRenderManager();
      RenderCreeper var4 = new RenderCreeper(var3);
      var4.mainModel = var1;
      var4.shadowSize = var2;
      return var4;
   }
}
