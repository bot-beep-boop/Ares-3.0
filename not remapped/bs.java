import com.google.gson.JsonParseException;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bs extends i {
   private static final Logger a = LogManager.getLogger();

   public boolean b(String[] var1, int var2) {
      return var2 == 0;
   }

   public String c() {
      return "title";
   }

   public String c(m var1) {
      return "commands.title.usage";
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length < 2) {
         throw new cf("commands.title.usage", new Object[0]);
      } else {
         if (var2.length < 3) {
            if ("title".equals(var2[1]) || "subtitle".equals(var2[1])) {
               throw new cf("commands.title.usage.title", new Object[0]);
            }

            if ("times".equals(var2[1])) {
               throw new cf("commands.title.usage.times", new Object[0]);
            }
         }

         lf var3 = a(var1, var2[0]);
         hv.a var4 = hv.a.a(var2[1]);
         if (var4 != hv.a.d && var4 != hv.a.e) {
            if (var4 == hv.a.c) {
               if (var2.length != 5) {
                  throw new cf("commands.title.usage", new Object[0]);
               } else {
                  int var11 = a(var2[2]);
                  int var12 = a(var2[3]);
                  int var13 = a(var2[4]);
                  hv var14 = new hv(var11, var12, var13);
                  var3.a.a((ff)var14);
                  a(var1, this, "commands.title.success", new Object[0]);
               }
            } else if (var2.length < 3) {
               throw new cf("commands.title.usage", new Object[0]);
            } else {
               String var10 = a(var2, 2);

               eu var6;
               try {
                  var6 = eu.a.a(var10);
               } catch (JsonParseException var9) {
                  Throwable var8 = ExceptionUtils.getRootCause(var9);
                  throw new cc("commands.tellraw.jsonException", new Object[]{var8 == null ? "" : var8.getMessage()});
               }

               hv var7 = new hv(var4, ev.a(var1, var6, var3));
               var3.a.a((ff)var7);
               a(var1, this, "commands.title.success", new Object[0]);
            }
         } else if (var2.length != 2) {
            throw new cf("commands.title.usage", new Object[0]);
         } else {
            hv var5 = new hv(var4, (eu)null);
            var3.a.a((ff)var5);
            a(var1, this, "commands.title.success", new Object[0]);
         }
      }
   }

   public int a() {
      return 2;
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      if (var2.length == 1) {
         return a(var2, MinecraftServer.N().K());
      } else {
         return var2.length == 2 ? a(var2, hv.a.a()) : null;
      }
   }
}
