import java.util.List;
import net.minecraft.server.MinecraftServer;

public class al extends i {
   public String c() {
      return "kick";
   }

   public int a() {
      return 3;
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      return var2.length >= 1 ? a(var2, MinecraftServer.N().K()) : null;
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length > 0 && var2[0].length() > 1) {
         lf var3 = MinecraftServer.N().ap().a(var2[0]);
         String var4 = "Kicked by an operator.";
         boolean var5 = false;
         if (var3 == null) {
            throw new cd();
         } else {
            if (var2.length >= 2) {
               var4 = a(var1, var2, 1).c();
               var5 = true;
            }

            var3.a.c(var4);
            if (var5) {
               a(var1, this, "commands.kick.success.reason", new Object[]{var3.e_(), var4});
            } else {
               a(var1, this, "commands.kick.success", new Object[]{var3.e_()});
            }

         }
      } else {
         throw new cf("commands.kick.usage", new Object[0]);
      }
   }

   public String c(m var1) {
      return "commands.kick.usage";
   }
}
