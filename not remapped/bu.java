import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.MinecraftServer;

public class bu extends i {
   public String c() {
      return "trigger";
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length < 3) {
         throw new cf("commands.trigger.usage", new Object[0]);
      } else {
         lf var3;
         if (var1 instanceof lf) {
            var3 = (lf)var1;
         } else {
            pk var4 = var1.f();
            if (!(var4 instanceof lf)) {
               throw new bz("commands.trigger.invalidPlayer", new Object[0]);
            }

            var3 = (lf)var4;
         }

         auo var8 = MinecraftServer.N().a(0).Z();
         auk var5 = var8.b(var2[0]);
         if (var5 != null && var5.c() == auu.c) {
            int var6 = a(var2[2]);
            if (!var8.b(var3.e_(), var5)) {
               throw new bz("commands.trigger.invalidObjective", new Object[]{var2[0]});
            } else {
               aum var7 = var8.c(var3.e_(), var5);
               if (var7.g()) {
                  throw new bz("commands.trigger.disabled", new Object[]{var2[0]});
               } else {
                  if ("set".equals(var2[1])) {
                     var7.c(var6);
                  } else {
                     if (!"add".equals(var2[1])) {
                        throw new bz("commands.trigger.invalidMode", new Object[]{var2[1]});
                     }

                     var7.a(var6);
                  }

                  var7.a(true);
                  if (var3.c.d()) {
                     a(var1, this, "commands.trigger.success", new Object[]{var2[0], var2[1], var2[2]});
                  }

               }
            }
         } else {
            throw new bz("commands.trigger.invalidObjective", new Object[]{var2[0]});
         }
      }
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      if (var2.length == 1) {
         auo var4 = MinecraftServer.N().a(0).Z();
         ArrayList var5 = Lists.newArrayList();
         Iterator var6 = var4.c().iterator();

         while(var6.hasNext()) {
            auk var7 = (auk)var6.next();
            if (var7.c() == auu.c) {
               var5.add(var7.b());
            }
         }

         return a(var2, (String[])var5.toArray(new String[var5.size()]));
      } else {
         return var2.length == 2 ? a(var2, new String[]{"add", "set"}) : null;
      }
   }

   public int a() {
      return 0;
   }

   public String c(m var1) {
      return "commands.trigger.usage";
   }
}
