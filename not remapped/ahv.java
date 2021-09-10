import java.util.Iterator;
import java.util.Random;

public abstract class ahv extends afh {
   public static final amn b = amn.a("level", 0, 15);

   public void a(adm var1, cj var2, alz var3, afh var4) {
      this.e(var1, var2, var3);
   }

   protected ahv(arm var1) {
      super(var1);
      this.j(this.M.b().a(b, 0));
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      this.a(true);
   }

   public aug a(adm var1, cj var2, alz var3) {
      return null;
   }

   public boolean a(alz var1, boolean var2) {
      return var2 && (Integer)var1.b(b) == 0;
   }

   public zw a(alz var1, Random var2, int var3) {
      return null;
   }

   public alz a(int var1) {
      return this.Q().a(b, var1);
   }

   public boolean e(adm var1, cj var2, alz var3) {
      if (this.J == arm.i) {
         boolean var4 = false;
         cq[] var5 = cq.values();
         int var6 = var5.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            cq var8 = var5[var7];
            if (var8 != cq.a && var1.p(var2.a(var8)).c().t() == arm.h) {
               var4 = true;
               break;
            }
         }

         if (var4) {
            Integer var9 = (Integer)var3.b(b);
            if (var9 == 0) {
               var1.a(var2, afi.Z.Q());
               this.e(var1, var2);
               return true;
            }

            if (var9 <= 4) {
               var1.a(var2, afi.e.Q());
               this.e(var1, var2);
               return true;
            }
         }
      }

      return false;
   }

   public static ajw b(arm var0) {
      if (var0 == arm.h) {
         return afi.j;
      } else if (var0 == arm.i) {
         return afi.l;
      } else {
         throw new IllegalArgumentException("Invalid material");
      }
   }

   public void c(adm var1, cj var2, alz var3) {
      this.e(var1, var2, var3);
   }

   protected void e(adm var1, cj var2) {
      double var3 = (double)var2.n();
      double var5 = (double)var2.o();
      double var7 = (double)var2.p();
      var1.a(var3 + 0.5D, var5 + 0.5D, var7 + 0.5D, "random.fizz", 0.5F, 2.6F + (var1.s.nextFloat() - var1.s.nextFloat()) * 0.8F);

      for(int var9 = 0; var9 < 8; ++var9) {
         var1.a(cy.m, var3 + Math.random(), var5 + 1.2D, var7 + Math.random(), 0.0D, 0.0D, 0.0D);
      }

   }

   public int a(adm var1) {
      if (this.J == arm.h) {
         return 5;
      } else if (this.J == arm.i) {
         return var1.t.o() ? 10 : 30;
      } else {
         return 0;
      }
   }

   public static float b(int var0) {
      if (var0 >= 8) {
         var0 = 0;
      }

      return (float)(var0 + 1) / 9.0F;
   }

   public int c(alz var1) {
      return (Integer)var1.b(b);
   }

   public aui a(adm var1, cj var2, pk var3, aui var4) {
      return var4.e(this.h(var1, var2));
   }

   public void c(adm var1, cj var2, alz var3, Random var4) {
      double var5 = (double)var2.n();
      double var7 = (double)var2.o();
      double var9 = (double)var2.p();
      if (this.J == arm.h) {
         int var11 = (Integer)var3.b(b);
         if (var11 > 0 && var11 < 8) {
            if (var4.nextInt(64) == 0) {
               var1.a(var5 + 0.5D, var7 + 0.5D, var9 + 0.5D, "liquid.water", var4.nextFloat() * 0.25F + 0.75F, var4.nextFloat() * 1.0F + 0.5F, false);
            }
         } else if (var4.nextInt(10) == 0) {
            var1.a(cy.h, var5 + (double)var4.nextFloat(), var7 + (double)var4.nextFloat(), var9 + (double)var4.nextFloat(), 0.0D, 0.0D, 0.0D);
         }
      }

      if (this.J == arm.i && var1.p(var2.a()).c().t() == arm.a && !var1.p(var2.a()).c().c()) {
         if (var4.nextInt(100) == 0) {
            double var18 = var5 + (double)var4.nextFloat();
            double var13 = var7 + this.F;
            double var15 = var9 + (double)var4.nextFloat();
            var1.a(cy.B, var18, var13, var15, 0.0D, 0.0D, 0.0D);
            var1.a(var18, var13, var15, "liquid.lavapop", 0.2F + var4.nextFloat() * 0.2F, 0.9F + var4.nextFloat() * 0.15F, false);
         }

         if (var4.nextInt(200) == 0) {
            var1.a(var5, var7, var9, "liquid.lava", 0.2F + var4.nextFloat() * 0.2F, 0.9F + var4.nextFloat() * 0.15F, false);
         }
      }

      if (var4.nextInt(10) == 0 && adm.a((adq)var1, (cj)var2.b())) {
         arm var19 = var1.p(var2.c(2)).c().t();
         if (!var19.c() && !var19.d()) {
            double var12 = var5 + (double)var4.nextFloat();
            double var14 = var7 - 1.05D;
            double var16 = var9 + (double)var4.nextFloat();
            if (this.J == arm.h) {
               var1.a(cy.s, var12, var14, var16, 0.0D, 0.0D, 0.0D);
            } else {
               var1.a(cy.t, var12, var14, var16, 0.0D, 0.0D, 0.0D);
            }
         }
      }

   }

   public boolean a(adq var1, cj var2, cq var3) {
      if (var1.p(var2).c().t() == this.J) {
         return false;
      } else {
         return var3 == cq.b ? true : super.a(var1, var2, var3);
      }
   }

   public int b() {
      return 1;
   }

   public int a(adq var1, cj var2, int var3) {
      return this.J == arm.h ? aea.c(var1, var2) : 16777215;
   }

   protected ama e() {
      return new ama(this, new amo[]{b});
   }

   public int c(adq var1, cj var2) {
      int var3 = var1.b(var2, 0);
      int var4 = var1.b(var2.a(), 0);
      int var5 = var3 & 255;
      int var6 = var4 & 255;
      int var7 = var3 >> 16 & 255;
      int var8 = var4 >> 16 & 255;
      return (var5 > var6 ? var5 : var6) | (var7 > var8 ? var7 : var8) << 16;
   }

   public adf m() {
      return this.J == arm.h ? adf.d : adf.a;
   }

   protected int e(adq var1, cj var2) {
      return var1.p(var2).c().t() == this.J ? (Integer)var1.p(var2).b(b) : -1;
   }

   public int a(Random var1) {
      return 0;
   }

   public static agl a(arm var0) {
      if (var0 == arm.h) {
         return afi.i;
      } else if (var0 == arm.i) {
         return afi.k;
      } else {
         throw new IllegalArgumentException("Invalid material");
      }
   }

   public static double a(adq var0, cj var1, arm var2) {
      aui var3 = a(var2).h(var0, var1);
      return var3.a == 0.0D && var3.c == 0.0D ? -1000.0D : ns.b(var3.c, var3.a) - 1.5707963267948966D;
   }

   public boolean c() {
      return false;
   }

   public boolean b(adq var1, cj var2, cq var3) {
      arm var4 = var1.p(var2).c().t();
      if (var4 == this.J) {
         return false;
      } else if (var3 == cq.b) {
         return true;
      } else {
         return var4 == arm.w ? false : super.b(var1, var2, var3);
      }
   }

   public boolean g(adq var1, cj var2) {
      for(int var3 = -1; var3 <= 1; ++var3) {
         for(int var4 = -1; var4 <= 1; ++var4) {
            alz var5 = var1.p(var2.a(var3, 0, var4));
            afh var6 = var5.c();
            arm var7 = var6.t();
            if (var7 != this.J && !var6.o()) {
               return true;
            }
         }
      }

      return false;
   }

   public boolean d() {
      return false;
   }

   protected aui h(adq var1, cj var2) {
      aui var3 = new aui(0.0D, 0.0D, 0.0D);
      int var4 = this.f(var1, var2);
      Iterator var5 = cq.c.a.iterator();

      cq var6;
      cj var7;
      while(var5.hasNext()) {
         var6 = (cq)var5.next();
         var7 = var2.a(var6);
         int var8 = this.f(var1, var7);
         int var9;
         if (var8 < 0) {
            if (!var1.p(var7).c().t().c()) {
               var8 = this.f(var1, var7.b());
               if (var8 >= 0) {
                  var9 = var8 - (var4 - 8);
                  var3 = var3.b((double)((var7.n() - var2.n()) * var9), (double)((var7.o() - var2.o()) * var9), (double)((var7.p() - var2.p()) * var9));
               }
            }
         } else if (var8 >= 0) {
            var9 = var8 - var4;
            var3 = var3.b((double)((var7.n() - var2.n()) * var9), (double)((var7.o() - var2.o()) * var9), (double)((var7.p() - var2.p()) * var9));
         }
      }

      if ((Integer)var1.p(var2).b(b) >= 8) {
         var5 = cq.c.a.iterator();

         do {
            if (!var5.hasNext()) {
               return var3.a();
            }

            var6 = (cq)var5.next();
            var7 = var2.a(var6);
         } while(!this.b(var1, var7, var6) && !this.b(var1, var7.a(), var6));

         var3 = var3.a().b(0.0D, -6.0D, 0.0D);
      }

      return var3.a();
   }

   public boolean b(adq var1, cj var2) {
      return this.J != arm.i;
   }

   protected int f(adq var1, cj var2) {
      int var3 = this.e(var1, var2);
      return var3 >= 8 ? 0 : var3;
   }
}
