import io.netty.util.internal.ThreadLocalRandom;
import java.util.Random;
import java.util.UUID;
import org.apache.commons.lang3.Validate;

public class qd {
   private boolean e;
   private final double a;
   private final int b;
   private final String c;
   private final UUID d;

   public String b() {
      return this.c;
   }

   public qd(UUID var1, String var2, double var3, int var5) {
      this.e = true;
      this.d = var1;
      this.c = var2;
      this.a = var3;
      this.b = var5;
      Validate.notEmpty(var2, "Modifier name cannot be empty", new Object[0]);
      Validate.inclusiveBetween(0L, 2L, (long)var5, "Invalid operation");
   }

   public int hashCode() {
      return this.d != null ? this.d.hashCode() : 0;
   }

   public boolean e() {
      return this.e;
   }

   public int c() {
      return this.b;
   }

   public UUID a() {
      return this.d;
   }

   public String toString() {
      return "AttributeModifier{amount=" + this.a + ", operation=" + this.b + ", name='" + this.c + '\'' + ", id=" + this.d + ", serialize=" + this.e + '}';
   }

   public double d() {
      return this.a;
   }

   public qd(String var1, double var2, int var4) {
      this(ns.a((Random)ThreadLocalRandom.current()), var1, var2, var4);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         qd var2 = (qd)var1;
         if (this.d != null) {
            if (this.d.equals(var2.d)) {
               return true;
            }
         } else if (var2.d == null) {
            return true;
         }

         return false;
      } else {
         return false;
      }
   }

   public qd a(boolean var1) {
      this.e = var1;
      return this;
   }
}
