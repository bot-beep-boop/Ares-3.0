package net.minecraft.block.properties;

import java.util.Collection;

public interface IProperty<T extends Comparable<T>> {
   String getName();

   Class<T> getValueClass();

   String getName(T var1);

   Collection<T> getAllowedValues();
}
