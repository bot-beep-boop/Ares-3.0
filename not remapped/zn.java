import java.util.List;

public class zn extends zw {
   public static eb a(zx var0, String var1) {
      if (var0.n()) {
         dn var2 = var0.o().m("Explosion");
         if (var2 != null) {
            return var2.a(var1);
         }
      }

      return null;
   }

   public void a(zx var1, wn var2, List<String> var3, boolean var4) {
      if (var1.n()) {
         dn var5 = var1.o().m("Explosion");
         if (var5 != null) {
            a(var5, var3);
         }
      }

   }

   public static void a(dn var0, List<String> var1) {
      byte var2 = var0.d("Type");
      if (var2 >= 0 && var2 <= 4) {
         var1.add(di.a("item.fireworksCharge.type." + var2).trim());
      } else {
         var1.add(di.a("item.fireworksCharge.type").trim());
      }

      int[] var3 = var0.l("Colors");
      int var8;
      int var9;
      if (var3.length > 0) {
         boolean var4 = true;
         String var5 = "";
         int[] var6 = var3;
         int var7 = var3.length;

         for(var8 = 0; var8 < var7; ++var8) {
            var9 = var6[var8];
            if (!var4) {
               var5 = var5 + ", ";
            }

            var4 = false;
            boolean var10 = false;

            for(int var11 = 0; var11 < ze.a.length; ++var11) {
               if (var9 == ze.a[var11]) {
                  var10 = true;
                  var5 = var5 + di.a("item.fireworksCharge." + zd.a(var11).d());
                  break;
               }
            }

            if (!var10) {
               var5 = var5 + di.a("item.fireworksCharge.customColor");
            }
         }

         var1.add(var5);
      }

      int[] var13 = var0.l("FadeColors");
      boolean var15;
      if (var13.length > 0) {
         var15 = true;
         String var14 = di.a("item.fireworksCharge.fadeTo") + " ";
         int[] var16 = var13;
         var8 = var13.length;

         for(var9 = 0; var9 < var8; ++var9) {
            int var18 = var16[var9];
            if (!var15) {
               var14 = var14 + ", ";
            }

            var15 = false;
            boolean var19 = false;

            for(int var12 = 0; var12 < 16; ++var12) {
               if (var18 == ze.a[var12]) {
                  var19 = true;
                  var14 = var14 + di.a("item.fireworksCharge." + zd.a(var12).d());
                  break;
               }
            }

            if (!var19) {
               var14 = var14 + di.a("item.fireworksCharge.customColor");
            }
         }

         var1.add(var14);
      }

      var15 = var0.n("Trail");
      if (var15) {
         var1.add(di.a("item.fireworksCharge.trail"));
      }

      boolean var17 = var0.n("Flicker");
      if (var17) {
         var1.add(di.a("item.fireworksCharge.flicker"));
      }

   }

   public int a(zx var1, int var2) {
      if (var2 != 1) {
         return super.a(var1, var2);
      } else {
         eb var3 = a(var1, "Colors");
         if (!(var3 instanceof ds)) {
            return 9079434;
         } else {
            ds var4 = (ds)var3;
            int[] var5 = var4.c();
            if (var5.length == 1) {
               return var5[0];
            } else {
               int var6 = 0;
               int var7 = 0;
               int var8 = 0;
               int[] var9 = var5;
               int var10 = var5.length;

               for(int var11 = 0; var11 < var10; ++var11) {
                  int var12 = var9[var11];
                  var6 += (var12 & 16711680) >> 16;
                  var7 += (var12 & '\uff00') >> 8;
                  var8 += (var12 & 255) >> 0;
               }

               var6 /= var5.length;
               var7 /= var5.length;
               var8 /= var5.length;
               return var6 << 16 | var7 << 8 | var8;
            }
         }
      }
   }
}
