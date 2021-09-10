package com.aresclient.visuals.hud.base;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileManager {
   private static Gson gson = new Gson();
   private static File ROOT_DIR = new File("AresFolder");
   private static File MODS_DIR;

   static {
      MODS_DIR = new File(ROOT_DIR, "Mods");
   }

   public static void init() {
      if (!ROOT_DIR.exists()) {
         ROOT_DIR.mkdirs();
      }

      if (!MODS_DIR.exists()) {
         MODS_DIR.mkdirs();
      }

   }

   public static Gson getGson() {
      return gson;
   }

   public static File getModsDirectory() {
      return MODS_DIR;
   }

   public static boolean writeJsonToFile(File var0, Object var1) {
      try {
         if (!var0.exists()) {
            var0.createNewFile();
         }

         FileOutputStream var2 = new FileOutputStream(var0);
         var2.write(gson.toJson(var1).getBytes());
         var2.flush();
         var2.close();
         return true;
      } catch (IOException var3) {
         var3.printStackTrace();
         return false;
      }
   }

   public static <T> T readFromJson(File var0, Class<T> var1) {
      try {
         FileInputStream var2 = new FileInputStream(var0);
         InputStreamReader var3 = new InputStreamReader(var2);
         BufferedReader var4 = new BufferedReader(var3);
         StringBuilder var5 = new StringBuilder();

         String var6;
         while((var6 = var4.readLine()) != null) {
            var5.append(var6);
         }

         var4.close();
         var3.close();
         var2.close();
         return gson.fromJson(var5.toString(), var1);
      } catch (IOException var7) {
         var7.printStackTrace();
         return null;
      }
   }
}
