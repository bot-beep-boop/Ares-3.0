public class bhf extends bhd<ale> {
   private static final jy c = new jy("textures/entity/enchanting_table_book.png");
   private bay d = new bay();

   public void a(ale var1, double var2, double var4, double var6, float var8, int var9) {
      bfl.E();
      bfl.b((float)var2 + 0.5F, (float)var4 + 0.75F, (float)var6 + 0.5F);
      float var10 = (float)var1.a + var8;
      bfl.b(0.0F, 0.1F + ns.a(var10 * 0.1F) * 0.01F, 0.0F);

      float var11;
      for(var11 = var1.l - var1.m; var11 >= 3.1415927F; var11 -= 6.2831855F) {
      }

      while(var11 < -3.1415927F) {
         var11 += 6.2831855F;
      }

      float var12 = var1.m + var11 * var8;
      bfl.b(-var12 * 180.0F / 3.1415927F, 0.0F, 1.0F, 0.0F);
      bfl.b(80.0F, 0.0F, 0.0F, 1.0F);
      this.a(c);
      float var13 = var1.g + (var1.f - var1.g) * var8 + 0.25F;
      float var14 = var1.g + (var1.f - var1.g) * var8 + 0.75F;
      var13 = (var13 - (float)ns.b((double)var13)) * 1.6F - 0.3F;
      var14 = (var14 - (float)ns.b((double)var14)) * 1.6F - 0.3F;
      if (var13 < 0.0F) {
         var13 = 0.0F;
      }

      if (var14 < 0.0F) {
         var14 = 0.0F;
      }

      if (var13 > 1.0F) {
         var13 = 1.0F;
      }

      if (var14 > 1.0F) {
         var14 = 1.0F;
      }

      float var15 = var1.k + (var1.j - var1.k) * var8;
      bfl.o();
      this.d.a((pk)null, var10, var13, var14, var15, 0.0F, 0.0625F);
      bfl.F();
   }

   public void a(akw var1, double var2, double var4, double var6, float var8, int var9) {
      this.a((ale)var1, var2, var4, var6, var8, var9);
   }
}
