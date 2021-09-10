import org.lwjgl.input.Keyboard;

public class aze extends axu {
   private avs h;
   private int g;
   private int f;
   private aln a;

   public void e() {
      ++this.f;
   }

   public void a(int var1, int var2, float var3) {
      this.c();
      this.a(this.q, bnq.a("sign.edit"), this.l / 2, 40, 16777215);
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      bfl.E();
      bfl.b((float)(this.l / 2), 0.0F, 50.0F);
      float var4 = 93.75F;
      bfl.a(-var4, -var4, -var4);
      bfl.b(180.0F, 0.0F, 1.0F, 0.0F);
      afh var5 = this.a.w();
      if (var5 == afi.an) {
         float var6 = (float)(this.a.u() * 360) / 16.0F;
         bfl.b(var6, 0.0F, 1.0F, 0.0F);
         bfl.b(0.0F, -1.0625F, 0.0F);
      } else {
         int var8 = this.a.u();
         float var7 = 0.0F;
         if (var8 == 2) {
            var7 = 180.0F;
         }

         if (var8 == 4) {
            var7 = 90.0F;
         }

         if (var8 == 5) {
            var7 = -90.0F;
         }

         bfl.b(var7, 0.0F, 1.0F, 0.0F);
         bfl.b(0.0F, -1.0625F, 0.0F);
      }

      if (this.f / 6 % 2 == 0) {
         this.a.f = this.g;
      }

      bhc.a.a(this.a, -0.5D, -0.75D, -0.5D, 0.0F);
      this.a.f = -1;
      bfl.F();
      super.a(var1, var2, var3);
   }

   protected void a(avs var1) {
      if (var1.l) {
         if (var1.k == 0) {
            this.a.p_();
            this.j.a((axu)null);
         }

      }
   }

   public aze(aln var1) {
      this.a = var1;
   }

   public void b() {
      this.n.clear();
      Keyboard.enableRepeatEvents(true);
      this.n.add(this.h = new avs(0, this.l / 2 - 100, this.m / 4 + 120, bnq.a("gui.done")));
      this.a.a(false);
   }

   protected void a(char var1, int var2) {
      if (var2 == 200) {
         this.g = this.g - 1 & 3;
      }

      if (var2 == 208 || var2 == 28 || var2 == 156) {
         this.g = this.g + 1 & 3;
      }

      String var3 = this.a.a[this.g].c();
      if (var2 == 14 && var3.length() > 0) {
         var3 = var3.substring(0, var3.length() - 1);
      }

      if (f.a(var1) && this.q.a(var3 + var1) <= 90) {
         var3 = var3 + var1;
      }

      this.a.a[this.g] = new fa(var3);
      if (var2 == 1) {
         this.a(this.h);
      }

   }

   public void m() {
      Keyboard.enableRepeatEvents(false);
      bcy var1 = this.j.u();
      if (var1 != null) {
         var1.a((ff)(new ix(this.a.v(), this.a.a)));
      }

      this.a.a(true);
   }
}
