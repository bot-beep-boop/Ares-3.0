package net.optifine;

import net.minecraft.util.BlockPos;
import net.minecraft.world.biome.BiomeGenBase;

public interface IRandomEntity {
   String getName();

   int getMaxHealth();

   int getId();

   int getHealth();

   BlockPos getSpawnPosition();

   BiomeGenBase getSpawnBiome();
}
