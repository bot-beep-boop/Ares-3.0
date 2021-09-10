package net.optifine.expr;

public class FunctionBool implements IExpressionBool {
   private IExpression[] arguments;
   private FunctionType type;

   public ExpressionType getExpressionType() {
      return ExpressionType.BOOL;
   }

   public FunctionBool(FunctionType var1, IExpression[] var2) {
      this.type = var1;
      this.arguments = var2;
   }

   public boolean eval() {
      return this.type.evalBool(this.arguments);
   }

   public String toString() {
      return this.type + "()";
   }
}
