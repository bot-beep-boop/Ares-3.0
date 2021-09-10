public class xa extends wy {
   private pr c;

   protected void a(auh var1) {
      pr var2 = this.n();
      if (var1.d != null) {
         if (var1.d == this.c) {
            return;
         }

         var1.d.a(ow.a((pk)this, var2), 0.0F);
      }

      for(int var3 = 0; var3 < 32; ++var3) {
         this.o.a(cy.y, this.s, this.t + this.V.nextDouble() * 2.0D, this.u, this.V.nextGaussian(), 0.0D, this.V.nextGaussian());
      }

      if (!this.o.D) {
         if (var2 instanceof lf) {
            lf var5 = (lf)var2;
            if (var5.a.a().g() && var5.o == this.o && !var5.bJ()) {
               if (this.V.nextFloat() < 0.05F && this.o.Q().b("doMobSpawning")) {
                  vp var4 = new vp(this.o);
                  var4.a(true);
                  var4.b(var2.s, var2.t, var2.u, var2.y, var2.z);
                  this.o.d((pk)var4);
               }

               if (var2.au()) {
                  var2.a((pk)null);
               }

               var2.a(this.s, this.t, this.u);
               var2.O = 0.0F;
               var2.a(ow.i, 5.0F);
            }
         } else if (var2 != null) {
            var2.a(this.s, this.t, this.u);
            var2.O = 0.0F;
         }

         this.J();
      }

   }

   public xa(adm var1, pr var2) {
      super(var1, var2);
      this.c = var2;
   }

   public xa(adm var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   public xa(adm var1) {
      super(var1);
   }

   public void t_() {
      pr var1 = this.n();
      if (var1 != null && var1 instanceof wn && !var1.ai()) {
         this.J();
      } else {
         super.t_();
      }

   }
}
