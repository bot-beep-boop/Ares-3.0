import java.io.IOException;

public class hn implements ff<fj> {
   private int b;
   private zx c;
   private int a;

   public int c() {
      return this.b;
   }

   public zx a() {
      return this.c;
   }

   public void a(em var1) throws IOException {
      this.a = var1.e();
      this.b = var1.readShort();
      this.c = var1.i();
   }

   public hn(int var1, int var2, zx var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3 == null ? null : var3.k();
   }

   public hn() {
   }

   public int b() {
      return this.a;
   }

   public void b(em var1) throws IOException {
      var1.b(this.a);
      var1.writeShort(this.b);
      var1.a(this.c);
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public void a(fj var1) {
      var1.a(this);
   }
}
