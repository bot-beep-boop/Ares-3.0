import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Random;

public class tv extends tm {
   private static final Map<zd, float[]> bo = Maps.newEnumMap(zd.class);
   private qy bq = new qy(this);
   private int bp;
   private final xp bm = new xp(new xi(this) {
      final tv a;

      public boolean a(wn var1) {
         return false;
      }

      {
         this.a = var1;
      }
   }, 2, 1);

   public void a(byte var1) {
      if (var1 == 10) {
         this.bp = 40;
      } else {
         super.a(var1);
      }

   }

   public ph a(ph var1) {
      return this.b(var1);
   }

   protected void b(boolean var1, int var2) {
      if (!this.cm()) {
         this.a(new zx(zw.a(afi.L), 1, this.cl().a()), 0.0F);
      }

      int var3 = this.V.nextInt(2) + 1 + this.V.nextInt(1 + var2);

      for(int var4 = 0; var4 < var3; ++var4) {
         if (this.at()) {
            this.a(zy.bn, 1);
         } else {
            this.a(zy.bm, 1);
         }
      }

   }

   public void v() {
      this.l(false);
      if (this.j_()) {
         this.a(60);
      }

   }

   protected void a(cj var1, afh var2) {
      this.a("mob.sheep.step", 0.15F, 1.0F);
   }

   public boolean cm() {
      return (this.ac.a(16) & 16) != 0;
   }

   protected zw A() {
      return zw.a(afi.L);
   }

   public void a(dn var1) {
      super.a(var1);
      this.l(var1.n("Sheared"));
      this.b(zd.b(var1.d("Color")));
   }

   public void m() {
      if (this.o.D) {
         this.bp = Math.max(0, this.bp - 1);
      }

      super.m();
   }

   protected String z() {
      return "mob.sheep.say";
   }

   public void b(dn var1) {
      super.b(var1);
      var1.a("Sheared", this.cm());
      var1.a("Color", (byte)this.cl().a());
   }

   public pu a(ok var1, pu var2) {
      var2 = super.a(var1, var2);
      this.b(a(this.o.s));
      return var2;
   }

   public float aS() {
      return 0.95F * this.K;
   }

   private zd a(tm var1, tm var2) {
      int var3 = ((tv)var1).cl().b();
      int var4 = ((tv)var2).cl().b();
      this.bm.a(0).b(var3);
      this.bm.a(1).b(var4);
      zx var5 = abt.a().a(this.bm, ((tv)var1).o);
      int var6;
      if (var5 != null && var5.b() == zy.aW) {
         var6 = var5.i();
      } else {
         var6 = this.o.s.nextBoolean() ? var3 : var4;
      }

      return zd.a(var6);
   }

   static {
      bo.put(zd.a, new float[]{1.0F, 1.0F, 1.0F});
      bo.put(zd.b, new float[]{0.85F, 0.5F, 0.2F});
      bo.put(zd.c, new float[]{0.7F, 0.3F, 0.85F});
      bo.put(zd.d, new float[]{0.4F, 0.6F, 0.85F});
      bo.put(zd.e, new float[]{0.9F, 0.9F, 0.2F});
      bo.put(zd.f, new float[]{0.5F, 0.8F, 0.1F});
      bo.put(zd.g, new float[]{0.95F, 0.5F, 0.65F});
      bo.put(zd.h, new float[]{0.3F, 0.3F, 0.3F});
      bo.put(zd.i, new float[]{0.6F, 0.6F, 0.6F});
      bo.put(zd.j, new float[]{0.3F, 0.5F, 0.6F});
      bo.put(zd.k, new float[]{0.5F, 0.25F, 0.7F});
      bo.put(zd.l, new float[]{0.2F, 0.3F, 0.7F});
      bo.put(zd.m, new float[]{0.4F, 0.3F, 0.2F});
      bo.put(zd.n, new float[]{0.4F, 0.5F, 0.2F});
      bo.put(zd.o, new float[]{0.6F, 0.2F, 0.2F});
      bo.put(zd.p, new float[]{0.1F, 0.1F, 0.1F});
   }

   public static float[] a(zd var0) {
      return (float[])bo.get(var0);
   }

   protected void E() {
      this.bp = this.bq.f();
      super.E();
   }

   public tv(adm var1) {
      super(var1);
      this.a(0.9F, 1.3F);
      ((sv)this.s()).a(true);
      this.i.a(0, new ra(this));
      this.i.a(1, new rv(this, 1.25D));
      this.i.a(2, new qv(this, 1.0D));
      this.i.a(3, new sh(this, 1.1D, zy.O, false));
      this.i.a(4, new rc(this, 1.1D));
      this.i.a(5, this.bq);
      this.i.a(6, new rz(this, 1.0D));
      this.i.a(7, new ri(this, wn.class, 6.0F));
      this.i.a(8, new ry(this));
      this.bm.a(0, new zx(zy.aW, 1, 0));
      this.bm.a(1, new zx(zy.aW, 1, 0));
   }

   public zd cl() {
      return zd.b(this.ac.a(16) & 15);
   }

   public void b(zd var1) {
      byte var2 = this.ac.a(16);
      this.ac.b(16, (byte)(var2 & 240 | var1.a() & 15));
   }

   protected void aX() {
      super.aX();
      this.a((qb)vy.a).a(8.0D);
      this.a((qb)vy.d).a(0.23000000417232513D);
   }

   public boolean a(wn var1) {
      zx var2 = var1.bi.h();
      if (var2 != null && var2.b() == zy.be && !this.cm() && !this.j_()) {
         if (!this.o.D) {
            this.l(true);
            int var3 = 1 + this.V.nextInt(3);

            for(int var4 = 0; var4 < var3; ++var4) {
               uz var5 = this.a(new zx(zw.a(afi.L), 1, this.cl().a()), 1.0F);
               var5.w += (double)(this.V.nextFloat() * 0.05F);
               var5.v += (double)((this.V.nextFloat() - this.V.nextFloat()) * 0.1F);
               var5.x += (double)((this.V.nextFloat() - this.V.nextFloat()) * 0.1F);
            }
         }

         var2.a(1, (pr)var1);
         this.a("mob.sheep.shear", 1.0F, 1.0F);
      }

      return super.a(var1);
   }

   protected void h() {
      super.h();
      this.ac.a(16, new Byte((byte)0));
   }

   public float p(float var1) {
      if (this.bp <= 0) {
         return 0.0F;
      } else if (this.bp >= 4 && this.bp <= 36) {
         return 1.0F;
      } else {
         return this.bp < 4 ? ((float)this.bp - var1) / 4.0F : -((float)(this.bp - 40) - var1) / 4.0F;
      }
   }

   public tv b(ph var1) {
      tv var2 = (tv)var1;
      tv var3 = new tv(this.o);
      var3.b(this.a((tm)this, (tm)var2));
      return var3;
   }

   protected String bo() {
      return "mob.sheep.say";
   }

   public static zd a(Random var0) {
      int var1 = var0.nextInt(100);
      if (var1 < 5) {
         return zd.p;
      } else if (var1 < 10) {
         return zd.h;
      } else if (var1 < 15) {
         return zd.i;
      } else if (var1 < 18) {
         return zd.m;
      } else {
         return var0.nextInt(500) == 0 ? zd.g : zd.a;
      }
   }

   public void l(boolean var1) {
      byte var2 = this.ac.a(16);
      if (var1) {
         this.ac.b(16, (byte)(var2 | 16));
      } else {
         this.ac.b(16, (byte)(var2 & -17));
      }

   }

   public float q(float var1) {
      if (this.bp > 4 && this.bp <= 36) {
         float var2 = ((float)(this.bp - 4) - var1) / 32.0F;
         return 0.62831855F + 0.21991149F * ns.a(var2 * 28.7F);
      } else {
         return this.bp > 0 ? 0.62831855F : this.z / 57.295776F;
      }
   }

   protected String bp() {
      return "mob.sheep.say";
   }
}
