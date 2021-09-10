public class rs extends ro {
   private final ts c;

   public void d() {
      super.d();
      this.c.n(false);
   }

   public boolean b() {
      return super.b();
   }

   public rs(ts var1, double var2) {
      super(var1, var2, 8);
      this.c = var1;
   }

   protected boolean a(adm var1, cj var2) {
      if (!var1.d(var2.a())) {
         return false;
      } else {
         alz var3 = var1.p(var2);
         afh var4 = var3.c();
         if (var4 == afi.ae) {
            akw var5 = var1.s(var2);
            if (var5 instanceof aky && ((aky)var5).l < 1) {
               return true;
            }
         } else {
            if (var4 == afi.am) {
               return true;
            }

            if (var4 == afi.C && var3.b(afg.a) != afg.a.a) {
               return true;
            }
         }

         return false;
      }
   }

   public void e() {
      super.e();
      this.c.cp().a(false);
      if (!this.f()) {
         this.c.n(false);
      } else if (!this.c.cn()) {
         this.c.n(true);
      }

   }

   public boolean a() {
      return this.c.cl() && !this.c.cn() && super.a();
   }

   public void c() {
      super.c();
      this.c.cp().a(false);
   }
}
