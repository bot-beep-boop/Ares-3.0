package net.optifine.shaders.uniform;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import net.optifine.expr.IExpression;
import net.optifine.expr.IExpressionCached;

public class CustomUniforms {
   private IExpressionCached[] expressionsCached;
   private CustomUniform[] uniforms;

   public void update() {
      this.resetCache();

      for(int var1 = 0; var1 < this.uniforms.length; ++var1) {
         CustomUniform var2 = this.uniforms[var1];
         var2.update();
      }

   }

   public CustomUniforms(CustomUniform[] var1, Map<String, IExpression> var2) {
      this.uniforms = var1;
      ArrayList var3 = new ArrayList();
      Iterator var5 = var2.keySet().iterator();

      while(var5.hasNext()) {
         String var4 = (String)var5.next();
         IExpression var6 = (IExpression)var2.get(var4);
         if (var6 instanceof IExpressionCached) {
            IExpressionCached var7 = (IExpressionCached)var6;
            var3.add(var7);
         }
      }

      this.expressionsCached = (IExpressionCached[])var3.toArray(new IExpressionCached[var3.size()]);
   }

   public void reset() {
      for(int var1 = 0; var1 < this.uniforms.length; ++var1) {
         CustomUniform var2 = this.uniforms[var1];
         var2.reset();
      }

   }

   private void resetCache() {
      for(int var1 = 0; var1 < this.expressionsCached.length; ++var1) {
         IExpressionCached var2 = this.expressionsCached[var1];
         var2.reset();
      }

   }

   public void setProgram(int var1) {
      for(int var2 = 0; var2 < this.uniforms.length; ++var2) {
         CustomUniform var3 = this.uniforms[var2];
         var3.setProgram(var1);
      }

   }
}
