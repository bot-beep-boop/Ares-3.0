public class ss extends st {
   qa a;
   pr b;
   private int c;

   public ss(qa var1) {
      super(var1, false);
      this.a = var1;
      this.a(1);
   }

   public void c() {
      this.e.d(this.b);
      pr var1 = this.a.co();
      if (var1 != null) {
         this.c = var1.bg();
      }

      super.c();
   }

   public boolean a() {
      if (!this.a.cl()) {
         return false;
      } else {
         pr var1 = this.a.co();
         if (var1 == null) {
            return false;
         } else {
            this.b = var1.bf();
            int var2 = var1.bg();
            return var2 != this.c && this.a(this.b, false) && this.a.a(this.b, var1);
         }
      }
   }
}
