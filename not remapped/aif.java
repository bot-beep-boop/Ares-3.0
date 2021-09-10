import com.google.common.base.Predicate;
import java.util.List;

public class aif extends ahs {
   public static final amm<aio.a> Q = amm.a("variant", aio.a.class, new Predicate<aio.a>() {
      public boolean apply(Object var1) {
         return this.a((aio.a)var1);
      }

      public boolean a(aio.a var1) {
         return var1.a() >= 4;
      }
   });

   public int j(adm var1, cj var2) {
      alz var3 = var1.p(var2);
      return var3.c().c(var3) & 3;
   }

   protected zx i(alz var1) {
      return new zx(zw.a((afh)this), 1, ((aio.a)var1.b(Q)).a() - 4);
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      var3.add(new zx(var1, 1, 0));
      var3.add(new zx(var1, 1, 1));
   }

   public aif() {
      this.j(this.M.b().a(Q, aio.a.e).a(b, true).a(a, true));
   }

   public void a(adm var1, wn var2, cj var3, alz var4, akw var5) {
      if (!var1.D && var2.bZ() != null && var2.bZ().b() == zy.be) {
         var2.b(na.ab[afh.a((afh)this)]);
         a(var1, var3, new zx(zw.a((afh)this), 1, ((aio.a)var4.b(Q)).a() - 4));
      } else {
         super.a(var1, var2, var3, var4, var5);
      }
   }

   protected void a(adm var1, cj var2, alz var3, int var4) {
      if (var3.b(Q) == aio.a.f && var1.s.nextInt(var4) == 0) {
         a(var1, var2, new zx(zy.e, 1, 0));
      }

   }

   public int a(alz var1) {
      return ((aio.a)var1.b(Q)).a();
   }

   public int c(alz var1) {
      byte var2 = 0;
      int var3 = var2 | ((aio.a)var1.b(Q)).a() - 4;
      if (!(Boolean)var1.b(a)) {
         var3 |= 4;
      }

      if ((Boolean)var1.b(b)) {
         var3 |= 8;
      }

      return var3;
   }

   protected ama e() {
      return new ama(this, new amo[]{Q, b, a});
   }

   public alz a(int var1) {
      return this.Q().a(Q, this.b(var1)).a(a, (var1 & 4) == 0).a(b, (var1 & 8) > 0);
   }

   public aio.a b(int var1) {
      return aio.a.a((var1 & 3) + 4);
   }
}
