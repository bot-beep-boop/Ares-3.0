import java.util.List;

public class bp extends i {
   public int a() {
      return 2;
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length < 4) {
         throw new cf("commands.testforblock.usage", new Object[0]);
      } else {
         var1.a(n.a.b, 0);
         cj var3 = a(var1, var2, 0, false);
         afh var4 = afh.b(var2[3]);
         if (var4 == null) {
            throw new cb("commands.setblock.notFound", new Object[]{var2[3]});
         } else {
            int var5 = -1;
            if (var2.length >= 5) {
               var5 = a(var2[4], -1, 15);
            }

            adm var6 = var1.e();
            if (!var6.e(var3)) {
               throw new bz("commands.testforblock.outOfWorld", new Object[0]);
            } else {
               dn var7 = new dn();
               boolean var8 = false;
               if (var2.length >= 6 && var4.z()) {
                  String var9 = a(var1, var2, 5).c();

                  try {
                     var7 = ed.a(var9);
                     var8 = true;
                  } catch (ec var13) {
                     throw new bz("commands.setblock.tagError", new Object[]{var13.getMessage()});
                  }
               }

               alz var14 = var6.p(var3);
               afh var10 = var14.c();
               if (var10 != var4) {
                  throw new bz("commands.testforblock.failed.tile", new Object[]{var3.n(), var3.o(), var3.p(), var10.f(), var4.f()});
               } else {
                  if (var5 > -1) {
                     int var11 = var14.c().c(var14);
                     if (var11 != var5) {
                        throw new bz("commands.testforblock.failed.data", new Object[]{var3.n(), var3.o(), var3.p(), var11, var5});
                     }
                  }

                  if (var8) {
                     akw var15 = var6.s(var3);
                     if (var15 == null) {
                        throw new bz("commands.testforblock.failed.tileEntity", new Object[]{var3.n(), var3.o(), var3.p()});
                     }

                     dn var12 = new dn();
                     var15.b(var12);
                     if (!dy.a(var7, var12, true)) {
                        throw new bz("commands.testforblock.failed.nbt", new Object[]{var3.n(), var3.o(), var3.p()});
                     }
                  }

                  var1.a(n.a.b, 1);
                  a(var1, this, "commands.testforblock.success", new Object[]{var3.n(), var3.o(), var3.p()});
               }
            }
         }
      }
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      if (var2.length > 0 && var2.length <= 3) {
         return a(var2, 0, var3);
      } else {
         return var2.length == 4 ? a(var2, afh.c.c()) : null;
      }
   }

   public String c() {
      return "testforblock";
   }

   public String c(m var1) {
      return "commands.testforblock.usage";
   }
}
