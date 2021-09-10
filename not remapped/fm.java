import java.io.IOException;

public class fm implements ff<fj> {
   private int e;
   private int b;
   private int c;
   private int a;
   private int d;

   public int c() {
      return this.c;
   }

   public int a() {
      return this.a;
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public fm() {
   }

   public void a(em var1) throws IOException {
      this.a = var1.e();
      this.e = var1.readByte();
      this.b = var1.readInt();
      this.c = var1.readInt();
      this.d = var1.readInt();
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public void b(em var1) throws IOException {
      var1.b(this.a);
      var1.writeByte(this.e);
      var1.writeInt(this.b);
      var1.writeInt(this.c);
      var1.writeInt(this.d);
   }

   public int d() {
      return this.d;
   }

   public int b() {
      return this.b;
   }

   public int e() {
      return this.e;
   }

   public fm(pk var1) {
      this.a = var1.F();
      this.b = ns.c(var1.s * 32.0D);
      this.c = ns.c(var1.t * 32.0D);
      this.d = ns.c(var1.u * 32.0D);
      if (var1 instanceof uv) {
         this.e = 1;
      }

   }
}
