import java.util.List;
import java.util.Random;

public class ajs extends ahj {
   public static final amm<zd> a = amm.a("color", zd.class);

   public void a(zw var1, yz var2, List<zx> var3) {
      zd[] var4 = zd.values();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         zd var7 = var4[var6];
         var3.add(new zx(var1, 1, var7.a()));
      }

   }

   public adf m() {
      return adf.d;
   }

   public ajs(arm var1) {
      super(var1, false);
      this.j(this.M.b().a(a, zd.a));
      this.a((yz)yz.b);
   }

   public int c(alz var1) {
      return ((zd)var1.b(a)).a();
   }

   public arn g(alz var1) {
      return ((zd)var1.b(a)).e();
   }

   public alz a(int var1) {
      return this.Q().a(a, zd.b(var1));
   }

   public boolean d() {
      return false;
   }

   public void c(adm var1, cj var2, alz var3) {
      if (!var1.D) {
         aff.f(var1, var2);
      }

   }

   public int a(Random var1) {
      return 0;
   }

   public void b(adm var1, cj var2, alz var3) {
      if (!var1.D) {
         aff.f(var1, var2);
      }

   }

   public int a(alz var1) {
      return ((zd)var1.b(a)).a();
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   protected boolean I() {
      return true;
   }
}
