public class bmp extends bmi {
   public static String l;
   public double j;
   public double k;

   public void a(adm var1, double var2, double var4, double var6, boolean var8, boolean var9) {
      if (!this.a.isEmpty()) {
         double var10 = 0.0D;
         if (var1 != null && !var8) {
            cj var12 = var1.M();
            double var13 = (double)var12.n() - var2;
            double var15 = (double)var12.p() - var4;
            var6 %= 360.0D;
            var10 = -((var6 - 90.0D) * 3.141592653589793D / 180.0D - Math.atan2(var15, var13));
            if (!var1.t.d()) {
               var10 = Math.random() * 3.1415927410125732D * 2.0D;
            }
         }

         if (var9) {
            this.j = var10;
         } else {
            double var17;
            for(var17 = var10 - this.j; var17 < -3.141592653589793D; var17 += 6.283185307179586D) {
            }

            while(var17 >= 3.141592653589793D) {
               var17 -= 6.283185307179586D;
            }

            var17 = ns.a(var17, -1.0D, 1.0D);
            this.k += var17 * 0.1D;
            this.k *= 0.8D;
            this.j += this.k;
         }

         int var18;
         for(var18 = (int)((this.j / 6.283185307179586D + 1.0D) * (double)this.a.size()) % this.a.size(); var18 < 0; var18 = (var18 + this.a.size()) % this.a.size()) {
         }

         if (var18 != this.h) {
            this.h = var18;
            bml.a((int[][])this.a.get(this.h), this.f, this.g, this.d, this.e, false, false);
         }

      }
   }

   public void j() {
      ave var1 = ave.A();
      if (var1.f != null && var1.h != null) {
         this.a(var1.f, var1.h.s, var1.h.u, (double)var1.h.y, false, false);
      } else {
         this.a((adm)null, 0.0D, 0.0D, 0.0D, true, false);
      }

   }

   public bmp(String var1) {
      super(var1);
      l = var1;
   }
}
