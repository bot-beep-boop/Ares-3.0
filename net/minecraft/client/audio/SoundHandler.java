package net.minecraft.client.audio;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ITickable;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SoundHandler implements ITickable, IResourceManagerReloadListener {
   private final IResourceManager mcResourceManager;
   private final SoundRegistry sndRegistry = new SoundRegistry();
   private static final ParameterizedType TYPE = new ParameterizedType() {
      public Type[] getActualTypeArguments() {
         return new Type[]{String.class, SoundList.class};
      }

      public Type getOwnerType() {
         return null;
      }

      public Type getRawType() {
         return Map.class;
      }
   };
   private static final Gson GSON = (new GsonBuilder()).registerTypeAdapter(SoundList.class, new SoundListSerializer()).create();
   public static final SoundPoolEntry missing_sound = new SoundPoolEntry(new ResourceLocation("meta:missing_sound"), 0.0D, 0.0D, false);
   private static final Logger logger = LogManager.getLogger();
   private final SoundManager sndManager;
   private static int[] $SWITCH_TABLE$net$minecraft$client$audio$SoundList$SoundEntry$Type;

   protected Map<String, SoundList> getSoundMap(InputStream var1) {
      try {
         Map var2 = (Map)GSON.fromJson(new InputStreamReader(var1), TYPE);
         IOUtils.closeQuietly(var1);
         return var2;
      } finally {
         IOUtils.closeQuietly(var1);
      }
   }

   public void setSoundLevel(SoundCategory var1, float var2) {
      if (var1 == SoundCategory.MASTER && var2 <= 0.0F) {
         this.stopSounds();
      }

      this.sndManager.setSoundCategoryVolume(var1, var2);
   }

   public void setListener(EntityPlayer var1, float var2) {
      this.sndManager.setListener(var1, var2);
   }

   public void stopSound(ISound var1) {
      this.sndManager.stopSound(var1);
   }

   static int[] $SWITCH_TABLE$net$minecraft$client$audio$SoundList$SoundEntry$Type() {
      int[] var10000 = $SWITCH_TABLE$net$minecraft$client$audio$SoundList$SoundEntry$Type;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[SoundList.SoundEntry.Type.values().length];

         try {
            var0[SoundList.SoundEntry.Type.FILE.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[SoundList.SoundEntry.Type.SOUND_EVENT.ordinal()] = 2;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$minecraft$client$audio$SoundList$SoundEntry$Type = var0;
         return var0;
      }
   }

   public boolean isSoundPlaying(ISound var1) {
      return this.sndManager.isSoundPlaying(var1);
   }

   public void update() {
      this.sndManager.updateAllSounds();
   }

   public SoundEventAccessorComposite getRandomSoundFromCategories(SoundCategory... var1) {
      ArrayList var2 = Lists.newArrayList();
      Iterator var4 = this.sndRegistry.getKeys().iterator();

      while(var4.hasNext()) {
         ResourceLocation var3 = (ResourceLocation)var4.next();
         SoundEventAccessorComposite var5 = (SoundEventAccessorComposite)this.sndRegistry.getObject(var3);
         if (ArrayUtils.contains(var1, var5.getSoundCategory())) {
            var2.add(var5);
         }
      }

      return var2.isEmpty() ? null : (SoundEventAccessorComposite)var2.get((new Random()).nextInt(var2.size()));
   }

   public void resumeSounds() {
      this.sndManager.resumeAllSounds();
   }

   public void pauseSounds() {
      this.sndManager.pauseAllSounds();
   }

   static SoundRegistry access$0(SoundHandler var0) {
      return var0.sndRegistry;
   }

   public SoundHandler(IResourceManager var1, GameSettings var2) {
      this.mcResourceManager = var1;
      this.sndManager = new SoundManager(this, var2);
   }

   public void playDelayedSound(ISound var1, int var2) {
      this.sndManager.playDelayedSound(var1, var2);
   }

   public void stopSounds() {
      this.sndManager.stopAllSounds();
   }

   public void onResourceManagerReload(IResourceManager param1) {
      // $FF: Couldn't be decompiled
   }

   public SoundEventAccessorComposite getSound(ResourceLocation var1) {
      return (SoundEventAccessorComposite)this.sndRegistry.getObject(var1);
   }

   public void playSound(ISound var1) {
      this.sndManager.playSound(var1);
   }

   public void unloadSounds() {
      this.sndManager.unloadSoundSystem();
   }

   private void loadSoundResource(ResourceLocation var1, SoundList var2) {
      boolean var3 = !this.sndRegistry.containsKey(var1);
      SoundEventAccessorComposite var4;
      if (!var3 && !var2.canReplaceExisting()) {
         var4 = (SoundEventAccessorComposite)this.sndRegistry.getObject(var1);
      } else {
         if (!var3) {
            logger.debug("Replaced sound event location {}", new Object[]{var1});
         }

         var4 = new SoundEventAccessorComposite(var1, 1.0D, 1.0D, var2.getSoundCategory());
         this.sndRegistry.registerSound(var4);
      }

      Iterator var6 = var2.getSoundList().iterator();

      while(var6.hasNext()) {
         SoundList.SoundEntry var5 = (SoundList.SoundEntry)var6.next();
         String var7 = var5.getSoundEntryName();
         ResourceLocation var8 = new ResourceLocation(var7);
         String var9 = var7.contains(":") ? var8.getResourceDomain() : var1.getResourceDomain();
         Object var10;
         switch($SWITCH_TABLE$net$minecraft$client$audio$SoundList$SoundEntry$Type()[var5.getSoundEntryType().ordinal()]) {
         case 1:
            ResourceLocation var11 = new ResourceLocation(var9, "sounds/" + var8.getResourcePath() + ".ogg");
            InputStream var12 = null;
            boolean var18 = false;

            label143: {
               try {
                  label166: {
                     try {
                        var18 = true;
                        var12 = this.mcResourceManager.getResource(var11).getInputStream();
                     } catch (FileNotFoundException var19) {
                        logger.warn("File {} does not exist, cannot add it to event {}", new Object[]{var11, var1});
                        var18 = false;
                        break label166;
                     } catch (IOException var20) {
                        logger.warn("Could not load sound file " + var11 + ", cannot add it to event " + var1, var20);
                        var18 = false;
                        break label143;
                     }

                     IOUtils.closeQuietly(var12);
                     var10 = new SoundEventAccessor(new SoundPoolEntry(var11, (double)var5.getSoundEntryPitch(), (double)var5.getSoundEntryVolume(), var5.isStreaming()), var5.getSoundEntryWeight());
                     var18 = false;
                     break;
                  }
               } finally {
                  if (var18) {
                     IOUtils.closeQuietly(var12);
                  }
               }

               IOUtils.closeQuietly(var12);
               continue;
            }

            IOUtils.closeQuietly(var12);
            continue;
         case 2:
            var10 = new ISoundEventAccessor<SoundPoolEntry>(this, var9, var5) {
               final SoundHandler this$0;
               final ResourceLocation field_148726_a;

               public SoundPoolEntry cloneEntry() {
                  SoundEventAccessorComposite var1 = (SoundEventAccessorComposite)SoundHandler.access$0(this.this$0).getObject(this.field_148726_a);
                  return var1 == null ? SoundHandler.missing_sound : var1.cloneEntry();
               }

               {
                  this.this$0 = var1;
                  this.field_148726_a = new ResourceLocation(var2, var3.getSoundEntryName());
               }

               public Object cloneEntry() {
                  return this.cloneEntry();
               }

               public int getWeight() {
                  SoundEventAccessorComposite var1 = (SoundEventAccessorComposite)SoundHandler.access$0(this.this$0).getObject(this.field_148726_a);
                  return var1 == null ? 0 : var1.getWeight();
               }
            };
            break;
         default:
            throw new IllegalStateException("IN YOU FACE");
         }

         var4.addSoundToEventPool((ISoundEventAccessor)var10);
      }

   }
}
