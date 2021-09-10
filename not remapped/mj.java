import net.minecraft.server.MinecraftServer;

public class mj implements m {
   private static final mj a = new mj();
   private StringBuffer b = new StringBuffer();

   public cj c() {
      return new cj(0, 0, 0);
   }

   public eu f_() {
      return new fa(this.e_());
   }

   public boolean u_() {
      return true;
   }

   public pk f() {
      return null;
   }

   public boolean a(int var1, String var2) {
      return true;
   }

   public void a(eu var1) {
      this.b.append(var1.c());
   }

   public aui d() {
      return new aui(0.0D, 0.0D, 0.0D);
   }

   public void a(n.a var1, int var2) {
   }

   public String e_() {
      return "Rcon";
   }

   public adm e() {
      return MinecraftServer.N().e();
   }
}
