import io.netty.buffer.ByteBuf;
import java.io.IOException;

public class gg implements ff<fj> {
   private String a;
   private em b;

   public em b() {
      return this.b;
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public String a() {
      return this.a;
   }

   public void b(em var1) throws IOException {
      var1.a(this.a);
      var1.writeBytes((ByteBuf)this.b);
   }

   public void a(em var1) throws IOException {
      this.a = var1.c(20);
      int var2 = var1.readableBytes();
      if (var2 >= 0 && var2 <= 1048576) {
         this.b = new em(var1.readBytes(var2));
      } else {
         throw new IOException("Payload may not be larger than 1048576 bytes");
      }
   }

   public gg() {
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public gg(String var1, em var2) {
      this.a = var1;
      this.b = var2;
      if (var2.writerIndex() > 1048576) {
         throw new IllegalArgumentException("Payload may not be larger than 1048576 bytes");
      }
   }
}
