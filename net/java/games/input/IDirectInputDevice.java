package net.java.games.input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class IDirectInputDevice {
   public static final int DIERR_INPUTLOST = -2147024866;
   public static final int DIDFT_TGLBUTTON = 8;
   public static final int DI_SETTINGSNOTSAVED = 11;
   public static final int DIEFT_DEADBAND = 16384;
   public static final int DIDFT_POV = 16;
   public static final int DIDF_RELAXIS = 2;
   public static final int GUID_Square = 14;
   public static final int DIEP_SAMPLEPERIOD = 2;
   public static final int GUID_Damper = 20;
   public static final int DI_EFFECTRESTARTED = 4;
   public static final int DIEFT_SATURATION = 2048;
   public static final int DIDFT_COLLECTION = 64;
   public static final int DIERR_NOTACQUIRED = -2147024868;
   public static final int DIDFT_VENDORDEFINED = 67108864;
   public static final int DIDFT_NOCOLLECTION = 16776960;
   public static final int DIEFT_CONSTANTFORCE = 1;
   public static final int DI8DEVTYPE_DEVICE = 17;
   public static final int GUID_Triangle = 16;
   public static final int DIEFT_POSNEGSATURATION = 8192;
   public static final int DIEP_START = 536870912;
   public static final int DIEFT_ALL = 0;
   public static final int GUID_YAxis = 2;
   public static final int DIEFT_CONDITION = 4;
   public static final int DIEFF_OBJECTIDS = 1;
   public static final int DIDFT_OUTPUT = 268435456;
   public static final int DIDFT_ALIAS = 134217728;
   public static final int GUID_XAxis = 1;
   public static final int DI_DEGREES = 100;
   public static final int GUID_RzAxis = 6;
   public static final int DIDOI_ASPECTMASK = 3840;
   private final boolean axes_in_relative_mode;
   public static final int DIDFT_NODATA = 128;
   public static final int GUID_Spring = 19;
   public static final int DIEP_GAIN = 4;
   public static final int DIDOI_GUIDISUSAGE = 65536;
   public static final int DIDOI_FFEFFECTTRIGGER = 2;
   public static final int DI_FFNOMINALMAX = 10000;
   public static final int DI_OK = 0;
   public static final int DIDFT_FFEFFECTTRIGGER = 33554432;
   public static final int DIEFF_OBJECTOFFSETS = 2;
   private int button_counter;
   public static final int DI_PROPNOEFFECT = 1;
   public static final int DIEFT_RAMPFORCE = 2;
   private final int dev_subtype;
   public static final int DIDOI_POLLED = 32768;
   private boolean released;
   public static final int DI_TRUNCATEDANDRESTARTED = 12;
   public static final int DIDFT_BUTTON = 12;
   public static final int DIDFT_OPTIONAL = Integer.MIN_VALUE;
   public static final int DI_POLLEDDEVICE = 2;
   private final List objects = new ArrayList();
   public static final int DI_DOWNLOADSKIPPED = 3;
   public static final int DI8DEVTYPE_GAMEPAD = 21;
   public static final int DIEFF_CARTESIAN = 16;
   public static final int DIEFT_STARTDELAY = 32768;
   public static final int DI8DEVTYPE_1STPERSON = 24;
   public static final int DIPROPRANGE_NOMIN = Integer.MIN_VALUE;
   public static final int DIEFT_FFFADE = 1024;
   public static final int DIEFT_HARDWARE = 255;
   private final Map object_to_component = new HashMap();
   public static final int DIEP_DURATION = 1;
   public static final int GUID_Sine = 15;
   public static final int DIEP_TRIGGERBUTTON = 8;
   public static final int DIDFT_ABSAXIS = 2;
   public static final int DISCL_NONEXCLUSIVE = 2;
   public static final int DIERR_OTHERAPPHASPRIO = -2147024891;
   public static final int GUID_Inertia = 21;
   public static final int GUID_Button = 8;
   public static final int GUID_POV = 10;
   private final List effects = new ArrayList();
   public static final int DIDOI_ASPECTACCEL = 768;
   public static final int DIDFT_ALL = 0;
   public static final int GUID_RampForce = 13;
   public static final int DIDOI_ASPECTVELOCITY = 512;
   public static final int DIEFT_PERIODIC = 3;
   private final List rumblers = new ArrayList();
   private final int[] device_state;
   public static final int GUID_Unknown = 11;
   static Class class$net$java$games$input$DIDeviceObjectData;
   public static final int DIDFT_AXIS = 3;
   public static final int GUID_RxAxis = 4;
   public static final int DIEP_TYPESPECIFICPARAMS = 256;
   public static final int DIDFT_FFACTUATOR = 16777216;
   public static final int INFINITE = -1;
   private final DummyWindow window;
   public static final int DIEP_ALLPARAMS_DX5 = 511;
   public static final int DI_TRUNCATED = 8;
   public static final int DI8DEVTYPE_FLIGHT = 23;
   private final long address;
   public static final int DI8DEVTYPE_KEYBOARD = 19;
   public static final int DI8DEVTYPE_SUPPLEMENTAL = 28;
   private final int dev_type;
   public static final int DIEP_DIRECTION = 64;
   public static final int DIEP_NODOWNLOAD = Integer.MIN_VALUE;
   public static final int GUID_Slider = 7;
   public static final int GUID_SawtoothUp = 17;
   private final String product_name;
   public static final int DIDFT_RELAXIS = 1;
   public static final int GUID_ZAxis = 3;
   public static final int DIEFT_POSNEGCOEFFICIENTS = 4096;
   public static final int DIDOI_ASPECTPOSITION = 256;
   private final String instance_name;
   public static final int DISCL_EXCLUSIVE = 1;
   public static final int GUID_ConstantForce = 12;
   public static final int DIEFF_SPHERICAL = 64;
   public static final int DI_NOEFFECT = 1;
   public static final int DIEFT_CUSTOMFORCE = 5;
   public static final int GUID_RyAxis = 5;
   public static final int GUID_Key = 9;
   public static final int DI8DEVTYPE_DEVICECTRL = 25;
   public static final int DIDOI_FFACTUATOR = 1;
   public static final int DIEP_ENVELOPE = 128;
   public static final int DIEP_TRIGGERREPEATINTERVAL = 16;
   public static final int DIDF_ABSAXIS = 1;
   public static final int DIPROPRANGE_NOMAX = Integer.MAX_VALUE;
   public static final int DIDOI_ASPECTFORCE = 1024;
   public static final int DIEP_STARTDELAY = 512;
   public static final int DI8DEVTYPE_REMOTE = 27;
   private int current_format_offset;
   public static final int DIEB_NOTRIGGER = -1;
   public static final int GUID_SawtoothDown = 18;
   public static final int DIDFT_PSHBUTTON = 4;
   public static final int GUID_CustomForce = 23;
   public static final int DI8DEVTYPE_MOUSE = 18;
   public static final int DI_BUFFEROVERFLOW = 1;
   public static final int DI8DEVTYPE_JOYSTICK = 20;
   public static final int DIEP_ALLPARAMS = 1023;
   private DataQueue queue;
   public static final int DIEFT_FFATTACK = 512;
   public static final int DI8DEVTYPE_DRIVING = 22;
   public static final int DI8DEVTYPE_SCREENPOINTER = 26;
   public static final int DISCL_BACKGROUND = 8;
   public static final int DIEFF_POLAR = 32;
   public static final int DI_SECONDS = 1000000;
   public static final int DISCL_FOREGROUND = 4;
   public static final int DIEP_NORESTART = 1073741824;
   public static final int GUID_Friction = 22;
   public static final int DISCL_NOWINKEY = 16;
   public static final int DIEP_AXES = 32;

   public final synchronized long[] getRangeProperty(int var1) throws IOException {
      this.checkReleased();
      long[] var2 = new long[2];
      int var3 = nGetRangeProperty(this.address, var1, var2);
      if (var3 != 0) {
         throw new IOException("Failed to get object range (" + var3 + ")");
      } else {
         return var2;
      }
   }

   private static final native int nSetDataFormat(long var0, int var2, DIDeviceObject[] var3);

   private final void setDataFormat(int var1) throws IOException {
      DIDeviceObject[] var2 = new DIDeviceObject[this.objects.size()];
      this.objects.toArray(var2);
      int var3 = nSetDataFormat(this.address, var1, var2);
      if (var3 != 0) {
         throw new IOException("Failed to set data format (" + Integer.toHexString(var3) + ")");
      }
   }

   private final Component.Identifier getIdentifier(int var1, int var2, int var3) {
      switch(var1) {
      case 1:
         return Component.Identifier.Axis.X;
      case 2:
         return Component.Identifier.Axis.Y;
      case 3:
         return Component.Identifier.Axis.Z;
      case 4:
         return Component.Identifier.Axis.RX;
      case 5:
         return Component.Identifier.Axis.RY;
      case 6:
         return Component.Identifier.Axis.RZ;
      case 7:
         return Component.Identifier.Axis.SLIDER;
      case 8:
         return this.getNextButtonIdentifier();
      case 9:
         return getKeyIdentifier(var3);
      case 10:
         return Component.Identifier.Axis.POV;
      default:
         return Component.Identifier.Axis.UNKNOWN;
      }
   }

   private static final native int nAcquire(long var0);

   public final void registerComponent(DIDeviceObject var1, DIComponent var2) {
      this.object_to_component.put(var1, var2);
   }

   public final int getType() {
      return this.dev_type;
   }

   private final void addObject(byte[] var1, int var2, int var3, int var4, int var5, int var6, String var7) throws IOException {
      Component.Identifier var8 = this.getIdentifier(var2, var4, var5);
      int var9 = this.current_format_offset++;
      DIDeviceObject var10 = new DIDeviceObject(this, var8, var1, var2, var3, var4, var5, var6, var7, var9);
      this.objects.add(var10);
   }

   private final native int nEnumObjects(long var1, int var3);

   private static final native int nSetBufferSize(long var0, int var2);

   private final boolean getDeviceData(DataQueue var1) throws IOException {
      int var2 = nGetDeviceData(this.address, 0, var1, var1.getElements(), var1.position(), var1.remaining());
      if (var2 != 0 && var2 != 1) {
         if (var2 == -2147024868) {
            this.acquire();
            return false;
         } else {
            throw new IOException("Failed to get device data (" + Integer.toHexString(var2) + ")");
         }
      } else {
         return true;
      }
   }

   private final void unacquire() throws IOException {
      int var1 = nUnacquire(this.address);
      if (var1 != 0 && var1 != 1) {
         throw new IOException("Failed to unAcquire device (" + Integer.toHexString(var1) + ")");
      }
   }

   private final Rumbler createPeriodicRumbler(DIDeviceObject[] var1, long[] var2, DIEffectInfo var3) throws IOException {
      int[] var4 = new int[var1.length];

      for(int var5 = 0; var5 < var4.length; ++var5) {
         var4[var5] = var1[var5].getDIIdentifier();
      }

      long var7 = nCreatePeriodicEffect(this.address, var3.getGUID(), 17, -1, 0, 10000, -1, 0, var4, var2, 0, 0, 0, 0, 10000, 0, 0, 50000, 0);
      return new IDirectInputEffect(var7, var3);
   }

   private static final native int nGetRangeProperty(long var0, int var2, long[] var3);

   private final void enumEffects() throws IOException {
      int var1 = this.nEnumEffects(this.address, 0);
      if (var1 != 0) {
         throw new IOException("Failed to enumerate effects (" + Integer.toHexString(var1) + ")");
      }
   }

   public final synchronized void setCooperativeLevel(int var1) throws IOException {
      this.checkReleased();
      int var2 = nSetCooperativeLevel(this.address, this.window.getHwnd(), var1);
      if (var2 != 0) {
         throw new IOException("Failed to set cooperative level (" + Integer.toHexString(var2) + ")");
      }
   }

   private final void getDeviceState(int[] var1) throws IOException {
      int var2 = nGetDeviceState(this.address, var1);
      if (var2 != 0) {
         if (var2 == -2147024868) {
            Arrays.fill(var1, 0);
            this.acquire();
         } else {
            throw new IOException("Failed to get device state (" + Integer.toHexString(var2) + ")");
         }
      }
   }

   private static final native int nGetDeviceState(long var0, int[] var2);

   private final void checkReleased() throws IOException {
      if (this.released) {
         throw new IOException("Device is released");
      }
   }

   private final DIDeviceObject lookupObjectByGUID(int var1) {
      for(int var2 = 0; var2 < this.objects.size(); ++var2) {
         DIDeviceObject var3 = (DIDeviceObject)this.objects.get(var2);
         if (var1 == var3.getGUIDType()) {
            return var3;
         }
      }

      return null;
   }

   private static final native int nGetDeviceData(long var0, int var2, DataQueue var3, Object[] var4, int var5, int var6);

   private static final native long nCreatePeriodicEffect(long var0, byte[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int[] var9, long[] var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19) throws IOException;

   public IDirectInputDevice(DummyWindow var1, long var2, byte[] var4, byte[] var5, int var6, int var7, String var8, String var9) throws IOException {
      this.window = var1;
      this.address = var2;
      this.product_name = var9;
      this.instance_name = var8;
      this.dev_type = var6;
      this.dev_subtype = var7;
      this.enumObjects();

      try {
         this.enumEffects();
         this.createRumblers();
      } catch (IOException var15) {
         DirectInputEnvironmentPlugin.logln("Failed to create rumblers: " + var15.getMessage());
      }

      boolean var10 = true;
      boolean var11 = false;

      int var12;
      for(var12 = 0; var12 < this.objects.size(); ++var12) {
         DIDeviceObject var13 = (DIDeviceObject)this.objects.get(var12);
         if (var13.isAxis()) {
            var11 = true;
            if (!var13.isRelative()) {
               var10 = false;
               break;
            }
         }
      }

      this.axes_in_relative_mode = var10 && var11;
      var12 = var10 ? 2 : 1;
      this.setDataFormat(var12);
      if (this.rumblers.size() > 0) {
         try {
            this.setCooperativeLevel(9);
         } catch (IOException var14) {
            this.setCooperativeLevel(10);
         }
      } else {
         this.setCooperativeLevel(10);
      }

      this.setBufferSize(32);
      this.acquire();
      this.device_state = new int[this.objects.size()];
   }

   public final Rumbler[] getRumblers() {
      return (Rumbler[])((Rumbler[])this.rumblers.toArray(new Rumbler[0]));
   }

   private static final Component.Identifier.Key getKeyIdentifier(int var0) {
      return DIIdentifierMap.getKeyIdentifier(var0);
   }

   protected void finalize() {
      this.release();
   }

   public final synchronized void setBufferSize(int var1) throws IOException {
      this.checkReleased();
      this.unacquire();
      int var2 = nSetBufferSize(this.address, var1);
      if (var2 != 0 && var2 != 1 && var2 != 2) {
         throw new IOException("Failed to set buffer size (" + Integer.toHexString(var2) + ")");
      } else {
         this.queue = new DataQueue(var1, class$net$java$games$input$DIDeviceObjectData == null ? (class$net$java$games$input$DIDeviceObjectData = class$("net.java.games.input.DIDeviceObjectData")) : class$net$java$games$input$DIDeviceObjectData);
         this.queue.position(this.queue.limit());
         this.acquire();
      }
   }

   private static final native int nPoll(long var0) throws IOException;

   public final synchronized void release() {
      if (!this.released) {
         this.released = true;

         for(int var1 = 0; var1 < this.rumblers.size(); ++var1) {
            IDirectInputEffect var2 = (IDirectInputEffect)this.rumblers.get(var1);
            var2.release();
         }

         nRelease(this.address);
      }

   }

   public final String getProductName() {
      return this.product_name;
   }

   public final synchronized int getDeadzoneProperty(int var1) throws IOException {
      this.checkReleased();
      return nGetDeadzoneProperty(this.address, var1);
   }

   private static final native void nRelease(long var0);

   private final void acquire() throws IOException {
      int var1 = nAcquire(this.address);
      if (var1 != 0 && var1 != -2147024891 && var1 != 1) {
         throw new IOException("Failed to acquire device (" + Integer.toHexString(var1) + ")");
      }
   }

   public final int getPollData(DIDeviceObject var1) {
      return this.device_state[var1.getFormatOffset()];
   }

   private final void poll() throws IOException {
      int var1 = nPoll(this.address);
      if (var1 != 0 && var1 != 1) {
         if (var1 == -2147024868) {
            this.acquire();
         } else {
            throw new IOException("Failed to poll device (" + Integer.toHexString(var1) + ")");
         }
      }
   }

   private final List createRumblers() throws IOException {
      DIDeviceObject var1 = this.lookupObjectByGUID(1);
      if (var1 == null) {
         return this.rumblers;
      } else {
         DIDeviceObject[] var2 = new DIDeviceObject[]{var1};
         long[] var3 = new long[]{0L};

         for(int var4 = 0; var4 < this.effects.size(); ++var4) {
            DIEffectInfo var5 = (DIEffectInfo)this.effects.get(var4);
            if ((var5.getEffectType() & 255) == 3 && (var5.getDynamicParams() & 4) != 0) {
               this.rumblers.add(this.createPeriodicRumbler(var2, var3, var5));
            }
         }

         return this.rumblers;
      }
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw (new NoClassDefFoundError()).initCause(var2);
      }
   }

   private static final native int nUnacquire(long var0);

   public final List getObjects() {
      return this.objects;
   }

   private final void enumObjects() throws IOException {
      int var1 = this.nEnumObjects(this.address, 31);
      if (var1 != 0) {
         throw new IOException("Failed to enumerate objects (" + Integer.toHexString(var1) + ")");
      }
   }

   public final synchronized void pollAll() throws IOException {
      this.checkReleased();
      this.poll();
      this.getDeviceState(this.device_state);
      this.queue.compact();
      this.getDeviceData(this.queue);
      this.queue.flip();
   }

   public final synchronized boolean getNextEvent(DIDeviceObjectData var1) {
      DIDeviceObjectData var2 = (DIDeviceObjectData)this.queue.get();
      if (var2 == null) {
         return false;
      } else {
         var1.set(var2);
         return true;
      }
   }

   public final DIDeviceObject mapEvent(DIDeviceObjectData var1) {
      int var2 = var1.getFormatOffset() / 4;
      return (DIDeviceObject)this.objects.get(var2);
   }

   private final native int nEnumEffects(long var1, int var3);

   private static final native int nSetCooperativeLevel(long var0, long var2, int var4);

   public final boolean areAxesRelative() {
      return this.axes_in_relative_mode;
   }

   private final void addEffect(byte[] var1, int var2, int var3, int var4, int var5, String var6) {
      this.effects.add(new DIEffectInfo(this, var1, var2, var3, var4, var5, var6));
   }

   private final Component.Identifier.Button getNextButtonIdentifier() {
      int var1 = this.button_counter++;
      return DIIdentifierMap.getButtonIdentifier(var1);
   }

   public final DIComponent mapObject(DIDeviceObject var1) {
      return (DIComponent)this.object_to_component.get(var1);
   }

   private static final native int nGetDeadzoneProperty(long var0, int var2) throws IOException;
}
