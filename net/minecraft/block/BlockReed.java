package net.minecraft.block;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockReed extends Block {
   public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 15);

   protected final boolean checkForDrop(World var1, BlockPos var2, IBlockState var3) {
      if (this.canBlockStay(var1, var2)) {
         return true;
      } else {
         this.dropBlockAsItem(var1, var2, var3, 0);
         var1.setBlockToAir(var2);
         return false;
      }
   }

   public AxisAlignedBB getCollisionBoundingBox(World var1, BlockPos var2, IBlockState var3) {
      return null;
   }

   public void updateTick(World var1, BlockPos var2, IBlockState var3, Random var4) {
      if ((var1.getBlockState(var2.down()).getBlock() == Blocks.reeds || this.checkForDrop(var1, var2, var3)) && var1.isAirBlock(var2.up())) {
         int var5;
         for(var5 = 1; var1.getBlockState(var2.down(var5)).getBlock() == this; ++var5) {
         }

         if (var5 < 3) {
            int var6 = (Integer)var3.getValue(AGE);
            if (var6 == 15) {
               var1.setBlockState(var2.up(), this.getDefaultState());
               var1.setBlockState(var2, var3.withProperty(AGE, 0), 4);
            } else {
               var1.setBlockState(var2, var3.withProperty(AGE, var6 + 1), 4);
            }
         }
      }

   }

   public IBlockState getStateFromMeta(int var1) {
      return this.getDefaultState().withProperty(AGE, var1);
   }

   protected BlockReed() {
      super(Material.plants);
      this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, 0));
      float var1 = 0.375F;
      this.setBlockBounds(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 1.0F, 0.5F + var1);
      this.setTickRandomly(true);
   }

   public void onNeighborBlockChange(World var1, BlockPos var2, IBlockState var3, Block var4) {
      this.checkForDrop(var1, var2, var3);
   }

   protected BlockState createBlockState() {
      return new BlockState(this, new IProperty[]{AGE});
   }

   public boolean canPlaceBlockAt(World var1, BlockPos var2) {
      Block var3 = var1.getBlockState(var2.down()).getBlock();
      if (var3 == this) {
         return true;
      } else if (var3 != Blocks.grass && var3 != Blocks.dirt && var3 != Blocks.sand) {
         return false;
      } else {
         Iterator var5 = EnumFacing.Plane.HORIZONTAL.iterator();

         while(var5.hasNext()) {
            EnumFacing var4 = (EnumFacing)var5.next();
            if (var1.getBlockState(var2.offset(var4).down()).getBlock().getMaterial() == Material.water) {
               return true;
            }
         }

         return false;
      }
   }

   public Item getItem(World var1, BlockPos var2) {
      return Items.reeds;
   }

   public EnumWorldBlockLayer getBlockLayer() {
      return EnumWorldBlockLayer.CUTOUT;
   }

   public int getMetaFromState(IBlockState var1) {
      return (Integer)var1.getValue(AGE);
   }

   public Item getItemDropped(IBlockState var1, Random var2, int var3) {
      return Items.reeds;
   }

   public boolean canBlockStay(World var1, BlockPos var2) {
      return this.canPlaceBlockAt(var1, var2);
   }

   public int colorMultiplier(IBlockAccess var1, BlockPos var2, int var3) {
      return var1.getBiomeGenForCoords(var2).getGrassColorAtPos(var2);
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }
}
