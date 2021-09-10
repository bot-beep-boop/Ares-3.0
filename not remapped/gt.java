import java.io.IOException;

public class gt implements ff<fj> {
   private boolean b;
   private int f;
   private oj e;
   private adp.a c;
   private int d;
   private boolean h;
   private int a;
   private adr g;

   public void a(fj var1) {
      var1.a(this);
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public adr g() {
      return this.g;
   }

   public oj e() {
      return this.e;
   }

   public void b(em var1) throws IOException {
      var1.writeInt(this.a);
      int var2 = this.c.a();
      if (this.b) {
         var2 |= 8;
      }

      var1.writeByte(var2);
      var1.writeByte(this.d);
      var1.writeByte(this.e.a());
      var1.writeByte(this.f);
      var1.a(this.g.a());
      var1.writeBoolean(this.h);
   }

   public gt(int var1, adp.a var2, boolean var3, int var4, oj var5, int var6, adr var7, boolean var8) {
      this.a = var1;
      this.d = var4;
      this.e = var5;
      this.c = var2;
      this.f = var6;
      this.b = var3;
      this.g = var7;
      this.h = var8;
   }

   public void a(em var1) throws IOException {
      this.a = var1.readInt();
      short var2 = var1.readUnsignedByte();
      this.b = (var2 & 8) == 8;
      int var3 = var2 & -9;
      this.c = adp.a.a(var3);
      this.d = var1.readByte();
      this.e = oj.a(var1.readUnsignedByte());
      this.f = var1.readUnsignedByte();
      this.g = adr.a(var1.c(16));
      if (this.g == null) {
         this.g = adr.b;
      }

      this.h = var1.readBoolean();
   }

   public boolean h() {
      return this.h;
   }

   public int d() {
      return this.d;
   }

   public gt() {
   }

   public boolean b() {
      return this.b;
   }

   public int a() {
      return this.a;
   }

   public int f() {
      return this.f;
   }

   public adp.a c() {
      return this.c;
   }
}
