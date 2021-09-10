package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBat;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderBat;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityBat;
import net.optifine.reflect.Reflector;

public class ModelAdapterBat extends ModelAdapter {
   public ModelAdapterBat() {
      super(EntityBat.class, "bat", 0.25F);
   }

   public ModelBase makeModel() {
      return new ModelBat();
   }

   public ModelRenderer getModelRenderer(ModelBase var1, String var2) {
      if (!(var1 instanceof ModelBat)) {
         return null;
      } else {
         ModelBat var3 = (ModelBat)var1;
         if (var2.equals("head")) {
            return (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelBat_ModelRenderers, 0);
         } else if (var2.equals("body")) {
            return (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelBat_ModelRenderers, 1);
         } else if (var2.equals("right_wing")) {
            return (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelBat_ModelRenderers, 2);
         } else if (var2.equals("left_wing")) {
            return (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelBat_ModelRenderers, 3);
         } else if (var2.equals("outer_right_wing")) {
            return (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelBat_ModelRenderers, 4);
         } else {
            return var2.equals("outer_left_wing") ? (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelBat_ModelRenderers, 5) : null;
         }
      }
   }

   public String[] getModelRendererNames() {
      return new String[]{"head", "body", "right_wing", "left_wing", "outer_right_wing", "outer_left_wing"};
   }

   public IEntityRenderer makeEntityRender(ModelBase var1, float var2) {
      RenderManager var3 = Minecraft.getMinecraft().getRenderManager();
      RenderBat var4 = new RenderBat(var3);
      var4.mainModel = var1;
      var4.shadowSize = var2;
      return var4;
   }
}
