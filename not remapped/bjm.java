public class bjm<T extends va> extends biv<T> {
   protected bbo a = new bbn();
   private static final jy e = new jy("textures/entity/minecart.png");

   public void a(T var1, double var2, double var4, double var6, float var8, float var9) {
      bfl.E();
      this.c(var1);
      long var10 = (long)var1.F() * 493286711L;
      var10 = var10 * var10 * 4392167121L + var10 * 98761L;
      float var12 = (((float)(var10 >> 16 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
      float var13 = (((float)(var10 >> 20 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
      float var14 = (((float)(var10 >> 24 & 7L) + 0.5F) / 8.0F - 0.5F) * 0.004F;
      bfl.b(var12, var13, var14);
      double var15 = var1.P + (var1.s - var1.P) * (double)var9;
      double var17 = var1.Q + (var1.t - var1.Q) * (double)var9;
      double var19 = var1.R + (var1.u - var1.R) * (double)var9;
      double var21 = 0.30000001192092896D;
      aui var23 = var1.k(var15, var17, var19);
      float var24 = var1.B + (var1.z - var1.B) * var9;
      if (var23 != null) {
         aui var25 = var1.a(var15, var17, var19, var21);
         aui var26 = var1.a(var15, var17, var19, -var21);
         if (var25 == null) {
            var25 = var23;
         }

         if (var26 == null) {
            var26 = var23;
         }

         var2 += var23.a - var15;
         var4 += (var25.b + var26.b) / 2.0D - var17;
         var6 += var23.c - var19;
         aui var27 = var26.b(-var25.a, -var25.b, -var25.c);
         if (var27.b() != 0.0D) {
            var27 = var27.a();
            var8 = (float)(Math.atan2(var27.c, var27.a) * 180.0D / 3.141592653589793D);
            var24 = (float)(Math.atan(var27.b) * 73.0D);
         }
      }

      bfl.b((float)var2, (float)var4 + 0.375F, (float)var6);
      bfl.b(180.0F - var8, 0.0F, 1.0F, 0.0F);
      bfl.b(-var24, 0.0F, 0.0F, 1.0F);
      float var30 = (float)var1.q() - var9;
      float var31 = var1.p() - var9;
      if (var31 < 0.0F) {
         var31 = 0.0F;
      }

      if (var30 > 0.0F) {
         bfl.b(ns.a(var30) * var30 * var31 / 10.0F * (float)var1.r(), 1.0F, 0.0F, 0.0F);
      }

      int var32 = var1.v();
      alz var28 = var1.t();
      if (var28.c().b() != -1) {
         bfl.E();
         this.a((jy)bmh.g);
         float var29 = 0.75F;
         bfl.a(var29, var29, var29);
         bfl.b(-0.5F, (float)(var32 - 8) / 16.0F, 0.5F);
         this.a(var1, var9, var28);
         bfl.F();
         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         this.c(var1);
      }

      bfl.a(-1.0F, -1.0F, 1.0F);
      this.a.a(var1, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
      bfl.F();
      super.a(var1, var2, var4, var6, var8, var9);
   }

   protected jy a(pk var1) {
      return this.a((va)var1);
   }

   protected jy a(T var1) {
      return e;
   }

   protected void a(T var1, float var2, alz var3) {
      bfl.E();
      ave.A().ae().a(var3, var1.c(var2));
      bfl.F();
   }

   public bjm(biu var1) {
      super(var1);
      this.c = 0.5F;
   }

   public void a(pk var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((va)var1, var2, var4, var6, var8, var9);
   }
}
