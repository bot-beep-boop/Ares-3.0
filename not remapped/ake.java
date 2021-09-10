public class ake extends afh {
   public static final amk a = amk.a("explode");

   public void a(adm var1, cj var2, alz var3, afh var4) {
      if (var1.z(var2)) {
         this.d(var1, var2, var3.a(a, true));
         var1.g(var2);
      }

   }

   public void c(adm var1, cj var2, alz var3) {
      super.c(var1, var2, var3);
      if (var1.z(var2)) {
         this.d(var1, var2, var3.a(a, true));
         var1.g(var2);
      }

   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      if (var4.bZ() != null) {
         zw var9 = var4.bZ().b();
         if (var9 == zy.d || var9 == zy.bL) {
            this.a(var1, var2, var3.a(a, true), (pr)var4);
            var1.g(var2);
            if (var9 == zy.d) {
               var4.bZ().a(1, (pr)var4);
            } else if (!var4.bA.d) {
               --var4.bZ().b;
            }

            return true;
         }
      }

      return super.a(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public boolean a(adi var1) {
      return false;
   }

   public alz a(int var1) {
      return this.Q().a(a, (var1 & 1) > 0);
   }

   public void a(adm var1, cj var2, alz var3, pk var4) {
      if (!var1.D && var4 instanceof wq) {
         wq var5 = (wq)var4;
         if (var5.at()) {
            this.a(var1, var2, var1.p(var2).a(a, true), var5.c instanceof pr ? (pr)var5.c : null);
            var1.g(var2);
         }
      }

   }

   public void d(adm var1, cj var2, alz var3) {
      this.a(var1, var2, var3, (pr)null);
   }

   public int c(alz var1) {
      return (Boolean)var1.b(a) ? 1 : 0;
   }

   public void a(adm var1, cj var2, alz var3, pr var4) {
      if (!var1.D) {
         if ((Boolean)var3.b(a)) {
            vj var5 = new vj(var1, (double)((float)var2.n() + 0.5F), (double)var2.o(), (double)((float)var2.p() + 0.5F), var4);
            var1.d((pk)var5);
            var1.a((pk)var5, "game.tnt.primed", 1.0F, 1.0F);
         }

      }
   }

   public ake() {
      super(arm.u);
      this.j(this.M.b().a(a, false));
      this.a(yz.d);
   }

   public void a(adm var1, cj var2, adi var3) {
      if (!var1.D) {
         vj var4 = new vj(var1, (double)((float)var2.n() + 0.5F), (double)var2.o(), (double)((float)var2.p() + 0.5F), var3.c());
         var4.a = var1.s.nextInt(var4.a / 4) + var4.a / 8;
         var1.d((pk)var4);
      }
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }
}
