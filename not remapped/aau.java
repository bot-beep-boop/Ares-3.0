public class aau extends yo {
   private final ahh b;
   private final ahh c;

   public boolean a(adm var1, cj var2, cq var3, wn var4, zx var5) {
      cj var6 = var2;
      amo var7 = this.b.n();
      Object var8 = this.b.a(var5);
      alz var9 = var1.p(var2);
      if (var9.c() == this.b) {
         boolean var10 = var9.b(ahh.a) == ahh.a.a;
         if ((var3 == cq.b && !var10 || var3 == cq.a && var10) && var8 == var9.b(var7)) {
            return true;
         }
      }

      var2 = var2.a(var3);
      alz var11 = var1.p(var2);
      return var11.c() == this.b && var8 == var11.b(var7) ? true : super.a(var1, var6, var3, var4, var5);
   }

   public boolean a(zx var1, wn var2, adm var3, cj var4, cq var5, float var6, float var7, float var8) {
      if (var1.b == 0) {
         return false;
      } else if (!var2.a(var4.a(var5), var5, var1)) {
         return false;
      } else {
         Object var9 = this.b.a(var1);
         alz var10 = var3.p(var4);
         if (var10.c() == this.b) {
            amo var11 = this.b.n();
            Comparable var12 = var10.b(var11);
            ahh.a var13 = (ahh.a)var10.b(ahh.a);
            if ((var5 == cq.b && var13 == ahh.a.b || var5 == cq.a && var13 == ahh.a.a) && var12 == var9) {
               alz var14 = this.c.Q().a(var11, var12);
               if (var3.b(this.c.a(var3, var4, var14)) && var3.a((cj)var4, (alz)var14, 3)) {
                  var3.a((double)((float)var4.n() + 0.5F), (double)((float)var4.o() + 0.5F), (double)((float)var4.p() + 0.5F), this.c.H.b(), (this.c.H.d() + 1.0F) / 2.0F, this.c.H.e() * 0.8F);
                  --var1.b;
               }

               return true;
            }
         }

         return this.a(var1, var3, var4.a(var5), var9) ? true : super.a(var1, var2, var3, var4, var5, var6, var7, var8);
      }
   }

   public String e_(zx var1) {
      return this.b.b(var1.i());
   }

   public aau(afh var1, ahh var2, ahh var3) {
      super(var1);
      this.b = var2;
      this.c = var3;
      this.d(0);
      this.a(true);
   }

   public int a(int var1) {
      return var1;
   }

   private boolean a(zx var1, adm var2, cj var3, Object var4) {
      alz var5 = var2.p(var3);
      if (var5.c() == this.b) {
         Comparable var6 = var5.b(this.b.n());
         if (var6 == var4) {
            alz var7 = this.c.Q().a(this.b.n(), var6);
            if (var2.b(this.c.a(var2, var3, var7)) && var2.a((cj)var3, (alz)var7, 3)) {
               var2.a((double)((float)var3.n() + 0.5F), (double)((float)var3.o() + 0.5F), (double)((float)var3.p() + 0.5F), this.c.H.b(), (this.c.H.d() + 1.0F) / 2.0F, this.c.H.e() * 0.8F);
               --var1.b;
            }

            return true;
         }
      }

      return false;
   }
}
