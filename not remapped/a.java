import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

public enum a {
   c("DARK_GREEN", '2', 2),
   t("UNDERLINE", 'n', true);

   private final String B;
   v("RESET", 'r', -1),
   g("GOLD", '6', 6),
   a("BLACK", '0', 0);

   private final char z;
   j("BLUE", '9', 9),
   d("DARK_AQUA", '3', 3);

   private static final a[] D = new a[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v};
   private static final Pattern x = Pattern.compile("(?i)" + String.valueOf('§') + "[0-9A-FK-OR]");
   i("DARK_GRAY", '8', 8),
   m("RED", 'c', 12),
   l("AQUA", 'b', 11),
   k("GREEN", 'a', 10),
   f("DARK_PURPLE", '5', 5),
   u("ITALIC", 'o', true);

   private final int C;
   r("BOLD", 'l', true),
   q("OBFUSCATED", 'k', true);

   private final String y;
   h("GRAY", '7', 7),
   n("LIGHT_PURPLE", 'd', 13),
   p("WHITE", 'f', 15);

   private static final Map<String, a> w = Maps.newHashMap();
   s("STRIKETHROUGH", 'm', true);

   private final boolean A;
   b("DARK_BLUE", '1', 1),
   o("YELLOW", 'e', 14),
   e("DARK_RED", '4', 4);

   private static String c(String var0) {
      return var0.toLowerCase().replaceAll("[^a-z]", "");
   }

   private a(String var3, char var4, int var5) {
      this(var3, var4, false, var5);
   }

   public static a a(int var0) {
      if (var0 < 0) {
         return v;
      } else {
         a[] var1 = values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            a var4 = var1[var3];
            if (var4.b() == var0) {
               return var4;
            }
         }

         return null;
      }
   }

   public boolean d() {
      return !this.A && this != v;
   }

   public static String a(String var0) {
      return var0 == null ? null : x.matcher(var0).replaceAll("");
   }

   public static a b(String var0) {
      return var0 == null ? null : (a)w.get(c(var0));
   }

   private a(String var3, char var4, boolean var5, int var6) {
      this.y = var3;
      this.z = var4;
      this.A = var5;
      this.C = var6;
      this.B = "§" + var4;
   }

   static {
      a[] var0 = values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         a var3 = var0[var2];
         w.put(c(var3.y), var3);
      }

   }

   public boolean c() {
      return this.A;
   }

   public String toString() {
      return this.B;
   }

   public int b() {
      return this.C;
   }

   public String e() {
      return this.name().toLowerCase();
   }

   public static Collection<String> a(boolean var0, boolean var1) {
      ArrayList var2 = Lists.newArrayList();
      a[] var3 = values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         a var6 = var3[var5];
         if ((!var6.d() || var0) && (!var6.c() || var1)) {
            var2.add(var6.e());
         }
      }

      return var2;
   }

   private a(String var3, char var4, boolean var5) {
      this(var3, var4, var5, -1);
   }
}
