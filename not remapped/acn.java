public class acn extends aci {
   protected acn(int var1, jy var2, int var3, acj var4) {
      super(var1, var2, var3, var4);
      this.c("fishingSpeed");
   }

   public int a(int var1) {
      return 15 + (var1 - 1) * 9;
   }

   public int b() {
      return 3;
   }

   public int b(int var1) {
      return super.a(var1) + 50;
   }
}
