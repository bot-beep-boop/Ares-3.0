import java.io.IOException;

public class fq implements ff<fj> {
   private int b;
   private int a;

   public int b() {
      return this.b;
   }

   public fq() {
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public fq(pk var1, int var2) {
      this.a = var1.F();
      this.b = var2;
   }

   public int a() {
      return this.a;
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public void b(em var1) throws IOException {
      var1.b(this.a);
      var1.writeByte(this.b);
   }

   public void a(em var1) throws IOException {
      this.a = var1.e();
      this.b = var1.readUnsignedByte();
   }
}
