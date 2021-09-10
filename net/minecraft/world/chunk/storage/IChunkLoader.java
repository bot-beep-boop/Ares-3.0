package net.minecraft.world.chunk.storage;

import java.io.IOException;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public interface IChunkLoader {
   void saveExtraChunkData(World var1, Chunk var2) throws IOException;

   void chunkTick();

   Chunk loadChunk(World var1, int var2, int var3) throws IOException;

   void saveExtraData();

   void saveChunk(World var1, Chunk var2) throws MinecraftException, IOException;
}
