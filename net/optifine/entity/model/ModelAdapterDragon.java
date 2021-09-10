package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelDragon;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderDragon;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.boss.EntityDragon;
import net.optifine.reflect.Reflector;

public class ModelAdapterDragon extends ModelAdapter {
   public ModelRenderer getModelRenderer(ModelBase var1, String var2) {
      if (!(var1 instanceof ModelDragon)) {
         return null;
      } else {
         ModelDragon var3 = (ModelDragon)var1;
         if (var2.equals("head")) {
            return (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelDragon_ModelRenderers, 0);
         } else if (var2.equals("spine")) {
            return (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelDragon_ModelRenderers, 1);
         } else if (var2.equals("jaw")) {
            return (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelDragon_ModelRenderers, 2);
         } else if (var2.equals("body")) {
            return (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelDragon_ModelRenderers, 3);
         } else if (var2.equals("rear_leg")) {
            return (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelDragon_ModelRenderers, 4);
         } else if (var2.equals("front_leg")) {
            return (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelDragon_ModelRenderers, 5);
         } else if (var2.equals("rear_leg_tip")) {
            return (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelDragon_ModelRenderers, 6);
         } else if (var2.equals("front_leg_tip")) {
            return (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelDragon_ModelRenderers, 7);
         } else if (var2.equals("rear_foot")) {
            return (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelDragon_ModelRenderers, 8);
         } else if (var2.equals("front_foot")) {
            return (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelDragon_ModelRenderers, 9);
         } else if (var2.equals("wing")) {
            return (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelDragon_ModelRenderers, 10);
         } else {
            return var2.equals("wing_tip") ? (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelDragon_ModelRenderers, 11) : null;
         }
      }
   }

   public ModelBase makeModel() {
      return new ModelDragon(0.0F);
   }

   public String[] getModelRendererNames() {
      return new String[]{"head", "spine", "jaw", "body", "rear_leg", "front_leg", "rear_leg_tip", "front_leg_tip", "rear_foot", "front_foot", "wing", "wing_tip"};
   }

   public ModelAdapterDragon() {
      super(EntityDragon.class, "dragon", 0.5F);
   }

   public IEntityRenderer makeEntityRender(ModelBase var1, float var2) {
      RenderManager var3 = Minecraft.getMinecraft().getRenderManager();
      RenderDragon var4 = new RenderDragon(var3);
      var4.mainModel = var1;
      var4.shadowSize = var2;
      return var4;
   }
}
