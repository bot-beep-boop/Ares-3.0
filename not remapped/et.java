import com.google.common.collect.Maps;
import java.util.Map;

public class et {
   private final et.a a;
   private final String b;

   public String toString() {
      return "ClickEvent{action=" + this.a + ", value='" + this.b + '\'' + '}';
   }

   public int hashCode() {
      int var1 = this.a.hashCode();
      var1 = 31 * var1 + (this.b != null ? this.b.hashCode() : 0);
      return var1;
   }

   public et.a a() {
      return this.a;
   }

   public String b() {
      return this.b;
   }

   public et(et.a var1, String var2) {
      this.a = var1;
      this.b = var2;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         et var2 = (et)var1;
         if (this.a != var2.a) {
            return false;
         } else {
            if (this.b != null) {
               if (!this.b.equals(var2.b)) {
                  return false;
               }
            } else if (var2.b != null) {
               return false;
            }

            return true;
         }
      } else {
         return false;
      }
   }

   public static enum a {
      private static final Map<String, et.a> g = Maps.newHashMap();
      private final boolean h;
      f("change_page", true),
      b("open_file", false);

      private final String i;
      a("open_url", true),
      c("run_command", true),
      d("twitch_user_info", false),
      e("suggest_command", true);

      private static final et.a[] j = new et.a[]{a, b, c, d, e, f};

      public String b() {
         return this.i;
      }

      private a(String var3, boolean var4) {
         this.i = var3;
         this.h = var4;
      }

      public static et.a a(String var0) {
         return (et.a)g.get(var0);
      }

      public boolean a() {
         return this.h;
      }

      static {
         et.a[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            et.a var3 = var0[var2];
            g.put(var3.b(), var3);
         }

      }
   }
}
