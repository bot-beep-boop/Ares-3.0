import java.util.List;

public class afv extends afh {
   public static final amm<zd> a = amm.a("color", zd.class);

   public int c(alz var1) {
      return ((zd)var1.b(a)).a();
   }

   public afv(arm var1) {
      super(var1);
      this.j(this.M.b().a(a, zd.a));
      this.a(yz.b);
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   public arn g(alz var1) {
      return ((zd)var1.b(a)).e();
   }

   public alz a(int var1) {
      return this.Q().a(a, zd.b(var1));
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      zd[] var4 = zd.values();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         zd var7 = var4[var6];
         var3.add(new zx(var1, 1, var7.a()));
      }

   }

   public int a(alz var1) {
      return ((zd)var1.b(a)).a();
   }
}
