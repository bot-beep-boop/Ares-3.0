package net.minecraft.launchwrapper.injector;

import java.io.File;
import java.util.Iterator;
import java.util.ListIterator;
import javax.imageio.ImageIO;
import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraft.launchwrapper.Launch;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TableSwitchInsnNode;
import org.objectweb.asm.tree.VarInsnNode;

public class IndevVanillaTweakInjector implements IClassTransformer {
   public static File inject() {
      System.out.println("Turning of ImageIO disk-caching");
      ImageIO.setUseCache(false);
      VanillaTweakInjector.loadIconsOnFrames();
      System.out.println("Setting gameDir to: " + Launch.minecraftHome);
      return Launch.minecraftHome;
   }

   public byte[] transform(String var1, String var2, byte[] var3) {
      if (var3 == null) {
         return null;
      } else {
         ClassNode var4 = new ClassNode();
         ClassReader var5 = new ClassReader(var3);
         var5.accept(var4, 8);
         if (!var4.interfaces.contains("java/lang/Runnable")) {
            return var3;
         } else {
            MethodNode var6 = null;
            Iterator var8 = var4.methods.iterator();

            while(var8.hasNext()) {
               MethodNode var7 = (MethodNode)var8.next();
               if ("run".equals(var7.name)) {
                  var6 = var7;
                  break;
               }
            }

            if (var6 == null) {
               return var3;
            } else {
               System.out.println("Probably the minecraft class (it has run && is applet!): " + var1);
               ListIterator var11 = var6.instructions.iterator();
               int var12 = -1;

               while(true) {
                  while(var11.hasNext()) {
                     AbstractInsnNode var9 = (AbstractInsnNode)var11.next();
                     if (var9.getOpcode() == 170) {
                        TableSwitchInsnNode var14 = (TableSwitchInsnNode)var9;
                        var12 = var6.instructions.indexOf((AbstractInsnNode)var14.labels.get(0));
                     } else if (var12 >= 0 && var6.instructions.indexOf(var9) == var12) {
                        int var10 = -1;

                        while(var11.hasNext()) {
                           var9 = (AbstractInsnNode)var11.next();
                           if (var9.getOpcode() == 167) {
                              var10 = var6.instructions.indexOf(((JumpInsnNode)var9).label);
                              break;
                           }
                        }

                        if (var10 >= 0) {
                           while(var6.instructions.indexOf(var9) != var10 && var11.hasNext()) {
                              var9 = (AbstractInsnNode)var11.next();
                           }

                           var9 = (AbstractInsnNode)var11.next();
                           var6.instructions.insertBefore(var9, new MethodInsnNode(184, "net/minecraft/launchwrapper/injector/IndevVanillaTweakInjector", "inject", "()Ljava/io/File;"));
                           var6.instructions.insertBefore(var9, new VarInsnNode(58, 2));
                        }
                     }
                  }

                  ClassWriter var13 = new ClassWriter(3);
                  var4.accept(var13);
                  return var13.toByteArray();
               }
            }
         }
      }
   }
}
