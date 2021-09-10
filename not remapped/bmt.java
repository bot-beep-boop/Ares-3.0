import java.nio.ByteBuffer;
import org.lwjgl.opengl.GL11;

public class bmt {
   private final bmu b;
   private int c;
   private int a;

   public bmt(bmu var1) {
      this.b = var1;
      this.a = bqs.e();
   }

   public void c() {
      if (this.a >= 0) {
         bqs.g(this.a);
         this.a = -1;
      }

   }

   public void a(int var1) {
      GL11.glDrawArrays(var1, 0, this.c);
   }

   public void a(ByteBuffer var1) {
      this.a();
      bqs.a(bqs.R, var1, 35044);
      this.b();
      this.c = var1.limit() / this.b.g();
   }

   public void a() {
      bqs.g(bqs.R, this.a);
   }

   public void b() {
      bqs.g(bqs.R, 0);
   }
}
