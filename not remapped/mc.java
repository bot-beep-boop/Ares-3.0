import com.google.gson.JsonObject;
import com.mojang.authlib.GameProfile;
import java.io.File;
import java.util.Iterator;

public class mc extends mb<GameProfile, md> {
   public GameProfile a(String var1) {
      Iterator var2 = this.e().values().iterator();

      md var3;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         var3 = (md)var2.next();
      } while(!var1.equalsIgnoreCase(((GameProfile)var3.f()).getName()));

      return (GameProfile)var3.f();
   }

   protected String b(GameProfile var1) {
      return var1.getId().toString();
   }

   protected ma<GameProfile> a(JsonObject var1) {
      return new md(var1);
   }

   protected String a(Object var1) {
      return this.b((GameProfile)var1);
   }

   public mc(File var1) {
      super(var1);
   }

   public boolean a(GameProfile var1) {
      return this.d(var1);
   }

   public String[] a() {
      String[] var1 = new String[this.e().size()];
      int var2 = 0;

      md var4;
      for(Iterator var3 = this.e().values().iterator(); var3.hasNext(); var1[var2++] = ((GameProfile)var4.f()).getName()) {
         var4 = (md)var3.next();
      }

      return var1;
   }
}
