package net.minecraft.util;

public class RegistryDefaulted<K, V> extends RegistrySimple<K, V> {
   private final V defaultObject;

   public V getObject(K var1) {
      Object var2 = super.getObject(var1);
      return var2 == null ? this.defaultObject : var2;
   }

   public RegistryDefaulted(V var1) {
      this.defaultObject = var1;
   }
}
