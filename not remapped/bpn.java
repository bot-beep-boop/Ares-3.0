import com.mojang.authlib.GameProfile;
import java.net.SocketAddress;
import net.minecraft.server.MinecraftServer;

public class bpn extends lx {
   private dn f;

   public bpn(bpo var1) {
      super(var1);
      this.a(10);
   }

   public MinecraftServer c() {
      return this.b();
   }

   public bpo b() {
      return (bpo)super.c();
   }

   public dn t() {
      return this.f;
   }

   protected void b(lf var1) {
      if (var1.e_().equals(this.b().S())) {
         this.f = new dn();
         var1.e(this.f);
      }

      super.b(var1);
   }

   public String a(SocketAddress var1, GameProfile var2) {
      return var2.getName().equalsIgnoreCase(this.b().S()) && this.a(var2.getName()) != null ? "That name is already taken." : super.a(var1, var2);
   }
}
