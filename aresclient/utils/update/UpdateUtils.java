package com.aresclient.utils.update;

import java.io.File;
import java.io.IOException;

public class UpdateUtils {
   public static File updaterFile = new File("Ares/Updater.jar");
   public static String versionFromWeb = "3.null";

   public static String readFromWeb(String param0) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public UpdateUtils() {
      if (!updaterFile.getParentFile().exists()) {
         updaterFile.getParentFile().mkdirs();
         if (!updaterFile.exists()) {
            createUpdater();
         }
      }

   }

   public static void createUpdater() {
   }
}
