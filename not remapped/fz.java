import java.io.IOException;

public class fz implements ff<fj> {
   private fz.a[] b;
   private adg a;

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public fz.a[] a() {
      return this.b;
   }

   public fz() {
   }

   public fz(int var1, short[] var2, amy var3) {
      this.a = new adg(var3.a, var3.b);
      this.b = new fz.a[var1];

      for(int var4 = 0; var4 < this.b.length; ++var4) {
         this.b[var4] = new fz.a(this, var2[var4], var3);
      }

   }

   public void b(em var1) throws IOException {
      var1.writeInt(this.a.a);
      var1.writeInt(this.a.b);
      var1.b(this.b.length);
      fz.a[] var2 = this.b;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         fz.a var5 = var2[var4];
         var1.writeShort(var5.b());
         var1.b(afh.d.b(var5.c()));
      }

   }

   public void a(em var1) throws IOException {
      this.a = new adg(var1.readInt(), var1.readInt());
      this.b = new fz.a[var1.e()];

      for(int var2 = 0; var2 < this.b.length; ++var2) {
         this.b[var2] = new fz.a(this, var1.readShort(), (alz)afh.d.a(var1.e()));
      }

   }

   static adg a(fz var0) {
      return var0.a;
   }

   public class a {
      private final alz c;
      final fz a;
      private final short b;

      public short b() {
         return this.b;
      }

      public alz c() {
         return this.c;
      }

      public a(fz var1, short var2, alz var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      public a(fz var1, short var2, amy var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3.g(this.a());
      }

      public cj a() {
         return new cj(fz.a(this.a).a(this.b >> 12 & 15, this.b & 255, this.b >> 8 & 15));
      }
   }
}
