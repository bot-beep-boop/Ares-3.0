import java.util.List;
import net.minecraft.server.MinecraftServer;

public class am extends i {
   public boolean b(String[] var1, int var2) {
      return var2 == 0;
   }

   public String c(m var1) {
      return "commands.kill.usage";
   }

   public String c() {
      return "kill";
   }

   public int a() {
      return 2;
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      return var2.length == 1 ? a(var2, MinecraftServer.N().K()) : null;
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length == 0) {
         lf var4 = b(var1);
         var4.G();
         a(var1, this, "commands.kill.successful", new Object[]{var4.f_()});
      } else {
         pk var3 = b(var1, var2[0]);
         var3.G();
         a(var1, this, "commands.kill.successful", new Object[]{var3.f_()});
      }
   }
}
