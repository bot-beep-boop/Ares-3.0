package net.minecraft.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Map;

public enum EnumParticleTypes {
   FIREWORKS_SPARK("fireworksSpark", 3, false),
   WATER_BUBBLE("bubble", 4, false),
   ITEM_TAKE("take", 40, false),
   SPELL_INSTANT("instantSpell", 14, false),
   BLOCK_DUST("blockdust_", 38, false, 1),
   WATER_WAKE("wake", 6, false),
   SMOKE_LARGE("largesmoke", 12, false);

   private final int argumentCount;
   SPELL_MOB_AMBIENT("mobSpellAmbient", 16, false),
   EXPLOSION_LARGE("largeexplode", 1, true),
   CRIT("crit", 9, false),
   BLOCK_CRACK("blockcrack_", 37, false, 1),
   SNOWBALL("snowballpoof", 31, false),
   MOB_APPEARANCE("mobappearance", 41, true),
   SNOW_SHOVEL("snowshovel", 32, false),
   EXPLOSION_NORMAL("explode", 0, true),
   CLOUD("cloud", 29, false),
   WATER_DROP("droplet", 39, false),
   DRIP_WATER("dripWater", 18, false);

   private static final EnumParticleTypes[] ENUM$VALUES = new EnumParticleTypes[]{EXPLOSION_NORMAL, EXPLOSION_LARGE, EXPLOSION_HUGE, FIREWORKS_SPARK, WATER_BUBBLE, WATER_SPLASH, WATER_WAKE, SUSPENDED, SUSPENDED_DEPTH, CRIT, CRIT_MAGIC, SMOKE_NORMAL, SMOKE_LARGE, SPELL, SPELL_INSTANT, SPELL_MOB, SPELL_MOB_AMBIENT, SPELL_WITCH, DRIP_WATER, DRIP_LAVA, VILLAGER_ANGRY, VILLAGER_HAPPY, TOWN_AURA, NOTE, PORTAL, ENCHANTMENT_TABLE, FLAME, LAVA, FOOTSTEP, CLOUD, REDSTONE, SNOWBALL, SNOW_SHOVEL, SLIME, HEART, BARRIER, ITEM_CRACK, BLOCK_CRACK, BLOCK_DUST, WATER_DROP, ITEM_TAKE, MOB_APPEARANCE};
   private final int particleID;
   SLIME("slime", 33, false),
   LAVA("lava", 27, false),
   VILLAGER_ANGRY("angryVillager", 20, false),
   WATER_SPLASH("splash", 5, false),
   DRIP_LAVA("dripLava", 19, false),
   ENCHANTMENT_TABLE("enchantmenttable", 25, false),
   SPELL_WITCH("witchMagic", 17, false),
   ITEM_CRACK("iconcrack_", 36, false, 2),
   SMOKE_NORMAL("smoke", 11, false),
   FOOTSTEP("footstep", 28, false),
   VILLAGER_HAPPY("happyVillager", 21, false);

   private static final Map<Integer, EnumParticleTypes> PARTICLES = Maps.newHashMap();
   private final String particleName;
   SUSPENDED_DEPTH("depthsuspend", 8, false),
   SPELL("spell", 13, false),
   BARRIER("barrier", 35, false),
   PORTAL("portal", 24, false),
   FLAME("flame", 26, false),
   TOWN_AURA("townaura", 22, false);

   private final boolean shouldIgnoreRange;
   SPELL_MOB("mobSpell", 15, false),
   SUSPENDED("suspended", 7, false),
   CRIT_MAGIC("magicCrit", 10, false),
   NOTE("note", 23, false);

   private static final String[] PARTICLE_NAMES;
   EXPLOSION_HUGE("hugeexplosion", 2, true),
   REDSTONE("reddust", 30, false),
   HEART("heart", 34, false);

   public String getParticleName() {
      return this.particleName;
   }

   public boolean hasArguments() {
      return this.argumentCount > 0;
   }

   public int getParticleID() {
      return this.particleID;
   }

   private EnumParticleTypes(String var3, int var4, boolean var5) {
      this(var3, var4, var5, 0);
   }

   static {
      ArrayList var0 = Lists.newArrayList();
      EnumParticleTypes[] var4;
      int var3 = (var4 = values()).length;

      for(int var2 = 0; var2 < var3; ++var2) {
         EnumParticleTypes var1 = var4[var2];
         PARTICLES.put(var1.getParticleID(), var1);
         if (!var1.getParticleName().endsWith("_")) {
            var0.add(var1.getParticleName());
         }
      }

      PARTICLE_NAMES = (String[])var0.toArray(new String[var0.size()]);
   }

   public static String[] getParticleNames() {
      return PARTICLE_NAMES;
   }

   private EnumParticleTypes(String var3, int var4, boolean var5, int var6) {
      this.particleName = var3;
      this.particleID = var4;
      this.shouldIgnoreRange = var5;
      this.argumentCount = var6;
   }

   public boolean getShouldIgnoreRange() {
      return this.shouldIgnoreRange;
   }

   public static EnumParticleTypes getParticleFromId(int var0) {
      return (EnumParticleTypes)PARTICLES.get(var0);
   }

   public int getArgumentCount() {
      return this.argumentCount;
   }
}
