import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.server.MinecraftServer;

public class kk extends auo {
   private aup c;
   private final Set<auk> b = Sets.newHashSet();
   private final MinecraftServer a;

   public void a(String var1) {
      super.a(var1);
      this.a.ap().a((ff)(new hs(var1)));
      this.b();
   }

   public void a(aul var1) {
      super.a(var1);
      this.a.ap().a((ff)(new hr(var1, 0)));
      this.b();
   }

   public List<ff> f(auk var1) {
      ArrayList var2 = Lists.newArrayList();
      var2.add(new hq(var1, 1));

      for(int var3 = 0; var3 < 19; ++var3) {
         if (this.a(var3) == var1) {
            var2.add(new hj(var3, var1));
         }
      }

      return var2;
   }

   public boolean a(String var1, String var2) {
      if (super.a(var1, var2)) {
         aul var3 = this.d(var2);
         this.a.ap().a((ff)(new hr(var3, Arrays.asList(var1), 3)));
         this.b();
         return true;
      } else {
         return false;
      }
   }

   public void a(String var1, auk var2) {
      super.a(var1, var2);
      this.a.ap().a((ff)(new hs(var1, var2)));
      this.b();
   }

   public void b(auk var1) {
      super.b(var1);
      if (this.b.contains(var1)) {
         this.a.ap().a((ff)(new hq(var1, 2)));
      }

      this.b();
   }

   public void a(int var1, auk var2) {
      auk var3 = this.a(var1);
      super.a(var1, var2);
      if (var3 != var2 && var3 != null) {
         if (this.h(var3) > 0) {
            this.a.ap().a((ff)(new hj(var1, var2)));
         } else {
            this.g(var3);
         }
      }

      if (var2 != null) {
         if (this.b.contains(var2)) {
            this.a.ap().a((ff)(new hj(var1, var2)));
         } else {
            this.e(var2);
         }
      }

      this.b();
   }

   public void c(aul var1) {
      super.c(var1);
      this.a.ap().a((ff)(new hr(var1, 1)));
      this.b();
   }

   public void e(auk var1) {
      List var2 = this.d(var1);
      Iterator var3 = this.a.ap().v().iterator();

      while(var3.hasNext()) {
         lf var4 = (lf)var3.next();
         Iterator var5 = var2.iterator();

         while(var5.hasNext()) {
            ff var6 = (ff)var5.next();
            var4.a.a(var6);
         }
      }

      this.b.add(var1);
   }

   public int h(auk var1) {
      int var2 = 0;

      for(int var3 = 0; var3 < 19; ++var3) {
         if (this.a(var3) == var1) {
            ++var2;
         }
      }

      return var2;
   }

   public void a(String var1, aul var2) {
      super.a(var1, var2);
      this.a.ap().a((ff)(new hr(var2, Arrays.asList(var1), 4)));
      this.b();
   }

   public void b(aul var1) {
      super.b(var1);
      this.a.ap().a((ff)(new hr(var1, 2)));
      this.b();
   }

   public void a(auk var1) {
      super.a(var1);
      this.b();
   }

   public List<ff> d(auk var1) {
      ArrayList var2 = Lists.newArrayList();
      var2.add(new hq(var1, 0));

      for(int var3 = 0; var3 < 19; ++var3) {
         if (this.a(var3) == var1) {
            var2.add(new hj(var3, var1));
         }
      }

      Iterator var5 = this.i(var1).iterator();

      while(var5.hasNext()) {
         aum var4 = (aum)var5.next();
         var2.add(new hs(var4));
      }

      return var2;
   }

   public void a(aup var1) {
      this.c = var1;
   }

   public void g(auk var1) {
      List var2 = this.f(var1);
      Iterator var3 = this.a.ap().v().iterator();

      while(var3.hasNext()) {
         lf var4 = (lf)var3.next();
         Iterator var5 = var2.iterator();

         while(var5.hasNext()) {
            ff var6 = (ff)var5.next();
            var4.a.a(var6);
         }
      }

      this.b.remove(var1);
   }

   protected void b() {
      if (this.c != null) {
         this.c.c();
      }

   }

   public void a(aum var1) {
      super.a(var1);
      if (this.b.contains(var1.d())) {
         this.a.ap().a((ff)(new hs(var1)));
      }

      this.b();
   }

   public kk(MinecraftServer var1) {
      this.a = var1;
   }

   public void c(auk var1) {
      super.c(var1);
      if (this.b.contains(var1)) {
         this.g(var1);
      }

      this.b();
   }
}
