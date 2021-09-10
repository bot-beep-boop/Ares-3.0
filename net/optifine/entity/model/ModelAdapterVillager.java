package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelVillager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderVillager;
import net.minecraft.entity.passive.EntityVillager;

public class ModelAdapterVillager extends ModelAdapter {
   public ModelAdapterVillager() {
      super(EntityVillager.class, "villager", 0.5F);
   }

   public ModelRenderer getModelRenderer(ModelBase var1, String var2) {
      if (!(var1 instanceof ModelVillager)) {
         return null;
      } else {
         ModelVillager var3 = (ModelVillager)var1;
         if (var2.equals("head")) {
            return var3.villagerHead;
         } else if (var2.equals("body")) {
            return var3.villagerBody;
         } else if (var2.equals("arms")) {
            return var3.villagerArms;
         } else if (var2.equals("left_leg")) {
            return var3.leftVillagerLeg;
         } else if (var2.equals("right_leg")) {
            return var3.rightVillagerLeg;
         } else {
            return var2.equals("nose") ? var3.villagerNose : null;
         }
      }
   }

   public ModelBase makeModel() {
      return new ModelVillager(0.0F);
   }

   public String[] getModelRendererNames() {
      return new String[]{"head", "body", "arms", "right_leg", "left_leg", "nose"};
   }

   public IEntityRenderer makeEntityRender(ModelBase var1, float var2) {
      RenderManager var3 = Minecraft.getMinecraft().getRenderManager();
      RenderVillager var4 = new RenderVillager(var3);
      var4.mainModel = var1;
      var4.shadowSize = var2;
      return var4;
   }
}
