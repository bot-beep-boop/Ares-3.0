import java.util.Iterator;
import java.util.List;

public abstract class sw {
   private int g;
   protected double e;
   private final qc a;
   protected adm c;
   private int f;
   protected ps b;
   protected asx d;
   private aui h = new aui(0.0D, 0.0D, 0.0D);
   private final asy j;
   private float i = 1.0F;

   public asx j() {
      return this.d;
   }

   public boolean a(double var1, double var3, double var5, double var7) {
      asx var9 = this.a((double)ns.c(var1), (double)((int)var3), (double)ns.c(var5));
      return this.a(var9, var7);
   }

   public void a(float var1) {
      this.i = var1;
   }

   protected void a(aui var1) {
      if (this.f - this.g > 100) {
         if (var1.g(this.h) < 2.25D) {
            this.n();
         }

         this.g = this.f;
         this.h = var1;
      }

   }

   public boolean m() {
      return this.d == null || this.d.b();
   }

   public asx a(pk var1) {
      if (!this.b()) {
         return null;
      } else {
         float var2 = this.i();
         this.c.B.a("pathfind");
         cj var3 = (new cj(this.b)).a();
         int var4 = (int)(var2 + 16.0F);
         adv var5 = new adv(this.c, var3.a(-var4, -var4, -var4), var3.a(var4, var4, var4), 0);
         asx var6 = this.j.a((adq)var5, (pk)this.b, (pk)var1, var2);
         this.c.B.b();
         return var6;
      }
   }

   public sw(ps var1, adm var2) {
      this.b = var1;
      this.c = var2;
      this.a = var1.a((qb)vy.b);
      this.j = this.a();
   }

   protected void l() {
      aui var1 = this.c();
      int var2 = this.d.d();

      for(int var3 = this.d.e(); var3 < this.d.d(); ++var3) {
         if (this.d.a(var3).b != (int)var1.b) {
            var2 = var3;
            break;
         }
      }

      float var8 = this.b.J * this.b.J * this.i;

      int var4;
      for(var4 = this.d.e(); var4 < var2; ++var4) {
         aui var5 = this.d.a(this.b, var4);
         if (var1.g(var5) < (double)var8) {
            this.d.c(var4 + 1);
         }
      }

      var4 = ns.f(this.b.J);
      int var9 = (int)this.b.K + 1;
      int var6 = var4;

      for(int var7 = var2 - 1; var7 >= this.d.e(); --var7) {
         if (this.a(var1, this.d.a(this.b, var7), var4, var9, var6)) {
            this.d.c(var7);
            break;
         }
      }

      this.a(var1);
   }

   public void k() {
      ++this.f;
      if (!this.m()) {
         aui var1;
         if (this.b()) {
            this.l();
         } else if (this.d != null && this.d.e() < this.d.d()) {
            var1 = this.c();
            aui var2 = this.d.a(this.b, this.d.e());
            if (var1.b > var2.b && !this.b.C && ns.c(var1.a) == ns.c(var2.a) && ns.c(var1.c) == ns.c(var2.c)) {
               this.d.c(this.d.e() + 1);
            }
         }

         if (!this.m()) {
            var1 = this.d.a((pk)this.b);
            if (var1 != null) {
               aug var8 = (new aug(var1.a, var1.b, var1.c, var1.a, var1.b, var1.c)).b(0.5D, 0.5D, 0.5D);
               List var3 = this.c.a((pk)this.b, (aug)var8.a(0.0D, -1.0D, 0.0D));
               double var4 = -1.0D;
               var8 = var8.c(0.0D, 1.0D, 0.0D);

               aug var7;
               for(Iterator var6 = var3.iterator(); var6.hasNext(); var4 = var7.b(var8, var4)) {
                  var7 = (aug)var6.next();
               }

               this.b.q().a(var1.a, var1.b + var4, var1.c, this.e);
            }
         }
      }
   }

   protected abstract aui c();

   protected abstract boolean b();

   public boolean a(pk var1, double var2) {
      asx var4 = this.a(var1);
      return var4 != null ? this.a(var4, var2) : false;
   }

   public asx a(cj var1) {
      if (!this.b()) {
         return null;
      } else {
         float var2 = this.i();
         this.c.B.a("pathfind");
         cj var3 = new cj(this.b);
         int var4 = (int)(var2 + 8.0F);
         adv var5 = new adv(this.c, var3.a(-var4, -var4, -var4), var3.a(var4, var4, var4), 0);
         asx var6 = this.j.a((adq)var5, (pk)this.b, (cj)var1, var2);
         this.c.B.b();
         return var6;
      }
   }

   public float i() {
      return (float)this.a.e();
   }

   protected void d() {
   }

   public void a(double var1) {
      this.e = var1;
   }

   public boolean a(asx var1, double var2) {
      if (var1 == null) {
         this.d = null;
         return false;
      } else {
         if (!var1.a(this.d)) {
            this.d = var1;
         }

         this.d();
         if (this.d.d() == 0) {
            return false;
         } else {
            this.e = var2;
            aui var4 = this.c();
            this.g = this.f;
            this.h = var4;
            return true;
         }
      }
   }

   protected abstract asy a();

   public void n() {
      this.d = null;
   }

   protected boolean o() {
      return this.b.V() || this.b.ab();
   }

   protected abstract boolean a(aui var1, aui var2, int var3, int var4, int var5);

   public final asx a(double var1, double var3, double var5) {
      return this.a(new cj(ns.c(var1), (int)var3, ns.c(var5)));
   }
}
