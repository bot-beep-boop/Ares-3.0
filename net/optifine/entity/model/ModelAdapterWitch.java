package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelWitch;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderWitch;
import net.minecraft.entity.monster.EntityWitch;
import net.optifine.reflect.Reflector;

public class ModelAdapterWitch extends ModelAdapter {
   public ModelBase makeModel() {
      return new ModelWitch(0.0F);
   }

   public String[] getModelRendererNames() {
      return new String[]{"mole", "head", "body", "arms", "right_leg", "left_leg", "nose"};
   }

   public IEntityRenderer makeEntityRender(ModelBase var1, float var2) {
      RenderManager var3 = Minecraft.getMinecraft().getRenderManager();
      RenderWitch var4 = new RenderWitch(var3);
      var4.mainModel = var1;
      var4.shadowSize = var2;
      return var4;
   }

   public ModelRenderer getModelRenderer(ModelBase var1, String var2) {
      if (!(var1 instanceof ModelWitch)) {
         return null;
      } else {
         ModelWitch var3 = (ModelWitch)var1;
         if (var2.equals("mole")) {
            return (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelWitch_mole);
         } else if (var2.equals("hat")) {
            return (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelWitch_hat);
         } else if (var2.equals("head")) {
            return var3.villagerHead;
         } else if (var2.equals("body")) {
            return var3.villagerBody;
         } else if (var2.equals("arms")) {
            return var3.villagerArms;
         } else if (var2.equals("left_leg")) {
            return var3.leftVillagerLeg;
         } else if (var2.equals("right_leg")) {
            return var3.rightVillagerLeg;
         } else {
            return var2.equals("nose") ? var3.villagerNose : null;
         }
      }
   }

   public ModelAdapterWitch() {
      super(EntityWitch.class, "witch", 0.5F);
   }
}
