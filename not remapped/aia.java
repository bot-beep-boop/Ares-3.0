import java.util.Iterator;
import java.util.Random;

public class aia extends afm implements afj {
   public boolean a(adm var1, cj var2, alz var3, boolean var4) {
      return true;
   }

   public boolean d(adm var1, cj var2, alz var3, Random var4) {
      var1.g(var2);
      aoz var5 = null;
      if (this == afi.P) {
         var5 = new aoz(afi.bg);
      } else if (this == afi.Q) {
         var5 = new aoz(afi.bh);
      }

      if (var5 != null && var5.b(var1, var4, var2)) {
         return true;
      } else {
         var1.a((cj)var2, (alz)var3, 3);
         return false;
      }
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      if (var4.nextInt(25) == 0) {
         int var5 = 5;
         boolean var6 = true;
         Iterator var7 = cj.b(var2.a(-4, -1, -4), var2.a(4, 1, 4)).iterator();

         while(var7.hasNext()) {
            cj var8 = (cj)var7.next();
            if (var1.p(var8).c() == this) {
               --var5;
               if (var5 <= 0) {
                  return;
               }
            }
         }

         cj var9 = var2.a(var4.nextInt(3) - 1, var4.nextInt(2) - var4.nextInt(2), var4.nextInt(3) - 1);

         for(int var10 = 0; var10 < 4; ++var10) {
            if (var1.d(var9) && this.f(var1, var9, this.Q())) {
               var2 = var9;
            }

            var9 = var2.a(var4.nextInt(3) - 1, var4.nextInt(2) - var4.nextInt(2), var4.nextInt(3) - 1);
         }

         if (var1.d(var9) && this.f(var1, var9, this.Q())) {
            var1.a((cj)var9, (alz)this.Q(), 2);
         }
      }

   }

   protected boolean c(afh var1) {
      return var1.o();
   }

   public boolean f(adm var1, cj var2, alz var3) {
      if (var2.o() >= 0 && var2.o() < 256) {
         alz var4 = var1.p(var2.b());
         if (var4.c() == afi.bw) {
            return true;
         } else if (var4.c() == afi.d && var4.b(agf.a) == agf.a.c) {
            return true;
         } else {
            return var1.k(var2) < 13 && this.c(var4.c());
         }
      } else {
         return false;
      }
   }

   public boolean a(adm var1, Random var2, cj var3, alz var4) {
      return (double)var2.nextFloat() < 0.4D;
   }

   public void b(adm var1, Random var2, cj var3, alz var4) {
      this.d(var1, var3, var4, var2);
   }

   protected aia() {
      float var1 = 0.2F;
      this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var1 * 2.0F, 0.5F + var1);
      this.a(true);
   }

   public boolean d(adm var1, cj var2) {
      return super.d(var1, var2) && this.f(var1, var2, this.Q());
   }
}
