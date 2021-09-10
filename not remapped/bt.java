import net.minecraft.server.MinecraftServer;

public class bt extends i {
   public void a(m var1, String[] var2) throws bz {
      this.d();
      a(var1, this, "commands.downfall.success", new Object[0]);
   }

   protected void d() {
      ato var1 = MinecraftServer.N().d[0].P();
      var1.b(!var1.p());
   }

   public String c() {
      return "toggledownfall";
   }

   public int a() {
      return 2;
   }

   public String c(m var1) {
      return "commands.downfall.usage";
   }
}
