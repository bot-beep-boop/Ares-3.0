import java.util.Random;

public class afz extends afm implements afj {
   public static final amn a = amn.a("age", 0, 7);

   public boolean a(adm var1, Random var2, cj var3, alz var4) {
      return true;
   }

   public int c(alz var1) {
      return (Integer)var1.b(a);
   }

   public boolean a(adm var1, cj var2, alz var3, boolean var4) {
      return (Integer)var3.b(a) < 7;
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      super.b(var1, var2, var3, var4);
      if (var1.l(var2.a()) >= 9) {
         int var5 = (Integer)var3.b(a);
         if (var5 < 7) {
            float var6 = a(this, var1, var2);
            if (var4.nextInt((int)(25.0F / var6) + 1) == 0) {
               var1.a((cj)var2, (alz)var3.a(a, var5 + 1), 2);
            }
         }
      }

   }

   protected zw l() {
      return zy.N;
   }

   protected afz() {
      this.j(this.M.b().a(a, 0));
      this.a(true);
      float var1 = 0.5F;
      this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.25F, 0.5F + var1);
      this.a((yz)null);
      this.c(0.0F);
      this.a(h);
      this.K();
   }

   public alz a(int var1) {
      return this.Q().a(a, var1);
   }

   protected zw n() {
      return zy.O;
   }

   protected static float a(afh var0, adm var1, cj var2) {
      float var3 = 1.0F;
      cj var4 = var2.b();

      for(int var5 = -1; var5 <= 1; ++var5) {
         for(int var6 = -1; var6 <= 1; ++var6) {
            float var7 = 0.0F;
            alz var8 = var1.p(var4.a(var5, 0, var6));
            if (var8.c() == afi.ak) {
               var7 = 1.0F;
               if ((Integer)var8.b(ags.a) > 0) {
                  var7 = 3.0F;
               }
            }

            if (var5 != 0 || var6 != 0) {
               var7 /= 4.0F;
            }

            var3 += var7;
         }
      }

      cj var12 = var2.c();
      cj var13 = var2.d();
      cj var15 = var2.e();
      cj var14 = var2.f();
      boolean var9 = var0 == var1.p(var15).c() || var0 == var1.p(var14).c();
      boolean var10 = var0 == var1.p(var12).c() || var0 == var1.p(var13).c();
      if (var9 && var10) {
         var3 /= 2.0F;
      } else {
         boolean var11 = var0 == var1.p(var15.c()).c() || var0 == var1.p(var14.c()).c() || var0 == var1.p(var14.d()).c() || var0 == var1.p(var15.d()).c();
         if (var11) {
            var3 /= 2.0F;
         }
      }

      return var3;
   }

   public boolean f(adm var1, cj var2, alz var3) {
      return (var1.k(var2) >= 8 || var1.i(var2)) && this.c(var1.p(var2.b()).c());
   }

   protected boolean c(afh var1) {
      return var1 == afi.ak;
   }

   public void g(adm var1, cj var2, alz var3) {
      int var4 = (Integer)var3.b(a) + ns.a((Random)var1.s, 2, 5);
      if (var4 > 7) {
         var4 = 7;
      }

      var1.a((cj)var2, (alz)var3.a(a, var4), 2);
   }

   public void b(adm var1, Random var2, cj var3, alz var4) {
      this.g(var1, var3, var4);
   }

   public void a(adm var1, cj var2, alz var3, float var4, int var5) {
      super.a(var1, var2, var3, var4, 0);
      if (!var1.D) {
         int var6 = (Integer)var3.b(a);
         if (var6 >= 7) {
            int var7 = 3 + var5;

            for(int var8 = 0; var8 < var7; ++var8) {
               if (var1.s.nextInt(15) <= var6) {
                  a(var1, var2, new zx(this.l(), 1, 0));
               }
            }
         }

      }
   }

   public zw c(adm var1, cj var2) {
      return this.l();
   }

   public zw a(alz var1, Random var2, int var3) {
      return (Integer)var1.b(a) == 7 ? this.n() : this.l();
   }
}
