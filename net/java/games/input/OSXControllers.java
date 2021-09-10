package net.java.games.input;

import java.io.IOException;

final class OSXControllers {
   private static final OSXEvent osx_event = new OSXEvent();

   public static final synchronized boolean getNextDeviceEvent(Event var0, OSXHIDQueue var1) throws IOException {
      if (var1.getNextEvent(osx_event)) {
         OSXComponent var2 = var1.mapEvent(osx_event);
         var0.set(var2, var2.getElement().convertValue((float)osx_event.getValue()), osx_event.getNanos());
         return true;
      } else {
         return false;
      }
   }

   public static final synchronized float poll(OSXHIDElement var0) throws IOException {
      var0.getElementValue(osx_event);
      return var0.convertValue((float)osx_event.getValue());
   }
}
