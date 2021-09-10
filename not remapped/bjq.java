public class bjq extends bjo<ts> {
   private static final jy e = new jy("textures/entity/cat/ocelot.png");
   private static final jy a = new jy("textures/entity/cat/black.png");
   private static final jy k = new jy("textures/entity/cat/siamese.png");
   private static final jy j = new jy("textures/entity/cat/red.png");

   protected jy a(pk var1) {
      return this.a((ts)var1);
   }

   protected jy a(ts var1) {
      switch(var1.ct()) {
      case 0:
      default:
         return e;
      case 1:
         return a;
      case 2:
         return j;
      case 3:
         return k;
      }
   }

   protected void a(ts var1, float var2) {
      super.a(var1, var2);
      if (var1.cl()) {
         bfl.a(0.8F, 0.8F, 0.8F);
      }

   }

   public bjq(biu var1, bbo var2, float var3) {
      super(var1, var2, var3);
   }

   protected void a(pr var1, float var2) {
      this.a((ts)var1, var2);
   }
}
