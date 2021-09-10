import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class aki extends afh {
   public static final amk P = amk.a("north");
   public static final amk a = amk.a("powered");
   public static final amk Q = amk.a("east");
   public static final amk b = amk.a("suspended");
   public static final amk S = amk.a("west");
   public static final amk O = amk.a("disarmed");
   public static final amk R = amk.a("south");
   public static final amk N = amk.a("attached");

   public int c(alz var1) {
      int var2 = 0;
      if ((Boolean)var1.b(a)) {
         var2 |= 1;
      }

      if ((Boolean)var1.b(b)) {
         var2 |= 2;
      }

      if ((Boolean)var1.b(N)) {
         var2 |= 4;
      }

      if ((Boolean)var1.b(O)) {
         var2 |= 8;
      }

      return var2;
   }

   public void c(adm var1, cj var2, alz var3) {
      var3 = var3.a(b, !adm.a((adq)var1, (cj)var2.b()));
      var1.a((cj)var2, (alz)var3, 3);
      this.e(var1, var2, var3);
   }

   public alz a(int var1) {
      return this.Q().a(a, (var1 & 1) > 0).a(b, (var1 & 2) > 0).a(N, (var1 & 4) > 0).a(O, (var1 & 8) > 0);
   }

   public void a(adm var1, cj var2, alz var3, wn var4) {
      if (!var1.D) {
         if (var4.bZ() != null && var4.bZ().b() == zy.be) {
            var1.a((cj)var2, (alz)var3.a(O, true), 4);
         }

      }
   }

   private void e(adm var1, cj var2, alz var3) {
      cq[] var4 = new cq[]{cq.d, cq.e};
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         cq var7 = var4[var6];

         for(int var8 = 1; var8 < 42; ++var8) {
            cj var9 = var2.a(var7, var8);
            alz var10 = var1.p(var9);
            if (var10.c() == afi.bR) {
               if (var10.b(akj.a) == var7.d()) {
                  afi.bR.a(var1, var9, var10, false, true, var8, var3);
               }
               break;
            }

            if (var10.c() != afi.bS) {
               break;
            }
         }
      }

   }

   public zw c(adm var1, cj var2) {
      return zy.F;
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      boolean var5 = (Boolean)var3.b(b);
      boolean var6 = !adm.a((adq)var1, (cj)var2.b());
      if (var5 != var6) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
      }

   }

   public boolean d() {
      return false;
   }

   public aki() {
      super(arm.q);
      this.j(this.M.b().a(a, false).a(b, false).a(N, false).a(O, false).a(P, false).a(Q, false).a(R, false).a(S, false));
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.15625F, 1.0F);
      this.a(true);
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      if (!var1.D) {
         if ((Boolean)var1.p(var2).b(a)) {
            this.e(var1, var2);
         }
      }
   }

   public aug a(adm var1, cj var2, alz var3) {
      return null;
   }

   public boolean c() {
      return false;
   }

   public void b(adm var1, cj var2, alz var3) {
      this.e(var1, var2, var3.a(a, true));
   }

   public static boolean c(adq var0, cj var1, alz var2, cq var3) {
      cj var4 = var1.a(var3);
      alz var5 = var0.p(var4);
      afh var6 = var5.c();
      if (var6 == afi.bR) {
         cq var9 = var3.d();
         return var5.b(akj.a) == var9;
      } else if (var6 == afi.bS) {
         boolean var7 = (Boolean)var2.b(b);
         boolean var8 = (Boolean)var5.b(b);
         return var7 == var8;
      } else {
         return false;
      }
   }

   public zw a(alz var1, Random var2, int var3) {
      return zy.F;
   }

   private void e(adm var1, cj var2) {
      alz var3 = var1.p(var2);
      boolean var4 = (Boolean)var3.b(a);
      boolean var5 = false;
      List var6 = var1.b((pk)null, (aug)(new aug((double)var2.n() + this.B, (double)var2.o() + this.C, (double)var2.p() + this.D, (double)var2.n() + this.E, (double)var2.o() + this.F, (double)var2.p() + this.G)));
      if (!var6.isEmpty()) {
         Iterator var7 = var6.iterator();

         while(var7.hasNext()) {
            pk var8 = (pk)var7.next();
            if (!var8.aI()) {
               var5 = true;
               break;
            }
         }
      }

      if (var5 != var4) {
         var3 = var3.a(a, var5);
         var1.a((cj)var2, (alz)var3, 3);
         this.e(var1, var2, var3);
      }

      if (var5) {
         var1.a((cj)var2, (afh)this, this.a(var1));
      }

   }

   public void a(adm var1, cj var2, alz var3, pk var4) {
      if (!var1.D) {
         if (!(Boolean)var3.b(a)) {
            this.e(var1, var2);
         }
      }
   }

   public alz a(alz var1, adq var2, cj var3) {
      return var1.a(P, c(var2, var3, var1, cq.c)).a(Q, c(var2, var3, var1, cq.f)).a(R, c(var2, var3, var1, cq.d)).a(S, c(var2, var3, var1, cq.e));
   }

   protected ama e() {
      return new ama(this, new amo[]{a, b, N, O, P, Q, S, R});
   }

   public adf m() {
      return adf.d;
   }

   public void a(adq var1, cj var2) {
      alz var3 = var1.p(var2);
      boolean var4 = (Boolean)var3.b(N);
      boolean var5 = (Boolean)var3.b(b);
      if (!var5) {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.09375F, 1.0F);
      } else if (!var4) {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      } else {
         this.a(0.0F, 0.0625F, 0.0F, 1.0F, 0.15625F, 1.0F);
      }

   }

   public void a(adm var1, cj var2, alz var3, Random var4) {
   }
}
