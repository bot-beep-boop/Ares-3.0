import java.util.Random;

public class afu extends age implements afj {
   public static final amn a = amn.a("age", 0, 2);

   public aug a(adm var1, cj var2, alz var3) {
      this.a(var1, var2);
      return super.a(var1, var2, var3);
   }

   public zw c(adm var1, cj var2) {
      return zy.aW;
   }

   public aug b(adm var1, cj var2) {
      this.a(var1, var2);
      return super.b(var1, var2);
   }

   public adf m() {
      return adf.c;
   }

   public void b(adm var1, Random var2, cj var3, alz var4) {
      var1.a((cj)var3, (alz)var4.a(a, (Integer)var4.b(a) + 1), 2);
   }

   public void a(adm var1, cj var2, alz var3, float var4, int var5) {
      int var6 = (Integer)var3.b(a);
      byte var7 = 1;
      if (var6 >= 2) {
         var7 = 3;
      }

      for(int var8 = 0; var8 < var7; ++var8) {
         a(var1, var2, new zx(zy.aW, 1, zd.m.b()));
      }

   }

   public boolean d() {
      return false;
   }

   public boolean e(adm var1, cj var2, alz var3) {
      var2 = var2.a((cq)var3.b(O));
      alz var4 = var1.p(var2);
      return var4.c() == afi.r && var4.b(aio.a) == aio.a.d;
   }

   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      if (!var3.k().c()) {
         var3 = cq.c;
      }

      return this.Q().a(O, var3.d()).a(a, 0);
   }

   private void f(adm var1, cj var2, alz var3) {
      var1.a((cj)var2, (alz)afi.a.Q(), 3);
      this.b(var1, var2, var3, 0);
   }

   public afu() {
      super(arm.k);
      this.j(this.M.b().a(O, cq.c).a(a, 0));
      this.a(true);
   }

   public void a(adq var1, cj var2) {
      alz var3 = var1.p(var2);
      cq var4 = (cq)var3.b(O);
      int var5 = (Integer)var3.b(a);
      int var6 = 4 + var5 * 2;
      int var7 = 5 + var5 * 2;
      float var8 = (float)var6 / 2.0F;
      switch(var4) {
      case d:
         this.a((8.0F - var8) / 16.0F, (12.0F - (float)var7) / 16.0F, (15.0F - (float)var6) / 16.0F, (8.0F + var8) / 16.0F, 0.75F, 0.9375F);
         break;
      case c:
         this.a((8.0F - var8) / 16.0F, (12.0F - (float)var7) / 16.0F, 0.0625F, (8.0F + var8) / 16.0F, 0.75F, (1.0F + (float)var6) / 16.0F);
         break;
      case e:
         this.a(0.0625F, (12.0F - (float)var7) / 16.0F, (8.0F - var8) / 16.0F, (1.0F + (float)var6) / 16.0F, 0.75F, (8.0F + var8) / 16.0F);
         break;
      case f:
         this.a((15.0F - (float)var6) / 16.0F, (12.0F - (float)var7) / 16.0F, (8.0F - var8) / 16.0F, 0.9375F, 0.75F, (8.0F + var8) / 16.0F);
      }

   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      if (!this.e(var1, var2, var3)) {
         this.f(var1, var2, var3);
      }

   }

   protected ama e() {
      return new ama(this, new amo[]{O, a});
   }

   public boolean a(adm var1, cj var2, alz var3, boolean var4) {
      return (Integer)var3.b(a) < 2;
   }

   public int j(adm var1, cj var2) {
      return zd.m.b();
   }

   public void a(adm var1, cj var2, alz var3, pr var4, zx var5) {
      cq var6 = cq.a((double)var4.y);
      var1.a((cj)var2, (alz)var3.a(O, var6), 2);
   }

   public boolean a(adm var1, Random var2, cj var3, alz var4) {
      return true;
   }

   public boolean c() {
      return false;
   }

   public alz a(int var1) {
      return this.Q().a(O, cq.b(var1)).a(a, (var1 & 15) >> 2);
   }

   public int c(alz var1) {
      byte var2 = 0;
      int var3 = var2 | ((cq)var1.b(O)).b();
      var3 |= (Integer)var1.b(a) << 2;
      return var3;
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      if (!this.e(var1, var2, var3)) {
         this.f(var1, var2, var3);
      } else if (var1.s.nextInt(5) == 0) {
         int var5 = (Integer)var3.b(a);
         if (var5 < 2) {
            var1.a((cj)var2, (alz)var3.a(a, var5 + 1), 2);
         }
      }

   }
}
