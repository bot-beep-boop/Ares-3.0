import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;

public class bec {
   private bmj e;
   private Random f = new Random();
   private List<bep> d = Lists.newArrayList();
   protected adm a;
   private Map<Integer, bed> g = Maps.newHashMap();
   private List<beb>[][] c = new List[4][];
   private static final jy b = new jy("textures/particle/particles.png");

   public void a(pk var1, float var2) {
      float var3 = auz.b();
      float var4 = auz.d();
      float var5 = auz.e();
      float var6 = auz.f();
      float var7 = auz.c();
      beb.aw = var1.P + (var1.s - var1.P) * (double)var2;
      beb.ax = var1.Q + (var1.t - var1.Q) * (double)var2;
      beb.ay = var1.R + (var1.u - var1.R) * (double)var2;
      bfl.l();
      bfl.b(770, 771);
      bfl.a(516, 0.003921569F);

      for(int var8 = 0; var8 < 3; ++var8) {
         for(int var9 = 0; var9 < 2; ++var9) {
            if (!this.c[var8][var9].isEmpty()) {
               switch(var9) {
               case 0:
                  bfl.a(false);
                  break;
               case 1:
                  bfl.a(true);
               }

               switch(var8) {
               case 0:
               default:
                  this.e.a(b);
                  break;
               case 1:
                  this.e.a(bmh.g);
               }

               bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
               bfx var10 = bfx.a();
               bfd var11 = var10.c();
               var11.a(7, bms.d);

               for(int var12 = 0; var12 < this.c[var8][var9].size(); ++var12) {
                  beb var13 = (beb)this.c[var8][var9].get(var12);

                  try {
                     var13.a(var11, var1, var2, var3, var7, var4, var5, var6);
                  } catch (Throwable var18) {
                     b var15 = b.a(var18, "Rendering Particle");
                     c var16 = var15.a("Particle being rendered");
                     var16.a("Particle", new Callable<String>(this, var13) {
                        final bec b;
                        final beb a;

                        public String a() throws Exception {
                           return this.a.toString();
                        }

                        public Object call() throws Exception {
                           return this.a();
                        }

                        {
                           this.b = var1;
                           this.a = var2;
                        }
                     });
                     var16.a("Particle Type", new Callable<String>(this, var8) {
                        final int a;
                        final bec b;

                        public String a() throws Exception {
                           if (this.a == 0) {
                              return "MISC_TEXTURE";
                           } else if (this.a == 1) {
                              return "TERRAIN_TEXTURE";
                           } else {
                              return this.a == 3 ? "ENTITY_PARTICLE_TEXTURE" : "Unknown - " + this.a;
                           }
                        }

                        public Object call() throws Exception {
                           return this.a();
                        }

                        {
                           this.b = var1;
                           this.a = var2;
                        }
                     });
                     throw new e(var15);
                  }
               }

               var10.b();
            }
         }
      }

      bfl.a(true);
      bfl.k();
      bfl.a(516, 0.1F);
   }

   public void a() {
      for(int var1 = 0; var1 < 4; ++var1) {
         this.a(var1);
      }

      ArrayList var4 = Lists.newArrayList();
      Iterator var2 = this.d.iterator();

      while(var2.hasNext()) {
         bep var3 = (bep)var2.next();
         var3.t_();
         if (var3.I) {
            var4.add(var3);
         }
      }

      this.d.removeAll(var4);
   }

   public void a(cj var1, cq var2) {
      alz var3 = this.a.p(var1);
      afh var4 = var3.c();
      if (var4.b() != -1) {
         int var5 = var1.n();
         int var6 = var1.o();
         int var7 = var1.p();
         float var8 = 0.1F;
         double var9 = (double)var5 + this.f.nextDouble() * (var4.C() - var4.B() - (double)(var8 * 2.0F)) + (double)var8 + var4.B();
         double var11 = (double)var6 + this.f.nextDouble() * (var4.E() - var4.D() - (double)(var8 * 2.0F)) + (double)var8 + var4.D();
         double var13 = (double)var7 + this.f.nextDouble() * (var4.G() - var4.F() - (double)(var8 * 2.0F)) + (double)var8 + var4.F();
         if (var2 == cq.a) {
            var11 = (double)var6 + var4.D() - (double)var8;
         }

         if (var2 == cq.b) {
            var11 = (double)var6 + var4.E() + (double)var8;
         }

         if (var2 == cq.c) {
            var13 = (double)var7 + var4.F() - (double)var8;
         }

         if (var2 == cq.d) {
            var13 = (double)var7 + var4.G() + (double)var8;
         }

         if (var2 == cq.e) {
            var9 = (double)var5 + var4.B() - (double)var8;
         }

         if (var2 == cq.f) {
            var9 = (double)var5 + var4.C() + (double)var8;
         }

         this.a((new beo(this.a, var9, var11, var13, 0.0D, 0.0D, 0.0D, var3)).a(var1).a(0.2F).h(0.6F));
      }
   }

   public void b(beb var1) {
      this.a(var1, 1, 0);
   }

   public void c(beb var1) {
      this.a(var1, 0, 1);
   }

   public void a(int var1, bed var2) {
      this.g.put(var1, var2);
   }

   private void a(int var1) {
      for(int var2 = 0; var2 < 2; ++var2) {
         this.a(this.c[var1][var2]);
      }

   }

   public void a(pk var1, cy var2) {
      this.d.add(new bep(this.a, var1, var2));
   }

   public String b() {
      int var1 = 0;

      for(int var2 = 0; var2 < 4; ++var2) {
         for(int var3 = 0; var3 < 2; ++var3) {
            var1 += this.c[var2][var3].size();
         }
      }

      return "" + var1;
   }

   private void a(beb var1, int var2, int var3) {
      for(int var4 = 0; var4 < 4; ++var4) {
         if (this.c[var4][var2].contains(var1)) {
            this.c[var4][var2].remove(var1);
            this.c[var4][var3].add(var1);
         }
      }

   }

   private void d(beb var1) {
      try {
         var1.t_();
      } catch (Throwable var6) {
         b var3 = b.a(var6, "Ticking Particle");
         c var4 = var3.a("Particle being ticked");
         int var5 = var1.a();
         var4.a("Particle", new Callable<String>(this, var1) {
            final beb a;
            final bec b;

            public Object call() throws Exception {
               return this.a();
            }

            {
               this.b = var1;
               this.a = var2;
            }

            public String a() throws Exception {
               return this.a.toString();
            }
         });
         var4.a("Particle Type", new Callable<String>(this, var5) {
            final bec b;
            final int a;

            public String a() throws Exception {
               if (this.a == 0) {
                  return "MISC_TEXTURE";
               } else if (this.a == 1) {
                  return "TERRAIN_TEXTURE";
               } else {
                  return this.a == 3 ? "ENTITY_PARTICLE_TEXTURE" : "Unknown - " + this.a;
               }
            }

            public Object call() throws Exception {
               return this.a();
            }

            {
               this.b = var1;
               this.a = var2;
            }
         });
         throw new e(var3);
      }
   }

   public void b(pk var1, float var2) {
      float var3 = 0.017453292F;
      float var4 = ns.b(var1.y * 0.017453292F);
      float var5 = ns.a(var1.y * 0.017453292F);
      float var6 = -var5 * ns.a(var1.z * 0.017453292F);
      float var7 = var4 * ns.a(var1.z * 0.017453292F);
      float var8 = ns.b(var1.z * 0.017453292F);

      for(int var9 = 0; var9 < 2; ++var9) {
         List var10 = this.c[3][var9];
         if (!var10.isEmpty()) {
            bfx var11 = bfx.a();
            bfd var12 = var11.c();

            for(int var13 = 0; var13 < var10.size(); ++var13) {
               beb var14 = (beb)var10.get(var13);
               var14.a(var12, var1, var2, var4, var8, var5, var6, var7);
            }
         }
      }

   }

   private void a(List<beb> var1) {
      ArrayList var2 = Lists.newArrayList();

      for(int var3 = 0; var3 < var1.size(); ++var3) {
         beb var4 = (beb)var1.get(var3);
         this.d(var4);
         if (var4.I) {
            var2.add(var4);
         }
      }

      var1.removeAll(var2);
   }

   public bec(adm var1, bmj var2) {
      this.a = var1;
      this.e = var2;

      for(int var3 = 0; var3 < 4; ++var3) {
         this.c[var3] = new List[2];

         for(int var4 = 0; var4 < 2; ++var4) {
            this.c[var3][var4] = Lists.newArrayList();
         }
      }

      this.c();
   }

   public beb a(int var1, double var2, double var4, double var6, double var8, double var10, double var12, int... var14) {
      bed var15 = (bed)this.g.get(var1);
      if (var15 != null) {
         beb var16 = var15.a(var1, this.a, var2, var4, var6, var8, var10, var12, var14);
         if (var16 != null) {
            this.a(var16);
            return var16;
         }
      }

      return null;
   }

   public void a(adm var1) {
      this.a = var1;

      for(int var2 = 0; var2 < 4; ++var2) {
         for(int var3 = 0; var3 < 2; ++var3) {
            this.c[var2][var3].clear();
         }
      }

      this.d.clear();
   }

   public void a(beb var1) {
      int var2 = var1.a();
      int var3 = var1.j() != 1.0F ? 0 : 1;
      if (this.c[var2][var3].size() >= 4000) {
         this.c[var2][var3].remove(0);
      }

      this.c[var2][var3].add(var1);
   }

   private void c() {
      this.a(cy.a.c(), new bdp.a());
      this.a(cy.e.c(), new bdl.a());
      this.a(cy.f.c(), new bek.a());
      this.a(cy.g.c(), new beq.a());
      this.a(cy.N.c(), new ber.a());
      this.a(cy.h.c(), new bel.a());
      this.a(cy.i.c(), new bem.b());
      this.a(cy.j.c(), new bdm.b());
      this.a(cy.k.c(), new bdm.a());
      this.a(cy.l.c(), new beh.a());
      this.a(cy.m.c(), new bdx.a());
      this.a(cy.n.c(), new bej.d());
      this.a(cy.o.c(), new bej.b());
      this.a(cy.p.c(), new bej.c());
      this.a(cy.q.c(), new bej.a());
      this.a(cy.r.c(), new bej.e());
      this.a(cy.s.c(), new bdn.b());
      this.a(cy.t.c(), new bdn.a());
      this.a(cy.u.c(), new bdt.a());
      this.a(cy.v.c(), new bem.a());
      this.a(cy.w.c(), new bem.b());
      this.a(cy.x.c(), new bea.a());
      this.a(cy.y.c(), new bef.a());
      this.a(cy.z.c(), new bdo.a());
      this.a(cy.A.c(), new bdr.a());
      this.a(cy.B.c(), new bdy.a());
      this.a(cy.C.c(), new bds.a());
      this.a(cy.D.c(), new bee.a());
      this.a(cy.E.c(), new beg.a());
      this.a(cy.F.c(), new bdk.c());
      this.a(cy.G.c(), new bei.a());
      this.a(cy.H.c(), new bdk.b());
      this.a(cy.I.c(), new bdt.b());
      this.a(cy.J.c(), new bdj.a());
      this.a(cy.K.c(), new bdk.a());
      this.a(cy.L.c(), new beo.a());
      this.a(cy.M.c(), new ben.a());
      this.a(cy.c.c(), new bdv.a());
      this.a(cy.b.c(), new bdu.a());
      this.a(cy.d.c(), new bdq.d());
      this.a(cy.P.c(), new bdz.a());
   }

   public void a(cj var1, alz var2) {
      if (var2.c().t() != arm.a) {
         var2 = var2.c().a((alz)var2, (adq)this.a, (cj)var1);
         byte var3 = 4;

         for(int var4 = 0; var4 < var3; ++var4) {
            for(int var5 = 0; var5 < var3; ++var5) {
               for(int var6 = 0; var6 < var3; ++var6) {
                  double var7 = (double)var1.n() + ((double)var4 + 0.5D) / (double)var3;
                  double var9 = (double)var1.o() + ((double)var5 + 0.5D) / (double)var3;
                  double var11 = (double)var1.p() + ((double)var6 + 0.5D) / (double)var3;
                  this.a((beb)(new beo(this.a, var7, var9, var11, var7 - (double)var1.n() - 0.5D, var9 - (double)var1.o() - 0.5D, var11 - (double)var1.p() - 0.5D, var2)).a(var1));
               }
            }
         }

      }
   }
}
