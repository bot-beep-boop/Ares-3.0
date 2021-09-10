package net.optifine.entity.model;

import net.minecraft.client.model.ModelRenderer;
import net.optifine.entity.model.anim.ModelUpdater;

public class CustomModelRenderer {
   private ModelRenderer modelRenderer;
   private boolean attach;
   private String modelPart;
   private ModelUpdater modelUpdater;

   public ModelUpdater getModelUpdater() {
      return this.modelUpdater;
   }

   public CustomModelRenderer(String var1, boolean var2, ModelRenderer var3, ModelUpdater var4) {
      this.modelPart = var1;
      this.attach = var2;
      this.modelRenderer = var3;
      this.modelUpdater = var4;
   }

   public String getModelPart() {
      return this.modelPart;
   }

   public ModelRenderer getModelRenderer() {
      return this.modelRenderer;
   }

   public boolean isAttach() {
      return this.attach;
   }
}
