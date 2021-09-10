public class bjr extends biv<uq> {
   private static final jy a = new jy("textures/painting/paintings_kristoffer_zetterstrand.png");

   protected jy a(pk var1) {
      return this.a((uq)var1);
   }

   public void a(uq var1, double var2, double var4, double var6, float var8, float var9) {
      bfl.E();
      bfl.b(var2, var4, var6);
      bfl.b(180.0F - var8, 0.0F, 1.0F, 0.0F);
      bfl.B();
      this.c(var1);
      uq.a var10 = var1.c;
      float var11 = 0.0625F;
      bfl.a(var11, var11, var11);
      this.a(var1, var10.C, var10.D, var10.E, var10.F);
      bfl.C();
      bfl.F();
      super.a(var1, var2, var4, var6, var8, var9);
   }

   protected jy a(uq var1) {
      return a;
   }

   private void a(uq var1, float var2, float var3) {
      int var4 = ns.c(var1.s);
      int var5 = ns.c(var1.t + (double)(var3 / 16.0F));
      int var6 = ns.c(var1.u);
      cq var7 = var1.b;
      if (var7 == cq.c) {
         var4 = ns.c(var1.s + (double)(var2 / 16.0F));
      }

      if (var7 == cq.e) {
         var6 = ns.c(var1.u - (double)(var2 / 16.0F));
      }

      if (var7 == cq.d) {
         var4 = ns.c(var1.s - (double)(var2 / 16.0F));
      }

      if (var7 == cq.f) {
         var6 = ns.c(var1.u + (double)(var2 / 16.0F));
      }

      int var8 = this.b.b.b(new cj(var4, var5, var6), 0);
      int var9 = var8 % 65536;
      int var10 = var8 / 65536;
      bqs.a(bqs.r, (float)var9, (float)var10);
      bfl.c(1.0F, 1.0F, 1.0F);
   }

   public bjr(biu var1) {
      super(var1);
   }

   private void a(uq var1, int var2, int var3, int var4, int var5) {
      float var6 = (float)(-var2) / 2.0F;
      float var7 = (float)(-var3) / 2.0F;
      float var8 = 0.5F;
      float var9 = 0.75F;
      float var10 = 0.8125F;
      float var11 = 0.0F;
      float var12 = 0.0625F;
      float var13 = 0.75F;
      float var14 = 0.8125F;
      float var15 = 0.001953125F;
      float var16 = 0.001953125F;
      float var17 = 0.7519531F;
      float var18 = 0.7519531F;
      float var19 = 0.0F;
      float var20 = 0.0625F;

      for(int var21 = 0; var21 < var2 / 16; ++var21) {
         for(int var22 = 0; var22 < var3 / 16; ++var22) {
            float var23 = var6 + (float)((var21 + 1) * 16);
            float var24 = var6 + (float)(var21 * 16);
            float var25 = var7 + (float)((var22 + 1) * 16);
            float var26 = var7 + (float)(var22 * 16);
            this.a(var1, (var23 + var24) / 2.0F, (var25 + var26) / 2.0F);
            float var27 = (float)(var4 + var2 - var21 * 16) / 256.0F;
            float var28 = (float)(var4 + var2 - (var21 + 1) * 16) / 256.0F;
            float var29 = (float)(var5 + var3 - var22 * 16) / 256.0F;
            float var30 = (float)(var5 + var3 - (var22 + 1) * 16) / 256.0F;
            bfx var31 = bfx.a();
            bfd var32 = var31.c();
            var32.a(7, bms.j);
            var32.b((double)var23, (double)var26, (double)(-var8)).a((double)var28, (double)var29).c(0.0F, 0.0F, -1.0F).d();
            var32.b((double)var24, (double)var26, (double)(-var8)).a((double)var27, (double)var29).c(0.0F, 0.0F, -1.0F).d();
            var32.b((double)var24, (double)var25, (double)(-var8)).a((double)var27, (double)var30).c(0.0F, 0.0F, -1.0F).d();
            var32.b((double)var23, (double)var25, (double)(-var8)).a((double)var28, (double)var30).c(0.0F, 0.0F, -1.0F).d();
            var32.b((double)var23, (double)var25, (double)var8).a((double)var9, (double)var11).c(0.0F, 0.0F, 1.0F).d();
            var32.b((double)var24, (double)var25, (double)var8).a((double)var10, (double)var11).c(0.0F, 0.0F, 1.0F).d();
            var32.b((double)var24, (double)var26, (double)var8).a((double)var10, (double)var12).c(0.0F, 0.0F, 1.0F).d();
            var32.b((double)var23, (double)var26, (double)var8).a((double)var9, (double)var12).c(0.0F, 0.0F, 1.0F).d();
            var32.b((double)var23, (double)var25, (double)(-var8)).a((double)var13, (double)var15).c(0.0F, 1.0F, 0.0F).d();
            var32.b((double)var24, (double)var25, (double)(-var8)).a((double)var14, (double)var15).c(0.0F, 1.0F, 0.0F).d();
            var32.b((double)var24, (double)var25, (double)var8).a((double)var14, (double)var16).c(0.0F, 1.0F, 0.0F).d();
            var32.b((double)var23, (double)var25, (double)var8).a((double)var13, (double)var16).c(0.0F, 1.0F, 0.0F).d();
            var32.b((double)var23, (double)var26, (double)var8).a((double)var13, (double)var15).c(0.0F, -1.0F, 0.0F).d();
            var32.b((double)var24, (double)var26, (double)var8).a((double)var14, (double)var15).c(0.0F, -1.0F, 0.0F).d();
            var32.b((double)var24, (double)var26, (double)(-var8)).a((double)var14, (double)var16).c(0.0F, -1.0F, 0.0F).d();
            var32.b((double)var23, (double)var26, (double)(-var8)).a((double)var13, (double)var16).c(0.0F, -1.0F, 0.0F).d();
            var32.b((double)var23, (double)var25, (double)var8).a((double)var18, (double)var19).c(-1.0F, 0.0F, 0.0F).d();
            var32.b((double)var23, (double)var26, (double)var8).a((double)var18, (double)var20).c(-1.0F, 0.0F, 0.0F).d();
            var32.b((double)var23, (double)var26, (double)(-var8)).a((double)var17, (double)var20).c(-1.0F, 0.0F, 0.0F).d();
            var32.b((double)var23, (double)var25, (double)(-var8)).a((double)var17, (double)var19).c(-1.0F, 0.0F, 0.0F).d();
            var32.b((double)var24, (double)var25, (double)(-var8)).a((double)var18, (double)var19).c(1.0F, 0.0F, 0.0F).d();
            var32.b((double)var24, (double)var26, (double)(-var8)).a((double)var18, (double)var20).c(1.0F, 0.0F, 0.0F).d();
            var32.b((double)var24, (double)var26, (double)var8).a((double)var17, (double)var20).c(1.0F, 0.0F, 0.0F).d();
            var32.b((double)var24, (double)var25, (double)var8).a((double)var17, (double)var19).c(1.0F, 0.0F, 0.0F).d();
            var31.b();
         }
      }

   }

   public void a(pk var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((uq)var1, var2, var4, var6, var8, var9);
   }
}
