package net.optifine.config;

public class RangeInt {
   private int max;
   private int min;

   public boolean isInRange(int var1) {
      if (var1 < this.min) {
         return false;
      } else {
         return var1 <= this.max;
      }
   }

   public int getMax() {
      return this.max;
   }

   public RangeInt(int var1, int var2) {
      this.min = Math.min(var1, var2);
      this.max = Math.max(var1, var2);
   }

   public int getMin() {
      return this.min;
   }

   public String toString() {
      return "min: " + this.min + ", max: " + this.max;
   }
}
