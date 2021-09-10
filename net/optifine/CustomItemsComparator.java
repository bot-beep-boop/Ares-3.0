package net.optifine;

import java.util.Comparator;
import net.minecraft.src.Config;

public class CustomItemsComparator implements Comparator {
   public int compare(Object var1, Object var2) {
      CustomItemProperties var3 = (CustomItemProperties)var1;
      CustomItemProperties var4 = (CustomItemProperties)var2;
      if (var3.weight != var4.weight) {
         return var4.weight - var3.weight;
      } else {
         return !Config.equals(var3.basePath, var4.basePath) ? var3.basePath.compareTo(var4.basePath) : var3.name.compareTo(var4.name);
      }
   }
}
