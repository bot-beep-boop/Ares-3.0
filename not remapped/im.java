import io.netty.buffer.ByteBuf;
import java.io.IOException;

public class im implements ff<ic> {
   private em b;
   private String a;

   public void b(em var1) throws IOException {
      var1.a(this.a);
      var1.writeBytes((ByteBuf)this.b);
   }

   public im(String var1, em var2) {
      this.a = var1;
      this.b = var2;
      if (var2.writerIndex() > 32767) {
         throw new IllegalArgumentException("Payload may not be larger than 32767 bytes");
      }
   }

   public im() {
   }

   public void a(ep var1) {
      this.a((ic)var1);
   }

   public em b() {
      return this.b;
   }

   public void a(em var1) throws IOException {
      this.a = var1.c(20);
      int var2 = var1.readableBytes();
      if (var2 >= 0 && var2 <= 32767) {
         this.b = new em(var1.readBytes(var2));
      } else {
         throw new IOException("Payload may not be larger than 32767 bytes");
      }
   }

   public String a() {
      return this.a;
   }

   public void a(ic var1) {
      var1.a(this);
   }
}
