package net.optifine.entity.model;

import net.minecraft.client.model.ModelBanner;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityBannerRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntityBanner;
import net.optifine.reflect.Reflector;

public class ModelAdapterBanner extends ModelAdapter {
   public ModelAdapterBanner() {
      super(TileEntityBanner.class, "banner", 0.0F);
   }

   public ModelRenderer getModelRenderer(ModelBase var1, String var2) {
      if (!(var1 instanceof ModelBanner)) {
         return null;
      } else {
         ModelBanner var3 = (ModelBanner)var1;
         if (var2.equals("slate")) {
            return var3.bannerSlate;
         } else if (var2.equals("stand")) {
            return var3.bannerStand;
         } else {
            return var2.equals("top") ? var3.bannerTop : null;
         }
      }
   }

   public ModelBase makeModel() {
      return new ModelBanner();
   }

   public String[] getModelRendererNames() {
      return new String[]{"slate", "stand", "top"};
   }

   public IEntityRenderer makeEntityRender(ModelBase var1, float var2) {
      TileEntityRendererDispatcher var3 = TileEntityRendererDispatcher.instance;
      Object var4 = var3.getSpecialRendererByClass(TileEntityBanner.class);
      if (!(var4 instanceof TileEntityBannerRenderer)) {
         return null;
      } else {
         if (((TileEntitySpecialRenderer)var4).getEntityClass() == null) {
            var4 = new TileEntityBannerRenderer();
            ((TileEntitySpecialRenderer)var4).setRendererDispatcher(var3);
         }

         if (!Reflector.TileEntityBannerRenderer_bannerModel.exists()) {
            Config.warn("Field not found: TileEntityBannerRenderer.bannerModel");
            return null;
         } else {
            Reflector.setFieldValue(var4, Reflector.TileEntityBannerRenderer_bannerModel, var1);
            return (IEntityRenderer)var4;
         }
      }
   }
}
