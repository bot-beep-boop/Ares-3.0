package net.minecraft.block.state;

import com.google.common.collect.ImmutableMap;
import java.util.Collection;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;

public interface IBlockState {
   <T extends Comparable<T>> IBlockState cycleProperty(IProperty<T> var1);

   ImmutableMap<IProperty, Comparable> getProperties();

   <T extends Comparable<T>, V extends T> IBlockState withProperty(IProperty<T> var1, V var2);

   Collection<IProperty> getPropertyNames();

   Block getBlock();

   <T extends Comparable<T>> T getValue(IProperty<T> var1);
}
