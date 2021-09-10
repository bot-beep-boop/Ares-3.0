package net.optifine.util;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.src.Config;

public class EntityUtils {
   private static final Map<Class, Integer> mapIdByClass = new HashMap();
   private static final Map<String, Integer> mapIdByName = new HashMap();
   private static final Map<String, Class> mapClassByName = new HashMap();

   public static int getEntityIdByClass(Class var0) {
      Integer var1 = (Integer)mapIdByClass.get(var0);
      return var1 == null ? -1 : var1;
   }

   static {
      for(int var0 = 0; var0 < 1000; ++var0) {
         Class var1 = EntityList.getClassFromID(var0);
         if (var1 != null) {
            String var2 = EntityList.getStringFromID(var0);
            if (var2 != null) {
               if (mapIdByClass.containsKey(var1)) {
                  Config.warn("Duplicate entity class: " + var1 + ", id1: " + mapIdByClass.get(var1) + ", id2: " + var0);
               }

               if (mapIdByName.containsKey(var2)) {
                  Config.warn("Duplicate entity name: " + var2 + ", id1: " + mapIdByName.get(var2) + ", id2: " + var0);
               }

               if (mapClassByName.containsKey(var2)) {
                  Config.warn("Duplicate entity name: " + var2 + ", class1: " + mapClassByName.get(var2) + ", class2: " + var1);
               }

               mapIdByClass.put(var1, var0);
               mapIdByName.put(var2, var0);
               mapClassByName.put(var2, var1);
            }
         }
      }

   }

   public static int getEntityIdByClass(Entity var0) {
      return var0 == null ? -1 : getEntityIdByClass(var0.getClass());
   }

   public static int getEntityIdByName(String var0) {
      Integer var1 = (Integer)mapIdByName.get(var0);
      return var1 == null ? -1 : var1;
   }

   public static Class getEntityClassByName(String var0) {
      Class var1 = (Class)mapClassByName.get(var0);
      return var1;
   }
}
