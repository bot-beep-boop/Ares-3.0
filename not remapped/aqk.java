import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Map.Entry;

public class aqk extends aqq {
   private int f;
   private static final List<ady.c> h;
   public static final List<ady> d;
   private int g;

   static {
      d = Arrays.asList(ady.p, ady.N, ady.w, ady.z, ady.A);
      h = Lists.newArrayList();
      h.add(new ady.c(vt.class, 1, 2, 4));
   }

   public aqk() {
      this.f = 32;
      this.g = 5;
   }

   public String a() {
      return "Monument";
   }

   public List<ady.c> b() {
      return h;
   }

   protected aqu b(int var1, int var2) {
      return new aqk.a(this.c, this.b, var1, var2);
   }

   protected boolean a(int var1, int var2) {
      int var3 = var1;
      int var4 = var2;
      if (var1 < 0) {
         var1 -= this.f - 1;
      }

      if (var2 < 0) {
         var2 -= this.f - 1;
      }

      int var5 = var1 / this.f;
      int var6 = var2 / this.f;
      Random var7 = this.c.a(var5, var6, 10387313);
      var5 *= this.f;
      var6 *= this.f;
      var5 += (var7.nextInt(this.f - this.g) + var7.nextInt(this.f - this.g)) / 2;
      var6 += (var7.nextInt(this.f - this.g) + var7.nextInt(this.f - this.g)) / 2;
      if (var3 == var5 && var4 == var6) {
         if (this.c.v().a(new cj(var3 * 16 + 8, 64, var4 * 16 + 8), (ady)null) != ady.N) {
            return false;
         }

         boolean var8 = this.c.v().a(var3 * 16 + 8, var4 * 16 + 8, 29, d);
         if (var8) {
            return true;
         }
      }

      return false;
   }

   public aqk(Map<String, String> var1) {
      this();
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if (((String)var3.getKey()).equals("spacing")) {
            this.f = ns.a((String)((String)var3.getValue()), this.f, 1);
         } else if (((String)var3.getKey()).equals("separation")) {
            this.g = ns.a((String)((String)var3.getValue()), this.g, 1);
         }
      }

   }

   public static class a extends aqu {
      private boolean d;
      private Set<adg> c = Sets.newHashSet();

      public boolean a(adg var1) {
         return this.c.contains(var1) ? false : super.a(var1);
      }

      public void a(dn var1) {
         super.a(var1);
         du var2 = new du();
         Iterator var3 = this.c.iterator();

         while(var3.hasNext()) {
            adg var4 = (adg)var3.next();
            dn var5 = new dn();
            var5.a("X", var4.a);
            var5.a("Z", var4.b);
            var2.a((eb)var5);
         }

         var1.a((String)"Processed", (eb)var2);
      }

      public void b(adg var1) {
         super.b(var1);
         this.c.add(var1);
      }

      private void b(adm var1, Random var2, int var3, int var4) {
         var2.setSeed(var1.J());
         long var5 = var2.nextLong();
         long var7 = var2.nextLong();
         long var9 = (long)var3 * var5;
         long var11 = (long)var4 * var7;
         var2.setSeed(var9 ^ var11 ^ var1.J());
         int var13 = var3 * 16 + 8 - 29;
         int var14 = var4 * 16 + 8 - 29;
         cq var15 = cq.c.a.a(var2);
         this.a.add(new aql.h(var2, var13, var14, var15));
         this.c();
         this.d = true;
      }

      public a(adm var1, Random var2, int var3, int var4) {
         super(var3, var4);
         this.b(var1, var2, var3, var4);
      }

      public void a(adm var1, Random var2, aqe var3) {
         if (!this.d) {
            this.a.clear();
            this.b(var1, var2, this.e(), this.f());
         }

         super.a(var1, var2, var3);
      }

      public void b(dn var1) {
         super.b(var1);
         if (var1.b("Processed", 9)) {
            du var2 = var1.c("Processed", 10);

            for(int var3 = 0; var3 < var2.c(); ++var3) {
               dn var4 = var2.b(var3);
               this.c.add(new adg(var4.f("X"), var4.f("Z")));
            }
         }

      }

      public a() {
      }
   }
}
