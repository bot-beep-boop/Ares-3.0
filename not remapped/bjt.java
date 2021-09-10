public class bjt extends bje<vw> {
   private static final jy j = new jy("textures/entity/zombie_pigman.png");

   public bjt(biu var1) {
      super(var1, new bcn(), 0.5F, 1.0F);
      this.a((blb)(new bky(this)));
      this.a((blb)(new bkx(this, this) {
         final bjt a;

         protected void a() {
            this.c = new bcn(0.5F, true);
            this.d = new bcn(1.0F, true);
         }

         {
            this.a = var1;
         }
      }));
   }

   protected jy a(vw var1) {
      return j;
   }

   protected jy a(ps var1) {
      return this.a((vw)var1);
   }

   protected jy a(pk var1) {
      return this.a((vw)var1);
   }
}
