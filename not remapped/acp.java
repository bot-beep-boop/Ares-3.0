public class acp extends aci {
   public int b(int var1) {
      return super.a(var1) + 50;
   }

   public int b() {
      return 3;
   }

   public boolean a(aci var1) {
      return super.a(var1) && var1.B != s.B;
   }

   protected acp(int var1, jy var2, int var3, acj var4) {
      super(var1, var2, var3, var4);
      if (var4 == acj.h) {
         this.c("lootBonusDigger");
      } else if (var4 == acj.i) {
         this.c("lootBonusFishing");
      } else {
         this.c("lootBonus");
      }

   }

   public int a(int var1) {
      return 15 + (var1 - 1) * 9;
   }
}
