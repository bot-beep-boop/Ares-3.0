public class wu extends ws {
   public int e = 1;

   protected void a(auh var1) {
      if (!this.o.D) {
         if (var1.d != null) {
            var1.d.a(ow.a((ws)this, this.a), 6.0F);
            this.a(this.a, var1.d);
         }

         boolean var2 = this.o.Q().b("mobGriefing");
         this.o.a((pk)null, this.s, this.t, this.u, (float)this.e, var2, var2);
         this.J();
      }

   }

   public void a(dn var1) {
      super.a(var1);
      if (var1.b("ExplosionPower", 99)) {
         this.e = var1.f("ExplosionPower");
      }

   }

   public wu(adm var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      super(var1, var2, var4, var6, var8, var10, var12);
   }

   public void b(dn var1) {
      super.b(var1);
      var1.a("ExplosionPower", this.e);
   }

   public wu(adm var1) {
      super(var1);
   }

   public wu(adm var1, pr var2, double var3, double var5, double var7) {
      super(var1, var2, var3, var5, var7);
   }
}
