package net.optifine.reflect;

import java.lang.reflect.Field;
import net.minecraft.src.Config;

public class FieldLocatorName implements IFieldLocator {
   private ReflectorClass reflectorClass = null;
   private String targetFieldName = null;

   public FieldLocatorName(ReflectorClass var1, String var2) {
      this.reflectorClass = var1;
      this.targetFieldName = var2;
   }

   private Field getDeclaredField(Class var1, String var2) throws NoSuchFieldException {
      Field[] var3 = var1.getDeclaredFields();

      for(int var4 = 0; var4 < var3.length; ++var4) {
         Field var5 = var3[var4];
         if (var5.getName().equals(var2)) {
            return var5;
         }
      }

      if (var1 == Object.class) {
         throw new NoSuchFieldException(var2);
      } else {
         return this.getDeclaredField(var1.getSuperclass(), var2);
      }
   }

   public Field getField() {
      Class var1 = this.reflectorClass.getTargetClass();
      if (var1 == null) {
         return null;
      } else {
         try {
            Field var2 = this.getDeclaredField(var1, this.targetFieldName);
            var2.setAccessible(true);
            return var2;
         } catch (NoSuchFieldException var3) {
            Config.log("(Reflector) Field not present: " + var1.getName() + "." + this.targetFieldName);
            return null;
         } catch (SecurityException var4) {
            var4.printStackTrace();
            return null;
         } catch (Throwable var5) {
            var5.printStackTrace();
            return null;
         }
      }
   }
}
