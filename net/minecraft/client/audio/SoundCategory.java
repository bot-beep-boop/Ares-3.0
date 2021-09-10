package net.minecraft.client.audio;

import com.google.common.collect.Maps;
import java.util.Map;

public enum SoundCategory {
   MOBS("hostile", 5),
   BLOCKS("block", 4);

   private static final Map<String, SoundCategory> NAME_CATEGORY_MAP = Maps.newHashMap();
   private final int categoryId;
   MASTER("master", 0);

   private static final Map<Integer, SoundCategory> ID_CATEGORY_MAP = Maps.newHashMap();
   private static final SoundCategory[] ENUM$VALUES = new SoundCategory[]{MASTER, MUSIC, RECORDS, WEATHER, BLOCKS, MOBS, ANIMALS, PLAYERS, AMBIENT};
   MUSIC("music", 1),
   PLAYERS("player", 7);

   private final String categoryName;
   RECORDS("record", 2),
   WEATHER("weather", 3),
   ANIMALS("neutral", 6),
   AMBIENT("ambient", 8);

   public String getCategoryName() {
      return this.categoryName;
   }

   static {
      SoundCategory[] var3;
      int var2 = (var3 = values()).length;

      for(int var1 = 0; var1 < var2; ++var1) {
         SoundCategory var0 = var3[var1];
         if (NAME_CATEGORY_MAP.containsKey(var0.getCategoryName()) || ID_CATEGORY_MAP.containsKey(var0.getCategoryId())) {
            throw new Error("Clash in Sound Category ID & Name pools! Cannot insert " + var0);
         }

         NAME_CATEGORY_MAP.put(var0.getCategoryName(), var0);
         ID_CATEGORY_MAP.put(var0.getCategoryId(), var0);
      }

   }

   public static SoundCategory getCategory(String var0) {
      return (SoundCategory)NAME_CATEGORY_MAP.get(var0);
   }

   private SoundCategory(String var3, int var4) {
      this.categoryName = var3;
      this.categoryId = var4;
   }

   public int getCategoryId() {
      return this.categoryId;
   }
}
