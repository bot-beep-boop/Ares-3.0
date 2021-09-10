import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.Map.Entry;

public class axy extends axu {
   private final axu a;
   private String i;
   private axy.a s;
   private final avh f;
   private final List<String> h = Lists.newArrayList();
   private final List<String> g = Lists.newArrayList();
   private avs t;
   private String[] r;

   static List b(axy var0) {
      return var0.h;
   }

   public void k() {
      super.k();
      this.s.p();
   }

   static List a(axy var0) {
      return var0.g;
   }

   public void b() {
      this.i = bnq.a("options.snooper.title");
      String var1 = bnq.a("options.snooper.desc");
      ArrayList var2 = Lists.newArrayList();
      Iterator var3 = this.q.c(var1, this.l - 30).iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         var2.add(var4);
      }

      this.r = (String[])var2.toArray(new String[var2.size()]);
      this.g.clear();
      this.h.clear();
      this.n.add(this.t = new avs(1, this.l / 2 - 152, this.m - 30, 150, 20, this.f.c(avh.a.u)));
      this.n.add(new avs(2, this.l / 2 + 2, this.m - 30, 150, 20, bnq.a("gui.done")));
      boolean var6 = this.j.G() != null && this.j.G().av() != null;
      Iterator var7 = (new TreeMap(this.j.I().c())).entrySet().iterator();

      Entry var5;
      while(var7.hasNext()) {
         var5 = (Entry)var7.next();
         this.g.add((var6 ? "C " : "") + (String)var5.getKey());
         this.h.add(this.q.a((String)var5.getValue(), this.l - 220));
      }

      if (var6) {
         var7 = (new TreeMap(this.j.G().av().c())).entrySet().iterator();

         while(var7.hasNext()) {
            var5 = (Entry)var7.next();
            this.g.add("S " + (String)var5.getKey());
            this.h.add(this.q.a((String)var5.getValue(), this.l - 220));
         }
      }

      this.s = new axy.a(this);
   }

   public void a(int var1, int var2, float var3) {
      this.c();
      this.s.a(var1, var2, var3);
      this.a(this.q, this.i, this.l / 2, 8, 16777215);
      int var4 = 22;
      String[] var5 = this.r;
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         String var8 = var5[var7];
         this.a(this.q, var8, this.l / 2, var4, 8421504);
         var4 += this.q.a;
      }

      super.a(var1, var2, var3);
   }

   public axy(axu var1, avh var2) {
      this.a = var1;
      this.f = var2;
   }

   protected void a(avs var1) {
      if (var1.l) {
         if (var1.k == 2) {
            this.f.b();
            this.f.b();
            this.j.a(this.a);
         }

         if (var1.k == 1) {
            this.f.a((avh.a)avh.a.u, 1);
            this.t.j = this.f.c(avh.a.u);
         }

      }
   }

   class a extends awi {
      final axy u;

      protected void a(int var1, int var2, int var3, int var4, int var5, int var6) {
         this.u.q.a((String)axy.a(this.u).get(var1), 10, var3, 16777215);
         this.u.q.a((String)axy.b(this.u).get(var1), 230, var3, 16777215);
      }

      protected void a(int var1, boolean var2, int var3, int var4) {
      }

      public a(axy var1) {
         super(var1.j, var1.l, var1.m, 80, var1.m - 40, var1.q.a + 1);
         this.u = var1;
      }

      protected void a() {
      }

      protected int b() {
         return axy.a(this.u).size();
      }

      protected boolean a(int var1) {
         return false;
      }

      protected int d() {
         return this.b - 10;
      }
   }
}
