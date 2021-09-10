package net.optifine.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import net.minecraft.client.settings.KeyBinding;

public class KeyUtils {
   public static void fixKeyConflicts(KeyBinding[] var0, KeyBinding[] var1) {
      HashSet var2 = new HashSet();

      KeyBinding var4;
      for(int var3 = 0; var3 < var1.length; ++var3) {
         var4 = var1[var3];
         var2.add(var4.getKeyCode());
      }

      HashSet var7 = new HashSet(Arrays.asList(var0));
      var7.removeAll(Arrays.asList(var1));
      Iterator var5 = var7.iterator();

      while(var5.hasNext()) {
         var4 = (KeyBinding)var5.next();
         Integer var6 = var4.getKeyCode();
         if (var2.contains(var6)) {
            var4.setKeyCode(0);
         }
      }

   }
}
