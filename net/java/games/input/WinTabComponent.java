package net.java.games.input;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WinTabComponent extends AbstractComponent {
   private int max;
   protected float lastKnownValue;
   public static final int ZAxis = 3;
   private boolean analog;
   public static final int XAxis = 1;
   private int min;
   public static final int NPressureAxis = 4;
   public static final int YAxis = 2;
   public static final int OrientationAxis = 6;
   public static final int TPressureAxis = 5;
   static Class class$net$java$games$input$Component$Identifier$Button;
   public static final int RotationAxis = 7;

   public static Collection createButtons(WinTabContext var0, int var1, int var2) {
      ArrayList var3 = new ArrayList();

      for(int var5 = 0; var5 < var2; ++var5) {
         try {
            Class var6 = class$net$java$games$input$Component$Identifier$Button == null ? (class$net$java$games$input$Component$Identifier$Button = class$("net.java.games.input.Component$Identifier$Button")) : class$net$java$games$input$Component$Identifier$Button;
            Field var7 = var6.getField("_" + var5);
            Component.Identifier var4 = (Component.Identifier)var7.get((Object)null);
            var3.add(new WinTabButtonComponent(var0, var1, var4.getName(), var4, var5));
         } catch (SecurityException var8) {
            var8.printStackTrace();
         } catch (NoSuchFieldException var9) {
            var9.printStackTrace();
         } catch (IllegalArgumentException var10) {
            var10.printStackTrace();
         } catch (IllegalAccessException var11) {
            var11.printStackTrace();
         }
      }

      return var3;
   }

   public static List createComponents(WinTabContext var0, int var1, int var2, int[] var3) {
      ArrayList var4 = new ArrayList();
      Component.Identifier.Axis var5;
      switch(var2) {
      case 1:
         var5 = Component.Identifier.Axis.X;
         var4.add(new WinTabComponent(var0, var1, var5.getName(), var5, var3[0], var3[1]));
         break;
      case 2:
         var5 = Component.Identifier.Axis.Y;
         var4.add(new WinTabComponent(var0, var1, var5.getName(), var5, var3[0], var3[1]));
         break;
      case 3:
         var5 = Component.Identifier.Axis.Z;
         var4.add(new WinTabComponent(var0, var1, var5.getName(), var5, var3[0], var3[1]));
         break;
      case 4:
         var5 = Component.Identifier.Axis.X_FORCE;
         var4.add(new WinTabComponent(var0, var1, var5.getName(), var5, var3[0], var3[1]));
         break;
      case 5:
         var5 = Component.Identifier.Axis.Y_FORCE;
         var4.add(new WinTabComponent(var0, var1, var5.getName(), var5, var3[0], var3[1]));
         break;
      case 6:
         var5 = Component.Identifier.Axis.RX;
         var4.add(new WinTabComponent(var0, var1, var5.getName(), var5, var3[0], var3[1]));
         var5 = Component.Identifier.Axis.RY;
         var4.add(new WinTabComponent(var0, var1, var5.getName(), var5, var3[2], var3[3]));
         var5 = Component.Identifier.Axis.RZ;
         var4.add(new WinTabComponent(var0, var1, var5.getName(), var5, var3[4], var3[5]));
         break;
      case 7:
         var5 = Component.Identifier.Axis.RX;
         var4.add(new WinTabComponent(var0, var1, var5.getName(), var5, var3[0], var3[1]));
         var5 = Component.Identifier.Axis.RY;
         var4.add(new WinTabComponent(var0, var1, var5.getName(), var5, var3[2], var3[3]));
         var5 = Component.Identifier.Axis.RZ;
         var4.add(new WinTabComponent(var0, var1, var5.getName(), var5, var3[4], var3[5]));
      }

      return var4;
   }

   private float normalise(float var1) {
      if (this.max == this.min) {
         return var1;
      } else {
         float var2 = (float)(this.max - this.min);
         return (var1 - (float)this.min) / var2;
      }
   }

   public Event processPacket(WinTabPacket var1) {
      float var2 = this.lastKnownValue;
      if (this.getIdentifier() == Component.Identifier.Axis.X) {
         var2 = this.normalise((float)var1.PK_X);
      }

      if (this.getIdentifier() == Component.Identifier.Axis.Y) {
         var2 = this.normalise((float)var1.PK_Y);
      }

      if (this.getIdentifier() == Component.Identifier.Axis.Z) {
         var2 = this.normalise((float)var1.PK_Z);
      }

      if (this.getIdentifier() == Component.Identifier.Axis.X_FORCE) {
         var2 = this.normalise((float)var1.PK_NORMAL_PRESSURE);
      }

      if (this.getIdentifier() == Component.Identifier.Axis.Y_FORCE) {
         var2 = this.normalise((float)var1.PK_TANGENT_PRESSURE);
      }

      if (this.getIdentifier() == Component.Identifier.Axis.RX) {
         var2 = this.normalise((float)var1.PK_ORIENTATION_ALT);
      }

      if (this.getIdentifier() == Component.Identifier.Axis.RY) {
         var2 = this.normalise((float)var1.PK_ORIENTATION_AZ);
      }

      if (this.getIdentifier() == Component.Identifier.Axis.RZ) {
         var2 = this.normalise((float)var1.PK_ORIENTATION_TWIST);
      }

      if (var2 != this.getPollData()) {
         this.lastKnownValue = var2;
         Event var3 = new Event();
         var3.set(this, var2, var1.PK_TIME * 1000L);
         return var3;
      } else {
         return null;
      }
   }

   protected WinTabComponent(WinTabContext var1, int var2, String var3, Component.Identifier var4) {
      super(var3, var4);
      this.min = 0;
      this.max = 1;
      this.analog = false;
   }

   public boolean isRelative() {
      return false;
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw (new NoClassDefFoundError()).initCause(var2);
      }
   }

   protected float poll() throws IOException {
      return this.lastKnownValue;
   }

   public static Collection createCursors(WinTabContext var0, int var1, String[] var2) {
      ArrayList var4 = new ArrayList();

      for(int var5 = 0; var5 < var2.length; ++var5) {
         Component.Identifier.Button var3;
         if (var2[var5].matches("Puck")) {
            var3 = Component.Identifier.Button.TOOL_FINGER;
         } else if (var2[var5].matches("Eraser.*")) {
            var3 = Component.Identifier.Button.TOOL_RUBBER;
         } else {
            var3 = Component.Identifier.Button.TOOL_PEN;
         }

         var4.add(new WinTabCursorComponent(var0, var1, var3.getName(), var3, var5));
      }

      return var4;
   }

   public boolean isAnalog() {
      return this.analog;
   }

   protected WinTabComponent(WinTabContext var1, int var2, String var3, Component.Identifier var4, int var5, int var6) {
      super(var3, var4);
      this.min = var5;
      this.max = var6;
      this.analog = true;
   }
}
