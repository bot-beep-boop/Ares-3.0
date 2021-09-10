import java.util.List;

public abstract class azu extends awd {
   protected final ave u;
   protected final List<azp> v;

   public azu(ave var1, int var2, int var3, List<azp> var4) {
      super(var1, var2, var3, 32, var3 - 55 + 4, 36);
      this.u = var1;
      this.v = var4;
      this.k = false;
      this.a(true, (int)((float)var1.k.a * 1.5F));
   }

   public awd.a b(int var1) {
      return this.c(var1);
   }

   protected abstract String e();

   protected int d() {
      return this.f - 6;
   }

   public int c() {
      return this.b;
   }

   protected void a(int var1, int var2, bfx var3) {
      String var4 = .a.t + "" + .a.r + this.e();
      this.u.k.a(var4, var1 + this.b / 2 - this.u.k.a(var4) / 2, Math.min(this.d + 3, var2), 16777215);
   }

   public azp c(int var1) {
      return (azp)this.f().get(var1);
   }

   protected int b() {
      return this.f().size();
   }

   public List<azp> f() {
      return this.v;
   }
}
