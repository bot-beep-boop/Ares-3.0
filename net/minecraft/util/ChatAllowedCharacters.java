package net.minecraft.util;

public class ChatAllowedCharacters {
   public static final char[] allowedCharactersArray = new char[]{'/', '\n', '\r', '\t', '\u0000', '\f', '`', '?', '*', '\\', '<', '>', '|', '"', ':'};

   public static String filterAllowedCharacters(String var0) {
      StringBuilder var1 = new StringBuilder();
      char[] var5;
      int var4 = (var5 = var0.toCharArray()).length;

      for(int var3 = 0; var3 < var4; ++var3) {
         char var2 = var5[var3];
         if (isAllowedCharacter(var2)) {
            var1.append(var2);
         }
      }

      return var1.toString();
   }

   public static boolean isAllowedCharacter(char var0) {
      return var0 >= ' ' && var0 != 127;
   }
}
