import com.google.common.base.Predicates;
import java.util.Iterator;
import java.util.Random;

public class aor extends aot {
   private static final amh a;
   private final alz c;
   private final alz d;
   private final alz b;

   static {
      a = amh.a((afh)afi.m).a(ajh.a, Predicates.equalTo(ajh.a.a));
   }

   public boolean b(adm var1, Random var2, cj var3) {
      while(var1.d(var3) && var3.o() > 2) {
         var3 = var3.b();
      }

      if (!a.a(var1.p(var3))) {
         return false;
      } else {
         int var4;
         int var5;
         for(var4 = -2; var4 <= 2; ++var4) {
            for(var5 = -2; var5 <= 2; ++var5) {
               if (var1.d(var3.a(var4, -1, var5)) && var1.d(var3.a(var4, -2, var5))) {
                  return false;
               }
            }
         }

         for(var4 = -1; var4 <= 0; ++var4) {
            for(var5 = -2; var5 <= 2; ++var5) {
               for(int var6 = -2; var6 <= 2; ++var6) {
                  var1.a((cj)var3.a(var5, var4, var6), (alz)this.c, 2);
               }
            }
         }

         var1.a((cj)var3, (alz)this.d, 2);
         Iterator var7 = cq.c.a.iterator();

         while(var7.hasNext()) {
            cq var8 = (cq)var7.next();
            var1.a((cj)var3.a(var8), (alz)this.d, 2);
         }

         for(var4 = -2; var4 <= 2; ++var4) {
            for(var5 = -2; var5 <= 2; ++var5) {
               if (var4 == -2 || var4 == 2 || var5 == -2 || var5 == 2) {
                  var1.a((cj)var3.a(var4, 1, var5), (alz)this.c, 2);
               }
            }
         }

         var1.a((cj)var3.a(2, 1, 0), (alz)this.b, 2);
         var1.a((cj)var3.a(-2, 1, 0), (alz)this.b, 2);
         var1.a((cj)var3.a(0, 1, 2), (alz)this.b, 2);
         var1.a((cj)var3.a(0, 1, -2), (alz)this.b, 2);

         for(var4 = -1; var4 <= 1; ++var4) {
            for(var5 = -1; var5 <= 1; ++var5) {
               if (var4 == 0 && var5 == 0) {
                  var1.a((cj)var3.a(var4, 4, var5), (alz)this.c, 2);
               } else {
                  var1.a((cj)var3.a(var4, 4, var5), (alz)this.b, 2);
               }
            }
         }

         for(var4 = 1; var4 <= 3; ++var4) {
            var1.a((cj)var3.a(-1, var4, -1), (alz)this.c, 2);
            var1.a((cj)var3.a(-1, var4, 1), (alz)this.c, 2);
            var1.a((cj)var3.a(1, var4, -1), (alz)this.c, 2);
            var1.a((cj)var3.a(1, var4, 1), (alz)this.c, 2);
         }

         return true;
      }
   }

   public aor() {
      this.b = afi.U.Q().a(akb.N, akb.a.b).a(ahh.a, ahh.a.b);
      this.c = afi.A.Q();
      this.d = afi.i.Q();
   }
}
