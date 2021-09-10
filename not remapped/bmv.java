import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bmv {
   private int d;
   private final bmv.a b;
   private int e;
   private static final Logger a = LogManager.getLogger();
   private final bmv.b c;

   public bmv(int var1, bmv.a var2, bmv.b var3, int var4) {
      if (!this.a(var1, var3)) {
         a.warn("Multiple vertex elements of the same type other than UVs are not supported. Forcing type to UV.");
         this.c = bmv.b.d;
      } else {
         this.c = var3;
      }

      this.b = var2;
      this.d = var1;
      this.e = var4;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         bmv var2 = (bmv)var1;
         if (this.e != var2.e) {
            return false;
         } else if (this.d != var2.d) {
            return false;
         } else if (this.b != var2.b) {
            return false;
         } else {
            return this.c == var2.c;
         }
      } else {
         return false;
      }
   }

   public final bmv.a a() {
      return this.b;
   }

   public String toString() {
      return this.e + "," + this.c.a() + "," + this.b.b();
   }

   public final boolean f() {
      return this.c == bmv.b.a;
   }

   public final int e() {
      return this.b.a() * this.e;
   }

   public final int d() {
      return this.d;
   }

   public final bmv.b b() {
      return this.c;
   }

   public final int c() {
      return this.e;
   }

   private final boolean a(int var1, bmv.b var2) {
      return var1 == 0 || var2 == bmv.b.d;
   }

   public int hashCode() {
      int var1 = this.b.hashCode();
      var1 = 31 * var1 + this.c.hashCode();
      var1 = 31 * var1 + this.d;
      var1 = 31 * var1 + this.e;
      return var1;
   }

   public static enum b {
      f("Blend Weight"),
      a("Position");

      private static final bmv.b[] i = new bmv.b[]{a, b, c, d, e, f, g};
      e("Bone Matrix"),
      c("Vertex Color");

      private final String h;
      d("UV"),
      g("Padding"),
      b("Normal");

      public String a() {
         return this.h;
      }

      private b(String var3) {
         this.h = var3;
      }
   }

   public static enum a {
      private static final bmv.a[] k = new bmv.a[]{a, b, c, d, e, f, g};
      d(2, "Unsigned Short", 5123);

      private final String i;
      e(2, "Short", 5122);

      private final int h;
      b(1, "Unsigned Byte", 5121),
      c(1, "Byte", 5120),
      a(4, "Float", 5126),
      f(4, "Unsigned Int", 5125),
      g(4, "Int", 5124);

      private final int j;

      public int c() {
         return this.j;
      }

      public String b() {
         return this.i;
      }

      private a(int var3, String var4, int var5) {
         this.h = var3;
         this.i = var4;
         this.j = var5;
      }

      public int a() {
         return this.h;
      }
   }
}
