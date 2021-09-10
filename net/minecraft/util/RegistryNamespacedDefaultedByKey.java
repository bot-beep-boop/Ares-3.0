package net.minecraft.util;

import org.apache.commons.lang3.Validate;

public class RegistryNamespacedDefaultedByKey<K, V> extends RegistryNamespaced<K, V> {
   private final K defaultValueKey;
   private V defaultValue;

   public V getObjectById(int var1) {
      Object var2 = super.getObjectById(var1);
      return var2 == null ? this.defaultValue : var2;
   }

   public V getObject(K var1) {
      Object var2 = super.getObject(var1);
      return var2 == null ? this.defaultValue : var2;
   }

   public void register(int var1, K var2, V var3) {
      if (this.defaultValueKey.equals(var2)) {
         this.defaultValue = var3;
      }

      super.register(var1, var2, var3);
   }

   public RegistryNamespacedDefaultedByKey(K var1) {
      this.defaultValueKey = var1;
   }

   public void validateKey() {
      Validate.notNull(this.defaultValueKey);
   }
}
