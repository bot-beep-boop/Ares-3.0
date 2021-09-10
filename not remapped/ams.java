import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class ams {
   private long f;
   private double d = 6.0E7D;
   private final List<amq> a = Lists.newArrayList();
   private double e;
   private int k;
   private long g;
   private double i;
   private int l;
   private int h;
   private double c = 0.0D;
   private double j;
   private double b = 0.0D;

   public int p() {
      return this.k;
   }

   public double g() {
      return this.c;
   }

   public long i() {
      return this.a() != amr.c ? this.f - System.currentTimeMillis() : 0L;
   }

   public double m() {
      return this.j;
   }

   public boolean a(aug var1) {
      return var1.d > this.b() && var1.a < this.d() && var1.f > this.c() && var1.c < this.e();
   }

   public void a(double var1) {
      this.d = var1;
      this.e = var1;
      this.f = System.currentTimeMillis();
      this.g = this.f;
      Iterator var3 = this.k().iterator();

      while(var3.hasNext()) {
         amq var4 = (amq)var3.next();
         var4.a(this, var1);
      }

   }

   public ams() {
      this.e = this.d;
      this.h = 29999984;
      this.i = 0.2D;
      this.j = 5.0D;
      this.k = 15;
      this.l = 5;
   }

   public double j() {
      return this.e;
   }

   public double d() {
      double var1 = this.f() + this.h() / 2.0D;
      if (var1 > (double)this.h) {
         var1 = (double)this.h;
      }

      return var1;
   }

   public void c(double var1, double var3) {
      this.b = var1;
      this.c = var3;
      Iterator var5 = this.k().iterator();

      while(var5.hasNext()) {
         amq var6 = (amq)var5.next();
         var6.a(this, var1, var3);
      }

   }

   public double e() {
      double var1 = this.g() + this.h() / 2.0D;
      if (var1 > (double)this.h) {
         var1 = (double)this.h;
      }

      return var1;
   }

   public boolean a(cj var1) {
      return (double)(var1.n() + 1) > this.b() && (double)var1.n() < this.d() && (double)(var1.p() + 1) > this.c() && (double)var1.p() < this.e();
   }

   public double f() {
      return this.b;
   }

   public double a(pk var1) {
      return this.b(var1.s, var1.u);
   }

   public void c(double var1) {
      this.i = var1;
      Iterator var3 = this.k().iterator();

      while(var3.hasNext()) {
         amq var4 = (amq)var3.next();
         var4.b(this, var1);
      }

   }

   public boolean a(adg var1) {
      return (double)var1.e() > this.b() && (double)var1.c() < this.d() && (double)var1.f() > this.c() && (double)var1.d() < this.e();
   }

   public void b(double var1) {
      this.j = var1;
      Iterator var3 = this.k().iterator();

      while(var3.hasNext()) {
         amq var4 = (amq)var3.next();
         var4.c(this, var1);
      }

   }

   public int l() {
      return this.h;
   }

   public int q() {
      return this.l;
   }

   public double h() {
      if (this.a() != amr.c) {
         double var1 = (double)((float)(System.currentTimeMillis() - this.g) / (float)(this.f - this.g));
         if (!(var1 >= 1.0D)) {
            return this.d + (this.e - this.d) * var1;
         }

         this.a(this.e);
      }

      return this.d;
   }

   public void a(int var1) {
      this.h = var1;
   }

   protected List<amq> k() {
      return Lists.newArrayList(this.a);
   }

   public amr a() {
      if (this.e < this.d) {
         return amr.b;
      } else {
         return this.e > this.d ? amr.a : amr.c;
      }
   }

   public double o() {
      return this.f == this.g ? 0.0D : Math.abs(this.d - this.e) / (double)(this.f - this.g);
   }

   public double b(double var1, double var3) {
      double var5 = var3 - this.c();
      double var7 = this.e() - var3;
      double var9 = var1 - this.b();
      double var11 = this.d() - var1;
      double var13 = Math.min(var9, var11);
      var13 = Math.min(var13, var5);
      return Math.min(var13, var7);
   }

   public void b(int var1) {
      this.k = var1;
      Iterator var2 = this.k().iterator();

      while(var2.hasNext()) {
         amq var3 = (amq)var2.next();
         var3.a(this, var1);
      }

   }

   public void a(double var1, double var3, long var5) {
      this.d = var1;
      this.e = var3;
      this.g = System.currentTimeMillis();
      this.f = this.g + var5;
      Iterator var7 = this.k().iterator();

      while(var7.hasNext()) {
         amq var8 = (amq)var7.next();
         var8.a(this, var1, var3, var5);
      }

   }

   public void c(int var1) {
      this.l = var1;
      Iterator var2 = this.k().iterator();

      while(var2.hasNext()) {
         amq var3 = (amq)var2.next();
         var3.b(this, var1);
      }

   }

   public double c() {
      double var1 = this.g() - this.h() / 2.0D;
      if (var1 < (double)(-this.h)) {
         var1 = (double)(-this.h);
      }

      return var1;
   }

   public void a(amq var1) {
      this.a.add(var1);
   }

   public double n() {
      return this.i;
   }

   public double b() {
      double var1 = this.f() - this.h() / 2.0D;
      if (var1 < (double)(-this.h)) {
         var1 = (double)(-this.h);
      }

      return var1;
   }
}
