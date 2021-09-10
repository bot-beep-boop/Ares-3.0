public class bim extends bjo<tn> {
   private static final jy a = new jy("textures/entity/chicken.png");

   protected float a(tn var1, float var2) {
      float var3 = var1.bq + (var1.bm - var1.bq) * var2;
      float var4 = var1.bp + (var1.bo - var1.bp) * var2;
      return (ns.a(var3) + 1.0F) * var4;
   }

   public bim(biu var1, bbo var2, float var3) {
      super(var1, var2, var3);
   }

   protected jy a(tn var1) {
      return a;
   }

   protected jy a(pk var1) {
      return this.a((tn)var1);
   }

   protected float b(pr var1, float var2) {
      return this.a((tn)var1, var2);
   }
}
