import net.minecraft.server.MinecraftServer;

public class bl extends i {
   public void a(m var1, String[] var2) throws bz {
      if (MinecraftServer.N().d != null) {
         a(var1, this, "commands.stop.start", new Object[0]);
      }

      MinecraftServer.N().w();
   }

   public String c() {
      return "stop";
   }

   public String c(m var1) {
      return "commands.stop.usage";
   }
}
