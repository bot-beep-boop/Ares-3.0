public class bjx extends bje<wa> {
   private static final jy j = new jy("textures/entity/skeleton/skeleton.png");
   private static final jy k = new jy("textures/entity/skeleton/wither_skeleton.png");

   protected jy a(pk var1) {
      return this.a((wa)var1);
   }

   protected void a(pr var1, float var2) {
      this.a((wa)var1, var2);
   }

   public bjx(biu var1) {
      super(var1, new bca(), 0.5F);
      this.a((blb)(new bky(this)));
      this.a((blb)(new bkx(this, this) {
         final bjx a;

         {
            this.a = var1;
         }

         protected void a() {
            this.c = new bca(0.5F, true);
            this.d = new bca(1.0F, true);
         }
      }));
   }

   protected jy a(wa var1) {
      return var1.cm() == 1 ? k : j;
   }

   public void C_() {
      bfl.b(0.09375F, 0.1875F, 0.0F);
   }

   protected jy a(ps var1) {
      return this.a((wa)var1);
   }

   protected void a(wa var1, float var2) {
      if (var1.cm() == 1) {
         bfl.a(1.2F, 1.2F, 1.2F);
      }

   }
}
