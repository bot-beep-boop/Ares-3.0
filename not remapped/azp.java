import java.util.List;

public abstract class azp implements awd.a {
   protected final azo b;
   private static final jy c = new jy("textures/gui/resource_packs.png");
   protected final ave a;
   private static final eu f = new fb("resourcePack.incompatible.new", new Object[0]);
   private static final eu e = new fb("resourcePack.incompatible.old", new Object[0]);
   private static final eu d = new fb("resourcePack.incompatible", new Object[0]);

   protected boolean i() {
      List var1 = this.b.b(this);
      int var2 = var1.indexOf(this);
      return var2 >= 0 && var2 < var1.size() - 1 && ((azp)var1.get(var2 + 1)).e();
   }

   public azp(azo var1) {
      this.b = var1;
      this.a = ave.A();
   }

   public void b(int var1, int var2, int var3, int var4, int var5, int var6) {
   }

   protected boolean h() {
      List var1 = this.b.b(this);
      int var2 = var1.indexOf(this);
      return var2 > 0 && ((azp)var1.get(var2 - 1)).e();
   }

   protected abstract void d();

   protected abstract int a();

   protected boolean g() {
      return this.b.a(this);
   }

   protected boolean f() {
      return !this.b.a(this);
   }

   public void a(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8) {
      int var9 = this.a();
      if (var9 != 1) {
         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         avp.a(var2 - 1, var3 - 1, var2 + var4 - 9, var3 + var5 + 1, -8978432);
      }

      this.d();
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      avp.a(var2, var3, 0.0F, 0.0F, 32, 32, 32.0F, 32.0F);
      String var10 = this.c();
      String var11 = this.b();
      int var12;
      if ((this.a.t.A || var8) && this.e()) {
         this.a.P().a(c);
         avp.a(var2, var3, var2 + 32, var3 + 32, -1601138544);
         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         var12 = var6 - var2;
         int var13 = var7 - var3;
         if (var9 < 1) {
            var10 = d.d();
            var11 = e.d();
         } else if (var9 > 1) {
            var10 = d.d();
            var11 = f.d();
         }

         if (this.f()) {
            if (var12 < 32) {
               avp.a(var2, var3, 0.0F, 32.0F, 32, 32, 256.0F, 256.0F);
            } else {
               avp.a(var2, var3, 0.0F, 0.0F, 32, 32, 256.0F, 256.0F);
            }
         } else {
            if (this.g()) {
               if (var12 < 16) {
                  avp.a(var2, var3, 32.0F, 32.0F, 32, 32, 256.0F, 256.0F);
               } else {
                  avp.a(var2, var3, 32.0F, 0.0F, 32, 32, 256.0F, 256.0F);
               }
            }

            if (this.h()) {
               if (var12 < 32 && var12 > 16 && var13 < 16) {
                  avp.a(var2, var3, 96.0F, 32.0F, 32, 32, 256.0F, 256.0F);
               } else {
                  avp.a(var2, var3, 96.0F, 0.0F, 32, 32, 256.0F, 256.0F);
               }
            }

            if (this.i()) {
               if (var12 < 32 && var12 > 16 && var13 > 16) {
                  avp.a(var2, var3, 64.0F, 32.0F, 32, 32, 256.0F, 256.0F);
               } else {
                  avp.a(var2, var3, 64.0F, 0.0F, 32, 32, 256.0F, 256.0F);
               }
            }
         }
      }

      var12 = this.a.k.a(var10);
      if (var12 > 157) {
         var10 = this.a.k.a(var10, 157 - this.a.k.a("...")) + "...";
      }

      this.a.k.a(var10, (float)(var2 + 32 + 2), (float)(var3 + 1), 16777215);
      List var15 = this.a.k.c(var11, 157);

      for(int var14 = 0; var14 < 2 && var14 < var15.size(); ++var14) {
         this.a.k.a((String)var15.get(var14), (float)(var2 + 32 + 2), (float)(var3 + 12 + 10 * var14), 8421504);
      }

   }

   public boolean a(int var1, int var2, int var3, int var4, int var5, int var6) {
      if (this.e() && var5 <= 32) {
         if (this.f()) {
            this.b.g();
            int var10 = this.a();
            if (var10 != 1) {
               String var11 = bnq.a("resourcePack.incompatible.confirm.title");
               String var9 = bnq.a("resourcePack.incompatible.confirm." + (var10 > 1 ? "new" : "old"));
               this.a.a((axu)(new awy(new awx(this) {
                  final azp a;

                  public void a(boolean var1, int var2) {
                     List var3 = this.a.b.b(this.a);
                     this.a.a.a((axu)this.a.b);
                     if (var1) {
                        var3.remove(this.a);
                        this.a.b.f().add(0, this.a);
                     }

                  }

                  {
                     this.a = var1;
                  }
               }, var11, var9, 0)));
            } else {
               this.b.b(this).remove(this);
               this.b.f().add(0, this);
            }

            return true;
         }

         if (var5 < 16 && this.g()) {
            this.b.b(this).remove(this);
            this.b.a().add(0, this);
            this.b.g();
            return true;
         }

         List var7;
         int var8;
         if (var5 > 16 && var6 < 16 && this.h()) {
            var7 = this.b.b(this);
            var8 = var7.indexOf(this);
            var7.remove(this);
            var7.add(var8 - 1, this);
            this.b.g();
            return true;
         }

         if (var5 > 16 && var6 > 16 && this.i()) {
            var7 = this.b.b(this);
            var8 = var7.indexOf(this);
            var7.remove(this);
            var7.add(var8 + 1, this);
            this.b.g();
            return true;
         }
      }

      return false;
   }

   protected abstract String c();

   public void a(int var1, int var2, int var3) {
   }

   protected abstract String b();

   protected boolean e() {
      return true;
   }
}
