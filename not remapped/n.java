public class n {
   private static final String[] b;
   private String[] c;
   private static final int a = n.a.values().length;
   private String[] d;

   public void a(n var1) {
      n.a[] var2 = n.a.values();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         n.a var5 = var2[var4];
         a(this, var5, var1.c[var5.a()], var1.d[var5.a()]);
      }

   }

   public void a(dn var1) {
      if (var1.b("CommandStats", 10)) {
         dn var2 = var1.m("CommandStats");
         n.a[] var3 = n.a.values();
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            n.a var6 = var3[var5];
            String var7 = var6.b() + "Name";
            String var8 = var6.b() + "Objective";
            if (var2.b(var7, 8) && var2.b(var8, 8)) {
               String var9 = var2.j(var7);
               String var10 = var2.j(var8);
               a(this, var6, var9, var10);
            }
         }

      }
   }

   public void b(dn var1) {
      dn var2 = new dn();
      n.a[] var3 = n.a.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         n.a var6 = var3[var5];
         String var7 = this.c[var6.a()];
         String var8 = this.d[var6.a()];
         if (var7 != null && var8 != null) {
            var2.a(var6.b() + "Name", var7);
            var2.a(var6.b() + "Objective", var8);
         }
      }

      if (!var2.c_()) {
         var1.a((String)"CommandStats", (eb)var2);
      }

   }

   public void a(m var1, n.a var2, int var3) {
      String var4 = this.c[var2.a()];
      if (var4 != null) {
         m var5 = new m(this, var1) {
            final m a;
            final n b;

            public void a(eu var1) {
               this.a.a(var1);
            }

            {
               this.b = var1;
               this.a = var2;
            }

            public aui d() {
               return this.a.d();
            }

            public boolean a(int var1, String var2) {
               return true;
            }

            public boolean u_() {
               return this.a.u_();
            }

            public pk f() {
               return this.a.f();
            }

            public String e_() {
               return this.a.e_();
            }

            public cj c() {
               return this.a.c();
            }

            public eu f_() {
               return this.a.f_();
            }

            public adm e() {
               return this.a.e();
            }

            public void a(n.a var1, int var2) {
               this.a.a(var1, var2);
            }
         };

         String var6;
         try {
            var6 = i.e(var5, var4);
         } catch (ca var11) {
            return;
         }

         String var7 = this.d[var2.a()];
         if (var7 != null) {
            auo var8 = var1.e().Z();
            auk var9 = var8.b(var7);
            if (var9 != null) {
               if (var8.b(var6, var9)) {
                  aum var10 = var8.c(var6, var9);
                  var10.c(var3);
               }
            }
         }
      }
   }

   public static void a(n var0, n.a var1, String var2, String var3) {
      if (var2 != null && var2.length() != 0 && var3 != null && var3.length() != 0) {
         if (var0.c == b || var0.d == b) {
            var0.c = new String[a];
            var0.d = new String[a];
         }

         var0.c[var1.a()] = var2;
         var0.d[var1.a()] = var3;
      } else {
         a(var0, var1);
      }
   }

   static {
      b = new String[a];
   }

   private static void a(n var0, n.a var1) {
      if (var0.c != b && var0.d != b) {
         var0.c[var1.a()] = null;
         var0.d[var1.a()] = null;
         boolean var2 = true;
         n.a[] var3 = n.a.values();
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            n.a var6 = var3[var5];
            if (var0.c[var6.a()] != null && var0.d[var6.a()] != null) {
               var2 = false;
               break;
            }
         }

         if (var2) {
            var0.c = b;
            var0.d = b;
         }

      }
   }

   public n() {
      this.c = b;
      this.d = b;
   }

   public static enum a {
      c(2, "AffectedEntities"),
      d(3, "AffectedItems");

      final String g;
      e(4, "QueryResult");

      private static final n.a[] h = new n.a[]{a, b, c, d, e};
      b(1, "AffectedBlocks");

      final int f;
      a(0, "SuccessCount");

      public static n.a a(String var0) {
         n.a[] var1 = values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            n.a var4 = var1[var3];
            if (var4.b().equals(var0)) {
               return var4;
            }
         }

         return null;
      }

      public int a() {
         return this.f;
      }

      private a(int var3, String var4) {
         this.f = var3;
         this.g = var4;
      }

      public String b() {
         return this.g;
      }

      public static String[] c() {
         String[] var0 = new String[values().length];
         int var1 = 0;
         n.a[] var2 = values();
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            n.a var5 = var2[var4];
            var0[var1++] = var5.b();
         }

         return var0;
      }
   }
}
