package net.optifine.shaders.config;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.src.Config;
import net.optifine.expr.ExpressionParser;
import net.optifine.expr.ExpressionType;
import net.optifine.expr.IExpression;
import net.optifine.expr.IExpressionBool;
import net.optifine.expr.IExpressionFloat;
import net.optifine.expr.ParseException;

public class MacroState {
   private static final List<String> MACRO_NAMES = Arrays.asList("define", "undef", "ifdef", "ifndef", "if", "else", "elif", "endif");
   private static final String UNDEF = "undef";
   private static final Pattern PATTERN_DEFINED = Pattern.compile("defined\\s+(\\w+)");
   private static final Pattern PATTERN_DIRECTIVE = Pattern.compile("\\s*#\\s*(\\w+)\\s*(.*)");
   private static final String IFDEF = "ifdef";
   private static final Pattern PATTERN_DEFINED_FUNC = Pattern.compile("defined\\s*\\(\\s*(\\w+)\\s*\\)");
   private static final String ELIF = "elif";
   private boolean active = true;
   private Deque<Boolean> dequeState = new ArrayDeque();
   private static final String DEFINE = "define";
   private static final Pattern PATTERN_MACRO = Pattern.compile("(\\w+)");
   private static final String IFNDEF = "ifndef";
   private static final String IF = "if";
   private Deque<Boolean> dequeResolved = new ArrayDeque();
   private static final String ELSE = "else";
   private Map<String, String> mapMacroValues = new HashMap();
   private static final String ENDIF = "endif";

   private void processMacro(String var1, String var2) {
      StringTokenizer var3 = new StringTokenizer(var2, " \t");
      String var4 = var3.hasMoreTokens() ? var3.nextToken() : "";
      String var5 = var3.hasMoreTokens() ? var3.nextToken("").trim() : "";
      if (var1.equals("define")) {
         this.mapMacroValues.put(var4, var5);
      } else if (var1.equals("undef")) {
         this.mapMacroValues.remove(var4);
      } else {
         boolean var6;
         if (var1.equals("ifdef")) {
            var6 = this.mapMacroValues.containsKey(var4);
            this.dequeState.add(var6);
            this.dequeResolved.add(var6);
         } else if (var1.equals("ifndef")) {
            var6 = !this.mapMacroValues.containsKey(var4);
            this.dequeState.add(var6);
            this.dequeResolved.add(var6);
         } else if (var1.equals("if")) {
            var6 = this.eval(var2);
            this.dequeState.add(var6);
            this.dequeResolved.add(var6);
         } else if (!this.dequeState.isEmpty()) {
            boolean var7;
            boolean var8;
            if (var1.equals("elif")) {
               var6 = (Boolean)this.dequeState.removeLast();
               var7 = (Boolean)this.dequeResolved.removeLast();
               if (var7) {
                  this.dequeState.add(false);
                  this.dequeResolved.add(var7);
               } else {
                  var8 = this.eval(var2);
                  this.dequeState.add(var8);
                  this.dequeResolved.add(var8);
               }
            } else if (var1.equals("else")) {
               var6 = (Boolean)this.dequeState.removeLast();
               var7 = (Boolean)this.dequeResolved.removeLast();
               var8 = !var7;
               this.dequeState.add(var8);
               this.dequeResolved.add(true);
            } else if (var1.equals("endif")) {
               this.dequeState.removeLast();
               this.dequeResolved.removeLast();
            }
         }
      }

   }

   public static boolean isMacroLine(String var0) {
      Matcher var1 = PATTERN_DIRECTIVE.matcher(var0);
      if (!var1.matches()) {
         return false;
      } else {
         String var2 = var1.group(1);
         return MACRO_NAMES.contains(var2);
      }
   }

   private boolean eval(String var1) {
      Matcher var2 = PATTERN_DEFINED.matcher(var1);
      var1 = var2.replaceAll("defined_$1");
      Matcher var3 = PATTERN_DEFINED_FUNC.matcher(var1);
      var1 = var3.replaceAll("defined_$1");
      boolean var4 = false;
      int var5 = 0;

      label102:
      do {
         var4 = false;
         Matcher var6 = PATTERN_MACRO.matcher(var1);

         String var7;
         char var8;
         do {
            do {
               do {
                  if (!var6.find()) {
                     continue label102;
                  }

                  var7 = var6.group();
               } while(var7.length() <= 0);

               var8 = var7.charAt(0);
            } while(!Character.isLetter(var8) && var8 != '_');
         } while(!this.mapMacroValues.containsKey(var7));

         String var9 = (String)this.mapMacroValues.get(var7);
         if (var9 == null) {
            var9 = "1";
         }

         int var10 = var6.start();
         int var11 = var6.end();
         var1 = var1.substring(0, var10) + " " + var9 + " " + var1.substring(var11);
         var4 = true;
         ++var5;
      } while(var4 && var5 < 100);

      if (var5 >= 100) {
         Config.warn("Too many iterations: " + var5 + ", when resolving: " + var1);
         return true;
      } else {
         try {
            MacroExpressionResolver var13 = new MacroExpressionResolver(this.mapMacroValues);
            ExpressionParser var14 = new ExpressionParser(var13);
            IExpression var15 = var14.parse(var1);
            if (var15.getExpressionType() == ExpressionType.BOOL) {
               IExpressionBool var17 = (IExpressionBool)var15;
               boolean var19 = var17.eval();
               return var19;
            } else if (var15.getExpressionType() == ExpressionType.FLOAT) {
               IExpressionFloat var16 = (IExpressionFloat)var15;
               float var18 = var16.eval();
               boolean var20 = var18 != 0.0F;
               return var20;
            } else {
               throw new ParseException("Not a boolean or float expression: " + var15.getExpressionType());
            }
         } catch (ParseException var12) {
            Config.warn("Invalid macro expression: " + var1);
            Config.warn("Error: " + var12.getMessage());
            return false;
         }
      }
   }

   public boolean processLine(String var1) {
      Matcher var2 = PATTERN_DIRECTIVE.matcher(var1);
      if (!var2.matches()) {
         return this.active;
      } else {
         String var3 = var2.group(1);
         String var4 = var2.group(2);
         int var5 = var4.indexOf("//");
         if (var5 >= 0) {
            var4 = var4.substring(0, var5);
         }

         boolean var6 = this.active;
         this.processMacro(var3, var4);
         this.active = !this.dequeState.contains(Boolean.FALSE);
         return this.active || var6;
      }
   }
}
