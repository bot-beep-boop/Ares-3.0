package net.java.games.input;

import java.io.IOException;

final class OSXHIDDeviceIterator {
   private final long iterator_address = nCreateIterator();

   private static final native long nCreateIterator();

   public OSXHIDDeviceIterator() throws IOException {
   }

   public final OSXHIDDevice next() throws IOException {
      return nNext(this.iterator_address);
   }

   private static final native OSXHIDDevice nNext(long var0) throws IOException;

   public final void close() {
      nReleaseIterator(this.iterator_address);
   }

   private static final native void nReleaseIterator(long var0);
}
