import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class avf {
   public int b;
   public int a;

   public void a() {
      Mouse.setGrabbed(true);
      this.a = 0;
      this.b = 0;
   }

   public void c() {
      this.a = Mouse.getDX();
      this.b = Mouse.getDY();
   }

   public void b() {
      Mouse.setCursorPosition(Display.getWidth() / 2, Display.getHeight() / 2);
      Mouse.setGrabbed(false);
   }
}
