package net.minecraft.world.gen.structure;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class MapGenNetherBridge extends MapGenStructure {
   private List<BiomeGenBase.SpawnListEntry> spawnList = Lists.newArrayList();

   public String getStructureName() {
      return "Fortress";
   }

   protected StructureStart getStructureStart(int var1, int var2) {
      return new MapGenNetherBridge.Start(this.worldObj, this.rand, var1, var2);
   }

   protected boolean canSpawnStructureAtCoords(int var1, int var2) {
      int var3 = var1 >> 4;
      int var4 = var2 >> 4;
      this.rand.setSeed((long)(var3 ^ var4 << 4) ^ this.worldObj.getSeed());
      this.rand.nextInt();
      if (this.rand.nextInt(3) != 0) {
         return false;
      } else if (var1 != (var3 << 4) + 4 + this.rand.nextInt(8)) {
         return false;
      } else {
         return var2 == (var4 << 4) + 4 + this.rand.nextInt(8);
      }
   }

   public MapGenNetherBridge() {
      this.spawnList.add(new BiomeGenBase.SpawnListEntry(EntityBlaze.class, 10, 2, 3));
      this.spawnList.add(new BiomeGenBase.SpawnListEntry(EntityPigZombie.class, 5, 4, 4));
      this.spawnList.add(new BiomeGenBase.SpawnListEntry(EntitySkeleton.class, 10, 4, 4));
      this.spawnList.add(new BiomeGenBase.SpawnListEntry(EntityMagmaCube.class, 3, 4, 4));
   }

   public List<BiomeGenBase.SpawnListEntry> getSpawnList() {
      return this.spawnList;
   }

   public static class Start extends StructureStart {
      public Start(World var1, Random var2, int var3, int var4) {
         super(var3, var4);
         StructureNetherBridgePieces.Start var5 = new StructureNetherBridgePieces.Start(var2, (var3 << 4) + 2, (var4 << 4) + 2);
         this.components.add(var5);
         var5.buildComponent(var5, this.components, var2);
         List var6 = var5.field_74967_d;

         while(!var6.isEmpty()) {
            int var7 = var2.nextInt(var6.size());
            StructureComponent var8 = (StructureComponent)var6.remove(var7);
            var8.buildComponent(var5, this.components, var2);
         }

         this.updateBoundingBox();
         this.setRandomHeight(var1, var2, 48, 70);
      }

      public Start() {
      }
   }
}
