import java.util.List;
import java.util.Random;
import net.minecraft.server.MinecraftServer;

public class bv extends i {
   public void a(m var1, String[] var2) throws bz {
      if (var2.length >= 1 && var2.length <= 2) {
         int var3 = (300 + (new Random()).nextInt(600)) * 20;
         if (var2.length >= 2) {
            var3 = a(var2[1], 1, 1000000) * 20;
         }

         le var4 = MinecraftServer.N().d[0];
         ato var5 = var4.P();
         if ("clear".equalsIgnoreCase(var2[0])) {
            var5.i(var3);
            var5.g(0);
            var5.f(0);
            var5.b(false);
            var5.a(false);
            a(var1, this, "commands.weather.clear", new Object[0]);
         } else if ("rain".equalsIgnoreCase(var2[0])) {
            var5.i(0);
            var5.g(var3);
            var5.f(var3);
            var5.b(true);
            var5.a(false);
            a(var1, this, "commands.weather.rain", new Object[0]);
         } else {
            if (!"thunder".equalsIgnoreCase(var2[0])) {
               throw new cf("commands.weather.usage", new Object[0]);
            }

            var5.i(0);
            var5.g(var3);
            var5.f(var3);
            var5.b(true);
            var5.a(true);
            a(var1, this, "commands.weather.thunder", new Object[0]);
         }

      } else {
         throw new cf("commands.weather.usage", new Object[0]);
      }
   }

   public int a() {
      return 2;
   }

   public String c(m var1) {
      return "commands.weather.usage";
   }

   public String c() {
      return "weather";
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      return var2.length == 1 ? a(var2, new String[]{"clear", "rain", "thunder"}) : null;
   }
}
