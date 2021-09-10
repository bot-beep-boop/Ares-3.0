import net.minecraft.server.MinecraftServer;

public class az extends i {
   public void a(m var1, String[] var2) throws bz {
      MinecraftServer var3 = MinecraftServer.N();
      boolean var4 = false;

      for(int var5 = 0; var5 < var3.d.length; ++var5) {
         if (var3.d[var5] != null) {
            le var6 = var3.d[var5];
            if (!var6.c) {
               var6.c = true;
               var4 = true;
            }
         }
      }

      if (var4) {
         a(var1, this, "commands.save.disabled", new Object[0]);
      } else {
         throw new bz("commands.save-off.alreadyOff", new Object[0]);
      }
   }

   public String c(m var1) {
      return "commands.save-off.usage";
   }

   public String c() {
      return "save-off";
   }
}
