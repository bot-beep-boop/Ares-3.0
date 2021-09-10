import com.google.gson.JsonParseException;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class azq extends azp {
   private final bnk d;
   private final jy e;
   private static final Logger c = LogManager.getLogger();

   protected void d() {
      this.a.P().a(this.e);
   }

   protected String b() {
      try {
         boj var1 = (boj)this.d.a(this.a.R().b, "pack");
         if (var1 != null) {
            return var1.a().d();
         }
      } catch (JsonParseException var2) {
         c.error("Couldn't load metadata info", var2);
      } catch (IOException var3) {
         c.error("Couldn't load metadata info", var3);
      }

      return a.m + "Missing " + "pack.mcmeta" + " :(";
   }

   public azq(azo var1) {
      super(var1);
      this.d = this.a.R().a;

      blz var2;
      try {
         var2 = new blz(this.d.a());
      } catch (IOException var4) {
         var2 = bml.a;
      }

      this.e = this.a.P().a("texturepackicon", var2);
   }

   protected boolean i() {
      return false;
   }

   protected boolean g() {
      return false;
   }

   protected boolean h() {
      return false;
   }

   protected String c() {
      return "Default";
   }

   protected boolean e() {
      return false;
   }

   protected boolean f() {
      return false;
   }

   protected int a() {
      return 1;
   }
}
