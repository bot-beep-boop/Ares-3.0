import java.util.List;
import net.minecraft.server.MinecraftServer;

public class bq extends i {
   public String c() {
      return "testfor";
   }

   public int a() {
      return 2;
   }

   public boolean b(String[] var1, int var2) {
      return var2 == 0;
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      return var2.length == 1 ? a(var2, MinecraftServer.N().K()) : null;
   }

   public String c(m var1) {
      return "commands.testfor.usage";
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length < 1) {
         throw new cf("commands.testfor.usage", new Object[0]);
      } else {
         pk var3 = b(var1, var2[0]);
         dn var4 = null;
         if (var2.length >= 2) {
            try {
               var4 = ed.a(a(var2, 1));
            } catch (ec var6) {
               throw new bz("commands.testfor.tagError", new Object[]{var6.getMessage()});
            }
         }

         if (var4 != null) {
            dn var5 = new dn();
            var3.e(var5);
            if (!dy.a(var4, var5, true)) {
               throw new bz("commands.testfor.failure", new Object[]{var3.e_()});
            }
         }

         a(var1, this, "commands.testfor.success", new Object[]{var3.e_()});
      }
   }
}
