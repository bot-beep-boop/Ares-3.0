import com.google.common.cache.LoadingCache;
import java.util.Random;

public class aip extends ahj {
   public static final amm<cq.a> a;

   public zw c(adm var1, cj var2) {
      return null;
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      cq.a var5 = (cq.a)var3.b(a);
      aip.a var6;
      if (var5 == cq.a.a) {
         var6 = new aip.a(var1, var2, cq.a.a);
         if (!var6.d() || aip.a.a(var6) < aip.a.b(var6) * aip.a.c(var6)) {
            var1.a(var2, afi.a.Q());
         }
      } else if (var5 == cq.a.c) {
         var6 = new aip.a(var1, var2, cq.a.c);
         if (!var6.d() || aip.a.a(var6) < aip.a.b(var6) * aip.a.c(var6)) {
            var1.a(var2, afi.a.Q());
         }
      }

   }

   public aug a(adm var1, cj var2, alz var3) {
      return null;
   }

   public void a(adm var1, cj var2, alz var3, pk var4) {
      if (var4.m == null && var4.l == null) {
         var4.d(var2);
      }

   }

   public int a(Random var1) {
      return 0;
   }

   public alz a(int var1) {
      return this.Q().a(a, (var1 & 3) == 2 ? cq.a.c : cq.a.a);
   }

   public aip() {
      super(arm.E, false);
      this.j(this.M.b().a(a, cq.a.a));
      this.a(true);
   }

   public int c(alz var1) {
      return a((cq.a)var1.b(a));
   }

   public boolean e(adm var1, cj var2) {
      aip.a var3 = new aip.a(var1, var2, cq.a.a);
      if (var3.d() && aip.a.a(var3) == 0) {
         var3.e();
         return true;
      } else {
         aip.a var4 = new aip.a(var1, var2, cq.a.c);
         if (var4.d() && aip.a.a(var4) == 0) {
            var4.e();
            return true;
         } else {
            return false;
         }
      }
   }

   public boolean d() {
      return false;
   }

   public void c(adm var1, cj var2, alz var3, Random var4) {
      if (var4.nextInt(100) == 0) {
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D, "portal.portal", 0.5F, var4.nextFloat() * 0.4F + 0.8F, false);
      }

      for(int var5 = 0; var5 < 4; ++var5) {
         double var6 = (double)((float)var2.n() + var4.nextFloat());
         double var8 = (double)((float)var2.o() + var4.nextFloat());
         double var10 = (double)((float)var2.p() + var4.nextFloat());
         double var12 = ((double)var4.nextFloat() - 0.5D) * 0.5D;
         double var14 = ((double)var4.nextFloat() - 0.5D) * 0.5D;
         double var16 = ((double)var4.nextFloat() - 0.5D) * 0.5D;
         int var18 = var4.nextInt(2) * 2 - 1;
         if (var1.p(var2.e()).c() != this && var1.p(var2.f()).c() != this) {
            var6 = (double)var2.n() + 0.5D + 0.25D * (double)var18;
            var12 = (double)(var4.nextFloat() * 2.0F * (float)var18);
         } else {
            var10 = (double)var2.p() + 0.5D + 0.25D * (double)var18;
            var16 = (double)(var4.nextFloat() * 2.0F * (float)var18);
         }

         var1.a(cy.y, var6, var8, var10, var12, var14, var16);
      }

   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      super.b(var1, var2, var3, var4);
      if (var1.t.d() && var1.Q().b("doMobSpawning") && var4.nextInt(2000) < var1.aa().a()) {
         int var5 = var2.o();

         cj var6;
         for(var6 = var2; !adm.a((adq)var1, (cj)var6) && var6.o() > 0; var6 = var6.b()) {
         }

         if (var5 > 0 && !var1.p(var6.a()).c().v()) {
            pk var7 = aax.a(var1, 57, (double)var6.n() + 0.5D, (double)var6.o() + 1.1D, (double)var6.p() + 0.5D);
            if (var7 != null) {
               var7.aj = var7.aq();
            }
         }
      }

   }

   static {
      a = amm.a("axis", cq.a.class, (Enum[])(cq.a.a, cq.a.c));
   }

   public boolean a(adq var1, cj var2, cq var3) {
      cq.a var4 = null;
      alz var5 = var1.p(var2);
      if (var1.p(var2).c() == this) {
         var4 = (cq.a)var5.b(a);
         if (var4 == null) {
            return false;
         }

         if (var4 == cq.a.c && var3 != cq.f && var3 != cq.e) {
            return false;
         }

         if (var4 == cq.a.a && var3 != cq.d && var3 != cq.c) {
            return false;
         }
      }

      boolean var6 = var1.p(var2.e()).c() == this && var1.p(var2.f(2)).c() != this;
      boolean var7 = var1.p(var2.f()).c() == this && var1.p(var2.g(2)).c() != this;
      boolean var8 = var1.p(var2.c()).c() == this && var1.p(var2.d(2)).c() != this;
      boolean var9 = var1.p(var2.d()).c() == this && var1.p(var2.e(2)).c() != this;
      boolean var10 = var6 || var7 || var4 == cq.a.a;
      boolean var11 = var8 || var9 || var4 == cq.a.c;
      if (var10 && var3 == cq.e) {
         return true;
      } else if (var10 && var3 == cq.f) {
         return true;
      } else if (var11 && var3 == cq.c) {
         return true;
      } else {
         return var11 && var3 == cq.d;
      }
   }

   public amd.b f(adm var1, cj var2) {
      cq.a var3 = cq.a.c;
      aip.a var4 = new aip.a(var1, var2, cq.a.a);
      LoadingCache var5 = amd.a(var1, true);
      if (!var4.d()) {
         var3 = cq.a.a;
         var4 = new aip.a(var1, var2, cq.a.c);
      }

      if (!var4.d()) {
         return new amd.b(var2, cq.c, cq.b, var5, 1, 1, 1);
      } else {
         int[] var6 = new int[cq.b.values().length];
         cq var7 = aip.a.d(var4).f();
         cj var8 = aip.a.e(var4).b(var4.a() - 1);
         cq.b[] var9 = cq.b.values();
         int var10 = var9.length;

         int var11;
         for(var11 = 0; var11 < var10; ++var11) {
            cq.b var12 = var9[var11];
            amd.b var13 = new amd.b(var7.c() == var12 ? var8 : var8.a(aip.a.d(var4), var4.b() - 1), cq.a(var12, var3), cq.b, var5, var4.b(), var4.a(), 1);

            for(int var14 = 0; var14 < var4.b(); ++var14) {
               for(int var15 = 0; var15 < var4.a(); ++var15) {
                  amc var16 = var13.a(var14, var15, 1);
                  if (var16.a() != null && var16.a().c().t() != arm.a) {
                     ++var6[var12.ordinal()];
                  }
               }
            }
         }

         cq.b var17 = cq.b.a;
         cq.b[] var18 = cq.b.values();
         var11 = var18.length;

         for(int var19 = 0; var19 < var11; ++var19) {
            cq.b var20 = var18[var19];
            if (var6[var20.ordinal()] < var6[var17.ordinal()]) {
               var17 = var20;
            }
         }

         return new amd.b(var7.c() == var17 ? var8 : var8.a(aip.a.d(var4), var4.b() - 1), cq.a(var17, var3), cq.b, var5, var4.b(), var4.a(), 1);
      }
   }

   public static int a(cq.a var0) {
      if (var0 == cq.a.a) {
         return 1;
      } else {
         return var0 == cq.a.c ? 2 : 0;
      }
   }

   public void a(adq var1, cj var2) {
      cq.a var3 = (cq.a)var1.p(var2).b(a);
      float var4 = 0.125F;
      float var5 = 0.125F;
      if (var3 == cq.a.a) {
         var4 = 0.5F;
      }

      if (var3 == cq.a.c) {
         var5 = 0.5F;
      }

      this.a(0.5F - var4, 0.0F, 0.5F - var5, 0.5F + var4, 1.0F, 0.5F + var5);
   }

   public adf m() {
      return adf.d;
   }

   public static class a {
      private cj f;
      private final adm a;
      private final cq c;
      private int e = 0;
      private int h;
      private final cq.a b;
      private final cq d;
      private int g;

      static int b(aip.a var0) {
         return var0.h;
      }

      public int a() {
         return this.g;
      }

      protected int a(cj var1, cq var2) {
         int var3;
         for(var3 = 0; var3 < 22; ++var3) {
            cj var4 = var1.a(var2, var3);
            if (!this.a(this.a.p(var4).c()) || this.a.p(var4.b()).c() != afi.Z) {
               break;
            }
         }

         afh var5 = this.a.p(var1.a(var2, var3)).c();
         return var5 == afi.Z ? var3 : 0;
      }

      public boolean d() {
         return this.f != null && this.h >= 2 && this.h <= 21 && this.g >= 3 && this.g <= 21;
      }

      static int a(aip.a var0) {
         return var0.e;
      }

      protected int c() {
         int var1;
         label76:
         for(this.g = 0; this.g < 21; ++this.g) {
            for(var1 = 0; var1 < this.h; ++var1) {
               cj var2 = this.f.a(this.c, var1).b(this.g);
               afh var3 = this.a.p(var2).c();
               if (!this.a(var3)) {
                  break label76;
               }

               if (var3 == afi.aY) {
                  ++this.e;
               }

               if (var1 == 0) {
                  var3 = this.a.p(var2.a(this.d)).c();
                  if (var3 != afi.Z) {
                     break label76;
                  }
               } else if (var1 == this.h - 1) {
                  var3 = this.a.p(var2.a(this.c)).c();
                  if (var3 != afi.Z) {
                     break label76;
                  }
               }
            }
         }

         for(var1 = 0; var1 < this.h; ++var1) {
            if (this.a.p(this.f.a(this.c, var1).b(this.g)).c() != afi.Z) {
               this.g = 0;
               break;
            }
         }

         if (this.g <= 21 && this.g >= 3) {
            return this.g;
         } else {
            this.f = null;
            this.h = 0;
            this.g = 0;
            return 0;
         }
      }

      public void e() {
         for(int var1 = 0; var1 < this.h; ++var1) {
            cj var2 = this.f.a(this.c, var1);

            for(int var3 = 0; var3 < this.g; ++var3) {
               this.a.a((cj)var2.b(var3), (alz)afi.aY.Q().a(aip.a, this.b), 2);
            }
         }

      }

      static int c(aip.a var0) {
         return var0.g;
      }

      static cj e(aip.a var0) {
         return var0.f;
      }

      public int b() {
         return this.h;
      }

      public a(adm var1, cj var2, cq.a var3) {
         this.a = var1;
         this.b = var3;
         if (var3 == cq.a.a) {
            this.d = cq.f;
            this.c = cq.e;
         } else {
            this.d = cq.c;
            this.c = cq.d;
         }

         for(cj var4 = var2; var2.o() > var4.o() - 21 && var2.o() > 0 && this.a(var1.p(var2.b()).c()); var2 = var2.b()) {
         }

         int var5 = this.a(var2, this.d) - 1;
         if (var5 >= 0) {
            this.f = var2.a(this.d, var5);
            this.h = this.a(this.f, this.c);
            if (this.h < 2 || this.h > 21) {
               this.f = null;
               this.h = 0;
            }
         }

         if (this.f != null) {
            this.g = this.c();
         }

      }

      static cq d(aip.a var0) {
         return var0.c;
      }

      protected boolean a(afh var1) {
         return var1.J == arm.a || var1 == afi.ab || var1 == afi.aY;
      }
   }
}
