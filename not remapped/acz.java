public class acz {
   private zx c;
   private int d;
   private zx b;
   private zx a;
   private boolean f;
   private int e;

   public acz(zx var1, zx var2) {
      this(var1, (zx)null, var2);
   }

   public zx d() {
      return this.c;
   }

   public boolean h() {
      return this.d >= this.e;
   }

   public void i() {
      this.d = this.e;
   }

   public int e() {
      return this.d;
   }

   public void a(dn var1) {
      dn var2 = var1.m("buy");
      this.a = zx.a(var2);
      dn var3 = var1.m("sell");
      this.c = zx.a(var3);
      if (var1.b("buyB", 10)) {
         this.b = zx.a(var1.m("buyB"));
      }

      if (var1.b("uses", 99)) {
         this.d = var1.f("uses");
      }

      if (var1.b("maxUses", 99)) {
         this.e = var1.f("maxUses");
      } else {
         this.e = 7;
      }

      if (var1.b("rewardExp", 1)) {
         this.f = var1.n("rewardExp");
      } else {
         this.f = true;
      }

   }

   public zx a() {
      return this.a;
   }

   public void a(int var1) {
      this.e += var1;
   }

   public acz(zx var1, zx var2, zx var3) {
      this(var1, var2, var3, 0, 7);
   }

   public boolean c() {
      return this.b != null;
   }

   public acz(dn var1) {
      this.a(var1);
   }

   public acz(zx var1, zw var2) {
      this(var1, new zx(var2));
   }

   public acz(zx var1, zx var2, zx var3, int var4, int var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = true;
   }

   public void g() {
      ++this.d;
   }

   public zx b() {
      return this.b;
   }

   public dn k() {
      dn var1 = new dn();
      var1.a((String)"buy", (eb)this.a.b(new dn()));
      var1.a((String)"sell", (eb)this.c.b(new dn()));
      if (this.b != null) {
         var1.a((String)"buyB", (eb)this.b.b(new dn()));
      }

      var1.a("uses", this.d);
      var1.a("maxUses", this.e);
      var1.a("rewardExp", this.f);
      return var1;
   }

   public boolean j() {
      return this.f;
   }

   public int f() {
      return this.e;
   }
}
