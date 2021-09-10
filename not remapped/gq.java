import java.io.IOException;

public class gq implements ff<fj> {
   private cj b;
   private int c;
   private int a;
   private boolean d;

   public boolean a() {
      return this.d;
   }

   public void b(em var1) throws IOException {
      var1.writeInt(this.a);
      var1.a(this.b);
      var1.writeInt(this.c);
      var1.writeBoolean(this.d);
   }

   public int c() {
      return this.c;
   }

   public cj d() {
      return this.b;
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public gq(int var1, cj var2, int var3, boolean var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public void a(em var1) throws IOException {
      this.a = var1.readInt();
      this.b = var1.c();
      this.c = var1.readInt();
      this.d = var1.readBoolean();
   }

   public int b() {
      return this.a;
   }

   public gq() {
   }
}
