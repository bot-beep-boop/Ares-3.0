import java.util.List;
import java.util.Random;

public class ajj extends afm implements afj {
   public static final amm<aio.a> a = amm.a("type", aio.a.class);
   public static final amn b = amn.a("stage", 0, 1);

   public int a(alz var1) {
      return ((aio.a)var1.b(a)).a();
   }

   public void d(adm var1, cj var2, alz var3, Random var4) {
      if ((Integer)var3.b(b) == 0) {
         var1.a((cj)var2, (alz)var3.a(b), 4);
      } else {
         this.e(var1, var2, var3, var4);
      }

   }

   public alz a(int var1) {
      return this.Q().a(a, aio.a.a(var1 & 7)).a(b, (var1 & 8) >> 3);
   }

   protected ama e() {
      return new ama(this, new amo[]{a, b});
   }

   public boolean a(adm var1, cj var2, alz var3, boolean var4) {
      return true;
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      if (!var1.D) {
         super.b(var1, var2, var3, var4);
         if (var1.l(var2.a()) >= 9 && var4.nextInt(7) == 0) {
            this.d(var1, var2, var3, var4);
         }

      }
   }

   private boolean a(adm var1, cj var2, int var3, int var4, aio.a var5) {
      return this.a(var1, var2.a(var3, 0, var4), var5) && this.a(var1, var2.a(var3 + 1, 0, var4), var5) && this.a(var1, var2.a(var3, 0, var4 + 1), var5) && this.a(var1, var2.a(var3 + 1, 0, var4 + 1), var5);
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      aio.a[] var4 = aio.a.values();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         aio.a var7 = var4[var6];
         var3.add(new zx(var1, 1, var7.a()));
      }

   }

   public int c(alz var1) {
      byte var2 = 0;
      int var3 = var2 | ((aio.a)var1.b(a)).a();
      var3 |= (Integer)var1.b(b) << 3;
      return var3;
   }

   public boolean a(adm var1, cj var2, aio.a var3) {
      alz var4 = var1.p(var2);
      return var4.c() == this && var4.b(a) == var3;
   }

   public String f() {
      return di.a(this.a() + "." + aio.a.a.d() + ".name");
   }

   public boolean a(adm var1, Random var2, cj var3, alz var4) {
      return (double)var1.s.nextFloat() < 0.45D;
   }

   public void e(adm var1, cj var2, alz var3, Random var4) {
      Object var5 = var4.nextInt(10) == 0 ? new aoi(true) : new apv(true);
      int var6 = 0;
      int var7 = 0;
      boolean var8 = false;
      alz var9;
      switch((aio.a)var3.b(a)) {
      case b:
         label107:
         for(var6 = 0; var6 >= -1; --var6) {
            for(var7 = 0; var7 >= -1; --var7) {
               if (this.a(var1, var2, var6, var7, aio.a.b)) {
                  var5 = new apf(false, var4.nextBoolean());
                  var8 = true;
                  break label107;
               }
            }
         }

         if (!var8) {
            var7 = 0;
            var6 = 0;
            var5 = new aps(true);
         }
         break;
      case c:
         var5 = new aoj(true, false);
         break;
      case d:
         var9 = afi.r.Q().a(ail.b, aio.a.d);
         alz var10 = afi.t.Q().a(aik.Q, aio.a.d).a(ahs.b, false);

         label121:
         for(var6 = 0; var6 >= -1; --var6) {
            for(var7 = 0; var7 >= -1; --var7) {
               if (this.a(var1, var2, var6, var7, aio.a.d)) {
                  var5 = new ape(true, 10, 20, var9, var10);
                  var8 = true;
                  break label121;
               }
            }
         }

         if (!var8) {
            var7 = 0;
            var6 = 0;
            var5 = new apv(true, 4 + var4.nextInt(7), var9, var10, false);
         }
         break;
      case e:
         var5 = new app(true);
         break;
      case f:
         label135:
         for(var6 = 0; var6 >= -1; --var6) {
            for(var7 = 0; var7 >= -1; --var7) {
               if (this.a(var1, var2, var6, var7, aio.a.f)) {
                  var5 = new apn(true);
                  var8 = true;
                  break label135;
               }
            }
         }

         if (!var8) {
            return;
         }
      case a:
      }

      var9 = afi.a.Q();
      if (var8) {
         var1.a((cj)var2.a(var6, 0, var7), (alz)var9, 4);
         var1.a((cj)var2.a(var6 + 1, 0, var7), (alz)var9, 4);
         var1.a((cj)var2.a(var6, 0, var7 + 1), (alz)var9, 4);
         var1.a((cj)var2.a(var6 + 1, 0, var7 + 1), (alz)var9, 4);
      } else {
         var1.a((cj)var2, (alz)var9, 4);
      }

      if (!((aot)var5).b(var1, var4, var2.a(var6, 0, var7))) {
         if (var8) {
            var1.a((cj)var2.a(var6, 0, var7), (alz)var3, 4);
            var1.a((cj)var2.a(var6 + 1, 0, var7), (alz)var3, 4);
            var1.a((cj)var2.a(var6, 0, var7 + 1), (alz)var3, 4);
            var1.a((cj)var2.a(var6 + 1, 0, var7 + 1), (alz)var3, 4);
         } else {
            var1.a((cj)var2, (alz)var3, 4);
         }
      }

   }

   protected ajj() {
      this.j(this.M.b().a(a, aio.a.a).a(b, 0));
      float var1 = 0.4F;
      this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var1 * 2.0F, 0.5F + var1);
      this.a(yz.c);
   }

   public void b(adm var1, Random var2, cj var3, alz var4) {
      this.d(var1, var3, var4, var2);
   }
}
