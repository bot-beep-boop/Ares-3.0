import com.google.common.collect.Maps;
import com.mojang.authlib.GameProfile;
import com.mojang.util.UUIDTypeAdapter;
import java.util.Map;
import java.util.UUID;

public class avm {
   private final String a;
   private final String b;
   private final avm.a d;
   private final String c;

   public avm(String var1, String var2, String var3, String var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = avm.a.a(var4);
   }

   public String b() {
      return this.b;
   }

   public String c() {
      return this.a;
   }

   public String a() {
      return "token:" + this.c + ":" + this.b;
   }

   public String d() {
      return this.c;
   }

   public GameProfile e() {
      try {
         UUID var1 = UUIDTypeAdapter.fromString(this.b());
         return new GameProfile(var1, this.c());
      } catch (IllegalArgumentException var2) {
         return new GameProfile((UUID)null, this.c());
      }
   }

   public avm.a f() {
      return this.d;
   }

   public static enum a {
      private static final avm.a[] e = new avm.a[]{a, b};
      b("mojang");

      private final String d;
      a("legacy");

      private static final Map<String, avm.a> c = Maps.newHashMap();

      private a(String var3) {
         this.d = var3;
      }

      public static avm.a a(String var0) {
         return (avm.a)c.get(var0.toLowerCase());
      }

      static {
         avm.a[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            avm.a var3 = var0[var2];
            c.put(var3.d, var3);
         }

      }
   }
}
