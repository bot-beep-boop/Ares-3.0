public class agu extends age {
   public static final amk a = amk.a("open");
   public static final amk b = amk.a("powered");
   public static final amk N = amk.a("in_wall");

   public int c(alz var1) {
      byte var2 = 0;
      int var3 = var2 | ((cq)var1.b(O)).b();
      if ((Boolean)var1.b(b)) {
         var3 |= 8;
      }

      if ((Boolean)var1.b(a)) {
         var3 |= 4;
      }

      return var3;
   }

   public agu(aio.a var1) {
      super(arm.d, var1.c());
      this.j(this.M.b().a(a, false).a(b, false).a(N, false));
      this.a(yz.d);
   }

   public boolean c() {
      return false;
   }

   public alz a(int var1) {
      return this.Q().a(O, cq.b(var1)).a(a, (var1 & 4) != 0).a(b, (var1 & 8) != 0);
   }

   public boolean b(adq var1, cj var2) {
      return (Boolean)var1.p(var2).b(a);
   }

   public void a(adq var1, cj var2) {
      cq.a var3 = ((cq)var1.p(var2).b(O)).k();
      if (var3 == cq.a.c) {
         this.a(0.0F, 0.0F, 0.375F, 1.0F, 1.0F, 0.625F);
      } else {
         this.a(0.375F, 0.0F, 0.0F, 0.625F, 1.0F, 1.0F);
      }

   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      if ((Boolean)var3.b(a)) {
         var3 = var3.a(a, false);
         var1.a((cj)var2, (alz)var3, 2);
      } else {
         cq var9 = cq.a((double)var4.y);
         if (var3.b(O) == var9.d()) {
            var3 = var3.a(O, var9);
         }

         var3 = var3.a(a, true);
         var1.a((cj)var2, (alz)var3, 2);
      }

      var1.a(var4, (Boolean)var3.b(a) ? 1003 : 1006, var2, 0);
      return true;
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      if (!var1.D) {
         boolean var5 = var1.z(var2);
         if (var5 || var4.i()) {
            if (var5 && !(Boolean)var3.b(a) && !(Boolean)var3.b(b)) {
               var1.a((cj)var2, (alz)var3.a(a, true).a(b, true), 2);
               var1.a((wn)null, 1003, var2, 0);
            } else if (!var5 && (Boolean)var3.b(a) && (Boolean)var3.b(b)) {
               var1.a((cj)var2, (alz)var3.a(a, false).a(b, false), 2);
               var1.a((wn)null, 1006, var2, 0);
            } else if (var5 != (Boolean)var3.b(b)) {
               var1.a((cj)var2, (alz)var3.a(b, var5), 2);
            }
         }

      }
   }

   protected ama e() {
      return new ama(this, new amo[]{O, a, b, N});
   }

   public aug a(adm var1, cj var2, alz var3) {
      if ((Boolean)var3.b(a)) {
         return null;
      } else {
         cq.a var4 = ((cq)var3.b(O)).k();
         return var4 == cq.a.c ? new aug((double)var2.n(), (double)var2.o(), (double)((float)var2.p() + 0.375F), (double)(var2.n() + 1), (double)((float)var2.o() + 1.5F), (double)((float)var2.p() + 0.625F)) : new aug((double)((float)var2.n() + 0.375F), (double)var2.o(), (double)var2.p(), (double)((float)var2.n() + 0.625F), (double)((float)var2.o() + 1.5F), (double)(var2.p() + 1));
      }
   }

   public boolean a(adq var1, cj var2, cq var3) {
      return true;
   }

   public alz a(alz var1, adq var2, cj var3) {
      cq.a var4 = ((cq)var1.b(O)).k();
      if (var4 == cq.a.c && (var2.p(var3.e()).c() == afi.bZ || var2.p(var3.f()).c() == afi.bZ) || var4 == cq.a.a && (var2.p(var3.c()).c() == afi.bZ || var2.p(var3.d()).c() == afi.bZ)) {
         var1 = var1.a(N, true);
      }

      return var1;
   }

   public boolean d(adm var1, cj var2) {
      return var1.p(var2.b()).c().t().a() ? super.d(var1, var2) : false;
   }

   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      return this.Q().a(O, var8.aP()).a(a, false).a(b, false).a(N, false);
   }

   public boolean d() {
      return false;
   }
}
