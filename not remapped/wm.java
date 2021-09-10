import java.util.concurrent.Callable;

public class wm implements og {
   public int c;
   public wn d;
   public zx[] a = new zx[36];
   public boolean e;
   public zx[] b = new zx[4];
   private zx f;

   public du a(du var1) {
      int var2;
      dn var3;
      for(var2 = 0; var2 < this.a.length; ++var2) {
         if (this.a[var2] != null) {
            var3 = new dn();
            var3.a("Slot", (byte)var2);
            this.a[var2].b(var3);
            var1.a((eb)var3);
         }
      }

      for(var2 = 0; var2 < this.b.length; ++var2) {
         if (this.b[var2] != null) {
            var3 = new dn();
            var3.a("Slot", (byte)(var2 + 100));
            this.b[var2].b(var3);
            var1.a((eb)var3);
         }
      }

      return var1;
   }

   public zx h() {
      return this.c < 9 && this.c >= 0 ? this.a[this.c] : null;
   }

   public void a(float var1) {
      var1 /= 4.0F;
      if (var1 < 1.0F) {
         var1 = 1.0F;
      }

      for(int var2 = 0; var2 < this.b.length; ++var2) {
         if (this.b[var2] != null && this.b[var2].b() instanceof yj) {
            this.b[var2].a((int)var1, (pr)this.d);
            if (this.b[var2].b == 0) {
               this.b[var2] = null;
            }
         }
      }

   }

   public String e_() {
      return "container.inventory";
   }

   public void p_() {
      this.e = true;
   }

   public boolean a(zx var1) {
      if (var1 != null && var1.b != 0 && var1.b() != null) {
         try {
            int var2;
            if (var1.g()) {
               var2 = this.j();
               if (var2 >= 0) {
                  this.a[var2] = zx.b(var1);
                  this.a[var2].c = 5;
                  var1.b = 0;
                  return true;
               } else if (this.d.bA.d) {
                  var1.b = 0;
                  return true;
               } else {
                  return false;
               }
            } else {
               do {
                  var2 = var1.b;
                  var1.b = this.e(var1);
               } while(var1.b > 0 && var1.b < var2);

               if (var1.b == var2 && this.d.bA.d) {
                  var1.b = 0;
                  return true;
               } else {
                  return var1.b < var2;
               }
            }
         } catch (Throwable var5) {
            b var3 = b.a(var5, "Adding item to inventory");
            c var4 = var3.a("Item being added");
            var4.a((String)"Item ID", (Object)zw.b(var1.b()));
            var4.a((String)"Item data", (Object)var1.i());
            var4.a("Item name", new Callable<String>(this, var1) {
               final zx a;
               final wm b;

               {
                  this.b = var1;
                  this.a = var2;
               }

               public Object call() throws Exception {
                  return this.a();
               }

               public String a() throws Exception {
                  return this.a.q();
               }
            });
            throw new e(var3);
         }
      } else {
         return false;
      }
   }

   public zx a(int var1, int var2) {
      zx[] var3 = this.a;
      if (var1 >= this.a.length) {
         var3 = this.b;
         var1 -= this.a.length;
      }

      if (var3[var1] != null) {
         zx var4;
         if (var3[var1].b <= var2) {
            var4 = var3[var1];
            var3[var1] = null;
            return var4;
         } else {
            var4 = var3[var1].a(var2);
            if (var3[var1].b == 0) {
               var3[var1] = null;
            }

            return var4;
         }
      } else {
         return null;
      }
   }

   public int j() {
      for(int var1 = 0; var1 < this.a.length; ++var1) {
         if (this.a[var1] == null) {
            return var1;
         }
      }

      return -1;
   }

   public void n() {
      int var1;
      for(var1 = 0; var1 < this.a.length; ++var1) {
         if (this.a[var1] != null) {
            this.d.a(this.a[var1], true, false);
            this.a[var1] = null;
         }
      }

      for(var1 = 0; var1 < this.b.length; ++var1) {
         if (this.b[var1] != null) {
            this.d.a(this.b[var1], true, false);
            this.b[var1] = null;
         }
      }

   }

   public zx p() {
      return this.f;
   }

   public boolean b(int var1, zx var2) {
      return true;
   }

   private int e(zx var1) {
      zw var2 = var1.b();
      int var3 = var1.b;
      int var4 = this.d(var1);
      if (var4 < 0) {
         var4 = this.j();
      }

      if (var4 < 0) {
         return var3;
      } else {
         if (this.a[var4] == null) {
            this.a[var4] = new zx(var2, 0, var1.i());
            if (var1.n()) {
               this.a[var4].d((dn)var1.o().b());
            }
         }

         int var5 = var3;
         if (var3 > this.a[var4].c() - this.a[var4].b) {
            var5 = this.a[var4].c() - this.a[var4].b;
         }

         if (var5 > this.q_() - this.a[var4].b) {
            var5 = this.q_() - this.a[var4].b;
         }

         if (var5 == 0) {
            return var3;
         } else {
            var3 -= var5;
            zx var10000 = this.a[var4];
            var10000.b += var5;
            this.a[var4].c = 5;
            return var3;
         }
      }
   }

   public boolean b(afh var1) {
      if (var1.t().l()) {
         return true;
      } else {
         zx var2 = this.a(this.c);
         return var2 != null ? var2.b(var1) : false;
      }
   }

   public zx b(int var1) {
      zx[] var2 = this.a;
      if (var1 >= this.a.length) {
         var2 = this.b;
         var1 -= this.a.length;
      }

      if (var2[var1] != null) {
         zx var3 = var2[var1];
         var2[var1] = null;
         return var3;
      } else {
         return null;
      }
   }

   public boolean b(zw var1) {
      int var2 = this.c(var1);
      return var2 >= 0;
   }

   public void a(int var1, zx var2) {
      zx[] var3 = this.a;
      if (var1 >= var3.length) {
         var1 -= var3.length;
         var3 = this.b;
      }

      var3[var1] = var2;
   }

   public void b(du var1) {
      this.a = new zx[36];
      this.b = new zx[4];

      for(int var2 = 0; var2 < var1.c(); ++var2) {
         dn var3 = var1.b(var2);
         int var4 = var3.d("Slot") & 255;
         zx var5 = zx.a(var3);
         if (var5 != null) {
            if (var4 >= 0 && var4 < this.a.length) {
               this.a[var4] = var5;
            }

            if (var4 >= 100 && var4 < this.b.length + 100) {
               this.b[var4 - 100] = var5;
            }
         }
      }

   }

   public int m() {
      int var1 = 0;

      for(int var2 = 0; var2 < this.b.length; ++var2) {
         if (this.b[var2] != null && this.b[var2].b() instanceof yj) {
            int var3 = ((yj)this.b[var2].b()).c;
            var1 += var3;
         }
      }

      return var1;
   }

   public int q_() {
      return 64;
   }

   public void c(wn var1) {
   }

   public void b(wn var1) {
   }

   public float a(afh var1) {
      float var2 = 1.0F;
      if (this.a[this.c] != null) {
         var2 *= this.a[this.c].a(var1);
      }

      return var2;
   }

   public zx e(int var1) {
      return this.b[var1];
   }

   public boolean l_() {
      return false;
   }

   public int g() {
      return 0;
   }

   public wm(wn var1) {
      this.d = var1;
   }

   public void k() {
      for(int var1 = 0; var1 < this.a.length; ++var1) {
         if (this.a[var1] != null) {
            this.a[var1].a(this.d.o, this.d, var1, this.c == var1);
         }
      }

   }

   public void b(zx var1) {
      this.f = var1;
   }

   public eu f_() {
      return (eu)(this.l_() ? new fa(this.e_()) : new fb(this.e_(), new Object[0]));
   }

   public boolean c(zx var1) {
      int var2;
      for(var2 = 0; var2 < this.b.length; ++var2) {
         if (this.b[var2] != null && this.b[var2].a(var1)) {
            return true;
         }
      }

      for(var2 = 0; var2 < this.a.length; ++var2) {
         if (this.a[var2] != null && this.a[var2].a(var1)) {
            return true;
         }
      }

      return false;
   }

   public int o_() {
      return this.a.length + 4;
   }

   public void a(zw var1, int var2, boolean var3, boolean var4) {
      zx var5 = this.h();
      int var6 = var3 ? this.a(var1, var2) : this.c(var1);
      if (var6 >= 0 && var6 < 9) {
         this.c = var6;
      } else if (var4 && var1 != null) {
         int var7 = this.j();
         if (var7 >= 0 && var7 < 9) {
            this.c = var7;
         }

         if (var5 == null || !var5.v() || this.a(var5.b(), var5.h()) != this.c) {
            int var8 = this.a(var1, var2);
            int var9;
            if (var8 >= 0) {
               var9 = this.a[var8].b;
               this.a[var8] = this.a[this.c];
            } else {
               var9 = 1;
            }

            this.a[this.c] = new zx(var1, var9, var2);
         }

      }
   }

   public void d(int var1) {
      if (var1 > 0) {
         var1 = 1;
      }

      if (var1 < 0) {
         var1 = -1;
      }

      for(this.c -= var1; this.c < 0; this.c += 9) {
      }

      while(this.c >= 9) {
         this.c -= 9;
      }

   }

   public static int i() {
      return 9;
   }

   public boolean a(wn var1) {
      if (this.d.I) {
         return false;
      } else {
         return !(var1.h(this.d) > 64.0D);
      }
   }

   private int a(zw var1, int var2) {
      for(int var3 = 0; var3 < this.a.length; ++var3) {
         if (this.a[var3] != null && this.a[var3].b() == var1 && this.a[var3].i() == var2) {
            return var3;
         }
      }

      return -1;
   }

   private int d(zx var1) {
      for(int var2 = 0; var2 < this.a.length; ++var2) {
         if (this.a[var2] != null && this.a[var2].b() == var1.b() && this.a[var2].d() && this.a[var2].b < this.a[var2].c() && this.a[var2].b < this.q_() && (!this.a[var2].f() || this.a[var2].i() == var1.i()) && zx.a(this.a[var2], var1)) {
            return var2;
         }
      }

      return -1;
   }

   public zx a(int var1) {
      zx[] var2 = this.a;
      if (var1 >= var2.length) {
         var1 -= var2.length;
         var2 = this.b;
      }

      return var2[var1];
   }

   public void b(int var1, int var2) {
   }

   public void l() {
      int var1;
      for(var1 = 0; var1 < this.a.length; ++var1) {
         this.a[var1] = null;
      }

      for(var1 = 0; var1 < this.b.length; ++var1) {
         this.b[var1] = null;
      }

   }

   private int c(zw var1) {
      for(int var2 = 0; var2 < this.a.length; ++var2) {
         if (this.a[var2] != null && this.a[var2].b() == var1) {
            return var2;
         }
      }

      return -1;
   }

   public int a_(int var1) {
      return 0;
   }

   public void b(wm var1) {
      int var2;
      for(var2 = 0; var2 < this.a.length; ++var2) {
         this.a[var2] = zx.b(var1.a[var2]);
      }

      for(var2 = 0; var2 < this.b.length; ++var2) {
         this.b[var2] = zx.b(var1.b[var2]);
      }

      this.c = var1.c;
   }

   public boolean a(zw var1) {
      int var2 = this.c(var1);
      if (var2 < 0) {
         return false;
      } else {
         if (--this.a[var2].b <= 0) {
            this.a[var2] = null;
         }

         return true;
      }
   }

   public int a(zw var1, int var2, int var3, dn var4) {
      int var5 = 0;

      zx var10000;
      int var6;
      zx var7;
      int var8;
      for(var6 = 0; var6 < this.a.length; ++var6) {
         var7 = this.a[var6];
         if (var7 != null && (var1 == null || var7.b() == var1) && (var2 <= -1 || var7.i() == var2) && (var4 == null || dy.a(var4, var7.o(), true))) {
            var8 = var3 <= 0 ? var7.b : Math.min(var3 - var5, var7.b);
            var5 += var8;
            if (var3 != 0) {
               var10000 = this.a[var6];
               var10000.b -= var8;
               if (this.a[var6].b == 0) {
                  this.a[var6] = null;
               }

               if (var3 > 0 && var5 >= var3) {
                  return var5;
               }
            }
         }
      }

      for(var6 = 0; var6 < this.b.length; ++var6) {
         var7 = this.b[var6];
         if (var7 != null && (var1 == null || var7.b() == var1) && (var2 <= -1 || var7.i() == var2) && (var4 == null || dy.a(var4, var7.o(), false))) {
            var8 = var3 <= 0 ? var7.b : Math.min(var3 - var5, var7.b);
            var5 += var8;
            if (var3 != 0) {
               var10000 = this.b[var6];
               var10000.b -= var8;
               if (this.b[var6].b == 0) {
                  this.b[var6] = null;
               }

               if (var3 > 0 && var5 >= var3) {
                  return var5;
               }
            }
         }
      }

      if (this.f != null) {
         if (var1 != null && this.f.b() != var1) {
            return var5;
         }

         if (var2 > -1 && this.f.i() != var2) {
            return var5;
         }

         if (var4 != null && !dy.a(var4, this.f.o(), false)) {
            return var5;
         }

         var6 = var3 <= 0 ? this.f.b : Math.min(var3 - var5, this.f.b);
         var5 += var6;
         if (var3 != 0) {
            var10000 = this.f;
            var10000.b -= var6;
            if (this.f.b == 0) {
               this.f = null;
            }

            if (var3 > 0 && var5 >= var3) {
               return var5;
            }
         }
      }

      return var5;
   }
}
