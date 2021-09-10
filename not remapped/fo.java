import java.io.IOException;

public class fo implements ff<fj> {
   private cj b;
   private String d;
   private int a;
   private cq c;

   public void a(fj var1) {
      var1.a(this);
   }

   public String d() {
      return this.d;
   }

   public cq c() {
      return this.c;
   }

   public void a(em var1) throws IOException {
      this.a = var1.e();
      this.d = var1.c(uq.a.A);
      this.b = var1.c();
      this.c = cq.b(var1.readUnsignedByte());
   }

   public fo(uq var1) {
      this.a = var1.F();
      this.b = var1.n();
      this.c = var1.b;
      this.d = var1.c.B;
   }

   public fo() {
   }

   public cj b() {
      return this.b;
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public void b(em var1) throws IOException {
      var1.b(this.a);
      var1.a(this.d);
      var1.a(this.b);
      var1.writeByte(this.c.b());
   }

   public int a() {
      return this.a;
   }
}
