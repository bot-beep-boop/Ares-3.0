import com.google.gson.JsonObject;
import com.mojang.authlib.GameProfile;
import java.io.File;
import java.util.Iterator;

public class ly extends mb<GameProfile, lz> {
   public String[] a() {
      String[] var1 = new String[this.e().size()];
      int var2 = 0;

      lz var4;
      for(Iterator var3 = this.e().values().iterator(); var3.hasNext(); var1[var2++] = ((GameProfile)var4.f()).getName()) {
         var4 = (lz)var3.next();
      }

      return var1;
   }

   protected ma<GameProfile> a(JsonObject var1) {
      return new lz(var1);
   }

   public boolean b(GameProfile var1) {
      lz var2 = (lz)this.b(var1);
      return var2 != null ? var2.b() : false;
   }

   public GameProfile a(String var1) {
      Iterator var2 = this.e().values().iterator();

      lz var3;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         var3 = (lz)var2.next();
      } while(!var1.equalsIgnoreCase(((GameProfile)var3.f()).getName()));

      return (GameProfile)var3.f();
   }

   protected String c(GameProfile var1) {
      return var1.getId().toString();
   }

   public ly(File var1) {
      super(var1);
   }

   protected String a(Object var1) {
      return this.c((GameProfile)var1);
   }
}
