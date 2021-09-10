import java.util.List;
import org.lwjgl.opengl.GL11;

public class bhb extends bhd<akv> {
   private static final jy c = new jy("textures/entity/beacon_beam.png");

   public boolean a() {
      return true;
   }

   public void a(akv var1, double var2, double var4, double var6, float var8, int var9) {
      float var10 = var1.o();
      bfl.a(516, 0.1F);
      if (var10 > 0.0F) {
         bfx var11 = bfx.a();
         bfd var12 = var11.c();
         bfl.n();
         List var13 = var1.n();
         int var14 = 0;

         for(int var15 = 0; var15 < var13.size(); ++var15) {
            akv.a var16 = (akv.a)var13.get(var15);
            int var17 = var14 + var16.c();
            this.a(c);
            GL11.glTexParameterf(3553, 10242, 10497.0F);
            GL11.glTexParameterf(3553, 10243, 10497.0F);
            bfl.f();
            bfl.p();
            bfl.k();
            bfl.a(true);
            bfl.a(770, 1, 1, 0);
            double var18 = (double)var1.z().K() + (double)var8;
            double var20 = ns.h(-var18 * 0.2D - (double)ns.c(-var18 * 0.1D));
            float var22 = var16.b()[0];
            float var23 = var16.b()[1];
            float var24 = var16.b()[2];
            double var25 = var18 * 0.025D * -1.5D;
            double var27 = 0.2D;
            double var29 = 0.5D + Math.cos(var25 + 2.356194490192345D) * 0.2D;
            double var31 = 0.5D + Math.sin(var25 + 2.356194490192345D) * 0.2D;
            double var33 = 0.5D + Math.cos(var25 + 0.7853981633974483D) * 0.2D;
            double var35 = 0.5D + Math.sin(var25 + 0.7853981633974483D) * 0.2D;
            double var37 = 0.5D + Math.cos(var25 + 3.9269908169872414D) * 0.2D;
            double var39 = 0.5D + Math.sin(var25 + 3.9269908169872414D) * 0.2D;
            double var41 = 0.5D + Math.cos(var25 + 5.497787143782138D) * 0.2D;
            double var43 = 0.5D + Math.sin(var25 + 5.497787143782138D) * 0.2D;
            double var45 = 0.0D;
            double var47 = 1.0D;
            double var49 = -1.0D + var20;
            double var51 = (double)((float)var16.c() * var10) * 2.5D + var49;
            var12.a(7, bms.i);
            var12.b(var2 + var29, var4 + (double)var17, var6 + var31).a(1.0D, var51).a(var22, var23, var24, 1.0F).d();
            var12.b(var2 + var29, var4 + (double)var14, var6 + var31).a(1.0D, var49).a(var22, var23, var24, 1.0F).d();
            var12.b(var2 + var33, var4 + (double)var14, var6 + var35).a(0.0D, var49).a(var22, var23, var24, 1.0F).d();
            var12.b(var2 + var33, var4 + (double)var17, var6 + var35).a(0.0D, var51).a(var22, var23, var24, 1.0F).d();
            var12.b(var2 + var41, var4 + (double)var17, var6 + var43).a(1.0D, var51).a(var22, var23, var24, 1.0F).d();
            var12.b(var2 + var41, var4 + (double)var14, var6 + var43).a(1.0D, var49).a(var22, var23, var24, 1.0F).d();
            var12.b(var2 + var37, var4 + (double)var14, var6 + var39).a(0.0D, var49).a(var22, var23, var24, 1.0F).d();
            var12.b(var2 + var37, var4 + (double)var17, var6 + var39).a(0.0D, var51).a(var22, var23, var24, 1.0F).d();
            var12.b(var2 + var33, var4 + (double)var17, var6 + var35).a(1.0D, var51).a(var22, var23, var24, 1.0F).d();
            var12.b(var2 + var33, var4 + (double)var14, var6 + var35).a(1.0D, var49).a(var22, var23, var24, 1.0F).d();
            var12.b(var2 + var41, var4 + (double)var14, var6 + var43).a(0.0D, var49).a(var22, var23, var24, 1.0F).d();
            var12.b(var2 + var41, var4 + (double)var17, var6 + var43).a(0.0D, var51).a(var22, var23, var24, 1.0F).d();
            var12.b(var2 + var37, var4 + (double)var17, var6 + var39).a(1.0D, var51).a(var22, var23, var24, 1.0F).d();
            var12.b(var2 + var37, var4 + (double)var14, var6 + var39).a(1.0D, var49).a(var22, var23, var24, 1.0F).d();
            var12.b(var2 + var29, var4 + (double)var14, var6 + var31).a(0.0D, var49).a(var22, var23, var24, 1.0F).d();
            var12.b(var2 + var29, var4 + (double)var17, var6 + var31).a(0.0D, var51).a(var22, var23, var24, 1.0F).d();
            var11.b();
            bfl.l();
            bfl.a(770, 771, 1, 0);
            bfl.a(false);
            var25 = 0.2D;
            var27 = 0.2D;
            var29 = 0.8D;
            var31 = 0.2D;
            var33 = 0.2D;
            var35 = 0.8D;
            var37 = 0.8D;
            var39 = 0.8D;
            var41 = 0.0D;
            var43 = 1.0D;
            var45 = -1.0D + var20;
            var47 = (double)((float)var16.c() * var10) + var45;
            var12.a(7, bms.i);
            var12.b(var2 + 0.2D, var4 + (double)var17, var6 + 0.2D).a(1.0D, var47).a(var22, var23, var24, 0.125F).d();
            var12.b(var2 + 0.2D, var4 + (double)var14, var6 + 0.2D).a(1.0D, var45).a(var22, var23, var24, 0.125F).d();
            var12.b(var2 + 0.8D, var4 + (double)var14, var6 + 0.2D).a(0.0D, var45).a(var22, var23, var24, 0.125F).d();
            var12.b(var2 + 0.8D, var4 + (double)var17, var6 + 0.2D).a(0.0D, var47).a(var22, var23, var24, 0.125F).d();
            var12.b(var2 + 0.8D, var4 + (double)var17, var6 + 0.8D).a(1.0D, var47).a(var22, var23, var24, 0.125F).d();
            var12.b(var2 + 0.8D, var4 + (double)var14, var6 + 0.8D).a(1.0D, var45).a(var22, var23, var24, 0.125F).d();
            var12.b(var2 + 0.2D, var4 + (double)var14, var6 + 0.8D).a(0.0D, var45).a(var22, var23, var24, 0.125F).d();
            var12.b(var2 + 0.2D, var4 + (double)var17, var6 + 0.8D).a(0.0D, var47).a(var22, var23, var24, 0.125F).d();
            var12.b(var2 + 0.8D, var4 + (double)var17, var6 + 0.2D).a(1.0D, var47).a(var22, var23, var24, 0.125F).d();
            var12.b(var2 + 0.8D, var4 + (double)var14, var6 + 0.2D).a(1.0D, var45).a(var22, var23, var24, 0.125F).d();
            var12.b(var2 + 0.8D, var4 + (double)var14, var6 + 0.8D).a(0.0D, var45).a(var22, var23, var24, 0.125F).d();
            var12.b(var2 + 0.8D, var4 + (double)var17, var6 + 0.8D).a(0.0D, var47).a(var22, var23, var24, 0.125F).d();
            var12.b(var2 + 0.2D, var4 + (double)var17, var6 + 0.8D).a(1.0D, var47).a(var22, var23, var24, 0.125F).d();
            var12.b(var2 + 0.2D, var4 + (double)var14, var6 + 0.8D).a(1.0D, var45).a(var22, var23, var24, 0.125F).d();
            var12.b(var2 + 0.2D, var4 + (double)var14, var6 + 0.2D).a(0.0D, var45).a(var22, var23, var24, 0.125F).d();
            var12.b(var2 + 0.2D, var4 + (double)var17, var6 + 0.2D).a(0.0D, var47).a(var22, var23, var24, 0.125F).d();
            var11.b();
            bfl.e();
            bfl.w();
            bfl.a(true);
            var14 = var17;
         }

         bfl.m();
      }

   }

   public void a(akw var1, double var2, double var4, double var6, float var8, int var9) {
      this.a((akv)var1, var2, var4, var6, var8, var9);
   }
}
