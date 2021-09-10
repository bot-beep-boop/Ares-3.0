import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.MinecraftServer;

public class bk extends i {
   public void a(m var1, String[] var2) throws bz {
      if (var2.length < 1) {
         throw new cf("commands.stats.usage", new Object[0]);
      } else {
         boolean var3;
         if (var2[0].equals("entity")) {
            var3 = false;
         } else {
            if (!var2[0].equals("block")) {
               throw new cf("commands.stats.usage", new Object[0]);
            }

            var3 = true;
         }

         byte var4;
         if (var3) {
            if (var2.length < 5) {
               throw new cf("commands.stats.block.usage", new Object[0]);
            }

            var4 = 4;
         } else {
            if (var2.length < 3) {
               throw new cf("commands.stats.entity.usage", new Object[0]);
            }

            var4 = 2;
         }

         int var11 = var4 + 1;
         String var5 = var2[var4];
         if ("set".equals(var5)) {
            if (var2.length < var11 + 3) {
               if (var11 == 5) {
                  throw new cf("commands.stats.block.set.usage", new Object[0]);
               }

               throw new cf("commands.stats.entity.set.usage", new Object[0]);
            }
         } else {
            if (!"clear".equals(var5)) {
               throw new cf("commands.stats.usage", new Object[0]);
            }

            if (var2.length < var11 + 1) {
               if (var11 == 5) {
                  throw new cf("commands.stats.block.clear.usage", new Object[0]);
               }

               throw new cf("commands.stats.entity.clear.usage", new Object[0]);
            }
         }

         n.a var6 = n.a.a(var2[var11++]);
         if (var6 == null) {
            throw new bz("commands.stats.failed", new Object[0]);
         } else {
            adm var7 = var1.e();
            n var8;
            cj var9;
            akw var10;
            if (var3) {
               var9 = a(var1, var2, 1, false);
               var10 = var7.s(var9);
               if (var10 == null) {
                  throw new bz("commands.stats.noCompatibleBlock", new Object[]{var9.n(), var9.o(), var9.p()});
               }

               if (var10 instanceof akz) {
                  var8 = ((akz)var10).c();
               } else {
                  if (!(var10 instanceof aln)) {
                     throw new bz("commands.stats.noCompatibleBlock", new Object[]{var9.n(), var9.o(), var9.p()});
                  }

                  var8 = ((aln)var10).d();
               }
            } else {
               pk var12 = b(var1, var2[1]);
               var8 = var12.aU();
            }

            if ("set".equals(var5)) {
               String var13 = var2[var11++];
               String var14 = var2[var11];
               if (var13.length() == 0 || var14.length() == 0) {
                  throw new bz("commands.stats.failed", new Object[0]);
               }

               n.a(var8, var6, var13, var14);
               a(var1, this, "commands.stats.success", new Object[]{var6.b(), var14, var13});
            } else if ("clear".equals(var5)) {
               n.a(var8, var6, (String)null, (String)null);
               a(var1, this, "commands.stats.cleared", new Object[]{var6.b()});
            }

            if (var3) {
               var9 = a(var1, var2, 1, false);
               var10 = var7.s(var9);
               var10.p_();
            }

         }
      }
   }

   public String c() {
      return "stats";
   }

   public int a() {
      return 2;
   }

   public boolean b(String[] var1, int var2) {
      return var1.length > 0 && var1[0].equals("entity") && var2 == 1;
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      if (var2.length == 1) {
         return a(var2, new String[]{"entity", "block"});
      } else if (var2.length == 2 && var2[0].equals("entity")) {
         return a(var2, this.d());
      } else if (var2.length >= 2 && var2.length <= 4 && var2[0].equals("block")) {
         return a(var2, 1, var3);
      } else if ((var2.length != 3 || !var2[0].equals("entity")) && (var2.length != 5 || !var2[0].equals("block"))) {
         if (var2.length == 4 && var2[0].equals("entity") || var2.length == 6 && var2[0].equals("block")) {
            return a(var2, n.a.c());
         } else {
            return (var2.length != 6 || !var2[0].equals("entity")) && (var2.length != 8 || !var2[0].equals("block")) ? null : a(var2, this.e());
         }
      } else {
         return a(var2, new String[]{"set", "clear"});
      }
   }

   public String c(m var1) {
      return "commands.stats.usage";
   }

   protected String[] d() {
      return MinecraftServer.N().K();
   }

   protected List<String> e() {
      Collection var1 = MinecraftServer.N().a(0).Z().c();
      ArrayList var2 = Lists.newArrayList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         auk var4 = (auk)var3.next();
         if (!var4.c().b()) {
            var2.add(var4.b());
         }
      }

      return var2;
   }
}
