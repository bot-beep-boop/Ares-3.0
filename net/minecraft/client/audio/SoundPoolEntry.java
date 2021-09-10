package net.minecraft.client.audio;

import net.minecraft.util.ResourceLocation;

public class SoundPoolEntry {
   private double pitch;
   private final boolean streamingSound;
   private final ResourceLocation location;
   private double volume;

   public boolean isStreamingSound() {
      return this.streamingSound;
   }

   public double getPitch() {
      return this.pitch;
   }

   public void setVolume(double var1) {
      this.volume = var1;
   }

   public ResourceLocation getSoundPoolEntryLocation() {
      return this.location;
   }

   public SoundPoolEntry(ResourceLocation var1, double var2, double var4, boolean var6) {
      this.location = var1;
      this.pitch = var2;
      this.volume = var4;
      this.streamingSound = var6;
   }

   public SoundPoolEntry(SoundPoolEntry var1) {
      this.location = var1.location;
      this.pitch = var1.pitch;
      this.volume = var1.volume;
      this.streamingSound = var1.streamingSound;
   }

   public double getVolume() {
      return this.volume;
   }

   public void setPitch(double var1) {
      this.pitch = var1;
   }
}
