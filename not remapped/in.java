import java.io.IOException;

public class in implements ff<ic> {
   private in.a b;
   private aui c;
   private int a;

   public pk a(adm var1) {
      return var1.a(this.a);
   }

   public void a(ep var1) {
      this.a((ic)var1);
   }

   public in(pk var1, aui var2) {
      this(var1, in.a.c);
      this.c = var2;
   }

   public in(pk var1, in.a var2) {
      this.a = var1.F();
      this.b = var2;
   }

   public in.a a() {
      return this.b;
   }

   public void a(em var1) throws IOException {
      this.a = var1.e();
      this.b = (in.a)var1.a(in.a.class);
      if (this.b == in.a.c) {
         this.c = new aui((double)var1.readFloat(), (double)var1.readFloat(), (double)var1.readFloat());
      }

   }

   public in() {
   }

   public aui b() {
      return this.c;
   }

   public void b(em var1) throws IOException {
      var1.b(this.a);
      var1.a((Enum)this.b);
      if (this.b == in.a.c) {
         var1.writeFloat((float)this.c.a);
         var1.writeFloat((float)this.c.b);
         var1.writeFloat((float)this.c.c);
      }

   }

   public void a(ic var1) {
      var1.a(this);
   }

   public static enum a {
      c,
      b,
      a;

      private static final in.a[] d = new in.a[]{a, b, c};
   }
}
