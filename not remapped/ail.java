import com.google.common.base.Predicate;
import java.util.List;

public class ail extends ahw {
   public static final amm<aio.a> b = amm.a("variant", aio.a.class, new Predicate<aio.a>() {
      public boolean a(aio.a var1) {
         return var1.a() < 4;
      }

      public boolean apply(Object var1) {
         return this.a((aio.a)var1);
      }
   });

   public int a(alz var1) {
      return ((aio.a)var1.b(b)).a();
   }

   public alz a(int var1) {
      alz var2 = this.Q().a(b, aio.a.a((var1 & 3) % 4));
      switch(var1 & 12) {
      case 0:
         var2 = var2.a(a, ahw.a.b);
         break;
      case 4:
         var2 = var2.a(a, ahw.a.a);
         break;
      case 8:
         var2 = var2.a(a, ahw.a.c);
         break;
      default:
         var2 = var2.a(a, ahw.a.d);
      }

      return var2;
   }

   public int c(alz var1) {
      byte var2 = 0;
      int var3 = var2 | ((aio.a)var1.b(b)).a();
      switch((ahw.a)var1.b(a)) {
      case a:
         var3 |= 4;
         break;
      case c:
         var3 |= 8;
         break;
      case d:
         var3 |= 12;
      }

      return var3;
   }

   public ail() {
      this.j(this.M.b().a(b, aio.a.a).a(a, ahw.a.b));
   }

   protected ama e() {
      return new ama(this, new amo[]{b, a});
   }

   public arn g(alz var1) {
      aio.a var2 = (aio.a)var1.b(b);
      switch((ahw.a)var1.b(a)) {
      case a:
      case c:
      case d:
      default:
         switch(var2) {
         case a:
         default:
            return aio.a.b.c();
         case b:
            return aio.a.f.c();
         case c:
            return arn.p;
         case d:
            return aio.a.b.c();
         }
      case b:
         return var2.c();
      }
   }

   protected zx i(alz var1) {
      return new zx(zw.a((afh)this), 1, ((aio.a)var1.b(b)).a());
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      var3.add(new zx(var1, 1, aio.a.a.a()));
      var3.add(new zx(var1, 1, aio.a.b.a()));
      var3.add(new zx(var1, 1, aio.a.c.a()));
      var3.add(new zx(var1, 1, aio.a.d.a()));
   }
}
