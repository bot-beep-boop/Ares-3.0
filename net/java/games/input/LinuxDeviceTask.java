package net.java.games.input;

import java.io.IOException;

abstract class LinuxDeviceTask {
   public static final int FAILED = 3;
   public static final int COMPLETED = 2;
   private Object result;
   public static final int INPROGRESS = 1;
   private IOException exception;
   private int state = 1;

   protected abstract Object execute() throws IOException;

   public final IOException getException() {
      return this.exception;
   }

   public final int getState() {
      return this.state;
   }

   public final void doExecute() {
      try {
         this.result = this.execute();
         this.state = 2;
      } catch (IOException var2) {
         this.exception = var2;
         this.state = 3;
      }

   }

   public final Object getResult() {
      return this.result;
   }
}
