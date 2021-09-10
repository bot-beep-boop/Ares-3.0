import io.netty.buffer.ByteBuf;

public class vc extends va {
   private int b = 0;
   private final adc a = new adc(this) {
      final vc a;

      public cj c() {
         return new cj(this.a.s, this.a.t + 0.5D, this.a.u);
      }

      public void a(ByteBuf var1) {
         var1.writeInt(this.a.F());
      }

      public adm e() {
         return this.a.o;
      }

      public pk f() {
         return this.a;
      }

      public aui d() {
         return new aui(this.a.s, this.a.t, this.a.u);
      }

      public int i() {
         return 1;
      }

      {
         this.a = var1;
      }

      public void h() {
         this.a.H().b(23, this.l());
         this.a.H().b(24, eu.a.a(this.k()));
      }
   };

   public vc(adm var1) {
      super(var1);
   }

   public boolean e(wn var1) {
      this.a.a(var1);
      return false;
   }

   protected void a(dn var1) {
      super.a(var1);
      this.a.b(var1);
      this.H().b(23, this.j().l());
      this.H().b(24, eu.a.a(this.j().k()));
   }

   public vc(adm var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   protected void h() {
      super.h();
      this.H().a(23, "");
      this.H().a(24, "");
   }

   public va.a s() {
      return va.a.g;
   }

   public alz u() {
      return afi.bX.Q();
   }

   public void a(int var1, int var2, int var3, boolean var4) {
      if (var4 && this.W - this.b >= 4) {
         this.j().a(this.o);
         this.b = this.W;
      }

   }

   public void i(int var1) {
      super.i(var1);
      if (var1 == 24) {
         try {
            this.a.b(eu.a.a(this.H().e(24)));
         } catch (Throwable var3) {
         }
      } else if (var1 == 23) {
         this.a.a(this.H().e(23));
      }

   }

   protected void b(dn var1) {
      super.b(var1);
      this.a.a(var1);
   }

   public adc j() {
      return this.a;
   }
}
