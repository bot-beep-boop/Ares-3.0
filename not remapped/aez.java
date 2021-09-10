import com.google.common.base.Predicate;
import java.util.List;

public class aez extends agr {
   public static final amn b;
   public static final aml a;

   protected aez() {
      super(arm.g);
      this.j(this.M.b().a(a, cq.c).a(b, 0));
      this.e(0);
      this.a((yz)yz.c);
   }

   protected ama e() {
      return new ama(this, new amo[]{a, b});
   }

   public boolean c() {
      return false;
   }

   public alz a(int var1) {
      return this.Q().a(a, cq.b(var1 & 3)).a(b, (var1 & 15) >> 2);
   }

   public boolean d() {
      return false;
   }

   static {
      a = aml.a("facing", (Predicate)cq.c.a);
      b = amn.a("damage", 0, 2);
   }

   public boolean a(adq var1, cj var2, cq var3) {
      return true;
   }

   public void a(adq var1, cj var2) {
      cq var3 = (cq)var1.p(var2).b(a);
      if (var3.k() == cq.a.a) {
         this.a(0.0F, 0.0F, 0.125F, 1.0F, 1.0F, 0.875F);
      } else {
         this.a(0.125F, 0.0F, 0.0F, 0.875F, 1.0F, 1.0F);
      }

   }

   public int a(alz var1) {
      return (Integer)var1.b(b);
   }

   public void a_(adm var1, cj var2) {
      var1.b(1022, var2, 0);
   }

   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      cq var9 = var8.aP().e();
      return super.a(var1, var2, var3, var4, var5, var6, var7, var8).a(a, var9).a(b, var7 >> 2);
   }

   public alz b(alz var1) {
      return this.Q().a(a, cq.d);
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      var3.add(new zx(var1, 1, 0));
      var3.add(new zx(var1, 1, 1));
      var3.add(new zx(var1, 1, 2));
   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      if (!var1.D) {
         var4.a((ol)(new aez.a(var1, var2)));
      }

      return true;
   }

   protected void a(uy var1) {
      var1.a(true);
   }

   public int c(alz var1) {
      byte var2 = 0;
      int var3 = var2 | ((cq)var1.b(a)).b();
      var3 |= (Integer)var1.b(b) << 2;
      return var3;
   }

   public static class a implements ol {
      private final cj b;
      private final adm a;

      public String k() {
         return "minecraft:anvil";
      }

      public String e_() {
         return "anvil";
      }

      public eu f_() {
         return new fb(afi.cf.a() + ".name", new Object[0]);
      }

      public a(adm var1, cj var2) {
         this.a = var1;
         this.b = var2;
      }

      public xi a(wm var1, wn var2) {
         return new xk(var1, this.a, this.b, var2);
      }

      public boolean l_() {
         return false;
      }
   }
}
