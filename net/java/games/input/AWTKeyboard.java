package net.java.games.input;

import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

final class AWTKeyboard extends Keyboard implements AWTEventListener {
   static Class class$java$awt$event$KeyEvent;
   private Event[] processed_events;
   private final List awt_events = new ArrayList();
   private int processed_events_index;

   private static final Component[] createComponents() {
      ArrayList var0 = new ArrayList();
      Field[] var1 = (class$java$awt$event$KeyEvent == null ? (class$java$awt$event$KeyEvent = class$("java.awt.event.KeyEvent")) : class$java$awt$event$KeyEvent).getFields();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         Field var3 = var1[var2];

         try {
            if (Modifier.isStatic(var3.getModifiers()) && var3.getType() == Integer.TYPE && var3.getName().startsWith("VK_")) {
               int var4 = var3.getInt((Object)null);
               Component.Identifier.Key var5 = AWTKeyMap.mapKeyCode(var4);
               if (var5 != Component.Identifier.Key.UNKNOWN) {
                  var0.add(new AWTKeyboard.Key(var5));
               }
            }
         } catch (IllegalAccessException var6) {
            throw new RuntimeException(var6);
         }
      }

      var0.add(new AWTKeyboard.Key(Component.Identifier.Key.RCONTROL));
      var0.add(new AWTKeyboard.Key(Component.Identifier.Key.LCONTROL));
      var0.add(new AWTKeyboard.Key(Component.Identifier.Key.RSHIFT));
      var0.add(new AWTKeyboard.Key(Component.Identifier.Key.LSHIFT));
      var0.add(new AWTKeyboard.Key(Component.Identifier.Key.RALT));
      var0.add(new AWTKeyboard.Key(Component.Identifier.Key.LALT));
      var0.add(new AWTKeyboard.Key(Component.Identifier.Key.NUMPADENTER));
      var0.add(new AWTKeyboard.Key(Component.Identifier.Key.RETURN));
      var0.add(new AWTKeyboard.Key(Component.Identifier.Key.NUMPADCOMMA));
      var0.add(new AWTKeyboard.Key(Component.Identifier.Key.COMMA));
      return (Component[])((Component[])var0.toArray(new Component[0]));
   }

   private final void addEvent(AWTKeyboard.Key var1, float var2, long var3) {
      var1.setValue(var2);
      if (this.processed_events_index < this.processed_events.length) {
         this.processed_events[this.processed_events_index++].set(var1, var2, var3);
      }

   }

   protected final synchronized boolean getNextDeviceEvent(Event var1) throws IOException {
      if (this.processed_events_index == 0) {
         return false;
      } else {
         --this.processed_events_index;
         var1.set(this.processed_events[0]);
         Event var2 = this.processed_events[0];
         this.processed_events[0] = this.processed_events[this.processed_events_index];
         this.processed_events[this.processed_events_index] = var2;
         return true;
      }
   }

   protected final void setDeviceEventQueueSize(int var1) throws IOException {
      this.resizeEventQueue(var1);
   }

   private final void resizeEventQueue(int var1) {
      this.processed_events = new Event[var1];

      for(int var2 = 0; var2 < this.processed_events.length; ++var2) {
         this.processed_events[var2] = new Event();
      }

      this.processed_events_index = 0;
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw (new NoClassDefFoundError()).initCause(var2);
      }
   }

   private final void processEvent(KeyEvent var1) {
      Component.Identifier.Key var2 = AWTKeyMap.map(var1);
      if (var2 != null) {
         AWTKeyboard.Key var3 = (AWTKeyboard.Key)this.getComponent(var2);
         if (var3 != null) {
            long var4 = var1.getWhen() * 1000000L;
            if (var1.getID() == 401) {
               this.addEvent(var3, 1.0F, var4);
            } else if (var1.getID() == 402) {
               KeyEvent var6 = (KeyEvent)Toolkit.getDefaultToolkit().getSystemEventQueue().peekEvent(401);
               if (var6 == null || var6.getWhen() != var1.getWhen()) {
                  this.addEvent(var3, 0.0F, var4);
               }
            }

         }
      }
   }

   public final synchronized void eventDispatched(AWTEvent var1) {
      if (var1 instanceof KeyEvent) {
         this.awt_events.add(var1);
      }

   }

   public final synchronized void pollDevice() throws IOException {
      for(int var1 = 0; var1 < this.awt_events.size(); ++var1) {
         KeyEvent var2 = (KeyEvent)this.awt_events.get(var1);
         this.processEvent(var2);
      }

      this.awt_events.clear();
   }

   protected AWTKeyboard() {
      super("AWTKeyboard", createComponents(), new Controller[0], new Rumbler[0]);
      Toolkit.getDefaultToolkit().addAWTEventListener(this, 8L);
      this.resizeEventQueue(32);
   }

   private static final class Key extends AbstractComponent {
      private float value;

      public final void setValue(float var1) {
         this.value = var1;
      }

      protected final float poll() {
         return this.value;
      }

      public final boolean isAnalog() {
         return false;
      }

      public Key(Component.Identifier.Key var1) {
         super(var1.getName(), var1);
      }

      public final boolean isRelative() {
         return false;
      }
   }
}
