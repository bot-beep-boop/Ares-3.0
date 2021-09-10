package net.minecraft.block;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRedstoneWire extends Block {
   public static final PropertyEnum<BlockRedstoneWire.EnumAttachPosition> SOUTH = PropertyEnum.create("south", BlockRedstoneWire.EnumAttachPosition.class);
   public static final PropertyInteger POWER = PropertyInteger.create("power", 0, 15);
   public static final PropertyEnum<BlockRedstoneWire.EnumAttachPosition> WEST = PropertyEnum.create("west", BlockRedstoneWire.EnumAttachPosition.class);
   private boolean canProvidePower = true;
   public static final PropertyEnum<BlockRedstoneWire.EnumAttachPosition> EAST = PropertyEnum.create("east", BlockRedstoneWire.EnumAttachPosition.class);
   public static final PropertyEnum<BlockRedstoneWire.EnumAttachPosition> NORTH = PropertyEnum.create("north", BlockRedstoneWire.EnumAttachPosition.class);
   private final Set<BlockPos> blocksNeedingUpdate = Sets.newHashSet();

   public int getWeakPower(IBlockAccess var1, BlockPos var2, IBlockState var3, EnumFacing var4) {
      if (!this.canProvidePower) {
         return 0;
      } else {
         int var5 = (Integer)var3.getValue(POWER);
         if (var5 == 0) {
            return 0;
         } else if (var4 == EnumFacing.UP) {
            return var5;
         } else {
            EnumSet var6 = EnumSet.noneOf(EnumFacing.class);
            Iterator var8 = EnumFacing.Plane.HORIZONTAL.iterator();

            while(var8.hasNext()) {
               EnumFacing var7 = (EnumFacing)var8.next();
               if (this.func_176339_d(var1, var2, var7)) {
                  var6.add(var7);
               }
            }

            if (var4.getAxis().isHorizontal() && var6.isEmpty()) {
               return var5;
            } else {
               return var6.contains(var4) && !var6.contains(var4.rotateYCCW()) && !var6.contains(var4.rotateY()) ? var5 : 0;
            }
         }
      }
   }

   public Item getItem(World var1, BlockPos var2) {
      return Items.redstone;
   }

   public IBlockState getStateFromMeta(int var1) {
      return this.getDefaultState().withProperty(POWER, var1);
   }

   public void onNeighborBlockChange(World var1, BlockPos var2, IBlockState var3, Block var4) {
      if (!var1.isRemote) {
         if (this.canPlaceBlockAt(var1, var2)) {
            this.updateSurroundingRedstone(var1, var2, var3);
         } else {
            this.dropBlockAsItem(var1, var2, var3, 0);
            var1.setBlockToAir(var2);
         }
      }

   }

   public int getStrongPower(IBlockAccess var1, BlockPos var2, IBlockState var3, EnumFacing var4) {
      return !this.canProvidePower ? 0 : this.getWeakPower(var1, var2, var3, var4);
   }

   private IBlockState updateSurroundingRedstone(World var1, BlockPos var2, IBlockState var3) {
      var3 = this.calculateCurrentChanges(var1, var2, var2, var3);
      ArrayList var4 = Lists.newArrayList(this.blocksNeedingUpdate);
      this.blocksNeedingUpdate.clear();
      Iterator var6 = var4.iterator();

      while(var6.hasNext()) {
         BlockPos var5 = (BlockPos)var6.next();
         var1.notifyNeighborsOfStateChange(var5, this);
      }

      return var3;
   }

   public boolean canPlaceBlockAt(World var1, BlockPos var2) {
      return World.doesBlockHaveSolidTopSurface(var1, var2.down()) || var1.getBlockState(var2.down()).getBlock() == Blocks.glowstone;
   }

   private int getMaxCurrentStrength(World var1, BlockPos var2, int var3) {
      if (var1.getBlockState(var2).getBlock() != this) {
         return var3;
      } else {
         int var4 = (Integer)var1.getBlockState(var2).getValue(POWER);
         return var4 > var3 ? var4 : var3;
      }
   }

   public Item getItemDropped(IBlockState var1, Random var2, int var3) {
      return Items.redstone;
   }

   public void onBlockAdded(World var1, BlockPos var2, IBlockState var3) {
      if (!var1.isRemote) {
         this.updateSurroundingRedstone(var1, var2, var3);
         Iterator var5 = EnumFacing.Plane.VERTICAL.iterator();

         EnumFacing var4;
         while(var5.hasNext()) {
            var4 = (EnumFacing)var5.next();
            var1.notifyNeighborsOfStateChange(var2.offset(var4), this);
         }

         var5 = EnumFacing.Plane.HORIZONTAL.iterator();

         while(var5.hasNext()) {
            var4 = (EnumFacing)var5.next();
            this.notifyWireNeighborsOfStateChange(var1, var2.offset(var4));
         }

         var5 = EnumFacing.Plane.HORIZONTAL.iterator();

         while(var5.hasNext()) {
            var4 = (EnumFacing)var5.next();
            BlockPos var6 = var2.offset(var4);
            if (var1.getBlockState(var6).getBlock().isNormalCube()) {
               this.notifyWireNeighborsOfStateChange(var1, var6.up());
            } else {
               this.notifyWireNeighborsOfStateChange(var1, var6.down());
            }
         }
      }

   }

   public EnumWorldBlockLayer getBlockLayer() {
      return EnumWorldBlockLayer.CUTOUT;
   }

   protected static boolean canConnectUpwardsTo(IBlockAccess var0, BlockPos var1) {
      return canConnectUpwardsTo(var0.getBlockState(var1));
   }

   public boolean canProvidePower() {
      return this.canProvidePower;
   }

   public void breakBlock(World var1, BlockPos var2, IBlockState var3) {
      super.breakBlock(var1, var2, var3);
      if (!var1.isRemote) {
         EnumFacing[] var7;
         int var6 = (var7 = EnumFacing.values()).length;

         EnumFacing var4;
         for(int var5 = 0; var5 < var6; ++var5) {
            var4 = var7[var5];
            var1.notifyNeighborsOfStateChange(var2.offset(var4), this);
         }

         this.updateSurroundingRedstone(var1, var2, var3);
         Iterator var8 = EnumFacing.Plane.HORIZONTAL.iterator();

         while(var8.hasNext()) {
            var4 = (EnumFacing)var8.next();
            this.notifyWireNeighborsOfStateChange(var1, var2.offset(var4));
         }

         var8 = EnumFacing.Plane.HORIZONTAL.iterator();

         while(var8.hasNext()) {
            var4 = (EnumFacing)var8.next();
            BlockPos var9 = var2.offset(var4);
            if (var1.getBlockState(var9).getBlock().isNormalCube()) {
               this.notifyWireNeighborsOfStateChange(var1, var9.up());
            } else {
               this.notifyWireNeighborsOfStateChange(var1, var9.down());
            }
         }
      }

   }

   public BlockRedstoneWire() {
      super(Material.circuits);
      this.setDefaultState(this.blockState.getBaseState().withProperty(NORTH, BlockRedstoneWire.EnumAttachPosition.NONE).withProperty(EAST, BlockRedstoneWire.EnumAttachPosition.NONE).withProperty(SOUTH, BlockRedstoneWire.EnumAttachPosition.NONE).withProperty(WEST, BlockRedstoneWire.EnumAttachPosition.NONE).withProperty(POWER, 0));
      this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
   }

   private BlockRedstoneWire.EnumAttachPosition getAttachPosition(IBlockAccess var1, BlockPos var2, EnumFacing var3) {
      BlockPos var4 = var2.offset(var3);
      Block var5 = var1.getBlockState(var2.offset(var3)).getBlock();
      if (canConnectTo(var1.getBlockState(var4), var3) || !var5.isBlockNormalCube() && canConnectUpwardsTo(var1.getBlockState(var4.down()))) {
         return BlockRedstoneWire.EnumAttachPosition.SIDE;
      } else {
         Block var6 = var1.getBlockState(var2.up()).getBlock();
         return !var6.isBlockNormalCube() && var5.isBlockNormalCube() && canConnectUpwardsTo(var1.getBlockState(var4.up())) ? BlockRedstoneWire.EnumAttachPosition.UP : BlockRedstoneWire.EnumAttachPosition.NONE;
      }
   }

   private boolean func_176339_d(IBlockAccess var1, BlockPos var2, EnumFacing var3) {
      BlockPos var4 = var2.offset(var3);
      IBlockState var5 = var1.getBlockState(var4);
      Block var6 = var5.getBlock();
      boolean var7 = var6.isNormalCube();
      boolean var8 = var1.getBlockState(var2.up()).getBlock().isNormalCube();
      if (!var8 && var7 && canConnectUpwardsTo(var1, var4.up())) {
         return true;
      } else if (canConnectTo(var5, var3)) {
         return true;
      } else if (var6 == Blocks.powered_repeater && var5.getValue(BlockRedstoneDiode.FACING) == var3) {
         return true;
      } else {
         return !var7 && canConnectUpwardsTo(var1, var4.down());
      }
   }

   protected BlockState createBlockState() {
      return new BlockState(this, new IProperty[]{NORTH, EAST, SOUTH, WEST, POWER});
   }

   public boolean isFullCube() {
      return false;
   }

   private int colorMultiplier(int var1) {
      float var2 = (float)var1 / 15.0F;
      float var3 = var2 * 0.6F + 0.4F;
      if (var1 == 0) {
         var3 = 0.3F;
      }

      float var4 = var2 * var2 * 0.7F - 0.5F;
      float var5 = var2 * var2 * 0.6F - 0.7F;
      if (var4 < 0.0F) {
         var4 = 0.0F;
      }

      if (var5 < 0.0F) {
         var5 = 0.0F;
      }

      int var6 = MathHelper.clamp_int((int)(var3 * 255.0F), 0, 255);
      int var7 = MathHelper.clamp_int((int)(var4 * 255.0F), 0, 255);
      int var8 = MathHelper.clamp_int((int)(var5 * 255.0F), 0, 255);
      return -16777216 | var6 << 16 | var7 << 8 | var8;
   }

   public AxisAlignedBB getCollisionBoundingBox(World var1, BlockPos var2, IBlockState var3) {
      return null;
   }

   private IBlockState calculateCurrentChanges(World var1, BlockPos var2, BlockPos var3, IBlockState var4) {
      IBlockState var5 = var4;
      int var6 = (Integer)var4.getValue(POWER);
      byte var7 = 0;
      int var14 = this.getMaxCurrentStrength(var1, var3, var7);
      this.canProvidePower = false;
      int var8 = var1.isBlockIndirectlyGettingPowered(var2);
      this.canProvidePower = true;
      if (var8 > 0 && var8 > var14 - 1) {
         var14 = var8;
      }

      int var9 = 0;
      Iterator var11 = EnumFacing.Plane.HORIZONTAL.iterator();

      while(true) {
         EnumFacing var10;
         while(var11.hasNext()) {
            var10 = (EnumFacing)var11.next();
            BlockPos var12 = var2.offset(var10);
            boolean var13 = var12.getX() != var3.getX() || var12.getZ() != var3.getZ();
            if (var13) {
               var9 = this.getMaxCurrentStrength(var1, var12, var9);
            }

            if (var1.getBlockState(var12).getBlock().isNormalCube() && !var1.getBlockState(var2.up()).getBlock().isNormalCube()) {
               if (var13 && var2.getY() >= var3.getY()) {
                  var9 = this.getMaxCurrentStrength(var1, var12.up(), var9);
               }
            } else if (!var1.getBlockState(var12).getBlock().isNormalCube() && var13 && var2.getY() <= var3.getY()) {
               var9 = this.getMaxCurrentStrength(var1, var12.down(), var9);
            }
         }

         if (var9 > var14) {
            var14 = var9 - 1;
         } else if (var14 > 0) {
            --var14;
         } else {
            var14 = 0;
         }

         if (var8 > var14 - 1) {
            var14 = var8;
         }

         if (var6 != var14) {
            var4 = var4.withProperty(POWER, var14);
            if (var1.getBlockState(var2) == var5) {
               var1.setBlockState(var2, var4, 2);
            }

            this.blocksNeedingUpdate.add(var2);
            EnumFacing[] var17;
            int var16 = (var17 = EnumFacing.values()).length;

            for(int var15 = 0; var15 < var16; ++var15) {
               var10 = var17[var15];
               this.blocksNeedingUpdate.add(var2.offset(var10));
            }
         }

         return var4;
      }
   }

   public int getMetaFromState(IBlockState var1) {
      return (Integer)var1.getValue(POWER);
   }

   public boolean isOpaqueCube() {
      return false;
   }

   protected static boolean canConnectUpwardsTo(IBlockState var0) {
      return canConnectTo(var0, (EnumFacing)null);
   }

   public IBlockState getActualState(IBlockState var1, IBlockAccess var2, BlockPos var3) {
      var1 = var1.withProperty(WEST, this.getAttachPosition(var2, var3, EnumFacing.WEST));
      var1 = var1.withProperty(EAST, this.getAttachPosition(var2, var3, EnumFacing.EAST));
      var1 = var1.withProperty(NORTH, this.getAttachPosition(var2, var3, EnumFacing.NORTH));
      var1 = var1.withProperty(SOUTH, this.getAttachPosition(var2, var3, EnumFacing.SOUTH));
      return var1;
   }

   public void randomDisplayTick(World var1, BlockPos var2, IBlockState var3, Random var4) {
      int var5 = (Integer)var3.getValue(POWER);
      if (var5 != 0) {
         double var6 = (double)var2.getX() + 0.5D + ((double)var4.nextFloat() - 0.5D) * 0.2D;
         double var8 = (double)((float)var2.getY() + 0.0625F);
         double var10 = (double)var2.getZ() + 0.5D + ((double)var4.nextFloat() - 0.5D) * 0.2D;
         float var12 = (float)var5 / 15.0F;
         float var13 = var12 * 0.6F + 0.4F;
         float var14 = Math.max(0.0F, var12 * var12 * 0.7F - 0.5F);
         float var15 = Math.max(0.0F, var12 * var12 * 0.6F - 0.7F);
         var1.spawnParticle(EnumParticleTypes.REDSTONE, var6, var8, var10, (double)var13, (double)var14, (double)var15);
      }

   }

   protected static boolean canConnectTo(IBlockState var0, EnumFacing var1) {
      Block var2 = var0.getBlock();
      if (var2 == Blocks.redstone_wire) {
         return true;
      } else if (Blocks.unpowered_repeater.isAssociated(var2)) {
         EnumFacing var3 = (EnumFacing)var0.getValue(BlockRedstoneRepeater.FACING);
         return var3 == var1 || var3.getOpposite() == var1;
      } else {
         return var2.canProvidePower() && var1 != null;
      }
   }

   private void notifyWireNeighborsOfStateChange(World var1, BlockPos var2) {
      if (var1.getBlockState(var2).getBlock() == this) {
         var1.notifyNeighborsOfStateChange(var2, this);
         EnumFacing[] var6;
         int var5 = (var6 = EnumFacing.values()).length;

         for(int var4 = 0; var4 < var5; ++var4) {
            EnumFacing var3 = var6[var4];
            var1.notifyNeighborsOfStateChange(var2.offset(var3), this);
         }
      }

   }

   public int colorMultiplier(IBlockAccess var1, BlockPos var2, int var3) {
      IBlockState var4 = var1.getBlockState(var2);
      return var4.getBlock() != this ? super.colorMultiplier(var1, var2, var3) : this.colorMultiplier((Integer)var4.getValue(POWER));
   }

   static enum EnumAttachPosition implements IStringSerializable {
      private static final BlockRedstoneWire.EnumAttachPosition[] ENUM$VALUES = new BlockRedstoneWire.EnumAttachPosition[]{UP, SIDE, NONE};
      SIDE("side");

      private final String name;
      NONE("none"),
      UP("up");

      private EnumAttachPosition(String var3) {
         this.name = var3;
      }

      public String toString() {
         return this.getName();
      }

      public String getName() {
         return this.name;
      }
   }
}
