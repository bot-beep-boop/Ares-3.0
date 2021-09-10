public class amz {
   private int c;
   private int a;
   private amw f;
   private amw e;
   private char[] d;
   private int b;

   public amz(int var1, boolean var2) {
      this.a = var1;
      this.d = new char[4096];
      this.e = new amw();
      if (var2) {
         this.f = new amw();
      }

   }

   public void b(int var1, int var2, int var3, int var4) {
      this.e.a(var1, var2, var3, var4);
   }

   public void a(int var1, int var2, int var3, alz var4) {
      alz var5 = this.a(var1, var2, var3);
      afh var6 = var5.c();
      afh var7 = var4.c();
      if (var6 != afi.a) {
         --this.b;
         if (var6.y()) {
            --this.c;
         }
      }

      if (var7 != afi.a) {
         ++this.b;
         if (var7.y()) {
            ++this.c;
         }
      }

      this.d[var2 << 8 | var3 << 4 | var1] = (char)afh.d.b(var4);
   }

   public amw i() {
      return this.f;
   }

   public afh b(int var1, int var2, int var3) {
      return this.a(var1, var2, var3).c();
   }

   public int e(int var1, int var2, int var3) {
      return this.e.a(var1, var2, var3);
   }

   public void a(char[] var1) {
      this.d = var1;
   }

   public void b(amw var1) {
      this.f = var1;
   }

   public void a(amw var1) {
      this.e = var1;
   }

   public boolean b() {
      return this.c > 0;
   }

   public int c(int var1, int var2, int var3) {
      alz var4 = this.a(var1, var2, var3);
      return var4.c().c(var4);
   }

   public void a(int var1, int var2, int var3, int var4) {
      this.f.a(var1, var2, var3, var4);
   }

   public boolean a() {
      return this.b == 0;
   }

   public int d() {
      return this.a;
   }

   public void e() {
      this.b = 0;
      this.c = 0;

      for(int var1 = 0; var1 < 16; ++var1) {
         for(int var2 = 0; var2 < 16; ++var2) {
            for(int var3 = 0; var3 < 16; ++var3) {
               afh var4 = this.b(var1, var2, var3);
               if (var4 != afi.a) {
                  ++this.b;
                  if (var4.y()) {
                     ++this.c;
                  }
               }
            }
         }
      }

   }

   public char[] g() {
      return this.d;
   }

   public int d(int var1, int var2, int var3) {
      return this.f.a(var1, var2, var3);
   }

   public amw h() {
      return this.e;
   }

   public alz a(int var1, int var2, int var3) {
      alz var4 = (alz)afh.d.a(this.d[var2 << 8 | var3 << 4 | var1]);
      return var4 != null ? var4 : afi.a.Q();
   }
}
