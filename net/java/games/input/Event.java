package net.java.games.input;

public final class Event {
   private long nanos;
   private Component component;
   private float value;

   public final Component getComponent() {
      return this.component;
   }

   public final void set(Event var1) {
      this.set(var1.getComponent(), var1.getValue(), var1.getNanos());
   }

   public final float getValue() {
      return this.value;
   }

   public final String toString() {
      return "Event: component = " + this.component + " | value = " + this.value;
   }

   public final long getNanos() {
      return this.nanos;
   }

   public final void set(Component var1, float var2, long var3) {
      this.component = var1;
      this.value = var2;
      this.nanos = var3;
   }
}
