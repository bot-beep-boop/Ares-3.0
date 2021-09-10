public class bmo extends bmi {
   private double j;
   private double k;

   public bmo(String var1) {
      super(var1);
   }

   public void j() {
      if (!this.a.isEmpty()) {
         ave var1 = ave.A();
         double var2 = 0.0D;
         if (var1.f != null && var1.h != null) {
            var2 = (double)var1.f.c(1.0F);
            if (!var1.f.t.d()) {
               var2 = Math.random();
            }
         }

         double var4;
         for(var4 = var2 - this.j; var4 < -0.5D; ++var4) {
         }

         while(var4 >= 0.5D) {
            --var4;
         }

         var4 = ns.a(var4, -1.0D, 1.0D);
         this.k += var4 * 0.1D;
         this.k *= 0.8D;
         this.j += this.k;

         int var6;
         for(var6 = (int)((this.j + 1.0D) * (double)this.a.size()) % this.a.size(); var6 < 0; var6 = (var6 + this.a.size()) % this.a.size()) {
         }

         if (var6 != this.h) {
            this.h = var6;
            bml.a((int[][])this.a.get(this.h), this.f, this.g, this.d, this.e, false, false);
         }

      }
   }
}
