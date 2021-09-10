import java.io.IOException;

public class hq implements ff<fj> {
   private auu.a c;
   private String a;
   private String b;
   private int d;

   public auu.a d() {
      return this.c;
   }

   public String b() {
      return this.b;
   }

   public void a(em var1) throws IOException {
      this.a = var1.c(16);
      this.d = var1.readByte();
      if (this.d == 0 || this.d == 2) {
         this.b = var1.c(32);
         this.c = auu.a.a(var1.c(16));
      }

   }

   public String a() {
      return this.a;
   }

   public void b(em var1) throws IOException {
      var1.a(this.a);
      var1.writeByte(this.d);
      if (this.d == 0 || this.d == 2) {
         var1.a(this.b);
         var1.a(this.c.a());
      }

   }

   public int c() {
      return this.d;
   }

   public hq() {
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public hq(auk var1, int var2) {
      this.a = var1.b();
      this.b = var1.d();
      this.c = var1.c().c();
      this.d = var2;
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }
}
