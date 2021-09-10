import java.util.Iterator;
import net.minecraft.server.MinecraftServer;

public class ex extends es {
   private String d = "";
   private final String b;
   private final String c;

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof ex)) {
         return false;
      } else {
         ex var2 = (ex)var1;
         return this.b.equals(var2.b) && this.c.equals(var2.c) && super.equals(var1);
      }
   }

   public void b(String var1) {
      this.d = var1;
   }

   public String toString() {
      return "ScoreComponent{name='" + this.b + '\'' + "objective='" + this.c + '\'' + ", siblings=" + this.a + ", style=" + this.b() + '}';
   }

   public String e() {
      MinecraftServer var1 = MinecraftServer.N();
      if (var1 != null && var1.O() && nx.b(this.d)) {
         auo var2 = var1.a(0).Z();
         auk var3 = var2.b(this.c);
         if (var2.b(this.b, var3)) {
            aum var4 = var2.c(this.b, var3);
            this.b(String.format("%d", var4.c()));
         } else {
            this.d = "";
         }
      }

      return this.d;
   }

   public String h() {
      return this.c;
   }

   public eu f() {
      return this.i();
   }

   public ex(String var1, String var2) {
      this.b = var1;
      this.c = var2;
   }

   public ex i() {
      ex var1 = new ex(this.b, this.c);
      var1.b(this.d);
      var1.a(this.b().m());
      Iterator var2 = this.a().iterator();

      while(var2.hasNext()) {
         eu var3 = (eu)var2.next();
         var1.a(var3.f());
      }

      return var1;
   }

   public String g() {
      return this.b;
   }
}
