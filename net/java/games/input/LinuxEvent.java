package net.java.games.input;

final class LinuxEvent {
   private long nanos;
   private final LinuxAxisDescriptor descriptor = new LinuxAxisDescriptor();
   private int value;

   public final long getNanos() {
      return this.nanos;
   }

   public final int getValue() {
      return this.value;
   }

   public final void set(long var1, long var3, int var5, int var6, int var7) {
      this.nanos = (var1 * 1000000L + var3) * 1000L;
      this.descriptor.set(var5, var6);
      this.value = var7;
   }

   public final LinuxAxisDescriptor getDescriptor() {
      return this.descriptor;
   }
}
