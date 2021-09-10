package net.optifine.player;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;

public class PlayerItemRenderer {
   private int attachTo = 0;
   private ModelRenderer modelRenderer = null;

   public void render(ModelBiped var1, float var2) {
      ModelRenderer var3 = PlayerItemModel.getAttachModel(var1, this.attachTo);
      if (var3 != null) {
         var3.postRender(var2);
      }

      this.modelRenderer.render(var2);
   }

   public ModelRenderer getModelRenderer() {
      return this.modelRenderer;
   }

   public PlayerItemRenderer(int var1, ModelRenderer var2) {
      this.attachTo = var1;
      this.modelRenderer = var2;
   }
}
