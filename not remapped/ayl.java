import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;
import org.lwjgl.input.Keyboard;

public abstract class ayl extends axu {
   private boolean H;
   private boolean w;
   protected final Set<yg> s = Sets.newHashSet();
   private int y;
   public xi h;
   private yg D;
   protected static final jy a = new jy("textures/gui/container/inventory.png");
   private int z;
   private int L;
   private boolean M;
   private zx N;
   private int I;
   private int G;
   private yg K;
   protected int r;
   private long E;
   private yg A;
   private long J;
   private long B;
   protected int f = 176;
   protected int i;
   private zx C;
   private yg u;
   private yg v;
   private zx x;
   protected boolean t;
   private int F;
   protected int g = 166;

   protected void a(int var1, int var2, int var3, long var4) {
      yg var6 = this.c(var1, var2);
      zx var7 = this.j.h.bi.p();
      if (this.v != null && this.j.t.A) {
         if (var3 == 0 || var3 == 1) {
            if (this.x == null) {
               if (var6 != this.v && this.v.d() != null) {
                  this.x = this.v.d().k();
               }
            } else if (this.x.b > 1 && var6 != null && xi.a(var6, this.x, false)) {
               long var8 = ave.J();
               if (this.D == var6) {
                  if (var8 - this.E > 500L) {
                     this.a(this.v, this.v.e, 0, 0);
                     this.a(var6, var6.e, 1, 0);
                     this.a(this.v, this.v.e, 0, 0);
                     this.E = var8 + 750L;
                     --this.x.b;
                  }
               } else {
                  this.D = var6;
                  this.E = var8;
               }
            }
         }
      } else if (this.t && var6 != null && var7 != null && var7.b > this.s.size() && xi.a(var6, var7, true) && var6.a(var7) && this.h.b(var6)) {
         this.s.add(var6);
         this.a();
      }

   }

   private void a(yg var1) {
      int var2 = var1.f;
      int var3 = var1.g;
      zx var4 = var1.d();
      boolean var5 = false;
      boolean var6 = var1 == this.v && this.x != null && !this.w;
      zx var7 = this.j.h.bi.p();
      String var8 = null;
      if (var1 == this.v && this.x != null && this.w && var4 != null) {
         var4 = var4.k();
         var4.b /= 2;
      } else if (this.t && this.s.contains(var1) && var7 != null) {
         if (this.s.size() == 1) {
            return;
         }

         if (xi.a(var1, var7, true) && this.h.b(var1)) {
            var4 = var7.k();
            var5 = true;
            xi.a(this.s, this.F, var4, var1.d() == null ? 0 : var1.d().b);
            if (var4.b > var4.c()) {
               var8 = a.o + "" + var4.c();
               var4.b = var4.c();
            }

            if (var4.b > var1.b(var4)) {
               var8 = a.o + "" + var1.b(var4);
               var4.b = var1.b(var4);
            }
         } else {
            this.s.remove(var1);
            this.a();
         }
      }

      this.e = 100.0F;
      this.k.a = 100.0F;
      if (var4 == null) {
         String var9 = var1.c();
         if (var9 != null) {
            bmi var10 = this.j.T().a(var9);
            bfl.f();
            this.j.P().a(bmh.g);
            this.a(var2, var3, var10, 16, 16);
            bfl.e();
            var6 = true;
         }
      }

      if (!var6) {
         if (var5) {
            a(var2, var3, var2 + 16, var3 + 16, -2130706433);
         }

         bfl.j();
         this.k.b(var4, var2, var3);
         this.k.a(this.q, var4, var2, var3, var8);
      }

      this.k.a = 0.0F;
      this.e = 0.0F;
   }

   public void a(int var1, int var2, float var3) {
      this.c();
      int var4 = this.i;
      int var5 = this.r;
      this.a(var3, var1, var2);
      bfl.C();
      avc.a();
      bfl.f();
      bfl.i();
      super.a(var1, var2, var3);
      avc.c();
      bfl.E();
      bfl.b((float)var4, (float)var5, 0.0F);
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      bfl.B();
      this.u = null;
      short var6 = 240;
      short var7 = 240;
      bqs.a(bqs.r, (float)var6 / 1.0F, (float)var7 / 1.0F);
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);

      int var11;
      for(int var8 = 0; var8 < this.h.c.size(); ++var8) {
         yg var9 = (yg)this.h.c.get(var8);
         this.a(var9);
         if (this.a(var9, var1, var2) && var9.b()) {
            this.u = var9;
            bfl.f();
            bfl.i();
            int var10 = var9.f;
            var11 = var9.g;
            bfl.a(true, true, true, false);
            this.a(var10, var11, var10 + 16, var11 + 16, -2130706433, -2130706433);
            bfl.a(true, true, true, true);
            bfl.e();
            bfl.j();
         }
      }

      avc.a();
      this.b(var1, var2);
      avc.c();
      wm var15 = this.j.h.bi;
      zx var16 = this.x == null ? var15.p() : this.x;
      if (var16 != null) {
         byte var17 = 8;
         var11 = this.x == null ? 8 : 16;
         String var12 = null;
         if (this.x != null && this.w) {
            var16 = var16.k();
            var16.b = ns.f((float)var16.b / 2.0F);
         } else if (this.t && this.s.size() > 1) {
            var16 = var16.k();
            var16.b = this.I;
            if (var16.b == 0) {
               var12 = "" + a.o + "0";
            }
         }

         this.a(var16, var1 - var4 - var17, var2 - var5 - var11, var12);
      }

      if (this.C != null) {
         float var18 = (float)(ave.J() - this.B) / 100.0F;
         if (var18 >= 1.0F) {
            var18 = 1.0F;
            this.C = null;
         }

         var11 = this.A.f - this.y;
         int var20 = this.A.g - this.z;
         int var13 = this.y + (int)((float)var11 * var18);
         int var14 = this.z + (int)((float)var20 * var18);
         this.a(this.C, var13, var14, (String)null);
      }

      bfl.F();
      if (var15.p() == null && this.u != null && this.u.e()) {
         zx var19 = this.u.d();
         this.a(var19, var1, var2);
      }

      bfl.e();
      bfl.j();
      avc.b();
   }

   protected void a(int var1, int var2, int var3) {
      super.a(var1, var2, var3);
      boolean var4 = var3 == this.j.t.aj.i() + 100;
      yg var5 = this.c(var1, var2);
      long var6 = ave.J();
      this.M = this.K == var5 && var6 - this.J < 250L && this.L == var3;
      this.H = false;
      if (var3 == 0 || var3 == 1 || var4) {
         int var8 = this.i;
         int var9 = this.r;
         boolean var10 = var1 < var8 || var2 < var9 || var1 >= var8 + this.f || var2 >= var9 + this.g;
         int var11 = -1;
         if (var5 != null) {
            var11 = var5.e;
         }

         if (var10) {
            var11 = -999;
         }

         if (this.j.t.A && var10 && this.j.h.bi.p() == null) {
            this.j.a((axu)null);
            return;
         }

         if (var11 != -1) {
            if (this.j.t.A) {
               if (var5 != null && var5.e()) {
                  this.v = var5;
                  this.x = null;
                  this.w = var3 == 1;
               } else {
                  this.v = null;
               }
            } else if (!this.t) {
               if (this.j.h.bi.p() == null) {
                  if (var3 == this.j.t.aj.i() + 100) {
                     this.a(var5, var11, var3, 3);
                  } else {
                     boolean var12 = var11 != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
                     byte var13 = 0;
                     if (var12) {
                        this.N = var5 != null && var5.e() ? var5.d() : null;
                        var13 = 1;
                     } else if (var11 == -999) {
                        var13 = 4;
                     }

                     this.a(var5, var11, var3, var13);
                  }

                  this.H = true;
               } else {
                  this.t = true;
                  this.G = var3;
                  this.s.clear();
                  if (var3 == 0) {
                     this.F = 0;
                  } else if (var3 == 1) {
                     this.F = 1;
                  } else if (var3 == this.j.t.aj.i() + 100) {
                     this.F = 2;
                  }
               }
            }
         }
      }

      this.K = var5;
      this.J = var6;
      this.L = var3;
   }

   protected void b(int var1, int var2, int var3) {
      yg var4 = this.c(var1, var2);
      int var5 = this.i;
      int var6 = this.r;
      boolean var7 = var1 < var5 || var2 < var6 || var1 >= var5 + this.f || var2 >= var6 + this.g;
      int var8 = -1;
      if (var4 != null) {
         var8 = var4.e;
      }

      if (var7) {
         var8 = -999;
      }

      yg var10;
      Iterator var11;
      if (this.M && var4 != null && var3 == 0 && this.h.a((zx)null, var4)) {
         if (r()) {
            if (var4 != null && var4.d != null && this.N != null) {
               var11 = this.h.c.iterator();

               while(var11.hasNext()) {
                  var10 = (yg)var11.next();
                  if (var10 != null && var10.a((wn)this.j.h) && var10.e() && var10.d == var4.d && xi.a(var10, this.N, true)) {
                     this.a(var10, var10.e, var3, 1);
                  }
               }
            }
         } else {
            this.a(var4, var8, var3, 6);
         }

         this.M = false;
         this.J = 0L;
      } else {
         if (this.t && this.G != var3) {
            this.t = false;
            this.s.clear();
            this.H = true;
            return;
         }

         if (this.H) {
            this.H = false;
            return;
         }

         boolean var9;
         if (this.v != null && this.j.t.A) {
            if (var3 == 0 || var3 == 1) {
               if (this.x == null && var4 != this.v) {
                  this.x = this.v.d();
               }

               var9 = xi.a(var4, this.x, false);
               if (var8 != -1 && this.x != null && var9) {
                  this.a(this.v, this.v.e, var3, 0);
                  this.a(var4, var8, 0, 0);
                  if (this.j.h.bi.p() != null) {
                     this.a(this.v, this.v.e, var3, 0);
                     this.y = var1 - var5;
                     this.z = var2 - var6;
                     this.A = this.v;
                     this.C = this.x;
                     this.B = ave.J();
                  } else {
                     this.C = null;
                  }
               } else if (this.x != null) {
                  this.y = var1 - var5;
                  this.z = var2 - var6;
                  this.A = this.v;
                  this.C = this.x;
                  this.B = ave.J();
               }

               this.x = null;
               this.v = null;
            }
         } else if (this.t && !this.s.isEmpty()) {
            this.a((yg)null, -999, xi.d(0, this.F), 5);
            var11 = this.s.iterator();

            while(var11.hasNext()) {
               var10 = (yg)var11.next();
               this.a(var10, var10.e, xi.d(1, this.F), 5);
            }

            this.a((yg)null, -999, xi.d(2, this.F), 5);
         } else if (this.j.h.bi.p() != null) {
            if (var3 == this.j.t.aj.i() + 100) {
               this.a(var4, var8, var3, 3);
            } else {
               var9 = var8 != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
               if (var9) {
                  this.N = var4 != null && var4.e() ? var4.d() : null;
               }

               this.a(var4, var8, var3, var9 ? 1 : 0);
            }
         }
      }

      if (this.j.h.bi.p() == null) {
         this.J = 0L;
      }

      this.t = false;
   }

   public ayl(xi var1) {
      this.h = var1;
      this.H = true;
   }

   private boolean a(yg var1, int var2, int var3) {
      return this.c(var1.f, var1.g, 16, 16, var2, var3);
   }

   private yg c(int var1, int var2) {
      for(int var3 = 0; var3 < this.h.c.size(); ++var3) {
         yg var4 = (yg)this.h.c.get(var3);
         if (this.a(var4, var1, var2)) {
            return var4;
         }
      }

      return null;
   }

   protected void b(int var1, int var2) {
   }

   public void m() {
      if (this.j.h != null) {
         this.h.b((wn)this.j.h);
      }
   }

   public void e() {
      super.e();
      if (!this.j.h.ai() || this.j.h.I) {
         this.j.h.n();
      }

   }

   public boolean d() {
      return false;
   }

   protected void a(yg var1, int var2, int var3, int var4) {
      if (var1 != null) {
         var2 = var1.e;
      }

      this.j.c.a(this.h.d, var2, var3, var4, this.j.h);
   }

   private void a(zx var1, int var2, int var3, String var4) {
      bfl.b(0.0F, 0.0F, 32.0F);
      this.e = 200.0F;
      this.k.a = 200.0F;
      this.k.b(var1, var2, var3);
      this.k.a(this.q, var1, var2, var3 - (this.x == null ? 0 : 8), var4);
      this.e = 0.0F;
      this.k.a = 0.0F;
   }

   protected abstract void a(float var1, int var2, int var3);

   protected void a(char var1, int var2) {
      if (var2 == 1 || var2 == this.j.t.af.i()) {
         this.j.h.n();
      }

      this.b(var2);
      if (this.u != null && this.u.e()) {
         if (var2 == this.j.t.aj.i()) {
            this.a(this.u, this.u.e, 0, 3);
         } else if (var2 == this.j.t.ah.i()) {
            this.a(this.u, this.u.e, q() ? 1 : 0, 4);
         }
      }

   }

   protected boolean c(int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = this.i;
      int var8 = this.r;
      var5 -= var7;
      var6 -= var8;
      return var5 >= var1 - 1 && var5 < var1 + var3 + 1 && var6 >= var2 - 1 && var6 < var2 + var4 + 1;
   }

   private void a() {
      zx var1 = this.j.h.bi.p();
      if (var1 != null && this.t) {
         this.I = var1.b;

         zx var4;
         int var5;
         for(Iterator var2 = this.s.iterator(); var2.hasNext(); this.I -= var4.b - var5) {
            yg var3 = (yg)var2.next();
            var4 = var1.k();
            var5 = var3.d() == null ? 0 : var3.d().b;
            xi.a(this.s, this.F, var4, var5);
            if (var4.b > var4.c()) {
               var4.b = var4.c();
            }

            if (var4.b > var3.b(var4)) {
               var4.b = var3.b(var4);
            }
         }

      }
   }

   protected boolean b(int var1) {
      if (this.j.h.bi.p() == null && this.u != null) {
         for(int var2 = 0; var2 < 9; ++var2) {
            if (var1 == this.j.t.aw[var2].i()) {
               this.a(this.u, this.u.e, var2, 2);
               return true;
            }
         }
      }

      return false;
   }

   public void b() {
      super.b();
      this.j.h.bk = this.h;
      this.i = (this.l - this.f) / 2;
      this.r = (this.m - this.g) / 2;
   }
}
