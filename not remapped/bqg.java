public class bqg extends bqh {
   public bqg(pr var1, pr var2) {
      super("player_death");
      if (var1 != null) {
         this.a("player", var1.e_());
      }

      if (var2 != null) {
         this.a("killer", var2.e_());
      }

   }
}
