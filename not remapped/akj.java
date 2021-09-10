import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.Random;

public class akj extends afh {
   public static final amk N;
   public static final amk O;
   public static final amk b;
   public static final aml a;

   public int b(adq var1, cj var2, alz var3, cq var4) {
      if (!(Boolean)var3.b(b)) {
         return 0;
      } else {
         return var3.b(a) == var4 ? 15 : 0;
      }
   }

   public akj() {
      super(arm.q);
      this.j(this.M.b().a(a, cq.c).a(b, false).a(N, false).a(O, false));
      this.a(yz.d);
      this.a(true);
   }

   public adf m() {
      return adf.b;
   }

   public int a(adq var1, cj var2, alz var3, cq var4) {
      return (Boolean)var3.b(b) ? 15 : 0;
   }

   protected ama e() {
      return new ama(this, new amo[]{a, b, N, O});
   }

   static {
      a = aml.a("facing", (Predicate)cq.c.a);
      b = amk.a("powered");
      N = amk.a("attached");
      O = amk.a("suspended");
   }

   public void b(adm var1, cj var2, alz var3) {
      boolean var4 = (Boolean)var3.b(N);
      boolean var5 = (Boolean)var3.b(b);
      if (var4 || var5) {
         this.a(var1, var2, var3, true, false, -1, (alz)null);
      }

      if (var5) {
         var1.c((cj)var2, (afh)this);
         var1.c((cj)var2.a(((cq)var3.b(a)).d()), (afh)this);
      }

      super.b(var1, var2, var3);
   }

   public boolean i() {
      return true;
   }

   public void a(adm var1, cj var2, alz var3, pr var4, zx var5) {
      this.a(var1, var2, var3, false, false, -1, (alz)null);
   }

   public int c(alz var1) {
      byte var2 = 0;
      int var3 = var2 | ((cq)var1.b(a)).b();
      if ((Boolean)var1.b(b)) {
         var3 |= 8;
      }

      if ((Boolean)var1.b(N)) {
         var3 |= 4;
      }

      return var3;
   }

   public aug a(adm var1, cj var2, alz var3) {
      return null;
   }

   public boolean d() {
      return false;
   }

   private void a(adm var1, cj var2, boolean var3, boolean var4, boolean var5, boolean var6) {
      if (var4 && !var6) {
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.1D, (double)var2.p() + 0.5D, "random.click", 0.4F, 0.6F);
      } else if (!var4 && var6) {
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.1D, (double)var2.p() + 0.5D, "random.click", 0.4F, 0.5F);
      } else if (var3 && !var5) {
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.1D, (double)var2.p() + 0.5D, "random.click", 0.4F, 0.7F);
      } else if (!var3 && var5) {
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.1D, (double)var2.p() + 0.5D, "random.bowhit", 0.4F, 1.2F / (var1.s.nextFloat() * 0.2F + 0.9F));
      }

   }

   private void a(adm var1, cj var2, cq var3) {
      var1.c((cj)var2, (afh)this);
      var1.c((cj)var2.a(var3.d()), (afh)this);
   }

   private boolean e(adm var1, cj var2, alz var3) {
      if (!this.d(var1, var2)) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
         return false;
      } else {
         return true;
      }
   }

   public alz a(alz var1, adq var2, cj var3) {
      return var1.a(O, !adm.a(var2, var3.b()));
   }

   public void a(adm var1, cj var2, alz var3, boolean var4, boolean var5, int var6, alz var7) {
      cq var8 = (cq)var3.b(a);
      boolean var9 = (Boolean)var3.b(N);
      boolean var10 = (Boolean)var3.b(b);
      boolean var11 = !adm.a((adq)var1, (cj)var2.b());
      boolean var12 = !var4;
      boolean var13 = false;
      int var14 = 0;
      alz[] var15 = new alz[42];

      cj var17;
      for(int var16 = 1; var16 < 42; ++var16) {
         var17 = var2.a(var8, var16);
         alz var18 = var1.p(var17);
         if (var18.c() == afi.bR) {
            if (var18.b(a) == var8.d()) {
               var14 = var16;
            }
            break;
         }

         if (var18.c() != afi.bS && var16 != var6) {
            var15[var16] = null;
            var12 = false;
         } else {
            if (var16 == var6) {
               var18 = (alz)Objects.firstNonNull(var7, var18);
            }

            boolean var19 = !(Boolean)var18.b(aki.O);
            boolean var20 = (Boolean)var18.b(aki.a);
            boolean var21 = (Boolean)var18.b(aki.b);
            var12 &= var21 == var11;
            var13 |= var19 && var20;
            var15[var16] = var18;
            if (var16 == var6) {
               var1.a((cj)var2, (afh)this, this.a(var1));
               var12 &= var19;
            }
         }
      }

      var12 &= var14 > 1;
      var13 &= var12;
      alz var22 = this.Q().a(N, var12).a(b, var13);
      if (var14 > 0) {
         var17 = var2.a(var8, var14);
         cq var24 = var8.d();
         var1.a((cj)var17, (alz)var22.a(a, var24), 3);
         this.a(var1, var17, var24);
         this.a(var1, var17, var12, var13, var9, var10);
      }

      this.a(var1, var2, var12, var13, var9, var10);
      if (!var4) {
         var1.a((cj)var2, (alz)var22.a(a, var8), 3);
         if (var5) {
            this.a(var1, var2, var8);
         }
      }

      if (var9 != var12) {
         for(int var23 = 1; var23 < var14; ++var23) {
            cj var25 = var2.a(var8, var23);
            alz var26 = var15[var23];
            if (var26 != null && var1.p(var25).c() != afi.a) {
               var1.a((cj)var25, (alz)var26.a(N, var12), 3);
            }
         }
      }

   }

   public boolean b(adm var1, cj var2, cq var3) {
      return var3.k().c() && var1.p(var2.a(var3.d())).c().v();
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      if (var4 != this) {
         if (this.e(var1, var2, var3)) {
            cq var5 = (cq)var3.b(a);
            if (!var1.p(var2.a(var5.d())).c().v()) {
               this.b(var1, var2, var3, 0);
               var1.g(var2);
            }
         }

      }
   }

   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      alz var9 = this.Q().a(b, false).a(N, false).a(O, false);
      if (var3.k().c()) {
         var9 = var9.a(a, var3);
      }

      return var9;
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      this.a(var1, var2, var3, false, true, -1, (alz)null);
   }

   public void a(adm var1, cj var2, alz var3, Random var4) {
   }

   public void a(adq var1, cj var2) {
      float var3 = 0.1875F;
      switch((cq)var1.p(var2).b(a)) {
      case f:
         this.a(0.0F, 0.2F, 0.5F - var3, var3 * 2.0F, 0.8F, 0.5F + var3);
         break;
      case e:
         this.a(1.0F - var3 * 2.0F, 0.2F, 0.5F - var3, 1.0F, 0.8F, 0.5F + var3);
         break;
      case d:
         this.a(0.5F - var3, 0.2F, 0.0F, 0.5F + var3, 0.8F, var3 * 2.0F);
         break;
      case c:
         this.a(0.5F - var3, 0.2F, 1.0F - var3 * 2.0F, 0.5F + var3, 0.8F, 1.0F);
      }

   }

   public alz a(int var1) {
      return this.Q().a(a, cq.b(var1 & 3)).a(b, (var1 & 8) > 0).a(N, (var1 & 4) > 0);
   }

   public boolean c() {
      return false;
   }

   public boolean d(adm var1, cj var2) {
      Iterator var3 = cq.c.a.iterator();

      cq var4;
      do {
         if (!var3.hasNext()) {
            return false;
         }

         var4 = (cq)var3.next();
      } while(!var1.p(var2.a(var4)).c().v());

      return true;
   }
}
