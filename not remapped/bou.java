public class bou implements bnj {
   private db<bov, boq> a;
   private boq d;
   private final bgc c;
   private final bmh b;

   public bou(bmh var1) {
      this.b = var1;
      this.c = new bgc(this);
   }

   public boq a(bov var1) {
      if (var1 == null) {
         return this.d;
      } else {
         boq var2 = (boq)this.a.a(var1);
         return var2 == null ? this.d : var2;
      }
   }

   public void a(bni var1) {
      bot var2 = new bot(var1, this.b, this.c);
      this.a = var2.a();
      this.d = (boq)this.a.a(bot.a);
      this.c.c();
   }

   public bmh b() {
      return this.b;
   }

   public boq a() {
      return this.d;
   }

   public bgc c() {
      return this.c;
   }
}
