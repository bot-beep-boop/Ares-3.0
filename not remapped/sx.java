public class sx extends sv {
   private cj f;

   public asx a(cj var1) {
      this.f = var1;
      return super.a(var1);
   }

   public boolean a(pk var1, double var2) {
      asx var4 = this.a(var1);
      if (var4 != null) {
         return this.a(var4, var2);
      } else {
         this.f = new cj(var1);
         this.e = var2;
         return true;
      }
   }

   public asx a(pk var1) {
      this.f = new cj(var1);
      return super.a(var1);
   }

   public sx(ps var1, adm var2) {
      super(var1, var2);
   }

   public void k() {
      if (!this.m()) {
         super.k();
      } else {
         if (this.f != null) {
            double var1 = (double)(this.b.J * this.b.J);
            if (!(this.b.c(this.f) < var1) && (!(this.b.t > (double)this.f.o()) || !(this.b.c(new cj(this.f.n(), ns.c(this.b.t), this.f.p())) < var1))) {
               this.b.q().a((double)this.f.n(), (double)this.f.o(), (double)this.f.p(), this.e);
            } else {
               this.f = null;
            }
         }

      }
   }
}
