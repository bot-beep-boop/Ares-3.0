public class wz extends wy {
   public wz(adm var1, pr var2) {
      super(var1, var2);
   }

   public wz(adm var1) {
      super(var1);
   }

   protected void a(auh var1) {
      if (var1.d != null) {
         var1.d.a(ow.a((pk)this, this.n()), 0.0F);
      }

      if (!this.o.D && this.V.nextInt(8) == 0) {
         byte var2 = 1;
         if (this.V.nextInt(32) == 0) {
            var2 = 4;
         }

         for(int var3 = 0; var3 < var2; ++var3) {
            tn var4 = new tn(this.o);
            var4.b(-24000);
            var4.b(this.s, this.t, this.u, this.y, 0.0F);
            this.o.d((pk)var4);
         }
      }

      double var5 = 0.08D;

      for(int var6 = 0; var6 < 8; ++var6) {
         this.o.a(cy.K, this.s, this.t, this.u, ((double)this.V.nextFloat() - 0.5D) * 0.08D, ((double)this.V.nextFloat() - 0.5D) * 0.08D, ((double)this.V.nextFloat() - 0.5D) * 0.08D, zw.b(zy.aP));
      }

      if (!this.o.D) {
         this.J();
      }

   }

   public wz(adm var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }
}
