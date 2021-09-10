import com.google.common.base.Predicate;
import java.util.List;

public class ahn extends afc {
   public static final amk b = amk.a("enabled");
   public static final aml a = aml.a("facing", new Predicate<cq>() {
      public boolean a(cq var1) {
         return var1 != cq.b;
      }

      public boolean apply(Object var1) {
         return this.a((cq)var1);
      }
   });

   public void a(adm var1, cj var2, alz var3, aug var4, List<aug> var5, pk var6) {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      float var7 = 0.125F;
      this.a(0.0F, 0.0F, 0.0F, var7, 1.0F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var7);
      super.a(var1, var2, var3, var4, var5, var6);
      this.a(1.0F - var7, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      this.a(0.0F, 0.0F, 1.0F - var7, 1.0F, 1.0F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void a(adm var1, cj var2, alz var3, pr var4, zx var5) {
      super.a(var1, var2, var3, var4, var5);
      if (var5.s()) {
         akw var6 = var1.s(var2);
         if (var6 instanceof alj) {
            ((alj)var6).a(var5.q());
         }
      }

   }

   public boolean O() {
      return true;
   }

   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      cq var9 = var3.d();
      if (var9 == cq.b) {
         var9 = cq.a;
      }

      return this.Q().a(a, var9).a(b, true);
   }

   public void c(adm var1, cj var2, alz var3) {
      this.e(var1, var2, var3);
   }

   public ahn() {
      super(arm.f, arn.m);
      this.j(this.M.b().a(a, cq.a).a(b, true));
      this.a(yz.d);
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public static cq b(int var0) {
      return cq.a(var0 & 7);
   }

   public boolean c() {
      return false;
   }

   public void a(adq var1, cj var2) {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public static boolean f(int var0) {
      return (var0 & 8) != 8;
   }

   public alz a(int var1) {
      return this.Q().a(a, b(var1)).a(b, f(var1));
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      this.e(var1, var2, var3);
   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      if (var1.D) {
         return true;
      } else {
         akw var9 = var1.s(var2);
         if (var9 instanceof alj) {
            var4.a((og)((alj)var9));
            var4.b(na.P);
         }

         return true;
      }
   }

   public akw a(adm var1, int var2) {
      return new alj();
   }

   public boolean a(adq var1, cj var2, cq var3) {
      return true;
   }

   public void b(adm var1, cj var2, alz var3) {
      akw var4 = var1.s(var2);
      if (var4 instanceof alj) {
         oi.a(var1, (cj)var2, (alj)var4);
         var1.e(var2, this);
      }

      super.b(var1, var2, var3);
   }

   protected ama e() {
      return new ama(this, new amo[]{a, b});
   }

   public int l(adm var1, cj var2) {
      return xi.a(var1.s(var2));
   }

   public int b() {
      return 3;
   }

   public int c(alz var1) {
      byte var2 = 0;
      int var3 = var2 | ((cq)var1.b(a)).a();
      if (!(Boolean)var1.b(b)) {
         var3 |= 8;
      }

      return var3;
   }

   public boolean d() {
      return false;
   }

   private void e(adm var1, cj var2, alz var3) {
      boolean var4 = !var1.z(var2);
      if (var4 != (Boolean)var3.b(b)) {
         var1.a((cj)var2, (alz)var3.a(b, var4), 4);
      }

   }

   public adf m() {
      return adf.b;
   }
}
