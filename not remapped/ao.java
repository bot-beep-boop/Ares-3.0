import net.minecraft.server.MinecraftServer;

public class ao extends i {
   public int a() {
      return 0;
   }

   public void a(m var1, String[] var2) throws bz {
      int var3 = MinecraftServer.N().I();
      var1.a(new fb("commands.players.list", new Object[]{var3, MinecraftServer.N().J()}));
      var1.a(new fa(MinecraftServer.N().ap().b(var2.length > 0 && "uuids".equalsIgnoreCase(var2[0]))));
      var1.a(n.a.e, var3);
   }

   public String c() {
      return "list";
   }

   public String c(m var1) {
      return "commands.players.usage";
   }
}
