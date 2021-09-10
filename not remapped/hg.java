import java.io.IOException;

public class hg implements ff<fj> {
   private long g;
   private hg.a a;
   private int b;
   private int h;
   private double e;
   private double c;
   private int i;
   private double d;
   private double f;

   public hg() {
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public void a(em var1) throws IOException {
      this.a = (hg.a)var1.a(hg.a.class);
      switch(this.a) {
      case a:
         this.e = var1.readDouble();
         break;
      case b:
         this.f = var1.readDouble();
         this.e = var1.readDouble();
         this.g = var1.f();
         break;
      case c:
         this.c = var1.readDouble();
         this.d = var1.readDouble();
         break;
      case f:
         this.i = var1.e();
         break;
      case e:
         this.h = var1.e();
         break;
      case d:
         this.c = var1.readDouble();
         this.d = var1.readDouble();
         this.f = var1.readDouble();
         this.e = var1.readDouble();
         this.g = var1.f();
         this.b = var1.e();
         this.i = var1.e();
         this.h = var1.e();
      }

   }

   public void a(ams var1) {
      switch(this.a) {
      case a:
         var1.a(this.e);
         break;
      case b:
         var1.a(this.f, this.e, this.g);
         break;
      case c:
         var1.c(this.c, this.d);
         break;
      case f:
         var1.c(this.i);
         break;
      case e:
         var1.b(this.h);
         break;
      case d:
         var1.c(this.c, this.d);
         if (this.g > 0L) {
            var1.a(this.f, this.e, this.g);
         } else {
            var1.a(this.e);
         }

         var1.a(this.b);
         var1.c(this.i);
         var1.b(this.h);
      }

   }

   public void b(em var1) throws IOException {
      var1.a((Enum)this.a);
      switch(this.a) {
      case a:
         var1.writeDouble(this.e);
         break;
      case b:
         var1.writeDouble(this.f);
         var1.writeDouble(this.e);
         var1.b(this.g);
         break;
      case c:
         var1.writeDouble(this.c);
         var1.writeDouble(this.d);
         break;
      case f:
         var1.b(this.i);
         break;
      case e:
         var1.b(this.h);
         break;
      case d:
         var1.writeDouble(this.c);
         var1.writeDouble(this.d);
         var1.writeDouble(this.f);
         var1.writeDouble(this.e);
         var1.b(this.g);
         var1.b(this.b);
         var1.b(this.i);
         var1.b(this.h);
      }

   }

   public void a(fj var1) {
      var1.a(this);
   }

   public hg(ams var1, hg.a var2) {
      this.a = var2;
      this.c = var1.f();
      this.d = var1.g();
      this.f = var1.h();
      this.e = var1.j();
      this.g = var1.i();
      this.b = var1.l();
      this.i = var1.q();
      this.h = var1.p();
   }

   public static enum a {
      a,
      e;

      private static final hg.a[] g = new hg.a[]{a, b, c, d, e, f};
      b,
      c,
      d,
      f;
   }
}
