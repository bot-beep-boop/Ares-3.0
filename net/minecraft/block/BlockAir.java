package net.minecraft.block;

import java.util.IdentityHashMap;
import java.util.Map;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockAir extends Block {
   private static Map mapOriginalOpacity = new IdentityHashMap();

   public int getRenderType() {
      return -1;
   }

   protected BlockAir() {
      super(Material.air);
   }

   public boolean isReplaceable(World var1, BlockPos var2) {
      return true;
   }

   public void dropBlockAsItemWithChance(World var1, BlockPos var2, IBlockState var3, float var4, int var5) {
   }

   public static void restoreLightOpacity(Block var0) {
      if (mapOriginalOpacity.containsKey(var0)) {
         int var1 = (Integer)mapOriginalOpacity.get(var0);
         setLightOpacity(var0, var1);
      }

   }

   public static void setLightOpacity(Block var0, int var1) {
      if (!mapOriginalOpacity.containsKey(var0)) {
         mapOriginalOpacity.put(var0, var0.lightOpacity);
      }

      var0.lightOpacity = var1;
   }

   public AxisAlignedBB getCollisionBoundingBox(World var1, BlockPos var2, IBlockState var3) {
      return null;
   }

   public boolean canCollideCheck(IBlockState var1, boolean var2) {
      return false;
   }

   public boolean isOpaqueCube() {
      return false;
   }
}
