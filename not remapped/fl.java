import java.io.IOException;

public class fl implements ff<fj> {
   private int c;
   private int b;
   private int a;
   private int d;
   private int e;

   public fl() {
   }

   public int a() {
      return this.a;
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public int c() {
      return this.c;
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public int d() {
      return this.d;
   }

   public void a(em var1) throws IOException {
      this.a = var1.e();
      this.b = var1.readInt();
      this.c = var1.readInt();
      this.d = var1.readInt();
      this.e = var1.readShort();
   }

   public void b(em var1) throws IOException {
      var1.b(this.a);
      var1.writeInt(this.b);
      var1.writeInt(this.c);
      var1.writeInt(this.d);
      var1.writeShort(this.e);
   }

   public int e() {
      return this.e;
   }

   public int b() {
      return this.b;
   }

   public fl(pp var1) {
      this.a = var1.F();
      this.b = ns.c(var1.s * 32.0D);
      this.c = ns.c(var1.t * 32.0D);
      this.d = ns.c(var1.u * 32.0D);
      this.e = var1.j();
   }
}
