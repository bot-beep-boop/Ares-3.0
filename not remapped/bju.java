public class bju extends bjo<tu> {
   private static final jy l = new jy("textures/entity/rabbit/salt.png");
   private static final jy o = new jy("textures/entity/rabbit/caerbannog.png");
   private static final jy j = new jy("textures/entity/rabbit/black.png");
   private static final jy m = new jy("textures/entity/rabbit/white_splotched.png");
   private static final jy k = new jy("textures/entity/rabbit/gold.png");
   private static final jy e = new jy("textures/entity/rabbit/white.png");
   private static final jy a = new jy("textures/entity/rabbit/brown.png");
   private static final jy n = new jy("textures/entity/rabbit/toast.png");

   protected jy a(pk var1) {
      return this.a((tu)var1);
   }

   protected jy a(tu var1) {
      String var2 = a.a(var1.e_());
      if (var2 != null && var2.equals("Toast")) {
         return n;
      } else {
         switch(var1.cn()) {
         case 0:
         default:
            return a;
         case 1:
            return e;
         case 2:
            return j;
         case 3:
            return m;
         case 4:
            return k;
         case 5:
            return l;
         case 99:
            return o;
         }
      }
   }

   public bju(biu var1, bbo var2, float var3) {
      super(var1, var2, var3);
   }
}
