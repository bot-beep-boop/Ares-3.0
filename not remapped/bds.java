public class bds extends beb {
   private int az;
   private static final jy a = new jy("textures/particle/footprint.png");
   private bmj aB;
   private int aA;

   protected bds(bmj var1, adm var2, double var3, double var5, double var7) {
      super(var2, var3, var5, var7, 0.0D, 0.0D, 0.0D);
      this.aB = var1;
      this.v = this.w = this.x = 0.0D;
      this.aA = 200;
   }

   public void t_() {
      ++this.az;
      if (this.az == this.aA) {
         this.J();
      }

   }

   public int a() {
      return 3;
   }

   public void a(bfd var1, pk var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = ((float)this.az + var3) / (float)this.aA;
      var9 *= var9;
      float var10 = 2.0F - var9 * 2.0F;
      if (var10 > 1.0F) {
         var10 = 1.0F;
      }

      var10 *= 0.2F;
      bfl.f();
      float var11 = 0.125F;
      float var12 = (float)(this.s - aw);
      float var13 = (float)(this.t - ax);
      float var14 = (float)(this.u - ay);
      float var15 = this.o.o(new cj(this));
      this.aB.a(a);
      bfl.l();
      bfl.b(770, 771);
      var1.a(7, bms.i);
      var1.b((double)(var12 - 0.125F), (double)var13, (double)(var14 + 0.125F)).a(0.0D, 1.0D).a(var15, var15, var15, var10).d();
      var1.b((double)(var12 + 0.125F), (double)var13, (double)(var14 + 0.125F)).a(1.0D, 1.0D).a(var15, var15, var15, var10).d();
      var1.b((double)(var12 + 0.125F), (double)var13, (double)(var14 - 0.125F)).a(1.0D, 0.0D).a(var15, var15, var15, var10).d();
      var1.b((double)(var12 - 0.125F), (double)var13, (double)(var14 - 0.125F)).a(0.0D, 0.0D).a(var15, var15, var15, var10).d();
      bfx.a().b();
      bfl.k();
      bfl.e();
   }

   public static class a implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         return new bds(ave.A().P(), var2, var3, var5, var7);
      }
   }
}
