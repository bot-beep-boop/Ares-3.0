package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraft.entity.monster.EntitySpider;

public class ModelAdapterSpider extends ModelAdapter {
   public ModelBase makeModel() {
      return new ModelSpider();
   }

   public String[] getModelRendererNames() {
      return new String[]{"head", "neck", "body", "leg1", "leg2", "leg3", "leg4", "leg5", "leg6", "leg7", "leg8"};
   }

   public ModelAdapterSpider() {
      super(EntitySpider.class, "spider", 1.0F);
   }

   protected ModelAdapterSpider(Class var1, String var2, float var3) {
      super(var1, var2, var3);
   }

   public ModelRenderer getModelRenderer(ModelBase var1, String var2) {
      if (!(var1 instanceof ModelSpider)) {
         return null;
      } else {
         ModelSpider var3 = (ModelSpider)var1;
         if (var2.equals("head")) {
            return var3.spiderHead;
         } else if (var2.equals("neck")) {
            return var3.spiderNeck;
         } else if (var2.equals("body")) {
            return var3.spiderBody;
         } else if (var2.equals("leg1")) {
            return var3.spiderLeg1;
         } else if (var2.equals("leg2")) {
            return var3.spiderLeg2;
         } else if (var2.equals("leg3")) {
            return var3.spiderLeg3;
         } else if (var2.equals("leg4")) {
            return var3.spiderLeg4;
         } else if (var2.equals("leg5")) {
            return var3.spiderLeg5;
         } else if (var2.equals("leg6")) {
            return var3.spiderLeg6;
         } else if (var2.equals("leg7")) {
            return var3.spiderLeg7;
         } else {
            return var2.equals("leg8") ? var3.spiderLeg8 : null;
         }
      }
   }

   public IEntityRenderer makeEntityRender(ModelBase var1, float var2) {
      RenderManager var3 = Minecraft.getMinecraft().getRenderManager();
      RenderSpider var4 = new RenderSpider(var3);
      var4.mainModel = var1;
      var4.shadowSize = var2;
      return var4;
   }
}
