package net.optifine.expr;

import java.util.ArrayList;
import java.util.Arrays;

public class ParametersVariable implements IParameters {
   private int maxCount;
   private ExpressionType[] repeat;
   private ExpressionType[] first;
   private ExpressionType[] last;
   private static final ExpressionType[] EMPTY = new ExpressionType[0];

   public ParametersVariable maxCount(int var1) {
      return new ParametersVariable(this.first, this.repeat, this.last, var1);
   }

   public ParametersVariable(ExpressionType[] var1, ExpressionType[] var2, ExpressionType[] var3, int var4) {
      this.maxCount = Integer.MAX_VALUE;
      this.first = normalize(var1);
      this.repeat = normalize(var2);
      this.last = normalize(var3);
      this.maxCount = var4;
   }

   public ParametersVariable repeat(ExpressionType... var1) {
      return new ParametersVariable(this.first, var1, this.last);
   }

   private static ExpressionType[] normalize(ExpressionType[] var0) {
      return var0 == null ? EMPTY : var0;
   }

   public ParametersVariable(ExpressionType[] var1, ExpressionType[] var2, ExpressionType[] var3) {
      this(var1, var2, var3, Integer.MAX_VALUE);
   }

   public ParametersVariable() {
      this((ExpressionType[])null, (ExpressionType[])null, (ExpressionType[])null);
   }

   public int getCountRepeat() {
      return this.first == null ? 0 : this.first.length;
   }

   public ExpressionType[] getFirst() {
      return this.first;
   }

   public ParametersVariable first(ExpressionType... var1) {
      return new ParametersVariable(var1, this.repeat, this.last);
   }

   public ParametersVariable last(ExpressionType... var1) {
      return new ParametersVariable(this.first, this.repeat, var1);
   }

   public ExpressionType[] getParameterTypes(IExpression[] var1) {
      int var2 = this.first.length + this.last.length;
      int var3 = var1.length - var2;
      int var4 = 0;

      for(int var5 = 0; var5 + this.repeat.length <= var3 && var2 + var5 + this.repeat.length <= this.maxCount; var5 += this.repeat.length) {
         ++var4;
      }

      ArrayList var7 = new ArrayList();
      var7.addAll(Arrays.asList(this.first));

      for(int var6 = 0; var6 < var4; ++var6) {
         var7.addAll(Arrays.asList(this.repeat));
      }

      var7.addAll(Arrays.asList(this.last));
      ExpressionType[] var8 = (ExpressionType[])var7.toArray(new ExpressionType[var7.size()]);
      return var8;
   }

   public ExpressionType[] getRepeat() {
      return this.repeat;
   }

   public ExpressionType[] getLast() {
      return this.last;
   }
}
