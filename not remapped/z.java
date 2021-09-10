import java.util.List;
import net.minecraft.server.MinecraftServer;

public class z extends i {
   public boolean b(String[] var1, int var2) {
      return var2 == 0;
   }

   public int a() {
      return 2;
   }

   public String c() {
      return "effect";
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length < 2) {
         throw new cf("commands.effect.usage", new Object[0]);
      } else {
         pr var3 = (pr)a(var1, var2[0], pr.class);
         if (var2[1].equals("clear")) {
            if (var3.bl().isEmpty()) {
               throw new bz("commands.effect.failure.notActive.all", new Object[]{var3.e_()});
            } else {
               var3.bk();
               a(var1, this, "commands.effect.success.removed.all", new Object[]{var3.e_()});
            }
         } else {
            int var4;
            try {
               var4 = a(var2[1], 1);
            } catch (cb var11) {
               pe var6 = pe.b(var2[1]);
               if (var6 == null) {
                  throw var11;
               }

               var4 = var6.H;
            }

            int var5 = 600;
            int var12 = 30;
            int var7 = 0;
            if (var4 >= 0 && var4 < pe.a.length && pe.a[var4] != null) {
               pe var8 = pe.a[var4];
               if (var2.length >= 3) {
                  var12 = a(var2[2], 0, 1000000);
                  if (var8.b()) {
                     var5 = var12;
                  } else {
                     var5 = var12 * 20;
                  }
               } else if (var8.b()) {
                  var5 = 1;
               }

               if (var2.length >= 4) {
                  var7 = a(var2[3], 0, 255);
               }

               boolean var9 = true;
               if (var2.length >= 5 && "true".equalsIgnoreCase(var2[4])) {
                  var9 = false;
               }

               if (var12 > 0) {
                  pf var10 = new pf(var4, var5, var7, false, var9);
                  var3.c(var10);
                  a(var1, this, "commands.effect.success", new Object[]{new fb(var10.g(), new Object[0]), var4, var7, var3.e_(), var12});
               } else if (var3.k(var4)) {
                  var3.m(var4);
                  a(var1, this, "commands.effect.success.removed", new Object[]{new fb(var8.a(), new Object[0]), var3.e_()});
               } else {
                  throw new bz("commands.effect.failure.notActive", new Object[]{new fb(var8.a(), new Object[0]), var3.e_()});
               }
            } else {
               throw new cb("commands.effect.notFound", new Object[]{var4});
            }
         }
      }
   }

   public String c(m var1) {
      return "commands.effect.usage";
   }

   protected String[] d() {
      return MinecraftServer.N().K();
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      if (var2.length == 1) {
         return a(var2, this.d());
      } else if (var2.length == 2) {
         return a(var2, pe.c());
      } else {
         return var2.length == 5 ? a(var2, new String[]{"true", "false"}) : null;
      }
   }
}
