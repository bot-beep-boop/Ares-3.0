package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenSavannaTree;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BlockSapling extends BlockBush implements IGrowable {
   public static final PropertyEnum<BlockPlanks.EnumType> TYPE = PropertyEnum.create("type", BlockPlanks.EnumType.class);
   public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
   private static int[] $SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType;

   public void grow(World var1, Random var2, BlockPos var3, IBlockState var4) {
      this.grow(var1, var3, var4, var2);
   }

   public boolean canUseBonemeal(World var1, Random var2, BlockPos var3, IBlockState var4) {
      return (double)var1.rand.nextFloat() < 0.45D;
   }

   public void updateTick(World var1, BlockPos var2, IBlockState var3, Random var4) {
      if (!var1.isRemote) {
         super.updateTick(var1, var2, var3, var4);
         if (var1.getLightFromNeighbors(var2.up()) >= 9 && var4.nextInt(7) == 0) {
            this.grow(var1, var2, var3, var4);
         }
      }

   }

   public void grow(World var1, BlockPos var2, IBlockState var3, Random var4) {
      if ((Integer)var3.getValue(STAGE) == 0) {
         var1.setBlockState(var2, var3.cycleProperty(STAGE), 4);
      } else {
         this.generateTree(var1, var2, var3, var4);
      }

   }

   public int getMetaFromState(IBlockState var1) {
      byte var2 = 0;
      int var3 = var2 | ((BlockPlanks.EnumType)var1.getValue(TYPE)).getMetadata();
      var3 |= (Integer)var1.getValue(STAGE) << 3;
      return var3;
   }

   public boolean isTypeAt(World var1, BlockPos var2, BlockPlanks.EnumType var3) {
      IBlockState var4 = var1.getBlockState(var2);
      return var4.getBlock() == this && var4.getValue(TYPE) == var3;
   }

   static int[] $SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType() {
      int[] var10000 = $SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[BlockPlanks.EnumType.values().length];

         try {
            var0[BlockPlanks.EnumType.ACACIA.ordinal()] = 5;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[BlockPlanks.EnumType.BIRCH.ordinal()] = 3;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[BlockPlanks.EnumType.DARK_OAK.ordinal()] = 6;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[BlockPlanks.EnumType.JUNGLE.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[BlockPlanks.EnumType.OAK.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[BlockPlanks.EnumType.SPRUCE.ordinal()] = 2;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType = var0;
         return var0;
      }
   }

   private boolean func_181624_a(World var1, BlockPos var2, int var3, int var4, BlockPlanks.EnumType var5) {
      return this.isTypeAt(var1, var2.add(var3, 0, var4), var5) && this.isTypeAt(var1, var2.add(var3 + 1, 0, var4), var5) && this.isTypeAt(var1, var2.add(var3, 0, var4 + 1), var5) && this.isTypeAt(var1, var2.add(var3 + 1, 0, var4 + 1), var5);
   }

   protected BlockSapling() {
      this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, BlockPlanks.EnumType.OAK).withProperty(STAGE, 0));
      float var1 = 0.4F;
      this.setBlockBounds(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var1 * 2.0F, 0.5F + var1);
      this.setCreativeTab(CreativeTabs.tabDecorations);
   }

   public int damageDropped(IBlockState var1) {
      return ((BlockPlanks.EnumType)var1.getValue(TYPE)).getMetadata();
   }

   public boolean canGrow(World var1, BlockPos var2, IBlockState var3, boolean var4) {
      return true;
   }

   protected BlockState createBlockState() {
      return new BlockState(this, new IProperty[]{TYPE, STAGE});
   }

   public void getSubBlocks(Item var1, CreativeTabs var2, List<ItemStack> var3) {
      BlockPlanks.EnumType[] var7;
      int var6 = (var7 = BlockPlanks.EnumType.values()).length;

      for(int var5 = 0; var5 < var6; ++var5) {
         BlockPlanks.EnumType var4 = var7[var5];
         var3.add(new ItemStack(var1, 1, var4.getMetadata()));
      }

   }

   public IBlockState getStateFromMeta(int var1) {
      return this.getDefaultState().withProperty(TYPE, BlockPlanks.EnumType.byMetadata(var1 & 7)).withProperty(STAGE, (var1 & 8) >> 3);
   }

   public String getLocalizedName() {
      return StatCollector.translateToLocal(this.getUnlocalizedName() + "." + BlockPlanks.EnumType.OAK.getUnlocalizedName() + ".name");
   }

   public void generateTree(World var1, BlockPos var2, IBlockState var3, Random var4) {
      Object var5 = var4.nextInt(10) == 0 ? new WorldGenBigTree(true) : new WorldGenTrees(true);
      int var6 = 0;
      int var7 = 0;
      boolean var8 = false;
      IBlockState var9;
      switch($SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType()[((BlockPlanks.EnumType)var3.getValue(TYPE)).ordinal()]) {
      case 1:
      default:
         break;
      case 2:
         label113:
         for(var6 = 0; var6 >= -1; --var6) {
            for(var7 = 0; var7 >= -1; --var7) {
               if (this.func_181624_a(var1, var2, var6, var7, BlockPlanks.EnumType.SPRUCE)) {
                  var5 = new WorldGenMegaPineTree(false, var4.nextBoolean());
                  var8 = true;
                  break label113;
               }
            }
         }

         if (!var8) {
            var7 = 0;
            var6 = 0;
            var5 = new WorldGenTaiga2(true);
         }
         break;
      case 3:
         var5 = new WorldGenForest(true, false);
         break;
      case 4:
         var9 = Blocks.log.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE);
         IBlockState var10 = Blocks.leaves.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty(BlockLeaves.CHECK_DECAY, false);

         label127:
         for(var6 = 0; var6 >= -1; --var6) {
            for(var7 = 0; var7 >= -1; --var7) {
               if (this.func_181624_a(var1, var2, var6, var7, BlockPlanks.EnumType.JUNGLE)) {
                  var5 = new WorldGenMegaJungle(true, 10, 20, var9, var10);
                  var8 = true;
                  break label127;
               }
            }
         }

         if (!var8) {
            var7 = 0;
            var6 = 0;
            var5 = new WorldGenTrees(true, 4 + var4.nextInt(7), var9, var10, false);
         }
         break;
      case 5:
         var5 = new WorldGenSavannaTree(true);
         break;
      case 6:
         label141:
         for(var6 = 0; var6 >= -1; --var6) {
            for(var7 = 0; var7 >= -1; --var7) {
               if (this.func_181624_a(var1, var2, var6, var7, BlockPlanks.EnumType.DARK_OAK)) {
                  var5 = new WorldGenCanopyTree(true);
                  var8 = true;
                  break label141;
               }
            }
         }

         if (!var8) {
            return;
         }
      }

      var9 = Blocks.air.getDefaultState();
      if (var8) {
         var1.setBlockState(var2.add(var6, 0, var7), var9, 4);
         var1.setBlockState(var2.add(var6 + 1, 0, var7), var9, 4);
         var1.setBlockState(var2.add(var6, 0, var7 + 1), var9, 4);
         var1.setBlockState(var2.add(var6 + 1, 0, var7 + 1), var9, 4);
      } else {
         var1.setBlockState(var2, var9, 4);
      }

      if (!((WorldGenerator)var5).generate(var1, var4, var2.add(var6, 0, var7))) {
         if (var8) {
            var1.setBlockState(var2.add(var6, 0, var7), var3, 4);
            var1.setBlockState(var2.add(var6 + 1, 0, var7), var3, 4);
            var1.setBlockState(var2.add(var6, 0, var7 + 1), var3, 4);
            var1.setBlockState(var2.add(var6 + 1, 0, var7 + 1), var3, 4);
         } else {
            var1.setBlockState(var2, var3, 4);
         }
      }

   }
}
