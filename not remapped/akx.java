import java.util.Arrays;
import java.util.List;

public class akx extends alk implements ot, km {
   private static final int[] f = new int[]{0, 1, 2};
   private String k;
   private int h;
   private zw j;
   private zx[] g = new zx[4];
   private static final int[] a = new int[]{3};
   private boolean[] i;

   public xi a(wm var1, wn var2) {
      return new xm(var1, this);
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

   public int[] a(cq var1) {
      return var1 == cq.b ? a : f;
   }

   public zx b(int var1) {
      if (var1 >= 0 && var1 < this.g.length) {
         zx var2 = this.g[var1];
         this.g[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public int o_() {
      return this.g.length;
   }

   public void l() {
      for(int var1 = 0; var1 < this.g.length; ++var1) {
         this.g[var1] = null;
      }

   }

   public boolean l_() {
      return this.k != null && this.k.length() > 0;
   }

   public zx a(int var1, int var2) {
      if (var1 >= 0 && var1 < this.g.length) {
         zx var3 = this.g[var1];
         this.g[var1] = null;
         return var3;
      } else {
         return null;
      }
   }

   public int g() {
      return 1;
   }

   private void o() {
      if (this.n()) {
         zx var1 = this.g[3];

         for(int var2 = 0; var2 < 3; ++var2) {
            if (this.g[var2] != null && this.g[var2].b() == zy.bz) {
               int var3 = this.g[var2].i();
               int var4 = this.c(var3, var1);
               List var5 = zy.bz.e(var3);
               List var6 = zy.bz.e(var4);
               if ((var3 <= 0 || var5 != var6) && (var5 == null || !var5.equals(var6) && var6 != null)) {
                  if (var3 != var4) {
                     this.g[var2].b(var4);
                  }
               } else if (!aai.f(var3) && aai.f(var4)) {
                  this.g[var2].b(var4);
               }
            }
         }

         if (var1.b().r()) {
            this.g[3] = new zx(var1.b().q());
         } else {
            --this.g[3].b;
            if (this.g[3].b <= 0) {
               this.g[3] = null;
            }
         }

      }
   }

   public String k() {
      return "minecraft:brewing_stand";
   }

   public void c() {
      if (this.h > 0) {
         --this.h;
         if (this.h == 0) {
            this.o();
            this.p_();
         } else if (!this.n()) {
            this.h = 0;
            this.p_();
         } else if (this.j != this.g[3].b()) {
            this.h = 0;
            this.p_();
         }
      } else if (this.n()) {
         this.h = 400;
         this.j = this.g[3].b();
      }

      if (!this.b.D) {
         boolean[] var1 = this.m();
         if (!Arrays.equals(var1, this.i)) {
            this.i = var1;
            alz var2 = this.b.p(this.v());
            if (!(var2.c() instanceof afl)) {
               return;
            }

            for(int var3 = 0; var3 < afl.a.length; ++var3) {
               var2 = var2.a(afl.a[var3], var1[var3]);
            }

            this.b.a((cj)this.c, (alz)var2, 2);
         }
      }

   }

   public zx a(int var1) {
      return var1 >= 0 && var1 < this.g.length ? this.g[var1] : null;
   }

   public int a_(int var1) {
      switch(var1) {
      case 0:
         return this.h;
      default:
         return 0;
      }
   }

   public boolean b(int var1, zx var2) {
      if (var1 == 3) {
         return var2.b().l(var2);
      } else {
         return var2.b() == zy.bz || var2.b() == zy.bA;
      }
   }

   public void c(wn var1) {
   }

   private int c(int var1, zx var2) {
      if (var2 == null) {
         return var1;
      } else {
         return var2.b().l(var2) ? abe.a(var1, var2.b().j(var2)) : var1;
      }
   }

   public void b(int var1, int var2) {
      switch(var1) {
      case 0:
         this.h = var2;
      default:
      }
   }

   public void b(dn var1) {
      super.b(var1);
      var1.a("BrewTime", (short)this.h);
      du var2 = new du();

      for(int var3 = 0; var3 < this.g.length; ++var3) {
         if (this.g[var3] != null) {
            dn var4 = new dn();
            var4.a("Slot", (byte)var3);
            this.g[var3].b(var4);
            var2.a((eb)var4);
         }
      }

      var1.a((String)"Items", (eb)var2);
      if (this.l_()) {
         var1.a("CustomName", this.k);
      }

   }

   public void a(dn var1) {
      super.a(var1);
      du var2 = var1.c("Items", 10);
      this.g = new zx[this.o_()];

      for(int var3 = 0; var3 < var2.c(); ++var3) {
         dn var4 = var2.b(var3);
         byte var5 = var4.d("Slot");
         if (var5 >= 0 && var5 < this.g.length) {
            this.g[var5] = zx.a(var4);
         }
      }

      this.h = var1.e("BrewTime");
      if (var1.b("CustomName", 8)) {
         this.k = var1.j("CustomName");
      }

   }

   public void b(wn var1) {
   }

   public int q_() {
      return 64;
   }

   public boolean b(int var1, zx var2, cq var3) {
      return true;
   }

   private boolean n() {
      if (this.g[3] != null && this.g[3].b > 0) {
         zx var1 = this.g[3];
         if (!var1.b().l(var1)) {
            return false;
         } else {
            boolean var2 = false;

            for(int var3 = 0; var3 < 3; ++var3) {
               if (this.g[var3] != null && this.g[var3].b() == zy.bz) {
                  int var4 = this.g[var3].i();
                  int var5 = this.c(var4, var1);
                  if (!aai.f(var4) && aai.f(var5)) {
                     var2 = true;
                     break;
                  }

                  List var6 = zy.bz.e(var4);
                  List var7 = zy.bz.e(var5);
                  if ((var4 <= 0 || var6 != var7) && (var6 == null || !var6.equals(var7) && var7 != null) && var4 != var5) {
                     var2 = true;
                     break;
                  }
               }
            }

            return var2;
         }
      } else {
         return false;
      }
   }

   public boolean[] m() {
      boolean[] var1 = new boolean[3];

      for(int var2 = 0; var2 < 3; ++var2) {
         if (this.g[var2] != null) {
            var1[var2] = true;
         }
      }

      return var1;
   }

   public void a(int var1, zx var2) {
      if (var1 >= 0 && var1 < this.g.length) {
         this.g[var1] = var2;
      }

   }

   public String e_() {
      return this.l_() ? this.k : "container.brewing";
   }

   public void a(String var1) {
      this.k = var1;
   }
}
