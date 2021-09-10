import com.mojang.authlib.GameProfile;
import java.io.IOException;
import java.util.UUID;

public class jl implements ff<jk> {
   private GameProfile a;

   public jl(GameProfile var1) {
      this.a = var1;
   }

   public void a(em var1) throws IOException {
      this.a = new GameProfile((UUID)null, var1.c(16));
   }

   public void a(ep var1) {
      this.a((jk)var1);
   }

   public GameProfile a() {
      return this.a;
   }

   public jl() {
   }

   public void b(em var1) throws IOException {
      var1.a(this.a.getName());
   }

   public void a(jk var1) {
      var1.a(this);
   }
}
