import java.io.OutputStream;
import java.io.PrintStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class kg extends PrintStream {
   private static final Logger a = LogManager.getLogger();
   private final String b;

   public void println(String var1) {
      this.a(var1);
   }

   private void a(String var1) {
      StackTraceElement[] var2 = Thread.currentThread().getStackTrace();
      StackTraceElement var3 = var2[Math.min(3, var2.length)];
      a.info("[{}]@.({}:{}): {}", new Object[]{this.b, var3.getFileName(), var3.getLineNumber(), var1});
   }

   public void println(Object var1) {
      this.a(String.valueOf(var1));
   }

   public kg(String var1, OutputStream var2) {
      super(var2);
      this.b = var1;
   }
}
