package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBlaze;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderBlaze;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.src.Config;
import net.optifine.reflect.Reflector;

public class ModelAdapterBlaze extends ModelAdapter {
   public ModelBase makeModel() {
      return new ModelBlaze();
   }

   public String[] getModelRendererNames() {
      return new String[]{"head", "stick1", "stick2", "stick3", "stick4", "stick5", "stick6", "stick7", "stick8", "stick9", "stick10", "stick11", "stick12"};
   }

   public ModelRenderer getModelRenderer(ModelBase var1, String var2) {
      if (!(var1 instanceof ModelBlaze)) {
         return null;
      } else {
         ModelBlaze var3 = (ModelBlaze)var1;
         if (var2.equals("head")) {
            return (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelBlaze_blazeHead);
         } else {
            String var4 = "stick";
            if (var2.startsWith(var4)) {
               ModelRenderer[] var5 = (ModelRenderer[])Reflector.getFieldValue(var3, Reflector.ModelBlaze_blazeSticks);
               if (var5 == null) {
                  return null;
               } else {
                  String var6 = var2.substring(var4.length());
                  int var7 = Config.parseInt(var6, -1);
                  --var7;
                  return var7 >= 0 && var7 < var5.length ? var5[var7] : null;
               }
            } else {
               return null;
            }
         }
      }
   }

   public IEntityRenderer makeEntityRender(ModelBase var1, float var2) {
      RenderManager var3 = Minecraft.getMinecraft().getRenderManager();
      RenderBlaze var4 = new RenderBlaze(var3);
      var4.mainModel = var1;
      var4.shadowSize = var2;
      return var4;
   }

   public ModelAdapterBlaze() {
      super(EntityBlaze.class, "blaze", 0.5F);
   }
}
