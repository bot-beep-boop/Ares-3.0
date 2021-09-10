import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class eo extends MessageToByteEncoder<ff> {
   private static final Logger a = LogManager.getLogger();
   private final fg c;
   private static final Marker b;

   static {
      b = MarkerManager.getMarker("PACKET_SENT", ek.b);
   }

   protected void a(ChannelHandlerContext var1, ff var2, ByteBuf var3) throws Exception {
      Integer var4 = ((el)var1.channel().attr(ek.c).get()).a(this.c, var2);
      if (a.isDebugEnabled()) {
         a.debug(b, "OUT: [{}:{}] {}", new Object[]{var1.channel().attr(ek.c).get(), var4, var2.getClass().getName()});
      }

      if (var4 == null) {
         throw new IOException("Can't serialize unregistered packet");
      } else {
         em var5 = new em(var3);
         var5.b(var4);

         try {
            if (var2 instanceof fp) {
               var2 = var2;
            }

            var2.b(var5);
         } catch (Throwable var7) {
            a.error(var7);
         }

      }
   }

   protected void encode(ChannelHandlerContext var1, Object var2, ByteBuf var3) throws Exception {
      this.a(var1, (ff)var2, var3);
   }

   public eo(fg var1) {
      this.c = var1;
   }
}
