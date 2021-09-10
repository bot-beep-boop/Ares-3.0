import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

public class aqo extends aqq {
   private boolean f;
   private int i;
   private List<ady> d;
   private adg[] g;
   private double h;

   protected boolean a(int var1, int var2) {
      if (!this.f) {
         Random var3 = new Random();
         var3.setSeed(this.c.J());
         double var4 = var3.nextDouble() * 3.141592653589793D * 2.0D;
         int var6 = 1;

         for(int var7 = 0; var7 < this.g.length; ++var7) {
            double var8 = (1.25D * (double)var6 + var3.nextDouble()) * this.h * (double)var6;
            int var10 = (int)Math.round(Math.cos(var4) * var8);
            int var11 = (int)Math.round(Math.sin(var4) * var8);
            cj var12 = this.c.v().a((var10 << 4) + 8, (var11 << 4) + 8, 112, this.d, var3);
            if (var12 != null) {
               var10 = var12.n() >> 4;
               var11 = var12.p() >> 4;
            }

            this.g[var7] = new adg(var10, var11);
            var4 += 6.283185307179586D * (double)var6 / (double)this.i;
            if (var7 == this.i) {
               var6 += 2 + var3.nextInt(5);
               this.i += 1 + var3.nextInt(2);
            }
         }

         this.f = true;
      }

      adg[] var13 = this.g;
      int var14 = var13.length;

      for(int var5 = 0; var5 < var14; ++var5) {
         adg var15 = var13[var5];
         if (var1 == var15.a && var2 == var15.b) {
            return true;
         }
      }

      return false;
   }

   public aqo() {
      this.g = new adg[3];
      this.h = 32.0D;
      this.i = 3;
      this.d = Lists.newArrayList();
      ady[] var1 = ady.n();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         ady var4 = var1[var3];
         if (var4 != null && var4.an > 0.0F) {
            this.d.add(var4);
         }
      }

   }

   public aqo(Map<String, String> var1) {
      this();
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if (((String)var3.getKey()).equals("distance")) {
            this.h = ns.a((String)var3.getValue(), this.h, 1.0D);
         } else if (((String)var3.getKey()).equals("count")) {
            this.g = new adg[ns.a((String)((String)var3.getValue()), this.g.length, 1)];
         } else if (((String)var3.getKey()).equals("spread")) {
            this.i = ns.a((String)((String)var3.getValue()), this.i, 1);
         }
      }

   }

   protected aqu b(int var1, int var2) {
      aqo.a var3;
      for(var3 = new aqo.a(this.c, this.b, var1, var2); var3.b().isEmpty() || ((aqp.m)var3.b().get(0)).b == null; var3 = new aqo.a(this.c, this.b, var1, var2)) {
      }

      return var3;
   }

   public String a() {
      return "Stronghold";
   }

   protected List<cj> z_() {
      ArrayList var1 = Lists.newArrayList();
      adg[] var2 = this.g;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         adg var5 = var2[var4];
         if (var5 != null) {
            var1.add(var5.a(64));
         }
      }

      return var1;
   }

   public static class a extends aqu {
      public a() {
      }

      public a(adm var1, Random var2, int var3, int var4) {
         super(var3, var4);
         aqp.b();
         aqp.m var5 = new aqp.m(0, var2, (var3 << 4) + 2, (var4 << 4) + 2);
         this.a.add(var5);
         var5.a(var5, this.a, var2);
         List var6 = var5.c;

         while(!var6.isEmpty()) {
            int var7 = var2.nextInt(var6.size());
            aqt var8 = (aqt)var6.remove(var7);
            var8.a((aqt)var5, (List)this.a, (Random)var2);
         }

         this.c();
         this.a(var1, var2, 10);
      }
   }
}
