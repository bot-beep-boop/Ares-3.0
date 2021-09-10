import org.lwjgl.input.Mouse;

public abstract class awi {
   protected final int h;
   protected int c;
   protected boolean s;
   protected int e;
   private boolean w = true;
   protected float n;
   protected int d;
   protected float m;
   private int u;
   protected int j;
   protected int o = -1;
   protected int f;
   protected final ave a;
   private int v;
   protected boolean q = true;
   protected int g;
   protected int l = -2;
   protected int i;
   protected int t;
   protected boolean r = true;
   protected boolean k = true;
   protected long p;
   protected int b;

   public int m() {
      return Math.max(0, this.k() - (this.e - this.d - 4));
   }

   public boolean q() {
      return this.w;
   }

   public boolean g(int var1) {
      return var1 >= this.d && var1 <= this.e && this.i >= this.g && this.i <= this.f;
   }

   protected void a(int var1, int var2, int var3) {
   }

   protected void a(boolean var1, int var2) {
      this.s = var1;
      this.t = var2;
      if (!var1) {
         this.t = 0;
      }

   }

   public awi(ave var1, int var2, int var3, int var4, int var5, int var6) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.h = var6;
      this.g = 0;
      this.f = var2;
   }

   protected int k() {
      return this.b() * this.h + this.t;
   }

   protected int d() {
      return this.b / 2 + 124;
   }

   protected void c(int var1, int var2, int var3, int var4) {
      bfx var5 = bfx.a();
      bfd var6 = var5.c();
      this.a.P().a(avp.b);
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      float var7 = 32.0F;
      var6.a(7, bms.i);
      var6.b((double)this.g, (double)var2, 0.0D).a(0.0D, (double)((float)var2 / 32.0F)).b(64, 64, 64, var4).d();
      var6.b((double)(this.g + this.b), (double)var2, 0.0D).a((double)((float)this.b / 32.0F), (double)((float)var2 / 32.0F)).b(64, 64, 64, var4).d();
      var6.b((double)(this.g + this.b), (double)var1, 0.0D).a((double)((float)this.b / 32.0F), (double)((float)var1 / 32.0F)).b(64, 64, 64, var3).d();
      var6.b((double)this.g, (double)var1, 0.0D).a(0.0D, (double)((float)var1 / 32.0F)).b(64, 64, 64, var3).d();
      var5.b();
   }

   protected void a(int var1, int var2) {
   }

   public int c() {
      return 220;
   }

   protected void b(int var1, int var2) {
   }

   public void a(int var1, int var2, int var3, int var4) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.e = var4;
      this.g = 0;
      this.f = var1;
   }

   protected abstract boolean a(int var1);

   public void b(boolean var1) {
      this.r = var1;
   }

   public void d(int var1, int var2) {
      this.u = var1;
      this.v = var2;
   }

   protected void b(int var1, int var2, int var3, int var4) {
      int var5 = this.b();
      bfx var6 = bfx.a();
      bfd var7 = var6.c();

      for(int var8 = 0; var8 < var5; ++var8) {
         int var9 = var2 + var8 * this.h + this.t;
         int var10 = this.h - 4;
         if (var9 > this.e || var9 + var10 < this.d) {
            this.a(var8, var1, var9);
         }

         if (this.r && this.a(var8)) {
            int var11 = this.g + (this.b / 2 - this.c() / 2);
            int var12 = this.g + this.b / 2 + this.c() / 2;
            bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
            bfl.x();
            var7.a(7, bms.i);
            var7.b((double)var11, (double)(var9 + var10 + 2), 0.0D).a(0.0D, 1.0D).b(128, 128, 128, 255).d();
            var7.b((double)var12, (double)(var9 + var10 + 2), 0.0D).a(1.0D, 1.0D).b(128, 128, 128, 255).d();
            var7.b((double)var12, (double)(var9 - 2), 0.0D).a(1.0D, 0.0D).b(128, 128, 128, 255).d();
            var7.b((double)var11, (double)(var9 - 2), 0.0D).a(0.0D, 0.0D).b(128, 128, 128, 255).d();
            var7.b((double)(var11 + 1), (double)(var9 + var10 + 1), 0.0D).a(0.0D, 1.0D).b(0, 0, 0, 255).d();
            var7.b((double)(var12 - 1), (double)(var9 + var10 + 1), 0.0D).a(1.0D, 1.0D).b(0, 0, 0, 255).d();
            var7.b((double)(var12 - 1), (double)(var9 - 1), 0.0D).a(1.0D, 0.0D).b(0, 0, 0, 255).d();
            var7.b((double)(var11 + 1), (double)(var9 - 1), 0.0D).a(0.0D, 0.0D).b(0, 0, 0, 255).d();
            var6.b();
            bfl.w();
         }

         this.a(var8, var1, var9, var10, var3, var4);
      }

   }

   public void i(int var1) {
      this.g = var1;
      this.f = var1 + this.b;
   }

   public int r() {
      return this.h;
   }

   public void p() {
      if (this.g(this.j)) {
         int var1;
         int var2;
         int var3;
         int var4;
         if (Mouse.getEventButton() == 0 && Mouse.getEventButtonState() && this.j >= this.d && this.j <= this.e) {
            var1 = (this.b - this.c()) / 2;
            var2 = (this.b + this.c()) / 2;
            var3 = this.j - this.d - this.t + (int)this.n - 4;
            var4 = var3 / this.h;
            if (var4 < this.b() && this.i >= var1 && this.i <= var2 && var4 >= 0 && var3 >= 0) {
               this.a(var4, false, this.i, this.j);
               this.o = var4;
            } else if (this.i >= var1 && this.i <= var2 && var3 < 0) {
               this.a(this.i - var1, this.j - this.d + (int)this.n - 4);
            }
         }

         if (Mouse.isButtonDown(0) && this.q()) {
            if (this.l == -1) {
               boolean var10 = true;
               if (this.j >= this.d && this.j <= this.e) {
                  var2 = (this.b - this.c()) / 2;
                  var3 = (this.b + this.c()) / 2;
                  var4 = this.j - this.d - this.t + (int)this.n - 4;
                  int var5 = var4 / this.h;
                  if (var5 < this.b() && this.i >= var2 && this.i <= var3 && var5 >= 0 && var4 >= 0) {
                     boolean var6 = var5 == this.o && ave.J() - this.p < 250L;
                     this.a(var5, var6, this.i, this.j);
                     this.o = var5;
                     this.p = ave.J();
                  } else if (this.i >= var2 && this.i <= var3 && var4 < 0) {
                     this.a(this.i - var2, this.j - this.d + (int)this.n - 4);
                     var10 = false;
                  }

                  int var11 = this.d();
                  int var7 = var11 + 6;
                  if (this.i >= var11 && this.i <= var7) {
                     this.m = -1.0F;
                     int var8 = this.m();
                     if (var8 < 1) {
                        var8 = 1;
                     }

                     int var9 = (int)((float)((this.e - this.d) * (this.e - this.d)) / (float)this.k());
                     var9 = ns.a(var9, 32, this.e - this.d - 8);
                     this.m /= (float)(this.e - this.d - var9) / (float)var8;
                  } else {
                     this.m = 1.0F;
                  }

                  if (var10) {
                     this.l = this.j;
                  } else {
                     this.l = -2;
                  }
               } else {
                  this.l = -2;
               }
            } else if (this.l >= 0) {
               this.n -= (float)(this.j - this.l) * this.m;
               this.l = this.j;
            }
         } else {
            this.l = -1;
         }

         var1 = Mouse.getEventDWheel();
         if (var1 != 0) {
            if (var1 > 0) {
               var1 = -1;
            } else if (var1 < 0) {
               var1 = 1;
            }

            this.n += (float)(var1 * this.h / 2);
         }

      }
   }

   protected abstract void a(int var1, int var2, int var3, int var4, int var5, int var6);

   public void d(boolean var1) {
      this.w = var1;
   }

   public void h(int var1) {
      this.n += (float)var1;
      this.l();
      this.l = -2;
   }

   public int c(int var1, int var2) {
      int var3 = this.g + this.b / 2 - this.c() / 2;
      int var4 = this.g + this.b / 2 + this.c() / 2;
      int var5 = var2 - this.d - this.t + (int)this.n - 4;
      int var6 = var5 / this.h;
      return var1 < this.d() && var1 >= var3 && var1 <= var4 && var6 >= 0 && var5 >= 0 && var6 < this.b() ? var6 : -1;
   }

   protected abstract void a();

   protected void a(int var1, int var2, bfx var3) {
   }

   protected void l() {
      this.n = ns.a(this.n, 0.0F, (float)this.m());
   }

   public int n() {
      return (int)this.n;
   }

   public void a(avs var1) {
      if (var1.l) {
         if (var1.k == this.u) {
            this.n -= (float)(this.h * 2 / 3);
            this.l = -2;
            this.l();
         } else if (var1.k == this.v) {
            this.n += (float)(this.h * 2 / 3);
            this.l = -2;
            this.l();
         }

      }
   }

   protected abstract void a(int var1, boolean var2, int var3, int var4);

   protected abstract int b();

   public void a(int var1, int var2, float var3) {
      if (this.q) {
         this.i = var1;
         this.j = var2;
         this.a();
         int var4 = this.d();
         int var5 = var4 + 6;
         this.l();
         bfl.f();
         bfl.n();
         bfx var6 = bfx.a();
         bfd var7 = var6.c();
         this.a.P().a(avp.b);
         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         float var8 = 32.0F;
         var7.a(7, bms.i);
         var7.b((double)this.g, (double)this.e, 0.0D).a((double)((float)this.g / var8), (double)((float)(this.e + (int)this.n) / var8)).b(32, 32, 32, 255).d();
         var7.b((double)this.f, (double)this.e, 0.0D).a((double)((float)this.f / var8), (double)((float)(this.e + (int)this.n) / var8)).b(32, 32, 32, 255).d();
         var7.b((double)this.f, (double)this.d, 0.0D).a((double)((float)this.f / var8), (double)((float)(this.d + (int)this.n) / var8)).b(32, 32, 32, 255).d();
         var7.b((double)this.g, (double)this.d, 0.0D).a((double)((float)this.g / var8), (double)((float)(this.d + (int)this.n) / var8)).b(32, 32, 32, 255).d();
         var6.b();
         int var9 = this.g + this.b / 2 - this.c() / 2 + 2;
         int var10 = this.d + 4 - (int)this.n;
         if (this.s) {
            this.a(var9, var10, var6);
         }

         this.b(var9, var10, var1, var2);
         bfl.i();
         byte var11 = 4;
         this.c(0, this.d, 255, 255);
         this.c(this.e, this.c, 255, 255);
         bfl.l();
         bfl.a(770, 771, 0, 1);
         bfl.c();
         bfl.j(7425);
         bfl.x();
         var7.a(7, bms.i);
         var7.b((double)this.g, (double)(this.d + var11), 0.0D).a(0.0D, 1.0D).b(0, 0, 0, 0).d();
         var7.b((double)this.f, (double)(this.d + var11), 0.0D).a(1.0D, 1.0D).b(0, 0, 0, 0).d();
         var7.b((double)this.f, (double)this.d, 0.0D).a(1.0D, 0.0D).b(0, 0, 0, 255).d();
         var7.b((double)this.g, (double)this.d, 0.0D).a(0.0D, 0.0D).b(0, 0, 0, 255).d();
         var6.b();
         var7.a(7, bms.i);
         var7.b((double)this.g, (double)this.e, 0.0D).a(0.0D, 1.0D).b(0, 0, 0, 255).d();
         var7.b((double)this.f, (double)this.e, 0.0D).a(1.0D, 1.0D).b(0, 0, 0, 255).d();
         var7.b((double)this.f, (double)(this.e - var11), 0.0D).a(1.0D, 0.0D).b(0, 0, 0, 0).d();
         var7.b((double)this.g, (double)(this.e - var11), 0.0D).a(0.0D, 0.0D).b(0, 0, 0, 0).d();
         var6.b();
         int var12 = this.m();
         if (var12 > 0) {
            int var13 = (this.e - this.d) * (this.e - this.d) / this.k();
            var13 = ns.a(var13, 32, this.e - this.d - 8);
            int var14 = (int)this.n * (this.e - this.d - var13) / var12 + this.d;
            if (var14 < this.d) {
               var14 = this.d;
            }

            var7.a(7, bms.i);
            var7.b((double)var4, (double)this.e, 0.0D).a(0.0D, 1.0D).b(0, 0, 0, 255).d();
            var7.b((double)var5, (double)this.e, 0.0D).a(1.0D, 1.0D).b(0, 0, 0, 255).d();
            var7.b((double)var5, (double)this.d, 0.0D).a(1.0D, 0.0D).b(0, 0, 0, 255).d();
            var7.b((double)var4, (double)this.d, 0.0D).a(0.0D, 0.0D).b(0, 0, 0, 255).d();
            var6.b();
            var7.a(7, bms.i);
            var7.b((double)var4, (double)(var14 + var13), 0.0D).a(0.0D, 1.0D).b(128, 128, 128, 255).d();
            var7.b((double)var5, (double)(var14 + var13), 0.0D).a(1.0D, 1.0D).b(128, 128, 128, 255).d();
            var7.b((double)var5, (double)var14, 0.0D).a(1.0D, 0.0D).b(128, 128, 128, 255).d();
            var7.b((double)var4, (double)var14, 0.0D).a(0.0D, 0.0D).b(128, 128, 128, 255).d();
            var6.b();
            var7.a(7, bms.i);
            var7.b((double)var4, (double)(var14 + var13 - 1), 0.0D).a(0.0D, 1.0D).b(192, 192, 192, 255).d();
            var7.b((double)(var5 - 1), (double)(var14 + var13 - 1), 0.0D).a(1.0D, 1.0D).b(192, 192, 192, 255).d();
            var7.b((double)(var5 - 1), (double)var14, 0.0D).a(1.0D, 0.0D).b(192, 192, 192, 255).d();
            var7.b((double)var4, (double)var14, 0.0D).a(0.0D, 0.0D).b(192, 192, 192, 255).d();
            var6.b();
         }

         this.b(var1, var2);
         bfl.w();
         bfl.j(7424);
         bfl.d();
         bfl.k();
      }
   }
}
