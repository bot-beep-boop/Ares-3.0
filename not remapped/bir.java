public class bir extends bjo<ug> {
   private static final jy k = new jy("textures/entity/enderdragon/dragon.png");
   private static final jy j = new jy("textures/entity/enderdragon/dragon_exploding.png");
   private static final jy e = new jy("textures/entity/endercrystal/endercrystal_beam.png");
   protected bco a;

   protected jy a(ug var1) {
      return k;
   }

   protected void a(pr var1, float var2, float var3, float var4) {
      this.a((ug)var1, var2, var3, var4);
   }

   public bir(biu var1) {
      super(var1, new bco(0.0F), 0.5F);
      this.a = (bco)this.f;
      this.a((blb)(new bkv(this)));
      this.a((blb)(new bku()));
   }

   protected jy a(pk var1) {
      return this.a((ug)var1);
   }

   protected void a(ug var1, float var2, float var3, float var4) {
      float var5 = (float)var1.b(7, var4)[0];
      float var6 = (float)(var1.b(5, var4)[1] - var1.b(10, var4)[1]);
      bfl.b(-var5, 0.0F, 1.0F, 0.0F);
      bfl.b(var6 * 10.0F, 1.0F, 0.0F, 0.0F);
      bfl.b(0.0F, 0.0F, 1.0F);
      if (var1.ax > 0) {
         float var7 = ((float)var1.ax + var4 - 1.0F) / 20.0F * 1.6F;
         var7 = ns.c(var7);
         if (var7 > 1.0F) {
            var7 = 1.0F;
         }

         bfl.b(var7 * this.b(var1), 0.0F, 0.0F, 1.0F);
      }

   }

   public void a(ps var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((ug)var1, var2, var4, var6, var8, var9);
   }

   public void a(pk var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((ug)var1, var2, var4, var6, var8, var9);
   }

   protected void a(ug var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      if (var1.by > 0) {
         float var8 = (float)var1.by / 200.0F;
         bfl.c(515);
         bfl.d();
         bfl.a(516, var8);
         this.a((jy)j);
         this.f.a(var1, var2, var3, var4, var5, var6, var7);
         bfl.a(516, 0.1F);
         bfl.c(514);
      }

      this.c(var1);
      this.f.a(var1, var2, var3, var4, var5, var6, var7);
      if (var1.au > 0) {
         bfl.c(514);
         bfl.x();
         bfl.l();
         bfl.b(770, 771);
         bfl.c(1.0F, 0.0F, 0.0F, 0.5F);
         this.f.a(var1, var2, var3, var4, var5, var6, var7);
         bfl.w();
         bfl.k();
         bfl.c(515);
      }

   }

   protected void a(pr var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.a((ug)var1, var2, var3, var4, var5, var6, var7);
   }

   protected void a(ug var1, double var2, double var4, double var6, float var8) {
      float var9 = (float)var1.bz.a + var8;
      float var10 = ns.a(var9 * 0.2F) / 2.0F + 0.5F;
      var10 = (var10 * var10 + var10) * 0.2F;
      float var11 = (float)(var1.bz.s - var1.s - (var1.p - var1.s) * (double)(1.0F - var8));
      float var12 = (float)((double)var10 + var1.bz.t - 1.0D - var1.t - (var1.q - var1.t) * (double)(1.0F - var8));
      float var13 = (float)(var1.bz.u - var1.u - (var1.r - var1.u) * (double)(1.0F - var8));
      float var14 = ns.c(var11 * var11 + var13 * var13);
      float var15 = ns.c(var11 * var11 + var12 * var12 + var13 * var13);
      bfl.E();
      bfl.b((float)var2, (float)var4 + 2.0F, (float)var6);
      bfl.b((float)(-Math.atan2((double)var13, (double)var11)) * 180.0F / 3.1415927F - 90.0F, 0.0F, 1.0F, 0.0F);
      bfl.b((float)(-Math.atan2((double)var14, (double)var12)) * 180.0F / 3.1415927F - 90.0F, 1.0F, 0.0F, 0.0F);
      bfx var16 = bfx.a();
      bfd var17 = var16.c();
      avc.a();
      bfl.p();
      this.a((jy)e);
      bfl.j(7425);
      float var18 = 0.0F - ((float)var1.W + var8) * 0.01F;
      float var19 = ns.c(var11 * var11 + var12 * var12 + var13 * var13) / 32.0F - ((float)var1.W + var8) * 0.01F;
      var17.a(5, bms.i);
      boolean var20 = true;

      for(int var21 = 0; var21 <= 8; ++var21) {
         float var22 = ns.a((float)(var21 % 8) * 3.1415927F * 2.0F / 8.0F) * 0.75F;
         float var23 = ns.b((float)(var21 % 8) * 3.1415927F * 2.0F / 8.0F) * 0.75F;
         float var24 = (float)(var21 % 8) * 1.0F / 8.0F;
         var17.b((double)(var22 * 0.2F), (double)(var23 * 0.2F), 0.0D).a((double)var24, (double)var19).b(0, 0, 0, 255).d();
         var17.b((double)var22, (double)var23, (double)var15).a((double)var24, (double)var18).b(255, 255, 255, 255).d();
      }

      var16.b();
      bfl.o();
      bfl.j(7424);
      avc.b();
      bfl.F();
   }

   public void a(ug var1, double var2, double var4, double var6, float var8, float var9) {
      bfc.a(var1, false);
      super.a((ps)var1, var2, var4, var6, var8, var9);
      if (var1.bz != null) {
         this.a(var1, var2, var4, var6, var9);
      }

   }

   public void a(pr var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((ug)var1, var2, var4, var6, var8, var9);
   }
}
