import io.netty.buffer.ByteBuf;

public class akz extends akw {
   private final adc a = new adc(this) {
      final akz a;

      public void h() {
         this.a.z().h(this.a.c);
      }

      public cj c() {
         return this.a.c;
      }

      public int i() {
         return 0;
      }

      public pk f() {
         return null;
      }

      {
         this.a = var1;
      }

      public aui d() {
         return new aui((double)this.a.c.n() + 0.5D, (double)this.a.c.o() + 0.5D, (double)this.a.c.p() + 0.5D);
      }

      public void a(String var1) {
         super.a(var1);
         this.a.p_();
      }

      public void a(ByteBuf var1) {
         var1.writeInt(this.a.c.n());
         var1.writeInt(this.a.c.o());
         var1.writeInt(this.a.c.p());
      }

      public adm e() {
         return this.a.z();
      }
   };

   public void b(dn var1) {
      super.b(var1);
      this.a.a(var1);
   }

   public void a(dn var1) {
      super.a(var1);
      this.a.b(var1);
   }

   public ff y_() {
      dn var1 = new dn();
      this.b(var1);
      return new ft(this.c, 2, var1);
   }

   public adc b() {
      return this.a;
   }

   public n c() {
      return this.a.n();
   }

   public boolean F() {
      return true;
   }
}
