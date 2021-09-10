public class bje<T extends ps> extends bjo<T> {
   protected bbj a;
   private static final jy j = new jy("textures/entity/steve.png");
   protected float e;

   protected jy a(pk var1) {
      return this.a((ps)var1);
   }

   public bje(biu var1, bbj var2, float var3, float var4) {
      super(var1, var2, var3);
      this.a = var2;
      this.e = var4;
      this.a((blb)(new bks(var2.e)));
   }

   protected jy a(T var1) {
      return j;
   }

   public bje(biu var1, bbj var2, float var3) {
      this(var1, var2, var3, 1.0F);
      this.a((blb)(new bky(this)));
   }

   public void C_() {
      bfl.b(0.0F, 0.1875F, 0.0F);
   }
}
