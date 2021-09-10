import java.io.IOException;

public class gf implements ff<fj> {
   private int b;
   private int a;
   private zx c;

   public int a() {
      return this.a;
   }

   public gf() {
   }

   public zx c() {
      return this.c;
   }

   public gf(int var1, int var2, zx var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3 == null ? null : var3.k();
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public void b(em var1) throws IOException {
      var1.writeByte(this.a);
      var1.writeShort(this.b);
      var1.a(this.c);
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public void a(em var1) throws IOException {
      this.a = var1.readByte();
      this.b = var1.readShort();
      this.c = var1.i();
   }

   public int b() {
      return this.b;
   }
}
