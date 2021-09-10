package net.optifine.expr;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.StringReader;
import java.util.ArrayList;

public class TokenParser {
   private static Token readToken(char var0, TokenType var1, PushbackReader var2) throws IOException {
      StringBuffer var3 = new StringBuffer();
      var3.append(var0);

      while(true) {
         int var4 = var2.read();
         if (var4 < 0) {
            break;
         }

         char var5 = (char)var4;
         if (!var1.hasCharNext(var5)) {
            var2.unread(var5);
            break;
         }

         var3.append(var5);
      }

      return new Token(var1, var3.toString());
   }

   public static Token[] parse(String var0) throws ParseException, IOException {
      StringReader var1 = new StringReader(var0);
      PushbackReader var2 = new PushbackReader(var1);
      ArrayList var3 = new ArrayList();

      while(true) {
         int var4 = var2.read();
         if (var4 < 0) {
            Token[] var8 = (Token[])var3.toArray(new Token[var3.size()]);
            return var8;
         }

         char var5 = (char)var4;
         if (!Character.isWhitespace(var5)) {
            TokenType var6 = TokenType.getTypeByFirstChar(var5);
            if (var6 == null) {
               throw new ParseException("Invalid character: '" + var5 + "', in: " + var0);
            }

            Token var7 = readToken(var5, var6, var2);
            var3.add(var7);
         }
      }
   }
}
