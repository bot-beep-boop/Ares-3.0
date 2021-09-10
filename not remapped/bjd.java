import com.google.common.collect.Maps;
import java.util.Map;

public class bjd extends bjo<tp> {
   private static final jy j = new jy("textures/entity/horse/mule.png");
   private static final jy m = new jy("textures/entity/horse/horse_skeleton.png");
   private static final jy l = new jy("textures/entity/horse/horse_zombie.png");
   private static final jy e = new jy("textures/entity/horse/horse_white.png");
   private static final jy k = new jy("textures/entity/horse/donkey.png");
   private static final Map<String, jy> a = Maps.newHashMap();

   public bjd(biu var1, bbh var2, float var3) {
      super(var1, var2, var3);
   }

   private jy b(tp var1) {
      String var2 = var1.cL();
      if (!var1.cK()) {
         return null;
      } else {
         jy var3 = (jy)a.get(var2);
         if (var3 == null) {
            var3 = new jy(var2);
            ave.A().P().a((jy)var3, (bmk)(new bmd(var1.cM())));
            a.put(var2, var3);
         }

         return var3;
      }
   }

   protected jy a(pk var1) {
      return this.a((tp)var1);
   }

   protected void a(tp var1, float var2) {
      float var3 = 1.0F;
      int var4 = var1.cl();
      if (var4 == 1) {
         var3 *= 0.87F;
      } else if (var4 == 2) {
         var3 *= 0.92F;
      }

      bfl.a(var3, var3, var3);
      super.a(var1, var2);
   }

   protected jy a(tp var1) {
      if (!var1.cJ()) {
         switch(var1.cl()) {
         case 0:
         default:
            return e;
         case 1:
            return k;
         case 2:
            return j;
         case 3:
            return l;
         case 4:
            return m;
         }
      } else {
         return this.b(var1);
      }
   }

   protected void a(pr var1, float var2) {
      this.a((tp)var1, var2);
   }
}
