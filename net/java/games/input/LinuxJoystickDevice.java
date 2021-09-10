package net.java.games.input;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

final class LinuxJoystickDevice implements LinuxDevice {
   private final byte[] axisMap;
   public static final int JS_EVENT_INIT = 128;
   private final LinuxJoystickEvent joystick_event = new LinuxJoystickEvent();
   private final Map povYs = new HashMap();
   private boolean closed;
   private final LinuxJoystickAxis[] axes;
   private final Map povXs = new HashMap();
   private EventQueue event_queue;
   public static final int JS_EVENT_BUTTON = 1;
   private final char[] buttonMap;
   private final String name;
   private final Event event = new Event();
   private final LinuxJoystickButton[] buttons;
   public static final int AXIS_MAX_VALUE = 32767;
   private final long fd;
   public static final int JS_EVENT_AXIS = 2;

   public final int getNumButtons() {
      return this.buttons.length;
   }

   public final void registerButton(int var1, LinuxJoystickButton var2) {
      this.buttons[var1] = var2;
   }

   public final void registerAxis(int var1, LinuxJoystickAxis var2) {
      this.axes[var1] = var2;
   }

   private final int getNumDeviceAxes() throws IOException {
      return nGetNumAxes(this.fd);
   }

   private final byte[] getDeviceAxisMap() throws IOException {
      return nGetAxisMap(this.fd);
   }

   public LinuxJoystickDevice(String var1) throws IOException {
      this.fd = nOpen(var1);

      try {
         this.name = this.getDeviceName();
         this.setBufferSize(32);
         this.buttons = new LinuxJoystickButton[this.getNumDeviceButtons()];
         this.axes = new LinuxJoystickAxis[this.getNumDeviceAxes()];
         this.axisMap = this.getDeviceAxisMap();
         this.buttonMap = this.getDeviceButtonMap();
      } catch (IOException var3) {
         this.close();
         throw var3;
      }
   }

   public final synchronized void poll() throws IOException {
      this.checkClosed();

      while(this.getNextDeviceEvent(this.joystick_event)) {
         this.processEvent(this.joystick_event);
      }

   }

   public final String getName() {
      return this.name;
   }

   private static final native int nGetNumButtons(long var0) throws IOException;

   protected void finalize() throws IOException {
      this.close();
   }

   private final String getDeviceName() throws IOException {
      return nGetName(this.fd);
   }

   private static final native int nGetVersion(long var0) throws IOException;

   public final synchronized void close() throws IOException {
      if (!this.closed) {
         this.closed = true;
         nClose(this.fd);
      }

   }

   private final void processEvent(LinuxJoystickEvent var1) {
      int var2 = var1.getNumber();
      int var3 = var1.getType() & -129;
      float var5;
      switch(var3) {
      case 1:
         if (var2 >= this.getNumButtons()) {
            return;
         }

         LinuxJoystickButton var7 = this.buttons[var2];
         if (var7 == null) {
            return;
         }

         var5 = (float)var1.getValue();
         var7.setValue(var5);
         this.event.set(var7, var5, var1.getNanos());
         break;
      case 2:
         if (var2 >= this.getNumAxes()) {
            return;
         }

         LinuxJoystickAxis var4 = this.axes[var2];
         if (var4 == null) {
            return;
         }

         var5 = (float)var1.getValue() / 32767.0F;
         var4.setValue(var5);
         LinuxJoystickPOV var6;
         if (this.povXs.containsKey(new Integer(var2))) {
            var6 = (LinuxJoystickPOV)((LinuxJoystickPOV)this.povXs.get(new Integer(var2)));
            var6.updateValue();
            this.event.set(var6, var6.getPollData(), var1.getNanos());
         } else if (this.povYs.containsKey(new Integer(var2))) {
            var6 = (LinuxJoystickPOV)((LinuxJoystickPOV)this.povYs.get(new Integer(var2)));
            var6.updateValue();
            this.event.set(var6, var6.getPollData(), var1.getNanos());
         } else {
            this.event.set(var4, var5, var1.getNanos());
         }
         break;
      default:
         return;
      }

      if (!this.event_queue.isFull()) {
         this.event_queue.add(this.event);
      }

   }

   public final synchronized boolean getNextEvent(Event var1) throws IOException {
      return this.event_queue.getNextEvent(var1);
   }

   private final boolean getNextDeviceEvent(LinuxJoystickEvent var1) throws IOException {
      return nGetNextEvent(this.fd, var1);
   }

   private final void checkClosed() throws IOException {
      if (this.closed) {
         throw new IOException("Device is closed");
      }
   }

   private static final native String nGetName(long var0) throws IOException;

   private static final native byte[] nGetAxisMap(long var0) throws IOException;

   private static final native boolean nGetNextEvent(long var0, LinuxJoystickEvent var2) throws IOException;

   public final void registerPOV(LinuxJoystickPOV var1) {
      LinuxJoystickAxis var2 = var1.getYAxis();
      LinuxJoystickAxis var3 = var1.getXAxis();

      int var4;
      for(var4 = 0; var4 < this.axes.length && this.axes[var4] != var2; ++var4) {
      }

      int var5;
      for(var5 = 0; var5 < this.axes.length && this.axes[var5] != var3; ++var5) {
      }

      this.povXs.put(new Integer(var4), var1);
      this.povYs.put(new Integer(var5), var1);
   }

   public final int getNumAxes() {
      return this.axes.length;
   }

   private static final native long nOpen(String var0) throws IOException;

   private static final native char[] nGetButtonMap(long var0) throws IOException;

   private static final native void nClose(long var0) throws IOException;

   public final byte[] getAxisMap() {
      return this.axisMap;
   }

   private final int getNumDeviceButtons() throws IOException {
      return nGetNumButtons(this.fd);
   }

   private final char[] getDeviceButtonMap() throws IOException {
      return nGetButtonMap(this.fd);
   }

   public final synchronized void setBufferSize(int var1) {
      this.event_queue = new EventQueue(var1);
   }

   private static final native int nGetNumAxes(long var0) throws IOException;

   private final int getVersion() throws IOException {
      return nGetVersion(this.fd);
   }

   public final char[] getButtonMap() {
      return this.buttonMap;
   }
}
