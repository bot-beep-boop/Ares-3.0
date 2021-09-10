import java.util.Iterator;
import java.util.List;

public class ait extends afd {
   public static final amk a = amk.a("powered");
   private final ait.a b;

   public int c(alz var1) {
      return (Boolean)var1.b(a) ? 1 : 0;
   }

   protected int e(alz var1) {
      return (Boolean)var1.b(a) ? 15 : 0;
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   protected int f(adm var1, cj var2) {
      aug var3 = this.a(var2);
      List var4;
      switch(this.b) {
      case a:
         var4 = var1.b((pk)null, (aug)var3);
         break;
      case b:
         var4 = var1.a(pr.class, var3);
         break;
      default:
         return 0;
      }

      if (!var4.isEmpty()) {
         Iterator var5 = var4.iterator();

         while(var5.hasNext()) {
            pk var6 = (pk)var5.next();
            if (!var6.aI()) {
               return 15;
            }
         }
      }

      return 0;
   }

   protected ait(arm var1, ait.a var2) {
      super(var1);
      this.j(this.M.b().a(a, false));
      this.b = var2;
   }

   protected alz a(alz var1, int var2) {
      return var1.a(a, var2 > 0);
   }

   public alz a(int var1) {
      return this.Q().a(a, var1 == 1);
   }

   public static enum a {
      b,
      a;

      private static final ait.a[] c = new ait.a[]{a, b};
   }
}
