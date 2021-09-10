import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import javax.crypto.Cipher;

public class eh extends MessageToByteEncoder<ByteBuf> {
   private final ef a;

   protected void encode(ChannelHandlerContext var1, Object var2, ByteBuf var3) throws Exception {
      this.a(var1, (ByteBuf)var2, var3);
   }

   public eh(Cipher var1) {
      this.a = new ef(var1);
   }

   protected void a(ChannelHandlerContext var1, ByteBuf var2, ByteBuf var3) throws Exception {
      this.a.a(var2, var3);
   }
}
