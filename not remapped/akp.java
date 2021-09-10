public class akp extends afd {
   private final int b;
   public static final amn a = amn.a("power", 0, 15);

   protected akp(arm var1, int var2, arn var3) {
      super(var1, var3);
      this.j(this.M.b().a(a, 0));
      this.b = var2;
   }

   protected alz a(alz var1, int var2) {
      return var1.a(a, var2);
   }

   public alz a(int var1) {
      return this.Q().a(a, var1);
   }

   protected int e(alz var1) {
      return (Integer)var1.b(a);
   }

   public int a(adm var1) {
      return 10;
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   protected int f(adm var1, cj var2) {
      int var3 = Math.min(var1.a(pk.class, this.a(var2)).size(), this.b);
      if (var3 > 0) {
         float var4 = (float)Math.min(this.b, var3) / (float)this.b;
         return ns.f(var4 * 15.0F);
      } else {
         return 0;
      }
   }

   protected akp(arm var1, int var2) {
      this(var1, var2, var1.r());
   }

   public int c(alz var1) {
      return (Integer)var1.b(a);
   }
}
