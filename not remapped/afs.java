import com.google.common.base.Predicate;
import java.util.Iterator;

public class afs extends afc {
   public final int b;
   public static final aml a;

   public alz e(adm var1, cj var2, alz var3) {
      if (var1.D) {
         return var3;
      } else {
         alz var4 = var1.p(var2.c());
         alz var5 = var1.p(var2.d());
         alz var6 = var1.p(var2.e());
         alz var7 = var1.p(var2.f());
         cq var8 = (cq)var3.b(a);
         afh var9 = var4.c();
         afh var10 = var5.c();
         afh var11 = var6.c();
         afh var12 = var7.c();
         if (var9 != this && var10 != this) {
            boolean var21 = var9.o();
            boolean var22 = var10.o();
            if (var11 == this || var12 == this) {
               cj var23 = var11 == this ? var2.e() : var2.f();
               alz var24 = var1.p(var23.c());
               alz var25 = var1.p(var23.d());
               var8 = cq.d;
               cq var26;
               if (var11 == this) {
                  var26 = (cq)var6.b(a);
               } else {
                  var26 = (cq)var7.b(a);
               }

               if (var26 == cq.c) {
                  var8 = cq.c;
               }

               afh var19 = var24.c();
               afh var20 = var25.c();
               if ((var21 || var19.o()) && !var22 && !var20.o()) {
                  var8 = cq.d;
               }

               if ((var22 || var20.o()) && !var21 && !var19.o()) {
                  var8 = cq.c;
               }
            }
         } else {
            cj var13 = var9 == this ? var2.c() : var2.d();
            alz var14 = var1.p(var13.e());
            alz var15 = var1.p(var13.f());
            var8 = cq.f;
            cq var16;
            if (var9 == this) {
               var16 = (cq)var4.b(a);
            } else {
               var16 = (cq)var5.b(a);
            }

            if (var16 == cq.e) {
               var8 = cq.e;
            }

            afh var17 = var14.c();
            afh var18 = var15.c();
            if ((var11.o() || var17.o()) && !var12.o() && !var18.o()) {
               var8 = cq.f;
            }

            if ((var12.o() || var18.o()) && !var11.o() && !var17.o()) {
               var8 = cq.e;
            }
         }

         var3 = var3.a(a, var8);
         var1.a((cj)var2, (alz)var3, 3);
         return var3;
      }
   }

   public int c(alz var1) {
      return ((cq)var1.b(a)).a();
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      super.a(var1, var2, var3, var4);
      akw var5 = var1.s(var2);
      if (var5 instanceof aky) {
         var5.E();
      }

   }

   private boolean n(adm var1, cj var2) {
      return this.o(var1, var2) || this.p(var1, var2);
   }

   public boolean i() {
      return this.b == 1;
   }

   public boolean O() {
      return true;
   }

   public boolean d() {
      return false;
   }

   public alz a(int var1) {
      cq var2 = cq.a(var1);
      if (var2.k() == cq.a.b) {
         var2 = cq.c;
      }

      return this.Q().a(a, var2);
   }

   public int b() {
      return 2;
   }

   public void c(adm var1, cj var2, alz var3) {
      this.e(var1, var2, var3);
      Iterator var4 = cq.c.a.iterator();

      while(var4.hasNext()) {
         cq var5 = (cq)var4.next();
         cj var6 = var2.a(var5);
         alz var7 = var1.p(var6);
         if (var7.c() == this) {
            this.e(var1, var6, var7);
         }
      }

   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      if (var1.D) {
         return true;
      } else {
         oo var9 = this.f(var1, var2);
         if (var9 != null) {
            var4.a((og)var9);
            if (this.b == 0) {
               var4.b(na.aa);
            } else if (this.b == 1) {
               var4.b(na.U);
            }
         }

         return true;
      }
   }

   public int a(adq var1, cj var2, alz var3, cq var4) {
      if (!this.i()) {
         return 0;
      } else {
         int var5 = 0;
         akw var6 = var1.s(var2);
         if (var6 instanceof aky) {
            var5 = ((aky)var6).l;
         }

         return ns.a(var5, 0, 15);
      }
   }

   public void b(adm var1, cj var2, alz var3) {
      akw var4 = var1.s(var2);
      if (var4 instanceof og) {
         oi.a(var1, var2, (og)var4);
         var1.e(var2, this);
      }

      super.b(var1, var2, var3);
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   public alz f(adm var1, cj var2, alz var3) {
      cq var4 = null;
      Iterator var5 = cq.c.a.iterator();

      while(var5.hasNext()) {
         cq var6 = (cq)var5.next();
         alz var7 = var1.p(var2.a(var6));
         if (var7.c() == this) {
            return var3;
         }

         if (var7.c().o()) {
            if (var4 != null) {
               var4 = null;
               break;
            }

            var4 = var6;
         }
      }

      if (var4 != null) {
         return var3.a(a, var4.d());
      } else {
         cq var8 = (cq)var3.b(a);
         if (var1.p(var2.a(var8)).c().o()) {
            var8 = var8.d();
         }

         if (var1.p(var2.a(var8)).c().o()) {
            var8 = var8.e();
         }

         if (var1.p(var2.a(var8)).c().o()) {
            var8 = var8.d();
         }

         return var3.a(a, var8);
      }
   }

   protected afs(int var1) {
      super(arm.d);
      this.j(this.M.b().a(a, cq.c));
      this.b = var1;
      this.a(yz.c);
      this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
   }

   static {
      a = aml.a("facing", (Predicate)cq.c.a);
   }

   private boolean p(adm var1, cj var2) {
      Iterator var3 = var1.a(ts.class, new aug((double)var2.n(), (double)(var2.o() + 1), (double)var2.p(), (double)(var2.n() + 1), (double)(var2.o() + 2), (double)(var2.p() + 1))).iterator();

      ts var5;
      do {
         if (!var3.hasNext()) {
            return false;
         }

         pk var4 = (pk)var3.next();
         var5 = (ts)var4;
      } while(!var5.cn());

      return true;
   }

   private boolean m(adm var1, cj var2) {
      if (var1.p(var2).c() != this) {
         return false;
      } else {
         Iterator var3 = cq.c.a.iterator();

         cq var4;
         do {
            if (!var3.hasNext()) {
               return false;
            }

            var4 = (cq)var3.next();
         } while(var1.p(var2.a(var4)).c() != this);

         return true;
      }
   }

   public int b(adq var1, cj var2, alz var3, cq var4) {
      return var4 == cq.b ? this.a(var1, var2, var3, var4) : 0;
   }

   public void a(adq var1, cj var2) {
      if (var1.p(var2.c()).c() == this) {
         this.a(0.0625F, 0.0F, 0.0F, 0.9375F, 0.875F, 0.9375F);
      } else if (var1.p(var2.d()).c() == this) {
         this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 1.0F);
      } else if (var1.p(var2.e()).c() == this) {
         this.a(0.0F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
      } else if (var1.p(var2.f()).c() == this) {
         this.a(0.0625F, 0.0F, 0.0625F, 1.0F, 0.875F, 0.9375F);
      } else {
         this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
      }

   }

   public boolean c() {
      return false;
   }

   public void a(adm var1, cj var2, alz var3, pr var4, zx var5) {
      cq var6 = cq.b(ns.c((double)(var4.y * 4.0F / 360.0F) + 0.5D) & 3).d();
      var3 = var3.a(a, var6);
      cj var7 = var2.c();
      cj var8 = var2.d();
      cj var9 = var2.e();
      cj var10 = var2.f();
      boolean var11 = this == var1.p(var7).c();
      boolean var12 = this == var1.p(var8).c();
      boolean var13 = this == var1.p(var9).c();
      boolean var14 = this == var1.p(var10).c();
      if (!var11 && !var12 && !var13 && !var14) {
         var1.a((cj)var2, (alz)var3, 3);
      } else if (var6.k() != cq.a.a || !var11 && !var12) {
         if (var6.k() == cq.a.c && (var13 || var14)) {
            if (var13) {
               var1.a((cj)var9, (alz)var3, 3);
            } else {
               var1.a((cj)var10, (alz)var3, 3);
            }

            var1.a((cj)var2, (alz)var3, 3);
         }
      } else {
         if (var11) {
            var1.a((cj)var7, (alz)var3, 3);
         } else {
            var1.a((cj)var8, (alz)var3, 3);
         }

         var1.a((cj)var2, (alz)var3, 3);
      }

      if (var5.s()) {
         akw var15 = var1.s(var2);
         if (var15 instanceof aky) {
            ((aky)var15).a(var5.q());
         }
      }

   }

   public oo f(adm var1, cj var2) {
      akw var3 = var1.s(var2);
      if (!(var3 instanceof aky)) {
         return null;
      } else {
         Object var4 = (aky)var3;
         if (this.n(var1, var2)) {
            return null;
         } else {
            Iterator var5 = cq.c.a.iterator();

            while(true) {
               while(true) {
                  cq var6;
                  akw var9;
                  do {
                     cj var7;
                     afh var8;
                     do {
                        if (!var5.hasNext()) {
                           return (oo)var4;
                        }

                        var6 = (cq)var5.next();
                        var7 = var2.a(var6);
                        var8 = var1.p(var7).c();
                     } while(var8 != this);

                     if (this.n(var1, var7)) {
                        return null;
                     }

                     var9 = var1.s(var7);
                  } while(!(var9 instanceof aky));

                  if (var6 != cq.e && var6 != cq.c) {
                     var4 = new of("container.chestDouble", (oo)var4, (aky)var9);
                  } else {
                     var4 = new of("container.chestDouble", (aky)var9, (oo)var4);
                  }
               }
            }
         }
      }
   }

   private boolean o(adm var1, cj var2) {
      return var1.p(var2.a()).c().v();
   }

   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      return this.Q().a(a, var8.aP());
   }

   public boolean d(adm var1, cj var2) {
      int var3 = 0;
      cj var4 = var2.e();
      cj var5 = var2.f();
      cj var6 = var2.c();
      cj var7 = var2.d();
      if (var1.p(var4).c() == this) {
         if (this.m(var1, var4)) {
            return false;
         }

         ++var3;
      }

      if (var1.p(var5).c() == this) {
         if (this.m(var1, var5)) {
            return false;
         }

         ++var3;
      }

      if (var1.p(var6).c() == this) {
         if (this.m(var1, var6)) {
            return false;
         }

         ++var3;
      }

      if (var1.p(var7).c() == this) {
         if (this.m(var1, var7)) {
            return false;
         }

         ++var3;
      }

      return var3 <= 1;
   }

   public int l(adm var1, cj var2) {
      return xi.b((og)this.f(var1, var2));
   }

   public akw a(adm var1, int var2) {
      return new aky();
   }
}
