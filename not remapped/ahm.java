public class ahm extends ajg {
   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      return super.a(var1, var2, var3, var4, var5, var6, var7, var8).a(N, var3.k());
   }

   public alz a(int var1) {
      cq.a var2 = cq.a.b;
      int var3 = var1 & 12;
      if (var3 == 4) {
         var2 = cq.a.a;
      } else if (var3 == 8) {
         var2 = cq.a.c;
      }

      return this.Q().a(N, var2);
   }

   public int c(alz var1) {
      int var2 = 0;
      cq.a var3 = (cq.a)var1.b(N);
      if (var3 == cq.a.a) {
         var2 |= 4;
      } else if (var3 == cq.a.c) {
         var2 |= 8;
      }

      return var2;
   }

   protected zx i(alz var1) {
      return new zx(zw.a((afh)this), 1, 0);
   }

   public ahm() {
      super(arm.b, arn.t);
      this.j(this.M.b().a(N, cq.a.b));
      this.a(yz.b);
   }

   protected ama e() {
      return new ama(this, new amo[]{N});
   }
}
