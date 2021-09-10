package net.minecraft.realms;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.AnvilConverterException;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.SaveFormatComparator;

public class RealmsAnvilLevelStorageSource {
   private ISaveFormat levelStorageSource;

   public boolean isConvertible(String var1) {
      return this.levelStorageSource.isConvertible(var1);
   }

   public boolean isNewLevelIdAcceptable(String var1) {
      return this.levelStorageSource.isNewLevelIdAcceptable(var1);
   }

   public boolean convertLevel(String var1, IProgressUpdate var2) {
      return this.levelStorageSource.convertMapFormat(var1, var2);
   }

   public List<RealmsLevelSummary> getLevelList() throws AnvilConverterException {
      ArrayList var1 = Lists.newArrayList();
      Iterator var3 = this.levelStorageSource.getSaveList().iterator();

      while(var3.hasNext()) {
         SaveFormatComparator var2 = (SaveFormatComparator)var3.next();
         var1.add(new RealmsLevelSummary(var2));
      }

      return var1;
   }

   public void renameLevel(String var1, String var2) {
      this.levelStorageSource.renameWorld(var1, var2);
   }

   public boolean levelExists(String var1) {
      return this.levelStorageSource.canLoadWorld(var1);
   }

   public String getName() {
      return this.levelStorageSource.getName();
   }

   public boolean deleteLevel(String var1) {
      return this.levelStorageSource.deleteWorldDirectory(var1);
   }

   public RealmsAnvilLevelStorageSource(ISaveFormat var1) {
      this.levelStorageSource = var1;
   }

   public void clearAll() {
      this.levelStorageSource.flushCache();
   }

   public boolean requiresConversion(String var1) {
      return this.levelStorageSource.isOldMapFormat(var1);
   }
}
