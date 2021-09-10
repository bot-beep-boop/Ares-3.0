import com.google.common.collect.Lists;
import java.util.List;

public class aku extends akw {
   private String j;
   private int a;
   private du f;
   private List<aku.a> h;
   private List<zd> i;
   private boolean g;

   public ff y_() {
      dn var1 = new dn();
      this.b(var1);
      return new ft(this.c, 6, var1);
   }

   public void a(dn var1) {
      super.a(var1);
      this.a = var1.f("Base");
      this.f = var1.c("Patterns", 10);
      this.h = null;
      this.i = null;
      this.j = null;
      this.g = true;
   }

   public static void e(zx var0) {
      dn var1 = var0.a("BlockEntityTag", false);
      if (var1 != null && var1.b("Patterns", 9)) {
         du var2 = var1.c("Patterns", 10);
         if (var2.c() > 0) {
            var2.a(var2.c() - 1);
            if (var2.c_()) {
               var0.o().o("BlockEntityTag");
               if (var0.o().c_()) {
                  var0.d((dn)null);
               }
            }

         }
      }
   }

   public static void a(dn var0, int var1, du var2) {
      var0.a("Base", var1);
      if (var2 != null) {
         var0.a((String)"Patterns", (eb)var2);
      }

   }

   public int b() {
      return this.a;
   }

   public void a(zx var1) {
      this.f = null;
      if (var1.n() && var1.o().b("BlockEntityTag", 10)) {
         dn var2 = var1.o().m("BlockEntityTag");
         if (var2.c("Patterns")) {
            this.f = (du)var2.c("Patterns", 10).b();
         }

         if (var2.b("Base", 99)) {
            this.a = var2.f("Base");
         } else {
            this.a = var1.i() & 15;
         }
      } else {
         this.a = var1.i() & 15;
      }

      this.h = null;
      this.i = null;
      this.j = "";
      this.g = true;
   }

   public static int b(zx var0) {
      dn var1 = var0.a("BlockEntityTag", false);
      return var1 != null && var1.c("Base") ? var1.f("Base") : var0.i();
   }

   public du d() {
      return this.f;
   }

   public List<aku.a> c() {
      this.h();
      return this.h;
   }

   public static int c(zx var0) {
      dn var1 = var0.a("BlockEntityTag", false);
      return var1 != null && var1.c("Patterns") ? var1.c("Patterns", 10).c() : 0;
   }

   private void h() {
      if (this.h == null || this.i == null || this.j == null) {
         if (!this.g) {
            this.j = "";
         } else {
            this.h = Lists.newArrayList();
            this.i = Lists.newArrayList();
            this.h.add(aku.a.a);
            this.i.add(zd.a(this.a));
            this.j = "b" + this.a;
            if (this.f != null) {
               for(int var1 = 0; var1 < this.f.c(); ++var1) {
                  dn var2 = this.f.b(var1);
                  aku.a var3 = aku.a.a(var2.j("Pattern"));
                  if (var3 != null) {
                     this.h.add(var3);
                     int var4 = var2.f("Color");
                     this.i.add(zd.a(var4));
                     this.j = this.j + var3.b() + var4;
                  }
               }
            }

         }
      }
   }

   public void b(dn var1) {
      super.b(var1);
      a(var1, this.a, this.f);
   }

   public List<zd> e() {
      this.h();
      return this.i;
   }

   public String g() {
      this.h();
      return this.j;
   }

   public static enum a {
      C("half_vertical_right", "vhr", " ##", " ##", " ##"),
      F("curly_border", "cbo", new zx(afi.bn));

      private zx Q;
      t("triangles_top", "tts", " # ", "# #", "   "),
      E("border", "bo", "###", "# #", "###");

      private String N;
      A("half_vertical", "vh", "## ", "## ", "## "),
      m("stripe_downleft", "dls", "  #", " # ", "#  "),
      L("flower", "flo", new zx(afi.O, 1, agw.a.j.b())),
      h("stripe_left", "ls", "#  ", "#  ", "#  "),
      x("diagonal_right", "rud", " ##", "  #", "   "),
      G("creeper", "cre", new zx(zy.bX, 1, 4)),
      f("stripe_bottom", "bs", "   ", "   ", "###"),
      w("diagonal_up_left", "lud", "   ", "#  ", "## "),
      v("diagonal_up_right", "rd", "   ", "  #", " ##"),
      i("stripe_right", "rs", "  #", "  #", "  #"),
      M("mojang", "moj", new zx(zy.ao, 1, 1)),
      l("stripe_downright", "drs", "#  ", " # ", "  #"),
      j("stripe_center", "cs", " # ", " # ", " # "),
      q("triangle_bottom", "bt", "   ", " # ", "# #"),
      p("straight_cross", "sc", " # ", "###", " # ");

      private String O;
      k("stripe_middle", "ms", "   ", "###", "   "),
      z("rhombus", "mr", " # ", "# #", " # "),
      g("stripe_top", "ts", "###", "   ", "   "),
      K("skull", "sku", new zx(zy.bX, 1, 1)),
      I("gradient_up", "gru", " # ", " # ", "# #"),
      c("square_bottom_right", "br", "   ", "   ", "  #"),
      J("bricks", "bri", new zx(afi.V)),
      u("diagonal_left", "ld", "## ", "#  ", "   "),
      H("gradient", "gra", "# #", " # ", " # "),
      a("base", "b"),
      r("triangle_top", "tt", "# #", " # ", "   "),
      B("half_horizontal", "hh", "###", "###", "   "),
      o("cross", "cr", "# #", " # ", "# #"),
      y("circle", "mc", "   ", " # ", "   "),
      b("square_bottom_left", "bl", "   ", "   ", "#  ");

      private static final aku.a[] R = new aku.a[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M};
      D("half_horizontal_bottom", "hhb", "   ", "###", "###"),
      n("small_stripes", "ss", "# #", "# #", "   "),
      e("square_top_right", "tr", "  #", "   ", "   ");

      private String[] P;
      d("square_top_left", "tl", "#  ", "   ", "   "),
      s("triangles_bottom", "bts", "   ", "# #", " # ");

      public String b() {
         return this.O;
      }

      public static aku.a a(String var0) {
         aku.a[] var1 = values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            aku.a var4 = var1[var3];
            if (var4.O.equals(var0)) {
               return var4;
            }
         }

         return null;
      }

      public boolean d() {
         return this.Q != null || this.P[0] != null;
      }

      private a(String var3, String var4) {
         this.P = new String[3];
         this.N = var3;
         this.O = var4;
      }

      private a(String var3, String var4, zx var5) {
         this(var3, var4);
         this.Q = var5;
      }

      public zx f() {
         return this.Q;
      }

      private a(String var3, String var4, String var5, String var6, String var7) {
         this(var3, var4);
         this.P[0] = var5;
         this.P[1] = var6;
         this.P[2] = var7;
      }

      public boolean e() {
         return this.Q != null;
      }

      public String a() {
         return this.N;
      }

      public String[] c() {
         return this.P;
      }
   }
}
