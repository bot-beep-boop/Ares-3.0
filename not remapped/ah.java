import java.util.List;
import net.minecraft.server.MinecraftServer;

public class ah extends i {
   protected String[] d() {
      return MinecraftServer.N().K();
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length <= 0) {
         throw new cf("commands.gamemode.usage", new Object[0]);
      } else {
         adp.a var3 = this.h(var1, var2[0]);
         lf var4 = var2.length >= 2 ? a(var1, var2[1]) : b(var1);
         var4.a(var3);
         var4.O = 0.0F;
         if (var1.e().Q().b("sendCommandFeedback")) {
            var4.a((eu)(new fb("gameMode.changed", new Object[0])));
         }

         fb var5 = new fb("gameMode." + var3.b(), new Object[0]);
         if (var4 != var1) {
            a(var1, this, 1, "commands.gamemode.success.other", new Object[]{var4.e_(), var5});
         } else {
            a(var1, this, 1, "commands.gamemode.success.self", new Object[]{var5});
         }

      }
   }

   public String c(m var1) {
      return "commands.gamemode.usage";
   }

   public boolean b(String[] var1, int var2) {
      return var2 == 1;
   }

   public String c() {
      return "gamemode";
   }

   public int a() {
      return 2;
   }

   protected adp.a h(m var1, String var2) throws cb {
      if (!var2.equalsIgnoreCase(adp.a.b.b()) && !var2.equalsIgnoreCase("s")) {
         if (!var2.equalsIgnoreCase(adp.a.c.b()) && !var2.equalsIgnoreCase("c")) {
            if (!var2.equalsIgnoreCase(adp.a.d.b()) && !var2.equalsIgnoreCase("a")) {
               return !var2.equalsIgnoreCase(adp.a.e.b()) && !var2.equalsIgnoreCase("sp") ? adp.a(a(var2, 0, adp.a.values().length - 2)) : adp.a.e;
            } else {
               return adp.a.d;
            }
         } else {
            return adp.a.c;
         }
      } else {
         return adp.a.b;
      }
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      if (var2.length == 1) {
         return a(var2, new String[]{"survival", "creative", "adventure", "spectator"});
      } else {
         return var2.length == 2 ? a(var2, this.d()) : null;
      }
   }
}
