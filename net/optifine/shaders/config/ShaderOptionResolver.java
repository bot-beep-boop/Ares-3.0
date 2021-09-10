package net.optifine.shaders.config;

import java.util.HashMap;
import java.util.Map;
import net.optifine.expr.IExpression;
import net.optifine.expr.IExpressionResolver;

public class ShaderOptionResolver implements IExpressionResolver {
   private Map<String, ExpressionShaderOptionSwitch> mapOptions = new HashMap();

   public IExpression getExpression(String var1) {
      ExpressionShaderOptionSwitch var2 = (ExpressionShaderOptionSwitch)this.mapOptions.get(var1);
      return var2;
   }

   public ShaderOptionResolver(ShaderOption[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         ShaderOption var3 = var1[var2];
         if (var3 instanceof ShaderOptionSwitch) {
            ShaderOptionSwitch var4 = (ShaderOptionSwitch)var3;
            ExpressionShaderOptionSwitch var5 = new ExpressionShaderOptionSwitch(var4);
            this.mapOptions.put(var3.getName(), var5);
         }
      }

   }
}
