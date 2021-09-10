import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class afh {
   public static final co<jy, afh> c;
   public afh.b H;
   public static final afh.b n;
   public float L;
   public static final afh.b p;
   public static final afh.b l;
   protected int u;
   protected float w;
   protected double F;
   protected boolean r;
   protected boolean A;
   protected float x;
   protected boolean v;
   protected final arn K;
   private String O;
   public static final afh.b j;
   protected boolean y;
   public static final afh.b f;
   public static final afh.b i;
   protected boolean t;
   protected final ama M;
   private alz N;
   public static final afh.b e;
   protected double G;
   public float I;
   protected double B;
   protected final arm J;
   protected boolean z;
   private yz b;
   protected int s;
   public static final afh.b o;
   private static final jy a = new jy("air");
   protected double D;
   public static final afh.b m;
   protected double E;
   protected double C;
   public static final afh.b g;
   public static final afh.b q;
   public static final afh.b k;
   public static final afh.b h;
   public static final ct<alz> d;

   public static alz d(int var0) {
      int var1 = var0 & 4095;
      int var2 = var0 >> 12 & 15;
      return c(var1).a(var2);
   }

   public alz a(alz var1, adq var2, cj var3) {
      return var1;
   }

   public void a(adm var1, cj var2, pk var3, float var4) {
      var3.e(var4, 1.0F);
   }

   public boolean A() {
      return true;
   }

   public static void S() {
      a(0, (jy)a, (new aey()).c("air"));
      a(1, (String)"stone", (new ajy()).c(1.5F).b(10.0F).a(i).c("stone"));
      a(2, (String)"grass", (new ahe()).c(0.6F).a(h).c("grass"));
      a(3, (String)"dirt", (new agf()).c(0.5F).a(g).c("dirt"));
      afh var0 = (new afh(arm.e)).c(2.0F).b(10.0F).a(i).c("stonebrick").a(yz.b);
      a(4, (String)"cobblestone", var0);
      afh var1 = (new aio()).c(2.0F).b(5.0F).a(f).c("wood");
      a(5, (String)"planks", var1);
      a(6, (String)"sapling", (new ajj()).c(0.0F).a(h).c("sapling"));
      a(7, (String)"bedrock", (new afh(arm.e)).x().b(6000000.0F).a(i).c("bedrock").K().a(yz.b));
      a(8, (String)"flowing_water", (new agl(arm.h)).c(100.0F).e(3).c("water").K());
      a(9, (String)"water", (new ajw(arm.h)).c(100.0F).e(3).c("water").K());
      a(10, (String)"flowing_lava", (new agl(arm.i)).c(100.0F).a(1.0F).c("lava").K());
      a(11, (String)"lava", (new ajw(arm.i)).c(100.0F).a(1.0F).c("lava").K());
      a(12, (String)"sand", (new ajh()).c(0.5F).a(m).c("sand"));
      a(13, (String)"gravel", (new ahf()).c(0.6F).a(g).c("gravel"));
      a(14, (String)"gold_ore", (new aim()).c(3.0F).b(5.0F).a(i).c("oreGold"));
      a(15, (String)"iron_ore", (new aim()).c(3.0F).b(5.0F).a(i).c("oreIron"));
      a(16, (String)"coal_ore", (new aim()).c(3.0F).b(5.0F).a(i).c("oreCoal"));
      a(17, (String)"log", (new ail()).c("log"));
      a(18, (String)"leaves", (new aik()).c("leaves"));
      a(19, (String)"sponge", (new ajr()).c(0.6F).a(h).c("sponge"));
      a(20, (String)"glass", (new ahc(arm.s, false)).c(0.3F).a(k).c("glass"));
      a(21, (String)"lapis_ore", (new aim()).c(3.0F).b(5.0F).a(i).c("oreLapis"));
      a(22, (String)"lapis_block", (new afh(arm.f, arn.H)).c(3.0F).b(5.0F).a(i).c("blockLapis").a(yz.b));
      a(23, (String)"dispenser", (new agg()).c(3.5F).a(i).c("dispenser"));
      afh var2 = (new aji()).a(i).c(0.8F).c("sandStone");
      a(24, (String)"sandstone", var2);
      a(25, (String)"noteblock", (new aii()).c(0.8F).c("musicBlock"));
      a(26, (String)"bed", (new afg()).a(f).c(0.2F).c("bed").K());
      a(27, (String)"golden_rail", (new ais()).c(0.7F).a(j).c("goldenRail"));
      a(28, (String)"detector_rail", (new agc()).c(0.7F).a(j).c("detectorRail"));
      a(29, (String)"sticky_piston", (new als(true)).c("pistonStickyBase"));
      a(30, (String)"web", (new ako()).e(1).c(4.0F).c("web"));
      a(31, (String)"tallgrass", (new akc()).c(0.0F).a(h).c("tallgrass"));
      a(32, (String)"deadbush", (new agb()).c(0.0F).a(h).c("deadbush"));
      a(33, (String)"piston", (new als(false)).c("pistonBase"));
      a(34, (String)"piston_head", (new alt()).c("pistonBase"));
      a(35, (String)"wool", (new afv(arm.n)).c(0.8F).a(l).c("cloth"));
      a(36, (String)"piston_extension", new alv());
      a(37, (String)"yellow_flower", (new akt()).c(0.0F).a(h).c("flower1"));
      a(38, (String)"red_flower", (new aiy()).c(0.0F).a(h).c("flower2"));
      afh var3 = (new aia()).c(0.0F).a(h).a(0.125F).c("mushroom");
      a(39, (String)"brown_mushroom", var3);
      afh var4 = (new aia()).c(0.0F).a(h).c("mushroom");
      a(40, (String)"red_mushroom", var4);
      a(41, (String)"gold_block", (new afh(arm.f, arn.F)).c(3.0F).b(10.0F).a(j).c("blockGold").a(yz.b));
      a(42, (String)"iron_block", (new afh(arm.f, arn.h)).c(5.0F).b(10.0F).a(j).c("blockIron").a(yz.b));
      a(43, (String)"double_stone_slab", (new agz()).c(2.0F).b(10.0F).a(i).c("stoneSlab"));
      a(44, (String)"stone_slab", (new ahi()).c(2.0F).b(10.0F).a(i).c("stoneSlab"));
      afh var5 = (new afh(arm.e, arn.D)).c(2.0F).b(10.0F).a(i).c("brick").a(yz.b);
      a(45, (String)"brick_block", var5);
      a(46, (String)"tnt", (new ake()).c(0.0F).a(h).c("tnt"));
      a(47, (String)"bookshelf", (new afk()).c(1.5F).a(f).c("bookshelf"));
      a(48, (String)"mossy_cobblestone", (new afh(arm.e)).c(2.0F).b(10.0F).a(i).c("stoneMoss").a(yz.b));
      a(49, (String)"obsidian", (new aij()).c(50.0F).b(2000.0F).a(i).c("obsidian"));
      a(50, (String)"torch", (new akf()).c(0.0F).a(0.9375F).a(f).c("torch"));
      a(51, (String)"fire", (new agv()).c(0.0F).a(1.0F).a(l).c("fire").K());
      a(52, (String)"mob_spawner", (new ahy()).c(5.0F).a(j).c("mobSpawner").K());
      a(53, (String)"oak_stairs", (new aju(var1.Q().a(aio.a, aio.a.a))).c((String)"stairsWood"));
      a(54, (String)"chest", (new afs(0)).c(2.5F).a(f).c("chest"));
      a(55, (String)"redstone_wire", (new ajb()).c(0.0F).a(e).c("redstoneDust").K());
      a(56, (String)"diamond_ore", (new aim()).c(3.0F).b(5.0F).a(i).c("oreDiamond"));
      a(57, (String)"diamond_block", (new afh(arm.f, arn.G)).c(5.0F).b(10.0F).a(j).c("blockDiamond").a(yz.b));
      a(58, (String)"crafting_table", (new afy()).c(2.5F).a(f).c("workbench"));
      a(59, (String)"wheat", (new afz()).c((String)"crops"));
      afh var6 = (new ags()).c(0.6F).a(g).c("farmland");
      a(60, (String)"farmland", var6);
      a(61, (String)"furnace", (new ahb(false)).c(3.5F).a(i).c("furnace").a(yz.c));
      a(62, (String)"lit_furnace", (new ahb(true)).c(3.5F).a(i).a(0.875F).c("furnace"));
      a(63, (String)"standing_sign", (new ajv()).c(1.0F).a(f).c("sign").K());
      a(64, (String)"wooden_door", (new agh(arm.d)).c(3.0F).a(f).c("doorOak").K());
      a(65, (String)"ladder", (new ahr()).c(0.4F).a(o).c("ladder"));
      a(66, (String)"rail", (new aix()).c(0.7F).a(j).c("rail"));
      a(67, (String)"stone_stairs", (new aju(var0.Q())).c((String)"stairsStone"));
      a(68, (String)"wall_sign", (new akm()).c(1.0F).a(f).c("sign").K());
      a(69, (String)"lever", (new ahu()).c(0.5F).a(f).c("lever"));
      a(70, (String)"stone_pressure_plate", (new ait(arm.e, ait.a.b)).c(0.5F).a(i).c("pressurePlateStone"));
      a(71, (String)"iron_door", (new agh(arm.f)).c(5.0F).a(j).c("doorIron").K());
      a(72, (String)"wooden_pressure_plate", (new ait(arm.d, ait.a.a)).c(0.5F).a(f).c("pressurePlateWood"));
      a(73, (String)"redstone_ore", (new aja(false)).c(3.0F).b(5.0F).a(i).c("oreRedstone").a(yz.b));
      a(74, (String)"lit_redstone_ore", (new aja(true)).a(0.625F).c(3.0F).b(5.0F).a(i).c("oreRedstone"));
      a(75, (String)"unlit_redstone_torch", (new ajd(false)).c(0.0F).a(f).c("notGate"));
      a(76, (String)"redstone_torch", (new ajd(true)).c(0.0F).a(0.5F).a(f).c("notGate").a(yz.d));
      a(77, (String)"stone_button", (new aka()).c(0.5F).a(i).c("button"));
      a(78, (String)"snow_layer", (new ajp()).c(0.1F).a(n).c("snow").e(0));
      a(79, (String)"ice", (new ahp()).c(0.5F).e(3).a(k).c("ice"));
      a(80, (String)"snow", (new ajo()).c(0.2F).a(n).c("snow"));
      a(81, (String)"cactus", (new afo()).c(0.4F).a(l).c("cactus"));
      a(82, (String)"clay", (new aft()).c(0.6F).a(g).c("clay"));
      a(83, (String)"reeds", (new aje()).c(0.0F).a(h).c("reeds").K());
      a(84, (String)"jukebox", (new ahq()).c(2.0F).b(10.0F).a(i).c("jukebox"));
      a(85, (String)"fence", (new agt(arm.d, aio.a.a.c())).c(2.0F).b(5.0F).a(f).c("fence"));
      afh var7 = (new aiv()).c(1.0F).a(f).c("pumpkin");
      a(86, (String)"pumpkin", var7);
      a(87, (String)"netherrack", (new aie()).c(0.4F).a(i).c("hellrock"));
      a(88, (String)"soul_sand", (new ajq()).c(0.5F).a(m).c("hellsand"));
      a(89, (String)"glowstone", (new ahd(arm.s)).c(0.3F).a(k).a(1.0F).c("lightgem"));
      a(90, (String)"portal", (new aip()).c(-1.0F).a(k).a(0.75F).c("portal"));
      a(91, (String)"lit_pumpkin", (new aiv()).c(1.0F).a(f).a(1.0F).c("litpumpkin"));
      a(92, (String)"cake", (new afp()).c(0.5F).a(l).c("cake").K());
      a(93, (String)"unpowered_repeater", (new ajf(false)).c(0.0F).a(f).c("diode").K());
      a(94, (String)"powered_repeater", (new ajf(true)).c(0.0F).a(f).c("diode").K());
      a(95, (String)"stained_glass", (new ajs(arm.s)).c(0.3F).a(k).c("stainedGlass"));
      a(96, (String)"trapdoor", (new akh(arm.d)).c(3.0F).a(f).c("trapdoor").K());
      a(97, (String)"monster_egg", (new ahz()).c(0.75F).c("monsterStoneEgg"));
      afh var8 = (new ajz()).c(1.5F).b(10.0F).a(i).c("stonebricksmooth");
      a(98, (String)"stonebrick", var8);
      a(99, (String)"brown_mushroom_block", (new aho(arm.d, arn.l, var3)).c(0.2F).a(f).c("mushroom"));
      a(100, (String)"red_mushroom_block", (new aho(arm.d, arn.D, var4)).c(0.2F).a(f).c("mushroom"));
      a(101, (String)"iron_bars", (new akd(arm.f, true)).c(5.0F).b(10.0F).a(j).c("fenceIron"));
      a(102, (String)"glass_pane", (new akd(arm.s, false)).c(0.3F).a(k).c("thinGlass"));
      afh var9 = (new ahx()).c(1.0F).a(f).c("melon");
      a(103, (String)"melon_block", var9);
      a(104, (String)"pumpkin_stem", (new ajx(var7)).c(0.0F).a(f).c("pumpkinStem"));
      a(105, (String)"melon_stem", (new ajx(var9)).c(0.0F).a(f).c("pumpkinStem"));
      a(106, (String)"vine", (new akk()).c(0.2F).a(h).c("vine"));
      a(107, (String)"fence_gate", (new agu(aio.a.a)).c(2.0F).b(5.0F).a(f).c("fenceGate"));
      a(108, (String)"brick_stairs", (new aju(var5.Q())).c((String)"stairsBrick"));
      a(109, (String)"stone_brick_stairs", (new aju(var8.Q().a(ajz.a, ajz.a.a))).c((String)"stairsStoneBrickSmooth"));
      a(110, (String)"mycelium", (new aib()).c(0.6F).a(h).c("mycel"));
      a(111, (String)"waterlily", (new akn()).c(0.0F).a(h).c("waterlily"));
      afh var10 = (new aic()).c(2.0F).b(10.0F).a(i).c("netherBrick").a(yz.b);
      a(112, (String)"nether_brick", var10);
      a(113, (String)"nether_brick_fence", (new agt(arm.e, arn.K)).c(2.0F).b(10.0F).a(i).c("netherFence"));
      a(114, (String)"nether_brick_stairs", (new aju(var10.Q())).c((String)"stairsNetherBrick"));
      a(115, (String)"nether_wart", (new aid()).c((String)"netherStalk"));
      a(116, (String)"enchanting_table", (new agm()).c(5.0F).b(2000.0F).c("enchantmentTable"));
      a(117, (String)"brewing_stand", (new afl()).c(0.5F).a(0.125F).c("brewingStand"));
      a(118, (String)"cauldron", (new afr()).c(2.0F).c("cauldron"));
      a(119, (String)"end_portal", (new agn(arm.E)).c(-1.0F).b(6000000.0F));
      a(120, (String)"end_portal_frame", (new ago()).a(k).a(0.125F).c(-1.0F).c("endPortalFrame").b(6000000.0F).a(yz.c));
      a(121, (String)"end_stone", (new afh(arm.e, arn.d)).c(3.0F).b(15.0F).a(i).c("whiteStone").a(yz.b));
      a(122, (String)"dragon_egg", (new agj()).c(3.0F).b(15.0F).a(i).a(0.125F).c("dragonEgg"));
      a(123, (String)"redstone_lamp", (new ajc(false)).c(0.3F).a(k).c("redstoneLight").a(yz.d));
      a(124, (String)"lit_redstone_lamp", (new ajc(true)).c(0.3F).a(k).c("redstoneLight"));
      a(125, (String)"double_wooden_slab", (new aha()).c(2.0F).b(5.0F).a(f).c("woodSlab"));
      a(126, (String)"wooden_slab", (new ahk()).c(2.0F).b(5.0F).a(f).c("woodSlab"));
      a(127, (String)"cocoa", (new afu()).c(0.2F).b(5.0F).a(f).c("cocoa"));
      a(128, (String)"sandstone_stairs", (new aju(var2.Q().a(aji.a, aji.a.c))).c((String)"stairsSandStone"));
      a(129, (String)"emerald_ore", (new aim()).c(3.0F).b(5.0F).a(i).c("oreEmerald"));
      a(130, (String)"ender_chest", (new agp()).c(22.5F).b(1000.0F).a(i).c("enderChest").a(0.5F));
      a(131, (String)"tripwire_hook", (new akj()).c("tripWireSource"));
      a(132, (String)"tripwire", (new aki()).c("tripWire"));
      a(133, (String)"emerald_block", (new afh(arm.f, arn.I)).c(5.0F).b(10.0F).a(j).c("blockEmerald").a(yz.b));
      a(134, (String)"spruce_stairs", (new aju(var1.Q().a(aio.a, aio.a.b))).c((String)"stairsWoodSpruce"));
      a(135, (String)"birch_stairs", (new aju(var1.Q().a(aio.a, aio.a.c))).c((String)"stairsWoodBirch"));
      a(136, (String)"jungle_stairs", (new aju(var1.Q().a(aio.a, aio.a.d))).c((String)"stairsWoodJungle"));
      a(137, (String)"command_block", (new afw()).x().b(6000000.0F).c("commandBlock"));
      a(138, (String)"beacon", (new aff()).c("beacon").a(1.0F));
      a(139, (String)"cobblestone_wall", (new akl(var0)).c("cobbleWall"));
      a(140, (String)"flower_pot", (new agx()).c(0.0F).a(e).c("flowerPot"));
      a(141, (String)"carrots", (new afq()).c("carrots"));
      a(142, (String)"potatoes", (new aiq()).c("potatoes"));
      a(143, (String)"wooden_button", (new akq()).c(0.5F).a(f).c("button"));
      a(144, (String)"skull", (new ajm()).c(1.0F).a(i).c("skull"));
      a(145, (String)"anvil", (new aez()).c(5.0F).a(p).b(2000.0F).c("anvil"));
      a(146, (String)"trapped_chest", (new afs(1)).c(2.5F).a(f).c("chestTrap"));
      a(147, (String)"light_weighted_pressure_plate", (new akp(arm.f, 15, arn.F)).c(0.5F).a(f).c("weightedPlate_light"));
      a(148, (String)"heavy_weighted_pressure_plate", (new akp(arm.f, 150)).c(0.5F).a(f).c("weightedPlate_heavy"));
      a(149, (String)"unpowered_comparator", (new afx(false)).c(0.0F).a(f).c("comparator").K());
      a(150, (String)"powered_comparator", (new afx(true)).c(0.0F).a(0.625F).a(f).c("comparator").K());
      a(151, (String)"daylight_detector", new aga(false));
      a(152, (String)"redstone_block", (new air(arm.f, arn.f)).c(5.0F).b(10.0F).a(j).c("blockRedstone").a(yz.d));
      a(153, (String)"quartz_ore", (new aim(arn.K)).c(3.0F).b(5.0F).a(i).c("netherquartz"));
      a(154, (String)"hopper", (new ahn()).c(3.0F).b(8.0F).a(j).c("hopper"));
      afh var11 = (new aiw()).a(i).c(0.8F).c("quartzBlock");
      a(155, (String)"quartz_block", var11);
      a(156, (String)"quartz_stairs", (new aju(var11.Q().a(aiw.a, aiw.a.a))).c((String)"stairsQuartz"));
      a(157, (String)"activator_rail", (new ais()).c(0.7F).a(j).c("activatorRail"));
      a(158, (String)"dropper", (new agk()).c(3.5F).a(i).c("dropper"));
      a(159, (String)"stained_hardened_clay", (new afv(arm.e)).c(1.25F).b(7.0F).a(i).c("clayHardenedStained"));
      a(160, (String)"stained_glass_pane", (new ajt()).c(0.3F).a(k).c("thinStainedGlass"));
      a(161, (String)"leaves2", (new aif()).c("leaves"));
      a(162, (String)"log2", (new aig()).c("log"));
      a(163, (String)"acacia_stairs", (new aju(var1.Q().a(aio.a, aio.a.e))).c((String)"stairsWoodAcacia"));
      a(164, (String)"dark_oak_stairs", (new aju(var1.Q().a(aio.a, aio.a.f))).c((String)"stairsWoodDarkOak"));
      a(165, (String)"slime", (new ajn()).c("slime").a(q));
      a(166, (String)"barrier", (new afb()).c("barrier"));
      a(167, (String)"iron_trapdoor", (new akh(arm.f)).c(5.0F).a(j).c("ironTrapdoor").K());
      a(168, (String)"prismarine", (new aiu()).c(1.5F).b(10.0F).a(i).c("prismarine"));
      a(169, (String)"sea_lantern", (new ajk(arm.s)).c(0.3F).a(k).a(1.0F).c("seaLantern"));
      a(170, (String)"hay_block", (new ahm()).c(0.5F).a(h).c("hayBlock").a(yz.b));
      a(171, (String)"carpet", (new aks()).c(0.1F).a(l).c("woolCarpet").e(0));
      a(172, (String)"hardened_clay", (new ahl()).c(1.25F).b(7.0F).a(i).c("clayHardened"));
      a(173, (String)"coal_block", (new afh(arm.e, arn.E)).c(5.0F).b(10.0F).a(i).c("blockCoal").a(yz.b));
      a(174, (String)"packed_ice", (new ain()).c(0.5F).a(k).c("icePacked"));
      a(175, (String)"double_plant", new agi());
      a(176, (String)"standing_banner", (new afa.a()).c(1.0F).a(f).c("banner").K());
      a(177, (String)"wall_banner", (new afa.b()).c(1.0F).a(f).c("banner").K());
      a(178, (String)"daylight_detector_inverted", new aga(true));
      afh var12 = (new aiz()).a(i).c(0.8F).c("redSandStone");
      a(179, (String)"red_sandstone", var12);
      a(180, (String)"red_sandstone_stairs", (new aju(var12.Q().a(aiz.a, aiz.a.c))).c((String)"stairsRedSandStone"));
      a(181, (String)"double_stone_slab2", (new agy()).c(2.0F).b(10.0F).a(i).c("stoneSlab2"));
      a(182, (String)"stone_slab2", (new ahg()).c(2.0F).b(10.0F).a(i).c("stoneSlab2"));
      a(183, (String)"spruce_fence_gate", (new agu(aio.a.b)).c(2.0F).b(5.0F).a(f).c("spruceFenceGate"));
      a(184, (String)"birch_fence_gate", (new agu(aio.a.c)).c(2.0F).b(5.0F).a(f).c("birchFenceGate"));
      a(185, (String)"jungle_fence_gate", (new agu(aio.a.d)).c(2.0F).b(5.0F).a(f).c("jungleFenceGate"));
      a(186, (String)"dark_oak_fence_gate", (new agu(aio.a.f)).c(2.0F).b(5.0F).a(f).c("darkOakFenceGate"));
      a(187, (String)"acacia_fence_gate", (new agu(aio.a.e)).c(2.0F).b(5.0F).a(f).c("acaciaFenceGate"));
      a(188, (String)"spruce_fence", (new agt(arm.d, aio.a.b.c())).c(2.0F).b(5.0F).a(f).c("spruceFence"));
      a(189, (String)"birch_fence", (new agt(arm.d, aio.a.c.c())).c(2.0F).b(5.0F).a(f).c("birchFence"));
      a(190, (String)"jungle_fence", (new agt(arm.d, aio.a.d.c())).c(2.0F).b(5.0F).a(f).c("jungleFence"));
      a(191, (String)"dark_oak_fence", (new agt(arm.d, aio.a.f.c())).c(2.0F).b(5.0F).a(f).c("darkOakFence"));
      a(192, (String)"acacia_fence", (new agt(arm.d, aio.a.e.c())).c(2.0F).b(5.0F).a(f).c("acaciaFence"));
      a(193, (String)"spruce_door", (new agh(arm.d)).c(3.0F).a(f).c("doorSpruce").K());
      a(194, (String)"birch_door", (new agh(arm.d)).c(3.0F).a(f).c("doorBirch").K());
      a(195, (String)"jungle_door", (new agh(arm.d)).c(3.0F).a(f).c("doorJungle").K());
      a(196, (String)"acacia_door", (new agh(arm.d)).c(3.0F).a(f).c("doorAcacia").K());
      a(197, (String)"dark_oak_door", (new agh(arm.d)).c(3.0F).a(f).c("doorDarkOak").K());
      c.a();
      Iterator var13 = c.iterator();

      while(true) {
         afh var14;
         while(var13.hasNext()) {
            var14 = (afh)var13.next();
            if (var14.J == arm.a) {
               var14.v = false;
            } else {
               boolean var15 = false;
               boolean var16 = var14 instanceof aju;
               boolean var17 = var14 instanceof ahh;
               boolean var18 = var14 == var6;
               boolean var19 = var14.t;
               boolean var20 = var14.s == 0;
               if (var16 || var17 || var18 || var19 || var20) {
                  var15 = true;
               }

               var14.v = var15;
            }
         }

         var13 = c.iterator();

         while(var13.hasNext()) {
            var14 = (afh)var13.next();
            Iterator var21 = var14.P().a().iterator();

            while(var21.hasNext()) {
               alz var22 = (alz)var21.next();
               int var23 = c.b(var14) << 4 | var14.c(var22);
               d.a(var22, var23);
            }
         }

         return;
      }
   }

   public afh a(yz var1) {
      this.b = var1;
      return this;
   }

   public boolean a(alz var1, boolean var2) {
      return this.A();
   }

   public ama P() {
      return this.M;
   }

   public final double D() {
      return this.C;
   }

   public void a(adm var1, cj var2, alz var3, Random var4) {
      this.b(var1, var2, var3, var4);
   }

   public boolean a(adm var1, cj var2) {
      return false;
   }

   public String toString() {
      return "Block{" + c.c(this) + "}";
   }

   public static boolean a(afh var0, afh var1) {
      if (var0 != null && var1 != null) {
         return var0 == var1 ? true : var0.b(var1);
      } else {
         return false;
      }
   }

   public final double G() {
      return this.G;
   }

   public final int d(adq var1, cj var2) {
      return this.a((adq)var1, (cj)var2, 0);
   }

   public arn g(alz var1) {
      return this.K;
   }

   public afh(arm var1, arn var2) {
      this.y = true;
      this.H = e;
      this.I = 1.0F;
      this.L = 0.6F;
      this.J = var1;
      this.K = var2;
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      this.r = this.c();
      this.s = this.c() ? 255 : 0;
      this.t = !var1.b();
      this.M = this.e();
      this.j(this.M.b());
   }

   public zw c(adm var1, cj var2) {
      return zw.a(this);
   }

   public zw a(alz var1, Random var2, int var3) {
      return zw.a(this);
   }

   public int a(alz var1) {
      return 0;
   }

   protected afh b(float var1) {
      this.x = var1 * 3.0F;
      return this;
   }

   public afh c(String var1) {
      this.O = var1;
      return this;
   }

   public boolean a(adi var1) {
      return true;
   }

   public boolean g() {
      return !this.J.a() && !this.J.d();
   }

   private boolean c(aui var1) {
      if (var1 == null) {
         return false;
      } else {
         return var1.a >= this.B && var1.a <= this.E && var1.b >= this.C && var1.b <= this.F;
      }
   }

   public static int a(afh var0) {
      return c.b(var0);
   }

   public final double C() {
      return this.E;
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
   }

   public float h() {
      return this.u() ? 0.2F : 1.0F;
   }

   public boolean O() {
      return false;
   }

   public boolean b(adq var1, cj var2) {
      return !this.J.c();
   }

   public boolean b(adq var1, cj var2, cq var3) {
      return var1.p(var2).c().t().a();
   }

   public final double E() {
      return this.F;
   }

   protected afh c(float var1) {
      this.w = var1;
      if (this.x < var1 * 5.0F) {
         this.x = var1 * 5.0F;
      }

      return this;
   }

   private static void a(int var0, jy var1, afh var2) {
      c.a(var0, var1, var2);
   }

   public String a() {
      return "tile." + this.O;
   }

   public void a(adm var1, cj var2, alz var3, pk var4) {
   }

   public alz b(alz var1) {
      return var1;
   }

   private boolean b(aui var1) {
      if (var1 == null) {
         return false;
      } else {
         return var1.a >= this.B && var1.a <= this.E && var1.c >= this.D && var1.c <= this.G;
      }
   }

   public boolean z() {
      return this.A;
   }

   public int c(adq var1, cj var2) {
      afh var3 = var1.p(var2).c();
      int var4 = var1.b(var2, var3.r());
      if (var4 == 0 && var3 instanceof ahh) {
         var2 = var2.b();
         var3 = var1.p(var2).c();
         return var1.b(var2, var3.r());
      } else {
         return var4;
      }
   }

   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      return this.a(var7);
   }

   public static void a(adm var0, cj var1, zx var2) {
      if (!var0.D && var0.Q().b("doTileDrops")) {
         float var3 = 0.5F;
         double var4 = (double)(var0.s.nextFloat() * var3) + (double)(1.0F - var3) * 0.5D;
         double var6 = (double)(var0.s.nextFloat() * var3) + (double)(1.0F - var3) * 0.5D;
         double var8 = (double)(var0.s.nextFloat() * var3) + (double)(1.0F - var3) * 0.5D;
         uz var10 = new uz(var0, (double)var1.n() + var4, (double)var1.o() + var6, (double)var1.p() + var8, var2);
         var10.p();
         var0.d((pk)var10);
      }
   }

   public yz L() {
      return this.b;
   }

   public void b(adm var1, cj var2, alz var3) {
   }

   public int j(adm var1, cj var2) {
      return this.a(var1.p(var2));
   }

   public boolean a(adq var1, cj var2, cq var3) {
      if (var3 == cq.a && this.C > 0.0D) {
         return true;
      } else if (var3 == cq.b && this.F < 1.0D) {
         return true;
      } else if (var3 == cq.c && this.D > 0.0D) {
         return true;
      } else if (var3 == cq.d && this.G < 1.0D) {
         return true;
      } else if (var3 == cq.e && this.B > 0.0D) {
         return true;
      } else if (var3 == cq.f && this.E < 1.0D) {
         return true;
      } else {
         return !var1.p(var2).c().c();
      }
   }

   public boolean b(afh var1) {
      return this == var1;
   }

   public void a(adm var1, cj var2, adi var3) {
   }

   public aug b(adm var1, cj var2) {
      return new aug((double)var2.n() + this.B, (double)var2.o() + this.C, (double)var2.p() + this.D, (double)var2.n() + this.E, (double)var2.o() + this.F, (double)var2.p() + this.G);
   }

   public final alz Q() {
      return this.N;
   }

   public void a(adm var1, cj var2, alz var3, wn var4) {
   }

   public void c(adm var1, cj var2, alz var3) {
   }

   public static afh c(int var0) {
      return (afh)c.a(var0);
   }

   public aug a(adm var1, cj var2, alz var3) {
      return new aug((double)var2.n() + this.B, (double)var2.o() + this.C, (double)var2.p() + this.D, (double)var2.n() + this.E, (double)var2.o() + this.F, (double)var2.p() + this.G);
   }

   static {
      c = new co(a);
      d = new ct();
      e = new afh.b("stone", 1.0F, 1.0F);
      f = new afh.b("wood", 1.0F, 1.0F);
      g = new afh.b("gravel", 1.0F, 1.0F);
      h = new afh.b("grass", 1.0F, 1.0F);
      i = new afh.b("stone", 1.0F, 1.0F);
      j = new afh.b("stone", 1.0F, 1.5F);
      k = new afh.b("stone", 1.0F, 1.0F) {
         public String b() {
            return "step.stone";
         }

         public String a() {
            return "dig.glass";
         }
      };
      l = new afh.b("cloth", 1.0F, 1.0F);
      m = new afh.b("sand", 1.0F, 1.0F);
      n = new afh.b("snow", 1.0F, 1.0F);
      o = new afh.b("ladder", 1.0F, 1.0F) {
         public String a() {
            return "dig.wood";
         }
      };
      p = new afh.b("anvil", 0.3F, 1.0F) {
         public String b() {
            return "random.anvil_land";
         }

         public String a() {
            return "dig.stone";
         }
      };
      q = new afh.b("slime", 1.0F, 1.0F) {
         public String a() {
            return "mob.slime.big";
         }

         public String b() {
            return "mob.slime.big";
         }

         public String c() {
            return "mob.slime.small";
         }
      };
   }

   protected afh e(int var1) {
      this.s = var1;
      return this;
   }

   public int l(adm var1, cj var2) {
      return 0;
   }

   public boolean y() {
      return this.z;
   }

   public boolean J() {
      return this.y;
   }

   public void j() {
   }

   public boolean a(adm var1, cj var2, alz var3, int var4, int var5) {
      return false;
   }

   public void a(adm var1, cj var2, alz var3, aug var4, List<aug> var5, pk var6) {
      aug var7 = this.a(var1, var2, var3);
      if (var7 != null && var4.b(var7)) {
         var5.add(var7);
      }

   }

   public int a(int var1, Random var2) {
      return this.a(var2);
   }

   public void k(adm var1, cj var2) {
   }

   protected void b(adm var1, cj var2, int var3) {
      if (!var1.D) {
         while(var3 > 0) {
            int var4 = pp.a(var3);
            var3 -= var4;
            var1.d((pk)(new pp(var1, (double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D, var4)));
         }
      }

   }

   protected ama e() {
      return new ama(this, new amo[0]);
   }

   protected afh a(boolean var1) {
      this.z = var1;
      return this;
   }

   public boolean N() {
      return true;
   }

   protected afh K() {
      this.y = false;
      return this;
   }

   public float a(wn var1, adm var2, cj var3) {
      float var4 = this.g(var2, var3);
      if (var4 < 0.0F) {
         return 0.0F;
      } else {
         return !var1.b(this) ? var1.a(this) / var4 / 100.0F : var1.a(this) / var4 / 30.0F;
      }
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
   }

   public int h(alz var1) {
      return 16777215;
   }

   public static afh a(zw var0) {
      return var0 instanceof yo ? ((yo)var0).d() : null;
   }

   public void a(adm var1, cj var2, pk var3) {
   }

   public void a(adm var1, wn var2, cj var3, alz var4, akw var5) {
      var2.b(na.ab[a(this)]);
      var2.a(0.025F);
      if (this.I() && ack.e(var2)) {
         zx var7 = this.i(var4);
         if (var7 != null) {
            a(var1, var3, var7);
         }
      } else {
         int var6 = ack.f(var2);
         this.b(var1, var3, var4, var6);
      }

   }

   public int a(adq var1, cj var2, int var3) {
      return 16777215;
   }

   protected afh(arm var1) {
      this(var1, var1.r());
   }

   protected afh a(afh.b var1) {
      this.H = var1;
      return this;
   }

   public static afh b(String var0) {
      jy var1 = new jy(var0);
      if (c.d(var1)) {
         return (afh)c.a(var1);
      } else {
         try {
            return (afh)c.a(Integer.parseInt(var0));
         } catch (NumberFormatException var3) {
            return null;
         }
      }
   }

   public auh a(adm var1, cj var2, aui var3, aui var4) {
      this.a((adq)var1, (cj)var2);
      var3 = var3.b((double)(-var2.n()), (double)(-var2.o()), (double)(-var2.p()));
      var4 = var4.b((double)(-var2.n()), (double)(-var2.o()), (double)(-var2.p()));
      aui var5 = var3.a(var4, this.B);
      aui var6 = var3.a(var4, this.E);
      aui var7 = var3.b(var4, this.C);
      aui var8 = var3.b(var4, this.F);
      aui var9 = var3.c(var4, this.D);
      aui var10 = var3.c(var4, this.G);
      if (!this.a(var5)) {
         var5 = null;
      }

      if (!this.a(var6)) {
         var6 = null;
      }

      if (!this.b(var7)) {
         var7 = null;
      }

      if (!this.b(var8)) {
         var8 = null;
      }

      if (!this.c(var9)) {
         var9 = null;
      }

      if (!this.c(var10)) {
         var10 = null;
      }

      aui var11 = null;
      if (var5 != null && (var11 == null || var3.g(var5) < var3.g(var11))) {
         var11 = var5;
      }

      if (var6 != null && (var11 == null || var3.g(var6) < var3.g(var11))) {
         var11 = var6;
      }

      if (var7 != null && (var11 == null || var3.g(var7) < var3.g(var11))) {
         var11 = var7;
      }

      if (var8 != null && (var11 == null || var3.g(var8) < var3.g(var11))) {
         var11 = var8;
      }

      if (var9 != null && (var11 == null || var3.g(var9) < var3.g(var11))) {
         var11 = var9;
      }

      if (var10 != null && (var11 == null || var3.g(var10) < var3.g(var11))) {
         var11 = var10;
      }

      if (var11 == null) {
         return null;
      } else {
         cq var12 = null;
         if (var11 == var5) {
            var12 = cq.e;
         }

         if (var11 == var6) {
            var12 = cq.f;
         }

         if (var11 == var7) {
            var12 = cq.a;
         }

         if (var11 == var8) {
            var12 = cq.b;
         }

         if (var11 == var9) {
            var12 = cq.c;
         }

         if (var11 == var10) {
            var12 = cq.d;
         }

         return new auh(var11.b((double)var2.n(), (double)var2.o(), (double)var2.p()), var12, var2);
      }
   }

   public void a(adq var1, cj var2) {
   }

   protected afh a(float var1) {
      this.u = (int)(15.0F * var1);
      return this;
   }

   public final double F() {
      return this.D;
   }

   public int a(adq var1, cj var2, alz var3, cq var4) {
      return 0;
   }

   public static int f(alz var0) {
      afh var1 = var0.c();
      return a(var1) + (var1.c(var0) << 12);
   }

   public boolean v() {
      return this.J.k() && this.d() && !this.i();
   }

   public String f() {
      return di.a(this.a() + ".name");
   }

   protected zx i(alz var1) {
      int var2 = 0;
      zw var3 = zw.a(this);
      if (var3 != null && var3.k()) {
         var2 = this.c(var1);
      }

      return new zx(var3, 1, var2);
   }

   public int p() {
      return this.s;
   }

   public void d(adm var1, cj var2, alz var3) {
   }

   public void a(adm var1, cj var2, wn var3) {
   }

   public void a(adm var1, cj var2, alz var3, float var4, int var5) {
      if (!var1.D) {
         int var6 = this.a(var5, var1.s);

         for(int var7 = 0; var7 < var6; ++var7) {
            if (!(var1.s.nextFloat() > var4)) {
               zw var8 = this.a(var3, var1.s, var5);
               if (var8 != null) {
                  a(var1, var2, new zx(var8, 1, this.a(var3)));
               }
            }
         }

      }
   }

   public void a(adm var1, pk var2) {
      var2.w = 0.0D;
   }

   public void c(adm var1, cj var2, alz var3, Random var4) {
   }

   public boolean u() {
      return this.J.c() && this.d();
   }

   public int H() {
      return 16777215;
   }

   public int a(adm var1) {
      return 10;
   }

   protected final void j(alz var1) {
      this.N = var1;
   }

   protected afh x() {
      this.c(-1.0F);
      return this;
   }

   public boolean i() {
      return false;
   }

   protected boolean I() {
      return this.d() && !this.A;
   }

   public final double B() {
      return this.B;
   }

   private boolean a(aui var1) {
      if (var1 == null) {
         return false;
      } else {
         return var1.b >= this.C && var1.b <= this.F && var1.c >= this.D && var1.c <= this.G;
      }
   }

   public boolean d(adm var1, cj var2) {
      return var1.p(var2).c().J.j();
   }

   public int a(Random var1) {
      return 1;
   }

   public float g(adm var1, cj var2) {
      return this.w;
   }

   public boolean q() {
      return this.t;
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      var3.add(new zx(var1, 1, 0));
   }

   protected final void a(float var1, float var2, float var3, float var4, float var5, float var6) {
      this.B = (double)var1;
      this.C = (double)var2;
      this.D = (double)var3;
      this.E = (double)var4;
      this.F = (double)var5;
      this.G = (double)var6;
   }

   public int r() {
      return this.u;
   }

   public afh.a R() {
      return afh.a.a;
   }

   public boolean s() {
      return this.v;
   }

   public adf m() {
      return adf.a;
   }

   public void a(adm var1, cj var2, alz var3, pr var4, zx var5) {
   }

   public final void b(adm var1, cj var2, alz var3, int var4) {
      this.a(var1, var2, var3, 1.0F, var4);
   }

   public boolean M() {
      return false;
   }

   public boolean o() {
      return this.r;
   }

   public boolean a(adm var1, cj var2, cq var3, zx var4) {
      return this.b(var1, var2, var3);
   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      return false;
   }

   private static void a(int var0, String var1, afh var2) {
      a(var0, new jy(var1), var2);
   }

   public int c(alz var1) {
      if (var1 != null && !var1.a().isEmpty()) {
         throw new IllegalArgumentException("Don't know how to convert " + var1 + " back into data...");
      } else {
         return 0;
      }
   }

   public aui a(adm var1, cj var2, pk var3, aui var4) {
      return var4;
   }

   public boolean w() {
      return this.J.c() && this.d();
   }

   public boolean c() {
      return true;
   }

   public int b(adq var1, cj var2, alz var3, cq var4) {
      return 0;
   }

   public boolean b(adm var1, cj var2, cq var3) {
      return this.d(var1, var2);
   }

   public int k() {
      return this.J.m();
   }

   public boolean d() {
      return true;
   }

   public int b() {
      return 3;
   }

   public float a(pk var1) {
      return this.x / 5.0F;
   }

   public alz a(int var1) {
      return this.Q();
   }

   public arm t() {
      return this.J;
   }

   public static enum a {
      b;

      private static final afh.a[] d = new afh.a[]{a, b, c};
      c,
      a;
   }

   public static class b {
      public final float c;
      public final float b;
      public final String a;

      public String c() {
         return "step." + this.a;
      }

      public float d() {
         return this.b;
      }

      public String b() {
         return this.a();
      }

      public String a() {
         return "dig." + this.a;
      }

      public b(String var1, float var2, float var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      public float e() {
         return this.c;
      }
   }
}
