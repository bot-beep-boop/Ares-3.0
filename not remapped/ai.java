import java.util.Iterator;
import java.util.List;
import net.minecraft.server.MinecraftServer;

public class ai extends i {
   public String c() {
      return "gamerule";
   }

   public String c(m var1) {
      return "commands.gamerule.usage";
   }

   public void a(m var1, String[] var2) throws bz {
      adk var3 = this.d();
      String var4 = var2.length > 0 ? var2[0] : "";
      String var5 = var2.length > 1 ? a(var2, 1) : "";
      switch(var2.length) {
      case 0:
         var1.a(new fa(a(var3.b())));
         break;
      case 1:
         if (!var3.e(var4)) {
            throw new bz("commands.gamerule.norule", new Object[]{var4});
         }

         String var6 = var3.a(var4);
         var1.a((new fa(var4)).a(" = ").a(var6));
         var1.a(n.a.e, var3.c(var4));
         break;
      default:
         if (var3.a(var4, adk.b.b) && !"true".equals(var5) && !"false".equals(var5)) {
            throw new bz("commands.generic.boolean.invalid", new Object[]{var5});
         }

         var3.a(var4, var5);
         a(var3, var4);
         a(var1, this, "commands.gamerule.success", new Object[0]);
      }

   }

   private adk d() {
      return MinecraftServer.N().a(0).Q();
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      if (var2.length == 1) {
         return a((String[])var2, (String[])this.d().b());
      } else {
         if (var2.length == 2) {
            adk var4 = this.d();
            if (var4.a(var2[0], adk.b.b)) {
               return a((String[])var2, (String[])(new String[]{"true", "false"}));
            }
         }

         return null;
      }
   }

   public static void a(adk var0, String var1) {
      if ("reducedDebugInfo".equals(var1)) {
         int var2 = var0.b(var1) ? 22 : 23;
         Iterator var3 = MinecraftServer.N().ap().v().iterator();

         while(var3.hasNext()) {
            lf var4 = (lf)var3.next();
            var4.a.a((ff)(new gi(var4, (byte)var2)));
         }
      }

   }

   public int a() {
      return 2;
   }
}
