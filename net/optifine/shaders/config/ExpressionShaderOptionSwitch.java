package net.optifine.shaders.config;

import net.optifine.expr.ExpressionType;
import net.optifine.expr.IExpressionBool;

public class ExpressionShaderOptionSwitch implements IExpressionBool {
   private ShaderOptionSwitch shaderOption;

   public ExpressionShaderOptionSwitch(ShaderOptionSwitch var1) {
      this.shaderOption = var1;
   }

   public String toString() {
      return "" + this.shaderOption;
   }

   public boolean eval() {
      return ShaderOptionSwitch.isTrue(this.shaderOption.getValue());
   }

   public ExpressionType getExpressionType() {
      return ExpressionType.BOOL;
   }
}
