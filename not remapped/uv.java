import java.util.List;

public class uv extends uu {
   public long a;
   private int b;
   private int c;

   protected void b(dn var1) {
   }

   public uv(adm var1, double var2, double var4, double var6) {
      super(var1);
      this.b(var2, var4, var6, 0.0F, 0.0F);
      this.b = 2;
      this.a = this.V.nextLong();
      this.c = this.V.nextInt(3) + 1;
      cj var8 = new cj(this);
      if (!var1.D && var1.Q().b("doFireTick") && (var1.aa() == oj.c || var1.aa() == oj.d) && var1.a((cj)var8, (int)10)) {
         if (var1.p(var8).c().t() == arm.a && afi.ab.d(var1, var8)) {
            var1.a(var8, afi.ab.Q());
         }

         for(int var9 = 0; var9 < 4; ++var9) {
            cj var10 = var8.a(this.V.nextInt(3) - 1, this.V.nextInt(3) - 1, this.V.nextInt(3) - 1);
            if (var1.p(var10).c().t() == arm.a && afi.ab.d(var1, var10)) {
               var1.a(var10, afi.ab.Q());
            }
         }
      }

   }

   protected void a(dn var1) {
   }

   public void t_() {
      super.t_();
      if (this.b == 2) {
         this.o.a(this.s, this.t, this.u, "ambient.weather.thunder", 10000.0F, 0.8F + this.V.nextFloat() * 0.2F);
         this.o.a(this.s, this.t, this.u, "random.explode", 2.0F, 0.5F + this.V.nextFloat() * 0.2F);
      }

      --this.b;
      if (this.b < 0) {
         if (this.c == 0) {
            this.J();
         } else if (this.b < -this.V.nextInt(10)) {
            --this.c;
            this.b = 1;
            this.a = this.V.nextLong();
            cj var1 = new cj(this);
            if (!this.o.D && this.o.Q().b("doFireTick") && this.o.a((cj)var1, (int)10) && this.o.p(var1).c().t() == arm.a && afi.ab.d(this.o, var1)) {
               this.o.a(var1, afi.ab.Q());
            }
         }
      }

      if (this.b >= 0) {
         if (this.o.D) {
            this.o.d(2);
         } else {
            double var6 = 3.0D;
            List var3 = this.o.b((pk)this, (aug)(new aug(this.s - var6, this.t - var6, this.u - var6, this.s + var6, this.t + 6.0D + var6, this.u + var6)));

            for(int var4 = 0; var4 < var3.size(); ++var4) {
               pk var5 = (pk)var3.get(var4);
               var5.a(this);
            }
         }
      }

   }

   protected void h() {
   }
}
