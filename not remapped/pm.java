import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class pm {
   private static final Map<String, Integer> g = Maps.newHashMap();
   private static final Map<Integer, Class<? extends pk>> e = Maps.newHashMap();
   private static final Map<String, Class<? extends pk>> c = Maps.newHashMap();
   private static final Map<Class<? extends pk>, Integer> f = Maps.newHashMap();
   private static final Logger b = LogManager.getLogger();
   public static final Map<Integer, pm.a> a = Maps.newLinkedHashMap();
   private static final Map<Class<? extends pk>, String> d = Maps.newHashMap();

   private static void a(Class<? extends pk> var0, String var1, int var2, int var3, int var4) {
      a(var0, var1, var2);
      a.put(var2, new pm.a(var2, var3, var4));
   }

   public static pk a(int var0, adm var1) {
      pk var2 = null;

      try {
         Class var3 = a(var0);
         if (var3 != null) {
            var2 = (pk)var3.getConstructor(adm.class).newInstance(var1);
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      if (var2 == null) {
         b.warn("Skipping Entity with id " + var0);
      }

      return var2;
   }

   public static pk a(dn var0, adm var1) {
      pk var2 = null;
      if ("Minecart".equals(var0.j("id"))) {
         var0.a("id", va.a.a(var0.f("Type")).b());
         var0.o("Type");
      }

      try {
         Class var3 = (Class)c.get(var0.j("id"));
         if (var3 != null) {
            var2 = (pk)var3.getConstructor(adm.class).newInstance(var1);
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      if (var2 != null) {
         var2.f(var0);
      } else {
         b.warn("Skipping Entity with id " + var0.j("id"));
      }

      return var2;
   }

   public static String b(int var0) {
      return (String)d.get(a(var0));
   }

   public static Class<? extends pk> a(int var0) {
      return (Class)e.get(var0);
   }

   public static boolean a(pk var0, String var1) {
      String var2 = b(var0);
      if (var2 == null && var0 instanceof wn) {
         var2 = "Player";
      } else if (var2 == null && var0 instanceof uv) {
         var2 = "LightningBolt";
      }

      return var1.equals(var2);
   }

   public static boolean b(String var0) {
      return "Player".equals(var0) || b().contains(var0);
   }

   public static pk a(String var0, adm var1) {
      pk var2 = null;

      try {
         Class var3 = (Class)c.get(var0);
         if (var3 != null) {
            var2 = (pk)var3.getConstructor(adm.class).newInstance(var1);
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      return var2;
   }

   public static String b(pk var0) {
      return (String)d.get(var0.getClass());
   }

   public static int a(String var0) {
      Integer var1 = (Integer)g.get(var0);
      return var1 == null ? 90 : var1;
   }

   private static void a(Class<? extends pk> var0, String var1, int var2) {
      if (c.containsKey(var1)) {
         throw new IllegalArgumentException("ID is already registered: " + var1);
      } else if (e.containsKey(var2)) {
         throw new IllegalArgumentException("ID is already registered: " + var2);
      } else if (var2 == 0) {
         throw new IllegalArgumentException("Cannot register to reserved id: " + var2);
      } else if (var0 == null) {
         throw new IllegalArgumentException("Cannot register null clazz for id: " + var2);
      } else {
         c.put(var1, var0);
         d.put(var0, var1);
         e.put(var2, var0);
         f.put(var0, var2);
         g.put(var1, var2);
      }
   }

   static {
      a(uz.class, "Item", 1);
      a(pp.class, "XPOrb", 2);
      a(wz.class, "ThrownEgg", 7);
      a(up.class, "LeashKnot", 8);
      a(uq.class, "Painting", 9);
      a(wq.class, "Arrow", 10);
      a(wx.class, "Snowball", 11);
      a(wu.class, "Fireball", 12);
      a(ww.class, "SmallFireball", 13);
      a(xa.class, "ThrownEnderpearl", 14);
      a(wr.class, "EyeOfEnderSignal", 15);
      a(xc.class, "ThrownPotion", 16);
      a(xb.class, "ThrownExpBottle", 17);
      a(uo.class, "ItemFrame", 18);
      a(xd.class, "WitherSkull", 19);
      a(vj.class, "PrimedTnt", 20);
      a(uy.class, "FallingSand", 21);
      a(wt.class, "FireworksRocketEntity", 22);
      a(um.class, "ArmorStand", 30);
      a(ux.class, "Boat", 41);
      a(vg.class, va.a.a.b(), 42);
      a(vb.class, va.a.b.b(), 43);
      a(ve.class, va.a.c.b(), 44);
      a(vi.class, va.a.d.b(), 45);
      a(vf.class, va.a.f.b(), 46);
      a(vh.class, va.a.e.b(), 47);
      a(vc.class, va.a.g.b(), 40);
      a(ps.class, "Mob", 48);
      a(vv.class, "Monster", 49);
      a(vn.class, "Creeper", 50, 894731, 0);
      a(wa.class, "Skeleton", 51, 12698049, 4802889);
      a(wc.class, "Spider", 52, 3419431, 11013646);
      a(vs.class, "Giant", 53);
      a(we.class, "Zombie", 54, 44975, 7969893);
      a(wb.class, "Slime", 55, 5349438, 8306542);
      a(vr.class, "Ghast", 56, 16382457, 12369084);
      a(vw.class, "PigZombie", 57, 15373203, 5009705);
      a(vo.class, "Enderman", 58, 1447446, 0);
      a(vm.class, "CaveSpider", 59, 803406, 11013646);
      a(vz.class, "Silverfish", 60, 7237230, 3158064);
      a(vl.class, "Blaze", 61, 16167425, 16775294);
      a(vu.class, "LavaSlime", 62, 3407872, 16579584);
      a(ug.class, "EnderDragon", 63);
      a(uk.class, "WitherBoss", 64);
      a(tk.class, "Bat", 65, 4996656, 986895);
      a(wd.class, "Witch", 66, 3407872, 5349438);
      a(vp.class, "Endermite", 67, 1447446, 7237230);
      a(vt.class, "Guardian", 68, 5931634, 15826224);
      a(tt.class, "Pig", 90, 15771042, 14377823);
      a(tv.class, "Sheep", 91, 15198183, 16758197);
      a(to.class, "Cow", 92, 4470310, 10592673);
      a(tn.class, "Chicken", 93, 10592673, 16711680);
      a(tx.class, "Squid", 94, 2243405, 7375001);
      a(ua.class, "Wolf", 95, 14144467, 13545366);
      a(tr.class, "MushroomCow", 96, 10489616, 12040119);
      a(tw.class, "SnowMan", 97);
      a(ts.class, "Ozelot", 98, 15720061, 5653556);
      a(ty.class, "VillagerGolem", 99);
      a(tp.class, "EntityHorse", 100, 12623485, 15656192);
      a(tu.class, "Rabbit", 101, 10051392, 7555121);
      a(wi.class, "Villager", 120, 5651507, 12422002);
      a(uf.class, "EnderCrystal", 200);
   }

   public static List<String> b() {
      Set var0 = c.keySet();
      ArrayList var1 = Lists.newArrayList();
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         Class var4 = (Class)c.get(var3);
         if ((var4.getModifiers() & 1024) != 1024) {
            var1.add(var3);
         }
      }

      var1.add("LightningBolt");
      return var1;
   }

   public static void a() {
   }

   public static int a(pk var0) {
      Integer var1 = (Integer)f.get(var0.getClass());
      return var1 == null ? 0 : var1;
   }

   public static class a {
      public final mw d;
      public final int b;
      public final int a;
      public final mw e;
      public final int c;

      public a(int var1, int var2, int var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = na.a(this);
         this.e = na.b(this);
      }
   }
}
