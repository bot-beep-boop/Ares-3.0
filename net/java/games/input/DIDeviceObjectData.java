package net.java.games.input;

final class DIDeviceObjectData {
   private int format_offset;
   private int sequence;
   private int millis;
   private int data;

   public final long getNanos() {
      return (long)this.millis * 1000000L;
   }

   public final void set(DIDeviceObjectData var1) {
      this.set(var1.format_offset, var1.data, var1.millis, var1.sequence);
   }

   public final void set(int var1, int var2, int var3, int var4) {
      this.format_offset = var1;
      this.data = var2;
      this.millis = var3;
      this.sequence = var4;
   }

   public final int getData() {
      return this.data;
   }

   public final int getFormatOffset() {
      return this.format_offset;
   }
}
