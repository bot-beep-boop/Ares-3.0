import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class hr implements ff<fj> {
   private String c = "";
   private String a = "";
   private int i;
   private String d = "";
   private String b = "";
   private int h;
   private Collection<String> g;
   private String e;
   private int f;

   public Collection<String> e() {
      return this.g;
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public void a(em var1) throws IOException {
      this.a = var1.c(16);
      this.h = var1.readByte();
      if (this.h == 0 || this.h == 2) {
         this.b = var1.c(32);
         this.c = var1.c(16);
         this.d = var1.c(16);
         this.i = var1.readByte();
         this.e = var1.c(32);
         this.f = var1.readByte();
      }

      if (this.h == 0 || this.h == 3 || this.h == 4) {
         int var2 = var1.e();

         for(int var3 = 0; var3 < var2; ++var3) {
            this.g.add(var1.c(40));
         }
      }

   }

   public int h() {
      return this.f;
   }

   public hr(aul var1, int var2) {
      this.e = auq.a.a.e;
      this.f = -1;
      this.g = Lists.newArrayList();
      this.a = var1.b();
      this.h = var2;
      if (var2 == 0 || var2 == 2) {
         this.b = var1.c();
         this.c = var1.e();
         this.d = var1.f();
         this.i = var1.k();
         this.e = var1.i().e;
         this.f = var1.l().b();
      }

      if (var2 == 0) {
         this.g.addAll(var1.d());
      }

   }

   public String i() {
      return this.e;
   }

   public int g() {
      return this.i;
   }

   public hr(aul var1, Collection<String> var2, int var3) {
      this.e = auq.a.a.e;
      this.f = -1;
      this.g = Lists.newArrayList();
      if (var3 != 3 && var3 != 4) {
         throw new IllegalArgumentException("Method must be join or leave for player constructor");
      } else if (var2 != null && !var2.isEmpty()) {
         this.h = var3;
         this.a = var1.b();
         this.g.addAll(var2);
      } else {
         throw new IllegalArgumentException("Players cannot be null/empty");
      }
   }

   public hr() {
      this.e = auq.a.a.e;
      this.f = -1;
      this.g = Lists.newArrayList();
   }

   public int f() {
      return this.h;
   }

   public void b(em var1) throws IOException {
      var1.a(this.a);
      var1.writeByte(this.h);
      if (this.h == 0 || this.h == 2) {
         var1.a(this.b);
         var1.a(this.c);
         var1.a(this.d);
         var1.writeByte(this.i);
         var1.a(this.e);
         var1.writeByte(this.f);
      }

      if (this.h == 0 || this.h == 3 || this.h == 4) {
         var1.b(this.g.size());
         Iterator var2 = this.g.iterator();

         while(var2.hasNext()) {
            String var3 = (String)var2.next();
            var1.a(var3);
         }
      }

   }

   public String c() {
      return this.c;
   }

   public String d() {
      return this.d;
   }

   public String a() {
      return this.a;
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public String b() {
      return this.b;
   }
}
