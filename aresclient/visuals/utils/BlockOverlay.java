package com.aresclient.visuals.utils;

import com.aresclient.utils.config.Config;

public class BlockOverlay {
   public static void SetDefault() {
      Config.red = 0.0F;
      Config.green = 0.0F;
      Config.blue = 0.0F;
      Config.thickness = 2.0F;
   }

   public static void SetPurple() {
      Config.red = 7.0F;
      Config.green = 0.0F;
      Config.blue = 0.9F;
      Config.thickness = 4.0F;
   }

   public static void SetRed() {
      Config.red = 0.9F;
      Config.green = 0.32F;
      Config.blue = 0.25F;
      Config.thickness = 4.0F;
   }

   public static void SetOrange() {
      Config.red = 0.92156F;
      Config.green = 0.5373F;
      Config.blue = 0.239F;
      Config.thickness = 4.0F;
   }

   public static void SetBlue() {
      Config.red = 0.0F;
      Config.green = 0.4F;
      Config.blue = 1.0F;
      Config.thickness = 4.0F;
   }

   public static void SetGreen() {
      Config.red = 0.0F;
      Config.green = 0.8F;
      Config.blue = 0.2F;
      Config.thickness = 4.0F;
   }
}
