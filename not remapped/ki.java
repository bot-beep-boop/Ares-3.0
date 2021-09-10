public final class ki extends RuntimeException {
   public static final ki a = new ki();

   public synchronized Throwable fillInStackTrace() {
      this.setStackTrace(new StackTraceElement[0]);
      return this;
   }

   private ki() {
      this.setStackTrace(new StackTraceElement[0]);
   }
}
