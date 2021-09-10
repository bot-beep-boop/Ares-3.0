public class sr extends st {
   pr b;
   qa a;
   private int c;

   public boolean a() {
      if (!this.a.cl()) {
         return false;
      } else {
         pr var1 = this.a.co();
         if (var1 == null) {
            return false;
         } else {
            this.b = var1.bd();
            int var2 = var1.be();
            return var2 != this.c && this.a(this.b, false) && this.a.a(this.b, var1);
         }
      }
   }

   public void c() {
      this.e.d(this.b);
      pr var1 = this.a.co();
      if (var1 != null) {
         this.c = var1.be();
      }

      super.c();
   }

   public sr(qa var1) {
      super(var1, false);
      this.a = var1;
      this.a(1);
   }
}
