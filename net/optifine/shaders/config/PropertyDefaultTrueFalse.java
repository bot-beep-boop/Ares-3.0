package net.optifine.shaders.config;

import net.optifine.Lang;

public class PropertyDefaultTrueFalse extends Property {
   public static final String[] PROPERTY_VALUES = new String[]{"default", "true", "false"};
   public static final String[] USER_VALUES = new String[]{"Default", "ON", "OFF"};

   public boolean isFalse() {
      return this.getValue() == 2;
   }

   public PropertyDefaultTrueFalse(String var1, String var2, int var3) {
      super(var1, PROPERTY_VALUES, var2, USER_VALUES, var3);
   }

   public boolean isDefault() {
      return this.getValue() == 0;
   }

   public String getUserValue() {
      if (this.isDefault()) {
         return Lang.getDefault();
      } else if (this.isTrue()) {
         return Lang.getOn();
      } else {
         return this.isFalse() ? Lang.getOff() : super.getUserValue();
      }
   }

   public boolean isTrue() {
      return this.getValue() == 1;
   }
}
