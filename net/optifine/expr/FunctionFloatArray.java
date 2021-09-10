package net.optifine.expr;

public class FunctionFloatArray implements IExpressionFloatArray {
   private IExpression[] arguments;
   private FunctionType type;

   public ExpressionType getExpressionType() {
      return ExpressionType.FLOAT_ARRAY;
   }

   public float[] eval() {
      return this.type.evalFloatArray(this.arguments);
   }

   public FunctionFloatArray(FunctionType var1, IExpression[] var2) {
      this.type = var1;
      this.arguments = var2;
   }

   public String toString() {
      return this.type + "()";
   }
}
