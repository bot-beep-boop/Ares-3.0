public class mq extends mw {
   private final String k;
   public final int a;
   public final int b;
   public final zx d;
   public final mq c;
   private ms l;
   private boolean m;

   public mw i() {
      return this.a();
   }

   public mq(String var1, String var2, int var3, int var4, zx var5, mq var6) {
      super(var1, new fb("achievement." + var2, new Object[0]));
      this.d = var5;
      this.k = "achievement." + var2 + ".desc";
      this.a = var3;
      this.b = var4;
      if (var3 < mr.a) {
         a = var3;
      }

      if (var4 < mr.b) {
         b = var4;
      }

      if (var3 > mr.c) {
         mr.c = var3;
      }

      if (var4 > mr.d) {
         mr.d = var4;
      }

      this.c = var6;
   }

   public boolean d() {
      return true;
   }

   public mq c() {
      super.h();
      mr.e.add(this);
      return this;
   }

   public mw b(Class var1) {
      return this.a(var1);
   }

   public String f() {
      return this.l != null ? this.l.a(di.a(this.k)) : di.a(this.k);
   }

   public mq a(ms var1) {
      this.l = var1;
      return this;
   }

   public mq b() {
      this.m = true;
      return this;
   }

   public mq a(Class<? extends mz> var1) {
      return (mq)super.b(var1);
   }

   public mq a() {
      this.f = true;
      return this;
   }

   public boolean g() {
      return this.m;
   }

   public mq(String var1, String var2, int var3, int var4, zw var5, mq var6) {
      this(var1, var2, var3, var4, new zx(var5), var6);
   }

   public mq(String var1, String var2, int var3, int var4, afh var5, mq var6) {
      this(var1, var2, var3, var4, new zx(var5), var6);
   }

   public mw h() {
      return this.c();
   }

   public eu e() {
      eu var1 = super.e();
      var1.b().a(this.g() ? a.f : a.k);
      return var1;
   }
}
