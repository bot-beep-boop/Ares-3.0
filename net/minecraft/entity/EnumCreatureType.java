package net.minecraft.entity;

import net.minecraft.block.material.Material;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.passive.IAnimals;

public enum EnumCreatureType {
   private static final EnumCreatureType[] ENUM$VALUES = new EnumCreatureType[]{MONSTER, CREATURE, AMBIENT, WATER_CREATURE};
   private final boolean isAnimal;
   WATER_CREATURE(EntityWaterMob.class, 5, Material.water, true, false);

   private final Class<? extends IAnimals> creatureClass;
   CREATURE(EntityAnimal.class, 10, Material.air, true, true);

   private final Material creatureMaterial;
   AMBIENT(EntityAmbientCreature.class, 15, Material.air, true, false);

   private final boolean isPeacefulCreature;
   private final int maxNumberOfCreature;
   MONSTER(IMob.class, 70, Material.air, false, false);

   public Class<? extends IAnimals> getCreatureClass() {
      return this.creatureClass;
   }

   private EnumCreatureType(Class<? extends IAnimals> var3, int var4, Material var5, boolean var6, boolean var7) {
      this.creatureClass = var3;
      this.maxNumberOfCreature = var4;
      this.creatureMaterial = var5;
      this.isPeacefulCreature = var6;
      this.isAnimal = var7;
   }

   public boolean getAnimal() {
      return this.isAnimal;
   }

   public boolean getPeacefulCreature() {
      return this.isPeacefulCreature;
   }

   public int getMaxNumberOfCreature() {
      return this.maxNumberOfCreature;
   }
}
