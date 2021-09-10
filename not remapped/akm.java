import com.google.common.base.Predicate;

public class akm extends ajl {
   public static final aml a;

   public int c(alz var1) {
      return ((cq)var1.b(a)).a();
   }

   public akm() {
      this.j(this.M.b().a(a, cq.c));
   }

   static {
      a = aml.a("facing", (Predicate)cq.c.a);
   }

   public alz a(int var1) {
      cq var2 = cq.a(var1);
      if (var2.k() == cq.a.b) {
         var2 = cq.c;
      }

      return this.Q().a(a, var2);
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      cq var5 = (cq)var3.b(a);
      if (!var1.p(var2.a(var5.d())).c().t().a()) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
      }

      super.a(var1, var2, var3, var4);
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   public void a(adq var1, cj var2) {
      cq var3 = (cq)var1.p(var2).b(a);
      float var4 = 0.28125F;
      float var5 = 0.78125F;
      float var6 = 0.0F;
      float var7 = 1.0F;
      float var8 = 0.125F;
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      switch(var3) {
      case c:
         this.a(var6, var4, 1.0F - var8, var7, var5, 1.0F);
         break;
      case d:
         this.a(var6, var4, 0.0F, var7, var5, var8);
         break;
      case e:
         this.a(1.0F - var8, var4, var6, 1.0F, var5, var7);
         break;
      case f:
         this.a(0.0F, var4, var6, var8, var5, var7);
      }

   }
}
