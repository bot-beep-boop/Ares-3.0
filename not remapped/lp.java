import net.minecraft.server.MinecraftServer;

public class lp implements jt {
   private final MinecraftServer b;
   private final ek c;
   private boolean d;
   private static final eu a = new fa("Status request has been handled.");

   public void a(eu var1) {
   }

   public lp(MinecraftServer var1, ek var2) {
      this.b = var1;
      this.c = var2;
   }

   public void a(ju var1) {
      this.c.a((ff)(new jq(var1.a())));
      this.c.a(a);
   }

   public void a(jv var1) {
      if (this.d) {
         this.c.a(a);
      } else {
         this.d = true;
         this.c.a((ff)(new jr(this.b.aG())));
      }
   }
}
