import java.io.IOException;

public class he implements ff<fj> {
   private int a;
   private adp.a c;
   private oj b;
   private adr d;

   public adr d() {
      return this.d;
   }

   public he() {
   }

   public adp.a c() {
      return this.c;
   }

   public void a(em var1) throws IOException {
      this.a = var1.readInt();
      this.b = oj.a(var1.readUnsignedByte());
      this.c = adp.a.a(var1.readUnsignedByte());
      this.d = adr.a(var1.c(16));
      if (this.d == null) {
         this.d = adr.b;
      }

   }

   public void a(fj var1) {
      var1.a(this);
   }

   public oj b() {
      return this.b;
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public he(int var1, oj var2, adr var3, adp.a var4) {
      this.a = var1;
      this.b = var2;
      this.c = var4;
      this.d = var3;
   }

   public int a() {
      return this.a;
   }

   public void b(em var1) throws IOException {
      var1.writeInt(this.a);
      var1.writeByte(this.b.a());
      var1.writeByte(this.c.a());
      var1.a(this.d.a());
   }
}
