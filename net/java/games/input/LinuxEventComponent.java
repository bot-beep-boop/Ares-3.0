package net.java.games.input;

import java.io.IOException;

final class LinuxEventComponent {
   private final int max;
   static final boolean $assertionsDisabled;
   private final LinuxAxisDescriptor descriptor;
   private final boolean is_relative;
   private final int min;
   private final LinuxEventDevice device;
   private final Component.Identifier identifier;
   private final Controller.Type button_trait;
   static Class class$net$java$games$input$LinuxEventComponent;
   private final int flat;

   public final boolean isRelative() {
      return this.is_relative;
   }

   public final Controller.Type getButtonTrait() {
      return this.button_trait;
   }

   public final void getAbsInfo(LinuxAbsInfo var1) throws IOException {
      if (!$assertionsDisabled && this.descriptor.getType() != 3) {
         throw new AssertionError();
      } else {
         this.device.getAbsInfo(this.descriptor.getCode(), var1);
      }
   }

   public LinuxEventComponent(LinuxEventDevice var1, Component.Identifier var2, boolean var3, int var4, int var5) throws IOException {
      this.device = var1;
      this.identifier = var2;
      if (var4 == 1) {
         this.button_trait = LinuxNativeTypesMap.guessButtonTrait(var5);
      } else {
         this.button_trait = Controller.Type.UNKNOWN;
      }

      this.is_relative = var3;
      this.descriptor = new LinuxAxisDescriptor();
      this.descriptor.set(var4, var5);
      if (var4 == 3) {
         LinuxAbsInfo var6 = new LinuxAbsInfo();
         this.getAbsInfo(var6);
         this.min = var6.getMin();
         this.max = var6.getMax();
         this.flat = var6.getFlat();
      } else {
         this.min = Integer.MIN_VALUE;
         this.max = Integer.MAX_VALUE;
         this.flat = 0;
      }

   }

   final float convertValue(float var1) {
      if (this.identifier instanceof Component.Identifier.Axis && !this.is_relative) {
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

   public final Component.Identifier getIdentifier() {
      return this.identifier;
   }

   public final LinuxAxisDescriptor getDescriptor() {
      return this.descriptor;
   }

   public final boolean isAnalog() {
      return this.identifier instanceof Component.Identifier.Axis && this.identifier != Component.Identifier.Axis.POV;
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw (new NoClassDefFoundError()).initCause(var2);
      }
   }

   public final LinuxEventDevice getDevice() {
      return this.device;
   }

   static {
      $assertionsDisabled = !(class$net$java$games$input$LinuxEventComponent == null ? (class$net$java$games$input$LinuxEventComponent = class$("net.java.games.input.LinuxEventComponent")) : class$net$java$games$input$LinuxEventComponent).desiredAssertionStatus();
   }

   final float getDeadZone() {
      return (float)this.flat / (2.0F * (float)(this.max - this.min));
   }
}
