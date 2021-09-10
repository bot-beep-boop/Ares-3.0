public final class adp {
   private final adp.a b;
   private boolean g;
   private final adr e;
   private final boolean d;
   private boolean f;
   private final boolean c;
   private final long a;
   private String h;

   public adp a() {
      this.g = true;
      return this;
   }

   public adp.a e() {
      return this.b;
   }

   public boolean g() {
      return this.c;
   }

   public String j() {
      return this.h;
   }

   public adp b() {
      this.f = true;
      return this;
   }

   public boolean f() {
      return this.d;
   }

   public boolean i() {
      return this.f;
   }

   public static adp.a a(int var0) {
      return adp.a.a(var0);
   }

   public adr h() {
      return this.e;
   }

   public adp(long var1, adp.a var3, boolean var4, boolean var5, adr var6) {
      this.h = "";
      this.a = var1;
      this.b = var3;
      this.c = var4;
      this.d = var5;
      this.e = var6;
   }

   public adp a(String var1) {
      this.h = var1;
      return this;
   }

   public boolean c() {
      return this.g;
   }

   public long d() {
      return this.a;
   }

   public adp(ato var1) {
      this(var1.b(), var1.r(), var1.s(), var1.t(), var1.u());
   }

   public static enum a {
      String g;
      c(1, "creative");

      private static final adp.a[] h = new adp.a[]{a, b, c, d, e};
      a(-1, "");

      int f;
      e(3, "spectator"),
      b(0, "survival"),
      d(2, "adventure");

      public boolean d() {
         return this == c;
      }

      public boolean c() {
         return this == d || this == e;
      }

      public boolean e() {
         return this == b || this == d;
      }

      public void a(wl var1) {
         if (this == c) {
            var1.c = true;
            var1.d = true;
            var1.a = true;
         } else if (this == e) {
            var1.c = true;
            var1.d = false;
            var1.a = true;
            var1.b = true;
         } else {
            var1.c = false;
            var1.d = false;
            var1.a = false;
            var1.b = false;
         }

         var1.e = !this.c();
      }

      public String b() {
         return this.g;
      }

      public static adp.a a(int var0) {
         adp.a[] var1 = values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            adp.a var4 = var1[var3];
            if (var4.f == var0) {
               return var4;
            }
         }

         return b;
      }

      public int a() {
         return this.f;
      }

      private a(int var3, String var4) {
         this.f = var3;
         this.g = var4;
      }

      public static adp.a a(String var0) {
         adp.a[] var1 = values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            adp.a var4 = var1[var3];
            if (var4.g.equals(var0)) {
               return var4;
            }
         }

         return b;
      }
   }
}
