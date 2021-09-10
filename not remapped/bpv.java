import java.util.Random;

public class bpv implements km {
   private final Random a = new Random();
   private final ave b;
   private int d = 100;
   private bpj c;

   public bpv(ave var1) {
      this.b = var1;
   }

   public void a(bpv.a var1) {
      this.c = bpf.a(var1.a());
      this.b.W().a(this.c);
      this.d = Integer.MAX_VALUE;
   }

   public void a() {
      if (this.c != null) {
         this.b.W().b(this.c);
         this.c = null;
         this.d = 0;
      }

   }

   public void c() {
      bpv.a var1 = this.b.X();
      if (this.c != null) {
         if (!var1.a().equals(this.c.a())) {
            this.b.W().b(this.c);
            this.d = ns.a((Random)this.a, 0, var1.b() / 2);
         }

         if (!this.b.W().c(this.c)) {
            this.c = null;
            this.d = Math.min(ns.a(this.a, var1.b(), var1.c()), this.d);
         }
      }

      if (this.c == null && this.d-- <= 0) {
         this.a(var1);
      }

   }

   public static enum a {
      private static final bpv.a[] k = new bpv.a[]{a, b, c, d, e, f, g};
      private final jy h;
      a(new jy("minecraft:music.menu"), 20, 600);

      private final int i;
      b(new jy("minecraft:music.game"), 12000, 24000),
      d(new jy("minecraft:music.game.end.credits"), Integer.MAX_VALUE, Integer.MAX_VALUE),
      e(new jy("minecraft:music.game.nether"), 1200, 3600),
      c(new jy("minecraft:music.game.creative"), 1200, 3600),
      f(new jy("minecraft:music.game.end.dragon"), 0, 0),
      g(new jy("minecraft:music.game.end"), 6000, 24000);

      private final int j;

      public jy a() {
         return this.h;
      }

      public int b() {
         return this.i;
      }

      public int c() {
         return this.j;
      }

      private a(jy var3, int var4, int var5) {
         this.h = var3;
         this.i = var4;
         this.j = var5;
      }
   }
}
