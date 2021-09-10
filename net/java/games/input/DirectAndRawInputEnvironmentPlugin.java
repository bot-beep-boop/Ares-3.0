package net.java.games.input;

import java.util.ArrayList;

public class DirectAndRawInputEnvironmentPlugin extends ControllerEnvironment {
   private RawInputEnvironmentPlugin rawPlugin = new RawInputEnvironmentPlugin();
   private Controller[] controllers = null;
   private DirectInputEnvironmentPlugin dinputPlugin = new DirectInputEnvironmentPlugin();

   public boolean isSupported() {
      return this.rawPlugin.isSupported() || this.dinputPlugin.isSupported();
   }

   public Controller[] getControllers() {
      if (this.controllers == null) {
         boolean var1 = false;
         boolean var2 = false;
         ArrayList var3 = new ArrayList();
         Controller[] var4 = this.dinputPlugin.getControllers();
         Controller[] var5 = this.rawPlugin.getControllers();

         int var6;
         for(var6 = 0; var6 < var5.length; ++var6) {
            var3.add(var5[var6]);
            if (var5[var6].getType() == Controller.Type.KEYBOARD) {
               var1 = true;
            } else if (var5[var6].getType() == Controller.Type.MOUSE) {
               var2 = true;
            }
         }

         for(var6 = 0; var6 < var4.length; ++var6) {
            if (var4[var6].getType() == Controller.Type.KEYBOARD) {
               if (!var1) {
                  var3.add(var4[var6]);
               }
            } else if (var4[var6].getType() == Controller.Type.MOUSE) {
               if (!var2) {
                  var3.add(var4[var6]);
               }
            } else {
               var3.add(var4[var6]);
            }
         }

         this.controllers = (Controller[])((Controller[])var3.toArray(new Controller[0]));
      }

      return this.controllers;
   }
}
