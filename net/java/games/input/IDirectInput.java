package net.java.games.input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class IDirectInput {
   private final long idirectinput_address;
   private final DummyWindow window;
   private final List devices = new ArrayList();

   private static final native void nRelease(long var0);

   private final native void nEnumDevices(long var1) throws IOException;

   public IDirectInput(DummyWindow var1) throws IOException {
      this.window = var1;
      this.idirectinput_address = createIDirectInput();

      try {
         this.enumDevices();
      } catch (IOException var3) {
         this.releaseDevices();
         this.release();
         throw var3;
      }
   }

   private static final native long createIDirectInput() throws IOException;

   public final void release() {
      nRelease(this.idirectinput_address);
   }

   public final List getDevices() {
      return this.devices;
   }

   private final void addDevice(long var1, byte[] var3, byte[] var4, int var5, int var6, String var7, String var8) throws IOException {
      try {
         IDirectInputDevice var9 = new IDirectInputDevice(this.window, var1, var3, var4, var5, var6, var7, var8);
         this.devices.add(var9);
      } catch (IOException var10) {
         DirectInputEnvironmentPlugin.logln("Failed to initialize device " + var8 + " because of: " + var10);
      }

   }

   public final void releaseDevices() {
      for(int var1 = 0; var1 < this.devices.size(); ++var1) {
         IDirectInputDevice var2 = (IDirectInputDevice)this.devices.get(var1);
         var2.release();
      }

   }

   private final void enumDevices() throws IOException {
      this.nEnumDevices(this.idirectinput_address);
   }
}
