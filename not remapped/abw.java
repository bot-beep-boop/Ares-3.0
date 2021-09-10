import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class abw implements abs {
   private final zx a;
   private final List<zx> b;

   public zx a(xp var1) {
      return this.a.k();
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
      return this.b.size();
   }

   public abw(zx var1, List<zx> var2) {
      this.a = var1;
      this.b = var2;
   }

   public zx b() {
      return this.a;
   }

   public boolean a(xp var1, adm var2) {
      ArrayList var3 = Lists.newArrayList(this.b);

      for(int var4 = 0; var4 < var1.h(); ++var4) {
         for(int var5 = 0; var5 < var1.i(); ++var5) {
            zx var6 = var1.c(var5, var4);
            if (var6 != null) {
               boolean var7 = false;
               Iterator var8 = var3.iterator();

               while(var8.hasNext()) {
                  zx var9 = (zx)var8.next();
                  if (var6.b() == var9.b() && (var9.i() == 32767 || var6.i() == var9.i())) {
                     var7 = true;
                     var3.remove(var9);
                     break;
                  }
               }

               if (!var7) {
                  return false;
               }
            }
         }
      }

      return var3.isEmpty();
   }
}
