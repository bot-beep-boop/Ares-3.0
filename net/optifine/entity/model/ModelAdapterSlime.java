package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSlime;
import net.minecraft.entity.monster.EntitySlime;
import net.optifine.reflect.Reflector;

public class ModelAdapterSlime extends ModelAdapter {
   public String[] getModelRendererNames() {
      return new String[]{"body", "left_eye", "right_eye", "mouth"};
   }

   public ModelBase makeModel() {
      return new ModelSlime(16);
   }

   public ModelAdapterSlime() {
      super(EntitySlime.class, "slime", 0.25F);
   }

   public IEntityRenderer makeEntityRender(ModelBase var1, float var2) {
      RenderManager var3 = Minecraft.getMinecraft().getRenderManager();
      RenderSlime var4 = new RenderSlime(var3, var1, var2);
      return var4;
   }

   public ModelRenderer getModelRenderer(ModelBase var1, String var2) {
      if (!(var1 instanceof ModelSlime)) {
         return null;
      } else {
         ModelSlime var3 = (ModelSlime)var1;
         if (var2.equals("body")) {
            return (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelSlime_ModelRenderers, 0);
         } else if (var2.equals("left_eye")) {
            return (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelSlime_ModelRenderers, 1);
         } else if (var2.equals("right_eye")) {
            return (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelSlime_ModelRenderers, 2);
         } else {
            return var2.equals("mouth") ? (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelSlime_ModelRenderers, 3) : null;
         }
      }
   }
}
