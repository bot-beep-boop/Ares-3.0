public class bga {
   protected int e;
   protected int d;
   protected final bfr a;
   protected final adm b;
   protected int c;
   public bht[] f;

   private int a(int var1, int var2, int var3) {
      int var4 = var3 * 16;
      int var5 = var4 - var1 + var2 / 2;
      if (var5 < 0) {
         var5 -= var2 - 1;
      }

      return var4 - var5 / var2 * var2;
   }

   public bga(adm var1, int var2, bfr var3, bhu var4) {
      this.a = var3;
      this.b = var1;
      this.a(var2);
      this.a(var4);
   }

   protected void a(bhu var1) {
      int var2 = this.d * this.c * this.e;
      this.f = new bht[var2];
      int var3 = 0;

      for(int var4 = 0; var4 < this.d; ++var4) {
         for(int var5 = 0; var5 < this.c; ++var5) {
            for(int var6 = 0; var6 < this.e; ++var6) {
               int var7 = (var6 * this.c + var5) * this.d + var4;
               cj var8 = new cj(var4 * 16, var5 * 16, var6 * 16);
               this.f[var7] = var1.a(this.b, this.a, var8, var3++);
            }
         }
      }

   }

   public void a(int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = ns.a(var1, 16);
      int var8 = ns.a(var2, 16);
      int var9 = ns.a(var3, 16);
      int var10 = ns.a(var4, 16);
      int var11 = ns.a(var5, 16);
      int var12 = ns.a(var6, 16);

      for(int var13 = var7; var13 <= var10; ++var13) {
         int var14 = var13 % this.d;
         if (var14 < 0) {
            var14 += this.d;
         }

         for(int var15 = var8; var15 <= var11; ++var15) {
            int var16 = var15 % this.c;
            if (var16 < 0) {
               var16 += this.c;
            }

            for(int var17 = var9; var17 <= var12; ++var17) {
               int var18 = var17 % this.e;
               if (var18 < 0) {
                  var18 += this.e;
               }

               int var19 = (var18 * this.c + var16) * this.d + var14;
               bht var20 = this.f[var19];
               var20.a(true);
            }
         }
      }

   }

   protected bht a(cj var1) {
      int var2 = ns.a(var1.n(), 16);
      int var3 = ns.a(var1.o(), 16);
      int var4 = ns.a(var1.p(), 16);
      if (var3 >= 0 && var3 < this.c) {
         var2 %= this.d;
         if (var2 < 0) {
            var2 += this.d;
         }

         var4 %= this.e;
         if (var4 < 0) {
            var4 += this.e;
         }

         int var5 = (var4 * this.c + var3) * this.d + var2;
         return this.f[var5];
      } else {
         return null;
      }
   }

   protected void a(int var1) {
      int var2 = var1 * 2 + 1;
      this.d = var2;
      this.c = 16;
      this.e = var2;
   }

   public void a() {
      bht[] var1 = this.f;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         bht var4 = var1[var3];
         var4.a();
      }

   }

   public void a(double var1, double var3) {
      int var5 = ns.c(var1) - 8;
      int var6 = ns.c(var3) - 8;
      int var7 = this.d * 16;

      for(int var8 = 0; var8 < this.d; ++var8) {
         int var9 = this.a(var5, var7, var8);

         for(int var10 = 0; var10 < this.e; ++var10) {
            int var11 = this.a(var6, var7, var10);

            for(int var12 = 0; var12 < this.c; ++var12) {
               int var13 = var12 * 16;
               bht var14 = this.f[(var10 * this.c + var12) * this.d + var8];
               cj var15 = new cj(var9, var13, var11);
               if (!var15.equals(var14.j())) {
                  var14.a(var15);
               }
            }
         }
      }

   }
}
