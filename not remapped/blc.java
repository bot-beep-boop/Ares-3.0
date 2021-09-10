public class blc implements blb<tv> {
   private final bbv c = new bbv();
   private static final jy a = new jy("textures/entity/sheep/sheep_fur.png");
   private final bjv b;

   public blc(bjv var1) {
      this.b = var1;
   }

   public void a(tv var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (!var1.cm() && !var1.ax()) {
         this.b.a((jy)a);
         if (var1.l_() && "jeb_".equals(var1.aM())) {
            boolean var17 = true;
            int var10 = var1.W / 25 + var1.F();
            int var11 = zd.values().length;
            int var12 = var10 % var11;
            int var13 = (var10 + 1) % var11;
            float var14 = ((float)(var1.W % 25) + var4) / 25.0F;
            float[] var15 = tv.a(zd.b(var12));
            float[] var16 = tv.a(zd.b(var13));
            bfl.c(var15[0] * (1.0F - var14) + var16[0] * var14, var15[1] * (1.0F - var14) + var16[1] * var14, var15[2] * (1.0F - var14) + var16[2] * var14);
         } else {
            float[] var9 = tv.a(var1.cl());
            bfl.c(var9[0], var9[1], var9[2]);
         }

         this.c.a(this.b.b());
         this.c.a(var1, var2, var3, var4);
         this.c.a(var1, var2, var3, var5, var6, var7, var8);
      }
   }

   public boolean b() {
      return true;
   }

   public void a(pr var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      this.a((tv)var1, var2, var3, var4, var5, var6, var7, var8);
   }
}
