package net.minecraft.client.audio;

import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ITickable;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class MusicTicker implements ITickable {
   private final Random rand = new Random();
   private final Minecraft mc;
   private int timeUntilNextMusic = 100;
   private ISound currentMusic;

   public MusicTicker(Minecraft var1) {
      this.mc = var1;
   }

   public void update() {
      MusicTicker.MusicType var1 = this.mc.getAmbientMusicType();
      if (this.currentMusic != null) {
         if (!var1.getMusicLocation().equals(this.currentMusic.getSoundLocation())) {
            this.mc.getSoundHandler().stopSound(this.currentMusic);
            this.timeUntilNextMusic = MathHelper.getRandomIntegerInRange(this.rand, 0, var1.getMinDelay() / 2);
         }

         if (!this.mc.getSoundHandler().isSoundPlaying(this.currentMusic)) {
            this.currentMusic = null;
            this.timeUntilNextMusic = Math.min(MathHelper.getRandomIntegerInRange(this.rand, var1.getMinDelay(), var1.getMaxDelay()), this.timeUntilNextMusic);
         }
      }

      if (this.currentMusic == null && this.timeUntilNextMusic-- <= 0) {
         this.func_181558_a(var1);
      }

   }

   public void func_181558_a(MusicTicker.MusicType var1) {
      this.currentMusic = PositionedSoundRecord.create(var1.getMusicLocation());
      this.mc.getSoundHandler().playSound(this.currentMusic);
      this.timeUntilNextMusic = Integer.MAX_VALUE;
   }

   public void func_181557_a() {
      if (this.currentMusic != null) {
         this.mc.getSoundHandler().stopSound(this.currentMusic);
         this.currentMusic = null;
         this.timeUntilNextMusic = 0;
      }

   }

   public static enum MusicType {
      private final ResourceLocation musicLocation;
      MENU(new ResourceLocation("minecraft:music.menu"), 20, 600),
      CREATIVE(new ResourceLocation("minecraft:music.game.creative"), 1200, 3600);

      private final int minDelay;
      private final int maxDelay;
      GAME(new ResourceLocation("minecraft:music.game"), 12000, 24000),
      END_BOSS(new ResourceLocation("minecraft:music.game.end.dragon"), 0, 0),
      END(new ResourceLocation("minecraft:music.game.end"), 6000, 24000),
      NETHER(new ResourceLocation("minecraft:music.game.nether"), 1200, 3600),
      CREDITS(new ResourceLocation("minecraft:music.game.end.credits"), Integer.MAX_VALUE, Integer.MAX_VALUE);

      private static final MusicTicker.MusicType[] ENUM$VALUES = new MusicTicker.MusicType[]{MENU, GAME, CREATIVE, CREDITS, NETHER, END_BOSS, END};

      public int getMaxDelay() {
         return this.maxDelay;
      }

      public int getMinDelay() {
         return this.minDelay;
      }

      private MusicType(ResourceLocation var3, int var4, int var5) {
         this.musicLocation = var3;
         this.minDelay = var4;
         this.maxDelay = var5;
      }

      public ResourceLocation getMusicLocation() {
         return this.musicLocation;
      }
   }
}
