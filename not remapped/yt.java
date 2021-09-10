public class yt extends zw {
   public static final String[] a = new String[]{"pulling_0", "pulling_1", "pulling_2"};

   public yt() {
      this.h = 1;
      this.d(384);
      this.a(yz.j);
   }

   public int b() {
      return 1;
   }

   public zx b(zx var1, adm var2, wn var3) {
      return var1;
   }

   public void a(zx var1, adm var2, wn var3, int var4) {
      boolean var5 = var3.bA.d || ack.a(aci.y.B, var1) > 0;
      if (var5 || var3.bi.b(zy.g)) {
         int var6 = this.d(var1) - var4;
         float var7 = (float)var6 / 20.0F;
         var7 = (var7 * var7 + var7 * 2.0F) / 3.0F;
         if ((double)var7 < 0.1D) {
            return;
         }

         if (var7 > 1.0F) {
            var7 = 1.0F;
         }

         wq var8 = new wq(var2, var3, var7 * 2.0F);
         if (var7 == 1.0F) {
            var8.a(true);
         }

         int var9 = ack.a(aci.v.B, var1);
         if (var9 > 0) {
            var8.b(var8.j() + (double)var9 * 0.5D + 0.5D);
         }

         int var10 = ack.a(aci.w.B, var1);
         if (var10 > 0) {
            var8.a(var10);
         }

         if (ack.a(aci.x.B, var1) > 0) {
            var8.e(100);
         }

         var1.a(1, (pr)var3);
         var2.a((pk)var3, "random.bow", 1.0F, 1.0F / (g.nextFloat() * 0.4F + 1.2F) + var7 * 0.5F);
         if (var5) {
            var8.a = 2;
         } else {
            var3.bi.a(zy.g);
         }

         var3.b(na.ad[zw.b((zw)this)]);
         if (!var2.D) {
            var2.d((pk)var8);
         }
      }

   }

   public zx a(zx var1, adm var2, wn var3) {
      if (var3.bA.d || var3.bi.b(zy.g)) {
         var3.a(var1, this.d(var1));
      }

      return var1;
   }

   public aba e(zx var1) {
      return aba.e;
   }

   public int d(zx var1) {
      return 72000;
   }
}
