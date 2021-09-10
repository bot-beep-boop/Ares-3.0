import com.mojang.authlib.GameProfile;
import java.util.List;
import net.minecraft.server.MinecraftServer;

public class at extends i {
   public void a(m var1, String[] var2) throws bz {
      if (var2.length == 1 && var2[0].length() > 0) {
         MinecraftServer var3 = MinecraftServer.N();
         GameProfile var4 = var3.ap().h().a(var2[0]);
         if (var4 == null) {
            throw new bz("commands.unban.failed", new Object[]{var2[0]});
         } else {
            var3.ap().h().c(var4);
            a(var1, this, "commands.unban.success", new Object[]{var2[0]});
         }
      } else {
         throw new cf("commands.unban.usage", new Object[0]);
      }
   }

   public int a() {
      return 3;
   }

   public String c() {
      return "pardon";
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      return var2.length == 1 ? a(var2, MinecraftServer.N().ap().h().a()) : null;
   }

   public String c(m var1) {
      return "commands.unban.usage";
   }

   public boolean a(m var1) {
      return MinecraftServer.N().ap().h().b() && super.a(var1);
   }
}
