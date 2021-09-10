public class bln extends bjl<bet> {
   private boolean a;

   protected jy a(bet var1) {
      return var1.i();
   }

   protected void a(bet var1, float var2) {
      float var3 = 0.9375F;
      bfl.a(var3, var3, var3);
   }

   public void a(pk var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((bet)var1, var2, var4, var6, var8, var9);
   }

   protected void a(bet var1, double var2, double var4, double var6, String var8, float var9, double var10) {
      if (var10 < 100.0D) {
         auo var12 = var1.cp();
         auk var13 = var12.a(2);
         if (var13 != null) {
            aum var14 = var12.c(var1.e_(), var13);
            this.a(var1, var14.c() + " " + var13.d(), var2, var4, var6, 64);
            var4 += (double)((float)this.c().a * 1.15F * var9);
         }
      }

      super.a(var1, var2, var4, var6, var8, var9, var10);
   }

   protected void a(pr var1, float var2) {
      this.a((bet)var1, var2);
   }

   public void C_() {
      bfl.b(0.0F, 0.1875F, 0.0F);
   }

   protected void a(pr var1, double var2, double var4, double var6) {
      this.a((bet)var1, var2, var4, var6);
   }

   public bbo b() {
      return this.g();
   }

   protected void a(bet var1, double var2, double var4, double var6) {
      if (var1.ai() && var1.bJ()) {
         super.a((pr)var1, var2 + (double)var1.by, var4 + (double)var1.bZ, var6 + (double)var1.bz);
      } else {
         super.a((pr)var1, var2, var4, var6);
      }

   }

   public void a(bet var1, double var2, double var4, double var6, float var8, float var9) {
      if (!var1.cc() || this.b.c == var1) {
         double var10 = var4;
         if (var1.av() && !(var1 instanceof bew)) {
            var10 = var4 - 0.125D;
         }

         this.d(var1);
         super.a((pr)var1, var2, var10, var6, var8, var9);
      }
   }

   public void b(bet var1) {
      float var2 = 1.0F;
      bfl.c(var2, var2, var2);
      bbr var3 = this.g();
      this.d(var1);
      var3.p = 0.0F;
      var3.n = false;
      var3.a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, var1);
      var3.a();
   }

   private void d(bet var1) {
      bbr var2 = this.g();
      if (var1.v()) {
         var2.a(false);
         var2.e.j = true;
         var2.f.j = true;
      } else {
         zx var3 = var1.bi.h();
         var2.a(true);
         var2.f.j = var1.a(wo.g);
         var2.v.j = var1.a(wo.b);
         var2.c.j = var1.a(wo.e);
         var2.d.j = var1.a(wo.f);
         var2.a.j = var1.a(wo.c);
         var2.b.j = var1.a(wo.d);
         var2.l = 0;
         var2.o = false;
         var2.n = var1.av();
         if (var3 == null) {
            var2.m = 0;
         } else {
            var2.m = 1;
            if (var1.bR() > 0) {
               aba var4 = var3.m();
               if (var4 == aba.d) {
                  var2.m = 3;
               } else if (var4 == aba.e) {
                  var2.o = true;
               }
            }
         }
      }

   }

   public void a(pr var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((bet)var1, var2, var4, var6, var8, var9);
   }

   protected void a(bet var1, float var2, float var3, float var4) {
      if (var1.ai() && var1.bJ()) {
         bfl.b(var1.ce(), 0.0F, 1.0F, 0.0F);
         bfl.b(this.b(var1), 0.0F, 0.0F, 1.0F);
         bfl.b(270.0F, 0.0F, 1.0F, 0.0F);
      } else {
         super.a(var1, var2, var3, var4);
      }

   }

   protected jy a(pk var1) {
      return this.a((bet)var1);
   }

   public bln(biu var1, boolean var2) {
      super(var1, new bbr(0.0F, var2), 0.5F);
      this.a = var2;
      this.a((blb)(new bkx(this)));
      this.a((blb)(new bky(this)));
      this.a((blb)(new bko(this)));
      this.a((blb)(new bkt(this)));
      this.a((blb)(new bkp(this)));
      this.a((blb)(new bks(this.g().e)));
   }

   public void c(bet var1) {
      float var2 = 1.0F;
      bfl.c(var2, var2, var2);
      bbr var3 = this.g();
      this.d(var1);
      var3.n = false;
      var3.p = 0.0F;
      var3.a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, var1);
      var3.b();
   }

   protected void a(pk var1, double var2, double var4, double var6, String var8, float var9, double var10) {
      this.a((bet)var1, var2, var4, var6, var8, var9, var10);
   }

   protected void a(pr var1, float var2, float var3, float var4) {
      this.a((bet)var1, var2, var3, var4);
   }

   public bln(biu var1) {
      this(var1, false);
   }

   public bbr g() {
      return (bbr)super.b();
   }
}
