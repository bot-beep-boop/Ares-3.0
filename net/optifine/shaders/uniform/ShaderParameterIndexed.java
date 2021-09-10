package net.optifine.shaders.uniform;

import net.optifine.expr.ExpressionType;
import net.optifine.expr.IExpressionFloat;

public class ShaderParameterIndexed implements IExpressionFloat {
   private int index2;
   private ShaderParameterFloat type;
   private int index1;

   public float eval() {
      return this.type.eval(this.index1, this.index2);
   }

   public ShaderParameterIndexed(ShaderParameterFloat var1, int var2) {
      this(var1, var2, 0);
   }

   public String toString() {
      if (this.type.getIndexNames1() == null) {
         return "" + this.type;
      } else {
         return this.type.getIndexNames2() == null ? this.type + "." + this.type.getIndexNames1()[this.index1] : this.type + "." + this.type.getIndexNames1()[this.index1] + "." + this.type.getIndexNames2()[this.index2];
      }
   }

   public ShaderParameterIndexed(ShaderParameterFloat var1) {
      this(var1, 0, 0);
   }

   public ShaderParameterIndexed(ShaderParameterFloat var1, int var2, int var3) {
      this.type = var1;
      this.index1 = var2;
      this.index2 = var3;
   }

   public ExpressionType getExpressionType() {
      return ExpressionType.FLOAT;
   }
}
