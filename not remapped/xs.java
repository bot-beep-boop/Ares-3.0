import java.util.List;
import java.util.Random;

public class xs extends xi {
   private Random k;
   public og a;
   public int f;
   public int[] h;
   private cj j;
   private adm i;
   public int[] g;

   public void b(int var1, int var2) {
      if (var1 >= 0 && var1 <= 2) {
         this.g[var1] = var2;
      } else if (var1 == 3) {
         this.f = var2;
      } else if (var1 >= 4 && var1 <= 6) {
         this.h[var1 - 4] = var2;
      } else {
         super.b(var1, var2);
      }

   }

   public xs(wm var1, adm var2) {
      this(var1, var2, cj.a);
   }

   public void b() {
      super.b();

      for(int var1 = 0; var1 < this.e.size(); ++var1) {
         xn var2 = (xn)this.e.get(var1);
         var2.a(this, 0, this.g[0]);
         var2.a(this, 1, this.g[1]);
         var2.a(this, 2, this.g[2]);
         var2.a(this, 3, this.f & -16);
         var2.a(this, 4, this.h[0]);
         var2.a(this, 5, this.h[1]);
         var2.a(this, 6, this.h[2]);
      }

   }

   public zx b(wn var1, int var2) {
      zx var3 = null;
      yg var4 = (yg)this.c.get(var2);
      if (var4 != null && var4.e()) {
         zx var5 = var4.d();
         var3 = var5.k();
         if (var2 == 0) {
            if (!this.a(var5, 2, 38, true)) {
               return null;
            }
         } else if (var2 == 1) {
            if (!this.a(var5, 2, 38, true)) {
               return null;
            }
         } else if (var5.b() == zy.aW && zd.a(var5.i()) == zd.l) {
            if (!this.a(var5, 1, 2, true)) {
               return null;
            }
         } else {
            if (((yg)this.c.get(0)).e() || !((yg)this.c.get(0)).a(var5)) {
               return null;
            }

            if (var5.n() && var5.b == 1) {
               ((yg)this.c.get(0)).d(var5.k());
               var5.b = 0;
            } else if (var5.b >= 1) {
               ((yg)this.c.get(0)).d(new zx(var5.b(), 1, var5.i()));
               --var5.b;
            }
         }

         if (var5.b == 0) {
            var4.d((zx)null);
         } else {
            var4.f();
         }

         if (var5.b == var3.b) {
            return null;
         }

         var4.a(var1, var5);
      }

      return var3;
   }

   public void a(xn var1) {
      super.a(var1);
      var1.a(this, 0, this.g[0]);
      var1.a(this, 1, this.g[1]);
      var1.a(this, 2, this.g[2]);
      var1.a(this, 3, this.f & -16);
      var1.a(this, 4, this.h[0]);
      var1.a(this, 5, this.h[1]);
      var1.a(this, 6, this.h[2]);
   }

   public void b(wn var1) {
      super.b(var1);
      if (!this.i.D) {
         for(int var2 = 0; var2 < this.a.o_(); ++var2) {
            zx var3 = this.a.b(var2);
            if (var3 != null) {
               var1.a(var3, false);
            }
         }

      }
   }

   public boolean a(wn var1, int var2) {
      zx var3 = this.a.a(0);
      zx var4 = this.a.a(1);
      int var5 = var2 + 1;
      if ((var4 == null || var4.b < var5) && !var1.bA.d) {
         return false;
      } else if (this.g[var2] > 0 && var3 != null && (var1.bB >= var5 && var1.bB >= this.g[var2] || var1.bA.d)) {
         if (!this.i.D) {
            List var6 = this.a(var3, var2, this.g[var2]);
            boolean var7 = var3.b() == zy.aL;
            if (var6 != null) {
               var1.b(var5);
               if (var7) {
                  var3.a((zw)zy.cd);
               }

               for(int var8 = 0; var8 < var6.size(); ++var8) {
                  acl var9 = (acl)var6.get(var8);
                  if (var7) {
                     zy.cd.a(var3, var9);
                  } else {
                     var3.a(var9.b, var9.c);
                  }
               }

               if (!var1.bA.d) {
                  var4.b -= var5;
                  if (var4.b <= 0) {
                     this.a.a(1, (zx)null);
                  }
               }

               var1.b(na.W);
               this.a.p_();
               this.f = var1.cj();
               this.a(this.a);
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean a(wn var1) {
      if (this.i.p(this.j).c() != afi.bC) {
         return false;
      } else {
         return !(var1.e((double)this.j.n() + 0.5D, (double)this.j.o() + 0.5D, (double)this.j.p() + 0.5D) > 64.0D);
      }
   }

   private List<acl> a(zx var1, int var2, int var3) {
      this.k.setSeed((long)(this.f + var2));
      List var4 = ack.b(this.k, var1, var3);
      if (var1.b() == zy.aL && var4 != null && var4.size() > 1) {
         var4.remove(this.k.nextInt(var4.size()));
      }

      return var4;
   }

   public void a(og var1) {
      if (var1 == this.a) {
         zx var2 = var1.a(0);
         int var3;
         if (var2 != null && var2.v()) {
            if (!this.i.D) {
               var3 = 0;

               int var4;
               for(var4 = -1; var4 <= 1; ++var4) {
                  for(int var5 = -1; var5 <= 1; ++var5) {
                     if ((var4 != 0 || var5 != 0) && this.i.d(this.j.a(var5, 0, var4)) && this.i.d(this.j.a(var5, 1, var4))) {
                        if (this.i.p(this.j.a(var5 * 2, 0, var4 * 2)).c() == afi.X) {
                           ++var3;
                        }

                        if (this.i.p(this.j.a(var5 * 2, 1, var4 * 2)).c() == afi.X) {
                           ++var3;
                        }

                        if (var5 != 0 && var4 != 0) {
                           if (this.i.p(this.j.a(var5 * 2, 0, var4)).c() == afi.X) {
                              ++var3;
                           }

                           if (this.i.p(this.j.a(var5 * 2, 1, var4)).c() == afi.X) {
                              ++var3;
                           }

                           if (this.i.p(this.j.a(var5, 0, var4 * 2)).c() == afi.X) {
                              ++var3;
                           }

                           if (this.i.p(this.j.a(var5, 1, var4 * 2)).c() == afi.X) {
                              ++var3;
                           }
                        }
                     }
                  }
               }

               this.k.setSeed((long)this.f);

               for(var4 = 0; var4 < 3; ++var4) {
                  this.g[var4] = ack.a(this.k, var4, var3, var2);
                  this.h[var4] = -1;
                  if (this.g[var4] < var4 + 1) {
                     this.g[var4] = 0;
                  }
               }

               for(var4 = 0; var4 < 3; ++var4) {
                  if (this.g[var4] > 0) {
                     List var7 = this.a(var2, var4, this.g[var4]);
                     if (var7 != null && !var7.isEmpty()) {
                        acl var6 = (acl)var7.get(this.k.nextInt(var7.size()));
                        this.h[var4] = var6.b.B | var6.c << 8;
                     }
                  }
               }

               this.b();
            }
         } else {
            for(var3 = 0; var3 < 3; ++var3) {
               this.g[var3] = 0;
               this.h[var3] = -1;
            }
         }
      }

   }

   public int e() {
      zx var1 = this.a.a(1);
      return var1 == null ? 0 : var1.b;
   }

   public xs(wm var1, adm var2, cj var3) {
      this.a = new oq(this, "Enchant", true, 2) {
         final xs a;

         public void p_() {
            super.p_();
            this.a.a((og)this);
         }

         {
            this.a = var1;
         }

         public int q_() {
            return 64;
         }
      };
      this.k = new Random();
      this.g = new int[3];
      this.h = new int[]{-1, -1, -1};
      this.i = var2;
      this.j = var3;
      this.f = var1.d.cj();
      this.a((yg)(new yg(this, this.a, 0, 15, 47) {
         final xs a;

         {
            this.a = var1;
         }

         public boolean a(zx var1) {
            return true;
         }

         public int a() {
            return 1;
         }
      }));
      this.a((yg)(new yg(this, this.a, 1, 35, 47) {
         final xs a;

         public boolean a(zx var1) {
            return var1.b() == zy.aW && zd.a(var1.i()) == zd.l;
         }

         {
            this.a = var1;
         }
      }));

      int var4;
      for(var4 = 0; var4 < 3; ++var4) {
         for(int var5 = 0; var5 < 9; ++var5) {
            this.a((yg)(new yg(var1, var5 + var4 * 9 + 9, 8 + var5 * 18, 84 + var4 * 18)));
         }
      }

      for(var4 = 0; var4 < 9; ++var4) {
         this.a((yg)(new yg(var1, var4, 8 + var4 * 18, 142)));
      }

   }
}
