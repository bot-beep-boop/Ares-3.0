package net.java.games.input;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractController implements Controller {
   private final String name;
   private final Component[] components;
   private final Map id_to_components = new HashMap();
   static final int EVENT_QUEUE_DEPTH = 32;
   private final Controller[] children;
   private EventQueue event_queue = new EventQueue(32);
   private static final Event event = new Event();
   private final Rumbler[] rumblers;

   protected void setDeviceEventQueueSize(int var1) throws IOException {
   }

   public int getPortNumber() {
      return 0;
   }

   protected AbstractController(String var1, Component[] var2, Controller[] var3, Rumbler[] var4) {
      this.name = var1;
      this.components = var2;
      this.children = var3;
      this.rumblers = var4;

      for(int var5 = var2.length - 1; var5 >= 0; --var5) {
         this.id_to_components.put(var2[var5].getIdentifier(), var2[var5]);
      }

   }

   public final Component getComponent(Component.Identifier var1) {
      return (Component)this.id_to_components.get(var1);
   }

   public final Component[] getComponents() {
      return this.components;
   }

   public Controller.Type getType() {
      return Controller.Type.UNKNOWN;
   }

   public final EventQueue getEventQueue() {
      return this.event_queue;
   }

   public synchronized boolean poll() {
      Component[] var1 = this.getComponents();

      try {
         this.pollDevice();

         for(int var2 = 0; var2 < var1.length; ++var2) {
            AbstractComponent var3 = (AbstractComponent)var1[var2];
            if (var3.isRelative()) {
               var3.setPollData(0.0F);
            } else {
               var3.resetHasPolled();
            }
         }

         while(true) {
            while(true) {
               if (!this.getNextDeviceEvent(event)) {
                  return true;
               }

               AbstractComponent var5 = (AbstractComponent)event.getComponent();
               float var6 = event.getValue();
               if (var5.isRelative()) {
                  if (var6 != 0.0F) {
                     var5.setPollData(var5.getPollData() + var6);
                     break;
                  }
               } else if (var6 != var5.getEventValue()) {
                  var5.setEventValue(var6);
                  break;
               }
            }

            if (!this.event_queue.isFull()) {
               this.event_queue.add(event);
            }
         }
      } catch (IOException var4) {
         ControllerEnvironment.logln("Failed to poll device: " + var4.getMessage());
         return false;
      }
   }

   public final Controller[] getControllers() {
      return this.children;
   }

   protected void pollDevice() throws IOException {
   }

   public String toString() {
      return this.name;
   }

   public final void setEventQueueSize(int var1) {
      try {
         this.setDeviceEventQueueSize(var1);
         this.event_queue = new EventQueue(var1);
      } catch (IOException var3) {
         ControllerEnvironment.logln("Failed to create new event queue of size " + var1 + ": " + var3);
      }

   }

   protected abstract boolean getNextDeviceEvent(Event var1) throws IOException;

   public final String getName() {
      return this.name;
   }

   public final Rumbler[] getRumblers() {
      return this.rumblers;
   }

   public Controller.PortType getPortType() {
      return Controller.PortType.UNKNOWN;
   }
}
