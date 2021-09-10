import java.util.Random;

public class ajw extends ahv {
   protected ajw(arm var1) {
      super(var1);
      this.a(false);
      if (var1 == arm.i) {
         this.a(true);
      }

   }

   protected boolean f(adm var1, cj var2) {
      cq[] var3 = cq.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         cq var6 = var3[var5];
         if (this.m(var1, var2.a(var6))) {
            return true;
         }
      }

      return false;
   }

   private boolean m(adm var1, cj var2) {
      return var1.p(var2).c().t().h();
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      if (this.J == arm.i) {
         if (var1.Q().b("doFireTick")) {
            int var5 = var4.nextInt(3);
            if (var5 > 0) {
               cj var6 = var2;

               for(int var7 = 0; var7 < var5; ++var7) {
                  var6 = var6.a(var4.nextInt(3) - 1, 1, var4.nextInt(3) - 1);
                  afh var8 = var1.p(var6).c();
                  if (var8.J == arm.a) {
                     if (this.f(var1, var6)) {
                        var1.a(var6, afi.ab.Q());
                        return;
                     }
                  } else if (var8.J.c()) {
                     return;
                  }
               }
            } else {
               for(int var9 = 0; var9 < 3; ++var9) {
                  cj var10 = var2.a(var4.nextInt(3) - 1, 0, var4.nextInt(3) - 1);
                  if (var1.d(var10.a()) && this.m(var1, var10)) {
                     var1.a(var10.a(), afi.ab.Q());
                  }
               }
            }

         }
      }
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      if (!this.e(var1, var2, var3)) {
         this.f(var1, var2, var3);
      }

   }

   private void f(adm var1, cj var2, alz var3) {
      agl var4 = a(this.J);
      var1.a((cj)var2, (alz)var4.Q().a(b, var3.b(b)), 2);
      var1.a((cj)var2, (afh)var4, this.a(var1));
   }
}
