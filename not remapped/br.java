import java.util.List;
import net.minecraft.server.MinecraftServer;

public class br extends i {
   public void a(m var1, String[] var2) throws bz {
      if (var2.length > 1) {
         int var3;
         if (var2[0].equals("set")) {
            if (var2[1].equals("day")) {
               var3 = 1000;
            } else if (var2[1].equals("night")) {
               var3 = 13000;
            } else {
               var3 = a(var2[1], 0);
            }

            this.a(var1, var3);
            a(var1, this, "commands.time.set", new Object[]{var3});
            return;
         }

         if (var2[0].equals("add")) {
            var3 = a(var2[1], 0);
            this.b(var1, var3);
            a(var1, this, "commands.time.added", new Object[]{var3});
            return;
         }

         if (var2[0].equals("query")) {
            if (var2[1].equals("daytime")) {
               var3 = (int)(var1.e().L() % 2147483647L);
               var1.a(n.a.e, var3);
               a(var1, this, "commands.time.query", new Object[]{var3});
               return;
            }

            if (var2[1].equals("gametime")) {
               var3 = (int)(var1.e().K() % 2147483647L);
               var1.a(n.a.e, var3);
               a(var1, this, "commands.time.query", new Object[]{var3});
               return;
            }
         }
      }

      throw new cf("commands.time.usage", new Object[0]);
   }

   protected void a(m var1, int var2) {
      for(int var3 = 0; var3 < MinecraftServer.N().d.length; ++var3) {
         MinecraftServer.N().d[var3].b((long)var2);
      }

   }

   public List<String> a(m var1, String[] var2, cj var3) {
      if (var2.length == 1) {
         return a(var2, new String[]{"set", "add", "query"});
      } else if (var2.length == 2 && var2[0].equals("set")) {
         return a(var2, new String[]{"day", "night"});
      } else {
         return var2.length == 2 && var2[0].equals("query") ? a(var2, new String[]{"daytime", "gametime"}) : null;
      }
   }

   protected void b(m var1, int var2) {
      for(int var3 = 0; var3 < MinecraftServer.N().d.length; ++var3) {
         le var4 = MinecraftServer.N().d[var3];
         var4.b(var4.L() + (long)var2);
      }

   }

   public String c() {
      return "time";
   }

   public String c(m var1) {
      return "commands.time.usage";
   }

   public int a() {
      return 2;
   }
}
