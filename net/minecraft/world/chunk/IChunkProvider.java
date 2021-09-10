package net.minecraft.world.chunk;

import java.util.List;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public interface IChunkProvider {
   Chunk provideChunk(BlockPos var1);

   List<BiomeGenBase.SpawnListEntry> getPossibleCreatures(EnumCreatureType var1, BlockPos var2);

   int getLoadedChunkCount();

   boolean unloadQueuedChunks();

   void populate(IChunkProvider var1, int var2, int var3);

   boolean populateChunk(IChunkProvider var1, Chunk var2, int var3, int var4);

   boolean chunkExists(int var1, int var2);

   void recreateStructures(Chunk var1, int var2, int var3);

   Chunk provideChunk(int var1, int var2);

   boolean canSave();

   String makeString();

   BlockPos getStrongholdGen(World var1, String var2, BlockPos var3);

   void saveExtraData();

   boolean saveChunks(boolean var1, IProgressUpdate var2);
}
