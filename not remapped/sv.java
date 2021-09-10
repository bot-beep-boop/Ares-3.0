import java.util.Iterator;

public class sv extends sw {
   protected ata a;
   private boolean f;

   public boolean h() {
      return this.a.d();
   }

   protected aui c() {
      return new aui(this.b.s, (double)this.p(), this.b.u);
   }

   private int p() {
      if (this.b.V() && this.h()) {
         int var1 = (int)this.b.aR().b;
         afh var2 = this.c.p(new cj(ns.c(this.b.s), var1, ns.c(this.b.u))).c();
         int var3 = 0;

         do {
            if (var2 != afi.i && var2 != afi.j) {
               return var1;
            }

            ++var1;
            var2 = this.c.p(new cj(ns.c(this.b.s), var1, ns.c(this.b.u))).c();
            ++var3;
         } while(var3 <= 16);

         return (int)this.b.aR().b;
      } else {
         return (int)(this.b.aR().b + 0.5D);
      }
   }

   public void d(boolean var1) {
      this.a.d(var1);
   }

   public void b(boolean var1) {
      this.a.b(var1);
   }

   public boolean e() {
      return this.a.e();
   }

   public void c(boolean var1) {
      this.a.a(var1);
   }

   private boolean a(int var1, int var2, int var3, int var4, int var5, int var6, aui var7, double var8, double var10) {
      int var12 = var1 - var4 / 2;
      int var13 = var3 - var6 / 2;
      if (!this.b(var12, var2, var13, var4, var5, var6, var7, var8, var10)) {
         return false;
      } else {
         for(int var14 = var12; var14 < var12 + var4; ++var14) {
            for(int var15 = var13; var15 < var13 + var6; ++var15) {
               double var16 = (double)var14 + 0.5D - var7.a;
               double var18 = (double)var15 + 0.5D - var7.c;
               if (!(var16 * var8 + var18 * var10 < 0.0D)) {
                  afh var20 = this.c.p(new cj(var14, var2 - 1, var15)).c();
                  arm var21 = var20.t();
                  if (var21 == arm.a) {
                     return false;
                  }

                  if (var21 == arm.h && !this.b.V()) {
                     return false;
                  }

                  if (var21 == arm.i) {
                     return false;
                  }
               }
            }
         }

         return true;
      }
   }

   private boolean b(int var1, int var2, int var3, int var4, int var5, int var6, aui var7, double var8, double var10) {
      Iterator var12 = cj.a(new cj(var1, var2, var3), new cj(var1 + var4 - 1, var2 + var5 - 1, var3 + var6 - 1)).iterator();

      while(var12.hasNext()) {
         cj var13 = (cj)var12.next();
         double var14 = (double)var13.n() + 0.5D - var7.a;
         double var16 = (double)var13.p() + 0.5D - var7.c;
         if (!(var14 * var8 + var16 * var10 < 0.0D)) {
            afh var18 = this.c.p(var13).c();
            if (!var18.b((adq)this.c, var13)) {
               return false;
            }
         }
      }

      return true;
   }

   protected void d() {
      super.d();
      if (this.f) {
         if (this.c.i(new cj(ns.c(this.b.s), (int)(this.b.aR().b + 0.5D), ns.c(this.b.u)))) {
            return;
         }

         for(int var1 = 0; var1 < this.d.d(); ++var1) {
            asv var2 = this.d.a(var1);
            if (this.c.i(new cj(var2.a, var2.b, var2.c))) {
               this.d.b(var1 - 1);
               return;
            }
         }
      }

   }

   public void e(boolean var1) {
      this.f = var1;
   }

   protected boolean b() {
      return this.b.C || this.h() && this.o() || this.b.au() && this.b instanceof we && this.b.m instanceof tn;
   }

   protected boolean a(aui var1, aui var2, int var3, int var4, int var5) {
      int var6 = ns.c(var1.a);
      int var7 = ns.c(var1.c);
      double var8 = var2.a - var1.a;
      double var10 = var2.c - var1.c;
      double var12 = var8 * var8 + var10 * var10;
      if (var12 < 1.0E-8D) {
         return false;
      } else {
         double var14 = 1.0D / Math.sqrt(var12);
         var8 *= var14;
         var10 *= var14;
         var3 += 2;
         var5 += 2;
         if (!this.a(var6, (int)var1.b, var7, var3, var4, var5, var1, var8, var10)) {
            return false;
         } else {
            var3 -= 2;
            var5 -= 2;
            double var16 = 1.0D / Math.abs(var8);
            double var18 = 1.0D / Math.abs(var10);
            double var20 = (double)(var6 * 1) - var1.a;
            double var22 = (double)(var7 * 1) - var1.c;
            if (var8 >= 0.0D) {
               ++var20;
            }

            if (var10 >= 0.0D) {
               ++var22;
            }

            var20 /= var8;
            var22 /= var10;
            int var24 = var8 < 0.0D ? -1 : 1;
            int var25 = var10 < 0.0D ? -1 : 1;
            int var26 = ns.c(var2.a);
            int var27 = ns.c(var2.c);
            int var28 = var26 - var6;
            int var29 = var27 - var7;

            do {
               if (var28 * var24 <= 0 && var29 * var25 <= 0) {
                  return true;
               }

               if (var20 < var22) {
                  var20 += var16;
                  var6 += var24;
                  var28 = var26 - var6;
               } else {
                  var22 += var18;
                  var7 += var25;
                  var29 = var27 - var7;
               }
            } while(this.a(var6, (int)var1.b, var7, var3, var4, var5, var1, var8, var10));

            return false;
         }
      }
   }

   public void a(boolean var1) {
      this.a.c(var1);
   }

   public sv(ps var1, adm var2) {
      super(var1, var2);
   }

   protected asy a() {
      this.a = new ata();
      this.a.a(true);
      return new asy(this.a);
   }

   public boolean g() {
      return this.a.b();
   }
}
