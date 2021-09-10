import com.google.common.base.Predicates;
import java.util.List;

public class yj extends zw {
   public final int b;
   public final int c;
   public final int d;
   private static final int[] k = new int[]{11, 16, 15, 13};
   public static final String[] a = new String[]{"minecraft:items/empty_armor_slot_helmet", "minecraft:items/empty_armor_slot_chestplate", "minecraft:items/empty_armor_slot_leggings", "minecraft:items/empty_armor_slot_boots"};
   private static final cr l = new cn() {
      protected zx b(ck var1, zx var2) {
         cj var3 = var1.d().a(agg.b(var1.f()));
         int var4 = var3.n();
         int var5 = var3.o();
         int var6 = var3.p();
         aug var7 = new aug((double)var4, (double)var5, (double)var6, (double)(var4 + 1), (double)(var5 + 1), (double)(var6 + 1));
         List var8 = var1.i().a(pr.class, var7, Predicates.and(po.d, new po.a(var2)));
         if (var8.size() > 0) {
            pr var9 = (pr)var8.get(0);
            int var10 = var9 instanceof wn ? 1 : 0;
            int var11 = ps.c(var2);
            zx var12 = var2.k();
            var12.b = 1;
            var9.c(var11 - var10, var12);
            if (var9 instanceof ps) {
               ((ps)var9).a(var11, 2.0F);
            }

            --var2.b;
            return var2;
         } else {
            return super.b(var1, var2);
         }
      }
   };
   private final yj.a m;

   public boolean a(zx var1, zx var2) {
      return this.m.b() == var2.b() ? true : super.a(var1, var2);
   }

   public yj(yj.a var1, int var2, int var3) {
      this.m = var1;
      this.b = var3;
      this.d = var2;
      this.c = var1.b(var3);
      this.d(var1.a(var3));
      this.h = 1;
      this.a(yz.j);
      agg.N.a(this, l);
   }

   public int b(zx var1) {
      if (this.m != yj.a.a) {
         return -1;
      } else {
         dn var2 = var1.o();
         if (var2 != null) {
            dn var3 = var2.m("display");
            if (var3 != null && var3.b("color", 3)) {
               return var3.f("color");
            }
         }

         return 10511680;
      }
   }

   public yj.a x_() {
      return this.m;
   }

   public void b(zx var1, int var2) {
      if (this.m != yj.a.a) {
         throw new UnsupportedOperationException("Can't dye non-leather!");
      } else {
         dn var3 = var1.o();
         if (var3 == null) {
            var3 = new dn();
            var1.d(var3);
         }

         dn var4 = var3.m("display");
         if (!var3.b("display", 10)) {
            var3.a((String)"display", (eb)var4);
         }

         var4.a("color", var2);
      }
   }

   public boolean d_(zx var1) {
      if (this.m != yj.a.a) {
         return false;
      } else if (!var1.n()) {
         return false;
      } else if (!var1.o().b("display", 10)) {
         return false;
      } else {
         return var1.o().m("display").b("color", 3);
      }
   }

   public int b() {
      return this.m.a();
   }

   static int[] d() {
      return k;
   }

   public void c(zx var1) {
      if (this.m == yj.a.a) {
         dn var2 = var1.o();
         if (var2 != null) {
            dn var3 = var2.m("display");
            if (var3.c("color")) {
               var3.o("color");
            }

         }
      }
   }

   public int a(zx var1, int var2) {
      if (var2 > 0) {
         return 16777215;
      } else {
         int var3 = this.b(var1);
         if (var3 < 0) {
            var3 = 16777215;
         }

         return var3;
      }
   }

   public zx a(zx var1, adm var2, wn var3) {
      int var4 = ps.c(var1) - 1;
      zx var5 = var3.q(var4);
      if (var5 == null) {
         var3.c(var4, var1.k());
         var1.b = 0;
      }

      return var1;
   }

   public static enum a {
      d("gold", 7, new int[]{2, 5, 3, 1}, 25);

      private final int g;
      private final int[] h;
      private final int i;
      c("iron", 15, new int[]{2, 6, 5, 2}, 9),
      b("chainmail", 15, new int[]{2, 5, 4, 1}, 12);

      private final String f;
      a("leather", 5, new int[]{1, 3, 2, 1}, 15),
      e("diamond", 33, new int[]{3, 8, 6, 3}, 10);

      private static final yj.a[] j = new yj.a[]{a, b, c, d, e};

      public int a() {
         return this.i;
      }

      public String c() {
         return this.f;
      }

      public int b(int var1) {
         return this.h[var1];
      }

      public int a(int var1) {
         return yj.d()[var1] * this.g;
      }

      private a(String var3, int var4, int[] var5, int var6) {
         this.f = var3;
         this.g = var4;
         this.h = var5;
         this.i = var6;
      }

      public zw b() {
         if (this == a) {
            return zy.aF;
         } else if (this == b) {
            return zy.j;
         } else if (this == d) {
            return zy.k;
         } else if (this == c) {
            return zy.j;
         } else {
            return this == e ? zy.i : null;
         }
      }
   }
}
