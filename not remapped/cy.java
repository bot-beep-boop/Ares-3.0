import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Map;

public enum cy {
   G("snowshovel", 32, false),
   K("iconcrack_", 36, false, 2),
   g("wake", 6, false);

   private final String Q;
   y("portal", 24, false);

   private static final cy[] W = new cy[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P};
   q("mobSpellAmbient", 16, false),
   x("note", 23, false),
   e("bubble", 4, false),
   c("hugeexplosion", 2, true),
   w("townaura", 22, false),
   J("barrier", 35, false),
   H("slime", 33, false);

   private static final String[] V;
   private static final Map<Integer, cy> U = Maps.newHashMap();
   P("mobappearance", 41, true),
   v("happyVillager", 21, false),
   u("angryVillager", 20, false),
   a("explode", 0, true),
   E("reddust", 30, false),
   h("suspended", 7, false),
   F("snowballpoof", 31, false),
   C("footstep", 28, false),
   m("largesmoke", 12, false);

   private final int T;
   j("crit", 9, false),
   s("dripWater", 18, false),
   L("blockcrack_", 37, false, 1),
   M("blockdust_", 38, false, 1),
   A("flame", 26, false),
   z("enchantmenttable", 25, false);

   private final boolean S;
   B("lava", 27, false),
   n("spell", 13, false),
   p("mobSpell", 15, false);

   private final int R;
   t("dripLava", 19, false),
   b("largeexplode", 1, true),
   o("instantSpell", 14, false),
   i("depthsuspend", 8, false),
   d("fireworksSpark", 3, false),
   O("take", 40, false),
   N("droplet", 39, false),
   D("cloud", 29, false),
   l("smoke", 11, false),
   k("magicCrit", 10, false),
   f("splash", 5, false),
   r("witchMagic", 17, false),
   I("heart", 34, false);

   private cy(String var3, int var4, boolean var5, int var6) {
      this.Q = var3;
      this.R = var4;
      this.S = var5;
      this.T = var6;
   }

   private cy(String var3, int var4, boolean var5) {
      this(var3, var4, var5, 0);
   }

   public int d() {
      return this.T;
   }

   public static String[] a() {
      return V;
   }

   public String b() {
      return this.Q;
   }

   static {
      ArrayList var0 = Lists.newArrayList();
      cy[] var1 = values();
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         cy var4 = var1[var3];
         U.put(var4.c(), var4);
         if (!var4.b().endsWith("_")) {
            var0.add(var4.b());
         }
      }

      V = (String[])var0.toArray(new String[var0.size()]);
   }

   public static cy a(int var0) {
      return (cy)U.get(var0);
   }

   public int c() {
      return this.R;
   }

   public boolean f() {
      return this.T > 0;
   }

   public boolean e() {
      return this.S;
   }
}
