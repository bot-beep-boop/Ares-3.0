import java.io.IOException;

public class gy implements ff<fj> {
   public gy.a a;
   public int b;
   public String e;
   public int d;
   public int c;

   public void a(em var1) throws IOException {
      this.a = (gy.a)var1.a(gy.a.class);
      if (this.a == gy.a.b) {
         this.d = var1.e();
         this.c = var1.readInt();
      } else if (this.a == gy.a.c) {
         this.b = var1.e();
         this.c = var1.readInt();
         this.e = var1.c(32767);
      }

   }

   public gy() {
   }

   public gy(ov var1, gy.a var2) {
      this.a = var2;
      pr var3 = var1.c();
      switch(var2) {
      case b:
         this.d = var1.f();
         this.c = var3 == null ? -1 : var3.F();
         break;
      case c:
         this.b = var1.h().F();
         this.c = var3 == null ? -1 : var3.F();
         this.e = var1.b().c();
      }

   }

   public void a(fj var1) {
      var1.a(this);
   }

   public void b(em var1) throws IOException {
      var1.a((Enum)this.a);
      if (this.a == gy.a.b) {
         var1.b(this.d);
         var1.writeInt(this.c);
      } else if (this.a == gy.a.c) {
         var1.b(this.b);
         var1.writeInt(this.c);
         var1.a(this.e);
      }

   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public static enum a {
      c;

      private static final gy.a[] d = new gy.a[]{a, b, c};
      a,
      b;
   }
}
