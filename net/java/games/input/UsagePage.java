package net.java.games.input;

import java.lang.reflect.Method;

final class UsagePage {
   public static final UsagePage DIGITIZER;
   static Class class$net$java$games$input$GenericDesktopUsage;
   public static final UsagePage POWER_DEVICE;
   public static final UsagePage ALPHANUMERIC_DISPLAY;
   public static final UsagePage KEYBOARD_OR_KEYPAD;
   public static final UsagePage TELEPHONY;
   public static final UsagePage CONSUMER;
   public static final UsagePage CAMERACONTROL;
   public static final UsagePage SPORT;
   public static final UsagePage BUTTON;
   public static final UsagePage ARCADE;
   public static final UsagePage ORDINAL;
   public static final UsagePage PID;
   private static final UsagePage[] map = new UsagePage[255];
   public static final UsagePage GENERIC_DESKTOP;
   static Class class$net$java$games$input$ButtonUsage;
   public static final UsagePage UNICODE;
   public static final UsagePage LEDS;
   private final Class usage_class;
   public static final UsagePage BAR_CODE_SCANNER;
   static Class class$net$java$games$input$KeyboardUsage;
   public static final UsagePage BATTERY_SYSTEM;
   public static final UsagePage GAME;
   public static final UsagePage VR;
   public static final UsagePage SCALE;
   private final int usage_page_id;
   public static final UsagePage UNDEFINED = new UsagePage(0);
   public static final UsagePage SIMULATION;

   private UsagePage(int var1) {
      this(var1, (Class)null);
   }

   public final Usage mapUsage(int var1) {
      if (this.usage_class == null) {
         return null;
      } else {
         try {
            Method var2 = this.usage_class.getMethod("map", Integer.TYPE);
            Object var3 = var2.invoke((Object)null, new Integer(var1));
            return (Usage)var3;
         } catch (Exception var4) {
            throw new Error(var4);
         }
      }
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw (new NoClassDefFoundError()).initCause(var2);
      }
   }

   private UsagePage(int var1, Class var2) {
      map[var1] = this;
      this.usage_class = var2;
      this.usage_page_id = var1;
   }

   public final String toString() {
      return "UsagePage (0x" + Integer.toHexString(this.usage_page_id) + ")";
   }

   public static final UsagePage map(int var0) {
      return var0 >= 0 && var0 < map.length ? map[var0] : null;
   }

   static {
      GENERIC_DESKTOP = new UsagePage(1, class$net$java$games$input$GenericDesktopUsage == null ? (class$net$java$games$input$GenericDesktopUsage = class$("net.java.games.input.GenericDesktopUsage")) : class$net$java$games$input$GenericDesktopUsage);
      SIMULATION = new UsagePage(2);
      VR = new UsagePage(3);
      SPORT = new UsagePage(4);
      GAME = new UsagePage(5);
      KEYBOARD_OR_KEYPAD = new UsagePage(7, class$net$java$games$input$KeyboardUsage == null ? (class$net$java$games$input$KeyboardUsage = class$("net.java.games.input.KeyboardUsage")) : class$net$java$games$input$KeyboardUsage);
      LEDS = new UsagePage(8);
      BUTTON = new UsagePage(9, class$net$java$games$input$ButtonUsage == null ? (class$net$java$games$input$ButtonUsage = class$("net.java.games.input.ButtonUsage")) : class$net$java$games$input$ButtonUsage);
      ORDINAL = new UsagePage(10);
      TELEPHONY = new UsagePage(11);
      CONSUMER = new UsagePage(12);
      DIGITIZER = new UsagePage(13);
      PID = new UsagePage(15);
      UNICODE = new UsagePage(16);
      ALPHANUMERIC_DISPLAY = new UsagePage(20);
      POWER_DEVICE = new UsagePage(132);
      BATTERY_SYSTEM = new UsagePage(133);
      BAR_CODE_SCANNER = new UsagePage(140);
      SCALE = new UsagePage(141);
      CAMERACONTROL = new UsagePage(144);
      ARCADE = new UsagePage(145);
   }
}
