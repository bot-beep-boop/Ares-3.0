package net.java.games.input;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

final class RawInputEventQueue {
   private List devices;
   private final Object monitor = new Object();

   private static final void registerDevices(DummyWindow var0, RawDeviceInfo[] var1) throws IOException {
      nRegisterDevices(0, var0.getHwnd(), var1);
   }

   private final RawDevice lookupDevice(long var1) {
      for(int var3 = 0; var3 < this.devices.size(); ++var3) {
         RawDevice var4 = (RawDevice)this.devices.get(var3);
         if (var4.getHandle() == var1) {
            return var4;
         }
      }

      return null;
   }

   static List access$100(RawInputEventQueue var0) {
      return var0.devices;
   }

   static Object access$000(RawInputEventQueue var0) {
      return var0.monitor;
   }

   public final void start(List var1) throws IOException {
      this.devices = var1;
      RawInputEventQueue.QueueThread var2 = new RawInputEventQueue.QueueThread(this);
      synchronized(this.monitor) {
         var2.start();

         while(true) {
            if (var2.isInitialized()) {
               break;
            }

            try {
               this.monitor.wait();
            } catch (InterruptedException var6) {
            }
         }
      }

      if (var2.getException() != null) {
         throw var2.getException();
      }
   }

   private static final native void nRegisterDevices(int var0, long var1, RawDeviceInfo[] var3) throws IOException;

   static void access$200(DummyWindow var0, RawDeviceInfo[] var1) throws IOException {
      registerDevices(var0, var1);
   }

   static void access$300(RawInputEventQueue var0, DummyWindow var1) throws IOException {
      var0.poll(var1);
   }

   private final void addMouseEvent(long var1, long var3, int var5, int var6, int var7, long var8, long var10, long var12, long var14) {
      RawDevice var16 = this.lookupDevice(var1);
      if (var16 != null) {
         var16.addMouseEvent(var3, var5, var6, var7, var8, var10, var12, var14);
      }
   }

   private final native void nPoll(long var1) throws IOException;

   private final void poll(DummyWindow var1) throws IOException {
      this.nPoll(var1.getHwnd());
   }

   private final void addKeyboardEvent(long var1, long var3, int var5, int var6, int var7, int var8, long var9) {
      RawDevice var11 = this.lookupDevice(var1);
      if (var11 != null) {
         var11.addKeyboardEvent(var3, var5, var6, var7, var8, var9);
      }
   }

   private final class QueueThread extends Thread {
      private DummyWindow window;
      private final RawInputEventQueue this$0;
      private boolean initialized;
      private IOException exception;

      public final boolean isInitialized() {
         return this.initialized;
      }

      public final IOException getException() {
         return this.exception;
      }

      public QueueThread(RawInputEventQueue var1) {
         this.this$0 = var1;
         this.setDaemon(true);
      }

      public final void run() {
         try {
            this.window = new DummyWindow();
         } catch (IOException var10) {
            this.exception = var10;
         }

         this.initialized = true;
         synchronized(RawInputEventQueue.access$000(this.this$0)) {
            RawInputEventQueue.access$000(this.this$0).notify();
         }

         if (this.exception == null) {
            HashSet var1 = new HashSet();

            try {
               for(int var2 = 0; var2 < RawInputEventQueue.access$100(this.this$0).size(); ++var2) {
                  RawDevice var3 = (RawDevice)RawInputEventQueue.access$100(this.this$0).get(var2);
                  var1.add(var3.getInfo());
               }

               RawDeviceInfo[] var13 = new RawDeviceInfo[var1.size()];
               var1.toArray(var13);

               try {
                  RawInputEventQueue.access$200(this.window, var13);

                  while(!this.isInterrupted()) {
                     RawInputEventQueue.access$300(this.this$0, this.window);
                  }
               } finally {
                  this.window.destroy();
               }
            } catch (IOException var12) {
               this.exception = var12;
            }

         }
      }
   }
}
