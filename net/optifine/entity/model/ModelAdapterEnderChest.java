package net.optifine.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityEnderChestRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.optifine.reflect.Reflector;

public class ModelAdapterEnderChest extends ModelAdapter {
   public IEntityRenderer makeEntityRender(ModelBase var1, float var2) {
      TileEntityRendererDispatcher var3 = TileEntityRendererDispatcher.instance;
      Object var4 = var3.getSpecialRendererByClass(TileEntityEnderChest.class);
      if (!(var4 instanceof TileEntityEnderChestRenderer)) {
         return null;
      } else {
         if (((TileEntitySpecialRenderer)var4).getEntityClass() == null) {
            var4 = new TileEntityEnderChestRenderer();
            ((TileEntitySpecialRenderer)var4).setRendererDispatcher(var3);
         }

         if (!Reflector.TileEntityEnderChestRenderer_modelChest.exists()) {
            Config.warn("Field not found: TileEntityEnderChestRenderer.modelChest");
            return null;
         } else {
            Reflector.setFieldValue(var4, Reflector.TileEntityEnderChestRenderer_modelChest, var1);
            return (IEntityRenderer)var4;
         }
      }
   }

   public String[] getModelRendererNames() {
      return new String[]{"lid", "base", "knob"};
   }

   public ModelBase makeModel() {
      return new ModelChest();
   }

   public ModelRenderer getModelRenderer(ModelBase var1, String var2) {
      if (!(var1 instanceof ModelChest)) {
         return null;
      } else {
         ModelChest var3 = (ModelChest)var1;
         if (var2.equals("lid")) {
            return var3.chestLid;
         } else if (var2.equals("base")) {
            return var3.chestBelow;
         } else {
            return var2.equals("knob") ? var3.chestKnob : null;
         }
      }
   }

   public ModelAdapterEnderChest() {
      super(TileEntityEnderChest.class, "ender_chest", 0.0F);
   }
}
