package net.optifine.expr;

public class Parameters implements IParameters {
   private ExpressionType[] parameterTypes;

   public ExpressionType[] getParameterTypes(IExpression[] var1) {
      return this.parameterTypes;
   }

   public Parameters(ExpressionType[] var1) {
      this.parameterTypes = var1;
   }
}
