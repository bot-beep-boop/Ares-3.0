public class ahj extends afh {
   private boolean a;

   public boolean a(adq var1, cj var2, cq var3) {
      alz var4 = var1.p(var2);
      afh var5 = var4.c();
      if (this == afi.w || this == afi.cG) {
         if (var1.p(var2.a(var3.d())) != var4) {
            return true;
         }

         if (var5 == this) {
            return false;
         }
      }

      return !this.a && var5 == this ? false : super.a(var1, var2, var3);
   }

   protected ahj(arm var1, boolean var2) {
      this(var1, var2, var1.r());
   }

   protected ahj(arm var1, boolean var2, arn var3) {
      super(var1, var3);
      this.a = var2;
   }

   public boolean c() {
      return false;
   }
}
