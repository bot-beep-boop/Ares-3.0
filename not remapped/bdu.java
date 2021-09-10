public class bdu extends beb {
   private int aA;
   private int aB;
   private static final jy a = new jy("textures/entity/explosion.png");
   private static final bmu az;
   private bmj aC;
   private float aD;

   public int b(float var1) {
      return 61680;
   }

   public void a(bfd var1, pk var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      int var9 = (int)(((float)this.aA + var3) * 15.0F / (float)this.aB);
      if (var9 <= 15) {
         this.aC.a(a);
         float var10 = (float)(var9 % 4) / 4.0F;
         float var11 = var10 + 0.24975F;
         float var12 = (float)(var9 / 4) / 4.0F;
         float var13 = var12 + 0.24975F;
         float var14 = 2.0F * this.aD;
         float var15 = (float)(this.p + (this.s - this.p) * (double)var3 - aw);
         float var16 = (float)(this.q + (this.t - this.q) * (double)var3 - ax);
         float var17 = (float)(this.r + (this.u - this.r) * (double)var3 - ay);
         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         bfl.f();
         avc.a();
         var1.a(7, az);
         var1.b((double)(var15 - var4 * var14 - var7 * var14), (double)(var16 - var5 * var14), (double)(var17 - var6 * var14 - var8 * var14)).a((double)var11, (double)var13).a(this.ar, this.as, this.at, 1.0F).a(0, 240).c(0.0F, 1.0F, 0.0F).d();
         var1.b((double)(var15 - var4 * var14 + var7 * var14), (double)(var16 + var5 * var14), (double)(var17 - var6 * var14 + var8 * var14)).a((double)var11, (double)var12).a(this.ar, this.as, this.at, 1.0F).a(0, 240).c(0.0F, 1.0F, 0.0F).d();
         var1.b((double)(var15 + var4 * var14 + var7 * var14), (double)(var16 + var5 * var14), (double)(var17 + var6 * var14 + var8 * var14)).a((double)var10, (double)var12).a(this.ar, this.as, this.at, 1.0F).a(0, 240).c(0.0F, 1.0F, 0.0F).d();
         var1.b((double)(var15 + var4 * var14 - var7 * var14), (double)(var16 - var5 * var14), (double)(var17 + var6 * var14 - var8 * var14)).a((double)var10, (double)var13).a(this.ar, this.as, this.at, 1.0F).a(0, 240).c(0.0F, 1.0F, 0.0F).d();
         bfx.a().b();
         bfl.e();
      }
   }

   public void t_() {
      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      ++this.aA;
      if (this.aA == this.aB) {
         this.J();
      }

   }

   protected bdu(bmj var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13) {
      super(var2, var3, var5, var7, 0.0D, 0.0D, 0.0D);
      this.aC = var1;
      this.aB = 6 + this.V.nextInt(4);
      this.ar = this.as = this.at = this.V.nextFloat() * 0.6F + 0.4F;
      this.aD = 1.0F - (float)var9 * 0.5F;
   }

   static {
      az = (new bmu()).a(bms.m).a(bms.o).a(bms.n).a(bms.p).a(bms.q).a(bms.r);
   }

   public int a() {
      return 3;
   }

   public static class a implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         return new bdu(ave.A().P(), var2, var3, var5, var7, var9, var11, var13);
      }
   }
}
