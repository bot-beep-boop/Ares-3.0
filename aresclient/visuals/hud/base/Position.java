package com.aresclient.visuals.hud.base;

public class Position {
   public int x;
   public int y;
   public boolean visible;

   public Position(int var1, int var2, boolean var3) {
      this.x = var1;
      this.y = var2;
      this.visible = var3;
   }

   public void setX(int var1) {
      this.x = var1;
   }

   public void setY(int var1) {
      this.y = var1;
   }

   public int getY() {
      return this.y;
   }

   public int getX() {
      return this.x;
   }

   public boolean isVisible() {
      return this.visible;
   }

   public void setVisible(boolean var1) {
      this.visible = var1;
   }
}
