package net.java.games.input;

import java.io.IOException;

public abstract class AbstractComponent implements Component {
   private float value;
   private boolean has_polled;
   private float event_value;
   private final Component.Identifier id;
   private final String name;

   public final float getPollData() {
      if (!this.has_polled && !this.isRelative()) {
         this.has_polled = true;

         try {
            this.setPollData(this.poll());
         } catch (IOException var2) {
            ControllerEnvironment.log("Failed to poll component: " + var2);
         }
      }

      return this.value;
   }

   protected AbstractComponent(String var1, Component.Identifier var2) {
      this.name = var1;
      this.id = var2;
   }

   final void setPollData(float var1) {
      this.value = var1;
   }

   public Component.Identifier getIdentifier() {
      return this.id;
   }

   public String toString() {
      return this.name;
   }

   final float getEventValue() {
      return this.event_value;
   }

   protected abstract float poll() throws IOException;

   final void resetHasPolled() {
      this.has_polled = false;
   }

   public boolean isAnalog() {
      return false;
   }

   public float getDeadZone() {
      return 0.0F;
   }

   final void setEventValue(float var1) {
      this.event_value = var1;
   }

   public String getName() {
      return this.name;
   }
}
