import java.util.Random;

public class apf extends apg {
   private static final alz f;
   private static final alz e;
   private static final alz g;
   private boolean h;

   public apf(boolean var1, boolean var2) {
      super(var1, 13, 15, e, f);
      this.h = var2;
   }

   public void a(adm var1, Random var2, cj var3) {
      this.b(var1, var3.e().c());
      this.b(var1, var3.g(2).c());
      this.b(var1, var3.e().e(2));
      this.b(var1, var3.g(2).e(2));

      for(int var4 = 0; var4 < 5; ++var4) {
         int var5 = var2.nextInt(64);
         int var6 = var5 % 8;
         int var7 = var5 / 8;
         if (var6 == 0 || var6 == 7 || var7 == 0 || var7 == 7) {
            this.b(var1, var3.a(-3 + var6, 0, -3 + var7));
         }
      }

   }

   private void c(adm var1, cj var2) {
      for(int var3 = 2; var3 >= -3; --var3) {
         cj var4 = var2.b(var3);
         afh var5 = var1.p(var4).c();
         if (var5 == afi.c || var5 == afi.d) {
            this.a(var1, var4, g);
            break;
         }

         if (var5.t() != arm.a && var3 < 0) {
            break;
         }
      }

   }

   private void a(adm var1, int var2, int var3, int var4, int var5, Random var6) {
      int var7 = var6.nextInt(5) + (this.h ? this.a : 3);
      int var8 = 0;

      for(int var9 = var4 - var7; var9 <= var4; ++var9) {
         int var10 = var4 - var9;
         int var11 = var5 + ns.d((float)var10 / (float)var7 * 3.5F);
         this.a(var1, new cj(var2, var9, var3), var11 + (var10 > 0 && var11 == var8 && (var9 & 1) == 0 ? 1 : 0));
         var8 = var11;
      }

   }

   public boolean b(adm var1, Random var2, cj var3) {
      int var4 = this.a(var2);
      if (!this.a(var1, var2, var3, var4)) {
         return false;
      } else {
         this.a(var1, var3.n(), var3.p(), var3.o() + var4, 0, var2);

         for(int var5 = 0; var5 < var4; ++var5) {
            afh var6 = var1.p(var3.b(var5)).c();
            if (var6.t() == arm.a || var6.t() == arm.j) {
               this.a(var1, var3.b(var5), this.b);
            }

            if (var5 < var4 - 1) {
               var6 = var1.p(var3.a(1, var5, 0)).c();
               if (var6.t() == arm.a || var6.t() == arm.j) {
                  this.a(var1, var3.a(1, var5, 0), this.b);
               }

               var6 = var1.p(var3.a(1, var5, 1)).c();
               if (var6.t() == arm.a || var6.t() == arm.j) {
                  this.a(var1, var3.a(1, var5, 1), this.b);
               }

               var6 = var1.p(var3.a(0, var5, 1)).c();
               if (var6.t() == arm.a || var6.t() == arm.j) {
                  this.a(var1, var3.a(0, var5, 1), this.b);
               }
            }
         }

         return true;
      }
   }

   static {
      e = afi.r.Q().a(ail.b, aio.a.b);
      f = afi.t.Q().a(aik.Q, aio.a.b).a(ahs.b, false);
      g = afi.d.Q().a(agf.a, agf.a.c);
   }

   private void b(adm var1, cj var2) {
      for(int var3 = -2; var3 <= 2; ++var3) {
         for(int var4 = -2; var4 <= 2; ++var4) {
            if (Math.abs(var3) != 2 || Math.abs(var4) != 2) {
               this.c(var1, var2.a(var3, 0, var4));
            }
         }
      }

   }
}
