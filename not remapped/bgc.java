import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class bgc {
   private final bou c;
   private final bgv b = new bgv();
   private final Map<alz, boq> a = Maps.newIdentityHashMap();

   public void a(afh var1, bgy var2) {
      this.b.a(var1, var2);
   }

   public void c() {
      this.a.clear();
      Iterator var1 = this.b.a().entrySet().iterator();

      while(var1.hasNext()) {
         Entry var2 = (Entry)var1.next();
         this.a.put(var2.getKey(), this.c.a((bov)var2.getValue()));
      }

   }

   public bou b() {
      return this.c;
   }

   public boq b(alz var1) {
      boq var2 = (boq)this.a.get(var1);
      if (var2 == null) {
         var2 = this.c.a();
      }

      return var2;
   }

   public bgc(bou var1) {
      this.c = var1;
      this.d();
   }

   public bmi a(alz var1) {
      afh var2 = var1.c();
      boq var3 = this.b(var1);
      if (var3 == null || var3 == this.c.a()) {
         label70: {
            if (var2 != afi.ax && var2 != afi.an && var2 != afi.ae && var2 != afi.cg && var2 != afi.cK && var2 != afi.cL) {
               if (var2 == afi.bQ) {
                  return this.c.b().a("minecraft:blocks/obsidian");
               }

               if (var2 == afi.k || var2 == afi.l) {
                  return this.c.b().a("minecraft:blocks/lava_still");
               }

               if (var2 != afi.i && var2 != afi.j) {
                  if (var2 == afi.ce) {
                     return this.c.b().a("minecraft:blocks/soul_sand");
                  }

                  if (var2 == afi.cv) {
                     return this.c.b().a("minecraft:items/barrier");
                  }
                  break label70;
               }

               return this.c.b().a("minecraft:blocks/water_still");
            }

            return this.c.b().a("minecraft:blocks/planks_oak");
         }
      }

      if (var3 == null) {
         var3 = this.c.a();
      }

      return var3.e();
   }

   private void d() {
      this.a(afi.a, afi.i, afi.j, afi.k, afi.l, afi.M, afi.ae, afi.bQ, afi.cg, afi.an, afi.ce, afi.bF, afi.cv, afi.ax, afi.cL, afi.cK);
      this.a(afi.b, (new bgx.a()).a((amo)ajy.a).a());
      this.a(afi.cI, (new bgx.a()).a((amo)aiu.a).a());
      this.a(afi.t, (new bgx.a()).a((amo)aik.Q).a("_leaves").a(ahs.b, ahs.a).a());
      this.a(afi.u, (new bgx.a()).a((amo)aif.Q).a("_leaves").a(ahs.b, ahs.a).a());
      this.a(afi.aK, (new bgx.a()).a(afo.a).a());
      this.a(afi.aM, (new bgx.a()).a(aje.a).a());
      this.a(afi.aN, (new bgx.a()).a(ahq.a).a());
      this.a(afi.bX, (new bgx.a()).a(afw.a).a());
      this.a(afi.bZ, (new bgx.a()).a((amo)akl.Q).a("_wall").a());
      this.a(afi.cF, (new bgx.a()).a((amo)agi.a).a(agi.N).a());
      this.a(afi.bo, (new bgx.a()).a(agu.b).a());
      this.a(afi.bp, (new bgx.a()).a(agu.b).a());
      this.a(afi.bq, (new bgx.a()).a(agu.b).a());
      this.a(afi.br, (new bgx.a()).a(agu.b).a());
      this.a(afi.bs, (new bgx.a()).a(agu.b).a());
      this.a(afi.bt, (new bgx.a()).a(agu.b).a());
      this.a(afi.bS, (new bgx.a()).a(aki.O, aki.a).a());
      this.a(afi.bL, (new bgx.a()).a((amo)aio.a).a("_double_slab").a());
      this.a(afi.bM, (new bgx.a()).a((amo)aio.a).a("_slab").a());
      this.a(afi.W, (new bgx.a()).a(ake.a).a());
      this.a(afi.ab, (new bgx.a()).a(agv.a).a());
      this.a(afi.af, (new bgx.a()).a(ajb.P).a());
      this.a(afi.ao, (new bgx.a()).a(agh.O).a());
      this.a(afi.ap, (new bgx.a()).a(agh.O).a());
      this.a(afi.aq, (new bgx.a()).a(agh.O).a());
      this.a(afi.ar, (new bgx.a()).a(agh.O).a());
      this.a(afi.as, (new bgx.a()).a(agh.O).a());
      this.a(afi.at, (new bgx.a()).a(agh.O).a());
      this.a(afi.aA, (new bgx.a()).a(agh.O).a());
      this.a(afi.L, (new bgx.a()).a((amo)afv.a).a("_wool").a());
      this.a(afi.cy, (new bgx.a()).a((amo)afv.a).a("_carpet").a());
      this.a(afi.cu, (new bgx.a()).a((amo)afv.a).a("_stained_hardened_clay").a());
      this.a(afi.cH, (new bgx.a()).a((amo)afv.a).a("_stained_glass_pane").a());
      this.a(afi.cG, (new bgx.a()).a((amo)afv.a).a("_stained_glass").a());
      this.a(afi.A, (new bgx.a()).a((amo)aji.a).a());
      this.a(afi.cM, (new bgx.a()).a((amo)aiz.a).a());
      this.a(afi.H, (new bgx.a()).a((amo)akc.a).a());
      this.a(afi.C, (new bgx.a()).a(afg.b).a());
      this.a(afi.N, (new bgx.a()).a(afi.N.n()).a());
      this.a(afi.O, (new bgx.a()).a(afi.O.n()).a());
      this.a(afi.U, (new bgx.a()).a((amo)akb.N).a("_slab").a());
      this.a(afi.cP, (new bgx.a()).a((amo)aih.N).a("_slab").a());
      this.a(afi.be, (new bgx.a()).a((amo)ahz.a).a("_monster_egg").a());
      this.a(afi.bf, (new bgx.a()).a((amo)ajz.a).a());
      this.a(afi.z, (new bgx.a()).a(agg.b).a());
      this.a(afi.ct, (new bgx.a()).a(agk.b).a());
      this.a(afi.r, (new bgx.a()).a((amo)ail.b).a("_log").a());
      this.a(afi.s, (new bgx.a()).a((amo)aig.b).a("_log").a());
      this.a(afi.f, (new bgx.a()).a((amo)aio.a).a("_planks").a());
      this.a(afi.g, (new bgx.a()).a((amo)ajj.a).a("_sapling").a());
      this.a(afi.m, (new bgx.a()).a((amo)ajh.a).a());
      this.a(afi.cp, (new bgx.a()).a(ahn.b).a());
      this.a(afi.ca, (new bgx.a()).a(agx.a).a());
      this.a(afi.cq, new bgu(this) {
         final bgc a;

         protected bov a(alz var1) {
            aiw.a var2 = (aiw.a)var1.b(aiw.a);
            switch(var2) {
            case a:
            default:
               return new bov("quartz_block", "normal");
            case b:
               return new bov("chiseled_quartz_block", "normal");
            case c:
               return new bov("quartz_column", "axis=y");
            case d:
               return new bov("quartz_column", "axis=x");
            case e:
               return new bov("quartz_column", "axis=z");
            }
         }

         {
            this.a = var1;
         }
      });
      this.a(afi.I, new bgu(this) {
         final bgc a;

         {
            this.a = var1;
         }

         protected bov a(alz var1) {
            return new bov("dead_bush", "normal");
         }
      });
      this.a(afi.bl, new bgu(this) {
         final bgc a;

         {
            this.a = var1;
         }

         protected bov a(alz var1) {
            LinkedHashMap var2 = Maps.newLinkedHashMap(var1.b());
            if (var1.b(ajx.b) != cq.b) {
               var2.remove(ajx.a);
            }

            return new bov((jy)afh.c.c(var1.c()), this.a(var2));
         }
      });
      this.a(afi.bm, new bgu(this) {
         final bgc a;

         protected bov a(alz var1) {
            LinkedHashMap var2 = Maps.newLinkedHashMap(var1.b());
            if (var1.b(ajx.b) != cq.b) {
               var2.remove(ajx.a);
            }

            return new bov((jy)afh.c.c(var1.c()), this.a(var2));
         }

         {
            this.a = var1;
         }
      });
      this.a(afi.d, new bgu(this) {
         final bgc a;

         {
            this.a = var1;
         }

         protected bov a(alz var1) {
            LinkedHashMap var2 = Maps.newLinkedHashMap(var1.b());
            String var3 = agf.a.a((Comparable)var2.remove(agf.a));
            if (agf.a.c != var1.b(agf.a)) {
               var2.remove(agf.b);
            }

            return new bov(var3, this.a(var2));
         }
      });
      this.a(afi.T, new bgu(this) {
         final bgc a;

         protected bov a(alz var1) {
            LinkedHashMap var2 = Maps.newLinkedHashMap(var1.b());
            String var3 = akb.N.a((Comparable)var2.remove(akb.N));
            var2.remove(akb.b);
            String var4 = (Boolean)var1.b(akb.b) ? "all" : "normal";
            return new bov(var3 + "_double_slab", var4);
         }

         {
            this.a = var1;
         }
      });
      this.a(afi.cO, new bgu(this) {
         final bgc a;

         {
            this.a = var1;
         }

         protected bov a(alz var1) {
            LinkedHashMap var2 = Maps.newLinkedHashMap(var1.b());
            String var3 = aih.N.a((Comparable)var2.remove(aih.N));
            var2.remove(akb.b);
            String var4 = (Boolean)var1.b(aih.b) ? "all" : "normal";
            return new bov(var3 + "_double_slab", var4);
         }
      });
   }

   public bgv a() {
      return this.b;
   }

   public void a(afh... var1) {
      this.b.a(var1);
   }
}
