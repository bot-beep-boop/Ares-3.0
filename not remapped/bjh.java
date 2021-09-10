import java.util.List;
import java.util.concurrent.Callable;

public class bjh implements bnj {
   private static final jy b = new jy("textures/misc/enchanted_item_glint.png");
   private final bmj e;
   private final bfo d;
   public float a;
   private boolean c = true;

   private void b(zx var1) {
      boq var2 = this.d.a(var1);
      zw var3 = var1.b();
      if (var3 != null) {
         boolean var4 = var2.c();
         if (!var4) {
            bfl.a(2.0F, 2.0F, 2.0F);
         }

         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      }
   }

   private void a(afh var1, String var2) {
      this.a((afh)var1, 0, (String)var2);
   }

   public void a(zx var1, int var2, int var3) {
      boq var4 = this.d.a(var1);
      bfl.E();
      this.e.a(bmh.g);
      this.e.b(bmh.g).b(false, false);
      bfl.B();
      bfl.d();
      bfl.a(516, 0.1F);
      bfl.l();
      bfl.b(770, 771);
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      this.a(var2, var3, var4.c());
      var4.f().a(bgr.b.e);
      this.a(var1, var4);
      bfl.c();
      bfl.C();
      bfl.f();
      bfl.F();
      this.e.a(bmh.g);
      this.e.b(bmh.g).a();
   }

   private void a(boq var1, zx var2) {
      this.a((boq)var1, -1, (zx)var2);
   }

   private void a(bfd var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      var1.a(7, bms.f);
      var1.b((double)var2, (double)var3, 0.0D).b(var6, var7, var8, var9).d();
      var1.b((double)var2, (double)(var3 + var5), 0.0D).b(var6, var7, var8, var9).d();
      var1.b((double)(var2 + var4), (double)(var3 + var5), 0.0D).b(var6, var7, var8, var9).d();
      var1.b((double)(var2 + var4), (double)var3, 0.0D).b(var6, var7, var8, var9).d();
      bfx.a().b();
   }

   public bjh(bmj var1, bou var2) {
      this.e = var1;
      this.d = new bfo(var2);
      this.b();
   }

   private void b() {
      this.a(afi.cf, "anvil_intact");
      this.a((afh)afi.cf, 1, (String)"anvil_slightly_damaged");
      this.a((afh)afi.cf, 2, (String)"anvil_very_damaged");
      this.a(afi.cy, zd.p.a(), "black_carpet");
      this.a(afi.cy, zd.l.a(), "blue_carpet");
      this.a(afi.cy, zd.m.a(), "brown_carpet");
      this.a(afi.cy, zd.j.a(), "cyan_carpet");
      this.a(afi.cy, zd.h.a(), "gray_carpet");
      this.a(afi.cy, zd.n.a(), "green_carpet");
      this.a(afi.cy, zd.d.a(), "light_blue_carpet");
      this.a(afi.cy, zd.f.a(), "lime_carpet");
      this.a(afi.cy, zd.c.a(), "magenta_carpet");
      this.a(afi.cy, zd.b.a(), "orange_carpet");
      this.a(afi.cy, zd.g.a(), "pink_carpet");
      this.a(afi.cy, zd.k.a(), "purple_carpet");
      this.a(afi.cy, zd.o.a(), "red_carpet");
      this.a(afi.cy, zd.i.a(), "silver_carpet");
      this.a(afi.cy, zd.a.a(), "white_carpet");
      this.a(afi.cy, zd.e.a(), "yellow_carpet");
      this.a(afi.bZ, akl.a.b.a(), "mossy_cobblestone_wall");
      this.a(afi.bZ, akl.a.a.a(), "cobblestone_wall");
      this.a(afi.d, agf.a.b.a(), "coarse_dirt");
      this.a(afi.d, agf.a.a.a(), "dirt");
      this.a(afi.d, agf.a.c.a(), "podzol");
      this.a((afh)afi.cF, agi.b.d.a(), (String)"double_fern");
      this.a((afh)afi.cF, agi.b.c.a(), (String)"double_grass");
      this.a((afh)afi.cF, agi.b.f.a(), (String)"paeonia");
      this.a((afh)afi.cF, agi.b.e.a(), (String)"double_rose");
      this.a((afh)afi.cF, agi.b.a.a(), (String)"sunflower");
      this.a((afh)afi.cF, agi.b.b.a(), (String)"syringa");
      this.a((afh)afi.t, aio.a.c.a(), (String)"birch_leaves");
      this.a((afh)afi.t, aio.a.d.a(), (String)"jungle_leaves");
      this.a((afh)afi.t, aio.a.a.a(), (String)"oak_leaves");
      this.a((afh)afi.t, aio.a.b.a(), (String)"spruce_leaves");
      this.a((afh)afi.u, aio.a.e.a() - 4, (String)"acacia_leaves");
      this.a((afh)afi.u, aio.a.f.a() - 4, (String)"dark_oak_leaves");
      this.a(afi.r, aio.a.c.a(), "birch_log");
      this.a(afi.r, aio.a.d.a(), "jungle_log");
      this.a(afi.r, aio.a.a.a(), "oak_log");
      this.a(afi.r, aio.a.b.a(), "spruce_log");
      this.a(afi.s, aio.a.e.a() - 4, "acacia_log");
      this.a(afi.s, aio.a.f.a() - 4, "dark_oak_log");
      this.a(afi.be, ahz.a.f.a(), "chiseled_brick_monster_egg");
      this.a(afi.be, ahz.a.b.a(), "cobblestone_monster_egg");
      this.a(afi.be, ahz.a.e.a(), "cracked_brick_monster_egg");
      this.a(afi.be, ahz.a.d.a(), "mossy_brick_monster_egg");
      this.a(afi.be, ahz.a.a.a(), "stone_monster_egg");
      this.a(afi.be, ahz.a.c.a(), "stone_brick_monster_egg");
      this.a(afi.f, aio.a.e.a(), "acacia_planks");
      this.a(afi.f, aio.a.c.a(), "birch_planks");
      this.a(afi.f, aio.a.f.a(), "dark_oak_planks");
      this.a(afi.f, aio.a.d.a(), "jungle_planks");
      this.a(afi.f, aio.a.a.a(), "oak_planks");
      this.a(afi.f, aio.a.b.a(), "spruce_planks");
      this.a(afi.cI, aiu.a.b.a(), "prismarine_bricks");
      this.a(afi.cI, aiu.a.c.a(), "dark_prismarine");
      this.a(afi.cI, aiu.a.a.a(), "prismarine");
      this.a(afi.cq, aiw.a.b.a(), "chiseled_quartz_block");
      this.a(afi.cq, aiw.a.a.a(), "quartz_block");
      this.a(afi.cq, aiw.a.c.a(), "quartz_column");
      this.a((afh)afi.O, agw.a.d.b(), (String)"allium");
      this.a((afh)afi.O, agw.a.c.b(), (String)"blue_orchid");
      this.a((afh)afi.O, agw.a.e.b(), (String)"houstonia");
      this.a((afh)afi.O, agw.a.g.b(), (String)"orange_tulip");
      this.a((afh)afi.O, agw.a.j.b(), (String)"oxeye_daisy");
      this.a((afh)afi.O, agw.a.i.b(), (String)"pink_tulip");
      this.a((afh)afi.O, agw.a.b.b(), (String)"poppy");
      this.a((afh)afi.O, agw.a.f.b(), (String)"red_tulip");
      this.a((afh)afi.O, agw.a.h.b(), (String)"white_tulip");
      this.a((afh)afi.m, ajh.a.b.a(), (String)"red_sand");
      this.a((afh)afi.m, ajh.a.a.a(), (String)"sand");
      this.a(afi.A, aji.a.b.a(), "chiseled_sandstone");
      this.a(afi.A, aji.a.a.a(), "sandstone");
      this.a(afi.A, aji.a.c.a(), "smooth_sandstone");
      this.a(afi.cM, aiz.a.b.a(), "chiseled_red_sandstone");
      this.a(afi.cM, aiz.a.a.a(), "red_sandstone");
      this.a(afi.cM, aiz.a.c.a(), "smooth_red_sandstone");
      this.a(afi.g, aio.a.e.a(), "acacia_sapling");
      this.a(afi.g, aio.a.c.a(), "birch_sapling");
      this.a(afi.g, aio.a.f.a(), "dark_oak_sapling");
      this.a(afi.g, aio.a.d.a(), "jungle_sapling");
      this.a(afi.g, aio.a.a.a(), "oak_sapling");
      this.a(afi.g, aio.a.b.a(), "spruce_sapling");
      this.a((afh)afi.v, 0, (String)"sponge");
      this.a((afh)afi.v, 1, (String)"sponge_wet");
      this.a((afh)afi.cG, zd.p.a(), (String)"black_stained_glass");
      this.a((afh)afi.cG, zd.l.a(), (String)"blue_stained_glass");
      this.a((afh)afi.cG, zd.m.a(), (String)"brown_stained_glass");
      this.a((afh)afi.cG, zd.j.a(), (String)"cyan_stained_glass");
      this.a((afh)afi.cG, zd.h.a(), (String)"gray_stained_glass");
      this.a((afh)afi.cG, zd.n.a(), (String)"green_stained_glass");
      this.a((afh)afi.cG, zd.d.a(), (String)"light_blue_stained_glass");
      this.a((afh)afi.cG, zd.f.a(), (String)"lime_stained_glass");
      this.a((afh)afi.cG, zd.c.a(), (String)"magenta_stained_glass");
      this.a((afh)afi.cG, zd.b.a(), (String)"orange_stained_glass");
      this.a((afh)afi.cG, zd.g.a(), (String)"pink_stained_glass");
      this.a((afh)afi.cG, zd.k.a(), (String)"purple_stained_glass");
      this.a((afh)afi.cG, zd.o.a(), (String)"red_stained_glass");
      this.a((afh)afi.cG, zd.i.a(), (String)"silver_stained_glass");
      this.a((afh)afi.cG, zd.a.a(), (String)"white_stained_glass");
      this.a((afh)afi.cG, zd.e.a(), (String)"yellow_stained_glass");
      this.a((afh)afi.cH, zd.p.a(), (String)"black_stained_glass_pane");
      this.a((afh)afi.cH, zd.l.a(), (String)"blue_stained_glass_pane");
      this.a((afh)afi.cH, zd.m.a(), (String)"brown_stained_glass_pane");
      this.a((afh)afi.cH, zd.j.a(), (String)"cyan_stained_glass_pane");
      this.a((afh)afi.cH, zd.h.a(), (String)"gray_stained_glass_pane");
      this.a((afh)afi.cH, zd.n.a(), (String)"green_stained_glass_pane");
      this.a((afh)afi.cH, zd.d.a(), (String)"light_blue_stained_glass_pane");
      this.a((afh)afi.cH, zd.f.a(), (String)"lime_stained_glass_pane");
      this.a((afh)afi.cH, zd.c.a(), (String)"magenta_stained_glass_pane");
      this.a((afh)afi.cH, zd.b.a(), (String)"orange_stained_glass_pane");
      this.a((afh)afi.cH, zd.g.a(), (String)"pink_stained_glass_pane");
      this.a((afh)afi.cH, zd.k.a(), (String)"purple_stained_glass_pane");
      this.a((afh)afi.cH, zd.o.a(), (String)"red_stained_glass_pane");
      this.a((afh)afi.cH, zd.i.a(), (String)"silver_stained_glass_pane");
      this.a((afh)afi.cH, zd.a.a(), (String)"white_stained_glass_pane");
      this.a((afh)afi.cH, zd.e.a(), (String)"yellow_stained_glass_pane");
      this.a(afi.cu, zd.p.a(), "black_stained_hardened_clay");
      this.a(afi.cu, zd.l.a(), "blue_stained_hardened_clay");
      this.a(afi.cu, zd.m.a(), "brown_stained_hardened_clay");
      this.a(afi.cu, zd.j.a(), "cyan_stained_hardened_clay");
      this.a(afi.cu, zd.h.a(), "gray_stained_hardened_clay");
      this.a(afi.cu, zd.n.a(), "green_stained_hardened_clay");
      this.a(afi.cu, zd.d.a(), "light_blue_stained_hardened_clay");
      this.a(afi.cu, zd.f.a(), "lime_stained_hardened_clay");
      this.a(afi.cu, zd.c.a(), "magenta_stained_hardened_clay");
      this.a(afi.cu, zd.b.a(), "orange_stained_hardened_clay");
      this.a(afi.cu, zd.g.a(), "pink_stained_hardened_clay");
      this.a(afi.cu, zd.k.a(), "purple_stained_hardened_clay");
      this.a(afi.cu, zd.o.a(), "red_stained_hardened_clay");
      this.a(afi.cu, zd.i.a(), "silver_stained_hardened_clay");
      this.a(afi.cu, zd.a.a(), "white_stained_hardened_clay");
      this.a(afi.cu, zd.e.a(), "yellow_stained_hardened_clay");
      this.a(afi.b, ajy.a.f.a(), "andesite");
      this.a(afi.b, ajy.a.g.a(), "andesite_smooth");
      this.a(afi.b, ajy.a.d.a(), "diorite");
      this.a(afi.b, ajy.a.e.a(), "diorite_smooth");
      this.a(afi.b, ajy.a.b.a(), "granite");
      this.a(afi.b, ajy.a.c.a(), "granite_smooth");
      this.a(afi.b, ajy.a.a.a(), "stone");
      this.a(afi.bf, ajz.a.c.a(), "cracked_stonebrick");
      this.a(afi.bf, ajz.a.a.a(), "stonebrick");
      this.a(afi.bf, ajz.a.d.a(), "chiseled_stonebrick");
      this.a(afi.bf, ajz.a.b.a(), "mossy_stonebrick");
      this.a((afh)afi.U, akb.a.e.a(), (String)"brick_slab");
      this.a((afh)afi.U, akb.a.d.a(), (String)"cobblestone_slab");
      this.a((afh)afi.U, akb.a.c.a(), (String)"old_wood_slab");
      this.a((afh)afi.U, akb.a.g.a(), (String)"nether_brick_slab");
      this.a((afh)afi.U, akb.a.h.a(), (String)"quartz_slab");
      this.a((afh)afi.U, akb.a.b.a(), (String)"sandstone_slab");
      this.a((afh)afi.U, akb.a.f.a(), (String)"stone_brick_slab");
      this.a((afh)afi.U, akb.a.a.a(), (String)"stone_slab");
      this.a((afh)afi.cP, aih.a.a.a(), (String)"red_sandstone_slab");
      this.a((afh)afi.H, akc.a.a.a(), (String)"dead_bush");
      this.a((afh)afi.H, akc.a.c.a(), (String)"fern");
      this.a((afh)afi.H, akc.a.b.a(), (String)"tall_grass");
      this.a((afh)afi.bM, aio.a.e.a(), (String)"acacia_slab");
      this.a((afh)afi.bM, aio.a.c.a(), (String)"birch_slab");
      this.a((afh)afi.bM, aio.a.f.a(), (String)"dark_oak_slab");
      this.a((afh)afi.bM, aio.a.d.a(), (String)"jungle_slab");
      this.a((afh)afi.bM, aio.a.a.a(), (String)"oak_slab");
      this.a((afh)afi.bM, aio.a.b.a(), (String)"spruce_slab");
      this.a(afi.L, zd.p.a(), "black_wool");
      this.a(afi.L, zd.l.a(), "blue_wool");
      this.a(afi.L, zd.m.a(), "brown_wool");
      this.a(afi.L, zd.j.a(), "cyan_wool");
      this.a(afi.L, zd.h.a(), "gray_wool");
      this.a(afi.L, zd.n.a(), "green_wool");
      this.a(afi.L, zd.d.a(), "light_blue_wool");
      this.a(afi.L, zd.f.a(), "lime_wool");
      this.a(afi.L, zd.c.a(), "magenta_wool");
      this.a(afi.L, zd.b.a(), "orange_wool");
      this.a(afi.L, zd.g.a(), "pink_wool");
      this.a(afi.L, zd.k.a(), "purple_wool");
      this.a(afi.L, zd.o.a(), "red_wool");
      this.a(afi.L, zd.i.a(), "silver_wool");
      this.a(afi.L, zd.a.a(), "white_wool");
      this.a(afi.L, zd.e.a(), "yellow_wool");
      this.a(afi.cC, "acacia_stairs");
      this.a(afi.cs, "activator_rail");
      this.a((afh)afi.bY, (String)"beacon");
      this.a(afi.h, "bedrock");
      this.a(afi.bV, "birch_stairs");
      this.a(afi.X, "bookshelf");
      this.a(afi.V, "brick_block");
      this.a(afi.V, "brick_block");
      this.a(afi.bu, "brick_stairs");
      this.a((afh)afi.P, (String)"brown_mushroom");
      this.a((afh)afi.aK, (String)"cactus");
      this.a(afi.aL, "clay");
      this.a(afi.cA, "coal_block");
      this.a(afi.q, "coal_ore");
      this.a(afi.e, "cobblestone");
      this.a(afi.ai, "crafting_table");
      this.a(afi.cD, "dark_oak_stairs");
      this.a((afh)afi.cl, (String)"daylight_detector");
      this.a((afh)afi.I, (String)"dead_bush");
      this.a(afi.E, "detector_rail");
      this.a(afi.ah, "diamond_block");
      this.a(afi.ag, "diamond_ore");
      this.a(afi.z, "dispenser");
      this.a(afi.ct, "dropper");
      this.a(afi.bT, "emerald_block");
      this.a(afi.bP, "emerald_ore");
      this.a(afi.bC, "enchanting_table");
      this.a(afi.bG, "end_portal_frame");
      this.a(afi.bH, "end_stone");
      this.a(afi.aO, "oak_fence");
      this.a(afi.aP, "spruce_fence");
      this.a(afi.aQ, "birch_fence");
      this.a(afi.aR, "jungle_fence");
      this.a(afi.aS, "dark_oak_fence");
      this.a(afi.aT, "acacia_fence");
      this.a(afi.bo, "oak_fence_gate");
      this.a(afi.bp, "spruce_fence_gate");
      this.a(afi.bq, "birch_fence_gate");
      this.a(afi.br, "jungle_fence_gate");
      this.a(afi.bs, "dark_oak_fence_gate");
      this.a(afi.bt, "acacia_fence_gate");
      this.a(afi.al, "furnace");
      this.a(afi.w, "glass");
      this.a(afi.bj, "glass_pane");
      this.a(afi.aX, "glowstone");
      this.a(afi.D, "golden_rail");
      this.a(afi.R, "gold_block");
      this.a(afi.o, "gold_ore");
      this.a((afh)afi.c, (String)"grass");
      this.a(afi.n, "gravel");
      this.a(afi.cz, "hardened_clay");
      this.a(afi.cx, "hay_block");
      this.a(afi.ci, "heavy_weighted_pressure_plate");
      this.a((afh)afi.cp, (String)"hopper");
      this.a(afi.aI, "ice");
      this.a(afi.bi, "iron_bars");
      this.a(afi.S, "iron_block");
      this.a(afi.p, "iron_ore");
      this.a(afi.cw, "iron_trapdoor");
      this.a(afi.aN, "jukebox");
      this.a(afi.bW, "jungle_stairs");
      this.a(afi.au, "ladder");
      this.a(afi.y, "lapis_block");
      this.a(afi.x, "lapis_ore");
      this.a(afi.ay, "lever");
      this.a(afi.ch, "light_weighted_pressure_plate");
      this.a(afi.aZ, "lit_pumpkin");
      this.a(afi.bk, "melon_block");
      this.a(afi.Y, "mossy_cobblestone");
      this.a((afh)afi.bw, (String)"mycelium");
      this.a(afi.aV, "netherrack");
      this.a(afi.by, "nether_brick");
      this.a(afi.bz, "nether_brick_fence");
      this.a(afi.bA, "nether_brick_stairs");
      this.a(afi.B, "noteblock");
      this.a(afi.ad, "oak_stairs");
      this.a(afi.Z, "obsidian");
      this.a(afi.cB, "packed_ice");
      this.a((afh)afi.J, (String)"piston");
      this.a(afi.aU, "pumpkin");
      this.a(afi.co, "quartz_ore");
      this.a(afi.cr, "quartz_stairs");
      this.a(afi.av, "rail");
      this.a(afi.cn, "redstone_block");
      this.a(afi.bJ, "redstone_lamp");
      this.a(afi.aC, "redstone_ore");
      this.a(afi.aF, "redstone_torch");
      this.a((afh)afi.Q, (String)"red_mushroom");
      this.a(afi.bO, "sandstone_stairs");
      this.a(afi.cN, "red_sandstone_stairs");
      this.a(afi.cJ, "sea_lantern");
      this.a(afi.cE, "slime");
      this.a(afi.aJ, "snow");
      this.a(afi.aH, "snow_layer");
      this.a(afi.aW, "soul_sand");
      this.a(afi.bU, "spruce_stairs");
      this.a((afh)afi.F, (String)"sticky_piston");
      this.a(afi.bv, "stone_brick_stairs");
      this.a(afi.aG, "stone_button");
      this.a(afi.az, "stone_pressure_plate");
      this.a(afi.aw, "stone_stairs");
      this.a(afi.W, "tnt");
      this.a(afi.aa, "torch");
      this.a(afi.bd, "trapdoor");
      this.a((afh)afi.bR, (String)"tripwire_hook");
      this.a(afi.bn, "vine");
      this.a(afi.bx, "waterlily");
      this.a(afi.G, "web");
      this.a(afi.cd, "wooden_button");
      this.a(afi.aB, "wooden_pressure_plate");
      this.a((afh)afi.N, agw.a.a.b(), (String)"dandelion");
      this.a((afh)afi.ae, (String)"chest");
      this.a(afi.cg, "trapped_chest");
      this.a(afi.bQ, "ender_chest");
      this.a(zy.a, "iron_shovel");
      this.a(zy.b, "iron_pickaxe");
      this.a(zy.c, "iron_axe");
      this.a(zy.d, "flint_and_steel");
      this.a(zy.e, "apple");
      this.a((zw)zy.f, 0, (String)"bow");
      this.a((zw)zy.f, 1, (String)"bow_pulling_0");
      this.a((zw)zy.f, 2, (String)"bow_pulling_1");
      this.a((zw)zy.f, 3, (String)"bow_pulling_2");
      this.a(zy.g, "arrow");
      this.a((zw)zy.h, 0, (String)"coal");
      this.a((zw)zy.h, 1, (String)"charcoal");
      this.a(zy.i, "diamond");
      this.a(zy.j, "iron_ingot");
      this.a(zy.k, "gold_ingot");
      this.a(zy.l, "iron_sword");
      this.a(zy.m, "wooden_sword");
      this.a(zy.n, "wooden_shovel");
      this.a(zy.o, "wooden_pickaxe");
      this.a(zy.p, "wooden_axe");
      this.a(zy.q, "stone_sword");
      this.a(zy.r, "stone_shovel");
      this.a(zy.s, "stone_pickaxe");
      this.a(zy.t, "stone_axe");
      this.a(zy.u, "diamond_sword");
      this.a(zy.v, "diamond_shovel");
      this.a(zy.w, "diamond_pickaxe");
      this.a(zy.x, "diamond_axe");
      this.a(zy.y, "stick");
      this.a(zy.z, "bowl");
      this.a(zy.A, "mushroom_stew");
      this.a(zy.B, "golden_sword");
      this.a(zy.C, "golden_shovel");
      this.a(zy.D, "golden_pickaxe");
      this.a(zy.E, "golden_axe");
      this.a(zy.F, "string");
      this.a(zy.G, "feather");
      this.a(zy.H, "gunpowder");
      this.a(zy.I, "wooden_hoe");
      this.a(zy.J, "stone_hoe");
      this.a(zy.K, "iron_hoe");
      this.a(zy.L, "diamond_hoe");
      this.a(zy.M, "golden_hoe");
      this.a(zy.N, "wheat_seeds");
      this.a(zy.O, "wheat");
      this.a(zy.P, "bread");
      this.a((zw)zy.Q, (String)"leather_helmet");
      this.a((zw)zy.R, (String)"leather_chestplate");
      this.a((zw)zy.S, (String)"leather_leggings");
      this.a((zw)zy.T, (String)"leather_boots");
      this.a((zw)zy.U, (String)"chainmail_helmet");
      this.a((zw)zy.V, (String)"chainmail_chestplate");
      this.a((zw)zy.W, (String)"chainmail_leggings");
      this.a((zw)zy.X, (String)"chainmail_boots");
      this.a((zw)zy.Y, (String)"iron_helmet");
      this.a((zw)zy.Z, (String)"iron_chestplate");
      this.a((zw)zy.aa, (String)"iron_leggings");
      this.a((zw)zy.ab, (String)"iron_boots");
      this.a((zw)zy.ac, (String)"diamond_helmet");
      this.a((zw)zy.ad, (String)"diamond_chestplate");
      this.a((zw)zy.ae, (String)"diamond_leggings");
      this.a((zw)zy.af, (String)"diamond_boots");
      this.a((zw)zy.ag, (String)"golden_helmet");
      this.a((zw)zy.ah, (String)"golden_chestplate");
      this.a((zw)zy.ai, (String)"golden_leggings");
      this.a((zw)zy.aj, (String)"golden_boots");
      this.a(zy.ak, "flint");
      this.a(zy.al, "porkchop");
      this.a(zy.am, "cooked_porkchop");
      this.a(zy.an, "painting");
      this.a(zy.ao, "golden_apple");
      this.a((zw)zy.ao, 1, (String)"golden_apple");
      this.a(zy.ap, "sign");
      this.a(zy.aq, "oak_door");
      this.a(zy.ar, "spruce_door");
      this.a(zy.as, "birch_door");
      this.a(zy.at, "jungle_door");
      this.a(zy.au, "acacia_door");
      this.a(zy.av, "dark_oak_door");
      this.a(zy.aw, "bucket");
      this.a(zy.ax, "water_bucket");
      this.a(zy.ay, "lava_bucket");
      this.a(zy.az, "minecart");
      this.a(zy.aA, "saddle");
      this.a(zy.aB, "iron_door");
      this.a(zy.aC, "redstone");
      this.a(zy.aD, "snowball");
      this.a(zy.aE, "boat");
      this.a(zy.aF, "leather");
      this.a(zy.aG, "milk_bucket");
      this.a(zy.aH, "brick");
      this.a(zy.aI, "clay_ball");
      this.a(zy.aJ, "reeds");
      this.a(zy.aK, "paper");
      this.a(zy.aL, "book");
      this.a(zy.aM, "slime_ball");
      this.a(zy.aN, "chest_minecart");
      this.a(zy.aO, "furnace_minecart");
      this.a(zy.aP, "egg");
      this.a(zy.aQ, "compass");
      this.a((zw)zy.aR, (String)"fishing_rod");
      this.a((zw)zy.aR, 1, (String)"fishing_rod_cast");
      this.a(zy.aS, "clock");
      this.a(zy.aT, "glowstone_dust");
      this.a(zy.aU, zp.a.a.a(), "cod");
      this.a(zy.aU, zp.a.b.a(), "salmon");
      this.a(zy.aU, zp.a.c.a(), "clownfish");
      this.a(zy.aU, zp.a.d.a(), "pufferfish");
      this.a(zy.aV, zp.a.a.a(), "cooked_cod");
      this.a(zy.aV, zp.a.b.a(), "cooked_salmon");
      this.a(zy.aW, zd.p.b(), "dye_black");
      this.a(zy.aW, zd.o.b(), "dye_red");
      this.a(zy.aW, zd.n.b(), "dye_green");
      this.a(zy.aW, zd.m.b(), "dye_brown");
      this.a(zy.aW, zd.l.b(), "dye_blue");
      this.a(zy.aW, zd.k.b(), "dye_purple");
      this.a(zy.aW, zd.j.b(), "dye_cyan");
      this.a(zy.aW, zd.i.b(), "dye_silver");
      this.a(zy.aW, zd.h.b(), "dye_gray");
      this.a(zy.aW, zd.g.b(), "dye_pink");
      this.a(zy.aW, zd.f.b(), "dye_lime");
      this.a(zy.aW, zd.e.b(), "dye_yellow");
      this.a(zy.aW, zd.d.b(), "dye_light_blue");
      this.a(zy.aW, zd.c.b(), "dye_magenta");
      this.a(zy.aW, zd.b.b(), "dye_orange");
      this.a(zy.aW, zd.a.b(), "dye_white");
      this.a(zy.aX, "bone");
      this.a(zy.aY, "sugar");
      this.a(zy.aZ, "cake");
      this.a(zy.ba, "bed");
      this.a(zy.bb, "repeater");
      this.a(zy.bc, "cookie");
      this.a((zw)zy.be, (String)"shears");
      this.a(zy.bf, "melon");
      this.a(zy.bg, "pumpkin_seeds");
      this.a(zy.bh, "melon_seeds");
      this.a(zy.bi, "beef");
      this.a(zy.bj, "cooked_beef");
      this.a(zy.bk, "chicken");
      this.a(zy.bl, "cooked_chicken");
      this.a(zy.bo, "rabbit");
      this.a(zy.bp, "cooked_rabbit");
      this.a(zy.bm, "mutton");
      this.a(zy.bn, "cooked_mutton");
      this.a(zy.br, "rabbit_foot");
      this.a(zy.bs, "rabbit_hide");
      this.a(zy.bq, "rabbit_stew");
      this.a(zy.bt, "rotten_flesh");
      this.a(zy.bu, "ender_pearl");
      this.a(zy.bv, "blaze_rod");
      this.a(zy.bw, "ghast_tear");
      this.a(zy.bx, "gold_nugget");
      this.a(zy.by, "nether_wart");
      this.d.a(zy.bz, new bfp(this) {
         final bjh a;

         {
            this.a = var1;
         }

         public bov a(zx var1) {
            return aai.f(var1.i()) ? new bov("bottle_splash", "inventory") : new bov("bottle_drinkable", "inventory");
         }
      });
      this.a(zy.bA, "glass_bottle");
      this.a(zy.bB, "spider_eye");
      this.a(zy.bC, "fermented_spider_eye");
      this.a(zy.bD, "blaze_powder");
      this.a(zy.bE, "magma_cream");
      this.a(zy.bF, "brewing_stand");
      this.a(zy.bG, "cauldron");
      this.a(zy.bH, "ender_eye");
      this.a(zy.bI, "speckled_melon");
      this.d.a(zy.bJ, new bfp(this) {
         final bjh a;

         public bov a(zx var1) {
            return new bov("spawn_egg", "inventory");
         }

         {
            this.a = var1;
         }
      });
      this.a(zy.bK, "experience_bottle");
      this.a(zy.bL, "fire_charge");
      this.a(zy.bM, "writable_book");
      this.a(zy.bO, "emerald");
      this.a(zy.bP, "item_frame");
      this.a(zy.bQ, "flower_pot");
      this.a(zy.bR, "carrot");
      this.a(zy.bS, "potato");
      this.a(zy.bT, "baked_potato");
      this.a(zy.bU, "poisonous_potato");
      this.a((zw)zy.bV, (String)"map");
      this.a(zy.bW, "golden_carrot");
      this.a((zw)zy.bX, 0, (String)"skull_skeleton");
      this.a((zw)zy.bX, 1, (String)"skull_wither");
      this.a((zw)zy.bX, 2, (String)"skull_zombie");
      this.a((zw)zy.bX, 3, (String)"skull_char");
      this.a((zw)zy.bX, 4, (String)"skull_creeper");
      this.a(zy.bY, "carrot_on_a_stick");
      this.a(zy.bZ, "nether_star");
      this.a(zy.ca, "pumpkin_pie");
      this.a(zy.cc, "firework_charge");
      this.a(zy.ce, "comparator");
      this.a(zy.cf, "netherbrick");
      this.a(zy.cg, "quartz");
      this.a(zy.ch, "tnt_minecart");
      this.a(zy.ci, "hopper_minecart");
      this.a((zw)zy.cj, (String)"armor_stand");
      this.a(zy.ck, "iron_horse_armor");
      this.a(zy.cl, "golden_horse_armor");
      this.a(zy.cm, "diamond_horse_armor");
      this.a(zy.cn, "lead");
      this.a(zy.co, "name_tag");
      this.d.a(zy.cE, new bfp(this) {
         final bjh a;

         public bov a(zx var1) {
            return new bov("banner", "inventory");
         }

         {
            this.a = var1;
         }
      });
      this.a(zy.cq, "record_13");
      this.a(zy.cr, "record_cat");
      this.a(zy.cs, "record_blocks");
      this.a(zy.ct, "record_chirp");
      this.a(zy.cu, "record_far");
      this.a(zy.cv, "record_mall");
      this.a(zy.cw, "record_mellohi");
      this.a(zy.cx, "record_stal");
      this.a(zy.cy, "record_strad");
      this.a(zy.cz, "record_ward");
      this.a(zy.cA, "record_11");
      this.a(zy.cB, "record_wait");
      this.a(zy.cC, "prismarine_shard");
      this.a(zy.cD, "prismarine_crystals");
      this.d.a(zy.cd, new bfp(this) {
         final bjh a;

         {
            this.a = var1;
         }

         public bov a(zx var1) {
            return new bov("enchanted_book", "inventory");
         }
      });
      this.d.a(zy.bd, new bfp(this) {
         final bjh a;

         {
            this.a = var1;
         }

         public bov a(zx var1) {
            return new bov("filled_map", "inventory");
         }
      });
      this.a(afi.bX, "command_block");
      this.a(zy.cb, "fireworks");
      this.a(zy.cp, "command_block_minecart");
      this.a(afi.cv, "barrier");
      this.a(afi.ac, "mob_spawner");
      this.a(zy.bN, "written_book");
      this.a(afi.bg, aho.a.k.a(), "brown_mushroom_block");
      this.a(afi.bh, aho.a.k.a(), "red_mushroom_block");
      this.a(afi.bI, "dragon_egg");
   }

   public void a(avn var1, zx var2, int var3, int var4) {
      this.a(var1, var2, var3, var4, (String)null);
   }

   private void a(bfd var1, List<bgg> var2, int var3, zx var4) {
      boolean var5 = var3 == -1 && var4 != null;
      int var6 = 0;

      for(int var7 = var2.size(); var6 < var7; ++var6) {
         bgg var8 = (bgg)var2.get(var6);
         int var9 = var3;
         if (var5 && var8.b()) {
            var9 = var4.b().a(var4, var8.c());
            if (bfk.a) {
               var9 = bml.c(var9);
            }

            var9 |= -16777216;
         }

         this.a(var1, var8, var9);
      }

   }

   protected void a(zw var1, int var2, String var3) {
      this.d.a(var1, var2, new bov(var3, "inventory"));
   }

   public void a(zx var1, boq var2) {
      if (var1 != null) {
         bfl.E();
         bfl.a(0.5F, 0.5F, 0.5F);
         if (var2.d()) {
            bfl.b(180.0F, 0.0F, 1.0F, 0.0F);
            bfl.b(-0.5F, -0.5F, -0.5F);
            bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
            bfl.B();
            bfi.a.a(var1);
         } else {
            bfl.b(-0.5F, -0.5F, -0.5F);
            this.a(var2, var1);
            if (var1.t()) {
               this.a(var2);
            }
         }

         bfl.F();
      }
   }

   public void a(zx var1, pr var2, bgr.b var3) {
      if (var1 != null && var2 != null) {
         boq var4 = this.d.a(var1);
         if (var2 instanceof wn) {
            wn var5 = (wn)var2;
            zw var6 = var1.b();
            bov var7 = null;
            if (var6 == zy.aR && var5.bG != null) {
               var7 = new bov("fishing_rod_cast", "inventory");
            } else if (var6 == zy.f && var5.bQ() != null) {
               int var8 = var1.l() - var5.bR();
               if (var8 >= 18) {
                  var7 = new bov("bow_pulling_2", "inventory");
               } else if (var8 > 13) {
                  var7 = new bov("bow_pulling_1", "inventory");
               } else if (var8 > 0) {
                  var7 = new bov("bow_pulling_0", "inventory");
               }
            }

            if (var7 != null) {
               var4 = this.d.a().a(var7);
            }
         }

         this.a(var1, var4, var3);
      }
   }

   protected void a(afh var1, int var2, String var3) {
      this.a(zw.a(var1), var2, var3);
   }

   public void a(zx var1, bgr.b var2) {
      if (var1 != null) {
         boq var3 = this.d.a(var1);
         this.a(var1, var3, var2);
      }
   }

   private void a(bfd var1, bgg var2, int var3) {
      var1.a(var2.a());
      var1.a(var3);
      this.a(var1, var2);
   }

   private void a(int var1, int var2, boolean var3) {
      bfl.b((float)var1, (float)var2, 100.0F + this.a);
      bfl.b(8.0F, 8.0F, 0.0F);
      bfl.a(1.0F, 1.0F, -1.0F);
      bfl.a(0.5F, 0.5F, 0.5F);
      if (var3) {
         bfl.a(40.0F, 40.0F, 40.0F);
         bfl.b(210.0F, 1.0F, 0.0F, 0.0F);
         bfl.b(-135.0F, 0.0F, 1.0F, 0.0F);
         bfl.e();
      } else {
         bfl.a(64.0F, 64.0F, 64.0F);
         bfl.b(180.0F, 1.0F, 0.0F, 0.0F);
         bfl.f();
      }

   }

   public bfo a() {
      return this.d;
   }

   public void a(avn var1, zx var2, int var3, int var4, String var5) {
      if (var2 != null) {
         if (var2.b != 1 || var5 != null) {
            String var6 = var5 == null ? String.valueOf(var2.b) : var5;
            if (var5 == null && var2.b < 1) {
               var6 = a.m + String.valueOf(var2.b);
            }

            bfl.f();
            bfl.i();
            bfl.k();
            var1.a(var6, (float)(var3 + 19 - 2 - var1.a(var6)), (float)(var4 + 6 + 3), 16777215);
            bfl.e();
            bfl.j();
         }

         if (var2.g()) {
            int var10 = (int)Math.round(13.0D - (double)var2.h() * 13.0D / (double)var2.j());
            int var7 = (int)Math.round(255.0D - (double)var2.h() * 255.0D / (double)var2.j());
            bfl.f();
            bfl.i();
            bfl.x();
            bfl.c();
            bfl.k();
            bfx var8 = bfx.a();
            bfd var9 = var8.c();
            this.a(var9, var3 + 2, var4 + 13, 13, 2, 0, 0, 0, 255);
            this.a(var9, var3 + 2, var4 + 13, 12, 1, (255 - var7) / 4, 64, 0, 255);
            this.a(var9, var3 + 2, var4 + 13, var10, 1, 255 - var7, var7, 0, 255);
            bfl.l();
            bfl.d();
            bfl.w();
            bfl.e();
            bfl.j();
         }

      }
   }

   private void a(boq var1, int var2, zx var3) {
      bfx var4 = bfx.a();
      bfd var5 = var4.c();
      var5.a(7, bms.b);
      cq[] var6 = cq.values();
      int var7 = var6.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         cq var9 = var6[var8];
         this.a(var5, var1.a(var9), var2, var3);
      }

      this.a(var5, var1.a(), var2, var3);
      var4.b();
   }

   public void a(boolean var1) {
      this.c = var1;
   }

   public void b(zx var1, int var2, int var3) {
      if (var1 != null && var1.b() != null) {
         this.a += 50.0F;

         try {
            this.a(var1, var2, var3);
         } catch (Throwable var7) {
            b var5 = b.a(var7, "Rendering item");
            c var6 = var5.a("Item being rendered");
            var6.a("Item Type", new Callable<String>(this, var1) {
               final bjh b;
               final zx a;

               public Object call() throws Exception {
                  return this.a();
               }

               {
                  this.b = var1;
                  this.a = var2;
               }

               public String a() throws Exception {
                  return String.valueOf(this.a.b());
               }
            });
            var6.a("Item Aux", new Callable<String>(this, var1) {
               final zx a;
               final bjh b;

               {
                  this.b = var1;
                  this.a = var2;
               }

               public String a() throws Exception {
                  return String.valueOf(this.a.i());
               }

               public Object call() throws Exception {
                  return this.a();
               }
            });
            var6.a("Item NBT", new Callable<String>(this, var1) {
               final bjh b;
               final zx a;

               {
                  this.b = var1;
                  this.a = var2;
               }

               public Object call() throws Exception {
                  return this.a();
               }

               public String a() throws Exception {
                  return String.valueOf(this.a.o());
               }
            });
            var6.a("Item Foil", new Callable<String>(this, var1) {
               final zx a;
               final bjh b;

               public String a() throws Exception {
                  return String.valueOf(this.a.t());
               }

               public Object call() throws Exception {
                  return this.a();
               }

               {
                  this.b = var1;
                  this.a = var2;
               }
            });
            throw new e(var5);
         }

         this.a -= 50.0F;
      }
   }

   private void a(zw var1, String var2) {
      this.a((zw)var1, 0, (String)var2);
   }

   private void a(boq var1, int var2) {
      this.a((boq)var1, var2, (zx)null);
   }

   protected void a(zx var1, boq var2, bgr.b var3) {
      this.e.a(bmh.g);
      this.e.b(bmh.g).b(false, false);
      this.b(var1);
      bfl.B();
      bfl.a(516, 0.1F);
      bfl.l();
      bfl.a(770, 771, 1, 0);
      bfl.E();
      bgr var4 = var2.f();
      var4.a(var3);
      if (this.a(var4.b(var3))) {
         bfl.e(1028);
      }

      this.a(var1, var2);
      bfl.e(1029);
      bfl.F();
      bfl.C();
      bfl.k();
      this.e.a(bmh.g);
      this.e.b(bmh.g).a();
   }

   private boolean a(bgq var1) {
      return var1.d.x < 0.0F ^ var1.d.y < 0.0F ^ var1.d.z < 0.0F;
   }

   public boolean a(zx var1) {
      boq var2 = this.d.a(var1);
      return var2 == null ? false : var2.c();
   }

   private void a(bfd var1, bgg var2) {
      df var3 = var2.d().m();
      var1.b((float)var3.n(), (float)var3.o(), (float)var3.p());
   }

   public void a(bni var1) {
      this.d.b();
   }

   private void a(boq var1) {
      bfl.a(false);
      bfl.c(514);
      bfl.f();
      bfl.b(768, 1);
      this.e.a(b);
      bfl.n(5890);
      bfl.E();
      bfl.a(8.0F, 8.0F, 8.0F);
      float var2 = (float)(ave.J() % 3000L) / 3000.0F / 8.0F;
      bfl.b(var2, 0.0F, 0.0F);
      bfl.b(-50.0F, 0.0F, 0.0F, 1.0F);
      this.a(var1, -8372020);
      bfl.F();
      bfl.E();
      bfl.a(8.0F, 8.0F, 8.0F);
      float var3 = (float)(ave.J() % 4873L) / 4873.0F / 8.0F;
      bfl.b(-var3, 0.0F, 0.0F);
      bfl.b(10.0F, 0.0F, 0.0F, 1.0F);
      this.a(var1, -8372020);
      bfl.F();
      bfl.n(5888);
      bfl.b(770, 771);
      bfl.e();
      bfl.c(515);
      bfl.a(true);
      this.e.a(bmh.g);
   }
}
