package net.java.games.input;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

final class OSXHIDQueue {
   private boolean released;
   private final Map map = new HashMap();
   private final long queue_address;

   private final void close() throws IOException {
      nClose(this.queue_address);
   }

   private static final native void nOpen(long var0, int var2) throws IOException;

   private final void open(int var1) throws IOException {
      nOpen(this.queue_address, var1);
   }

   private static final native void nAddElement(long var0, long var2) throws IOException;

   public final synchronized void setQueueDepth(int var1) throws IOException {
      this.checkReleased();
      this.stop();
      this.close();
      this.createQueue(var1);
   }

   private static final native void nStart(long var0) throws IOException;

   private static final native void nClose(long var0) throws IOException;

   private final void stop() throws IOException {
      nStop(this.queue_address);
   }

   private static final native void nRemoveElement(long var0, long var2) throws IOException;

   private final void createQueue(int var1) throws IOException {
      this.open(var1);

      try {
         this.start();
      } catch (IOException var3) {
         this.close();
         throw var3;
      }
   }

   public final synchronized boolean getNextEvent(OSXEvent var1) throws IOException {
      this.checkReleased();
      return nGetNextEvent(this.queue_address, var1);
   }

   private static final native boolean nGetNextEvent(long var0, OSXEvent var2) throws IOException;

   private static final native void nReleaseQueue(long var0) throws IOException;

   public final void addElement(OSXHIDElement var1, OSXComponent var2) throws IOException {
      nAddElement(this.queue_address, var1.getCookie());
      this.map.put(new Long(var1.getCookie()), var2);
   }

   public final OSXComponent mapEvent(OSXEvent var1) {
      return (OSXComponent)this.map.get(new Long(var1.getCookie()));
   }

   private final void start() throws IOException {
      nStart(this.queue_address);
   }

   public final void removeElement(OSXHIDElement var1) throws IOException {
      nRemoveElement(this.queue_address, var1.getCookie());
      this.map.remove(new Long(var1.getCookie()));
   }

   private static final native void nStop(long var0) throws IOException;

   public final synchronized void release() throws IOException {
      if (!this.released) {
         this.released = true;

         try {
            this.stop();
            this.close();
         } finally {
            nReleaseQueue(this.queue_address);
         }
      }

   }

   private final void checkReleased() throws IOException {
      if (this.released) {
         throw new IOException("Queue is released");
      }
   }

   public OSXHIDQueue(long var1, int var3) throws IOException {
      this.queue_address = var1;

      try {
         this.createQueue(var3);
      } catch (IOException var5) {
         this.release();
         throw var5;
      }
   }
}
