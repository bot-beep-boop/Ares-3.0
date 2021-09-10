public class tr extends to {
   public to b(ph var1) {
      return this.c(var1);
   }

   public ph a(ph var1) {
      return this.c(var1);
   }

   public tr(adm var1) {
      super(var1);
      this.a(0.9F, 1.3F);
      this.bn = afi.bw;
   }

   public tr c(ph var1) {
      return new tr(this.o);
   }

   public boolean a(wn var1) {
      zx var2 = var1.bi.h();
      if (var2 != null && var2.b() == zy.z && this.l() >= 0) {
         if (var2.b == 1) {
            var1.bi.a(var1.bi.c, new zx(zy.A));
            return true;
         }

         if (var1.bi.a(new zx(zy.A)) && !var1.bA.d) {
            var1.bi.a(var1.bi.c, 1);
            return true;
         }
      }

      if (var2 != null && var2.b() == zy.be && this.l() >= 0) {
         this.J();
         this.o.a(cy.b, this.s, this.t + (double)(this.K / 2.0F), this.u, 0.0D, 0.0D, 0.0D);
         if (!this.o.D) {
            to var3 = new to(this.o);
            var3.b(this.s, this.t, this.u, this.y, this.z);
            var3.i(this.bn());
            var3.aI = this.aI;
            if (this.l_()) {
               var3.a((String)this.aM());
            }

            this.o.d((pk)var3);

            for(int var4 = 0; var4 < 5; ++var4) {
               this.o.d((pk)(new uz(this.o, this.s, this.t + (double)this.K, this.u, new zx(afi.Q))));
            }

            var2.a(1, (pr)var1);
            this.a("mob.sheep.shear", 1.0F, 1.0F);
         }

         return true;
      } else {
         return super.a(var1);
      }
   }
}
