package net.minecraft.server.management;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Map.Entry;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S21PacketChunkData;
import net.minecraft.network.play.server.S22PacketMultiBlockChange;
import net.minecraft.network.play.server.S23PacketBlockChange;
import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import net.optifine.ChunkPosComparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlayerManager {
   private long previousTotalWorldTime;
   private final int[][] xzDirectionsConst = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
   private final List<PlayerManager.PlayerInstance> playerInstancesToUpdate = Lists.newArrayList();
   private final List<PlayerManager.PlayerInstance> playerInstanceList = Lists.newArrayList();
   private final LongHashMap<PlayerManager.PlayerInstance> playerInstances = new LongHashMap();
   private final Map<EntityPlayerMP, Set<ChunkCoordIntPair>> mapPlayerPendingEntries = new HashMap();
   private int playerViewRadius;
   private final WorldServer theWorldServer;
   private static final Logger pmLogger = LogManager.getLogger();
   private final List<EntityPlayerMP> players = Lists.newArrayList();

   public void removePlayer(EntityPlayerMP var1) {
      this.mapPlayerPendingEntries.remove(var1);
      int var2 = (int)var1.managedPosX >> 4;
      int var3 = (int)var1.managedPosZ >> 4;

      for(int var4 = var2 - this.playerViewRadius; var4 <= var2 + this.playerViewRadius; ++var4) {
         for(int var5 = var3 - this.playerViewRadius; var5 <= var3 + this.playerViewRadius; ++var5) {
            PlayerManager.PlayerInstance var6 = this.getPlayerInstance(var4, var5, false);
            if (var6 != null) {
               var6.removePlayer(var1);
            }
         }
      }

      this.players.remove(var1);
   }

   static List access$3(PlayerManager var0) {
      return var0.playerInstanceList;
   }

   public static int getFurthestViewableBlock(int var0) {
      return var0 * 16 - 16;
   }

   public void filterChunkLoadQueue(EntityPlayerMP var1) {
      ArrayList var2 = Lists.newArrayList(var1.loadedChunks);
      int var3 = 0;
      int var4 = this.playerViewRadius;
      int var5 = (int)var1.posX >> 4;
      int var6 = (int)var1.posZ >> 4;
      int var7 = 0;
      int var8 = 0;
      ChunkCoordIntPair var9 = PlayerManager.PlayerInstance.access$0(this.getPlayerInstance(var5, var6, true));
      var1.loadedChunks.clear();
      if (var2.contains(var9)) {
         var1.loadedChunks.add(var9);
      }

      int var10;
      for(var10 = 1; var10 <= var4 * 2; ++var10) {
         for(int var11 = 0; var11 < 2; ++var11) {
            int[] var12 = this.xzDirectionsConst[var3++ % 4];

            for(int var13 = 0; var13 < var10; ++var13) {
               var7 += var12[0];
               var8 += var12[1];
               var9 = PlayerManager.PlayerInstance.access$0(this.getPlayerInstance(var5 + var7, var6 + var8, true));
               if (var2.contains(var9)) {
                  var1.loadedChunks.add(var9);
               }
            }
         }
      }

      var3 %= 4;

      for(var10 = 0; var10 < var4 * 2; ++var10) {
         var7 += this.xzDirectionsConst[var3][0];
         var8 += this.xzDirectionsConst[var3][1];
         var9 = PlayerManager.PlayerInstance.access$0(this.getPlayerInstance(var5 + var7, var6 + var8, true));
         if (var2.contains(var9)) {
            var1.loadedChunks.add(var9);
         }
      }

   }

   public boolean hasPlayerInstance(int var1, int var2) {
      long var3 = (long)var1 + 2147483647L | (long)var2 + 2147483647L << 32;
      return this.playerInstances.getValueByKey(var3) != null;
   }

   public WorldServer getWorldServer() {
      return this.theWorldServer;
   }

   private PriorityQueue<ChunkCoordIntPair> getNearest(Set<ChunkCoordIntPair> var1, EntityPlayerMP var2, int var3) {
      float var4;
      for(var4 = var2.rotationYaw + 90.0F; var4 <= -180.0F; var4 += 360.0F) {
      }

      while(var4 > 180.0F) {
         var4 -= 360.0F;
      }

      double var5 = (double)var4 * 0.017453292519943295D;
      double var7 = (double)var2.rotationPitch;
      double var9 = var7 * 0.017453292519943295D;
      ChunkPosComparator var11 = new ChunkPosComparator(var2.chunkCoordX, var2.chunkCoordZ, var5, var9);
      Comparator var12 = Collections.reverseOrder(var11);
      PriorityQueue var13 = new PriorityQueue(var3, var12);
      Iterator var15 = var1.iterator();

      while(var15.hasNext()) {
         ChunkCoordIntPair var14 = (ChunkCoordIntPair)var15.next();
         if (var13.size() < var3) {
            var13.add(var14);
         } else {
            ChunkCoordIntPair var16 = (ChunkCoordIntPair)var13.peek();
            if (var11.compare(var14, var16) < 0) {
               var13.remove();
               var13.add(var14);
            }
         }
      }

      return var13;
   }

   static WorldServer access$1(PlayerManager var0) {
      return var0.theWorldServer;
   }

   public PlayerManager(WorldServer var1) {
      this.theWorldServer = var1;
      this.setPlayerViewRadius(var1.getMinecraftServer().getConfigurationManager().getViewDistance());
   }

   public void setPlayerViewRadius(int var1) {
      var1 = MathHelper.clamp_int(var1, 3, 64);
      if (var1 != this.playerViewRadius) {
         int var2 = var1 - this.playerViewRadius;
         Iterator var4 = Lists.newArrayList(this.players).iterator();

         while(true) {
            while(var4.hasNext()) {
               EntityPlayerMP var3 = (EntityPlayerMP)var4.next();
               int var5 = (int)var3.posX >> 4;
               int var6 = (int)var3.posZ >> 4;
               Set var7 = this.getPendingEntriesSafe(var3);
               int var8;
               int var9;
               PlayerManager.PlayerInstance var10;
               if (var2 > 0) {
                  for(var8 = var5 - var1; var8 <= var5 + var1; ++var8) {
                     for(var9 = var6 - var1; var9 <= var6 + var1; ++var9) {
                        if (Config.isLazyChunkLoading()) {
                           var7.add(new ChunkCoordIntPair(var8, var9));
                        } else {
                           var10 = this.getPlayerInstance(var8, var9, true);
                           if (!PlayerManager.PlayerInstance.access$1(var10).contains(var3)) {
                              var10.addPlayer(var3);
                           }
                        }
                     }
                  }
               } else {
                  for(var8 = var5 - this.playerViewRadius; var8 <= var5 + this.playerViewRadius; ++var8) {
                     for(var9 = var6 - this.playerViewRadius; var9 <= var6 + this.playerViewRadius; ++var9) {
                        if (!this.overlaps(var8, var9, var5, var6, var1)) {
                           var7.remove(new ChunkCoordIntPair(var8, var9));
                           var10 = this.getPlayerInstance(var8, var9, true);
                           if (var10 != null) {
                              var10.removePlayer(var3);
                           }
                        }
                     }
                  }
               }
            }

            this.playerViewRadius = var1;
            break;
         }
      }

   }

   static LongHashMap access$2(PlayerManager var0) {
      return var0.playerInstances;
   }

   static List access$4(PlayerManager var0) {
      return var0.playerInstancesToUpdate;
   }

   public void updateMountedMovingPlayer(EntityPlayerMP var1) {
      int var2 = (int)var1.posX >> 4;
      int var3 = (int)var1.posZ >> 4;
      double var4 = var1.managedPosX - var1.posX;
      double var6 = var1.managedPosZ - var1.posZ;
      double var8 = var4 * var4 + var6 * var6;
      if (var8 >= 64.0D) {
         int var10 = (int)var1.managedPosX >> 4;
         int var11 = (int)var1.managedPosZ >> 4;
         int var12 = this.playerViewRadius;
         int var13 = var2 - var10;
         int var14 = var3 - var11;
         if (var13 != 0 || var14 != 0) {
            Set var15 = this.getPendingEntriesSafe(var1);

            for(int var16 = var2 - var12; var16 <= var2 + var12; ++var16) {
               for(int var17 = var3 - var12; var17 <= var3 + var12; ++var17) {
                  if (!this.overlaps(var16, var17, var10, var11, var12)) {
                     if (Config.isLazyChunkLoading()) {
                        var15.add(new ChunkCoordIntPair(var16, var17));
                     } else {
                        this.getPlayerInstance(var16, var17, true).addPlayer(var1);
                     }
                  }

                  if (!this.overlaps(var16 - var13, var17 - var14, var2, var3, var12)) {
                     var15.remove(new ChunkCoordIntPair(var16 - var13, var17 - var14));
                     PlayerManager.PlayerInstance var18 = this.getPlayerInstance(var16 - var13, var17 - var14, false);
                     if (var18 != null) {
                        var18.removePlayer(var1);
                     }
                  }
               }
            }

            this.filterChunkLoadQueue(var1);
            var1.managedPosX = var1.posX;
            var1.managedPosZ = var1.posZ;
         }
      }

   }

   static Logger access$0() {
      return pmLogger;
   }

   private PlayerManager.PlayerInstance getPlayerInstance(int var1, int var2, boolean var3) {
      long var4 = (long)var1 + 2147483647L | (long)var2 + 2147483647L << 32;
      PlayerManager.PlayerInstance var6 = (PlayerManager.PlayerInstance)this.playerInstances.getValueByKey(var4);
      if (var6 == null && var3) {
         var6 = new PlayerManager.PlayerInstance(this, var1, var2);
         this.playerInstances.add(var4, var6);
         this.playerInstanceList.add(var6);
      }

      return var6;
   }

   public void markBlockForUpdate(BlockPos var1) {
      int var2 = var1.getX() >> 4;
      int var3 = var1.getZ() >> 4;
      PlayerManager.PlayerInstance var4 = this.getPlayerInstance(var2, var3, false);
      if (var4 != null) {
         var4.flagChunkForUpdate(var1.getX() & 15, var1.getY(), var1.getZ() & 15);
      }

   }

   public void updatePlayerInstances() {
      Set var1 = this.mapPlayerPendingEntries.entrySet();
      Iterator var2 = var1.iterator();

      while(true) {
         while(true) {
            Entry var3;
            Set var4;
            do {
               if (!var2.hasNext()) {
                  long var10 = this.theWorldServer.getTotalWorldTime();
                  int var11;
                  PlayerManager.PlayerInstance var13;
                  if (var10 - this.previousTotalWorldTime > 8000L) {
                     this.previousTotalWorldTime = var10;

                     for(var11 = 0; var11 < this.playerInstanceList.size(); ++var11) {
                        var13 = (PlayerManager.PlayerInstance)this.playerInstanceList.get(var11);
                        var13.onUpdate();
                        var13.processChunk();
                     }
                  } else {
                     for(var11 = 0; var11 < this.playerInstancesToUpdate.size(); ++var11) {
                        var13 = (PlayerManager.PlayerInstance)this.playerInstancesToUpdate.get(var11);
                        var13.onUpdate();
                     }
                  }

                  this.playerInstancesToUpdate.clear();
                  if (this.players.isEmpty()) {
                     WorldProvider var12 = this.theWorldServer.provider;
                     if (!var12.canRespawnHere()) {
                        this.theWorldServer.theChunkProviderServer.unloadAllChunks();
                     }
                  }

                  return;
               }

               var3 = (Entry)var2.next();
               var4 = (Set)var3.getValue();
            } while(var4.isEmpty());

            EntityPlayerMP var5 = (EntityPlayerMP)var3.getKey();
            if (var5.worldObj != this.theWorldServer) {
               var2.remove();
            } else {
               int var6 = this.playerViewRadius / 3 + 1;
               if (!Config.isLazyChunkLoading()) {
                  var6 = this.playerViewRadius * 2 + 1;
               }

               Iterator var8 = this.getNearest(var4, var5, var6).iterator();

               while(var8.hasNext()) {
                  ChunkCoordIntPair var7 = (ChunkCoordIntPair)var8.next();
                  PlayerManager.PlayerInstance var9 = this.getPlayerInstance(var7.chunkXPos, var7.chunkZPos, true);
                  var9.addPlayer(var5);
                  var4.remove(var7);
               }
            }
         }
      }
   }

   private Set<ChunkCoordIntPair> getPendingEntriesSafe(EntityPlayerMP var1) {
      Set var2 = (Set)this.mapPlayerPendingEntries.get(var1);
      if (var2 != null) {
         return var2;
      } else {
         int var3 = Math.min(this.playerViewRadius, 8);
         int var4 = this.playerViewRadius * 2 + 1;
         int var5 = var3 * 2 + 1;
         int var6 = var4 * var4 - var5 * var5;
         var6 = Math.max(var6, 16);
         HashSet var7 = new HashSet(var6);
         this.mapPlayerPendingEntries.put(var1, var7);
         return var7;
      }
   }

   public boolean isPlayerWatchingChunk(EntityPlayerMP var1, int var2, int var3) {
      PlayerManager.PlayerInstance var4 = this.getPlayerInstance(var2, var3, false);
      return var4 != null && PlayerManager.PlayerInstance.access$1(var4).contains(var1) && !var1.loadedChunks.contains(PlayerManager.PlayerInstance.access$0(var4));
   }

   public void addPlayer(EntityPlayerMP var1) {
      int var2 = (int)var1.posX >> 4;
      int var3 = (int)var1.posZ >> 4;
      var1.managedPosX = var1.posX;
      var1.managedPosZ = var1.posZ;
      int var4 = Math.min(this.playerViewRadius, 8);
      int var5 = var2 - var4;
      int var6 = var2 + var4;
      int var7 = var3 - var4;
      int var8 = var3 + var4;
      Set var9 = this.getPendingEntriesSafe(var1);

      for(int var10 = var2 - this.playerViewRadius; var10 <= var2 + this.playerViewRadius; ++var10) {
         for(int var11 = var3 - this.playerViewRadius; var11 <= var3 + this.playerViewRadius; ++var11) {
            if (var10 >= var5 && var10 <= var6 && var11 >= var7 && var11 <= var8) {
               this.getPlayerInstance(var10, var11, true).addPlayer(var1);
            } else {
               var9.add(new ChunkCoordIntPair(var10, var11));
            }
         }
      }

      this.players.add(var1);
      this.filterChunkLoadQueue(var1);
   }

   private boolean overlaps(int var1, int var2, int var3, int var4, int var5) {
      int var6 = var1 - var3;
      int var7 = var2 - var4;
      return var6 >= -var5 && var6 <= var5 ? var7 >= -var5 && var7 <= var5 : false;
   }

   class PlayerInstance {
      private int numBlocksToUpdate;
      private short[] locationOfBlockChange;
      final PlayerManager this$0;
      private int flagsYAreasToUpdate;
      private final List<EntityPlayerMP> playersWatchingChunk;
      private long previousWorldTime;
      private final ChunkCoordIntPair chunkCoords;

      public void flagChunkForUpdate(int var1, int var2, int var3) {
         if (this.numBlocksToUpdate == 0) {
            PlayerManager.access$4(this.this$0).add(this);
         }

         this.flagsYAreasToUpdate |= 1 << (var2 >> 4);
         if (this.numBlocksToUpdate < 64) {
            short var4 = (short)(var1 << 12 | var3 << 8 | var2);

            for(int var5 = 0; var5 < this.numBlocksToUpdate; ++var5) {
               if (this.locationOfBlockChange[var5] == var4) {
                  return;
               }
            }

            this.locationOfBlockChange[this.numBlocksToUpdate++] = var4;
         }

      }

      public void sendToAllPlayersWatchingChunk(Packet var1) {
         for(int var2 = 0; var2 < this.playersWatchingChunk.size(); ++var2) {
            EntityPlayerMP var3 = (EntityPlayerMP)this.playersWatchingChunk.get(var2);
            if (!var3.loadedChunks.contains(this.chunkCoords)) {
               var3.playerNetServerHandler.sendPacket(var1);
            }
         }

      }

      public void removePlayer(EntityPlayerMP var1) {
         if (this.playersWatchingChunk.contains(var1)) {
            Chunk var2 = PlayerManager.access$1(this.this$0).getChunkFromChunkCoords(this.chunkCoords.chunkXPos, this.chunkCoords.chunkZPos);
            if (var2.isPopulated()) {
               var1.playerNetServerHandler.sendPacket(new S21PacketChunkData(var2, true, 0));
            }

            this.playersWatchingChunk.remove(var1);
            var1.loadedChunks.remove(this.chunkCoords);
            if (this.playersWatchingChunk.isEmpty()) {
               long var3 = (long)this.chunkCoords.chunkXPos + 2147483647L | (long)this.chunkCoords.chunkZPos + 2147483647L << 32;
               this.increaseInhabitedTime(var2);
               PlayerManager.access$2(this.this$0).remove(var3);
               PlayerManager.access$3(this.this$0).remove(this);
               if (this.numBlocksToUpdate > 0) {
                  PlayerManager.access$4(this.this$0).remove(this);
               }

               this.this$0.getWorldServer().theChunkProviderServer.dropChunk(this.chunkCoords.chunkXPos, this.chunkCoords.chunkZPos);
            }
         }

      }

      public void onUpdate() {
         if (this.numBlocksToUpdate != 0) {
            int var1;
            int var2;
            int var3;
            if (this.numBlocksToUpdate == 1) {
               var1 = (this.locationOfBlockChange[0] >> 12 & 15) + this.chunkCoords.chunkXPos * 16;
               var2 = this.locationOfBlockChange[0] & 255;
               var3 = (this.locationOfBlockChange[0] >> 8 & 15) + this.chunkCoords.chunkZPos * 16;
               BlockPos var7 = new BlockPos(var1, var2, var3);
               this.sendToAllPlayersWatchingChunk(new S23PacketBlockChange(PlayerManager.access$1(this.this$0), var7));
               if (PlayerManager.access$1(this.this$0).getBlockState(var7).getBlock().hasTileEntity()) {
                  this.sendTileToAllPlayersWatchingChunk(PlayerManager.access$1(this.this$0).getTileEntity(var7));
               }
            } else {
               int var4;
               if (this.numBlocksToUpdate != 64) {
                  this.sendToAllPlayersWatchingChunk(new S22PacketMultiBlockChange(this.numBlocksToUpdate, this.locationOfBlockChange, PlayerManager.access$1(this.this$0).getChunkFromChunkCoords(this.chunkCoords.chunkXPos, this.chunkCoords.chunkZPos)));

                  for(var1 = 0; var1 < this.numBlocksToUpdate; ++var1) {
                     var2 = (this.locationOfBlockChange[var1] >> 12 & 15) + this.chunkCoords.chunkXPos * 16;
                     var3 = this.locationOfBlockChange[var1] & 255;
                     var4 = (this.locationOfBlockChange[var1] >> 8 & 15) + this.chunkCoords.chunkZPos * 16;
                     BlockPos var8 = new BlockPos(var2, var3, var4);
                     if (PlayerManager.access$1(this.this$0).getBlockState(var8).getBlock().hasTileEntity()) {
                        this.sendTileToAllPlayersWatchingChunk(PlayerManager.access$1(this.this$0).getTileEntity(var8));
                     }
                  }
               } else {
                  var1 = this.chunkCoords.chunkXPos * 16;
                  var2 = this.chunkCoords.chunkZPos * 16;
                  this.sendToAllPlayersWatchingChunk(new S21PacketChunkData(PlayerManager.access$1(this.this$0).getChunkFromChunkCoords(this.chunkCoords.chunkXPos, this.chunkCoords.chunkZPos), false, this.flagsYAreasToUpdate));

                  for(var3 = 0; var3 < 16; ++var3) {
                     if ((this.flagsYAreasToUpdate & 1 << var3) != 0) {
                        var4 = var3 << 4;
                        List var5 = PlayerManager.access$1(this.this$0).getTileEntitiesIn(var1, var4, var2, var1 + 16, var4 + 16, var2 + 16);

                        for(int var6 = 0; var6 < var5.size(); ++var6) {
                           this.sendTileToAllPlayersWatchingChunk((TileEntity)var5.get(var6));
                        }
                     }
                  }
               }
            }

            this.numBlocksToUpdate = 0;
            this.flagsYAreasToUpdate = 0;
         }

      }

      static ChunkCoordIntPair access$0(PlayerManager.PlayerInstance var0) {
         return var0.chunkCoords;
      }

      public void addPlayer(EntityPlayerMP var1) {
         if (this.playersWatchingChunk.contains(var1)) {
            PlayerManager.access$0().debug("Failed to add player. {} already is in chunk {}, {}", new Object[]{var1, this.chunkCoords.chunkXPos, this.chunkCoords.chunkZPos});
         } else {
            if (this.playersWatchingChunk.isEmpty()) {
               this.previousWorldTime = PlayerManager.access$1(this.this$0).getTotalWorldTime();
            }

            this.playersWatchingChunk.add(var1);
            var1.loadedChunks.add(this.chunkCoords);
         }

      }

      public PlayerInstance(PlayerManager var1, int var2, int var3) {
         this.this$0 = var1;
         this.playersWatchingChunk = Lists.newArrayList();
         this.locationOfBlockChange = new short[64];
         this.chunkCoords = new ChunkCoordIntPair(var2, var3);
         var1.getWorldServer().theChunkProviderServer.loadChunk(var2, var3);
      }

      private void increaseInhabitedTime(Chunk var1) {
         var1.setInhabitedTime(var1.getInhabitedTime() + PlayerManager.access$1(this.this$0).getTotalWorldTime() - this.previousWorldTime);
         this.previousWorldTime = PlayerManager.access$1(this.this$0).getTotalWorldTime();
      }

      public void processChunk() {
         this.increaseInhabitedTime(PlayerManager.access$1(this.this$0).getChunkFromChunkCoords(this.chunkCoords.chunkXPos, this.chunkCoords.chunkZPos));
      }

      static List access$1(PlayerManager.PlayerInstance var0) {
         return var0.playersWatchingChunk;
      }

      private void sendTileToAllPlayersWatchingChunk(TileEntity var1) {
         if (var1 != null) {
            Packet var2 = var1.getDescriptionPacket();
            if (var2 != null) {
               this.sendToAllPlayersWatchingChunk(var2);
            }
         }

      }
   }
}
