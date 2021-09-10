package net.minecraft.client.audio;

import net.minecraft.util.ResourceLocation;

public interface ISound {
   boolean canRepeat();

   float getVolume();

   float getXPosF();

   float getZPosF();

   ISound.AttenuationType getAttenuationType();

   float getYPosF();

   ResourceLocation getSoundLocation();

   int getRepeatDelay();

   float getPitch();

   public static enum AttenuationType {
      LINEAR(2);

      private static final ISound.AttenuationType[] ENUM$VALUES = new ISound.AttenuationType[]{NONE, LINEAR};
      NONE(0);

      private final int type;

      private AttenuationType(int var3) {
         this.type = var3;
      }

      public int getTypeInt() {
         return this.type;
      }
   }
}
