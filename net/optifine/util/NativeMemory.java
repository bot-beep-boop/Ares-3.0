package net.optifine.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.src.Config;

public class NativeMemory {
   private static LongSupplier bufferAllocatedSupplier = makeLongSupplier(new String[][]{{"sun.misc.SharedSecrets", "getJavaNioAccess", "getDirectBufferPool", "getMemoryUsed"}, {"jdk.internal.misc.SharedSecrets", "getJavaNioAccess", "getDirectBufferPool", "getMemoryUsed"}});
   private static LongSupplier bufferMaximumSupplier = makeLongSupplier(new String[][]{{"sun.misc.VM", "maxDirectMemory"}, {"jdk.internal.misc.VM", "maxDirectMemory"}});

   private static LongSupplier makeLongSupplier(String[] var0) throws Exception {
      if (var0.length < 2) {
         return null;
      } else {
         Class var1 = Class.forName(var0[0]);
         Method var2 = var1.getMethod(var0[1]);
         var2.setAccessible(true);
         Object var3 = null;

         for(int var4 = 2; var4 < var0.length; ++var4) {
            String var5 = var0[var4];
            var3 = var2.invoke(var3);
            var2 = var3.getClass().getMethod(var5);
            var2.setAccessible(true);
         }

         LongSupplier var6 = new LongSupplier(var2, var3) {
            private final Method val$method1;
            private final Object val$o;
            private boolean disabled;

            public long getAsLong() {
               if (this.disabled) {
                  return -1L;
               } else {
                  try {
                     return (Long)this.val$method1.invoke(this.val$o);
                  } catch (Throwable var2) {
                     Config.warn(var2.getClass().getName() + ": " + var2.getMessage());
                     this.disabled = true;
                     return -1L;
                  }
               }
            }

            {
               this.val$method1 = var1;
               this.val$o = var2;
               this.disabled = false;
            }
         };
         return var6;
      }
   }

   public static long getBufferAllocated() {
      return bufferAllocatedSupplier == null ? -1L : bufferAllocatedSupplier.getAsLong();
   }

   public static long getBufferMaximum() {
      return bufferMaximumSupplier == null ? -1L : bufferMaximumSupplier.getAsLong();
   }

   private static LongSupplier makeLongSupplier(String[][] var0) {
      ArrayList var1 = new ArrayList();
      int var2 = 0;

      while(var2 < var0.length) {
         String[] var3 = var0[var2];

         try {
            LongSupplier var4 = makeLongSupplier(var3);
            return var4;
         } catch (Throwable var5) {
            var1.add(var5);
            ++var2;
         }
      }

      Iterator var7 = var1.iterator();

      while(var7.hasNext()) {
         Throwable var6 = (Throwable)var7.next();
         Config.warn(var6.getClass().getName() + ": " + var6.getMessage());
      }

      return null;
   }
}
