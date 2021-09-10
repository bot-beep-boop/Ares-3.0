import net.minecraft.server.MinecraftServer;

public class kz extends le {
   private le a;

   protected void a() {
   }

   public kz(MinecraftServer var1, atp var2, int var3, le var4, nt var5) {
      super(var1, var2, new atl(var4.P()), var3, var5);
      this.a = var4;
      var4.af().a(new amq(this) {
         final kz a;

         public void b(ams var1, int var2) {
            this.a.af().c(var2);
         }

         public void a(ams var1, double var2) {
            this.a.af().a(var2);
         }

         public void a(ams var1, double var2, double var4) {
            this.a.af().c(var2, var4);
         }

         {
            this.a = var1;
         }

         public void a(ams var1, double var2, double var4, long var6) {
            this.a.af().a(var2, var4, var6);
         }

         public void a(ams var1, int var2) {
            this.a.af().b(var2);
         }

         public void c(ams var1, double var2) {
            this.a.af().b(var2);
         }

         public void b(ams var1, double var2) {
            this.a.af().c(var2);
         }
      });
   }

   public adm b() {
      this.z = this.a.T();
      this.C = this.a.Z();
      String var1 = th.a(this.t);
      th var2 = (th)this.z.a(th.class, var1);
      if (var2 == null) {
         this.A = new th(this);
         this.z.a((String)var1, (ate)this.A);
      } else {
         this.A = var2;
         this.A.a((adm)this);
      }

      return this;
   }
}
