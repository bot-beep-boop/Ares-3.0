import com.mojang.authlib.GameProfile;
import java.util.UUID;

public class bfi {
   public static bfi a = new bfi();
   private aku e = new aku();
   private aky c = new aky(1);
   private alf d = new alf();
   private aky b = new aky(0);
   private alo f = new alo();

   public void a(zx var1) {
      if (var1.b() == zy.cE) {
         this.e.a(var1);
         bhc.a.a(this.e, 0.0D, 0.0D, 0.0D, 0.0F);
      } else if (var1.b() == zy.bX) {
         GameProfile var2 = null;
         if (var1.n()) {
            dn var3 = var1.o();
            if (var3.b("SkullOwner", 10)) {
               var2 = dy.a(var3.m("SkullOwner"));
            } else if (var3.b("SkullOwner", 8) && var3.j("SkullOwner").length() > 0) {
               var2 = new GameProfile((UUID)null, var3.j("SkullOwner"));
               var2 = alo.b(var2);
               var3.o("SkullOwner");
               var3.a((String)"SkullOwner", (eb)dy.a(new dn(), var2));
            }
         }

         if (bhk.c != null) {
            bfl.E();
            bfl.b(-0.5F, 0.0F, -0.5F);
            bfl.a(2.0F, 2.0F, 2.0F);
            bfl.p();
            bhk.c.a(0.0F, 0.0F, 0.0F, cq.b, 0.0F, var1.i(), var2, -1);
            bfl.o();
            bfl.F();
         }
      } else {
         afh var4 = afh.a(var1.b());
         if (var4 == afi.bQ) {
            bhc.a.a(this.d, 0.0D, 0.0D, 0.0D, 0.0F);
         } else if (var4 == afi.cg) {
            bhc.a.a(this.c, 0.0D, 0.0D, 0.0D, 0.0F);
         } else {
            bhc.a.a(this.b, 0.0D, 0.0D, 0.0D, 0.0F);
         }
      }

   }
}
