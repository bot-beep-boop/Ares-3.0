public class bqe extends bqh {
   public bqe(mq var1) {
      super("achievement");
      this.a("achievement_id", var1.e);
      this.a("achievement_name", var1.e().c());
      this.a("achievement_description", var1.f());
      this.a("Achievement '" + var1.e().c() + "' obtained!");
   }
}
