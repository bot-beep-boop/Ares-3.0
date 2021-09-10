public class bkh extends bjo<wi> {
   private static final jy a = new jy("textures/entity/villager/villager.png");
   private static final jy m = new jy("textures/entity/villager/butcher.png");
   private static final jy e = new jy("textures/entity/villager/farmer.png");
   private static final jy l = new jy("textures/entity/villager/smith.png");
   private static final jy j = new jy("textures/entity/villager/librarian.png");
   private static final jy k = new jy("textures/entity/villager/priest.png");

   protected void a(wi var1, float var2) {
      float var3 = 0.9375F;
      if (var1.l() < 0) {
         var3 = (float)((double)var3 * 0.5D);
         this.c = 0.25F;
      } else {
         this.c = 0.5F;
      }

      bfl.a(var3, var3, var3);
   }

   public bci g() {
      return (bci)super.b();
   }

   public bbo b() {
      return this.g();
   }

   public bkh(biu var1) {
      super(var1, new bci(0.0F), 0.5F);
      this.a((blb)(new bks(this.g().a)));
   }

   protected jy a(pk var1) {
      return this.a((wi)var1);
   }

   protected jy a(wi var1) {
      switch(var1.cl()) {
      case 0:
         return e;
      case 1:
         return j;
      case 2:
         return k;
      case 3:
         return l;
      case 4:
         return m;
      default:
         return a;
      }
   }

   protected void a(pr var1, float var2) {
      this.a((wi)var1, var2);
   }
}
