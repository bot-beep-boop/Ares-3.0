import java.util.UUID;

public class vw extends we {
   private UUID bo;
   private int bn;
   private static final qd c;
   private static final UUID b = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
   private int bm;

   protected String bp() {
      return "mob.zombiepig.zpigdeath";
   }

   private void b(pk var1) {
      this.bm = 400 + this.V.nextInt(400);
      this.bn = this.V.nextInt(40);
      if (var1 instanceof pr) {
         this.b((pr)var1);
      }

   }

   protected void b(boolean var1, int var2) {
      int var3 = this.V.nextInt(2 + var2);

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         this.a(zy.bt, 1);
      }

      var3 = this.V.nextInt(2 + var2);

      for(var4 = 0; var4 < var3; ++var4) {
         this.a(zy.bx, 1);
      }

   }

   public void b(dn var1) {
      super.b(var1);
      var1.a("Anger", (short)this.bm);
      if (this.bo != null) {
         var1.a("HurtBy", this.bo.toString());
      } else {
         var1.a("HurtBy", "");
      }

   }

   static {
      c = (new qd(b, "Attacking speed boost", 0.05D, 0)).a(false);
   }

   public boolean a(ow var1, float var2) {
      if (this.b((ow)var1)) {
         return false;
      } else {
         pk var3 = var1.j();
         if (var3 instanceof wn) {
            this.b(var3);
         }

         return super.a(var1, var2);
      }
   }

   public boolean bS() {
      return this.o.a((aug)this.aR(), (pk)this) && this.o.a((pk)this, (aug)this.aR()).isEmpty() && !this.o.d(this.aR());
   }

   protected String bo() {
      return "mob.zombiepig.zpighurt";
   }

   static void a(vw var0, pk var1) {
      var0.b(var1);
   }

   public boolean bR() {
      return this.o.aa() != oj.a;
   }

   protected String z() {
      return "mob.zombiepig.zpig";
   }

   public vw(adm var1) {
      super(var1);
      this.ab = true;
   }

   public void b(pr var1) {
      super.b((pr)var1);
      if (var1 != null) {
         this.bo = var1.aK();
      }

   }

   public boolean a(wn var1) {
      return false;
   }

   public boolean cm() {
      return this.bm > 0;
   }

   protected void E() {
      qc var1 = this.a((qb)vy.d);
      if (this.cm()) {
         if (!this.j_() && !var1.a(c)) {
            var1.b(c);
         }

         --this.bm;
      } else if (var1.a(c)) {
         var1.c(c);
      }

      if (this.bn > 0 && --this.bn == 0) {
         this.a("mob.zombiepig.zpigangry", this.bB() * 2.0F, ((this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F) * 1.8F);
      }

      if (this.bm > 0 && this.bo != null && this.bd() == null) {
         wn var2 = this.o.b(this.bo);
         this.b((pr)var2);
         this.aN = var2;
         this.aO = this.be();
      }

      super.E();
   }

   public void a(dn var1) {
      super.a(var1);
      this.bm = var1.e("Anger");
      String var2 = var1.j("HurtBy");
      if (var2.length() > 0) {
         this.bo = UUID.fromString(var2);
         wn var3 = this.o.b(this.bo);
         this.b((pr)var3);
         if (var3 != null) {
            this.aN = var3;
            this.aO = this.be();
         }
      }

   }

   public void t_() {
      super.t_();
   }

   protected void n() {
      this.bi.a(1, new vw.b(this));
      this.bi.a(2, new vw.a(this));
   }

   public pu a(ok var1, pu var2) {
      super.a(var1, var2);
      this.m(false);
      return var2;
   }

   protected void aX() {
      super.aX();
      this.a((qb)a).a(0.0D);
      this.a((qb)vy.d).a(0.23000000417232513D);
      this.a((qb)vy.e).a(5.0D);
   }

   protected void a(ok var1) {
      this.c(0, new zx(zy.B));
   }

   protected void bq() {
      this.a(zy.k, 1);
   }

   static class a extends sp<wn> {
      public boolean a() {
         return ((vw)this.e).cm() && super.a();
      }

      public a(vw var1) {
         super(var1, wn.class, true);
      }
   }

   static class b extends sm {
      public b(vw var1) {
         super(var1, true);
      }

      protected void a(py var1, pr var2) {
         super.a(var1, var2);
         if (var1 instanceof vw) {
            vw.a((vw)((vw)var1), (pk)var2);
         }

      }
   }
}
