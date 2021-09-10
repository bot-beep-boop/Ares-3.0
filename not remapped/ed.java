import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ed {
   private static final Pattern b = Pattern.compile("\\[[-+\\d|,\\s]+\\]");
   private static final Logger a = LogManager.getLogger();

   private static int a(String var0, char var1) {
      int var2 = 0;

      for(boolean var3 = true; var2 < var0.length(); ++var2) {
         char var4 = var0.charAt(var2);
         if (var4 == '"') {
            if (!b(var0, var2)) {
               var3 = !var3;
            }
         } else if (var3) {
            if (var4 == var1) {
               return var2;
            }

            if (var4 == '{' || var4 == '[') {
               return -1;
            }
         }
      }

      return -1;
   }

   static ed.a a(String... var0) throws ec {
      return a(var0[0], var0[1]);
   }

   private static String d(String var0, boolean var1) throws ec {
      if (var1) {
         var0 = var0.trim();
         if (var0.startsWith("{") || var0.startsWith("[")) {
            return var0;
         }
      }

      int var2 = a(var0, ':');
      if (var2 == -1) {
         if (var1) {
            return var0;
         } else {
            throw new ec("Unable to locate name/value separator for string: " + var0);
         }
      } else {
         return var0.substring(var2 + 1).trim();
      }
   }

   private static String c(String var0, boolean var1) throws ec {
      if (var1) {
         var0 = var0.trim();
         if (var0.startsWith("{") || var0.startsWith("[")) {
            return "";
         }
      }

      int var2 = a(var0, ':');
      if (var2 == -1) {
         if (var1) {
            return "";
         } else {
            throw new ec("Unable to locate name/value separator for string: " + var0);
         }
      } else {
         return var0.substring(0, var2).trim();
      }
   }

   static int b(String var0) throws ec {
      int var1 = 0;
      boolean var2 = false;
      Stack var3 = new Stack();

      for(int var4 = 0; var4 < var0.length(); ++var4) {
         char var5 = var0.charAt(var4);
         if (var5 == '"') {
            if (b(var0, var4)) {
               if (!var2) {
                  throw new ec("Illegal use of \\\": " + var0);
               }
            } else {
               var2 = !var2;
            }
         } else if (!var2) {
            if (var5 != '{' && var5 != '[') {
               if (var5 == '}' && (var3.isEmpty() || (Character)var3.pop() != '{')) {
                  throw new ec("Unbalanced curly brackets {}: " + var0);
               }

               if (var5 == ']' && (var3.isEmpty() || (Character)var3.pop() != '[')) {
                  throw new ec("Unbalanced square brackets []: " + var0);
               }
            } else {
               if (var3.isEmpty()) {
                  ++var1;
               }

               var3.push(var5);
            }
         }
      }

      if (var2) {
         throw new ec("Unbalanced quotation: " + var0);
      } else if (!var3.isEmpty()) {
         throw new ec("Unbalanced brackets: " + var0);
      } else {
         if (var1 == 0 && !var0.isEmpty()) {
            var1 = 1;
         }

         return var1;
      }
   }

   private static boolean b(String var0, int var1) {
      return var1 > 0 && var0.charAt(var1 - 1) == '\\' && !b(var0, var1 - 1);
   }

   private static String a(String var0, int var1) throws ec {
      Stack var2 = new Stack();
      int var3 = var1 + 1;
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;

      for(int var7 = 0; var3 < var0.length(); ++var3) {
         char var8 = var0.charAt(var3);
         if (var8 == '"') {
            if (b(var0, var3)) {
               if (!var4) {
                  throw new ec("Illegal use of \\\": " + var0);
               }
            } else {
               var4 = !var4;
               if (var4 && !var6) {
                  var5 = true;
               }

               if (!var4) {
                  var7 = var3;
               }
            }
         } else if (!var4) {
            if (var8 != '{' && var8 != '[') {
               if (var8 == '}' && (var2.isEmpty() || (Character)var2.pop() != '{')) {
                  throw new ec("Unbalanced curly brackets {}: " + var0);
               }

               if (var8 == ']' && (var2.isEmpty() || (Character)var2.pop() != '[')) {
                  throw new ec("Unbalanced square brackets []: " + var0);
               }

               if (var8 == ',' && var2.isEmpty()) {
                  return var0.substring(0, var3);
               }
            } else {
               var2.push(var8);
            }
         }

         if (!Character.isWhitespace(var8)) {
            if (!var4 && var5 && var7 != var3) {
               return var0.substring(0, var7 + 1);
            }

            var6 = true;
         }
      }

      return var0.substring(0, var3);
   }

   private static String b(String var0, boolean var1) throws ec {
      int var2 = a(var0, ':');
      int var3 = a(var0, ',');
      if (var1) {
         if (var2 == -1) {
            throw new ec("Unable to locate name/value separator for string: " + var0);
         }

         if (var3 != -1 && var3 < var2) {
            throw new ec("Name error at: " + var0);
         }
      } else if (var2 == -1 || var2 > var3) {
         var2 = -1;
      }

      return a(var0, var2);
   }

   public static dn a(String var0) throws ec {
      var0 = var0.trim();
      if (!var0.startsWith("{")) {
         throw new ec("Invalid tag encountered, expected '{' as first char.");
      } else if (b(var0) != 1) {
         throw new ec("Encountered multiple top tags, only one expected");
      } else {
         return (dn)a("tag", var0).a();
      }
   }

   private static ed.a a(String var0, boolean var1) throws ec {
      String var2 = c(var0, var1);
      String var3 = d(var0, var1);
      return a(var2, var3);
   }

   static ed.a a(String var0, String var1) throws ec {
      var1 = var1.trim();
      String var3;
      boolean var4;
      char var6;
      if (var1.startsWith("{")) {
         var1 = var1.substring(1, var1.length() - 1);

         ed.b var5;
         for(var5 = new ed.b(var0); var1.length() > 0; var1 = var1.substring(var3.length() + 1)) {
            var3 = b(var1, true);
            if (var3.length() > 0) {
               var4 = false;
               var5.b.add(a(var3, var4));
            }

            if (var1.length() < var3.length() + 1) {
               break;
            }

            var6 = var1.charAt(var3.length());
            if (var6 != ',' && var6 != '{' && var6 != '}' && var6 != '[' && var6 != ']') {
               throw new ec("Unexpected token '" + var6 + "' at: " + var1.substring(var3.length()));
            }
         }

         return var5;
      } else if (var1.startsWith("[") && !b.matcher(var1).matches()) {
         var1 = var1.substring(1, var1.length() - 1);

         ed.c var2;
         for(var2 = new ed.c(var0); var1.length() > 0; var1 = var1.substring(var3.length() + 1)) {
            var3 = b(var1, false);
            if (var3.length() > 0) {
               var4 = true;
               var2.b.add(a(var3, var4));
            }

            if (var1.length() < var3.length() + 1) {
               break;
            }

            var6 = var1.charAt(var3.length());
            if (var6 != ',' && var6 != '{' && var6 != '}' && var6 != '[' && var6 != ']') {
               throw new ec("Unexpected token '" + var6 + "' at: " + var1.substring(var3.length()));
            }
         }

         return var2;
      } else {
         return new ed.d(var0, var1);
      }
   }

   static class d extends ed.a {
      private static final Pattern h = Pattern.compile("[-+]?[0-9]+");
      private static final Pattern i = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+");
      private static final Pattern f = Pattern.compile("[-+]?[0-9]+[l|L]");
      protected String b;
      private static final Pattern c = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+[d|D]");
      private static final Splitter j = Splitter.on(',').omitEmptyStrings();
      private static final Pattern d = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+[f|F]");
      private static final Pattern e = Pattern.compile("[-+]?[0-9]+[b|B]");
      private static final Pattern g = Pattern.compile("[-+]?[0-9]+[s|S]");

      public eb a() throws ec {
         try {
            if (c.matcher(this.b).matches()) {
               return new dp(Double.parseDouble(this.b.substring(0, this.b.length() - 1)));
            }

            if (d.matcher(this.b).matches()) {
               return new dr(Float.parseFloat(this.b.substring(0, this.b.length() - 1)));
            }

            if (e.matcher(this.b).matches()) {
               return new dm(Byte.parseByte(this.b.substring(0, this.b.length() - 1)));
            }

            if (f.matcher(this.b).matches()) {
               return new dv(Long.parseLong(this.b.substring(0, this.b.length() - 1)));
            }

            if (g.matcher(this.b).matches()) {
               return new dz(Short.parseShort(this.b.substring(0, this.b.length() - 1)));
            }

            if (h.matcher(this.b).matches()) {
               return new dt(Integer.parseInt(this.b));
            }

            if (i.matcher(this.b).matches()) {
               return new dp(Double.parseDouble(this.b));
            }

            if (this.b.equalsIgnoreCase("true") || this.b.equalsIgnoreCase("false")) {
               return new dm((byte)(Boolean.parseBoolean(this.b) ? 1 : 0));
            }
         } catch (NumberFormatException var6) {
            this.b = this.b.replaceAll("\\\\\"", "\"");
            return new ea(this.b);
         }

         if (this.b.startsWith("[") && this.b.endsWith("]")) {
            String var7 = this.b.substring(1, this.b.length() - 1);
            String[] var8 = (String[])Iterables.toArray(j.split(var7), String.class);

            try {
               int[] var3 = new int[var8.length];

               for(int var4 = 0; var4 < var8.length; ++var4) {
                  var3[var4] = Integer.parseInt(var8[var4].trim());
               }

               return new ds(var3);
            } catch (NumberFormatException var5) {
               return new ea(this.b);
            }
         } else {
            if (this.b.startsWith("\"") && this.b.endsWith("\"")) {
               this.b = this.b.substring(1, this.b.length() - 1);
            }

            this.b = this.b.replaceAll("\\\\\"", "\"");
            StringBuilder var1 = new StringBuilder();

            for(int var2 = 0; var2 < this.b.length(); ++var2) {
               if (var2 < this.b.length() - 1 && this.b.charAt(var2) == '\\' && this.b.charAt(var2 + 1) == '\\') {
                  var1.append('\\');
                  ++var2;
               } else {
                  var1.append(this.b.charAt(var2));
               }
            }

            return new ea(var1.toString());
         }
      }

      public d(String var1, String var2) {
         this.a = var1;
         this.b = var2;
      }
   }

   static class b extends ed.a {
      protected List<ed.a> b = Lists.newArrayList();

      public eb a() throws ec {
         dn var1 = new dn();
         Iterator var2 = this.b.iterator();

         while(var2.hasNext()) {
            ed.a var3 = (ed.a)var2.next();
            var1.a(var3.a, var3.a());
         }

         return var1;
      }

      public b(String var1) {
         this.a = var1;
      }
   }

   static class c extends ed.a {
      protected List<ed.a> b = Lists.newArrayList();

      public eb a() throws ec {
         du var1 = new du();
         Iterator var2 = this.b.iterator();

         while(var2.hasNext()) {
            ed.a var3 = (ed.a)var2.next();
            var1.a(var3.a());
         }

         return var1;
      }

      public c(String var1) {
         this.a = var1;
      }
   }

   abstract static class a {
      protected String a;

      public abstract eb a() throws ec;
   }
}
