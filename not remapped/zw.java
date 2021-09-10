import com.google.common.base.Function;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class zw {
   protected boolean i;
   protected static Random g = new Random();
   private zw d;
   private int c;
   protected static final UUID f = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");
   protected boolean j;
   private yz b;
   private static final Map<afh, zw> a = Maps.newHashMap();
   private String l;
   protected int h = 64;
   private String k;
   public static final cx<jy, zw> e = new cx();

   public String a() {
      return "item." + this.l;
   }

   public zw c(int var1) {
      this.h = var1;
      return this;
   }

   public zw n() {
      this.i = true;
      return this;
   }

   public String e_(zx var1) {
      return "item." + this.l;
   }

   public float a(zx var1, afh var2) {
      return 1.0F;
   }

   public zx a(zx var1, adm var2, wn var3) {
      return var1;
   }

   public boolean m() {
      return this.c > 0 && !this.j;
   }

   public boolean a(zx var1, wn var2, pr var3) {
      return false;
   }

   public boolean f() {
      return false;
   }

   public boolean k() {
      return this.j;
   }

   public boolean a(zx var1, pr var2, pr var3) {
      return false;
   }

   public boolean b(afh var1) {
      return false;
   }

   public String j(zx var1) {
      return this.k;
   }

   public static zw d(String var0) {
      zw var1 = (zw)e.a(new jy(var0));
      if (var1 == null) {
         try {
            return b(Integer.parseInt(var0));
         } catch (NumberFormatException var3) {
         }
      }

      return var1;
   }

   public aba e(zx var1) {
      return aba.a;
   }

   public zw a(yz var1) {
      this.b = var1;
      return this;
   }

   public void a(zx var1, wn var2, List<String> var3, boolean var4) {
   }

   public int a(zx var1, int var2) {
      return 16777215;
   }

   public aaj g(zx var1) {
      return var1.w() ? aaj.c : aaj.a;
   }

   protected zw d(int var1) {
      this.c = var1;
      return this;
   }

   public int b() {
      return 0;
   }

   protected zw e(String var1) {
      this.k = var1;
      return this;
   }

   public boolean r() {
      return this.d != null;
   }

   public int a(int var1) {
      return 0;
   }

   private static void a(int var0, jy var1, zw var2) {
      e.a(var0, var1, var2);
   }

   public boolean f_(zx var1) {
      return this.j() == 1 && this.m();
   }

   public static zw b(int var0) {
      return (zw)e.a(var0);
   }

   public static int b(zw var0) {
      return var0 == null ? 0 : e.b(var0);
   }

   public static zw a(afh var0) {
      return (zw)a.get(var0);
   }

   public zw c(zw var1) {
      this.d = var1;
      return this;
   }

   protected auh a(adm var1, wn var2, boolean var3) {
      float var4 = var2.z;
      float var5 = var2.y;
      double var6 = var2.s;
      double var8 = var2.t + (double)var2.aS();
      double var10 = var2.u;
      aui var12 = new aui(var6, var8, var10);
      float var13 = ns.b(-var5 * 0.017453292F - 3.1415927F);
      float var14 = ns.a(-var5 * 0.017453292F - 3.1415927F);
      float var15 = -ns.b(-var4 * 0.017453292F);
      float var16 = ns.a(-var4 * 0.017453292F);
      float var17 = var14 * var15;
      float var19 = var13 * var15;
      double var20 = 5.0D;
      aui var22 = var12.b((double)var17 * var20, (double)var16 * var20, (double)var19 * var20);
      return var1.a(var12, var22, var3, !var3, false);
   }

   public int l() {
      return this.c;
   }

   protected static void a(afh var0, zw var1) {
      a(afh.a(var0), (jy)afh.c.c(var0), var1);
      a.put(var0, var1);
   }

   public int j() {
      return this.h;
   }

   public boolean s() {
      return false;
   }

   public String k(zx var1) {
      String var2 = this.e_(var1);
      return var2 == null ? "" : di.a(var2);
   }

   public zx b(zx var1, adm var2, wn var3) {
      return var1;
   }

   public Multimap<String, qd> i() {
      return HashMultimap.create();
   }

   public boolean a(zx var1, wn var2, adm var3, cj var4, cq var5, float var6, float var7, float var8) {
      return false;
   }

   public int d(zx var1) {
      return 0;
   }

   public yz c() {
      return this.b;
   }

   protected zw a(boolean var1) {
      this.j = var1;
      return this;
   }

   public static void t() {
      a((afh)afi.b, (zw)(new aae(afi.b, afi.b, new Function<zx, String>() {
         public String a(zx var1) {
            return ajy.a.a(var1.i()).d();
         }

         public Object apply(Object var1) {
            return this.a((zx)var1);
         }
      })).b("stone"));
      a((afh)afi.c, (zw)(new aaz(afi.c, false)));
      a((afh)afi.d, (zw)(new aae(afi.d, afi.d, new Function<zx, String>() {
         public Object apply(Object var1) {
            return this.a((zx)var1);
         }

         public String a(zx var1) {
            return agf.a.a(var1.i()).c();
         }
      })).b("dirt"));
      c(afi.e);
      a((afh)afi.f, (zw)(new aae(afi.f, afi.f, new Function<zx, String>() {
         public String a(zx var1) {
            return aio.a.a(var1.i()).d();
         }

         public Object apply(Object var1) {
            return this.a((zx)var1);
         }
      })).b("wood"));
      a((afh)afi.g, (zw)(new aae(afi.g, afi.g, new Function<zx, String>() {
         public String a(zx var1) {
            return aio.a.a(var1.i()).d();
         }

         public Object apply(Object var1) {
            return this.a((zx)var1);
         }
      })).b("sapling"));
      c(afi.h);
      a((afh)afi.m, (zw)(new aae(afi.m, afi.m, new Function<zx, String>() {
         public String a(zx var1) {
            return ajh.a.a(var1.i()).d();
         }

         public Object apply(Object var1) {
            return this.a((zx)var1);
         }
      })).b("sand"));
      c(afi.n);
      c(afi.o);
      c(afi.p);
      c(afi.q);
      a((afh)afi.r, (zw)(new aae(afi.r, afi.r, new Function<zx, String>() {
         public String a(zx var1) {
            return aio.a.a(var1.i()).d();
         }

         public Object apply(Object var1) {
            return this.a((zx)var1);
         }
      })).b("log"));
      a((afh)afi.s, (zw)(new aae(afi.s, afi.s, new Function<zx, String>() {
         public String a(zx var1) {
            return aio.a.a(var1.i() + 4).d();
         }

         public Object apply(Object var1) {
            return this.a((zx)var1);
         }
      })).b("log"));
      a((afh)afi.t, (zw)(new aaa(afi.t)).b("leaves"));
      a((afh)afi.u, (zw)(new aaa(afi.u)).b("leaves"));
      a((afh)afi.v, (zw)(new aae(afi.v, afi.v, new Function<zx, String>() {
         public Object apply(Object var1) {
            return this.a((zx)var1);
         }

         public String a(zx var1) {
            return (var1.i() & 1) == 1 ? "wet" : "dry";
         }
      })).b("sponge"));
      c(afi.w);
      c(afi.x);
      c(afi.y);
      c(afi.z);
      a((afh)afi.A, (zw)(new aae(afi.A, afi.A, new Function<zx, String>() {
         public String a(zx var1) {
            return aji.a.a(var1.i()).c();
         }

         public Object apply(Object var1) {
            return this.a((zx)var1);
         }
      })).b("sandStone"));
      c(afi.B);
      c(afi.D);
      c(afi.E);
      a((afh)afi.F, (zw)(new aah(afi.F)));
      c(afi.G);
      a((afh)afi.H, (zw)(new aaz(afi.H, true)).a(new String[]{"shrub", "grass", "fern"}));
      c((afh)afi.I);
      a((afh)afi.J, (zw)(new aah(afi.J)));
      a((afh)afi.L, (zw)(new zf(afi.L)).b("cloth"));
      a((afh)afi.N, (zw)(new aae(afi.N, afi.N, new Function<zx, String>() {
         public Object apply(Object var1) {
            return this.a((zx)var1);
         }

         public String a(zx var1) {
            return agw.a.a(agw.b.a, var1.i()).d();
         }
      })).b("flower"));
      a((afh)afi.O, (zw)(new aae(afi.O, afi.O, new Function<zx, String>() {
         public String a(zx var1) {
            return agw.a.a(agw.b.b, var1.i()).d();
         }

         public Object apply(Object var1) {
            return this.a((zx)var1);
         }
      })).b("rose"));
      c((afh)afi.P);
      c((afh)afi.Q);
      c(afi.R);
      c(afi.S);
      a((afh)afi.U, (zw)(new aau(afi.U, afi.U, afi.T)).b("stoneSlab"));
      c(afi.V);
      c(afi.W);
      c(afi.X);
      c(afi.Y);
      c(afi.Z);
      c(afi.aa);
      c(afi.ac);
      c(afi.ad);
      c((afh)afi.ae);
      c(afi.ag);
      c(afi.ah);
      c(afi.ai);
      c(afi.ak);
      c(afi.al);
      c(afi.am);
      c(afi.au);
      c(afi.av);
      c(afi.aw);
      c(afi.ay);
      c(afi.az);
      c(afi.aB);
      c(afi.aC);
      c(afi.aF);
      c(afi.aG);
      a((afh)afi.aH, (zw)(new aav(afi.aH)));
      c(afi.aI);
      c(afi.aJ);
      c((afh)afi.aK);
      c(afi.aL);
      c(afi.aN);
      c(afi.aO);
      c(afi.aP);
      c(afi.aQ);
      c(afi.aR);
      c(afi.aS);
      c(afi.aT);
      c(afi.aU);
      c(afi.aV);
      c(afi.aW);
      c(afi.aX);
      c(afi.aZ);
      c(afi.bd);
      a((afh)afi.be, (zw)(new aae(afi.be, afi.be, new Function<zx, String>() {
         public String a(zx var1) {
            return ahz.a.a(var1.i()).c();
         }

         public Object apply(Object var1) {
            return this.a((zx)var1);
         }
      })).b("monsterStoneEgg"));
      a((afh)afi.bf, (zw)(new aae(afi.bf, afi.bf, new Function<zx, String>() {
         public String a(zx var1) {
            return ajz.a.a(var1.i()).c();
         }

         public Object apply(Object var1) {
            return this.a((zx)var1);
         }
      })).b("stonebricksmooth"));
      c(afi.bg);
      c(afi.bh);
      c(afi.bi);
      c(afi.bj);
      c(afi.bk);
      a((afh)afi.bn, (zw)(new aaz(afi.bn, false)));
      c(afi.bo);
      c(afi.bp);
      c(afi.bq);
      c(afi.br);
      c(afi.bs);
      c(afi.bt);
      c(afi.bu);
      c(afi.bv);
      c((afh)afi.bw);
      a((afh)afi.bx, (zw)(new abb(afi.bx)));
      c(afi.by);
      c(afi.bz);
      c(afi.bA);
      c(afi.bC);
      c(afi.bG);
      c(afi.bH);
      c(afi.bI);
      c(afi.bJ);
      a((afh)afi.bM, (zw)(new aau(afi.bM, afi.bM, afi.bL)).b("woodSlab"));
      c(afi.bO);
      c(afi.bP);
      c(afi.bQ);
      c((afh)afi.bR);
      c(afi.bT);
      c(afi.bU);
      c(afi.bV);
      c(afi.bW);
      c(afi.bX);
      c((afh)afi.bY);
      a((afh)afi.bZ, (zw)(new aae(afi.bZ, afi.bZ, new Function<zx, String>() {
         public String a(zx var1) {
            return akl.a.a(var1.i()).c();
         }

         public Object apply(Object var1) {
            return this.a((zx)var1);
         }
      })).b("cobbleWall"));
      c(afi.cd);
      a((afh)afi.cf, (zw)(new yi(afi.cf)).b("anvil"));
      c(afi.cg);
      c(afi.ch);
      c(afi.ci);
      c((afh)afi.cl);
      c(afi.cn);
      c(afi.co);
      c((afh)afi.cp);
      a((afh)afi.cq, (zw)(new aae(afi.cq, afi.cq, new String[]{"default", "chiseled", "lines"})).b("quartzBlock"));
      c(afi.cr);
      c(afi.cs);
      c(afi.ct);
      a((afh)afi.cu, (zw)(new zf(afi.cu)).b("clayHardenedStained"));
      c(afi.cv);
      c(afi.cw);
      c(afi.cx);
      a((afh)afi.cy, (zw)(new zf(afi.cy)).b("woolCarpet"));
      c(afi.cz);
      c(afi.cA);
      c(afi.cB);
      c(afi.cC);
      c(afi.cD);
      c(afi.cE);
      a((afh)afi.cF, (zw)(new zc(afi.cF, afi.cF, new Function<zx, String>() {
         public String a(zx var1) {
            return agi.b.a(var1.i()).c();
         }

         public Object apply(Object var1) {
            return this.a((zx)var1);
         }
      })).b("doublePlant"));
      a((afh)afi.cG, (zw)(new zf(afi.cG)).b("stainedGlass"));
      a((afh)afi.cH, (zw)(new zf(afi.cH)).b("stainedGlassPane"));
      a((afh)afi.cI, (zw)(new aae(afi.cI, afi.cI, new Function<zx, String>() {
         public Object apply(Object var1) {
            return this.a((zx)var1);
         }

         public String a(zx var1) {
            return aiu.a.a(var1.i()).c();
         }
      })).b("prismarine"));
      c(afi.cJ);
      a((afh)afi.cM, (zw)(new aae(afi.cM, afi.cM, new Function<zx, String>() {
         public String a(zx var1) {
            return aiz.a.a(var1.i()).c();
         }

         public Object apply(Object var1) {
            return this.a((zx)var1);
         }
      })).b("redSandStone"));
      c(afi.cN);
      a((afh)afi.cP, (zw)(new aau(afi.cP, afi.cP, afi.cO)).b("stoneSlab2"));
      a(256, (String)"iron_shovel", (new aaq(zw.a.c)).c("shovelIron"));
      a(257, (String)"iron_pickaxe", (new aag(zw.a.c)).c("pickaxeIron"));
      a(258, (String)"iron_axe", (new yl(zw.a.c)).c("hatchetIron"));
      a(259, (String)"flint_and_steel", (new zr()).c("flintAndSteel"));
      a(260, (String)"apple", (new zs(4, 0.3F, false)).c("apple"));
      a(261, (String)"bow", (new yt()).c("bow"));
      a(262, (String)"arrow", (new zw()).c("arrow").a(yz.j));
      a(263, (String)"coal", (new yx()).c("coal"));
      a(264, (String)"diamond", (new zw()).c("diamond").a(yz.l));
      a(265, (String)"iron_ingot", (new zw()).c("ingotIron").a(yz.l));
      a(266, (String)"gold_ingot", (new zw()).c("ingotGold").a(yz.l));
      a(267, (String)"iron_sword", (new aay(zw.a.c)).c("swordIron"));
      a(268, (String)"wooden_sword", (new aay(zw.a.a)).c("swordWood"));
      a(269, (String)"wooden_shovel", (new aaq(zw.a.a)).c("shovelWood"));
      a(270, (String)"wooden_pickaxe", (new aag(zw.a.a)).c("pickaxeWood"));
      a(271, (String)"wooden_axe", (new yl(zw.a.a)).c("hatchetWood"));
      a(272, (String)"stone_sword", (new aay(zw.a.b)).c("swordStone"));
      a(273, (String)"stone_shovel", (new aaq(zw.a.b)).c("shovelStone"));
      a(274, (String)"stone_pickaxe", (new aag(zw.a.b)).c("pickaxeStone"));
      a(275, (String)"stone_axe", (new yl(zw.a.b)).c("hatchetStone"));
      a(276, (String)"diamond_sword", (new aay(zw.a.d)).c("swordDiamond"));
      a(277, (String)"diamond_shovel", (new aaq(zw.a.d)).c("shovelDiamond"));
      a(278, (String)"diamond_pickaxe", (new aag(zw.a.d)).c("pickaxeDiamond"));
      a(279, (String)"diamond_axe", (new yl(zw.a.d)).c("hatchetDiamond"));
      a(280, (String)"stick", (new zw()).n().c("stick").a(yz.l));
      a(281, (String)"bowl", (new zw()).c("bowl").a(yz.l));
      a(282, (String)"mushroom_stew", (new yu(6)).c("mushroomStew"));
      a(283, (String)"golden_sword", (new aay(zw.a.e)).c("swordGold"));
      a(284, (String)"golden_shovel", (new aaq(zw.a.e)).c("shovelGold"));
      a(285, (String)"golden_pickaxe", (new aag(zw.a.e)).c("pickaxeGold"));
      a(286, (String)"golden_axe", (new yl(zw.a.e)).c("hatchetGold"));
      a(287, (String)"string", (new yp(afi.bS)).c("string").a(yz.l));
      a(288, (String)"feather", (new zw()).c("feather").a(yz.l));
      a(289, (String)"gunpowder", (new zw()).c("sulphur").e(abe.k).a(yz.l));
      a(290, (String)"wooden_hoe", (new zv(zw.a.a)).c("hoeWood"));
      a(291, (String)"stone_hoe", (new zv(zw.a.b)).c("hoeStone"));
      a(292, (String)"iron_hoe", (new zv(zw.a.c)).c("hoeIron"));
      a(293, (String)"diamond_hoe", (new zv(zw.a.d)).c("hoeDiamond"));
      a(294, (String)"golden_hoe", (new zv(zw.a.e)).c("hoeGold"));
      a(295, (String)"wheat_seeds", (new aao(afi.aj, afi.ak)).c("seeds"));
      a(296, (String)"wheat", (new zw()).c("wheat").a(yz.l));
      a(297, (String)"bread", (new zs(5, 0.6F, false)).c("bread"));
      a(298, (String)"leather_helmet", (new yj(yj.a.a, 0, 0)).c("helmetCloth"));
      a(299, (String)"leather_chestplate", (new yj(yj.a.a, 0, 1)).c("chestplateCloth"));
      a(300, (String)"leather_leggings", (new yj(yj.a.a, 0, 2)).c("leggingsCloth"));
      a(301, (String)"leather_boots", (new yj(yj.a.a, 0, 3)).c("bootsCloth"));
      a(302, (String)"chainmail_helmet", (new yj(yj.a.b, 1, 0)).c("helmetChain"));
      a(303, (String)"chainmail_chestplate", (new yj(yj.a.b, 1, 1)).c("chestplateChain"));
      a(304, (String)"chainmail_leggings", (new yj(yj.a.b, 1, 2)).c("leggingsChain"));
      a(305, (String)"chainmail_boots", (new yj(yj.a.b, 1, 3)).c("bootsChain"));
      a(306, (String)"iron_helmet", (new yj(yj.a.c, 2, 0)).c("helmetIron"));
      a(307, (String)"iron_chestplate", (new yj(yj.a.c, 2, 1)).c("chestplateIron"));
      a(308, (String)"iron_leggings", (new yj(yj.a.c, 2, 2)).c("leggingsIron"));
      a(309, (String)"iron_boots", (new yj(yj.a.c, 2, 3)).c("bootsIron"));
      a(310, (String)"diamond_helmet", (new yj(yj.a.e, 3, 0)).c("helmetDiamond"));
      a(311, (String)"diamond_chestplate", (new yj(yj.a.e, 3, 1)).c("chestplateDiamond"));
      a(312, (String)"diamond_leggings", (new yj(yj.a.e, 3, 2)).c("leggingsDiamond"));
      a(313, (String)"diamond_boots", (new yj(yj.a.e, 3, 3)).c("bootsDiamond"));
      a(314, (String)"golden_helmet", (new yj(yj.a.d, 4, 0)).c("helmetGold"));
      a(315, (String)"golden_chestplate", (new yj(yj.a.d, 4, 1)).c("chestplateGold"));
      a(316, (String)"golden_leggings", (new yj(yj.a.d, 4, 2)).c("leggingsGold"));
      a(317, (String)"golden_boots", (new yj(yj.a.d, 4, 3)).c("bootsGold"));
      a(318, (String)"flint", (new zw()).c("flint").a(yz.l));
      a(319, (String)"porkchop", (new zs(3, 0.3F, true)).c("porkchopRaw"));
      a(320, (String)"cooked_porkchop", (new zs(8, 0.8F, true)).c("porkchopCooked"));
      a(321, (String)"painting", (new zu(uq.class)).c("painting"));
      a(322, (String)"golden_apple", (new zt(4, 1.2F, false)).h().a(pe.l.H, 5, 1, 1.0F).c("appleGold"));
      a(323, (String)"sign", (new aar()).c("sign"));
      a(324, (String)"wooden_door", (new zb(afi.ao)).c("doorOak"));
      zw var0 = (new yv(afi.a)).c("bucket").c(16);
      a(325, (String)"bucket", var0);
      a(326, (String)"water_bucket", (new yv(afi.i)).c("bucketWater").c(var0));
      a(327, (String)"lava_bucket", (new yv(afi.k)).c("bucketLava").c(var0));
      a(328, (String)"minecart", (new aad(va.a.a)).c("minecart"));
      a(329, (String)"saddle", (new aam()).c("saddle"));
      a(330, (String)"iron_door", (new zb(afi.aA)).c("doorIron"));
      a(331, (String)"redstone", (new aal()).c("redstone").e(abe.i));
      a(332, (String)"snowball", (new aaw()).c("snowball"));
      a(333, (String)"boat", (new yq()).c("boat"));
      a(334, (String)"leather", (new zw()).c("leather").a(yz.l));
      a(335, (String)"milk_bucket", (new aac()).c("milk").c(var0));
      a(336, (String)"brick", (new zw()).c("brick").a(yz.l));
      a(337, (String)"clay_ball", (new zw()).c("clay").a(yz.l));
      a(338, (String)"reeds", (new yp(afi.aM)).c("reeds").a(yz.l));
      a(339, (String)"paper", (new zw()).c("paper").a(yz.f));
      a(340, (String)"book", (new yr()).c("book").a(yz.f));
      a(341, (String)"slime_ball", (new zw()).c("slimeball").a(yz.f));
      a(342, (String)"chest_minecart", (new aad(va.a.b)).c("minecartChest"));
      a(343, (String)"furnace_minecart", (new aad(va.a.c)).c("minecartFurnace"));
      a(344, (String)"egg", (new zg()).c("egg"));
      a(345, (String)"compass", (new zw()).c("compass").a(yz.i));
      a(346, (String)"fishing_rod", (new zq()).c("fishingRod"));
      a(347, (String)"clock", (new zw()).c("clock").a(yz.i));
      a(348, (String)"glowstone_dust", (new zw()).c("yellowDust").e(abe.j).a(yz.l));
      a(349, (String)"fish", (new zp(false)).c("fish").a(true));
      a(350, (String)"cooked_fish", (new zp(true)).c("fish").a(true));
      a(351, (String)"dye", (new ze()).c("dyePowder"));
      a(352, (String)"bone", (new zw()).c("bone").n().a(yz.f));
      a(353, (String)"sugar", (new zw()).c("sugar").e(abe.b).a(yz.l));
      a(354, (String)"cake", (new yp(afi.ba)).c(1).c("cake").a(yz.h));
      a(355, (String)"bed", (new yn()).c(1).c("bed"));
      a(356, (String)"repeater", (new yp(afi.bb)).c("diode").a(yz.d));
      a(357, (String)"cookie", (new zs(2, 0.1F, false)).c("cookie"));
      a(358, (String)"filled_map", (new aab()).c("map"));
      a(359, (String)"shears", (new aap()).c("shears"));
      a(360, (String)"melon", (new zs(2, 0.3F, false)).c("melon"));
      a(361, (String)"pumpkin_seeds", (new aao(afi.bl, afi.ak)).c("seeds_pumpkin"));
      a(362, (String)"melon_seeds", (new aao(afi.bm, afi.ak)).c("seeds_melon"));
      a(363, (String)"beef", (new zs(3, 0.3F, true)).c("beefRaw"));
      a(364, (String)"cooked_beef", (new zs(8, 0.8F, true)).c("beefCooked"));
      a(365, (String)"chicken", (new zs(2, 0.3F, true)).a(pe.s.H, 30, 0, 0.3F).c("chickenRaw"));
      a(366, (String)"cooked_chicken", (new zs(6, 0.6F, true)).c("chickenCooked"));
      a(367, (String)"rotten_flesh", (new zs(4, 0.1F, true)).a(pe.s.H, 30, 0, 0.8F).c("rottenFlesh"));
      a(368, (String)"ender_pearl", (new zk()).c("enderPearl"));
      a(369, (String)"blaze_rod", (new zw()).c("blazeRod").a(yz.l).n());
      a(370, (String)"ghast_tear", (new zw()).c("ghastTear").e(abe.c).a(yz.k));
      a(371, (String)"gold_nugget", (new zw()).c("goldNugget").a(yz.l));
      a(372, (String)"nether_wart", (new aao(afi.bB, afi.aW)).c("netherStalkSeeds").e("+4"));
      a(373, (String)"potion", (new aai()).c("potion"));
      a(374, (String)"glass_bottle", (new ys()).c("glassBottle"));
      a(375, (String)"spider_eye", (new zs(2, 0.8F, false)).a(pe.u.H, 5, 0, 1.0F).c("spiderEye").e(abe.d));
      a(376, (String)"fermented_spider_eye", (new zw()).c("fermentedSpiderEye").e(abe.e).a(yz.k));
      a(377, (String)"blaze_powder", (new zw()).c("blazePowder").e(abe.g).a(yz.k));
      a(378, (String)"magma_cream", (new zw()).c("magmaCream").e(abe.h).a(yz.k));
      a(379, (String)"brewing_stand", (new yp(afi.bD)).c("brewingStand").a(yz.k));
      a(380, (String)"cauldron", (new yp(afi.bE)).c("cauldron").a(yz.k));
      a(381, (String)"ender_eye", (new zj()).c("eyeOfEnder"));
      a(382, (String)"speckled_melon", (new zw()).c("speckledMelon").e(abe.f).a(yz.k));
      a(383, (String)"spawn_egg", (new aax()).c("monsterPlacer"));
      a(384, (String)"experience_bottle", (new zl()).c("expBottle"));
      a(385, (String)"fire_charge", (new zm()).c("fireball"));
      a(386, (String)"writable_book", (new abc()).c("writingBook").a(yz.f));
      a(387, (String)"written_book", (new abd()).c("writtenBook").c(16));
      a(388, (String)"emerald", (new zw()).c("emerald").a(yz.l));
      a(389, (String)"item_frame", (new zu(uo.class)).c("frame"));
      a(390, (String)"flower_pot", (new yp(afi.ca)).c("flowerPot").a(yz.c));
      a(391, (String)"carrot", (new aan(3, 0.6F, afi.cb, afi.ak)).c("carrots"));
      a(392, (String)"potato", (new aan(1, 0.3F, afi.cc, afi.ak)).c("potato"));
      a(393, (String)"baked_potato", (new zs(5, 0.6F, false)).c("potatoBaked"));
      a(394, (String)"poisonous_potato", (new zs(2, 0.3F, false)).a(pe.u.H, 5, 0, 0.6F).c("potatoPoisonous"));
      a(395, (String)"map", (new zh()).c("emptyMap"));
      a(396, (String)"golden_carrot", (new zs(6, 1.2F, false)).c("carrotGolden").e(abe.l).a(yz.k));
      a(397, (String)"skull", (new aat()).c("skull"));
      a(398, (String)"carrot_on_a_stick", (new yw()).c("carrotOnAStick"));
      a(399, (String)"nether_star", (new aas()).c("netherStar").a(yz.l));
      a(400, (String)"pumpkin_pie", (new zs(8, 0.3F, false)).c("pumpkinPie").a(yz.h));
      a(401, (String)"fireworks", (new zo()).c("fireworks"));
      a(402, (String)"firework_charge", (new zn()).c("fireworksCharge").a(yz.f));
      a(403, (String)"enchanted_book", (new zi()).c(1).c("enchantedBook"));
      a(404, (String)"comparator", (new yp(afi.cj)).c("comparator").a(yz.d));
      a(405, (String)"netherbrick", (new zw()).c("netherbrick").a(yz.l));
      a(406, (String)"quartz", (new zw()).c("netherquartz").a(yz.l));
      a(407, (String)"tnt_minecart", (new aad(va.a.d)).c("minecartTnt"));
      a(408, (String)"hopper_minecart", (new aad(va.a.f)).c("minecartHopper"));
      a(409, (String)"prismarine_shard", (new zw()).c("prismarineShard").a(yz.l));
      a(410, (String)"prismarine_crystals", (new zw()).c("prismarineCrystals").a(yz.l));
      a(411, (String)"rabbit", (new zs(3, 0.3F, true)).c("rabbitRaw"));
      a(412, (String)"cooked_rabbit", (new zs(5, 0.6F, true)).c("rabbitCooked"));
      a(413, (String)"rabbit_stew", (new yu(10)).c("rabbitStew"));
      a(414, (String)"rabbit_foot", (new zw()).c("rabbitFoot").e(abe.n).a(yz.k));
      a(415, (String)"rabbit_hide", (new zw()).c("rabbitHide").a(yz.l));
      a(416, (String)"armor_stand", (new yk()).c("armorStand").c(16));
      a(417, (String)"iron_horse_armor", (new zw()).c("horsearmormetal").c(1).a(yz.f));
      a(418, (String)"golden_horse_armor", (new zw()).c("horsearmorgold").c(1).a(yz.f));
      a(419, (String)"diamond_horse_armor", (new zw()).c("horsearmordiamond").c(1).a(yz.f));
      a(420, (String)"lead", (new zz()).c("leash"));
      a(421, (String)"name_tag", (new aaf()).c("nameTag"));
      a(422, (String)"command_block_minecart", (new aad(va.a.g)).c("minecartCommandBlock").a((yz)null));
      a(423, (String)"mutton", (new zs(2, 0.3F, true)).c("muttonRaw"));
      a(424, (String)"cooked_mutton", (new zs(6, 0.8F, true)).c("muttonCooked"));
      a(425, (String)"banner", (new ym()).b("banner"));
      a(427, (String)"spruce_door", (new zb(afi.ap)).c("doorSpruce"));
      a(428, (String)"birch_door", (new zb(afi.aq)).c("doorBirch"));
      a(429, (String)"jungle_door", (new zb(afi.ar)).c("doorJungle"));
      a(430, (String)"acacia_door", (new zb(afi.as)).c("doorAcacia"));
      a(431, (String)"dark_oak_door", (new zb(afi.at)).c("doorDarkOak"));
      a(2256, (String)"record_13", (new aak("13")).c("record"));
      a(2257, (String)"record_cat", (new aak("cat")).c("record"));
      a(2258, (String)"record_blocks", (new aak("blocks")).c("record"));
      a(2259, (String)"record_chirp", (new aak("chirp")).c("record"));
      a(2260, (String)"record_far", (new aak("far")).c("record"));
      a(2261, (String)"record_mall", (new aak("mall")).c("record"));
      a(2262, (String)"record_mellohi", (new aak("mellohi")).c("record"));
      a(2263, (String)"record_stal", (new aak("stal")).c("record"));
      a(2264, (String)"record_strad", (new aak("strad")).c("record"));
      a(2265, (String)"record_ward", (new aak("ward")).c("record"));
      a(2266, (String)"record_11", (new aak("11")).c("record"));
      a(2267, (String)"record_wait", (new aak("wait")).c("record"));
   }

   public boolean e() {
      return false;
   }

   public boolean a(dn var1) {
      return false;
   }

   public zw c(String var1) {
      this.l = var1;
      return this;
   }

   public boolean a(zx var1, zx var2) {
      return false;
   }

   public boolean f(zx var1) {
      return var1.w();
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      var3.add(new zx(var1, 1, 0));
   }

   public void a(zx var1, adm var2, wn var3, int var4) {
   }

   private static void c(afh var0) {
      a((afh)var0, (zw)(new yo(var0)));
   }

   public void d(zx var1, adm var2, wn var3) {
   }

   public String a(zx var1) {
      return ("" + di.a(this.k(var1) + ".name")).trim();
   }

   public zw q() {
      return this.d;
   }

   public void a(zx var1, adm var2, pk var3, int var4, boolean var5) {
   }

   public boolean l(zx var1) {
      return this.j(var1) != null;
   }

   public boolean a(zx var1, adm var2, afh var3, cj var4, pr var5) {
      return false;
   }

   public boolean p() {
      return true;
   }

   private static void a(int var0, String var1, zw var2) {
      a(var0, new jy(var1), var2);
   }

   public boolean w_() {
      return this.i;
   }

   public static enum a {
      private final float h;
      private final int j;
      private final int f;
      private final int g;
      private final float i;
      a(0, 59, 2.0F, 0.0F, 15),
      c(2, 250, 6.0F, 2.0F, 14),
      d(3, 1561, 8.0F, 3.0F, 10),
      e(0, 32, 12.0F, 0.0F, 22),
      b(1, 131, 4.0F, 1.0F, 5);

      private static final zw.a[] k = new zw.a[]{a, b, c, d, e};

      public float c() {
         return this.i;
      }

      public int d() {
         return this.f;
      }

      public int a() {
         return this.g;
      }

      public int e() {
         return this.j;
      }

      public zw f() {
         if (this == a) {
            return zw.a(afi.f);
         } else if (this == b) {
            return zw.a(afi.e);
         } else if (this == e) {
            return zy.k;
         } else if (this == c) {
            return zy.j;
         } else {
            return this == d ? zy.i : null;
         }
      }

      public float b() {
         return this.h;
      }

      private a(int var3, int var4, float var5, float var6, int var7) {
         this.f = var3;
         this.g = var4;
         this.h = var5;
         this.i = var6;
         this.j = var7;
      }
   }
}
