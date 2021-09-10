import com.mojang.authlib.GameProfile;
import java.io.IOException;
import java.util.UUID;

public class jg implements ff<jf> {
   private GameProfile a;

   public void a(jf var1) {
      var1.a(this);
   }

   public void a(em var1) throws IOException {
      String var2 = var1.c(36);
      String var3 = var1.c(16);
      UUID var4 = UUID.fromString(var2);
      this.a = new GameProfile(var4, var3);
   }

   public GameProfile a() {
      return this.a;
   }

   public void b(em var1) throws IOException {
      UUID var2 = this.a.getId();
      var1.a(var2 == null ? "" : var2.toString());
      var1.a(this.a.getName());
   }

   public jg() {
   }

   public void a(ep var1) {
      this.a((jf)var1);
   }

   public jg(GameProfile var1) {
      this.a = var1;
   }
}
