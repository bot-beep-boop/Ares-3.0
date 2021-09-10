import java.util.List;

public class v extends i {
   public int a() {
      return 2;
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      if (var2.length > 0 && var2.length <= 3) {
         return a(var2, 0, var3);
      } else if (var2.length > 3 && var2.length <= 6) {
         return a(var2, 3, var3);
      } else if (var2.length > 6 && var2.length <= 9) {
         return a(var2, 6, var3);
      } else {
         return var2.length == 10 ? a(var2, new String[]{"masked", "all"}) : null;
      }
   }

   public String c() {
      return "testforblocks";
   }

   public String c(m var1) {
      return "commands.compare.usage";
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length < 9) {
         throw new cf("commands.compare.usage", new Object[0]);
      } else {
         var1.a(n.a.b, 0);
         cj var3 = a(var1, var2, 0, false);
         cj var4 = a(var1, var2, 3, false);
         cj var5 = a(var1, var2, 6, false);
         aqe var6 = new aqe(var3, var4);
         aqe var7 = new aqe(var5, var5.a(var6.b()));
         int var8 = var6.c() * var6.d() * var6.e();
         if (var8 > 524288) {
            throw new bz("commands.compare.tooManyBlocks", new Object[]{var8, 524288});
         } else if (var6.b >= 0 && var6.e < 256 && var7.b >= 0 && var7.e < 256) {
            adm var9 = var1.e();
            if (var9.a(var6) && var9.a(var7)) {
               boolean var10 = false;
               if (var2.length > 9 && var2[9].equals("masked")) {
                  var10 = true;
               }

               var8 = 0;
               cj var11 = new cj(var7.a - var6.a, var7.b - var6.b, var7.c - var6.c);
               cj.a var12 = new cj.a();
               cj.a var13 = new cj.a();

               for(int var14 = var6.c; var14 <= var6.f; ++var14) {
                  for(int var15 = var6.b; var15 <= var6.e; ++var15) {
                     for(int var16 = var6.a; var16 <= var6.d; ++var16) {
                        var12.c(var16, var15, var14);
                        var13.c(var16 + var11.n(), var15 + var11.o(), var14 + var11.p());
                        boolean var17 = false;
                        alz var18 = var9.p(var12);
                        if (!var10 || var18.c() != afi.a) {
                           if (var18 == var9.p(var13)) {
                              akw var19 = var9.s(var12);
                              akw var20 = var9.s(var13);
                              if (var19 != null && var20 != null) {
                                 dn var21 = new dn();
                                 var19.b(var21);
                                 var21.o("x");
                                 var21.o("y");
                                 var21.o("z");
                                 dn var22 = new dn();
                                 var20.b(var22);
                                 var22.o("x");
                                 var22.o("y");
                                 var22.o("z");
                                 if (!var21.equals(var22)) {
                                    var17 = true;
                                 }
                              } else if (var19 != null) {
                                 var17 = true;
                              }
                           } else {
                              var17 = true;
                           }

                           ++var8;
                           if (var17) {
                              throw new bz("commands.compare.failed", new Object[0]);
                           }
                        }
                     }
                  }
               }

               var1.a(n.a.b, var8);
               a(var1, this, "commands.compare.success", new Object[]{var8});
            } else {
               throw new bz("commands.compare.outOfWorld", new Object[0]);
            }
         } else {
            throw new bz("commands.compare.outOfWorld", new Object[0]);
         }
      }
   }
}
