package net.java.games.input;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

final class RawKeyboard extends Keyboard {
   static Class class$net$java$games$input$RawIdentifierMap;
   private final RawKeyboardEvent raw_event = new RawKeyboardEvent();
   private final RawDevice device;

   protected RawKeyboard(String var1, RawDevice var2, Controller[] var3, Rumbler[] var4) throws IOException {
      super(var1, createKeyboardComponents(var2), var3, var4);
      this.device = var2;
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw (new NoClassDefFoundError()).initCause(var2);
      }
   }

   private static final Component[] createKeyboardComponents(RawDevice var0) {
      ArrayList var1 = new ArrayList();
      Field[] var2 = (class$net$java$games$input$RawIdentifierMap == null ? (class$net$java$games$input$RawIdentifierMap = class$("net.java.games.input.RawIdentifierMap")) : class$net$java$games$input$RawIdentifierMap).getFields();

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Field var4 = var2[var3];

         try {
            if (Modifier.isStatic(var4.getModifiers()) && var4.getType() == Integer.TYPE) {
               int var5 = var4.getInt((Object)null);
               Component.Identifier.Key var6 = RawIdentifierMap.mapVKey(var5);
               if (var6 != Component.Identifier.Key.UNKNOWN) {
                  var1.add(new RawKeyboard.Key(var0, var5, var6));
               }
            }
         } catch (IllegalAccessException var7) {
            throw new RuntimeException(var7);
         }
      }

      return (Component[])((Component[])var1.toArray(new Component[0]));
   }

   protected final void setDeviceEventQueueSize(int var1) throws IOException {
      this.device.setBufferSize(var1);
   }

   public final void pollDevice() throws IOException {
      this.device.pollKeyboard();
   }

   protected final synchronized boolean getNextDeviceEvent(Event var1) throws IOException {
      while(this.device.getNextKeyboardEvent(this.raw_event)) {
         int var2 = this.raw_event.getVKey();
         Component.Identifier.Key var3 = RawIdentifierMap.mapVKey(var2);
         Component var4 = this.getComponent(var3);
         if (var4 != null) {
            int var5 = this.raw_event.getMessage();
            if (var5 != 256 && var5 != 260) {
               if (var5 != 257 && var5 != 261) {
                  continue;
               }

               var1.set(var4, 0.0F, this.raw_event.getNanos());
               return true;
            }

            var1.set(var4, 1.0F, this.raw_event.getNanos());
            return true;
         }
      }

      return false;
   }

   static final class Key extends AbstractComponent {
      private final int vkey_code;
      private final RawDevice device;

      public final boolean isRelative() {
         return false;
      }

      public Key(RawDevice var1, int var2, Component.Identifier.Key var3) {
         super(var3.getName(), var3);
         this.device = var1;
         this.vkey_code = var2;
      }

      protected final float poll() throws IOException {
         return this.device.isKeyDown(this.vkey_code) ? 1.0F : 0.0F;
      }

      public final boolean isAnalog() {
         return false;
      }
   }
}
