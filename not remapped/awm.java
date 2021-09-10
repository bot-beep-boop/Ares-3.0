public class awm extends avp implements bai {
   private final ave g;
   public static final jy a = new jy("textures/gui/spectator_widgets.png");
   private static final jy f = new jy("textures/gui/widgets.png");
   private long h;
   private baf i;

   public void a(int var1) {
      this.h = ave.J();
      if (this.i != null) {
         this.i.b(var1);
      } else {
         this.i = new baf(this);
      }

   }

   protected void a(avr var1, float var2, int var3, float var4, baj var5) {
      bfl.B();
      bfl.l();
      bfl.a(770, 771, 1, 0);
      bfl.c(1.0F, 1.0F, 1.0F, var2);
      this.g.P().a(f);
      this.a((float)(var3 - 91), var4, 0, 0, 182, 22);
      if (var5.b() >= 0) {
         this.a((float)(var3 - 91 - 1 + var5.b() * 20), var4 - 1.0F, 0, 22, 24, 22);
      }

      avc.c();

      for(int var6 = 0; var6 < 9; ++var6) {
         this.a(var6, var1.a() / 2 - 90 + var6 * 20 + 2, var4 + 3.0F, var2, var5.a(var6));
      }

      avc.a();
      bfl.C();
      bfl.k();
   }

   private void a(int var1, int var2, float var3, float var4, bah var5) {
      this.g.P().a(a);
      if (var5 != baf.a) {
         int var6 = (int)(var4 * 255.0F);
         bfl.E();
         bfl.b((float)var2, var3, 0.0F);
         float var7 = var5.B_() ? 1.0F : 0.25F;
         bfl.c(var7, var7, var7, var4);
         var5.a(var7, var6);
         bfl.F();
         String var8 = String.valueOf(avh.c(this.g.t.aw[var1].i()));
         if (var6 > 3 && var5.B_()) {
            this.g.k.a(var8, (float)(var2 + 19 - 2 - this.g.k.a(var8)), var3 + 6.0F + 3.0F, 16777215 + (var6 << 24));
         }
      }

   }

   public boolean a() {
      return this.i != null;
   }

   public awm(ave var1) {
      this.g = var1;
   }

   public void a(baf var1) {
      this.i = null;
      this.h = 0L;
   }

   public void a(avr var1, float var2) {
      if (this.i != null) {
         float var3 = this.c();
         if (var3 <= 0.0F) {
            this.i.d();
         } else {
            int var4 = var1.a() / 2;
            float var5 = this.e;
            this.e = -90.0F;
            float var6 = (float)var1.b() - 22.0F * var3;
            baj var7 = this.i.f();
            this.a(var1, var3, var4, var6, var7);
            this.e = var5;
         }
      }
   }

   public void b(int var1) {
      int var2;
      for(var2 = this.i.e() + var1; var2 >= 0 && var2 <= 8 && (this.i.a(var2) == baf.a || !this.i.a(var2).B_()); var2 += var1) {
      }

      if (var2 >= 0 && var2 <= 8) {
         this.i.b(var2);
         this.h = ave.J();
      }

   }

   public void b() {
      this.h = ave.J();
      if (this.a()) {
         int var1 = this.i.e();
         if (var1 != -1) {
            this.i.b(var1);
         }
      } else {
         this.i = new baf(this);
      }

   }

   public void a(avr var1) {
      int var2 = (int)(this.c() * 255.0F);
      if (var2 > 3 && this.i != null) {
         bah var3 = this.i.b();
         String var4 = var3 != baf.a ? var3.A_().d() : this.i.c().b().d();
         if (var4 != null) {
            int var5 = (var1.a() - this.g.k.a(var4)) / 2;
            int var6 = var1.b() - 35;
            bfl.E();
            bfl.l();
            bfl.a(770, 771, 1, 0);
            this.g.k.a(var4, (float)var5, (float)var6, 16777215 + (var2 << 24));
            bfl.k();
            bfl.F();
         }
      }

   }

   private float c() {
      long var1 = this.h - ave.J() + 5000L;
      return ns.a((float)var1 / 2000.0F, 0.0F, 1.0F);
   }
}
