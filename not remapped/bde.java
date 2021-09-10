public class bde {
   public long e;
   private bde.a j;
   private String k;
   public String c;
   public boolean h;
   public String b;
   private boolean l;
   public String i;
   public String g = "1.8.9";
   public int f = 47;
   public String a;
   public String d;

   public void a(String var1) {
      this.k = var1;
   }

   public bde.a b() {
      return this.j;
   }

   public String c() {
      return this.k;
   }

   public boolean d() {
      return this.l;
   }

   public dn a() {
      dn var1 = new dn();
      var1.a("name", this.a);
      var1.a("ip", this.b);
      if (this.k != null) {
         var1.a("icon", this.k);
      }

      if (this.j == bde.a.a) {
         var1.a("acceptTextures", true);
      } else if (this.j == bde.a.b) {
         var1.a("acceptTextures", false);
      }

      return var1;
   }

   public void a(bde var1) {
      this.b = var1.b;
      this.a = var1.a;
      this.a(var1.b());
      this.k = var1.k;
      this.l = var1.l;
   }

   public static bde a(dn var0) {
      bde var1 = new bde(var0.j("name"), var0.j("ip"), false);
      if (var0.b("icon", 8)) {
         var1.a(var0.j("icon"));
      }

      if (var0.b("acceptTextures", 1)) {
         if (var0.n("acceptTextures")) {
            var1.a(bde.a.a);
         } else {
            var1.a(bde.a.b);
         }
      } else {
         var1.a(bde.a.c);
      }

      return var1;
   }

   public void a(bde.a var1) {
      this.j = var1;
   }

   public bde(String var1, String var2, boolean var3) {
      this.j = bde.a.c;
      this.a = var1;
      this.b = var2;
      this.l = var3;
   }

   public static enum a {
      private final eu d;
      c("prompt");

      private static final bde.a[] e = new bde.a[]{a, b, c};
      a("enabled"),
      b("disabled");

      private a(String var3) {
         this.d = new fb("addServer.resourcePack." + var3, new Object[0]);
      }

      public eu a() {
         return this.d;
      }
   }
}
