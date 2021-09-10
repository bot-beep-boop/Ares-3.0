import java.util.List;

public class be extends i {
   public String c(m var1) {
      return "commands.setblock.usage";
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length < 4) {
         throw new cf("commands.setblock.usage", new Object[0]);
      } else {
         var1.a(n.a.b, 0);
         cj var3 = a(var1, var2, 0, false);
         afh var4 = i.g(var1, var2[3]);
         int var5 = 0;
         if (var2.length >= 5) {
            var5 = a(var2[4], 0, 15);
         }

         adm var6 = var1.e();
         if (!var6.e(var3)) {
            throw new bz("commands.setblock.outOfWorld", new Object[0]);
         } else {
            dn var7 = new dn();
            boolean var8 = false;
            if (var2.length >= 7 && var4.z()) {
               String var9 = a(var1, var2, 6).c();

               try {
                  var7 = ed.a(var9);
                  var8 = true;
               } catch (ec var12) {
                  throw new bz("commands.setblock.tagError", new Object[]{var12.getMessage()});
               }
            }

            if (var2.length >= 6) {
               if (var2[5].equals("destroy")) {
                  var6.b(var3, true);
                  if (var4 == afi.a) {
                     a(var1, this, "commands.setblock.success", new Object[0]);
                     return;
                  }
               } else if (var2[5].equals("keep") && !var6.d(var3)) {
                  throw new bz("commands.setblock.noChange", new Object[0]);
               }
            }

            akw var13 = var6.s(var3);
            if (var13 != null) {
               if (var13 instanceof og) {
                  ((og)var13).l();
               }

               var6.a(var3, afi.a.Q(), var4 == afi.a ? 2 : 4);
            }

            alz var10 = var4.a(var5);
            if (!var6.a((cj)var3, (alz)var10, 2)) {
               throw new bz("commands.setblock.noChange", new Object[0]);
            } else {
               if (var8) {
                  akw var11 = var6.s(var3);
                  if (var11 != null) {
                     var7.a("x", var3.n());
                     var7.a("y", var3.o());
                     var7.a("z", var3.p());
                     var11.a(var7);
                  }
               }

               var6.b(var3, var10.c());
               var1.a(n.a.b, 1);
               a(var1, this, "commands.setblock.success", new Object[0]);
            }
         }
      }
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      if (var2.length > 0 && var2.length <= 3) {
         return a(var2, 0, var3);
      } else if (var2.length == 4) {
         return a(var2, afh.c.c());
      } else {
         return var2.length == 6 ? a(var2, new String[]{"replace", "destroy", "keep"}) : null;
      }
   }

   public String c() {
      return "setblock";
   }

   public int a() {
      return 2;
   }
}
