package net.optifine.expr;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.src.Config;
import net.minecraft.util.MathHelper;
import net.optifine.shaders.uniform.Smoother;
import net.optifine.util.MathUtils;

public enum FunctionType {
   GREATER_OR_EQUAL(8, ExpressionType.BOOL, ">=", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT});

   private static int[] $SWITCH_TABLE$net$optifine$expr$FunctionType;
   AND(3, ExpressionType.BOOL, "&&", new ExpressionType[]{ExpressionType.BOOL, ExpressionType.BOOL});

   private ExpressionType expressionType;
   SIGNUM(ExpressionType.FLOAT, "signum", new ExpressionType[]{ExpressionType.FLOAT}),
   CEIL(ExpressionType.FLOAT, "ceil", new ExpressionType[]{ExpressionType.FLOAT}),
   PLUS(10, ExpressionType.FLOAT, "+", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT}),
   ABS(ExpressionType.FLOAT, "abs", new ExpressionType[]{ExpressionType.FLOAT}),
   ACOS(ExpressionType.FLOAT, "acos", new ExpressionType[]{ExpressionType.FLOAT}),
   TAN(ExpressionType.FLOAT, "tan", new ExpressionType[]{ExpressionType.FLOAT}),
   MINUS(10, ExpressionType.FLOAT, "-", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT}),
   EQUAL(7, ExpressionType.BOOL, "==", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT}),
   FLOOR(ExpressionType.FLOAT, "floor", new ExpressionType[]{ExpressionType.FLOAT}),
   OR(2, ExpressionType.BOOL, "||", new ExpressionType[]{ExpressionType.BOOL, ExpressionType.BOOL}),
   NOT_EQUAL(7, ExpressionType.BOOL, "!=", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT});

   private int precedence;
   COS(ExpressionType.FLOAT, "cos", new ExpressionType[]{ExpressionType.FLOAT}),
   MAX(ExpressionType.FLOAT, "max", (new ParametersVariable()).first(ExpressionType.FLOAT).repeat(ExpressionType.FLOAT)),
   MOD(11, ExpressionType.FLOAT, "%", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT}),
   FMOD(ExpressionType.FLOAT, "fmod", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT}),
   FRAC(ExpressionType.FLOAT, "frac", new ExpressionType[]{ExpressionType.FLOAT}),
   PI(ExpressionType.FLOAT, "pi", new ExpressionType[0]),
   FALSE(ExpressionType.BOOL, "false", new ExpressionType[0]);

   private static final FunctionType[] ENUM$VALUES = new FunctionType[]{PLUS, MINUS, MUL, DIV, MOD, NEG, PI, SIN, COS, ASIN, ACOS, TAN, ATAN, ATAN2, TORAD, TODEG, MIN, MAX, CLAMP, ABS, FLOOR, CEIL, EXP, FRAC, LOG, POW, RANDOM, ROUND, SIGNUM, SQRT, FMOD, TIME, IF, NOT, AND, OR, GREATER, GREATER_OR_EQUAL, SMALLER, SMALLER_OR_EQUAL, EQUAL, NOT_EQUAL, BETWEEN, EQUALS, IN, SMOOTH, TRUE, FALSE, VEC2, VEC3, VEC4};
   SMALLER(8, ExpressionType.BOOL, "<", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT}),
   NOT(12, ExpressionType.BOOL, "!", new ExpressionType[]{ExpressionType.BOOL}),
   ATAN(ExpressionType.FLOAT, "atan", new ExpressionType[]{ExpressionType.FLOAT}),
   ASIN(ExpressionType.FLOAT, "asin", new ExpressionType[]{ExpressionType.FLOAT}),
   IF(ExpressionType.FLOAT, "if", (new ParametersVariable()).first(ExpressionType.BOOL, ExpressionType.FLOAT).repeat(ExpressionType.BOOL, ExpressionType.FLOAT).last(ExpressionType.FLOAT)),
   VEC3(ExpressionType.FLOAT_ARRAY, "vec3", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT, ExpressionType.FLOAT}),
   VEC4(ExpressionType.FLOAT_ARRAY, "vec4", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT, ExpressionType.FLOAT, ExpressionType.FLOAT}),
   TODEG(ExpressionType.FLOAT, "todeg", new ExpressionType[]{ExpressionType.FLOAT}),
   TORAD(ExpressionType.FLOAT, "torad", new ExpressionType[]{ExpressionType.FLOAT}),
   SIN(ExpressionType.FLOAT, "sin", new ExpressionType[]{ExpressionType.FLOAT}),
   MUL(11, ExpressionType.FLOAT, "*", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT}),
   ATAN2(ExpressionType.FLOAT, "atan2", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT}),
   TRUE(ExpressionType.BOOL, "true", new ExpressionType[0]),
   NEG(12, ExpressionType.FLOAT, "neg", new ExpressionType[]{ExpressionType.FLOAT});

   public static FunctionType[] VALUES = values();
   DIV(11, ExpressionType.FLOAT, "/", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT}),
   SQRT(ExpressionType.FLOAT, "sqrt", new ExpressionType[]{ExpressionType.FLOAT}),
   BETWEEN(7, ExpressionType.BOOL, "between", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT, ExpressionType.FLOAT});

   private static final Map<Integer, Float> mapSmooth = new HashMap();
   MIN(ExpressionType.FLOAT, "min", (new ParametersVariable()).first(ExpressionType.FLOAT).repeat(ExpressionType.FLOAT)),
   LOG(ExpressionType.FLOAT, "log", new ExpressionType[]{ExpressionType.FLOAT}),
   IN(ExpressionType.BOOL, "in", (new ParametersVariable()).first(ExpressionType.FLOAT).repeat(ExpressionType.FLOAT).last(ExpressionType.FLOAT));

   private IParameters parameters;
   SMOOTH(ExpressionType.FLOAT, "smooth", (new ParametersVariable()).first(ExpressionType.FLOAT).repeat(ExpressionType.FLOAT).maxCount(4)),
   CLAMP(ExpressionType.FLOAT, "clamp", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT, ExpressionType.FLOAT}),
   SMALLER_OR_EQUAL(8, ExpressionType.BOOL, "<=", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT}),
   GREATER(8, ExpressionType.BOOL, ">", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT}),
   EXP(ExpressionType.FLOAT, "exp", new ExpressionType[]{ExpressionType.FLOAT}),
   EQUALS(7, ExpressionType.BOOL, "equals", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT, ExpressionType.FLOAT}),
   POW(ExpressionType.FLOAT, "pow", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT});

   private String name;
   ROUND(ExpressionType.FLOAT, "round", new ExpressionType[]{ExpressionType.FLOAT}),
   RANDOM(ExpressionType.FLOAT, "random", new ExpressionType[0]),
   TIME(ExpressionType.FLOAT, "time", new ExpressionType[0]),
   VEC2(ExpressionType.FLOAT_ARRAY, "vec2", new ExpressionType[]{ExpressionType.FLOAT, ExpressionType.FLOAT});

   public ExpressionType[] getParameterTypes(IExpression[] var1) {
      return this.parameters.getParameterTypes(var1);
   }

   public static FunctionType parse(String var0) {
      for(int var1 = 0; var1 < VALUES.length; ++var1) {
         FunctionType var2 = VALUES[var1];
         if (var2.getName().equals(var0)) {
            return var2;
         }
      }

      return null;
   }

   public int getPrecedence() {
      return this.precedence;
   }

   public ExpressionType getExpressionType() {
      return this.expressionType;
   }

   private float getMax(IExpression[] var1) {
      if (var1.length == 2) {
         return Math.max(evalFloat(var1, 0), evalFloat(var1, 1));
      } else {
         float var2 = evalFloat(var1, 0);

         for(int var3 = 1; var3 < var1.length; ++var3) {
            float var4 = evalFloat(var1, var3);
            if (var4 > var2) {
               var2 = var4;
            }
         }

         return var2;
      }
   }

   private static float evalFloat(IExpression[] var0, int var1) {
      IExpressionFloat var2 = (IExpressionFloat)var0[var1];
      float var3 = var2.eval();
      return var3;
   }

   private static boolean evalBool(IExpression[] var0, int var1) {
      IExpressionBool var2 = (IExpressionBool)var0[var1];
      boolean var3 = var2.eval();
      return var3;
   }

   static int[] $SWITCH_TABLE$net$optifine$expr$FunctionType() {
      int[] var10000 = $SWITCH_TABLE$net$optifine$expr$FunctionType;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[values().length];

         try {
            var0[ABS.ordinal()] = 20;
         } catch (NoSuchFieldError var51) {
         }

         try {
            var0[ACOS.ordinal()] = 11;
         } catch (NoSuchFieldError var50) {
         }

         try {
            var0[AND.ordinal()] = 35;
         } catch (NoSuchFieldError var49) {
         }

         try {
            var0[ASIN.ordinal()] = 10;
         } catch (NoSuchFieldError var48) {
         }

         try {
            var0[ATAN.ordinal()] = 13;
         } catch (NoSuchFieldError var47) {
         }

         try {
            var0[ATAN2.ordinal()] = 14;
         } catch (NoSuchFieldError var46) {
         }

         try {
            var0[BETWEEN.ordinal()] = 43;
         } catch (NoSuchFieldError var45) {
         }

         try {
            var0[CEIL.ordinal()] = 22;
         } catch (NoSuchFieldError var44) {
         }

         try {
            var0[CLAMP.ordinal()] = 19;
         } catch (NoSuchFieldError var43) {
         }

         try {
            var0[COS.ordinal()] = 9;
         } catch (NoSuchFieldError var42) {
         }

         try {
            var0[DIV.ordinal()] = 4;
         } catch (NoSuchFieldError var41) {
         }

         try {
            var0[EQUAL.ordinal()] = 41;
         } catch (NoSuchFieldError var40) {
         }

         try {
            var0[EQUALS.ordinal()] = 44;
         } catch (NoSuchFieldError var39) {
         }

         try {
            var0[EXP.ordinal()] = 23;
         } catch (NoSuchFieldError var38) {
         }

         try {
            var0[FALSE.ordinal()] = 48;
         } catch (NoSuchFieldError var37) {
         }

         try {
            var0[FLOOR.ordinal()] = 21;
         } catch (NoSuchFieldError var36) {
         }

         try {
            var0[FMOD.ordinal()] = 31;
         } catch (NoSuchFieldError var35) {
         }

         try {
            var0[FRAC.ordinal()] = 24;
         } catch (NoSuchFieldError var34) {
         }

         try {
            var0[GREATER.ordinal()] = 37;
         } catch (NoSuchFieldError var33) {
         }

         try {
            var0[GREATER_OR_EQUAL.ordinal()] = 38;
         } catch (NoSuchFieldError var32) {
         }

         try {
            var0[IF.ordinal()] = 33;
         } catch (NoSuchFieldError var31) {
         }

         try {
            var0[IN.ordinal()] = 45;
         } catch (NoSuchFieldError var30) {
         }

         try {
            var0[LOG.ordinal()] = 25;
         } catch (NoSuchFieldError var29) {
         }

         try {
            var0[MAX.ordinal()] = 18;
         } catch (NoSuchFieldError var28) {
         }

         try {
            var0[MIN.ordinal()] = 17;
         } catch (NoSuchFieldError var27) {
         }

         try {
            var0[MINUS.ordinal()] = 2;
         } catch (NoSuchFieldError var26) {
         }

         try {
            var0[MOD.ordinal()] = 5;
         } catch (NoSuchFieldError var25) {
         }

         try {
            var0[MUL.ordinal()] = 3;
         } catch (NoSuchFieldError var24) {
         }

         try {
            var0[NEG.ordinal()] = 6;
         } catch (NoSuchFieldError var23) {
         }

         try {
            var0[NOT.ordinal()] = 34;
         } catch (NoSuchFieldError var22) {
         }

         try {
            var0[NOT_EQUAL.ordinal()] = 42;
         } catch (NoSuchFieldError var21) {
         }

         try {
            var0[OR.ordinal()] = 36;
         } catch (NoSuchFieldError var20) {
         }

         try {
            var0[PI.ordinal()] = 7;
         } catch (NoSuchFieldError var19) {
         }

         try {
            var0[PLUS.ordinal()] = 1;
         } catch (NoSuchFieldError var18) {
         }

         try {
            var0[POW.ordinal()] = 26;
         } catch (NoSuchFieldError var17) {
         }

         try {
            var0[RANDOM.ordinal()] = 27;
         } catch (NoSuchFieldError var16) {
         }

         try {
            var0[ROUND.ordinal()] = 28;
         } catch (NoSuchFieldError var15) {
         }

         try {
            var0[SIGNUM.ordinal()] = 29;
         } catch (NoSuchFieldError var14) {
         }

         try {
            var0[SIN.ordinal()] = 8;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[SMALLER.ordinal()] = 39;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[SMALLER_OR_EQUAL.ordinal()] = 40;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[SMOOTH.ordinal()] = 46;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[SQRT.ordinal()] = 30;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[TAN.ordinal()] = 12;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[TIME.ordinal()] = 32;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[TODEG.ordinal()] = 16;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[TORAD.ordinal()] = 15;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[TRUE.ordinal()] = 47;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[VEC2.ordinal()] = 49;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[VEC3.ordinal()] = 50;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[VEC4.ordinal()] = 51;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$optifine$expr$FunctionType = var0;
         return var0;
      }
   }

   public boolean evalBool(IExpression[] var1) {
      switch($SWITCH_TABLE$net$optifine$expr$FunctionType()[this.ordinal()]) {
      case 34:
         return !evalBool(var1, 0);
      case 35:
         if (evalBool(var1, 0) && evalBool(var1, 1)) {
            return true;
         }

         return false;
      case 36:
         if (!evalBool(var1, 0) && !evalBool(var1, 1)) {
            return false;
         }

         return true;
      case 37:
         if (evalFloat(var1, 0) > evalFloat(var1, 1)) {
            return true;
         }

         return false;
      case 38:
         if (evalFloat(var1, 0) >= evalFloat(var1, 1)) {
            return true;
         }

         return false;
      case 39:
         if (evalFloat(var1, 0) < evalFloat(var1, 1)) {
            return true;
         }

         return false;
      case 40:
         if (evalFloat(var1, 0) <= evalFloat(var1, 1)) {
            return true;
         }

         return false;
      case 41:
         if (evalFloat(var1, 0) == evalFloat(var1, 1)) {
            return true;
         }

         return false;
      case 42:
         if (evalFloat(var1, 0) != evalFloat(var1, 1)) {
            return true;
         }

         return false;
      case 43:
         float var2 = evalFloat(var1, 0);
         if (var2 >= evalFloat(var1, 1) && var2 <= evalFloat(var1, 2)) {
            return true;
         }

         return false;
      case 44:
         float var3 = evalFloat(var1, 0) - evalFloat(var1, 1);
         float var4 = evalFloat(var1, 2);
         if (Math.abs(var3) <= var4) {
            return true;
         }

         return false;
      case 45:
         float var5 = evalFloat(var1, 0);

         for(int var6 = 1; var6 < var1.length; ++var6) {
            float var7 = evalFloat(var1, var6);
            if (var5 == var7) {
               return true;
            }
         }

         return false;
      case 46:
      default:
         Config.warn("Unknown function type: " + this);
         return false;
      case 47:
         return true;
      case 48:
         return false;
      }
   }

   public float[] evalFloatArray(IExpression[] var1) {
      switch($SWITCH_TABLE$net$optifine$expr$FunctionType()[this.ordinal()]) {
      case 49:
         return new float[]{evalFloat(var1, 0), evalFloat(var1, 1)};
      case 50:
         return new float[]{evalFloat(var1, 0), evalFloat(var1, 1), evalFloat(var1, 2)};
      case 51:
         return new float[]{evalFloat(var1, 0), evalFloat(var1, 1), evalFloat(var1, 2), evalFloat(var1, 3)};
      default:
         Config.warn("Unknown function type: " + this);
         return null;
      }
   }

   public String getName() {
      return this.name;
   }

   private float getMin(IExpression[] var1) {
      if (var1.length == 2) {
         return Math.min(evalFloat(var1, 0), evalFloat(var1, 1));
      } else {
         float var2 = evalFloat(var1, 0);

         for(int var3 = 1; var3 < var1.length; ++var3) {
            float var4 = evalFloat(var1, var3);
            if (var4 < var2) {
               var2 = var4;
            }
         }

         return var2;
      }
   }

   private FunctionType(int var3, ExpressionType var4, String var5, IParameters var6) {
      this.precedence = var3;
      this.expressionType = var4;
      this.name = var5;
      this.parameters = var6;
   }

   public float evalFloat(IExpression[] var1) {
      int var9;
      switch($SWITCH_TABLE$net$optifine$expr$FunctionType()[this.ordinal()]) {
      case 1:
         return evalFloat(var1, 0) + evalFloat(var1, 1);
      case 2:
         return evalFloat(var1, 0) - evalFloat(var1, 1);
      case 3:
         return evalFloat(var1, 0) * evalFloat(var1, 1);
      case 4:
         return evalFloat(var1, 0) / evalFloat(var1, 1);
      case 5:
         float var2 = evalFloat(var1, 0);
         float var3 = evalFloat(var1, 1);
         return var2 - var3 * (float)((int)(var2 / var3));
      case 6:
         return -evalFloat(var1, 0);
      case 7:
         return MathHelper.PI;
      case 8:
         return MathHelper.sin(evalFloat(var1, 0));
      case 9:
         return MathHelper.cos(evalFloat(var1, 0));
      case 10:
         return MathUtils.asin(evalFloat(var1, 0));
      case 11:
         return MathUtils.acos(evalFloat(var1, 0));
      case 12:
         return (float)Math.tan((double)evalFloat(var1, 0));
      case 13:
         return (float)Math.atan((double)evalFloat(var1, 0));
      case 14:
         return (float)MathHelper.atan2((double)evalFloat(var1, 0), (double)evalFloat(var1, 1));
      case 15:
         return MathUtils.toRad(evalFloat(var1, 0));
      case 16:
         return MathUtils.toDeg(evalFloat(var1, 0));
      case 17:
         return this.getMin(var1);
      case 18:
         return this.getMax(var1);
      case 19:
         return MathHelper.clamp_float(evalFloat(var1, 0), evalFloat(var1, 1), evalFloat(var1, 2));
      case 20:
         return MathHelper.abs(evalFloat(var1, 0));
      case 21:
         return (float)MathHelper.floor_float(evalFloat(var1, 0));
      case 22:
         return (float)MathHelper.ceiling_float_int(evalFloat(var1, 0));
      case 23:
         return (float)Math.exp((double)evalFloat(var1, 0));
      case 24:
         return (float)MathHelper.func_181162_h((double)evalFloat(var1, 0));
      case 25:
         return (float)Math.log((double)evalFloat(var1, 0));
      case 26:
         return (float)Math.pow((double)evalFloat(var1, 0), (double)evalFloat(var1, 1));
      case 27:
         return (float)Math.random();
      case 28:
         return (float)Math.round(evalFloat(var1, 0));
      case 29:
         return Math.signum(evalFloat(var1, 0));
      case 30:
         return MathHelper.sqrt_float(evalFloat(var1, 0));
      case 31:
         float var4 = evalFloat(var1, 0);
         float var5 = evalFloat(var1, 1);
         return var4 - var5 * (float)MathHelper.floor_float(var4 / var5);
      case 32:
         Minecraft var6 = Minecraft.getMinecraft();
         WorldClient var7 = var6.theWorld;
         if (var7 == null) {
            return 0.0F;
         }

         return (float)(var7.getTotalWorldTime() % 24000L) + Config.renderPartialTicks;
      case 33:
         int var8 = (var1.length - 1) / 2;

         for(var9 = 0; var9 < var8; ++var9) {
            int var14 = var9 * 2;
            if (evalBool(var1, var14)) {
               return evalFloat(var1, var14 + 1);
            }
         }

         return evalFloat(var1, var8 * 2);
      case 34:
      case 35:
      case 36:
      case 37:
      case 38:
      case 39:
      case 40:
      case 41:
      case 42:
      case 43:
      case 44:
      case 45:
      default:
         Config.warn("Unknown function type: " + this);
         return 0.0F;
      case 46:
         var9 = (int)evalFloat(var1, 0);
         float var10 = evalFloat(var1, 1);
         float var11 = var1.length > 2 ? evalFloat(var1, 2) : 1.0F;
         float var12 = var1.length > 3 ? evalFloat(var1, 3) : var11;
         float var13 = Smoother.getSmoothValue(var9, var10, var11, var12);
         return var13;
      }
   }

   public IParameters getParameters() {
      return this.parameters;
   }

   public int getParameterCount(IExpression[] var1) {
      return this.parameters.getParameterTypes(var1).length;
   }

   private FunctionType(ExpressionType var3, String var4, ExpressionType... var5) {
      this(0, var3, var4, (ExpressionType[])var5);
   }

   private FunctionType(ExpressionType var3, String var4, IParameters var5) {
      this(0, var3, var4, (IParameters)var5);
   }

   private FunctionType(int var3, ExpressionType var4, String var5, ExpressionType... var6) {
      this(var3, var4, var5, (IParameters)(new Parameters(var6)));
   }
}
