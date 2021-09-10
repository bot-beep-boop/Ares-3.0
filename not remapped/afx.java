import com.google.common.base.Predicate;
import java.util.List;
import java.util.Random;

public class afx extends agd implements agq {
   public static final amk a = amk.a("powered");
   public static final amm<afx.a> b = amm.a("mode", afx.a.class);

   public String f() {
      return di.a("item.comparator.name");
   }

   protected int d(alz var1) {
      return 2;
   }

   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      return this.Q().a(O, var8.aP().d()).a(a, false).a(b, afx.a.a);
   }

   public boolean a(adm var1, cj var2, alz var3, int var4, int var5) {
      super.a(var1, var2, var3, var4, var5);
      akw var6 = var1.s(var2);
      return var6 == null ? false : var6.c(var4, var5);
   }

   private void k(adm var1, cj var2, alz var3) {
      int var4 = this.j(var1, var2, var3);
      akw var5 = var1.s(var2);
      int var6 = 0;
      if (var5 instanceof ala) {
         ala var7 = (ala)var5;
         var6 = var7.b();
         var7.a(var4);
      }

      if (var6 != var4 || var3.b(b) == afx.a.a) {
         boolean var9 = this.e(var1, var2, var3);
         boolean var8 = this.l(var3);
         if (var8 && !var9) {
            var1.a((cj)var2, (alz)var3.a(a, false), 2);
         } else if (!var8 && var9) {
            var1.a((cj)var2, (alz)var3.a(a, true), 2);
         }

         this.h(var1, var2, var3);
      }

   }

   public akw a(adm var1, int var2) {
      return new ala();
   }

   protected alz e(alz var1) {
      Boolean var2 = (Boolean)var1.b(a);
      afx.a var3 = (afx.a)var1.b(b);
      cq var4 = (cq)var1.b(O);
      return afi.ck.Q().a(O, var4).a(a, var2).a(b, var3);
   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      if (!var4.bA.e) {
         return false;
      } else {
         var3 = var3.a(b);
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D, "random.click", 0.3F, var3.b(b) == afx.a.b ? 0.55F : 0.5F);
         var1.a((cj)var2, (alz)var3, 2);
         this.k(var1, var2, var3);
         return true;
      }
   }

   public void b(adm var1, cj var2, alz var3) {
      super.b(var1, var2, var3);
      var1.t(var2);
      this.h(var1, var2, var3);
   }

   protected void g(adm var1, cj var2, alz var3) {
      if (!var1.a((cj)var2, (afh)this)) {
         int var4 = this.j(var1, var2, var3);
         akw var5 = var1.s(var2);
         int var6 = var5 instanceof ala ? ((ala)var5).b() : 0;
         if (var4 != var6 || this.l(var3) != this.e(var1, var2, var3)) {
            if (this.i(var1, var2, var3)) {
               var1.a(var2, this, 2, -1);
            } else {
               var1.a(var2, this, 2, 0);
            }
         }

      }
   }

   public void c(adm var1, cj var2, alz var3) {
      super.c(var1, var2, var3);
      var1.a(var2, this.a(var1, 0));
   }

   protected ama e() {
      return new ama(this, new amo[]{O, b, a});
   }

   public afx(boolean var1) {
      super(var1);
      this.j(this.M.b().a(O, cq.c).a(a, false).a(b, afx.a.a));
      this.A = true;
   }

   protected int a(adq var1, cj var2, alz var3) {
      akw var4 = var1.s(var2);
      return var4 instanceof ala ? ((ala)var4).b() : 0;
   }

   protected boolean l(alz var1) {
      return this.N || (Boolean)var1.b(a);
   }

   private int j(adm var1, cj var2, alz var3) {
      return var3.b(b) == afx.a.b ? Math.max(this.f(var1, var2, var3) - this.c(var1, var2, var3), 0) : this.f(var1, var2, var3);
   }

   private uo a(adm var1, cq var2, cj var3) {
      List var4 = var1.a(uo.class, new aug((double)var3.n(), (double)var3.o(), (double)var3.p(), (double)(var3.n() + 1), (double)(var3.o() + 1), (double)(var3.p() + 1)), new Predicate<pk>(this, var2) {
         final cq a;
         final afx b;

         public boolean apply(Object var1) {
            return this.a((pk)var1);
         }

         public boolean a(pk var1) {
            return var1 != null && var1.aP() == this.a;
         }

         {
            this.b = var1;
            this.a = var2;
         }
      });
      return var4.size() == 1 ? (uo)var4.get(0) : null;
   }

   protected int f(adm var1, cj var2, alz var3) {
      int var4 = super.f(var1, var2, var3);
      cq var5 = (cq)var3.b(O);
      cj var6 = var2.a(var5);
      afh var7 = var1.p(var6).c();
      if (var7.O()) {
         var4 = var7.l(var1, var6);
      } else if (var4 < 15 && var7.v()) {
         var6 = var6.a(var5);
         var7 = var1.p(var6).c();
         if (var7.O()) {
            var4 = var7.l(var1, var6);
         } else if (var7.t() == arm.a) {
            uo var8 = this.a(var1, var5, var6);
            if (var8 != null) {
               var4 = var8.q();
            }
         }
      }

      return var4;
   }

   public int c(alz var1) {
      byte var2 = 0;
      int var3 = var2 | ((cq)var1.b(O)).b();
      if ((Boolean)var1.b(a)) {
         var3 |= 8;
      }

      if (var1.b(b) == afx.a.b) {
         var3 |= 4;
      }

      return var3;
   }

   protected alz k(alz var1) {
      Boolean var2 = (Boolean)var1.b(a);
      afx.a var3 = (afx.a)var1.b(b);
      cq var4 = (cq)var1.b(O);
      return afi.cj.Q().a(O, var4).a(a, var2).a(b, var3);
   }

   protected boolean e(adm var1, cj var2, alz var3) {
      int var4 = this.f(var1, var2, var3);
      if (var4 >= 15) {
         return true;
      } else if (var4 == 0) {
         return false;
      } else {
         int var5 = this.c(var1, var2, var3);
         if (var5 == 0) {
            return true;
         } else {
            return var4 >= var5;
         }
      }
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      if (this.N) {
         var1.a((cj)var2, (alz)this.k(var3).a(a, true), 4);
      }

      this.k(var1, var2, var3);
   }

   public zw c(adm var1, cj var2) {
      return zy.ce;
   }

   public zw a(alz var1, Random var2, int var3) {
      return zy.ce;
   }

   public alz a(int var1) {
      return this.Q().a(O, cq.b(var1)).a(a, (var1 & 8) > 0).a(b, (var1 & 4) > 0 ? afx.a.b : afx.a.a);
   }

   public static enum a implements nw {
      private static final afx.a[] d = new afx.a[]{a, b};
      b("subtract"),
      a("compare");

      private final String c;

      private a(String var3) {
         this.c = var3;
      }

      public String l() {
         return this.c;
      }

      public String toString() {
         return this.c;
      }
   }
}
