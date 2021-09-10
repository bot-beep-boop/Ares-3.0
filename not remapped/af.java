import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class af extends i {
   public String c() {
      return "fill";
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length < 7) {
         throw new cf("commands.fill.usage", new Object[0]);
      } else {
         var1.a(n.a.b, 0);
         cj var3 = a(var1, var2, 0, false);
         cj var4 = a(var1, var2, 3, false);
         afh var5 = i.g(var1, var2[6]);
         int var6 = 0;
         if (var2.length >= 8) {
            var6 = a(var2[7], 0, 15);
         }

         cj var7 = new cj(Math.min(var3.n(), var4.n()), Math.min(var3.o(), var4.o()), Math.min(var3.p(), var4.p()));
         cj var8 = new cj(Math.max(var3.n(), var4.n()), Math.max(var3.o(), var4.o()), Math.max(var3.p(), var4.p()));
         int var9 = (var8.n() - var7.n() + 1) * (var8.o() - var7.o() + 1) * (var8.p() - var7.p() + 1);
         if (var9 > 32768) {
            throw new bz("commands.fill.tooManyBlocks", new Object[]{var9, 32768});
         } else if (var7.o() >= 0 && var8.o() < 256) {
            adm var10 = var1.e();

            for(int var11 = var7.p(); var11 < var8.p() + 16; var11 += 16) {
               for(int var12 = var7.n(); var12 < var8.n() + 16; var12 += 16) {
                  if (!var10.e(new cj(var12, var8.o() - var7.o(), var11))) {
                     throw new bz("commands.fill.outOfWorld", new Object[0]);
                  }
               }
            }

            dn var22 = new dn();
            boolean var23 = false;
            if (var2.length >= 10 && var5.z()) {
               String var13 = a(var1, var2, 9).c();

               try {
                  var22 = ed.a(var13);
                  var23 = true;
               } catch (ec var21) {
                  throw new bz("commands.fill.tagError", new Object[]{var21.getMessage()});
               }
            }

            ArrayList var24 = Lists.newArrayList();
            var9 = 0;

            for(int var14 = var7.p(); var14 <= var8.p(); ++var14) {
               for(int var15 = var7.o(); var15 <= var8.o(); ++var15) {
                  for(int var16 = var7.n(); var16 <= var8.n(); ++var16) {
                     cj var17 = new cj(var16, var15, var14);
                     alz var19;
                     if (var2.length >= 9) {
                        if (!var2[8].equals("outline") && !var2[8].equals("hollow")) {
                           if (var2[8].equals("destroy")) {
                              var10.b(var17, true);
                           } else if (var2[8].equals("keep")) {
                              if (!var10.d(var17)) {
                                 continue;
                              }
                           } else if (var2[8].equals("replace") && !var5.z()) {
                              if (var2.length > 9) {
                                 afh var18 = i.g(var1, var2[9]);
                                 if (var10.p(var17).c() != var18) {
                                    continue;
                                 }
                              }

                              if (var2.length > 10) {
                                 int var28 = i.a(var2[10]);
                                 var19 = var10.p(var17);
                                 if (var19.c().c(var19) != var28) {
                                    continue;
                                 }
                              }
                           }
                        } else if (var16 != var7.n() && var16 != var8.n() && var15 != var7.o() && var15 != var8.o() && var14 != var7.p() && var14 != var8.p()) {
                           if (var2[8].equals("hollow")) {
                              var10.a((cj)var17, (alz)afi.a.Q(), 2);
                              var24.add(var17);
                           }
                           continue;
                        }
                     }

                     akw var29 = var10.s(var17);
                     if (var29 != null) {
                        if (var29 instanceof og) {
                           ((og)var29).l();
                        }

                        var10.a(var17, afi.cv.Q(), var5 == afi.cv ? 2 : 4);
                     }

                     var19 = var5.a(var6);
                     if (var10.a((cj)var17, (alz)var19, 2)) {
                        var24.add(var17);
                        ++var9;
                        if (var23) {
                           akw var20 = var10.s(var17);
                           if (var20 != null) {
                              var22.a("x", var17.n());
                              var22.a("y", var17.o());
                              var22.a("z", var17.p());
                              var20.a(var22);
                           }
                        }
                     }
                  }
               }
            }

            Iterator var25 = var24.iterator();

            while(var25.hasNext()) {
               cj var26 = (cj)var25.next();
               afh var27 = var10.p(var26).c();
               var10.b(var26, var27);
            }

            if (var9 <= 0) {
               throw new bz("commands.fill.failed", new Object[0]);
            } else {
               var1.a(n.a.b, var9);
               a(var1, this, "commands.fill.success", new Object[]{var9});
            }
         } else {
            throw new bz("commands.fill.outOfWorld", new Object[0]);
         }
      }
   }

   public int a() {
      return 2;
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      if (var2.length > 0 && var2.length <= 3) {
         return a(var2, 0, var3);
      } else if (var2.length > 3 && var2.length <= 6) {
         return a(var2, 3, var3);
      } else if (var2.length == 7) {
         return a(var2, afh.c.c());
      } else if (var2.length == 9) {
         return a(var2, new String[]{"replace", "destroy", "keep", "hollow", "outline"});
      } else {
         return var2.length == 10 && "replace".equals(var2[8]) ? a(var2, afh.c.c()) : null;
      }
   }

   public String c(m var1) {
      return "commands.fill.usage";
   }
}
