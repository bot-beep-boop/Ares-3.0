import java.util.Random;

public class any {
   protected int a = 8;
   protected Random b = new Random();
   protected adm c;

   protected void a(adm var1, int var2, int var3, int var4, int var5, ans var6) {
   }

   public void a(amv var1, adm var2, int var3, int var4, ans var5) {
      int var6 = this.a;
      this.c = var2;
      this.b.setSeed(var2.J());
      long var7 = this.b.nextLong();
      long var9 = this.b.nextLong();

      for(int var11 = var3 - var6; var11 <= var3 + var6; ++var11) {
         for(int var12 = var4 - var6; var12 <= var4 + var6; ++var12) {
            long var13 = (long)var11 * var7;
            long var15 = (long)var12 * var9;
            this.b.setSeed(var13 ^ var15 ^ var2.J());
            this.a(var2, var11, var12, var3, var4, var5);
         }
      }

   }
}
