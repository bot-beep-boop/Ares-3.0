public class bii extends bjo<tk> {
   private static final jy a = new jy("textures/entity/bat.png");

   protected void a(pr var1, float var2) {
      this.a((tk)var1, var2);
   }

   public bii(biu var1) {
      super(var1, new bav(), 0.25F);
   }

   protected jy a(tk var1) {
      return a;
   }

   protected void a(tk var1, float var2) {
      bfl.a(0.35F, 0.35F, 0.35F);
   }

   protected jy a(pk var1) {
      return this.a((tk)var1);
   }

   protected void a(tk var1, float var2, float var3, float var4) {
      if (!var1.n()) {
         bfl.b(0.0F, ns.b(var2 * 0.3F) * 0.1F, 0.0F);
      } else {
         bfl.b(0.0F, -0.1F, 0.0F);
      }

      super.a(var1, var2, var3, var4);
   }

   protected void a(pr var1, float var2, float var3, float var4) {
      this.a((tk)var1, var2, var3, var4);
   }
}
