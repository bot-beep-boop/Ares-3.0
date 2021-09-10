package net.optifine.util;

public class CounterInt {
   private int value;
   private int startValue;

   public synchronized int nextValue() {
      int var1 = this.value++;
      return var1;
   }

   public synchronized void reset() {
      this.value = this.startValue;
   }

   public int getValue() {
      return this.value;
   }

   public CounterInt(int var1) {
      this.startValue = var1;
      this.value = var1;
   }
}
