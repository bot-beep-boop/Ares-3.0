package net.java.games.input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WinTabDevice extends AbstractController {
   private List eventList = new ArrayList();
   private WinTabContext context;

   protected boolean getNextDeviceEvent(Event var1) throws IOException {
      if (this.eventList.size() > 0) {
         Event var2 = (Event)this.eventList.remove(0);
         var1.set(var2);
         return true;
      } else {
         return false;
      }
   }

   protected void pollDevice() throws IOException {
      this.context.processEvents();
      super.pollDevice();
   }

   private static final native int[] nGetAxisDetails(int var0, int var1);

   public Controller.Type getType() {
      return Controller.Type.TRACKPAD;
   }

   private static final native int nGetMaxButtonCount(int var0);

   private static final native String nGetName(int var0);

   public static WinTabDevice createDevice(WinTabContext var0, int var1) {
      String var2 = nGetName(var1);
      WinTabEnvironmentPlugin.logln("Device " + var1 + ", name: " + var2);
      ArrayList var3 = new ArrayList();
      int[] var4 = nGetAxisDetails(var1, 1);
      if (var4.length == 0) {
         WinTabEnvironmentPlugin.logln("ZAxis not supported");
      } else {
         WinTabEnvironmentPlugin.logln("Xmin: " + var4[0] + ", Xmax: " + var4[1]);
         var3.addAll(WinTabComponent.createComponents(var0, var1, 1, var4));
      }

      var4 = nGetAxisDetails(var1, 2);
      if (var4.length == 0) {
         WinTabEnvironmentPlugin.logln("YAxis not supported");
      } else {
         WinTabEnvironmentPlugin.logln("Ymin: " + var4[0] + ", Ymax: " + var4[1]);
         var3.addAll(WinTabComponent.createComponents(var0, var1, 2, var4));
      }

      var4 = nGetAxisDetails(var1, 3);
      if (var4.length == 0) {
         WinTabEnvironmentPlugin.logln("ZAxis not supported");
      } else {
         WinTabEnvironmentPlugin.logln("Zmin: " + var4[0] + ", Zmax: " + var4[1]);
         var3.addAll(WinTabComponent.createComponents(var0, var1, 3, var4));
      }

      var4 = nGetAxisDetails(var1, 4);
      if (var4.length == 0) {
         WinTabEnvironmentPlugin.logln("NPressureAxis not supported");
      } else {
         WinTabEnvironmentPlugin.logln("NPressMin: " + var4[0] + ", NPressMax: " + var4[1]);
         var3.addAll(WinTabComponent.createComponents(var0, var1, 4, var4));
      }

      var4 = nGetAxisDetails(var1, 5);
      if (var4.length == 0) {
         WinTabEnvironmentPlugin.logln("TPressureAxis not supported");
      } else {
         WinTabEnvironmentPlugin.logln("TPressureAxismin: " + var4[0] + ", TPressureAxismax: " + var4[1]);
         var3.addAll(WinTabComponent.createComponents(var0, var1, 5, var4));
      }

      var4 = nGetAxisDetails(var1, 6);
      if (var4.length == 0) {
         WinTabEnvironmentPlugin.logln("OrientationAxis not supported");
      } else {
         WinTabEnvironmentPlugin.logln("OrientationAxis mins/maxs: " + var4[0] + "," + var4[1] + ", " + var4[2] + "," + var4[3] + ", " + var4[4] + "," + var4[5]);
         var3.addAll(WinTabComponent.createComponents(var0, var1, 6, var4));
      }

      var4 = nGetAxisDetails(var1, 7);
      if (var4.length == 0) {
         WinTabEnvironmentPlugin.logln("RotationAxis not supported");
      } else {
         WinTabEnvironmentPlugin.logln("RotationAxis is supported (by the device, not by this plugin)");
         var3.addAll(WinTabComponent.createComponents(var0, var1, 7, var4));
      }

      String[] var5 = nGetCursorNames(var1);
      var3.addAll(WinTabComponent.createCursors(var0, var1, var5));

      int var6;
      for(var6 = 0; var6 < var5.length; ++var6) {
         WinTabEnvironmentPlugin.logln("Cursor " + var6 + "'s name: " + var5[var6]);
      }

      var6 = nGetMaxButtonCount(var1);
      WinTabEnvironmentPlugin.logln("Device has " + var6 + " buttons");
      var3.addAll(WinTabComponent.createButtons(var0, var1, var6));
      Component[] var7 = (Component[])((Component[])var3.toArray(new Component[0]));
      return new WinTabDevice(var0, var1, var2, var7);
   }

   private static final native String[] nGetCursorNames(int var0);

   private WinTabDevice(WinTabContext var1, int var2, String var3, Component[] var4) {
      super(var3, var4, new Controller[0], new Rumbler[0]);
      this.context = var1;
   }

   public void processPacket(WinTabPacket var1) {
      Component[] var2 = this.getComponents();

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Event var4 = ((WinTabComponent)var2[var3]).processPacket(var1);
         if (var4 != null) {
            this.eventList.add(var4);
         }
      }

   }
}
