package net.java.games.input;

final class RawMouseEvent {
   private int flags;
   private long raw_buttons;
   private long last_y;
   private long extra_information;
   private int button_flags;
   private int button_data;
   private long millis;
   private static final int WHEEL_SCALE = 120;
   private long last_x;

   public final long getRawButtons() {
      return this.raw_buttons;
   }

   public final int getButtonFlags() {
      return this.button_flags;
   }

   public final void set(long var1, int var3, int var4, int var5, long var6, long var8, long var10, long var12) {
      this.millis = var1;
      this.flags = var3;
      this.button_flags = var4;
      this.button_data = var5;
      this.raw_buttons = var6;
      this.last_x = var8;
      this.last_y = var10;
      this.extra_information = var12;
   }

   public final int getLastY() {
      return (int)this.last_y;
   }

   public final int getWheelDelta() {
      return this.button_data / 120;
   }

   public final void set(RawMouseEvent var1) {
      this.set(var1.millis, var1.flags, var1.button_flags, var1.button_data, var1.raw_buttons, var1.last_x, var1.last_y, var1.extra_information);
   }

   public final long getNanos() {
      return this.millis * 1000000L;
   }

   private final int getButtonData() {
      return this.button_data;
   }

   public final int getFlags() {
      return this.flags;
   }

   public final int getLastX() {
      return (int)this.last_x;
   }
}
