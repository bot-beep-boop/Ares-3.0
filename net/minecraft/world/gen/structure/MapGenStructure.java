package net.minecraft.world.gen.structure;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ReportedException;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.MapGenBase;

public abstract class MapGenStructure extends MapGenBase {
   protected Map<Long, StructureStart> structureMap = Maps.newHashMap();
   private MapGenStructureData structureData;

   protected List<BlockPos> getCoordList() {
      return null;
   }

   protected final void recursiveGenerate(World var1, int var2, int var3, int var4, int var5, ChunkPrimer var6) {
      this.initializeStructureData(var1);
      if (!this.structureMap.containsKey(ChunkCoordIntPair.chunkXZ2Int(var2, var3))) {
         this.rand.nextInt();

         try {
            if (this.canSpawnStructureAtCoords(var2, var3)) {
               StructureStart var7 = this.getStructureStart(var2, var3);
               this.structureMap.put(ChunkCoordIntPair.chunkXZ2Int(var2, var3), var7);
               this.setStructureStart(var2, var3, var7);
            }
         } catch (Throwable var10) {
            CrashReport var8 = CrashReport.makeCrashReport(var10, "Exception preparing structure feature");
            CrashReportCategory var9 = var8.makeCategory("Feature being prepared");
            var9.addCrashSectionCallable("Is feature chunk", new Callable<String>(this, var2, var3) {
               private final int val$chunkZ;
               private final int val$chunkX;
               final MapGenStructure this$0;

               {
                  this.this$0 = var1;
                  this.val$chunkX = var2;
                  this.val$chunkZ = var3;
               }

               public String call() throws Exception {
                  return this.this$0.canSpawnStructureAtCoords(this.val$chunkX, this.val$chunkZ) ? "True" : "False";
               }

               public Object call() throws Exception {
                  return this.call();
               }
            });
            var9.addCrashSection("Chunk location", String.format("%d,%d", var2, var3));
            var9.addCrashSectionCallable("Chunk pos hash", new Callable<String>(this, var2, var3) {
               final MapGenStructure this$0;
               private final int val$chunkZ;
               private final int val$chunkX;

               public String call() throws Exception {
                  return String.valueOf(ChunkCoordIntPair.chunkXZ2Int(this.val$chunkX, this.val$chunkZ));
               }

               {
                  this.this$0 = var1;
                  this.val$chunkX = var2;
                  this.val$chunkZ = var3;
               }

               public Object call() throws Exception {
                  return this.call();
               }
            });
            var9.addCrashSectionCallable("Structure type", new Callable<String>(this) {
               final MapGenStructure this$0;

               public Object call() throws Exception {
                  return this.call();
               }

               {
                  this.this$0 = var1;
               }

               public String call() throws Exception {
                  return this.this$0.getClass().getCanonicalName();
               }
            });
            throw new ReportedException(var8);
         }
      }

   }

   public boolean generateStructure(World var1, Random var2, ChunkCoordIntPair var3) {
      this.initializeStructureData(var1);
      int var4 = (var3.chunkXPos << 4) + 8;
      int var5 = (var3.chunkZPos << 4) + 8;
      boolean var6 = false;
      Iterator var8 = this.structureMap.values().iterator();

      while(var8.hasNext()) {
         StructureStart var7 = (StructureStart)var8.next();
         if (var7.isSizeableStructure() && var7.func_175788_a(var3) && var7.getBoundingBox().intersectsWith(var4, var5, var4 + 15, var5 + 15)) {
            var7.generateStructure(var1, var2, new StructureBoundingBox(var4, var5, var4 + 15, var5 + 15));
            var7.func_175787_b(var3);
            var6 = true;
            this.setStructureStart(var7.getChunkPosX(), var7.getChunkPosZ(), var7);
         }
      }

      return var6;
   }

   public BlockPos getClosestStrongholdPos(World var1, BlockPos var2) {
      this.worldObj = var1;
      this.initializeStructureData(var1);
      this.rand.setSeed(var1.getSeed());
      long var3 = this.rand.nextLong();
      long var5 = this.rand.nextLong();
      long var7 = (long)(var2.getX() >> 4) * var3;
      long var9 = (long)(var2.getZ() >> 4) * var5;
      this.rand.setSeed(var7 ^ var9 ^ var1.getSeed());
      this.recursiveGenerate(var1, var2.getX() >> 4, var2.getZ() >> 4, 0, 0, (ChunkPrimer)null);
      double var11 = Double.MAX_VALUE;
      BlockPos var13 = null;
      Iterator var15 = this.structureMap.values().iterator();

      double var18;
      while(var15.hasNext()) {
         StructureStart var14 = (StructureStart)var15.next();
         if (var14.isSizeableStructure()) {
            StructureComponent var16 = (StructureComponent)var14.getComponents().get(0);
            BlockPos var17 = var16.getBoundingBoxCenter();
            var18 = var17.distanceSq(var2);
            if (var18 < var11) {
               var11 = var18;
               var13 = var17;
            }
         }
      }

      if (var13 != null) {
         return var13;
      } else {
         List var20 = this.getCoordList();
         if (var20 != null) {
            BlockPos var21 = null;
            Iterator var23 = var20.iterator();

            while(var23.hasNext()) {
               BlockPos var22 = (BlockPos)var23.next();
               var18 = var22.distanceSq(var2);
               if (var18 < var11) {
                  var11 = var18;
                  var21 = var22;
               }
            }

            return var21;
         } else {
            return null;
         }
      }
   }

   protected abstract boolean canSpawnStructureAtCoords(int var1, int var2);

   protected abstract StructureStart getStructureStart(int var1, int var2);

   private void setStructureStart(int var1, int var2, StructureStart var3) {
      this.structureData.writeInstance(var3.writeStructureComponentsToNBT(var1, var2), var1, var2);
      this.structureData.markDirty();
   }

   private void initializeStructureData(World var1) {
      if (this.structureData == null) {
         this.structureData = (MapGenStructureData)var1.loadItemData(MapGenStructureData.class, this.getStructureName());
         if (this.structureData == null) {
            this.structureData = new MapGenStructureData(this.getStructureName());
            var1.setItemData(this.getStructureName(), this.structureData);
         } else {
            NBTTagCompound var2 = this.structureData.getTagCompound();
            Iterator var4 = var2.getKeySet().iterator();

            while(var4.hasNext()) {
               String var3 = (String)var4.next();
               NBTBase var5 = var2.getTag(var3);
               if (var5.getId() == 10) {
                  NBTTagCompound var6 = (NBTTagCompound)var5;
                  if (var6.hasKey("ChunkX") && var6.hasKey("ChunkZ")) {
                     int var7 = var6.getInteger("ChunkX");
                     int var8 = var6.getInteger("ChunkZ");
                     StructureStart var9 = MapGenStructureIO.getStructureStart(var6, var1);
                     if (var9 != null) {
                        this.structureMap.put(ChunkCoordIntPair.chunkXZ2Int(var7, var8), var9);
                     }
                  }
               }
            }
         }
      }

   }

   public boolean func_175795_b(BlockPos var1) {
      this.initializeStructureData(this.worldObj);
      return this.func_175797_c(var1) != null;
   }

   public abstract String getStructureName();

   protected StructureStart func_175797_c(BlockPos var1) {
      Iterator var3 = this.structureMap.values().iterator();

      while(true) {
         StructureStart var2;
         do {
            do {
               if (!var3.hasNext()) {
                  return null;
               }

               var2 = (StructureStart)var3.next();
            } while(!var2.isSizeableStructure());
         } while(!var2.getBoundingBox().isVecInside(var1));

         Iterator var4 = var2.getComponents().iterator();

         while(var4.hasNext()) {
            StructureComponent var5 = (StructureComponent)var4.next();
            if (var5.getBoundingBox().isVecInside(var1)) {
               return var2;
            }
         }
      }
   }

   public boolean isPositionInStructure(World var1, BlockPos var2) {
      this.initializeStructureData(var1);
      Iterator var4 = this.structureMap.values().iterator();

      StructureStart var3;
      do {
         if (!var4.hasNext()) {
            return false;
         }

         var3 = (StructureStart)var4.next();
      } while(!var3.isSizeableStructure() || !var3.getBoundingBox().isVecInside(var2));

      return true;
   }
}
