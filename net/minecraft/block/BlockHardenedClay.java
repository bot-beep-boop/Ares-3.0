package net.minecraft.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;

public class BlockHardenedClay extends Block {
   public MapColor getMapColor(IBlockState var1) {
      return MapColor.adobeColor;
   }

   public BlockHardenedClay() {
      super(Material.rock);
      this.setCreativeTab(CreativeTabs.tabBlock);
   }
}
