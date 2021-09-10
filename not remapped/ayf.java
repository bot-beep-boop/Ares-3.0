import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.lwjgl.input.Mouse;

public class ayf extends axu implements ayg {
   protected String f = "Select world";
   private ayf.b g;
   private ayf.c h;
   private ayf.d r;
   private awi t;
   private nb s;
   protected axu a;
   private ayf.a i;
   private boolean u = true;

   public void f() {
      this.g = new ayf.b(this, this.j);
      this.g.d(1, 1);
      this.h = new ayf.c(this, this.j);
      this.h.d(1, 1);
      this.i = new ayf.a(this, this.j);
      this.i.d(1, 1);
      this.r = new ayf.d(this, this.j);
      this.r.d(1, 1);
   }

   static avn d(ayf var0) {
      return var0.q;
   }

   private void b(int var1, int var2) {
      this.c(var1, var2, 0, 0);
   }

   static avn g(ayf var0) {
      return var0.q;
   }

   static avn j(ayf var0) {
      return var0.q;
   }

   public void g() {
      this.n.add(new avs(0, this.l / 2 + 4, this.m - 28, 150, 20, bnq.a("gui.done")));
      this.n.add(new avs(1, this.l / 2 - 160, this.m - 52, 80, 20, bnq.a("stat.generalButton")));
      avs var1;
      this.n.add(var1 = new avs(2, this.l / 2 - 80, this.m - 52, 80, 20, bnq.a("stat.blocksButton")));
      avs var2;
      this.n.add(var2 = new avs(3, this.l / 2, this.m - 52, 80, 20, bnq.a("stat.itemsButton")));
      avs var3;
      this.n.add(var3 = new avs(4, this.l / 2 + 80, this.m - 52, 80, 20, bnq.a("stat.mobsButton")));
      if (this.i.b() == 0) {
         var1.l = false;
      }

      if (this.h.b() == 0) {
         var2.l = false;
      }

      if (this.r.b() == 0) {
         var3.l = false;
      }

   }

   static avn l(ayf var0) {
      return var0.q;
   }

   static avn e(ayf var0) {
      return var0.q;
   }

   static void a(ayf var0, int var1, int var2, zw var3) {
      var0.a(var1, var2, var3);
   }

   private void c(int var1, int var2, int var3, int var4) {
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      this.j.P().a(c);
      float var5 = 0.0078125F;
      float var6 = 0.0078125F;
      boolean var7 = true;
      boolean var8 = true;
      bfx var9 = bfx.a();
      bfd var10 = var9.c();
      var10.a(7, bms.g);
      var10.b((double)var1, (double)(var2 + 18), (double)this.e).a((double)((float)var3 * 0.0078125F), (double)((float)(var4 + 18) * 0.0078125F)).d();
      var10.b((double)(var1 + 18), (double)(var2 + 18), (double)this.e).a((double)((float)(var3 + 18) * 0.0078125F), (double)((float)(var4 + 18) * 0.0078125F)).d();
      var10.b((double)(var1 + 18), (double)var2, (double)this.e).a((double)((float)(var3 + 18) * 0.0078125F), (double)((float)var4 * 0.0078125F)).d();
      var10.b((double)var1, (double)var2, (double)this.e).a((double)((float)var3 * 0.0078125F), (double)((float)var4 * 0.0078125F)).d();
      var9.b();
   }

   static nb b(ayf var0) {
      return var0.s;
   }

   static avn q(ayf var0) {
      return var0.q;
   }

   static avn m(ayf var0) {
      return var0.q;
   }

   static avn i(ayf var0) {
      return var0.q;
   }

   public boolean d() {
      return !this.u;
   }

   static avn o(ayf var0) {
      return var0.q;
   }

   static avn c(ayf var0) {
      return var0.q;
   }

   static avn h(ayf var0) {
      return var0.q;
   }

   static avn n(ayf var0) {
      return var0.q;
   }

   public void a(int var1, int var2, float var3) {
      if (this.u) {
         this.c();
         this.a(this.q, bnq.a("multiplayer.downloadingStats"), this.l / 2, this.m / 2, 16777215);
         this.a(this.q, c_[(int)(ave.J() / 150L % (long)c_.length)], this.l / 2, this.m / 2 + this.q.a * 2, 16777215);
      } else {
         this.t.a(var1, var2, var3);
         this.a(this.q, this.f, this.l / 2, 20, 16777215);
         super.a(var1, var2, var3);
      }

   }

   static avn f(ayf var0) {
      return var0.q;
   }

   static avn a(ayf var0) {
      return var0.q;
   }

   public ayf(axu var1, nb var2) {
      this.a = var1;
      this.s = var2;
   }

   static void a(ayf var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      var0.a(var1, var2, var3, var4, var5, var6);
   }

   static void a(ayf var0, int var1, int var2, int var3, int var4) {
      var0.c(var1, var2, var3, var4);
   }

   static avn k(ayf var0) {
      return var0.q;
   }

   static avn p(ayf var0) {
      return var0.q;
   }

   private void a(int var1, int var2, zw var3) {
      this.b(var1 + 1, var2 + 1);
      bfl.B();
      avc.c();
      this.k.a(new zx(var3, 1, 0), var1 + 2, var2 + 2);
      avc.a();
      bfl.C();
   }

   public void k() {
      super.k();
      if (this.t != null) {
         this.t.p();
      }

   }

   protected void a(avs var1) {
      if (var1.l) {
         if (var1.k == 0) {
            this.j.a(this.a);
         } else if (var1.k == 1) {
            this.t = this.g;
         } else if (var1.k == 3) {
            this.t = this.h;
         } else if (var1.k == 2) {
            this.t = this.i;
         } else if (var1.k == 4) {
            this.t = this.r;
         } else {
            this.t.a(var1);
         }

      }
   }

   static void b(ayf var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      var0.a(var1, var2, var3, var4, var5, var6);
   }

   static avn r(ayf var0) {
      return var0.q;
   }

   public void a() {
      if (this.u) {
         this.f();
         this.g();
         this.t = this.g;
         this.u = false;
      }

   }

   static avn s(ayf var0) {
      return var0.q;
   }

   public void b() {
      this.f = bnq.a("gui.stats");
      this.u = true;
      this.j.u().a((ff)(new ig(ig.a.b)));
   }

   abstract class e extends awi {
      protected Comparator<mu> x;
      final ayf A;
      protected List<mu> w;
      protected int y;
      protected int z;
      protected int v;

      protected void a(int var1, int var2) {
         this.v = -1;
         if (var1 >= 79 && var1 < 115) {
            this.v = 0;
         } else if (var1 >= 129 && var1 < 165) {
            this.v = 1;
         } else if (var1 >= 179 && var1 < 215) {
            this.v = 2;
         }

         if (this.v >= 0) {
            this.d(this.v);
            this.a.W().a((bpj)bpf.a(new jy("gui.button.press"), 1.0F));
         }

      }

      protected void a(mu var1, int var2, int var3) {
         if (var1 != null) {
            zw var4 = var1.a();
            zx var5 = new zx(var4);
            String var6 = var5.a();
            String var7 = ("" + bnq.a(var6 + ".name")).trim();
            if (var7.length() > 0) {
               int var8 = var2 + 12;
               int var9 = var3 - 12;
               int var10 = ayf.k(this.A).a(var7);
               ayf.b(this.A, var8 - 3, var9 - 3, var8 + var10 + 3, var9 + 8 + 3, -1073741824, -1073741824);
               ayf.l(this.A).a(var7, (float)var8, (float)var9, -1);
            }

         }
      }

      protected void a(mw var1, int var2, int var3, boolean var4) {
         String var5;
         if (var1 != null) {
            var5 = var1.a(ayf.b(this.A).a(var1));
            this.A.c(ayf.e(this.A), var5, var2 - ayf.f(this.A).a(var5), var3 + 5, var4 ? 16777215 : 9474192);
         } else {
            var5 = "-";
            this.A.c(ayf.g(this.A), var5, var2 - ayf.h(this.A).a(var5), var3 + 5, var4 ? 16777215 : 9474192);
         }

      }

      protected boolean a(int var1) {
         return false;
      }

      protected void b(int var1, int var2) {
         if (var2 >= this.d && var2 <= this.e) {
            int var3 = this.c(var1, var2);
            int var4 = this.b / 2 - 92 - 16;
            if (var3 >= 0) {
               if (var1 < var4 + 40 || var1 > var4 + 40 + 20) {
                  return;
               }

               mu var9 = this.c(var3);
               this.a(var9, var1, var2);
            } else {
               String var5 = "";
               if (var1 >= var4 + 115 - 18 && var1 <= var4 + 115) {
                  var5 = this.b(0);
               } else if (var1 >= var4 + 165 - 18 && var1 <= var4 + 165) {
                  var5 = this.b(1);
               } else {
                  if (var1 < var4 + 215 - 18 || var1 > var4 + 215) {
                     return;
                  }

                  var5 = this.b(2);
               }

               var5 = ("" + bnq.a(var5)).trim();
               if (var5.length() > 0) {
                  int var6 = var1 + 12;
                  int var7 = var2 - 12;
                  int var8 = ayf.i(this.A).a(var5);
                  ayf.a(this.A, var6 - 3, var7 - 3, var6 + var8 + 3, var7 + 8 + 3, -1073741824, -1073741824);
                  ayf.j(this.A).a(var5, (float)var6, (float)var7, -1);
               }
            }

         }
      }

      protected void a(int var1, boolean var2, int var3, int var4) {
      }

      protected void a(int var1, int var2, bfx var3) {
         if (!Mouse.isButtonDown(0)) {
            this.v = -1;
         }

         if (this.v == 0) {
            ayf.a(this.A, var1 + 115 - 18, var2 + 1, 0, 0);
         } else {
            ayf.a(this.A, var1 + 115 - 18, var2 + 1, 0, 18);
         }

         if (this.v == 1) {
            ayf.a(this.A, var1 + 165 - 18, var2 + 1, 0, 0);
         } else {
            ayf.a(this.A, var1 + 165 - 18, var2 + 1, 0, 18);
         }

         if (this.v == 2) {
            ayf.a(this.A, var1 + 215 - 18, var2 + 1, 0, 0);
         } else {
            ayf.a(this.A, var1 + 215 - 18, var2 + 1, 0, 18);
         }

         if (this.y != -1) {
            short var4 = 79;
            byte var5 = 18;
            if (this.y == 1) {
               var4 = 129;
            } else if (this.y == 2) {
               var4 = 179;
            }

            if (this.z == 1) {
               var5 = 36;
            }

            ayf.a(this.A, var1 + var4, var2 + 1, var5, 0);
         }

      }

      protected abstract String b(int var1);

      protected void a() {
         this.A.c();
      }

      protected void d(int var1) {
         if (var1 != this.y) {
            this.y = var1;
            this.z = -1;
         } else if (this.z == -1) {
            this.z = 1;
         } else {
            this.y = -1;
            this.z = 0;
         }

         Collections.sort(this.w, this.x);
      }

      protected final mu c(int var1) {
         return (mu)this.w.get(var1);
      }

      protected e(ayf var1, ave var2) {
         super(var2, var1.l, var1.m, 32, var1.m - 64, 20);
         this.A = var1;
         this.v = -1;
         this.y = -1;
         this.b(false);
         this.a(true, 20);
      }

      protected final int b() {
         return this.w.size();
      }
   }

   class a extends ayf.e {
      final ayf u;

      protected void a(int var1, int var2, int var3, int var4, int var5, int var6) {
         mu var7 = this.c(var1);
         zw var8 = var7.a();
         ayf.a(this.u, var2 + 40, var3, var8);
         int var9 = zw.b(var8);
         this.a(na.ac[var9], var2 + 115, var3, var1 % 2 == 0);
         this.a(na.ad[var9], var2 + 165, var3, var1 % 2 == 0);
         this.a(var7, var2 + 215, var3, var1 % 2 == 0);
      }

      protected String b(int var1) {
         if (var1 == 0) {
            return "stat.crafted";
         } else {
            return var1 == 1 ? "stat.used" : "stat.mined";
         }
      }

      public a(ayf var1, ave var2) {
         super(var1, var2);
         this.u = var1;
         this.w = Lists.newArrayList();
         Iterator var3 = na.e.iterator();

         while(var3.hasNext()) {
            mu var4 = (mu)var3.next();
            boolean var5 = false;
            int var6 = zw.b(var4.a());
            if (ayf.b(var1).a((mw)var4) > 0) {
               var5 = true;
            } else if (na.ad[var6] != null && ayf.b(var1).a(na.ad[var6]) > 0) {
               var5 = true;
            } else if (na.ac[var6] != null && ayf.b(var1).a(na.ac[var6]) > 0) {
               var5 = true;
            }

            if (var5) {
               this.w.add(var4);
            }
         }

         this.x = new Comparator<mu>(this, var1) {
            final ayf.a b;
            final ayf a;

            public int a(mu var1, mu var2) {
               int var3 = zw.b(var1.a());
               int var4 = zw.b(var2.a());
               mw var5 = null;
               mw var6 = null;
               if (this.b.y == 2) {
                  var5 = na.ab[var3];
                  var6 = na.ab[var4];
               } else if (this.b.y == 0) {
                  var5 = na.ac[var3];
                  var6 = na.ac[var4];
               } else if (this.b.y == 1) {
                  var5 = na.ad[var3];
                  var6 = na.ad[var4];
               }

               if (var5 != null || var6 != null) {
                  if (var5 == null) {
                     return 1;
                  }

                  if (var6 == null) {
                     return -1;
                  }

                  int var7 = ayf.b(this.b.u).a(var5);
                  int var8 = ayf.b(this.b.u).a(var6);
                  if (var7 != var8) {
                     return (var7 - var8) * this.b.z;
                  }
               }

               return var3 - var4;
            }

            {
               this.b = var1;
               this.a = var2;
            }

            public int compare(Object var1, Object var2) {
               return this.a((mu)var1, (mu)var2);
            }
         };
      }

      protected void a(int var1, int var2, bfx var3) {
         super.a(var1, var2, var3);
         if (this.v == 0) {
            ayf.a(this.u, var1 + 115 - 18 + 1, var2 + 1 + 1, 18, 18);
         } else {
            ayf.a(this.u, var1 + 115 - 18, var2 + 1, 18, 18);
         }

         if (this.v == 1) {
            ayf.a(this.u, var1 + 165 - 18 + 1, var2 + 1 + 1, 36, 18);
         } else {
            ayf.a(this.u, var1 + 165 - 18, var2 + 1, 36, 18);
         }

         if (this.v == 2) {
            ayf.a(this.u, var1 + 215 - 18 + 1, var2 + 1 + 1, 54, 18);
         } else {
            ayf.a(this.u, var1 + 215 - 18, var2 + 1, 54, 18);
         }

      }
   }

   class d extends awi {
      private final List<pm.a> v;
      final ayf u;

      protected void a(int var1, int var2, int var3, int var4, int var5, int var6) {
         pm.a var7 = (pm.a)this.v.get(var1);
         String var8 = bnq.a("entity." + pm.b(var7.a) + ".name");
         int var9 = ayf.b(this.u).a(var7.d);
         int var10 = ayf.b(this.u).a(var7.e);
         String var11 = bnq.a("stat.entityKills", var9, var8);
         String var12 = bnq.a("stat.entityKilledBy", var8, var10);
         if (var9 == 0) {
            var11 = bnq.a("stat.entityKills.none", var8);
         }

         if (var10 == 0) {
            var12 = bnq.a("stat.entityKilledBy.none", var8);
         }

         this.u.c(ayf.o(this.u), var8, var2 + 2 - 10, var3 + 1, 16777215);
         this.u.c(ayf.p(this.u), var11, var2 + 2, var3 + 1 + ayf.q(this.u).a, var9 == 0 ? 6316128 : 9474192);
         this.u.c(ayf.r(this.u), var12, var2 + 2, var3 + 1 + ayf.s(this.u).a * 2, var10 == 0 ? 6316128 : 9474192);
      }

      protected void a() {
         this.u.c();
      }

      protected void a(int var1, boolean var2, int var3, int var4) {
      }

      protected boolean a(int var1) {
         return false;
      }

      public d(ayf var1, ave var2) {
         super(var2, var1.l, var1.m, 32, var1.m - 64, ayf.m(var1).a * 4);
         this.u = var1;
         this.v = Lists.newArrayList();
         this.b(false);
         Iterator var3 = pm.a.values().iterator();

         while(true) {
            pm.a var4;
            do {
               if (!var3.hasNext()) {
                  return;
               }

               var4 = (pm.a)var3.next();
            } while(ayf.b(var1).a(var4.d) <= 0 && ayf.b(var1).a(var4.e) <= 0);

            this.v.add(var4);
         }
      }

      protected int k() {
         return this.b() * ayf.n(this.u).a * 4;
      }

      protected int b() {
         return this.v.size();
      }
   }

   class c extends ayf.e {
      final ayf u;

      protected void a(int var1, int var2, bfx var3) {
         super.a(var1, var2, var3);
         if (this.v == 0) {
            ayf.a(this.u, var1 + 115 - 18 + 1, var2 + 1 + 1, 72, 18);
         } else {
            ayf.a(this.u, var1 + 115 - 18, var2 + 1, 72, 18);
         }

         if (this.v == 1) {
            ayf.a(this.u, var1 + 165 - 18 + 1, var2 + 1 + 1, 18, 18);
         } else {
            ayf.a(this.u, var1 + 165 - 18, var2 + 1, 18, 18);
         }

         if (this.v == 2) {
            ayf.a(this.u, var1 + 215 - 18 + 1, var2 + 1 + 1, 36, 18);
         } else {
            ayf.a(this.u, var1 + 215 - 18, var2 + 1, 36, 18);
         }

      }

      public c(ayf var1, ave var2) {
         super(var1, var2);
         this.u = var1;
         this.w = Lists.newArrayList();
         Iterator var3 = na.d.iterator();

         while(var3.hasNext()) {
            mu var4 = (mu)var3.next();
            boolean var5 = false;
            int var6 = zw.b(var4.a());
            if (ayf.b(var1).a((mw)var4) > 0) {
               var5 = true;
            } else if (na.ae[var6] != null && ayf.b(var1).a(na.ae[var6]) > 0) {
               var5 = true;
            } else if (na.ac[var6] != null && ayf.b(var1).a(na.ac[var6]) > 0) {
               var5 = true;
            }

            if (var5) {
               this.w.add(var4);
            }
         }

         this.x = new Comparator<mu>(this, var1) {
            final ayf.c b;
            final ayf a;

            {
               this.b = var1;
               this.a = var2;
            }

            public int compare(Object var1, Object var2) {
               return this.a((mu)var1, (mu)var2);
            }

            public int a(mu var1, mu var2) {
               int var3 = zw.b(var1.a());
               int var4 = zw.b(var2.a());
               mw var5 = null;
               mw var6 = null;
               if (this.b.y == 0) {
                  var5 = na.ae[var3];
                  var6 = na.ae[var4];
               } else if (this.b.y == 1) {
                  var5 = na.ac[var3];
                  var6 = na.ac[var4];
               } else if (this.b.y == 2) {
                  var5 = na.ad[var3];
                  var6 = na.ad[var4];
               }

               if (var5 != null || var6 != null) {
                  if (var5 == null) {
                     return 1;
                  }

                  if (var6 == null) {
                     return -1;
                  }

                  int var7 = ayf.b(this.b.u).a(var5);
                  int var8 = ayf.b(this.b.u).a(var6);
                  if (var7 != var8) {
                     return (var7 - var8) * this.b.z;
                  }
               }

               return var3 - var4;
            }
         };
      }

      protected void a(int var1, int var2, int var3, int var4, int var5, int var6) {
         mu var7 = this.c(var1);
         zw var8 = var7.a();
         ayf.a(this.u, var2 + 40, var3, var8);
         int var9 = zw.b(var8);
         this.a(na.ae[var9], var2 + 115, var3, var1 % 2 == 0);
         this.a(na.ac[var9], var2 + 165, var3, var1 % 2 == 0);
         this.a(var7, var2 + 215, var3, var1 % 2 == 0);
      }

      protected String b(int var1) {
         if (var1 == 1) {
            return "stat.crafted";
         } else {
            return var1 == 2 ? "stat.used" : "stat.depleted";
         }
      }
   }

   class b extends awi {
      final ayf u;

      protected void a(int var1, int var2, int var3, int var4, int var5, int var6) {
         mw var7 = (mw)na.c.get(var1);
         this.u.c(ayf.a(this.u), var7.e().c(), var2 + 2, var3 + 1, var1 % 2 == 0 ? 16777215 : 9474192);
         String var8 = var7.a(ayf.b(this.u).a(var7));
         this.u.c(ayf.c(this.u), var8, var2 + 2 + 213 - ayf.d(this.u).a(var8), var3 + 1, var1 % 2 == 0 ? 16777215 : 9474192);
      }

      protected void a() {
         this.u.c();
      }

      public b(ayf var1, ave var2) {
         super(var2, var1.l, var1.m, 32, var1.m - 64, 10);
         this.u = var1;
         this.b(false);
      }

      protected void a(int var1, boolean var2, int var3, int var4) {
      }

      protected int b() {
         return na.c.size();
      }

      protected int k() {
         return this.b() * 10;
      }

      protected boolean a(int var1) {
         return false;
      }
   }
}
