import java.util.Iterator;
import java.util.List;

public class aax extends zw {
   public zx a(zx var1, adm var2, wn var3) {
      if (var2.D) {
         return var1;
      } else {
         auh var4 = this.a(var2, var3, true);
         if (var4 == null) {
            return var1;
         } else {
            if (var4.a == auh.a.b) {
               cj var5 = var4.a();
               if (!var2.a(var3, var5)) {
                  return var1;
               }

               if (!var3.a(var5, var4.b, var1)) {
                  return var1;
               }

               if (var2.p(var5).c() instanceof ahv) {
                  pk var6 = a(var2, var1.i(), (double)var5.n() + 0.5D, (double)var5.o() + 0.5D, (double)var5.p() + 0.5D);
                  if (var6 != null) {
                     if (var6 instanceof pr && var1.s()) {
                        ((ps)var6).a((String)var1.q());
                     }

                     if (!var3.bA.d) {
                        --var1.b;
                     }

                     var3.b(na.ad[zw.b((zw)this)]);
                  }
               }
            }

            return var1;
         }
      }
   }

   public boolean a(zx var1, wn var2, adm var3, cj var4, cq var5, float var6, float var7, float var8) {
      if (var3.D) {
         return true;
      } else if (!var2.a(var4.a(var5), var5, var1)) {
         return false;
      } else {
         alz var9 = var3.p(var4);
         if (var9.c() == afi.ac) {
            akw var10 = var3.s(var4);
            if (var10 instanceof all) {
               add var11 = ((all)var10).b();
               var11.a(pm.b(var1.i()));
               var10.p_();
               var3.h(var4);
               if (!var2.bA.d) {
                  --var1.b;
               }

               return true;
            }
         }

         var4 = var4.a(var5);
         double var13 = 0.0D;
         if (var5 == cq.b && var9 instanceof agt) {
            var13 = 0.5D;
         }

         pk var12 = a(var3, var1.i(), (double)var4.n() + 0.5D, (double)var4.o() + var13, (double)var4.p() + 0.5D);
         if (var12 != null) {
            if (var12 instanceof pr && var1.s()) {
               var12.a(var1.q());
            }

            if (!var2.bA.d) {
               --var1.b;
            }
         }

         return true;
      }
   }

   public static pk a(adm var0, int var1, double var2, double var4, double var6) {
      if (!pm.a.containsKey(var1)) {
         return null;
      } else {
         pk var8 = null;

         for(int var9 = 0; var9 < 1; ++var9) {
            var8 = pm.a(var1, var0);
            if (var8 instanceof pr) {
               ps var10 = (ps)var8;
               var8.b(var2, var4, var6, ns.g(var0.s.nextFloat() * 360.0F), 0.0F);
               var10.aK = var10.y;
               var10.aI = var10.y;
               var10.a(var0.E(new cj(var10)), (pu)null);
               var0.d(var8);
               var10.x();
            }
         }

         return var8;
      }
   }

   public String a(zx var1) {
      String var2 = ("" + di.a(this.a() + ".name")).trim();
      String var3 = pm.b(var1.i());
      if (var3 != null) {
         var2 = var2 + " " + di.a("entity." + var3 + ".name");
      }

      return var2;
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      Iterator var4 = pm.a.values().iterator();

      while(var4.hasNext()) {
         pm.a var5 = (pm.a)var4.next();
         var3.add(new zx(var1, 1, var5.a));
      }

   }

   public aax() {
      this.a(true);
      this.a(yz.f);
   }

   public int a(zx var1, int var2) {
      pm.a var3 = (pm.a)pm.a.get(var1.i());
      if (var3 != null) {
         return var2 == 0 ? var3.b : var3.c;
      } else {
         return 16777215;
      }
   }
}
