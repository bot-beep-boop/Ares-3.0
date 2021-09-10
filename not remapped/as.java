import java.util.List;
import java.util.regex.Matcher;
import net.minecraft.server.MinecraftServer;

public class as extends i {
   public void a(m var1, String[] var2) throws bz {
      if (var2.length == 1 && var2[0].length() > 1) {
         Matcher var3 = q.a.matcher(var2[0]);
         if (var3.matches()) {
            MinecraftServer.N().ap().i().c(var2[0]);
            a(var1, this, "commands.unbanip.success", new Object[]{var2[0]});
         } else {
            throw new cc("commands.unbanip.invalid", new Object[0]);
         }
      } else {
         throw new cf("commands.unbanip.usage", new Object[0]);
      }
   }

   public boolean a(m var1) {
      return MinecraftServer.N().ap().i().b() && super.a(var1);
   }

   public int a() {
      return 3;
   }

   public String c(m var1) {
      return "commands.unbanip.usage";
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      return var2.length == 1 ? a(var2, MinecraftServer.N().ap().i().a()) : null;
   }

   public String c() {
      return "pardon-ip";
   }
}
