import com.mojang.authlib.GameProfile;
import java.io.PrintStream;
import java.util.Random;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class kb {
   private static boolean b;
   private static final PrintStream a;
   private static final Logger c;

   static {
      a = System.out;
      b = false;
      c = LogManager.getLogger();
   }

   private static void d() {
      System.setErr(new kg("STDERR", System.err));
      System.setOut(new kg("STDOUT", a));
   }

   public static boolean a() {
      return b;
   }

   static void b() {
      agg.N.a(zy.g, new ka() {
         protected wv a(adm var1, cz var2) {
            wq var3 = new wq(var1, var2.a(), var2.b(), var2.c());
            var3.a = 1;
            return var3;
         }
      });
      agg.N.a(zy.aP, new ka() {
         protected wv a(adm var1, cz var2) {
            return new wz(var1, var2.a(), var2.b(), var2.c());
         }
      });
      agg.N.a(zy.aD, new ka() {
         protected wv a(adm var1, cz var2) {
            return new wx(var1, var2.a(), var2.b(), var2.c());
         }
      });
      agg.N.a(zy.bK, new ka() {
         protected float b() {
            return super.b() * 1.25F;
         }

         protected wv a(adm var1, cz var2) {
            return new xb(var1, var2.a(), var2.b(), var2.c());
         }

         protected float a() {
            return super.a() * 0.5F;
         }
      });
      agg.N.a(zy.bz, new cr() {
         private final cn b = new cn();

         public zx a(ck var1, zx var2) {
            return aai.f(var2.i()) ? (new ka(this, var2) {
               final <undefinedtype> c;
               final zx b;

               protected float a() {
                  return super.a() * 0.5F;
               }

               protected float b() {
                  return super.b() * 1.25F;
               }

               protected wv a(adm var1, cz var2) {
                  return new xc(var1, var2.a(), var2.b(), var2.c(), this.b.k());
               }

               {
                  this.c = var1;
                  this.b = var2;
               }
            }).a(var1, var2) : this.b.a(var1, var2);
         }
      });
      agg.N.a(zy.bJ, new cn() {
         public zx b(ck var1, zx var2) {
            cq var3 = agg.b(var1.f());
            double var4 = var1.a() + (double)var3.g();
            double var6 = (double)((float)var1.d().o() + 0.2F);
            double var8 = var1.c() + (double)var3.i();
            pk var10 = aax.a(var1.i(), var2.i(), var4, var6, var8);
            if (var10 instanceof pr && var2.s()) {
               ((ps)var10).a((String)var2.q());
            }

            var2.a(1);
            return var2;
         }
      });
      agg.N.a(zy.cb, new cn() {
         protected void a(ck var1) {
            var1.i().b(1002, var1.d(), 0);
         }

         public zx b(ck var1, zx var2) {
            cq var3 = agg.b(var1.f());
            double var4 = var1.a() + (double)var3.g();
            double var6 = (double)((float)var1.d().o() + 0.2F);
            double var8 = var1.c() + (double)var3.i();
            wt var10 = new wt(var1.i(), var4, var6, var8, var2);
            var1.i().d((pk)var10);
            var2.a(1);
            return var2;
         }
      });
      agg.N.a(zy.bL, new cn() {
         protected void a(ck var1) {
            var1.i().b(1009, var1.d(), 0);
         }

         public zx b(ck var1, zx var2) {
            cq var3 = agg.b(var1.f());
            cz var4 = agg.a(var1);
            double var5 = var4.a() + (double)((float)var3.g() * 0.3F);
            double var7 = var4.b() + (double)((float)var3.h() * 0.3F);
            double var9 = var4.c() + (double)((float)var3.i() * 0.3F);
            adm var11 = var1.i();
            Random var12 = var11.s;
            double var13 = var12.nextGaussian() * 0.05D + (double)var3.g();
            double var15 = var12.nextGaussian() * 0.05D + (double)var3.h();
            double var17 = var12.nextGaussian() * 0.05D + (double)var3.i();
            var11.d((pk)(new ww(var11, var5, var7, var9, var13, var15, var17)));
            var2.a(1);
            return var2;
         }
      });
      agg.N.a(zy.aE, new cn() {
         private final cn b = new cn();

         protected void a(ck var1) {
            var1.i().b(1000, var1.d(), 0);
         }

         public zx b(ck var1, zx var2) {
            cq var3 = agg.b(var1.f());
            adm var4 = var1.i();
            double var5 = var1.a() + (double)((float)var3.g() * 1.125F);
            double var7 = var1.b() + (double)((float)var3.h() * 1.125F);
            double var9 = var1.c() + (double)((float)var3.i() * 1.125F);
            cj var11 = var1.d().a(var3);
            arm var12 = var4.p(var11).c().t();
            double var13;
            if (arm.h.equals(var12)) {
               var13 = 1.0D;
            } else {
               if (!arm.a.equals(var12) || !arm.h.equals(var4.p(var11.b()).c().t())) {
                  return this.b.a(var1, var2);
               }

               var13 = 0.0D;
            }

            ux var15 = new ux(var4, var5, var7 + var13, var9);
            var4.d((pk)var15);
            var2.a(1);
            return var2;
         }
      });
      cn var0 = new cn() {
         private final cn b = new cn();

         public zx b(ck var1, zx var2) {
            yv var3 = (yv)var2.b();
            cj var4 = var1.d().a(agg.b(var1.f()));
            if (var3.a(var1.i(), var4)) {
               var2.a(zy.aw);
               var2.b = 1;
               return var2;
            } else {
               return this.b.a(var1, var2);
            }
         }
      };
      agg.N.a(zy.ay, var0);
      agg.N.a(zy.ax, var0);
      agg.N.a(zy.aw, new cn() {
         private final cn b = new cn();

         public zx b(ck var1, zx var2) {
            adm var3 = var1.i();
            cj var4 = var1.d().a(agg.b(var1.f()));
            alz var5 = var3.p(var4);
            afh var6 = var5.c();
            arm var7 = var6.t();
            zw var8;
            if (arm.h.equals(var7) && var6 instanceof ahv && (Integer)var5.b(ahv.b) == 0) {
               var8 = zy.ax;
            } else {
               if (!arm.i.equals(var7) || !(var6 instanceof ahv) || (Integer)var5.b(ahv.b) != 0) {
                  return super.b(var1, var2);
               }

               var8 = zy.ay;
            }

            var3.g(var4);
            if (--var2.b == 0) {
               var2.a(var8);
               var2.b = 1;
            } else if (((alc)var1.h()).a(new zx(var8)) < 0) {
               this.b.a(var1, new zx(var8));
            }

            return var2;
         }
      });
      agg.N.a(zy.d, new cn() {
         private boolean b = true;

         protected void a(ck var1) {
            if (this.b) {
               var1.i().b(1000, var1.d(), 0);
            } else {
               var1.i().b(1001, var1.d(), 0);
            }

         }

         protected zx b(ck var1, zx var2) {
            adm var3 = var1.i();
            cj var4 = var1.d().a(agg.b(var1.f()));
            if (var3.d(var4)) {
               var3.a(var4, afi.ab.Q());
               if (var2.a(1, (Random)var3.s)) {
                  var2.b = 0;
               }
            } else if (var3.p(var4).c() == afi.W) {
               afi.W.d(var3, var4, afi.W.Q().a(ake.a, true));
               var3.g(var4);
            } else {
               this.b = false;
            }

            return var2;
         }
      });
      agg.N.a(zy.aW, new cn() {
         private boolean b = true;

         protected zx b(ck var1, zx var2) {
            if (zd.a == zd.a(var2.i())) {
               adm var3 = var1.i();
               cj var4 = var1.d().a(agg.b(var1.f()));
               if (ze.a(var2, var3, var4)) {
                  if (!var3.D) {
                     var3.b(2005, var4, 0);
                  }
               } else {
                  this.b = false;
               }

               return var2;
            } else {
               return super.b(var1, var2);
            }
         }

         protected void a(ck var1) {
            if (this.b) {
               var1.i().b(1000, var1.d(), 0);
            } else {
               var1.i().b(1001, var1.d(), 0);
            }

         }
      });
      agg.N.a(zw.a(afi.W), new cn() {
         protected zx b(ck var1, zx var2) {
            adm var3 = var1.i();
            cj var4 = var1.d().a(agg.b(var1.f()));
            vj var5 = new vj(var3, (double)var4.n() + 0.5D, (double)var4.o(), (double)var4.p() + 0.5D, (pr)null);
            var3.d((pk)var5);
            var3.a((pk)var5, "game.tnt.primed", 1.0F, 1.0F);
            --var2.b;
            return var2;
         }
      });
      agg.N.a(zy.bX, new cn() {
         private boolean b = true;

         protected void a(ck var1) {
            if (this.b) {
               var1.i().b(1000, var1.d(), 0);
            } else {
               var1.i().b(1001, var1.d(), 0);
            }

         }

         protected zx b(ck var1, zx var2) {
            adm var3 = var1.i();
            cq var4 = agg.b(var1.f());
            cj var5 = var1.d().a(var4);
            ajm var6 = afi.ce;
            if (var3.d(var5) && var6.b(var3, var5, var2)) {
               if (!var3.D) {
                  var3.a((cj)var5, (alz)var6.Q().a(ajm.a, cq.b), 3);
                  akw var7 = var3.s(var5);
                  if (var7 instanceof alo) {
                     if (var2.i() == 3) {
                        GameProfile var8 = null;
                        if (var2.n()) {
                           dn var9 = var2.o();
                           if (var9.b("SkullOwner", 10)) {
                              var8 = dy.a(var9.m("SkullOwner"));
                           } else if (var9.b("SkullOwner", 8)) {
                              String var10 = var9.j("SkullOwner");
                              if (!nx.b(var10)) {
                                 var8 = new GameProfile((UUID)null, var10);
                              }
                           }
                        }

                        ((alo)var7).a(var8);
                     } else {
                        ((alo)var7).a(var2.i());
                     }

                     ((alo)var7).b(var4.d().b() * 4);
                     afi.ce.a(var3, var5, (alo)var7);
                  }

                  --var2.b;
               }
            } else {
               this.b = false;
            }

            return var2;
         }
      });
      agg.N.a(zw.a(afi.aU), new cn() {
         private boolean b = true;

         protected void a(ck var1) {
            if (this.b) {
               var1.i().b(1000, var1.d(), 0);
            } else {
               var1.i().b(1001, var1.d(), 0);
            }

         }

         protected zx b(ck var1, zx var2) {
            adm var3 = var1.i();
            cj var4 = var1.d().a(agg.b(var1.f()));
            aiv var5 = (aiv)afi.aU;
            if (var3.d(var4) && var5.e(var3, var4)) {
               if (!var3.D) {
                  var3.a((cj)var4, (alz)var5.Q(), 3);
               }

               --var2.b;
            } else {
               this.b = false;
            }

            return var2;
         }
      });
   }

   public static void a(String var0) {
      a.println(var0);
   }

   public static void c() {
      if (!b) {
         b = true;
         if (c.isDebugEnabled()) {
            d();
         }

         afh.S();
         agv.l();
         zw.t();
         na.a();
         b();
      }
   }
}
