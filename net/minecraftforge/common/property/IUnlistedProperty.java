package net.minecraftforge.common.property;

public interface IUnlistedProperty<V> {
   Class<V> getType();

   String valueToString(V var1);

   String getName();

   boolean isValid(V var1);
}
