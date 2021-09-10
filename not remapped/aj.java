import java.util.List;
import net.minecraft.server.MinecraftServer;

public class aj extends i {
   public List<String> a(m var1, String[] var2, cj var3) {
      if (var2.length == 1) {
         return a(var2, this.d());
      } else {
         return var2.length == 2 ? a(var2, zw.e.c()) : null;
      }
   }

   protected String[] d() {
      return MinecraftServer.N().K();
   }

   public boolean b(String[] var1, int var2) {
      return var2 == 0;
   }

   public String c(m var1) {
      return "commands.give.usage";
   }

   public int a() {
      return 2;
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length < 2) {
         throw new cf("commands.give.usage", new Object[0]);
      } else {
         lf var3 = a(var1, var2[0]);
         zw var4 = f(var1, var2[1]);
         int var5 = var2.length >= 3 ? a(var2[2], 1, 64) : 1;
         int var6 = var2.length >= 4 ? a(var2[3]) : 0;
         zx var7 = new zx(var4, var5, var6);
         if (var2.length >= 5) {
            String var8 = a(var1, var2, 4).c();

            try {
               var7.d(ed.a(var8));
            } catch (ec var10) {
               throw new bz("commands.give.tagError", new Object[]{var10.getMessage()});
            }
         }

         boolean var11 = var3.bi.a(var7);
         if (var11) {
            var3.o.a((pk)var3, "random.pop", 0.2F, ((var3.bc().nextFloat() - var3.bc().nextFloat()) * 0.7F + 1.0F) * 2.0F);
            var3.bj.b();
         }

         uz var9;
         if (var11 && var7.b <= 0) {
            var7.b = 1;
            var1.a(n.a.d, var5);
            var9 = var3.a(var7, false);
            if (var9 != null) {
               var9.v();
            }
         } else {
            var1.a(n.a.d, var5 - var7.b);
            var9 = var3.a(var7, false);
            if (var9 != null) {
               var9.q();
               var9.b(var3.e_());
            }
         }

         a(var1, this, "commands.give.success", new Object[]{var7.C(), var5, var3.e_()});
      }
   }

   public String c() {
      return "give";
   }
}
