package net.optifine.shaders.uniform;

import net.optifine.expr.IExpression;
import net.optifine.shaders.SMCLog;

public class CustomUniform {
   private ShaderUniformBase shaderUniform;
   private String name;
   private IExpression expression;
   private UniformType type;

   public IExpression getExpression() {
      return this.expression;
   }

   public void reset() {
      this.shaderUniform.reset();
   }

   public String getName() {
      return this.name;
   }

   public void setProgram(int var1) {
      this.shaderUniform.setProgram(var1);
   }

   public void update() {
      if (this.shaderUniform.isDefined()) {
         try {
            this.type.updateUniform(this.expression, this.shaderUniform);
         } catch (RuntimeException var2) {
            SMCLog.severe("Error updating custom uniform: " + this.shaderUniform.getName());
            SMCLog.severe(var2.getClass().getName() + ": " + var2.getMessage());
            this.shaderUniform.disable();
            SMCLog.severe("Custom uniform disabled: " + this.shaderUniform.getName());
         }
      }

   }

   public CustomUniform(String var1, UniformType var2, IExpression var3) {
      this.name = var1;
      this.type = var2;
      this.expression = var3;
      this.shaderUniform = var2.makeShaderUniform(var1);
   }

   public UniformType getType() {
      return this.type;
   }

   public String toString() {
      return this.type.name().toLowerCase() + " " + this.name;
   }

   public ShaderUniformBase getShaderUniform() {
      return this.shaderUniform;
   }
}
