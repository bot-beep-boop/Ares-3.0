import java.util.Random;

public class bku implements blb<ug> {
   public boolean b() {
      return false;
   }

   public void a(pr var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      this.a((ug)var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public void a(ug var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (var1.by > 0) {
         bfx var9 = bfx.a();
         bfd var10 = var9.c();
         avc.a();
         float var11 = ((float)var1.by + var4) / 200.0F;
         float var12 = 0.0F;
         if (var11 > 0.8F) {
            var12 = (var11 - 0.8F) / 0.2F;
         }

         Random var13 = new Random(432L);
         bfl.x();
         bfl.j(7425);
         bfl.l();
         bfl.b(770, 1);
         bfl.c();
         bfl.o();
         bfl.a(false);
         bfl.E();
         bfl.b(0.0F, -1.0F, -2.0F);

         for(int var14 = 0; (float)var14 < (var11 + var11 * var11) / 2.0F * 60.0F; ++var14) {
            bfl.b(var13.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
            bfl.b(var13.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
            bfl.b(var13.nextFloat() * 360.0F, 0.0F, 0.0F, 1.0F);
            bfl.b(var13.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
            bfl.b(var13.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
            bfl.b(var13.nextFloat() * 360.0F + var11 * 90.0F, 0.0F, 0.0F, 1.0F);
            float var15 = var13.nextFloat() * 20.0F + 5.0F + var12 * 10.0F;
            float var16 = var13.nextFloat() * 2.0F + 1.0F + var12 * 2.0F;
            var10.a(6, bms.f);
            var10.b(0.0D, 0.0D, 0.0D).b(255, 255, 255, (int)(255.0F * (1.0F - var12))).d();
            var10.b(-0.866D * (double)var16, (double)var15, (double)(-0.5F * var16)).b(255, 0, 255, 0).d();
            var10.b(0.866D * (double)var16, (double)var15, (double)(-0.5F * var16)).b(255, 0, 255, 0).d();
            var10.b(0.0D, (double)var15, (double)(1.0F * var16)).b(255, 0, 255, 0).d();
            var10.b(-0.866D * (double)var16, (double)var15, (double)(-0.5F * var16)).b(255, 0, 255, 0).d();
            var9.b();
         }

         bfl.F();
         bfl.a(true);
         bfl.p();
         bfl.k();
         bfl.j(7424);
         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         bfl.w();
         bfl.d();
         avc.b();
      }
   }
}
