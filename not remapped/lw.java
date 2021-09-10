import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.mojang.authlib.Agent;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.ProfileLookupCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class lw {
   public static final File a = new File("banned-ips.txt");
   private static final Logger e = LogManager.getLogger();
   public static final File d = new File("white-list.txt");
   public static final File b = new File("banned-players.txt");
   public static final File c = new File("ops.txt");

   private static void a(MinecraftServer var0, Collection<String> var1, ProfileLookupCallback var2) {
      String[] var3 = (String[])Iterators.toArray(Iterators.filter(var1.iterator(), new Predicate<String>() {
         public boolean apply(Object var1) {
            return this.a((String)var1);
         }

         public boolean a(String var1) {
            return !nx.b(var1);
         }
      }), String.class);
      if (var0.af()) {
         var0.aE().findProfilesByNames(var3, Agent.MINECRAFT, var2);
      } else {
         String[] var4 = var3;
         int var5 = var3.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            String var7 = var4[var6];
            UUID var8 = wn.a(new GameProfile((UUID)null, var7));
            GameProfile var9 = new GameProfile(var8, var7);
            var2.onProfileLookupSucceeded(var9);
         }
      }

   }

   public static String a(String var0) {
      if (!nx.b(var0) && var0.length() <= 16) {
         MinecraftServer var1 = MinecraftServer.N();
         GameProfile var2 = var1.aF().a(var0);
         if (var2 != null && var2.getId() != null) {
            return var2.getId().toString();
         } else if (!var1.T() && var1.af()) {
            ArrayList var3 = Lists.newArrayList();
            ProfileLookupCallback var4 = new ProfileLookupCallback(var1, var3) {
               final MinecraftServer a;
               final List b;

               public void onProfileLookupSucceeded(GameProfile var1) {
                  this.a.aF().a(var1);
                  this.b.add(var1);
               }

               public void onProfileLookupFailed(GameProfile var1, Exception var2) {
                  lw.a().warn("Could not lookup user whitelist entry for " + var1.getName(), var2);
               }

               {
                  this.a = var1;
                  this.b = var2;
               }
            };
            a(var1, Lists.newArrayList(new String[]{var0}), var4);
            return var3.size() > 0 && ((GameProfile)var3.get(0)).getId() != null ? ((GameProfile)var3.get(0)).getId().toString() : "";
         } else {
            return wn.a(new GameProfile((UUID)null, var0)).toString();
         }
      } else {
         return var0;
      }
   }

   static Logger a() {
      return e;
   }
}
