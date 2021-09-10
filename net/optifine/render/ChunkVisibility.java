package net.optifine.render;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ClassInheritanceMultiMap;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;

public class ChunkVisibility {
   private static int iMaxStatic = -1;
   private static int iMaxStaticFinal = 16;
   private static int counter = 0;
   private static int pcxLast = Integer.MIN_VALUE;
   public static final int MASK_FACINGS = 63;
   public static final EnumFacing[][] enumFacingArrays = makeEnumFacingArrays(false);
   private static World worldLast = null;
   private static int pczLast = Integer.MIN_VALUE;
   public static final EnumFacing[][] enumFacingOppositeArrays = makeEnumFacingArrays(true);

   public static boolean isFinished() {
      return counter == 0;
   }

   private static EnumFacing[][] makeEnumFacingArrays(boolean var0) {
      byte var1 = 64;
      EnumFacing[][] var2 = new EnumFacing[var1][];

      for(int var3 = 0; var3 < var1; ++var3) {
         ArrayList var4 = new ArrayList();

         for(int var5 = 0; var5 < EnumFacing.VALUES.length; ++var5) {
            EnumFacing var6 = EnumFacing.VALUES[var5];
            EnumFacing var7 = var0 ? var6.getOpposite() : var6;
            int var8 = 1 << var7.ordinal();
            if ((var3 & var8) != 0) {
               var4.add(var6);
            }
         }

         EnumFacing[] var9 = (EnumFacing[])var4.toArray(new EnumFacing[var4.size()]);
         var2[var3] = var9;
      }

      return var2;
   }

   public static void reset() {
      worldLast = null;
   }

   public static int getMaxChunkY(World var0, Entity var1, int var2) {
      int var3 = MathHelper.floor_double(var1.posX) >> 4;
      int var4 = MathHelper.floor_double(var1.posY) >> 4;
      int var5 = MathHelper.floor_double(var1.posZ) >> 4;
      Chunk var6 = var0.getChunkFromChunkCoords(var3, var5);
      int var7 = var3 - var2;
      int var8 = var3 + var2;
      int var9 = var5 - var2;
      int var10 = var5 + var2;
      if (var0 != worldLast || var3 != pcxLast || var5 != pczLast) {
         counter = 0;
         iMaxStaticFinal = 16;
         worldLast = var0;
         pcxLast = var3;
         pczLast = var5;
      }

      if (counter == 0) {
         iMaxStatic = -1;
      }

      int var11 = iMaxStatic;
      switch(counter) {
      case 0:
         var8 = var3;
         var10 = var5;
         break;
      case 1:
         var7 = var3;
         var10 = var5;
         break;
      case 2:
         var8 = var3;
         var9 = var5;
         break;
      case 3:
         var7 = var3;
         var9 = var5;
      }

      for(int var12 = var7; var12 < var8; ++var12) {
         for(int var13 = var9; var13 < var10; ++var13) {
            Chunk var14 = var0.getChunkFromChunkCoords(var12, var13);
            if (!var14.isEmpty()) {
               ExtendedBlockStorage[] var15 = var14.getBlockStorageArray();

               for(int var16 = var15.length - 1; var16 > var11; --var16) {
                  ExtendedBlockStorage var17 = var15[var16];
                  if (var17 != null && !var17.isEmpty()) {
                     if (var16 > var11) {
                        var11 = var16;
                     }
                     break;
                  }
               }

               try {
                  Map var21 = var14.getTileEntityMap();
                  if (!var21.isEmpty()) {
                     Iterator var18 = var21.keySet().iterator();

                     while(var18.hasNext()) {
                        BlockPos var23 = (BlockPos)var18.next();
                        int var19 = var23.getY() >> 4;
                        if (var19 > var11) {
                           var11 = var19;
                        }
                     }
                  }
               } catch (ConcurrentModificationException var20) {
               }

               ClassInheritanceMultiMap[] var22 = var14.getEntityLists();

               for(int var24 = var22.length - 1; var24 > var11; --var24) {
                  ClassInheritanceMultiMap var25 = var22[var24];
                  if (!var25.isEmpty() && (var14 != var6 || var24 != var4 || var25.size() != 1)) {
                     if (var24 > var11) {
                        var11 = var24;
                     }
                     break;
                  }
               }
            }
         }
      }

      if (counter < 3) {
         iMaxStatic = var11;
         var11 = iMaxStaticFinal;
      } else {
         iMaxStaticFinal = var11;
         iMaxStatic = -1;
      }

      counter = (counter + 1) % 4;
      return var11 << 4;
   }

   public static EnumFacing[] getFacingsNotOpposite(int var0) {
      int var1 = ~var0 & 63;
      return enumFacingOppositeArrays[var1];
   }
}
