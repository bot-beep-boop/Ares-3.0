public class alg extends akw {
   private int f;
   private zw a;

   public alg() {
   }

   public alg(zw var1, int var2) {
      this.a = var1;
      this.f = var2;
   }

   public void a(dn var1) {
      super.a(var1);
      if (var1.b("Item", 8)) {
         this.a = zw.d(var1.j("Item"));
      } else {
         this.a = zw.b(var1.f("Item"));
      }

      this.f = var1.f("Data");
   }

   public ff y_() {
      dn var1 = new dn();
      this.b(var1);
      var1.o("Item");
      var1.a("Item", zw.b(this.a));
      return new ft(this.c, 5, var1);
   }

   public void b(dn var1) {
      super.b(var1);
      jy var2 = (jy)zw.e.c(this.a);
      var1.a("Item", var2 == null ? "" : var2.toString());
      var1.a("Data", this.f);
   }

   public zw b() {
      return this.a;
   }

   public int c() {
      return this.f;
   }

   public void a(zw var1, int var2) {
      this.a = var1;
      this.f = var2;
   }
}
