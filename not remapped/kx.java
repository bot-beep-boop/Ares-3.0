import net.minecraft.server.MinecraftServer;

public class kx extends le {
   private static final long I = (long)"North Carolina".hashCode();
   public static final adp a;

   static {
      a = (new adp(I, adp.a.b, true, false, adr.b)).a();
   }

   public kx(MinecraftServer var1, atp var2, ato var3, int var4, nt var5) {
      super(var1, var2, var3, var4, var5);
      this.x.a(a);
   }
}
