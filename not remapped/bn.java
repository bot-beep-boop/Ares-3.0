import java.util.EnumSet;
import java.util.List;
import net.minecraft.server.MinecraftServer;

public class bn extends i {
   public int a() {
      return 2;
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      return var2.length != 1 && var2.length != 2 ? null : a(var2, MinecraftServer.N().K());
   }

   public boolean b(String[] var1, int var2) {
      return var2 == 0;
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length < 1) {
         throw new cf("commands.tp.usage", new Object[0]);
      } else {
         byte var3 = 0;
         Object var4;
         if (var2.length != 2 && var2.length != 4 && var2.length != 6) {
            var4 = b(var1);
         } else {
            var4 = b(var1, var2[0]);
            var3 = 1;
         }

         if (var2.length != 1 && var2.length != 2) {
            if (var2.length < var3 + 3) {
               throw new cf("commands.tp.usage", new Object[0]);
            } else if (((pk)var4).o != null) {
               int var14 = var3 + 1;
               i.a var6 = a(((pk)var4).s, var2[var3], true);
               i.a var7 = a(((pk)var4).t, var2[var14++], 0, 0, false);
               i.a var8 = a(((pk)var4).u, var2[var14++], true);
               i.a var9 = a((double)((pk)var4).y, var2.length > var14 ? var2[var14++] : "~", false);
               i.a var10 = a((double)((pk)var4).z, var2.length > var14 ? var2[var14] : "~", false);
               float var12;
               if (var4 instanceof lf) {
                  EnumSet var11 = EnumSet.noneOf(fi.a.class);
                  if (var6.c()) {
                     var11.add(fi.a.a);
                  }

                  if (var7.c()) {
                     var11.add(fi.a.b);
                  }

                  if (var8.c()) {
                     var11.add(fi.a.c);
                  }

                  if (var10.c()) {
                     var11.add(fi.a.e);
                  }

                  if (var9.c()) {
                     var11.add(fi.a.d);
                  }

                  var12 = (float)var9.b();
                  if (!var9.c()) {
                     var12 = ns.g(var12);
                  }

                  float var13 = (float)var10.b();
                  if (!var10.c()) {
                     var13 = ns.g(var13);
                  }

                  if (var13 > 90.0F || var13 < -90.0F) {
                     var13 = ns.g(180.0F - var13);
                     var12 = ns.g(var12 + 180.0F);
                  }

                  ((pk)var4).a((pk)null);
                  ((lf)var4).a.a(var6.b(), var7.b(), var8.b(), var12, var13, var11);
                  ((pk)var4).f(var12);
               } else {
                  float var15 = (float)ns.g(var9.a());
                  var12 = (float)ns.g(var10.a());
                  if (var12 > 90.0F || var12 < -90.0F) {
                     var12 = ns.g(180.0F - var12);
                     var15 = ns.g(var15 + 180.0F);
                  }

                  ((pk)var4).b(var6.a(), var7.a(), var8.a(), var15, var12);
                  ((pk)var4).f(var15);
               }

               a(var1, this, "commands.tp.success.coordinates", new Object[]{((pk)var4).e_(), var6.a(), var7.a(), var8.a()});
            }
         } else {
            pk var5 = b(var1, var2[var2.length - 1]);
            if (var5.o != ((pk)var4).o) {
               throw new bz("commands.tp.notSameDimension", new Object[0]);
            } else {
               ((pk)var4).a((pk)null);
               if (var4 instanceof lf) {
                  ((lf)var4).a.a(var5.s, var5.t, var5.u, var5.y, var5.z);
               } else {
                  ((pk)var4).b(var5.s, var5.t, var5.u, var5.y, var5.z);
               }

               a(var1, this, "commands.tp.success", new Object[]{((pk)var4).e_(), var5.e_()});
            }
         }
      }
   }

   public String c() {
      return "tp";
   }

   public String c(m var1) {
      return "commands.tp.usage";
   }
}
