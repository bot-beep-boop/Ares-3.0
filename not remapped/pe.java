import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;

public class pe {
   public static final pe n;
   public static final pe D;
   public static final pe C;
   public static final pe e;
   private String M = "";
   private final int L;
   public static final pe u;
   public static final pe r;
   public static final pe c;
   public static final pe w;
   public static final pe f;
   public static final pe G;
   private final Map<qb, qd> J = Maps.newHashMap();
   public final int H;
   public static final pe d;
   public static final pe F;
   public static final pe[] a = new pe[32];
   public static final pe x;
   public static final pe s;
   public static final pe h;
   public static final pe b = null;
   public static final pe A;
   public static final pe i;
   public static final pe k;
   public static final pe E;
   public static final pe z;
   private boolean P;
   public static final pe p;
   private static final Map<jy, pe> I = Maps.newHashMap();
   public static final pe j;
   public static final pe t;
   public static final pe q;
   public static final pe l;
   private final boolean K;
   public static final pe m;
   private int N = -1;
   public static final pe y;
   public static final pe B;
   public static final pe v;
   public static final pe g;
   public static final pe o;
   private double O;

   public boolean j() {
      return this.P;
   }

   public boolean g() {
      return this.K;
   }

   public static String a(pf var0) {
      if (var0.h()) {
         return "**:**";
      } else {
         int var1 = var0.b();
         return nx.a(var1);
      }
   }

   public pe c(String var1) {
      this.M = var1;
      return this;
   }

   public void b(pr var1, qf var2, int var3) {
      Iterator var4 = this.J.entrySet().iterator();

      while(var4.hasNext()) {
         Entry var5 = (Entry)var4.next();
         qc var6 = var2.a((qb)var5.getKey());
         if (var6 != null) {
            qd var7 = (qd)var5.getValue();
            var6.c(var7);
            var6.b(new qd(var7.a(), this.a() + " " + var3, this.a(var3, var7), var7.c()));
         }
      }

   }

   public pe a(qb var1, String var2, double var3, int var5) {
      qd var6 = new qd(UUID.fromString(var2), this.a(), var3, var5);
      this.J.put(var1, var6);
      return this;
   }

   protected pe(int var1, jy var2, boolean var3, int var4) {
      this.H = var1;
      a[var1] = this;
      I.put(var2, this);
      this.K = var3;
      if (var3) {
         this.O = 0.5D;
      } else {
         this.O = 1.0D;
      }

      this.L = var4;
   }

   public String a() {
      return this.M;
   }

   protected pe b(int var1, int var2) {
      this.N = var1 + var2 * 8;
      return this;
   }

   static {
      c = (new pe(1, new jy("speed"), false, 8171462)).c("potion.moveSpeed").b(0, 0).a(vy.d, "91AEAA56-376B-4498-935B-2F7F68070635", 0.20000000298023224D, 2);
      d = (new pe(2, new jy("slowness"), true, 5926017)).c("potion.moveSlowdown").b(1, 0).a(vy.d, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.15000000596046448D, 2);
      e = (new pe(3, new jy("haste"), false, 14270531)).c("potion.digSpeed").b(2, 0).a(1.5D);
      f = (new pe(4, new jy("mining_fatigue"), true, 4866583)).c("potion.digSlowDown").b(3, 0);
      g = (new pb(5, new jy("strength"), false, 9643043)).c("potion.damageBoost").b(4, 0).a(vy.e, "648D7064-6A60-4F59-8ABE-C2C23A6DD7A9", 2.5D, 2);
      h = (new pd(6, new jy("instant_health"), false, 16262179)).c("potion.heal");
      i = (new pd(7, new jy("instant_damage"), true, 4393481)).c("potion.harm");
      j = (new pe(8, new jy("jump_boost"), false, 2293580)).c("potion.jump").b(2, 1);
      k = (new pe(9, new jy("nausea"), true, 5578058)).c("potion.confusion").b(3, 1).a(0.25D);
      l = (new pe(10, new jy("regeneration"), false, 13458603)).c("potion.regeneration").b(7, 0).a(0.25D);
      m = (new pe(11, new jy("resistance"), false, 10044730)).c("potion.resistance").b(6, 1);
      n = (new pe(12, new jy("fire_resistance"), false, 14981690)).c("potion.fireResistance").b(7, 1);
      o = (new pe(13, new jy("water_breathing"), false, 3035801)).c("potion.waterBreathing").b(0, 2);
      p = (new pe(14, new jy("invisibility"), false, 8356754)).c("potion.invisibility").b(0, 1);
      q = (new pe(15, new jy("blindness"), true, 2039587)).c("potion.blindness").b(5, 1).a(0.25D);
      r = (new pe(16, new jy("night_vision"), false, 2039713)).c("potion.nightVision").b(4, 1);
      s = (new pe(17, new jy("hunger"), true, 5797459)).c("potion.hunger").b(1, 1);
      t = (new pb(18, new jy("weakness"), true, 4738376)).c("potion.weakness").b(5, 0).a(vy.e, "22653B89-116E-49DC-9B6B-9971489B5BE5", 2.0D, 0);
      u = (new pe(19, new jy("poison"), true, 5149489)).c("potion.poison").b(6, 0).a(0.25D);
      v = (new pe(20, new jy("wither"), true, 3484199)).c("potion.wither").b(1, 2).a(0.25D);
      w = (new pc(21, new jy("health_boost"), false, 16284963)).c("potion.healthBoost").b(2, 2).a(vy.a, "5D6F0BA2-1186-46AC-B896-C61C5CEE99CC", 4.0D, 0);
      x = (new pa(22, new jy("absorption"), false, 2445989)).c("potion.absorption").b(2, 2);
      y = (new pd(23, new jy("saturation"), false, 16262179)).c("potion.saturation");
      z = null;
      A = null;
      B = null;
      C = null;
      D = null;
      E = null;
      F = null;
      G = null;
   }

   public void a(pk var1, pk var2, pr var3, int var4, double var5) {
      int var7;
      if (this.H == h.H && !var3.bm() || this.H == i.H && var3.bm()) {
         var7 = (int)(var5 * (double)(4 << var4) + 0.5D);
         var3.h((float)var7);
      } else if (this.H == i.H && !var3.bm() || this.H == h.H && var3.bm()) {
         var7 = (int)(var5 * (double)(6 << var4) + 0.5D);
         if (var1 == null) {
            var3.a(ow.l, (float)var7);
         } else {
            var3.a(ow.b(var1, var2), (float)var7);
         }
      }

   }

   public void a(pr var1, int var2) {
      if (this.H == l.H) {
         if (var1.bn() < var1.bu()) {
            var1.h(1.0F);
         }
      } else if (this.H == u.H) {
         if (var1.bn() > 1.0F) {
            var1.a(ow.l, 1.0F);
         }
      } else if (this.H == v.H) {
         var1.a(ow.m, 1.0F);
      } else if (this.H == s.H && var1 instanceof wn) {
         ((wn)var1).a(0.025F * (float)(var2 + 1));
      } else if (this.H == y.H && var1 instanceof wn) {
         if (!var1.o.D) {
            ((wn)var1).cl().a(var2 + 1, 1.0F);
         }
      } else if (this.H == h.H && !var1.bm() || this.H == i.H && var1.bm()) {
         var1.h((float)Math.max(4 << var2, 0));
      } else if (this.H == i.H && !var1.bm() || this.H == h.H && var1.bm()) {
         var1.a(ow.l, (float)(6 << var2));
      }

   }

   public int k() {
      return this.L;
   }

   public boolean b() {
      return false;
   }

   public double h() {
      return this.O;
   }

   public int f() {
      return this.N;
   }

   public static pe b(String var0) {
      return (pe)I.get(new jy(var0));
   }

   public static Set<jy> c() {
      return I.keySet();
   }

   public boolean a(int var1, int var2) {
      int var3;
      if (this.H == l.H) {
         var3 = 50 >> var2;
         if (var3 > 0) {
            return var1 % var3 == 0;
         } else {
            return true;
         }
      } else if (this.H == u.H) {
         var3 = 25 >> var2;
         if (var3 > 0) {
            return var1 % var3 == 0;
         } else {
            return true;
         }
      } else if (this.H == v.H) {
         var3 = 40 >> var2;
         if (var3 > 0) {
            return var1 % var3 == 0;
         } else {
            return true;
         }
      } else {
         return this.H == s.H;
      }
   }

   public int d() {
      return this.H;
   }

   public Map<qb, qd> l() {
      return this.J;
   }

   protected pe a(double var1) {
      this.O = var1;
      return this;
   }

   public double a(int var1, qd var2) {
      return var2.d() * (double)(var1 + 1);
   }

   public void a(pr var1, qf var2, int var3) {
      Iterator var4 = this.J.entrySet().iterator();

      while(var4.hasNext()) {
         Entry var5 = (Entry)var4.next();
         qc var6 = var2.a((qb)var5.getKey());
         if (var6 != null) {
            var6.c((qd)var5.getValue());
         }
      }

   }

   public boolean e() {
      return this.N >= 0;
   }
}
