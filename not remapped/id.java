import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

public class id implements ff<ic> {
   private String a;
   private cj b;

   public void a(ep var1) {
      this.a((ic)var1);
   }

   public id(String var1, cj var2) {
      this.a = var1;
      this.b = var2;
   }

   public String a() {
      return this.a;
   }

   public void b(em var1) throws IOException {
      var1.a(StringUtils.substring(this.a, 0, 32767));
      boolean var2 = this.b != null;
      var1.writeBoolean(var2);
      if (var2) {
         var1.a(this.b);
      }

   }

   public void a(ic var1) {
      var1.a(this);
   }

   public id() {
   }

   public id(String var1) {
      this(var1, (cj)null);
   }

   public cj b() {
      return this.b;
   }

   public void a(em var1) throws IOException {
      this.a = var1.c(32767);
      boolean var2 = var1.readBoolean();
      if (var2) {
         this.b = var1.c();
      }

   }
}
