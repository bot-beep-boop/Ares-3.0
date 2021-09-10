import java.util.List;

public class aks extends afh {
   public static final amm<zd> a = amm.a("color", zd.class);

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   public int a(alz var1) {
      return ((zd)var1.b(a)).a();
   }

   public void j() {
      this.b(0);
   }

   private boolean e(adm var1, cj var2, alz var3) {
      if (!this.e(var1, var2)) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
         return false;
      } else {
         return true;
      }
   }

   public arn g(alz var1) {
      return ((zd)var1.b(a)).e();
   }

   private boolean e(adm var1, cj var2) {
      return !var1.d(var2.b());
   }

   protected aks() {
      super(arm.r);
      this.j(this.M.b().a(a, zd.a));
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
      this.a(true);
      this.a(yz.c);
      this.b(0);
   }

   public alz a(int var1) {
      return this.Q().a(a, zd.b(var1));
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      this.e(var1, var2, var3);
   }

   protected void b(int var1) {
      byte var2 = 0;
      float var3 = (float)(1 * (1 + var2)) / 16.0F;
      this.a(0.0F, 0.0F, 0.0F, 1.0F, var3, 1.0F);
   }

   public boolean a(adq var1, cj var2, cq var3) {
      return var3 == cq.b ? true : super.a(var1, var2, var3);
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      for(int var4 = 0; var4 < 16; ++var4) {
         var3.add(new zx(var1, 1, var4));
      }

   }

   public void a(adq var1, cj var2) {
      this.b(0);
   }

   public boolean d(adm var1, cj var2) {
      return super.d(var1, var2) && this.e(var1, var2);
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public int c(alz var1) {
      return ((zd)var1.b(a)).a();
   }
}
