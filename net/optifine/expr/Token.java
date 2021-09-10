package net.optifine.expr;

public class Token {
   private String text;
   private TokenType type;

   public TokenType getType() {
      return this.type;
   }

   public String getText() {
      return this.text;
   }

   public String toString() {
      return this.text;
   }

   public Token(TokenType var1, String var2) {
      this.type = var1;
      this.text = var2;
   }
}
