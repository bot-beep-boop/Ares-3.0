import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class awy extends axu {
   protected String h;
   private String r;
   protected String g;
   private int t;
   protected awx a;
   private final List<String> s = Lists.newArrayList();
   protected String f;
   protected int i;

   public void b() {
      this.n.add(new awe(0, this.l / 2 - 155, this.m / 6 + 96, this.g));
      this.n.add(new awe(1, this.l / 2 - 155 + 160, this.m / 6 + 96, this.h));
      this.s.clear();
      this.s.addAll(this.q.c(this.r, this.l - 50));
   }

   public void e() {
      super.e();
      avs var2;
      if (--this.t == 0) {
         for(Iterator var1 = this.n.iterator(); var1.hasNext(); var2.l = true) {
            var2 = (avs)var1.next();
         }
      }

   }

   protected void a(avs var1) {
      this.a.a(var1.k == 0, this.i);
   }

   public void a(int var1, int var2, float var3) {
      this.c();
      this.a(this.q, this.f, this.l / 2, 70, 16777215);
      int var4 = 90;

      for(Iterator var5 = this.s.iterator(); var5.hasNext(); var4 += this.q.a) {
         String var6 = (String)var5.next();
         this.a(this.q, var6, this.l / 2, var4, 16777215);
      }

      super.a(var1, var2, var3);
   }

   public awy(awx var1, String var2, String var3, String var4, String var5, int var6) {
      this.a = var1;
      this.f = var2;
      this.r = var3;
      this.g = var4;
      this.h = var5;
      this.i = var6;
   }

   public void b(int var1) {
      this.t = var1;

      avs var3;
      for(Iterator var2 = this.n.iterator(); var2.hasNext(); var3.l = false) {
         var3 = (avs)var2.next();
      }

   }

   public awy(awx var1, String var2, String var3, int var4) {
      this.a = var1;
      this.f = var2;
      this.r = var3;
      this.i = var4;
      this.g = bnq.a("gui.yes");
      this.h = bnq.a("gui.no");
   }
}
