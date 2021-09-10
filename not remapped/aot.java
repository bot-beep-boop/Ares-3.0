import java.util.Random;

public abstract class aot {
   private final boolean a;

   public aot(boolean var1) {
      this.a = var1;
   }

   public void e() {
   }

   public aot() {
      this(false);
   }

   public abstract boolean b(adm var1, Random var2, cj var3);

   protected void a(adm var1, cj var2, alz var3) {
      if (this.a) {
         var1.a((cj)var2, (alz)var3, 3);
      } else {
         var1.a((cj)var2, (alz)var3, 2);
      }

   }
}
