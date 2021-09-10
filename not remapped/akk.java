import java.util.Iterator;
import java.util.Random;

public class akk extends afh {
   public static final amk a = amk.a("up");
   public static final amk P = amk.a("west");
   public static final amk O = amk.a("south");
   public static final amk N = amk.a("east");
   public static final amk b = amk.a("north");
   public static final amk[] Q;

   public void a(adq var1, cj var2) {
      float var3 = 0.0625F;
      float var4 = 1.0F;
      float var5 = 1.0F;
      float var6 = 1.0F;
      float var7 = 0.0F;
      float var8 = 0.0F;
      float var9 = 0.0F;
      boolean var10 = false;
      if ((Boolean)var1.p(var2).b(P)) {
         var7 = Math.max(var7, 0.0625F);
         var4 = 0.0F;
         var5 = 0.0F;
         var8 = 1.0F;
         var6 = 0.0F;
         var9 = 1.0F;
         var10 = true;
      }

      if ((Boolean)var1.p(var2).b(N)) {
         var4 = Math.min(var4, 0.9375F);
         var7 = 1.0F;
         var5 = 0.0F;
         var8 = 1.0F;
         var6 = 0.0F;
         var9 = 1.0F;
         var10 = true;
      }

      if ((Boolean)var1.p(var2).b(b)) {
         var9 = Math.max(var9, 0.0625F);
         var6 = 0.0F;
         var4 = 0.0F;
         var7 = 1.0F;
         var5 = 0.0F;
         var8 = 1.0F;
         var10 = true;
      }

      if ((Boolean)var1.p(var2).b(O)) {
         var6 = Math.min(var6, 0.9375F);
         var9 = 1.0F;
         var4 = 0.0F;
         var7 = 1.0F;
         var5 = 0.0F;
         var8 = 1.0F;
         var10 = true;
      }

      if (!var10 && this.c(var1.p(var2.a()).c())) {
         var5 = Math.min(var5, 0.9375F);
         var8 = 1.0F;
         var4 = 0.0F;
         var7 = 1.0F;
         var6 = 0.0F;
         var9 = 1.0F;
      }

      this.a(var4, var5, var6, var7, var8, var9);
   }

   public void j() {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      if (!var1.D && !this.e(var1, var2, var3)) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
      }

   }

   private boolean e(adm var1, cj var2, alz var3) {
      alz var4 = var3;
      Iterator var5 = cq.c.a.iterator();

      while(true) {
         amk var7;
         alz var8;
         do {
            cq var6;
            do {
               do {
                  if (!var5.hasNext()) {
                     if (d(var3) == 0) {
                        return false;
                     }

                     if (var4 != var3) {
                        var1.a((cj)var2, (alz)var3, 2);
                     }

                     return true;
                  }

                  var6 = (cq)var5.next();
                  var7 = a(var6);
               } while(!(Boolean)var3.b(var7));
            } while(this.c(var1.p(var2.a(var6)).c()));

            var8 = var1.p(var2.a());
         } while(var8.c() == this && (Boolean)var8.b(var7));

         var3 = var3.a(var7, false);
      }
   }

   public boolean d() {
      return false;
   }

   public alz a(alz var1, adq var2, cj var3) {
      return var1.a(a, var2.p(var3.a()).c().u());
   }

   public int a(adq var1, cj var2, int var3) {
      return var1.b(var2).c(var2);
   }

   public zw a(alz var1, Random var2, int var3) {
      return null;
   }

   private boolean c(afh var1) {
      return var1.d() && var1.J.c();
   }

   public int H() {
      return adj.c();
   }

   public alz a(int var1) {
      return this.Q().a(O, (var1 & 1) > 0).a(P, (var1 & 2) > 0).a(b, (var1 & 4) > 0).a(N, (var1 & 8) > 0);
   }

   public int c(alz var1) {
      int var2 = 0;
      if ((Boolean)var1.b(O)) {
         var2 |= 1;
      }

      if ((Boolean)var1.b(P)) {
         var2 |= 2;
      }

      if ((Boolean)var1.b(b)) {
         var2 |= 4;
      }

      if ((Boolean)var1.b(N)) {
         var2 |= 8;
      }

      return var2;
   }

   static {
      Q = new amk[]{a, b, O, P, N};
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      if (!var1.D) {
         if (var1.s.nextInt(4) == 0) {
            byte var5 = 4;
            int var6 = 5;
            boolean var7 = false;

            label242:
            for(int var8 = -var5; var8 <= var5; ++var8) {
               for(int var9 = -var5; var9 <= var5; ++var9) {
                  for(int var10 = -1; var10 <= 1; ++var10) {
                     if (var1.p(var2.a(var8, var10, var9)).c() == this) {
                        --var6;
                        if (var6 <= 0) {
                           var7 = true;
                           break label242;
                        }
                     }
                  }
               }
            }

            cq var18 = cq.a(var4);
            cj var19 = var2.a();
            cq var24;
            if (var18 == cq.b && var2.o() < 255 && var1.d(var19)) {
               if (!var7) {
                  alz var21 = var3;
                  Iterator var23 = cq.c.a.iterator();

                  while(true) {
                     do {
                        if (!var23.hasNext()) {
                           if ((Boolean)var21.b(b) || (Boolean)var21.b(N) || (Boolean)var21.b(O) || (Boolean)var21.b(P)) {
                              var1.a((cj)var19, (alz)var21, 2);
                           }

                           return;
                        }

                        var24 = (cq)var23.next();
                     } while(!var4.nextBoolean() && this.c(var1.p(var19.a(var24)).c()));

                     var21 = var21.a(a(var24), false);
                  }
               }
            } else {
               cj var20;
               if (var18.k().c() && !(Boolean)var3.b(a(var18))) {
                  if (!var7) {
                     var20 = var2.a(var18);
                     afh var22 = var1.p(var20).c();
                     if (var22.J == arm.a) {
                        var24 = var18.e();
                        cq var25 = var18.f();
                        boolean var26 = (Boolean)var3.b(a(var24));
                        boolean var27 = (Boolean)var3.b(a(var25));
                        cj var28 = var20.a(var24);
                        cj var17 = var20.a(var25);
                        if (var26 && this.c(var1.p(var28).c())) {
                           var1.a((cj)var20, (alz)this.Q().a(a(var24), true), 2);
                        } else if (var27 && this.c(var1.p(var17).c())) {
                           var1.a((cj)var20, (alz)this.Q().a(a(var25), true), 2);
                        } else if (var26 && var1.d(var28) && this.c(var1.p(var2.a(var24)).c())) {
                           var1.a((cj)var28, (alz)this.Q().a(a(var18.d()), true), 2);
                        } else if (var27 && var1.d(var17) && this.c(var1.p(var2.a(var25)).c())) {
                           var1.a((cj)var17, (alz)this.Q().a(a(var18.d()), true), 2);
                        } else if (this.c(var1.p(var20.a()).c())) {
                           var1.a((cj)var20, (alz)this.Q(), 2);
                        }
                     } else if (var22.J.k() && var22.d()) {
                        var1.a((cj)var2, (alz)var3.a(a(var18), true), 2);
                     }

                  }
               } else {
                  if (var2.o() > 1) {
                     var20 = var2.b();
                     alz var11 = var1.p(var20);
                     afh var12 = var11.c();
                     alz var13;
                     Iterator var14;
                     cq var15;
                     if (var12.J == arm.a) {
                        var13 = var3;
                        var14 = cq.c.a.iterator();

                        while(var14.hasNext()) {
                           var15 = (cq)var14.next();
                           if (var4.nextBoolean()) {
                              var13 = var13.a(a(var15), false);
                           }
                        }

                        if ((Boolean)var13.b(b) || (Boolean)var13.b(N) || (Boolean)var13.b(O) || (Boolean)var13.b(P)) {
                           var1.a((cj)var20, (alz)var13, 2);
                        }
                     } else if (var12 == this) {
                        var13 = var11;
                        var14 = cq.c.a.iterator();

                        while(var14.hasNext()) {
                           var15 = (cq)var14.next();
                           amk var16 = a(var15);
                           if (var4.nextBoolean() && (Boolean)var3.b(var16)) {
                              var13 = var13.a(var16, true);
                           }
                        }

                        if ((Boolean)var13.b(b) || (Boolean)var13.b(N) || (Boolean)var13.b(O) || (Boolean)var13.b(P)) {
                           var1.a((cj)var20, (alz)var13, 2);
                        }
                     }
                  }

               }
            }
         }
      }
   }

   protected ama e() {
      return new ama(this, new amo[]{a, b, N, O, P});
   }

   public static amk a(cq var0) {
      switch(var0) {
      case b:
         return a;
      case c:
         return b;
      case d:
         return O;
      case f:
         return N;
      case e:
         return P;
      default:
         throw new IllegalArgumentException(var0 + " is an invalid choice");
      }
   }

   public boolean c() {
      return false;
   }

   public void a(adm var1, wn var2, cj var3, alz var4, akw var5) {
      if (!var1.D && var2.bZ() != null && var2.bZ().b() == zy.be) {
         var2.b(na.ab[afh.a((afh)this)]);
         a((adm)var1, (cj)var3, (zx)(new zx(afi.bn, 1, 0)));
      } else {
         super.a(var1, var2, var3, var4, var5);
      }

   }

   public static int d(alz var0) {
      int var1 = 0;
      amk[] var2 = Q;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         amk var5 = var2[var4];
         if ((Boolean)var0.b(var5)) {
            ++var1;
         }
      }

      return var1;
   }

   public akk() {
      super(arm.l);
      this.j(this.M.b().a(a, false).a(b, false).a(N, false).a(O, false).a(P, false));
      this.a(true);
      this.a((yz)yz.c);
   }

   public adf m() {
      return adf.c;
   }

   public boolean b(adm var1, cj var2, cq var3) {
      switch(var3) {
      case b:
         return this.c(var1.p(var2.a()).c());
      case c:
      case d:
      case f:
      case e:
         return this.c(var1.p(var2.a(var3.d())).c());
      default:
         return false;
      }
   }

   public aug a(adm var1, cj var2, alz var3) {
      return null;
   }

   public boolean a(adm var1, cj var2) {
      return true;
   }

   public int h(alz var1) {
      return adj.c();
   }

   public int a(Random var1) {
      return 0;
   }

   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      alz var9 = this.Q().a(a, false).a(b, false).a(N, false).a(O, false).a(P, false);
      return var3.k().c() ? var9.a(a(var3.d()), true) : var9;
   }
}
