package net.optifine.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;

public abstract class ModelAdapterBiped extends ModelAdapter {
   public ModelRenderer getModelRenderer(ModelBase var1, String var2) {
      if (!(var1 instanceof ModelBiped)) {
         return null;
      } else {
         ModelBiped var3 = (ModelBiped)var1;
         if (var2.equals("head")) {
            return var3.bipedHead;
         } else if (var2.equals("headwear")) {
            return var3.bipedHeadwear;
         } else if (var2.equals("body")) {
            return var3.bipedBody;
         } else if (var2.equals("left_arm")) {
            return var3.bipedLeftArm;
         } else if (var2.equals("right_arm")) {
            return var3.bipedRightArm;
         } else if (var2.equals("left_leg")) {
            return var3.bipedLeftLeg;
         } else {
            return var2.equals("right_leg") ? var3.bipedRightLeg : null;
         }
      }
   }

   public String[] getModelRendererNames() {
      return new String[]{"head", "headwear", "body", "left_arm", "right_arm", "left_leg", "right_leg"};
   }

   public ModelAdapterBiped(Class var1, String var2, float var3) {
      super(var1, var2, var3);
   }
}
