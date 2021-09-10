package net.java.games.input;

import java.io.IOException;

final class OSXHIDElement {
   private final OSXHIDDevice device;
   private final boolean is_relative;
   private final int max;
   private final UsagePair usage_pair;
   private final int min;
   private final ElementType element_type;
   private final Component.Identifier identifier;
   private final long element_cookie;

   final void getElementValue(OSXEvent var1) throws IOException {
      this.device.getElementValue(this.element_cookie, var1);
   }

   final boolean isRelative() {
      return this.is_relative && this.identifier instanceof Component.Identifier.Axis;
   }

   private final Component.Identifier computeIdentifier() {
      if (this.usage_pair.getUsagePage() == UsagePage.GENERIC_DESKTOP) {
         return ((GenericDesktopUsage)this.usage_pair.getUsage()).getIdentifier();
      } else if (this.usage_pair.getUsagePage() == UsagePage.BUTTON) {
         return ((ButtonUsage)this.usage_pair.getUsage()).getIdentifier();
      } else {
         return this.usage_pair.getUsagePage() == UsagePage.KEYBOARD_OR_KEYPAD ? ((KeyboardUsage)this.usage_pair.getUsage()).getIdentifier() : null;
      }
   }

   final long getCookie() {
      return this.element_cookie;
   }

   private UsagePair getUsagePair() {
      return this.usage_pair;
   }

   final Component.Identifier getIdentifier() {
      return this.identifier;
   }

   final boolean isAnalog() {
      return this.identifier instanceof Component.Identifier.Axis && this.identifier != Component.Identifier.Axis.POV;
   }

   public OSXHIDElement(OSXHIDDevice var1, UsagePair var2, long var3, ElementType var5, int var6, int var7, boolean var8) {
      this.device = var1;
      this.usage_pair = var2;
      this.element_cookie = var3;
      this.element_type = var5;
      this.min = var6;
      this.max = var7;
      this.identifier = this.computeIdentifier();
      this.is_relative = var8;
   }

   final float convertValue(float var1) {
      if (this.identifier == Component.Identifier.Axis.POV) {
         switch((int)var1) {
         case 0:
            return 0.25F;
         case 1:
            return 0.375F;
         case 2:
            return 0.5F;
         case 3:
            return 0.625F;
         case 4:
            return 0.75F;
         case 5:
            return 0.875F;
         case 6:
            return 1.0F;
         case 7:
            return 0.125F;
         case 8:
            return 0.0F;
         default:
            return 0.0F;
         }
      } else if (this.identifier instanceof Component.Identifier.Axis && !this.is_relative) {
         if (this.min == this.max) {
            return 0.0F;
         } else {
            if (var1 > (float)this.max) {
               var1 = (float)this.max;
            } else if (var1 < (float)this.min) {
               var1 = (float)this.min;
            }

            return 2.0F * (var1 - (float)this.min) / (float)(this.max - this.min) - 1.0F;
         }
      } else {
         return var1;
      }
   }

   final ElementType getType() {
      return this.element_type;
   }
}
