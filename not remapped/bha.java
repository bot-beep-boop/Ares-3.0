import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class bha extends bhd<aku> {
   private static final Map<String, bha.a> c = Maps.newHashMap();
   private bau e = new bau();
   private static final jy d = new jy("textures/entity/banner_base.png");

   private jy a(aku var1) {
      String var2 = var1.g();
      if (var2.isEmpty()) {
         return null;
      } else {
         bha.a var3 = (bha.a)c.get(var2);
         if (var3 == null) {
            if (c.size() >= 256) {
               long var4 = System.currentTimeMillis();
               Iterator var6 = c.keySet().iterator();

               while(var6.hasNext()) {
                  String var7 = (String)var6.next();
                  bha.a var8 = (bha.a)c.get(var7);
                  if (var4 - var8.a > 60000L) {
                     ave.A().P().c(var8.b);
                     var6.remove();
                  }
               }

               if (c.size() >= 256) {
                  return null;
               }
            }

            List var9 = var1.c();
            List var5 = var1.e();
            ArrayList var10 = Lists.newArrayList();
            Iterator var11 = var9.iterator();

            while(var11.hasNext()) {
               aku.a var12 = (aku.a)var11.next();
               var10.add("textures/entity/banner/" + var12.a() + ".png");
            }

            var3 = new bha.a();
            var3.b = new jy(var2);
            ave.A().P().a((jy)var3.b, (bmk)(new bmc(d, var10, var5)));
            c.put(var2, var3);
         }

         var3.a = System.currentTimeMillis();
         return var3.b;
      }
   }

   public void a(aku var1, double var2, double var4, double var6, float var8, int var9) {
      boolean var10 = var1.z() != null;
      boolean var11 = !var10 || var1.w() == afi.cK;
      int var12 = var10 ? var1.u() : 0;
      long var13 = var10 ? var1.z().K() : 0L;
      bfl.E();
      float var15 = 0.6666667F;
      float var17;
      if (var11) {
         bfl.b((float)var2 + 0.5F, (float)var4 + 0.75F * var15, (float)var6 + 0.5F);
         float var16 = (float)(var12 * 360) / 16.0F;
         bfl.b(-var16, 0.0F, 1.0F, 0.0F);
         this.e.b.j = true;
      } else {
         var17 = 0.0F;
         if (var12 == 2) {
            var17 = 180.0F;
         }

         if (var12 == 4) {
            var17 = 90.0F;
         }

         if (var12 == 5) {
            var17 = -90.0F;
         }

         bfl.b((float)var2 + 0.5F, (float)var4 - 0.25F * var15, (float)var6 + 0.5F);
         bfl.b(-var17, 0.0F, 1.0F, 0.0F);
         bfl.b(0.0F, -0.3125F, -0.4375F);
         this.e.b.j = false;
      }

      cj var19 = var1.v();
      var17 = (float)(var19.n() * 7 + var19.o() * 9 + var19.p() * 13) + (float)var13 + var8;
      this.e.a.f = (-0.0125F + 0.01F * ns.b(var17 * 3.1415927F * 0.02F)) * 3.1415927F;
      bfl.B();
      jy var18 = this.a(var1);
      if (var18 != null) {
         this.a(var18);
         bfl.E();
         bfl.a(var15, -var15, -var15);
         this.e.a();
         bfl.F();
      }

      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      bfl.F();
   }

   public void a(akw var1, double var2, double var4, double var6, float var8, int var9) {
      this.a((aku)var1, var2, var4, var6, var8, var9);
   }

   static class a {
      public long a;
      public jy b;

      a(Object var1) {
         this();
      }

      private a() {
      }
   }
}
