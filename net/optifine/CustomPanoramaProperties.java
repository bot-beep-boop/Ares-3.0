package net.optifine;

import java.util.Properties;
import net.minecraft.util.ResourceLocation;
import net.optifine.config.ConnectedParser;

public class CustomPanoramaProperties {
   private int overlay2Top = 0;
   private int blur3 = 3;
   private int blur2 = 3;
   private int overlay2Bottom = Integer.MIN_VALUE;
   private int overlay1Bottom = 16777215;
   private ResourceLocation[] panoramaLocations;
   private int weight = 1;
   private String path;
   private int blur1 = 64;
   private int overlay1Top = -2130706433;

   public ResourceLocation[] getPanoramaLocations() {
      return this.panoramaLocations;
   }

   public int getOverlay1Top() {
      return this.overlay1Top;
   }

   public int getWeight() {
      return this.weight;
   }

   public String toString() {
      return this.path + ", weight: " + this.weight + ", blur: " + this.blur1 + " " + this.blur2 + " " + this.blur3 + ", overlay: " + this.overlay1Top + " " + this.overlay1Bottom + " " + this.overlay2Top + " " + this.overlay2Bottom;
   }

   public CustomPanoramaProperties(String var1, Properties var2) {
      ConnectedParser var3 = new ConnectedParser("CustomPanorama");
      this.path = var1;
      this.panoramaLocations = new ResourceLocation[6];

      for(int var4 = 0; var4 < this.panoramaLocations.length; ++var4) {
         this.panoramaLocations[var4] = new ResourceLocation(var1 + "/panorama_" + var4 + ".png");
      }

      this.weight = var3.parseInt(var2.getProperty("weight"), 1);
      this.blur1 = var3.parseInt(var2.getProperty("blur1"), 64);
      this.blur2 = var3.parseInt(var2.getProperty("blur2"), 3);
      this.blur3 = var3.parseInt(var2.getProperty("blur3"), 3);
      this.overlay1Top = ConnectedParser.parseColor4(var2.getProperty("overlay1.top"), -2130706433);
      this.overlay1Bottom = ConnectedParser.parseColor4(var2.getProperty("overlay1.bottom"), 16777215);
      this.overlay2Top = ConnectedParser.parseColor4(var2.getProperty("overlay2.top"), 0);
      this.overlay2Bottom = ConnectedParser.parseColor4(var2.getProperty("overlay2.bottom"), Integer.MIN_VALUE);
   }

   public int getBlur2() {
      return this.blur2;
   }

   public int getOverlay1Bottom() {
      return this.overlay1Bottom;
   }

   public int getOverlay2Top() {
      return this.overlay2Top;
   }

   public int getBlur3() {
      return this.blur3;
   }

   public int getOverlay2Bottom() {
      return this.overlay2Bottom;
   }

   public int getBlur1() {
      return this.blur1;
   }
}
