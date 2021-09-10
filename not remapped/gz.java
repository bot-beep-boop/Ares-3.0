import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class gz implements ff<fj> {
   private final List<gz.b> b = Lists.newArrayList();
   private gz.a a;

   public void a(em var1) throws IOException {
      this.a = (gz.a)var1.a(gz.a.class);
      int var2 = var1.e();

      for(int var3 = 0; var3 < var2; ++var3) {
         GameProfile var4 = null;
         int var5 = 0;
         adp.a var6 = null;
         eu var7 = null;
         switch(this.a) {
         case a:
            var4 = new GameProfile(var1.g(), var1.c(16));
            int var8 = var1.e();
            int var9 = 0;

            for(; var9 < var8; ++var9) {
               String var10 = var1.c(32767);
               String var11 = var1.c(32767);
               if (var1.readBoolean()) {
                  var4.getProperties().put(var10, new Property(var10, var11, var1.c(32767)));
               } else {
                  var4.getProperties().put(var10, new Property(var10, var11));
               }
            }

            var6 = adp.a.a(var1.e());
            var5 = var1.e();
            if (var1.readBoolean()) {
               var7 = var1.d();
            }
            break;
         case b:
            var4 = new GameProfile(var1.g(), (String)null);
            var6 = adp.a.a(var1.e());
            break;
         case c:
            var4 = new GameProfile(var1.g(), (String)null);
            var5 = var1.e();
            break;
         case d:
            var4 = new GameProfile(var1.g(), (String)null);
            if (var1.readBoolean()) {
               var7 = var1.d();
            }
            break;
         case e:
            var4 = new GameProfile(var1.g(), (String)null);
         }

         this.b.add(new gz.b(this, var4, var5, var6, var7));
      }

   }

   public String toString() {
      return Objects.toStringHelper(this).add("action", this.a).add("entries", this.b).toString();
   }

   public void b(em var1) throws IOException {
      var1.a((Enum)this.a);
      var1.b(this.b.size());
      Iterator var2 = this.b.iterator();

      while(true) {
         while(var2.hasNext()) {
            gz.b var3 = (gz.b)var2.next();
            switch(this.a) {
            case a:
               var1.a(var3.a().getId());
               var1.a(var3.a().getName());
               var1.b(var3.a().getProperties().size());
               Iterator var4 = var3.a().getProperties().values().iterator();

               while(var4.hasNext()) {
                  Property var5 = (Property)var4.next();
                  var1.a(var5.getName());
                  var1.a(var5.getValue());
                  if (var5.hasSignature()) {
                     var1.writeBoolean(true);
                     var1.a(var5.getSignature());
                  } else {
                     var1.writeBoolean(false);
                  }
               }

               var1.b(var3.c().a());
               var1.b(var3.b());
               if (var3.d() == null) {
                  var1.writeBoolean(false);
               } else {
                  var1.writeBoolean(true);
                  var1.a(var3.d());
               }
               break;
            case b:
               var1.a(var3.a().getId());
               var1.b(var3.c().a());
               break;
            case c:
               var1.a(var3.a().getId());
               var1.b(var3.b());
               break;
            case d:
               var1.a(var3.a().getId());
               if (var3.d() == null) {
                  var1.writeBoolean(false);
               } else {
                  var1.writeBoolean(true);
                  var1.a(var3.d());
               }
               break;
            case e:
               var1.a(var3.a().getId());
            }
         }

         return;
      }
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public gz() {
   }

   public List<gz.b> a() {
      return this.b;
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public gz(gz.a var1, lf... var2) {
      this.a = var1;
      lf[] var3 = var2;
      int var4 = var2.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         lf var6 = var3[var5];
         this.b.add(new gz.b(this, var6.cd(), var6.h, var6.c.b(), var6.E()));
      }

   }

   public gz.a b() {
      return this.a;
   }

   public gz(gz.a var1, Iterable<lf> var2) {
      this.a = var1;
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         lf var4 = (lf)var3.next();
         this.b.add(new gz.b(this, var4.cd(), var4.h, var4.c.b(), var4.E()));
      }

   }

   public class b {
      final gz a;
      private final int b;
      private final GameProfile d;
      private final adp.a c;
      private final eu e;

      public eu d() {
         return this.e;
      }

      public int b() {
         return this.b;
      }

      public String toString() {
         return Objects.toStringHelper(this).add("latency", this.b).add("gameMode", this.c).add("profile", this.d).add("displayName", this.e == null ? null : eu.a.a(this.e)).toString();
      }

      public adp.a c() {
         return this.c;
      }

      public GameProfile a() {
         return this.d;
      }

      public b(gz var1, GameProfile var2, int var3, adp.a var4, eu var5) {
         this.a = var1;
         this.d = var2;
         this.b = var3;
         this.c = var4;
         this.e = var5;
      }
   }

   public static enum a {
      private static final gz.a[] f = new gz.a[]{a, b, c, d, e};
      a,
      c,
      d,
      b,
      e;
   }
}
