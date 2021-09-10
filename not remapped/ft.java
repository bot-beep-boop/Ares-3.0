import java.io.IOException;

public class ft implements ff<fj> {
   private cj a;
   private dn c;
   private int b;

   public dn c() {
      return this.c;
   }

   public cj a() {
      return this.a;
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public void a(em var1) throws IOException {
      this.a = var1.c();
      this.b = var1.readUnsignedByte();
      this.c = var1.h();
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public int b() {
      return this.b;
   }

   public ft() {
   }

   public ft(cj var1, int var2, dn var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public void b(em var1) throws IOException {
      var1.a(this.a);
      var1.writeByte((byte)this.b);
      var1.a(this.c);
   }
}
