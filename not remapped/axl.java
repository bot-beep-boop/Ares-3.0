import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class axl extends axu {
   private final bns h;
   protected axu a;
   private awe r;
   private final avh g;
   private awe i;
   private axl.a f;

   static awe c(axl var0) {
      return var0.r;
   }

   static avh b(axl var0) {
      return var0.g;
   }

   public void k() {
      super.k();
      this.f.p();
   }

   static bns a(axl var0) {
      return var0.h;
   }

   protected void a(avs var1) {
      if (var1.l) {
         switch(var1.k) {
         case 5:
            break;
         case 6:
            this.j.a(this.a);
            break;
         case 100:
            if (var1 instanceof awe) {
               this.g.a((avh.a)((awe)var1).c(), 1);
               var1.j = this.g.c(avh.a.E);
               avr var2 = new avr(this.j);
               int var3 = var2.a();
               int var4 = var2.b();
               this.a(this.j, var3, var4);
            }
            break;
         default:
            this.f.a(var1);
         }

      }
   }

   public void a(int var1, int var2, float var3) {
      this.f.a(var1, var2, var3);
      this.a(this.q, bnq.a("options.language"), this.l / 2, 16, 16777215);
      this.a(this.q, "(" + bnq.a("options.languageWarning") + ")", this.l / 2, this.m - 56, 8421504);
      super.a(var1, var2, var3);
   }

   static awe d(axl var0) {
      return var0.i;
   }

   public axl(axu var1, avh var2, bns var3) {
      this.a = var1;
      this.g = var2;
      this.h = var3;
   }

   public void b() {
      this.n.add(this.i = new awe(100, this.l / 2 - 155, this.m - 38, avh.a.E, this.g.c(avh.a.E)));
      this.n.add(this.r = new awe(6, this.l / 2 - 155 + 160, this.m - 38, bnq.a("gui.done")));
      this.f = new axl.a(this, this.j);
      this.f.d(7, 8);
   }

   class a extends awi {
      final axl u;
      private final List<String> v;
      private final Map<String, bnr> w;

      protected int k() {
         return this.b() * 18;
      }

      protected void a(int var1, int var2, int var3, int var4, int var5, int var6) {
         this.u.q.b(true);
         this.u.a(this.u.q, ((bnr)this.w.get(this.v.get(var1))).toString(), this.b / 2, var3 + 1, 16777215);
         this.u.q.b(axl.a(this.u).c().b());
      }

      protected void a(int var1, boolean var2, int var3, int var4) {
         bnr var5 = (bnr)this.w.get(this.v.get(var1));
         axl.a(this.u).a(var5);
         axl.b(this.u).aN = var5.a();
         this.a.e();
         this.u.q.a(axl.a(this.u).a() || axl.b(this.u).aO);
         this.u.q.b(axl.a(this.u).b());
         axl.c(this.u).j = bnq.a("gui.done");
         axl.d(this.u).j = axl.b(this.u).c(avh.a.E);
         axl.b(this.u).b();
      }

      protected int b() {
         return this.v.size();
      }

      protected boolean a(int var1) {
         return ((String)this.v.get(var1)).equals(axl.a(this.u).c().a());
      }

      public a(axl var1, ave var2) {
         super(var2, var1.l, var1.m, 32, var1.m - 65 + 4, 18);
         this.u = var1;
         this.v = Lists.newArrayList();
         this.w = Maps.newHashMap();
         Iterator var3 = axl.a(var1).d().iterator();

         while(var3.hasNext()) {
            bnr var4 = (bnr)var3.next();
            this.w.put(var4.a(), var4);
            this.v.add(var4.a());
         }

      }

      protected void a() {
         this.u.c();
      }
   }
}
