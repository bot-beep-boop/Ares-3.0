package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBoat;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderBoat;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.src.Config;
import net.optifine.reflect.Reflector;

public class ModelAdapterBoat extends ModelAdapter {
   public ModelBase makeModel() {
      return new ModelBoat();
   }

   public IEntityRenderer makeEntityRender(ModelBase var1, float var2) {
      RenderManager var3 = Minecraft.getMinecraft().getRenderManager();
      RenderBoat var4 = new RenderBoat(var3);
      if (!Reflector.RenderBoat_modelBoat.exists()) {
         Config.warn("Field not found: RenderBoat.modelBoat");
         return null;
      } else {
         Reflector.setFieldValue(var4, Reflector.RenderBoat_modelBoat, var1);
         var4.shadowSize = var2;
         return var4;
      }
   }

   public String[] getModelRendererNames() {
      return new String[]{"bottom", "back", "front", "right", "left"};
   }

   public ModelAdapterBoat() {
      super(EntityBoat.class, "boat", 0.5F);
   }

   public ModelRenderer getModelRenderer(ModelBase var1, String var2) {
      if (!(var1 instanceof ModelBoat)) {
         return null;
      } else {
         ModelBoat var3 = (ModelBoat)var1;
         if (var2.equals("bottom")) {
            return var3.boatSides[0];
         } else if (var2.equals("back")) {
            return var3.boatSides[1];
         } else if (var2.equals("front")) {
            return var3.boatSides[2];
         } else if (var2.equals("right")) {
            return var3.boatSides[3];
         } else {
            return var2.equals("left") ? var3.boatSides[4] : null;
         }
      }
   }
}
