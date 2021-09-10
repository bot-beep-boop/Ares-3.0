import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;

public class avu {
   public static List<eu> a(eu var0, int var1, avn var2, boolean var3, boolean var4) {
      int var5 = 0;
      fa var6 = new fa("");
      ArrayList var7 = Lists.newArrayList();
      ArrayList var8 = Lists.newArrayList(var0);

      for(int var9 = 0; var9 < var8.size(); ++var9) {
         eu var10 = (eu)var8.get(var9);
         String var11 = var10.e();
         boolean var12 = false;
         String var14;
         if (var11.contains("\n")) {
            int var13 = var11.indexOf(10);
            var14 = var11.substring(var13 + 1);
            var11 = var11.substring(0, var13 + 1);
            fa var15 = new fa(var14);
            var15.a(var10.b().m());
            var8.add(var9 + 1, var15);
            var12 = true;
         }

         String var21 = a(var10.b().k() + var11, var4);
         var14 = var21.endsWith("\n") ? var21.substring(0, var21.length() - 1) : var21;
         int var22 = var2.a(var14);
         fa var16 = new fa(var14);
         var16.a(var10.b().m());
         if (var5 + var22 > var1) {
            String var17 = var2.a(var21, var1 - var5, false);
            String var18 = var17.length() < var21.length() ? var21.substring(var17.length()) : null;
            if (var18 != null && var18.length() > 0) {
               int var19 = var17.lastIndexOf(" ");
               if (var19 >= 0 && var2.a(var21.substring(0, var19)) > 0) {
                  var17 = var21.substring(0, var19);
                  if (var3) {
                     ++var19;
                  }

                  var18 = var21.substring(var19);
               } else if (var5 > 0 && !var21.contains(" ")) {
                  var17 = "";
                  var18 = var21;
               }

               fa var20 = new fa(var18);
               var20.a(var10.b().m());
               var8.add(var9 + 1, var20);
            }

            var22 = var2.a(var17);
            var16 = new fa(var17);
            var16.a(var10.b().m());
            var12 = true;
         }

         if (var5 + var22 <= var1) {
            var5 += var22;
            var6.a((eu)var16);
         } else {
            var12 = true;
         }

         if (var12) {
            var7.add(var6);
            var5 = 0;
            var6 = new fa("");
         }
      }

      var7.add(var6);
      return var7;
   }

   public static String a(String var0, boolean var1) {
      return !var1 && !ave.A().t.n ? a.a(var0) : var0;
   }
}
