package net.java.games.input;

import java.io.IOException;

final class IDirectInputEffect implements Rumbler {
   private final long address;
   private boolean released;
   private final DIEffectInfo info;

   private final void stop() throws IOException {
      int var1 = nStop(this.address);
      if (var1 != 0) {
         throw new IOException("Failed to stop effect (0x" + Integer.toHexString(var1) + ")");
      }
   }

   private static final native int nStop(long var0);

   private static final native int nSetGain(long var0, int var2);

   private static final native int nStart(long var0, int var2, int var3);

   private static final native void nRelease(long var0);

   private final void setGain(int var1) throws IOException {
      int var2 = nSetGain(this.address, var1);
      if (var2 != 3 && var2 != 4 && var2 != 0 && var2 != 8 && var2 != 12) {
         throw new IOException("Failed to set effect gain (0x" + Integer.toHexString(var2) + ")");
      }
   }

   protected void finalize() {
      this.release();
   }

   public IDirectInputEffect(long var1, DIEffectInfo var3) {
      this.address = var1;
      this.info = var3;
   }

   public final String getAxisName() {
      return null;
   }

   public final Component.Identifier getAxisIdentifier() {
      return null;
   }

   public final synchronized void release() {
      if (!this.released) {
         this.released = true;
         nRelease(this.address);
      }

   }

   public final synchronized void rumble(float var1) {
      try {
         this.checkReleased();
         if (var1 > 0.0F) {
            int var2 = Math.round(var1 * 10000.0F);
            this.setGain(var2);
            this.start(1, 0);
         } else {
            this.stop();
         }
      } catch (IOException var3) {
         DirectInputEnvironmentPlugin.logln("Failed to set rumbler gain: " + var3.getMessage());
      }

   }

   private final void checkReleased() throws IOException {
      if (this.released) {
         throw new IOException();
      }
   }

   private final void start(int var1, int var2) throws IOException {
      int var3 = nStart(this.address, var1, var2);
      if (var3 != 0) {
         throw new IOException("Failed to start effect (0x" + Integer.toHexString(var3) + ")");
      }
   }
}
