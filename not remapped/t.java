import java.util.List;
import net.minecraft.server.MinecraftServer;

public class t extends i {
   public boolean b(String[] var1, int var2) {
      return var2 == 0;
   }

   public String c() {
      return "clear";
   }

   protected String[] d() {
      return MinecraftServer.N().K();
   }

   public int a() {
      return 2;
   }

   public String c(m var1) {
      return "commands.clear.usage";
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      if (var2.length == 1) {
         return a(var2, this.d());
      } else {
         return var2.length == 2 ? a(var2, zw.e.c()) : null;
      }
   }

   public void a(m var1, String[] var2) throws bz {
      lf var3 = var2.length == 0 ? b(var1) : a(var1, var2[0]);
      zw var4 = var2.length >= 2 ? f(var1, var2[1]) : null;
      int var5 = var2.length >= 3 ? a(var2[2], -1) : -1;
      int var6 = var2.length >= 4 ? a(var2[3], -1) : -1;
      dn var7 = null;
      if (var2.length >= 5) {
         try {
            var7 = ed.a(a(var2, 4));
         } catch (ec var9) {
            throw new bz("commands.clear.tagError", new Object[]{var9.getMessage()});
         }
      }

      if (var2.length >= 2 && var4 == null) {
         throw new bz("commands.clear.failure", new Object[]{var3.e_()});
      } else {
         int var8 = var3.bi.a(var4, var5, var6, var7);
         var3.bj.b();
         if (!var3.bA.d) {
            var3.o();
         }

         var1.a(n.a.d, var8);
         if (var8 == 0) {
            throw new bz("commands.clear.failure", new Object[]{var3.e_()});
         } else {
            if (var6 == 0) {
               var1.a(new fb("commands.clear.testing", new Object[]{var3.e_(), var8}));
            } else {
               a(var1, this, "commands.clear.success", new Object[]{var3.e_(), var8});
            }

         }
      }
   }
}
