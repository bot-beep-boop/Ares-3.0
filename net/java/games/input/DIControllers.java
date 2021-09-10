package net.java.games.input;

import java.io.IOException;

final class DIControllers {
   private static final DIDeviceObjectData di_event = new DIDeviceObjectData();

   public static final float poll(Component var0, DIDeviceObject var1) throws IOException {
      int var2 = var1.getDevice().getPollData(var1);
      float var3;
      if (var1.isRelative()) {
         var3 = (float)var1.getRelativePollValue(var2);
      } else {
         var3 = (float)var2;
      }

      return var1.convertValue(var3);
   }

   public static final synchronized boolean getNextDeviceEvent(Event var0, IDirectInputDevice var1) throws IOException {
      if (!var1.getNextEvent(di_event)) {
         return false;
      } else {
         DIDeviceObject var2 = var1.mapEvent(di_event);
         DIComponent var3 = var1.mapObject(var2);
         if (var3 == null) {
            return false;
         } else {
            int var4;
            if (var2.isRelative()) {
               var4 = var2.getRelativeEventValue(di_event.getData());
            } else {
               var4 = di_event.getData();
            }

            var0.set(var3, var3.getDeviceObject().convertValue((float)var4), di_event.getNanos());
            return true;
         }
      }
   }
}
