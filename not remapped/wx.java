public class wx extends wy {
   protected void a(auh var1) {
      if (var1.d != null) {
         byte var2 = 0;
         if (var1.d instanceof vl) {
            var2 = 3;
         }

         var1.d.a(ow.a((pk)this, this.n()), (float)var2);
      }

      for(int var3 = 0; var3 < 8; ++var3) {
         this.o.a(cy.F, this.s, this.t, this.u, 0.0D, 0.0D, 0.0D);
      }

      if (!this.o.D) {
         this.J();
      }

   }

   public wx(adm var1) {
      super(var1);
   }

   public wx(adm var1, pr var2) {
      super(var1, var2);
   }

   public wx(adm var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }
}
