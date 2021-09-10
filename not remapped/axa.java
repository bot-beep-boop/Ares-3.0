public class axa extends axu {
   private avs s;
   private String g;
   private avs u;
   private axa.a r;
   private String h;
   private String i;
   private apz f = apz.e();
   private avs t;
   private final axb a;

   static float b(axa var0) {
      return var0.e;
   }

   protected void a(avs var1) {
      int var2 = this.f.c().size() - this.r.u - 1;
      if (var1.k == 1) {
         this.j.a((axu)this.a);
      } else if (var1.k == 0) {
         this.a.a = this.a();
         this.j.a((axu)this.a);
      } else if (var1.k == 5) {
         this.j.a((axu)(new axq(this)));
      } else if (var1.k == 4 && this.g()) {
         this.f.c().remove(var2);
         this.r.u = Math.min(this.r.u, this.f.c().size() - 1);
      }

      this.f.d();
      this.f();
   }

   public void b() {
      this.n.clear();
      this.g = bnq.a("createWorld.customize.flat.title");
      this.h = bnq.a("createWorld.customize.flat.tile");
      this.i = bnq.a("createWorld.customize.flat.height");
      this.r = new axa.a(this);
      this.n.add(this.s = new avs(2, this.l / 2 - 154, this.m - 52, 100, 20, bnq.a("createWorld.customize.flat.addLayer") + " (NYI)"));
      this.n.add(this.t = new avs(3, this.l / 2 - 50, this.m - 52, 100, 20, bnq.a("createWorld.customize.flat.editLayer") + " (NYI)"));
      this.n.add(this.u = new avs(4, this.l / 2 - 155, this.m - 52, 150, 20, bnq.a("createWorld.customize.flat.removeLayer")));
      this.n.add(new avs(0, this.l / 2 - 155, this.m - 28, 150, 20, bnq.a("gui.done")));
      this.n.add(new avs(5, this.l / 2 + 5, this.m - 52, 150, 20, bnq.a("createWorld.customize.presets")));
      this.n.add(new avs(1, this.l / 2 + 5, this.m - 28, 150, 20, bnq.a("gui.cancel")));
      this.s.m = this.t.m = false;
      this.f.d();
      this.f();
   }

   public void a(String var1) {
      this.f = apz.a(var1);
   }

   static apz e(axa var0) {
      return var0.f;
   }

   static float c(axa var0) {
      return var0.e;
   }

   static float a(axa var0) {
      return var0.e;
   }

   private boolean g() {
      return this.r.u > -1 && this.r.u < this.f.c().size();
   }

   public void f() {
      boolean var1 = this.g();
      this.u.l = var1;
      this.t.l = var1;
      this.t.l = false;
      this.s.l = false;
   }

   public String a() {
      return this.f.toString();
   }

   public axa(axb var1, String var2) {
      this.a = var1;
      this.a(var2);
   }

   public void a(int var1, int var2, float var3) {
      this.c();
      this.r.a(var1, var2, var3);
      this.a(this.q, this.g, this.l / 2, 8, 16777215);
      int var4 = this.l / 2 - 92 - 16;
      this.c(this.q, this.h, var4, 32, 16777215);
      this.c(this.q, this.i, var4 + 2 + 213 - this.q.a(this.i), 32, 16777215);
      super.a(var1, var2, var3);
   }

   public void k() {
      super.k();
      this.r.p();
   }

   static float d(axa var0) {
      return var0.e;
   }

   class a extends awi {
      final axa v;
      public int u;

      public a(axa var1) {
         super(var1.j, var1.l, var1.m, 43, var1.m - 60, 24);
         this.v = var1;
         this.u = -1;
      }

      private void d(int var1, int var2, int var3, int var4) {
         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         this.a.P().a(avp.c);
         float var5 = 0.0078125F;
         float var6 = 0.0078125F;
         boolean var7 = true;
         boolean var8 = true;
         bfx var9 = bfx.a();
         bfd var10 = var9.c();
         var10.a(7, bms.g);
         var10.b((double)var1, (double)(var2 + 18), (double)axa.a(this.v)).a((double)((float)var3 * 0.0078125F), (double)((float)(var4 + 18) * 0.0078125F)).d();
         var10.b((double)(var1 + 18), (double)(var2 + 18), (double)axa.b(this.v)).a((double)((float)(var3 + 18) * 0.0078125F), (double)((float)(var4 + 18) * 0.0078125F)).d();
         var10.b((double)(var1 + 18), (double)var2, (double)axa.c(this.v)).a((double)((float)(var3 + 18) * 0.0078125F), (double)((float)var4 * 0.0078125F)).d();
         var10.b((double)var1, (double)var2, (double)axa.d(this.v)).a((double)((float)var3 * 0.0078125F), (double)((float)var4 * 0.0078125F)).d();
         var9.b();
      }

      protected void a(int var1, int var2, int var3, int var4, int var5, int var6) {
         aqa var7 = (aqa)axa.e(this.v).c().get(axa.e(this.v).c().size() - var1 - 1);
         alz var8 = var7.c();
         afh var9 = var8.c();
         zw var10 = zw.a(var9);
         zx var11 = var9 != afi.a && var10 != null ? new zx(var10, 1, var9.c(var8)) : null;
         String var12 = var11 == null ? "Air" : var10.a(var11);
         if (var10 == null) {
            if (var9 != afi.j && var9 != afi.i) {
               if (var9 == afi.l || var9 == afi.k) {
                  var10 = zy.ay;
               }
            } else {
               var10 = zy.ax;
            }

            if (var10 != null) {
               var11 = new zx(var10, 1, var9.c(var8));
               var12 = var9.f();
            }
         }

         this.a(var2, var3, var11);
         this.v.q.a(var12, var2 + 18 + 5, var3 + 3, 16777215);
         String var13;
         if (var1 == 0) {
            var13 = bnq.a("createWorld.customize.flat.layer.top", var7.b());
         } else if (var1 == axa.e(this.v).c().size() - 1) {
            var13 = bnq.a("createWorld.customize.flat.layer.bottom", var7.b());
         } else {
            var13 = bnq.a("createWorld.customize.flat.layer", var7.b());
         }

         this.v.q.a(var13, var2 + 2 + 213 - this.v.q.a(var13), var3 + 3, 16777215);
      }

      protected int b() {
         return axa.e(this.v).c().size();
      }

      private void e(int var1, int var2) {
         this.d(var1, var2, 0, 0);
      }

      protected int d() {
         return this.b - 70;
      }

      private void a(int var1, int var2, zx var3) {
         this.e(var1 + 1, var2 + 1);
         bfl.B();
         if (var3 != null && var3.b() != null) {
            avc.c();
            this.v.k.a(var3, var1 + 2, var2 + 2);
            avc.a();
         }

         bfl.C();
      }

      protected boolean a(int var1) {
         return var1 == this.u;
      }

      protected void a() {
      }

      protected void a(int var1, boolean var2, int var3, int var4) {
         this.u = var1;
         this.v.f();
      }
   }
}
