public class sy extends sw {
   protected asy a() {
      return new asy(new asz());
   }

   protected void d() {
      super.d();
   }

   protected boolean a(aui var1, aui var2, int var3, int var4, int var5) {
      auh var6 = this.c.a(var1, new aui(var2.a, var2.b + (double)this.b.K * 0.5D, var2.c), false, true, false);
      return var6 == null || var6.a == auh.a.a;
   }

   protected void l() {
      aui var1 = this.c();
      float var2 = this.b.J * this.b.J;
      byte var3 = 6;
      if (var1.g(this.d.a(this.b, this.d.e())) < (double)var2) {
         this.d.a();
      }

      for(int var4 = Math.min(this.d.e() + var3, this.d.d() - 1); var4 > this.d.e(); --var4) {
         aui var5 = this.d.a(this.b, var4);
         if (!(var5.g(var1) > 36.0D) && this.a(var1, var5, 0, 0, 0)) {
            this.d.c(var4);
            break;
         }
      }

      this.a(var1);
   }

   protected aui c() {
      return new aui(this.b.s, this.b.t + (double)this.b.K * 0.5D, this.b.u);
   }

   public sy(ps var1, adm var2) {
      super(var1, var2);
   }

   protected boolean b() {
      return this.o();
   }
}
