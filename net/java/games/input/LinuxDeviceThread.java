package net.java.games.input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class LinuxDeviceThread extends Thread {
   private final List tasks = new ArrayList();

   public LinuxDeviceThread() {
      this.setDaemon(true);
      this.start();
   }

   public final Object execute(LinuxDeviceTask var1) throws IOException {
      synchronized(this) {
         this.tasks.add(var1);
         this.notify();
      }

      synchronized(var1) {
         while(var1.getState() == 1) {
            try {
               var1.wait();
            } catch (InterruptedException var5) {
            }
         }
      }

      switch(var1.getState()) {
      case 2:
         return var1.getResult();
      case 3:
         throw var1.getException();
      default:
         throw new RuntimeException("Invalid task state: " + var1.getState());
      }
   }

   public final synchronized void run() {
      while(true) {
         if (!this.tasks.isEmpty()) {
            LinuxDeviceTask var1 = (LinuxDeviceTask)this.tasks.remove(0);
            var1.doExecute();
            synchronized(var1) {
               var1.notify();
            }
         } else {
            try {
               this.wait();
            } catch (InterruptedException var5) {
            }
         }
      }
   }
}
