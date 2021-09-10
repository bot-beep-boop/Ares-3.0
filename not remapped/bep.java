public class bep extends beb {
   private int az;
   private int aA;
   private cy aB;
   private pk a;

   public int a() {
      return 3;
   }

   public void t_() {
      for(int var1 = 0; var1 < 16; ++var1) {
         double var2 = (double)(this.V.nextFloat() * 2.0F - 1.0F);
         double var4 = (double)(this.V.nextFloat() * 2.0F - 1.0F);
         double var6 = (double)(this.V.nextFloat() * 2.0F - 1.0F);
         if (!(var2 * var2 + var4 * var4 + var6 * var6 > 1.0D)) {
            double var8 = this.a.s + var2 * (double)this.a.J / 4.0D;
            double var10 = this.a.aR().b + (double)(this.a.K / 2.0F) + var4 * (double)this.a.K / 4.0D;
            double var12 = this.a.u + var6 * (double)this.a.J / 4.0D;
            this.o.a(this.aB, false, var8, var10, var12, var2, var4 + 0.2D, var6);
         }
      }

      ++this.az;
      if (this.az >= this.aA) {
         this.J();
      }

   }

   public void a(bfd var1, pk var2, float var3, float var4, float var5, float var6, float var7, float var8) {
   }

   public bep(adm var1, pk var2, cy var3) {
      super(var1, var2.s, var2.aR().b + (double)(var2.K / 2.0F), var2.u, var2.v, var2.w, var2.x);
      this.a = var2;
      this.aA = 3;
      this.aB = var3;
      this.t_();
   }
}
