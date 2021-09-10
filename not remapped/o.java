import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.server.MinecraftServer;

public class o {
   private static final Pattern b = Pattern.compile("\\G([-!]?[\\w-]*)(?:$|,)");
   private static final Pattern c = Pattern.compile("\\G(\\w+)=([-!]?[\\w-]*)(?:$|,)");
   private static final Set<String> d = Sets.newHashSet(new String[]{"x", "y", "z", "dx", "dy", "dz", "rm", "r"});
   private static final Pattern a = Pattern.compile("^@([pare])(?:\\[([\\w=,!-]*)\\])?$");

   public static int a(int var0) {
      var0 %= 360;
      if (var0 >= 160) {
         var0 -= 360;
      }

      if (var0 < 0) {
         var0 += 360;
      }

      return var0;
   }

   private static List<Predicate<pk>> d(Map<String, String> var0) {
      ArrayList var1 = Lists.newArrayList();
      String var2 = b(var0, "team");
      boolean var3 = var2 != null && var2.startsWith("!");
      if (var3) {
         var2 = var2.substring(1);
      }

      if (var2 != null) {
         var1.add(new Predicate<pk>(var2, var3) {
            final boolean b;
            final String a;

            public boolean a(pk var1) {
               if (!(var1 instanceof pr)) {
                  return false;
               } else {
                  pr var2 = (pr)var1;
                  auq var3 = var2.bO();
                  String var4 = var3 == null ? "" : var3.b();
                  return var4.equals(this.a) != this.b;
               }
            }

            public boolean apply(Object var1) {
               return this.a((pk)var1);
            }

            {
               this.a = var1;
               this.b = var2;
            }
         });
      }

      return var1;
   }

   public static <T extends pk> T a(m var0, String var1, Class<? extends T> var2) {
      List var3 = b(var0, var1, var2);
      return var3.size() == 1 ? (pk)var3.get(0) : null;
   }

   private static <T extends pk> boolean b(m var0, Map<String, String> var1) {
      String var2 = b(var1, "type");
      var2 = var2 != null && var2.startsWith("!") ? var2.substring(1) : var2;
      if (var2 != null && !pm.b(var2)) {
         fb var3 = new fb("commands.generic.entity.invalidType", new Object[]{var2});
         var3.b().a(a.m);
         var0.a(var3);
         return false;
      } else {
         return true;
      }
   }

   private static int a(Map<String, String> var0, String var1, int var2) {
      return var0.containsKey(var1) ? ns.a((String)var0.get(var1), var2) : var2;
   }

   public static boolean a(String var0) {
      Matcher var1 = a.matcher(var0);
      if (!var1.matches()) {
         return false;
      } else {
         Map var2 = c(var1.group(2));
         String var3 = var1.group(1);
         int var4 = !"a".equals(var3) && !"e".equals(var3) ? 1 : 0;
         return a(var2, "c", var4) != 1;
      }
   }

   private static List<Predicate<pk>> f(Map<String, String> var0) {
      ArrayList var1 = Lists.newArrayList();
      String var2 = b(var0, "name");
      boolean var3 = var2 != null && var2.startsWith("!");
      if (var3) {
         var2 = var2.substring(1);
      }

      if (var2 != null) {
         var1.add(new Predicate<pk>(var2, var3) {
            final boolean b;
            final String a;

            public boolean apply(Object var1) {
               return this.a((pk)var1);
            }

            {
               this.a = var1;
               this.b = var2;
            }

            public boolean a(pk var1) {
               return var1.e_().equals(this.a) != this.b;
            }
         });
      }

      return var1;
   }

   public static lf a(m var0, String var1) {
      return (lf)a(var0, var1, lf.class);
   }

   private static List<adm> a(m var0, Map<String, String> var1) {
      ArrayList var2 = Lists.newArrayList();
      if (h(var1)) {
         var2.add(var0.e());
      } else {
         Collections.addAll(var2, MinecraftServer.N().d);
      }

      return var2;
   }

   private static List<Predicate<pk>> a(Map<String, String> var0, cj var1) {
      ArrayList var2 = Lists.newArrayList();
      int var3 = a(var0, "rm", -1);
      int var4 = a(var0, "r", -1);
      if (var1 != null && (var3 >= 0 || var4 >= 0)) {
         int var5 = var3 * var3;
         int var6 = var4 * var4;
         var2.add(new Predicate<pk>(var1, var3, var5, var4, var6) {
            final int d;
            final cj a;
            final int b;
            final int c;
            final int e;

            public boolean apply(Object var1) {
               return this.a((pk)var1);
            }

            public boolean a(pk var1) {
               int var2 = (int)var1.c(this.a);
               return (this.b < 0 || var2 >= this.c) && (this.d < 0 || var2 <= this.e);
            }

            {
               this.a = var1;
               this.b = var2;
               this.c = var3;
               this.d = var4;
               this.e = var5;
            }
         });
      }

      return var2;
   }

   private static String b(Map<String, String> var0, String var1) {
      return (String)var0.get(var1);
   }

   private static boolean h(Map<String, String> var0) {
      Iterator var1 = d.iterator();

      String var2;
      do {
         if (!var1.hasNext()) {
            return false;
         }

         var2 = (String)var1.next();
      } while(!var0.containsKey(var2));

      return true;
   }

   private static List<Predicate<pk>> g(Map<String, String> var0) {
      ArrayList var1 = Lists.newArrayList();
      int var2;
      int var3;
      if (var0.containsKey("rym") || var0.containsKey("ry")) {
         var2 = a(a(var0, "rym", 0));
         var3 = a(a(var0, "ry", 359));
         var1.add(new Predicate<pk>(var2, var3) {
            final int b;
            final int a;

            public boolean apply(Object var1) {
               return this.a((pk)var1);
            }

            public boolean a(pk var1) {
               int var2 = o.a((int)Math.floor((double)var1.y));
               if (this.a > this.b) {
                  return var2 >= this.a || var2 <= this.b;
               } else {
                  return var2 >= this.a && var2 <= this.b;
               }
            }

            {
               this.a = var1;
               this.b = var2;
            }
         });
      }

      if (var0.containsKey("rxm") || var0.containsKey("rx")) {
         var2 = a(a(var0, "rxm", 0));
         var3 = a(a(var0, "rx", 359));
         var1.add(new Predicate<pk>(var2, var3) {
            final int b;
            final int a;

            public boolean apply(Object var1) {
               return this.a((pk)var1);
            }

            public boolean a(pk var1) {
               int var2 = o.a((int)Math.floor((double)var1.z));
               if (this.a > this.b) {
                  return var2 >= this.a || var2 <= this.b;
               } else {
                  return var2 >= this.a && var2 <= this.b;
               }
            }

            {
               this.a = var1;
               this.b = var2;
            }
         });
      }

      return var1;
   }

   private static List<Predicate<pk>> a(Map<String, String> var0, String var1) {
      ArrayList var2 = Lists.newArrayList();
      String var3 = b(var0, "type");
      boolean var4 = var3 != null && var3.startsWith("!");
      if (var4) {
         var3 = var3.substring(1);
      }

      boolean var6 = !var1.equals("e");
      boolean var7 = var1.equals("r") && var3 != null;
      if ((var3 == null || !var1.equals("e")) && !var7) {
         if (var6) {
            var2.add(new Predicate<pk>() {
               public boolean apply(Object var1) {
                  return this.a((pk)var1);
               }

               public boolean a(pk var1) {
                  return var1 instanceof wn;
               }
            });
         }
      } else {
         var2.add(new Predicate<pk>(var3, var4) {
            final String a;
            final boolean b;

            public boolean apply(Object var1) {
               return this.a((pk)var1);
            }

            public boolean a(pk var1) {
               return pm.a(var1, this.a) != this.b;
            }

            {
               this.a = var1;
               this.b = var2;
            }
         });
      }

      return var2;
   }

   public static boolean b(String var0) {
      return a.matcher(var0).matches();
   }

   private static Map<String, String> c(String var0) {
      HashMap var1 = Maps.newHashMap();
      if (var0 == null) {
         return var1;
      } else {
         int var2 = 0;
         int var3 = -1;

         for(Matcher var4 = b.matcher(var0); var4.find(); var3 = var4.end()) {
            String var5 = null;
            switch(var2++) {
            case 0:
               var5 = "x";
               break;
            case 1:
               var5 = "y";
               break;
            case 2:
               var5 = "z";
               break;
            case 3:
               var5 = "r";
            }

            if (var5 != null && var4.group(1).length() > 0) {
               var1.put(var5, var4.group(1));
            }
         }

         if (var3 < var0.length()) {
            Matcher var6 = c.matcher(var3 == -1 ? var0 : var0.substring(var3));

            while(var6.find()) {
               var1.put(var6.group(1), var6.group(2));
            }
         }

         return var1;
      }
   }

   private static <T extends pk> List<T> a(Map<String, String> var0, Class<? extends T> var1, List<Predicate<pk>> var2, String var3, adm var4, cj var5) {
      ArrayList var6 = Lists.newArrayList();
      String var7 = b(var0, "type");
      var7 = var7 != null && var7.startsWith("!") ? var7.substring(1) : var7;
      boolean var8 = !var3.equals("e");
      boolean var9 = var3.equals("r") && var7 != null;
      int var10 = a(var0, "dx", 0);
      int var11 = a(var0, "dy", 0);
      int var12 = a(var0, "dz", 0);
      int var13 = a(var0, "r", -1);
      Predicate var14 = Predicates.and(var2);
      Predicate var15 = Predicates.and(po.a, var14);
      if (var5 != null) {
         int var16 = var4.j.size();
         int var17 = var4.f.size();
         boolean var18 = var16 < var17 / 16;
         aug var19;
         if (!var0.containsKey("dx") && !var0.containsKey("dy") && !var0.containsKey("dz")) {
            if (var13 >= 0) {
               var19 = new aug((double)(var5.n() - var13), (double)(var5.o() - var13), (double)(var5.p() - var13), (double)(var5.n() + var13 + 1), (double)(var5.o() + var13 + 1), (double)(var5.p() + var13 + 1));
               if (var8 && var18 && !var9) {
                  var6.addAll(var4.b(var1, var15));
               } else {
                  var6.addAll(var4.a(var1, var19, var15));
               }
            } else if (var3.equals("a")) {
               var6.addAll(var4.b(var1, var14));
            } else if (var3.equals("p") || var3.equals("r") && !var9) {
               var6.addAll(var4.b(var1, var15));
            } else {
               var6.addAll(var4.a(var1, var15));
            }
         } else {
            var19 = a(var5, var10, var11, var12);
            if (var8 && var18 && !var9) {
               Predicate var20 = new Predicate<pk>(var19) {
                  final aug a;

                  {
                     this.a = var1;
                  }

                  public boolean apply(Object var1) {
                     return this.a((pk)var1);
                  }

                  public boolean a(pk var1) {
                     if (!(var1.s < this.a.a) && !(var1.t < this.a.b) && !(var1.u < this.a.c)) {
                        return !(var1.s >= this.a.d) && !(var1.t >= this.a.e) && !(var1.u >= this.a.f);
                     } else {
                        return false;
                     }
                  }
               };
               var6.addAll(var4.b(var1, Predicates.and(var15, var20)));
            } else {
               var6.addAll(var4.a(var1, var19, var15));
            }
         }
      } else if (var3.equals("a")) {
         var6.addAll(var4.b(var1, var14));
      } else if (!var3.equals("p") && (!var3.equals("r") || var9)) {
         var6.addAll(var4.a(var1, var15));
      } else {
         var6.addAll(var4.b(var1, var15));
      }

      return var6;
   }

   private static <T extends pk> List<T> a(List<T> var0, Map<String, String> var1, m var2, Class<? extends T> var3, String var4, cj var5) {
      int var6 = a(var1, "c", !var4.equals("a") && !var4.equals("e") ? 1 : 0);
      if (!var4.equals("p") && !var4.equals("a") && !var4.equals("e")) {
         if (var4.equals("r")) {
            Collections.shuffle((List)var0);
         }
      } else if (var5 != null) {
         Collections.sort((List)var0, new Comparator<pk>(var5) {
            final cj a;

            public int a(pk var1, pk var2) {
               return ComparisonChain.start().compare(var1.b(this.a), var2.b(this.a)).result();
            }

            public int compare(Object var1, Object var2) {
               return this.a((pk)var1, (pk)var2);
            }

            {
               this.a = var1;
            }
         });
      }

      pk var7 = var2.f();
      if (var7 != null && var3.isAssignableFrom(var7.getClass()) && var6 == 1 && ((List)var0).contains(var7) && !"r".equals(var4)) {
         var0 = Lists.newArrayList(new pk[]{var7});
      }

      if (var6 != 0) {
         if (var6 < 0) {
            Collections.reverse((List)var0);
         }

         var0 = ((List)var0).subList(0, Math.min(Math.abs(var6), ((List)var0).size()));
      }

      return (List)var0;
   }

   private static List<Predicate<pk>> e(Map<String, String> var0) {
      ArrayList var1 = Lists.newArrayList();
      Map var2 = a(var0);
      if (var2 != null && var2.size() > 0) {
         var1.add(new Predicate<pk>(var2) {
            final Map a;

            {
               this.a = var1;
            }

            public boolean a(pk var1) {
               auo var2 = MinecraftServer.N().a(0).Z();
               Iterator var3 = this.a.entrySet().iterator();

               Entry var4;
               boolean var6;
               int var10;
               do {
                  if (!var3.hasNext()) {
                     return true;
                  }

                  var4 = (Entry)var3.next();
                  String var5 = (String)var4.getKey();
                  var6 = false;
                  if (var5.endsWith("_min") && var5.length() > 4) {
                     var6 = true;
                     var5 = var5.substring(0, var5.length() - 4);
                  }

                  auk var7 = var2.b(var5);
                  if (var7 == null) {
                     return false;
                  }

                  String var8 = var1 instanceof lf ? var1.e_() : var1.aK().toString();
                  if (!var2.b(var8, var7)) {
                     return false;
                  }

                  aum var9 = var2.c(var8, var7);
                  var10 = var9.c();
                  if (var10 < (Integer)var4.getValue() && var6) {
                     return false;
                  }
               } while(var10 <= (Integer)var4.getValue() || var6);

               return false;
            }

            public boolean apply(Object var1) {
               return this.a((pk)var1);
            }
         });
      }

      return var1;
   }

   private static aug a(cj var0, int var1, int var2, int var3) {
      boolean var4 = var1 < 0;
      boolean var5 = var2 < 0;
      boolean var6 = var3 < 0;
      int var7 = var0.n() + (var4 ? var1 : 0);
      int var8 = var0.o() + (var5 ? var2 : 0);
      int var9 = var0.p() + (var6 ? var3 : 0);
      int var10 = var0.n() + (var4 ? 0 : var1) + 1;
      int var11 = var0.o() + (var5 ? 0 : var2) + 1;
      int var12 = var0.p() + (var6 ? 0 : var3) + 1;
      return new aug((double)var7, (double)var8, (double)var9, (double)var10, (double)var11, (double)var12);
   }

   private static List<Predicate<pk>> b(Map<String, String> var0) {
      ArrayList var1 = Lists.newArrayList();
      int var2 = a(var0, "lm", -1);
      int var3 = a(var0, "l", -1);
      if (var2 > -1 || var3 > -1) {
         var1.add(new Predicate<pk>(var2, var3) {
            final int a;
            final int b;

            public boolean apply(Object var1) {
               return this.a((pk)var1);
            }

            {
               this.a = var1;
               this.b = var2;
            }

            public boolean a(pk var1) {
               if (!(var1 instanceof lf)) {
                  return false;
               } else {
                  lf var2 = (lf)var1;
                  return (this.a <= -1 || var2.bB >= this.a) && (this.b <= -1 || var2.bB <= this.b);
               }
            }
         });
      }

      return var1;
   }

   public static Map<String, Integer> a(Map<String, String> var0) {
      HashMap var1 = Maps.newHashMap();
      Iterator var2 = var0.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         if (var3.startsWith("score_") && var3.length() > "score_".length()) {
            var1.put(var3.substring("score_".length()), ns.a((String)var0.get(var3), 1));
         }
      }

      return var1;
   }

   public static <T extends pk> List<T> b(m var0, String var1, Class<? extends T> var2) {
      Matcher var3 = a.matcher(var1);
      if (var3.matches() && var0.a(1, "@")) {
         Map var4 = c(var3.group(2));
         if (!b(var0, var4)) {
            return Collections.emptyList();
         } else {
            String var5 = var3.group(1);
            cj var6 = b(var4, var0.c());
            List var7 = a(var0, var4);
            ArrayList var8 = Lists.newArrayList();
            Iterator var9 = var7.iterator();

            while(var9.hasNext()) {
               adm var10 = (adm)var9.next();
               if (var10 != null) {
                  ArrayList var11 = Lists.newArrayList();
                  var11.addAll(a(var4, var5));
                  var11.addAll(b(var4));
                  var11.addAll(c(var4));
                  var11.addAll(d(var4));
                  var11.addAll(e(var4));
                  var11.addAll(f(var4));
                  var11.addAll(a(var4, var6));
                  var11.addAll(g(var4));
                  var8.addAll(a((Map)var4, (Class)var2, (List)var11, (String)var5, (adm)var10, var6));
               }
            }

            return a((List)var8, (Map)var4, (m)var0, (Class)var2, (String)var5, var6);
         }
      } else {
         return Collections.emptyList();
      }
   }

   public static eu b(m var0, String var1) {
      List var2 = b(var0, var1, pk.class);
      if (var2.isEmpty()) {
         return null;
      } else {
         ArrayList var3 = Lists.newArrayList();
         Iterator var4 = var2.iterator();

         while(var4.hasNext()) {
            pk var5 = (pk)var4.next();
            var3.add(var5.f_());
         }

         return i.a((List)var3);
      }
   }

   private static cj b(Map<String, String> var0, cj var1) {
      return new cj(a(var0, "x", var1.n()), a(var0, "y", var1.o()), a(var0, "z", var1.p()));
   }

   private static List<Predicate<pk>> c(Map<String, String> var0) {
      ArrayList var1 = Lists.newArrayList();
      int var2 = a(var0, "m", adp.a.a.a());
      if (var2 != adp.a.a.a()) {
         var1.add(new Predicate<pk>(var2) {
            final int a;

            public boolean a(pk var1) {
               if (!(var1 instanceof lf)) {
                  return false;
               } else {
                  lf var2 = (lf)var1;
                  return var2.c.b().a() == this.a;
               }
            }

            public boolean apply(Object var1) {
               return this.a((pk)var1);
            }

            {
               this.a = var1;
            }
         });
      }

      return var1;
   }
}
