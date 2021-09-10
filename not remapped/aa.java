import java.util.List;
import net.minecraft.server.MinecraftServer;

public class aa extends i {
   public void a(m var1, String[] var2) throws bz {
      if (var2.length <= 0) {
         throw new cf("commands.me.usage", new Object[0]);
      } else {
         eu var3 = b(var1, var2, 0, !(var1 instanceof wn));
         MinecraftServer.N().ap().a((eu)(new fb("chat.type.emote", new Object[]{var1.f_(), var3})));
      }
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      return a(var2, MinecraftServer.N().K());
   }

   public String c(m var1) {
      return "commands.me.usage";
   }

   public String c() {
      return "me";
   }

   public int a() {
      return 0;
   }
}
