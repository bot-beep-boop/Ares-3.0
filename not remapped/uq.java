import com.google.common.collect.Lists;
import java.util.ArrayList;

public class uq extends un {
   public uq.a c;

   public void b(pk var1) {
      if (this.o.Q().b("doEntityDrops")) {
         if (var1 instanceof wn) {
            wn var2 = (wn)var1;
            if (var2.bA.d) {
               return;
            }
         }

         this.a(new zx(zy.an), 0.0F);
      }
   }

   public void b(double var1, double var3, double var5, float var7, float var8) {
      cj var9 = this.a.a(var1 - this.s, var3 - this.t, var5 - this.u);
      this.b((double)var9.n(), (double)var9.o(), (double)var9.p());
   }

   public uq(adm var1, cj var2, cq var3, String var4) {
      this(var1, var2, var3);
      uq.a[] var5 = uq.a.values();
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         uq.a var8 = var5[var7];
         if (var8.B.equals(var4)) {
            this.c = var8;
            break;
         }
      }

      this.a(var3);
   }

   public void b(dn var1) {
      var1.a("Motive", this.c.B);
      super.b(var1);
   }

   public uq(adm var1, cj var2, cq var3) {
      super(var1, var2);
      ArrayList var4 = Lists.newArrayList();
      uq.a[] var5 = uq.a.values();
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         uq.a var8 = var5[var7];
         this.c = var8;
         this.a(var3);
         if (this.j()) {
            var4.add(var8);
         }
      }

      if (!var4.isEmpty()) {
         this.c = (uq.a)var4.get(this.V.nextInt(var4.size()));
      }

      this.a(var3);
   }

   public int m() {
      return this.c.D;
   }

   public void a(double var1, double var3, double var5, float var7, float var8, int var9, boolean var10) {
      cj var11 = this.a.a(var1 - this.s, var3 - this.t, var5 - this.u);
      this.b((double)var11.n(), (double)var11.o(), (double)var11.p());
   }

   public int l() {
      return this.c.C;
   }

   public void a(dn var1) {
      String var2 = var1.j("Motive");
      uq.a[] var3 = uq.a.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         uq.a var6 = var3[var5];
         if (var6.B.equals(var2)) {
            this.c = var6;
         }
      }

      if (this.c == null) {
         this.c = uq.a.a;
      }

      super.a(var1);
   }

   public uq(adm var1) {
      super(var1);
   }

   public static enum a {
      e("Bomb", 16, 16, 64, 0),
      p("Bust", 32, 32, 32, 128),
      s("SkullAndRoses", 32, 32, 128, 128),
      z("DonkeyKong", 64, 48, 192, 112);

      private static final uq.a[] G = new uq.a[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z};
      k("Sunset", 32, 16, 96, 32),
      h("Pool", 32, 16, 0, 32);

      public final int D;
      public final int E;
      b("Aztec", 16, 16, 16, 0);

      public final String B;
      f("Plant", 16, 16, 80, 0),
      m("Wanderer", 16, 32, 0, 64),
      d("Aztec2", 16, 16, 48, 0),
      u("Fighters", 64, 32, 0, 96),
      n("Graham", 16, 32, 16, 64),
      i("Courbet", 32, 16, 32, 32),
      t("Wither", 32, 32, 160, 128),
      x("BurningSkull", 64, 64, 128, 192),
      l("Creebet", 32, 16, 128, 32),
      o("Match", 32, 32, 0, 128),
      j("Sea", 32, 16, 64, 32),
      q("Stage", 32, 32, 64, 128),
      c("Alban", 16, 16, 32, 0);

      public final int F;
      public static final int A = "SkullAndRoses".length();
      a("Kebab", 16, 16, 0, 0),
      v("Pointer", 64, 64, 0, 192),
      y("Skeleton", 64, 48, 192, 64),
      r("Void", 32, 32, 96, 128),
      g("Wasteland", 16, 16, 96, 0),
      w("Pigscene", 64, 64, 64, 192);

      public final int C;

      private a(String var3, int var4, int var5, int var6, int var7) {
         this.B = var3;
         this.C = var4;
         this.D = var5;
         this.E = var6;
         this.F = var7;
      }
   }
}
