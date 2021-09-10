package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RendererLivingEntity;

public class LayerBipedArmor extends LayerArmorBase<ModelBiped> {
   protected void setModelVisible(ModelBiped var1) {
      var1.setInvisible(false);
   }

   public LayerBipedArmor(RendererLivingEntity<?> var1) {
      super(var1);
   }

   protected void setModelPartVisible(ModelBase var1, int var2) {
      this.setModelPartVisible((ModelBiped)var1, var2);
   }

   protected void initArmor() {
      this.modelLeggings = new ModelBiped(0.5F);
      this.modelArmor = new ModelBiped(1.0F);
   }

   protected void setModelPartVisible(ModelBiped var1, int var2) {
      this.setModelVisible(var1);
      switch(var2) {
      case 1:
         var1.bipedRightLeg.showModel = true;
         var1.bipedLeftLeg.showModel = true;
         break;
      case 2:
         var1.bipedBody.showModel = true;
         var1.bipedRightLeg.showModel = true;
         var1.bipedLeftLeg.showModel = true;
         break;
      case 3:
         var1.bipedBody.showModel = true;
         var1.bipedRightArm.showModel = true;
         var1.bipedLeftArm.showModel = true;
         break;
      case 4:
         var1.bipedHead.showModel = true;
         var1.bipedHeadwear.showModel = true;
      }

   }
}
