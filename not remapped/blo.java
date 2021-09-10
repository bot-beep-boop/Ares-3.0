import com.google.gson.JsonObject;
import org.lwjgl.opengl.GL14;

public class blo {
   private final int b;
   private final int d;
   private final boolean h;
   private final int f;
   private final int e;
   private final boolean g;
   private final int c;
   private static blo a = null;

   public blo() {
      this(false, true, 1, 0, 1, 0, 32774);
   }

   private static int b(String var0) {
      String var1 = var0.trim().toLowerCase();
      var1 = var1.replaceAll("_", "");
      var1 = var1.replaceAll("one", "1");
      var1 = var1.replaceAll("zero", "0");
      var1 = var1.replaceAll("minus", "-");
      if (var1.equals("0")) {
         return 0;
      } else if (var1.equals("1")) {
         return 1;
      } else if (var1.equals("srccolor")) {
         return 768;
      } else if (var1.equals("1-srccolor")) {
         return 769;
      } else if (var1.equals("dstcolor")) {
         return 774;
      } else if (var1.equals("1-dstcolor")) {
         return 775;
      } else if (var1.equals("srcalpha")) {
         return 770;
      } else if (var1.equals("1-srcalpha")) {
         return 771;
      } else if (var1.equals("dstalpha")) {
         return 772;
      } else {
         return var1.equals("1-dstalpha") ? 773 : -1;
      }
   }

   public blo(int var1, int var2, int var3, int var4, int var5) {
      this(true, false, var1, var2, var3, var4, var5);
   }

   private blo(boolean var1, boolean var2, int var3, int var4, int var5, int var6, int var7) {
      this.g = var1;
      this.b = var3;
      this.d = var4;
      this.c = var5;
      this.e = var6;
      this.h = var2;
      this.f = var7;
   }

   public static blo a(JsonObject var0) {
      if (var0 == null) {
         return new blo();
      } else {
         int var1 = 32774;
         int var2 = 1;
         int var3 = 0;
         int var4 = 1;
         int var5 = 0;
         boolean var6 = true;
         boolean var7 = false;
         if (ni.a(var0, "func")) {
            var1 = a(var0.get("func").getAsString());
            if (var1 != 32774) {
               var6 = false;
            }
         }

         if (ni.a(var0, "srcrgb")) {
            var2 = b(var0.get("srcrgb").getAsString());
            if (var2 != 1) {
               var6 = false;
            }
         }

         if (ni.a(var0, "dstrgb")) {
            var3 = b(var0.get("dstrgb").getAsString());
            if (var3 != 0) {
               var6 = false;
            }
         }

         if (ni.a(var0, "srcalpha")) {
            var4 = b(var0.get("srcalpha").getAsString());
            if (var4 != 1) {
               var6 = false;
            }

            var7 = true;
         }

         if (ni.a(var0, "dstalpha")) {
            var5 = b(var0.get("dstalpha").getAsString());
            if (var5 != 0) {
               var6 = false;
            }

            var7 = true;
         }

         if (var6) {
            return new blo();
         } else {
            return var7 ? new blo(var2, var3, var4, var5, var1) : new blo(var2, var3, var1);
         }
      }
   }

   public boolean b() {
      return this.h;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof blo)) {
         return false;
      } else {
         blo var2 = (blo)var1;
         if (this.f != var2.f) {
            return false;
         } else if (this.e != var2.e) {
            return false;
         } else if (this.d != var2.d) {
            return false;
         } else if (this.h != var2.h) {
            return false;
         } else if (this.g != var2.g) {
            return false;
         } else if (this.c != var2.c) {
            return false;
         } else {
            return this.b == var2.b;
         }
      }
   }

   public void a() {
      if (!this.equals(a)) {
         if (a == null || this.h != a.b()) {
            a = this;
            if (this.h) {
               bfl.k();
               return;
            }

            bfl.l();
         }

         GL14.glBlendEquation(this.f);
         if (this.g) {
            bfl.a(this.b, this.d, this.c, this.e);
         } else {
            bfl.b(this.b, this.d);
         }

      }
   }

   private static int a(String var0) {
      String var1 = var0.trim().toLowerCase();
      if (var1.equals("add")) {
         return 32774;
      } else if (var1.equals("subtract")) {
         return 32778;
      } else if (var1.equals("reversesubtract")) {
         return 32779;
      } else if (var1.equals("reverse_subtract")) {
         return 32779;
      } else if (var1.equals("min")) {
         return 32775;
      } else {
         return var1.equals("max") ? '耈' : '耆';
      }
   }

   public int hashCode() {
      int var1 = this.b;
      var1 = 31 * var1 + this.c;
      var1 = 31 * var1 + this.d;
      var1 = 31 * var1 + this.e;
      var1 = 31 * var1 + this.f;
      var1 = 31 * var1 + (this.g ? 1 : 0);
      var1 = 31 * var1 + (this.h ? 1 : 0);
      return var1;
   }

   public blo(int var1, int var2, int var3) {
      this(false, false, var1, var2, var1, var2, var3);
   }
}
