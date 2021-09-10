import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

public class aqm extends aqq {
   private List<ady.c> f;
   private int g;
   private static final List<ady> d;
   private int h;

   protected boolean a(int var1, int var2) {
      int var3 = var1;
      int var4 = var2;
      if (var1 < 0) {
         var1 -= this.g - 1;
      }

      if (var2 < 0) {
         var2 -= this.g - 1;
      }

      int var5 = var1 / this.g;
      int var6 = var2 / this.g;
      Random var7 = this.c.a(var5, var6, 14357617);
      var5 *= this.g;
      var6 *= this.g;
      var5 += var7.nextInt(this.g - this.h);
      var6 += var7.nextInt(this.g - this.h);
      if (var3 == var5 && var4 == var6) {
         ady var8 = this.c.v().a(new cj(var3 * 16 + 8, 0, var4 * 16 + 8));
         if (var8 == null) {
            return false;
         }

         Iterator var9 = d.iterator();

         while(var9.hasNext()) {
            ady var10 = (ady)var9.next();
            if (var8 == var10) {
               return true;
            }
         }
      }

      return false;
   }

   public aqm() {
      this.f = Lists.newArrayList();
      this.g = 32;
      this.h = 8;
      this.f.add(new ady.c(wd.class, 1, 1, 1));
   }

   public String a() {
      return "Temple";
   }

   protected aqu b(int var1, int var2) {
      return new aqm.a(this.c, this.b, var1, var2);
   }

   public List<ady.c> b() {
      return this.f;
   }

   public boolean a(cj var1) {
      aqu var2 = this.c(var1);
      if (var2 != null && var2 instanceof aqm.a && !var2.a.isEmpty()) {
         aqt var3 = (aqt)var2.a.getFirst();
         return var3 instanceof aqn.d;
      } else {
         return false;
      }
   }

   static {
      d = Arrays.asList(ady.r, ady.G, ady.K, ady.L, ady.v);
   }

   public aqm(Map<String, String> var1) {
      this();
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if (((String)var3.getKey()).equals("distance")) {
            this.g = ns.a((String)var3.getValue(), this.g, this.h + 1);
         }
      }

   }

   public static class a extends aqu {
      public a() {
      }

      public a(adm var1, Random var2, int var3, int var4) {
         super(var3, var4);
         ady var5 = var1.b(new cj(var3 * 16 + 8, 0, var4 * 16 + 8));
         if (var5 != ady.K && var5 != ady.L) {
            if (var5 == ady.v) {
               aqn.d var7 = new aqn.d(var2, var3 * 16, var4 * 16);
               this.a.add(var7);
            } else if (var5 == ady.r || var5 == ady.G) {
               aqn.a var8 = new aqn.a(var2, var3 * 16, var4 * 16);
               this.a.add(var8);
            }
         } else {
            aqn.b var6 = new aqn.b(var2, var3 * 16, var4 * 16);
            this.a.add(var6);
         }

         this.c();
      }
   }
}
