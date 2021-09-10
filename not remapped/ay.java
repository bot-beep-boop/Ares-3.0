import net.minecraft.server.MinecraftServer;

public class ay extends i {
   public void a(m var1, String[] var2) throws bz {
      MinecraftServer var3 = MinecraftServer.N();
      var1.a(new fb("commands.save.start", new Object[0]));
      if (var3.ap() != null) {
         var3.ap().j();
      }

      try {
         int var4;
         le var5;
         boolean var6;
         for(var4 = 0; var4 < var3.d.length; ++var4) {
            if (var3.d[var4] != null) {
               var5 = var3.d[var4];
               var6 = var5.c;
               var5.c = false;
               var5.a(true, (nu)null);
               var5.c = var6;
            }
         }

         if (var2.length > 0 && "flush".equals(var2[0])) {
            var1.a(new fb("commands.save.flushStart", new Object[0]));

            for(var4 = 0; var4 < var3.d.length; ++var4) {
               if (var3.d[var4] != null) {
                  var5 = var3.d[var4];
                  var6 = var5.c;
                  var5.c = false;
                  var5.n();
                  var5.c = var6;
               }
            }

            var1.a(new fb("commands.save.flushEnd", new Object[0]));
         }
      } catch (adn var7) {
         a(var1, this, "commands.save.failed", new Object[]{var7.getMessage()});
         return;
      }

      a(var1, this, "commands.save.success", new Object[0]);
   }

   public String c(m var1) {
      return "commands.save.usage";
   }

   public String c() {
      return "save-all";
   }
}
