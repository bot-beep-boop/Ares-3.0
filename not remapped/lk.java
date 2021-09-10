import net.minecraft.server.MinecraftServer;

public class lk implements jd {
   private final MinecraftServer a;
   private final ek b;

   public lk(MinecraftServer var1, ek var2) {
      this.a = var1;
      this.b = var2;
   }

   public void a(eu var1) {
   }

   public void a(jc var1) {
      this.b.a(var1.a());
      this.b.a((ep)(new lo(this.a, this.b)));
   }
}
