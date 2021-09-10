public class ajv extends ajl {
   public static final amn a = amn.a("rotation", 0, 15);

   public void a(adm var1, cj var2, alz var3, afh var4) {
      if (!var1.p(var2.b()).c().t().a()) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
      }

      super.a(var1, var2, var3, var4);
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   public int c(alz var1) {
      return (Integer)var1.b(a);
   }

   public alz a(int var1) {
      return this.Q().a(a, var1);
   }

   public ajv() {
      this.j(this.M.b().a(a, 0));
   }
}
