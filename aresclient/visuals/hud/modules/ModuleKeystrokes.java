package com.aresclient.visuals.hud.modules;

import com.aresclient.visuals.hud.base.impl.MoveableModule;
import com.aresclient.visuals.utils.Keystrokes;

public class ModuleKeystrokes extends MoveableModule {
   public void render() {
      Keystrokes var1 = new Keystrokes();
      var1.draw(this.getX(), this.getY());
   }

   public String getName() {
      return "Keystrokes";
   }

   public int getWidth() {
      return 60;
   }

   public int getHeight() {
      return 40;
   }

   public ModuleKeystrokes(int var1, int var2) {
      super(var1, var2, true);
   }
}
