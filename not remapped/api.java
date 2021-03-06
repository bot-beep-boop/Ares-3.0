import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class api extends aot {
   private static final String[] b = new String[]{"Skeleton", "Zombie", "Zombie", "Spider"};
   private static final Logger a = LogManager.getLogger();
   private static final List<ob> c;

   public boolean b(adm var1, Random var2, cj var3) {
      boolean var4 = true;
      int var5 = var2.nextInt(2) + 2;
      int var6 = -var5 - 1;
      int var7 = var5 + 1;
      boolean var8 = true;
      boolean var9 = true;
      int var10 = var2.nextInt(2) + 2;
      int var11 = -var10 - 1;
      int var12 = var10 + 1;
      int var13 = 0;

      int var14;
      int var15;
      int var16;
      cj var17;
      for(var14 = var6; var14 <= var7; ++var14) {
         for(var15 = -1; var15 <= 4; ++var15) {
            for(var16 = var11; var16 <= var12; ++var16) {
               var17 = var3.a(var14, var15, var16);
               arm var18 = var1.p(var17).c().t();
               boolean var19 = var18.a();
               if (var15 == -1 && !var19) {
                  return false;
               }

               if (var15 == 4 && !var19) {
                  return false;
               }

               if ((var14 == var6 || var14 == var7 || var16 == var11 || var16 == var12) && var15 == 0 && var1.d(var17) && var1.d(var17.a())) {
                  ++var13;
               }
            }
         }
      }

      if (var13 >= 1 && var13 <= 5) {
         for(var14 = var6; var14 <= var7; ++var14) {
            for(var15 = 3; var15 >= -1; --var15) {
               for(var16 = var11; var16 <= var12; ++var16) {
                  var17 = var3.a(var14, var15, var16);
                  if (var14 != var6 && var15 != -1 && var16 != var11 && var14 != var7 && var15 != 4 && var16 != var12) {
                     if (var1.p(var17).c() != afi.ae) {
                        var1.g(var17);
                     }
                  } else if (var17.o() >= 0 && !var1.p(var17.b()).c().t().a()) {
                     var1.g(var17);
                  } else if (var1.p(var17).c().t().a() && var1.p(var17).c() != afi.ae) {
                     if (var15 == -1 && var2.nextInt(4) != 0) {
                        var1.a((cj)var17, (alz)afi.Y.Q(), 2);
                     } else {
                        var1.a((cj)var17, (alz)afi.e.Q(), 2);
                     }
                  }
               }
            }
         }

         for(var14 = 0; var14 < 2; ++var14) {
            for(var15 = 0; var15 < 3; ++var15) {
               var16 = var3.n() + var2.nextInt(var5 * 2 + 1) - var5;
               int var24 = var3.o();
               int var25 = var3.p() + var2.nextInt(var10 * 2 + 1) - var10;
               cj var26 = new cj(var16, var24, var25);
               if (var1.d(var26)) {
                  int var20 = 0;
                  Iterator var21 = cq.c.a.iterator();

                  while(var21.hasNext()) {
                     cq var22 = (cq)var21.next();
                     if (var1.p(var26.a(var22)).c().t().a()) {
                        ++var20;
                     }
                  }

                  if (var20 == 1) {
                     var1.a((cj)var26, (alz)afi.ae.f(var1, var26, afi.ae.Q()), 2);
                     List var27 = ob.a(c, zy.cd.b(var2));
                     akw var28 = var1.s(var26);
                     if (var28 instanceof aky) {
                        ob.a(var2, var27, (og)((aky)var28), 8);
                     }
                     break;
                  }
               }
            }
         }

         var1.a((cj)var3, (alz)afi.ac.Q(), 2);
         akw var23 = var1.s(var3);
         if (var23 instanceof all) {
            ((all)var23).b().a(this.a(var2));
         } else {
            a.error("Failed to fetch mob spawner entity at (" + var3.n() + ", " + var3.o() + ", " + var3.p() + ")");
         }

         return true;
      } else {
         return false;
      }
   }

   static {
      c = Lists.newArrayList(new ob[]{new ob(zy.aA, 0, 1, 1, 10), new ob(zy.j, 0, 1, 4, 10), new ob(zy.P, 0, 1, 1, 10), new ob(zy.O, 0, 1, 4, 10), new ob(zy.H, 0, 1, 4, 10), new ob(zy.F, 0, 1, 4, 10), new ob(zy.aw, 0, 1, 1, 10), new ob(zy.ao, 0, 1, 1, 1), new ob(zy.aC, 0, 1, 4, 10), new ob(zy.cq, 0, 1, 1, 4), new ob(zy.cr, 0, 1, 1, 4), new ob(zy.co, 0, 1, 1, 10), new ob(zy.cl, 0, 1, 1, 2), new ob(zy.ck, 0, 1, 1, 5), new ob(zy.cm, 0, 1, 1, 1)});
   }

   private String a(Random var1) {
      return b[var1.nextInt(b.length)];
   }
}
