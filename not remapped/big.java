public class big extends bjl<um> {
   public static final jy a = new jy("textures/entity/armorstand/wood.png");

   protected jy a(pk var1) {
      return this.a((um)var1);
   }

   public bbo b() {
      return this.a();
   }

   protected jy a(um var1) {
      return a;
   }

   protected void a(pr var1, float var2, float var3, float var4) {
      this.a((um)var1, var2, var3, var4);
   }

   protected void a(um var1, float var2, float var3, float var4) {
      bfl.b(180.0F - var3, 0.0F, 1.0F, 0.0F);
   }

   public bat a() {
      return (bat)super.b();
   }

   protected boolean a(pr var1) {
      return this.b((um)var1);
   }

   public big(biu var1) {
      super(var1, new bat(), 0.0F);
      bkx var2 = new bkx(this, this) {
         final big a;

         protected void a() {
            this.c = new bas(0.5F);
            this.d = new bas(1.0F);
         }

         {
            this.a = var1;
         }
      };
      this.a((blb)var2);
      this.a((blb)(new bky(this)));
      this.a((blb)(new bks(this.a().e)));
   }

   protected boolean b(um var1) {
      return var1.aN();
   }

   protected boolean b(pk var1) {
      return this.b((um)var1);
   }
}
