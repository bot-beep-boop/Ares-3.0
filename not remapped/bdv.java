public class bdv extends beb {
   private int a;
   private int az = 8;

   public void t_() {
      for(int var1 = 0; var1 < 6; ++var1) {
         double var2 = this.s + (this.V.nextDouble() - this.V.nextDouble()) * 4.0D;
         double var4 = this.t + (this.V.nextDouble() - this.V.nextDouble()) * 4.0D;
         double var6 = this.u + (this.V.nextDouble() - this.V.nextDouble()) * 4.0D;
         this.o.a(cy.b, var2, var4, var6, (double)((float)this.a / (float)this.az), 0.0D, 0.0D);
      }

      ++this.a;
      if (this.a == this.az) {
         this.J();
      }

   }

   public void a(bfd var1, pk var2, float var3, float var4, float var5, float var6, float var7, float var8) {
   }

   public int a() {
      return 1;
   }

   protected bdv(adm var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      super(var1, var2, var4, var6, 0.0D, 0.0D, 0.0D);
   }

   public static class a implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         return new bdv(var2, var3, var5, var7, var9, var11, var13);
      }
   }
}
