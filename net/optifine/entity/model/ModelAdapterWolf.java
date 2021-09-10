package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelWolf;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderWolf;
import net.minecraft.entity.passive.EntityWolf;
import net.optifine.reflect.Reflector;

public class ModelAdapterWolf extends ModelAdapter {
   public String[] getModelRendererNames() {
      return new String[]{"head", "body", "leg1", "leg2", "leg3", "leg4", "tail", "mane"};
   }

   public IEntityRenderer makeEntityRender(ModelBase var1, float var2) {
      RenderManager var3 = Minecraft.getMinecraft().getRenderManager();
      RenderWolf var4 = new RenderWolf(var3, var1, var2);
      return var4;
   }

   public ModelBase makeModel() {
      return new ModelWolf();
   }

   public ModelAdapterWolf() {
      super(EntityWolf.class, "wolf", 0.5F);
   }

   public ModelRenderer getModelRenderer(ModelBase var1, String var2) {
      if (!(var1 instanceof ModelWolf)) {
         return null;
      } else {
         ModelWolf var3 = (ModelWolf)var1;
         if (var2.equals("head")) {
            return var3.wolfHeadMain;
         } else if (var2.equals("body")) {
            return var3.wolfBody;
         } else if (var2.equals("leg1")) {
            return var3.wolfLeg1;
         } else if (var2.equals("leg2")) {
            return var3.wolfLeg2;
         } else if (var2.equals("leg3")) {
            return var3.wolfLeg3;
         } else if (var2.equals("leg4")) {
            return var3.wolfLeg4;
         } else if (var2.equals("tail")) {
            return (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelWolf_tail);
         } else {
            return var2.equals("mane") ? (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelWolf_mane) : null;
         }
      }
   }
}
