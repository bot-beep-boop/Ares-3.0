package net.minecraft.block.state.pattern;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;

public class BlockStateHelper implements Predicate<IBlockState> {
   private final BlockState blockstate;
   private final Map<IProperty, Predicate> propertyPredicates = Maps.newHashMap();

   public static BlockStateHelper forBlock(Block var0) {
      return new BlockStateHelper(var0.getBlockState());
   }

   private BlockStateHelper(BlockState var1) {
      this.blockstate = var1;
   }

   public <V extends Comparable<V>> BlockStateHelper where(IProperty<V> var1, Predicate<? extends V> var2) {
      if (!this.blockstate.getProperties().contains(var1)) {
         throw new IllegalArgumentException(this.blockstate + " cannot support property " + var1);
      } else {
         this.propertyPredicates.put(var1, var2);
         return this;
      }
   }

   public boolean apply(IBlockState var1) {
      if (var1 != null && var1.getBlock().equals(this.blockstate.getBlock())) {
         Iterator var3 = this.propertyPredicates.entrySet().iterator();

         while(var3.hasNext()) {
            Entry var2 = (Entry)var3.next();
            Comparable var4 = var1.getValue((IProperty)var2.getKey());
            if (!((Predicate)var2.getValue()).apply(var4)) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean apply(Object var1) {
      return this.apply((IBlockState)var1);
   }
}