import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class nx {
   private static final Pattern a = Pattern.compile("(?i)\\u00A7[0-9A-FK-OR]");

   public static String a(int var0) {
      int var1 = var0 / 20;
      int var2 = var1 / 60;
      var1 %= 60;
      return var1 < 10 ? var2 + ":0" + var1 : var2 + ":" + var1;
   }

   public static boolean b(String var0) {
      return StringUtils.isEmpty(var0);
   }

   public static String a(String var0) {
      return a.matcher(var0).replaceAll("");
   }
}
