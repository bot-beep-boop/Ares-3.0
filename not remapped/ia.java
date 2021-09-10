import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class ia implements ff<fj> {
   private int a;
   private final List<ia.a> b = Lists.newArrayList();

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public List<ia.a> b() {
      return this.b;
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public ia(int var1, Collection<qc> var2) {
      this.a = var1;
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         qc var4 = (qc)var3.next();
         this.b.add(new ia.a(this, var4.a().a(), var4.b(), var4.c()));
      }

   }

   public int a() {
      return this.a;
   }

   public void a(em var1) throws IOException {
      this.a = var1.e();
      int var2 = var1.readInt();

      for(int var3 = 0; var3 < var2; ++var3) {
         String var4 = var1.c(64);
         double var5 = var1.readDouble();
         ArrayList var7 = Lists.newArrayList();
         int var8 = var1.e();

         for(int var9 = 0; var9 < var8; ++var9) {
            UUID var10 = var1.g();
            var7.add(new qd(var10, "Unknown synced attribute modifier", var1.readDouble(), var1.readByte()));
         }

         this.b.add(new ia.a(this, var4, var5, var7));
      }

   }

   public ia() {
   }

   public void b(em var1) throws IOException {
      var1.b(this.a);
      var1.writeInt(this.b.size());
      Iterator var2 = this.b.iterator();

      while(var2.hasNext()) {
         ia.a var3 = (ia.a)var2.next();
         var1.a(var3.a());
         var1.writeDouble(var3.b());
         var1.b(var3.c().size());
         Iterator var4 = var3.c().iterator();

         while(var4.hasNext()) {
            qd var5 = (qd)var4.next();
            var1.a(var5.a());
            var1.writeDouble(var5.d());
            var1.writeByte(var5.c());
         }
      }

   }

   public class a {
      private final double c;
      private final String b;
      final ia a;
      private final Collection<qd> d;

      public Collection<qd> c() {
         return this.d;
      }

      public double b() {
         return this.c;
      }

      public a(ia var1, String var2, double var3, Collection var5) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var5;
      }

      public String a() {
         return this.b;
      }
   }
}
