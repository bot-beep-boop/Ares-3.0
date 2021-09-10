import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.util.Iterator;
import java.util.UUID;

public final class dy {
   public static GameProfile a(dn var0) {
      String var1 = null;
      String var2 = null;
      if (var0.b("Name", 8)) {
         var1 = var0.j("Name");
      }

      if (var0.b("Id", 8)) {
         var2 = var0.j("Id");
      }

      if (nx.b(var1) && nx.b(var2)) {
         return null;
      } else {
         UUID var3;
         try {
            var3 = UUID.fromString(var2);
         } catch (Throwable var12) {
            var3 = null;
         }

         GameProfile var4 = new GameProfile(var3, var1);
         if (var0.b("Properties", 10)) {
            dn var5 = var0.m("Properties");
            Iterator var6 = var5.c().iterator();

            while(var6.hasNext()) {
               String var7 = (String)var6.next();
               du var8 = var5.c(var7, 10);

               for(int var9 = 0; var9 < var8.c(); ++var9) {
                  dn var10 = var8.b(var9);
                  String var11 = var10.j("Value");
                  if (var10.b("Signature", 8)) {
                     var4.getProperties().put(var7, new Property(var7, var11, var10.j("Signature")));
                  } else {
                     var4.getProperties().put(var7, new Property(var7, var11));
                  }
               }
            }
         }

         return var4;
      }
   }

   public static boolean a(eb var0, eb var1, boolean var2) {
      if (var0 == var1) {
         return true;
      } else if (var0 == null) {
         return true;
      } else if (var1 == null) {
         return false;
      } else if (!var0.getClass().equals(var1.getClass())) {
         return false;
      } else if (var0 instanceof dn) {
         dn var9 = (dn)var0;
         dn var10 = (dn)var1;
         Iterator var11 = var9.c().iterator();

         String var12;
         eb var13;
         do {
            if (!var11.hasNext()) {
               return true;
            }

            var12 = (String)var11.next();
            var13 = var9.a(var12);
         } while(a(var13, var10.a(var12), var2));

         return false;
      } else if (var0 instanceof du && var2) {
         du var3 = (du)var0;
         du var4 = (du)var1;
         if (var3.c() == 0) {
            return var4.c() == 0;
         } else {
            for(int var5 = 0; var5 < var3.c(); ++var5) {
               eb var6 = var3.g(var5);
               boolean var7 = false;

               for(int var8 = 0; var8 < var4.c(); ++var8) {
                  if (a(var6, var4.g(var8), var2)) {
                     var7 = true;
                     break;
                  }
               }

               if (!var7) {
                  return false;
               }
            }

            return true;
         }
      } else {
         return var0.equals(var1);
      }
   }

   public static dn a(dn var0, GameProfile var1) {
      if (!nx.b(var1.getName())) {
         var0.a("Name", var1.getName());
      }

      if (var1.getId() != null) {
         var0.a("Id", var1.getId().toString());
      }

      if (!var1.getProperties().isEmpty()) {
         dn var2 = new dn();
         Iterator var3 = var1.getProperties().keySet().iterator();

         while(var3.hasNext()) {
            String var4 = (String)var3.next();
            du var5 = new du();

            dn var8;
            for(Iterator var6 = var1.getProperties().get(var4).iterator(); var6.hasNext(); var5.a((eb)var8)) {
               Property var7 = (Property)var6.next();
               var8 = new dn();
               var8.a("Value", var7.getValue());
               if (var7.hasSignature()) {
                  var8.a("Signature", var7.getSignature());
               }
            }

            var2.a((String)var4, (eb)var5);
         }

         var0.a((String)"Properties", (eb)var2);
      }

      return var0;
   }
}
