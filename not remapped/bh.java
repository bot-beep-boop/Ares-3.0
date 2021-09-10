import java.util.List;
import net.minecraft.server.MinecraftServer;

public class bh extends i {
   public boolean b(String[] var1, int var2) {
      return var2 == 0;
   }

   public String c(m var1) {
      return "commands.spawnpoint.usage";
   }

   public int a() {
      return 2;
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length > 1 && var2.length < 4) {
         throw new cf("commands.spawnpoint.usage", new Object[0]);
      } else {
         lf var3 = var2.length > 0 ? a(var1, var2[0]) : b(var1);
         cj var4 = var2.length > 3 ? a(var1, var2, 1, true) : var3.c();
         if (var3.o != null) {
            var3.a((cj)var4, true);
            a(var1, this, "commands.spawnpoint.success", new Object[]{var3.e_(), var4.n(), var4.o(), var4.p()});
         }

      }
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      if (var2.length == 1) {
         return a(var2, MinecraftServer.N().K());
      } else {
         return var2.length > 1 && var2.length <= 4 ? a(var2, 1, var3) : null;
      }
   }

   public String c() {
      return "spawnpoint";
   }
}
