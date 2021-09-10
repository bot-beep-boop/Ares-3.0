import java.util.Collection;
import java.util.Iterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class aup extends ate {
   private static final Logger b = LogManager.getLogger();
   private auo c;
   private dn d;

   public void a(auo var1) {
      this.c = var1;
      if (this.d != null) {
         this.a(this.d);
      }

   }

   public void b(dn var1) {
      if (this.c == null) {
         b.warn("Tried to save scoreboard without having a scoreboard...");
      } else {
         var1.a((String)"Objectives", (eb)this.b());
         var1.a((String)"PlayerScores", (eb)this.e());
         var1.a((String)"Teams", (eb)this.a());
         this.d(var1);
      }
   }

   public void a(dn var1) {
      if (this.c == null) {
         this.d = var1;
      } else {
         this.b(var1.c("Objectives", 10));
         this.c(var1.c("PlayerScores", 10));
         if (var1.b("DisplaySlots", 10)) {
            this.c(var1.m("DisplaySlots"));
         }

         if (var1.b("Teams", 9)) {
            this.a(var1.c("Teams", 10));
         }

      }
   }

   protected du a() {
      du var1 = new du();
      Collection var2 = this.c.g();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         aul var4 = (aul)var3.next();
         dn var5 = new dn();
         var5.a("Name", var4.b());
         var5.a("DisplayName", var4.c());
         if (var4.l().b() >= 0) {
            var5.a("TeamColor", var4.l().e());
         }

         var5.a("Prefix", var4.e());
         var5.a("Suffix", var4.f());
         var5.a("AllowFriendlyFire", var4.g());
         var5.a("SeeFriendlyInvisibles", var4.h());
         var5.a("NameTagVisibility", var4.i().e);
         var5.a("DeathMessageVisibility", var4.j().e);
         du var6 = new du();
         Iterator var7 = var4.d().iterator();

         while(var7.hasNext()) {
            String var8 = (String)var7.next();
            var6.a((eb)(new ea(var8)));
         }

         var5.a((String)"Players", (eb)var6);
         var1.a((eb)var5);
      }

      return var1;
   }

   public aup() {
      this("scoreboard");
   }

   protected void c(dn var1) {
      for(int var2 = 0; var2 < 19; ++var2) {
         if (var1.b("slot_" + var2, 8)) {
            String var3 = var1.j("slot_" + var2);
            auk var4 = this.c.b(var3);
            this.c.a(var2, var4);
         }
      }

   }

   protected void b(du var1) {
      for(int var2 = 0; var2 < var1.c(); ++var2) {
         dn var3 = var1.b(var2);
         auu var4 = (auu)auu.a.get(var3.j("CriteriaName"));
         if (var4 != null) {
            String var5 = var3.j("Name");
            if (var5.length() > 16) {
               var5 = var5.substring(0, 16);
            }

            auk var6 = this.c.a(var5, var4);
            var6.a(var3.j("DisplayName"));
            var6.a(auu.a.a(var3.j("RenderType")));
         }
      }

   }

   protected du b() {
      du var1 = new du();
      Collection var2 = this.c.c();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         auk var4 = (auk)var3.next();
         if (var4.c() != null) {
            dn var5 = new dn();
            var5.a("Name", var4.b());
            var5.a("CriteriaName", var4.c().a());
            var5.a("DisplayName", var4.d());
            var5.a("RenderType", var4.e().a());
            var1.a((eb)var5);
         }
      }

      return var1;
   }

   protected void a(du var1) {
      for(int var2 = 0; var2 < var1.c(); ++var2) {
         dn var3 = var1.b(var2);
         String var4 = var3.j("Name");
         if (var4.length() > 16) {
            var4 = var4.substring(0, 16);
         }

         aul var5 = this.c.e(var4);
         String var6 = var3.j("DisplayName");
         if (var6.length() > 32) {
            var6 = var6.substring(0, 32);
         }

         var5.a(var6);
         if (var3.b("TeamColor", 8)) {
            var5.a(a.b(var3.j("TeamColor")));
         }

         var5.b(var3.j("Prefix"));
         var5.c(var3.j("Suffix"));
         if (var3.b("AllowFriendlyFire", 99)) {
            var5.a(var3.n("AllowFriendlyFire"));
         }

         if (var3.b("SeeFriendlyInvisibles", 99)) {
            var5.b(var3.n("SeeFriendlyInvisibles"));
         }

         auq.a var7;
         if (var3.b("NameTagVisibility", 8)) {
            var7 = auq.a.a(var3.j("NameTagVisibility"));
            if (var7 != null) {
               var5.a(var7);
            }
         }

         if (var3.b("DeathMessageVisibility", 8)) {
            var7 = auq.a.a(var3.j("DeathMessageVisibility"));
            if (var7 != null) {
               var5.b(var7);
            }
         }

         this.a(var5, var3.c("Players", 8));
      }

   }

   protected void a(aul var1, du var2) {
      for(int var3 = 0; var3 < var2.c(); ++var3) {
         this.c.a(var2.f(var3), var1.b());
      }

   }

   protected void d(dn var1) {
      dn var2 = new dn();
      boolean var3 = false;

      for(int var4 = 0; var4 < 19; ++var4) {
         auk var5 = this.c.a(var4);
         if (var5 != null) {
            var2.a("slot_" + var4, var5.b());
            var3 = true;
         }
      }

      if (var3) {
         var1.a((String)"DisplaySlots", (eb)var2);
      }

   }

   protected void c(du var1) {
      for(int var2 = 0; var2 < var1.c(); ++var2) {
         dn var3 = var1.b(var2);
         auk var4 = this.c.b(var3.j("Objective"));
         String var5 = var3.j("Name");
         if (var5.length() > 40) {
            var5 = var5.substring(0, 40);
         }

         aum var6 = this.c.c(var5, var4);
         var6.c(var3.f("Score"));
         if (var3.c("Locked")) {
            var6.a(var3.n("Locked"));
         }
      }

   }

   protected du e() {
      du var1 = new du();
      Collection var2 = this.c.e();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         aum var4 = (aum)var3.next();
         if (var4.d() != null) {
            dn var5 = new dn();
            var5.a("Name", var4.e());
            var5.a("Objective", var4.d().b());
            var5.a("Score", var4.c());
            var5.a("Locked", var4.g());
            var1.a((eb)var5);
         }
      }

      return var1;
   }

   public aup(String var1) {
      super(var1);
   }
}
