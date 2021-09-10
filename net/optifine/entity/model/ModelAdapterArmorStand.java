package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelArmorStand;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.ArmorStandRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.src.Config;

public class ModelAdapterArmorStand extends ModelAdapterBiped {
   public ModelRenderer getModelRenderer(ModelBase var1, String var2) {
      if (!(var1 instanceof ModelArmorStand)) {
         return null;
      } else {
         ModelArmorStand var3 = (ModelArmorStand)var1;
         if (var2.equals("right")) {
            return var3.standRightSide;
         } else if (var2.equals("left")) {
            return var3.standLeftSide;
         } else if (var2.equals("waist")) {
            return var3.standWaist;
         } else {
            return var2.equals("base") ? var3.standBase : super.getModelRenderer(var3, var2);
         }
      }
   }

   public ModelAdapterArmorStand() {
      super(EntityArmorStand.class, "armor_stand", 0.0F);
   }

   public IEntityRenderer makeEntityRender(ModelBase var1, float var2) {
      RenderManager var3 = Minecraft.getMinecraft().getRenderManager();
      ArmorStandRenderer var4 = new ArmorStandRenderer(var3);
      var4.mainModel = var1;
      var4.shadowSize = var2;
      return var4;
   }

   public ModelBase makeModel() {
      return new ModelArmorStand();
   }

   public String[] getModelRendererNames() {
      String[] var1 = super.getModelRendererNames();
      var1 = (String[])Config.addObjectsToArray(var1, new String[]{"right", "left", "waist", "base"});
      return var1;
   }
}
