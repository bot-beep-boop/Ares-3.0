import java.io.IOException;

public class ih implements ff<ic> {
   private String a;
   private boolean d;
   private wn.b c;
   private int e;
   private int b;

   public wn.b c() {
      return this.c;
   }

   public String a() {
      return this.a;
   }

   public ih() {
   }

   public void a(ic var1) {
      var1.a(this);
   }

   public int e() {
      return this.e;
   }

   public ih(String var1, int var2, wn.b var3, boolean var4, int var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   public void a(em var1) throws IOException {
      this.a = var1.c(7);
      this.b = var1.readByte();
      this.c = wn.b.a(var1.readByte());
      this.d = var1.readBoolean();
      this.e = var1.readUnsignedByte();
   }

   public void b(em var1) throws IOException {
      var1.a(this.a);
      var1.writeByte(this.b);
      var1.writeByte(this.c.a());
      var1.writeBoolean(this.d);
      var1.writeByte(this.e);
   }

   public void a(ep var1) {
      this.a((ic)var1);
   }

   public boolean d() {
      return this.d;
   }
}
