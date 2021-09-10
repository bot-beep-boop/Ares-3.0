import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public final class adt {
   private final Set<adg> b = Sets.newHashSet();
   private static final int a = (int)Math.pow(17.0D, 2.0D);

   public static boolean a(ps.a var0, adm var1, cj var2) {
      if (!var1.af().a(var2)) {
         return false;
      } else {
         afh var3 = var1.p(var2).c();
         if (var0 == ps.a.c) {
            return var3.t().d() && var1.p(var2.b()).c().t().d() && !var1.p(var2.a()).c().v();
         } else {
            cj var4 = var2.b();
            if (!adm.a((adq)var1, (cj)var4)) {
               return false;
            } else {
               afh var5 = var1.p(var4).c();
               boolean var6 = var5 != afi.h && var5 != afi.cv;
               return var6 && !var3.v() && !var3.t().d() && !var1.p(var2.a()).c().v();
            }
         }
      }
   }

   public static void a(adm var0, ady var1, int var2, int var3, int var4, int var5, Random var6) {
      List var7 = var1.a(pt.b);
      if (!var7.isEmpty()) {
         while(var6.nextFloat() < var1.g()) {
            ady.c var8 = (ady.c)oa.a(var0.s, var7);
            int var9 = var8.c + var6.nextInt(1 + var8.d - var8.c);
            pu var10 = null;
            int var11 = var2 + var6.nextInt(var4);
            int var12 = var3 + var6.nextInt(var5);
            int var13 = var11;
            int var14 = var12;

            for(int var15 = 0; var15 < var9; ++var15) {
               boolean var16 = false;

               for(int var17 = 0; !var16 && var17 < 4; ++var17) {
                  cj var18 = var0.r(new cj(var11, 0, var12));
                  if (a(ps.a.a, var0, var18)) {
                     ps var19;
                     try {
                        var19 = (ps)var8.b.getConstructor(adm.class).newInstance(var0);
                     } catch (Exception var21) {
                        var21.printStackTrace();
                        continue;
                     }

                     var19.b((double)((float)var11 + 0.5F), (double)var18.o(), (double)((float)var12 + 0.5F), var6.nextFloat() * 360.0F, 0.0F);
                     var0.d((pk)var19);
                     var10 = var19.a(var0.E(new cj(var19)), var10);
                     var16 = true;
                  }

                  var11 += var6.nextInt(5) - var6.nextInt(5);

                  for(var12 += var6.nextInt(5) - var6.nextInt(5); var11 < var2 || var11 >= var2 + var4 || var12 < var3 || var12 >= var3 + var4; var12 = var14 + var6.nextInt(5) - var6.nextInt(5)) {
                     var11 = var13 + var6.nextInt(5) - var6.nextInt(5);
                  }
               }
            }
         }

      }
   }

   public int a(le var1, boolean var2, boolean var3, boolean var4) {
      if (!var2 && !var3) {
         return 0;
      } else {
         this.b.clear();
         int var5 = 0;
         Iterator var6 = var1.j.iterator();

         while(true) {
            wn var7;
            int var9;
            int var12;
            do {
               if (!var6.hasNext()) {
                  int var36 = 0;
                  cj var37 = var1.M();
                  pt[] var38 = pt.values();
                  var9 = var38.length;

                  label197:
                  for(int var39 = 0; var39 < var9; ++var39) {
                     pt var40 = var38[var39];
                     if ((!var40.d() || var3) && (var40.d() || var2) && (!var40.e() || var4)) {
                        var12 = var1.a((Class)var40.a());
                        int var41 = var40.b() * var5 / a;
                        if (var12 <= var41) {
                           Iterator var42 = this.b.iterator();

                           label194:
                           while(true) {
                              int var17;
                              int var18;
                              int var19;
                              afh var20;
                              do {
                                 if (!var42.hasNext()) {
                                    continue label197;
                                 }

                                 adg var15 = (adg)var42.next();
                                 cj var16 = a(var1, var15.a, var15.b);
                                 var17 = var16.n();
                                 var18 = var16.o();
                                 var19 = var16.p();
                                 var20 = var1.p(var16).c();
                              } while(var20.v());

                              int var21 = 0;

                              for(int var22 = 0; var22 < 3; ++var22) {
                                 int var23 = var17;
                                 int var24 = var18;
                                 int var25 = var19;
                                 byte var26 = 6;
                                 ady.c var27 = null;
                                 pu var28 = null;

                                 for(int var29 = 0; var29 < 4; ++var29) {
                                    var23 += var1.s.nextInt(var26) - var1.s.nextInt(var26);
                                    var24 += var1.s.nextInt(1) - var1.s.nextInt(1);
                                    var25 += var1.s.nextInt(var26) - var1.s.nextInt(var26);
                                    cj var30 = new cj(var23, var24, var25);
                                    float var31 = (float)var23 + 0.5F;
                                    float var32 = (float)var25 + 0.5F;
                                    if (!var1.b((double)var31, (double)var24, (double)var32, 24.0D) && !(var37.c((double)var31, (double)var24, (double)var32) < 576.0D)) {
                                       if (var27 == null) {
                                          var27 = var1.a(var40, var30);
                                          if (var27 == null) {
                                             break;
                                          }
                                       }

                                       if (var1.a(var40, var27, var30) && a(pv.a(var27.b), var1, var30)) {
                                          ps var33;
                                          try {
                                             var33 = (ps)var27.b.getConstructor(adm.class).newInstance(var1);
                                          } catch (Exception var35) {
                                             var35.printStackTrace();
                                             return var36;
                                          }

                                          var33.b((double)var31, (double)var24, (double)var32, var1.s.nextFloat() * 360.0F, 0.0F);
                                          if (var33.bR() && var33.bS()) {
                                             var28 = var33.a(var1.E(new cj(var33)), var28);
                                             if (var33.bS()) {
                                                ++var21;
                                                var1.d(var33);
                                             }

                                             if (var21 >= var33.bV()) {
                                                continue label194;
                                             }
                                          }

                                          var36 += var21;
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }

                  return var36;
               }

               var7 = (wn)var6.next();
            } while(var7.v());

            int var8 = ns.c(var7.s / 16.0D);
            var9 = ns.c(var7.u / 16.0D);
            byte var10 = 8;

            for(int var11 = -var10; var11 <= var10; ++var11) {
               for(var12 = -var10; var12 <= var10; ++var12) {
                  boolean var13 = var11 == -var10 || var11 == var10 || var12 == -var10 || var12 == var10;
                  adg var14 = new adg(var11 + var8, var12 + var9);
                  if (!this.b.contains(var14)) {
                     ++var5;
                     if (!var13 && var1.af().a(var14)) {
                        this.b.add(var14);
                     }
                  }
               }
            }
         }
      }
   }

   protected static cj a(adm var0, int var1, int var2) {
      amy var3 = var0.a(var1, var2);
      int var4 = var1 * 16 + var0.s.nextInt(16);
      int var5 = var2 * 16 + var0.s.nextInt(16);
      int var6 = ns.c(var3.f(new cj(var4, 0, var5)) + 1, 16);
      int var7 = var0.s.nextInt(var6 > 0 ? var6 : var3.g() + 16 - 1);
      return new cj(var4, var7, var5);
   }
}
