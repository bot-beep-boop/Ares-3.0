package net.optifine.entity.model.anim;

import net.minecraft.client.model.ModelRenderer;
import net.optifine.expr.ExpressionType;
import net.optifine.expr.IExpressionFloat;

public class ModelVariableFloat implements IExpressionFloat {
   private ModelRenderer modelRenderer;
   private ModelVariableType enumModelVariable;
   private String name;

   public ModelVariableFloat(String var1, ModelRenderer var2, ModelVariableType var3) {
      this.name = var1;
      this.modelRenderer = var2;
      this.enumModelVariable = var3;
   }

   public ExpressionType getExpressionType() {
      return ExpressionType.FLOAT;
   }

   public String toString() {
      return this.name;
   }

   public float eval() {
      return this.getValue();
   }

   public void setValue(float var1) {
      this.enumModelVariable.setFloat(this.modelRenderer, var1);
   }

   public float getValue() {
      return this.enumModelVariable.getFloat(this.modelRenderer);
   }
}
