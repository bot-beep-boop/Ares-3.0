package net.optifine.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelQuadruped;
import net.minecraft.client.model.ModelRenderer;

public abstract class ModelAdapterQuadruped extends ModelAdapter {
   public ModelAdapterQuadruped(Class var1, String var2, float var3) {
      super(var1, var2, var3);
   }

   public String[] getModelRendererNames() {
      return new String[]{"head", "body", "leg1", "leg2", "leg3", "leg4"};
   }

   public ModelRenderer getModelRenderer(ModelBase var1, String var2) {
      if (!(var1 instanceof ModelQuadruped)) {
         return null;
      } else {
         ModelQuadruped var3 = (ModelQuadruped)var1;
         if (var2.equals("head")) {
            return var3.head;
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
}
