package net.optifine.expr;

public class ExpressionFloatArrayCached implements IExpressionCached, IExpressionFloatArray {
   private float[] value;
   private boolean cached;
   private IExpressionFloatArray expression;

   public String toString() {
      return "cached(" + this.expression + ")";
   }

   public void reset() {
      this.cached = false;
   }

   public float[] eval() {
      if (!this.cached) {
         this.value = this.expression.eval();
         this.cached = true;
      }

      return this.value;
   }

   public ExpressionType getExpressionType() {
      return ExpressionType.FLOAT;
   }

   public ExpressionFloatArrayCached(IExpressionFloatArray var1) {
      this.expression = var1;
   }
}
