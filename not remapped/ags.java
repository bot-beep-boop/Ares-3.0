import java.util.Iterator;
import java.util.Random;

public class ags extends afh {
   public static final amn a = amn.a("moisture", 0, 7);

   private boolean e(adm var1, cj var2) {
      afh var3 = var1.p(var2.a()).c();
      return var3 instanceof afz || var3 instanceof ajx;
   }

   public zw c(adm var1, cj var2) {
      return zw.a(afi.d);
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public boolean a(adq var1, cj var2, cq var3) {
      switch(var3) {
      case b:
         return true;
      case c:
      case d:
      case e:
      case f:
         afh var4 = var1.p(var2).c();
         return !var4.c() && var4 != afi.ak;
      default:
         return super.a(var1, var2, var3);
      }
   }

   public void a(adm var1, cj var2, pk var3, float var4) {
      if (var3 instanceof pr) {
         if (!var1.D && var1.s.nextFloat() < var4 - 0.5F) {
            if (!(var3 instanceof wn) && !var1.Q().b("mobGriefing")) {
               return;
            }

            var1.a(var2, afi.d.Q());
         }

         super.a(var1, var2, var3, var4);
      }
   }

   protected ags() {
      super(arm.c);
      this.j(this.M.b().a(a, 0));
      this.a(true);
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
      this.e(255);
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   private boolean f(adm var1, cj var2) {
      Iterator var3 = cj.b(var2.a(-4, 0, -4), var2.a(4, 1, 4)).iterator();

      cj.a var4;
      do {
         if (!var3.hasNext()) {
            return false;
         }

         var4 = (cj.a)var3.next();
      } while(var1.p(var4).c().t() != arm.h);

      return true;
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      int var5 = (Integer)var3.b(a);
      if (!this.f(var1, var2) && !var1.C(var2.a())) {
         if (var5 > 0) {
            var1.a((cj)var2, (alz)var3.a(a, var5 - 1), 2);
         } else if (!this.e(var1, var2)) {
            var1.a(var2, afi.d.Q());
         }
      } else if (var5 < 7) {
         var1.a((cj)var2, (alz)var3.a(a, 7), 2);
      }

   }

   public alz a(int var1) {
      return this.Q().a(a, var1 & 7);
   }

   public int c(alz var1) {
      return (Integer)var1.b(a);
   }

   public aug a(adm var1, cj var2, alz var3) {
      return new aug((double)var2.n(), (double)var2.o(), (double)var2.p(), (double)(var2.n() + 1), (double)(var2.o() + 1), (double)(var2.p() + 1));
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      super.a(var1, var2, var3, var4);
      if (var1.p(var2.a()).c().t().a()) {
         var1.a(var2, afi.d.Q());
      }

   }

   public zw a(alz var1, Random var2, int var3) {
      return afi.d.a(afi.d.Q().a(agf.a, agf.a.a), var2, var3);
   }
}
