package net.minecraft.block;

import com.google.common.base.Predicate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockStairs extends Block {
   private static final int[][] field_150150_a;
   private final IBlockState modelState;
   public static final PropertyDirection FACING;
   private final Block modelBlock;
   private int rayTracePass;
   public static final PropertyEnum<BlockStairs.EnumShape> SHAPE;
   private boolean hasRaytraced;
   public static final PropertyEnum<BlockStairs.EnumHalf> HALF;

   public boolean onBlockActivated(World var1, BlockPos var2, IBlockState var3, EntityPlayer var4, EnumFacing var5, float var6, float var7, float var8) {
      return this.modelBlock.onBlockActivated(var1, var2, this.modelState, var4, EnumFacing.DOWN, 0.0F, 0.0F, 0.0F);
   }

   public boolean isCollidable() {
      return this.modelBlock.isCollidable();
   }

   public void onBlockDestroyedByExplosion(World var1, BlockPos var2, Explosion var3) {
      this.modelBlock.onBlockDestroyedByExplosion(var1, var2, var3);
   }

   public Vec3 modifyAcceleration(World var1, BlockPos var2, Entity var3, Vec3 var4) {
      return this.modelBlock.modifyAcceleration(var1, var2, var3, var4);
   }

   public static boolean isBlockStairs(Block var0) {
      return var0 instanceof BlockStairs;
   }

   public MovingObjectPosition collisionRayTrace(World var1, BlockPos var2, Vec3 var3, Vec3 var4) {
      MovingObjectPosition[] var5 = new MovingObjectPosition[8];
      IBlockState var6 = var1.getBlockState(var2);
      int var7 = ((EnumFacing)var6.getValue(FACING)).getHorizontalIndex();
      boolean var8 = var6.getValue(HALF) == BlockStairs.EnumHalf.TOP;
      int[] var9 = field_150150_a[var7 + (var8 ? 4 : 0)];
      this.hasRaytraced = true;

      int var10;
      for(var10 = 0; var10 < 8; ++var10) {
         this.rayTracePass = var10;
         if (Arrays.binarySearch(var9, var10) < 0) {
            var5[var10] = super.collisionRayTrace(var1, var2, var3, var4);
         }
      }

      int[] var13 = var9;
      int var12 = var9.length;

      for(int var11 = 0; var11 < var12; ++var11) {
         var10 = var13[var11];
         var5[var10] = null;
      }

      MovingObjectPosition var19 = null;
      double var20 = 0.0D;
      MovingObjectPosition[] var16 = var5;
      int var15 = var5.length;

      for(int var14 = 0; var14 < var15; ++var14) {
         MovingObjectPosition var21 = var16[var14];
         if (var21 != null) {
            double var17 = var21.hitVec.squareDistanceTo(var4);
            if (var17 > var20) {
               var19 = var21;
               var20 = var17;
            }
         }
      }

      return var19;
   }

   public AxisAlignedBB getSelectedBoundingBox(World var1, BlockPos var2) {
      return this.modelBlock.getSelectedBoundingBox(var1, var2);
   }

   public static boolean isSameStair(IBlockAccess var0, BlockPos var1, IBlockState var2) {
      IBlockState var3 = var0.getBlockState(var1);
      Block var4 = var3.getBlock();
      return isBlockStairs(var4) && var3.getValue(HALF) == var2.getValue(HALF) && var3.getValue(FACING) == var2.getValue(FACING);
   }

   public void breakBlock(World var1, BlockPos var2, IBlockState var3) {
      this.modelBlock.breakBlock(var1, var2, this.modelState);
   }

   public boolean func_176304_i(IBlockAccess var1, BlockPos var2) {
      IBlockState var3 = var1.getBlockState(var2);
      EnumFacing var4 = (EnumFacing)var3.getValue(FACING);
      BlockStairs.EnumHalf var5 = (BlockStairs.EnumHalf)var3.getValue(HALF);
      boolean var6 = var5 == BlockStairs.EnumHalf.TOP;
      float var7 = 0.5F;
      float var8 = 1.0F;
      if (var6) {
         var7 = 0.0F;
         var8 = 0.5F;
      }

      float var9 = 0.0F;
      float var10 = 0.5F;
      float var11 = 0.5F;
      float var12 = 1.0F;
      boolean var13 = false;
      IBlockState var14;
      Block var15;
      EnumFacing var16;
      if (var4 == EnumFacing.EAST) {
         var14 = var1.getBlockState(var2.west());
         var15 = var14.getBlock();
         if (isBlockStairs(var15) && var5 == var14.getValue(HALF)) {
            var16 = (EnumFacing)var14.getValue(FACING);
            if (var16 == EnumFacing.NORTH && !isSameStair(var1, var2.north(), var3)) {
               var11 = 0.0F;
               var12 = 0.5F;
               var13 = true;
            } else if (var16 == EnumFacing.SOUTH && !isSameStair(var1, var2.south(), var3)) {
               var11 = 0.5F;
               var12 = 1.0F;
               var13 = true;
            }
         }
      } else if (var4 == EnumFacing.WEST) {
         var14 = var1.getBlockState(var2.east());
         var15 = var14.getBlock();
         if (isBlockStairs(var15) && var5 == var14.getValue(HALF)) {
            var9 = 0.5F;
            var10 = 1.0F;
            var16 = (EnumFacing)var14.getValue(FACING);
            if (var16 == EnumFacing.NORTH && !isSameStair(var1, var2.north(), var3)) {
               var11 = 0.0F;
               var12 = 0.5F;
               var13 = true;
            } else if (var16 == EnumFacing.SOUTH && !isSameStair(var1, var2.south(), var3)) {
               var11 = 0.5F;
               var12 = 1.0F;
               var13 = true;
            }
         }
      } else if (var4 == EnumFacing.SOUTH) {
         var14 = var1.getBlockState(var2.north());
         var15 = var14.getBlock();
         if (isBlockStairs(var15) && var5 == var14.getValue(HALF)) {
            var11 = 0.0F;
            var12 = 0.5F;
            var16 = (EnumFacing)var14.getValue(FACING);
            if (var16 == EnumFacing.WEST && !isSameStair(var1, var2.west(), var3)) {
               var13 = true;
            } else if (var16 == EnumFacing.EAST && !isSameStair(var1, var2.east(), var3)) {
               var9 = 0.5F;
               var10 = 1.0F;
               var13 = true;
            }
         }
      } else if (var4 == EnumFacing.NORTH) {
         var14 = var1.getBlockState(var2.south());
         var15 = var14.getBlock();
         if (isBlockStairs(var15) && var5 == var14.getValue(HALF)) {
            var16 = (EnumFacing)var14.getValue(FACING);
            if (var16 == EnumFacing.WEST && !isSameStair(var1, var2.west(), var3)) {
               var13 = true;
            } else if (var16 == EnumFacing.EAST && !isSameStair(var1, var2.east(), var3)) {
               var9 = 0.5F;
               var10 = 1.0F;
               var13 = true;
            }
         }
      }

      if (var13) {
         this.setBlockBounds(var9, var7, var11, var10, var8, var12);
      }

      return var13;
   }

   public void onBlockClicked(World var1, BlockPos var2, EntityPlayer var3) {
      this.modelBlock.onBlockClicked(var1, var2, var3);
   }

   public void randomDisplayTick(World var1, BlockPos var2, IBlockState var3, Random var4) {
      this.modelBlock.randomDisplayTick(var1, var2, var3, var4);
   }

   public int getMetaFromState(IBlockState var1) {
      int var2 = 0;
      if (var1.getValue(HALF) == BlockStairs.EnumHalf.TOP) {
         var2 |= 4;
      }

      var2 |= 5 - ((EnumFacing)var1.getValue(FACING)).getIndex();
      return var2;
   }

   public int func_176305_g(IBlockAccess var1, BlockPos var2) {
      IBlockState var3 = var1.getBlockState(var2);
      EnumFacing var4 = (EnumFacing)var3.getValue(FACING);
      BlockStairs.EnumHalf var5 = (BlockStairs.EnumHalf)var3.getValue(HALF);
      boolean var6 = var5 == BlockStairs.EnumHalf.TOP;
      IBlockState var7;
      Block var8;
      EnumFacing var9;
      if (var4 == EnumFacing.EAST) {
         var7 = var1.getBlockState(var2.west());
         var8 = var7.getBlock();
         if (isBlockStairs(var8) && var5 == var7.getValue(HALF)) {
            var9 = (EnumFacing)var7.getValue(FACING);
            if (var9 == EnumFacing.NORTH && !isSameStair(var1, var2.north(), var3)) {
               return var6 ? 1 : 2;
            }

            if (var9 == EnumFacing.SOUTH && !isSameStair(var1, var2.south(), var3)) {
               return var6 ? 2 : 1;
            }
         }
      } else if (var4 == EnumFacing.WEST) {
         var7 = var1.getBlockState(var2.east());
         var8 = var7.getBlock();
         if (isBlockStairs(var8) && var5 == var7.getValue(HALF)) {
            var9 = (EnumFacing)var7.getValue(FACING);
            if (var9 == EnumFacing.NORTH && !isSameStair(var1, var2.north(), var3)) {
               return var6 ? 2 : 1;
            }

            if (var9 == EnumFacing.SOUTH && !isSameStair(var1, var2.south(), var3)) {
               return var6 ? 1 : 2;
            }
         }
      } else if (var4 == EnumFacing.SOUTH) {
         var7 = var1.getBlockState(var2.north());
         var8 = var7.getBlock();
         if (isBlockStairs(var8) && var5 == var7.getValue(HALF)) {
            var9 = (EnumFacing)var7.getValue(FACING);
            if (var9 == EnumFacing.WEST && !isSameStair(var1, var2.west(), var3)) {
               return var6 ? 2 : 1;
            }

            if (var9 == EnumFacing.EAST && !isSameStair(var1, var2.east(), var3)) {
               return var6 ? 1 : 2;
            }
         }
      } else if (var4 == EnumFacing.NORTH) {
         var7 = var1.getBlockState(var2.south());
         var8 = var7.getBlock();
         if (isBlockStairs(var8) && var5 == var7.getValue(HALF)) {
            var9 = (EnumFacing)var7.getValue(FACING);
            if (var9 == EnumFacing.WEST && !isSameStair(var1, var2.west(), var3)) {
               return var6 ? 1 : 2;
            }

            if (var9 == EnumFacing.EAST && !isSameStair(var1, var2.east(), var3)) {
               return var6 ? 2 : 1;
            }
         }
      }

      return 0;
   }

   public void setBlockBoundsBasedOnState(IBlockAccess var1, BlockPos var2) {
      if (this.hasRaytraced) {
         this.setBlockBounds(0.5F * (float)(this.rayTracePass % 2), 0.5F * (float)(this.rayTracePass / 4 % 2), 0.5F * (float)(this.rayTracePass / 2 % 2), 0.5F + 0.5F * (float)(this.rayTracePass % 2), 0.5F + 0.5F * (float)(this.rayTracePass / 4 % 2), 0.5F + 0.5F * (float)(this.rayTracePass / 2 % 2));
      } else {
         this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      }

   }

   public int tickRate(World var1) {
      return this.modelBlock.tickRate(var1);
   }

   public MapColor getMapColor(IBlockState var1) {
      return this.modelBlock.getMapColor(this.modelState);
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public IBlockState onBlockPlaced(World var1, BlockPos var2, EnumFacing var3, float var4, float var5, float var6, int var7, EntityLivingBase var8) {
      IBlockState var9 = super.onBlockPlaced(var1, var2, var3, var4, var5, var6, var7, var8);
      var9 = var9.withProperty(FACING, var8.getHorizontalFacing()).withProperty(SHAPE, BlockStairs.EnumShape.STRAIGHT);
      return var3 == EnumFacing.DOWN || var3 != EnumFacing.UP && (double)var5 > 0.5D ? var9.withProperty(HALF, BlockStairs.EnumHalf.TOP) : var9.withProperty(HALF, BlockStairs.EnumHalf.BOTTOM);
   }

   public void addCollisionBoxesToList(World var1, BlockPos var2, IBlockState var3, AxisAlignedBB var4, List<AxisAlignedBB> var5, Entity var6) {
      this.setBaseCollisionBounds(var1, var2);
      super.addCollisionBoxesToList(var1, var2, var3, var4, var5, var6);
      boolean var7 = this.func_176306_h(var1, var2);
      super.addCollisionBoxesToList(var1, var2, var3, var4, var5, var6);
      if (var7 && this.func_176304_i(var1, var2)) {
         super.addCollisionBoxesToList(var1, var2, var3, var4, var5, var6);
      }

      this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void setBaseCollisionBounds(IBlockAccess var1, BlockPos var2) {
      if (var1.getBlockState(var2).getValue(HALF) == BlockStairs.EnumHalf.TOP) {
         this.setBlockBounds(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else {
         this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      }

   }

   protected BlockStairs(IBlockState var1) {
      super(var1.getBlock().blockMaterial);
      this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(HALF, BlockStairs.EnumHalf.BOTTOM).withProperty(SHAPE, BlockStairs.EnumShape.STRAIGHT));
      this.modelBlock = var1.getBlock();
      this.modelState = var1;
      this.setHardness(this.modelBlock.blockHardness);
      this.setResistance(this.modelBlock.blockResistance / 3.0F);
      this.setStepSound(this.modelBlock.stepSound);
      this.setLightOpacity(255);
      this.setCreativeTab(CreativeTabs.tabBlock);
   }

   public IBlockState getActualState(IBlockState var1, IBlockAccess var2, BlockPos var3) {
      if (this.func_176306_h(var2, var3)) {
         switch(this.func_176305_g(var2, var3)) {
         case 0:
            var1 = var1.withProperty(SHAPE, BlockStairs.EnumShape.STRAIGHT);
            break;
         case 1:
            var1 = var1.withProperty(SHAPE, BlockStairs.EnumShape.INNER_RIGHT);
            break;
         case 2:
            var1 = var1.withProperty(SHAPE, BlockStairs.EnumShape.INNER_LEFT);
         }
      } else {
         switch(this.func_176307_f(var2, var3)) {
         case 0:
            var1 = var1.withProperty(SHAPE, BlockStairs.EnumShape.STRAIGHT);
            break;
         case 1:
            var1 = var1.withProperty(SHAPE, BlockStairs.EnumShape.OUTER_RIGHT);
            break;
         case 2:
            var1 = var1.withProperty(SHAPE, BlockStairs.EnumShape.OUTER_LEFT);
         }
      }

      return var1;
   }

   public void onBlockDestroyedByPlayer(World var1, BlockPos var2, IBlockState var3) {
      this.modelBlock.onBlockDestroyedByPlayer(var1, var2, var3);
   }

   static {
      FACING = PropertyDirection.create("facing", (Predicate)EnumFacing.Plane.HORIZONTAL);
      HALF = PropertyEnum.create("half", BlockStairs.EnumHalf.class);
      SHAPE = PropertyEnum.create("shape", BlockStairs.EnumShape.class);
      field_150150_a = new int[][]{{4, 5}, {5, 7}, {6, 7}, {4, 6}, {0, 1}, {1, 3}, {2, 3}, {0, 2}};
   }

   public EnumWorldBlockLayer getBlockLayer() {
      return this.modelBlock.getBlockLayer();
   }

   public boolean func_176306_h(IBlockAccess var1, BlockPos var2) {
      IBlockState var3 = var1.getBlockState(var2);
      EnumFacing var4 = (EnumFacing)var3.getValue(FACING);
      BlockStairs.EnumHalf var5 = (BlockStairs.EnumHalf)var3.getValue(HALF);
      boolean var6 = var5 == BlockStairs.EnumHalf.TOP;
      float var7 = 0.5F;
      float var8 = 1.0F;
      if (var6) {
         var7 = 0.0F;
         var8 = 0.5F;
      }

      float var9 = 0.0F;
      float var10 = 1.0F;
      float var11 = 0.0F;
      float var12 = 0.5F;
      boolean var13 = true;
      IBlockState var14;
      Block var15;
      EnumFacing var16;
      if (var4 == EnumFacing.EAST) {
         var9 = 0.5F;
         var12 = 1.0F;
         var14 = var1.getBlockState(var2.east());
         var15 = var14.getBlock();
         if (isBlockStairs(var15) && var5 == var14.getValue(HALF)) {
            var16 = (EnumFacing)var14.getValue(FACING);
            if (var16 == EnumFacing.NORTH && !isSameStair(var1, var2.south(), var3)) {
               var12 = 0.5F;
               var13 = false;
            } else if (var16 == EnumFacing.SOUTH && !isSameStair(var1, var2.north(), var3)) {
               var11 = 0.5F;
               var13 = false;
            }
         }
      } else if (var4 == EnumFacing.WEST) {
         var10 = 0.5F;
         var12 = 1.0F;
         var14 = var1.getBlockState(var2.west());
         var15 = var14.getBlock();
         if (isBlockStairs(var15) && var5 == var14.getValue(HALF)) {
            var16 = (EnumFacing)var14.getValue(FACING);
            if (var16 == EnumFacing.NORTH && !isSameStair(var1, var2.south(), var3)) {
               var12 = 0.5F;
               var13 = false;
            } else if (var16 == EnumFacing.SOUTH && !isSameStair(var1, var2.north(), var3)) {
               var11 = 0.5F;
               var13 = false;
            }
         }
      } else if (var4 == EnumFacing.SOUTH) {
         var11 = 0.5F;
         var12 = 1.0F;
         var14 = var1.getBlockState(var2.south());
         var15 = var14.getBlock();
         if (isBlockStairs(var15) && var5 == var14.getValue(HALF)) {
            var16 = (EnumFacing)var14.getValue(FACING);
            if (var16 == EnumFacing.WEST && !isSameStair(var1, var2.east(), var3)) {
               var10 = 0.5F;
               var13 = false;
            } else if (var16 == EnumFacing.EAST && !isSameStair(var1, var2.west(), var3)) {
               var9 = 0.5F;
               var13 = false;
            }
         }
      } else if (var4 == EnumFacing.NORTH) {
         var14 = var1.getBlockState(var2.north());
         var15 = var14.getBlock();
         if (isBlockStairs(var15) && var5 == var14.getValue(HALF)) {
            var16 = (EnumFacing)var14.getValue(FACING);
            if (var16 == EnumFacing.WEST && !isSameStair(var1, var2.east(), var3)) {
               var10 = 0.5F;
               var13 = false;
            } else if (var16 == EnumFacing.EAST && !isSameStair(var1, var2.west(), var3)) {
               var9 = 0.5F;
               var13 = false;
            }
         }
      }

      this.setBlockBounds(var9, var7, var11, var10, var8, var12);
      return var13;
   }

   public int func_176307_f(IBlockAccess var1, BlockPos var2) {
      IBlockState var3 = var1.getBlockState(var2);
      EnumFacing var4 = (EnumFacing)var3.getValue(FACING);
      BlockStairs.EnumHalf var5 = (BlockStairs.EnumHalf)var3.getValue(HALF);
      boolean var6 = var5 == BlockStairs.EnumHalf.TOP;
      IBlockState var7;
      Block var8;
      EnumFacing var9;
      if (var4 == EnumFacing.EAST) {
         var7 = var1.getBlockState(var2.east());
         var8 = var7.getBlock();
         if (isBlockStairs(var8) && var5 == var7.getValue(HALF)) {
            var9 = (EnumFacing)var7.getValue(FACING);
            if (var9 == EnumFacing.NORTH && !isSameStair(var1, var2.south(), var3)) {
               return var6 ? 1 : 2;
            }

            if (var9 == EnumFacing.SOUTH && !isSameStair(var1, var2.north(), var3)) {
               return var6 ? 2 : 1;
            }
         }
      } else if (var4 == EnumFacing.WEST) {
         var7 = var1.getBlockState(var2.west());
         var8 = var7.getBlock();
         if (isBlockStairs(var8) && var5 == var7.getValue(HALF)) {
            var9 = (EnumFacing)var7.getValue(FACING);
            if (var9 == EnumFacing.NORTH && !isSameStair(var1, var2.south(), var3)) {
               return var6 ? 2 : 1;
            }

            if (var9 == EnumFacing.SOUTH && !isSameStair(var1, var2.north(), var3)) {
               return var6 ? 1 : 2;
            }
         }
      } else if (var4 == EnumFacing.SOUTH) {
         var7 = var1.getBlockState(var2.south());
         var8 = var7.getBlock();
         if (isBlockStairs(var8) && var5 == var7.getValue(HALF)) {
            var9 = (EnumFacing)var7.getValue(FACING);
            if (var9 == EnumFacing.WEST && !isSameStair(var1, var2.east(), var3)) {
               return var6 ? 2 : 1;
            }

            if (var9 == EnumFacing.EAST && !isSameStair(var1, var2.west(), var3)) {
               return var6 ? 1 : 2;
            }
         }
      } else if (var4 == EnumFacing.NORTH) {
         var7 = var1.getBlockState(var2.north());
         var8 = var7.getBlock();
         if (isBlockStairs(var8) && var5 == var7.getValue(HALF)) {
            var9 = (EnumFacing)var7.getValue(FACING);
            if (var9 == EnumFacing.WEST && !isSameStair(var1, var2.east(), var3)) {
               return var6 ? 1 : 2;
            }

            if (var9 == EnumFacing.EAST && !isSameStair(var1, var2.west(), var3)) {
               return var6 ? 2 : 1;
            }
         }
      }

      return 0;
   }

   public float getExplosionResistance(Entity var1) {
      return this.modelBlock.getExplosionResistance(var1);
   }

   protected BlockState createBlockState() {
      return new BlockState(this, new IProperty[]{FACING, HALF, SHAPE});
   }

   public boolean canCollideCheck(IBlockState var1, boolean var2) {
      return this.modelBlock.canCollideCheck(var1, var2);
   }

   public void onBlockAdded(World var1, BlockPos var2, IBlockState var3) {
      this.onNeighborBlockChange(var1, var2, this.modelState, Blocks.air);
      this.modelBlock.onBlockAdded(var1, var2, this.modelState);
   }

   public int getMixedBrightnessForBlock(IBlockAccess var1, BlockPos var2) {
      return this.modelBlock.getMixedBrightnessForBlock(var1, var2);
   }

   public boolean isFullCube() {
      return false;
   }

   public void updateTick(World var1, BlockPos var2, IBlockState var3, Random var4) {
      this.modelBlock.updateTick(var1, var2, var3, var4);
   }

   public void onEntityCollidedWithBlock(World var1, BlockPos var2, Entity var3) {
      this.modelBlock.onEntityCollidedWithBlock(var1, var2, var3);
   }

   public boolean canPlaceBlockAt(World var1, BlockPos var2) {
      return this.modelBlock.canPlaceBlockAt(var1, var2);
   }

   public IBlockState getStateFromMeta(int var1) {
      IBlockState var2 = this.getDefaultState().withProperty(HALF, (var1 & 4) > 0 ? BlockStairs.EnumHalf.TOP : BlockStairs.EnumHalf.BOTTOM);
      var2 = var2.withProperty(FACING, EnumFacing.getFront(5 - (var1 & 3)));
      return var2;
   }

   public static enum EnumHalf implements IStringSerializable {
      BOTTOM("bottom");

      private final String name;
      TOP("top");

      private static final BlockStairs.EnumHalf[] ENUM$VALUES = new BlockStairs.EnumHalf[]{TOP, BOTTOM};

      public String toString() {
         return this.name;
      }

      private EnumHalf(String var3) {
         this.name = var3;
      }

      public String getName() {
         return this.name;
      }
   }

   public static enum EnumShape implements IStringSerializable {
      INNER_LEFT("inner_left"),
      INNER_RIGHT("inner_right"),
      OUTER_RIGHT("outer_right"),
      STRAIGHT("straight");

      private final String name;
      OUTER_LEFT("outer_left");

      private static final BlockStairs.EnumShape[] ENUM$VALUES = new BlockStairs.EnumShape[]{STRAIGHT, INNER_LEFT, INNER_RIGHT, OUTER_LEFT, OUTER_RIGHT};

      public String toString() {
         return this.name;
      }

      private EnumShape(String var3) {
         this.name = var3;
      }

      public String getName() {
         return this.name;
      }
   }
}
