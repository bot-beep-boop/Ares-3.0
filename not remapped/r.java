import com.mojang.authlib.GameProfile;
import java.util.Date;
import java.util.List;
import net.minecraft.server.MinecraftServer;

public class r extends i {
   public List<String> a(m var1, String[] var2, cj var3) {
      return var2.length >= 1 ? a(var2, MinecraftServer.N().K()) : null;
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length >= 1 && var2[0].length() > 0) {
         MinecraftServer var3 = MinecraftServer.N();
         GameProfile var4 = var3.aF().a(var2[0]);
         if (var4 == null) {
            throw new bz("commands.ban.failed", new Object[]{var2[0]});
         } else {
            String var5 = null;
            if (var2.length >= 2) {
               var5 = a(var1, var2, 1).c();
            }

            md var6 = new md(var4, (Date)null, var1.e_(), (Date)null, var5);
            var3.ap().h().a((ma)var6);
            lf var7 = var3.ap().a(var2[0]);
            if (var7 != null) {
               var7.a.c("You are banned from this server.");
            }

            a(var1, this, "commands.ban.success", new Object[]{var2[0]});
         }
      } else {
         throw new cf("commands.ban.usage", new Object[0]);
      }
   }

   public String c() {
      return "ban";
   }

   public String c(m var1) {
      return "commands.ban.usage";
   }

   public boolean a(m var1) {
      return MinecraftServer.N().ap().h().b() && super.a(var1);
   }

   public int a() {
      return 3;
   }
}
