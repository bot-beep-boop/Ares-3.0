import net.minecraft.server.MinecraftServer;

public class ln implements jd {
   private final MinecraftServer a;
   private final ek b;

   public void a(eu var1) {
   }

   public ln(MinecraftServer var1, ek var2) {
      this.a = var1;
      this.b = var2;
   }

   public void a(jc var1) {
      switch(var1.a()) {
      case d:
         this.b.a(el.d);
         fa var2;
         if (var1.b() > 47) {
            var2 = new fa("Outdated server! I'm still on 1.8.9");
            this.b.a((ff)(new jj(var2)));
            this.b.a((eu)var2);
         } else if (var1.b() < 47) {
            var2 = new fa("Outdated client! Please use 1.8.9");
            this.b.a((ff)(new jj(var2)));
            this.b.a((eu)var2);
         } else {
            this.b.a((ep)(new lo(this.a, this.b)));
         }
         break;
      case c:
         this.b.a(el.c);
         this.b.a((ep)(new lp(this.a, this.b)));
         break;
      default:
         throw new UnsupportedOperationException("Invalid intention " + var1.a());
      }

   }
}
