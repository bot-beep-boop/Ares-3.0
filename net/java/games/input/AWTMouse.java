package net.java.games.input;

import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class AWTMouse extends Mouse implements AWTEventListener {
   private final List processed_awt_events = new ArrayList();
   private int event_state = 1;
   private final List awt_events = new ArrayList();
   private static final int EVENT_Y = 2;
   private static final int EVENT_BUTTON = 4;
   private static final int EVENT_X = 1;

   protected AWTMouse() {
      super("AWTMouse", createComponents(), new Controller[0], new Rumbler[0]);
      Toolkit.getDefaultToolkit().addAWTEventListener(this, 131120L);
   }

   public final synchronized void eventDispatched(AWTEvent var1) {
      this.awt_events.add(var1);
   }

   private final AWTMouse.Button getButton(int var1) {
      switch(var1) {
      case 0:
      default:
         return null;
      case 1:
         return (AWTMouse.Button)this.getLeft();
      case 2:
         return (AWTMouse.Button)this.getMiddle();
      case 3:
         return (AWTMouse.Button)this.getRight();
      }
   }

   private final void processButtons(int var1, float var2) {
      AWTMouse.Button var3 = this.getButton(var1);
      if (var3 != null) {
         var3.setValue(var2);
      }

   }

   private static final Component[] createComponents() {
      return new Component[]{new AWTMouse.Axis(Component.Identifier.Axis.X), new AWTMouse.Axis(Component.Identifier.Axis.Y), new AWTMouse.Axis(Component.Identifier.Axis.Z), new AWTMouse.Button(Component.Identifier.Button.LEFT), new AWTMouse.Button(Component.Identifier.Button.MIDDLE), new AWTMouse.Button(Component.Identifier.Button.RIGHT)};
   }

   protected final synchronized boolean getNextDeviceEvent(Event var1) throws IOException {
      while(!this.processed_awt_events.isEmpty()) {
         AWTEvent var2 = (AWTEvent)this.processed_awt_events.get(0);
         long var4;
         if (var2 instanceof MouseWheelEvent) {
            MouseWheelEvent var7 = (MouseWheelEvent)var2;
            var4 = var7.getWhen() * 1000000L;
            var1.set(this.getWheel(), (float)var7.getWheelRotation(), var4);
            this.processed_awt_events.remove(0);
         } else if (var2 instanceof MouseEvent) {
            MouseEvent var3 = (MouseEvent)var2;
            var4 = var3.getWhen() * 1000000L;
            switch(this.event_state) {
            case 1:
               this.event_state = 2;
               var1.set(this.getX(), (float)var3.getX(), var4);
               return true;
            case 2:
               this.event_state = 4;
               var1.set(this.getY(), (float)var3.getY(), var4);
               return true;
            case 3:
            default:
               throw new RuntimeException("Unknown event state: " + this.event_state);
            case 4:
               this.processed_awt_events.remove(0);
               this.event_state = 1;
               AWTMouse.Button var6 = this.getButton(var3.getButton());
               if (var6 != null) {
                  switch(var3.getID()) {
                  case 501:
                     var1.set(var6, 1.0F, var4);
                     return true;
                  case 502:
                     var1.set(var6, 0.0F, var4);
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   public final synchronized void pollDevice() throws IOException {
      AWTMouse.Axis var1 = (AWTMouse.Axis)this.getWheel();
      var1.setValue(0.0F);

      for(int var2 = 0; var2 < this.awt_events.size(); ++var2) {
         AWTEvent var3 = (AWTEvent)this.awt_events.get(var2);
         this.processEvent(var3);
         this.processed_awt_events.add(var3);
      }

      this.awt_events.clear();
   }

   private final void processEvent(AWTEvent var1) throws IOException {
      AWTMouse.Axis var3;
      if (var1 instanceof MouseWheelEvent) {
         MouseWheelEvent var2 = (MouseWheelEvent)var1;
         var3 = (AWTMouse.Axis)this.getWheel();
         var3.setValue(var3.poll() + (float)var2.getWheelRotation());
      } else if (var1 instanceof MouseEvent) {
         MouseEvent var5 = (MouseEvent)var1;
         var3 = (AWTMouse.Axis)this.getX();
         AWTMouse.Axis var4 = (AWTMouse.Axis)this.getY();
         var3.setValue((float)var5.getX());
         var4.setValue((float)var5.getY());
         switch(var5.getID()) {
         case 501:
            this.processButtons(var5.getButton(), 1.0F);
            break;
         case 502:
            this.processButtons(var5.getButton(), 0.0F);
         }
      }

   }

   static final class Button extends AbstractComponent {
      private float value;

      public final boolean isRelative() {
         return false;
      }

      protected final float poll() throws IOException {
         return this.value;
      }

      public final boolean isAnalog() {
         return false;
      }

      protected final void setValue(float var1) {
         this.value = var1;
      }

      public Button(Component.Identifier.Button var1) {
         super(var1.getName(), var1);
      }
   }

   static final class Axis extends AbstractComponent {
      private float value;

      protected final float poll() throws IOException {
         return this.value;
      }

      public Axis(Component.Identifier.Axis var1) {
         super(var1.getName(), var1);
      }

      public final boolean isRelative() {
         return false;
      }

      public final boolean isAnalog() {
         return true;
      }

      protected final void setValue(float var1) {
         this.value = var1;
      }
   }
}
