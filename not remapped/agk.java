public class agk extends agg {
   private final cr P = new cn();

   public akw a(adm var1, int var2) {
      return new ald();
   }

   protected cr a(zx var1) {
      return this.P;
   }

   protected void f(adm var1, cj var2) {
      cl var3 = new cl(var1, var2);
      alc var4 = (alc)var3.h();
      if (var4 != null) {
         int var5 = var4.m();
         if (var5 < 0) {
            var1.b(1001, var2, 0);
         } else {
            zx var6 = var4.a(var5);
            if (var6 != null) {
               cq var7 = (cq)var1.p(var2).b(a);
               cj var8 = var2.a(var7);
               og var9 = alj.b(var1, (double)var8.n(), (double)var8.o(), (double)var8.p());
               zx var10;
               if (var9 == null) {
                  var10 = this.P.a(var3, var6);
                  if (var10 != null && var10.b <= 0) {
                     var10 = null;
                  }
               } else {
                  var10 = alj.a(var9, var6.k().a(1), var7.d());
                  if (var10 == null) {
                     var10 = var6.k();
                     if (--var10.b <= 0) {
                        var10 = null;
                     }
                  } else {
                     var10 = var6.k();
                  }
               }

               var4.a(var5, var10);
            }
         }
      }
   }
}
