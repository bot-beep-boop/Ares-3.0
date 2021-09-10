package net.java.games.input;

final class RawKeyboardEvent {
   private int vkey;
   private long extra_information;
   private int message;
   private int flags;
   private int make_code;
   private long millis;

   public final int getMessage() {
      return this.message;
   }

   public final long getNanos() {
      return this.millis * 1000000L;
   }

   public final void set(long var1, int var3, int var4, int var5, int var6, long var7) {
      this.millis = var1;
      this.make_code = var3;
      this.flags = var4;
      this.vkey = var5;
      this.message = var6;
      this.extra_information = var7;
   }

   public final void set(RawKeyboardEvent var1) {
      this.set(var1.millis, var1.make_code, var1.flags, var1.vkey, var1.message, var1.extra_information);
   }

   public final int getVKey() {
      return this.vkey;
   }
}
