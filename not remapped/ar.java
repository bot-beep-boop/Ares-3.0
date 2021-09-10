import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.server.MinecraftServer;

public class ar extends i {
   public String c() {
      return "op";
   }

   public int a() {
      return 3;
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length == 1 && var2[0].length() > 0) {
         MinecraftServer var3 = MinecraftServer.N();
         GameProfile var4 = var3.aF().a(var2[0]);
         if (var4 == null) {
            throw new bz("commands.op.failed", new Object[]{var2[0]});
         } else {
            var3.ap().a(var4);
            a(var1, this, "commands.op.success", new Object[]{var2[0]});
         }
      } else {
         throw new cf("commands.op.usage", new Object[0]);
      }
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      if (var2.length == 1) {
         String var4 = var2[var2.length - 1];
         ArrayList var5 = Lists.newArrayList();
         GameProfile[] var6 = MinecraftServer.N().L();
         int var7 = var6.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            GameProfile var9 = var6[var8];
            if (!MinecraftServer.N().ap().h(var9) && a(var4, var9.getName())) {
               var5.add(var9.getName());
            }
         }

         return var5;
      } else {
         return null;
      }
   }

   public String c(m var1) {
      return "commands.op.usage";
   }
}
