public class bjb extends bjo<vs> {
   private float e;
   private static final jy a = new jy("textures/entity/zombie/zombie.png");

   protected void a(pr var1, float var2) {
      this.a((vs)var1, var2);
   }

   protected void a(vs var1, float var2) {
      bfl.a(this.e, this.e, this.e);
   }

   public bjb(biu var1, bbo var2, float var3, float var4) {
      super(var1, var2, var3 * var4);
      this.e = var4;
      this.a((blb)(new bky(this)));
      this.a((blb)(new bkx(this, this) {
         final bjb a;

         protected void a() {
            this.c = new bcn(0.5F, true);
            this.d = new bcn(1.0F, true);
         }

         {
            this.a = var1;
         }
      }));
   }

   protected jy a(vs var1) {
      return a;
   }

   public void C_() {
      bfl.b(0.0F, 0.1875F, 0.0F);
   }

   protected jy a(pk var1) {
      return this.a((vs)var1);
   }
}
