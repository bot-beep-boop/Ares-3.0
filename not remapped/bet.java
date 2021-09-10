import com.mojang.authlib.GameProfile;
import java.io.File;

public abstract class bet extends wn {
   private bdc a;

   public static bma a(jy var0, String var1) {
      bmj var2 = ave.A().P();
      Object var3 = var2.b(var0);
      if (var3 == null) {
         var3 = new bma((File)null, String.format("http://skins.minecraft.net/MinecraftSkins/%s.png", nx.a(var1)), bmz.a(b(var1)), new bfs());
         var2.a((jy)var0, (bmk)var3);
      }

      return (bma)var3;
   }

   public boolean v() {
      bdc var1 = ave.A().u().a(this.cd().getId());
      return var1 != null && var1.b() == adp.a.e;
   }

   public jy i() {
      bdc var1 = this.b();
      return var1 == null ? bmz.a(this.aK()) : var1.g();
   }

   public static jy c(String var0) {
      return new jy("skins/" + nx.a(var0));
   }

   protected bdc b() {
      if (this.a == null) {
         this.a = ave.A().u().a(this.aK());
      }

      return this.a;
   }

   public boolean a() {
      return this.b() != null;
   }

   public boolean g() {
      bdc var1 = this.b();
      return var1 != null && var1.e();
   }

   public jy k() {
      bdc var1 = this.b();
      return var1 == null ? null : var1.h();
   }

   public bet(adm var1, GameProfile var2) {
      super(var1, var2);
   }

   public float o() {
      float var1 = 1.0F;
      if (this.bA.b) {
         var1 *= 1.1F;
      }

      qc var2 = this.a(vy.d);
      var1 = (float)((double)var1 * ((var2.e() / (double)this.bA.b() + 1.0D) / 2.0D));
      if (this.bA.b() == 0.0F || Float.isNaN(var1) || Float.isInfinite(var1)) {
         var1 = 1.0F;
      }

      if (this.bS() && this.bQ().b() == zy.f) {
         int var3 = this.bT();
         float var4 = (float)var3 / 20.0F;
         if (var4 > 1.0F) {
            var4 = 1.0F;
         } else {
            var4 *= var4;
         }

         var1 *= 1.0F - var4 * 0.15F;
      }

      return var1;
   }

   public String l() {
      bdc var1 = this.b();
      return var1 == null ? bmz.b(this.aK()) : var1.f();
   }
}
