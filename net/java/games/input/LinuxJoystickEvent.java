package net.java.games.input;

final class LinuxJoystickEvent {
   private int number;
   private long nanos;
   private int value;
   private int type;

   public final int getType() {
      return this.type;
   }

   public final int getNumber() {
      return this.number;
   }

   public final long getNanos() {
      return this.nanos;
   }

   public final void set(long var1, int var3, int var4, int var5) {
      this.nanos = var1 * 1000000L;
      this.value = var3;
      this.type = var4;
      this.number = var5;
   }

   public final int getValue() {
      return this.value;
   }
}
