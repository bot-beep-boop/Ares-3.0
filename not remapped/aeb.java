import java.util.Random;

public class aeb {
   protected int z;
   protected cj c;
   protected int E;
   protected aot i;
   protected int B;
   protected aot w;
   protected ant d;
   protected aot y;
   protected aot p;
   protected aot m;
   protected aot e = new aop(4);
   protected aot u;
   protected aot n;
   protected aot q;
   protected aot j;
   protected aou s;
   protected int I;
   protected int H;
   protected int D;
   protected aot o;
   protected int J;
   protected int G;
   protected aot t;
   protected aot g;
   protected aot h;
   protected aot f;
   protected aot x;
   protected adm a;
   protected aot l;
   protected int A;
   protected int C;
   protected Random b;
   protected aot v;
   protected aot k;
   protected aot r;
   public boolean L;
   protected int K;
   protected int F;

   protected void b(int var1, aot var2, int var3, int var4) {
      for(int var5 = 0; var5 < var1; ++var5) {
         cj var6 = this.c.a(this.b.nextInt(16), this.b.nextInt(var4) + this.b.nextInt(var4) + var3 - var4, this.b.nextInt(16));
         var2.b(this.a, this.b, var6);
      }

   }

   protected void a(ady var1) {
      this.a();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < this.I; ++var2) {
         var3 = this.b.nextInt(16) + 8;
         var4 = this.b.nextInt(16) + 8;
         this.f.b(this.a, this.b, this.a.r(this.c.a(var3, 0, var4)));
      }

      for(var2 = 0; var2 < this.J; ++var2) {
         var3 = this.b.nextInt(16) + 8;
         var4 = this.b.nextInt(16) + 8;
         this.e.b(this.a, this.b, this.a.r(this.c.a(var3, 0, var4)));
      }

      for(var2 = 0; var2 < this.H; ++var2) {
         var3 = this.b.nextInt(16) + 8;
         var4 = this.b.nextInt(16) + 8;
         this.g.b(this.a, this.b, this.a.r(this.c.a(var3, 0, var4)));
      }

      var2 = this.A;
      if (this.b.nextInt(10) == 0) {
         ++var2;
      }

      int var5;
      cj var7;
      for(var3 = 0; var3 < var2; ++var3) {
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(16) + 8;
         aoh var6 = var1.a(this.b);
         var6.e();
         var7 = this.a.m(this.c.a(var4, 0, var5));
         if (var6.b(this.a, this.b, var7)) {
            var6.a(this.a, this.b, var7);
         }
      }

      for(var3 = 0; var3 < this.K; ++var3) {
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(16) + 8;
         this.v.b(this.a, this.b, this.a.m(this.c.a(var4, 0, var5)));
      }

      cj var8;
      int var11;
      int var12;
      for(var3 = 0; var3 < this.B; ++var3) {
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(16) + 8;
         var11 = this.a.m(this.c.a(var4, 0, var5)).o() + 32;
         if (var11 > 0) {
            var12 = this.b.nextInt(var11);
            var8 = this.c.a(var4, var12, var5);
            agw.a var9 = var1.a(this.b, var8);
            agw var10 = var9.a().a();
            if (var10.t() != arm.a) {
               this.s.a(var10, var9);
               this.s.b(this.a, this.b, var8);
            }
         }
      }

      for(var3 = 0; var3 < this.C; ++var3) {
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(16) + 8;
         var11 = this.a.m(this.c.a(var4, 0, var5)).o() * 2;
         if (var11 > 0) {
            var12 = this.b.nextInt(var11);
            var1.b(this.b).b(this.a, this.b, this.c.a(var4, var12, var5));
         }
      }

      for(var3 = 0; var3 < this.D; ++var3) {
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(16) + 8;
         var11 = this.a.m(this.c.a(var4, 0, var5)).o() * 2;
         if (var11 > 0) {
            var12 = this.b.nextInt(var11);
            (new aoq()).b(this.a, this.b, this.c.a(var4, var12, var5));
         }
      }

      for(var3 = 0; var3 < this.z; ++var3) {
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(16) + 8;
         var11 = this.a.m(this.c.a(var4, 0, var5)).o() * 2;
         if (var11 > 0) {
            var12 = this.b.nextInt(var11);

            cj var14;
            for(var8 = this.c.a(var4, var12, var5); var8.o() > 0; var8 = var14) {
               var14 = var8.b();
               if (!this.a.d(var14)) {
                  break;
               }
            }

            this.y.b(this.a, this.b, var8);
         }
      }

      for(var3 = 0; var3 < this.E; ++var3) {
         if (this.b.nextInt(4) == 0) {
            var4 = this.b.nextInt(16) + 8;
            var5 = this.b.nextInt(16) + 8;
            cj var13 = this.a.m(this.c.a(var4, 0, var5));
            this.t.b(this.a, this.b, var13);
         }

         if (this.b.nextInt(8) == 0) {
            var4 = this.b.nextInt(16) + 8;
            var5 = this.b.nextInt(16) + 8;
            var11 = this.a.m(this.c.a(var4, 0, var5)).o() * 2;
            if (var11 > 0) {
               var12 = this.b.nextInt(var11);
               var8 = this.c.a(var4, var12, var5);
               this.u.b(this.a, this.b, var8);
            }
         }
      }

      if (this.b.nextInt(4) == 0) {
         var3 = this.b.nextInt(16) + 8;
         var4 = this.b.nextInt(16) + 8;
         var5 = this.a.m(this.c.a(var3, 0, var4)).o() * 2;
         if (var5 > 0) {
            var11 = this.b.nextInt(var5);
            this.t.b(this.a, this.b, this.c.a(var3, var11, var4));
         }
      }

      if (this.b.nextInt(8) == 0) {
         var3 = this.b.nextInt(16) + 8;
         var4 = this.b.nextInt(16) + 8;
         var5 = this.a.m(this.c.a(var3, 0, var4)).o() * 2;
         if (var5 > 0) {
            var11 = this.b.nextInt(var5);
            this.u.b(this.a, this.b, this.c.a(var3, var11, var4));
         }
      }

      for(var3 = 0; var3 < this.F; ++var3) {
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(16) + 8;
         var11 = this.a.m(this.c.a(var4, 0, var5)).o() * 2;
         if (var11 > 0) {
            var12 = this.b.nextInt(var11);
            this.w.b(this.a, this.b, this.c.a(var4, var12, var5));
         }
      }

      for(var3 = 0; var3 < 10; ++var3) {
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(16) + 8;
         var11 = this.a.m(this.c.a(var4, 0, var5)).o() * 2;
         if (var11 > 0) {
            var12 = this.b.nextInt(var11);
            this.w.b(this.a, this.b, this.c.a(var4, var12, var5));
         }
      }

      if (this.b.nextInt(32) == 0) {
         var3 = this.b.nextInt(16) + 8;
         var4 = this.b.nextInt(16) + 8;
         var5 = this.a.m(this.c.a(var3, 0, var4)).o() * 2;
         if (var5 > 0) {
            var11 = this.b.nextInt(var5);
            (new apl()).b(this.a, this.b, this.c.a(var3, var11, var4));
         }
      }

      for(var3 = 0; var3 < this.G; ++var3) {
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(16) + 8;
         var11 = this.a.m(this.c.a(var4, 0, var5)).o() * 2;
         if (var11 > 0) {
            var12 = this.b.nextInt(var11);
            this.x.b(this.a, this.b, this.c.a(var4, var12, var5));
         }
      }

      if (this.L) {
         for(var3 = 0; var3 < 50; ++var3) {
            var4 = this.b.nextInt(16) + 8;
            var5 = this.b.nextInt(16) + 8;
            var11 = this.b.nextInt(248) + 8;
            if (var11 > 0) {
               var12 = this.b.nextInt(var11);
               var8 = this.c.a(var4, var12, var5);
               (new apr(afi.i)).b(this.a, this.b, var8);
            }
         }

         for(var3 = 0; var3 < 20; ++var3) {
            var4 = this.b.nextInt(16) + 8;
            var5 = this.b.nextInt(16) + 8;
            var11 = this.b.nextInt(this.b.nextInt(this.b.nextInt(240) + 8) + 8);
            var7 = this.c.a(var4, var11, var5);
            (new apr(afi.k)).b(this.a, this.b, var7);
         }
      }

   }

   public void a(adm var1, Random var2, ady var3, cj var4) {
      if (this.a != null) {
         throw new RuntimeException("Already decorating");
      } else {
         this.a = var1;
         String var5 = var1.P().B();
         if (var5 != null) {
            this.d = ant.a.a(var5).b();
         } else {
            this.d = ant.a.a("").b();
         }

         this.b = var2;
         this.c = var4;
         this.h = new apj(afi.d.Q(), this.d.I);
         this.i = new apj(afi.n.Q(), this.d.M);
         this.j = new apj(afi.b.Q().a(ajy.a, ajy.a.b), this.d.Q);
         this.k = new apj(afi.b.Q().a(ajy.a, ajy.a.d), this.d.U);
         this.l = new apj(afi.b.Q().a(ajy.a, ajy.a.f), this.d.Y);
         this.m = new apj(afi.q.Q(), this.d.ac);
         this.n = new apj(afi.p.Q(), this.d.ag);
         this.o = new apj(afi.o.Q(), this.d.ak);
         this.p = new apj(afi.aC.Q(), this.d.ao);
         this.q = new apj(afi.ag.Q(), this.d.as);
         this.r = new apj(afi.x.Q(), this.d.aw);
         this.a(var3);
         this.a = null;
         this.b = null;
      }
   }

   protected void a(int var1, aot var2, int var3, int var4) {
      int var5;
      if (var4 < var3) {
         var5 = var3;
         var3 = var4;
         var4 = var5;
      } else if (var4 == var3) {
         if (var3 < 255) {
            ++var4;
         } else {
            --var3;
         }
      }

      for(var5 = 0; var5 < var1; ++var5) {
         cj var6 = this.c.a(this.b.nextInt(16), this.b.nextInt(var4 - var3) + var3, this.b.nextInt(16));
         var2.b(this.a, this.b, var6);
      }

   }

   protected void a() {
      this.a(this.d.J, this.h, this.d.K, this.d.L);
      this.a(this.d.N, this.i, this.d.O, this.d.P);
      this.a(this.d.V, this.k, this.d.W, this.d.X);
      this.a(this.d.R, this.j, this.d.S, this.d.T);
      this.a(this.d.Z, this.l, this.d.aa, this.d.ab);
      this.a(this.d.ad, this.m, this.d.ae, this.d.af);
      this.a(this.d.ah, this.n, this.d.ai, this.d.aj);
      this.a(this.d.al, this.o, this.d.am, this.d.an);
      this.a(this.d.ap, this.p, this.d.aq, this.d.ar);
      this.a(this.d.at, this.q, this.d.au, this.d.av);
      this.b(this.d.ax, this.r, this.d.ay, this.d.az);
   }

   public aeb() {
      this.f = new apo(afi.m, 7);
      this.g = new apo(afi.n, 6);
      this.s = new aou(afi.N, agw.a.a);
      this.t = new aom(afi.P);
      this.u = new aom(afi.Q);
      this.v = new aoz();
      this.w = new apm();
      this.x = new aon();
      this.y = new apx();
      this.B = 2;
      this.C = 1;
      this.H = 1;
      this.I = 3;
      this.J = 1;
      this.L = true;
   }
}
