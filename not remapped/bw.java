import com.mojang.authlib.GameProfile;
import java.util.List;
import net.minecraft.server.MinecraftServer;

public class bw extends i {
   public int a() {
      return 3;
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length < 1) {
         throw new cf("commands.whitelist.usage", new Object[0]);
      } else {
         MinecraftServer var3 = MinecraftServer.N();
         if (var2[0].equals("on")) {
            var3.ap().a(true);
            a(var1, this, "commands.whitelist.enabled", new Object[0]);
         } else if (var2[0].equals("off")) {
            var3.ap().a(false);
            a(var1, this, "commands.whitelist.disabled", new Object[0]);
         } else if (var2[0].equals("list")) {
            var1.a(new fb("commands.whitelist.list", new Object[]{var3.ap().l().length, var3.ap().q().length}));
            String[] var4 = var3.ap().l();
            var1.a(new fa(a(var4)));
         } else {
            GameProfile var5;
            if (var2[0].equals("add")) {
               if (var2.length < 2) {
                  throw new cf("commands.whitelist.add.usage", new Object[0]);
               }

               var5 = var3.aF().a(var2[1]);
               if (var5 == null) {
                  throw new bz("commands.whitelist.add.failed", new Object[]{var2[1]});
               }

               var3.ap().d(var5);
               a(var1, this, "commands.whitelist.add.success", new Object[]{var2[1]});
            } else if (var2[0].equals("remove")) {
               if (var2.length < 2) {
                  throw new cf("commands.whitelist.remove.usage", new Object[0]);
               }

               var5 = var3.ap().k().a(var2[1]);
               if (var5 == null) {
                  throw new bz("commands.whitelist.remove.failed", new Object[]{var2[1]});
               }

               var3.ap().c(var5);
               a(var1, this, "commands.whitelist.remove.success", new Object[]{var2[1]});
            } else if (var2[0].equals("reload")) {
               var3.ap().a();
               a(var1, this, "commands.whitelist.reloaded", new Object[0]);
            }
         }

      }
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      if (var2.length == 1) {
         return a(var2, new String[]{"on", "off", "list", "add", "remove", "reload"});
      } else {
         if (var2.length == 2) {
            if (var2[0].equals("remove")) {
               return a(var2, MinecraftServer.N().ap().l());
            }

            if (var2[0].equals("add")) {
               return a(var2, MinecraftServer.N().aF().a());
            }
         }

         return null;
      }
   }

   public String c(m var1) {
      return "commands.whitelist.usage";
   }

   public String c() {
      return "whitelist";
   }
}
