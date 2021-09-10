package net.java.games.input;

final class LinuxAbsInfo {
   private int flat;
   private int maximum;
   private int minimum;
   private int fuzz;
   private int value;

   final int getMax() {
      return this.maximum;
   }

   public final String toString() {
      return "AbsInfo: value = " + this.value + " | min = " + this.minimum + " | max = " + this.maximum + " | fuzz = " + this.fuzz + " | flat = " + this.flat;
   }

   final int getFlat() {
      return this.flat;
   }

   final int getMin() {
      return this.minimum;
   }

   final int getFuzz() {
      return this.fuzz;
   }

   public final int getValue() {
      return this.value;
   }

   public final void set(int var1, int var2, int var3, int var4, int var5) {
      this.value = var1;
      this.minimum = var2;
      this.maximum = var3;
      this.fuzz = var4;
      this.flat = var5;
   }
}
