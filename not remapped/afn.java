import java.util.List;
import java.util.Random;

public abstract class afn extends afh {
   private final boolean N;
   public static final amk b = amk.a("powered");
   public static final aml a = aml.a("facing");

   public void b(adm var1, cj var2, alz var3) {
      if ((Boolean)var3.b(b)) {
         this.c(var1, var2, (cq)var3.b(a));
      }

      super.b(var1, var2, var3);
   }

   public void a(adm var1, cj var2, alz var3, Random var4) {
   }

   public alz a(int var1) {
      cq var2;
      switch(var1 & 7) {
      case 0:
         var2 = cq.a;
         break;
      case 1:
         var2 = cq.f;
         break;
      case 2:
         var2 = cq.e;
         break;
      case 3:
         var2 = cq.d;
         break;
      case 4:
         var2 = cq.c;
         break;
      case 5:
      default:
         var2 = cq.b;
      }

      return this.Q().a(a, var2).a(b, (var1 & 8) > 0);
   }

   private void f(adm var1, cj var2, alz var3) {
      this.d(var3);
      List var4 = var1.a(wq.class, new aug((double)var2.n() + this.B, (double)var2.o() + this.C, (double)var2.p() + this.D, (double)var2.n() + this.E, (double)var2.o() + this.F, (double)var2.p() + this.G));
      boolean var5 = !var4.isEmpty();
      boolean var6 = (Boolean)var3.b(b);
      if (var5 && !var6) {
         var1.a(var2, var3.a(b, true));
         this.c(var1, var2, (cq)var3.b(a));
         var1.b(var2, var2);
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D, "random.click", 0.3F, 0.6F);
      }

      if (!var5 && var6) {
         var1.a(var2, var3.a(b, false));
         this.c(var1, var2, (cq)var3.b(a));
         var1.b(var2, var2);
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D, "random.click", 0.3F, 0.5F);
      }

      if (var5) {
         var1.a((cj)var2, (afh)this, this.a(var1));
      }

   }

   protected static boolean a(adm var0, cj var1, cq var2) {
      cj var3 = var1.a(var2);
      return var2 == cq.a ? adm.a((adq)var0, (cj)var3) : var0.p(var3).c().v();
   }

   private void d(alz var1) {
      cq var2 = (cq)var1.b(a);
      boolean var3 = (Boolean)var1.b(b);
      float var4 = 0.25F;
      float var5 = 0.375F;
      float var6 = (float)(var3 ? 1 : 2) / 16.0F;
      float var7 = 0.125F;
      float var8 = 0.1875F;
      switch(var2) {
      case f:
         this.a(0.0F, 0.375F, 0.3125F, var6, 0.625F, 0.6875F);
         break;
      case e:
         this.a(1.0F - var6, 0.375F, 0.3125F, 1.0F, 0.625F, 0.6875F);
         break;
      case d:
         this.a(0.3125F, 0.375F, 0.0F, 0.6875F, 0.625F, var6);
         break;
      case c:
         this.a(0.3125F, 0.375F, 1.0F - var6, 0.6875F, 0.625F, 1.0F);
         break;
      case b:
         this.a(0.3125F, 0.0F, 0.375F, 0.6875F, 0.0F + var6, 0.625F);
         break;
      case a:
         this.a(0.3125F, 1.0F - var6, 0.375F, 0.6875F, 1.0F, 0.625F);
      }

   }

   public int a(adq var1, cj var2, alz var3, cq var4) {
      return (Boolean)var3.b(b) ? 15 : 0;
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      if (this.e(var1, var2, var3) && !a(var1, var2, ((cq)var3.b(a)).d())) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
      }

   }

   private void c(adm var1, cj var2, cq var3) {
      var1.c((cj)var2, (afh)this);
      var1.c((cj)var2.a(var3.d()), (afh)this);
   }

   public void j() {
      float var1 = 0.1875F;
      float var2 = 0.125F;
      float var3 = 0.125F;
      this.a(0.5F - var1, 0.5F - var2, 0.5F - var3, 0.5F + var1, 0.5F + var2, 0.5F + var3);
   }

   protected ama e() {
      return new ama(this, new amo[]{a, b});
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      if (!var1.D) {
         if ((Boolean)var3.b(b)) {
            if (this.N) {
               this.f(var1, var2, var3);
            } else {
               var1.a(var2, var3.a(b, false));
               this.c(var1, var2, (cq)var3.b(a));
               var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D, "random.click", 0.3F, 0.5F);
               var1.b(var2, var2);
            }

         }
      }
   }

   public boolean i() {
      return true;
   }

   public aug a(adm var1, cj var2, alz var3) {
      return null;
   }

   private boolean e(adm var1, cj var2, alz var3) {
      if (this.d(var1, var2)) {
         return true;
      } else {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
         return false;
      }
   }

   public boolean d(adm var1, cj var2) {
      cq[] var3 = cq.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         cq var6 = var3[var5];
         if (a(var1, var2, var6)) {
            return true;
         }
      }

      return false;
   }

   public boolean d() {
      return false;
   }

   protected afn(boolean var1) {
      super(arm.q);
      this.j(this.M.b().a(a, cq.c).a(b, false));
      this.a(true);
      this.a(yz.d);
      this.N = var1;
   }

   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      return a(var1, var2, var3.d()) ? this.Q().a(a, var3).a(b, false) : this.Q().a(a, cq.a).a(b, false);
   }

   public int a(adm var1) {
      return this.N ? 30 : 20;
   }

   public int c(alz var1) {
      int var2;
      switch((cq)var1.b(a)) {
      case f:
         var2 = 1;
         break;
      case e:
         var2 = 2;
         break;
      case d:
         var2 = 3;
         break;
      case c:
         var2 = 4;
         break;
      case b:
      default:
         var2 = 5;
         break;
      case a:
         var2 = 0;
      }

      if ((Boolean)var1.b(b)) {
         var2 |= 8;
      }

      return var2;
   }

   public boolean c() {
      return false;
   }

   public void a(adq var1, cj var2) {
      this.d(var1.p(var2));
   }

   public int b(adq var1, cj var2, alz var3, cq var4) {
      if (!(Boolean)var3.b(b)) {
         return 0;
      } else {
         return var3.b(a) == var4 ? 15 : 0;
      }
   }

   public void a(adm var1, cj var2, alz var3, pk var4) {
      if (!var1.D) {
         if (this.N) {
            if (!(Boolean)var3.b(b)) {
               this.f(var1, var2, var3);
            }
         }
      }
   }

   public boolean b(adm var1, cj var2, cq var3) {
      return a(var1, var2, var3.d());
   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      if ((Boolean)var3.b(b)) {
         return true;
      } else {
         var1.a((cj)var2, (alz)var3.a(b, true), 3);
         var1.b(var2, var2);
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D, "random.click", 0.3F, 0.6F);
         this.c(var1, var2, (cq)var3.b(a));
         var1.a((cj)var2, (afh)this, this.a(var1));
         return true;
      }
   }
}
