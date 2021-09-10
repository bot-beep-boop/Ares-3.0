import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.server.MinecraftServer;

public class bj extends i {
   public List<String> a(m var1, String[] var2, cj var3) {
      return var2.length >= 1 && var2.length <= 2 ? b(var2, 0, var3) : null;
   }

   public String c() {
      return "spreadplayers";
   }

   private bj.a[] a(Random var1, int var2, double var3, double var5, double var7, double var9) {
      bj.a[] var11 = new bj.a[var2];

      for(int var12 = 0; var12 < var11.length; ++var12) {
         bj.a var13 = new bj.a();
         var13.a(var1, var3, var5, var7, var9);
         var11[var12] = var13;
      }

      return var11;
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length < 6) {
         throw new cf("commands.spreadplayers.usage", new Object[0]);
      } else {
         byte var3 = 0;
         cj var4 = var1.c();
         double var10000 = (double)var4.n();
         int var17 = var3 + 1;
         double var5 = b(var10000, var2[var3], true);
         double var7 = b((double)var4.p(), var2[var17++], true);
         double var9 = a(var2[var17++], 0.0D);
         double var11 = a(var2[var17++], var9 + 1.0D);
         boolean var13 = d(var2[var17++]);
         ArrayList var14 = Lists.newArrayList();

         while(var17 < var2.length) {
            String var15 = var2[var17++];
            if (o.b(var15)) {
               List var16 = o.b(var1, var15, pk.class);
               if (var16.size() == 0) {
                  throw new ca();
               }

               var14.addAll(var16);
            } else {
               lf var18 = MinecraftServer.N().ap().a(var15);
               if (var18 == null) {
                  throw new cd();
               }

               var14.add(var18);
            }
         }

         var1.a(n.a.c, var14.size());
         if (var14.isEmpty()) {
            throw new ca();
         } else {
            var1.a(new fb("commands.spreadplayers.spreading." + (var13 ? "teams" : "players"), new Object[]{var14.size(), var11, var5, var7, var9}));
            this.a(var1, var14, new bj.a(var5, var7), var9, var11, ((pk)var14.get(0)).o, var13);
         }
      }
   }

   private int a(bj.a var1, double var2, adm var4, Random var5, double var6, double var8, double var10, double var12, bj.a[] var14, boolean var15) throws bz {
      boolean var16 = true;
      double var18 = 3.4028234663852886E38D;

      int var17;
      for(var17 = 0; var17 < 10000 && var16; ++var17) {
         var16 = false;
         var18 = 3.4028234663852886E38D;

         int var22;
         bj.a var23;
         for(int var20 = 0; var20 < var14.length; ++var20) {
            bj.a var21 = var14[var20];
            var22 = 0;
            var23 = new bj.a();

            for(int var24 = 0; var24 < var14.length; ++var24) {
               if (var20 != var24) {
                  bj.a var25 = var14[var24];
                  double var26 = var21.a(var25);
                  var18 = Math.min(var26, var18);
                  if (var26 < var2) {
                     ++var22;
                     var23.a += var25.a - var21.a;
                     var23.b += var25.b - var21.b;
                  }
               }
            }

            if (var22 > 0) {
               var23.a /= (double)var22;
               var23.b /= (double)var22;
               double var30 = (double)var23.b();
               if (var30 > 0.0D) {
                  var23.a();
                  var21.b(var23);
               } else {
                  var21.a(var5, var6, var8, var10, var12);
               }

               var16 = true;
            }

            if (var21.a(var6, var8, var10, var12)) {
               var16 = true;
            }
         }

         if (!var16) {
            bj.a[] var28 = var14;
            int var29 = var14.length;

            for(var22 = 0; var22 < var29; ++var22) {
               var23 = var28[var22];
               if (!var23.b(var4)) {
                  var23.a(var5, var6, var8, var10, var12);
                  var16 = true;
               }
            }
         }
      }

      if (var17 >= 10000) {
         throw new bz("commands.spreadplayers.failure." + (var15 ? "teams" : "players"), new Object[]{var14.length, var1.a, var1.b, String.format("%.2f", var18)});
      } else {
         return var17;
      }
   }

   public int a() {
      return 2;
   }

   private int b(List<pk> var1) {
      HashSet var2 = Sets.newHashSet();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         pk var4 = (pk)var3.next();
         if (var4 instanceof wn) {
            var2.add(((wn)var4).bO());
         } else {
            var2.add((Object)null);
         }
      }

      return var2.size();
   }

   private double a(List<pk> var1, adm var2, bj.a[] var3, boolean var4) {
      double var5 = 0.0D;
      int var7 = 0;
      HashMap var8 = Maps.newHashMap();

      for(int var9 = 0; var9 < var1.size(); ++var9) {
         pk var10 = (pk)var1.get(var9);
         bj.a var11;
         if (var4) {
            auq var12 = var10 instanceof wn ? ((wn)var10).bO() : null;
            if (!var8.containsKey(var12)) {
               var8.put(var12, var3[var7++]);
            }

            var11 = (bj.a)var8.get(var12);
         } else {
            var11 = var3[var7++];
         }

         var10.a((double)((float)ns.c(var11.a) + 0.5F), (double)var11.a(var2), (double)ns.c(var11.b) + 0.5D);
         double var17 = Double.MAX_VALUE;

         for(int var14 = 0; var14 < var3.length; ++var14) {
            if (var11 != var3[var14]) {
               double var15 = var11.a(var3[var14]);
               var17 = Math.min(var15, var17);
            }
         }

         var5 += var17;
      }

      var5 /= (double)var1.size();
      return var5;
   }

   public String c(m var1) {
      return "commands.spreadplayers.usage";
   }

   private void a(m var1, List<pk> var2, bj.a var3, double var4, double var6, adm var8, boolean var9) throws bz {
      Random var10 = new Random();
      double var11 = var3.a - var6;
      double var13 = var3.b - var6;
      double var15 = var3.a + var6;
      double var17 = var3.b + var6;
      bj.a[] var19 = this.a(var10, var9 ? this.b(var2) : var2.size(), var11, var13, var15, var17);
      int var20 = this.a(var3, var4, var8, var10, var11, var13, var15, var17, var19, var9);
      double var21 = this.a(var2, var8, var19, var9);
      a(var1, this, "commands.spreadplayers.success." + (var9 ? "teams" : "players"), new Object[]{var19.length, var3.a, var3.b});
      if (var19.length > 1) {
         var1.a(new fb("commands.spreadplayers.info." + (var9 ? "teams" : "players"), new Object[]{String.format("%.2f", var21), var20}));
      }

   }

   static class a {
      double a;
      double b;

      public boolean b(adm var1) {
         cj var2 = new cj(this.a, 256.0D, this.b);

         arm var3;
         do {
            if (var2.o() <= 0) {
               return false;
            }

            var2 = var2.b();
            var3 = var1.p(var2).c().t();
         } while(var3 == arm.a);

         return !var3.d() && var3 != arm.o;
      }

      public void a(Random var1, double var2, double var4, double var6, double var8) {
         this.a = ns.a(var1, var2, var6);
         this.b = ns.a(var1, var4, var8);
      }

      void a() {
         double var1 = (double)this.b();
         this.a /= var1;
         this.b /= var1;
      }

      public int a(adm var1) {
         cj var2 = new cj(this.a, 256.0D, this.b);

         do {
            if (var2.o() <= 0) {
               return 257;
            }

            var2 = var2.b();
         } while(var1.p(var2).c().t() == arm.a);

         return var2.o() + 1;
      }

      a(double var1, double var3) {
         this.a = var1;
         this.b = var3;
      }

      a() {
      }

      public boolean a(double var1, double var3, double var5, double var7) {
         boolean var9 = false;
         if (this.a < var1) {
            this.a = var1;
            var9 = true;
         } else if (this.a > var5) {
            this.a = var5;
            var9 = true;
         }

         if (this.b < var3) {
            this.b = var3;
            var9 = true;
         } else if (this.b > var7) {
            this.b = var7;
            var9 = true;
         }

         return var9;
      }

      public void b(bj.a var1) {
         this.a -= var1.a;
         this.b -= var1.b;
      }

      double a(bj.a var1) {
         double var2 = this.a - var1.a;
         double var4 = this.b - var1.b;
         return Math.sqrt(var2 * var2 + var4 * var4);
      }

      float b() {
         return ns.a(this.a * this.a + this.b * this.b);
      }
   }
}
