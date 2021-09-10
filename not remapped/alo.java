import com.google.common.collect.Iterables;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;

public class alo extends akw {
   private int f;
   private int a;
   private GameProfile g = null;

   public int c() {
      return this.a;
   }

   public ff y_() {
      dn var1 = new dn();
      this.b(var1);
      return new ft(this.c, 4, var1);
   }

   public void a(GameProfile var1) {
      this.a = 3;
      this.g = var1;
      this.e();
   }

   public void b(int var1) {
      this.f = var1;
   }

   public int d() {
      return this.f;
   }

   public void a(int var1) {
      this.a = var1;
      this.g = null;
   }

   public GameProfile b() {
      return this.g;
   }

   public static GameProfile b(GameProfile var0) {
      if (var0 != null && !nx.b(var0.getName())) {
         if (var0.isComplete() && var0.getProperties().containsKey("textures")) {
            return var0;
         } else if (MinecraftServer.N() == null) {
            return var0;
         } else {
            GameProfile var1 = MinecraftServer.N().aF().a(var0.getName());
            if (var1 == null) {
               return var0;
            } else {
               Property var2 = (Property)Iterables.getFirst(var1.getProperties().get("textures"), (Object)null);
               if (var2 == null) {
                  var1 = MinecraftServer.N().aD().fillProfileProperties(var1, true);
               }

               return var1;
            }
         }
      } else {
         return var0;
      }
   }

   public void b(dn var1) {
      super.b(var1);
      var1.a("SkullType", (byte)(this.a & 255));
      var1.a("Rot", (byte)(this.f & 255));
      if (this.g != null) {
         dn var2 = new dn();
         dy.a(var2, this.g);
         var1.a((String)"Owner", (eb)var2);
      }

   }

   public void a(dn var1) {
      super.a(var1);
      this.a = var1.d("SkullType");
      this.f = var1.d("Rot");
      if (this.a == 3) {
         if (var1.b("Owner", 10)) {
            this.g = dy.a(var1.m("Owner"));
         } else if (var1.b("ExtraType", 8)) {
            String var2 = var1.j("ExtraType");
            if (!nx.b(var2)) {
               this.g = new GameProfile((UUID)null, var2);
               this.e();
            }
         }
      }

   }

   private void e() {
      this.g = b(this.g);
      this.p_();
   }
}
