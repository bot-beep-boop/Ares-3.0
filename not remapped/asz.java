public class asz extends asw {
   public void a(adq var1, pk var2) {
      super.a(var1, var2);
   }

   public asv a(pk var1) {
      return this.a(ns.c(var1.aR().a), ns.c(var1.aR().b + 0.5D), ns.c(var1.aR().c));
   }

   public asv a(pk var1, double var2, double var4, double var6) {
      return this.a(ns.c(var2 - (double)(var1.J / 2.0F)), ns.c(var4 + 0.5D), ns.c(var6 - (double)(var1.J / 2.0F)));
   }

   public int a(asv[] var1, pk var2, asv var3, asv var4, float var5) {
      int var6 = 0;
      cq[] var7 = cq.values();
      int var8 = var7.length;

      for(int var9 = 0; var9 < var8; ++var9) {
         cq var10 = var7[var9];
         asv var11 = this.a(var2, var3.a + var10.g(), var3.b + var10.h(), var3.c + var10.i());
         if (var11 != null && !var11.i && var11.a(var4) < var5) {
            var1[var6++] = var11;
         }
      }

      return var6;
   }

   private int b(pk var1, int var2, int var3, int var4) {
      cj.a var5 = new cj.a();

      for(int var6 = var2; var6 < var2 + this.c; ++var6) {
         for(int var7 = var3; var7 < var3 + this.d; ++var7) {
            for(int var8 = var4; var8 < var4 + this.e; ++var8) {
               afh var9 = this.a.p(var5.c(var6, var7, var8)).c();
               if (var9.t() != arm.h) {
                  return 0;
               }
            }
         }
      }

      return -1;
   }

   public void a() {
      super.a();
   }

   private asv a(pk var1, int var2, int var3, int var4) {
      int var5 = this.b(var1, var2, var3, var4);
      return var5 == -1 ? this.a(var2, var3, var4) : null;
   }
}
