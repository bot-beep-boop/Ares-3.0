import net.minecraft.server.MinecraftServer;

public class aw extends i {
   public void a(m var1, String[] var2) throws bz {
      String var3 = MinecraftServer.N().a(adp.a.b, false);
      if (var3 != null) {
         a(var1, this, "commands.publish.started", new Object[]{var3});
      } else {
         a(var1, this, "commands.publish.failed", new Object[0]);
      }

   }

   public String c(m var1) {
      return "commands.publish.usage";
   }

   public String c() {
      return "publish";
   }
}
