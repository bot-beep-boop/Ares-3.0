public class bqf extends bqh {
   public bqf(pr var1, pr var2) {
      super("player_combat");
      this.a("player", var1.e_());
      if (var2 != null) {
         this.a("primary_opponent", var2.e_());
      }

      if (var2 != null) {
         this.a("Combat between " + var1.e_() + " and " + var2.e_());
      } else {
         this.a("Combat between " + var1.e_() + " and others");
      }

   }
}
