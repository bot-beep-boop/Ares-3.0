package net.java.games.input;

import java.util.ArrayList;

public class WinTabContext {
   private long hCTX;
   private DummyWindow window;
   private Controller[] controllers;

   public Controller[] getControllers() {
      if (this.hCTX == 0L) {
         throw new IllegalStateException("Context must be open before getting the controllers");
      } else {
         return this.controllers;
      }
   }

   private static final native WinTabPacket[] nGetPackets(long var0);

   public synchronized void processEvents() {
      WinTabPacket[] var1 = nGetPackets(this.hCTX);

      for(int var2 = 0; var2 < var1.length; ++var2) {
         ((WinTabDevice)((WinTabDevice)this.getControllers()[0])).processPacket(var1[var2]);
      }

   }

   public synchronized void open() {
      this.hCTX = nOpen(this.window.getHwnd());
      ArrayList var1 = new ArrayList();
      int var2 = nGetNumberOfSupportedDevices();

      for(int var3 = 0; var3 < var2; ++var3) {
         WinTabDevice var4 = WinTabDevice.createDevice(this, var3);
         if (var4 != null) {
            var1.add(var4);
         }
      }

      this.controllers = (Controller[])((Controller[])var1.toArray(new Controller[0]));
   }

   private static final native void nClose(long var0);

   public synchronized void close() {
      nClose(this.hCTX);
   }

   private static final native int nGetNumberOfSupportedDevices();

   public WinTabContext(DummyWindow var1) {
      this.window = var1;
   }

   private static final native long nOpen(long var0);
}
