import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class akv extends alk implements km, og {
   private final List<akv.a> f = Lists.newArrayList();
   private boolean i;
   private int j = -1;
   private int l;
   private float h;
   private zx m;
   private int k;
   private String n;
   public static final pe[][] a;
   private long g;

   public ff y_() {
      dn var1 = new dn();
      this.b(var1);
      return new ft(this.c, 3, var1);
   }

   public boolean a(wn var1) {
      if (this.b.s(this.c) != this) {
         return false;
      } else {
         return !(var1.e((double)this.c.n() + 0.5D, (double)this.c.o() + 0.5D, (double)this.c.p() + 0.5D) > 64.0D);
      }
   }

   public double s() {
      return 65536.0D;
   }

   public boolean b(int var1, zx var2) {
      return var2.b() == zy.bO || var2.b() == zy.i || var2.b() == zy.k || var2.b() == zy.j;
   }

   public zx a(int var1) {
      return var1 == 0 ? this.m : null;
   }

   public void c(wn var1) {
   }

   public void l() {
      this.m = null;
   }

   public void a(String var1) {
      this.n = var1;
   }

   public void m() {
      this.B();
      this.A();
   }

   public zx b(int var1) {
      if (var1 == 0 && this.m != null) {
         zx var2 = this.m;
         this.m = null;
         return var2;
      } else {
         return null;
      }
   }

   public xi a(wm var1, wn var2) {
      return new xl(var1, this);
   }

   public int q_() {
      return 1;
   }

   public int a_(int var1) {
      switch(var1) {
      case 0:
         return this.j;
      case 1:
         return this.k;
      case 2:
         return this.l;
      default:
         return 0;
      }
   }

   public void a(dn var1) {
      super.a(var1);
      this.k = this.h(var1.f("Primary"));
      this.l = this.h(var1.f("Secondary"));
      this.j = var1.f("Levels");
   }

   public boolean l_() {
      return this.n != null && this.n.length() > 0;
   }

   private void A() {
      if (this.i && this.j > 0 && !this.b.D && this.k > 0) {
         double var1 = (double)(this.j * 10 + 10);
         byte var3 = 0;
         if (this.j >= 4 && this.k == this.l) {
            var3 = 1;
         }

         int var4 = this.c.n();
         int var5 = this.c.o();
         int var6 = this.c.p();
         aug var7 = (new aug((double)var4, (double)var5, (double)var6, (double)(var4 + 1), (double)(var5 + 1), (double)(var6 + 1))).b(var1, var1, var1).a(0.0D, (double)this.b.U(), 0.0D);
         List var8 = this.b.a(wn.class, var7);
         Iterator var9 = var8.iterator();

         wn var10;
         while(var9.hasNext()) {
            var10 = (wn)var9.next();
            var10.c(new pf(this.k, 180, var3, true, true));
         }

         if (this.j >= 4 && this.k != this.l && this.l > 0) {
            var9 = var8.iterator();

            while(var9.hasNext()) {
               var10 = (wn)var9.next();
               var10.c(new pf(this.l, 180, 0, true, true));
            }
         }
      }

   }

   public List<akv.a> n() {
      return this.f;
   }

   private int h(int var1) {
      if (var1 >= 0 && var1 < pe.a.length && pe.a[var1] != null) {
         pe var2 = pe.a[var1];
         return var2 != pe.c && var2 != pe.e && var2 != pe.m && var2 != pe.j && var2 != pe.g && var2 != pe.l ? 0 : var1;
      } else {
         return 0;
      }
   }

   public int o_() {
      return 1;
   }

   public zx a(int var1, int var2) {
      if (var1 == 0 && this.m != null) {
         if (var2 >= this.m.b) {
            zx var3 = this.m;
            this.m = null;
            return var3;
         } else {
            zx var10000 = this.m;
            var10000.b -= var2;
            return new zx(this.m.b(), var2, this.m.i());
         }
      } else {
         return null;
      }
   }

   static {
      a = new pe[][]{{pe.c, pe.e}, {pe.m, pe.j}, {pe.g}, {pe.l}};
   }

   public void c() {
      if (this.b.K() % 80L == 0L) {
         this.m();
      }

   }

   public String e_() {
      return this.l_() ? this.n : "container.beacon";
   }

   public String k() {
      return "minecraft:beacon";
   }

   public void b(wn var1) {
   }

   public boolean c(int var1, int var2) {
      if (var1 == 1) {
         this.m();
         return true;
      } else {
         return super.c(var1, var2);
      }
   }

   private void B() {
      int var1 = this.j;
      int var2 = this.c.n();
      int var3 = this.c.o();
      int var4 = this.c.p();
      this.j = 0;
      this.f.clear();
      this.i = true;
      akv.a var5 = new akv.a(tv.a(zd.a));
      this.f.add(var5);
      boolean var6 = true;
      cj.a var7 = new cj.a();

      int var8;
      for(var8 = var3 + 1; var8 < 256; ++var8) {
         alz var9 = this.b.p(var7.c(var2, var8, var4));
         float[] var10;
         if (var9.c() == afi.cG) {
            var10 = tv.a((zd)var9.b(ajs.a));
         } else {
            if (var9.c() != afi.cH) {
               if (var9.c().p() >= 15 && var9.c() != afi.h) {
                  this.i = false;
                  this.f.clear();
                  break;
               }

               var5.a();
               continue;
            }

            var10 = tv.a((zd)var9.b(ajt.a));
         }

         if (!var6) {
            var10 = new float[]{(var5.b()[0] + var10[0]) / 2.0F, (var5.b()[1] + var10[1]) / 2.0F, (var5.b()[2] + var10[2]) / 2.0F};
         }

         if (Arrays.equals(var10, var5.b())) {
            var5.a();
         } else {
            var5 = new akv.a(var10);
            this.f.add(var5);
         }

         var6 = false;
      }

      if (this.i) {
         for(var8 = 1; var8 <= 4; this.j = var8++) {
            int var15 = var3 - var8;
            if (var15 < 0) {
               break;
            }

            boolean var17 = true;

            for(int var11 = var2 - var8; var11 <= var2 + var8 && var17; ++var11) {
               for(int var12 = var4 - var8; var12 <= var4 + var8; ++var12) {
                  afh var13 = this.b.p(new cj(var11, var15, var12)).c();
                  if (var13 != afi.bT && var13 != afi.R && var13 != afi.ah && var13 != afi.S) {
                     var17 = false;
                     break;
                  }
               }
            }

            if (!var17) {
               break;
            }
         }

         if (this.j == 0) {
            this.i = false;
         }
      }

      if (!this.b.D && this.j == 4 && var1 < this.j) {
         Iterator var14 = this.b.a(wn.class, (new aug((double)var2, (double)var3, (double)var4, (double)var2, (double)(var3 - 4), (double)var4)).b(10.0D, 5.0D, 10.0D)).iterator();

         while(var14.hasNext()) {
            wn var16 = (wn)var14.next();
            var16.b((mw)mr.K);
         }
      }

   }

   public int g() {
      return 3;
   }

   public void a(int var1, zx var2) {
      if (var1 == 0) {
         this.m = var2;
      }

   }

   public void b(int var1, int var2) {
      switch(var1) {
      case 0:
         this.j = var2;
         break;
      case 1:
         this.k = this.h(var2);
         break;
      case 2:
         this.l = this.h(var2);
      }

   }

   public float o() {
      if (!this.i) {
         return 0.0F;
      } else {
         int var1 = (int)(this.b.K() - this.g);
         this.g = this.b.K();
         if (var1 > 1) {
            this.h -= (float)var1 / 40.0F;
            if (this.h < 0.0F) {
               this.h = 0.0F;
            }
         }

         this.h += 0.025F;
         if (this.h > 1.0F) {
            this.h = 1.0F;
         }

         return this.h;
      }
   }

   public void b(dn var1) {
      super.b(var1);
      var1.a("Primary", this.k);
      var1.a("Secondary", this.l);
      var1.a("Levels", this.j);
   }

   public static class a {
      private int b;
      private final float[] a;

      protected void a() {
         ++this.b;
      }

      public int c() {
         return this.b;
      }

      public float[] b() {
         return this.a;
      }

      public a(float[] var1) {
         this.a = var1;
         this.b = 1;
      }
   }
}
