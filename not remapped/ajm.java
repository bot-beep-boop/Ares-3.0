import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.Random;

public class ajm extends afc {
   public static final aml a = aml.a("facing");
   private amd P;
   private static final Predicate<amc> N = new Predicate<amc>() {
      public boolean apply(Object var1) {
         return this.a((amc)var1);
      }

      public boolean a(amc var1) {
         return var1.a() != null && var1.a().c() == afi.ce && var1.b() instanceof alo && ((alo)var1.b()).c() == 1;
      }
   };
   private amd O;
   public static final amk b = amk.a("nodrop");

   protected ajm() {
      super(arm.q);
      this.j(this.M.b().a(a, cq.c).a(b, false));
      this.a(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
   }

   public zw c(adm var1, cj var2) {
      return zy.bX;
   }

   public boolean b(adm var1, cj var2, zx var3) {
      if (var3.i() == 1 && var2.o() >= 2 && var1.aa() != oj.a && !var1.D) {
         return this.l().a(var1, var2) != null;
      } else {
         return false;
      }
   }

   public void a(adm var1, cj var2, alo var3) {
      if (var3.c() == 1 && var2.o() >= 2 && var1.aa() != oj.a && !var1.D) {
         amd var4 = this.n();
         amd.b var5 = var4.a(var1, var2);
         if (var5 != null) {
            int var6;
            for(var6 = 0; var6 < 3; ++var6) {
               amc var7 = var5.a(var6, 0, 0);
               var1.a((cj)var7.d(), (alz)var7.a().a(b, true), 2);
            }

            for(var6 = 0; var6 < var4.c(); ++var6) {
               for(int var13 = 0; var13 < var4.b(); ++var13) {
                  amc var8 = var5.a(var6, var13, 0);
                  var1.a((cj)var8.d(), (alz)afi.a.Q(), 2);
               }
            }

            cj var12 = var5.a(1, 0, 0).d();
            uk var14 = new uk(var1);
            cj var15 = var5.a(1, 2, 0).d();
            var14.b((double)var15.n() + 0.5D, (double)var15.o() + 0.55D, (double)var15.p() + 0.5D, var5.b().k() == cq.a.a ? 0.0F : 90.0F, 0.0F);
            var14.aI = var5.b().k() == cq.a.a ? 0.0F : 90.0F;
            var14.n();
            Iterator var9 = var1.a(wn.class, var14.aR().b(50.0D, 50.0D, 50.0D)).iterator();

            while(var9.hasNext()) {
               wn var10 = (wn)var9.next();
               var10.b((mw)mr.I);
            }

            var1.d((pk)var14);

            int var16;
            for(var16 = 0; var16 < 120; ++var16) {
               var1.a(cy.F, (double)var12.n() + var1.s.nextDouble(), (double)(var12.o() - 2) + var1.s.nextDouble() * 3.9D, (double)var12.p() + var1.s.nextDouble(), 0.0D, 0.0D, 0.0D);
            }

            for(var16 = 0; var16 < var4.c(); ++var16) {
               for(int var17 = 0; var17 < var4.b(); ++var17) {
                  amc var11 = var5.a(var16, var17, 0);
                  var1.b(var11.d(), afi.a);
               }
            }

         }
      }
   }

   public void a(adm var1, cj var2, alz var3, float var4, int var5) {
   }

   protected amd l() {
      if (this.O == null) {
         this.O = ame.a().a("   ", "###", "~#~").a('#', amc.a(amh.a(afi.aW))).a('~', amc.a(amh.a(afi.a))).b();
      }

      return this.O;
   }

   public boolean d() {
      return false;
   }

   public void a(adm var1, cj var2, alz var3, wn var4) {
      if (var4.bA.d) {
         var3 = var3.a(b, true);
         var1.a((cj)var2, (alz)var3, 4);
      }

      super.a(var1, var2, var3, var4);
   }

   public boolean c() {
      return false;
   }

   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      return this.Q().a(a, var8.aP()).a(b, false);
   }

   protected ama e() {
      return new ama(this, new amo[]{a, b});
   }

   public alz a(int var1) {
      return this.Q().a(a, cq.a(var1 & 7)).a(b, (var1 & 8) > 0);
   }

   public zw a(alz var1, Random var2, int var3) {
      return zy.bX;
   }

   protected amd n() {
      if (this.P == null) {
         this.P = ame.a().a("^^^", "###", "~#~").a('#', amc.a(amh.a(afi.aW))).a('^', N).a('~', amc.a(amh.a(afi.a))).b();
      }

      return this.P;
   }

   public akw a(adm var1, int var2) {
      return new alo();
   }

   public String f() {
      return di.a("tile.skull.skeleton.name");
   }

   public aug a(adm var1, cj var2, alz var3) {
      this.a(var1, var2);
      return super.a(var1, var2, var3);
   }

   public int j(adm var1, cj var2) {
      akw var3 = var1.s(var2);
      return var3 instanceof alo ? ((alo)var3).c() : super.j(var1, var2);
   }

   public int c(alz var1) {
      byte var2 = 0;
      int var3 = var2 | ((cq)var1.b(a)).a();
      if ((Boolean)var1.b(b)) {
         var3 |= 8;
      }

      return var3;
   }

   public void a(adq var1, cj var2) {
      switch((cq)var1.p(var2).b(a)) {
      case b:
      default:
         this.a(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
         break;
      case c:
         this.a(0.25F, 0.25F, 0.5F, 0.75F, 0.75F, 1.0F);
         break;
      case d:
         this.a(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.5F);
         break;
      case e:
         this.a(0.5F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F);
         break;
      case f:
         this.a(0.0F, 0.25F, 0.25F, 0.5F, 0.75F, 0.75F);
      }

   }

   public void b(adm var1, cj var2, alz var3) {
      if (!var1.D) {
         if (!(Boolean)var3.b(b)) {
            akw var4 = var1.s(var2);
            if (var4 instanceof alo) {
               alo var5 = (alo)var4;
               zx var6 = new zx(zy.bX, 1, this.j(var1, var2));
               if (var5.c() == 3 && var5.b() != null) {
                  var6.d(new dn());
                  dn var7 = new dn();
                  dy.a(var7, var5.b());
                  var6.o().a((String)"SkullOwner", (eb)var7);
               }

               a(var1, var2, (zx)var6);
            }
         }

         super.b(var1, var2, var3);
      }
   }
}
