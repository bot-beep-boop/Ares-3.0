package net.java.games.input;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

public abstract class ControllerEnvironment {
   static final boolean $assertionsDisabled;
   static Class class$net$java$games$input$ControllerEnvironment;
   protected final ArrayList controllerListeners = new ArrayList();
   private static ControllerEnvironment defaultEnvironment;

   static void log(String var0) {
      Logger.getLogger((class$net$java$games$input$ControllerEnvironment == null ? (class$net$java$games$input$ControllerEnvironment = class$("net.java.games.input.ControllerEnvironment")) : class$net$java$games$input$ControllerEnvironment).getName()).info(var0);
   }

   protected void fireControllerRemoved(Controller var1) {
      ControllerEvent var2 = new ControllerEvent(var1);
      Iterator var3 = this.controllerListeners.iterator();

      while(var3.hasNext()) {
         ((ControllerListener)var3.next()).controllerRemoved(var2);
      }

   }

   public static ControllerEnvironment getDefaultEnvironment() {
      return defaultEnvironment;
   }

   public void removeControllerListener(ControllerListener var1) {
      if (!$assertionsDisabled && var1 == null) {
         throw new AssertionError();
      } else {
         this.controllerListeners.remove(var1);
      }
   }

   public abstract boolean isSupported();

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw (new NoClassDefFoundError()).initCause(var2);
      }
   }

   protected void fireControllerAdded(Controller var1) {
      ControllerEvent var2 = new ControllerEvent(var1);
      Iterator var3 = this.controllerListeners.iterator();

      while(var3.hasNext()) {
         ((ControllerListener)var3.next()).controllerAdded(var2);
      }

   }

   protected ControllerEnvironment() {
   }

   public void addControllerListener(ControllerListener var1) {
      if (!$assertionsDisabled && var1 == null) {
         throw new AssertionError();
      } else {
         this.controllerListeners.add(var1);
      }
   }

   public abstract Controller[] getControllers();

   static {
      $assertionsDisabled = !(class$net$java$games$input$ControllerEnvironment == null ? (class$net$java$games$input$ControllerEnvironment = class$("net.java.games.input.ControllerEnvironment")) : class$net$java$games$input$ControllerEnvironment).desiredAssertionStatus();
      defaultEnvironment = new DefaultControllerEnvironment();
   }

   static void logln(String var0) {
      log(var0 + "\n");
   }
}
