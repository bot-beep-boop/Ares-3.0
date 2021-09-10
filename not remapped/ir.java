import java.io.IOException;

public class ir implements ff<ic> {
   private ir.a c;
   private cq b;
   private cj a;

   public ir() {
   }

   public ir(ir.a var1, cj var2, cq var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public void a(ic var1) {
      var1.a(this);
   }

   public ir.a c() {
      return this.c;
   }

   public cq b() {
      return this.b;
   }

   public void a(em var1) throws IOException {
      this.c = (ir.a)var1.a(ir.a.class);
      this.a = var1.c();
      this.b = cq.a(var1.readUnsignedByte());
   }

   public void b(em var1) throws IOException {
      var1.a((Enum)this.c);
      var1.a(this.a);
      var1.writeByte(this.b.a());
   }

   public cj a() {
      return this.a;
   }

   public void a(ep var1) {
      this.a((ic)var1);
   }

   public static enum a {
      d,
      a;

      private static final ir.a[] g = new ir.a[]{a, b, c, d, e, f};
      e,
      f,
      b,
      c;
   }
}
