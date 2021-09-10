package net.minecraft.client.audio;

import net.minecraft.util.ResourceLocation;

public abstract class PositionedSound implements ISound {
   protected ISound.AttenuationType attenuationType;
   protected float yPosF;
   protected float xPosF;
   protected float zPosF;
   protected float volume = 1.0F;
   protected int repeatDelay = 0;
   protected final ResourceLocation positionedSoundLocation;
   protected boolean repeat = false;
   protected float pitch = 1.0F;

   public int getRepeatDelay() {
      return this.repeatDelay;
   }

   public float getVolume() {
      return this.volume;
   }

   public float getPitch() {
      return this.pitch;
   }

   public ISound.AttenuationType getAttenuationType() {
      return this.attenuationType;
   }

   protected PositionedSound(ResourceLocation var1) {
      this.attenuationType = ISound.AttenuationType.LINEAR;
      this.positionedSoundLocation = var1;
   }

   public ResourceLocation getSoundLocation() {
      return this.positionedSoundLocation;
   }

   public boolean canRepeat() {
      return this.repeat;
   }

   public float getXPosF() {
      return this.xPosF;
   }

   public float getZPosF() {
      return this.zPosF;
   }

   public float getYPosF() {
      return this.yPosF;
   }
}
