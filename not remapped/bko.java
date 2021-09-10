import java.util.Random;

public class bko implements blb<pr> {
   private final bjl a;

   public void a(pr var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      int var9 = var1.bv();
      if (var9 > 0) {
         wq var10 = new wq(var1.o, var1.s, var1.t, var1.u);
         Random var11 = new Random((long)var1.F());
         avc.a();

         for(int var12 = 0; var12 < var9; ++var12) {
            bfl.E();
            bct var13 = this.a.b().a(var11);
            bcr var14 = (bcr)var13.l.get(var11.nextInt(var13.l.size()));
            var13.c(0.0625F);
            float var15 = var11.nextFloat();
            float var16 = var11.nextFloat();
            float var17 = var11.nextFloat();
            float var18 = (var14.a + (var14.d - var14.a) * var15) / 16.0F;
            float var19 = (var14.b + (var14.e - var14.b) * var16) / 16.0F;
            float var20 = (var14.c + (var14.f - var14.c) * var17) / 16.0F;
            bfl.b(var18, var19, var20);
            var15 = var15 * 2.0F - 1.0F;
            var16 = var16 * 2.0F - 1.0F;
            var17 = var17 * 2.0F - 1.0F;
            var15 *= -1.0F;
            var16 *= -1.0F;
            var17 *= -1.0F;
            float var21 = ns.c(var15 * var15 + var17 * var17);
            var10.A = var10.y = (float)(Math.atan2((double)var15, (double)var17) * 180.0D / 3.1415927410125732D);
            var10.B = var10.z = (float)(Math.atan2((double)var16, (double)var21) * 180.0D / 3.1415927410125732D);
            double var22 = 0.0D;
            double var24 = 0.0D;
            double var26 = 0.0D;
            this.a.d().a(var10, var22, var24, var26, 0.0F, var4);
            bfl.F();
         }

         avc.b();
      }
   }

   public boolean b() {
      return false;
   }

   public bko(bjl var1) {
      this.a = var1;
   }
}
