import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import net.minecraft.server.MinecraftServer;

public class ax extends i {
   private static final Map<String, Integer> a = Maps.newHashMap();

   public List<String> a(m var1, String[] var2, cj var3) {
      if (var2.length == 1) {
         return a(var2, new String[]{"entity", "block"});
      } else if (var2.length == 2 && var2[0].equals("entity")) {
         return a(var2, this.d());
      } else if (var2.length >= 2 && var2.length <= 4 && var2[0].equals("block")) {
         return a(var2, 1, var3);
      } else if ((var2.length != 3 || !var2[0].equals("entity")) && (var2.length != 5 || !var2[0].equals("block"))) {
         return (var2.length != 4 || !var2[0].equals("entity")) && (var2.length != 6 || !var2[0].equals("block")) ? null : a(var2, zw.e.c());
      } else {
         return a(var2, a.keySet());
      }
   }

   private int e(String var1) throws bz {
      if (!a.containsKey(var1)) {
         throw new bz("commands.generic.parameter.invalid", new Object[]{var1});
      } else {
         return (Integer)a.get(var1);
      }
   }

   static {
      int var0;
      for(var0 = 0; var0 < 54; ++var0) {
         a.put("slot.container." + var0, var0);
      }

      for(var0 = 0; var0 < 9; ++var0) {
         a.put("slot.hotbar." + var0, var0);
      }

      for(var0 = 0; var0 < 27; ++var0) {
         a.put("slot.inventory." + var0, 9 + var0);
      }

      for(var0 = 0; var0 < 27; ++var0) {
         a.put("slot.enderchest." + var0, 200 + var0);
      }

      for(var0 = 0; var0 < 8; ++var0) {
         a.put("slot.villager." + var0, 300 + var0);
      }

      for(var0 = 0; var0 < 15; ++var0) {
         a.put("slot.horse." + var0, 500 + var0);
      }

      a.put("slot.weapon", 99);
      a.put("slot.armor.head", 103);
      a.put("slot.armor.chest", 102);
      a.put("slot.armor.legs", 101);
      a.put("slot.armor.feet", 100);
      a.put("slot.horse.saddle", 400);
      a.put("slot.horse.armor", 401);
      a.put("slot.horse.chest", 499);
   }

   protected String[] d() {
      return MinecraftServer.N().K();
   }

   public String c() {
      return "replaceitem";
   }

   public String c(m var1) {
      return "commands.replaceitem.usage";
   }

   public int a() {
      return 2;
   }

   public boolean b(String[] var1, int var2) {
      return var1.length > 0 && var1[0].equals("entity") && var2 == 1;
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length < 1) {
         throw new cf("commands.replaceitem.usage", new Object[0]);
      } else {
         boolean var3;
         if (var2[0].equals("entity")) {
            var3 = false;
         } else {
            if (!var2[0].equals("block")) {
               throw new cf("commands.replaceitem.usage", new Object[0]);
            }

            var3 = true;
         }

         byte var4;
         if (var3) {
            if (var2.length < 6) {
               throw new cf("commands.replaceitem.block.usage", new Object[0]);
            }

            var4 = 4;
         } else {
            if (var2.length < 4) {
               throw new cf("commands.replaceitem.entity.usage", new Object[0]);
            }

            var4 = 2;
         }

         int var16 = var4 + 1;
         int var5 = this.e(var2[var4]);

         zw var6;
         try {
            var6 = f(var1, var2[var16]);
         } catch (cb var15) {
            if (afh.b(var2[var16]) != afi.a) {
               throw var15;
            }

            var6 = null;
         }

         ++var16;
         int var7 = var2.length > var16 ? a(var2[var16++], 1, 64) : 1;
         int var8 = var2.length > var16 ? a(var2[var16++]) : 0;
         zx var9 = new zx(var6, var7, var8);
         if (var2.length > var16) {
            String var10 = a(var1, var2, var16).c();

            try {
               var9.d(ed.a(var10));
            } catch (ec var14) {
               throw new bz("commands.replaceitem.tagError", new Object[]{var14.getMessage()});
            }
         }

         if (var9.b() == null) {
            var9 = null;
         }

         if (var3) {
            var1.a(n.a.d, 0);
            cj var18 = a(var1, var2, 1, false);
            adm var11 = var1.e();
            akw var12 = var11.s(var18);
            if (var12 == null || !(var12 instanceof og)) {
               throw new bz("commands.replaceitem.noContainer", new Object[]{var18.n(), var18.o(), var18.p()});
            }

            og var13 = (og)var12;
            if (var5 >= 0 && var5 < var13.o_()) {
               var13.a(var5, var9);
            }
         } else {
            pk var17 = b(var1, var2[1]);
            var1.a(n.a.d, 0);
            if (var17 instanceof wn) {
               ((wn)var17).bj.b();
            }

            if (!var17.d(var5, var9)) {
               throw new bz("commands.replaceitem.failed", new Object[]{var5, var7, var9 == null ? "Air" : var9.C()});
            }

            if (var17 instanceof wn) {
               ((wn)var17).bj.b();
            }
         }

         var1.a(n.a.d, var7);
         a(var1, this, "commands.replaceitem.success", new Object[]{var5, var7, var9 == null ? "Air" : var9.C()});
      }
   }
}
