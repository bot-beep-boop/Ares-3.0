public abstract class ka extends cn {
   protected abstract wv a(adm var1, cz var2);

   protected float b() {
      return 1.1F;
   }

   protected void a(ck var1) {
      var1.i().b(1002, var1.d(), 0);
   }

   public zx b(ck var1, zx var2) {
      adm var3 = var1.i();
      cz var4 = agg.a(var1);
      cq var5 = agg.b(var1.f());
      wv var6 = this.a(var3, var4);
      var6.c((double)var5.g(), (double)((float)var5.h() + 0.1F), (double)var5.i(), this.b(), this.a());
      var3.d((pk)var6);
      var2.a(1);
      return var2;
   }

   protected float a() {
      return 6.0F;
   }
}
