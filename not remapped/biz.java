public class biz extends biv<ur> {
   private static final jy a = new jy("textures/particle/particles.png");

   public void a(ur var1, double var2, double var4, double var6, float var8, float var9) {
      bfl.E();
      bfl.b((float)var2, (float)var4, (float)var6);
      bfl.B();
      bfl.a(0.5F, 0.5F, 0.5F);
      this.c(var1);
      bfx var10 = bfx.a();
      bfd var11 = var10.c();
      boolean var12 = true;
      boolean var13 = true;
      float var14 = 0.0625F;
      float var15 = 0.125F;
      float var16 = 0.125F;
      float var17 = 0.1875F;
      float var18 = 1.0F;
      float var19 = 0.5F;
      float var20 = 0.5F;
      bfl.b(180.0F - this.b.e, 0.0F, 1.0F, 0.0F);
      bfl.b(-this.b.f, 1.0F, 0.0F, 0.0F);
      var11.a(7, bms.j);
      var11.b(-0.5D, -0.5D, 0.0D).a(0.0625D, 0.1875D).c(0.0F, 1.0F, 0.0F).d();
      var11.b(0.5D, -0.5D, 0.0D).a(0.125D, 0.1875D).c(0.0F, 1.0F, 0.0F).d();
      var11.b(0.5D, 0.5D, 0.0D).a(0.125D, 0.125D).c(0.0F, 1.0F, 0.0F).d();
      var11.b(-0.5D, 0.5D, 0.0D).a(0.0625D, 0.125D).c(0.0F, 1.0F, 0.0F).d();
      var10.b();
      bfl.C();
      bfl.F();
      if (var1.b != null) {
         float var21 = var1.b.l(var9);
         float var22 = ns.a(ns.c(var21) * 3.1415927F);
         aui var23 = new aui(-0.36D, 0.03D, 0.35D);
         var23 = var23.a(-(var1.b.B + (var1.b.z - var1.b.B) * var9) * 3.1415927F / 180.0F);
         var23 = var23.b(-(var1.b.A + (var1.b.y - var1.b.A) * var9) * 3.1415927F / 180.0F);
         var23 = var23.b(var22 * 0.5F);
         var23 = var23.a(-var22 * 0.7F);
         double var24 = var1.b.p + (var1.b.s - var1.b.p) * (double)var9 + var23.a;
         double var26 = var1.b.q + (var1.b.t - var1.b.q) * (double)var9 + var23.b;
         double var28 = var1.b.r + (var1.b.u - var1.b.r) * (double)var9 + var23.c;
         double var30 = (double)var1.b.aS();
         if (this.b.g != null && this.b.g.aB > 0 || var1.b != ave.A().h) {
            float var32 = (var1.b.aJ + (var1.b.aI - var1.b.aJ) * var9) * 3.1415927F / 180.0F;
            double var33 = (double)ns.a(var32);
            double var35 = (double)ns.b(var32);
            double var37 = 0.35D;
            double var39 = 0.8D;
            var24 = var1.b.p + (var1.b.s - var1.b.p) * (double)var9 - var35 * 0.35D - var33 * 0.8D;
            var26 = var1.b.q + var30 + (var1.b.t - var1.b.q) * (double)var9 - 0.45D;
            var28 = var1.b.r + (var1.b.u - var1.b.r) * (double)var9 - var33 * 0.35D + var35 * 0.8D;
            var30 = var1.b.av() ? -0.1875D : 0.0D;
         }

         double var47 = var1.p + (var1.s - var1.p) * (double)var9;
         double var34 = var1.q + (var1.t - var1.q) * (double)var9 + 0.25D;
         double var36 = var1.r + (var1.u - var1.r) * (double)var9;
         double var38 = (double)((float)(var24 - var47));
         double var40 = (double)((float)(var26 - var34)) + var30;
         double var42 = (double)((float)(var28 - var36));
         bfl.x();
         bfl.f();
         var11.a(3, bms.f);
         boolean var44 = true;

         for(int var45 = 0; var45 <= 16; ++var45) {
            float var46 = (float)var45 / 16.0F;
            var11.b(var2 + var38 * (double)var46, var4 + var40 * (double)(var46 * var46 + var46) * 0.5D + 0.25D, var6 + var42 * (double)var46).b(0, 0, 0, 255).d();
         }

         var10.b();
         bfl.e();
         bfl.w();
         super.a(var1, var2, var4, var6, var8, var9);
      }

   }

   public biz(biu var1) {
      super(var1);
   }

   protected jy a(pk var1) {
      return this.a((ur)var1);
   }

   public void a(pk var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((ur)var1, var2, var4, var6, var8, var9);
   }

   protected jy a(ur var1) {
      return a;
   }
}
