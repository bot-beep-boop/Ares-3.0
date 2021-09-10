import java.io.IOException;

public class fy implements ff<fj> {
   private eu a;
   private byte b;

   public eu a() {
      return this.a;
   }

   public void b(em var1) throws IOException {
      var1.a(this.a);
      var1.writeByte(this.b);
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public void a(em var1) throws IOException {
      this.a = var1.d();
      this.b = var1.readByte();
   }

   public byte c() {
      return this.b;
   }

   public boolean b() {
      return this.b == 1 || this.b == 2;
   }

   public fy() {
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public fy(eu var1, byte var2) {
      this.a = var1;
      this.b = var2;
   }

   public fy(eu var1) {
      this(var1, (byte)1);
   }
}
