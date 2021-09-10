import net.minecraft.server.MinecraftServer;

public class bg extends i {
   public String c(m var1) {
      return "commands.setidletimeout.usage";
   }

   public String c() {
      return "setidletimeout";
   }

   public int a() {
      return 3;
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length != 1) {
         throw new cf("commands.setidletimeout.usage", new Object[0]);
      } else {
         int var3 = a(var2[0], 0);
         MinecraftServer.N().d(var3);
         a(var1, this, "commands.setidletimeout.success", new Object[]{var3});
      }
   }
}
