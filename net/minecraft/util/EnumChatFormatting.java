package net.minecraft.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

public enum EnumChatFormatting {
   WHITE("WHITE", 'f', 15),
   DARK_BLUE("DARK_BLUE", '1', 1),
   ITALIC("ITALIC", 'o', true);

   private static final EnumChatFormatting[] ENUM$VALUES = new EnumChatFormatting[]{BLACK, DARK_BLUE, DARK_GREEN, DARK_AQUA, DARK_RED, DARK_PURPLE, GOLD, GRAY, DARK_GRAY, BLUE, GREEN, AQUA, RED, LIGHT_PURPLE, YELLOW, WHITE, OBFUSCATED, BOLD, STRIKETHROUGH, UNDERLINE, ITALIC, RESET};
   private final String controlString;
   YELLOW("YELLOW", 'e', 14),
   BLUE("BLUE", '9', 9),
   AQUA("AQUA", 'b', 11);

   private final int colorIndex;
   STRIKETHROUGH("STRIKETHROUGH", 'm', true),
   UNDERLINE("UNDERLINE", 'n', true);

   private static final Pattern formattingCodePattern = Pattern.compile("(?i)" + String.valueOf('§') + "[0-9A-FK-OR]");
   LIGHT_PURPLE("LIGHT_PURPLE", 'd', 13),
   BOLD("BOLD", 'l', true),
   OBFUSCATED("OBFUSCATED", 'k', true);

   private final String name;
   BLACK("BLACK", '0', 0),
   GREEN("GREEN", 'a', 10);

   private static final Map<String, EnumChatFormatting> nameMapping = Maps.newHashMap();
   DARK_GREEN("DARK_GREEN", '2', 2),
   RED("RED", 'c', 12),
   DARK_GRAY("DARK_GRAY", '8', 8),
   DARK_AQUA("DARK_AQUA", '3', 3);

   private final char formattingCode;
   DARK_PURPLE("DARK_PURPLE", '5', 5),
   RESET("RESET", 'r', -1);

   private final boolean fancyStyling;
   GRAY("GRAY", '7', 7),
   DARK_RED("DARK_RED", '4', 4),
   GOLD("GOLD", '6', 6);

   private static String func_175745_c(String var0) {
      return var0.toLowerCase().replaceAll("[^a-z]", "");
   }

   public static EnumChatFormatting func_175744_a(int var0) {
      if (var0 < 0) {
         return RESET;
      } else {
         EnumChatFormatting[] var4;
         int var3 = (var4 = values()).length;

         for(int var2 = 0; var2 < var3; ++var2) {
            EnumChatFormatting var1 = var4[var2];
            if (var1.getColorIndex() == var0) {
               return var1;
            }
         }

         return null;
      }
   }

   private EnumChatFormatting(String var3, char var4, boolean var5) {
      this(var3, var4, var5, -1);
   }

   public int getColorIndex() {
      return this.colorIndex;
   }

   public boolean isFancyStyling() {
      return this.fancyStyling;
   }

   static {
      EnumChatFormatting[] var3;
      int var2 = (var3 = values()).length;

      for(int var1 = 0; var1 < var2; ++var1) {
         EnumChatFormatting var0 = var3[var1];
         nameMapping.put(func_175745_c(var0.name), var0);
      }

   }

   private EnumChatFormatting(String var3, char var4, int var5) {
      this(var3, var4, false, var5);
   }

   public static Collection<String> getValidValues(boolean var0, boolean var1) {
      ArrayList var2 = Lists.newArrayList();
      EnumChatFormatting[] var6;
      int var5 = (var6 = values()).length;

      for(int var4 = 0; var4 < var5; ++var4) {
         EnumChatFormatting var3 = var6[var4];
         if ((!var3.isColor() || var0) && (!var3.isFancyStyling() || var1)) {
            var2.add(var3.getFriendlyName());
         }
      }

      return var2;
   }

   public boolean isColor() {
      return !this.fancyStyling && this != RESET;
   }

   public static EnumChatFormatting getValueByName(String var0) {
      return var0 == null ? null : (EnumChatFormatting)nameMapping.get(func_175745_c(var0));
   }

   public String getFriendlyName() {
      return this.name().toLowerCase();
   }

   public String toString() {
      return this.controlString;
   }

   private EnumChatFormatting(String var3, char var4, boolean var5, int var6) {
      this.name = var3;
      this.formattingCode = var4;
      this.fancyStyling = var5;
      this.colorIndex = var6;
      this.controlString = "§" + var4;
   }

   public static String getTextWithoutFormattingCodes(String var0) {
      return var0 == null ? null : formattingCodePattern.matcher(var0).replaceAll("");
   }
}
