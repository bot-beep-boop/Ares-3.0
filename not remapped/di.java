public class di {
   private static dj b = new dj();
   private static dj a = dj.a();

   public static String a(String var0, Object... var1) {
      return a.a(var0, var1);
   }

   public static String a(String var0) {
      return a.a(var0);
   }

   public static boolean c(String var0) {
      return a.b(var0);
   }

   public static long a() {
      return a.c();
   }

   public static String b(String var0) {
      return b.a(var0);
   }
}
