import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class na {
   public static mw t;
   public static mw l;
   public static mw Q;
   public static mw o;
   public static final mw[] ac;
   public static mw n;
   public static mw I;
   public static mw p;
   public static mw Z;
   public static List<mw> c = Lists.newArrayList();
   public static mw L;
   public static mw G;
   public static List<mu> d = Lists.newArrayList();
   public static mw F;
   public static List<mw> b = Lists.newArrayList();
   public static mw N;
   public static mw V;
   public static mw u;
   protected static Map<String, mw> a = Maps.newHashMap();
   public static mw q;
   public static mw j;
   public static mw Y;
   public static final mw[] ad;
   public static mw M;
   public static mw m;
   public static mw X;
   public static mw D;
   public static final mw[] ab;
   public static mw x;
   public static mw y;
   public static mw i;
   public static mw k;
   public static mw C;
   public static final mw[] ae;
   public static List<mu> e = Lists.newArrayList();
   public static mw v;
   public static mw P;
   public static mw K;
   public static mw r;
   public static mw g;
   public static mw T;
   public static mw U;
   public static mw z;
   public static mw H;
   public static mw R;
   public static mw W;
   public static mw B;
   public static mw A;
   public static mw f = (new mt("stat.leaveGame", new fb("stat.leaveGame", new Object[0]))).i().h();
   public static mw w;
   public static mw O;
   public static mw S;
   public static mw s;
   public static mw E;
   public static mw J;
   public static mw h;
   public static mw aa;

   static {
      g = (new mt("stat.playOneMinute", new fb("stat.playOneMinute", new Object[0]), mw.h)).i().h();
      h = (new mt("stat.timeSinceDeath", new fb("stat.timeSinceDeath", new Object[0]), mw.h)).i().h();
      i = (new mt("stat.walkOneCm", new fb("stat.walkOneCm", new Object[0]), mw.i)).i().h();
      j = (new mt("stat.crouchOneCm", new fb("stat.crouchOneCm", new Object[0]), mw.i)).i().h();
      k = (new mt("stat.sprintOneCm", new fb("stat.sprintOneCm", new Object[0]), mw.i)).i().h();
      l = (new mt("stat.swimOneCm", new fb("stat.swimOneCm", new Object[0]), mw.i)).i().h();
      m = (new mt("stat.fallOneCm", new fb("stat.fallOneCm", new Object[0]), mw.i)).i().h();
      n = (new mt("stat.climbOneCm", new fb("stat.climbOneCm", new Object[0]), mw.i)).i().h();
      o = (new mt("stat.flyOneCm", new fb("stat.flyOneCm", new Object[0]), mw.i)).i().h();
      p = (new mt("stat.diveOneCm", new fb("stat.diveOneCm", new Object[0]), mw.i)).i().h();
      q = (new mt("stat.minecartOneCm", new fb("stat.minecartOneCm", new Object[0]), mw.i)).i().h();
      r = (new mt("stat.boatOneCm", new fb("stat.boatOneCm", new Object[0]), mw.i)).i().h();
      s = (new mt("stat.pigOneCm", new fb("stat.pigOneCm", new Object[0]), mw.i)).i().h();
      t = (new mt("stat.horseOneCm", new fb("stat.horseOneCm", new Object[0]), mw.i)).i().h();
      u = (new mt("stat.jump", new fb("stat.jump", new Object[0]))).i().h();
      v = (new mt("stat.drop", new fb("stat.drop", new Object[0]))).i().h();
      w = (new mt("stat.damageDealt", new fb("stat.damageDealt", new Object[0]), mw.j)).h();
      x = (new mt("stat.damageTaken", new fb("stat.damageTaken", new Object[0]), mw.j)).h();
      y = (new mt("stat.deaths", new fb("stat.deaths", new Object[0]))).h();
      z = (new mt("stat.mobKills", new fb("stat.mobKills", new Object[0]))).h();
      A = (new mt("stat.animalsBred", new fb("stat.animalsBred", new Object[0]))).h();
      B = (new mt("stat.playerKills", new fb("stat.playerKills", new Object[0]))).h();
      C = (new mt("stat.fishCaught", new fb("stat.fishCaught", new Object[0]))).h();
      D = (new mt("stat.junkFished", new fb("stat.junkFished", new Object[0]))).h();
      E = (new mt("stat.treasureFished", new fb("stat.treasureFished", new Object[0]))).h();
      F = (new mt("stat.talkedToVillager", new fb("stat.talkedToVillager", new Object[0]))).h();
      G = (new mt("stat.tradedWithVillager", new fb("stat.tradedWithVillager", new Object[0]))).h();
      H = (new mt("stat.cakeSlicesEaten", new fb("stat.cakeSlicesEaten", new Object[0]))).h();
      I = (new mt("stat.cauldronFilled", new fb("stat.cauldronFilled", new Object[0]))).h();
      J = (new mt("stat.cauldronUsed", new fb("stat.cauldronUsed", new Object[0]))).h();
      K = (new mt("stat.armorCleaned", new fb("stat.armorCleaned", new Object[0]))).h();
      L = (new mt("stat.bannerCleaned", new fb("stat.bannerCleaned", new Object[0]))).h();
      M = (new mt("stat.brewingstandInteraction", new fb("stat.brewingstandInteraction", new Object[0]))).h();
      N = (new mt("stat.beaconInteraction", new fb("stat.beaconInteraction", new Object[0]))).h();
      O = (new mt("stat.dropperInspected", new fb("stat.dropperInspected", new Object[0]))).h();
      P = (new mt("stat.hopperInspected", new fb("stat.hopperInspected", new Object[0]))).h();
      Q = (new mt("stat.dispenserInspected", new fb("stat.dispenserInspected", new Object[0]))).h();
      R = (new mt("stat.noteblockPlayed", new fb("stat.noteblockPlayed", new Object[0]))).h();
      S = (new mt("stat.noteblockTuned", new fb("stat.noteblockTuned", new Object[0]))).h();
      T = (new mt("stat.flowerPotted", new fb("stat.flowerPotted", new Object[0]))).h();
      U = (new mt("stat.trappedChestTriggered", new fb("stat.trappedChestTriggered", new Object[0]))).h();
      V = (new mt("stat.enderchestOpened", new fb("stat.enderchestOpened", new Object[0]))).h();
      W = (new mt("stat.itemEnchanted", new fb("stat.itemEnchanted", new Object[0]))).h();
      X = (new mt("stat.recordPlayed", new fb("stat.recordPlayed", new Object[0]))).h();
      Y = (new mt("stat.furnaceInteraction", new fb("stat.furnaceInteraction", new Object[0]))).h();
      Z = (new mt("stat.craftingTableInteraction", new fb("stat.workbenchInteraction", new Object[0]))).h();
      aa = (new mt("stat.chestOpened", new fb("stat.chestOpened", new Object[0]))).h();
      ab = new mw[4096];
      ac = new mw[32000];
      ad = new mw[32000];
      ae = new mw[32000];
   }

   private static void d() {
      Iterator var0 = zw.e.iterator();

      while(var0.hasNext()) {
         zw var1 = (zw)var0.next();
         if (var1 != null) {
            int var2 = zw.b(var1);
            String var3 = a(var1);
            if (var3 != null) {
               ad[var2] = (new mu("stat.useItem.", var3, new fb("stat.useItem", new Object[]{(new zx(var1)).C()}), var1)).h();
               if (!(var1 instanceof yo)) {
                  d.add((mu)ad[var2]);
               }
            }
         }
      }

      a(ad);
   }

   private static void c() {
      Iterator var0 = afh.c.iterator();

      while(var0.hasNext()) {
         afh var1 = (afh)var0.next();
         zw var2 = zw.a(var1);
         if (var2 != null) {
            int var3 = afh.a(var1);
            String var4 = a(var2);
            if (var4 != null && var1.J()) {
               ab[var3] = (new mu("stat.mineBlock.", var4, new fb("stat.mineBlock", new Object[]{(new zx(var1)).C()}), var2)).h();
               e.add((mu)ab[var3]);
            }
         }
      }

      a(ab);
   }

   private static void e() {
      Iterator var0 = zw.e.iterator();

      while(var0.hasNext()) {
         zw var1 = (zw)var0.next();
         if (var1 != null) {
            int var2 = zw.b(var1);
            String var3 = a(var1);
            if (var3 != null && var1.m()) {
               ae[var2] = (new mu("stat.breakItem.", var3, new fb("stat.breakItem", new Object[]{(new zx(var1)).C()}), var1)).h();
            }
         }
      }

      a(ae);
   }

   private static void b() {
      HashSet var0 = Sets.newHashSet();
      Iterator var1 = abt.a().b().iterator();

      while(var1.hasNext()) {
         abs var2 = (abs)var1.next();
         if (var2.b() != null) {
            var0.add(var2.b().b());
         }
      }

      var1 = abo.a().b().values().iterator();

      while(var1.hasNext()) {
         zx var5 = (zx)var1.next();
         var0.add(var5.b());
      }

      var1 = var0.iterator();

      while(var1.hasNext()) {
         zw var6 = (zw)var1.next();
         if (var6 != null) {
            int var3 = zw.b(var6);
            String var4 = a(var6);
            if (var4 != null) {
               ac[var3] = (new mu("stat.craftItem.", var4, new fb("stat.craftItem", new Object[]{(new zx(var6)).C()}), var6)).h();
            }
         }
      }

      a(ac);
   }

   private static void a(mw[] var0) {
      a(var0, afi.j, afi.i);
      a(var0, afi.l, afi.k);
      a(var0, afi.aZ, afi.aU);
      a(var0, afi.am, afi.al);
      a(var0, afi.aD, afi.aC);
      a(var0, afi.bc, afi.bb);
      a(var0, afi.ck, afi.cj);
      a(var0, afi.aF, afi.aE);
      a(var0, afi.bK, afi.bJ);
      a(var0, afi.T, afi.U);
      a(var0, afi.bL, afi.bM);
      a(var0, afi.cO, afi.cP);
      a(var0, afi.c, afi.d);
      a(var0, afi.ak, afi.d);
   }

   public static void a() {
      c();
      d();
      e();
      b();
      mr.a();
      pm.a();
   }

   private static String a(zw var0) {
      jy var1 = (jy)zw.e.c(var0);
      return var1 != null ? var1.toString().replace(':', '.') : null;
   }

   public static mw a(String var0) {
      return (mw)a.get(var0);
   }

   public static mw b(pm.a var0) {
      String var1 = pm.b(var0.a);
      return var1 == null ? null : (new mw("stat.entityKilledBy." + var1, new fb("stat.entityKilledBy", new Object[]{new fb("entity." + var1 + ".name", new Object[0])}))).h();
   }

   public static mw a(pm.a var0) {
      String var1 = pm.b(var0.a);
      return var1 == null ? null : (new mw("stat.killEntity." + var1, new fb("stat.entityKill", new Object[]{new fb("entity." + var1 + ".name", new Object[0])}))).h();
   }

   private static void a(mw[] var0, afh var1, afh var2) {
      int var3 = afh.a(var1);
      int var4 = afh.a(var2);
      if (var0[var3] != null && var0[var4] == null) {
         var0[var4] = var0[var3];
      } else {
         b.remove(var0[var3]);
         e.remove(var0[var3]);
         c.remove(var0[var3]);
         var0[var3] = var0[var4];
      }
   }
}
