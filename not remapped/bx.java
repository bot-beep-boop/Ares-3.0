import java.util.List;
import net.minecraft.server.MinecraftServer;

public class bx extends i {
   public List<String> a(m var1, String[] var2, cj var3) {
      if (var2.length == 1) {
         return a(var2, new String[]{"set", "center", "damage", "warning", "add", "get"});
      } else if (var2.length == 2 && var2[0].equals("damage")) {
         return a(var2, new String[]{"buffer", "amount"});
      } else if (var2.length >= 2 && var2.length <= 3 && var2[0].equals("center")) {
         return b(var2, 1, var3);
      } else {
         return var2.length == 2 && var2[0].equals("warning") ? a(var2, new String[]{"time", "distance"}) : null;
      }
   }

   protected ams d() {
      return MinecraftServer.N().d[0].af();
   }

   public String c(m var1) {
      return "commands.worldborder.usage";
   }

   public String c() {
      return "worldborder";
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length < 1) {
         throw new cf("commands.worldborder.usage", new Object[0]);
      } else {
         ams var3 = this.d();
         double var4;
         double var6;
         long var8;
         if (var2[0].equals("set")) {
            if (var2.length != 2 && var2.length != 3) {
               throw new cf("commands.worldborder.set.usage", new Object[0]);
            }

            var4 = var3.j();
            var6 = a(var2[1], 1.0D, 6.0E7D);
            var8 = var2.length > 2 ? a(var2[2], 0L, 9223372036854775L) * 1000L : 0L;
            if (var8 > 0L) {
               var3.a(var4, var6, var8);
               if (var4 > var6) {
                  a(var1, this, "commands.worldborder.setSlowly.shrink.success", new Object[]{String.format("%.1f", var6), String.format("%.1f", var4), Long.toString(var8 / 1000L)});
               } else {
                  a(var1, this, "commands.worldborder.setSlowly.grow.success", new Object[]{String.format("%.1f", var6), String.format("%.1f", var4), Long.toString(var8 / 1000L)});
               }
            } else {
               var3.a(var6);
               a(var1, this, "commands.worldborder.set.success", new Object[]{String.format("%.1f", var6), String.format("%.1f", var4)});
            }
         } else if (var2[0].equals("add")) {
            if (var2.length != 2 && var2.length != 3) {
               throw new cf("commands.worldborder.add.usage", new Object[0]);
            }

            var4 = var3.h();
            var6 = var4 + a(var2[1], -var4, 6.0E7D - var4);
            var8 = var3.i() + (var2.length > 2 ? a(var2[2], 0L, 9223372036854775L) * 1000L : 0L);
            if (var8 > 0L) {
               var3.a(var4, var6, var8);
               if (var4 > var6) {
                  a(var1, this, "commands.worldborder.setSlowly.shrink.success", new Object[]{String.format("%.1f", var6), String.format("%.1f", var4), Long.toString(var8 / 1000L)});
               } else {
                  a(var1, this, "commands.worldborder.setSlowly.grow.success", new Object[]{String.format("%.1f", var6), String.format("%.1f", var4), Long.toString(var8 / 1000L)});
               }
            } else {
               var3.a(var6);
               a(var1, this, "commands.worldborder.set.success", new Object[]{String.format("%.1f", var6), String.format("%.1f", var4)});
            }
         } else if (var2[0].equals("center")) {
            if (var2.length != 3) {
               throw new cf("commands.worldborder.center.usage", new Object[0]);
            }

            cj var10 = var1.c();
            double var5 = b((double)var10.n() + 0.5D, var2[1], true);
            double var7 = b((double)var10.p() + 0.5D, var2[2], true);
            var3.c(var5, var7);
            a(var1, this, "commands.worldborder.center.success", new Object[]{var5, var7});
         } else if (var2[0].equals("damage")) {
            if (var2.length < 2) {
               throw new cf("commands.worldborder.damage.usage", new Object[0]);
            }

            if (var2[1].equals("buffer")) {
               if (var2.length != 3) {
                  throw new cf("commands.worldborder.damage.buffer.usage", new Object[0]);
               }

               var4 = a(var2[2], 0.0D);
               var6 = var3.m();
               var3.b(var4);
               a(var1, this, "commands.worldborder.damage.buffer.success", new Object[]{String.format("%.1f", var4), String.format("%.1f", var6)});
            } else if (var2[1].equals("amount")) {
               if (var2.length != 3) {
                  throw new cf("commands.worldborder.damage.amount.usage", new Object[0]);
               }

               var4 = a(var2[2], 0.0D);
               var6 = var3.n();
               var3.c(var4);
               a(var1, this, "commands.worldborder.damage.amount.success", new Object[]{String.format("%.2f", var4), String.format("%.2f", var6)});
            }
         } else if (var2[0].equals("warning")) {
            if (var2.length < 2) {
               throw new cf("commands.worldborder.warning.usage", new Object[0]);
            }

            int var12 = a(var2[2], 0);
            int var11;
            if (var2[1].equals("time")) {
               if (var2.length != 3) {
                  throw new cf("commands.worldborder.warning.time.usage", new Object[0]);
               }

               var11 = var3.p();
               var3.b(var12);
               a(var1, this, "commands.worldborder.warning.time.success", new Object[]{var12, var11});
            } else if (var2[1].equals("distance")) {
               if (var2.length != 3) {
                  throw new cf("commands.worldborder.warning.distance.usage", new Object[0]);
               }

               var11 = var3.q();
               var3.c(var12);
               a(var1, this, "commands.worldborder.warning.distance.success", new Object[]{var12, var11});
            }
         } else {
            if (!var2[0].equals("get")) {
               throw new cf("commands.worldborder.usage", new Object[0]);
            }

            var4 = var3.h();
            var1.a(n.a.e, ns.c(var4 + 0.5D));
            var1.a(new fb("commands.worldborder.get.success", new Object[]{String.format("%.0f", var4)}));
         }

      }
   }

   public int a() {
      return 2;
   }
}
