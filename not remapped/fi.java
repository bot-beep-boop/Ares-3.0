import java.io.IOException;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

public class fi implements ff<fj> {
   private double c;
   private Set<fi.a> f;
   private double a;
   private double b;
   private float d;
   private float e;

   public double b() {
      return this.b;
   }

   public fi() {
   }

   public fi(double var1, double var3, double var5, float var7, float var8, Set<fi.a> var9) {
      this.a = var1;
      this.b = var3;
      this.c = var5;
      this.d = var7;
      this.e = var8;
      this.f = var9;
   }

   public double a() {
      return this.a;
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public float e() {
      return this.e;
   }

   public double c() {
      return this.c;
   }

   public Set<fi.a> f() {
      return this.f;
   }

   public float d() {
      return this.d;
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public void a(em var1) throws IOException {
      this.a = var1.readDouble();
      this.b = var1.readDouble();
      this.c = var1.readDouble();
      this.d = var1.readFloat();
      this.e = var1.readFloat();
      this.f = fi.a.a(var1.readUnsignedByte());
   }

   public void b(em var1) throws IOException {
      var1.writeDouble(this.a);
      var1.writeDouble(this.b);
      var1.writeDouble(this.c);
      var1.writeFloat(this.d);
      var1.writeFloat(this.e);
      var1.writeByte(fi.a.a(this.f));
   }

   public static enum a {
      c(2),
      b(1),
      d(3),
      a(0),
      e(4);

      private static final fi.a[] g = new fi.a[]{a, b, c, d, e};
      private int f;

      private int a() {
         return 1 << this.f;
      }

      public static Set<fi.a> a(int var0) {
         EnumSet var1 = EnumSet.noneOf(fi.a.class);
         fi.a[] var2 = values();
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            fi.a var5 = var2[var4];
            if (var5.b(var0)) {
               var1.add(var5);
            }
         }

         return var1;
      }

      public static int a(Set<fi.a> var0) {
         int var1 = 0;

         fi.a var3;
         for(Iterator var2 = var0.iterator(); var2.hasNext(); var1 |= var3.a()) {
            var3 = (fi.a)var2.next();
         }

         return var1;
      }

      private boolean b(int var1) {
         return (var1 & this.a()) == this.a();
      }

      private a(int var3) {
         this.f = var3;
      }
   }
}
