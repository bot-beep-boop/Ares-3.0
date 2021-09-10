package net.minecraft.world.storage;

import java.util.List;
import net.minecraft.client.AnvilConverterException;
import net.minecraft.util.IProgressUpdate;

public interface ISaveFormat {
   boolean isOldMapFormat(String var1);

   ISaveHandler getSaveLoader(String var1, boolean var2);

   boolean canLoadWorld(String var1);

   WorldInfo getWorldInfo(String var1);

   void renameWorld(String var1, String var2);

   boolean convertMapFormat(String var1, IProgressUpdate var2);

   boolean isNewLevelIdAcceptable(String var1);

   boolean isConvertible(String var1);

   String getName();

   boolean deleteWorldDirectory(String var1);

   List<SaveFormatComparator> getSaveList() throws AnvilConverterException;

   void flushCache();
}
