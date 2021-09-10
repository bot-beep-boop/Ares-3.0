import com.google.common.collect.Maps;
import java.util.Map;

public class biu {
   public adm b;
   public double i;
   public float f;
   private bln m;
   private boolean s = true;
   private avn n;
   private Map<String, bln> l = Maps.newHashMap();
   public double j;
   public pk d;
   public double h;
   public float e;
   private double p;
   public avh g;
   private double q;
   private boolean r = false;
   private Map<Class<? extends pk>, biv<? extends pk>> k = Maps.newHashMap();
   private double o;
   private boolean t = false;
   public bmj a;
   public pk c;

   public boolean a(pk var1, double var2, double var4, double var6, float var8, float var9, boolean var10) {
      biv var11 = null;

      try {
         var11 = this.a(var1);
         if (var11 != null && this.a != null) {
            try {
               if (var11 instanceof bjl) {
                  ((bjl)var11).a(this.r);
               }

               var11.a(var1, var2, var4, var6, var8, var9);
            } catch (Throwable var18) {
               throw new e(b.a(var18, "Rendering entity in world"));
            }

            try {
               if (!this.r) {
                  var11.b(var1, var2, var4, var6, var8, var9);
               }
            } catch (Throwable var17) {
               throw new e(b.a(var17, "Post-rendering entity in world"));
            }

            if (this.t && !var1.ax() && !var10) {
               try {
                  this.b(var1, var2, var4, var6, var8, var9);
               } catch (Throwable var16) {
                  throw new e(b.a(var16, "Rendering entity hitbox in world"));
               }
            }
         } else if (this.a != null) {
            return false;
         }

         return true;
      } catch (Throwable var19) {
         b var13 = b.a(var19, "Rendering entity in world");
         c var14 = var13.a("Entity being rendered");
         var1.a(var14);
         c var15 = var13.a("Renderer details");
         var15.a((String)"Assigned renderer", (Object)var11);
         var15.a((String)"Location", (Object)c.a(var2, var4, var6));
         var15.a((String)"Rotation", (Object)var8);
         var15.a((String)"Delta", (Object)var9);
         throw new e(var13);
      }
   }

   public boolean a(pk var1, float var2) {
      return this.a(var1, var2, false);
   }

   private void b(pk var1, double var2, double var4, double var6, float var8, float var9) {
      bfl.a(false);
      bfl.x();
      bfl.f();
      bfl.p();
      bfl.k();
      float var10 = var1.J / 2.0F;
      aug var11 = var1.aR();
      aug var12 = new aug(var11.a - var1.s + var2, var11.b - var1.t + var4, var11.c - var1.u + var6, var11.d - var1.s + var2, var11.e - var1.t + var4, var11.f - var1.u + var6);
      bfr.a(var12, 255, 255, 255, 255);
      if (var1 instanceof pr) {
         float var13 = 0.01F;
         bfr.a(new aug(var2 - (double)var10, var4 + (double)var1.aS() - 0.009999999776482582D, var6 - (double)var10, var2 + (double)var10, var4 + (double)var1.aS() + 0.009999999776482582D, var6 + (double)var10), 255, 0, 0, 255);
      }

      bfx var16 = bfx.a();
      bfd var14 = var16.c();
      aui var15 = var1.d(var9);
      var14.a(3, bms.f);
      var14.b(var2, var4 + (double)var1.aS(), var6).b(0, 0, 255, 255).d();
      var14.b(var2 + var15.a * 2.0D, var4 + (double)var1.aS() + var15.b * 2.0D, var6 + var15.c * 2.0D).b(0, 0, 255, 255).d();
      var16.b();
      bfl.w();
      bfl.e();
      bfl.o();
      bfl.k();
      bfl.a(true);
   }

   public double b(double var1, double var3, double var5) {
      double var7 = var1 - this.h;
      double var9 = var3 - this.i;
      double var11 = var5 - this.j;
      return var7 * var7 + var9 * var9 + var11 * var11;
   }

   public boolean a(pk var1, bia var2, double var3, double var5, double var7) {
      biv var9 = this.a(var1);
      return var9 != null && var9.a(var1, var2, var3, var5, var7);
   }

   public void c(boolean var1) {
      this.r = var1;
   }

   public void a(double var1, double var3, double var5) {
      this.o = var1;
      this.p = var3;
      this.q = var5;
   }

   public boolean b() {
      return this.t;
   }

   public biu(bmj var1, bjh var2) {
      this.a = var1;
      this.k.put(vm.class, new bil(this));
      this.k.put(wc.class, new bka(this));
      this.k.put(tt.class, new bjs(this, new bbq(), 0.7F));
      this.k.put(tv.class, new bjv(this, new bbw(), 0.7F));
      this.k.put(to.class, new bin(this, new bbb(), 0.7F));
      this.k.put(tr.class, new bjp(this, new bbb(), 0.7F));
      this.k.put(ua.class, new bkl(this, new bcm(), 0.5F));
      this.k.put(tn.class, new bim(this, new bba(), 0.3F));
      this.k.put(ts.class, new bjq(this, new bbp(), 0.4F));
      this.k.put(tu.class, new bju(this, new bbu(), 0.3F));
      this.k.put(vz.class, new bjw(this));
      this.k.put(vp.class, new bit(this));
      this.k.put(vn.class, new bio(this));
      this.k.put(vo.class, new bis(this));
      this.k.put(tw.class, new bjz(this));
      this.k.put(wa.class, new bjx(this));
      this.k.put(wd.class, new bki(this));
      this.k.put(vl.class, new bij(this));
      this.k.put(vw.class, new bjt(this));
      this.k.put(we.class, new bkm(this));
      this.k.put(wb.class, new bjy(this, new bcc(16), 0.25F));
      this.k.put(vu.class, new bji(this));
      this.k.put(vs.class, new bjb(this, new bcn(), 0.5F, 6.0F));
      this.k.put(vr.class, new bja(this));
      this.k.put(tx.class, new bkb(this, new bcf(), 0.7F));
      this.k.put(wi.class, new bkh(this));
      this.k.put(ty.class, new bkg(this));
      this.k.put(tk.class, new bii(this));
      this.k.put(vt.class, new bjc(this));
      this.k.put(ug.class, new bir(this));
      this.k.put(uf.class, new biq(this));
      this.k.put(uk.class, new bkj(this));
      this.k.put(pk.class, new bip(this));
      this.k.put(uq.class, new bjr(this));
      this.k.put(uo.class, new bjg(this, var2));
      this.k.put(up.class, new bjj(this));
      this.k.put(wq.class, new bih(this));
      this.k.put(wx.class, new bkc(this, zy.aD, var2));
      this.k.put(xa.class, new bkc(this, zy.bu, var2));
      this.k.put(wr.class, new bkc(this, zy.bH, var2));
      this.k.put(wz.class, new bkc(this, zy.aP, var2));
      this.k.put(xc.class, new bkd(this, var2));
      this.k.put(xb.class, new bkc(this, zy.bK, var2));
      this.k.put(wt.class, new bkc(this, zy.cb, var2));
      this.k.put(wu.class, new biy(this, 2.0F));
      this.k.put(ww.class, new biy(this, 0.5F));
      this.k.put(xd.class, new bkk(this));
      this.k.put(uz.class, new bjf(this, var2));
      this.k.put(pp.class, new biw(this));
      this.k.put(vj.class, new bkf(this));
      this.k.put(uy.class, new bix(this));
      this.k.put(um.class, new big(this));
      this.k.put(vi.class, new bke(this));
      this.k.put(vh.class, new bjn(this));
      this.k.put(va.class, new bjm(this));
      this.k.put(ux.class, new bik(this));
      this.k.put(ur.class, new biz(this));
      this.k.put(tp.class, new bjd(this, new bbh(), 0.75F));
      this.k.put(uv.class, new bjk(this));
      this.m = new bln(this);
      this.l.put("default", this.m);
      this.l.put("slim", new bln(this, true));
   }

   public void a(adm var1, avn var2, pk var3, pk var4, avh var5, float var6) {
      this.b = var1;
      this.g = var5;
      this.c = var3;
      this.d = var4;
      this.n = var2;
      if (var3 instanceof pr && ((pr)var3).bJ()) {
         alz var7 = var1.p(new cj(var3));
         afh var8 = var7.c();
         if (var8 == afi.C) {
            int var9 = ((cq)var7.b(afg.O)).b();
            this.e = (float)(var9 * 90 + 180);
            this.f = 0.0F;
         }
      } else {
         this.e = var3.A + (var3.y - var3.A) * var6;
         this.f = var3.B + (var3.z - var3.B) * var6;
      }

      if (var5.aB == 2) {
         this.e += 180.0F;
      }

      this.h = var3.P + (var3.s - var3.P) * (double)var6;
      this.i = var3.Q + (var3.t - var3.Q) * (double)var6;
      this.j = var3.R + (var3.u - var3.R) * (double)var6;
   }

   public void a(float var1) {
      this.e = var1;
   }

   public boolean a() {
      return this.s;
   }

   public void a(adm var1) {
      this.b = var1;
   }

   public <T extends pk> biv<T> a(pk var1) {
      if (var1 instanceof bet) {
         String var2 = ((bet)var1).l();
         bln var3 = (bln)this.l.get(var2);
         return var3 != null ? var3 : this.m;
      } else {
         return this.a(var1.getClass());
      }
   }

   public <T extends pk> biv<T> a(Class<? extends pk> var1) {
      biv var2 = (biv)this.k.get(var1);
      if (var2 == null && var1 != pk.class) {
         var2 = this.a(var1.getSuperclass());
         this.k.put(var1, var2);
      }

      return var2;
   }

   public avn c() {
      return this.n;
   }

   public boolean a(pk var1, double var2, double var4, double var6, float var8, float var9) {
      return this.a(var1, var2, var4, var6, var8, var9, false);
   }

   public void b(boolean var1) {
      this.t = var1;
   }

   public boolean a(pk var1, float var2, boolean var3) {
      if (var1.W == 0) {
         var1.P = var1.s;
         var1.Q = var1.t;
         var1.R = var1.u;
      }

      double var4 = var1.P + (var1.s - var1.P) * (double)var2;
      double var6 = var1.Q + (var1.t - var1.Q) * (double)var2;
      double var8 = var1.R + (var1.u - var1.R) * (double)var2;
      float var10 = var1.A + (var1.y - var1.A) * var2;
      int var11 = var1.b(var2);
      if (var1.at()) {
         var11 = 15728880;
      }

      int var12 = var11 % 65536;
      int var13 = var11 / 65536;
      bqs.a(bqs.r, (float)var12 / 1.0F, (float)var13 / 1.0F);
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      return this.a(var1, var4 - this.o, var6 - this.p, var8 - this.q, var10, var2, var3);
   }

   public void b(pk var1, float var2) {
      double var3 = var1.P + (var1.s - var1.P) * (double)var2;
      double var5 = var1.Q + (var1.t - var1.Q) * (double)var2;
      double var7 = var1.R + (var1.u - var1.R) * (double)var2;
      biv var9 = this.a(var1);
      if (var9 != null && this.a != null) {
         int var10 = var1.b(var2);
         int var11 = var10 % 65536;
         int var12 = var10 / 65536;
         bqs.a(bqs.r, (float)var11 / 1.0F, (float)var12 / 1.0F);
         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         var9.a(var1, var3 - this.o, var5 - this.p, var7 - this.q);
      }

   }

   public void a(boolean var1) {
      this.s = var1;
   }
}
