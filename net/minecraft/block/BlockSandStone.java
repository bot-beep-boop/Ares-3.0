package net.minecraft.block;

import java.util.List;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

public class BlockSandStone extends Block {
   public static final PropertyEnum<BlockSandStone.EnumType> TYPE = PropertyEnum.create("type", BlockSandStone.EnumType.class);

   protected BlockState createBlockState() {
      return new BlockState(this, new IProperty[]{TYPE});
   }

   public int damageDropped(IBlockState var1) {
      return ((BlockSandStone.EnumType)var1.getValue(TYPE)).getMetadata();
   }

   public BlockSandStone() {
      super(Material.rock);
      this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, BlockSandStone.EnumType.DEFAULT));
      this.setCreativeTab(CreativeTabs.tabBlock);
   }

   public IBlockState getStateFromMeta(int var1) {
      return this.getDefaultState().withProperty(TYPE, BlockSandStone.EnumType.byMetadata(var1));
   }

   public int getMetaFromState(IBlockState var1) {
      return ((BlockSandStone.EnumType)var1.getValue(TYPE)).getMetadata();
   }

   public void getSubBlocks(Item var1, CreativeTabs var2, List<ItemStack> var3) {
      BlockSandStone.EnumType[] var7;
      int var6 = (var7 = BlockSandStone.EnumType.values()).length;

      for(int var5 = 0; var5 < var6; ++var5) {
         BlockSandStone.EnumType var4 = var7[var5];
         var3.add(new ItemStack(var1, 1, var4.getMetadata()));
      }

   }

   public MapColor getMapColor(IBlockState var1) {
      return MapColor.sandColor;
   }

   public static enum EnumType implements IStringSerializable {
      private final String name;
      private final int metadata;
      SMOOTH(2, "smooth_sandstone", "smooth");

      private static final BlockSandStone.EnumType[] META_LOOKUP = new BlockSandStone.EnumType[values().length];
      CHISELED(1, "chiseled_sandstone", "chiseled"),
      DEFAULT(0, "sandstone", "default");

      private final String unlocalizedName;
      private static final BlockSandStone.EnumType[] ENUM$VALUES = new BlockSandStone.EnumType[]{DEFAULT, CHISELED, SMOOTH};

      private EnumType(int var3, String var4, String var5) {
         this.metadata = var3;
         this.name = var4;
         this.unlocalizedName = var5;
      }

      public String getUnlocalizedName() {
         return this.unlocalizedName;
      }

      public static BlockSandStone.EnumType byMetadata(int var0) {
         if (var0 < 0 || var0 >= META_LOOKUP.length) {
            var0 = 0;
         }

         return META_LOOKUP[var0];
      }

      public String getName() {
         return this.name;
      }

      public int getMetadata() {
         return this.metadata;
      }

      public String toString() {
         return this.name;
      }

      static {
         BlockSandStone.EnumType[] var3;
         int var2 = (var3 = values()).length;

         for(int var1 = 0; var1 < var2; ++var1) {
            BlockSandStone.EnumType var0 = var3[var1];
            META_LOOKUP[var0.getMetadata()] = var0;
         }

      }
   }
}
