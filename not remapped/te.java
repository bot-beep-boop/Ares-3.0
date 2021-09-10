public class te {
   private int f;
   private final cq c;
   private int d;
   private final cj a;
   private final cj b;
   private boolean e;

   public int c() {
      return this.f;
   }

   public void b() {
      ++this.f;
   }

   public int b(int var1, int var2, int var3) {
      return (int)this.a.c((double)var1, (double)var2, (double)var3);
   }

   public int h() {
      return this.d;
   }

   public te(cj var1, cq var2, int var3) {
      this.a = var1;
      this.c = var2;
      this.b = var1.a(var2, 2);
      this.d = var3;
   }

   public int b(cj var1) {
      return (int)this.b.i(var1);
   }

   public int f() {
      return this.c.g() * 2;
   }

   public int g() {
      return this.c.i() * 2;
   }

   private static cq a(int var0, int var1) {
      if (var0 < 0) {
         return cq.e;
      } else if (var0 > 0) {
         return cq.f;
      } else {
         return var1 < 0 ? cq.c : cq.d;
      }
   }

   public boolean i() {
      return this.e;
   }

   public cj d() {
      return this.a;
   }

   public te(cj var1, int var2, int var3, int var4) {
      this(var1, a(var2, var3), var4);
   }

   public cj e() {
      return this.b;
   }

   public boolean c(cj var1) {
      int var2 = var1.n() - this.a.n();
      int var3 = var1.p() - this.a.o();
      return var2 * this.c.g() + var3 * this.c.i() >= 0;
   }

   public int a(cj var1) {
      return (int)var1.i(this.d());
   }

   public void a(int var1) {
      this.d = var1;
   }

   public void a() {
      this.f = 0;
   }

   public void a(boolean var1) {
      this.e = var1;
   }
}
