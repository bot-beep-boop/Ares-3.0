import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class ayu extends ayw {
   private float x;
   private static final jy u = new jy("textures/gui/container/creative_inventory/tabs.png");
   private ayt E;
   private avw A;
   private static oq v = new oq("tmp", true, 45);
   private boolean D;
   private boolean y;
   private yg C;
   private boolean z;
   private List<yg> B;
   private static int w;

   public void k() {
      super.k();
      int var1 = Mouse.getEventDWheel();
      if (var1 != 0 && this.i()) {
         int var2 = ((ayu.a)this.h).a.size() / 9 - 5;
         if (var1 > 0) {
            var1 = 1;
         }

         if (var1 < 0) {
            var1 = -1;
         }

         this.x = (float)((double)this.x - (double)var1 / (double)var2);
         this.x = ns.a(this.x, 0.0F, 1.0F);
         ((ayu.a)this.h).a(this.x);
      }

   }

   protected void b(int var1, int var2, int var3) {
      if (var3 == 0) {
         int var4 = var1 - this.i;
         int var5 = var2 - this.r;
         yz[] var6 = yz.a;
         int var7 = var6.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            yz var9 = var6[var8];
            if (this.a(var9, var4, var5)) {
               this.b(var9);
               return;
            }
         }
      }

      super.b(var1, var2, var3);
   }

   protected void a(yg var1, int var2, int var3, int var4) {
      this.D = true;
      boolean var5 = var4 == 1;
      var4 = var2 == -999 && var4 == 0 ? 4 : var4;
      zx var7;
      wm var11;
      if (var1 == null && w != yz.m.a() && var4 != 5) {
         var11 = this.j.h.bi;
         if (var11.p() != null) {
            if (var3 == 0) {
               this.j.h.a(var11.p(), true);
               this.j.c.a(var11.p());
               var11.b((zx)null);
            }

            if (var3 == 1) {
               var7 = var11.p().a(1);
               this.j.h.a(var7, true);
               this.j.c.a(var7);
               if (var11.p().b == 0) {
                  var11.b((zx)null);
               }
            }
         }
      } else {
         int var10;
         if (var1 == this.C && var5) {
            for(var10 = 0; var10 < this.j.h.bj.a().size(); ++var10) {
               this.j.c.a((zx)null, var10);
            }
         } else {
            zx var6;
            if (w == yz.m.a()) {
               if (var1 == this.C) {
                  this.j.h.bi.b((zx)null);
               } else if (var4 == 4 && var1 != null && var1.e()) {
                  var6 = var1.a(var3 == 0 ? 1 : var1.d().c());
                  this.j.h.a(var6, true);
                  this.j.c.a(var6);
               } else if (var4 == 4 && this.j.h.bi.p() != null) {
                  this.j.h.a(this.j.h.bi.p(), true);
                  this.j.c.a(this.j.h.bi.p());
                  this.j.h.bi.b((zx)null);
               } else {
                  this.j.h.bj.a(var1 == null ? var2 : ayu.b.a((ayu.b)var1).e, var3, var4, this.j.h);
                  this.j.h.bj.b();
               }
            } else if (var4 != 5 && var1.d == v) {
               var11 = this.j.h.bi;
               var7 = var11.p();
               zx var8 = var1.d();
               zx var9;
               if (var4 == 2) {
                  if (var8 != null && var3 >= 0 && var3 < 9) {
                     var9 = var8.k();
                     var9.b = var9.c();
                     this.j.h.bi.a(var3, var9);
                     this.j.h.bj.b();
                  }

                  return;
               }

               if (var4 == 3) {
                  if (var11.p() == null && var1.e()) {
                     var9 = var1.d().k();
                     var9.b = var9.c();
                     var11.b(var9);
                  }

                  return;
               }

               if (var4 == 4) {
                  if (var8 != null) {
                     var9 = var8.k();
                     var9.b = var3 == 0 ? 1 : var9.c();
                     this.j.h.a(var9, true);
                     this.j.c.a(var9);
                  }

                  return;
               }

               if (var7 != null && var8 != null && var7.a(var8)) {
                  if (var3 == 0) {
                     if (var5) {
                        var7.b = var7.c();
                     } else if (var7.b < var7.c()) {
                        ++var7.b;
                     }
                  } else if (var7.b <= 1) {
                     var11.b((zx)null);
                  } else {
                     --var7.b;
                  }
               } else if (var8 != null && var7 == null) {
                  var11.b(zx.b(var8));
                  var7 = var11.p();
                  if (var5) {
                     var7.b = var7.c();
                  }
               } else {
                  var11.b((zx)null);
               }
            } else {
               this.h.a(var1 == null ? var2 : var1.e, var3, var4, this.j.h);
               if (xi.c(var3) == 2) {
                  for(var10 = 0; var10 < 9; ++var10) {
                     this.j.c.a(this.h.a(45 + var10).d(), 36 + var10);
                  }
               } else if (var1 != null) {
                  var6 = this.h.a(var1.e).d();
                  this.j.c.a(var6, var1.e - this.h.c.size() + 9 + 36);
               }
            }
         }
      }

   }

   protected void a(zx var1, int var2, int var3) {
      if (w == yz.g.a()) {
         List var4 = var1.a((wn)this.j.h, this.j.t.y);
         yz var5 = var1.b().c();
         if (var5 == null && var1.b() == zy.cd) {
            Map var6 = ack.a(var1);
            if (var6.size() == 1) {
               aci var7 = aci.c((Integer)var6.keySet().iterator().next());
               yz[] var8 = yz.a;
               int var9 = var8.length;

               for(int var10 = 0; var10 < var9; ++var10) {
                  yz var11 = var8[var10];
                  if (var11.a(var7.C)) {
                     var5 = var11;
                     break;
                  }
               }
            }
         }

         if (var5 != null) {
            var4.add(1, "" + .a.r + .a.j + bnq.a(var5.c()));
         }

         for(int var12 = 0; var12 < var4.size(); ++var12) {
            if (var12 == 0) {
               var4.set(var12, var1.u().e + (String)var4.get(var12));
            } else {
               var4.set(var12, .a.h + (String)var4.get(var12));
            }
         }

         this.a((List)var4, var2, var3);
      } else {
         super.a(var1, var2, var3);
      }

   }

   protected void a(yz var1) {
      boolean var2 = var1.a() == w;
      boolean var3 = var1.m();
      int var4 = var1.l();
      int var5 = var4 * 28;
      int var6 = 0;
      int var7 = this.i + 28 * var4;
      int var8 = this.r;
      byte var9 = 32;
      if (var2) {
         var6 += 32;
      }

      if (var4 == 5) {
         var7 = this.i + this.f - 28;
      } else if (var4 > 0) {
         var7 += var4;
      }

      if (var3) {
         var8 -= 28;
      } else {
         var6 += 64;
         var8 += this.g - 4;
      }

      bfl.f();
      this.b(var7, var8, var5, var6, 28, var9);
      this.e = 100.0F;
      this.k.a = 100.0F;
      var7 += 6;
      var8 += 8 + (var3 ? 1 : -1);
      bfl.e();
      bfl.B();
      zx var10 = var1.d();
      this.k.b(var10, var7, var8);
      this.k.a(this.q, var10, var7, var8);
      bfl.f();
      this.k.a = 0.0F;
      this.e = 0.0F;
   }

   static oq g() {
      return v;
   }

   static {
      w = yz.b.a();
   }

   public void a(int var1, int var2, float var3) {
      boolean var4 = Mouse.isButtonDown(0);
      int var5 = this.i;
      int var6 = this.r;
      int var7 = var5 + 175;
      int var8 = var6 + 18;
      int var9 = var7 + 14;
      int var10 = var8 + 112;
      if (!this.z && var4 && var1 >= var7 && var2 >= var8 && var1 < var9 && var2 < var10) {
         this.y = this.i();
      }

      if (!var4) {
         this.y = false;
      }

      this.z = var4;
      if (this.y) {
         this.x = ((float)(var2 - var8) - 7.5F) / ((float)(var10 - var8) - 15.0F);
         this.x = ns.a(this.x, 0.0F, 1.0F);
         ((ayu.a)this.h).a(this.x);
      }

      super.a(var1, var2, var3);
      yz[] var11 = yz.a;
      int var12 = var11.length;

      for(int var13 = 0; var13 < var12; ++var13) {
         yz var14 = var11[var13];
         if (this.b(var14, var1, var2)) {
            break;
         }
      }

      if (this.C != null && w == yz.m.a() && this.c(this.C.f, this.C.g, 16, 16, var1, var2)) {
         this.a((String)bnq.a("inventory.binSlot"), var1, var2);
      }

      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      bfl.f();
   }

   protected void a(char var1, int var2) {
      if (w != yz.g.a()) {
         if (avh.a(this.j.t.ak)) {
            this.b(yz.g);
         } else {
            super.a(var1, var2);
         }

      } else {
         if (this.D) {
            this.D = false;
            this.A.a("");
         }

         if (!this.b(var2)) {
            if (this.A.a(var1, var2)) {
               this.h();
            } else {
               super.a(var1, var2);
            }

         }
      }
   }

   protected boolean a(yz var1, int var2, int var3) {
      int var4 = var1.l();
      int var5 = 28 * var4;
      byte var6 = 0;
      if (var4 == 5) {
         var5 = this.f - 28 + 2;
      } else if (var4 > 0) {
         var5 += var4;
      }

      int var7;
      if (var1.m()) {
         var7 = var6 - 32;
      } else {
         var7 = var6 + this.g;
      }

      return var2 >= var5 && var2 <= var5 + 28 && var3 >= var7 && var3 <= var7 + 32;
   }

   public void m() {
      super.m();
      if (this.j.h != null && this.j.h.bi != null) {
         this.j.h.bj.b((xn)this.E);
      }

      Keyboard.enableRepeatEvents(false);
   }

   public ayu(wn var1) {
      super(new ayu.a(var1));
      var1.bk = this.h;
      this.p = true;
      this.g = 136;
      this.f = 195;
   }

   private boolean i() {
      return w != yz.m.a() && yz.a[w].j() && ((ayu.a)this.h).e();
   }

   protected void a(float var1, int var2, int var3) {
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      avc.c();
      yz var4 = yz.a[w];
      yz[] var5 = yz.a;
      int var6 = var5.length;

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         yz var8 = var5[var7];
         this.j.P().a(u);
         if (var8.a() != w) {
            this.a(var8);
         }
      }

      this.j.P().a(new jy("textures/gui/container/creative_inventory/tab_" + var4.g()));
      this.b(this.i, this.r, 0, 0, this.f, this.g);
      this.A.g();
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      int var9 = this.i + 175;
      var6 = this.r + 18;
      var7 = var6 + 112;
      this.j.P().a(u);
      if (var4.j()) {
         this.b(var9, var6 + (int)((float)(var7 - var6 - 17) * this.x), 232 + (this.i() ? 0 : 12), 0, 12, 15);
      }

      this.a(var4);
      if (var4 == yz.m) {
         azc.a(this.i + 43, this.r + 45, 20, (float)(this.i + 43 - var2), (float)(this.r + 45 - 30 - var3), this.j.h);
      }

   }

   public void b() {
      if (this.j.c.h()) {
         super.b();
         this.n.clear();
         Keyboard.enableRepeatEvents(true);
         this.A = new avw(0, this.q, this.i + 82, this.r + 6, 89, this.q.a);
         this.A.f(15);
         this.A.a(false);
         this.A.e(false);
         this.A.g(16777215);
         int var1 = w;
         w = -1;
         this.b(yz.a[var1]);
         this.E = new ayt(this.j);
         this.j.h.bj.a((xn)this.E);
      } else {
         this.j.a((axu)(new azc(this.j.h)));
      }

   }

   private void b(yz var1) {
      int var2 = w;
      w = var1.a();
      ayu.a var3 = (ayu.a)this.h;
      this.s.clear();
      var3.a.clear();
      var1.a(var3.a);
      if (var1 == yz.m) {
         xi var4 = this.j.h.bj;
         if (this.B == null) {
            this.B = var3.c;
         }

         var3.c = Lists.newArrayList();

         for(int var5 = 0; var5 < var4.c.size(); ++var5) {
            ayu.b var6 = new ayu.b(this, (yg)var4.c.get(var5), var5);
            var3.c.add(var6);
            int var7;
            int var8;
            int var9;
            if (var5 >= 5 && var5 < 9) {
               var7 = var5 - 5;
               var8 = var7 / 2;
               var9 = var7 % 2;
               var6.f = 9 + var8 * 54;
               var6.g = 6 + var9 * 27;
            } else if (var5 >= 0 && var5 < 5) {
               var6.g = -2000;
               var6.f = -2000;
            } else if (var5 < var4.c.size()) {
               var7 = var5 - 9;
               var8 = var7 % 9;
               var9 = var7 / 9;
               var6.f = 9 + var8 * 18;
               if (var5 >= 36) {
                  var6.g = 112;
               } else {
                  var6.g = 54 + var9 * 18;
               }
            }
         }

         this.C = new yg(v, 0, 173, 112);
         var3.c.add(this.C);
      } else if (var2 == yz.m.a()) {
         var3.c = this.B;
         this.B = null;
      }

      if (this.A != null) {
         if (var1 == yz.g) {
            this.A.e(true);
            this.A.d(false);
            this.A.b(true);
            this.A.a("");
            this.h();
         } else {
            this.A.e(false);
            this.A.d(true);
            this.A.b(false);
         }
      }

      this.x = 0.0F;
      var3.a(0.0F);
   }

   private void h() {
      ayu.a var1 = (ayu.a)this.h;
      var1.a.clear();
      Iterator var2 = zw.e.iterator();

      while(var2.hasNext()) {
         zw var3 = (zw)var2.next();
         if (var3 != null && var3.c() != null) {
            var3.a((zw)var3, (yz)null, (List)var1.a);
         }
      }

      aci[] var8 = aci.b;
      int var9 = var8.length;

      for(int var4 = 0; var4 < var9; ++var4) {
         aci var5 = var8[var4];
         if (var5 != null && var5.C != null) {
            zy.cd.a(var5, var1.a);
         }
      }

      var2 = var1.a.iterator();
      String var10 = this.A.b().toLowerCase();

      while(var2.hasNext()) {
         zx var11 = (zx)var2.next();
         boolean var12 = false;
         Iterator var6 = var11.a((wn)this.j.h, this.j.t.y).iterator();

         while(var6.hasNext()) {
            String var7 = (String)var6.next();
            if (.a.a(var7).toLowerCase().contains(var10)) {
               var12 = true;
               break;
            }
         }

         if (!var12) {
            var2.remove();
         }
      }

      this.x = 0.0F;
      var1.a(0.0F);
   }

   protected void a(int var1, int var2, int var3) {
      if (var3 == 0) {
         int var4 = var1 - this.i;
         int var5 = var2 - this.r;
         yz[] var6 = yz.a;
         int var7 = var6.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            yz var9 = var6[var8];
            if (this.a(var9, var4, var5)) {
               return;
            }
         }
      }

      super.a(var1, var2, var3);
   }

   public int f() {
      return w;
   }

   protected boolean b(yz var1, int var2, int var3) {
      int var4 = var1.l();
      int var5 = 28 * var4;
      byte var6 = 0;
      if (var4 == 5) {
         var5 = this.f - 28 + 2;
      } else if (var4 > 0) {
         var5 += var4;
      }

      int var7;
      if (var1.m()) {
         var7 = var6 - 32;
      } else {
         var7 = var6 + this.g;
      }

      if (this.c(var5 + 3, var7 + 3, 23, 27, var2, var3)) {
         this.a((String)bnq.a(var1.c()), var2, var3);
         return true;
      } else {
         return false;
      }
   }

   protected void a() {
      int var1 = this.i;
      super.a();
      if (this.A != null && this.i != var1) {
         this.A.a = this.i + 82;
      }

   }

   protected void b(int var1, int var2) {
      yz var3 = yz.a[w];
      if (var3.h()) {
         bfl.k();
         this.q.a(bnq.a(var3.c()), 8, 6, 4210752);
      }

   }

   public void e() {
      if (!this.j.c.h()) {
         this.j.a((axu)(new azc(this.j.h)));
      }

      this.a();
   }

   protected void a(avs var1) {
      if (var1.k == 0) {
         this.j.a((axu)(new aye(this, this.j.h.x())));
      }

      if (var1.k == 1) {
         this.j.a((axu)(new ayf(this, this.j.h.x())));
      }

   }

   static class a extends xi {
      public List<zx> a = Lists.newArrayList();

      public zx b(wn var1, int var2) {
         if (var2 >= this.c.size() - 9 && var2 < this.c.size()) {
            yg var3 = (yg)this.c.get(var2);
            if (var3 != null && var3.e()) {
               var3.d((zx)null);
            }
         }

         return null;
      }

      public boolean b(yg var1) {
         return var1.d instanceof wm || var1.g > 90 && var1.f <= 162;
      }

      public a(wn var1) {
         wm var2 = var1.bi;

         int var3;
         for(var3 = 0; var3 < 5; ++var3) {
            for(int var4 = 0; var4 < 9; ++var4) {
               this.a(new yg(ayu.g(), var3 * 9 + var4, 9 + var4 * 18, 18 + var3 * 18));
            }
         }

         for(var3 = 0; var3 < 9; ++var3) {
            this.a(new yg(var2, var3, 9 + var3 * 18, 112));
         }

         this.a(0.0F);
      }

      public boolean a(wn var1) {
         return true;
      }

      public void a(float var1) {
         int var2 = (this.a.size() + 9 - 1) / 9 - 5;
         int var3 = (int)((double)(var1 * (float)var2) + 0.5D);
         if (var3 < 0) {
            var3 = 0;
         }

         for(int var4 = 0; var4 < 5; ++var4) {
            for(int var5 = 0; var5 < 9; ++var5) {
               int var6 = var5 + (var4 + var3) * 9;
               if (var6 >= 0 && var6 < this.a.size()) {
                  ayu.g().a(var5 + var4 * 9, (zx)this.a.get(var6));
               } else {
                  ayu.g().a(var5 + var4 * 9, (zx)null);
               }
            }
         }

      }

      public boolean a(zx var1, yg var2) {
         return var2.g > 90;
      }

      public boolean e() {
         return this.a.size() > 45;
      }

      protected void a(int var1, int var2, boolean var3, wn var4) {
      }
   }

   class b extends yg {
      final ayu a;
      private final yg b;

      public int a() {
         return this.b.a();
      }

      public int b(zx var1) {
         return this.b.b(var1);
      }

      public zx a(int var1) {
         return this.b.a(var1);
      }

      public boolean a(zx var1) {
         return this.b.a(var1);
      }

      static yg a(ayu.b var0) {
         return var0.b;
      }

      public zx d() {
         return this.b.d();
      }

      public b(ayu var1, yg var2, int var3) {
         super(var2.d, var3, 0, 0);
         this.a = var1;
         this.b = var2;
      }

      public boolean e() {
         return this.b.e();
      }

      public void f() {
         this.b.f();
      }

      public boolean a(og var1, int var2) {
         return this.b.a(var1, var2);
      }

      public String c() {
         return this.b.c();
      }

      public void d(zx var1) {
         this.b.d(var1);
      }

      public void a(wn var1, zx var2) {
         this.b.a(var1, var2);
      }
   }
}
