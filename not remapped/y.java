import java.util.Iterator;
import net.minecraft.server.MinecraftServer;

public class y extends ah {
   protected void a(adp.a var1) {
      MinecraftServer var2 = MinecraftServer.N();
      var2.a(var1);
      lf var4;
      if (var2.ax()) {
         for(Iterator var3 = MinecraftServer.N().ap().v().iterator(); var3.hasNext(); var4.O = 0.0F) {
            var4 = (lf)var3.next();
            var4.a(var1);
         }
      }

   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length <= 0) {
         throw new cf("commands.defaultgamemode.usage", new Object[0]);
      } else {
         adp.a var3 = this.h(var1, var2[0]);
         this.a(var3);
         a(var1, this, "commands.defaultgamemode.success", new Object[]{new fb("gameMode." + var3.b(), new Object[0])});
      }
   }

   public String c(m var1) {
      return "commands.defaultgamemode.usage";
   }

   public String c() {
      return "defaultgamemode";
   }
}
