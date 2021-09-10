public class bka<T extends wc> extends bjo<T> {
   private static final jy a = new jy("textures/entity/spider/spider.png");

   public bka(biu var1) {
      super(var1, new bce(), 1.0F);
      this.a((blb)(new blf(this)));
   }

   protected jy a(pk var1) {
      return this.a((wc)var1);
   }

   protected float b(pr var1) {
      return this.b((wc)var1);
   }

   protected float b(T var1) {
      return 180.0F;
   }

   protected jy a(T var1) {
      return a;
   }
}
