package net.optifine.expr;

public enum TokenType {
   NUMBER("0123456789", "0123456789.");

   private static final TokenType[] ENUM$VALUES = new TokenType[]{IDENTIFIER, NUMBER, OPERATOR, COMMA, BRACKET_OPEN, BRACKET_CLOSE};
   private String charsNext;
   OPERATOR("+-*/%!&|<>=", "&|=");

   public static final TokenType[] VALUES = values();
   COMMA(",");

   private String charsFirst;
   BRACKET_OPEN("("),
   BRACKET_CLOSE(")"),
   IDENTIFIER("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_:.");

   private TokenType(String var3) {
      this(var3, "");
   }

   public static TokenType getTypeByFirstChar(char var0) {
      for(int var1 = 0; var1 < VALUES.length; ++var1) {
         TokenType var2 = VALUES[var1];
         if (var2.getCharsFirst().indexOf(var0) >= 0) {
            return var2;
         }
      }

      return null;
   }

   public String getCharsFirst() {
      return this.charsFirst;
   }

   private TokenType(String var3, String var4) {
      this.charsFirst = var3;
      this.charsNext = var4;
   }

   public String getCharsNext() {
      return this.charsNext;
   }

   public boolean hasCharNext(char var1) {
      return this.charsNext.indexOf(var1) >= 0;
   }

   private static class Const {
      static final String ALPHAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
      static final String DIGITS = "0123456789";
   }
}
