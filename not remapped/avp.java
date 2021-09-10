public class avp {
   public static final jy c = new jy("textures/gui/container/stats_icons.png");
   public static final jy b = new jy("textures/gui/options_background.png");
   public static final jy d = new jy("textures/gui/icons.png");
   protected float e;

   public static void a(int var0, int var1, float var2, float var3, int var4, int var5, int var6, int var7, float var8, float var9) {
      float var10 = 1.0F / var8;
      float var11 = 1.0F / var9;
      bfx var12 = bfx.a();
      bfd var13 = var12.c();
      var13.a(7, bms.g);
      var13.b((double)var0, (double)(var1 + var7), 0.0D).a((double)(var2 * var10), (double)((var3 + (float)var5) * var11)).d();
      var13.b((double)(var0 + var6), (double)(var1 + var7), 0.0D).a((double)((var2 + (float)var4) * var10), (double)((var3 + (float)var5) * var11)).d();
      var13.b((double)(var0 + var6), (double)var1, 0.0D).a((double)((var2 + (float)var4) * var10), (double)(var3 * var11)).d();
      var13.b((double)var0, (double)var1, 0.0D).a((double)(var2 * var10), (double)(var3 * var11)).d();
      var12.b();
   }

   public void b(int var1, int var2, int var3, int var4, int var5, int var6) {
      float var7 = 0.00390625F;
      float var8 = 0.00390625F;
      bfx var9 = bfx.a();
      bfd var10 = var9.c();
      var10.a(7, bms.g);
      var10.b((double)var1, (double)(var2 + var6), (double)this.e).a((double)((float)var3 * var7), (double)((float)(var4 + var6) * var8)).d();
      var10.b((double)(var1 + var5), (double)(var2 + var6), (double)this.e).a((double)((float)(var3 + var5) * var7), (double)((float)(var4 + var6) * var8)).d();
      var10.b((double)(var1 + var5), (double)var2, (double)this.e).a((double)((float)(var3 + var5) * var7), (double)((float)var4 * var8)).d();
      var10.b((double)var1, (double)var2, (double)this.e).a((double)((float)var3 * var7), (double)((float)var4 * var8)).d();
      var9.b();
   }

   public void a(int var1, int var2, bmi var3, int var4, int var5) {
      bfx var6 = bfx.a();
      bfd var7 = var6.c();
      var7.a(7, bms.g);
      var7.b((double)var1, (double)(var2 + var5), (double)this.e).a((double)var3.e(), (double)var3.h()).d();
      var7.b((double)(var1 + var4), (double)(var2 + var5), (double)this.e).a((double)var3.f(), (double)var3.h()).d();
      var7.b((double)(var1 + var4), (double)var2, (double)this.e).a((double)var3.f(), (double)var3.g()).d();
      var7.b((double)var1, (double)var2, (double)this.e).a((double)var3.e(), (double)var3.g()).d();
      var6.b();
   }

   protected void a(int var1, int var2, int var3, int var4) {
      if (var2 < var1) {
         int var5 = var1;
         var1 = var2;
         var2 = var5;
      }

      a(var1, var3, var2 + 1, var3 + 1, var4);
   }

   public static void a(int var0, int var1, int var2, int var3, int var4) {
      int var5;
      if (var0 < var2) {
         var5 = var0;
         var0 = var2;
         var2 = var5;
      }

      if (var1 < var3) {
         var5 = var1;
         var1 = var3;
         var3 = var5;
      }

      float var11 = (float)(var4 >> 24 & 255) / 255.0F;
      float var6 = (float)(var4 >> 16 & 255) / 255.0F;
      float var7 = (float)(var4 >> 8 & 255) / 255.0F;
      float var8 = (float)(var4 & 255) / 255.0F;
      bfx var9 = bfx.a();
      bfd var10 = var9.c();
      bfl.l();
      bfl.x();
      bfl.a(770, 771, 1, 0);
      bfl.c(var6, var7, var8, var11);
      var10.a(7, bms.e);
      var10.b((double)var0, (double)var3, 0.0D).d();
      var10.b((double)var2, (double)var3, 0.0D).d();
      var10.b((double)var2, (double)var1, 0.0D).d();
      var10.b((double)var0, (double)var1, 0.0D).d();
      var9.b();
      bfl.w();
      bfl.k();
   }

   public void c(avn var1, String var2, int var3, int var4, int var5) {
      var1.a(var2, (float)var3, (float)var4, var5);
   }

   public void a(avn var1, String var2, int var3, int var4, int var5) {
      var1.a(var2, (float)(var3 - var1.a(var2) / 2), (float)var4, var5);
   }

   public static void a(int var0, int var1, float var2, float var3, int var4, int var5, float var6, float var7) {
      float var8 = 1.0F / var6;
      float var9 = 1.0F / var7;
      bfx var10 = bfx.a();
      bfd var11 = var10.c();
      var11.a(7, bms.g);
      var11.b((double)var0, (double)(var1 + var5), 0.0D).a((double)(var2 * var8), (double)((var3 + (float)var5) * var9)).d();
      var11.b((double)(var0 + var4), (double)(var1 + var5), 0.0D).a((double)((var2 + (float)var4) * var8), (double)((var3 + (float)var5) * var9)).d();
      var11.b((double)(var0 + var4), (double)var1, 0.0D).a((double)((var2 + (float)var4) * var8), (double)(var3 * var9)).d();
      var11.b((double)var0, (double)var1, 0.0D).a((double)(var2 * var8), (double)(var3 * var9)).d();
      var10.b();
   }

   protected void b(int var1, int var2, int var3, int var4) {
      if (var3 < var2) {
         int var5 = var2;
         var2 = var3;
         var3 = var5;
      }

      a(var1, var2 + 1, var1 + 1, var3, var4);
   }

   protected void a(int var1, int var2, int var3, int var4, int var5, int var6) {
      float var7 = (float)(var5 >> 24 & 255) / 255.0F;
      float var8 = (float)(var5 >> 16 & 255) / 255.0F;
      float var9 = (float)(var5 >> 8 & 255) / 255.0F;
      float var10 = (float)(var5 & 255) / 255.0F;
      float var11 = (float)(var6 >> 24 & 255) / 255.0F;
      float var12 = (float)(var6 >> 16 & 255) / 255.0F;
      float var13 = (float)(var6 >> 8 & 255) / 255.0F;
      float var14 = (float)(var6 & 255) / 255.0F;
      bfl.x();
      bfl.l();
      bfl.c();
      bfl.a(770, 771, 1, 0);
      bfl.j(7425);
      bfx var15 = bfx.a();
      bfd var16 = var15.c();
      var16.a(7, bms.f);
      var16.b((double)var3, (double)var2, (double)this.e).a(var8, var9, var10, var7).d();
      var16.b((double)var1, (double)var2, (double)this.e).a(var8, var9, var10, var7).d();
      var16.b((double)var1, (double)var4, (double)this.e).a(var12, var13, var14, var11).d();
      var16.b((double)var3, (double)var4, (double)this.e).a(var12, var13, var14, var11).d();
      var15.b();
      bfl.j(7424);
      bfl.k();
      bfl.d();
      bfl.w();
   }

   public void a(float var1, float var2, int var3, int var4, int var5, int var6) {
      float var7 = 0.00390625F;
      float var8 = 0.00390625F;
      bfx var9 = bfx.a();
      bfd var10 = var9.c();
      var10.a(7, bms.g);
      var10.b((double)(var1 + 0.0F), (double)(var2 + (float)var6), (double)this.e).a((double)((float)var3 * var7), (double)((float)(var4 + var6) * var8)).d();
      var10.b((double)(var1 + (float)var5), (double)(var2 + (float)var6), (double)this.e).a((double)((float)(var3 + var5) * var7), (double)((float)(var4 + var6) * var8)).d();
      var10.b((double)(var1 + (float)var5), (double)(var2 + 0.0F), (double)this.e).a((double)((float)(var3 + var5) * var7), (double)((float)var4 * var8)).d();
      var10.b((double)(var1 + 0.0F), (double)(var2 + 0.0F), (double)this.e).a((double)((float)var3 * var7), (double)((float)var4 * var8)).d();
      var9.b();
   }
}
