package net.optifine.expr;

public class ConstantFloat implements IExpressionFloat {
   private float value;

   public String toString() {
      return "" + this.value;
   }

   public float eval() {
      return this.value;
   }

   public ConstantFloat(float var1) {
      this.value = var1;
   }

   public ExpressionType getExpressionType() {
      return ExpressionType.FLOAT;
   }
}
