import java.util.Iterator;
import java.util.Random;

public class aje extends afh {
   public static final amn a = amn.a("age", 0, 15);

   public boolean e(adm var1, cj var2) {
      return this.d(var1, var2);
   }

   public boolean c() {
      return false;
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      if (var1.p(var2.b()).c() == afi.aM || this.e(var1, var2, var3)) {
         if (var1.d(var2.a())) {
            int var5;
            for(var5 = 1; var1.p(var2.c(var5)).c() == this; ++var5) {
            }

            if (var5 < 3) {
               int var6 = (Integer)var3.b(a);
               if (var6 == 15) {
                  var1.a(var2.a(), this.Q());
                  var1.a((cj)var2, (alz)var3.a(a, 0), 4);
               } else {
                  var1.a((cj)var2, (alz)var3.a(a, var6 + 1), 4);
               }
            }
         }

      }
   }

   public aug a(adm var1, cj var2, alz var3) {
      return null;
   }

   public int a(adq var1, cj var2, int var3) {
      return var1.b(var2).b(var2);
   }

   public zw a(alz var1, Random var2, int var3) {
      return zy.aJ;
   }

   protected aje() {
      super(arm.k);
      this.j(this.M.b().a(a, 0));
      float var1 = 0.375F;
      this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 1.0F, 0.5F + var1);
      this.a(true);
   }

   public alz a(int var1) {
      return this.Q().a(a, var1);
   }

   protected final boolean e(adm var1, cj var2, alz var3) {
      if (this.e(var1, var2)) {
         return true;
      } else {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
         return false;
      }
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      this.e(var1, var2, var3);
   }

   public zw c(adm var1, cj var2) {
      return zy.aJ;
   }

   public adf m() {
      return adf.c;
   }

   public int c(alz var1) {
      return (Integer)var1.b(a);
   }

   public boolean d() {
      return false;
   }

   public boolean d(adm var1, cj var2) {
      afh var3 = var1.p(var2.b()).c();
      if (var3 == this) {
         return true;
      } else if (var3 != afi.c && var3 != afi.d && var3 != afi.m) {
         return false;
      } else {
         Iterator var4 = cq.c.a.iterator();

         cq var5;
         do {
            if (!var4.hasNext()) {
               return false;
            }

            var5 = (cq)var4.next();
         } while(var1.p(var2.a(var5).b()).c().t() != arm.h);

         return true;
      }
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }
}
