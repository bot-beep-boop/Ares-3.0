import com.google.common.base.Predicate;
import java.util.List;
import java.util.Random;

public class ago extends afh {
   public static final aml a;
   public static final amk b;

   public void j() {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
   }

   public boolean c() {
      return false;
   }

   public zw a(alz var1, Random var2, int var3) {
      return null;
   }

   public int c(alz var1) {
      byte var2 = 0;
      int var3 = var2 | ((cq)var1.b(a)).b();
      if ((Boolean)var1.b(b)) {
         var3 |= 4;
      }

      return var3;
   }

   static {
      a = aml.a("facing", (Predicate)cq.c.a);
      b = amk.a("eye");
   }

   public void a(adm var1, cj var2, alz var3, aug var4, List<aug> var5, pk var6) {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      if ((Boolean)var1.p(var2).b(b)) {
         this.a(0.3125F, 0.8125F, 0.3125F, 0.6875F, 1.0F, 0.6875F);
         super.a(var1, var2, var3, var4, var5, var6);
      }

      this.j();
   }

   public alz a(int var1) {
      return this.Q().a(b, (var1 & 4) != 0).a(a, cq.b(var1 & 3));
   }

   public ago() {
      super(arm.e, arn.C);
      this.j(this.M.b().a(a, cq.c).a(b, false));
   }

   protected ama e() {
      return new ama(this, new amo[]{a, b});
   }

   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      return this.Q().a(a, var8.aP().d()).a(b, false);
   }

   public boolean O() {
      return true;
   }

   public int l(adm var1, cj var2) {
      return (Boolean)var1.p(var2).b(b) ? 15 : 0;
   }
}
