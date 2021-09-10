import com.google.gson.JsonParseException;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class aq extends i {
   public String c(m var1) {
      return "commands.tellraw.usage";
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length < 2) {
         throw new cf("commands.tellraw.usage", new Object[0]);
      } else {
         lf var3 = a(var1, var2[0]);
         String var4 = a(var2, 1);

         try {
            eu var5 = eu.a.a(var4);
            var3.a((eu)ev.a(var1, var5, var3));
         } catch (JsonParseException var7) {
            Throwable var6 = ExceptionUtils.getRootCause(var7);
            throw new cc("commands.tellraw.jsonException", new Object[]{var6 == null ? "" : var6.getMessage()});
         }
      }
   }

   public int a() {
      return 2;
   }

   public boolean b(String[] var1, int var2) {
      return var2 == 0;
   }

   public String c() {
      return "tellraw";
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      return var2.length == 1 ? a(var2, MinecraftServer.N().K()) : null;
   }
}
