import com.google.common.base.Functions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.primitives.Doubles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;

public abstract class i implements k {
   private static h a;

   public static cj a(m var0, String[] var1, int var2, boolean var3) throws cb {
      cj var4 = var0.c();
      return new cj(b((double)var4.n(), var1[var2], -30000000, 30000000, var3), b((double)var4.o(), var1[var2 + 1], 0, 256, false), b((double)var4.p(), var1[var2 + 2], -30000000, 30000000, var3));
   }

   public static void a(h var0) {
      a = var0;
   }

   public static String a(Collection<String> var0) {
      return a(var0.toArray(new String[var0.size()]));
   }

   public static eu b(m var0, String[] var1, int var2, boolean var3) throws cd {
      fa var4 = new fa("");

      for(int var5 = var2; var5 < var1.length; ++var5) {
         if (var5 > var2) {
            var4.a(" ");
         }

         Object var6 = new fa(var1[var5]);
         if (var3) {
            eu var7 = o.b(var0, var1[var5]);
            if (var7 == null) {
               if (o.b(var1[var5])) {
                  throw new cd();
               }
            } else {
               var6 = var7;
            }
         }

         var4.a((eu)var6);
      }

      return var4;
   }

   public static List<String> a(String[] var0, String... var1) {
      return a((String[])var0, (Collection)Arrays.asList(var1));
   }

   public static double a(String var0, double var1) throws cb {
      return a(var0, var1, Double.MAX_VALUE);
   }

   public int a(k var1) {
      return this.c().compareTo(var1.c());
   }

   public static pk b(m var0, String var1) throws ca {
      return a(var0, var1, pk.class);
   }

   public static int a(String var0, int var1, int var2) throws cb {
      int var3 = a(var0);
      if (var3 < var1) {
         throw new cb("commands.generic.num.tooSmall", new Object[]{var3, var1});
      } else if (var3 > var2) {
         throw new cb("commands.generic.num.tooBig", new Object[]{var3, var2});
      } else {
         return var3;
      }
   }

   public static eu a(List<eu> var0) {
      fa var1 = new fa("");

      for(int var2 = 0; var2 < var0.size(); ++var2) {
         if (var2 > 0) {
            if (var2 == var0.size() - 1) {
               var1.a(" and ");
            } else if (var2 > 0) {
               var1.a(", ");
            }
         }

         var1.a((eu)var0.get(var2));
      }

      return var1;
   }

   public static List<String> a(String[] var0, int var1, cj var2) {
      if (var2 == null) {
         return null;
      } else {
         int var4 = var0.length - 1;
         String var3;
         if (var4 == var1) {
            var3 = Integer.toString(var2.n());
         } else if (var4 == var1 + 1) {
            var3 = Integer.toString(var2.o());
         } else {
            if (var4 != var1 + 2) {
               return null;
            }

            var3 = Integer.toString(var2.p());
         }

         return Lists.newArrayList(new String[]{var3});
      }
   }

   public static double b(double var0, String var2, int var3, int var4, boolean var5) throws cb {
      boolean var6 = var2.startsWith("~");
      if (var6 && Double.isNaN(var0)) {
         throw new cb("commands.generic.num.invalid", new Object[]{var0});
      } else {
         double var7 = var6 ? var0 : 0.0D;
         if (!var6 || var2.length() > 1) {
            boolean var9 = var2.contains(".");
            if (var6) {
               var2 = var2.substring(1);
            }

            var7 += c(var2);
            if (!var9 && !var6 && var5) {
               var7 += 0.5D;
            }
         }

         if (var3 != 0 || var4 != 0) {
            if (var7 < (double)var3) {
               throw new cb("commands.generic.double.tooSmall", new Object[]{var7, var3});
            }

            if (var7 > (double)var4) {
               throw new cb("commands.generic.double.tooBig", new Object[]{var7, var4});
            }
         }

         return var7;
      }
   }

   public static List<String> b(String[] var0, int var1, cj var2) {
      if (var2 == null) {
         return null;
      } else {
         int var4 = var0.length - 1;
         String var3;
         if (var4 == var1) {
            var3 = Integer.toString(var2.n());
         } else {
            if (var4 != var1 + 1) {
               return null;
            }

            var3 = Integer.toString(var2.p());
         }

         return Lists.newArrayList(new String[]{var3});
      }
   }

   public int compareTo(Object var1) {
      return this.a((k)var1);
   }

   public static int a(String var0) throws cb {
      try {
         return Integer.parseInt(var0);
      } catch (NumberFormatException var2) {
         throw new cb("commands.generic.num.invalid", new Object[]{var0});
      }
   }

   public static double c(String var0) throws cb {
      try {
         double var1 = Double.parseDouble(var0);
         if (!Doubles.isFinite(var1)) {
            throw new cb("commands.generic.num.invalid", new Object[]{var0});
         } else {
            return var1;
         }
      } catch (NumberFormatException var3) {
         throw new cb("commands.generic.num.invalid", new Object[]{var0});
      }
   }

   public static String a(String[] var0, int var1) {
      StringBuilder var2 = new StringBuilder();

      for(int var3 = var1; var3 < var0.length; ++var3) {
         if (var3 > var1) {
            var2.append(" ");
         }

         String var4 = var0[var3];
         var2.append(var4);
      }

      return var2.toString();
   }

   public static lf a(m var0, String var1) throws cd {
      lf var2 = o.a(var0, var1);
      if (var2 == null) {
         try {
            var2 = MinecraftServer.N().ap().a(UUID.fromString(var1));
         } catch (IllegalArgumentException var4) {
         }
      }

      if (var2 == null) {
         var2 = MinecraftServer.N().ap().a(var1);
      }

      if (var2 == null) {
         throw new cd();
      } else {
         return var2;
      }
   }

   public static int a(String var0, int var1) throws cb {
      return a(var0, var1, Integer.MAX_VALUE);
   }

   public static afh g(m var0, String var1) throws cb {
      jy var2 = new jy(var1);
      if (!afh.c.d(var2)) {
         throw new cb("commands.give.block.notFound", new Object[]{var2});
      } else {
         afh var3 = (afh)afh.c.a(var2);
         if (var3 == null) {
            throw new cb("commands.give.block.notFound", new Object[]{var2});
         } else {
            return var3;
         }
      }
   }

   public static <T extends pk> T a(m var0, String var1, Class<? extends T> var2) throws ca {
      Object var3 = o.a(var0, var1, var2);
      MinecraftServer var4 = MinecraftServer.N();
      if (var3 == null) {
         var3 = var4.ap().a(var1);
      }

      if (var3 == null) {
         try {
            UUID var5 = UUID.fromString(var1);
            var3 = var4.a(var5);
            if (var3 == null) {
               var3 = var4.ap().a(var5);
            }
         } catch (IllegalArgumentException var6) {
            throw new ca("commands.generic.entity.invalidUuid", new Object[0]);
         }
      }

      if (var3 != null && var2.isAssignableFrom(var3.getClass())) {
         return (pk)var3;
      } else {
         throw new ca();
      }
   }

   public static boolean a(String var0, String var1) {
      return var1.regionMatches(true, 0, var0, 0, var0.length());
   }

   public static String e(m var0, String var1) throws ca {
      try {
         return a(var0, var1).e_();
      } catch (cd var5) {
         try {
            return b(var0, var1).aK().toString();
         } catch (ca var4) {
            if (o.b(var1)) {
               throw var4;
            } else {
               return var1;
            }
         }
      }
   }

   public static i.a a(double var0, String var2, boolean var3) throws cb {
      return a(var0, var2, -30000000, 30000000, var3);
   }

   public boolean b(String[] var1, int var2) {
      return false;
   }

   public static lf b(m var0) throws cd {
      if (var0 instanceof lf) {
         return (lf)var0;
      } else {
         throw new cd("You must specify which player you wish to perform this action on.", new Object[0]);
      }
   }

   public static i.a a(double var0, String var2, int var3, int var4, boolean var5) throws cb {
      boolean var6 = var2.startsWith("~");
      if (var6 && Double.isNaN(var0)) {
         throw new cb("commands.generic.num.invalid", new Object[]{var0});
      } else {
         double var7 = 0.0D;
         if (!var6 || var2.length() > 1) {
            boolean var9 = var2.contains(".");
            if (var6) {
               var2 = var2.substring(1);
            }

            var7 += c(var2);
            if (!var9 && !var6 && var5) {
               var7 += 0.5D;
            }
         }

         if (var3 != 0 || var4 != 0) {
            if (var7 < (double)var3) {
               throw new cb("commands.generic.double.tooSmall", new Object[]{var7, var3});
            }

            if (var7 > (double)var4) {
               throw new cb("commands.generic.double.tooBig", new Object[]{var7, var4});
            }
         }

         return new i.a(var7 + (var6 ? var0 : 0.0D), var7, var6);
      }
   }

   public static long b(String var0) throws cb {
      try {
         return Long.parseLong(var0);
      } catch (NumberFormatException var2) {
         throw new cb("commands.generic.num.invalid", new Object[]{var0});
      }
   }

   public static String d(m var0, String var1) throws cd {
      try {
         return a(var0, var1).e_();
      } catch (cd var3) {
         if (o.b(var1)) {
            throw var3;
         } else {
            return var1;
         }
      }
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      return null;
   }

   public static long a(String var0, long var1, long var3) throws cb {
      long var5 = b(var0);
      if (var5 < var1) {
         throw new cb("commands.generic.num.tooSmall", new Object[]{var5, var1});
      } else if (var5 > var3) {
         throw new cb("commands.generic.num.tooBig", new Object[]{var5, var3});
      } else {
         return var5;
      }
   }

   public boolean a(m var1) {
      return var1.a(this.a(), this.c());
   }

   public static void a(m var0, k var1, String var2, Object... var3) {
      a(var0, var1, 0, var2, var3);
   }

   public static zw f(m var0, String var1) throws cb {
      jy var2 = new jy(var1);
      zw var3 = (zw)zw.e.a(var2);
      if (var3 == null) {
         throw new cb("commands.give.item.notFound", new Object[]{var2});
      } else {
         return var3;
      }
   }

   public static eu a(m var0, String[] var1, int var2) throws cd {
      return b(var0, var1, var2, false);
   }

   public static List<String> a(String[] var0, Collection<?> var1) {
      String var2 = var0[var0.length - 1];
      ArrayList var3 = Lists.newArrayList();
      if (!var1.isEmpty()) {
         Iterator var4 = Iterables.transform(var1, Functions.toStringFunction()).iterator();

         while(var4.hasNext()) {
            String var5 = (String)var4.next();
            if (a(var2, var5)) {
               var3.add(var5);
            }
         }

         if (var3.isEmpty()) {
            var4 = var1.iterator();

            while(var4.hasNext()) {
               Object var6 = var4.next();
               if (var6 instanceof jy && a(var2, ((jy)var6).a())) {
                  var3.add(String.valueOf(var6));
               }
            }
         }
      }

      return var3;
   }

   public static void a(m var0, k var1, int var2, String var3, Object... var4) {
      if (a != null) {
         a.a(var0, var1, var2, var3, var4);
      }

   }

   public List<String> b() {
      return Collections.emptyList();
   }

   public static String a(Object[] var0) {
      StringBuilder var1 = new StringBuilder();

      for(int var2 = 0; var2 < var0.length; ++var2) {
         String var3 = var0[var2].toString();
         if (var2 > 0) {
            if (var2 == var0.length - 1) {
               var1.append(" and ");
            } else {
               var1.append(", ");
            }
         }

         var1.append(var3);
      }

      return var1.toString();
   }

   public static boolean d(String var0) throws bz {
      if (!var0.equals("true") && !var0.equals("1")) {
         if (!var0.equals("false") && !var0.equals("0")) {
            throw new bz("commands.generic.boolean.invalid", new Object[]{var0});
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   public int a() {
      return 4;
   }

   public static double a(String var0, double var1, double var3) throws cb {
      double var5 = c(var0);
      if (var5 < var1) {
         throw new cb("commands.generic.double.tooSmall", new Object[]{var5, var1});
      } else if (var5 > var3) {
         throw new cb("commands.generic.double.tooBig", new Object[]{var5, var3});
      } else {
         return var5;
      }
   }

   public static List<pk> c(m var0, String var1) throws ca {
      return (List)(o.b(var1) ? o.b(var0, var1, pk.class) : Lists.newArrayList(new pk[]{b(var0, var1)}));
   }

   public static double b(double var0, String var2, boolean var3) throws cb {
      return b(var0, var2, -30000000, 30000000, var3);
   }

   public static class a {
      private final boolean c;
      private final double a;
      private final double b;

      public double b() {
         return this.b;
      }

      public double a() {
         return this.a;
      }

      protected a(double var1, double var3, boolean var5) {
         this.a = var1;
         this.b = var3;
         this.c = var5;
      }

      public boolean c() {
         return this.c;
      }
   }
}
