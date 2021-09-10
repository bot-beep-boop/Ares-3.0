public class vm extends wc {
   public vm(adm var1) {
      super(var1);
      this.a(0.7F, 0.5F);
   }

   protected void aX() {
      super.aX();
      this.a(vy.a).a(12.0D);
   }

   public boolean r(pk var1) {
      if (super.r(var1)) {
         if (var1 instanceof pr) {
            byte var2 = 0;
            if (this.o.aa() == oj.c) {
               var2 = 7;
            } else if (this.o.aa() == oj.d) {
               var2 = 15;
            }

            if (var2 > 0) {
               ((pr)var1).c(new pf(pe.u.H, var2 * 20, 0));
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public float aS() {
      return 0.45F;
   }

   public pu a(ok var1, pu var2) {
      return var2;
   }
}
