import java.util.List;
import net.minecraft.server.MinecraftServer;

public class bb extends i {
   public String c() {
      return "say";
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length > 0 && var2[0].length() > 0) {
         eu var3 = b(var1, var2, 0, true);
         MinecraftServer.N().ap().a((eu)(new fb("chat.type.announcement", new Object[]{var1.f_(), var3})));
      } else {
         throw new cf("commands.say.usage", new Object[0]);
      }
   }

   public int a() {
      return 1;
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      return var2.length >= 1 ? a(var2, MinecraftServer.N().K()) : null;
   }

   public String c(m var1) {
      return "commands.say.usage";
   }
}
