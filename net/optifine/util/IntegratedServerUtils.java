package net.optifine.util;

import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;

public class IntegratedServerUtils {
   public static Entity getEntity(UUID var0) {
      WorldServer var1 = getWorldServer();
      if (var1 == null) {
         return null;
      } else {
         Entity var2 = var1.getEntityFromUuid(var0);
         return var2;
      }
   }

   public static WorldServer getWorldServer() {
      Minecraft var0 = Config.getMinecraft();
      WorldClient var1 = var0.theWorld;
      if (var1 == null) {
         return null;
      } else if (!var0.isIntegratedServerRunning()) {
         return null;
      } else {
         IntegratedServer var2 = var0.getIntegratedServer();
         if (var2 == null) {
            return null;
         } else {
            WorldProvider var3 = var1.provider;
            if (var3 == null) {
               return null;
            } else {
               int var4 = var3.getDimensionId();

               try {
                  WorldServer var5 = var2.worldServerForDimension(var4);
                  return var5;
               } catch (NullPointerException var6) {
                  return null;
               }
            }
         }
      }
   }

   public static TileEntity getTileEntity(BlockPos var0) {
      WorldServer var1 = getWorldServer();
      if (var1 == null) {
         return null;
      } else {
         Chunk var2 = var1.getChunkProvider().provideChunk(var0.getX() >> 4, var0.getZ() >> 4);
         if (var2 == null) {
            return null;
         } else {
            TileEntity var3 = var2.getTileEntity(var0, Chunk.EnumCreateEntityType.CHECK);
            return var3;
         }
      }
   }
}
