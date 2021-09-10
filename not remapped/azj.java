public class azj implements awd.a {
   protected final ave a;
   private long d = 0L;
   private final azh c;
   protected final bpq.a b;

   protected azj(azh var1, bpq.a var2) {
      this.c = var1;
      this.b = var2;
      this.a = ave.A();
   }

   public boolean a(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.c.b(var1);
      if (ave.J() - this.d < 250L) {
         this.c.f();
      }

      this.d = ave.J();
      return false;
   }

   public bpq.a a() {
      return this.b;
   }

   public void b(int var1, int var2, int var3, int var4, int var5, int var6) {
   }

   public void a(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8) {
      this.a.k.a(bnq.a("lanServer.title"), var2 + 32 + 3, var3 + 1, 16777215);
      this.a.k.a(this.b.a(), var2 + 32 + 3, var3 + 12, 8421504);
      if (this.a.t.x) {
         this.a.k.a(bnq.a("selectServer.hiddenAddress"), var2 + 32 + 3, var3 + 12 + 11, 3158064);
      } else {
         this.a.k.a(this.b.b(), var2 + 32 + 3, var3 + 12 + 11, 3158064);
      }

   }

   public void a(int var1, int var2, int var3) {
   }
}
