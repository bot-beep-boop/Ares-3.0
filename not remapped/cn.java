public class cn implements cr {
   protected void a(ck var1, cq var2) {
      var1.i().b(2000, var1.d(), this.a(var2));
   }

   private int a(cq var1) {
      return var1.g() + 1 + (var1.i() + 1) * 3;
   }

   protected zx b(ck var1, zx var2) {
      cq var3 = agg.b(var1.f());
      cz var4 = agg.a(var1);
      zx var5 = var2.a(1);
      a(var1.i(), var5, 6, var3, var4);
      return var2;
   }

   protected void a(ck var1) {
      var1.i().b(1000, var1.d(), 0);
   }

   public final zx a(ck var1, zx var2) {
      zx var3 = this.b(var1, var2);
      this.a(var1);
      this.a(var1, agg.b(var1.f()));
      return var3;
   }

   public static void a(adm var0, zx var1, int var2, cq var3, cz var4) {
      double var5 = var4.a();
      double var7 = var4.b();
      double var9 = var4.c();
      if (var3.k() == cq.a.b) {
         var7 -= 0.125D;
      } else {
         var7 -= 0.15625D;
      }

      uz var11 = new uz(var0, var5, var7, var9, var1);
      double var12 = var0.s.nextDouble() * 0.1D + 0.2D;
      var11.v = (double)var3.g() * var12;
      var11.w = 0.20000000298023224D;
      var11.x = (double)var3.i() * var12;
      var11.v += var0.s.nextGaussian() * 0.007499999832361937D * (double)var2;
      var11.w += var0.s.nextGaussian() * 0.007499999832361937D * (double)var2;
      var11.x += var0.s.nextGaussian() * 0.007499999832361937D * (double)var2;
      var0.d((pk)var11);
   }
}
