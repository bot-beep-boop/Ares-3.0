import java.util.List;
import net.minecraft.server.MinecraftServer;

public class ab extends i {
   public void a(m var1, String[] var2) throws bz {
      if (var2.length < 2) {
         throw new cf("commands.enchant.usage", new Object[0]);
      } else {
         lf var3 = a(var1, var2[0]);
         var1.a(n.a.d, 0);

         int var4;
         try {
            var4 = a(var2[1], 0);
         } catch (cb var12) {
            aci var6 = aci.b(var2[1]);
            if (var6 == null) {
               throw var12;
            }

            var4 = var6.B;
         }

         int var5 = 1;
         zx var13 = var3.bZ();
         if (var13 == null) {
            throw new bz("commands.enchant.noItem", new Object[0]);
         } else {
            aci var7 = aci.c(var4);
            if (var7 == null) {
               throw new cb("commands.enchant.notFound", new Object[]{var4});
            } else if (!var7.a(var13)) {
               throw new bz("commands.enchant.cantEnchant", new Object[0]);
            } else {
               if (var2.length >= 3) {
                  var5 = a(var2[2], var7.e(), var7.b());
               }

               if (var13.n()) {
                  du var8 = var13.p();
                  if (var8 != null) {
                     for(int var9 = 0; var9 < var8.c(); ++var9) {
                        short var10 = var8.b(var9).e("id");
                        if (aci.c(var10) != null) {
                           aci var11 = aci.c(var10);
                           if (!var11.a(var7)) {
                              throw new bz("commands.enchant.cantCombine", new Object[]{var7.d(var5), var11.d(var8.b(var9).e("lvl"))});
                           }
                        }
                     }
                  }
               }

               var13.a(var7, var5);
               a(var1, this, "commands.enchant.success", new Object[0]);
               var1.a(n.a.d, 1);
            }
         }
      }
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      if (var2.length == 1) {
         return a(var2, this.d());
      } else {
         return var2.length == 2 ? a(var2, aci.c()) : null;
      }
   }

   public boolean b(String[] var1, int var2) {
      return var2 == 0;
   }

   public String c(m var1) {
      return "commands.enchant.usage";
   }

   public String c() {
      return "enchant";
   }

   protected String[] d() {
      return MinecraftServer.N().K();
   }

   public int a() {
      return 2;
   }
}
