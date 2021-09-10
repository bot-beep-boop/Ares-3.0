import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderException;
import java.util.List;
import java.util.zip.Inflater;

public class ei extends ByteToMessageDecoder {
   private int b;
   private final Inflater a;

   public void a(int var1) {
      this.b = var1;
   }

   public ei(int var1) {
      this.b = var1;
      this.a = new Inflater();
   }

   protected void decode(ChannelHandlerContext var1, ByteBuf var2, List<Object> var3) throws Exception {
      if (var2.readableBytes() != 0) {
         em var4 = new em(var2);
         int var5 = var4.e();
         if (var5 == 0) {
            var3.add(var4.readBytes(var4.readableBytes()));
         } else {
            if (var5 < this.b) {
               throw new DecoderException("Badly compressed packet - size of " + var5 + " is below server threshold of " + this.b);
            }

            if (var5 > 2097152) {
               throw new DecoderException("Badly compressed packet - size of " + var5 + " is larger than protocol maximum of " + 2097152);
            }

            byte[] var6 = new byte[var4.readableBytes()];
            var4.readBytes(var6);
            this.a.setInput(var6);
            byte[] var7 = new byte[var5];
            this.a.inflate(var7);
            var3.add(Unpooled.wrappedBuffer(var7));
            this.a.reset();
         }

      }
   }
}
