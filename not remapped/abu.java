import com.google.common.collect.Lists;
import java.util.ArrayList;

public class abu implements abs {
   public zx a(xp var1) {
      ArrayList var2 = Lists.newArrayList();

      zx var4;
      for(int var3 = 0; var3 < var1.o_(); ++var3) {
         var4 = var1.a(var3);
         if (var4 != null) {
            var2.add(var4);
            if (var2.size() > 1) {
               zx var5 = (zx)var2.get(0);
               if (var4.b() != var5.b() || var5.b != 1 || var4.b != 1 || !var5.b().m()) {
                  return null;
               }
            }
         }
      }

      if (var2.size() == 2) {
         zx var10 = (zx)var2.get(0);
         var4 = (zx)var2.get(1);
         if (var10.b() == var4.b() && var10.b == 1 && var4.b == 1 && var10.b().m()) {
            zw var11 = var10.b();
            int var6 = var11.l() - var10.h();
            int var7 = var11.l() - var4.h();
            int var8 = var6 + var7 + var11.l() * 5 / 100;
            int var9 = var11.l() - var8;
            if (var9 < 0) {
               var9 = 0;
            }

            return new zx(var10.b(), 1, var9);
         }
      }

      return null;
   }

   public zx[] b(xp var1) {
      zx[] var2 = new zx[var1.o_()];

      for(int var3 = 0; var3 < var2.length; ++var3) {
         zx var4 = var1.a(var3);
         if (var4 != null && var4.b().r()) {
            var2[var3] = new zx(var4.b().q());
         }
      }

      return var2;
   }

   public int a() {
      return 4;
   }

   public zx b() {
      return null;
   }

   public boolean a(xp var1, adm var2) {
      ArrayList var3 = Lists.newArrayList();

      for(int var4 = 0; var4 < var1.o_(); ++var4) {
         zx var5 = var1.a(var4);
         if (var5 != null) {
            var3.add(var5);
            if (var3.size() > 1) {
               zx var6 = (zx)var3.get(0);
               if (var5.b() != var6.b() || var6.b != 1 || var5.b != 1 || !var6.b().m()) {
                  return false;
               }
            }
         }
      }

      return var3.size() == 2;
   }
}
