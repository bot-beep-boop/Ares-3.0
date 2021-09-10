public class sd extends rd {
   private double e;
   private tp a;
   private double c;
   private double d;
   private double b;

   public sd(tp var1, double var2) {
      this.a = var1;
      this.b = var2;
      this.a(1);
   }

   public boolean a() {
      if (!this.a.co() && this.a.l != null) {
         aui var1 = tc.a(this.a, 5, 4);
         if (var1 == null) {
            return false;
         } else {
            this.c = var1.a;
            this.d = var1.b;
            this.e = var1.c;
            return true;
         }
      } else {
         return false;
      }
   }

   public boolean b() {
      return !this.a.s().m() && this.a.l != null;
   }

   public void e() {
      if (this.a.bc().nextInt(50) == 0) {
         if (this.a.l instanceof wn) {
            int var1 = this.a.cC();
            int var2 = this.a.cI();
            if (var2 > 0 && this.a.bc().nextInt(var2) < var1) {
               this.a.h((wn)this.a.l);
               this.a.o.a((pk)this.a, (byte)7);
               return;
            }

            this.a.u(5);
         }

         this.a.l.a((pk)null);
         this.a.l = null;
         this.a.cW();
         this.a.o.a((pk)this.a, (byte)6);
      }

   }

   public void c() {
      this.a.s().a(this.c, this.d, this.e, this.b);
   }
}
