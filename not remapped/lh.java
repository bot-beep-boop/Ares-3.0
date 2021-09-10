import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class lh {
   public int d;
   private boolean y;
   public double k;
   public int b;
   private double s;
   public int h;
   private pk w;
   public Set<lf> o = Sets.newHashSet();
   public int f;
   public pk a;
   public boolean n;
   private double r;
   private double q;
   private boolean x;
   public int m;
   public int c;
   private boolean u;
   private boolean t;
   private int v;
   public int e;
   public double l;
   private static final Logger p = LogManager.getLogger();
   public int g;
   public int i;
   public double j;

   public void a(List<wn> var1) {
      this.n = false;
      if (!this.t || this.a.e(this.q, this.r, this.s) > 16.0D) {
         this.q = this.a.s;
         this.r = this.a.t;
         this.s = this.a.u;
         this.t = true;
         this.n = true;
         this.b(var1);
      }

      if (this.w != this.a.m || this.a.m != null && this.m % 60 == 0) {
         this.w = this.a.m;
         this.a((ff)(new hl(0, this.a, this.a.m)));
      }

      if (this.a instanceof uo && this.m % 10 == 0) {
         uo var2 = (uo)this.a;
         zx var3 = var2.o();
         if (var3 != null && var3.b() instanceof aab) {
            atg var4 = zy.bd.a(var3, this.a.o);
            Iterator var5 = var1.iterator();

            while(var5.hasNext()) {
               wn var6 = (wn)var5.next();
               lf var7 = (lf)var6;
               var4.a(var7, var3);
               ff var8 = zy.bd.c(var3, this.a.o, var7);
               if (var8 != null) {
                  var7.a.a(var8);
               }
            }
         }

         this.b();
      }

      if (this.m % this.c == 0 || this.a.ai || this.a.H().a()) {
         int var23;
         int var24;
         if (this.a.m == null) {
            ++this.v;
            var23 = ns.c(this.a.s * 32.0D);
            var24 = ns.c(this.a.t * 32.0D);
            int var26 = ns.c(this.a.u * 32.0D);
            int var27 = ns.d(this.a.y * 256.0F / 360.0F);
            int var28 = ns.d(this.a.z * 256.0F / 360.0F);
            int var29 = var23 - this.d;
            int var30 = var24 - this.e;
            int var9 = var26 - this.f;
            Object var10 = null;
            boolean var11 = Math.abs(var29) >= 4 || Math.abs(var30) >= 4 || Math.abs(var9) >= 4 || this.m % 60 == 0;
            boolean var12 = Math.abs(var27 - this.g) >= 4 || Math.abs(var28 - this.h) >= 4;
            if (this.m > 0 || this.a instanceof wq) {
               if (var29 >= -128 && var29 < 128 && var30 >= -128 && var30 < 128 && var9 >= -128 && var9 < 128 && this.v <= 400 && !this.x && this.y == this.a.C) {
                  if ((!var11 || !var12) && !(this.a instanceof wq)) {
                     if (var11) {
                        var10 = new gv.a(this.a.F(), (byte)var29, (byte)var30, (byte)var9, this.a.C);
                     } else if (var12) {
                        var10 = new gv.c(this.a.F(), (byte)var27, (byte)var28, this.a.C);
                     }
                  } else {
                     var10 = new gv.b(this.a.F(), (byte)var29, (byte)var30, (byte)var9, (byte)var27, (byte)var28, this.a.C);
                  }
               } else {
                  this.y = this.a.C;
                  this.v = 0;
                  var10 = new hz(this.a.F(), var23, var24, var26, (byte)var27, (byte)var28, this.a.C);
               }
            }

            if (this.u) {
               double var13 = this.a.v - this.j;
               double var15 = this.a.w - this.k;
               double var17 = this.a.x - this.l;
               double var19 = 0.02D;
               double var21 = var13 * var13 + var15 * var15 + var17 * var17;
               if (var21 > var19 * var19 || var21 > 0.0D && this.a.v == 0.0D && this.a.w == 0.0D && this.a.x == 0.0D) {
                  this.j = this.a.v;
                  this.k = this.a.w;
                  this.l = this.a.x;
                  this.a((ff)(new hm(this.a.F(), this.j, this.k, this.l)));
               }
            }

            if (var10 != null) {
               this.a((ff)var10);
            }

            this.b();
            if (var11) {
               this.d = var23;
               this.e = var24;
               this.f = var26;
            }

            if (var12) {
               this.g = var27;
               this.h = var28;
            }

            this.x = false;
         } else {
            var23 = ns.d(this.a.y * 256.0F / 360.0F);
            var24 = ns.d(this.a.z * 256.0F / 360.0F);
            boolean var25 = Math.abs(var23 - this.g) >= 4 || Math.abs(var24 - this.h) >= 4;
            if (var25) {
               this.a((ff)(new gv.c(this.a.F(), (byte)var23, (byte)var24, this.a.C)));
               this.g = var23;
               this.h = var24;
            }

            this.d = ns.c(this.a.s * 32.0D);
            this.e = ns.c(this.a.t * 32.0D);
            this.f = ns.c(this.a.u * 32.0D);
            this.b();
            this.x = true;
         }

         var23 = ns.d(this.a.aC() * 256.0F / 360.0F);
         if (Math.abs(var23 - this.i) >= 4) {
            this.a((ff)(new hf(this.a, (byte)var23)));
            this.i = var23;
         }

         this.a.ai = false;
      }

      ++this.m;
      if (this.a.G) {
         this.b((ff)(new hm(this.a)));
         this.a.G = false;
      }

   }

   public void d(lf var1) {
      if (this.o.contains(var1)) {
         this.o.remove(var1);
         var1.d(this.a);
      }

   }

   private void b() {
      pz var1 = this.a.H();
      if (var1.a()) {
         this.b((ff)(new hk(this.a.F(), var1, false)));
      }

      if (this.a instanceof pr) {
         qi var2 = (qi)((pr)this.a).by();
         Set var3 = var2.b();
         if (!var3.isEmpty()) {
            this.b((ff)(new ia(this.a.F(), var3)));
         }

         var3.clear();
      }

   }

   private ff c() {
      if (this.a.I) {
         p.warn("Fetching addPacket for removed entity");
      }

      if (this.a instanceof uz) {
         return new fk(this.a, 2, 1);
      } else if (this.a instanceof lf) {
         return new fp((wn)this.a);
      } else if (this.a instanceof va) {
         va var9 = (va)this.a;
         return new fk(this.a, 10, var9.s().a());
      } else if (this.a instanceof ux) {
         return new fk(this.a, 1);
      } else if (this.a instanceof pi) {
         this.i = ns.d(this.a.aC() * 256.0F / 360.0F);
         return new fn((pr)this.a);
      } else if (this.a instanceof ur) {
         wn var8 = ((ur)this.a).b;
         return new fk(this.a, 90, var8 != null ? var8.F() : this.a.F());
      } else if (this.a instanceof wq) {
         pk var7 = ((wq)this.a).c;
         return new fk(this.a, 60, var7 != null ? var7.F() : this.a.F());
      } else if (this.a instanceof wx) {
         return new fk(this.a, 61);
      } else if (this.a instanceof xc) {
         return new fk(this.a, 73, ((xc)this.a).o());
      } else if (this.a instanceof xb) {
         return new fk(this.a, 75);
      } else if (this.a instanceof xa) {
         return new fk(this.a, 65);
      } else if (this.a instanceof wr) {
         return new fk(this.a, 72);
      } else if (this.a instanceof wt) {
         return new fk(this.a, 76);
      } else {
         fk var2;
         if (this.a instanceof ws) {
            ws var6 = (ws)this.a;
            var2 = null;
            byte var10 = 63;
            if (this.a instanceof ww) {
               var10 = 64;
            } else if (this.a instanceof xd) {
               var10 = 66;
            }

            if (var6.a != null) {
               var2 = new fk(this.a, var10, ((ws)this.a).a.F());
            } else {
               var2 = new fk(this.a, var10, 0);
            }

            var2.d((int)(var6.b * 8000.0D));
            var2.e((int)(var6.c * 8000.0D));
            var2.f((int)(var6.d * 8000.0D));
            return var2;
         } else if (this.a instanceof wz) {
            return new fk(this.a, 62);
         } else if (this.a instanceof vj) {
            return new fk(this.a, 50);
         } else if (this.a instanceof uf) {
            return new fk(this.a, 51);
         } else if (this.a instanceof uy) {
            uy var5 = (uy)this.a;
            return new fk(this.a, 70, afh.f(var5.l()));
         } else if (this.a instanceof um) {
            return new fk(this.a, 78);
         } else if (this.a instanceof uq) {
            return new fo((uq)this.a);
         } else {
            cj var3;
            if (this.a instanceof uo) {
               uo var4 = (uo)this.a;
               var2 = new fk(this.a, 71, var4.b.b());
               var3 = var4.n();
               var2.a(ns.d((float)(var3.n() * 32)));
               var2.b(ns.d((float)(var3.o() * 32)));
               var2.c(ns.d((float)(var3.p() * 32)));
               return var2;
            } else if (this.a instanceof up) {
               up var1 = (up)this.a;
               var2 = new fk(this.a, 77);
               var3 = var1.n();
               var2.a(ns.d((float)(var3.n() * 32)));
               var2.b(ns.d((float)(var3.o() * 32)));
               var2.c(ns.d((float)(var3.p() * 32)));
               return var2;
            } else if (this.a instanceof pp) {
               return new fl((pp)this.a);
            } else {
               throw new IllegalArgumentException("Don't know how to add " + this.a.getClass() + "!");
            }
         }
      }
   }

   public boolean c(lf var1) {
      double var2 = var1.s - (double)(this.d / 32);
      double var4 = var1.u - (double)(this.f / 32);
      return var2 >= (double)(-this.b) && var2 <= (double)this.b && var4 >= (double)(-this.b) && var4 <= (double)this.b && this.a.a(var1);
   }

   private boolean e(lf var1) {
      return var1.u().t().a(var1, this.a.ae, this.a.ag);
   }

   public int hashCode() {
      return this.a.F();
   }

   public void b(ff var1) {
      this.a(var1);
      if (this.a instanceof lf) {
         ((lf)this.a).a.a(var1);
      }

   }

   public lh(pk var1, int var2, int var3, boolean var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.u = var4;
      this.d = ns.c(var1.s * 32.0D);
      this.e = ns.c(var1.t * 32.0D);
      this.f = ns.c(var1.u * 32.0D);
      this.g = ns.d(var1.y * 256.0F / 360.0F);
      this.h = ns.d(var1.z * 256.0F / 360.0F);
      this.i = ns.d(var1.aC() * 256.0F / 360.0F);
      this.y = var1.C;
   }

   public void b(List<wn> var1) {
      for(int var2 = 0; var2 < var1.size(); ++var2) {
         this.b((lf)var1.get(var2));
      }

   }

   public void a(lf var1) {
      if (this.o.contains(var1)) {
         var1.d(this.a);
         this.o.remove(var1);
      }

   }

   public void a() {
      Iterator var1 = this.o.iterator();

      while(var1.hasNext()) {
         lf var2 = (lf)var1.next();
         var2.d(this.a);
      }

   }

   public void b(lf var1) {
      if (var1 != this.a) {
         if (this.c(var1)) {
            if (!this.o.contains(var1) && (this.e(var1) || this.a.n)) {
               this.o.add(var1);
               ff var2 = this.c();
               var1.a.a(var2);
               if (!this.a.H().d()) {
                  var1.a.a((ff)(new hk(this.a.F(), this.a.H(), true)));
               }

               dn var3 = this.a.aV();
               if (var3 != null) {
                  var1.a.a((ff)(new gj(this.a.F(), var3)));
               }

               if (this.a instanceof pr) {
                  qi var4 = (qi)((pr)this.a).by();
                  Collection var5 = var4.c();
                  if (!var5.isEmpty()) {
                     var1.a.a((ff)(new ia(this.a.F(), var5)));
                  }
               }

               this.j = this.a.v;
               this.k = this.a.w;
               this.l = this.a.x;
               if (this.u && !(var2 instanceof fn)) {
                  var1.a.a((ff)(new hm(this.a.F(), this.a.v, this.a.w, this.a.x)));
               }

               if (this.a.m != null) {
                  var1.a.a((ff)(new hl(0, this.a, this.a.m)));
               }

               if (this.a instanceof ps && ((ps)this.a).cd() != null) {
                  var1.a.a((ff)(new hl(1, this.a, ((ps)this.a).cd())));
               }

               if (this.a instanceof pr) {
                  for(int var7 = 0; var7 < 5; ++var7) {
                     zx var9 = ((pr)this.a).p(var7);
                     if (var9 != null) {
                        var1.a.a((ff)(new hn(this.a.F(), var7, var9)));
                     }
                  }
               }

               if (this.a instanceof wn) {
                  wn var8 = (wn)this.a;
                  if (var8.bJ()) {
                     var1.a.a((ff)(new ha(var8, new cj(this.a))));
                  }
               }

               if (this.a instanceof pr) {
                  pr var10 = (pr)this.a;
                  Iterator var11 = var10.bl().iterator();

                  while(var11.hasNext()) {
                     pf var6 = (pf)var11.next();
                     var1.a.a((ff)(new ib(this.a.F(), var6)));
                  }
               }
            }
         } else if (this.o.contains(var1)) {
            this.o.remove(var1);
            var1.d(this.a);
         }

      }
   }

   public void a(ff var1) {
      Iterator var2 = this.o.iterator();

      while(var2.hasNext()) {
         lf var3 = (lf)var2.next();
         var3.a.a(var1);
      }

   }

   public boolean equals(Object var1) {
      if (var1 instanceof lh) {
         return ((lh)var1).a.F() == this.a.F();
      } else {
         return false;
      }
   }
}
