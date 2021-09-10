import java.io.IOException;

public class fu implements ff<fj> {
   private cj a;
   private afh d;
   private int c;
   private int b;

   public void a(fj var1) {
      var1.a(this);
   }

   public int b() {
      return this.b;
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public void b(em var1) throws IOException {
      var1.a(this.a);
      var1.writeByte(this.b);
      var1.writeByte(this.c);
      var1.b(afh.a(this.d) & 4095);
   }

   public afh d() {
      return this.d;
   }

   public cj a() {
      return this.a;
   }

   public void a(em var1) throws IOException {
      this.a = var1.c();
      this.b = var1.readUnsignedByte();
      this.c = var1.readUnsignedByte();
      this.d = afh.c(var1.e() & 4095);
   }

   public int c() {
      return this.c;
   }

   public fu() {
   }

   public fu(cj var1, afh var2, int var3, int var4) {
      this.a = var1;
      this.b = var3;
      this.c = var4;
      this.d = var2;
   }
}
