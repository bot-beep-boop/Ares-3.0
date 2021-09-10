public class rh extends rd {
   float c;
   pr b;
   ps a;

   public void c() {
      double var1 = this.b.s - this.a.s;
      double var3 = this.b.u - this.a.u;
      float var5 = ns.a(var1 * var1 + var3 * var3);
      ps var10000 = this.a;
      var10000.v += var1 / (double)var5 * 0.5D * 0.800000011920929D + this.a.v * 0.20000000298023224D;
      var10000 = this.a;
      var10000.x += var3 / (double)var5 * 0.5D * 0.800000011920929D + this.a.x * 0.20000000298023224D;
      this.a.w = (double)this.c;
   }

   public boolean a() {
      this.b = this.a.u();
      if (this.b == null) {
         return false;
      } else {
         double var1 = this.a.h(this.b);
         if (!(var1 < 4.0D) && !(var1 > 16.0D)) {
            if (!this.a.C) {
               return false;
            } else {
               return this.a.bc().nextInt(5) == 0;
            }
         } else {
            return false;
         }
      }
   }

   public boolean b() {
      return !this.a.C;
   }

   public rh(ps var1, float var2) {
      this.a = var1;
      this.c = var2;
      this.a(5);
   }
}
