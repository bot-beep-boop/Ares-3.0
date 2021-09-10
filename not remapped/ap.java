import java.util.Arrays;
import java.util.List;
import net.minecraft.server.MinecraftServer;

public class ap extends i {
   public List<String> b() {
      return Arrays.asList("w", "msg");
   }

   public String c(m var1) {
      return "commands.message.usage";
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length < 2) {
         throw new cf("commands.message.usage", new Object[0]);
      } else {
         lf var3 = a(var1, var2[0]);
         if (var3 == var1) {
            throw new cd("commands.message.sameTarget", new Object[0]);
         } else {
            eu var4 = b(var1, var2, 1, !(var1 instanceof wn));
            fb var5 = new fb("commands.message.display.incoming", new Object[]{var1.f_(), var4.f()});
            fb var6 = new fb("commands.message.display.outgoing", new Object[]{var3.f_(), var4.f()});
            var5.b().a(.a.h).b(true);
            var6.b().a(.a.h).b(true);
            var3.a((eu)var5);
            var1.a(var6);
         }
      }
   }

   public boolean b(String[] var1, int var2) {
      return var2 == 0;
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      return a(var2, MinecraftServer.N().K());
   }

   public int a() {
      return 0;
   }

   public String c() {
      return "tell";
   }
}
