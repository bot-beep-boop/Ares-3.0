package net.minecraft.launchwrapper.injector;

import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;
import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraft.launchwrapper.Launch;
import org.lwjgl.opengl.Display;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

public class VanillaTweakInjector implements IClassTransformer {
   private static ByteBuffer loadIcon(File var0) throws IOException {
      BufferedImage var1 = ImageIO.read(var0);
      int[] var2 = var1.getRGB(0, 0, var1.getWidth(), var1.getHeight(), (int[])null, 0, var1.getWidth());
      ByteBuffer var3 = ByteBuffer.allocate(4 * var2.length);
      int[] var7 = var2;
      int var6 = var2.length;

      for(int var5 = 0; var5 < var6; ++var5) {
         int var4 = var7[var5];
         var3.putInt(var4 << 8 | var4 >> 24 & 255);
      }

      var3.flip();
      return var3;
   }

   public static File inject() {
      System.out.println("Turning of ImageIO disk-caching");
      ImageIO.setUseCache(false);
      loadIconsOnFrames();
      System.out.println("Setting gameDir to: " + Launch.minecraftHome);
      return Launch.minecraftHome;
   }

   public byte[] transform(String var1, String var2, byte[] var3) {
      if (var3 == null) {
         return null;
      } else if (!"net.minecraft.client.Minecraft".equals(var1)) {
         return var3;
      } else {
         ClassNode var4 = new ClassNode();
         ClassReader var5 = new ClassReader(var3);
         var5.accept(var4, 8);
         MethodNode var6 = null;
         Iterator var8 = var4.methods.iterator();

         while(var8.hasNext()) {
            MethodNode var7 = (MethodNode)var8.next();
            if ("main".equals(var7.name)) {
               var6 = var7;
               break;
            }
         }

         if (var6 == null) {
            return var3;
         } else {
            FieldNode var11 = null;
            Iterator var9 = var4.fields.iterator();

            while(var9.hasNext()) {
               FieldNode var12 = (FieldNode)var9.next();
               String var10 = Type.getDescriptor(File.class);
               if (var10.equals(var12.desc) && (var12.access & 8) == 8) {
                  var11 = var12;
                  break;
               }
            }

            MethodNode var13 = new MethodNode();
            Label var14 = new Label();
            var13.visitLabel(var14);
            var13.visitLineNumber(9001, var14);
            var13.visitMethodInsn(184, "net/minecraft/launchwrapper/injector/VanillaTweakInjector", "inject", "()Ljava/io/File;");
            var13.visitFieldInsn(179, "net/minecraft/client/Minecraft", var11.name, "Ljava/io/File;");
            var6.instructions.insert(var13.instructions);
            ClassWriter var15 = new ClassWriter(3);
            var4.accept(var15);
            return var15.toByteArray();
         }
      }
   }

   public static void loadIconsOnFrames() {
      try {
         File var0 = new File(Launch.assetsDir, "icons/icon_16x16.png");
         File var1 = new File(Launch.assetsDir, "icons/icon_32x32.png");
         System.out.println("Loading current icons for window from: " + var0 + " and " + var1);
         Display.setIcon(new ByteBuffer[]{loadIcon(var0), loadIcon(var1)});
         Frame[] var2 = Frame.getFrames();
         if (var2 != null) {
            List var3 = Arrays.asList(ImageIO.read(var0), ImageIO.read(var1));
            Frame[] var7 = var2;
            int var6 = var2.length;

            for(int var5 = 0; var5 < var6; ++var5) {
               Frame var4 = var7[var5];

               try {
                  var4.setIconImages(var3);
               } catch (Throwable var9) {
                  var9.printStackTrace();
               }
            }
         }
      } catch (IOException var10) {
         var10.printStackTrace();
      }

   }
}
