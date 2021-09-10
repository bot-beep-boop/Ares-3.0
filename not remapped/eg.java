import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.util.List;
import javax.crypto.Cipher;

public class eg extends MessageToMessageDecoder<ByteBuf> {
   private final ef a;

   protected void a(ChannelHandlerContext var1, ByteBuf var2, List<Object> var3) throws Exception {
      var3.add(this.a.a(var1, var2));
   }

   public eg(Cipher var1) {
      this.a = new ef(var1);
   }

   protected void decode(ChannelHandlerContext var1, Object var2, List var3) throws Exception {
      this.a(var1, (ByteBuf)var2, var3);
   }
}
