import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.server.MinecraftServer;

public class bc extends i {
   protected void o(m var1, String[] var2, int var3) throws bz {
      auo var4 = this.d();
      String var5 = e(var1, var2[var3++]);
      if (var5.length() > 40) {
         throw new cc("commands.scoreboard.players.name.tooLong", new Object[]{var5, 40});
      } else {
         auk var6 = this.a(var2[var3++], false);
         if (!var4.b(var5, var6)) {
            throw new bz("commands.scoreboard.players.test.notFound", new Object[]{var6.b(), var5});
         } else {
            int var7 = var2[var3].equals("*") ? Integer.MIN_VALUE : a(var2[var3]);
            ++var3;
            int var8 = var3 < var2.length && !var2[var3].equals("*") ? a(var2[var3], var7) : Integer.MAX_VALUE;
            aum var9 = var4.c(var5, var6);
            if (var9.c() >= var7 && var9.c() <= var8) {
               a(var1, this, "commands.scoreboard.players.test.success", new Object[]{var9.c(), var7, var8});
            } else {
               throw new bz("commands.scoreboard.players.test.failed", new Object[]{var9.c(), var7, var8});
            }
         }
      }
   }

   protected void j(m var1, String[] var2, int var3) throws bz {
      auo var4 = this.d();
      String var5 = var2[var3++];
      int var6 = auo.i(var5);
      auk var7 = null;
      if (var2.length == 4) {
         var7 = this.a(var2[var3], false);
      }

      if (var6 < 0) {
         throw new bz("commands.scoreboard.objectives.setdisplay.invalidSlot", new Object[]{var5});
      } else {
         var4.a(var6, var7);
         if (var7 != null) {
            a(var1, this, "commands.scoreboard.objectives.setdisplay.successSet", new Object[]{auo.b(var6), var7.b()});
         } else {
            a(var1, this, "commands.scoreboard.objectives.setdisplay.successCleared", new Object[]{auo.b(var6)});
         }

      }
   }

   public void a(m var1, String[] var2) throws bz {
      if (!this.b(var1, var2)) {
         if (var2.length < 1) {
            throw new cf("commands.scoreboard.usage", new Object[0]);
         } else {
            if (var2[0].equalsIgnoreCase("objectives")) {
               if (var2.length == 1) {
                  throw new cf("commands.scoreboard.objectives.usage", new Object[0]);
               }

               if (var2[1].equalsIgnoreCase("list")) {
                  this.d(var1);
               } else if (var2[1].equalsIgnoreCase("add")) {
                  if (var2.length < 4) {
                     throw new cf("commands.scoreboard.objectives.add.usage", new Object[0]);
                  }

                  this.b(var1, var2, 2);
               } else if (var2[1].equalsIgnoreCase("remove")) {
                  if (var2.length != 3) {
                     throw new cf("commands.scoreboard.objectives.remove.usage", new Object[0]);
                  }

                  this.h(var1, var2[2]);
               } else {
                  if (!var2[1].equalsIgnoreCase("setdisplay")) {
                     throw new cf("commands.scoreboard.objectives.usage", new Object[0]);
                  }

                  if (var2.length != 3 && var2.length != 4) {
                     throw new cf("commands.scoreboard.objectives.setdisplay.usage", new Object[0]);
                  }

                  this.j(var1, var2, 2);
               }
            } else if (var2[0].equalsIgnoreCase("players")) {
               if (var2.length == 1) {
                  throw new cf("commands.scoreboard.players.usage", new Object[0]);
               }

               if (var2[1].equalsIgnoreCase("list")) {
                  if (var2.length > 3) {
                     throw new cf("commands.scoreboard.players.list.usage", new Object[0]);
                  }

                  this.k(var1, var2, 2);
               } else if (var2[1].equalsIgnoreCase("add")) {
                  if (var2.length < 5) {
                     throw new cf("commands.scoreboard.players.add.usage", new Object[0]);
                  }

                  this.l(var1, var2, 2);
               } else if (var2[1].equalsIgnoreCase("remove")) {
                  if (var2.length < 5) {
                     throw new cf("commands.scoreboard.players.remove.usage", new Object[0]);
                  }

                  this.l(var1, var2, 2);
               } else if (var2[1].equalsIgnoreCase("set")) {
                  if (var2.length < 5) {
                     throw new cf("commands.scoreboard.players.set.usage", new Object[0]);
                  }

                  this.l(var1, var2, 2);
               } else if (var2[1].equalsIgnoreCase("reset")) {
                  if (var2.length != 3 && var2.length != 4) {
                     throw new cf("commands.scoreboard.players.reset.usage", new Object[0]);
                  }

                  this.m(var1, var2, 2);
               } else if (var2[1].equalsIgnoreCase("enable")) {
                  if (var2.length != 4) {
                     throw new cf("commands.scoreboard.players.enable.usage", new Object[0]);
                  }

                  this.n(var1, var2, 2);
               } else if (var2[1].equalsIgnoreCase("test")) {
                  if (var2.length != 5 && var2.length != 6) {
                     throw new cf("commands.scoreboard.players.test.usage", new Object[0]);
                  }

                  this.o(var1, var2, 2);
               } else {
                  if (!var2[1].equalsIgnoreCase("operation")) {
                     throw new cf("commands.scoreboard.players.usage", new Object[0]);
                  }

                  if (var2.length != 7) {
                     throw new cf("commands.scoreboard.players.operation.usage", new Object[0]);
                  }

                  this.p(var1, var2, 2);
               }
            } else {
               if (!var2[0].equalsIgnoreCase("teams")) {
                  throw new cf("commands.scoreboard.usage", new Object[0]);
               }

               if (var2.length == 1) {
                  throw new cf("commands.scoreboard.teams.usage", new Object[0]);
               }

               if (var2[1].equalsIgnoreCase("list")) {
                  if (var2.length > 3) {
                     throw new cf("commands.scoreboard.teams.list.usage", new Object[0]);
                  }

                  this.f(var1, var2, 2);
               } else if (var2[1].equalsIgnoreCase("add")) {
                  if (var2.length < 3) {
                     throw new cf("commands.scoreboard.teams.add.usage", new Object[0]);
                  }

                  this.c(var1, var2, 2);
               } else if (var2[1].equalsIgnoreCase("remove")) {
                  if (var2.length != 3) {
                     throw new cf("commands.scoreboard.teams.remove.usage", new Object[0]);
                  }

                  this.e(var1, var2, 2);
               } else if (var2[1].equalsIgnoreCase("empty")) {
                  if (var2.length != 3) {
                     throw new cf("commands.scoreboard.teams.empty.usage", new Object[0]);
                  }

                  this.i(var1, var2, 2);
               } else if (var2[1].equalsIgnoreCase("join")) {
                  if (var2.length < 4 && (var2.length != 3 || !(var1 instanceof wn))) {
                     throw new cf("commands.scoreboard.teams.join.usage", new Object[0]);
                  }

                  this.g(var1, var2, 2);
               } else if (var2[1].equalsIgnoreCase("leave")) {
                  if (var2.length < 3 && !(var1 instanceof wn)) {
                     throw new cf("commands.scoreboard.teams.leave.usage", new Object[0]);
                  }

                  this.h(var1, var2, 2);
               } else {
                  if (!var2[1].equalsIgnoreCase("option")) {
                     throw new cf("commands.scoreboard.teams.usage", new Object[0]);
                  }

                  if (var2.length != 4 && var2.length != 5) {
                     throw new cf("commands.scoreboard.teams.option.usage", new Object[0]);
                  }

                  this.d(var1, var2, 2);
               }
            }

         }
      }
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      if (var2.length == 1) {
         return a(var2, new String[]{"objectives", "players", "teams"});
      } else {
         if (var2[0].equalsIgnoreCase("objectives")) {
            if (var2.length == 2) {
               return a(var2, new String[]{"list", "add", "remove", "setdisplay"});
            }

            if (var2[1].equalsIgnoreCase("add")) {
               if (var2.length == 4) {
                  Set var4 = auu.a.keySet();
                  return a(var2, var4);
               }
            } else if (var2[1].equalsIgnoreCase("remove")) {
               if (var2.length == 3) {
                  return a(var2, this.a(false));
               }
            } else if (var2[1].equalsIgnoreCase("setdisplay")) {
               if (var2.length == 3) {
                  return a(var2, auo.h());
               }

               if (var2.length == 4) {
                  return a(var2, this.a(false));
               }
            }
         } else if (var2[0].equalsIgnoreCase("players")) {
            if (var2.length == 2) {
               return a(var2, new String[]{"set", "add", "remove", "reset", "list", "enable", "test", "operation"});
            }

            if (!var2[1].equalsIgnoreCase("set") && !var2[1].equalsIgnoreCase("add") && !var2[1].equalsIgnoreCase("remove") && !var2[1].equalsIgnoreCase("reset")) {
               if (var2[1].equalsIgnoreCase("enable")) {
                  if (var2.length == 3) {
                     return a(var2, MinecraftServer.N().K());
                  }

                  if (var2.length == 4) {
                     return a(var2, this.e());
                  }
               } else if (!var2[1].equalsIgnoreCase("list") && !var2[1].equalsIgnoreCase("test")) {
                  if (var2[1].equalsIgnoreCase("operation")) {
                     if (var2.length == 3) {
                        return a(var2, this.d().d());
                     }

                     if (var2.length == 4) {
                        return a(var2, this.a(true));
                     }

                     if (var2.length == 5) {
                        return a(var2, new String[]{"+=", "-=", "*=", "/=", "%=", "=", "<", ">", "><"});
                     }

                     if (var2.length == 6) {
                        return a(var2, MinecraftServer.N().K());
                     }

                     if (var2.length == 7) {
                        return a(var2, this.a(false));
                     }
                  }
               } else {
                  if (var2.length == 3) {
                     return a(var2, this.d().d());
                  }

                  if (var2.length == 4 && var2[1].equalsIgnoreCase("test")) {
                     return a(var2, this.a(false));
                  }
               }
            } else {
               if (var2.length == 3) {
                  return a(var2, MinecraftServer.N().K());
               }

               if (var2.length == 4) {
                  return a(var2, this.a(true));
               }
            }
         } else if (var2[0].equalsIgnoreCase("teams")) {
            if (var2.length == 2) {
               return a(var2, new String[]{"add", "remove", "join", "leave", "empty", "list", "option"});
            }

            if (var2[1].equalsIgnoreCase("join")) {
               if (var2.length == 3) {
                  return a(var2, this.d().f());
               }

               if (var2.length >= 4) {
                  return a(var2, MinecraftServer.N().K());
               }
            } else {
               if (var2[1].equalsIgnoreCase("leave")) {
                  return a(var2, MinecraftServer.N().K());
               }

               if (!var2[1].equalsIgnoreCase("empty") && !var2[1].equalsIgnoreCase("list") && !var2[1].equalsIgnoreCase("remove")) {
                  if (var2[1].equalsIgnoreCase("option")) {
                     if (var2.length == 3) {
                        return a(var2, this.d().f());
                     }

                     if (var2.length == 4) {
                        return a(var2, new String[]{"color", "friendlyfire", "seeFriendlyInvisibles", "nametagVisibility", "deathMessageVisibility"});
                     }

                     if (var2.length == 5) {
                        if (var2[3].equalsIgnoreCase("color")) {
                           return a(var2, .a.a(true, false));
                        }

                        if (var2[3].equalsIgnoreCase("nametagVisibility") || var2[3].equalsIgnoreCase("deathMessageVisibility")) {
                           return a(var2, auq.a.a());
                        }

                        if (var2[3].equalsIgnoreCase("friendlyfire") || var2[3].equalsIgnoreCase("seeFriendlyInvisibles")) {
                           return a(var2, new String[]{"true", "false"});
                        }
                     }
                  }
               } else if (var2.length == 3) {
                  return a(var2, this.d().f());
               }
            }
         }

         return null;
      }
   }

   protected List<String> e() {
      Collection var1 = this.d().c();
      ArrayList var2 = Lists.newArrayList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         auk var4 = (auk)var3.next();
         if (var4.c() == auu.c) {
            var2.add(var4.b());
         }
      }

      return var2;
   }

   public int a() {
      return 2;
   }

   protected void p(m var1, String[] var2, int var3) throws bz {
      auo var4 = this.d();
      String var5 = e(var1, var2[var3++]);
      auk var6 = this.a(var2[var3++], true);
      String var7 = var2[var3++];
      String var8 = e(var1, var2[var3++]);
      auk var9 = this.a(var2[var3], false);
      if (var5.length() > 40) {
         throw new cc("commands.scoreboard.players.name.tooLong", new Object[]{var5, 40});
      } else if (var8.length() > 40) {
         throw new cc("commands.scoreboard.players.name.tooLong", new Object[]{var8, 40});
      } else {
         aum var10 = var4.c(var5, var6);
         if (!var4.b(var8, var9)) {
            throw new bz("commands.scoreboard.players.operation.notFound", new Object[]{var9.b(), var8});
         } else {
            aum var11 = var4.c(var8, var9);
            if (var7.equals("+=")) {
               var10.c(var10.c() + var11.c());
            } else if (var7.equals("-=")) {
               var10.c(var10.c() - var11.c());
            } else if (var7.equals("*=")) {
               var10.c(var10.c() * var11.c());
            } else if (var7.equals("/=")) {
               if (var11.c() != 0) {
                  var10.c(var10.c() / var11.c());
               }
            } else if (var7.equals("%=")) {
               if (var11.c() != 0) {
                  var10.c(var10.c() % var11.c());
               }
            } else if (var7.equals("=")) {
               var10.c(var11.c());
            } else if (var7.equals("<")) {
               var10.c(Math.min(var10.c(), var11.c()));
            } else if (var7.equals(">")) {
               var10.c(Math.max(var10.c(), var11.c()));
            } else {
               if (!var7.equals("><")) {
                  throw new bz("commands.scoreboard.players.operation.invalidOperation", new Object[]{var7});
               }

               int var12 = var10.c();
               var10.c(var11.c());
               var11.c(var12);
            }

            a(var1, this, "commands.scoreboard.players.operation.success", new Object[0]);
         }
      }
   }

   private boolean b(m var1, String[] var2) throws bz {
      int var3 = -1;

      for(int var4 = 0; var4 < var2.length; ++var4) {
         if (this.b(var2, var4) && "*".equals(var2[var4])) {
            if (var3 >= 0) {
               throw new bz("commands.scoreboard.noMultiWildcard", new Object[0]);
            }

            var3 = var4;
         }
      }

      if (var3 < 0) {
         return false;
      } else {
         ArrayList var12 = Lists.newArrayList(this.d().d());
         String var5 = var2[var3];
         ArrayList var6 = Lists.newArrayList();
         Iterator var7 = var12.iterator();

         while(var7.hasNext()) {
            String var8 = (String)var7.next();
            var2[var3] = var8;

            try {
               this.a(var1, var2);
               var6.add(var8);
            } catch (bz var11) {
               fb var10 = new fb(var11.getMessage(), var11.a());
               var10.b().a(.a.m);
               var1.a(var10);
            }
         }

         var2[var3] = var5;
         var1.a(n.a.c, var6.size());
         if (var6.size() == 0) {
            throw new cf("commands.scoreboard.allMatchesFailed", new Object[0]);
         } else {
            return true;
         }
      }
   }

   protected void n(m var1, String[] var2, int var3) throws bz {
      auo var4 = this.d();
      String var5 = d(var1, var2[var3++]);
      if (var5.length() > 40) {
         throw new cc("commands.scoreboard.players.name.tooLong", new Object[]{var5, 40});
      } else {
         auk var6 = this.a(var2[var3], false);
         if (var6.c() != auu.c) {
            throw new bz("commands.scoreboard.players.enable.noTrigger", new Object[]{var6.b()});
         } else {
            aum var7 = var4.c(var5, var6);
            var7.a(false);
            a(var1, this, "commands.scoreboard.players.enable.success", new Object[]{var6.b(), var5});
         }
      }
   }

   public String c() {
      return "scoreboard";
   }

   protected void h(m var1, String var2) throws bz {
      auo var3 = this.d();
      auk var4 = this.a(var2, false);
      var3.k(var4);
      a(var1, this, "commands.scoreboard.objectives.remove.success", new Object[]{var2});
   }

   protected void d(m var1) throws bz {
      auo var2 = this.d();
      Collection var3 = var2.c();
      if (var3.size() <= 0) {
         throw new bz("commands.scoreboard.objectives.list.empty", new Object[0]);
      } else {
         fb var4 = new fb("commands.scoreboard.objectives.list.count", new Object[]{var3.size()});
         var4.b().a(.a.c);
         var1.a(var4);
         Iterator var5 = var3.iterator();

         while(var5.hasNext()) {
            auk var6 = (auk)var5.next();
            var1.a(new fb("commands.scoreboard.objectives.list.entry", new Object[]{var6.b(), var6.d(), var6.c().a()}));
         }

      }
   }

   protected void e(m var1, String[] var2, int var3) throws bz {
      auo var4 = this.d();
      aul var5 = this.e(var2[var3]);
      if (var5 != null) {
         var4.d(var5);
         a(var1, this, "commands.scoreboard.teams.remove.success", new Object[]{var5.b()});
      }
   }

   protected void d(m var1, String[] var2, int var3) throws bz {
      aul var4 = this.e(var2[var3++]);
      if (var4 != null) {
         String var5 = var2[var3++].toLowerCase();
         if (!var5.equalsIgnoreCase("color") && !var5.equalsIgnoreCase("friendlyfire") && !var5.equalsIgnoreCase("seeFriendlyInvisibles") && !var5.equalsIgnoreCase("nametagVisibility") && !var5.equalsIgnoreCase("deathMessageVisibility")) {
            throw new cf("commands.scoreboard.teams.option.usage", new Object[0]);
         } else if (var2.length == 4) {
            if (var5.equalsIgnoreCase("color")) {
               throw new cf("commands.scoreboard.teams.option.noValue", new Object[]{var5, a(.a.a(true, false))});
            } else if (!var5.equalsIgnoreCase("friendlyfire") && !var5.equalsIgnoreCase("seeFriendlyInvisibles")) {
               if (!var5.equalsIgnoreCase("nametagVisibility") && !var5.equalsIgnoreCase("deathMessageVisibility")) {
                  throw new cf("commands.scoreboard.teams.option.usage", new Object[0]);
               } else {
                  throw new cf("commands.scoreboard.teams.option.noValue", new Object[]{var5, a(auq.a.a())});
               }
            } else {
               throw new cf("commands.scoreboard.teams.option.noValue", new Object[]{var5, a(Arrays.asList("true", "false"))});
            }
         } else {
            String var6 = var2[var3];
            if (var5.equalsIgnoreCase("color")) {
               .a var7 = .a.b(var6);
               if (var7 == null || var7.c()) {
                  throw new cf("commands.scoreboard.teams.option.noValue", new Object[]{var5, a(.a.a(true, false))});
               }

               var4.a(var7);
               var4.b(var7.toString());
               var4.c(.a.v.toString());
            } else if (var5.equalsIgnoreCase("friendlyfire")) {
               if (!var6.equalsIgnoreCase("true") && !var6.equalsIgnoreCase("false")) {
                  throw new cf("commands.scoreboard.teams.option.noValue", new Object[]{var5, a(Arrays.asList("true", "false"))});
               }

               var4.a(var6.equalsIgnoreCase("true"));
            } else if (var5.equalsIgnoreCase("seeFriendlyInvisibles")) {
               if (!var6.equalsIgnoreCase("true") && !var6.equalsIgnoreCase("false")) {
                  throw new cf("commands.scoreboard.teams.option.noValue", new Object[]{var5, a(Arrays.asList("true", "false"))});
               }

               var4.b(var6.equalsIgnoreCase("true"));
            } else {
               auq.a var8;
               if (var5.equalsIgnoreCase("nametagVisibility")) {
                  var8 = auq.a.a(var6);
                  if (var8 == null) {
                     throw new cf("commands.scoreboard.teams.option.noValue", new Object[]{var5, a(auq.a.a())});
                  }

                  var4.a(var8);
               } else if (var5.equalsIgnoreCase("deathMessageVisibility")) {
                  var8 = auq.a.a(var6);
                  if (var8 == null) {
                     throw new cf("commands.scoreboard.teams.option.noValue", new Object[]{var5, a(auq.a.a())});
                  }

                  var4.b(var8);
               }
            }

            a(var1, this, "commands.scoreboard.teams.option.success", new Object[]{var5, var4.b(), var6});
         }
      }
   }

   protected void m(m var1, String[] var2, int var3) throws bz {
      auo var4 = this.d();
      String var5 = e(var1, var2[var3++]);
      if (var2.length > var3) {
         auk var6 = this.a(var2[var3++], false);
         var4.d(var5, var6);
         a(var1, this, "commands.scoreboard.players.resetscore.success", new Object[]{var6.b(), var5});
      } else {
         var4.d(var5, (auk)null);
         a(var1, this, "commands.scoreboard.players.reset.success", new Object[]{var5});
      }

   }

   protected void g(m var1, String[] var2, int var3) throws bz {
      auo var4 = this.d();
      String var5 = var2[var3++];
      HashSet var6 = Sets.newHashSet();
      HashSet var7 = Sets.newHashSet();
      String var8;
      if (var1 instanceof wn && var3 == var2.length) {
         var8 = b(var1).e_();
         if (var4.a(var8, var5)) {
            var6.add(var8);
         } else {
            var7.add(var8);
         }
      } else {
         label70:
         while(true) {
            while(true) {
               if (var3 >= var2.length) {
                  break label70;
               }

               var8 = var2[var3++];
               if (var8.startsWith("@")) {
                  List var13 = c(var1, var8);
                  Iterator var10 = var13.iterator();

                  while(var10.hasNext()) {
                     pk var11 = (pk)var10.next();
                     String var12 = e(var1, var11.aK().toString());
                     if (var4.a(var12, var5)) {
                        var6.add(var12);
                     } else {
                        var7.add(var12);
                     }
                  }
               } else {
                  String var9 = e(var1, var8);
                  if (var4.a(var9, var5)) {
                     var6.add(var9);
                  } else {
                     var7.add(var9);
                  }
               }
            }
         }
      }

      if (!var6.isEmpty()) {
         var1.a(n.a.c, var6.size());
         a(var1, this, "commands.scoreboard.teams.join.success", new Object[]{var6.size(), var5, a(var6.toArray(new String[var6.size()]))});
      }

      if (!var7.isEmpty()) {
         throw new bz("commands.scoreboard.teams.join.failure", new Object[]{var7.size(), var5, a(var7.toArray(new String[var7.size()]))});
      }
   }

   protected void c(m var1, String[] var2, int var3) throws bz {
      String var4 = var2[var3++];
      auo var5 = this.d();
      if (var5.d(var4) != null) {
         throw new bz("commands.scoreboard.teams.add.alreadyExists", new Object[]{var4});
      } else if (var4.length() > 16) {
         throw new cc("commands.scoreboard.teams.add.tooLong", new Object[]{var4, 16});
      } else if (var4.length() == 0) {
         throw new cf("commands.scoreboard.teams.add.usage", new Object[0]);
      } else {
         if (var2.length > var3) {
            String var6 = a(var1, var2, var3).c();
            if (var6.length() > 32) {
               throw new cc("commands.scoreboard.teams.add.displayTooLong", new Object[]{var6, 32});
            }

            if (var6.length() > 0) {
               var5.e(var4).a(var6);
            } else {
               var5.e(var4);
            }
         } else {
            var5.e(var4);
         }

         a(var1, this, "commands.scoreboard.teams.add.success", new Object[]{var4});
      }
   }

   protected List<String> a(boolean var1) {
      Collection var2 = this.d().c();
      ArrayList var3 = Lists.newArrayList();
      Iterator var4 = var2.iterator();

      while(true) {
         auk var5;
         do {
            if (!var4.hasNext()) {
               return var3;
            }

            var5 = (auk)var4.next();
         } while(var1 && var5.c().b());

         var3.add(var5.b());
      }
   }

   protected void h(m var1, String[] var2, int var3) throws bz {
      auo var4 = this.d();
      HashSet var5 = Sets.newHashSet();
      HashSet var6 = Sets.newHashSet();
      String var7;
      if (var1 instanceof wn && var3 == var2.length) {
         var7 = b(var1).e_();
         if (var4.f(var7)) {
            var5.add(var7);
         } else {
            var6.add(var7);
         }
      } else {
         label69:
         while(true) {
            while(true) {
               if (var3 >= var2.length) {
                  break label69;
               }

               var7 = var2[var3++];
               if (var7.startsWith("@")) {
                  List var12 = c(var1, var7);
                  Iterator var9 = var12.iterator();

                  while(var9.hasNext()) {
                     pk var10 = (pk)var9.next();
                     String var11 = e(var1, var10.aK().toString());
                     if (var4.f(var11)) {
                        var5.add(var11);
                     } else {
                        var6.add(var11);
                     }
                  }
               } else {
                  String var8 = e(var1, var7);
                  if (var4.f(var8)) {
                     var5.add(var8);
                  } else {
                     var6.add(var8);
                  }
               }
            }
         }
      }

      if (!var5.isEmpty()) {
         var1.a(n.a.c, var5.size());
         a(var1, this, "commands.scoreboard.teams.leave.success", new Object[]{var5.size(), a(var5.toArray(new String[var5.size()]))});
      }

      if (!var6.isEmpty()) {
         throw new bz("commands.scoreboard.teams.leave.failure", new Object[]{var6.size(), a(var6.toArray(new String[var6.size()]))});
      }
   }

   protected void l(m var1, String[] var2, int var3) throws bz {
      String var4 = var2[var3 - 1];
      int var5 = var3;
      String var6 = e(var1, var2[var3++]);
      if (var6.length() > 40) {
         throw new cc("commands.scoreboard.players.name.tooLong", new Object[]{var6, 40});
      } else {
         auk var7 = this.a(var2[var3++], true);
         int var8 = var4.equalsIgnoreCase("set") ? a(var2[var3++]) : a(var2[var3++], 0);
         if (var2.length > var3) {
            pk var9 = b(var1, var2[var5]);

            try {
               dn var10 = ed.a(a(var2, var3));
               dn var11 = new dn();
               var9.e(var11);
               if (!dy.a(var10, var11, true)) {
                  throw new bz("commands.scoreboard.players.set.tagMismatch", new Object[]{var6});
               }
            } catch (ec var12) {
               throw new bz("commands.scoreboard.players.set.tagError", new Object[]{var12.getMessage()});
            }
         }

         auo var13 = this.d();
         aum var14 = var13.c(var6, var7);
         if (var4.equalsIgnoreCase("set")) {
            var14.c(var8);
         } else if (var4.equalsIgnoreCase("add")) {
            var14.a(var8);
         } else {
            var14.b(var8);
         }

         a(var1, this, "commands.scoreboard.players.set.success", new Object[]{var7.b(), var6, var14.c()});
      }
   }

   protected void b(m var1, String[] var2, int var3) throws bz {
      String var4 = var2[var3++];
      String var5 = var2[var3++];
      auo var6 = this.d();
      auu var7 = (auu)auu.a.get(var5);
      if (var7 == null) {
         throw new cf("commands.scoreboard.objectives.add.wrongType", new Object[]{var5});
      } else if (var6.b(var4) != null) {
         throw new bz("commands.scoreboard.objectives.add.alreadyExists", new Object[]{var4});
      } else if (var4.length() > 16) {
         throw new cc("commands.scoreboard.objectives.add.tooLong", new Object[]{var4, 16});
      } else if (var4.length() == 0) {
         throw new cf("commands.scoreboard.objectives.add.usage", new Object[0]);
      } else {
         if (var2.length > var3) {
            String var8 = a(var1, var2, var3).c();
            if (var8.length() > 32) {
               throw new cc("commands.scoreboard.objectives.add.displayTooLong", new Object[]{var8, 32});
            }

            if (var8.length() > 0) {
               var6.a(var4, var7).a(var8);
            } else {
               var6.a(var4, var7);
            }
         } else {
            var6.a(var4, var7);
         }

         a(var1, this, "commands.scoreboard.objectives.add.success", new Object[]{var4});
      }
   }

   public boolean b(String[] var1, int var2) {
      if (!var1[0].equalsIgnoreCase("players")) {
         if (var1[0].equalsIgnoreCase("teams")) {
            return var2 == 2;
         } else {
            return false;
         }
      } else if (var1.length > 1 && var1[1].equalsIgnoreCase("operation")) {
         return var2 == 2 || var2 == 5;
      } else {
         return var2 == 2;
      }
   }

   protected void k(m var1, String[] var2, int var3) throws bz {
      auo var4 = this.d();
      if (var2.length > var3) {
         String var5 = e(var1, var2[var3]);
         Map var6 = var4.c(var5);
         var1.a(n.a.e, var6.size());
         if (var6.size() <= 0) {
            throw new bz("commands.scoreboard.players.list.player.empty", new Object[]{var5});
         }

         fb var7 = new fb("commands.scoreboard.players.list.player.count", new Object[]{var6.size(), var5});
         var7.b().a(.a.c);
         var1.a(var7);
         Iterator var8 = var6.values().iterator();

         while(var8.hasNext()) {
            aum var9 = (aum)var8.next();
            var1.a(new fb("commands.scoreboard.players.list.player.entry", new Object[]{var9.c(), var9.d().d(), var9.d().b()}));
         }
      } else {
         Collection var10 = var4.d();
         var1.a(n.a.e, var10.size());
         if (var10.size() <= 0) {
            throw new bz("commands.scoreboard.players.list.empty", new Object[0]);
         }

         fb var11 = new fb("commands.scoreboard.players.list.count", new Object[]{var10.size()});
         var11.b().a(.a.c);
         var1.a(var11);
         var1.a(new fa(a(var10.toArray())));
      }

   }

   public String c(m var1) {
      return "commands.scoreboard.usage";
   }

   protected auo d() {
      return MinecraftServer.N().a(0).Z();
   }

   protected void i(m var1, String[] var2, int var3) throws bz {
      auo var4 = this.d();
      aul var5 = this.e(var2[var3]);
      if (var5 != null) {
         ArrayList var6 = Lists.newArrayList(var5.d());
         var1.a(n.a.c, var6.size());
         if (var6.isEmpty()) {
            throw new bz("commands.scoreboard.teams.empty.alreadyEmpty", new Object[]{var5.b()});
         } else {
            Iterator var7 = var6.iterator();

            while(var7.hasNext()) {
               String var8 = (String)var7.next();
               var4.a(var8, var5);
            }

            a(var1, this, "commands.scoreboard.teams.empty.success", new Object[]{var6.size(), var5.b()});
         }
      }
   }

   protected auk a(String var1, boolean var2) throws bz {
      auo var3 = this.d();
      auk var4 = var3.b(var1);
      if (var4 == null) {
         throw new bz("commands.scoreboard.objectiveNotFound", new Object[]{var1});
      } else if (var2 && var4.c().b()) {
         throw new bz("commands.scoreboard.objectiveReadOnly", new Object[]{var1});
      } else {
         return var4;
      }
   }

   protected aul e(String var1) throws bz {
      auo var2 = this.d();
      aul var3 = var2.d(var1);
      if (var3 == null) {
         throw new bz("commands.scoreboard.teamNotFound", new Object[]{var1});
      } else {
         return var3;
      }
   }

   protected void f(m var1, String[] var2, int var3) throws bz {
      auo var4 = this.d();
      if (var2.length > var3) {
         aul var5 = this.e(var2[var3]);
         if (var5 == null) {
            return;
         }

         Collection var6 = var5.d();
         var1.a(n.a.e, var6.size());
         if (var6.size() <= 0) {
            throw new bz("commands.scoreboard.teams.list.player.empty", new Object[]{var5.b()});
         }

         fb var7 = new fb("commands.scoreboard.teams.list.player.count", new Object[]{var6.size(), var5.b()});
         var7.b().a(.a.c);
         var1.a(var7);
         var1.a(new fa(a(var6.toArray())));
      } else {
         Collection var9 = var4.g();
         var1.a(n.a.e, var9.size());
         if (var9.size() <= 0) {
            throw new bz("commands.scoreboard.teams.list.empty", new Object[0]);
         }

         fb var10 = new fb("commands.scoreboard.teams.list.count", new Object[]{var9.size()});
         var10.b().a(.a.c);
         var1.a(var10);
         Iterator var11 = var9.iterator();

         while(var11.hasNext()) {
            aul var8 = (aul)var11.next();
            var1.a(new fb("commands.scoreboard.teams.list.entry", new Object[]{var8.b(), var8.c(), var8.d().size()}));
         }
      }

   }
}
