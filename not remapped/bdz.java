public class bdz extends beb {
   private pr a;

   public int a() {
      return 3;
   }

   public void a(bfd var1, pk var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (this.a != null) {
         biu var9 = ave.A().af();
         var9.a(beb.aw, beb.ax, beb.ay);
         float var10 = 0.42553192F;
         float var11 = ((float)this.f + var3) / (float)this.g;
         bfl.a(true);
         bfl.l();
         bfl.j();
         bfl.b(770, 771);
         float var12 = 240.0F;
         bqs.a(bqs.r, var12, var12);
         bfl.E();
         float var13 = 0.05F + 0.5F * ns.a(var11 * 3.1415927F);
         bfl.c(1.0F, 1.0F, 1.0F, var13);
         bfl.b(0.0F, 1.8F, 0.0F);
         bfl.b(180.0F - var2.y, 0.0F, 1.0F, 0.0F);
         bfl.b(60.0F - 150.0F * var11 - var2.z, 1.0F, 0.0F, 0.0F);
         bfl.b(0.0F, -0.4F, -1.5F);
         bfl.a(var10, var10, var10);
         this.a.y = this.a.A = 0.0F;
         this.a.aK = this.a.aL = 0.0F;
         var9.a(this.a, 0.0D, 0.0D, 0.0D, 0.0F, var3);
         bfl.F();
         bfl.j();
      }
   }

   protected bdz(adm var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6, 0.0D, 0.0D, 0.0D);
      this.ar = this.as = this.at = 1.0F;
      this.v = this.w = this.x = 0.0D;
      this.i = 0.0F;
      this.g = 30;
   }

   public void t_() {
      super.t_();
      if (this.a == null) {
         vt var1 = new vt(this.o);
         var1.co();
         this.a = var1;
      }

   }

   public static class a implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         return new bdz(var2, var3, var5, var7);
      }
   }
}
