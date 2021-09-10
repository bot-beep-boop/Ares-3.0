package net.minecraft.block;

import java.util.List;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeColorHelper;

public class BlockDoublePlant extends BlockBush implements IGrowable {
   public static final PropertyEnum<EnumFacing> FACING;
   public static final PropertyEnum<BlockDoublePlant.EnumPlantType> VARIANT = PropertyEnum.create("variant", BlockDoublePlant.EnumPlantType.class);
   public static final PropertyEnum<BlockDoublePlant.EnumBlockHalf> HALF = PropertyEnum.create("half", BlockDoublePlant.EnumBlockHalf.class);

   public void onBlockHarvested(World var1, BlockPos var2, IBlockState var3, EntityPlayer var4) {
      if (var3.getValue(HALF) == BlockDoublePlant.EnumBlockHalf.UPPER) {
         if (var1.getBlockState(var2.down()).getBlock() == this) {
            if (!var4.capabilities.isCreativeMode) {
               IBlockState var5 = var1.getBlockState(var2.down());
               BlockDoublePlant.EnumPlantType var6 = (BlockDoublePlant.EnumPlantType)var5.getValue(VARIANT);
               if (var6 != BlockDoublePlant.EnumPlantType.FERN && var6 != BlockDoublePlant.EnumPlantType.GRASS) {
                  var1.destroyBlock(var2.down(), true);
               } else if (!var1.isRemote) {
                  if (var4.getCurrentEquippedItem() != null && var4.getCurrentEquippedItem().getItem() == Items.shears) {
                     this.onHarvest(var1, var2, var5, var4);
                     var1.setBlockToAir(var2.down());
                  } else {
                     var1.destroyBlock(var2.down(), true);
                  }
               } else {
                  var1.setBlockToAir(var2.down());
               }
            } else {
               var1.setBlockToAir(var2.down());
            }
         }
      } else if (var4.capabilities.isCreativeMode && var1.getBlockState(var2.up()).getBlock() == this) {
         var1.setBlockState(var2.up(), Blocks.air.getDefaultState(), 2);
      }

      super.onBlockHarvested(var1, var2, var3, var4);
   }

   public boolean canBlockStay(World var1, BlockPos var2, IBlockState var3) {
      if (var3.getValue(HALF) == BlockDoublePlant.EnumBlockHalf.UPPER) {
         return var1.getBlockState(var2.down()).getBlock() == this;
      } else {
         IBlockState var4 = var1.getBlockState(var2.up());
         return var4.getBlock() == this && super.canBlockStay(var1, var2, var4);
      }
   }

   public int getMetaFromState(IBlockState var1) {
      return var1.getValue(HALF) == BlockDoublePlant.EnumBlockHalf.UPPER ? 8 | ((EnumFacing)var1.getValue(FACING)).getHorizontalIndex() : ((BlockDoublePlant.EnumPlantType)var1.getValue(VARIANT)).getMeta();
   }

   public boolean isReplaceable(World var1, BlockPos var2) {
      IBlockState var3 = var1.getBlockState(var2);
      if (var3.getBlock() != this) {
         return true;
      } else {
         BlockDoublePlant.EnumPlantType var4 = (BlockDoublePlant.EnumPlantType)this.getActualState(var3, var1, var2).getValue(VARIANT);
         return var4 == BlockDoublePlant.EnumPlantType.FERN || var4 == BlockDoublePlant.EnumPlantType.GRASS;
      }
   }

   private boolean onHarvest(World var1, BlockPos var2, IBlockState var3, EntityPlayer var4) {
      BlockDoublePlant.EnumPlantType var5 = (BlockDoublePlant.EnumPlantType)var3.getValue(VARIANT);
      if (var5 != BlockDoublePlant.EnumPlantType.FERN && var5 != BlockDoublePlant.EnumPlantType.GRASS) {
         return false;
      } else {
         var4.triggerAchievement(StatList.mineBlockStatArray[Block.getIdFromBlock(this)]);
         int var6 = (var5 == BlockDoublePlant.EnumPlantType.GRASS ? BlockTallGrass.EnumType.GRASS : BlockTallGrass.EnumType.FERN).getMeta();
         spawnAsEntity(var1, var2, new ItemStack(Blocks.tallgrass, 2, var6));
         return true;
      }
   }

   public boolean canPlaceBlockAt(World var1, BlockPos var2) {
      return super.canPlaceBlockAt(var1, var2) && var1.isAirBlock(var2.up());
   }

   public int damageDropped(IBlockState var1) {
      return var1.getValue(HALF) != BlockDoublePlant.EnumBlockHalf.UPPER && var1.getValue(VARIANT) != BlockDoublePlant.EnumPlantType.GRASS ? ((BlockDoublePlant.EnumPlantType)var1.getValue(VARIANT)).getMeta() : 0;
   }

   public void harvestBlock(World var1, EntityPlayer var2, BlockPos var3, IBlockState var4, TileEntity var5) {
      if (var1.isRemote || var2.getCurrentEquippedItem() == null || var2.getCurrentEquippedItem().getItem() != Items.shears || var4.getValue(HALF) != BlockDoublePlant.EnumBlockHalf.LOWER || !this.onHarvest(var1, var3, var4, var2)) {
         super.harvestBlock(var1, var2, var3, var4, var5);
      }

   }

   static {
      FACING = BlockDirectional.FACING;
   }

   public int getDamageValue(World var1, BlockPos var2) {
      return this.getVariant(var1, var2).getMeta();
   }

   public BlockDoublePlant.EnumPlantType getVariant(IBlockAccess var1, BlockPos var2) {
      IBlockState var3 = var1.getBlockState(var2);
      if (var3.getBlock() == this) {
         var3 = this.getActualState(var3, var1, var2);
         return (BlockDoublePlant.EnumPlantType)var3.getValue(VARIANT);
      } else {
         return BlockDoublePlant.EnumPlantType.FERN;
      }
   }

   public void placeAt(World var1, BlockPos var2, BlockDoublePlant.EnumPlantType var3, int var4) {
      var1.setBlockState(var2, this.getDefaultState().withProperty(HALF, BlockDoublePlant.EnumBlockHalf.LOWER).withProperty(VARIANT, var3), var4);
      var1.setBlockState(var2.up(), this.getDefaultState().withProperty(HALF, BlockDoublePlant.EnumBlockHalf.UPPER), var4);
   }

   protected void checkAndDropBlock(World var1, BlockPos var2, IBlockState var3) {
      if (!this.canBlockStay(var1, var2, var3)) {
         boolean var4 = var3.getValue(HALF) == BlockDoublePlant.EnumBlockHalf.UPPER;
         BlockPos var5 = var4 ? var2 : var2.up();
         BlockPos var6 = var4 ? var2.down() : var2;
         Object var7 = var4 ? this : var1.getBlockState(var5).getBlock();
         Object var8 = var4 ? var1.getBlockState(var6).getBlock() : this;
         if (var7 == this) {
            var1.setBlockState(var5, Blocks.air.getDefaultState(), 2);
         }

         if (var8 == this) {
            var1.setBlockState(var6, Blocks.air.getDefaultState(), 3);
            if (!var4) {
               this.dropBlockAsItem(var1, var6, var3, 0);
            }
         }
      }

   }

   public void onBlockPlacedBy(World var1, BlockPos var2, IBlockState var3, EntityLivingBase var4, ItemStack var5) {
      var1.setBlockState(var2.up(), this.getDefaultState().withProperty(HALF, BlockDoublePlant.EnumBlockHalf.UPPER), 2);
   }

   public void setBlockBoundsBasedOnState(IBlockAccess var1, BlockPos var2) {
      this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public BlockDoublePlant() {
      super(Material.vine);
      this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockDoublePlant.EnumPlantType.SUNFLOWER).withProperty(HALF, BlockDoublePlant.EnumBlockHalf.LOWER).withProperty(FACING, EnumFacing.NORTH));
      this.setHardness(0.0F);
      this.setStepSound(soundTypeGrass);
      this.setUnlocalizedName("doublePlant");
   }

   protected BlockState createBlockState() {
      return new BlockState(this, new IProperty[]{HALF, VARIANT, FACING});
   }

   public void grow(World var1, Random var2, BlockPos var3, IBlockState var4) {
      spawnAsEntity(var1, var3, new ItemStack(this, 1, this.getVariant(var1, var3).getMeta()));
   }

   public Item getItemDropped(IBlockState var1, Random var2, int var3) {
      if (var1.getValue(HALF) == BlockDoublePlant.EnumBlockHalf.UPPER) {
         return null;
      } else {
         BlockDoublePlant.EnumPlantType var4 = (BlockDoublePlant.EnumPlantType)var1.getValue(VARIANT);
         if (var4 == BlockDoublePlant.EnumPlantType.FERN) {
            return null;
         } else if (var4 == BlockDoublePlant.EnumPlantType.GRASS) {
            return var2.nextInt(8) == 0 ? Items.wheat_seeds : null;
         } else {
            return Item.getItemFromBlock(this);
         }
      }
   }

   public IBlockState getStateFromMeta(int var1) {
      return (var1 & 8) > 0 ? this.getDefaultState().withProperty(HALF, BlockDoublePlant.EnumBlockHalf.UPPER) : this.getDefaultState().withProperty(HALF, BlockDoublePlant.EnumBlockHalf.LOWER).withProperty(VARIANT, BlockDoublePlant.EnumPlantType.byMetadata(var1 & 7));
   }

   public boolean canGrow(World var1, BlockPos var2, IBlockState var3, boolean var4) {
      BlockDoublePlant.EnumPlantType var5 = this.getVariant(var1, var2);
      return var5 != BlockDoublePlant.EnumPlantType.GRASS && var5 != BlockDoublePlant.EnumPlantType.FERN;
   }

   public IBlockState getActualState(IBlockState var1, IBlockAccess var2, BlockPos var3) {
      if (var1.getValue(HALF) == BlockDoublePlant.EnumBlockHalf.UPPER) {
         IBlockState var4 = var2.getBlockState(var3.down());
         if (var4.getBlock() == this) {
            var1 = var1.withProperty(VARIANT, (BlockDoublePlant.EnumPlantType)var4.getValue(VARIANT));
         }
      }

      return var1;
   }

   public Block.EnumOffsetType getOffsetType() {
      return Block.EnumOffsetType.XZ;
   }

   public int colorMultiplier(IBlockAccess var1, BlockPos var2, int var3) {
      BlockDoublePlant.EnumPlantType var4 = this.getVariant(var1, var2);
      return var4 != BlockDoublePlant.EnumPlantType.GRASS && var4 != BlockDoublePlant.EnumPlantType.FERN ? 16777215 : BiomeColorHelper.getGrassColorAtPos(var1, var2);
   }

   public void getSubBlocks(Item var1, CreativeTabs var2, List<ItemStack> var3) {
      BlockDoublePlant.EnumPlantType[] var7;
      int var6 = (var7 = BlockDoublePlant.EnumPlantType.values()).length;

      for(int var5 = 0; var5 < var6; ++var5) {
         BlockDoublePlant.EnumPlantType var4 = var7[var5];
         var3.add(new ItemStack(var1, 1, var4.getMeta()));
      }

   }

   public boolean canUseBonemeal(World var1, Random var2, BlockPos var3, IBlockState var4) {
      return true;
   }

   public static enum EnumBlockHalf implements IStringSerializable {
      private static final BlockDoublePlant.EnumBlockHalf[] ENUM$VALUES = new BlockDoublePlant.EnumBlockHalf[]{UPPER, LOWER};
      LOWER,
      UPPER;

      public String getName() {
         return this == UPPER ? "upper" : "lower";
      }

      public String toString() {
         return this.getName();
      }
   }

   public static enum EnumPlantType implements IStringSerializable {
      SYRINGA(1, "syringa");

      private final String unlocalizedName;
      private final String name;
      SUNFLOWER(0, "sunflower"),
      PAEONIA(5, "paeonia"),
      GRASS(2, "double_grass", "grass"),
      FERN(3, "double_fern", "fern"),
      ROSE(4, "double_rose", "rose");

      private static final BlockDoublePlant.EnumPlantType[] META_LOOKUP = new BlockDoublePlant.EnumPlantType[values().length];
      private final int meta;
      private static final BlockDoublePlant.EnumPlantType[] ENUM$VALUES = new BlockDoublePlant.EnumPlantType[]{SUNFLOWER, SYRINGA, GRASS, FERN, ROSE, PAEONIA};

      public int getMeta() {
         return this.meta;
      }

      public String getUnlocalizedName() {
         return this.unlocalizedName;
      }

      public static BlockDoublePlant.EnumPlantType byMetadata(int var0) {
         if (var0 < 0 || var0 >= META_LOOKUP.length) {
            var0 = 0;
         }

         return META_LOOKUP[var0];
      }

      public String getName() {
         return this.name;
      }

      private EnumPlantType(int var3, String var4) {
         this(var3, var4, var4);
      }

      public String toString() {
         return this.name;
      }

      private EnumPlantType(int var3, String var4, String var5) {
         this.meta = var3;
         this.name = var4;
         this.unlocalizedName = var5;
      }

      static {
         BlockDoublePlant.EnumPlantType[] var3;
         int var2 = (var3 = values()).length;

         for(int var1 = 0; var1 < var2; ++var1) {
            BlockDoublePlant.EnumPlantType var0 = var3[var1];
            META_LOOKUP[var0.getMeta()] = var0;
         }

      }
   }
}
