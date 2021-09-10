package net.java.games.input;

import java.io.IOException;

final class DIDeviceObject {
   private final int type;
   private final int instance;
   private final int format_offset;
   private final byte[] guid;
   private static final int WHEEL_SCALE = 120;
   private final long max;
   private final String name;
   private final int flags;
   private int last_poll_value;
   private final IDirectInputDevice device;
   private final int identifier;
   private final int deadzone;
   private int last_event_value;
   private final Component.Identifier id;
   private final int guid_type;
   private final long min;

   public final int getGUIDType() {
      return this.guid_type;
   }

   public final Component.Identifier getIdentifier() {
      return this.id;
   }

   public final String getName() {
      return this.name;
   }

   public final long getMin() {
      return this.min;
   }

   public final int getFormatOffset() {
      return this.format_offset;
   }

   public final float getDeadzone() {
      return (float)this.deadzone;
   }

   public final int getInstance() {
      return this.instance;
   }

   public final boolean isAnalog() {
      return this.isAxis() && this.id != Component.Identifier.Axis.POV;
   }

   public final IDirectInputDevice getDevice() {
      return this.device;
   }

   public final byte[] getGUID() {
      return this.guid;
   }

   public final int getFlags() {
      return this.flags;
   }

   public final long getMax() {
      return this.max;
   }

   public final synchronized int getRelativeEventValue(int var1) {
      if (this.device.areAxesRelative()) {
         return var1;
      } else {
         int var2 = var1 - this.last_event_value;
         this.last_event_value = var1;
         return var2;
      }
   }

   public final int getType() {
      return this.type;
   }

   public final boolean isRelative() {
      return this.isAxis() && (this.type & 1) != 0;
   }

   public final boolean isAxis() {
      return (this.type & 3) != 0;
   }

   public final synchronized int getRelativePollValue(int var1) {
      if (this.device.areAxesRelative()) {
         return var1;
      } else {
         int var2 = var1 - this.last_poll_value;
         this.last_poll_value = var1;
         return var2;
      }
   }

   public final int getDIIdentifier() {
      return this.identifier;
   }

   public DIDeviceObject(IDirectInputDevice var1, Component.Identifier var2, byte[] var3, int var4, int var5, int var6, int var7, int var8, String var9, int var10) throws IOException {
      this.device = var1;
      this.id = var2;
      this.guid = var3;
      this.identifier = var5;
      this.type = var6;
      this.instance = var7;
      this.guid_type = var4;
      this.flags = var8;
      this.name = var9;
      this.format_offset = var10;
      if (this.isAxis() && !this.isRelative()) {
         long[] var11 = var1.getRangeProperty(var5);
         this.min = var11[0];
         this.max = var11[1];
         this.deadzone = var1.getDeadzoneProperty(var5);
      } else {
         this.min = -2147483648L;
         this.max = 2147483647L;
         this.deadzone = 0;
      }

   }

   public final boolean isButton() {
      return (this.type & 12) != 0;
   }

   public final float convertValue(float var1) {
      if (this.getDevice().getType() == 18 && this.id == Component.Identifier.Axis.Z) {
         return var1 / 120.0F;
      } else if (this.isButton()) {
         return ((int)var1 & 128) != 0 ? 1.0F : 0.0F;
      } else if (this.id == Component.Identifier.Axis.POV) {
         int var2 = (int)var1;
         if ((var2 & '\uffff') == 65535) {
            return 0.0F;
         } else {
            short var3 = 2250;
            if (var2 >= 0 && var2 < var3) {
               return 0.25F;
            } else if (var2 < 3 * var3) {
               return 0.375F;
            } else if (var2 < 5 * var3) {
               return 0.5F;
            } else if (var2 < 7 * var3) {
               return 0.625F;
            } else if (var2 < 9 * var3) {
               return 0.75F;
            } else if (var2 < 11 * var3) {
               return 0.875F;
            } else if (var2 < 13 * var3) {
               return 1.0F;
            } else {
               return var2 < 15 * var3 ? 0.125F : 0.25F;
            }
         }
      } else {
         return this.isAxis() && !this.isRelative() ? 2.0F * (var1 - (float)this.min) / (float)(this.max - this.min) - 1.0F : var1;
      }
   }
}
