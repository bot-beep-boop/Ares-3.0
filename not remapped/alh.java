public class alh extends alk implements ot, km {
   private int k;
   private zx[] h = new zx[3];
   private String m;
   private int l;
   private static final int[] f = new int[]{2, 1};
   private int i;
   private static final int[] a = new int[]{0};
   private static final int[] g = new int[]{1};
   private int j;

   public void b(int var1, int var2) {
      switch(var1) {
      case 0:
         this.i = var2;
         break;
      case 1:
         this.j = var2;
         break;
      case 2:
         this.k = var2;
         break;
      case 3:
         this.l = var2;
      }

   }

   public boolean b(int var1, zx var2, cq var3) {
      if (var3 == cq.a && var1 == 1) {
         zw var4 = var2.b();
         if (var4 != zy.ax && var4 != zy.aw) {
            return false;
         }
      }

      return true;
   }

   public int[] a(cq var1) {
      if (var1 == cq.a) {
         return f;
      } else {
         return var1 == cq.b ? a : g;
      }
   }

   public void a(String var1) {
      this.m = var1;
   }

   public xi a(wm var1, wn var2) {
      return new xu(var1, this);
   }

   public static boolean a(og var0) {
      return var0.a_(0) > 0;
   }

   public void c() {
      boolean var1 = this.m();
      boolean var2 = false;
      if (this.m()) {
         --this.i;
      }

      if (!this.b.D) {
         if (!this.m() && (this.h[1] == null || this.h[0] == null)) {
            if (!this.m() && this.k > 0) {
               this.k = ns.a(this.k - 2, 0, this.l);
            }
         } else {
            if (!this.m() && this.o()) {
               this.j = this.i = b(this.h[1]);
               if (this.m()) {
                  var2 = true;
                  if (this.h[1] != null) {
                     --this.h[1].b;
                     if (this.h[1].b == 0) {
                        zw var3 = this.h[1].b().q();
                        this.h[1] = var3 != null ? new zx(var3) : null;
                     }
                  }
               }
            }

            if (this.m() && this.o()) {
               ++this.k;
               if (this.k == this.l) {
                  this.k = 0;
                  this.l = this.a(this.h[0]);
                  this.n();
                  var2 = true;
               }
            } else {
               this.k = 0;
            }
         }

         if (var1 != this.m()) {
            var2 = true;
            ahb.a(this.m(), this.b, this.c);
         }
      }

      if (var2) {
         this.p_();
      }

   }

   public static boolean c(zx var0) {
      return b(var0) > 0;
   }

   public int g() {
      return 4;
   }

   public static int b(zx var0) {
      if (var0 == null) {
         return 0;
      } else {
         zw var1 = var0.b();
         if (var1 instanceof yo && afh.a(var1) != afi.a) {
            afh var2 = afh.a(var1);
            if (var2 == afi.bM) {
               return 150;
            }

            if (var2.t() == arm.d) {
               return 300;
            }

            if (var2 == afi.cA) {
               return 16000;
            }
         }

         if (var1 instanceof za && ((za)var1).h().equals("WOOD")) {
            return 200;
         } else if (var1 instanceof aay && ((aay)var1).h().equals("WOOD")) {
            return 200;
         } else if (var1 instanceof zv && ((zv)var1).g().equals("WOOD")) {
            return 200;
         } else if (var1 == zy.y) {
            return 100;
         } else if (var1 == zy.h) {
            return 1600;
         } else if (var1 == zy.ay) {
            return 20000;
         } else if (var1 == zw.a(afi.g)) {
            return 100;
         } else {
            return var1 == zy.bv ? 2400 : 0;
         }
      }
   }

   public void a(dn var1) {
      super.a(var1);
      du var2 = var1.c("Items", 10);
      this.h = new zx[this.o_()];

      for(int var3 = 0; var3 < var2.c(); ++var3) {
         dn var4 = var2.b(var3);
         byte var5 = var4.d("Slot");
         if (var5 >= 0 && var5 < this.h.length) {
            this.h[var5] = zx.a(var4);
         }
      }

      this.i = var1.e("BurnTime");
      this.k = var1.e("CookTime");
      this.l = var1.e("CookTimeTotal");
      this.j = b(this.h[1]);
      if (var1.b("CustomName", 8)) {
         this.m = var1.j("CustomName");
      }

   }

   public int q_() {
      return 64;
   }

   public boolean b(int var1, zx var2) {
      if (var1 == 2) {
         return false;
      } else if (var1 != 1) {
         return true;
      } else {
         return c(var2) || xt.c_(var2);
      }
   }

   public boolean l_() {
      return this.m != null && this.m.length() > 0;
   }

   public void l() {
      for(int var1 = 0; var1 < this.h.length; ++var1) {
         this.h[var1] = null;
      }

   }

   public String e_() {
      return this.l_() ? this.m : "container.furnace";
   }

   public void a(int var1, zx var2) {
      boolean var3 = var2 != null && var2.a(this.h[var1]) && zx.a(var2, this.h[var1]);
      this.h[var1] = var2;
      if (var2 != null && var2.b > this.q_()) {
         var2.b = this.q_();
      }

      if (var1 == 0 && !var3) {
         this.l = this.a(var2);
         this.k = 0;
         this.p_();
      }

   }

   public zx a(int var1) {
      return this.h[var1];
   }

   public zx a(int var1, int var2) {
      if (this.h[var1] != null) {
         zx var3;
         if (this.h[var1].b <= var2) {
            var3 = this.h[var1];
            this.h[var1] = null;
            return var3;
         } else {
            var3 = this.h[var1].a(var2);
            if (this.h[var1].b == 0) {
               this.h[var1] = null;
            }

            return var3;
         }
      } else {
         return null;
      }
   }

   public boolean m() {
      return this.i > 0;
   }

   public void c(wn var1) {
   }

   public void b(dn var1) {
      super.b(var1);
      var1.a("BurnTime", (short)this.i);
      var1.a("CookTime", (short)this.k);
      var1.a("CookTimeTotal", (short)this.l);
      du var2 = new du();

      for(int var3 = 0; var3 < this.h.length; ++var3) {
         if (this.h[var3] != null) {
            dn var4 = new dn();
            var4.a("Slot", (byte)var3);
            this.h[var3].b(var4);
            var2.a((eb)var4);
         }
      }

      var1.a((String)"Items", (eb)var2);
      if (this.l_()) {
         var1.a("CustomName", this.m);
      }

   }

   public int a(zx var1) {
      return 200;
   }

   public void n() {
      if (this.o()) {
         zx var1 = abo.a().a(this.h[0]);
         if (this.h[2] == null) {
            this.h[2] = var1.k();
         } else if (this.h[2].b() == var1.b()) {
            ++this.h[2].b;
         }

         if (this.h[0].b() == zw.a(afi.v) && this.h[0].i() == 1 && this.h[1] != null && this.h[1].b() == zy.aw) {
            this.h[1] = new zx(zy.ax);
         }

         --this.h[0].b;
         if (this.h[0].b <= 0) {
            this.h[0] = null;
         }

      }
   }

   public int a_(int var1) {
      switch(var1) {
      case 0:
         return this.i;
      case 1:
         return this.j;
      case 2:
         return this.k;
      case 3:
         return this.l;
      default:
         return 0;
      }
   }

   public zx b(int var1) {
      if (this.h[var1] != null) {
         zx var2 = this.h[var1];
         this.h[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   private boolean o() {
      if (this.h[0] == null) {
         return false;
      } else {
         zx var1 = abo.a().a(this.h[0]);
         if (var1 == null) {
            return false;
         } else if (this.h[2] == null) {
            return true;
         } else if (!this.h[2].a(var1)) {
            return false;
         } else if (this.h[2].b < this.q_() && this.h[2].b < this.h[2].c()) {
            return true;
         } else {
            return this.h[2].b < var1.c();
         }
      }
   }

   public boolean a(wn var1) {
      if (this.b.s(this.c) != this) {
         return false;
      } else {
         return !(var1.e((double)this.c.n() + 0.5D, (double)this.c.o() + 0.5D, (double)this.c.p() + 0.5D) > 64.0D);
      }
   }

   public boolean a(int var1, zx var2, cq var3) {
      return this.b(var1, var2);
   }

   public void b(wn var1) {
   }

   public int o_() {
      return this.h.length;
   }

   public String k() {
      return "minecraft:furnace";
   }
}
