package net.optifine.shaders.config;

import java.util.Arrays;
import java.util.List;
import net.minecraft.src.Config;
import net.optifine.shaders.Shaders;
import net.optifine.util.StrUtils;

public abstract class ShaderOption {
   public static final String COLOR_BLUE = "§9";
   private boolean enabled = true;
   public static final String COLOR_RED = "§c";
   private boolean visible = true;
   private String[] values = null;
   private String valueDefault = null;
   private String description = null;
   private String[] paths = null;
   private String value = null;
   public static final String COLOR_GREEN = "§a";
   private String name = null;

   public boolean isVisible() {
      return this.visible;
   }

   public String[] getValues() {
      return (String[])this.values.clone();
   }

   public String getValue() {
      return this.value;
   }

   public void setEnabled(boolean var1) {
      this.enabled = var1;
   }

   public boolean setValue(String var1) {
      int var2 = getIndex(var1, this.values);
      if (var2 < 0) {
         return false;
      } else {
         this.value = var1;
         return true;
      }
   }

   public boolean isUsedInLine(String var1) {
      return false;
   }

   public boolean isEnabled() {
      return this.enabled;
   }

   public String getName() {
      return this.name;
   }

   public String getNameText() {
      return Shaders.translate("option." + this.name, this.name);
   }

   public String getDescriptionText() {
      String var1 = Config.normalize(this.description);
      var1 = StrUtils.removePrefix(var1, "//");
      var1 = Shaders.translate("option." + this.getName() + ".comment", var1);
      return var1;
   }

   public void prevValue() {
      int var1 = getIndex(this.value, this.values);
      if (var1 >= 0) {
         var1 = (var1 - 1 + this.values.length) % this.values.length;
         this.value = this.values[var1];
      }

   }

   public boolean isChanged() {
      return !Config.equals(this.value, this.valueDefault);
   }

   public String[] getPaths() {
      return this.paths;
   }

   public void addPaths(String[] var1) {
      List var2 = Arrays.asList(this.paths);

      for(int var3 = 0; var3 < var1.length; ++var3) {
         String var4 = var1[var3];
         if (!var2.contains(var4)) {
            this.paths = (String[])Config.addObjectToArray(this.paths, var4);
         }
      }

   }

   public void nextValue() {
      int var1 = getIndex(this.value, this.values);
      if (var1 >= 0) {
         var1 = (var1 + 1) % this.values.length;
         this.value = this.values[var1];
      }

   }

   public String getValueColor(String var1) {
      return "";
   }

   private static int getIndex(String var0, String[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         String var3 = var1[var2];
         if (var3.equals(var0)) {
            return var2;
         }
      }

      return -1;
   }

   public String getValueDefault() {
      return this.valueDefault;
   }

   public boolean checkUsed() {
      return false;
   }

   public String getSourceLine() {
      return null;
   }

   public String getDescription() {
      return this.description;
   }

   public boolean isValidValue(String var1) {
      return getIndex(var1, this.values) >= 0;
   }

   public String toString() {
      return this.name + ", value: " + this.value + ", valueDefault: " + this.valueDefault + ", paths: " + Config.arrayToString((Object[])this.paths);
   }

   public boolean matchesLine(String var1) {
      return false;
   }

   public void setDescription(String var1) {
      this.description = var1;
   }

   public void resetValue() {
      this.value = this.valueDefault;
   }

   public String getValueText(String var1) {
      return Shaders.translate("value." + this.name + "." + var1, var1);
   }

   public void setVisible(boolean var1) {
      this.visible = var1;
   }

   public float getIndexNormalized() {
      if (this.values.length <= 1) {
         return 0.0F;
      } else {
         int var1 = getIndex(this.value, this.values);
         if (var1 < 0) {
            return 0.0F;
         } else {
            float var2 = 1.0F * (float)var1 / ((float)this.values.length - 1.0F);
            return var2;
         }
      }
   }

   public ShaderOption(String var1, String var2, String var3, String[] var4, String var5, String var6) {
      this.name = var1;
      this.description = var2;
      this.value = var3;
      this.values = var4;
      this.valueDefault = var5;
      if (var6 != null) {
         this.paths = new String[]{var6};
      }

   }

   public void setIndexNormalized(float var1) {
      if (this.values.length > 1) {
         var1 = Config.limit(var1, 0.0F, 1.0F);
         int var2 = Math.round(var1 * (float)(this.values.length - 1));
         this.value = this.values[var2];
      }

   }
}
