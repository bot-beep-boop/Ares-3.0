import java.util.List;
import net.minecraft.server.MinecraftServer;

public class bf extends i {
   public String c() {
      return "setworldspawn";
   }

   public int a() {
      return 2;
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      return var2.length > 0 && var2.length <= 3 ? a(var2, 0, var3) : null;
   }

   public String c(m var1) {
      return "commands.setworldspawn.usage";
   }

   public void a(m var1, String[] var2) throws bz {
      cj var3;
      if (var2.length == 0) {
         var3 = b(var1).c();
      } else {
         if (var2.length != 3 || var1.e() == null) {
            throw new cf("commands.setworldspawn.usage", new Object[0]);
         }

         var3 = a(var1, var2, 0, true);
      }

      var1.e().B(var3);
      MinecraftServer.N().ap().a((ff)(new ht(var3)));
      a(var1, this, "commands.setworldspawn.success", new Object[]{var3.n(), var3.o(), var3.p()});
   }
}
