import net.minecraft.server.MinecraftServer;

public class bi extends i {
   public String c(m var1) {
      return "commands.seed.usage";
   }

   public void a(m var1, String[] var2) throws bz {
      Object var3 = var1 instanceof wn ? ((wn)var1).o : MinecraftServer.N().a(0);
      var1.a(new fb("commands.seed.success", new Object[]{((adm)var3).J()}));
   }

   public String c() {
      return "seed";
   }

   public int a() {
      return 2;
   }

   public boolean a(m var1) {
      return MinecraftServer.N().T() || super.a(var1);
   }
}
