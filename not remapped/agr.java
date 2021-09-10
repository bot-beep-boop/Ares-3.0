import java.util.Random;

public class agr extends afh {
   public static boolean N;

   public agr(arm var1) {
      super(var1);
   }

   public void c(adm var1, cj var2, alz var3) {
      var1.a((cj)var2, (afh)this, this.a(var1));
   }

   private void f(adm var1, cj var2) {
      if (e(var1, var2.b()) && var2.o() >= 0) {
         byte var3 = 32;
         if (!N && var1.a(var2.a(-var3, -var3, -var3), var2.a(var3, var3, var3))) {
            if (!var1.D) {
               uy var5 = new uy(var1, (double)var2.n() + 0.5D, (double)var2.o(), (double)var2.p() + 0.5D, var1.p(var2));
               this.a(var5);
               var1.d((pk)var5);
            }
         } else {
            var1.g(var2);

            cj var4;
            for(var4 = var2.b(); e(var1, var4) && var4.o() > 0; var4 = var4.b()) {
            }

            if (var4.o() > 0) {
               var1.a(var4.a(), this.Q());
            }
         }

      }
   }

   protected void a(uy var1) {
   }

   public agr() {
      super(arm.p);
      this.a((yz)yz.b);
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      if (!var1.D) {
         this.f(var1, var2);
      }

   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      var1.a((cj)var2, (afh)this, this.a(var1));
   }

   public void a_(adm var1, cj var2) {
   }

   public static boolean e(adm var0, cj var1) {
      afh var2 = var0.p(var1).c();
      arm var3 = var2.J;
      return var2 == afi.ab || var3 == arm.a || var3 == arm.h || var3 == arm.i;
   }

   public int a(adm var1) {
      return 2;
   }
}
