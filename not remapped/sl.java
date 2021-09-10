public class sl extends st {
   ty a;
   pr b;

   public void c() {
      this.a.d(this.b);
      super.c();
   }

   public sl(ty var1) {
      super(var1, false, true);
      this.a = var1;
      this.a(1);
   }

   public boolean a() {
      tf var1 = this.a.n();
      if (var1 == null) {
         return false;
      } else {
         this.b = var1.b((pr)this.a);
         if (this.b instanceof vn) {
            return false;
         } else if (!this.a(this.b, false)) {
            if (this.e.bc().nextInt(20) == 0) {
               this.b = var1.c((pr)this.a);
               return this.a(this.b, false);
            } else {
               return false;
            }
         } else {
            return true;
         }
      }
   }
}
