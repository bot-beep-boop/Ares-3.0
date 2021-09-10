import java.io.IOException;

public class fs implements ff<fj> {
   private int c;
   private int a;
   private cj b;

   public int a() {
      return this.a;
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public fs(int var1, cj var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public int c() {
      return this.c;
   }

   public cj b() {
      return this.b;
   }

   public void a(em var1) throws IOException {
      this.a = var1.e();
      this.b = var1.c();
      this.c = var1.readUnsignedByte();
   }

   public void b(em var1) throws IOException {
      var1.b(this.a);
      var1.a(this.b);
      var1.writeByte(this.c);
   }

   public fs() {
   }
}
