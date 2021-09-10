package net.java.games.input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class LinuxEventDevice implements LinuxDevice {
   private final Map component_map = new HashMap();
   static Class class$net$java$games$input$Component$Identifier$Key;
   private final List components;
   private final byte[] key_states = new byte[64];
   private boolean closed;
   private final LinuxInputID input_id;
   private final Controller.Type type;
   static Class class$net$java$games$input$Component$Identifier$Axis;
   private final long fd;
   private final Rumbler[] rumblers;
   private final String name;

   private final int getVersion() throws IOException {
      return nGetVersion(this.fd);
   }

   static void access$100(long var0) throws IOException {
      nClose(var0);
   }

   public static final boolean isBitSet(byte[] var0, int var1) {
      return (var0[var1 / 8] & 1 << var1 % 8) != 0;
   }

   private static final native void nGetAbsInfo(long var0, int var2, LinuxAbsInfo var3) throws IOException;

   private final byte[] getKeysBits() throws IOException {
      byte[] var1 = new byte[64];
      nGetBits(this.fd, 1, var1);
      return var1;
   }

   private static final native void nGetDeviceUsageBits(long var0, byte[] var2) throws IOException;

   private final byte[] getRelativeAxesBits() throws IOException {
      byte[] var1 = new byte[2];
      nGetBits(this.fd, 2, var1);
      return var1;
   }

   public final void registerComponent(LinuxAxisDescriptor var1, LinuxComponent var2) {
      this.component_map.put(var1, var2);
   }

   private static final native int nUploadConstantEffect(long var0, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12) throws IOException;

   public final String getName() {
      return this.name;
   }

   private static final native boolean nGetNextEvent(long var0, LinuxEvent var2) throws IOException;

   private final Controller.Type guessTypeFromUsages() throws IOException {
      byte[] var1 = this.getDeviceUsageBits();
      if (isBitSet(var1, 0)) {
         return Controller.Type.MOUSE;
      } else if (isBitSet(var1, 3)) {
         return Controller.Type.KEYBOARD;
      } else if (isBitSet(var1, 2)) {
         return Controller.Type.GAMEPAD;
      } else {
         return isBitSet(var1, 1) ? Controller.Type.STICK : Controller.Type.UNKNOWN;
      }
   }

   private static final native void nGetKeyStates(long var0, byte[] var2) throws IOException;

   public final Controller.PortType getPortType() throws IOException {
      return this.input_id.getPortType();
   }

   private static final native void nWriteEvent(long var0, int var2, int var3, int var4) throws IOException;

   public final boolean isKeySet(int var1) {
      return isBitSet(this.key_states, var1);
   }

   private static final native int nUploadRumbleEffect(long var0, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) throws IOException;

   private static final native LinuxInputID nGetInputID(long var0) throws IOException;

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw (new NoClassDefFoundError()).initCause(var2);
      }
   }

   public final LinuxInputID getInputID() {
      return this.input_id;
   }

   public final LinuxComponent mapDescriptor(LinuxAxisDescriptor var1) {
      return (LinuxComponent)this.component_map.get(var1);
   }

   public final synchronized int uploadConstantEffect(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) throws IOException {
      this.checkClosed();
      return nUploadConstantEffect(this.fd, var1, var3, var2, var4, var5, var6, var7, var8, var9, var10, var11);
   }

   private static final native int nGetNumEffects(long var0) throws IOException;

   public final synchronized void writeEvent(int var1, int var2, int var3) throws IOException {
      this.checkClosed();
      nWriteEvent(this.fd, var1, var2, var3);
   }

   public final synchronized void pollKeyStates() throws IOException {
      nGetKeyStates(this.fd, this.key_states);
   }

   private final void checkClosed() throws IOException {
      if (this.closed) {
         throw new IOException("Device is closed");
      }
   }

   public final Controller.Type getType() {
      return this.type;
   }

   public final Rumbler[] getRumblers() {
      return this.rumblers;
   }

   private final LinuxInputID getDeviceInputID() throws IOException {
      return nGetInputID(this.fd);
   }

   public final List getComponents() {
      return this.components;
   }

   private final String getDeviceName() throws IOException {
      return nGetName(this.fd);
   }

   private static final native void nGetBits(long var0, int var2, byte[] var3) throws IOException;

   public final synchronized void close() throws IOException {
      if (!this.closed) {
         this.closed = true;
         LinuxEnvironmentPlugin.execute(new LinuxDeviceTask(this) {
            private final LinuxEventDevice this$0;

            {
               this.this$0 = var1;
            }

            protected final Object execute() throws IOException {
               LinuxEventDevice.access$100(LinuxEventDevice.access$000(this.this$0));
               return null;
            }
         });
      }
   }

   private static final int countComponents(List var0, Class var1, boolean var2) {
      int var3 = 0;

      for(int var4 = 0; var4 < var0.size(); ++var4) {
         LinuxEventComponent var5 = (LinuxEventComponent)var0.get(var4);
         if (var1.isInstance(var5.getIdentifier()) && var2 == var5.isRelative()) {
            ++var3;
         }
      }

      return var3;
   }

   private static final native void nEraseEffect(long var0, int var2) throws IOException;

   private final byte[] getEventTypeBits() throws IOException {
      byte[] var1 = new byte[4];
      nGetBits(this.fd, 0, var1);
      return var1;
   }

   public LinuxEventDevice(String var1) throws IOException {
      boolean var4 = true;

      long var2;
      try {
         var2 = nOpen(var1, true);
      } catch (IOException var7) {
         var2 = nOpen(var1, false);
         var4 = false;
      }

      this.fd = var2;

      try {
         this.name = this.getDeviceName();
         this.input_id = this.getDeviceInputID();
         this.components = this.getDeviceComponents();
         if (var4) {
            this.rumblers = this.enumerateRumblers();
         } else {
            this.rumblers = new Rumbler[0];
         }

         this.type = this.guessType();
      } catch (IOException var6) {
         this.close();
         throw var6;
      }
   }

   public final synchronized boolean getNextEvent(LinuxEvent var1) throws IOException {
      this.checkClosed();
      return nGetNextEvent(this.fd, var1);
   }

   private final byte[] getForceFeedbackBits() throws IOException {
      byte[] var1 = new byte[16];
      nGetBits(this.fd, 21, var1);
      return var1;
   }

   private final Controller.Type guessType() throws IOException {
      Controller.Type var1 = this.guessTypeFromUsages();
      return var1 == Controller.Type.UNKNOWN ? this.guessTypeFromComponents() : var1;
   }

   private static final native String nGetName(long var0) throws IOException;

   private final void addAbsoluteAxes(List var1) throws IOException {
      byte[] var2 = this.getAbsoluteAxesBits();

      for(int var3 = 0; var3 < var2.length * 8; ++var3) {
         if (isBitSet(var2, var3)) {
            Component.Identifier var4 = LinuxNativeTypesMap.getAbsAxisID(var3);
            var1.add(new LinuxEventComponent(this, var4, false, 3, var3));
         }
      }

   }

   private final Controller.Type guessTypeFromComponents() throws IOException {
      List var1 = this.getComponents();
      if (var1.size() == 0) {
         return Controller.Type.UNKNOWN;
      } else {
         int var2 = countComponents(var1, class$net$java$games$input$Component$Identifier$Axis == null ? (class$net$java$games$input$Component$Identifier$Axis = class$("net.java.games.input.Component$Identifier$Axis")) : class$net$java$games$input$Component$Identifier$Axis, true);
         int var3 = countComponents(var1, class$net$java$games$input$Component$Identifier$Axis == null ? (class$net$java$games$input$Component$Identifier$Axis = class$("net.java.games.input.Component$Identifier$Axis")) : class$net$java$games$input$Component$Identifier$Axis, false);
         int var4 = countComponents(var1, class$net$java$games$input$Component$Identifier$Key == null ? (class$net$java$games$input$Component$Identifier$Key = class$("net.java.games.input.Component$Identifier$Key")) : class$net$java$games$input$Component$Identifier$Key, false);
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;
         int var8 = 0;
         if (this.name.toLowerCase().indexOf("mouse") != -1) {
            ++var5;
         }

         if (this.name.toLowerCase().indexOf("keyboard") != -1) {
            ++var6;
         }

         if (this.name.toLowerCase().indexOf("joystick") != -1) {
            ++var7;
         }

         if (this.name.toLowerCase().indexOf("gamepad") != -1) {
            ++var8;
         }

         int var9 = 0;
         int var10 = 0;
         int var11 = 0;
         int var12 = 0;

         for(int var13 = 0; var13 < var1.size(); ++var13) {
            LinuxEventComponent var14 = (LinuxEventComponent)var1.get(var13);
            if (var14.getButtonTrait() == Controller.Type.MOUSE) {
               ++var10;
            } else if (var14.getButtonTrait() == Controller.Type.KEYBOARD) {
               ++var9;
            } else if (var14.getButtonTrait() == Controller.Type.GAMEPAD) {
               ++var12;
            } else if (var14.getButtonTrait() == Controller.Type.STICK) {
               ++var11;
            }
         }

         if (var10 >= var9 && var10 >= var11 && var10 >= var12) {
            ++var5;
         } else if (var9 >= var10 && var9 >= var11 && var9 >= var12) {
            ++var6;
         } else if (var11 >= var9 && var11 >= var10 && var11 >= var12) {
            ++var7;
         } else if (var12 >= var9 && var12 >= var10 && var12 >= var11) {
            ++var8;
         }

         if (var2 >= 2) {
            ++var5;
         }

         if (var3 >= 2) {
            ++var7;
            ++var8;
         }

         if (var5 >= var6 && var5 >= var7 && var5 >= var8) {
            return Controller.Type.MOUSE;
         } else if (var6 >= var5 && var6 >= var7 && var6 >= var8) {
            return Controller.Type.KEYBOARD;
         } else if (var7 >= var5 && var7 >= var6 && var7 >= var8) {
            return Controller.Type.STICK;
         } else {
            return var8 >= var5 && var8 >= var6 && var8 >= var7 ? Controller.Type.GAMEPAD : null;
         }
      }
   }

   private final void addRelativeAxes(List var1) throws IOException {
      byte[] var2 = this.getRelativeAxesBits();

      for(int var3 = 0; var3 < var2.length * 8; ++var3) {
         if (isBitSet(var2, var3)) {
            Component.Identifier var4 = LinuxNativeTypesMap.getRelAxisID(var3);
            var1.add(new LinuxEventComponent(this, var4, true, 2, var3));
         }
      }

   }

   public final synchronized int uploadRumbleEffect(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) throws IOException {
      this.checkClosed();
      return nUploadRumbleEffect(this.fd, var1, var3, var2, var4, var5, var6, var7, var8);
   }

   final void eraseEffect(int var1) throws IOException {
      nEraseEffect(this.fd, var1);
   }

   private final void addKeys(List var1) throws IOException {
      byte[] var2 = this.getKeysBits();

      for(int var3 = 0; var3 < var2.length * 8; ++var3) {
         if (isBitSet(var2, var3)) {
            Component.Identifier var4 = LinuxNativeTypesMap.getButtonID(var3);
            var1.add(new LinuxEventComponent(this, var4, false, 1, var3));
         }
      }

   }

   private final Rumbler[] enumerateRumblers() {
      ArrayList var1 = new ArrayList();

      try {
         int var2 = this.getNumEffects();
         if (var2 <= 0) {
            return (Rumbler[])((Rumbler[])var1.toArray(new Rumbler[0]));
         }

         byte[] var3 = this.getForceFeedbackBits();
         if (isBitSet(var3, 80) && var2 > var1.size()) {
            var1.add(new LinuxRumbleFF(this));
         }
      } catch (IOException var4) {
         LinuxEnvironmentPlugin.logln("Failed to enumerate rumblers: " + var4.getMessage());
      }

      return (Rumbler[])((Rumbler[])var1.toArray(new Rumbler[0]));
   }

   private static final native void nClose(long var0) throws IOException;

   private final byte[] getAbsoluteAxesBits() throws IOException {
      byte[] var1 = new byte[8];
      nGetBits(this.fd, 3, var1);
      return var1;
   }

   public final synchronized void getAbsInfo(int var1, LinuxAbsInfo var2) throws IOException {
      this.checkClosed();
      nGetAbsInfo(this.fd, var1, var2);
   }

   private final byte[] getDeviceUsageBits() throws IOException {
      byte[] var1 = new byte[2];
      if (this.getVersion() >= 65537) {
         nGetDeviceUsageBits(this.fd, var1);
      }

      return var1;
   }

   private static final native int nGetVersion(long var0) throws IOException;

   private final List getDeviceComponents() throws IOException {
      ArrayList var1 = new ArrayList();
      byte[] var2 = this.getEventTypeBits();
      if (isBitSet(var2, 1)) {
         this.addKeys(var1);
      }

      if (isBitSet(var2, 3)) {
         this.addAbsoluteAxes(var1);
      }

      if (isBitSet(var2, 2)) {
         this.addRelativeAxes(var1);
      }

      return var1;
   }

   private static final native long nOpen(String var0, boolean var1) throws IOException;

   protected void finalize() throws IOException {
      this.close();
   }

   public final int getNumEffects() throws IOException {
      return nGetNumEffects(this.fd);
   }

   static long access$000(LinuxEventDevice var0) {
      return var0.fd;
   }
}
