package com.aresclient.utils.update;

import com.aresclient.Ares;
import java.io.IOException;

public class Updater {
   public static boolean IsUptoday;

   public static void checkUpdate() {
      try {
         UpdateUtils.versionFromWeb = UpdateUtils.readFromWeb("http://dl.aresclient.com/client/version");
      } catch (IOException var1) {
         var1.printStackTrace();
      }

      if (Ares.getData().clientVersion.equalsIgnoreCase(UpdateUtils.versionFromWeb)) {
         IsUptoday = true;
      } else {
         IsUptoday = false;
      }

   }
}
