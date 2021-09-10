public class asx {
   private final asv[] a;
   private int b;
   private int c;

   public int d() {
      return this.c;
   }

   public void b(int var1) {
      this.c = var1;
   }

   public boolean b(aui var1) {
      asv var2 = this.c();
      if (var2 == null) {
         return false;
      } else {
         return var2.a == (int)var1.a && var2.c == (int)var1.c;
      }
   }

   public boolean b() {
      return this.b >= this.c;
   }

   public asv a(int var1) {
      return this.a[var1];
   }

   public void c(int var1) {
      this.b = var1;
   }

   public aui a(pk var1, int var2) {
      double var3 = (double)this.a[var2].a + (double)((int)(var1.J + 1.0F)) * 0.5D;
      double var5 = (double)this.a[var2].b;
      double var7 = (double)this.a[var2].c + (double)((int)(var1.J + 1.0F)) * 0.5D;
      return new aui(var3, var5, var7);
   }

   public boolean a(asx var1) {
      if (var1 == null) {
         return false;
      } else if (var1.a.length != this.a.length) {
         return false;
      } else {
         for(int var2 = 0; var2 < this.a.length; ++var2) {
            if (this.a[var2].a != var1.a[var2].a || this.a[var2].b != var1.a[var2].b || this.a[var2].c != var1.a[var2].c) {
               return false;
            }
         }

         return true;
      }
   }

   public asv c() {
      return this.c > 0 ? this.a[this.c - 1] : null;
   }

   public int e() {
      return this.b;
   }

   public void a() {
      ++this.b;
   }

   public aui a(pk var1) {
      return this.a(var1, this.b);
   }

   public asx(asv[] var1) {
      this.a = var1;
      this.c = var1.length;
   }
}
