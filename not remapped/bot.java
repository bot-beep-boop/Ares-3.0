import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Queues;
import com.google.common.collect.Sets;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bot {
   private static final bgl q;
   private final bni f;
   private final bgo l = new bgo();
   private static final Map<String, String> d = Maps.newHashMap();
   private final bgp m = new bgp();
   private static final Set<jy> b = Sets.newHashSet(new jy[]{new jy("blocks/water_flow"), new jy("blocks/water_still"), new jy("blocks/lava_flow"), new jy("blocks/lava_still"), new jy("blocks/destroy_stage_0"), new jy("blocks/destroy_stage_1"), new jy("blocks/destroy_stage_2"), new jy("blocks/destroy_stage_3"), new jy("blocks/destroy_stage_4"), new jy("blocks/destroy_stage_5"), new jy("blocks/destroy_stage_6"), new jy("blocks/destroy_stage_7"), new jy("blocks/destroy_stage_8"), new jy("blocks/destroy_stage_9"), new jy("items/empty_armor_slot_helmet"), new jy("items/empty_armor_slot_chestplate"), new jy("items/empty_armor_slot_leggings"), new jy("items/empty_armor_slot_boots")});
   private static final bgl p;
   private static final bgl r;
   private Map<String, jy> s = Maps.newLinkedHashMap();
   private static final Logger c = LogManager.getLogger();
   private Map<zw, List<String>> u = Maps.newIdentityHashMap();
   private final Map<jy, bgm> t = Maps.newHashMap();
   private final Map<jy, bgl> h = Maps.newLinkedHashMap();
   protected static final bov a = new bov("builtin/missing", "missing");
   private final Map<bov, bgm.d> i = Maps.newLinkedHashMap();
   private static final bgl o;
   private final Map<jy, bmi> g = Maps.newHashMap();
   private static final Joiner e;
   private final bmh j;
   private final bgc k;
   private dd<bov, boq> n = new dd();

   private Set<jy> k() {
      HashSet var1 = Sets.newHashSet();
      Iterator var2 = this.s.values().iterator();

      while(true) {
         while(true) {
            bgl var4;
            do {
               if (!var2.hasNext()) {
                  return var1;
               }

               jy var3 = (jy)var2.next();
               var4 = (bgl)this.h.get(var3);
            } while(var4 == null);

            var1.add(new jy(var4.c("particle")));
            Iterator var5;
            jy var11;
            if (this.b(var4)) {
               for(var5 = bgp.a.iterator(); var5.hasNext(); var1.add(var11)) {
                  String var10 = (String)var5.next();
                  var11 = new jy(var4.c(var10));
                  if (var4.f() == p && !bmh.f.equals(var11)) {
                     bmi.b(var11.toString());
                  } else if (var4.f() == q && !bmh.f.equals(var11)) {
                     bmi.a(var11.toString());
                  }
               }
            } else if (!this.c(var4)) {
               var5 = var4.a().iterator();

               while(var5.hasNext()) {
                  bgh var6 = (bgh)var5.next();
                  Iterator var7 = var6.c.values().iterator();

                  while(var7.hasNext()) {
                     bgi var8 = (bgi)var7.next();
                     jy var9 = new jy(var4.c(var8.d));
                     var1.add(var9);
                  }
               }
            }
         }
      }
   }

   private void c() {
      Iterator var1 = this.i.keySet().iterator();

      while(var1.hasNext()) {
         bov var2 = (bov)var1.next();
         Iterator var3 = ((bgm.d)this.i.get(var2)).b().iterator();

         while(var3.hasNext()) {
            bgm.c var4 = (bgm.c)var3.next();
            jy var5 = var4.a();
            if (this.h.get(var5) == null) {
               try {
                  bgl var6 = this.c(var5);
                  this.h.put(var5, var6);
               } catch (Exception var7) {
                  c.warn("Unable to load block model: '" + var5 + "' for variant: '" + var2 + "'", var7);
               }
            }
         }
      }

   }

   static Map a(bot var0) {
      return var0.g;
   }

   private void b() {
      this.a(this.k.a().a().values());
      this.i.put(a, new bgm.d(a.c(), Lists.newArrayList(new bgm.c[]{new bgm.c(new jy(a.a()), bor.a, false, 1)})));
      jy var1 = new jy("item_frame");
      bgm var2 = this.a(var1);
      this.a(var2, new bov(var1, "normal"));
      this.a(var2, new bov(var1, "map"));
      this.c();
      this.d();
   }

   public db<bov, boq> a() {
      this.b();
      this.h();
      this.j();
      this.l();
      this.f();
      return this.n;
   }

   private void h() {
      this.i();
      Iterator var1 = this.h.values().iterator();

      while(var1.hasNext()) {
         bgl var2 = (bgl)var1.next();
         var2.a(this.h);
      }

      bgl.b(this.h);
   }

   private boolean b(bgl var1) {
      if (var1 == null) {
         return false;
      } else {
         bgl var2 = var1.f();
         return var2 == o || var2 == p || var2 == q;
      }
   }

   private boolean c(bgl var1) {
      if (var1 == null) {
         return false;
      } else {
         bgl var2 = var1.f();
         return var2 == r;
      }
   }

   private void j() {
      Set var1 = this.g();
      var1.addAll(this.k());
      var1.remove(bmh.f);
      bmb var2 = new bmb(this, var1) {
         final Set a;
         final bot b;

         public void a(bmh var1) {
            Iterator var2 = this.a.iterator();

            while(var2.hasNext()) {
               jy var3 = (jy)var2.next();
               bmi var4 = var1.a(var3);
               bot.a(this.b).put(var3, var4);
            }

         }

         {
            this.b = var1;
            this.a = var2;
         }
      };
      this.j.a(this.f, var2);
      this.g.put(new jy("missingno"), this.j.f());
   }

   private jy f(jy var1) {
      Iterator var2 = this.h.entrySet().iterator();

      Entry var3;
      bgl var4;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         var3 = (Entry)var2.next();
         var4 = (bgl)var3.getValue();
      } while(var4 == null || !var1.equals(var4.e()));

      return (jy)var3.getKey();
   }

   private List<String> a(zw var1) {
      List var2 = (List)this.u.get(var1);
      if (var2 == null) {
         var2 = Collections.singletonList(((jy)zw.e.c(var1)).toString());
      }

      return var2;
   }

   private void a(Collection<bov> var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         bov var3 = (bov)var2.next();

         try {
            bgm var4 = this.a((jy)var3);

            try {
               this.a(var4, var3);
            } catch (Exception var6) {
               c.warn("Unable to load variant: " + var3.c() + " from " + var3);
            }
         } catch (Exception var7) {
            c.warn("Unable to load definition " + var3, var7);
         }
      }

   }

   public bot(bni var1, bmh var2, bgc var3) {
      this.f = var1;
      this.j = var2;
      this.k = var3;
   }

   private bgm a(jy var1) {
      jy var2 = this.b(var1);
      bgm var3 = (bgm)this.t.get(var2);
      if (var3 == null) {
         ArrayList var4 = Lists.newArrayList();

         try {
            Iterator var5 = this.f.b(var2).iterator();

            while(var5.hasNext()) {
               bnh var6 = (bnh)var5.next();
               InputStream var7 = null;

               try {
                  var7 = var6.b();
                  bgm var8 = bgm.a(new InputStreamReader(var7, Charsets.UTF_8));
                  var4.add(var8);
               } catch (Exception var13) {
                  throw new RuntimeException("Encountered an exception when loading model definition of '" + var1 + "' from: '" + var6.a() + "' in resourcepack: '" + var6.d() + "'", var13);
               } finally {
                  IOUtils.closeQuietly(var7);
               }
            }
         } catch (IOException var15) {
            throw new RuntimeException("Encountered an exception when loading model definition of model " + var2.toString(), var15);
         }

         var3 = new bgm(var4);
         this.t.put(var2, var3);
      }

      return var3;
   }

   private bgl d(bgl var1) {
      return this.m.a(this.j, var1);
   }

   private bgg a(bgh var1, bgi var2, bmi var3, cq var4, bor var5, boolean var6) {
      return this.l.a(var1.a, var1.b, var2, var3, var4, var5, var1.d, var6, var1.e);
   }

   private jy d(jy var1) {
      return new jy(var1.b(), "models/" + var1.a() + ".json");
   }

   private bgl c(jy var1) throws IOException {
      String var3 = var1.a();
      if ("builtin/generated".equals(var3)) {
         return o;
      } else if ("builtin/compass".equals(var3)) {
         return p;
      } else if ("builtin/clock".equals(var3)) {
         return q;
      } else if ("builtin/entity".equals(var3)) {
         return r;
      } else {
         Object var2;
         if (var3.startsWith("builtin/")) {
            String var4 = var3.substring("builtin/".length());
            String var5 = (String)d.get(var4);
            if (var5 == null) {
               throw new FileNotFoundException(var1.toString());
            }

            var2 = new StringReader(var5);
         } else {
            bnh var9 = this.f.a(this.d(var1));
            var2 = new InputStreamReader(var9.b(), Charsets.UTF_8);
         }

         bgl var11;
         try {
            bgl var10 = bgl.a((Reader)var2);
            var10.b = var1.toString();
            var11 = var10;
         } finally {
            ((Reader)var2).close();
         }

         return var11;
      }
   }

   private void l() {
      Iterator var1 = this.s.values().iterator();

      while(var1.hasNext()) {
         jy var2 = (jy)var1.next();
         bgl var3 = (bgl)this.h.get(var2);
         if (this.b(var3)) {
            bgl var4 = this.d(var3);
            if (var4 != null) {
               var4.b = var2.toString();
            }

            this.h.put(var2, var4);
         } else if (this.c(var3)) {
            this.h.put(var2, var3);
         }
      }

      var1 = this.g.values().iterator();

      while(var1.hasNext()) {
         bmi var5 = (bmi)var1.next();
         if (!var5.m()) {
            var5.l();
         }
      }

   }

   private boq a(bgl var1, bor var2, boolean var3) {
      bmi var4 = (bmi)this.g.get(new jy(var1.c("particle")));
      bow.a var5 = (new bow.a(var1)).a(var4);
      Iterator var6 = var1.a().iterator();

      while(var6.hasNext()) {
         bgh var7 = (bgh)var6.next();
         Iterator var8 = var7.c.keySet().iterator();

         while(var8.hasNext()) {
            cq var9 = (cq)var8.next();
            bgi var10 = (bgi)var7.c.get(var9);
            bmi var11 = (bmi)this.g.get(new jy(var1.c(var10.d)));
            if (var10.b == null) {
               var5.a(this.a(var7, var10, var11, var9, var2, var3));
            } else {
               var5.a(var2.a(var10.b), this.a(var7, var10, var11, var9, var2, var3));
            }
         }
      }

      return var5.b();
   }

   private List<jy> e(jy var1) {
      ArrayList var2 = Lists.newArrayList(new jy[]{var1});
      jy var3 = var1;

      while((var3 = this.f(var3)) != null) {
         var2.add(0, var3);
      }

      return var2;
   }

   static {
      d.put("missing", "{ \"textures\": {   \"particle\": \"missingno\",   \"missingno\": \"missingno\"}, \"elements\": [ {     \"from\": [ 0, 0, 0 ],     \"to\": [ 16, 16, 16 ],     \"faces\": {         \"down\":  { \"uv\": [ 0, 0, 16, 16 ], \"cullface\": \"down\", \"texture\": \"#missingno\" },         \"up\":    { \"uv\": [ 0, 0, 16, 16 ], \"cullface\": \"up\", \"texture\": \"#missingno\" },         \"north\": { \"uv\": [ 0, 0, 16, 16 ], \"cullface\": \"north\", \"texture\": \"#missingno\" },         \"south\": { \"uv\": [ 0, 0, 16, 16 ], \"cullface\": \"south\", \"texture\": \"#missingno\" },         \"west\":  { \"uv\": [ 0, 0, 16, 16 ], \"cullface\": \"west\", \"texture\": \"#missingno\" },         \"east\":  { \"uv\": [ 0, 0, 16, 16 ], \"cullface\": \"east\", \"texture\": \"#missingno\" }    }}]}");
      e = Joiner.on(" -> ");
      o = bgl.a("{\"elements\":[{  \"from\": [0, 0, 0],   \"to\": [16, 16, 16],   \"faces\": {       \"down\": {\"uv\": [0, 0, 16, 16], \"texture\":\"\"}   }}]}");
      p = bgl.a("{\"elements\":[{  \"from\": [0, 0, 0],   \"to\": [16, 16, 16],   \"faces\": {       \"down\": {\"uv\": [0, 0, 16, 16], \"texture\":\"\"}   }}]}");
      q = bgl.a("{\"elements\":[{  \"from\": [0, 0, 0],   \"to\": [16, 16, 16],   \"faces\": {       \"down\": {\"uv\": [0, 0, 16, 16], \"texture\":\"\"}   }}]}");
      r = bgl.a("{\"elements\":[{  \"from\": [0, 0, 0],   \"to\": [16, 16, 16],   \"faces\": {       \"down\": {\"uv\": [0, 0, 16, 16], \"texture\":\"\"}   }}]}");
      o.b = "generation marker";
      p.b = "compass generation marker";
      q.b = "class generation marker";
      r.b = "block entity marker";
   }

   private Set<jy> g() {
      HashSet var1 = Sets.newHashSet();
      ArrayList var2 = Lists.newArrayList(this.i.keySet());
      Collections.sort(var2, new Comparator<bov>(this) {
         final bot a;

         public int a(bov var1, bov var2) {
            return var1.toString().compareTo(var2.toString());
         }

         public int compare(Object var1, Object var2) {
            return this.a((bov)var1, (bov)var2);
         }

         {
            this.a = var1;
         }
      });
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         bov var4 = (bov)var3.next();
         bgm.d var5 = (bgm.d)this.i.get(var4);
         Iterator var6 = var5.b().iterator();

         while(var6.hasNext()) {
            bgm.c var7 = (bgm.c)var6.next();
            bgl var8 = (bgl)this.h.get(var7.a());
            if (var8 == null) {
               c.warn("Missing model for: " + var4);
            } else {
               var1.addAll(this.a(var8));
            }
         }
      }

      var1.addAll(b);
      return var1;
   }

   private Set<jy> a(bgl var1) {
      HashSet var2 = Sets.newHashSet();
      Iterator var3 = var1.a().iterator();

      while(var3.hasNext()) {
         bgh var4 = (bgh)var3.next();
         Iterator var5 = var4.c.values().iterator();

         while(var5.hasNext()) {
            bgi var6 = (bgi)var5.next();
            jy var7 = new jy(var1.c(var6.d));
            var2.add(var7);
         }
      }

      var2.add(new jy(var1.c("particle")));
      return var2;
   }

   private void d() {
      this.e();
      Iterator var1 = zw.e.iterator();

      while(var1.hasNext()) {
         zw var2 = (zw)var1.next();
         List var3 = this.a(var2);
         Iterator var4 = var3.iterator();

         while(var4.hasNext()) {
            String var5 = (String)var4.next();
            jy var6 = this.a(var5);
            this.s.put(var5, var6);
            if (this.h.get(var6) == null) {
               try {
                  bgl var7 = this.c(var6);
                  this.h.put(var6, var7);
               } catch (Exception var8) {
                  c.warn("Unable to load item model: '" + var6 + "' for item: '" + zw.e.c(var2) + "'", var8);
               }
            }
         }
      }

   }

   private void f() {
      Iterator var1 = this.i.keySet().iterator();

      while(var1.hasNext()) {
         bov var2 = (bov)var1.next();
         box.a var3 = new box.a();
         int var4 = 0;
         Iterator var5 = ((bgm.d)this.i.get(var2)).b().iterator();

         while(true) {
            while(var5.hasNext()) {
               bgm.c var6 = (bgm.c)var5.next();
               bgl var7 = (bgl)this.h.get(var6.a());
               if (var7 != null && var7.d()) {
                  ++var4;
                  var3.a(this.a(var7, var6.b(), var6.c()), var6.d());
               } else {
                  c.warn("Missing model for: " + var2);
               }
            }

            if (var4 == 0) {
               c.warn("No weighted models for: " + var2);
            } else if (var4 == 1) {
               this.n.a(var2, var3.b());
            } else {
               this.n.a(var2, var3.a());
            }
            break;
         }
      }

      var1 = this.s.entrySet().iterator();

      while(true) {
         while(var1.hasNext()) {
            Entry var8 = (Entry)var1.next();
            jy var9 = (jy)var8.getValue();
            bov var10 = new bov((String)var8.getKey(), "inventory");
            bgl var11 = (bgl)this.h.get(var9);
            if (var11 != null && var11.d()) {
               if (this.c(var11)) {
                  this.n.a(var10, new bos(var11.g()));
               } else {
                  this.n.a(var10, this.a(var11, bor.a, false));
               }
            } else {
               c.warn("Missing model for: " + var9);
            }
         }

         return;
      }
   }

   private void a(bgm var1, bov var2) {
      this.i.put(var2, var1.b(var2.c()));
   }

   private void e() {
      this.u.put(zw.a(afi.b), Lists.newArrayList(new String[]{"stone", "granite", "granite_smooth", "diorite", "diorite_smooth", "andesite", "andesite_smooth"}));
      this.u.put(zw.a(afi.d), Lists.newArrayList(new String[]{"dirt", "coarse_dirt", "podzol"}));
      this.u.put(zw.a(afi.f), Lists.newArrayList(new String[]{"oak_planks", "spruce_planks", "birch_planks", "jungle_planks", "acacia_planks", "dark_oak_planks"}));
      this.u.put(zw.a(afi.g), Lists.newArrayList(new String[]{"oak_sapling", "spruce_sapling", "birch_sapling", "jungle_sapling", "acacia_sapling", "dark_oak_sapling"}));
      this.u.put(zw.a((afh)afi.m), Lists.newArrayList(new String[]{"sand", "red_sand"}));
      this.u.put(zw.a(afi.r), Lists.newArrayList(new String[]{"oak_log", "spruce_log", "birch_log", "jungle_log"}));
      this.u.put(zw.a((afh)afi.t), Lists.newArrayList(new String[]{"oak_leaves", "spruce_leaves", "birch_leaves", "jungle_leaves"}));
      this.u.put(zw.a(afi.v), Lists.newArrayList(new String[]{"sponge", "sponge_wet"}));
      this.u.put(zw.a(afi.A), Lists.newArrayList(new String[]{"sandstone", "chiseled_sandstone", "smooth_sandstone"}));
      this.u.put(zw.a(afi.cM), Lists.newArrayList(new String[]{"red_sandstone", "chiseled_red_sandstone", "smooth_red_sandstone"}));
      this.u.put(zw.a((afh)afi.H), Lists.newArrayList(new String[]{"dead_bush", "tall_grass", "fern"}));
      this.u.put(zw.a((afh)afi.I), Lists.newArrayList(new String[]{"dead_bush"}));
      this.u.put(zw.a(afi.L), Lists.newArrayList(new String[]{"black_wool", "red_wool", "green_wool", "brown_wool", "blue_wool", "purple_wool", "cyan_wool", "silver_wool", "gray_wool", "pink_wool", "lime_wool", "yellow_wool", "light_blue_wool", "magenta_wool", "orange_wool", "white_wool"}));
      this.u.put(zw.a((afh)afi.N), Lists.newArrayList(new String[]{"dandelion"}));
      this.u.put(zw.a((afh)afi.O), Lists.newArrayList(new String[]{"poppy", "blue_orchid", "allium", "houstonia", "red_tulip", "orange_tulip", "white_tulip", "pink_tulip", "oxeye_daisy"}));
      this.u.put(zw.a((afh)afi.U), Lists.newArrayList(new String[]{"stone_slab", "sandstone_slab", "cobblestone_slab", "brick_slab", "stone_brick_slab", "nether_brick_slab", "quartz_slab"}));
      this.u.put(zw.a((afh)afi.cP), Lists.newArrayList(new String[]{"red_sandstone_slab"}));
      this.u.put(zw.a((afh)afi.cG), Lists.newArrayList(new String[]{"black_stained_glass", "red_stained_glass", "green_stained_glass", "brown_stained_glass", "blue_stained_glass", "purple_stained_glass", "cyan_stained_glass", "silver_stained_glass", "gray_stained_glass", "pink_stained_glass", "lime_stained_glass", "yellow_stained_glass", "light_blue_stained_glass", "magenta_stained_glass", "orange_stained_glass", "white_stained_glass"}));
      this.u.put(zw.a(afi.be), Lists.newArrayList(new String[]{"stone_monster_egg", "cobblestone_monster_egg", "stone_brick_monster_egg", "mossy_brick_monster_egg", "cracked_brick_monster_egg", "chiseled_brick_monster_egg"}));
      this.u.put(zw.a(afi.bf), Lists.newArrayList(new String[]{"stonebrick", "mossy_stonebrick", "cracked_stonebrick", "chiseled_stonebrick"}));
      this.u.put(zw.a((afh)afi.bM), Lists.newArrayList(new String[]{"oak_slab", "spruce_slab", "birch_slab", "jungle_slab", "acacia_slab", "dark_oak_slab"}));
      this.u.put(zw.a(afi.bZ), Lists.newArrayList(new String[]{"cobblestone_wall", "mossy_cobblestone_wall"}));
      this.u.put(zw.a(afi.cf), Lists.newArrayList(new String[]{"anvil_intact", "anvil_slightly_damaged", "anvil_very_damaged"}));
      this.u.put(zw.a(afi.cq), Lists.newArrayList(new String[]{"quartz_block", "chiseled_quartz_block", "quartz_column"}));
      this.u.put(zw.a(afi.cu), Lists.newArrayList(new String[]{"black_stained_hardened_clay", "red_stained_hardened_clay", "green_stained_hardened_clay", "brown_stained_hardened_clay", "blue_stained_hardened_clay", "purple_stained_hardened_clay", "cyan_stained_hardened_clay", "silver_stained_hardened_clay", "gray_stained_hardened_clay", "pink_stained_hardened_clay", "lime_stained_hardened_clay", "yellow_stained_hardened_clay", "light_blue_stained_hardened_clay", "magenta_stained_hardened_clay", "orange_stained_hardened_clay", "white_stained_hardened_clay"}));
      this.u.put(zw.a((afh)afi.cH), Lists.newArrayList(new String[]{"black_stained_glass_pane", "red_stained_glass_pane", "green_stained_glass_pane", "brown_stained_glass_pane", "blue_stained_glass_pane", "purple_stained_glass_pane", "cyan_stained_glass_pane", "silver_stained_glass_pane", "gray_stained_glass_pane", "pink_stained_glass_pane", "lime_stained_glass_pane", "yellow_stained_glass_pane", "light_blue_stained_glass_pane", "magenta_stained_glass_pane", "orange_stained_glass_pane", "white_stained_glass_pane"}));
      this.u.put(zw.a((afh)afi.u), Lists.newArrayList(new String[]{"acacia_leaves", "dark_oak_leaves"}));
      this.u.put(zw.a(afi.s), Lists.newArrayList(new String[]{"acacia_log", "dark_oak_log"}));
      this.u.put(zw.a(afi.cI), Lists.newArrayList(new String[]{"prismarine", "prismarine_bricks", "dark_prismarine"}));
      this.u.put(zw.a(afi.cy), Lists.newArrayList(new String[]{"black_carpet", "red_carpet", "green_carpet", "brown_carpet", "blue_carpet", "purple_carpet", "cyan_carpet", "silver_carpet", "gray_carpet", "pink_carpet", "lime_carpet", "yellow_carpet", "light_blue_carpet", "magenta_carpet", "orange_carpet", "white_carpet"}));
      this.u.put(zw.a((afh)afi.cF), Lists.newArrayList(new String[]{"sunflower", "syringa", "double_grass", "double_fern", "double_rose", "paeonia"}));
      this.u.put(zy.f, Lists.newArrayList(new String[]{"bow", "bow_pulling_0", "bow_pulling_1", "bow_pulling_2"}));
      this.u.put(zy.h, Lists.newArrayList(new String[]{"coal", "charcoal"}));
      this.u.put(zy.aR, Lists.newArrayList(new String[]{"fishing_rod", "fishing_rod_cast"}));
      this.u.put(zy.aU, Lists.newArrayList(new String[]{"cod", "salmon", "clownfish", "pufferfish"}));
      this.u.put(zy.aV, Lists.newArrayList(new String[]{"cooked_cod", "cooked_salmon"}));
      this.u.put(zy.aW, Lists.newArrayList(new String[]{"dye_black", "dye_red", "dye_green", "dye_brown", "dye_blue", "dye_purple", "dye_cyan", "dye_silver", "dye_gray", "dye_pink", "dye_lime", "dye_yellow", "dye_light_blue", "dye_magenta", "dye_orange", "dye_white"}));
      this.u.put(zy.bz, Lists.newArrayList(new String[]{"bottle_drinkable", "bottle_splash"}));
      this.u.put(zy.bX, Lists.newArrayList(new String[]{"skull_skeleton", "skull_wither", "skull_zombie", "skull_char", "skull_creeper"}));
      this.u.put(zw.a(afi.bo), Lists.newArrayList(new String[]{"oak_fence_gate"}));
      this.u.put(zw.a(afi.aO), Lists.newArrayList(new String[]{"oak_fence"}));
      this.u.put(zy.aq, Lists.newArrayList(new String[]{"oak_door"}));
   }

   private void i() {
      ArrayDeque var1 = Queues.newArrayDeque();
      HashSet var2 = Sets.newHashSet();
      Iterator var3 = this.h.keySet().iterator();

      jy var5;
      while(var3.hasNext()) {
         jy var4 = (jy)var3.next();
         var2.add(var4);
         var5 = ((bgl)this.h.get(var4)).e();
         if (var5 != null) {
            var1.add(var5);
         }
      }

      while(!var1.isEmpty()) {
         jy var7 = (jy)var1.pop();

         try {
            if (this.h.get(var7) != null) {
               continue;
            }

            bgl var8 = this.c(var7);
            this.h.put(var7, var8);
            var5 = var8.e();
            if (var5 != null && !var2.contains(var5)) {
               var1.add(var5);
            }
         } catch (Exception var6) {
            c.warn("In parent chain: " + e.join(this.e(var7)) + "; unable to load model: '" + var7 + "'", var6);
         }

         var2.add(var7);
      }

   }

   private jy b(jy var1) {
      return new jy(var1.b(), "blockstates/" + var1.a() + ".json");
   }

   private jy a(String var1) {
      jy var2 = new jy(var1);
      return new jy(var2.b(), "item/" + var2.a());
   }
}
