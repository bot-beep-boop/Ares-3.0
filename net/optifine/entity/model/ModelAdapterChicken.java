package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderChicken;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityChicken;

public class ModelAdapterChicken extends ModelAdapter {
   public ModelRenderer getModelRenderer(ModelBase var1, String var2) {
      if (!(var1 instanceof ModelChicken)) {
         return null;
      } else {
         ModelChicken var3 = (ModelChicken)var1;
         if (var2.equals("head")) {
            return var3.head;
         } else if (var2.equals("body")) {
            return var3.body;
         } else if (var2.equals("right_leg")) {
            return var3.rightLeg;
         } else if (var2.equals("left_leg")) {
            return var3.leftLeg;
         } else if (var2.equals("right_wing")) {
            return var3.rightWing;
         } else if (var2.equals("left_wing")) {
            return var3.leftWing;
         } else if (var2.equals("bill")) {
            return var3.bill;
         } else {
            return var2.equals("chin") ? var3.chin : null;
         }
      }
   }

   public IEntityRenderer makeEntityRender(ModelBase var1, float var2) {
      RenderManager var3 = Minecraft.getMinecraft().getRenderManager();
      RenderChicken var4 = new RenderChicken(var3, var1, var2);
      return var4;
   }

   public String[] getModelRendererNames() {
      return new String[]{"head", "body", "right_leg", "left_leg", "right_wing", "left_wing", "bill", "chin"};
   }

   public ModelBase makeModel() {
      return new ModelChicken();
   }

   public ModelAdapterChicken() {
      super(EntityChicken.class, "chicken", 0.3F);
   }
}
