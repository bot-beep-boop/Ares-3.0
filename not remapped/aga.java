import java.util.List;
import java.util.Random;

public class aga extends afc {
   public static final amn a = amn.a("power", 0, 15);
   private final boolean b;

   public void a(adq var1, cj var2) {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F);
   }

   public akw a(adm var1, int var2) {
      return new alb();
   }

   public int a(adq var1, cj var2, alz var3, cq var4) {
      return (Integer)var3.b(a);
   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      if (var4.cn()) {
         if (var1.D) {
            return true;
         } else {
            if (this.b) {
               var1.a((cj)var2, (alz)afi.cl.Q().a(a, var3.b(a)), 4);
               afi.cl.f(var1, var2);
            } else {
               var1.a((cj)var2, (alz)afi.cm.Q().a(a, var3.b(a)), 4);
               afi.cm.f(var1, var2);
            }

            return true;
         }
      } else {
         return super.a(var1, var2, var3, var4, var5, var6, var7, var8);
      }
   }

   public alz a(int var1) {
      return this.Q().a(a, var1);
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      if (!this.b) {
         super.a(var1, var2, var3);
      }

   }

   public aga(boolean var1) {
      super(arm.d);
      this.b = var1;
      this.j(this.M.b().a(a, 0));
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.375F, 1.0F);
      this.a(yz.d);
      this.c(0.2F);
      this.a(f);
      this.c("daylightDetector");
   }

   public boolean d() {
      return false;
   }

   public boolean c() {
      return false;
   }

   public int c(alz var1) {
      return (Integer)var1.b(a);
   }

   public boolean i() {
      return true;
   }

   public void f(adm var1, cj var2) {
      if (!var1.t.o()) {
         alz var3 = var1.p(var2);
         int var4 = var1.b(ads.a, var2) - var1.ab();
         float var5 = var1.d(1.0F);
         float var6 = var5 < 3.1415927F ? 0.0F : 6.2831855F;
         var5 += (var6 - var5) * 0.2F;
         var4 = Math.round((float)var4 * ns.b(var5));
         var4 = ns.a(var4, 0, 15);
         if (this.b) {
            var4 = 15 - var4;
         }

         if ((Integer)var3.b(a) != var4) {
            var1.a((cj)var2, (alz)var3.a(a, var4), 3);
         }

      }
   }

   public int b() {
      return 3;
   }

   public zw a(alz var1, Random var2, int var3) {
      return zw.a((afh)afi.cl);
   }

   public zw c(adm var1, cj var2) {
      return zw.a((afh)afi.cl);
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }
}
