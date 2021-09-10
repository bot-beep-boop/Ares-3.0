import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.lwjgl.util.vector.Vector3f;

public class bgp {
   public static final List<String> a = Lists.newArrayList(new String[]{"layer0", "layer1", "layer2", "layer3", "layer4"});

   private List<bgh> a(int var1, String var2, bmi var3) {
      HashMap var4 = Maps.newHashMap();
      var4.put(cq.d, new bgi((cq)null, var1, var2, new bgk(new float[]{0.0F, 0.0F, 16.0F, 16.0F}, 0)));
      var4.put(cq.c, new bgi((cq)null, var1, var2, new bgk(new float[]{16.0F, 0.0F, 0.0F, 16.0F}, 0)));
      ArrayList var5 = Lists.newArrayList();
      var5.add(new bgh(new Vector3f(0.0F, 0.0F, 7.5F), new Vector3f(16.0F, 16.0F, 8.5F), var4, (bgj)null, true));
      var5.addAll(this.a(var3, var2, var1));
      return var5;
   }

   private void a(bgp.b var1, List<bgp.a> var2, int[] var3, int var4, int var5, int var6, int var7, boolean var8) {
      boolean var9 = this.a(var3, var4 + var1.b(), var5 + var1.c(), var6, var7) && var8;
      if (var9) {
         this.a(var2, var1, var4, var5);
      }

   }

   private List<bgh> a(bmi var1, String var2, int var3) {
      float var4 = (float)var1.c();
      float var5 = (float)var1.d();
      ArrayList var6 = Lists.newArrayList();
      Iterator var7 = this.a(var1).iterator();

      while(var7.hasNext()) {
         bgp.a var8 = (bgp.a)var7.next();
         float var9 = 0.0F;
         float var10 = 0.0F;
         float var11 = 0.0F;
         float var12 = 0.0F;
         float var13 = 0.0F;
         float var14 = 0.0F;
         float var15 = 0.0F;
         float var16 = 0.0F;
         float var17 = 0.0F;
         float var18 = 0.0F;
         float var19 = (float)var8.b();
         float var20 = (float)var8.c();
         float var21 = (float)var8.d();
         bgp.b var22 = var8.a();
         switch(var22) {
         case a:
            var13 = var19;
            var9 = var19;
            var11 = var14 = var20 + 1.0F;
            var15 = var21;
            var10 = var21;
            var16 = var21;
            var12 = var21;
            var17 = 16.0F / var4;
            var18 = 16.0F / (var5 - 1.0F);
            break;
         case b:
            var16 = var21;
            var15 = var21;
            var13 = var19;
            var9 = var19;
            var11 = var14 = var20 + 1.0F;
            var10 = var21 + 1.0F;
            var12 = var21 + 1.0F;
            var17 = 16.0F / var4;
            var18 = 16.0F / (var5 - 1.0F);
            break;
         case c:
            var13 = var21;
            var9 = var21;
            var14 = var21;
            var11 = var21;
            var16 = var19;
            var10 = var19;
            var12 = var15 = var20 + 1.0F;
            var17 = 16.0F / (var4 - 1.0F);
            var18 = 16.0F / var5;
            break;
         case d:
            var14 = var21;
            var13 = var21;
            var9 = var21 + 1.0F;
            var11 = var21 + 1.0F;
            var16 = var19;
            var10 = var19;
            var12 = var15 = var20 + 1.0F;
            var17 = 16.0F / (var4 - 1.0F);
            var18 = 16.0F / var5;
         }

         float var23 = 16.0F / var4;
         float var24 = 16.0F / var5;
         var9 *= var23;
         var11 *= var23;
         var10 *= var24;
         var12 *= var24;
         var10 = 16.0F - var10;
         var12 = 16.0F - var12;
         var13 *= var17;
         var14 *= var17;
         var15 *= var18;
         var16 *= var18;
         HashMap var25 = Maps.newHashMap();
         var25.put(var22.a(), new bgi((cq)null, var3, var2, new bgk(new float[]{var13, var15, var14, var16}, 0)));
         switch(var22) {
         case a:
            var6.add(new bgh(new Vector3f(var9, var10, 7.5F), new Vector3f(var11, var10, 8.5F), var25, (bgj)null, true));
            break;
         case b:
            var6.add(new bgh(new Vector3f(var9, var12, 7.5F), new Vector3f(var11, var12, 8.5F), var25, (bgj)null, true));
            break;
         case c:
            var6.add(new bgh(new Vector3f(var9, var10, 7.5F), new Vector3f(var9, var12, 8.5F), var25, (bgj)null, true));
            break;
         case d:
            var6.add(new bgh(new Vector3f(var11, var10, 7.5F), new Vector3f(var11, var12, 8.5F), var25, (bgj)null, true));
         }
      }

      return var6;
   }

   private boolean a(int[] var1, int var2, int var3, int var4, int var5) {
      if (var2 >= 0 && var3 >= 0 && var2 < var4 && var3 < var5) {
         return (var1[var3 * var4 + var2] >> 24 & 255) == 0;
      } else {
         return true;
      }
   }

   public bgl a(bmh var1, bgl var2) {
      HashMap var3 = Maps.newHashMap();
      ArrayList var4 = Lists.newArrayList();

      for(int var5 = 0; var5 < a.size(); ++var5) {
         String var6 = (String)a.get(var5);
         if (!var2.b(var6)) {
            break;
         }

         String var7 = var2.c(var6);
         var3.put(var6, var7);
         bmi var8 = var1.a((new jy(var7)).toString());
         var4.addAll(this.a(var5, var6, var8));
      }

      if (var4.isEmpty()) {
         return null;
      } else {
         var3.put("particle", var2.b("particle") ? var2.c("particle") : (String)var3.get("layer0"));
         return new bgl(var4, var3, false, false, var2.g());
      }
   }

   private void a(List<bgp.a> var1, bgp.b var2, int var3, int var4) {
      bgp.a var5 = null;
      Iterator var6 = var1.iterator();

      while(var6.hasNext()) {
         bgp.a var7 = (bgp.a)var6.next();
         if (var7.a() == var2) {
            int var8 = bgp.b.a(var2) ? var4 : var3;
            if (var7.d() == var8) {
               var5 = var7;
               break;
            }
         }
      }

      int var9 = bgp.b.a(var2) ? var4 : var3;
      int var10 = bgp.b.a(var2) ? var3 : var4;
      if (var5 == null) {
         var1.add(new bgp.a(var2, var10, var9));
      } else {
         var5.a(var10);
      }

   }

   private List<bgp.a> a(bmi var1) {
      int var2 = var1.c();
      int var3 = var1.d();
      ArrayList var4 = Lists.newArrayList();

      for(int var5 = 0; var5 < var1.k(); ++var5) {
         int[] var6 = var1.a(var5)[0];

         for(int var7 = 0; var7 < var3; ++var7) {
            for(int var8 = 0; var8 < var2; ++var8) {
               boolean var9 = !this.a(var6, var8, var7, var2, var3);
               this.a(bgp.b.a, var4, var6, var8, var7, var2, var3, var9);
               this.a(bgp.b.b, var4, var6, var8, var7, var2, var3, var9);
               this.a(bgp.b.c, var4, var6, var8, var7, var2, var3, var9);
               this.a(bgp.b.d, var4, var6, var8, var7, var2, var3, var9);
            }
         }
      }

      return var4;
   }

   static enum b {
      a(cq.b, 0, -1);

      private final int g;
      private final cq e;
      d(cq.e, 1, 0),
      b(cq.a, 0, 1),
      c(cq.f, -1, 0);

      private static final bgp.b[] h = new bgp.b[]{a, b, c, d};
      private final int f;

      private b(cq var3, int var4, int var5) {
         this.e = var3;
         this.f = var4;
         this.g = var5;
      }

      private boolean d() {
         return this == b || this == a;
      }

      public int c() {
         return this.g;
      }

      static boolean a(bgp.b var0) {
         return var0.d();
      }

      public cq a() {
         return this.e;
      }

      public int b() {
         return this.f;
      }
   }

   static class a {
      private final int d;
      private final bgp.b a;
      private int b;
      private int c;

      public bgp.b a() {
         return this.a;
      }

      public void a(int var1) {
         if (var1 < this.b) {
            this.b = var1;
         } else if (var1 > this.c) {
            this.c = var1;
         }

      }

      public a(bgp.b var1, int var2, int var3) {
         this.a = var1;
         this.b = var2;
         this.c = var2;
         this.d = var3;
      }

      public int b() {
         return this.b;
      }

      public int c() {
         return this.c;
      }

      public int d() {
         return this.d;
      }
   }
}
