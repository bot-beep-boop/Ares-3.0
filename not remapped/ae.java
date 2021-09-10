import java.util.List;
import net.minecraft.server.MinecraftServer;

public class ae extends i {
   protected String[] d() {
      return MinecraftServer.N().K();
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      return var2.length == 2 ? a(var2, this.d()) : null;
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length <= 0) {
         throw new cf("commands.xp.usage", new Object[0]);
      } else {
         String var3 = var2[0];
         boolean var4 = var3.endsWith("l") || var3.endsWith("L");
         if (var4 && var3.length() > 1) {
            var3 = var3.substring(0, var3.length() - 1);
         }

         int var5 = a(var3);
         boolean var6 = var5 < 0;
         if (var6) {
            var5 *= -1;
         }

         lf var7 = var2.length > 1 ? a(var1, var2[1]) : b(var1);
         if (var4) {
            var1.a(n.a.e, var7.bB);
            if (var6) {
               var7.a(-var5);
               a(var1, this, "commands.xp.success.negative.levels", new Object[]{var5, var7.e_()});
            } else {
               var7.a(var5);
               a(var1, this, "commands.xp.success.levels", new Object[]{var5, var7.e_()});
            }
         } else {
            var1.a(n.a.e, var7.bC);
            if (var6) {
               throw new bz("commands.xp.failure.widthdrawXp", new Object[0]);
            }

            var7.u(var5);
            a(var1, this, "commands.xp.success", new Object[]{var5, var7.e_()});
         }

      }
   }

   public String c() {
      return "xp";
   }

   public boolean b(String[] var1, int var2) {
      return var2 == 1;
   }

   public String c(m var1) {
      return "commands.xp.usage";
   }

   public int a() {
      return 2;
   }
}
