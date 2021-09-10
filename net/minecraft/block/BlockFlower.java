package net.minecraft.block;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.List;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

public abstract class BlockFlower extends BlockBush {
   protected PropertyEnum<BlockFlower.EnumFlowerType> type;

   public IProperty<BlockFlower.EnumFlowerType> getTypeProperty() {
      if (this.type == null) {
         this.type = PropertyEnum.create("type", BlockFlower.EnumFlowerType.class, new Predicate<BlockFlower.EnumFlowerType>(this) {
            final BlockFlower this$0;

            public boolean apply(BlockFlower.EnumFlowerType var1) {
               return var1.getBlockType() == this.this$0.getBlockType();
            }

            public boolean apply(Object var1) {
               return this.apply((BlockFlower.EnumFlowerType)var1);
            }

            {
               this.this$0 = var1;
            }
         });
      }

      return this.type;
   }

   protected BlockState createBlockState() {
      return new BlockState(this, new IProperty[]{this.getTypeProperty()});
   }

   public int damageDropped(IBlockState var1) {
      return ((BlockFlower.EnumFlowerType)var1.getValue(this.getTypeProperty())).getMeta();
   }

   public Block.EnumOffsetType getOffsetType() {
      return Block.EnumOffsetType.XZ;
   }

   public void getSubBlocks(Item var1, CreativeTabs var2, List<ItemStack> var3) {
      BlockFlower.EnumFlowerType[] var7;
      int var6 = (var7 = BlockFlower.EnumFlowerType.getTypes(this.getBlockType())).length;

      for(int var5 = 0; var5 < var6; ++var5) {
         BlockFlower.EnumFlowerType var4 = var7[var5];
         var3.add(new ItemStack(var1, 1, var4.getMeta()));
      }

   }

   public abstract BlockFlower.EnumFlowerColor getBlockType();

   protected BlockFlower() {
      this.setDefaultState(this.blockState.getBaseState().withProperty(this.getTypeProperty(), this.getBlockType() == BlockFlower.EnumFlowerColor.RED ? BlockFlower.EnumFlowerType.POPPY : BlockFlower.EnumFlowerType.DANDELION));
   }

   public int getMetaFromState(IBlockState var1) {
      return ((BlockFlower.EnumFlowerType)var1.getValue(this.getTypeProperty())).getMeta();
   }

   public IBlockState getStateFromMeta(int var1) {
      return this.getDefaultState().withProperty(this.getTypeProperty(), BlockFlower.EnumFlowerType.getType(this.getBlockType(), var1));
   }

   public static enum EnumFlowerType implements IStringSerializable {
      private final String unlocalizedName;
      POPPY(BlockFlower.EnumFlowerColor.RED, 0, "poppy");

      private final String name;
      RED_TULIP(BlockFlower.EnumFlowerColor.RED, 4, "red_tulip", "tulipRed");

      private final int meta;
      ALLIUM(BlockFlower.EnumFlowerColor.RED, 2, "allium");

      private final BlockFlower.EnumFlowerColor blockType;
      ORANGE_TULIP(BlockFlower.EnumFlowerColor.RED, 5, "orange_tulip", "tulipOrange");

      private static final BlockFlower.EnumFlowerType[][] TYPES_FOR_BLOCK = new BlockFlower.EnumFlowerType[BlockFlower.EnumFlowerColor.values().length][];
      WHITE_TULIP(BlockFlower.EnumFlowerColor.RED, 6, "white_tulip", "tulipWhite");

      private static final BlockFlower.EnumFlowerType[] ENUM$VALUES = new BlockFlower.EnumFlowerType[]{DANDELION, POPPY, BLUE_ORCHID, ALLIUM, HOUSTONIA, RED_TULIP, ORANGE_TULIP, WHITE_TULIP, PINK_TULIP, OXEYE_DAISY};
      OXEYE_DAISY(BlockFlower.EnumFlowerColor.RED, 8, "oxeye_daisy", "oxeyeDaisy"),
      PINK_TULIP(BlockFlower.EnumFlowerColor.RED, 7, "pink_tulip", "tulipPink"),
      DANDELION(BlockFlower.EnumFlowerColor.YELLOW, 0, "dandelion"),
      BLUE_ORCHID(BlockFlower.EnumFlowerColor.RED, 1, "blue_orchid", "blueOrchid"),
      HOUSTONIA(BlockFlower.EnumFlowerColor.RED, 3, "houstonia");

      public String toString() {
         return this.name;
      }

      public int getMeta() {
         return this.meta;
      }

      static {
         BlockFlower.EnumFlowerColor[] var3;
         int var2 = (var3 = BlockFlower.EnumFlowerColor.values()).length;

         for(int var1 = 0; var1 < var2; ++var1) {
            BlockFlower.EnumFlowerColor var0 = var3[var1];
            Collection var4 = Collections2.filter(Lists.newArrayList(values()), new Predicate<BlockFlower.EnumFlowerType>(var0) {
               private final BlockFlower.EnumFlowerColor val$blockflower$enumflowercolor;

               {
                  this.val$blockflower$enumflowercolor = var1;
               }

               public boolean apply(Object var1) {
                  return this.apply((BlockFlower.EnumFlowerType)var1);
               }

               public boolean apply(BlockFlower.EnumFlowerType var1) {
                  return var1.getBlockType() == this.val$blockflower$enumflowercolor;
               }
            });
            TYPES_FOR_BLOCK[var0.ordinal()] = (BlockFlower.EnumFlowerType[])var4.toArray(new BlockFlower.EnumFlowerType[var4.size()]);
         }

      }

      public static BlockFlower.EnumFlowerType getType(BlockFlower.EnumFlowerColor var0, int var1) {
         BlockFlower.EnumFlowerType[] var2 = TYPES_FOR_BLOCK[var0.ordinal()];
         if (var1 < 0 || var1 >= var2.length) {
            var1 = 0;
         }

         return var2[var1];
      }

      private EnumFlowerType(BlockFlower.EnumFlowerColor var3, int var4, String var5) {
         this(var3, var4, var5, var5);
      }

      public static BlockFlower.EnumFlowerType[] getTypes(BlockFlower.EnumFlowerColor var0) {
         return TYPES_FOR_BLOCK[var0.ordinal()];
      }

      public String getUnlocalizedName() {
         return this.unlocalizedName;
      }

      private EnumFlowerType(BlockFlower.EnumFlowerColor var3, int var4, String var5, String var6) {
         this.blockType = var3;
         this.meta = var4;
         this.name = var5;
         this.unlocalizedName = var6;
      }

      public String getName() {
         return this.name;
      }

      public BlockFlower.EnumFlowerColor getBlockType() {
         return this.blockType;
      }
   }

   public static enum EnumFlowerColor {
      YELLOW,
      RED;

      private static final BlockFlower.EnumFlowerColor[] ENUM$VALUES = new BlockFlower.EnumFlowerColor[]{YELLOW, RED};

      public BlockFlower getBlock() {
         return this == YELLOW ? Blocks.yellow_flower : Blocks.red_flower;
      }
   }
}
