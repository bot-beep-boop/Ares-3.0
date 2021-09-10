package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelMinecart;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderMinecart;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.src.Config;
import net.optifine.reflect.Reflector;

public class ModelAdapterMinecart extends ModelAdapter {
   public IEntityRenderer makeEntityRender(ModelBase var1, float var2) {
      RenderManager var3 = Minecraft.getMinecraft().getRenderManager();
      RenderMinecart var4 = new RenderMinecart(var3);
      if (!Reflector.RenderMinecart_modelMinecart.exists()) {
         Config.warn("Field not found: RenderMinecart.modelMinecart");
         return null;
      } else {
         Reflector.setFieldValue(var4, Reflector.RenderMinecart_modelMinecart, var1);
         var4.shadowSize = var2;
         return var4;
      }
   }

   protected ModelAdapterMinecart(Class var1, String var2, float var3) {
      super(var1, var2, var3);
   }

   public ModelRenderer getModelRenderer(ModelBase var1, String var2) {
      if (!(var1 instanceof ModelMinecart)) {
         return null;
      } else {
         ModelMinecart var3 = (ModelMinecart)var1;
         if (var2.equals("bottom")) {
            return var3.sideModels[0];
         } else if (var2.equals("back")) {
            return var3.sideModels[1];
         } else if (var2.equals("front")) {
            return var3.sideModels[2];
         } else if (var2.equals("right")) {
            return var3.sideModels[3];
         } else if (var2.equals("left")) {
            return var3.sideModels[4];
         } else {
            return var2.equals("dirt") ? var3.sideModels[5] : null;
         }
      }
   }

   public ModelAdapterMinecart() {
      super(EntityMinecart.class, "minecart", 0.5F);
   }

   public ModelBase makeModel() {
      return new ModelMinecart();
   }

   public String[] getModelRendererNames() {
      return new String[]{"bottom", "back", "front", "right", "left", "dirt"};
   }
}
