import java.util.Random;

public class alv extends afc {
   public static final amm<alt.a> b;
   public static final aml a;

   public boolean d() {
      return false;
   }

   public int c(alz var1) {
      byte var2 = 0;
      int var3 = var2 | ((cq)var1.b(a)).a();
      if (var1.b(b) == alt.a.b) {
         var3 |= 8;
      }

      return var3;
   }

   public alz a(int var1) {
      return this.Q().a(a, alt.b(var1)).a(b, (var1 & 8) > 0 ? alt.a.b : alt.a.a);
   }

   protected ama e() {
      return new ama(this, new amo[]{a, b});
   }

   public zw c(adm var1, cj var2) {
      return null;
   }

   public auh a(adm var1, cj var2, aui var3, aui var4) {
      return null;
   }

   public void a(adq var1, cj var2) {
      alu var3 = this.e(var1, var2);
      if (var3 != null) {
         alz var4 = var3.b();
         afh var5 = var4.c();
         if (var5 == this || var5.t() == arm.a) {
            return;
         }

         float var6 = var3.a(0.0F);
         if (var3.d()) {
            var6 = 1.0F - var6;
         }

         var5.a(var1, var2);
         if (var5 == afi.J || var5 == afi.F) {
            var6 = 0.0F;
         }

         cq var7 = var3.e();
         this.B = var5.B() - (double)((float)var7.g() * var6);
         this.C = var5.D() - (double)((float)var7.h() * var6);
         this.D = var5.F() - (double)((float)var7.i() * var6);
         this.E = var5.C() - (double)((float)var7.g() * var6);
         this.F = var5.E() - (double)((float)var7.h() * var6);
         this.G = var5.G() - (double)((float)var7.i() * var6);
      }

   }

   public void a(adm var1, cj var2, alz var3, float var4, int var5) {
      if (!var1.D) {
         alu var6 = this.e(var1, var2);
         if (var6 != null) {
            alz var7 = var6.b();
            var7.c().b(var1, var2, var7, 0);
         }
      }
   }

   public boolean c() {
      return false;
   }

   public akw a(adm var1, int var2) {
      return null;
   }

   public boolean d(adm var1, cj var2) {
      return false;
   }

   public zw a(alz var1, Random var2, int var3) {
      return null;
   }

   public void d(adm var1, cj var2, alz var3) {
      cj var4 = var2.a(((cq)var3.b(a)).d());
      alz var5 = var1.p(var4);
      if (var5.c() instanceof als && (Boolean)var5.b(als.b)) {
         var1.g(var4);
      }

   }

   public boolean b(adm var1, cj var2, cq var3) {
      return false;
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      if (!var1.D) {
         var1.s(var2);
      }

   }

   private alu e(adq var1, cj var2) {
      akw var3 = var1.s(var2);
      return var3 instanceof alu ? (alu)var3 : null;
   }

   public alv() {
      super(arm.H);
      this.j(this.M.b().a(a, cq.c).a(b, alt.a.a));
      this.c(-1.0F);
   }

   public void b(adm var1, cj var2, alz var3) {
      akw var4 = var1.s(var2);
      if (var4 instanceof alu) {
         ((alu)var4).h();
      } else {
         super.b(var1, var2, var3);
      }

   }

   public static akw a(alz var0, cq var1, boolean var2, boolean var3) {
      return new alu(var0, var1, var2, var3);
   }

   static {
      a = alt.a;
      b = alt.b;
   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      if (!var1.D && var1.s(var2) == null) {
         var1.g(var2);
         return true;
      } else {
         return false;
      }
   }

   public aug a(adm var1, cj var2, alz var3, float var4, cq var5) {
      if (var3.c() != this && var3.c().t() != arm.a) {
         aug var6 = var3.c().a(var1, var2, var3);
         if (var6 == null) {
            return null;
         } else {
            double var7 = var6.a;
            double var9 = var6.b;
            double var11 = var6.c;
            double var13 = var6.d;
            double var15 = var6.e;
            double var17 = var6.f;
            if (var5.g() < 0) {
               var7 -= (double)((float)var5.g() * var4);
            } else {
               var13 -= (double)((float)var5.g() * var4);
            }

            if (var5.h() < 0) {
               var9 -= (double)((float)var5.h() * var4);
            } else {
               var15 -= (double)((float)var5.h() * var4);
            }

            if (var5.i() < 0) {
               var11 -= (double)((float)var5.i() * var4);
            } else {
               var17 -= (double)((float)var5.i() * var4);
            }

            return new aug(var7, var9, var11, var13, var15, var17);
         }
      } else {
         return null;
      }
   }

   public aug a(adm var1, cj var2, alz var3) {
      alu var4 = this.e(var1, var2);
      if (var4 == null) {
         return null;
      } else {
         float var5 = var4.a(0.0F);
         if (var4.d()) {
            var5 = 1.0F - var5;
         }

         return this.a(var1, var2, var4.b(), var5, var4.e());
      }
   }
}
