import com.google.common.collect.Maps;
import java.util.Map;

public class ew {
   private final ew.a a;
   private final eu b;

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         ew var2 = (ew)var1;
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

   public eu b() {
      return this.b;
   }

   public ew(ew.a var1, eu var2) {
      this.a = var1;
      this.b = var2;
   }

   public int hashCode() {
      int var1 = this.a.hashCode();
      var1 = 31 * var1 + (this.b != null ? this.b.hashCode() : 0);
      return var1;
   }

   public ew.a a() {
      return this.a;
   }

   public String toString() {
      return "HoverEvent{action=" + this.a + ", value='" + this.b + '\'' + '}';
   }

   public static enum a {
      b("show_achievement", true);

      private final String g;
      private final boolean f;
      private static final ew.a[] h = new ew.a[]{a, b, c, d};
      a("show_text", true);

      private static final Map<String, ew.a> e = Maps.newHashMap();
      d("show_entity", true),
      c("show_item", true);

      private a(String var3, boolean var4) {
         this.g = var3;
         this.f = var4;
      }

      public boolean a() {
         return this.f;
      }

      public static ew.a a(String var0) {
         return (ew.a)e.get(var0);
      }

      public String b() {
         return this.g;
      }

      static {
         ew.a[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            ew.a var3 = var0[var2];
            e.put(var3.b(), var3);
         }

      }
   }
}
