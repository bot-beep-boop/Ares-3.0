import org.lwjgl.opengl.GL11;

public class bjc extends bjo<vt> {
   private static final jy j = new jy("textures/entity/guardian_elder.png");
   private static final jy k = new jy("textures/entity/guardian_beam.png");
   int a;
   private static final jy e = new jy("textures/entity/guardian.png");

   public boolean a(ps var1, bia var2, double var3, double var5, double var7) {
      return this.a((vt)var1, var2, var3, var5, var7);
   }

   public void a(ps var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((vt)var1, var2, var4, var6, var8, var9);
   }

   protected jy a(vt var1) {
      return var1.cn() ? j : e;
   }

   public bjc(biu var1) {
      super(var1, new bbg(), 0.5F);
      this.a = ((bbg)this.f).a();
   }

   public boolean a(pk var1, bia var2, double var3, double var5, double var7) {
      return this.a((vt)var1, var2, var3, var5, var7);
   }

   public void a(vt var1, double var2, double var4, double var6, float var8, float var9) {
      if (this.a != ((bbg)this.f).a()) {
         this.f = new bbg();
         this.a = ((bbg)this.f).a();
      }

      super.a((ps)var1, var2, var4, var6, var8, var9);
      pr var10 = var1.cq();
      if (var10 != null) {
         float var11 = var1.q(var9);
         bfx var12 = bfx.a();
         bfd var13 = var12.c();
         this.a((jy)k);
         GL11.glTexParameterf(3553, 10242, 10497.0F);
         GL11.glTexParameterf(3553, 10243, 10497.0F);
         bfl.f();
         bfl.p();
         bfl.k();
         bfl.a(true);
         float var14 = 240.0F;
         bqs.a(bqs.r, var14, var14);
         bfl.a(770, 1, 1, 0);
         float var15 = (float)var1.o.K() + var9;
         float var16 = var15 * 0.5F % 1.0F;
         float var17 = var1.aS();
         bfl.E();
         bfl.b((float)var2, (float)var4 + var17, (float)var6);
         aui var18 = this.a(var10, (double)var10.K * 0.5D, var9);
         aui var19 = this.a(var1, (double)var17, var9);
         aui var20 = var18.d(var19);
         double var21 = var20.b() + 1.0D;
         var20 = var20.a();
         float var23 = (float)Math.acos(var20.b);
         float var24 = (float)Math.atan2(var20.c, var20.a);
         bfl.b((1.5707964F + -var24) * 57.295776F, 0.0F, 1.0F, 0.0F);
         bfl.b(var23 * 57.295776F, 1.0F, 0.0F, 0.0F);
         byte var25 = 1;
         double var26 = (double)var15 * 0.05D * (1.0D - (double)(var25 & 1) * 2.5D);
         var13.a(7, bms.i);
         float var28 = var11 * var11;
         int var29 = 64 + (int)(var28 * 240.0F);
         int var30 = 32 + (int)(var28 * 192.0F);
         int var31 = 128 - (int)(var28 * 64.0F);
         double var32 = (double)var25 * 0.2D;
         double var34 = var32 * 1.41D;
         double var36 = 0.0D + Math.cos(var26 + 2.356194490192345D) * var34;
         double var38 = 0.0D + Math.sin(var26 + 2.356194490192345D) * var34;
         double var40 = 0.0D + Math.cos(var26 + 0.7853981633974483D) * var34;
         double var42 = 0.0D + Math.sin(var26 + 0.7853981633974483D) * var34;
         double var44 = 0.0D + Math.cos(var26 + 3.9269908169872414D) * var34;
         double var46 = 0.0D + Math.sin(var26 + 3.9269908169872414D) * var34;
         double var48 = 0.0D + Math.cos(var26 + 5.497787143782138D) * var34;
         double var50 = 0.0D + Math.sin(var26 + 5.497787143782138D) * var34;
         double var52 = 0.0D + Math.cos(var26 + 3.141592653589793D) * var32;
         double var54 = 0.0D + Math.sin(var26 + 3.141592653589793D) * var32;
         double var56 = 0.0D + Math.cos(var26 + 0.0D) * var32;
         double var58 = 0.0D + Math.sin(var26 + 0.0D) * var32;
         double var60 = 0.0D + Math.cos(var26 + 1.5707963267948966D) * var32;
         double var62 = 0.0D + Math.sin(var26 + 1.5707963267948966D) * var32;
         double var64 = 0.0D + Math.cos(var26 + 4.71238898038469D) * var32;
         double var66 = 0.0D + Math.sin(var26 + 4.71238898038469D) * var32;
         double var70 = 0.0D;
         double var72 = 0.4999D;
         double var74 = (double)(-1.0F + var16);
         double var76 = var21 * (0.5D / var32) + var74;
         var13.b(var52, var21, var54).a(0.4999D, var76).b(var29, var30, var31, 255).d();
         var13.b(var52, 0.0D, var54).a(0.4999D, var74).b(var29, var30, var31, 255).d();
         var13.b(var56, 0.0D, var58).a(0.0D, var74).b(var29, var30, var31, 255).d();
         var13.b(var56, var21, var58).a(0.0D, var76).b(var29, var30, var31, 255).d();
         var13.b(var60, var21, var62).a(0.4999D, var76).b(var29, var30, var31, 255).d();
         var13.b(var60, 0.0D, var62).a(0.4999D, var74).b(var29, var30, var31, 255).d();
         var13.b(var64, 0.0D, var66).a(0.0D, var74).b(var29, var30, var31, 255).d();
         var13.b(var64, var21, var66).a(0.0D, var76).b(var29, var30, var31, 255).d();
         double var78 = 0.0D;
         if (var1.W % 2 == 0) {
            var78 = 0.5D;
         }

         var13.b(var36, var21, var38).a(0.5D, var78 + 0.5D).b(var29, var30, var31, 255).d();
         var13.b(var40, var21, var42).a(1.0D, var78 + 0.5D).b(var29, var30, var31, 255).d();
         var13.b(var48, var21, var50).a(1.0D, var78).b(var29, var30, var31, 255).d();
         var13.b(var44, var21, var46).a(0.5D, var78).b(var29, var30, var31, 255).d();
         var12.b();
         bfl.F();
      }

   }

   public void a(pk var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((vt)var1, var2, var4, var6, var8, var9);
   }

   protected jy a(pk var1) {
      return this.a((vt)var1);
   }

   public boolean a(vt var1, bia var2, double var3, double var5, double var7) {
      if (super.a((ps)var1, var2, var3, var5, var7)) {
         return true;
      } else {
         if (var1.cp()) {
            pr var9 = var1.cq();
            if (var9 != null) {
               aui var10 = this.a(var9, (double)var9.K * 0.5D, 1.0F);
               aui var11 = this.a(var1, (double)var1.aS(), 1.0F);
               if (var2.a(aug.a(var11.a, var11.b, var11.c, var10.a, var10.b, var10.c))) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   protected void a(vt var1, float var2) {
      if (var1.cn()) {
         bfl.a(2.35F, 2.35F, 2.35F);
      }

   }

   public void a(pr var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((vt)var1, var2, var4, var6, var8, var9);
   }

   protected void a(pr var1, float var2) {
      this.a((vt)var1, var2);
   }

   private aui a(pr var1, double var2, float var4) {
      double var5 = var1.P + (var1.s - var1.P) * (double)var4;
      double var7 = var2 + var1.Q + (var1.t - var1.Q) * (double)var4;
      double var9 = var1.R + (var1.u - var1.R) * (double)var4;
      return new aui(var5, var7, var9);
   }
}
