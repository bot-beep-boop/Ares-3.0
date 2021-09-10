package net.minecraft.client.audio;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.util.RegistrySimple;
import net.minecraft.util.ResourceLocation;

public class SoundRegistry extends RegistrySimple<ResourceLocation, SoundEventAccessorComposite> {
   private Map<ResourceLocation, SoundEventAccessorComposite> soundRegistry;

   protected Map<ResourceLocation, SoundEventAccessorComposite> createUnderlyingMap() {
      this.soundRegistry = Maps.newHashMap();
      return this.soundRegistry;
   }

   public void registerSound(SoundEventAccessorComposite var1) {
      this.putObject(var1.getSoundEventLocation(), var1);
   }

   public void clearMap() {
      this.soundRegistry.clear();
   }
}
