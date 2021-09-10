import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.server.MinecraftServer;

public class q extends i {
   public static final Pattern a = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

   public String c(m var1) {
      return "commands.banip.usage";
   }

   public int a() {
      return 3;
   }

   public boolean a(m var1) {
      return MinecraftServer.N().ap().i().b() && super.a(var1);
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      return var2.length == 1 ? a(var2, MinecraftServer.N().K()) : null;
   }

   protected void a(m var1, String var2, String var3) {
      lv var4 = new lv(var2, (Date)null, var1.e_(), (Date)null, var3);
      MinecraftServer.N().ap().i().a((ma)var4);
      List var5 = MinecraftServer.N().ap().b(var2);
      String[] var6 = new String[var5.size()];
      int var7 = 0;

      lf var9;
      for(Iterator var8 = var5.iterator(); var8.hasNext(); var6[var7++] = var9.e_()) {
         var9 = (lf)var8.next();
         var9.a.c("You have been IP banned.");
      }

      if (var5.isEmpty()) {
         a(var1, this, "commands.banip.success", new Object[]{var2});
      } else {
         a(var1, this, "commands.banip.success.players", new Object[]{var2, a(var6)});
      }

   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length >= 1 && var2[0].length() > 1) {
         eu var3 = var2.length >= 2 ? a(var1, var2, 1) : null;
         Matcher var4 = a.matcher(var2[0]);
         if (var4.matches()) {
            this.a(var1, var2[0], var3 == null ? null : var3.c());
         } else {
            lf var5 = MinecraftServer.N().ap().a(var2[0]);
            if (var5 == null) {
               throw new cd("commands.banip.invalid", new Object[0]);
            }

            this.a(var1, var5.w(), var3 == null ? null : var3.c());
         }

      } else {
         throw new cf("commands.banip.usage", new Object[0]);
      }
   }

   public String c() {
      return "ban-ip";
   }
}
