import java.util.Random;

public abstract class afd extends afh {
   public int a(adm var1) {
      return 20;
   }

   public aug a(adm var1, cj var2, alz var3) {
      return null;
   }

   protected void d(alz var1) {
      boolean var2 = this.e(var1) > 0;
      float var3 = 0.0625F;
      if (var2) {
         this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.03125F, 0.9375F);
      } else {
         this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.0625F, 0.9375F);
      }

   }

   protected abstract int f(adm var1, cj var2);

   public boolean d() {
      return false;
   }

   public int a(adq var1, cj var2, alz var3, cq var4) {
      return this.e(var3);
   }

   public void j() {
      float var1 = 0.5F;
      float var2 = 0.125F;
      float var3 = 0.5F;
      this.a(0.0F, 0.375F, 0.0F, 1.0F, 0.625F, 1.0F);
   }

   public boolean i() {
      return true;
   }

   public boolean g() {
      return true;
   }

   protected abstract int e(alz var1);

   protected afd(arm var1) {
      this(var1, var1.r());
   }

   protected void a(adm var1, cj var2, alz var3, int var4) {
      int var5 = this.f(var1, var2);
      boolean var6 = var4 > 0;
      boolean var7 = var5 > 0;
      if (var4 != var5) {
         var3 = this.a(var3, var5);
         var1.a((cj)var2, (alz)var3, 2);
         this.e(var1, var2);
         var1.b(var2, var2);
      }

      if (!var7 && var6) {
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.1D, (double)var2.p() + 0.5D, "random.click", 0.3F, 0.5F);
      } else if (var7 && !var6) {
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.1D, (double)var2.p() + 0.5D, "random.click", 0.3F, 0.6F);
      }

      if (var7) {
         var1.a((cj)var2, (afh)this, this.a(var1));
      }

   }

   public void a(adq var1, cj var2) {
      this.d(var1.p(var2));
   }

   public int k() {
      return 1;
   }

   protected afd(arm var1, arn var2) {
      super(var1, var2);
      this.a((yz)yz.d);
      this.a(true);
   }

   public void b(adm var1, cj var2, alz var3) {
      if (this.e(var3) > 0) {
         this.e(var1, var2);
      }

      super.b(var1, var2, var3);
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      if (!this.m(var1, var2.b())) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
      }

   }

   public void a(adm var1, cj var2, alz var3, Random var4) {
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      if (!var1.D) {
         int var5 = this.e(var3);
         if (var5 > 0) {
            this.a(var1, var2, var3, var5);
         }

      }
   }

   public boolean d(adm var1, cj var2) {
      return this.m(var1, var2.b());
   }

   private boolean m(adm var1, cj var2) {
      return adm.a((adq)var1, (cj)var2) || var1.p(var2).c() instanceof agt;
   }

   public boolean b(adq var1, cj var2) {
      return true;
   }

   public int b(adq var1, cj var2, alz var3, cq var4) {
      return var4 == cq.b ? this.e(var3) : 0;
   }

   protected abstract alz a(alz var1, int var2);

   public boolean c() {
      return false;
   }

   protected aug a(cj var1) {
      float var2 = 0.125F;
      return new aug((double)((float)var1.n() + 0.125F), (double)var1.o(), (double)((float)var1.p() + 0.125F), (double)((float)(var1.n() + 1) - 0.125F), (double)var1.o() + 0.25D, (double)((float)(var1.p() + 1) - 0.125F));
   }

   public void a(adm var1, cj var2, alz var3, pk var4) {
      if (!var1.D) {
         int var5 = this.e(var3);
         if (var5 == 0) {
            this.a(var1, var2, var3, var5);
         }

      }
   }

   protected void e(adm var1, cj var2) {
      var1.c((cj)var2, (afh)this);
      var1.c((cj)var2.b(), (afh)this);
   }
}
