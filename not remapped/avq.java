import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;

public class avq {
   private static final jy a = new jy("textures/map/map_icons.png");
   private final bmj b;
   private final Map<String, avq.a> c = Maps.newHashMap();

   public void a() {
      Iterator var1 = this.c.values().iterator();

      while(var1.hasNext()) {
         avq.a var2 = (avq.a)var1.next();
         this.b.c(avq.a.b(var2));
      }

      this.c.clear();
   }

   public avq(bmj var1) {
      this.b = var1;
   }

   static bmj a(avq var0) {
      return var0.b;
   }

   private avq.a b(atg var1) {
      avq.a var2 = (avq.a)this.c.get(var1.a);
      if (var2 == null) {
         var2 = new avq.a(this, var1);
         this.c.put(var1.a, var2);
      }

      return var2;
   }

   public void a(atg var1, boolean var2) {
      avq.a.a(this.b(var1), var2);
   }

   public void a(atg var1) {
      avq.a.a(this.b(var1));
   }

   static jy b() {
      return a;
   }

   class a {
      private final jy d;
      private final int[] e;
      private final atg b;
      final avq a;
      private final blz c;

      private a(avq var1, atg var2) {
         this.a = var1;
         this.b = var2;
         this.c = new blz(128, 128);
         this.e = this.c.e();
         this.d = avq.a(var1).a("map/" + var2.a, this.c);

         for(int var3 = 0; var3 < this.e.length; ++var3) {
            this.e[var3] = 0;
         }

      }

      private void a() {
         for(int var1 = 0; var1 < 16384; ++var1) {
            int var2 = this.b.f[var1] & 255;
            if (var2 / 4 == 0) {
               this.e[var1] = (var1 + var1 / 128 & 1) * 8 + 16 << 24;
            } else {
               this.e[var1] = arn.a[var2 / 4].a(var2 & 3);
            }
         }

         this.c.d();
      }

      static void a(avq.a var0, boolean var1) {
         var0.a(var1);
      }

      a(avq var1, atg var2, Object var3) {
         this(var1, var2);
      }

      static void a(avq.a var0) {
         var0.a();
      }

      static jy b(avq.a var0) {
         return var0.d;
      }

      private void a(boolean var1) {
         byte var2 = 0;
         byte var3 = 0;
         bfx var4 = bfx.a();
         bfd var5 = var4.c();
         float var6 = 0.0F;
         avq.a(this.a).a(this.d);
         bfl.l();
         bfl.a(1, 771, 0, 1);
         bfl.c();
         var5.a(7, bms.g);
         var5.b((double)((float)var2 + var6), (double)((float)(var3 + 128) - var6), -0.009999999776482582D).a(0.0D, 1.0D).d();
         var5.b((double)((float)(var2 + 128) - var6), (double)((float)(var3 + 128) - var6), -0.009999999776482582D).a(1.0D, 1.0D).d();
         var5.b((double)((float)(var2 + 128) - var6), (double)((float)var3 + var6), -0.009999999776482582D).a(1.0D, 0.0D).d();
         var5.b((double)((float)var2 + var6), (double)((float)var3 + var6), -0.009999999776482582D).a(0.0D, 0.0D).d();
         var4.b();
         bfl.d();
         bfl.k();
         avq.a(this.a).a(avq.b());
         int var7 = 0;
         Iterator var8 = this.b.h.values().iterator();

         while(true) {
            atf var9;
            do {
               if (!var8.hasNext()) {
                  bfl.E();
                  bfl.b(0.0F, 0.0F, -0.04F);
                  bfl.a(1.0F, 1.0F, 1.0F);
                  bfl.F();
                  return;
               }

               var9 = (atf)var8.next();
            } while(var1 && var9.a() != 1);

            bfl.E();
            bfl.b((float)var2 + (float)var9.b() / 2.0F + 64.0F, (float)var3 + (float)var9.c() / 2.0F + 64.0F, -0.02F);
            bfl.b((float)(var9.d() * 360) / 16.0F, 0.0F, 0.0F, 1.0F);
            bfl.a(4.0F, 4.0F, 3.0F);
            bfl.b(-0.125F, 0.125F, 0.0F);
            byte var10 = var9.a();
            float var11 = (float)(var10 % 4) / 4.0F;
            float var12 = (float)(var10 / 4) / 4.0F;
            float var13 = (float)(var10 % 4 + 1) / 4.0F;
            float var14 = (float)(var10 / 4 + 1) / 4.0F;
            var5.a(7, bms.g);
            float var15 = -0.001F;
            var5.b(-1.0D, 1.0D, (double)((float)var7 * -0.001F)).a((double)var11, (double)var12).d();
            var5.b(1.0D, 1.0D, (double)((float)var7 * -0.001F)).a((double)var13, (double)var12).d();
            var5.b(1.0D, -1.0D, (double)((float)var7 * -0.001F)).a((double)var13, (double)var14).d();
            var5.b(-1.0D, -1.0D, (double)((float)var7 * -0.001F)).a((double)var11, (double)var14).d();
            var4.b();
            bfl.F();
            ++var7;
         }
      }
   }
}
