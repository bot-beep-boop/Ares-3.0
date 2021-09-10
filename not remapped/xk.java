import java.util.Iterator;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class xk extends xi {
   private cj j;
   private og g;
   private int k;
   private og h;
   private final wn m;
   public int a;
   private adm i;
   private static final Logger f = LogManager.getLogger();
   private String l;

   public void a(xn var1) {
      super.a(var1);
      var1.a(this, 0, this.a);
   }

   public void a(String var1) {
      this.l = var1;
      if (this.a(2).e()) {
         zx var2 = this.a(2).d();
         if (StringUtils.isBlank(var1)) {
            var2.r();
         } else {
            var2.c(this.l);
         }
      }

      this.e();
   }

   public xk(wm var1, adm var2, wn var3) {
      this(var1, var2, cj.a, var3);
   }

   public void b(wn var1) {
      super.b(var1);
      if (!this.i.D) {
         for(int var2 = 0; var2 < this.h.o_(); ++var2) {
            zx var3 = this.h.b(var2);
            if (var3 != null) {
               var1.a(var3, false);
            }
         }

      }
   }

   public void b(int var1, int var2) {
      if (var1 == 0) {
         this.a = var2;
      }

   }

   public boolean a(wn var1) {
      if (this.i.p(this.j).c() != afi.cf) {
         return false;
      } else {
         return !(var1.e((double)this.j.n() + 0.5D, (double)this.j.o() + 0.5D, (double)this.j.p() + 0.5D) > 64.0D);
      }
   }

   public void e() {
      boolean var1 = false;
      boolean var2 = true;
      boolean var3 = true;
      boolean var4 = true;
      boolean var5 = true;
      boolean var6 = true;
      boolean var7 = true;
      zx var8 = this.h.a(0);
      this.a = 1;
      int var9 = 0;
      byte var10 = 0;
      byte var11 = 0;
      if (var8 == null) {
         this.g.a(0, (zx)null);
         this.a = 0;
      } else {
         zx var12 = var8.k();
         zx var13 = this.h.a(1);
         Map var14 = ack.a(var12);
         boolean var15 = false;
         int var25 = var10 + var8.A() + (var13 == null ? 0 : var13.A());
         this.k = 0;
         int var16;
         if (var13 != null) {
            var15 = var13.b() == zy.cd && zy.cd.h(var13).c() > 0;
            int var17;
            int var18;
            if (var12.e() && var12.b().a(var8, var13)) {
               var16 = Math.min(var12.h(), var12.j() / 4);
               if (var16 <= 0) {
                  this.g.a(0, (zx)null);
                  this.a = 0;
                  return;
               }

               for(var17 = 0; var16 > 0 && var17 < var13.b; ++var17) {
                  var18 = var12.h() - var16;
                  var12.b(var18);
                  ++var9;
                  var16 = Math.min(var12.h(), var12.j() / 4);
               }

               this.k = var17;
            } else {
               if (!var15 && (var12.b() != var13.b() || !var12.e())) {
                  this.g.a(0, (zx)null);
                  this.a = 0;
                  return;
               }

               int var20;
               if (var12.e() && !var15) {
                  var16 = var8.j() - var8.h();
                  var17 = var13.j() - var13.h();
                  var18 = var17 + var12.j() * 12 / 100;
                  int var19 = var16 + var18;
                  var20 = var12.j() - var19;
                  if (var20 < 0) {
                     var20 = 0;
                  }

                  if (var20 < var12.i()) {
                     var12.b(var20);
                     var9 += 2;
                  }
               }

               Map var26 = ack.a(var13);
               Iterator var27 = var26.keySet().iterator();

               label229:
               while(true) {
                  aci var28;
                  do {
                     if (!var27.hasNext()) {
                        break label229;
                     }

                     var18 = (Integer)var27.next();
                     var28 = aci.c(var18);
                  } while(var28 == null);

                  var20 = var14.containsKey(var18) ? (Integer)var14.get(var18) : 0;
                  int var21 = (Integer)var26.get(var18);
                  int var10000;
                  if (var20 == var21) {
                     ++var21;
                     var10000 = var21;
                  } else {
                     var10000 = Math.max(var21, var20);
                  }

                  var21 = var10000;
                  boolean var22 = var28.a(var8);
                  if (this.m.bA.d || var8.b() == zy.cd) {
                     var22 = true;
                  }

                  Iterator var23 = var14.keySet().iterator();

                  while(var23.hasNext()) {
                     int var24 = (Integer)var23.next();
                     if (var24 != var18 && !var28.a(aci.c(var24))) {
                        var22 = false;
                        ++var9;
                     }
                  }

                  if (var22) {
                     if (var21 > var28.b()) {
                        var21 = var28.b();
                     }

                     var14.put(var18, var21);
                     int var29 = 0;
                     switch(var28.d()) {
                     case 1:
                        var29 = 8;
                        break;
                     case 2:
                        var29 = 4;
                     case 3:
                     case 4:
                     case 6:
                     case 7:
                     case 8:
                     case 9:
                     default:
                        break;
                     case 5:
                        var29 = 2;
                        break;
                     case 10:
                        var29 = 1;
                     }

                     if (var15) {
                        var29 = Math.max(1, var29 / 2);
                     }

                     var9 += var29 * var21;
                  }
               }
            }
         }

         if (StringUtils.isBlank(this.l)) {
            if (var8.s()) {
               var11 = 1;
               var9 += var11;
               var12.r();
            }
         } else if (!this.l.equals(var8.q())) {
            var11 = 1;
            var9 += var11;
            var12.c(this.l);
         }

         this.a = var25 + var9;
         if (var9 <= 0) {
            var12 = null;
         }

         if (var11 == var9 && var11 > 0 && this.a >= 40) {
            this.a = 39;
         }

         if (this.a >= 40 && !this.m.bA.d) {
            var12 = null;
         }

         if (var12 != null) {
            var16 = var12.A();
            if (var13 != null && var16 < var13.A()) {
               var16 = var13.A();
            }

            var16 = var16 * 2 + 1;
            var12.c(var16);
            ack.a(var14, var12);
         }

         this.g.a(0, var12);
         this.b();
      }
   }

   static int b(xk var0) {
      return var0.k;
   }

   public xk(wm var1, adm var2, cj var3, wn var4) {
      this.g = new ye();
      this.h = new oq(this, "Repair", true, 2) {
         final xk a;

         {
            this.a = var1;
         }

         public void p_() {
            super.p_();
            this.a.a((og)this);
         }
      };
      this.j = var3;
      this.i = var2;
      this.m = var4;
      this.a((yg)(new yg(this.h, 0, 27, 47)));
      this.a((yg)(new yg(this.h, 1, 76, 47)));
      this.a((yg)(new yg(this, this.g, 2, 134, 47, var2, var3) {
         final adm a;
         final cj b;
         final xk c;

         public boolean a(zx var1) {
            return false;
         }

         {
            this.c = var1;
            this.a = var6;
            this.b = var7;
         }

         public void a(wn var1, zx var2) {
            if (!var1.bA.d) {
               var1.a(-this.c.a);
            }

            xk.a(this.c).a(0, (zx)null);
            if (xk.b(this.c) > 0) {
               zx var3 = xk.a(this.c).a(1);
               if (var3 != null && var3.b > xk.b(this.c)) {
                  var3.b -= xk.b(this.c);
                  xk.a(this.c).a(1, var3);
               } else {
                  xk.a(this.c).a(1, (zx)null);
               }
            } else {
               xk.a(this.c).a(1, (zx)null);
            }

            this.c.a = 0;
            alz var5 = this.a.p(this.b);
            if (!var1.bA.d && !this.a.D && var5.c() == afi.cf && var1.bc().nextFloat() < 0.12F) {
               int var4 = (Integer)var5.b(aez.b);
               ++var4;
               if (var4 > 2) {
                  this.a.g(this.b);
                  this.a.b(1020, this.b, 0);
               } else {
                  this.a.a((cj)this.b, (alz)var5.a(aez.b, var4), 2);
                  this.a.b(1021, this.b, 0);
               }
            } else if (!this.a.D) {
               this.a.b(1021, this.b, 0);
            }

         }

         public boolean a(wn var1) {
            return (var1.bA.d || var1.bB >= this.c.a) && this.c.a > 0 && this.e();
         }
      }));

      int var5;
      for(var5 = 0; var5 < 3; ++var5) {
         for(int var6 = 0; var6 < 9; ++var6) {
            this.a((yg)(new yg(var1, var6 + var5 * 9 + 9, 8 + var6 * 18, 84 + var5 * 18)));
         }
      }

      for(var5 = 0; var5 < 9; ++var5) {
         this.a((yg)(new yg(var1, var5, 8 + var5 * 18, 142)));
      }

   }

   static og a(xk var0) {
      return var0.h;
   }

   public zx b(wn var1, int var2) {
      zx var3 = null;
      yg var4 = (yg)this.c.get(var2);
      if (var4 != null && var4.e()) {
         zx var5 = var4.d();
         var3 = var5.k();
         if (var2 == 2) {
            if (!this.a(var5, 3, 39, true)) {
               return null;
            }

            var4.a(var5, var3);
         } else if (var2 != 0 && var2 != 1) {
            if (var2 >= 3 && var2 < 39 && !this.a(var5, 0, 2, false)) {
               return null;
            }
         } else if (!this.a(var5, 3, 39, false)) {
            return null;
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

   public void a(og var1) {
      super.a(var1);
      if (var1 == this.h) {
         this.e();
      }

   }
}
