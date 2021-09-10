package net.minecraft.util;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class MouseHelper {
   public int deltaY;
   public int deltaX;

   public void mouseXYChange() {
      this.deltaX = Mouse.getDX();
      this.deltaY = Mouse.getDY();
   }

   public void ungrabMouseCursor() {
      Mouse.setCursorPosition(Display.getWidth() / 2, Display.getHeight() / 2);
      Mouse.setGrabbed(false);
   }

   public void grabMouseCursor() {
      Mouse.setGrabbed(true);
      this.deltaX = 0;
      this.deltaY = 0;
   }
}
