public abstract class bjo<T extends ps> extends bjl<T> {
   protected boolean a(pr var1) {
      return this.b((ps)var1);
   }

   public bjo(biu var1, bbo var2, float var3) {
      super(var1, var2, var3);
   }

   private double a(double var1, double var3, double var5) {
      return var1 + (var3 - var1) * var5;
   }

   public void a(T var1, float var2) {
      int var3 = var1.b(var2);
      int var4 = var3 % 65536;
      int var5 = var3 / 65536;
      bqs.a(bqs.r, (float)var4 / 1.0F, (float)var5 / 1.0F);
   }

   public boolean a(pk var1, bia var2, double var3, double var5, double var7) {
      return this.a((ps)var1, var2, var3, var5, var7);
   }

   public void a(pk var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((ps)var1, var2, var4, var6, var8, var9);
   }

   protected boolean b(T var1) {
      return super.a((pr)var1) && (var1.aO() || var1.l_() && var1 == this.b.d);
   }

   public boolean a(T var1, bia var2, double var3, double var5, double var7) {
      if (super.a(var1, var2, var3, var5, var7)) {
         return true;
      } else if (var1.cc() && var1.cd() != null) {
         pk var9 = var1.cd();
         return var2.a(var9.aR());
      } else {
         return false;
      }
   }

   protected void b(T var1, double var2, double var4, double var6, float var8, float var9) {
      pk var10 = var1.cd();
      if (var10 != null) {
         var4 -= (1.6D - (double)var1.K) * 0.5D;
         bfx var11 = bfx.a();
         bfd var12 = var11.c();
         double var13 = this.a((double)var10.A, (double)var10.y, (double)(var9 * 0.5F)) * 0.01745329238474369D;
         double var15 = this.a((double)var10.B, (double)var10.z, (double)(var9 * 0.5F)) * 0.01745329238474369D;
         double var17 = Math.cos(var13);
         double var19 = Math.sin(var13);
         double var21 = Math.sin(var15);
         if (var10 instanceof un) {
            var17 = 0.0D;
            var19 = 0.0D;
            var21 = -1.0D;
         }

         double var23 = Math.cos(var15);
         double var25 = this.a(var10.p, var10.s, (double)var9) - var17 * 0.7D - var19 * 0.5D * var23;
         double var27 = this.a(var10.q + (double)var10.aS() * 0.7D, var10.t + (double)var10.aS() * 0.7D, (double)var9) - var21 * 0.5D - 0.25D;
         double var29 = this.a(var10.r, var10.u, (double)var9) - var19 * 0.7D + var17 * 0.5D * var23;
         double var31 = this.a((double)var1.aJ, (double)var1.aI, (double)var9) * 0.01745329238474369D + 1.5707963267948966D;
         var17 = Math.cos(var31) * (double)var1.J * 0.4D;
         var19 = Math.sin(var31) * (double)var1.J * 0.4D;
         double var33 = this.a(var1.p, var1.s, (double)var9) + var17;
         double var35 = this.a(var1.q, var1.t, (double)var9);
         double var37 = this.a(var1.r, var1.u, (double)var9) + var19;
         var2 += var17;
         var6 += var19;
         double var39 = (double)((float)(var25 - var33));
         double var41 = (double)((float)(var27 - var35));
         double var43 = (double)((float)(var29 - var37));
         bfl.x();
         bfl.f();
         bfl.p();
         boolean var45 = true;
         double var46 = 0.025D;
         var12.a(5, bms.f);

         int var48;
         float var49;
         float var50;
         float var51;
         float var52;
         for(var48 = 0; var48 <= 24; ++var48) {
            var49 = 0.5F;
            var50 = 0.4F;
            var51 = 0.3F;
            if (var48 % 2 == 0) {
               var49 *= 0.7F;
               var50 *= 0.7F;
               var51 *= 0.7F;
            }

            var52 = (float)var48 / 24.0F;
            var12.b(var2 + var39 * (double)var52 + 0.0D, var4 + var41 * (double)(var52 * var52 + var52) * 0.5D + (double)((24.0F - (float)var48) / 18.0F + 0.125F), var6 + var43 * (double)var52).a(var49, var50, var51, 1.0F).d();
            var12.b(var2 + var39 * (double)var52 + 0.025D, var4 + var41 * (double)(var52 * var52 + var52) * 0.5D + (double)((24.0F - (float)var48) / 18.0F + 0.125F) + 0.025D, var6 + var43 * (double)var52).a(var49, var50, var51, 1.0F).d();
         }

         var11.b();
         var12.a(5, bms.f);

         for(var48 = 0; var48 <= 24; ++var48) {
            var49 = 0.5F;
            var50 = 0.4F;
            var51 = 0.3F;
            if (var48 % 2 == 0) {
               var49 *= 0.7F;
               var50 *= 0.7F;
               var51 *= 0.7F;
            }

            var52 = (float)var48 / 24.0F;
            var12.b(var2 + var39 * (double)var52 + 0.0D, var4 + var41 * (double)(var52 * var52 + var52) * 0.5D + (double)((24.0F - (float)var48) / 18.0F + 0.125F) + 0.025D, var6 + var43 * (double)var52).a(var49, var50, var51, 1.0F).d();
            var12.b(var2 + var39 * (double)var52 + 0.025D, var4 + var41 * (double)(var52 * var52 + var52) * 0.5D + (double)((24.0F - (float)var48) / 18.0F + 0.125F), var6 + var43 * (double)var52 + 0.025D).a(var49, var50, var51, 1.0F).d();
         }

         var11.b();
         bfl.e();
         bfl.w();
         bfl.o();
      }

   }

   public void a(T var1, double var2, double var4, double var6, float var8, float var9) {
      super.a((pr)var1, var2, var4, var6, var8, var9);
      this.b(var1, var2, var4, var6, var8, var9);
   }

   public void a(pr var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((ps)var1, var2, var4, var6, var8, var9);
   }

   protected boolean b(pk var1) {
      return this.b((ps)var1);
   }
}
