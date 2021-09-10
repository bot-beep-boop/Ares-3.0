import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.List;

public class alj extends alk implements km, ali {
   private int g = -1;
   private zx[] a = new zx[5];
   private String f;

   public static og b(adm var0, double var1, double var3, double var5) {
      Object var7 = null;
      int var8 = ns.c(var1);
      int var9 = ns.c(var3);
      int var10 = ns.c(var5);
      cj var11 = new cj(var8, var9, var10);
      afh var12 = var0.p(var11).c();
      if (var12.z()) {
         akw var13 = var0.s(var11);
         if (var13 instanceof og) {
            var7 = (og)var13;
            if (var7 instanceof aky && var12 instanceof afs) {
               var7 = ((afs)var12).f(var0, var11);
            }
         }
      }

      if (var7 == null) {
         List var14 = var0.a((pk)null, (aug)(new aug(var1 - 0.5D, var3 - 0.5D, var5 - 0.5D, var1 + 0.5D, var3 + 0.5D, var5 + 0.5D)), (Predicate)po.c);
         if (var14.size() > 0) {
            var7 = (og)var14.get(var0.s.nextInt(var14.size()));
         }
      }

      return (og)var7;
   }

   public int q_() {
      return 64;
   }

   public static boolean a(ali var0) {
      og var1 = b(var0);
      if (var1 != null) {
         cq var2 = cq.a;
         if (b(var1, var2)) {
            return false;
         }

         if (var1 instanceof ot) {
            ot var3 = (ot)var1;
            int[] var4 = var3.a(var2);

            for(int var5 = 0; var5 < var4.length; ++var5) {
               if (a(var0, var1, var4[var5], var2)) {
                  return true;
               }
            }
         } else {
            int var7 = var1.o_();

            for(int var9 = 0; var9 < var7; ++var9) {
               if (a(var0, var1, var9, var2)) {
                  return true;
               }
            }
         }
      } else {
         Iterator var6 = a(var0.z(), var0.A(), var0.B() + 1.0D, var0.C()).iterator();

         while(var6.hasNext()) {
            uz var8 = (uz)var6.next();
            if (a((og)var0, (uz)var8)) {
               return true;
            }
         }
      }

      return false;
   }

   public static og b(ali var0) {
      return b(var0.z(), var0.A(), var0.B() + 1.0D, var0.C());
   }

   private static boolean b(og var0, zx var1, int var2, cq var3) {
      return !(var0 instanceof ot) || ((ot)var0).b(var2, var1, var3);
   }

   public static boolean a(og var0, uz var1) {
      boolean var2 = false;
      if (var1 == null) {
         return false;
      } else {
         zx var3 = var1.l().k();
         zx var4 = a(var0, var3, (cq)null);
         if (var4 != null && var4.b != 0) {
            var1.a(var4);
         } else {
            var2 = true;
            var1.J();
         }

         return var2;
      }
   }

   public void p_() {
      super.p_();
   }

   private boolean a(og var1, cq var2) {
      if (!(var1 instanceof ot)) {
         int var7 = var1.o_();

         for(int var8 = 0; var8 < var7; ++var8) {
            zx var9 = var1.a(var8);
            if (var9 == null || var9.b != var9.c()) {
               return false;
            }
         }
      } else {
         ot var3 = (ot)var1;
         int[] var4 = var3.a(var2);

         for(int var5 = 0; var5 < var4.length; ++var5) {
            zx var6 = var3.a(var4[var5]);
            if (var6 == null || var6.b != var6.c()) {
               return false;
            }
         }
      }

      return true;
   }

   private boolean q() {
      zx[] var1 = this.a;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         zx var4 = var1[var3];
         if (var4 == null || var4.b != var4.c()) {
            return false;
         }
      }

      return true;
   }

   public boolean a(wn var1) {
      if (this.b.s(this.c) != this) {
         return false;
      } else {
         return !(var1.e((double)this.c.n() + 0.5D, (double)this.c.o() + 0.5D, (double)this.c.p() + 0.5D) > 64.0D);
      }
   }

   public boolean o() {
      return this.g <= 1;
   }

   public static zx a(og var0, zx var1, cq var2) {
      if (var0 instanceof ot && var2 != null) {
         ot var6 = (ot)var0;
         int[] var7 = var6.a(var2);

         for(int var5 = 0; var5 < var7.length && var1 != null && var1.b > 0; ++var5) {
            var1 = c(var0, var1, var7[var5], var2);
         }
      } else {
         int var3 = var0.o_();

         for(int var4 = 0; var4 < var3 && var1 != null && var1.b > 0; ++var4) {
            var1 = c(var0, var1, var4, var2);
         }
      }

      if (var1 != null && var1.b == 0) {
         var1 = null;
      }

      return var1;
   }

   public boolean l_() {
      return this.f != null && this.f.length() > 0;
   }

   public void d(int var1) {
      this.g = var1;
   }

   private boolean r() {
      og var1 = this.H();
      if (var1 == null) {
         return false;
      } else {
         cq var2 = ahn.b(this.u()).d();
         if (this.a(var1, var2)) {
            return false;
         } else {
            for(int var3 = 0; var3 < this.o_(); ++var3) {
               if (this.a(var3) != null) {
                  zx var4 = this.a(var3).k();
                  zx var5 = a(var1, this.a(var3, 1), var2);
                  if (var5 == null || var5.b == 0) {
                     var1.p_();
                     return true;
                  }

                  this.a(var3, var4);
               }
            }

            return false;
         }
      }
   }

   private static boolean a(og var0, zx var1, int var2, cq var3) {
      if (!var0.b(var2, var1)) {
         return false;
      } else {
         return !(var0 instanceof ot) || ((ot)var0).a(var2, var1, var3);
      }
   }

   public String k() {
      return "minecraft:hopper";
   }

   private static boolean a(ali var0, og var1, int var2, cq var3) {
      zx var4 = var1.a(var2);
      if (var4 != null && b(var1, var4, var2, var3)) {
         zx var5 = var4.k();
         zx var6 = a(var0, var1.a(var2, 1), (cq)null);
         if (var6 == null || var6.b == 0) {
            var1.p_();
            return true;
         }

         var1.a(var2, var5);
      }

      return false;
   }

   private static boolean a(zx var0, zx var1) {
      if (var0.b() != var1.b()) {
         return false;
      } else if (var0.i() != var1.i()) {
         return false;
      } else if (var0.b > var0.c()) {
         return false;
      } else {
         return zx.a(var0, var1);
      }
   }

   public double C() {
      return (double)this.c.p() + 0.5D;
   }

   public static List<uz> a(adm var0, double var1, double var3, double var5) {
      return var0.a(uz.class, new aug(var1 - 0.5D, var3 - 0.5D, var5 - 0.5D, var1 + 0.5D, var3 + 0.5D, var5 + 0.5D), po.a);
   }

   public zx a(int var1) {
      return this.a[var1];
   }

   public void c(wn var1) {
   }

   public void a(int var1, zx var2) {
      this.a[var1] = var2;
      if (var2 != null && var2.b > this.q_()) {
         var2.b = this.q_();
      }

   }

   public int g() {
      return 0;
   }

   public zx a(int var1, int var2) {
      if (this.a[var1] != null) {
         zx var3;
         if (this.a[var1].b <= var2) {
            var3 = this.a[var1];
            this.a[var1] = null;
            return var3;
         } else {
            var3 = this.a[var1].a(var2);
            if (this.a[var1].b == 0) {
               this.a[var1] = null;
            }

            return var3;
         }
      } else {
         return null;
      }
   }

   public void b(int var1, int var2) {
   }

   public void b(dn var1) {
      super.b(var1);
      du var2 = new du();

      for(int var3 = 0; var3 < this.a.length; ++var3) {
         if (this.a[var3] != null) {
            dn var4 = new dn();
            var4.a("Slot", (byte)var3);
            this.a[var3].b(var4);
            var2.a((eb)var4);
         }
      }

      var1.a((String)"Items", (eb)var2);
      var1.a("TransferCooldown", this.g);
      if (this.l_()) {
         var1.a("CustomName", this.f);
      }

   }

   public double A() {
      return (double)this.c.n() + 0.5D;
   }

   public zx b(int var1) {
      if (this.a[var1] != null) {
         zx var2 = this.a[var1];
         this.a[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public int a_(int var1) {
      return 0;
   }

   public boolean b(int var1, zx var2) {
      return true;
   }

   public xi a(wm var1, wn var2) {
      return new xw(var1, this, var2);
   }

   public void a(String var1) {
      this.f = var1;
   }

   public boolean m() {
      if (this.b != null && !this.b.D) {
         if (!this.n() && ahn.f(this.u())) {
            boolean var1 = false;
            if (!this.p()) {
               var1 = this.r();
            }

            if (!this.q()) {
               var1 = a((ali)this) || var1;
            }

            if (var1) {
               this.d(8);
               this.p_();
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   private static zx c(og var0, zx var1, int var2, cq var3) {
      zx var4 = var0.a(var2);
      if (a(var0, var1, var2, var3)) {
         boolean var5 = false;
         if (var4 == null) {
            var0.a(var2, var1);
            var1 = null;
            var5 = true;
         } else if (a(var4, var1)) {
            int var6 = var1.c() - var4.b;
            int var7 = Math.min(var1.b, var6);
            var1.b -= var7;
            var4.b += var7;
            var5 = var7 > 0;
         }

         if (var5) {
            if (var0 instanceof alj) {
               alj var8 = (alj)var0;
               if (var8.o()) {
                  var8.d(8);
               }

               var0.p_();
            }

            var0.p_();
         }
      }

      return var1;
   }

   public void a(dn var1) {
      super.a(var1);
      du var2 = var1.c("Items", 10);
      this.a = new zx[this.o_()];
      if (var1.b("CustomName", 8)) {
         this.f = var1.j("CustomName");
      }

      this.g = var1.f("TransferCooldown");

      for(int var3 = 0; var3 < var2.c(); ++var3) {
         dn var4 = var2.b(var3);
         byte var5 = var4.d("Slot");
         if (var5 >= 0 && var5 < this.a.length) {
            this.a[var5] = zx.a(var4);
         }
      }

   }

   private static boolean b(og var0, cq var1) {
      if (var0 instanceof ot) {
         ot var2 = (ot)var0;
         int[] var3 = var2.a(var1);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var2.a(var3[var4]) != null) {
               return false;
            }
         }
      } else {
         int var5 = var0.o_();

         for(int var6 = 0; var6 < var5; ++var6) {
            if (var0.a(var6) != null) {
               return false;
            }
         }
      }

      return true;
   }

   private boolean p() {
      zx[] var1 = this.a;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         zx var4 = var1[var3];
         if (var4 != null) {
            return false;
         }
      }

      return true;
   }

   public void c() {
      if (this.b != null && !this.b.D) {
         --this.g;
         if (!this.n()) {
            this.d(0);
            this.m();
         }

      }
   }

   public boolean n() {
      return this.g > 0;
   }

   private og H() {
      cq var1 = ahn.b(this.u());
      return b(this.z(), (double)(this.c.n() + var1.g()), (double)(this.c.o() + var1.h()), (double)(this.c.p() + var1.i()));
   }

   public double B() {
      return (double)this.c.o() + 0.5D;
   }

   public void l() {
      for(int var1 = 0; var1 < this.a.length; ++var1) {
         this.a[var1] = null;
      }

   }

   public String e_() {
      return this.l_() ? this.f : "container.hopper";
   }

   public void b(wn var1) {
   }

   public int o_() {
      return this.a.length;
   }
}
