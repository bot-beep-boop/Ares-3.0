import java.io.IOException;

public class hp implements ff<fj> {
   private float a;
   private float c;
   private int b;

   public int b() {
      return this.b;
   }

   public void a(em var1) throws IOException {
      this.a = var1.readFloat();
      this.b = var1.e();
      this.c = var1.readFloat();
   }

   public float c() {
      return this.c;
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public float a() {
      return this.a;
   }

   public hp(float var1, int var2, float var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public hp() {
   }

   public void b(em var1) throws IOException {
      var1.writeFloat(this.a);
      var1.b(this.b);
      var1.writeFloat(this.c);
   }
}
