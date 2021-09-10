package net.java.games.input;

import java.io.IOException;

final class LinuxControllers {
   private static final LinuxEvent linux_event = new LinuxEvent();
   private static final LinuxAbsInfo abs_info = new LinuxAbsInfo();

   public static final synchronized boolean getNextDeviceEvent(Event var0, LinuxEventDevice var1) throws IOException {
      while(true) {
         if (var1.getNextEvent(linux_event)) {
            LinuxAxisDescriptor var2 = linux_event.getDescriptor();
            LinuxComponent var3 = var1.mapDescriptor(var2);
            if (var3 == null) {
               continue;
            }

            float var4 = var3.convertValue((float)linux_event.getValue(), var2);
            var0.set(var3, var4, linux_event.getNanos());
            return true;
         }

         return false;
      }
   }

   public static final synchronized float poll(LinuxEventComponent var0) throws IOException {
      int var1 = var0.getDescriptor().getType();
      switch(var1) {
      case 1:
         int var2 = var0.getDescriptor().getCode();
         float var3 = var0.getDevice().isKeySet(var2) ? 1.0F : 0.0F;
         return var3;
      case 3:
         var0.getAbsInfo(abs_info);
         return (float)abs_info.getValue();
      default:
         throw new RuntimeException("Unkown native_type: " + var1);
      }
   }
}
