import java.util.Iterator;

public class aea {
   private static final aea.a a = new aea.a() {
      public int a(ady var1, cj var2) {
         return var1.b(var2);
      }
   };
   private static final aea.a c = new aea.a() {
      public int a(ady var1, cj var2) {
         return var1.ar;
      }
   };
   private static final aea.a b = new aea.a() {
      public int a(ady var1, cj var2) {
         return var1.c(var2);
      }
   };

   private static int a(adq var0, cj var1, aea.a var2) {
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;

      int var8;
      for(Iterator var6 = cj.b(var1.a(-1, 0, -1), var1.a(1, 0, 1)).iterator(); var6.hasNext(); var5 += var8 & 255) {
         cj.a var7 = (cj.a)var6.next();
         var8 = var2.a(var0.b(var7), var7);
         var3 += (var8 & 16711680) >> 16;
         var4 += (var8 & '\uff00') >> 8;
      }

      return (var3 / 9 & 255) << 16 | (var4 / 9 & 255) << 8 | var5 / 9 & 255;
   }

   public static int a(adq var0, cj var1) {
      return a(var0, var1, a);
   }

   public static int c(adq var0, cj var1) {
      return a(var0, var1, c);
   }

   public static int b(adq var0, cj var1) {
      return a(var0, var1, b);
   }

   interface a {
      int a(ady var1, cj var2);
   }
}
