import java.util.List;
import net.minecraft.server.MinecraftServer;

public class ag extends i {
   public List<String> a(m var1, String[] var2, cj var3) {
      return var2.length == 1 ? a(var2, new String[]{"peaceful", "easy", "normal", "hard"}) : null;
   }

   public String c() {
      return "difficulty";
   }

   protected oj e(String var1) throws cb {
      if (!var1.equalsIgnoreCase("peaceful") && !var1.equalsIgnoreCase("p")) {
         if (!var1.equalsIgnoreCase("easy") && !var1.equalsIgnoreCase("e")) {
            if (!var1.equalsIgnoreCase("normal") && !var1.equalsIgnoreCase("n")) {
               return !var1.equalsIgnoreCase("hard") && !var1.equalsIgnoreCase("h") ? oj.a(a(var1, 0, 3)) : oj.d;
            } else {
               return oj.c;
            }
         } else {
            return oj.b;
         }
      } else {
         return oj.a;
      }
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length <= 0) {
         throw new cf("commands.difficulty.usage", new Object[0]);
      } else {
         oj var3 = this.e(var2[0]);
         MinecraftServer.N().a(var3);
         a(var1, this, "commands.difficulty.success", new Object[]{new fb(var3.b(), new Object[0])});
      }
   }

   public String c(m var1) {
      return "commands.difficulty.usage";
   }

   public int a() {
      return 2;
   }
}
