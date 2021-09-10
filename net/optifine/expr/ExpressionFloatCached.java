package net.optifine.expr;

public class ExpressionFloatCached implements IExpressionCached, IExpressionFloat {
   private boolean cached;
   private float value;
   private IExpressionFloat expression;

   public void reset() {
      this.cached = false;
   }

   public float eval() {
      if (!this.cached) {
         this.value = this.expression.eval();
         this.cached = true;
      }

      return this.value;
   }

   public String toString() {
      return "cached(" + this.expression + ")";
   }

   public ExpressionFloatCached(IExpressionFloat var1) {
      this.expression = var1;
   }

   public ExpressionType getExpressionType() {
      return ExpressionType.FLOAT;
   }
}
