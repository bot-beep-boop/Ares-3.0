package net.java.games.input;

import java.io.IOException;

final class RawDevice {
   public static final int RIM_TYPEKEYBOARD = 1;
   static Class class$net$java$games$input$RawMouseEvent;
   private DataQueue processed_mouse_events;
   public static final int RI_MOUSE_RIGHT_BUTTON_DOWN = 4;
   private final boolean[] button_states = new boolean[5];
   public static final int RIM_TYPEHID = 2;
   private int last_x;
   public static final int WM_KEYUP = 257;
   private final long handle;
   private final boolean[] key_states = new boolean[255];
   public static final int RI_MOUSE_BUTTON_4_DOWN = 64;
   public static final int RI_MOUSE_LEFT_BUTTON_DOWN = 1;
   private int relative_x;
   static Class class$net$java$games$input$RawKeyboardEvent;
   private int event_relative_x;
   public static final int MOUSE_MOVE_RELATIVE = 0;
   private DataQueue mouse_events;
   public static final int RI_MOUSE_BUTTON_4_UP = 128;
   public static final int MOUSE_MOVE_ABSOLUTE = 1;
   public static final int RI_MOUSE_LEFT_BUTTON_UP = 2;
   private int relative_y;
   public static final int RI_MOUSE_WHEEL = 1024;
   public static final int RI_MOUSE_BUTTON_5_UP = 512;
   public static final int RI_MOUSE_BUTTON_2_DOWN = 4;
   public static final int MOUSE_ATTRIBUTES_CHANGED = 4;
   public static final int WM_KEYDOWN = 256;
   private int last_y;
   private int event_last_x;
   private int event_relative_y;
   public static final int MOUSE_VIRTUAL_DESKTOP = 2;
   private int event_last_y;
   public static final int WM_SYSKEYUP = 261;
   private DataQueue keyboard_events;
   private int wheel;
   public static final int RI_MOUSE_MIDDLE_BUTTON_DOWN = 16;
   public static final int RI_MOUSE_BUTTON_5_DOWN = 256;
   public static final int RI_MOUSE_RIGHT_BUTTON_UP = 8;
   private final int type;
   public static final int RIM_TYPEMOUSE = 0;
   private DataQueue processed_keyboard_events;
   public static final int RI_MOUSE_MIDDLE_BUTTON_UP = 32;
   public static final int WM_SYSKEYDOWN = 260;
   public static final int RI_MOUSE_BUTTON_1_DOWN = 1;
   public static final int RI_MOUSE_BUTTON_3_UP = 32;
   public static final int RI_MOUSE_BUTTON_1_UP = 2;
   private final RawInputEventQueue queue;
   public static final int RI_MOUSE_BUTTON_3_DOWN = 16;
   public static final int RI_MOUSE_BUTTON_2_UP = 8;

   public final boolean isKeyDown(int var1) {
      return this.key_states[var1];
   }

   public final boolean getButtonState(int var1) {
      return var1 >= this.button_states.length ? false : this.button_states[var1];
   }

   public final synchronized void pollMouse() {
      this.relative_x = this.relative_y = this.wheel = 0;
      this.mouse_events.flip();

      while(this.mouse_events.hasRemaining()) {
         RawMouseEvent var1 = (RawMouseEvent)this.mouse_events.get();
         boolean var2 = this.processMouseEvent(var1);
         if (var2 && this.processed_mouse_events.hasRemaining()) {
            RawMouseEvent var3 = (RawMouseEvent)this.processed_mouse_events.get();
            var3.set(var1);
         }
      }

      this.mouse_events.compact();
   }

   private final boolean updateButtonState(int var1, int var2, int var3, int var4) {
      if (var1 >= this.button_states.length) {
         return false;
      } else if ((var2 & var3) != 0) {
         this.button_states[var1] = true;
         return true;
      } else if ((var2 & var4) != 0) {
         this.button_states[var1] = false;
         return true;
      } else {
         return false;
      }
   }

   private final boolean processKeyboardEvent(RawKeyboardEvent var1) {
      int var2 = var1.getMessage();
      int var3 = var1.getVKey();
      if (var3 >= this.key_states.length) {
         return false;
      } else if (var2 != 256 && var2 != 260) {
         if (var2 != 257 && var2 != 261) {
            return false;
         } else {
            this.key_states[var3] = false;
            return true;
         }
      } else {
         this.key_states[var3] = true;
         return true;
      }
   }

   public final synchronized boolean getNextMouseEvent(RawMouseEvent var1) {
      this.processed_mouse_events.flip();
      if (!this.processed_mouse_events.hasRemaining()) {
         this.processed_mouse_events.compact();
         return false;
      } else {
         RawMouseEvent var2 = (RawMouseEvent)this.processed_mouse_events.get();
         if ((var2.getFlags() & 1) != 0) {
            this.event_relative_x = var2.getLastX() - this.event_last_x;
            this.event_relative_y = var2.getLastY() - this.event_last_y;
            this.event_last_x = var2.getLastX();
            this.event_last_y = var2.getLastY();
         } else {
            this.event_relative_x = var2.getLastX();
            this.event_relative_y = var2.getLastY();
         }

         var1.set(var2);
         this.processed_mouse_events.compact();
         return true;
      }
   }

   public final synchronized void pollKeyboard() {
      this.keyboard_events.flip();

      while(this.keyboard_events.hasRemaining()) {
         RawKeyboardEvent var1 = (RawKeyboardEvent)this.keyboard_events.get();
         boolean var2 = this.processKeyboardEvent(var1);
         if (var2 && this.processed_keyboard_events.hasRemaining()) {
            RawKeyboardEvent var3 = (RawKeyboardEvent)this.processed_keyboard_events.get();
            var3.set(var1);
         }
      }

      this.keyboard_events.compact();
   }

   public final int getRelativeX() {
      return this.relative_x;
   }

   public final int getType() {
      return this.type;
   }

   public final String getName() throws IOException {
      return nGetName(this.handle);
   }

   public final RawDeviceInfo getInfo() throws IOException {
      return nGetInfo(this, this.handle);
   }

   public final int getRelativeY() {
      return this.relative_y;
   }

   private final boolean processMouseEvent(RawMouseEvent var1) {
      boolean var2 = false;
      int var3 = var1.getButtonFlags();
      var2 = this.updateButtonState(0, var3, 1, 2) || var2;
      var2 = this.updateButtonState(1, var3, 4, 8) || var2;
      var2 = this.updateButtonState(2, var3, 16, 32) || var2;
      var2 = this.updateButtonState(3, var3, 64, 128) || var2;
      var2 = this.updateButtonState(4, var3, 256, 512) || var2;
      int var4;
      int var5;
      if ((var1.getFlags() & 1) != 0) {
         var4 = var1.getLastX() - this.last_x;
         var5 = var1.getLastY() - this.last_y;
         this.last_x = var1.getLastX();
         this.last_y = var1.getLastY();
      } else {
         var4 = var1.getLastX();
         var5 = var1.getLastY();
      }

      int var6 = 0;
      if ((var3 & 1024) != 0) {
         var6 = var1.getWheelDelta();
      }

      this.relative_x += var4;
      this.relative_y += var5;
      this.wheel += var6;
      var2 = var4 != 0 || var5 != 0 || var6 != 0 || var2;
      return var2;
   }

   public final int getEventRelativeY() {
      return this.event_relative_y;
   }

   private static final native String nGetName(long var0) throws IOException;

   private static final native RawDeviceInfo nGetInfo(RawDevice var0, long var1) throws IOException;

   public RawDevice(RawInputEventQueue var1, long var2, int var4) {
      this.queue = var1;
      this.handle = var2;
      this.type = var4;
      this.setBufferSize(32);
   }

   public final long getHandle() {
      return this.handle;
   }

   public final synchronized void addMouseEvent(long var1, int var3, int var4, int var5, long var6, long var8, long var10, long var12) {
      if (this.mouse_events.hasRemaining()) {
         RawMouseEvent var14 = (RawMouseEvent)this.mouse_events.get();
         var14.set(var1, var3, var4, var5, var6, var8, var10, var12);
      }

   }

   public final int getEventRelativeX() {
      return this.event_relative_x;
   }

   public final void setBufferSize(int var1) {
      this.keyboard_events = new DataQueue(var1, class$net$java$games$input$RawKeyboardEvent == null ? (class$net$java$games$input$RawKeyboardEvent = class$("net.java.games.input.RawKeyboardEvent")) : class$net$java$games$input$RawKeyboardEvent);
      this.mouse_events = new DataQueue(var1, class$net$java$games$input$RawMouseEvent == null ? (class$net$java$games$input$RawMouseEvent = class$("net.java.games.input.RawMouseEvent")) : class$net$java$games$input$RawMouseEvent);
      this.processed_keyboard_events = new DataQueue(var1, class$net$java$games$input$RawKeyboardEvent == null ? (class$net$java$games$input$RawKeyboardEvent = class$("net.java.games.input.RawKeyboardEvent")) : class$net$java$games$input$RawKeyboardEvent);
      this.processed_mouse_events = new DataQueue(var1, class$net$java$games$input$RawMouseEvent == null ? (class$net$java$games$input$RawMouseEvent = class$("net.java.games.input.RawMouseEvent")) : class$net$java$games$input$RawMouseEvent);
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw (new NoClassDefFoundError()).initCause(var2);
      }
   }

   public final synchronized void addKeyboardEvent(long var1, int var3, int var4, int var5, int var6, long var7) {
      if (this.keyboard_events.hasRemaining()) {
         RawKeyboardEvent var9 = (RawKeyboardEvent)this.keyboard_events.get();
         var9.set(var1, var3, var4, var5, var6, var7);
      }

   }

   public final synchronized boolean getNextKeyboardEvent(RawKeyboardEvent var1) {
      this.processed_keyboard_events.flip();
      if (!this.processed_keyboard_events.hasRemaining()) {
         this.processed_keyboard_events.compact();
         return false;
      } else {
         RawKeyboardEvent var2 = (RawKeyboardEvent)this.processed_keyboard_events.get();
         var1.set(var2);
         this.processed_keyboard_events.compact();
         return true;
      }
   }

   public final int getWheel() {
      return this.wheel;
   }
}
