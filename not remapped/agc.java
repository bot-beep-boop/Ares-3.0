import com.google.common.base.Predicate;
import java.util.List;
import java.util.Random;

public class agc extends afe {
   public static final amk N = amk.a("powered");
   public static final amm<afe.b> b = amm.a("shape", afe.b.class, new Predicate<afe.b>() {
      public boolean apply(Object var1) {
         return this.a((afe.b)var1);
      }

      public boolean a(afe.b var1) {
         return var1 != afe.b.j && var1 != afe.b.i && var1 != afe.b.g && var1 != afe.b.h;
      }
   });

   public int a(adm var1) {
      return 20;
   }

   private void e(adm var1, cj var2, alz var3) {
      boolean var4 = (Boolean)var3.b(N);
      boolean var5 = false;
      List var6 = this.a(var1, var2, va.class);
      if (!var6.isEmpty()) {
         var5 = true;
      }

      if (var5 && !var4) {
         var1.a((cj)var2, (alz)var3.a(N, true), 3);
         var1.c((cj)var2, (afh)this);
         var1.c((cj)var2.b(), (afh)this);
         var1.b(var2, var2);
      }

      if (!var5 && var4) {
         var1.a((cj)var2, (alz)var3.a(N, false), 3);
         var1.c((cj)var2, (afh)this);
         var1.c((cj)var2.b(), (afh)this);
         var1.b(var2, var2);
      }

      if (var5) {
         var1.a((cj)var2, (afh)this, this.a(var1));
      }

      var1.e(var2, this);
   }

   protected <T extends va> List<T> a(adm var1, cj var2, Class<T> var3, Predicate<pk>... var4) {
      aug var5 = this.a(var2);
      return var4.length != 1 ? var1.a(var3, var5) : var1.a(var3, var5, var4[0]);
   }

   private aug a(cj var1) {
      float var2 = 0.2F;
      return new aug((double)((float)var1.n() + 0.2F), (double)var1.o(), (double)((float)var1.p() + 0.2F), (double)((float)(var1.n() + 1) - 0.2F), (double)((float)(var1.o() + 1) - 0.2F), (double)((float)(var1.p() + 1) - 0.2F));
   }

   public void c(adm var1, cj var2, alz var3) {
      super.c(var1, var2, var3);
      this.e(var1, var2, var3);
   }

   public agc() {
      super(true);
      this.j(this.M.b().a(N, false).a(b, afe.b.a));
      this.a(true);
   }

   public int l(adm var1, cj var2) {
      if ((Boolean)var1.p(var2).b(N)) {
         List var3 = this.a(var1, var2, vc.class);
         if (!var3.isEmpty()) {
            return ((vc)var3.get(0)).j().j();
         }

         List var4 = this.a(var1, var2, va.class, po.c);
         if (!var4.isEmpty()) {
            return xi.b((og)var4.get(0));
         }
      }

      return 0;
   }

   public void a(adm var1, cj var2, alz var3, pk var4) {
      if (!var1.D) {
         if (!(Boolean)var3.b(N)) {
            this.e(var1, var2, var3);
         }
      }
   }

   public boolean O() {
      return true;
   }

   public alz a(int var1) {
      return this.Q().a(b, afe.b.a(var1 & 7)).a(N, (var1 & 8) > 0);
   }

   public boolean i() {
      return true;
   }

   public int a(adq var1, cj var2, alz var3, cq var4) {
      return (Boolean)var3.b(N) ? 15 : 0;
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      if (!var1.D && (Boolean)var3.b(N)) {
         this.e(var1, var2, var3);
      }
   }

   public void a(adm var1, cj var2, alz var3, Random var4) {
   }

   public amo<afe.b> n() {
      return b;
   }

   public int c(alz var1) {
      byte var2 = 0;
      int var3 = var2 | ((afe.b)var1.b(b)).a();
      if ((Boolean)var1.b(N)) {
         var3 |= 8;
      }

      return var3;
   }

   public int b(adq var1, cj var2, alz var3, cq var4) {
      if (!(Boolean)var3.b(N)) {
         return 0;
      } else {
         return var4 == cq.b ? 15 : 0;
      }
   }

   protected ama e() {
      return new ama(this, new amo[]{b, N});
   }
}
