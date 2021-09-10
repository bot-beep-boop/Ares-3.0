import java.io.IOException;

public class hc implements ff<fj> {
   private int b;
   private int a;

   public void a(fj var1) {
      var1.a(this);
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public hc(int var1, pf var2) {
      this.a = var1;
      this.b = var2.a();
   }

   public hc() {
   }

   public void b(em var1) throws IOException {
      var1.b(this.a);
      var1.writeByte(this.b);
   }

   public int a() {
      return this.a;
   }

   public void a(em var1) throws IOException {
      this.a = var1.e();
      this.b = var1.readUnsignedByte();
   }

   public int b() {
      return this.b;
   }
}
