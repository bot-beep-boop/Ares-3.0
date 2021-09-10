import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class u extends i {
   public String c() {
      return "clone";
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length < 9) {
         throw new cf("commands.clone.usage", new Object[0]);
      } else {
         var1.a(n.a.b, 0);
         cj var3 = a(var1, var2, 0, false);
         cj var4 = a(var1, var2, 3, false);
         cj var5 = a(var1, var2, 6, false);
         aqe var6 = new aqe(var3, var4);
         aqe var7 = new aqe(var5, var5.a(var6.b()));
         int var8 = var6.c() * var6.d() * var6.e();
         if (var8 > 32768) {
            throw new bz("commands.clone.tooManyBlocks", new Object[]{var8, 32768});
         } else {
            boolean var9 = false;
            afh var10 = null;
            int var11 = -1;
            if ((var2.length < 11 || !var2[10].equals("force") && !var2[10].equals("move")) && var6.a(var7)) {
               throw new bz("commands.clone.noOverlap", new Object[0]);
            } else {
               if (var2.length >= 11 && var2[10].equals("move")) {
                  var9 = true;
               }

               if (var6.b >= 0 && var6.e < 256 && var7.b >= 0 && var7.e < 256) {
                  adm var12 = var1.e();
                  if (var12.a(var6) && var12.a(var7)) {
                     boolean var13 = false;
                     if (var2.length >= 10) {
                        if (var2[9].equals("masked")) {
                           var13 = true;
                        } else if (var2[9].equals("filtered")) {
                           if (var2.length < 12) {
                              throw new cf("commands.clone.usage", new Object[0]);
                           }

                           var10 = g(var1, var2[11]);
                           if (var2.length >= 13) {
                              var11 = a(var2[12], 0, 15);
                           }
                        }
                     }

                     ArrayList var14 = Lists.newArrayList();
                     ArrayList var15 = Lists.newArrayList();
                     ArrayList var16 = Lists.newArrayList();
                     LinkedList var17 = Lists.newLinkedList();
                     cj var18 = new cj(var7.a - var6.a, var7.b - var6.b, var7.c - var6.c);

                     for(int var19 = var6.c; var19 <= var6.f; ++var19) {
                        for(int var20 = var6.b; var20 <= var6.e; ++var20) {
                           for(int var21 = var6.a; var21 <= var6.d; ++var21) {
                              cj var22 = new cj(var21, var20, var19);
                              cj var23 = var22.a((df)var18);
                              alz var24 = var12.p(var22);
                              if ((!var13 || var24.c() != afi.a) && (var10 == null || var24.c() == var10 && (var11 < 0 || var24.c().c(var24) == var11))) {
                                 akw var25 = var12.s(var22);
                                 if (var25 != null) {
                                    dn var26 = new dn();
                                    var25.b(var26);
                                    var15.add(new u.a(var23, var24, var26));
                                    var17.addLast(var22);
                                 } else if (!var24.c().o() && !var24.c().d()) {
                                    var16.add(new u.a(var23, var24, (dn)null));
                                    var17.addFirst(var22);
                                 } else {
                                    var14.add(new u.a(var23, var24, (dn)null));
                                    var17.addLast(var22);
                                 }
                              }
                           }
                        }
                     }

                     if (var9) {
                        Iterator var27;
                        cj var29;
                        for(var27 = var17.iterator(); var27.hasNext(); var12.a((cj)var29, (alz)afi.cv.Q(), 2)) {
                           var29 = (cj)var27.next();
                           akw var31 = var12.s(var29);
                           if (var31 instanceof og) {
                              ((og)var31).l();
                           }
                        }

                        var27 = var17.iterator();

                        while(var27.hasNext()) {
                           var29 = (cj)var27.next();
                           var12.a((cj)var29, (alz)afi.a.Q(), 3);
                        }
                     }

                     ArrayList var28 = Lists.newArrayList();
                     var28.addAll(var14);
                     var28.addAll(var15);
                     var28.addAll(var16);
                     List var30 = Lists.reverse(var28);

                     Iterator var32;
                     u.a var33;
                     akw var34;
                     for(var32 = var30.iterator(); var32.hasNext(); var12.a((cj)var33.a, (alz)afi.cv.Q(), 2)) {
                        var33 = (u.a)var32.next();
                        var34 = var12.s(var33.a);
                        if (var34 instanceof og) {
                           ((og)var34).l();
                        }
                     }

                     var8 = 0;
                     var32 = var28.iterator();

                     while(var32.hasNext()) {
                        var33 = (u.a)var32.next();
                        if (var12.a((cj)var33.a, (alz)var33.b, 2)) {
                           ++var8;
                        }
                     }

                     for(var32 = var15.iterator(); var32.hasNext(); var12.a((cj)var33.a, (alz)var33.b, 2)) {
                        var33 = (u.a)var32.next();
                        var34 = var12.s(var33.a);
                        if (var33.c != null && var34 != null) {
                           var33.c.a("x", var33.a.n());
                           var33.c.a("y", var33.a.o());
                           var33.c.a("z", var33.a.p());
                           var34.a(var33.c);
                           var34.p_();
                        }
                     }

                     var32 = var30.iterator();

                     while(var32.hasNext()) {
                        var33 = (u.a)var32.next();
                        var12.b(var33.a, var33.b.c());
                     }

                     List var35 = var12.a(var6, false);
                     if (var35 != null) {
                        Iterator var36 = var35.iterator();

                        while(var36.hasNext()) {
                           adw var37 = (adw)var36.next();
                           if (var6.b((df)var37.a)) {
                              cj var38 = var37.a.a((df)var18);
                              var12.b(var38, var37.a(), (int)(var37.b - var12.P().f()), var37.c);
                           }
                        }
                     }

                     if (var8 <= 0) {
                        throw new bz("commands.clone.failed", new Object[0]);
                     } else {
                        var1.a(n.a.b, var8);
                        a(var1, this, "commands.clone.success", new Object[]{var8});
                     }
                  } else {
                     throw new bz("commands.clone.outOfWorld", new Object[0]);
                  }
               } else {
                  throw new bz("commands.clone.outOfWorld", new Object[0]);
               }
            }
         }
      }
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      if (var2.length > 0 && var2.length <= 3) {
         return a(var2, 0, var3);
      } else if (var2.length > 3 && var2.length <= 6) {
         return a(var2, 3, var3);
      } else if (var2.length > 6 && var2.length <= 9) {
         return a(var2, 6, var3);
      } else if (var2.length == 10) {
         return a(var2, new String[]{"replace", "masked", "filtered"});
      } else if (var2.length == 11) {
         return a(var2, new String[]{"normal", "force", "move"});
      } else {
         return var2.length == 12 && "filtered".equals(var2[9]) ? a(var2, afh.c.c()) : null;
      }
   }

   public String c(m var1) {
      return "commands.clone.usage";
   }

   public int a() {
      return 2;
   }

   static class a {
      public final alz b;
      public final cj a;
      public final dn c;

      public a(cj var1, alz var2, dn var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }
   }
}
