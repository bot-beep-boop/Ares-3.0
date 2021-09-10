package net.optifine.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBook;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityEnchantmentTableRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import net.optifine.reflect.Reflector;

public class ModelAdapterBook extends ModelAdapter {
   public ModelRenderer getModelRenderer(ModelBase var1, String var2) {
      if (!(var1 instanceof ModelBook)) {
         return null;
      } else {
         ModelBook var3 = (ModelBook)var1;
         if (var2.equals("cover_right")) {
            return var3.coverRight;
         } else if (var2.equals("cover_left")) {
            return var3.coverLeft;
         } else if (var2.equals("pages_right")) {
            return var3.pagesRight;
         } else if (var2.equals("pages_left")) {
            return var3.pagesLeft;
         } else if (var2.equals("flipping_page_right")) {
            return var3.flippingPageRight;
         } else if (var2.equals("flipping_page_left")) {
            return var3.flippingPageLeft;
         } else {
            return var2.equals("book_spine") ? var3.bookSpine : null;
         }
      }
   }

   public ModelAdapterBook() {
      super(TileEntityEnchantmentTable.class, "book", 0.0F);
   }

   public IEntityRenderer makeEntityRender(ModelBase var1, float var2) {
      TileEntityRendererDispatcher var3 = TileEntityRendererDispatcher.instance;
      Object var4 = var3.getSpecialRendererByClass(TileEntityEnchantmentTable.class);
      if (!(var4 instanceof TileEntityEnchantmentTableRenderer)) {
         return null;
      } else {
         if (((TileEntitySpecialRenderer)var4).getEntityClass() == null) {
            var4 = new TileEntityEnchantmentTableRenderer();
            ((TileEntitySpecialRenderer)var4).setRendererDispatcher(var3);
         }

         if (!Reflector.TileEntityEnchantmentTableRenderer_modelBook.exists()) {
            Config.warn("Field not found: TileEntityEnchantmentTableRenderer.modelBook");
            return null;
         } else {
            Reflector.setFieldValue(var4, Reflector.TileEntityEnchantmentTableRenderer_modelBook, var1);
            return (IEntityRenderer)var4;
         }
      }
   }

   public String[] getModelRendererNames() {
      return new String[]{"cover_right", "cover_left", "pages_right", "pages_left", "flipping_page_right", "flipping_page_left", "book_spine"};
   }

   public ModelBase makeModel() {
      return new ModelBook();
   }
}
