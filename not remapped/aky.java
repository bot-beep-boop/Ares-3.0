import java.util.Iterator;
import java.util.List;

public class aky extends alk implements km, og {
   public boolean a;
   public aky h;
   public int l;
   private int o;
   public aky g;
   private zx[] m = new zx[27];
   public aky i;
   public aky f;
   public float k;
   public float j;
   private String p;
   private int n;

   public void a(dn var1) {
      super.a(var1);
      du var2 = var1.c("Items", 10);
      this.m = new zx[this.o_()];
      if (var1.b("CustomName", 8)) {
         this.p = var1.j("CustomName");
      }

      for(int var3 = 0; var3 < var2.c(); ++var3) {
         dn var4 = var2.b(var3);
         int var5 = var4.d("Slot") & 255;
         if (var5 >= 0 && var5 < this.m.length) {
            this.m[var5] = zx.a(var4);
         }
      }

   }

   public boolean a(wn var1) {
      if (this.b.s(this.c) != this) {
         return false;
      } else {
         return !(var1.e((double)this.c.n() + 0.5D, (double)this.c.o() + 0.5D, (double)this.c.p() + 0.5D) > 64.0D);
      }
   }

   public void b(dn var1) {
      super.b(var1);
      du var2 = new du();

      for(int var3 = 0; var3 < this.m.length; ++var3) {
         if (this.m[var3] != null) {
            dn var4 = new dn();
            var4.a("Slot", (byte)var3);
            this.m[var3].b(var4);
            var2.a((eb)var4);
         }
      }

      var1.a((String)"Items", (eb)var2);
      if (this.l_()) {
         var1.a("CustomName", this.p);
      }

   }

   public void b(wn var1) {
      if (!var1.v()) {
         if (this.l < 0) {
            this.l = 0;
         }

         ++this.l;
         this.b.c(this.c, this.w(), 1, this.l);
         this.b.c(this.c, this.w());
         this.b.c(this.c.b(), this.w());
      }

   }

   public boolean l_() {
      return this.p != null && this.p.length() > 0;
   }

   public String k() {
      return "minecraft:chest";
   }

   public zx a(int var1) {
      return this.m[var1];
   }

   public int q_() {
      return 64;
   }

   public void a(String var1) {
      this.p = var1;
   }

   public boolean b(int var1, zx var2) {
      return true;
   }

   public int n() {
      if (this.o == -1) {
         if (this.b == null || !(this.w() instanceof afs)) {
            return 0;
         }

         this.o = ((afs)this.w()).b;
      }

      return this.o;
   }

   public void a(int var1, zx var2) {
      this.m[var1] = var2;
      if (var2 != null && var2.b > this.q_()) {
         var2.b = this.q_();
      }

      this.p_();
   }

   public String e_() {
      return this.l_() ? this.p : "container.chest";
   }

   public aky() {
      this.o = -1;
   }

   public void l() {
      for(int var1 = 0; var1 < this.m.length; ++var1) {
         this.m[var1] = null;
      }

   }

   public void b(int var1, int var2) {
   }

   public xi a(wm var1, wn var2) {
      return new xo(var1, this, var2);
   }

   public int g() {
      return 0;
   }

   public int o_() {
      return 27;
   }

   public void c(wn var1) {
      if (!var1.v() && this.w() instanceof afs) {
         --this.l;
         this.b.c(this.c, this.w(), 1, this.l);
         this.b.c(this.c, this.w());
         this.b.c(this.c.b(), this.w());
      }

   }

   public boolean c(int var1, int var2) {
      if (var1 == 1) {
         this.l = var2;
         return true;
      } else {
         return super.c(var1, var2);
      }
   }

   public int a_(int var1) {
      return 0;
   }

   private boolean b(cj var1) {
      if (this.b == null) {
         return false;
      } else {
         afh var2 = this.b.p(var1).c();
         return var2 instanceof afs && ((afs)var2).b == this.n();
      }
   }

   public aky(int var1) {
      this.o = var1;
   }

   protected aky a(cq var1) {
      cj var2 = this.c.a(var1);
      if (this.b(var2)) {
         akw var3 = this.b.s(var2);
         if (var3 instanceof aky) {
            aky var4 = (aky)var3;
            var4.a(this, var1.d());
            return var4;
         }
      }

      return null;
   }

   public zx b(int var1) {
      if (this.m[var1] != null) {
         zx var2 = this.m[var1];
         this.m[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void y() {
      super.y();
      this.E();
      this.m();
   }

   private void a(aky var1, cq var2) {
      if (var1.x()) {
         this.a = false;
      } else if (this.a) {
         switch(var2) {
         case c:
            if (this.f != var1) {
               this.a = false;
            }
            break;
         case d:
            if (this.i != var1) {
               this.a = false;
            }
            break;
         case f:
            if (this.g != var1) {
               this.a = false;
            }
            break;
         case e:
            if (this.h != var1) {
               this.a = false;
            }
         }
      }

   }

   public void E() {
      super.E();
      this.a = false;
   }

   public void m() {
      if (!this.a) {
         this.a = true;
         this.h = this.a(cq.e);
         this.g = this.a(cq.f);
         this.f = this.a(cq.c);
         this.i = this.a(cq.d);
      }
   }

   public void c() {
      this.m();
      int var1 = this.c.n();
      int var2 = this.c.o();
      int var3 = this.c.p();
      ++this.n;
      float var4;
      if (!this.b.D && this.l != 0 && (this.n + var1 + var2 + var3) % 200 == 0) {
         this.l = 0;
         var4 = 5.0F;
         List var5 = this.b.a(wn.class, new aug((double)((float)var1 - var4), (double)((float)var2 - var4), (double)((float)var3 - var4), (double)((float)(var1 + 1) + var4), (double)((float)(var2 + 1) + var4), (double)((float)(var3 + 1) + var4)));
         Iterator var6 = var5.iterator();

         label128:
         while(true) {
            og var8;
            do {
               wn var7;
               do {
                  if (!var6.hasNext()) {
                     break label128;
                  }

                  var7 = (wn)var6.next();
               } while(!(var7.bk instanceof xo));

               var8 = ((xo)var7.bk).e();
            } while(var8 != this && (!(var8 instanceof of) || !((of)var8).a((og)this)));

            ++this.l;
         }
      }

      this.k = this.j;
      var4 = 0.1F;
      double var14;
      if (this.l > 0 && this.j == 0.0F && this.f == null && this.h == null) {
         double var11 = (double)var1 + 0.5D;
         var14 = (double)var3 + 0.5D;
         if (this.i != null) {
            var14 += 0.5D;
         }

         if (this.g != null) {
            var11 += 0.5D;
         }

         this.b.a(var11, (double)var2 + 0.5D, var14, "random.chestopen", 0.5F, this.b.s.nextFloat() * 0.1F + 0.9F);
      }

      if (this.l == 0 && this.j > 0.0F || this.l > 0 && this.j < 1.0F) {
         float var12 = this.j;
         if (this.l > 0) {
            this.j += var4;
         } else {
            this.j -= var4;
         }

         if (this.j > 1.0F) {
            this.j = 1.0F;
         }

         float var13 = 0.5F;
         if (this.j < var13 && var12 >= var13 && this.f == null && this.h == null) {
            var14 = (double)var1 + 0.5D;
            double var9 = (double)var3 + 0.5D;
            if (this.i != null) {
               var9 += 0.5D;
            }

            if (this.g != null) {
               var14 += 0.5D;
            }

            this.b.a(var14, (double)var2 + 0.5D, var9, "random.chestclosed", 0.5F, this.b.s.nextFloat() * 0.1F + 0.9F);
         }

         if (this.j < 0.0F) {
            this.j = 0.0F;
         }
      }

   }

   public zx a(int var1, int var2) {
      if (this.m[var1] != null) {
         zx var3;
         if (this.m[var1].b <= var2) {
            var3 = this.m[var1];
            this.m[var1] = null;
            this.p_();
            return var3;
         } else {
            var3 = this.m[var1].a(var2);
            if (this.m[var1].b == 0) {
               this.m[var1] = null;
            }

            this.p_();
            return var3;
         }
      } else {
         return null;
      }
   }
}
