package net.minecraft.world.storage;

import net.minecraft.world.WorldSavedData;

public class SaveDataMemoryStorage extends MapStorage {
   public void saveAllData() {
   }

   public int getUniqueDataId(String var1) {
      return 0;
   }

   public WorldSavedData loadData(Class<? extends WorldSavedData> var1, String var2) {
      return (WorldSavedData)this.loadedDataMap.get(var2);
   }

   public SaveDataMemoryStorage() {
      super((ISaveHandler)null);
   }

   public void setData(String var1, WorldSavedData var2) {
      this.loadedDataMap.put(var1, var2);
   }
}
