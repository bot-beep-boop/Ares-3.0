import com.google.common.collect.Lists;
import java.util.List;

public class bkm extends bje<we> {
   private final List<blb<we>> o;
   private static final jy j = new jy("textures/entity/zombie/zombie.png");
   private final List<blb<we>> n;
   private static final jy k = new jy("textures/entity/zombie/zombie_villager.png");
   private final bbj l;
   private final bcj m;

   public void a(pr var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((we)var1, var2, var4, var6, var8, var9);
   }

   protected jy a(we var1) {
      return var1.co() ? k : j;
   }

   protected void a(pr var1, float var2, float var3, float var4) {
      this.a((we)var1, var2, var3, var4);
   }

   public void a(pk var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((we)var1, var2, var4, var6, var8, var9);
   }

   public void a(ps var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((we)var1, var2, var4, var6, var8, var9);
   }

   protected jy a(ps var1) {
      return this.a((we)var1);
   }

   public void a(we var1, double var2, double var4, double var6, float var8, float var9) {
      this.b(var1);
      super.a(var1, var2, var4, var6, var8, var9);
   }

   protected jy a(pk var1) {
      return this.a((we)var1);
   }

   private void b(we var1) {
      if (var1.co()) {
         this.f = this.m;
         this.h = this.n;
      } else {
         this.f = this.l;
         this.h = this.o;
      }

      this.a = (bbj)this.f;
   }

   protected void a(we var1, float var2, float var3, float var4) {
      if (var1.cp()) {
         var3 += (float)(Math.cos((double)var1.W * 3.25D) * 3.141592653589793D * 0.25D);
      }

      super.a(var1, var2, var3, var4);
   }

   public bkm(biu var1) {
      super(var1, new bcn(), 0.5F, 1.0F);
      blb var2 = (blb)this.h.get(0);
      this.l = this.a;
      this.m = new bcj();
      this.a((blb)(new bky(this)));
      bkx var3 = new bkx(this, this) {
         final bkm a;

         {
            this.a = var1;
         }

         protected void a() {
            this.c = new bcn(0.5F, true);
            this.d = new bcn(1.0F, true);
         }
      };
      this.a((blb)var3);
      this.o = Lists.newArrayList(this.h);
      if (var2 instanceof bks) {
         this.b(var2);
         this.a((blb)(new bks(this.m.e)));
      }

      this.b(var3);
      this.a((blb)(new blg(this)));
      this.n = Lists.newArrayList(this.h);
   }
}
