import java.util.UUID;

public class bmz {
   private static final jy a = new jy("textures/entity/steve.png");
   private static final jy b = new jy("textures/entity/alex.png");

   public static jy a() {
      return a;
   }

   public static String b(UUID var0) {
      return c(var0) ? "slim" : "default";
   }

   private static boolean c(UUID var0) {
      return (var0.hashCode() & 1) == 1;
   }

   public static jy a(UUID var0) {
      return c(var0) ? b : a;
   }
}
