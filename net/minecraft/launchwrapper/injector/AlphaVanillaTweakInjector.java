package net.minecraft.launchwrapper.injector;

import java.applet.Applet;
import java.applet.AppletStub;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraft.launchwrapper.Launch;

public class AlphaVanillaTweakInjector implements IClassTransformer {
   private static Field getWorkingDirField(String var0) throws ClassNotFoundException {
      Class var1 = getaClass(var0);
      Field[] var5;
      int var4 = (var5 = var1.getDeclaredFields()).length;

      for(int var3 = 0; var3 < var4; ++var3) {
         Field var2 = var5[var3];
         if (Modifier.isStatic(var2.getModifiers()) && var2.getType().getName().equals("java.io.File")) {
            return var2;
         }
      }

      return null;
   }

   public static void main(String[] var0) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, ClassNotFoundException {
      Class var1;
      try {
         var1 = getaClass("net.minecraft.client.MinecraftApplet");
      } catch (ClassNotFoundException var10) {
         var1 = getaClass("com.mojang.minecraft.MinecraftApplet");
      }

      System.out.println("AlphaVanillaTweakInjector.class.getClassLoader() = " + AlphaVanillaTweakInjector.class.getClassLoader());
      Constructor var2 = var1.getConstructor();
      Object var3 = var2.newInstance();
      Field[] var7;
      int var6 = (var7 = var1.getDeclaredFields()).length;

      for(int var5 = 0; var5 < var6; ++var5) {
         Field var4 = var7[var5];
         String var8 = var4.getType().getName();
         if (!var8.contains("awt") && !var8.contains("java") && !var8.equals("long")) {
            System.out.println("Found likely Minecraft candidate: " + var4);
            Field var9 = getWorkingDirField(var8);
            if (var9 != null) {
               System.out.println("Found File, changing to " + Launch.minecraftHome);
               var9.setAccessible(true);
               var9.set((Object)null, Launch.minecraftHome);
               break;
            }
         }
      }

      startMinecraft((Applet)var3, var0);
   }

   private static void startMinecraft(Applet var0, String[] var1) {
      HashMap var2 = new HashMap();
      String var3 = "Player" + System.currentTimeMillis() % 1000L;
      if (var1.length > 0) {
         var3 = var1[0];
      }

      String var4 = "-";
      if (var1.length > 1) {
         var4 = var1[1];
      }

      var2.put("username", var3);
      var2.put("sessionid", var4);
      Frame var5 = new Frame();
      var5.setTitle("Minecraft");
      var5.setBackground(Color.BLACK);
      JPanel var6 = new JPanel();
      var5.setLayout(new BorderLayout());
      var6.setPreferredSize(new Dimension(854, 480));
      var5.add(var6, "Center");
      var5.pack();
      var5.setLocationRelativeTo((Component)null);
      var5.setVisible(true);
      var5.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent var1) {
            System.exit(1);
         }
      });

      class LauncherFake extends Applet implements AppletStub {
         private final Map val$params;
         private static final long serialVersionUID = 1L;

         public URL getCodeBase() {
            try {
               return new URL("http://www.minecraft.net/game/");
            } catch (MalformedURLException var2) {
               var2.printStackTrace();
               return null;
            }
         }

         public String getParameter(String var1) {
            if (this.val$params.containsKey(var1)) {
               return (String)this.val$params.get(var1);
            } else {
               System.err.println("Client asked for parameter: " + var1);
               return null;
            }
         }

         public boolean isActive() {
            return true;
         }

         public void appletResize(int var1, int var2) {
         }

         LauncherFake(Map var1) {
            this.val$params = var1;
         }

         public URL getDocumentBase() {
            try {
               return new URL("http://www.minecraft.net/game/");
            } catch (MalformedURLException var2) {
               var2.printStackTrace();
               return null;
            }
         }
      }

      LauncherFake var7 = new LauncherFake(var2);
      var0.setStub(var7);
      var7.setLayout(new BorderLayout());
      var7.add(var0, "Center");
      var7.validate();
      var5.removeAll();
      var5.setLayout(new BorderLayout());
      var5.add(var7, "Center");
      var5.validate();
      var0.init();
      var0.start();
      Runtime.getRuntime().addShutdownHook(new Thread(var0) {
         private final Applet val$applet;

         {
            this.val$applet = var1;
         }

         public void run() {
            this.val$applet.stop();
         }
      });
      VanillaTweakInjector.loadIconsOnFrames();
   }

   public byte[] transform(String var1, String var2, byte[] var3) {
      return var3;
   }

   private static Class<?> getaClass(String var0) throws ClassNotFoundException {
      return Launch.classLoader.findClass(var0);
   }
}
