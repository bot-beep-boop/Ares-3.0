package net.minecraft.launchwrapper;

import java.io.File;
import java.util.List;

public class IndevVanillaTweaker implements ITweaker {
   private List<String> args;

   public String getLaunchTarget() {
      return "net.minecraft.launchwrapper.injector.AlphaVanillaTweakInjector";
   }

   public String[] getLaunchArguments() {
      return (String[])this.args.toArray(new String[this.args.size()]);
   }

   public void acceptOptions(List<String> var1, File var2, File var3, String var4) {
      this.args = var1;
   }

   public void injectIntoClassLoader(LaunchClassLoader var1) {
      var1.registerTransformer("net.minecraft.launchwrapper.injector.IndevVanillaTweakInjector");
   }
}
