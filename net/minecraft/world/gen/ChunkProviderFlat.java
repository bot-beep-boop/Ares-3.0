package net.minecraft.world.gen;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraft.world.gen.structure.StructureOceanMonument;

public class ChunkProviderFlat implements IChunkProvider {
   private Random random;
   private final boolean hasDecoration;
   private WorldGenLakes waterLakeGenerator;
   private final FlatGeneratorInfo flatWorldGenInfo;
   private final IBlockState[] cachedBlockIDs = new IBlockState[256];
   private WorldGenLakes lavaLakeGenerator;
   private final boolean hasDungeons;
   private World worldObj;
   private final List<MapGenStructure> structureGenerators = Lists.newArrayList();

   public int getLoadedChunkCount() {
      return 0;
   }

   public BlockPos getStrongholdGen(World var1, String var2, BlockPos var3) {
      if ("Stronghold".equals(var2)) {
         Iterator var5 = this.structureGenerators.iterator();

         while(var5.hasNext()) {
            MapGenStructure var4 = (MapGenStructure)var5.next();
            if (var4 instanceof MapGenStronghold) {
               return var4.getClosestStrongholdPos(var1, var3);
            }
         }
      }

      return null;
   }

   public String makeString() {
      return "FlatLevelSource";
   }

   public boolean saveChunks(boolean var1, IProgressUpdate var2) {
      return true;
   }

   public void saveExtraData() {
   }

   public void recreateStructures(Chunk var1, int var2, int var3) {
      Iterator var5 = this.structureGenerators.iterator();

      while(var5.hasNext()) {
         MapGenStructure var4 = (MapGenStructure)var5.next();
         var4.generate(this, this.worldObj, var2, var3, (ChunkPrimer)null);
      }

   }

   public boolean chunkExists(int var1, int var2) {
      return true;
   }

   public Chunk provideChunk(int var1, int var2) {
      ChunkPrimer var3 = new ChunkPrimer();

      int var7;
      for(int var4 = 0; var4 < this.cachedBlockIDs.length; ++var4) {
         IBlockState var5 = this.cachedBlockIDs[var4];
         if (var5 != null) {
            for(int var6 = 0; var6 < 16; ++var6) {
               for(var7 = 0; var7 < 16; ++var7) {
                  var3.setBlockState(var6, var4, var7, var5);
               }
            }
         }
      }

      Iterator var10 = this.structureGenerators.iterator();

      while(var10.hasNext()) {
         MapGenBase var8 = (MapGenBase)var10.next();
         var8.generate(this, this.worldObj, var1, var2, var3);
      }

      Chunk var9 = new Chunk(this.worldObj, var3, var1, var2);
      BiomeGenBase[] var11 = this.worldObj.getWorldChunkManager().loadBlockGeneratorData((BiomeGenBase[])null, var1 * 16, var2 * 16, 16, 16);
      byte[] var12 = var9.getBiomeArray();

      for(var7 = 0; var7 < var12.length; ++var7) {
         var12[var7] = (byte)var11[var7].biomeID;
      }

      var9.generateSkylightMap();
      return var9;
   }

   public boolean populateChunk(IChunkProvider var1, Chunk var2, int var3, int var4) {
      return false;
   }

   public Chunk provideChunk(BlockPos var1) {
      return this.provideChunk(var1.getX() >> 4, var1.getZ() >> 4);
   }

   public boolean unloadQueuedChunks() {
      return false;
   }

   public void populate(IChunkProvider var1, int var2, int var3) {
      int var4 = var2 * 16;
      int var5 = var3 * 16;
      BlockPos var6 = new BlockPos(var4, 0, var5);
      BiomeGenBase var7 = this.worldObj.getBiomeGenForCoords(new BlockPos(var4 + 16, 0, var5 + 16));
      boolean var8 = false;
      this.random.setSeed(this.worldObj.getSeed());
      long var9 = this.random.nextLong() / 2L * 2L + 1L;
      long var11 = this.random.nextLong() / 2L * 2L + 1L;
      this.random.setSeed((long)var2 * var9 + (long)var3 * var11 ^ this.worldObj.getSeed());
      ChunkCoordIntPair var13 = new ChunkCoordIntPair(var2, var3);
      Iterator var15 = this.structureGenerators.iterator();

      while(var15.hasNext()) {
         MapGenStructure var14 = (MapGenStructure)var15.next();
         boolean var16 = var14.generateStructure(this.worldObj, this.random, var13);
         if (var14 instanceof MapGenVillage) {
            var8 |= var16;
         }
      }

      if (this.waterLakeGenerator != null && !var8 && this.random.nextInt(4) == 0) {
         this.waterLakeGenerator.generate(this.worldObj, this.random, var6.add(this.random.nextInt(16) + 8, this.random.nextInt(256), this.random.nextInt(16) + 8));
      }

      if (this.lavaLakeGenerator != null && !var8 && this.random.nextInt(8) == 0) {
         BlockPos var17 = var6.add(this.random.nextInt(16) + 8, this.random.nextInt(this.random.nextInt(248) + 8), this.random.nextInt(16) + 8);
         if (var17.getY() < this.worldObj.getSeaLevel() || this.random.nextInt(10) == 0) {
            this.lavaLakeGenerator.generate(this.worldObj, this.random, var17);
         }
      }

      if (this.hasDungeons) {
         for(int var18 = 0; var18 < 8; ++var18) {
            (new WorldGenDungeons()).generate(this.worldObj, this.random, var6.add(this.random.nextInt(16) + 8, this.random.nextInt(256), this.random.nextInt(16) + 8));
         }
      }

      if (this.hasDecoration) {
         var7.decorate(this.worldObj, this.random, var6);
      }

   }

   public List<BiomeGenBase.SpawnListEntry> getPossibleCreatures(EnumCreatureType var1, BlockPos var2) {
      BiomeGenBase var3 = this.worldObj.getBiomeGenForCoords(var2);
      return var3.getSpawnableList(var1);
   }

   public boolean canSave() {
      return true;
   }

   public ChunkProviderFlat(World var1, long var2, boolean var4, String var5) {
      this.worldObj = var1;
      this.random = new Random(var2);
      this.flatWorldGenInfo = FlatGeneratorInfo.createFlatGeneratorFromString(var5);
      if (var4) {
         Map var6 = this.flatWorldGenInfo.getWorldFeatures();
         if (var6.containsKey("village")) {
            Map var7 = (Map)var6.get("village");
            if (!var7.containsKey("size")) {
               var7.put("size", "1");
            }

            this.structureGenerators.add(new MapGenVillage(var7));
         }

         if (var6.containsKey("biome_1")) {
            this.structureGenerators.add(new MapGenScatteredFeature((Map)var6.get("biome_1")));
         }

         if (var6.containsKey("mineshaft")) {
            this.structureGenerators.add(new MapGenMineshaft((Map)var6.get("mineshaft")));
         }

         if (var6.containsKey("stronghold")) {
            this.structureGenerators.add(new MapGenStronghold((Map)var6.get("stronghold")));
         }

         if (var6.containsKey("oceanmonument")) {
            this.structureGenerators.add(new StructureOceanMonument((Map)var6.get("oceanmonument")));
         }
      }

      if (this.flatWorldGenInfo.getWorldFeatures().containsKey("lake")) {
         this.waterLakeGenerator = new WorldGenLakes(Blocks.water);
      }

      if (this.flatWorldGenInfo.getWorldFeatures().containsKey("lava_lake")) {
         this.lavaLakeGenerator = new WorldGenLakes(Blocks.lava);
      }

      this.hasDungeons = this.flatWorldGenInfo.getWorldFeatures().containsKey("dungeon");
      int var13 = 0;
      int var14 = 0;
      boolean var8 = true;
      Iterator var10 = this.flatWorldGenInfo.getFlatLayers().iterator();

      while(var10.hasNext()) {
         FlatLayerInfo var9 = (FlatLayerInfo)var10.next();

         for(int var11 = var9.getMinY(); var11 < var9.getMinY() + var9.getLayerCount(); ++var11) {
            IBlockState var12 = var9.getLayerMaterial();
            if (var12.getBlock() != Blocks.air) {
               var8 = false;
               this.cachedBlockIDs[var11] = var12;
            }
         }

         if (var9.getLayerMaterial().getBlock() == Blocks.air) {
            var14 += var9.getLayerCount();
         } else {
            var13 += var9.getLayerCount() + var14;
            var14 = 0;
         }
      }

      var1.setSeaLevel(var13);
      this.hasDecoration = var8 ? false : this.flatWorldGenInfo.getWorldFeatures().containsKey("decoration");
   }
}
