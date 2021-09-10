import com.google.common.collect.HashMultiset;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multisets;
import java.util.List;

public class aab extends yy {
   public static atg a(int var0, adm var1) {
      String var2 = "map_" + var0;
      atg var3 = (atg)var1.a(atg.class, var2);
      if (var3 == null) {
         var3 = new atg(var2);
         var1.a((String)var2, (ate)var3);
      }

      return var3;
   }

   protected aab() {
      this.a(true);
   }

   public void a(zx var1, wn var2, List<String> var3, boolean var4) {
      atg var5 = this.a(var1, var2.o);
      if (var4) {
         if (var5 == null) {
            var3.add("Unknown map");
         } else {
            var3.add("Scaling at 1:" + (1 << var5.e));
            var3.add("(Level " + var5.e + "/" + 4 + ")");
         }
      }

   }

   public atg a(zx var1, adm var2) {
      String var3 = "map_" + var1.i();
      atg var4 = (atg)var2.a(atg.class, var3);
      if (var4 == null && !var2.D) {
         var1.b(var2.b("map"));
         var3 = "map_" + var1.i();
         var4 = new atg(var3);
         var4.e = 3;
         var4.a((double)var2.P().c(), (double)var2.P().e(), var4.e);
         var4.d = (byte)var2.t.q();
         var4.c();
         var2.a((String)var3, (ate)var4);
      }

      return var4;
   }

   public ff c(zx var1, adm var2, wn var3) {
      return this.a(var1, var2).a(var1, var2, var3);
   }

   public void d(zx var1, adm var2, wn var3) {
      if (var1.n() && var1.o().n("map_is_scaling")) {
         atg var4 = zy.bd.a(var1, var2);
         var1.b(var2.b("map"));
         atg var5 = new atg("map_" + var1.i());
         var5.e = (byte)(var4.e + 1);
         if (var5.e > 4) {
            var5.e = 4;
         }

         var5.a((double)var4.b, (double)var4.c, var5.e);
         var5.d = var4.d;
         var5.c();
         var2.a((String)("map_" + var1.i()), (ate)var5);
      }

   }

   public void a(adm var1, pk var2, atg var3) {
      if (var1.t.q() == var3.d && var2 instanceof wn) {
         int var4 = 1 << var3.e;
         int var5 = var3.b;
         int var6 = var3.c;
         int var7 = ns.c(var2.s - (double)var5) / var4 + 64;
         int var8 = ns.c(var2.u - (double)var6) / var4 + 64;
         int var9 = 128 / var4;
         if (var1.t.o()) {
            var9 /= 2;
         }

         atg.a var10 = var3.a((wn)var2);
         ++var10.b;
         boolean var11 = false;

         for(int var12 = var7 - var9 + 1; var12 < var7 + var9; ++var12) {
            if ((var12 & 15) == (var10.b & 15) || var11) {
               var11 = false;
               double var13 = 0.0D;

               for(int var15 = var8 - var9 - 1; var15 < var8 + var9; ++var15) {
                  if (var12 >= 0 && var15 >= -1 && var12 < 128 && var15 < 128) {
                     int var16 = var12 - var7;
                     int var17 = var15 - var8;
                     boolean var18 = var16 * var16 + var17 * var17 > (var9 - 2) * (var9 - 2);
                     int var19 = (var5 / var4 + var12 - 64) * var4;
                     int var20 = (var6 / var4 + var15 - 64) * var4;
                     HashMultiset var21 = HashMultiset.create();
                     amy var22 = var1.f(new cj(var19, 0, var20));
                     if (!var22.f()) {
                        int var23 = var19 & 15;
                        int var24 = var20 & 15;
                        int var25 = 0;
                        double var26 = 0.0D;
                        if (var1.t.o()) {
                           int var28 = var19 + var20 * 231871;
                           var28 = var28 * var28 * 31287121 + var28 * 11;
                           if ((var28 >> 20 & 1) == 0) {
                              var21.add(afi.d.g(afi.d.Q().a(agf.a, agf.a.a)), 10);
                           } else {
                              var21.add(afi.b.g(afi.b.Q().a(ajy.a, ajy.a.a)), 100);
                           }

                           var26 = 100.0D;
                        } else {
                           cj.a var35 = new cj.a();

                           for(int var29 = 0; var29 < var4; ++var29) {
                              for(int var30 = 0; var30 < var4; ++var30) {
                                 int var31 = var22.b(var29 + var23, var30 + var24) + 1;
                                 alz var32 = afi.a.Q();
                                 if (var31 > 1) {
                                    do {
                                       --var31;
                                       var32 = var22.g(var35.c(var29 + var23, var31, var30 + var24));
                                    } while(var32.c().g(var32) == arn.b && var31 > 0);

                                    if (var31 > 0 && var32.c().t().d()) {
                                       int var33 = var31 - 1;

                                       afh var34;
                                       do {
                                          var34 = var22.a(var29 + var23, var33--, var30 + var24);
                                          ++var25;
                                       } while(var33 > 0 && var34.t().d());
                                    }
                                 }

                                 var26 += (double)var31 / (double)(var4 * var4);
                                 var21.add(var32.c().g(var32));
                              }
                           }
                        }

                        var25 /= var4 * var4;
                        double var36 = (var26 - var13) * 4.0D / (double)(var4 + 4) + ((double)(var12 + var15 & 1) - 0.5D) * 0.4D;
                        byte var37 = 1;
                        if (var36 > 0.6D) {
                           var37 = 2;
                        }

                        if (var36 < -0.6D) {
                           var37 = 0;
                        }

                        arn var38 = (arn)Iterables.getFirst(Multisets.copyHighestCountFirst(var21), arn.b);
                        if (var38 == arn.n) {
                           var36 = (double)var25 * 0.1D + (double)(var12 + var15 & 1) * 0.2D;
                           var37 = 1;
                           if (var36 < 0.5D) {
                              var37 = 2;
                           }

                           if (var36 > 0.9D) {
                              var37 = 0;
                           }
                        }

                        var13 = var26;
                        if (var15 >= 0 && var16 * var16 + var17 * var17 < var9 * var9 && (!var18 || (var12 + var15 & 1) != 0)) {
                           byte var39 = var3.f[var12 + var15 * 128];
                           byte var40 = (byte)(var38.M * 4 + var37);
                           if (var39 != var40) {
                              var3.f[var12 + var15 * 128] = var40;
                              var3.a(var12, var15);
                              var11 = true;
                           }
                        }
                     }
                  }
               }
            }
         }

      }
   }

   public void a(zx var1, adm var2, pk var3, int var4, boolean var5) {
      if (!var2.D) {
         atg var6 = this.a(var1, var2);
         if (var3 instanceof wn) {
            wn var7 = (wn)var3;
            var6.a(var7, var1);
         }

         if (var5) {
            this.a(var2, var3, var6);
         }

      }
   }
}
