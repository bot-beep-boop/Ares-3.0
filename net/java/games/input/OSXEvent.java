package net.java.games.input;

class OSXEvent {
   private int value;
   private long type;
   private long nanos;
   private long cookie;

   public void set(long var1, long var3, int var5, long var6) {
      this.type = var1;
      this.cookie = var3;
      this.value = var5;
      this.nanos = var6;
   }

   public long getType() {
      return this.type;
   }

   public long getCookie() {
      return this.cookie;
   }

   public int getValue() {
      return this.value;
   }

   public long getNanos() {
      return this.nanos;
   }
}
