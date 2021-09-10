public abstract class afc extends afh implements agq {
   protected boolean e(adm var1, cj var2) {
      return this.a(var1, var2, cq.c) || this.a(var1, var2, cq.d) || this.a(var1, var2, cq.e) || this.a(var1, var2, cq.f);
   }

   protected afc(arm var1) {
      this(var1, var1.r());
   }

   public boolean a(adm var1, cj var2, alz var3, int var4, int var5) {
      super.a(var1, var2, var3, var4, var5);
      akw var6 = var1.s(var2);
      return var6 == null ? false : var6.c(var4, var5);
   }

   public void b(adm var1, cj var2, alz var3) {
      super.b(var1, var2, var3);
      var1.t(var2);
   }

   protected boolean a(adm var1, cj var2, cq var3) {
      return var1.p(var2.a(var3)).c().t() == arm.A;
   }

   public int b() {
      return -1;
   }

   protected afc(arm var1, arn var2) {
      super(var1, var2);
      this.A = true;
   }
}
