import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.Random;

public class ajx extends afm implements afj {
   private final afh N;
   public static final aml b = aml.a("facing", new Predicate<cq>() {
      public boolean a(cq var1) {
         return var1 != cq.a;
      }

      public boolean apply(Object var1) {
         return this.a((cq)var1);
      }
   });
   public static final amn a = amn.a("age", 0, 7);

   protected zw l() {
      if (this.N == afi.aU) {
         return zy.bg;
      } else {
         return this.N == afi.bk ? zy.bh : null;
      }
   }

   public zw a(alz var1, Random var2, int var3) {
      return null;
   }

   public boolean a(adm var1, Random var2, cj var3, alz var4) {
      return true;
   }

   public void a(adq var1, cj var2) {
      this.F = (double)((float)((Integer)var1.p(var2).b(a) * 2 + 2) / 16.0F);
      float var3 = 0.125F;
      this.a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, (float)this.F, 0.5F + var3);
   }

   protected ama e() {
      return new ama(this, new amo[]{a, b});
   }

   public int a(adq var1, cj var2, int var3) {
      return this.h(var1.p(var2));
   }

   public int h(alz var1) {
      if (var1.c() != this) {
         return super.h(var1);
      } else {
         int var2 = (Integer)var1.b(a);
         int var3 = var2 * 32;
         int var4 = 255 - var2 * 8;
         int var5 = var2 * 4;
         return var3 << 16 | var4 << 8 | var5;
      }
   }

   public void g(adm var1, cj var2, alz var3) {
      int var4 = (Integer)var3.b(a) + ns.a((Random)var1.s, 2, 5);
      var1.a((cj)var2, (alz)var3.a(a, Math.min(7, var4)), 2);
   }

   public int c(alz var1) {
      return (Integer)var1.b(a);
   }

   public alz a(int var1) {
      return this.Q().a(a, var1);
   }

   public zw c(adm var1, cj var2) {
      zw var3 = this.l();
      return var3 != null ? var3 : null;
   }

   public void a(adm var1, cj var2, alz var3, float var4, int var5) {
      super.a(var1, var2, var3, var4, var5);
      if (!var1.D) {
         zw var6 = this.l();
         if (var6 != null) {
            int var7 = (Integer)var3.b(a);

            for(int var8 = 0; var8 < 3; ++var8) {
               if (var1.s.nextInt(15) <= var7) {
                  a(var1, var2, new zx(var6));
               }
            }

         }
      }
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      super.b(var1, var2, var3, var4);
      if (var1.l(var2.a()) >= 9) {
         float var5 = afz.a(this, var1, var2);
         if (var4.nextInt((int)(25.0F / var5) + 1) == 0) {
            int var6 = (Integer)var3.b(a);
            if (var6 < 7) {
               var3 = var3.a(a, var6 + 1);
               var1.a((cj)var2, (alz)var3, 2);
            } else {
               Iterator var7 = cq.c.a.iterator();

               while(var7.hasNext()) {
                  cq var8 = (cq)var7.next();
                  if (var1.p(var2.a(var8)).c() == this.N) {
                     return;
                  }
               }

               var2 = var2.a(cq.c.a.a(var4));
               afh var9 = var1.p(var2.b()).c();
               if (var1.p(var2).c().J == arm.a && (var9 == afi.ak || var9 == afi.d || var9 == afi.c)) {
                  var1.a(var2, this.N.Q());
               }
            }
         }

      }
   }

   protected boolean c(afh var1) {
      return var1 == afi.ak;
   }

   public void b(adm var1, Random var2, cj var3, alz var4) {
      this.g(var1, var3, var4);
   }

   public alz a(alz var1, adq var2, cj var3) {
      var1 = var1.a(b, cq.b);
      Iterator var4 = cq.c.a.iterator();

      while(var4.hasNext()) {
         cq var5 = (cq)var4.next();
         if (var2.p(var3.a(var5)).c() == this.N) {
            var1 = var1.a(b, var5);
            break;
         }
      }

      return var1;
   }

   protected ajx(afh var1) {
      this.j(this.M.b().a(a, 0).a(b, cq.b));
      this.N = var1;
      this.a(true);
      float var2 = 0.125F;
      this.a(0.5F - var2, 0.0F, 0.5F - var2, 0.5F + var2, 0.25F, 0.5F + var2);
      this.a((yz)null);
   }

   public boolean a(adm var1, cj var2, alz var3, boolean var4) {
      return (Integer)var3.b(a) != 7;
   }

   public void j() {
      float var1 = 0.125F;
      this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.25F, 0.5F + var1);
   }
}
