import com.google.common.base.Predicate;

public class aiv extends age {
   private static final Predicate<alz> Q = new Predicate<alz>() {
      public boolean apply(Object var1) {
         return this.a((alz)var1);
      }

      public boolean a(alz var1) {
         return var1 != null && (var1.c() == afi.aU || var1.c() == afi.aZ);
      }
   };
   private amd N;
   private amd P;
   private amd a;
   private amd b;

   protected amd n() {
      if (this.b == null) {
         this.b = ame.a().a("^", "#", "#").a('^', amc.a(Q)).a('#', amc.a(amh.a(afi.aJ))).b();
      }

      return this.b;
   }

   protected amd T() {
      if (this.N == null) {
         this.N = ame.a().a("~ ~", "###", "~#~").a('#', amc.a(amh.a(afi.S))).a('~', amc.a(amh.a(afi.a))).b();
      }

      return this.N;
   }

   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      return this.Q().a(O, var8.aP().d());
   }

   protected amd U() {
      if (this.P == null) {
         this.P = ame.a().a("~^~", "###", "~#~").a('^', amc.a(Q)).a('#', amc.a(amh.a(afi.S))).a('~', amc.a(amh.a(afi.a))).b();
      }

      return this.P;
   }

   protected aiv() {
      super(arm.C, arn.q);
      this.j(this.M.b().a(O, cq.c));
      this.a(true);
      this.a(yz.b);
   }

   public int c(alz var1) {
      return ((cq)var1.b(O)).b();
   }

   protected ama e() {
      return new ama(this, new amo[]{O});
   }

   public boolean e(adm var1, cj var2) {
      return this.l().a(var1, var2) != null || this.T().a(var1, var2) != null;
   }

   public void c(adm var1, cj var2, alz var3) {
      super.c(var1, var2, var3);
      this.f(var1, var2);
   }

   public alz a(int var1) {
      return this.Q().a(O, cq.b(var1));
   }

   private void f(adm var1, cj var2) {
      amd.b var3;
      int var4;
      int var6;
      if ((var3 = this.n().a(var1, var2)) != null) {
         for(var4 = 0; var4 < this.n().b(); ++var4) {
            amc var5 = var3.a(0, var4, 0);
            var1.a((cj)var5.d(), (alz)afi.a.Q(), 2);
         }

         tw var9 = new tw(var1);
         cj var10 = var3.a(0, 2, 0).d();
         var9.b((double)var10.n() + 0.5D, (double)var10.o() + 0.05D, (double)var10.p() + 0.5D, 0.0F, 0.0F);
         var1.d((pk)var9);

         for(var6 = 0; var6 < 120; ++var6) {
            var1.a(cy.G, (double)var10.n() + var1.s.nextDouble(), (double)var10.o() + var1.s.nextDouble() * 2.5D, (double)var10.p() + var1.s.nextDouble(), 0.0D, 0.0D, 0.0D);
         }

         for(var6 = 0; var6 < this.n().b(); ++var6) {
            amc var7 = var3.a(0, var6, 0);
            var1.b(var7.d(), afi.a);
         }
      } else if ((var3 = this.U().a(var1, var2)) != null) {
         for(var4 = 0; var4 < this.U().c(); ++var4) {
            for(int var12 = 0; var12 < this.U().b(); ++var12) {
               var1.a((cj)var3.a(var4, var12, 0).d(), (alz)afi.a.Q(), 2);
            }
         }

         cj var11 = var3.a(1, 2, 0).d();
         ty var13 = new ty(var1);
         var13.l(true);
         var13.b((double)var11.n() + 0.5D, (double)var11.o() + 0.05D, (double)var11.p() + 0.5D, 0.0F, 0.0F);
         var1.d((pk)var13);

         for(var6 = 0; var6 < 120; ++var6) {
            var1.a(cy.F, (double)var11.n() + var1.s.nextDouble(), (double)var11.o() + var1.s.nextDouble() * 3.9D, (double)var11.p() + var1.s.nextDouble(), 0.0D, 0.0D, 0.0D);
         }

         for(var6 = 0; var6 < this.U().c(); ++var6) {
            for(int var14 = 0; var14 < this.U().b(); ++var14) {
               amc var8 = var3.a(var6, var14, 0);
               var1.b(var8.d(), afi.a);
            }
         }
      }

   }

   public boolean d(adm var1, cj var2) {
      return var1.p(var2).c().J.j() && adm.a((adq)var1, (cj)var2.b());
   }

   protected amd l() {
      if (this.a == null) {
         this.a = ame.a().a(" ", "#", "#").a('#', amc.a(amh.a(afi.aJ))).b();
      }

      return this.a;
   }
}
