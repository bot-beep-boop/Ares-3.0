package net.minecraft.world.storage;

import net.minecraft.world.WorldSettings;

public class SaveFormatComparator implements Comparable<SaveFormatComparator> {
   private final boolean cheatsEnabled;
   private final WorldSettings.GameType theEnumGameType;
   private final boolean requiresConversion;
   private final boolean hardcore;
   private final String displayName;
   private final String fileName;
   private final long sizeOnDisk;
   private final long lastTimePlayed;

   public String getFileName() {
      return this.fileName;
   }

   public long getLastTimePlayed() {
      return this.lastTimePlayed;
   }

   public long getSizeOnDisk() {
      return this.sizeOnDisk;
   }

   public SaveFormatComparator(String var1, String var2, long var3, long var5, WorldSettings.GameType var7, boolean var8, boolean var9, boolean var10) {
      this.fileName = var1;
      this.displayName = var2;
      this.lastTimePlayed = var3;
      this.sizeOnDisk = var5;
      this.theEnumGameType = var7;
      this.requiresConversion = var8;
      this.hardcore = var9;
      this.cheatsEnabled = var10;
   }

   public boolean isHardcoreModeEnabled() {
      return this.hardcore;
   }

   public int compareTo(Object var1) {
      return this.compareTo((SaveFormatComparator)var1);
   }

   public boolean getCheatsEnabled() {
      return this.cheatsEnabled;
   }

   public boolean requiresConversion() {
      return this.requiresConversion;
   }

   public int compareTo(SaveFormatComparator var1) {
      if (this.lastTimePlayed < var1.lastTimePlayed) {
         return 1;
      } else {
         return this.lastTimePlayed > var1.lastTimePlayed ? -1 : this.fileName.compareTo(var1.fileName);
      }
   }

   public WorldSettings.GameType getEnumGameType() {
      return this.theEnumGameType;
   }

   public String getDisplayName() {
      return this.displayName;
   }
}
