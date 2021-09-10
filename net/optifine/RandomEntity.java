package net.optifine;

import java.util.UUID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.BlockPos;
import net.minecraft.world.biome.BiomeGenBase;

public class RandomEntity implements IRandomEntity {
   private Entity entity;

   public BiomeGenBase getSpawnBiome() {
      return this.entity.getDataWatcher().spawnBiome;
   }

   public int getId() {
      UUID var1 = this.entity.getUniqueID();
      long var2 = var1.getLeastSignificantBits();
      int var4 = (int)(var2 & 2147483647L);
      return var4;
   }

   public Entity getEntity() {
      return this.entity;
   }

   public String getName() {
      return this.entity.hasCustomName() ? this.entity.getCustomNameTag() : null;
   }

   public BlockPos getSpawnPosition() {
      return this.entity.getDataWatcher().spawnPosition;
   }

   public int getHealth() {
      if (!(this.entity instanceof EntityLiving)) {
         return 0;
      } else {
         EntityLiving var1 = (EntityLiving)this.entity;
         return (int)var1.getHealth();
      }
   }

   public void setEntity(Entity var1) {
      this.entity = var1;
   }

   public int getMaxHealth() {
      if (!(this.entity instanceof EntityLiving)) {
         return 0;
      } else {
         EntityLiving var1 = (EntityLiving)this.entity;
         return (int)var1.getMaxHealth();
      }
   }
}
