public class aam extends zw {
   public boolean a(zx var1, wn var2, pr var3) {
      if (var3 instanceof tt) {
         tt var4 = (tt)var3;
         if (!var4.cl() && !var4.j_()) {
            var4.l(true);
            var4.o.a((pk)var4, "mob.horse.leather", 0.5F, 1.0F);
            --var1.b;
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean a(zx var1, pr var2, pr var3) {
      this.a(var1, (wn)null, var2);
      return true;
   }

   public aam() {
      this.h = 1;
      this.a(yz.e);
   }
}
