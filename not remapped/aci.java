import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public abstract class aci {
   private final int F;
   public static final aci t;
   public static final aci k = new acu(8, new jy("depth_strider"), 2);
   private static final Map<jy, aci> E = Maps.newHashMap();
   public acj C;
   public static final aci f = new acr(3, new jy("blast_protection"), 2, 3);
   public static final aci h = new acq(5, new jy("respiration"), 2);
   public static final aci z;
   public static final aci j = new acs(7, new jy("thorns"), 1);
   public static final aci q;
   public final int B;
   public static final aci d = new acr(1, new jy("fire_protection"), 5, 1);
   public static final aci w;
   public static final aci u;
   public static final aci[] b;
   public static final aci y;
   public static final aci m = new acf(17, new jy("smite"), 5, 1);
   private static final aci[] a = new aci[256];
   public static final aci e = new acr(2, new jy("feather_falling"), 5, 2);
   public static final aci g = new acr(4, new jy("projectile_protection"), 5, 4);
   protected String D;
   public static final aci p = new acm(20, new jy("fire_aspect"), 2);
   public static final aci s;
   public static final aci r;
   public static final aci o = new aco(19, new jy("knockback"), 5);
   public static final aci n = new acf(18, new jy("bane_of_arthropods"), 5, 2);
   public static final aci A;
   public static final aci x;
   public static final aci c = new acr(0, new jy("protection"), 10, 0);
   public static final aci v;
   public static final aci i = new acv(6, new jy("aqua_affinity"), 2);
   public static final aci l = new acf(16, new jy("sharpness"), 10, 0);

   public int e() {
      return 1;
   }

   public static aci c(int var0) {
      return var0 >= 0 && var0 < a.length ? a[var0] : null;
   }

   public boolean a(aci var1) {
      return this != var1;
   }

   public void b(pr var1, pk var2, int var3) {
   }

   public static Set<jy> c() {
      return E.keySet();
   }

   public static aci b(String var0) {
      return (aci)E.get(new jy(var0));
   }

   public boolean a(zx var1) {
      return this.C.a(var1.b());
   }

   public aci c(String var1) {
      this.D = var1;
      return this;
   }

   public float a(int var1, pw var2) {
      return 0.0F;
   }

   public int b() {
      return 1;
   }

   static {
      q = new acp(21, new jy("looting"), 2, acj.g);
      r = new ach(32, new jy("efficiency"), 10);
      s = new act(33, new jy("silk_touch"), 1);
      t = new acg(34, new jy("unbreaking"), 5);
      u = new acp(35, new jy("fortune"), 2, acj.h);
      v = new acb(48, new jy("power"), 10);
      w = new ace(49, new jy("punch"), 2);
      x = new acc(50, new jy("flame"), 2);
      y = new acd(51, new jy("infinity"), 1);
      z = new acp(61, new jy("luck_of_the_sea"), 2, acj.i);
      A = new acn(62, new jy("lure"), 2, acj.i);
      ArrayList var0 = Lists.newArrayList();
      aci[] var1 = a;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         aci var4 = var1[var3];
         if (var4 != null) {
            var0.add(var4);
         }
      }

      b = (aci[])var0.toArray(new aci[var0.size()]);
   }

   public String a() {
      return "enchantment." + this.D;
   }

   public int a(int var1) {
      return 1 + var1 * 10;
   }

   public int b(int var1) {
      return this.a(var1) + 5;
   }

   public void a(pr var1, pk var2, int var3) {
   }

   public int a(int var1, ow var2) {
      return 0;
   }

   public int d() {
      return this.F;
   }

   public String d(int var1) {
      String var2 = di.a(this.a());
      return var2 + " " + di.a("enchantment.level." + var1);
   }

   protected aci(int var1, jy var2, int var3, acj var4) {
      this.B = var1;
      this.F = var3;
      this.C = var4;
      if (a[var1] != null) {
         throw new IllegalArgumentException("Duplicate enchantment id!");
      } else {
         a[var1] = this;
         E.put(var2, this);
      }
   }
}
