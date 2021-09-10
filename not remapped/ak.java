import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.server.MinecraftServer;

public class ak extends i {
   protected List<k> d(m var1) {
      List var2 = MinecraftServer.N().P().a(var1);
      Collections.sort(var2);
      return var2;
   }

   public void a(m var1, String[] var2) throws bz {
      List var3 = this.d(var1);
      boolean var4 = true;
      int var5 = (var3.size() - 1) / 7;
      boolean var6 = false;

      int var13;
      try {
         var13 = var2.length == 0 ? 0 : a(var2[0], 1, var5 + 1) - 1;
      } catch (cb var12) {
         Map var8 = this.d();
         k var9 = (k)var8.get(var2[0]);
         if (var9 != null) {
            throw new cf(var9.c(var1), new Object[0]);
         }

         if (ns.a(var2[0], -1) != -1) {
            throw var12;
         }

         throw new ce();
      }

      int var7 = Math.min((var13 + 1) * 7, var3.size());
      fb var14 = new fb("commands.help.header", new Object[]{var13 + 1, var5 + 1});
      var14.b().a(.a.c);
      var1.a(var14);

      for(int var15 = var13 * 7; var15 < var7; ++var15) {
         k var10 = (k)var3.get(var15);
         fb var11 = new fb(var10.c(var1), new Object[0]);
         var11.b().a(new et(et.a.e, "/" + var10.c() + " "));
         var1.a(var11);
      }

      if (var13 == 0 && var1 instanceof wn) {
         fb var16 = new fb("commands.help.footer", new Object[0]);
         var16.b().a(.a.k);
         var1.a(var16);
      }

   }

   public int a() {
      return 0;
   }

   public List<String> b() {
      return Arrays.asList("?");
   }

   public String c() {
      return "help";
   }

   public String c(m var1) {
      return "commands.help.usage";
   }

   protected Map<String, k> d() {
      return MinecraftServer.N().P().a();
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      if (var2.length == 1) {
         Set var4 = this.d().keySet();
         return a(var2, (String[])var4.toArray(new String[var4.size()]));
      } else {
         return null;
      }
   }
}
