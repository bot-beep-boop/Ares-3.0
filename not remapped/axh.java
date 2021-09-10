import java.util.Iterator;
import java.util.List;

public class axh extends axu {
   private int i;
   private eu f;
   private String a;
   private final axu h;
   private List<String> g;

   public axh(axu var1, String var2, eu var3) {
      this.h = var1;
      this.a = bnq.a(var2);
      this.f = var3;
   }

   public void b() {
      this.n.clear();
      this.g = this.q.c(this.f.d(), this.l - 50);
      this.i = this.g.size() * this.q.a;
      this.n.add(new avs(0, this.l / 2 - 100, this.m / 2 + this.i / 2 + this.q.a, bnq.a("gui.toMenu")));
   }

   public void a(int var1, int var2, float var3) {
      this.c();
      this.a(this.q, this.a, this.l / 2, this.m / 2 - this.i / 2 - this.q.a * 2, 11184810);
      int var4 = this.m / 2 - this.i / 2;
      if (this.g != null) {
         for(Iterator var5 = this.g.iterator(); var5.hasNext(); var4 += this.q.a) {
            String var6 = (String)var5.next();
            this.a(this.q, var6, this.l / 2, var4, 16777215);
         }
      }

      super.a(var1, var2, var3);
   }

   protected void a(char var1, int var2) {
   }

   protected void a(avs var1) {
      if (var1.k == 0) {
         this.j.a(this.h);
      }

   }
}
