package net.java.games.input;

import java.io.IOException;

final class RawMouse extends Mouse {
   private static final int EVENT_DONE = 1;
   private static final int EVENT_X = 2;
   private int event_state = 1;
   private static final int EVENT_BUTTON_1 = 6;
   private static final int EVENT_BUTTON_4 = 9;
   private static final int EVENT_Z = 4;
   private static final int EVENT_Y = 3;
   private final RawDevice device;
   private static final int EVENT_BUTTON_0 = 5;
   private static final int EVENT_BUTTON_3 = 8;
   private static final int EVENT_BUTTON_2 = 7;
   private final RawMouseEvent current_event = new RawMouseEvent();

   public final void pollDevice() throws IOException {
      this.device.pollMouse();
   }

   protected final void setDeviceEventQueueSize(int var1) throws IOException {
      this.device.setBufferSize(var1);
   }

   protected RawMouse(String var1, RawDevice var2, Component[] var3, Controller[] var4, Rumbler[] var5) throws IOException {
      super(var1, var3, var4, var5);
      this.device = var2;
   }

   private static final boolean makeButtonEvent(RawMouseEvent var0, Event var1, Component var2, int var3, int var4) {
      if ((var0.getButtonFlags() & var3) != 0) {
         var1.set(var2, 1.0F, var0.getNanos());
         return true;
      } else if ((var0.getButtonFlags() & var4) != 0) {
         var1.set(var2, 0.0F, var0.getNanos());
         return true;
      } else {
         return false;
      }
   }

   protected final synchronized boolean getNextDeviceEvent(Event var1) throws IOException {
      while(true) {
         switch(this.event_state) {
         case 1:
            if (!this.device.getNextMouseEvent(this.current_event)) {
               return false;
            }

            this.event_state = 2;
            break;
         case 2:
            int var2 = this.device.getEventRelativeX();
            this.event_state = 3;
            if (var2 == 0) {
               break;
            }

            var1.set(this.getX(), (float)var2, this.current_event.getNanos());
            return true;
         case 3:
            int var3 = this.device.getEventRelativeY();
            this.event_state = 4;
            if (var3 == 0) {
               break;
            }

            var1.set(this.getY(), (float)var3, this.current_event.getNanos());
            return true;
         case 4:
            int var4 = this.current_event.getWheelDelta();
            this.event_state = 5;
            if (var4 == 0) {
               break;
            }

            var1.set(this.getWheel(), (float)var4, this.current_event.getNanos());
            return true;
         case 5:
            this.event_state = 6;
            if (!makeButtonEvent(this.current_event, var1, this.getPrimaryButton(), 1, 2)) {
               break;
            }

            return true;
         case 6:
            this.event_state = 7;
            if (!makeButtonEvent(this.current_event, var1, this.getSecondaryButton(), 4, 8)) {
               break;
            }

            return true;
         case 7:
            this.event_state = 8;
            if (!makeButtonEvent(this.current_event, var1, this.getTertiaryButton(), 16, 32)) {
               break;
            }

            return true;
         case 8:
            this.event_state = 9;
            if (!makeButtonEvent(this.current_event, var1, this.getButton3(), 64, 128)) {
               break;
            }

            return true;
         case 9:
            this.event_state = 1;
            if (!makeButtonEvent(this.current_event, var1, this.getButton4(), 256, 512)) {
               break;
            }

            return true;
         default:
            throw new RuntimeException("Unknown event state: " + this.event_state);
         }
      }
   }

   static final class Button extends AbstractComponent {
      private final RawDevice device;
      private final int button_id;

      public final boolean isAnalog() {
         return false;
      }

      public Button(RawDevice var1, Component.Identifier.Button var2, int var3) {
         super(var2.getName(), var2);
         this.device = var1;
         this.button_id = var3;
      }

      public final boolean isRelative() {
         return false;
      }

      protected final float poll() throws IOException {
         return this.device.getButtonState(this.button_id) ? 1.0F : 0.0F;
      }
   }

   static final class Axis extends AbstractComponent {
      private final RawDevice device;

      protected final float poll() throws IOException {
         if (this.getIdentifier() == Component.Identifier.Axis.X) {
            return (float)this.device.getRelativeX();
         } else if (this.getIdentifier() == Component.Identifier.Axis.Y) {
            return (float)this.device.getRelativeY();
         } else if (this.getIdentifier() == Component.Identifier.Axis.Z) {
            return (float)this.device.getWheel();
         } else {
            throw new RuntimeException("Unknown raw axis: " + this.getIdentifier());
         }
      }

      public final boolean isRelative() {
         return true;
      }

      public final boolean isAnalog() {
         return true;
      }

      public Axis(RawDevice var1, Component.Identifier.Axis var2) {
         super(var2.getName(), var2);
         this.device = var1;
      }
   }
}
