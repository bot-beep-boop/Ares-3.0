import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

public class aqv extends aqq {
   private int f;
   private int g;
   public static final List<ady> d;
   private int h;

   public aqv() {
      this.g = 32;
      this.h = 8;
   }

   static {
      d = Arrays.asList(ady.q, ady.r, ady.Y);
   }

   protected aqu b(int var1, int var2) {
      return new aqv.a(this.c, this.b, var1, var2, this.f);
   }

   public aqv(Map<String, String> var1) {
      this();
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if (((String)var3.getKey()).equals("size")) {
            this.f = ns.a((String)((String)var3.getValue()), this.f, 0);
         } else if (((String)var3.getKey()).equals("distance")) {
            this.g = ns.a((String)var3.getValue(), this.g, this.h + 1);
         }
      }

   }

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
      Random var7 = this.c.a(var5, var6, 10387312);
      var5 *= this.g;
      var6 *= this.g;
      var5 += var7.nextInt(this.g - this.h);
      var6 += var7.nextInt(this.g - this.h);
      if (var3 == var5 && var4 == var6) {
         boolean var8 = this.c.v().a(var3 * 16 + 8, var4 * 16 + 8, 0, d);
         if (var8) {
            return true;
         }
      }

      return false;
   }

   public String a() {
      return "Village";
   }

   public static class a extends aqu {
      private boolean c;

      public void a(dn var1) {
         super.a(var1);
         var1.a("Valid", this.c);
      }

      public a() {
      }

      public boolean d() {
         return this.c;
      }

      public void b(dn var1) {
         super.b(var1);
         this.c = var1.n("Valid");
      }

      public a(adm var1, Random var2, int var3, int var4, int var5) {
         super(var3, var4);
         List var6 = aqw.a(var2, var5);
         aqw.k var7 = new aqw.k(var1.v(), 0, var2, (var3 << 4) + 2, (var4 << 4) + 2, var6, var5);
         this.a.add(var7);
         var7.a(var7, this.a, var2);
         List var8 = var7.g;
         List var9 = var7.f;

         int var10;
         while(!var8.isEmpty() || !var9.isEmpty()) {
            aqt var11;
            if (var8.isEmpty()) {
               var10 = var2.nextInt(var9.size());
               var11 = (aqt)var9.remove(var10);
               var11.a((aqt)var7, (List)this.a, (Random)var2);
            } else {
               var10 = var2.nextInt(var8.size());
               var11 = (aqt)var8.remove(var10);
               var11.a((aqt)var7, (List)this.a, (Random)var2);
            }
         }

         this.c();
         var10 = 0;
         Iterator var13 = this.a.iterator();

         while(var13.hasNext()) {
            aqt var12 = (aqt)var13.next();
            if (!(var12 instanceof aqw.o)) {
               ++var10;
            }
         }

         this.c = var10 > 2;
      }
   }
}
