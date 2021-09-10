package net.java.games.input;

public abstract class Mouse extends AbstractController {
   public Component getExtra() {
      return this.getComponent(Component.Identifier.Button.EXTRA);
   }

   public Component getMiddle() {
      return this.getComponent(Component.Identifier.Button.MIDDLE);
   }

   public Component getY() {
      return this.getComponent(Component.Identifier.Axis.Y);
   }

   public Component getSide() {
      return this.getComponent(Component.Identifier.Button.SIDE);
   }

   public Controller.Type getType() {
      return Controller.Type.MOUSE;
   }

   public Component getTertiaryButton() {
      Component var1 = this.getComponent(Component.Identifier.Button.MIDDLE);
      if (var1 == null) {
         var1 = this.getComponent(Component.Identifier.Button._3);
      }

      return var1;
   }

   public Component getPrimaryButton() {
      Component var1 = this.getComponent(Component.Identifier.Button.LEFT);
      if (var1 == null) {
         var1 = this.getComponent(Component.Identifier.Button._1);
      }

      return var1;
   }

   public Component getX() {
      return this.getComponent(Component.Identifier.Axis.X);
   }

   public Component getSecondaryButton() {
      Component var1 = this.getComponent(Component.Identifier.Button.RIGHT);
      if (var1 == null) {
         var1 = this.getComponent(Component.Identifier.Button._2);
      }

      return var1;
   }

   public Component getWheel() {
      return this.getComponent(Component.Identifier.Axis.Z);
   }

   public Component getBack() {
      return this.getComponent(Component.Identifier.Button.BACK);
   }

   public Component getButton4() {
      return this.getComponent(Component.Identifier.Button._4);
   }

   public Component getLeft() {
      return this.getComponent(Component.Identifier.Button.LEFT);
   }

   public Component getRight() {
      return this.getComponent(Component.Identifier.Button.RIGHT);
   }

   public Component getForward() {
      return this.getComponent(Component.Identifier.Button.FORWARD);
   }

   protected Mouse(String var1, Component[] var2, Controller[] var3, Rumbler[] var4) {
      super(var1, var2, var3, var4);
   }

   public Component getButton3() {
      return this.getComponent(Component.Identifier.Button._3);
   }
}
