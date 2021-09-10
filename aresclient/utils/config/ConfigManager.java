package com.aresclient.utils.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.commons.io.IOUtils;

public class ConfigManager {
   public static File configFile = new File("Ares/Ares.json");
   public static Config settings;
   public static boolean loaded = false;

   public static void save() throws FileNotFoundException {
      if (settings != null) {
         if (!configFile.exists()) {
            loadProperties(true);
         }

         GsonBuilder var0 = new GsonBuilder();
         Gson var1 = var0.setPrettyPrinting().create();
         PrintWriter var2 = new PrintWriter(new FileOutputStream(configFile));
         var2.print(var1.toJson(settings));
         var2.flush();
         var2.close();
      }

   }

   public static void loadProperties(boolean var0) {
      try {
         loaded = true;
         String var1 = "{}";

         try {
            if (!configFile.exists()) {
               configFile.getParentFile().mkdir();
               configFile.createNewFile();
               var1 = (new Gson()).toJson(new Config());
            } else {
               var1 = IOUtils.toString(new FileInputStream(configFile));
               var1 = var1.replace("§cl", "§cf").replace("§ck", "§cf").replace("§cm", "§cf").replace("§cn", "§cf").replace("§cr", "§cf").replace("Â", "");
            }
         } catch (IOException var3) {
            var3.printStackTrace();
            if (var0) {
               delete();
            }

            return;
         }

         if ((Config)(new Gson()).fromJson(var1, Config.class) == null) {
            var1 = (new Gson()).toJson(new Config());
         }

         settings = (Config)(new Gson()).fromJson(var1, Config.class);
         if (settings == null && var0) {
            delete();
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         if (var0) {
            delete();
         }
      }

   }

   private static void delete() {
      System.out.println("Settings could not be loaded.");
      if (configFile.exists()) {
         System.out.println("Delete broken config file..");
         settings = (Config)(new Gson()).fromJson((new Gson()).toJson(new Config()), Config.class);

         try {
            save();
         } catch (FileNotFoundException var1) {
            var1.printStackTrace();
         }
      } else {
         System.out.println("Can't delete the config file?! @ " + configFile.getAbsolutePath());
      }

      loadProperties(false);
   }
}
