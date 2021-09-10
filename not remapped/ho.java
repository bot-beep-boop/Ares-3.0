import java.io.IOException;

public class ho implements ff<fj> {
   private float a;
   private int c;
   private int b;

   public float a() {
      return this.a;
   }

   public ho(float var1, int var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public void a(em var1) throws IOException {
      this.a = var1.readFloat();
      this.c = var1.e();
      this.b = var1.e();
   }

   public ho() {
   }

   public int c() {
      return this.c;
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public int b() {
      return this.b;
   }

   public void b(em var1) throws IOException {
      var1.writeFloat(this.a);
      var1.b(this.c);
      var1.b(this.b);
   }

   public void a(fj var1) {
      var1.a(this);
   }
}
