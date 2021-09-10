import java.io.IOException;

public class hv implements ff<fj> {
   private hv.a a;
   private eu b;
   private int d;
   private int c;
   private int e;

   public int c() {
      return this.c;
   }

   public eu b() {
      return this.b;
   }

   public int e() {
      return this.e;
   }

   public int d() {
      return this.d;
   }

   public hv(hv.a var1, eu var2) {
      this(var1, var2, -1, -1, -1);
   }

   public hv.a a() {
      return this.a;
   }

   public hv(int var1, int var2, int var3) {
      this(hv.a.c, (eu)null, var1, var2, var3);
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public void a(em var1) throws IOException {
      this.a = (hv.a)var1.a(hv.a.class);
      if (this.a == hv.a.a || this.a == hv.a.b) {
         this.b = var1.d();
      }

      if (this.a == hv.a.c) {
         this.c = var1.readInt();
         this.d = var1.readInt();
         this.e = var1.readInt();
      }

   }

   public hv(hv.a var1, eu var2, int var3, int var4, int var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   public hv() {
   }

   public void b(em var1) throws IOException {
      var1.a((Enum)this.a);
      if (this.a == hv.a.a || this.a == hv.a.b) {
         var1.a(this.b);
      }

      if (this.a == hv.a.c) {
         var1.writeInt(this.c);
         var1.writeInt(this.d);
         var1.writeInt(this.e);
      }

   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public static enum a {
      c;

      private static final hv.a[] f = new hv.a[]{a, b, c, d, e};
      d,
      b,
      e,
      a;

      public static String[] a() {
         String[] var0 = new String[values().length];
         int var1 = 0;
         hv.a[] var2 = values();
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            hv.a var5 = var2[var4];
            var0[var1++] = var5.name().toLowerCase();
         }

         return var0;
      }

      public static hv.a a(String var0) {
         hv.a[] var1 = values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            hv.a var4 = var1[var3];
            if (var4.name().equalsIgnoreCase(var0)) {
               return var4;
            }
         }

         return a;
      }
   }
}
