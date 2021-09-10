import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

public class jy {
   protected final String b;
   protected final String a;

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof jy)) {
         return false;
      } else {
         jy var2 = (jy)var1;
         return this.a.equals(var2.a) && this.b.equals(var2.b);
      }
   }

   public jy(String var1) {
      this(0, a(var1));
   }

   public String a() {
      return this.b;
   }

   public String b() {
      return this.a;
   }

   public jy(String var1, String var2) {
      this(0, var1, var2);
   }

   public int hashCode() {
      return 31 * this.a.hashCode() + this.b.hashCode();
   }

   protected jy(int var1, String... var2) {
      this.a = StringUtils.isEmpty(var2[0]) ? "minecraft" : var2[0].toLowerCase();
      this.b = var2[1];
      Validate.notNull(this.b);
   }

   public String toString() {
      return this.a + ':' + this.b;
   }

   protected static String[] a(String var0) {
      String[] var1 = new String[]{null, var0};
      int var2 = var0.indexOf(58);
      if (var2 >= 0) {
         var1[1] = var0.substring(var2 + 1, var0.length());
         if (var2 > 1) {
            var1[0] = var0.substring(0, var2);
         }
      }

      return var1;
   }
}
