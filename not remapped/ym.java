import java.util.List;

public class ym extends yo {
   public boolean a(zx var1, wn var2, adm var3, cj var4, cq var5, float var6, float var7, float var8) {
      if (var5 == cq.a) {
         return false;
      } else if (!var3.p(var4).c().t().a()) {
         return false;
      } else {
         var4 = var4.a(var5);
         if (!var2.a(var4, var5, var1)) {
            return false;
         } else if (!afi.cK.d(var3, var4)) {
            return false;
         } else if (var3.D) {
            return true;
         } else {
            if (var5 == cq.b) {
               int var9 = ns.c((double)((var2.y + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15;
               var3.a((cj)var4, (alz)afi.cK.Q().a(ajv.a, var9), 3);
            } else {
               var3.a((cj)var4, (alz)afi.cL.Q().a(akm.a, var5), 3);
            }

            --var1.b;
            akw var10 = var3.s(var4);
            if (var10 instanceof aku) {
               ((aku)var10).a(var1);
            }

            return true;
         }
      }
   }

   public ym() {
      super(afi.cK);
      this.h = 16;
      this.a(yz.c);
      this.a(true);
      this.d(0);
   }

   public int a(zx var1, int var2) {
      if (var2 == 0) {
         return 16777215;
      } else {
         zd var3 = this.h(var1);
         return var3.e().L;
      }
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      zd[] var4 = zd.values();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         zd var7 = var4[var6];
         dn var8 = new dn();
         aku.a(var8, var7.b(), (du)null);
         dn var9 = new dn();
         var9.a((String)"BlockEntityTag", (eb)var8);
         zx var10 = new zx(var1, 1, var7.b());
         var10.d(var9);
         var3.add(var10);
      }

   }

   public String a(zx var1) {
      String var2 = "item.banner.";
      zd var3 = this.h(var1);
      var2 = var2 + var3.d() + ".name";
      return di.a(var2);
   }

   private zd h(zx var1) {
      dn var2 = var1.a("BlockEntityTag", false);
      zd var3 = null;
      if (var2 != null && var2.c("Base")) {
         var3 = zd.a(var2.f("Base"));
      } else {
         var3 = zd.a(var1.i());
      }

      return var3;
   }

   public void a(zx var1, wn var2, List<String> var3, boolean var4) {
      dn var5 = var1.a("BlockEntityTag", false);
      if (var5 != null && var5.c("Patterns")) {
         du var6 = var5.c("Patterns", 10);

         for(int var7 = 0; var7 < var6.c() && var7 < 6; ++var7) {
            dn var8 = var6.b(var7);
            zd var9 = zd.a(var8.f("Color"));
            aku.a var10 = aku.a.a(var8.j("Pattern"));
            if (var10 != null) {
               var3.add(di.a("item.banner." + var10.a() + "." + var9.d()));
            }
         }

      }
   }

   public yz c() {
      return yz.c;
   }
}
