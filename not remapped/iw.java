import java.io.IOException;

public class iw implements ff<ic> {
   private zx b;
   private int a;

   public void a(ep var1) {
      this.a((ic)var1);
   }

   public zx b() {
      return this.b;
   }

   public void a(em var1) throws IOException {
      this.a = var1.readShort();
      this.b = var1.i();
   }

   public void a(ic var1) {
      var1.a(this);
   }

   public int a() {
      return this.a;
   }

   public iw() {
   }

   public iw(int var1, zx var2) {
      this.a = var1;
      this.b = var2 != null ? var2.k() : null;
   }

   public void b(em var1) throws IOException {
      var1.writeShort(this.a);
      var1.a(this.b);
   }
}
