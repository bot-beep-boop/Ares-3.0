package net.optifine.shaders.config;

import net.optifine.shaders.Shaders;

public class ShaderOptionScreen extends ShaderOption {
   public String getNameText() {
      return Shaders.translate("screen." + this.getName(), this.getName());
   }

   public String getDescriptionText() {
      return Shaders.translate("screen." + this.getName() + ".comment", (String)null);
   }

   public ShaderOptionScreen(String var1) {
      super(var1, (String)null, (String)null, new String[0], (String)null, (String)null);
   }
}
