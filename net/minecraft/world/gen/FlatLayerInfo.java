package net.minecraft.world.gen;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;

public class FlatLayerInfo {
   private IBlockState layerMaterial;
   private final int field_175902_a;
   private int layerMinimumY;
   private int layerCount;

   public IBlockState getLayerMaterial() {
      return this.layerMaterial;
   }

   public int getLayerCount() {
      return this.layerCount;
   }

   public String toString() {
      String var1;
      if (this.field_175902_a >= 3) {
         ResourceLocation var2 = (ResourceLocation)Block.blockRegistry.getNameForObject(this.getLayerMaterialBlock());
         var1 = var2 == null ? "null" : var2.toString();
         if (this.layerCount > 1) {
            var1 = this.layerCount + "*" + var1;
         }
      } else {
         var1 = Integer.toString(Block.getIdFromBlock(this.getLayerMaterialBlock()));
         if (this.layerCount > 1) {
            var1 = this.layerCount + "x" + var1;
         }
      }

      int var3 = this.getFillBlockMeta();
      if (var3 > 0) {
         var1 = var1 + ":" + var3;
      }

      return var1;
   }

   public void setMinY(int var1) {
      this.layerMinimumY = var1;
   }

   public FlatLayerInfo(int var1, int var2, Block var3, int var4) {
      this(var1, var2, var3);
      this.layerMaterial = var3.getStateFromMeta(var4);
   }

   public FlatLayerInfo(int var1, int var2, Block var3) {
      this.layerCount = 1;
      this.field_175902_a = var1;
      this.layerCount = var2;
      this.layerMaterial = var3.getDefaultState();
   }

   public FlatLayerInfo(int var1, Block var2) {
      this(3, var1, var2);
   }

   private int getFillBlockMeta() {
      return this.layerMaterial.getBlock().getMetaFromState(this.layerMaterial);
   }

   private Block getLayerMaterialBlock() {
      return this.layerMaterial.getBlock();
   }

   public int getMinY() {
      return this.layerMinimumY;
   }
}
