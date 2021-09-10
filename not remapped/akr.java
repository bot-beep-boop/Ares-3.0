import java.util.List;
import java.util.Random;

public abstract class akr extends ahh {
   public static final amm<aio.a> b = amm.a("variant", aio.a.class);

   public akr() {
      super(arm.d);
      alz var1 = this.M.b();
      if (!this.l()) {
         var1 = var1.a(a, ahh.a.b);
      }

      this.j(var1.a(b, aio.a.a));
      this.a((yz)yz.b);
   }

   public arn g(alz var1) {
      return ((aio.a)var1.b(b)).c();
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      if (var1 != zw.a((afh)afi.bL)) {
         aio.a[] var4 = aio.a.values();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            aio.a var7 = var4[var6];
            var3.add(new zx(var1, 1, var7.a()));
         }

      }
   }

   protected ama e() {
      return this.l() ? new ama(this, new amo[]{b}) : new ama(this, new amo[]{a, b});
   }

   public alz a(int var1) {
      alz var2 = this.Q().a(b, aio.a.a(var1 & 7));
      if (!this.l()) {
         var2 = var2.a(a, (var1 & 8) == 0 ? ahh.a.b : ahh.a.a);
      }

      return var2;
   }

   public zw a(alz var1, Random var2, int var3) {
      return zw.a((afh)afi.bM);
   }

   public int c(alz var1) {
      byte var2 = 0;
      int var3 = var2 | ((aio.a)var1.b(b)).a();
      if (!this.l() && var1.b(a) == ahh.a.a) {
         var3 |= 8;
      }

      return var3;
   }

   public int a(alz var1) {
      return ((aio.a)var1.b(b)).a();
   }

   public amo<?> n() {
      return b;
   }

   public Object a(zx var1) {
      return aio.a.a(var1.i() & 7);
   }

   public String b(int var1) {
      return super.a() + "." + aio.a.a(var1).d();
   }

   public zw c(adm var1, cj var2) {
      return zw.a((afh)afi.bM);
   }
}
