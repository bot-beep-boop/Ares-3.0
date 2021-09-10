public class aad extends zw {
   private static final cr a = new cn() {
      private final cn b = new cn();

      public zx b(ck var1, zx var2) {
         cq var3 = agg.b(var1.f());
         adm var4 = var1.i();
         double var5 = var1.a() + (double)var3.g() * 1.125D;
         double var7 = Math.floor(var1.b()) + (double)var3.h();
         double var9 = var1.c() + (double)var3.i() * 1.125D;
         cj var11 = var1.d().a(var3);
         alz var12 = var4.p(var11);
         afe.b var13 = var12.c() instanceof afe ? (afe.b)var12.b(((afe)var12.c()).n()) : afe.b.a;
         double var14;
         if (afe.d(var12)) {
            if (var13.c()) {
               var14 = 0.6D;
            } else {
               var14 = 0.1D;
            }
         } else {
            if (var12.c().t() != arm.a || !afe.d(var4.p(var11.b()))) {
               return this.b.a(var1, var2);
            }

            alz var16 = var4.p(var11.b());
            afe.b var17 = var16.c() instanceof afe ? (afe.b)var16.b(((afe)var16.c()).n()) : afe.b.a;
            if (var3 != cq.a && var17.c()) {
               var14 = -0.4D;
            } else {
               var14 = -0.9D;
            }
         }

         va var18 = va.a(var4, var5, var7 + var14, var9, aad.a((aad)var2.b()));
         if (var2.s()) {
            var18.a(var2.q());
         }

         var4.d((pk)var18);
         var2.a(1);
         return var2;
      }

      protected void a(ck var1) {
         var1.i().b(1000, var1.d(), 0);
      }
   };
   private final va.a b;

   public boolean a(zx var1, wn var2, adm var3, cj var4, cq var5, float var6, float var7, float var8) {
      alz var9 = var3.p(var4);
      if (afe.d(var9)) {
         if (!var3.D) {
            afe.b var10 = var9.c() instanceof afe ? (afe.b)var9.b(((afe)var9.c()).n()) : afe.b.a;
            double var11 = 0.0D;
            if (var10.c()) {
               var11 = 0.5D;
            }

            va var13 = va.a(var3, (double)var4.n() + 0.5D, (double)var4.o() + 0.0625D + var11, (double)var4.p() + 0.5D, this.b);
            if (var1.s()) {
               var13.a(var1.q());
            }

            var3.d((pk)var13);
         }

         --var1.b;
         return true;
      } else {
         return false;
      }
   }

   static va.a a(aad var0) {
      return var0.b;
   }

   public aad(va.a var1) {
      this.h = 1;
      this.b = var1;
      this.a(yz.e);
      agg.N.a(this, a);
   }
}
