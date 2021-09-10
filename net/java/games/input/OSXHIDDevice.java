package net.java.games.input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

final class OSXHIDDevice {
   private static final String kIOHIDElementHasNullStateKey = "HasNullState";
   private static final String kIOHIDElementUnitExponentKey = "UnitExponent";
   private static final String kIOHIDElementIsNonLinearKey = "IsNonLinear";
   private static final String kIOHIDProductKey = "Product";
   private static final String kIOHIDMaxInputReportSizeKey = "MaxInputReportSize";
   private static final String kIOHIDElementIsWrappingKey = "IsWrapping";
   private static final String kIOHIDElementParentCollectionKey = "ParentCollection";
   private static final String kIOHIDElementReportSizeKey = "ReportSize";
   private static final String kIOHIDPrimaryUsagePageKey = "PrimaryUsagePage";
   private final long device_interface_address;
   private static final int AXIS_DEFAULT_MAX_VALUE = 65536;
   private static final String kIOHIDElementScaledMaxKey = "ScaledMax";
   private static final String kIOHIDMaxOutputReportSizeKey = "MaxOutputReportSize";
   private static final String kIOHIDElementTypeKey = "Type";
   private static final String kIOHIDTransportKey = "Transport";
   private static final String kIOHIDPrimaryUsageKey = "PrimaryUsage";
   private static final String kIOHIDElementUsagePageKey = "UsagePage";
   private static final String kIOHIDElementHasPreferredStateKey = "HasPreferredState";
   private static final String kIOHIDElementReportCountKey = "ReportCount";
   private static final String kIOHIDProductIDKey = "ProductID";
   private static final String kIOHIDElementCollectionTypeKey = "CollectionType";
   private static final String kIOHIDDeviceUsageKey = "DeviceUsage";
   private static final String kIOHIDElementIsArrayKey = "IsArray";
   private static final int AXIS_DEFAULT_MIN_VALUE = 0;
   private static final String kIOHIDCountryCodeKey = "CountryCode";
   private static final String kIOHIDManufacturerKey = "Manufacturer";
   private static final String kIOHIDDeviceUsagePageKey = "DeviceUsagePage";
   private static final String kIOHIDElementMinKey = "Min";
   private static final String kIOHIDElementScaledMinKey = "ScaledMin";
   private static final String kIOHIDElementValueLocationKey = "ValueLocation";
   private final Map properties;
   private static final String kIOHIDMaxFeatureReportSizeKey = "MaxFeatureReportSize";
   private static final String kIOHIDVersionNumberKey = "VersionNumber";
   private static final String kIOHIDElementKey = "Elements";
   private static final String kIOHIDVendorIDSourceKey = "VendorIDSource";
   private static final String kIOHIDElementUsageKey = "Usage";
   private static final String kIOHIDElementNameKey = "Name";
   private static final String kIOHIDElementMaxKey = "Max";
   private static final Logger log;
   private static final String kIOHIDElementIsRelativeKey = "IsRelative";
   private static final String kIOHIDElementDuplicateIndexKey = "DuplicateIndex";
   private static final String kIOHIDLocationIDKey = "LocationID";
   private final long device_address;
   private static final String kIOHIDElementCookieKey = "ElementCookie";
   static Class class$net$java$games$input$OSXHIDDevice;
   private static final String kIOHIDSerialNumberKey = "SerialNumber";
   private static final String kIOHIDDeviceUsagePairsKey = "DeviceUsagePairs";
   private static final String kIOHIDElementUnitKey = "Unit";
   private static final String kIOHIDVendorIDKey = "VendorID";
   private boolean released;
   private static final String kIOHIDElementReportIDKey = "ReportID";
   private static final String kIOHIDElementSizeKey = "Size";

   private static final long getLongFromProperties(Map var0, String var1, long var2) {
      Long var4 = (Long)var0.get(var1);
      return var4 == null ? var2 : var4;
   }

   private final void dumpProperties() {
      log.info(this.toString());
      dumpMap("", this.properties);
   }

   private static final UsagePair createUsagePair(int var0, int var1) {
      UsagePage var2 = UsagePage.map(var0);
      if (var2 != null) {
         Usage var3 = var2.mapUsage(var1);
         if (var3 != null) {
            return new UsagePair(var2, var3);
         }
      }

      return null;
   }

   private static final void dumpObject(String var0, Object var1) {
      if (var1 instanceof Long) {
         Long var2 = (Long)var1;
         log.info(var0 + "0x" + Long.toHexString(var2));
      } else if (var1 instanceof Map) {
         dumpMap(var0, (Map)var1);
      } else if (var1.getClass().isArray()) {
         dumpArray(var0, (Object[])((Object[])var1));
      } else {
         log.info(var0 + var1);
      }

   }

   private static final native long nCreateQueue(long var0) throws IOException;

   public final UsagePair getUsagePair() {
      int var1 = getIntFromProperties(this.properties, "PrimaryUsagePage");
      int var2 = getIntFromProperties(this.properties, "PrimaryUsage");
      return createUsagePair(var1, var2);
   }

   public final List getElements() {
      ArrayList var1 = new ArrayList();
      this.addElements(var1, this.properties);
      return var1;
   }

   public final Controller.PortType getPortType() {
      String var1 = (String)this.properties.get("Transport");
      if (var1 == null) {
         return Controller.PortType.UNKNOWN;
      } else {
         return var1.equals("USB") ? Controller.PortType.USB : Controller.PortType.UNKNOWN;
      }
   }

   public final String getProductName() {
      return (String)this.properties.get("Product");
   }

   private static final native Map nGetDeviceProperties(long var0) throws IOException;

   private static final native void nReleaseDevice(long var0, long var2);

   private final OSXHIDElement createElementFromElementProperties(Map var1) {
      long var2 = getLongFromProperties(var1, "ElementCookie");
      int var4 = getIntFromProperties(var1, "Type");
      ElementType var5 = ElementType.map(var4);
      int var6 = (int)getLongFromProperties(var1, "Min", 0L);
      int var7 = (int)getLongFromProperties(var1, "Max", 65536L);
      UsagePair var8 = this.getUsagePair();
      boolean var9 = var8 != null && (var8.getUsage() == GenericDesktopUsage.POINTER || var8.getUsage() == GenericDesktopUsage.MOUSE);
      boolean var10 = getBooleanFromProperties(var1, "IsRelative", var9);
      int var11 = getIntFromProperties(var1, "Usage");
      int var12 = getIntFromProperties(var1, "UsagePage");
      UsagePair var13 = createUsagePair(var12, var11);
      return var13 != null && (var5 == ElementType.INPUT_MISC || var5 == ElementType.INPUT_BUTTON || var5 == ElementType.INPUT_AXIS) ? new OSXHIDElement(this, var13, var2, var5, var6, var7, var10) : null;
   }

   private static final void dumpMap(String var0, Map var1) {
      Iterator var2 = var1.keySet().iterator();

      while(var2.hasNext()) {
         Object var3 = var2.next();
         Object var4 = var1.get(var3);
         dumpObject(var0, var3);
         dumpObject(var0 + "\t", var4);
      }

   }

   private final void addElements(List var1, Map var2) {
      Object[] var3 = (Object[])((Object[])var2.get("Elements"));
      if (var3 != null) {
         for(int var4 = 0; var4 < var3.length; ++var4) {
            Map var5 = (Map)var3[var4];
            OSXHIDElement var6 = this.createElementFromElementProperties(var5);
            if (var6 != null) {
               var1.add(var6);
            }

            this.addElements(var1, var5);
         }

      }
   }

   private static final native void nOpen(long var0) throws IOException;

   private static final native void nGetElementValue(long var0, long var2, OSXEvent var4) throws IOException;

   private static final long getLongFromProperties(Map var0, String var1) {
      Long var2 = (Long)var0.get(var1);
      return var2;
   }

   private static final void dumpArray(String var0, Object[] var1) {
      log.info(var0 + "{");

      for(int var2 = 0; var2 < var1.length; ++var2) {
         dumpObject(var0 + "\t", var1[var2]);
         log.info(var0 + ",");
      }

      log.info(var0 + "}");
   }

   private final void open() throws IOException {
      nOpen(this.device_interface_address);
   }

   public final synchronized void release() throws IOException {
      try {
         this.close();
      } finally {
         this.released = true;
         nReleaseDevice(this.device_address, this.device_interface_address);
      }

   }

   public final synchronized void getElementValue(long var1, OSXEvent var3) throws IOException {
      this.checkReleased();
      nGetElementValue(this.device_interface_address, var1, var3);
   }

   public final synchronized OSXHIDQueue createQueue(int var1) throws IOException {
      this.checkReleased();
      long var2 = nCreateQueue(this.device_interface_address);
      return new OSXHIDQueue(var2, var1);
   }

   private static final boolean getBooleanFromProperties(Map var0, String var1, boolean var2) {
      return getLongFromProperties(var0, var1, var2 ? 1L : 0L) != 0L;
   }

   private final Map getDeviceProperties() throws IOException {
      return nGetDeviceProperties(this.device_address);
   }

   private static final int getIntFromProperties(Map var0, String var1) {
      return (int)getLongFromProperties(var0, var1);
   }

   public OSXHIDDevice(long var1, long var3) throws IOException {
      this.device_address = var1;
      this.device_interface_address = var3;
      this.properties = this.getDeviceProperties();
      this.open();
   }

   static {
      log = Logger.getLogger((class$net$java$games$input$OSXHIDDevice == null ? (class$net$java$games$input$OSXHIDDevice = class$("net.java.games.input.OSXHIDDevice")) : class$net$java$games$input$OSXHIDDevice).getName());
   }

   private final void checkReleased() throws IOException {
      if (this.released) {
         throw new IOException();
      }
   }

   private final void close() throws IOException {
      nClose(this.device_interface_address);
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw (new NoClassDefFoundError()).initCause(var2);
      }
   }

   private static final native void nClose(long var0) throws IOException;
}
