package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelGuardian;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderGuardian;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.src.Config;
import net.optifine.reflect.Reflector;

public class ModelAdapterGuardian extends ModelAdapter {
   public ModelRenderer getModelRenderer(ModelBase var1, String var2) {
      if (!(var1 instanceof ModelGuardian)) {
         return null;
      } else {
         ModelGuardian var3 = (ModelGuardian)var1;
         if (var2.equals("body")) {
            return (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelGuardian_body);
         } else if (var2.equals("eye")) {
            return (ModelRenderer)Reflector.getFieldValue(var3, Reflector.ModelGuardian_eye);
         } else {
            String var4 = "spine";
            if (var2.startsWith(var4)) {
               ModelRenderer[] var9 = (ModelRenderer[])Reflector.getFieldValue(var3, Reflector.ModelGuardian_spines);
               if (var9 == null) {
                  return null;
               } else {
                  String var10 = var2.substring(var4.length());
                  int var11 = Config.parseInt(var10, -1);
                  --var11;
                  return var11 >= 0 && var11 < var9.length ? var9[var11] : null;
               }
            } else {
               String var5 = "tail";
               if (var2.startsWith(var5)) {
                  ModelRenderer[] var6 = (ModelRenderer[])Reflector.getFieldValue(var3, Reflector.ModelGuardian_tail);
                  if (var6 == null) {
                     return null;
                  } else {
                     String var7 = var2.substring(var5.length());
                     int var8 = Config.parseInt(var7, -1);
                     --var8;
                     return var8 >= 0 && var8 < var6.length ? var6[var8] : null;
                  }
               } else {
                  return null;
               }
            }
         }
      }
   }

   public IEntityRenderer makeEntityRender(ModelBase var1, float var2) {
      RenderManager var3 = Minecraft.getMinecraft().getRenderManager();
      RenderGuardian var4 = new RenderGuardian(var3);
      var4.mainModel = var1;
      var4.shadowSize = var2;
      return var4;
   }

   public ModelBase makeModel() {
      return new ModelGuardian();
   }

   public String[] getModelRendererNames() {
      return new String[]{"body", "eye", "spine1", "spine2", "spine3", "spine4", "spine5", "spine6", "spine7", "spine8", "spine9", "spine10", "spine11", "spine12", "tail1", "tail2", "tail3"};
   }

   public ModelAdapterGuardian() {
      super(EntityGuardian.class, "guardian", 0.5F);
   }
}
