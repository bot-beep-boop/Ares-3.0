import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class xi {
   public List<yg> c = Lists.newArrayList();
   private Set<wn> i = Sets.newHashSet();
   public int d;
   private short a;
   public List<zx> b = Lists.newArrayList();
   private int g;
   private final Set<yg> h = Sets.newHashSet();
   protected List<xn> e = Lists.newArrayList();
   private int f = -1;

   protected void d() {
      this.g = 0;
      this.h.clear();
   }

   public void a(zx[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.a(var2).d(var1[var2]);
      }

   }

   public void b(int var1, int var2) {
   }

   public List<zx> a() {
      ArrayList var1 = Lists.newArrayList();

      for(int var2 = 0; var2 < this.c.size(); ++var2) {
         var1.add(((yg)this.c.get(var2)).d());
      }

      return var1;
   }

   public boolean c(wn var1) {
      return !this.i.contains(var1);
   }

   public void a(int var1, zx var2) {
      this.a(var1).d(var2);
   }

   public yg a(og var1, int var2) {
      for(int var3 = 0; var3 < this.c.size(); ++var3) {
         yg var4 = (yg)this.c.get(var3);
         if (var4.a(var1, var2)) {
            return var4;
         }
      }

      return null;
   }

   public abstract boolean a(wn var1);

   protected void a(int var1, int var2, boolean var3, wn var4) {
      this.a(var1, var2, 1, var4);
   }

   public zx b(wn var1, int var2) {
      yg var3 = (yg)this.c.get(var2);
      return var3 != null ? var3.d() : null;
   }

   public short a(wm var1) {
      ++this.a;
      return this.a;
   }

   public static int a(akw var0) {
      return var0 instanceof og ? b((og)var0) : 0;
   }

   public yg a(int var1) {
      return (yg)this.c.get(var1);
   }

   public void b(xn var1) {
      this.e.remove(var1);
   }

   public static boolean a(yg var0, zx var1, boolean var2) {
      boolean var3 = var0 == null || !var0.e();
      if (var0 != null && var0.e() && var1 != null && var1.a(var0.d()) && zx.a(var0.d(), var1)) {
         var3 |= var0.d().b + (var2 ? 0 : var1.b) <= var1.c();
      }

      return var3;
   }

   public void a(xn var1) {
      if (this.e.contains(var1)) {
         throw new IllegalArgumentException("Listener already listening");
      } else {
         this.e.add(var1);
         var1.a(this, this.a());
         this.b();
      }
   }

   public static int b(int var0) {
      return var0 >> 2 & 3;
   }

   public static int d(int var0, int var1) {
      return var0 & 3 | (var1 & 3) << 2;
   }

   public static int b(og var0) {
      if (var0 == null) {
         return 0;
      } else {
         int var1 = 0;
         float var2 = 0.0F;

         for(int var3 = 0; var3 < var0.o_(); ++var3) {
            zx var4 = var0.a(var3);
            if (var4 != null) {
               var2 += (float)var4.b / (float)Math.min(var0.q_(), var4.c());
               ++var1;
            }
         }

         var2 /= (float)var0.o_();
         return ns.d(var2 * 14.0F) + (var1 > 0 ? 1 : 0);
      }
   }

   public void b() {
      for(int var1 = 0; var1 < this.c.size(); ++var1) {
         zx var2 = ((yg)this.c.get(var1)).d();
         zx var3 = (zx)this.b.get(var1);
         if (!zx.b(var3, var2)) {
            var3 = var2 == null ? null : var2.k();
            this.b.set(var1, var3);

            for(int var4 = 0; var4 < this.e.size(); ++var4) {
               ((xn)this.e.get(var4)).a(this, var1, var3);
            }
         }
      }

   }

   public boolean a(wn var1, int var2) {
      return false;
   }

   public void a(wn var1, boolean var2) {
      if (var2) {
         this.i.remove(var1);
      } else {
         this.i.add(var1);
      }

   }

   public void a(og var1) {
      this.b();
   }

   public void b(wn var1) {
      wm var2 = var1.bi;
      if (var2.p() != null) {
         var1.a(var2.p(), false);
         var2.b((zx)null);
      }

   }

   public static void a(Set<yg> var0, int var1, zx var2, int var3) {
      switch(var1) {
      case 0:
         var2.b = ns.d((float)var2.b / (float)var0.size());
         break;
      case 1:
         var2.b = 1;
         break;
      case 2:
         var2.b = var2.b().j();
      }

      var2.b += var3;
   }

   protected boolean a(zx var1, int var2, int var3, boolean var4) {
      boolean var5 = false;
      int var6 = var2;
      if (var4) {
         var6 = var3 - 1;
      }

      yg var7;
      zx var8;
      if (var1.d()) {
         while(var1.b > 0 && (!var4 && var6 < var3 || var4 && var6 >= var2)) {
            var7 = (yg)this.c.get(var6);
            var8 = var7.d();
            if (var8 != null && var8.b() == var1.b() && (!var1.f() || var1.i() == var8.i()) && zx.a(var1, var8)) {
               int var9 = var8.b + var1.b;
               if (var9 <= var1.c()) {
                  var1.b = 0;
                  var8.b = var9;
                  var7.f();
                  var5 = true;
               } else if (var8.b < var1.c()) {
                  var1.b -= var1.c() - var8.b;
                  var8.b = var1.c();
                  var7.f();
                  var5 = true;
               }
            }

            if (var4) {
               --var6;
            } else {
               ++var6;
            }
         }
      }

      if (var1.b > 0) {
         if (var4) {
            var6 = var3 - 1;
         } else {
            var6 = var2;
         }

         while(!var4 && var6 < var3 || var4 && var6 >= var2) {
            var7 = (yg)this.c.get(var6);
            var8 = var7.d();
            if (var8 == null) {
               var7.d(var1.k());
               var7.f();
               var1.b = 0;
               var5 = true;
               break;
            }

            if (var4) {
               --var6;
            } else {
               ++var6;
            }
         }
      }

      return var5;
   }

   public static boolean a(int var0, wn var1) {
      if (var0 == 0) {
         return true;
      } else if (var0 == 1) {
         return true;
      } else {
         return var0 == 2 && var1.bA.d;
      }
   }

   protected yg a(yg var1) {
      var1.e = this.c.size();
      this.c.add(var1);
      this.b.add((Object)null);
      return var1;
   }

   public boolean b(yg var1) {
      return true;
   }

   public boolean a(zx var1, yg var2) {
      return true;
   }

   public zx a(int var1, int var2, int var3, wn var4) {
      zx var5 = null;
      wm var6 = var4.bi;
      int var9;
      zx var17;
      if (var3 == 5) {
         int var7 = this.g;
         this.g = c(var2);
         if ((var7 != 1 || this.g != 2) && var7 != this.g) {
            this.d();
         } else if (var6.p() == null) {
            this.d();
         } else if (this.g == 0) {
            this.f = b(var2);
            if (a(this.f, var4)) {
               this.g = 1;
               this.h.clear();
            } else {
               this.d();
            }
         } else if (this.g == 1) {
            yg var8 = (yg)this.c.get(var1);
            if (var8 != null && a(var8, var6.p(), true) && var8.a(var6.p()) && var6.p().b > this.h.size() && this.b(var8)) {
               this.h.add(var8);
            }
         } else if (this.g == 2) {
            if (!this.h.isEmpty()) {
               var17 = var6.p().k();
               var9 = var6.p().b;
               Iterator var10 = this.h.iterator();

               while(var10.hasNext()) {
                  yg var11 = (yg)var10.next();
                  if (var11 != null && a(var11, var6.p(), true) && var11.a(var6.p()) && var6.p().b >= this.h.size() && this.b(var11)) {
                     zx var12 = var17.k();
                     int var13 = var11.e() ? var11.d().b : 0;
                     a(this.h, this.f, var12, var13);
                     if (var12.b > var12.c()) {
                        var12.b = var12.c();
                     }

                     if (var12.b > var11.b(var12)) {
                        var12.b = var11.b(var12);
                     }

                     var9 -= var12.b - var13;
                     var11.d(var12);
                  }
               }

               var17.b = var9;
               if (var17.b <= 0) {
                  var17 = null;
               }

               var6.b(var17);
            }

            this.d();
         } else {
            this.d();
         }
      } else if (this.g != 0) {
         this.d();
      } else {
         yg var16;
         int var20;
         zx var22;
         if (var3 != 0 && var3 != 1 || var2 != 0 && var2 != 1) {
            if (var3 == 2 && var2 >= 0 && var2 < 9) {
               var16 = (yg)this.c.get(var1);
               if (var16.a(var4)) {
                  var17 = var6.a(var2);
                  boolean var21 = var17 == null || var16.d == var6 && var16.a(var17);
                  var20 = -1;
                  if (!var21) {
                     var20 = var6.j();
                     var21 |= var20 > -1;
                  }

                  if (var16.e() && var21) {
                     var22 = var16.d();
                     var6.a(var2, var22.k());
                     if ((var16.d != var6 || !var16.a(var17)) && var17 != null) {
                        if (var20 > -1) {
                           var6.a(var17);
                           var16.a(var22.b);
                           var16.d((zx)null);
                           var16.a(var4, var22);
                        }
                     } else {
                        var16.a(var22.b);
                        var16.d(var17);
                        var16.a(var4, var22);
                     }
                  } else if (!var16.e() && var17 != null && var16.a(var17)) {
                     var6.a(var2, (zx)null);
                     var16.d(var17);
                  }
               }
            } else if (var3 == 3 && var4.bA.d && var6.p() == null && var1 >= 0) {
               var16 = (yg)this.c.get(var1);
               if (var16 != null && var16.e()) {
                  var17 = var16.d().k();
                  var17.b = var17.c();
                  var6.b(var17);
               }
            } else if (var3 == 4 && var6.p() == null && var1 >= 0) {
               var16 = (yg)this.c.get(var1);
               if (var16 != null && var16.e() && var16.a(var4)) {
                  var17 = var16.a(var2 == 0 ? 1 : var16.d().b);
                  var16.a(var4, var17);
                  var4.a(var17, true);
               }
            } else if (var3 == 6 && var1 >= 0) {
               var16 = (yg)this.c.get(var1);
               var17 = var6.p();
               if (var17 != null && (var16 == null || !var16.e() || !var16.a(var4))) {
                  var9 = var2 == 0 ? 0 : this.c.size() - 1;
                  var20 = var2 == 0 ? 1 : -1;

                  for(int var23 = 0; var23 < 2; ++var23) {
                     for(int var24 = var9; var24 >= 0 && var24 < this.c.size() && var17.b < var17.c(); var24 += var20) {
                        yg var25 = (yg)this.c.get(var24);
                        if (var25.e() && a(var25, var17, true) && var25.a(var4) && this.a(var17, var25) && (var23 != 0 || var25.d().b != var25.d().c())) {
                           int var14 = Math.min(var17.c() - var17.b, var25.d().b);
                           zx var15 = var25.a(var14);
                           var17.b += var14;
                           if (var15.b <= 0) {
                              var25.d((zx)null);
                           }

                           var25.a(var4, var15);
                        }
                     }
                  }
               }

               this.b();
            }
         } else if (var1 == -999) {
            if (var6.p() != null) {
               if (var2 == 0) {
                  var4.a(var6.p(), true);
                  var6.b((zx)null);
               }

               if (var2 == 1) {
                  var4.a(var6.p().a(1), true);
                  if (var6.p().b == 0) {
                     var6.b((zx)null);
                  }
               }
            }
         } else if (var3 == 1) {
            if (var1 < 0) {
               return null;
            }

            var16 = (yg)this.c.get(var1);
            if (var16 != null && var16.a(var4)) {
               var17 = this.b(var4, var1);
               if (var17 != null) {
                  zw var18 = var17.b();
                  var5 = var17.k();
                  if (var16.d() != null && var16.d().b() == var18) {
                     this.a(var1, var2, true, var4);
                  }
               }
            }
         } else {
            if (var1 < 0) {
               return null;
            }

            var16 = (yg)this.c.get(var1);
            if (var16 != null) {
               var17 = var16.d();
               zx var19 = var6.p();
               if (var17 != null) {
                  var5 = var17.k();
               }

               if (var17 == null) {
                  if (var19 != null && var16.a(var19)) {
                     var20 = var2 == 0 ? var19.b : 1;
                     if (var20 > var16.b(var19)) {
                        var20 = var16.b(var19);
                     }

                     if (var19.b >= var20) {
                        var16.d(var19.a(var20));
                     }

                     if (var19.b == 0) {
                        var6.b((zx)null);
                     }
                  }
               } else if (var16.a(var4)) {
                  if (var19 == null) {
                     var20 = var2 == 0 ? var17.b : (var17.b + 1) / 2;
                     var22 = var16.a(var20);
                     var6.b(var22);
                     if (var17.b == 0) {
                        var16.d((zx)null);
                     }

                     var16.a(var4, var6.p());
                  } else if (var16.a(var19)) {
                     if (var17.b() == var19.b() && var17.i() == var19.i() && zx.a(var17, var19)) {
                        var20 = var2 == 0 ? var19.b : 1;
                        if (var20 > var16.b(var19) - var17.b) {
                           var20 = var16.b(var19) - var17.b;
                        }

                        if (var20 > var19.c() - var17.b) {
                           var20 = var19.c() - var17.b;
                        }

                        var19.a(var20);
                        if (var19.b == 0) {
                           var6.b((zx)null);
                        }

                        var17.b += var20;
                     } else if (var19.b <= var16.b(var19)) {
                        var16.d(var19);
                        var6.b(var17);
                     }
                  } else if (var17.b() == var19.b() && var19.c() > 1 && (!var17.f() || var17.i() == var19.i()) && zx.a(var17, var19)) {
                     var20 = var17.b;
                     if (var20 > 0 && var20 + var19.b <= var19.c()) {
                        var19.b += var20;
                        var17 = var16.a(var20);
                        if (var17.b == 0) {
                           var16.d((zx)null);
                        }

                        var16.a(var4, var6.p());
                     }
                  }
               }

               var16.f();
            }
         }
      }

      return var5;
   }

   public static int c(int var0) {
      return var0 & 3;
   }
}
