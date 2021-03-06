import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.MinecraftServer;

public class p extends i {
   public boolean b(String[] var1, int var2) {
      return var2 == 2;
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      if (var2.length == 1) {
         return a(var2, new String[]{"give", "take"});
      } else if (var2.length != 2) {
         return var2.length == 3 ? a(var2, MinecraftServer.N().K()) : null;
      } else {
         ArrayList var4 = Lists.newArrayList();
         Iterator var5 = na.b.iterator();

         while(var5.hasNext()) {
            mw var6 = (mw)var5.next();
            var4.add(var6.e);
         }

         return a(var2, var4);
      }
   }

   public String c() {
      return "achievement";
   }

   public int a() {
      return 2;
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length < 2) {
         throw new cf("commands.achievement.usage", new Object[0]);
      } else {
         mw var3 = na.a(var2[1]);
         if (var3 == null && !var2[1].equals("*")) {
            throw new bz("commands.achievement.unknownAchievement", new Object[]{var2[1]});
         } else {
            lf var4 = var2.length >= 3 ? a(var1, var2[2]) : b(var1);
            boolean var5 = var2[0].equalsIgnoreCase("give");
            boolean var6 = var2[0].equalsIgnoreCase("take");
            if (var5 || var6) {
               if (var3 == null) {
                  Iterator var14;
                  mq var15;
                  if (var5) {
                     var14 = mr.e.iterator();

                     while(var14.hasNext()) {
                        var15 = (mq)var14.next();
                        var4.b((mw)var15);
                     }

                     a(var1, this, "commands.achievement.give.success.all", new Object[]{var4.e_()});
                  } else if (var6) {
                     var14 = Lists.reverse(mr.e).iterator();

                     while(var14.hasNext()) {
                        var15 = (mq)var14.next();
                        var4.a((mw)var15);
                     }

                     a(var1, this, "commands.achievement.take.success.all", new Object[]{var4.e_()});
                  }

               } else {
                  if (var3 instanceof mq) {
                     mq var7 = (mq)var3;
                     ArrayList var8;
                     if (var5) {
                        if (var4.A().a((mq)var7)) {
                           throw new bz("commands.achievement.alreadyHave", new Object[]{var4.e_(), var3.j()});
                        }

                        for(var8 = Lists.newArrayList(); var7.c != null && !var4.A().a((mq)var7.c); var7 = var7.c) {
                           var8.add(var7.c);
                        }

                        Iterator var9 = Lists.reverse(var8).iterator();

                        while(var9.hasNext()) {
                           mq var10 = (mq)var9.next();
                           var4.b((mw)var10);
                        }
                     } else if (var6) {
                        if (!var4.A().a((mq)var7)) {
                           throw new bz("commands.achievement.dontHave", new Object[]{var4.e_(), var3.j()});
                        }

                        var8 = Lists.newArrayList(Iterators.filter(mr.e.iterator(), new Predicate<mq>(this, var4, var3) {
                           final p c;
                           final mw b;
                           final lf a;

                           public boolean a(mq var1) {
                              return this.a.A().a((mq)var1) && var1 != this.b;
                           }

                           {
                              this.c = var1;
                              this.a = var2;
                              this.b = var3;
                           }

                           public boolean apply(Object var1) {
                              return this.a((mq)var1);
                           }
                        }));
                        ArrayList var16 = Lists.newArrayList(var8);
                        Iterator var17 = var8.iterator();

                        label158:
                        while(true) {
                           mq var11;
                           mq var12;
                           boolean var13;
                           do {
                              if (!var17.hasNext()) {
                                 var17 = var16.iterator();

                                 while(var17.hasNext()) {
                                    var11 = (mq)var17.next();
                                    var4.a((mw)var11);
                                 }
                                 break label158;
                              }

                              var11 = (mq)var17.next();
                              var12 = var11;

                              for(var13 = false; var12 != null; var12 = var12.c) {
                                 if (var12 == var3) {
                                    var13 = true;
                                 }
                              }
                           } while(var13);

                           for(var12 = var11; var12 != null; var12 = var12.c) {
                              var16.remove(var11);
                           }
                        }
                     }
                  }

                  if (var5) {
                     var4.b((mw)var3);
                     a(var1, this, "commands.achievement.give.success.one", new Object[]{var4.e_(), var3.j()});
                  } else if (var6) {
                     var4.a(var3);
                     a(var1, this, "commands.achievement.take.success.one", new Object[]{var3.j(), var4.e_()});
                  }

               }
            }
         }
      }
   }

   public String c(m var1) {
      return "commands.achievement.usage";
   }
}
