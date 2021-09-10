import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class aai extends zw {
   private Map<Integer, List<pf>> a = Maps.newHashMap();
   private static final Map<List<pf>, Integer> b = Maps.newLinkedHashMap();

   public List<pf> e(int var1) {
      List var2 = (List)this.a.get(var1);
      if (var2 == null) {
         var2 = abe.b(var1, false);
         this.a.put(var1, var2);
      }

      return var2;
   }

   public aai() {
      this.c(1);
      this.a(true);
      this.d(0);
      this.a(yz.k);
   }

   public int d(zx var1) {
      return 32;
   }

   public List<pf> h(zx var1) {
      if (var1.n() && var1.o().b("CustomPotionEffects", 9)) {
         ArrayList var7 = Lists.newArrayList();
         du var3 = var1.o().c("CustomPotionEffects", 10);

         for(int var4 = 0; var4 < var3.c(); ++var4) {
            dn var5 = var3.b(var4);
            pf var6 = pf.b(var5);
            if (var6 != null) {
               var7.add(var6);
            }
         }

         return var7;
      } else {
         List var2 = (List)this.a.get(var1.i());
         if (var2 == null) {
            var2 = abe.b(var1.i(), false);
            this.a.put(var1.i(), var2);
         }

         return var2;
      }
   }

   public boolean f(zx var1) {
      List var2 = this.h(var1);
      return var2 != null && !var2.isEmpty();
   }

   public zx a(zx var1, adm var2, wn var3) {
      if (f(var1.i())) {
         if (!var3.bA.d) {
            --var1.b;
         }

         var2.a((pk)var3, "random.bow", 0.5F, 0.4F / (g.nextFloat() * 0.4F + 0.8F));
         if (!var2.D) {
            var2.d((pk)(new xc(var2, var3, var1)));
         }

         var3.b(na.ad[zw.b((zw)this)]);
         return var1;
      } else {
         var3.a(var1, this.d(var1));
         return var1;
      }
   }

   public boolean h(int var1) {
      List var2 = this.e(var1);
      if (var2 != null && !var2.isEmpty()) {
         Iterator var3 = var2.iterator();

         pf var4;
         do {
            if (!var3.hasNext()) {
               return false;
            }

            var4 = (pf)var3.next();
         } while(!pe.a[var4.a()].b());

         return true;
      } else {
         return false;
      }
   }

   public String a(zx var1) {
      if (var1.i() == 0) {
         return di.a("item.emptyPotion.name").trim();
      } else {
         String var2 = "";
         if (f(var1.i())) {
            var2 = di.a("potion.prefix.grenade").trim() + " ";
         }

         List var3 = zy.bz.h(var1);
         String var4;
         if (var3 != null && !var3.isEmpty()) {
            var4 = ((pf)var3.get(0)).g();
            var4 = var4 + ".postfix";
            return var2 + di.a(var4).trim();
         } else {
            var4 = abe.c(var1.i());
            return di.a(var4).trim() + " " + super.a(var1);
         }
      }
   }

   public aba e(zx var1) {
      return aba.c;
   }

   public zx b(zx var1, adm var2, wn var3) {
      if (!var3.bA.d) {
         --var1.b;
      }

      if (!var2.D) {
         List var4 = this.h(var1);
         if (var4 != null) {
            Iterator var5 = var4.iterator();

            while(var5.hasNext()) {
               pf var6 = (pf)var5.next();
               var3.c(new pf(var6));
            }
         }
      }

      var3.b(na.ad[zw.b((zw)this)]);
      if (!var3.bA.d) {
         if (var1.b <= 0) {
            return new zx(zy.bA);
         }

         var3.bi.a(new zx(zy.bA));
      }

      return var1;
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      super.a(var1, var2, var3);
      int var5;
      if (b.isEmpty()) {
         for(int var4 = 0; var4 <= 15; ++var4) {
            for(var5 = 0; var5 <= 1; ++var5) {
               int var6;
               if (var5 == 0) {
                  var6 = var4 | 8192;
               } else {
                  var6 = var4 | 16384;
               }

               for(int var7 = 0; var7 <= 2; ++var7) {
                  int var8 = var6;
                  if (var7 != 0) {
                     if (var7 == 1) {
                        var8 = var6 | 32;
                     } else if (var7 == 2) {
                        var8 = var6 | 64;
                     }
                  }

                  List var9 = abe.b(var8, false);
                  if (var9 != null && !var9.isEmpty()) {
                     b.put(var9, var8);
                  }
               }
            }
         }
      }

      Iterator var10 = b.values().iterator();

      while(var10.hasNext()) {
         var5 = (Integer)var10.next();
         var3.add(new zx(var1, 1, var5));
      }

   }

   public static boolean f(int var0) {
      return (var0 & 16384) != 0;
   }

   public void a(zx var1, wn var2, List<String> var3, boolean var4) {
      if (var1.i() != 0) {
         List var5 = zy.bz.h(var1);
         HashMultimap var6 = HashMultimap.create();
         Iterator var16;
         if (var5 != null && !var5.isEmpty()) {
            var16 = var5.iterator();

            while(var16.hasNext()) {
               pf var8 = (pf)var16.next();
               String var9 = di.a(var8.g()).trim();
               pe var10 = pe.a[var8.a()];
               Map var11 = var10.l();
               if (var11 != null && var11.size() > 0) {
                  Iterator var12 = var11.entrySet().iterator();

                  while(var12.hasNext()) {
                     Entry var13 = (Entry)var12.next();
                     qd var14 = (qd)var13.getValue();
                     qd var15 = new qd(var14.b(), var10.a(var8.c(), var14), var14.c());
                     var6.put(((qb)var13.getKey()).a(), var15);
                  }
               }

               if (var8.c() > 0) {
                  var9 = var9 + " " + di.a("potion.potency." + var8.c()).trim();
               }

               if (var8.b() > 20) {
                  var9 = var9 + " (" + pe.a(var8) + ")";
               }

               if (var10.g()) {
                  var3.add(.a.m + var9);
               } else {
                  var3.add(.a.h + var9);
               }
            }
         } else {
            String var7 = di.a("potion.empty").trim();
            var3.add(.a.h + var7);
         }

         if (!var6.isEmpty()) {
            var3.add("");
            var3.add(.a.f + di.a("potion.effects.whenDrank"));
            var16 = var6.entries().iterator();

            while(var16.hasNext()) {
               Entry var17 = (Entry)var16.next();
               qd var19 = (qd)var17.getValue();
               double var18 = var19.d();
               double var20;
               if (var19.c() != 1 && var19.c() != 2) {
                  var20 = var19.d();
               } else {
                  var20 = var19.d() * 100.0D;
               }

               if (var18 > 0.0D) {
                  var3.add(.a.j + di.a("attribute.modifier.plus." + var19.c(), zx.a.format(var20), di.a("attribute.name." + (String)var17.getKey())));
               } else if (var18 < 0.0D) {
                  var20 *= -1.0D;
                  var3.add(.a.m + di.a("attribute.modifier.take." + var19.c(), zx.a.format(var20), di.a("attribute.name." + (String)var17.getKey())));
               }
            }
         }

      }
   }

   public int g(int var1) {
      return abe.a(var1, false);
   }

   public int a(zx var1, int var2) {
      return var2 > 0 ? 16777215 : this.g(var1.i());
   }
}
