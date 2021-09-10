package net.java.games.input;

public abstract class Keyboard extends AbstractController {
   public final boolean isKeyDown(Component.Identifier.Key var1) {
      Component var2 = this.getComponent(var1);
      if (var2 == null) {
         return false;
      } else {
         return var2.getPollData() != 0.0F;
      }
   }

   public Controller.Type getType() {
      return Controller.Type.KEYBOARD;
   }

   protected Keyboard(String var1, Component[] var2, Controller[] var3, Rumbler[] var4) {
      super(var1, var2, var3, var4);
   }
}
