public class alm extends akw {
   public boolean f;
   public byte a;

   public void a(adm var1, cj var2) {
      if (var1.p(var2.a()).c().t() == arm.a) {
         arm var3 = var1.p(var2.b()).c().t();
         byte var4 = 0;
         if (var3 == arm.e) {
            var4 = 1;
         }

         if (var3 == arm.p) {
            var4 = 2;
         }

         if (var3 == arm.s) {
            var4 = 3;
         }

         if (var3 == arm.d) {
            var4 = 4;
         }

         var1.c(var2, afi.B, var4, this.a);
      }
   }

   public void b() {
      this.a = (byte)((this.a + 1) % 25);
      this.p_();
   }

   public void b(dn var1) {
      super.b(var1);
      var1.a("note", this.a);
   }

   public void a(dn var1) {
      super.a(var1);
      this.a = var1.d("note");
      this.a = (byte)ns.a(this.a, 0, 24);
   }
}
