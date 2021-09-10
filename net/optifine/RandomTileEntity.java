package net.optifine;

import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.biome.BiomeGenBase;
import net.optifine.util.TileEntityUtils;

public class RandomTileEntity implements IRandomEntity {
   private TileEntity tileEntity;

   public String getName() {
      String var1 = TileEntityUtils.getTileEntityName(this.tileEntity);
      return var1;
   }

   public int getHealth() {
      return -1;
   }

   public void setTileEntity(TileEntity var1) {
      this.tileEntity = var1;
   }

   public TileEntity getTileEntity() {
      return this.tileEntity;
   }

   public int getMaxHealth() {
      return -1;
   }

   public int getId() {
      return Config.getRandom(this.tileEntity.getPos(), this.tileEntity.getBlockMetadata());
   }

   public BiomeGenBase getSpawnBiome() {
      return this.tileEntity.getWorld().getBiomeGenForCoords(this.tileEntity.getPos());
   }

   public BlockPos getSpawnPosition() {
      return this.tileEntity.getPos();
   }
}
