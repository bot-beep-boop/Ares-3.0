public class zb extends zw {
   private afh a;

   public zb(afh var1) {
      this.a = var1;
      this.a(yz.d);
   }

   public static void a(adm var0, cj var1, cq var2, afh var3) {
      cj var4 = var1.a(var2.e());
      cj var5 = var1.a(var2.f());
      int var6 = (var0.p(var5).c().v() ? 1 : 0) + (var0.p(var5.a()).c().v() ? 1 : 0);
      int var7 = (var0.p(var4).c().v() ? 1 : 0) + (var0.p(var4.a()).c().v() ? 1 : 0);
      boolean var8 = var0.p(var5).c() == var3 || var0.p(var5.a()).c() == var3;
      boolean var9 = var0.p(var4).c() == var3 || var0.p(var4.a()).c() == var3;
      boolean var10 = false;
      if (var8 && !var9 || var7 > var6) {
         var10 = true;
      }

      cj var11 = var1.a();
      alz var12 = var3.Q().a(agh.a, var2).a(agh.N, var10 ? agh.b.b : agh.b.a);
      var0.a((cj)var1, (alz)var12.a(agh.P, agh.a.b), 2);
      var0.a((cj)var11, (alz)var12.a(agh.P, agh.a.a), 2);
      var0.c(var1, var3);
      var0.c(var11, var3);
   }

   public boolean a(zx var1, wn var2, adm var3, cj var4, cq var5, float var6, float var7, float var8) {
      if (var5 != cq.b) {
         return false;
      } else {
         alz var9 = var3.p(var4);
         afh var10 = var9.c();
         if (!var10.a(var3, var4)) {
            var4 = var4.a(var5);
         }

         if (!var2.a(var4, var5, var1)) {
            return false;
         } else if (!this.a.d(var3, var4)) {
            return false;
         } else {
            a(var3, var4, cq.a((double)var2.y), this.a);
            --var1.b;
            return true;
         }
      }
   }
}
