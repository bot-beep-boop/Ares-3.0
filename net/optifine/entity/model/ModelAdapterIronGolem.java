package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelIronGolem;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderIronGolem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityIronGolem;

public class ModelAdapterIronGolem extends ModelAdapter {
   public IEntityRenderer makeEntityRender(ModelBase var1, float var2) {
      RenderManager var3 = Minecraft.getMinecraft().getRenderManager();
      RenderIronGolem var4 = new RenderIronGolem(var3);
      var4.mainModel = var1;
      var4.shadowSize = var2;
      return var4;
   }

   public String[] getModelRendererNames() {
      return new String[]{"head", "body", "right_arm", "left_arm", "left_leg", "right_leg"};
   }

   public ModelAdapterIronGolem() {
      super(EntityIronGolem.class, "iron_golem", 0.5F);
   }

   public ModelRenderer getModelRenderer(ModelBase var1, String var2) {
      if (!(var1 instanceof ModelIronGolem)) {
         return null;
      } else {
         ModelIronGolem var3 = (ModelIronGolem)var1;
         if (var2.equals("head")) {
            return var3.ironGolemHead;
         } else if (var2.equals("body")) {
            return var3.ironGolemBody;
         } else if (var2.equals("left_arm")) {
            return var3.ironGolemLeftArm;
         } else if (var2.equals("right_arm")) {
            return var3.ironGolemRightArm;
         } else if (var2.equals("left_leg")) {
            return var3.ironGolemLeftLeg;
         } else {
            return var2.equals("right_leg") ? var3.ironGolemRightLeg : null;
         }
      }
   }

   public ModelBase makeModel() {
      return new ModelIronGolem();
   }
}
