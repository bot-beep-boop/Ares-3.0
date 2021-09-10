import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ack {
   private static final ack.e b = new ack.e();
   private static final Random a = new Random();
   private static final ack.b d = new ack.b();
   private static final ack.d c = new ack.d();
   private static final ack.a e = new ack.a();

   public static int a(int var0, zx[] var1) {
      if (var1 == null) {
         return 0;
      } else {
         int var2 = 0;
         zx[] var3 = var1;
         int var4 = var1.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            zx var6 = var3[var5];
            int var7 = a(var0, var6);
            if (var7 > var2) {
               var2 = var7;
            }
         }

         return var2;
      }
   }

   public static void a(pr var0, pk var1) {
      d.b = var1;
      d.a = var0;
      if (var0 != null) {
         a((ack.c)d, (zx[])var0.as());
      }

      if (var1 instanceof wn) {
         a((ack.c)d, (zx)var0.bA());
      }

   }

   private static void a(ack.c var0, zx var1) {
      if (var1 != null) {
         du var2 = var1.p();
         if (var2 != null) {
            for(int var3 = 0; var3 < var2.c(); ++var3) {
               short var4 = var2.b(var3).e("id");
               short var5 = var2.b(var3).e("lvl");
               if (aci.c(var4) != null) {
                  var0.a(aci.c(var4), var5);
               }
            }

         }
      }
   }

   public static int a(zx[] var0, ow var1) {
      b.a = 0;
      b.b = var1;
      a((ack.c)b, (zx[])var0);
      if (b.a > 25) {
         b.a = 25;
      } else if (b.a < 0) {
         b.a = 0;
      }

      return (b.a + 1 >> 1) + a.nextInt((b.a >> 1) + 1);
   }

   public static void b(pr var0, pk var1) {
      e.a = var0;
      e.b = var1;
      if (var0 != null) {
         a((ack.c)e, (zx[])var0.as());
      }

      if (var0 instanceof wn) {
         a((ack.c)e, (zx)var0.bA());
      }

   }

   public static float a(zx var0, pw var1) {
      c.a = 0.0F;
      c.b = var1;
      a((ack.c)c, (zx)var0);
      return c.a;
   }

   public static int i(pr var0) {
      return a(aci.q.B, var0.bA());
   }

   public static int c(pr var0) {
      return a(aci.r.B, var0.bA());
   }

   public static int h(pr var0) {
      return a(aci.A.B, var0.bA());
   }

   public static int b(pk var0) {
      return a(aci.k.B, var0.as());
   }

   public static int a(Random var0, int var1, int var2, zx var3) {
      zw var4 = var3.b();
      int var5 = var4.b();
      if (var5 <= 0) {
         return 0;
      } else {
         if (var2 > 15) {
            var2 = 15;
         }

         int var6 = var0.nextInt(8) + 1 + (var2 >> 1) + var0.nextInt(var2 + 1);
         if (var1 == 0) {
            return Math.max(var6 / 3, 1);
         } else {
            return var1 == 1 ? var6 * 2 / 3 + 1 : Math.max(var6, var2 * 2);
         }
      }
   }

   public static boolean j(pr var0) {
      return a(aci.i.B, var0.as()) > 0;
   }

   public static int a(pr var0) {
      return a(aci.o.B, var0.bA());
   }

   public static boolean e(pr var0) {
      return a(aci.s.B, var0.bA()) > 0;
   }

   public static List<acl> b(Random var0, zx var1, int var2) {
      zw var3 = var1.b();
      int var4 = var3.b();
      if (var4 <= 0) {
         return null;
      } else {
         var4 /= 2;
         var4 = 1 + var0.nextInt((var4 >> 1) + 1) + var0.nextInt((var4 >> 1) + 1);
         int var5 = var4 + var2;
         float var6 = (var0.nextFloat() + var0.nextFloat() - 1.0F) * 0.15F;
         int var7 = (int)((float)var5 * (1.0F + var6) + 0.5F);
         if (var7 < 1) {
            var7 = 1;
         }

         ArrayList var8 = null;
         Map var9 = b(var7, var1);
         if (var9 != null && !var9.isEmpty()) {
            acl var10 = (acl)oa.a(var0, var9.values());
            if (var10 != null) {
               var8 = Lists.newArrayList();
               var8.add(var10);

               for(int var11 = var7; var0.nextInt(50) <= var11; var11 >>= 1) {
                  Iterator var12 = var9.keySet().iterator();

                  while(var12.hasNext()) {
                     Integer var13 = (Integer)var12.next();
                     boolean var14 = true;
                     Iterator var15 = var8.iterator();

                     while(var15.hasNext()) {
                        acl var16 = (acl)var15.next();
                        if (!var16.b.a(aci.c(var13))) {
                           var14 = false;
                           break;
                        }
                     }

                     if (!var14) {
                        var12.remove();
                     }
                  }

                  if (!var9.isEmpty()) {
                     acl var17 = (acl)oa.a(var0, var9.values());
                     var8.add(var17);
                  }
               }
            }
         }

         return var8;
      }
   }

   public static Map<Integer, Integer> a(zx var0) {
      LinkedHashMap var1 = Maps.newLinkedHashMap();
      du var2 = var0.b() == zy.cd ? zy.cd.h(var0) : var0.p();
      if (var2 != null) {
         for(int var3 = 0; var3 < var2.c(); ++var3) {
            short var4 = var2.b(var3).e("id");
            short var5 = var2.b(var3).e("lvl");
            var1.put(Integer.valueOf(var4), Integer.valueOf(var5));
         }
      }

      return var1;
   }

   public static void a(Map<Integer, Integer> var0, zx var1) {
      du var2 = new du();
      Iterator var3 = var0.keySet().iterator();

      while(var3.hasNext()) {
         int var4 = (Integer)var3.next();
         aci var5 = aci.c(var4);
         if (var5 != null) {
            dn var6 = new dn();
            var6.a("id", (short)var4);
            var6.a("lvl", (short)(Integer)var0.get(var4));
            var2.a((eb)var6);
            if (var1.b() == zy.cd) {
               zy.cd.a(var1, new acl(var5, (Integer)var0.get(var4)));
            }
         }
      }

      if (var2.c() > 0) {
         if (var1.b() != zy.cd) {
            var1.a((String)"ench", (eb)var2);
         }
      } else if (var1.n()) {
         var1.o().o("ench");
      }

   }

   public static int g(pr var0) {
      return a(aci.z.B, var0.bA());
   }

   public static zx a(aci var0, pr var1) {
      zx[] var2 = var1.as();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         zx var5 = var2[var4];
         if (var5 != null && a(var0.B, var5) > 0) {
            return var5;
         }
      }

      return null;
   }

   public static zx a(Random var0, zx var1, int var2) {
      List var3 = b(var0, var1, var2);
      boolean var4 = var1.b() == zy.aL;
      if (var4) {
         var1.a((zw)zy.cd);
      }

      if (var3 != null) {
         Iterator var5 = var3.iterator();

         while(var5.hasNext()) {
            acl var6 = (acl)var5.next();
            if (var4) {
               zy.cd.a(var1, var6);
            } else {
               var1.a(var6.b, var6.c);
            }
         }
      }

      return var1;
   }

   public static int a(int var0, zx var1) {
      if (var1 == null) {
         return 0;
      } else {
         du var2 = var1.p();
         if (var2 == null) {
            return 0;
         } else {
            for(int var3 = 0; var3 < var2.c(); ++var3) {
               short var4 = var2.b(var3).e("id");
               short var5 = var2.b(var3).e("lvl");
               if (var4 == var0) {
                  return var5;
               }
            }

            return 0;
         }
      }
   }

   public static int f(pr var0) {
      return a(aci.u.B, var0.bA());
   }

   private static void a(ack.c var0, zx[] var1) {
      zx[] var2 = var1;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         zx var5 = var2[var4];
         a(var0, var5);
      }

   }

   public static int b(pr var0) {
      return a(aci.p.B, var0.bA());
   }

   public static int a(pk var0) {
      return a(aci.h.B, var0.as());
   }

   public static Map<Integer, acl> b(int var0, zx var1) {
      zw var2 = var1.b();
      HashMap var3 = null;
      boolean var4 = var1.b() == zy.aL;
      aci[] var5 = aci.b;
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         aci var8 = var5[var7];
         if (var8 != null && (var8.C.a(var2) || var4)) {
            for(int var9 = var8.e(); var9 <= var8.b(); ++var9) {
               if (var0 >= var8.a(var9) && var0 <= var8.b(var9)) {
                  if (var3 == null) {
                     var3 = Maps.newHashMap();
                  }

                  var3.put(var8.B, new acl(var8, var9));
               }
            }
         }
      }

      return var3;
   }

   interface c {
      void a(aci var1, int var2);
   }

   static final class a implements ack.c {
      public pk b;
      public pr a;

      public void a(aci var1, int var2) {
         var1.a(this.a, this.b, var2);
      }

      a(Object var1) {
         this();
      }

      private a() {
      }
   }

   static final class b implements ack.c {
      public pk b;
      public pr a;

      b(Object var1) {
         this();
      }

      public void a(aci var1, int var2) {
         var1.b(this.a, this.b, var2);
      }

      private b() {
      }
   }

   static final class d implements ack.c {
      public pw b;
      public float a;

      public void a(aci var1, int var2) {
         this.a += var1.a(var2, this.b);
      }

      private d() {
      }

      d(Object var1) {
         this();
      }
   }

   static final class e implements ack.c {
      public ow b;
      public int a;

      public void a(aci var1, int var2) {
         this.a += var1.a(var2, this.b);
      }

      private e() {
      }

      e(Object var1) {
         this();
      }
   }
}
