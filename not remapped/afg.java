import java.util.Iterator;
import java.util.Random;

public class afg extends age {
   public static final amk b = amk.a("occupied");
   public static final amm<afg.a> a = amm.a("part", afg.a.class);

   public int c(alz var1) {
      byte var2 = 0;
      int var3 = var2 | ((cq)var1.b(O)).b();
      if (var1.b(a) == afg.a.a) {
         var3 |= 8;
         if ((Boolean)var1.b(b)) {
            var3 |= 4;
         }
      }

      return var3;
   }

   public int k() {
      return 1;
   }

   public static cj a(adm var0, cj var1, int var2) {
      cq var3 = (cq)var0.p(var1).b(O);
      int var4 = var1.n();
      int var5 = var1.o();
      int var6 = var1.p();

      for(int var7 = 0; var7 <= 1; ++var7) {
         int var8 = var4 - var3.g() * var7 - 1;
         int var9 = var6 - var3.i() * var7 - 1;
         int var10 = var8 + 2;
         int var11 = var9 + 2;

         for(int var12 = var8; var12 <= var10; ++var12) {
            for(int var13 = var9; var13 <= var11; ++var13) {
               cj var14 = new cj(var12, var5, var13);
               if (e(var0, var14)) {
                  if (var2 <= 0) {
                     return var14;
                  }

                  --var2;
               }
            }
         }
      }

      return null;
   }

   public zw c(adm var1, cj var2) {
      return zy.ba;
   }

   public void a(adq var1, cj var2) {
      this.l();
   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      if (var1.D) {
         return true;
      } else {
         if (var3.b(a) != afg.a.a) {
            var2 = var2.a((cq)var3.b(O));
            var3 = var1.p(var2);
            if (var3.c() != this) {
               return true;
            }
         }

         if (var1.t.e() && var1.b(var2) != ady.x) {
            if ((Boolean)var3.b(b)) {
               wn var10 = this.f(var1, var2);
               if (var10 != null) {
                  var4.b((eu)(new fb("tile.bed.occupied", new Object[0])));
                  return true;
               }

               var3 = var3.a(b, false);
               var1.a((cj)var2, (alz)var3, 4);
            }

            wn.a var11 = var4.a(var2);
            if (var11 == wn.a.a) {
               var3 = var3.a(b, true);
               var1.a((cj)var2, (alz)var3, 4);
               return true;
            } else {
               if (var11 == wn.a.c) {
                  var4.b((eu)(new fb("tile.bed.noSleep", new Object[0])));
               } else if (var11 == wn.a.f) {
                  var4.b((eu)(new fb("tile.bed.notSafe", new Object[0])));
               }

               return true;
            }
         } else {
            var1.g(var2);
            cj var9 = var2.a(((cq)var3.b(O)).d());
            if (var1.p(var9).c() == this) {
               var1.g(var9);
            }

            var1.a((pk)null, (double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D, 5.0F, true, true);
            return true;
         }
      }
   }

   public zw a(alz var1, Random var2, int var3) {
      return var1.b(a) == afg.a.a ? null : zy.ba;
   }

   public boolean c() {
      return false;
   }

   public void a(adm var1, cj var2, alz var3, float var4, int var5) {
      if (var3.b(a) == afg.a.b) {
         super.a(var1, var2, var3, var4, 0);
      }

   }

   protected ama e() {
      return new ama(this, new amo[]{O, a, b});
   }

   private void l() {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5625F, 1.0F);
   }

   public alz a(int var1) {
      cq var2 = cq.b(var1);
      return (var1 & 8) > 0 ? this.Q().a(a, afg.a.a).a(O, var2).a(b, (var1 & 4) > 0) : this.Q().a(a, afg.a.b).a(O, var2);
   }

   public adf m() {
      return adf.c;
   }

   public alz a(alz var1, adq var2, cj var3) {
      if (var1.b(a) == afg.a.b) {
         alz var4 = var2.p(var3.a((cq)var1.b(O)));
         if (var4.c() == this) {
            var1 = var1.a(b, var4.b(b));
         }
      }

      return var1;
   }

   public afg() {
      super(arm.n);
      this.j(this.M.b().a(a, afg.a.b).a(b, false));
      this.l();
   }

   public boolean d() {
      return false;
   }

   public void a(adm var1, cj var2, alz var3, wn var4) {
      if (var4.bA.d && var3.b(a) == afg.a.a) {
         cj var5 = var2.a(((cq)var3.b(O)).d());
         if (var1.p(var5).c() == this) {
            var1.g(var5);
         }
      }

   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      cq var5 = (cq)var3.b(O);
      if (var3.b(a) == afg.a.a) {
         if (var1.p(var2.a(var5.d())).c() != this) {
            var1.g(var2);
         }
      } else if (var1.p(var2.a(var5)).c() != this) {
         var1.g(var2);
         if (!var1.D) {
            this.b(var1, var2, var3, 0);
         }
      }

   }

   protected static boolean e(adm var0, cj var1) {
      return adm.a((adq)var0, (cj)var1.b()) && !var0.p(var1).c().t().a() && !var0.p(var1.a()).c().t().a();
   }

   private wn f(adm var1, cj var2) {
      Iterator var3 = var1.j.iterator();

      wn var4;
      do {
         if (!var3.hasNext()) {
            return null;
         }

         var4 = (wn)var3.next();
      } while(!var4.bJ() || !var4.bx.equals(var2));

      return var4;
   }

   public static enum a implements nw {
      private final String c;
      b("foot"),
      a("head");

      private static final afg.a[] d = new afg.a[]{a, b};

      private a(String var3) {
         this.c = var3;
      }

      public String toString() {
         return this.c;
      }

      public String l() {
         return this.c;
      }
   }
}
