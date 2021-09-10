import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class ajb extends afh {
   private final Set<cj> R = Sets.newHashSet();
   public static final amn P = amn.a("power", 0, 15);
   public static final amm<ajb.a> O = amm.a("west", ajb.a.class);
   public static final amm<ajb.a> a = amm.a("north", ajb.a.class);
   public static final amm<ajb.a> b = amm.a("east", ajb.a.class);
   public static final amm<ajb.a> N = amm.a("south", ajb.a.class);
   private boolean Q = true;

   private int a(adm var1, cj var2, int var3) {
      if (var1.p(var2).c() != this) {
         return var3;
      } else {
         int var4 = (Integer)var1.p(var2).b(P);
         return var4 > var3 ? var4 : var3;
      }
   }

   public alz a(alz var1, adq var2, cj var3) {
      var1 = var1.a(O, this.c(var2, var3, cq.e));
      var1 = var1.a(b, this.c(var2, var3, cq.f));
      var1 = var1.a(a, this.c(var2, var3, cq.c));
      var1 = var1.a(N, this.c(var2, var3, cq.d));
      return var1;
   }

   public zw a(alz var1, Random var2, int var3) {
      return zy.aC;
   }

   public int a(adq var1, cj var2, int var3) {
      alz var4 = var1.p(var2);
      return var4.c() != this ? super.a(var1, var2, var3) : this.b((Integer)var4.b(P));
   }

   public adf m() {
      return adf.c;
   }

   public boolean d(adm var1, cj var2) {
      return adm.a((adq)var1, (cj)var2.b()) || var1.p(var2.b()).c() == afi.aX;
   }

   private alz e(adm var1, cj var2, alz var3) {
      var3 = this.a(var1, var2, var2, var3);
      ArrayList var4 = Lists.newArrayList(this.R);
      this.R.clear();
      Iterator var5 = var4.iterator();

      while(var5.hasNext()) {
         cj var6 = (cj)var5.next();
         var1.c((cj)var6, (afh)this);
      }

      return var3;
   }

   public boolean i() {
      return this.Q;
   }

   protected static boolean d(alz var0) {
      return a(var0, (cq)null);
   }

   public int a(adq var1, cj var2, alz var3, cq var4) {
      if (!this.Q) {
         return 0;
      } else {
         int var5 = (Integer)var3.b(P);
         if (var5 == 0) {
            return 0;
         } else if (var4 == cq.b) {
            return var5;
         } else {
            EnumSet var6 = EnumSet.noneOf(cq.class);
            Iterator var7 = cq.c.a.iterator();

            while(var7.hasNext()) {
               cq var8 = (cq)var7.next();
               if (this.d(var1, var2, var8)) {
                  var6.add(var8);
               }
            }

            if (var4.k().c() && var6.isEmpty()) {
               return var5;
            } else if (var6.contains(var4) && !var6.contains(var4.f()) && !var6.contains(var4.e())) {
               return var5;
            } else {
               return 0;
            }
         }
      }
   }

   protected ama e() {
      return new ama(this, new amo[]{a, b, N, O, P});
   }

   public ajb() {
      super(arm.q);
      this.j(this.M.b().a(a, ajb.a.c).a(b, ajb.a.c).a(N, ajb.a.c).a(O, ajb.a.c).a(P, 0));
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
   }

   protected static boolean e(adq var0, cj var1) {
      return d(var0.p(var1));
   }

   private void e(adm var1, cj var2) {
      if (var1.p(var2).c() == this) {
         var1.c((cj)var2, (afh)this);
         cq[] var3 = cq.values();
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            cq var6 = var3[var5];
            var1.c((cj)var2.a(var6), (afh)this);
         }

      }
   }

   private int b(int var1) {
      float var2 = (float)var1 / 15.0F;
      float var3 = var2 * 0.6F + 0.4F;
      if (var1 == 0) {
         var3 = 0.3F;
      }

      float var4 = var2 * var2 * 0.7F - 0.5F;
      float var5 = var2 * var2 * 0.6F - 0.7F;
      if (var4 < 0.0F) {
         var4 = 0.0F;
      }

      if (var5 < 0.0F) {
         var5 = 0.0F;
      }

      int var6 = ns.a((int)(var3 * 255.0F), 0, 255);
      int var7 = ns.a((int)(var4 * 255.0F), 0, 255);
      int var8 = ns.a((int)(var5 * 255.0F), 0, 255);
      return -16777216 | var6 << 16 | var7 << 8 | var8;
   }

   public int b(adq var1, cj var2, alz var3, cq var4) {
      return !this.Q ? 0 : this.a(var1, var2, var3, var4);
   }

   protected static boolean a(alz var0, cq var1) {
      afh var2 = var0.c();
      if (var2 == afi.af) {
         return true;
      } else if (afi.bb.e(var2)) {
         cq var3 = (cq)var0.b(ajf.O);
         return var3 == var1 || var3.d() == var1;
      } else {
         return var2.i() && var1 != null;
      }
   }

   public zw c(adm var1, cj var2) {
      return zy.aC;
   }

   private ajb.a c(adq var1, cj var2, cq var3) {
      cj var4 = var2.a(var3);
      afh var5 = var1.p(var2.a(var3)).c();
      if (a(var1.p(var4), var3) || !var5.u() && d(var1.p(var4.b()))) {
         return ajb.a.b;
      } else {
         afh var6 = var1.p(var2.a()).c();
         return !var6.u() && var5.u() && d(var1.p(var4.a())) ? ajb.a.a : ajb.a.c;
      }
   }

   private alz a(adm var1, cj var2, cj var3, alz var4) {
      alz var5 = var4;
      int var6 = (Integer)var4.b(P);
      byte var7 = 0;
      int var14 = this.a((adm)var1, (cj)var3, var7);
      this.Q = false;
      int var8 = var1.A(var2);
      this.Q = true;
      if (var8 > 0 && var8 > var14 - 1) {
         var14 = var8;
      }

      int var9 = 0;
      Iterator var10 = cq.c.a.iterator();

      while(true) {
         while(var10.hasNext()) {
            cq var11 = (cq)var10.next();
            cj var12 = var2.a(var11);
            boolean var13 = var12.n() != var3.n() || var12.p() != var3.p();
            if (var13) {
               var9 = this.a(var1, var12, var9);
            }

            if (var1.p(var12).c().v() && !var1.p(var2.a()).c().v()) {
               if (var13 && var2.o() >= var3.o()) {
                  var9 = this.a(var1, var12.a(), var9);
               }
            } else if (!var1.p(var12).c().v() && var13 && var2.o() <= var3.o()) {
               var9 = this.a(var1, var12.b(), var9);
            }
         }

         if (var9 > var14) {
            var14 = var9 - 1;
         } else if (var14 > 0) {
            --var14;
         } else {
            var14 = 0;
         }

         if (var8 > var14 - 1) {
            var14 = var8;
         }

         if (var6 != var14) {
            var4 = var4.a(P, var14);
            if (var1.p(var2) == var5) {
               var1.a((cj)var2, (alz)var4, 2);
            }

            this.R.add(var2);
            cq[] var15 = cq.values();
            int var16 = var15.length;

            for(int var17 = 0; var17 < var16; ++var17) {
               cq var18 = var15[var17];
               this.R.add(var2.a(var18));
            }
         }

         return var4;
      }
   }

   private boolean d(adq var1, cj var2, cq var3) {
      cj var4 = var2.a(var3);
      alz var5 = var1.p(var4);
      afh var6 = var5.c();
      boolean var7 = var6.v();
      boolean var8 = var1.p(var2.a()).c().v();
      if (!var8 && var7 && e(var1, var4.a())) {
         return true;
      } else if (a(var5, var3)) {
         return true;
      } else if (var6 == afi.bc && var5.b(agd.O) == var3) {
         return true;
      } else {
         return !var7 && e(var1, var4.b());
      }
   }

   public aug a(adm var1, cj var2, alz var3) {
      return null;
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      if (!var1.D) {
         if (this.d(var1, var2)) {
            this.e(var1, var2, var3);
         } else {
            this.b(var1, var2, var3, 0);
            var1.g(var2);
         }

      }
   }

   public boolean c() {
      return false;
   }

   public void b(adm var1, cj var2, alz var3) {
      super.b(var1, var2, var3);
      if (!var1.D) {
         cq[] var4 = cq.values();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            cq var7 = var4[var6];
            var1.c((cj)var2.a(var7), (afh)this);
         }

         this.e(var1, var2, var3);
         Iterator var8 = cq.c.a.iterator();

         cq var9;
         while(var8.hasNext()) {
            var9 = (cq)var8.next();
            this.e(var1, var2.a(var9));
         }

         var8 = cq.c.a.iterator();

         while(var8.hasNext()) {
            var9 = (cq)var8.next();
            cj var10 = var2.a(var9);
            if (var1.p(var10).c().v()) {
               this.e(var1, var10.a());
            } else {
               this.e(var1, var10.b());
            }
         }

      }
   }

   public alz a(int var1) {
      return this.Q().a(P, var1);
   }

   public void c(adm var1, cj var2, alz var3, Random var4) {
      int var5 = (Integer)var3.b(P);
      if (var5 != 0) {
         double var6 = (double)var2.n() + 0.5D + ((double)var4.nextFloat() - 0.5D) * 0.2D;
         double var8 = (double)((float)var2.o() + 0.0625F);
         double var10 = (double)var2.p() + 0.5D + ((double)var4.nextFloat() - 0.5D) * 0.2D;
         float var12 = (float)var5 / 15.0F;
         float var13 = var12 * 0.6F + 0.4F;
         float var14 = Math.max(0.0F, var12 * var12 * 0.7F - 0.5F);
         float var15 = Math.max(0.0F, var12 * var12 * 0.6F - 0.7F);
         var1.a(cy.E, var6, var8, var10, (double)var13, (double)var14, (double)var15);
      }
   }

   public int c(alz var1) {
      return (Integer)var1.b(P);
   }

   public boolean d() {
      return false;
   }

   public void c(adm var1, cj var2, alz var3) {
      if (!var1.D) {
         this.e(var1, var2, var3);
         Iterator var4 = cq.c.b.iterator();

         cq var5;
         while(var4.hasNext()) {
            var5 = (cq)var4.next();
            var1.c((cj)var2.a(var5), (afh)this);
         }

         var4 = cq.c.a.iterator();

         while(var4.hasNext()) {
            var5 = (cq)var4.next();
            this.e(var1, var2.a(var5));
         }

         var4 = cq.c.a.iterator();

         while(var4.hasNext()) {
            var5 = (cq)var4.next();
            cj var6 = var2.a(var5);
            if (var1.p(var6).c().v()) {
               this.e(var1, var6.a());
            } else {
               this.e(var1, var6.b());
            }
         }

      }
   }

   static enum a implements nw {
      private final String d;
      c("none"),
      a("up");

      private static final ajb.a[] e = new ajb.a[]{a, b, c};
      b("side");

      private a(String var3) {
         this.d = var3;
      }

      public String l() {
         return this.d;
      }

      public String toString() {
         return this.l();
      }
   }
}
