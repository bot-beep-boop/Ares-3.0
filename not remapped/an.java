import java.util.List;
import net.minecraft.server.MinecraftServer;

public class an extends i {
   public String c() {
      return "banlist";
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      return var2.length == 1 ? a(var2, new String[]{"players", "ips"}) : null;
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length >= 1 && var2[0].equalsIgnoreCase("ips")) {
         var1.a(new fb("commands.banlist.ips", new Object[]{MinecraftServer.N().ap().i().a().length}));
         var1.a(new fa(a(MinecraftServer.N().ap().i().a())));
      } else {
         var1.a(new fb("commands.banlist.players", new Object[]{MinecraftServer.N().ap().h().a().length}));
         var1.a(new fa(a(MinecraftServer.N().ap().h().a())));
      }

   }

   public boolean a(m var1) {
      return (MinecraftServer.N().ap().i().b() || MinecraftServer.N().ap().h().b()) && super.a(var1);
   }

   public int a() {
      return 3;
   }

   public String c(m var1) {
      return "commands.banlist.usage";
   }
}
