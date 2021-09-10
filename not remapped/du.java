import com.google.common.collect.Lists;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class du extends eb {
   private static final Logger b = LogManager.getLogger();
   private List<eb> c = Lists.newArrayList();
   private byte d = 0;

   public dn b(int var1) {
      if (var1 >= 0 && var1 < this.c.size()) {
         eb var2 = (eb)this.c.get(var1);
         return var2.a() == 10 ? (dn)var2 : new dn();
      } else {
         return new dn();
      }
   }

   public eb b() {
      du var1 = new du();
      var1.d = this.d;
      Iterator var2 = this.c.iterator();

      while(var2.hasNext()) {
         eb var3 = (eb)var2.next();
         eb var4 = var3.b();
         var1.c.add(var4);
      }

      return var1;
   }

   public int c() {
      return this.c.size();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("[");

      for(int var2 = 0; var2 < this.c.size(); ++var2) {
         if (var2 != 0) {
            var1.append(',');
         }

         var1.append(var2).append(':').append(this.c.get(var2));
      }

      return var1.append(']').toString();
   }

   public float e(int var1) {
      if (var1 >= 0 && var1 < this.c.size()) {
         eb var2 = (eb)this.c.get(var1);
         return var2.a() == 5 ? ((dr)var2).h() : 0.0F;
      } else {
         return 0.0F;
      }
   }

   public double d(int var1) {
      if (var1 >= 0 && var1 < this.c.size()) {
         eb var2 = (eb)this.c.get(var1);
         return var2.a() == 6 ? ((dp)var2).g() : 0.0D;
      } else {
         return 0.0D;
      }
   }

   void a(DataInput var1, int var2, dw var3) throws IOException {
      var3.a(296L);
      if (var2 > 512) {
         throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
      } else {
         this.d = var1.readByte();
         int var4 = var1.readInt();
         if (this.d == 0 && var4 > 0) {
            throw new RuntimeException("Missing type on ListTag");
         } else {
            var3.a(32L * (long)var4);
            this.c = Lists.newArrayListWithCapacity(var4);

            for(int var5 = 0; var5 < var4; ++var5) {
               eb var6 = eb.a(this.d);
               var6.a(var1, var2 + 1, var3);
               this.c.add(var6);
            }

         }
      }
   }

   public void a(int var1, eb var2) {
      if (var2.a() == 0) {
         b.warn("Invalid TagEnd added to ListTag");
      } else if (var1 >= 0 && var1 < this.c.size()) {
         if (this.d == 0) {
            this.d = var2.a();
         } else if (this.d != var2.a()) {
            b.warn("Adding mismatching tag types to tag list");
            return;
         }

         this.c.set(var1, var2);
      } else {
         b.warn("index out of bounds to set tag in tag list");
      }
   }

   public String f(int var1) {
      if (var1 >= 0 && var1 < this.c.size()) {
         eb var2 = (eb)this.c.get(var1);
         return var2.a() == 8 ? var2.a_() : var2.toString();
      } else {
         return "";
      }
   }

   public void a(eb var1) {
      if (var1.a() == 0) {
         b.warn("Invalid TagEnd added to ListTag");
      } else {
         if (this.d == 0) {
            this.d = var1.a();
         } else if (this.d != var1.a()) {
            b.warn("Adding mismatching tag types to tag list");
            return;
         }

         this.c.add(var1);
      }
   }

   public eb a(int var1) {
      return (eb)this.c.remove(var1);
   }

   public int hashCode() {
      return super.hashCode() ^ this.c.hashCode();
   }

   public byte a() {
      return 9;
   }

   public eb g(int var1) {
      return (eb)(var1 >= 0 && var1 < this.c.size() ? (eb)this.c.get(var1) : new dq());
   }

   void a(DataOutput var1) throws IOException {
      if (!this.c.isEmpty()) {
         this.d = ((eb)this.c.get(0)).a();
      } else {
         this.d = 0;
      }

      var1.writeByte(this.d);
      var1.writeInt(this.c.size());

      for(int var2 = 0; var2 < this.c.size(); ++var2) {
         ((eb)this.c.get(var2)).a(var1);
      }

   }

   public int f() {
      return this.d;
   }

   public boolean c_() {
      return this.c.isEmpty();
   }

   public int[] c(int var1) {
      if (var1 >= 0 && var1 < this.c.size()) {
         eb var2 = (eb)this.c.get(var1);
         return var2.a() == 11 ? ((ds)var2).c() : new int[0];
      } else {
         return new int[0];
      }
   }

   public boolean equals(Object var1) {
      if (super.equals(var1)) {
         du var2 = (du)var1;
         if (this.d == var2.d) {
            return this.c.equals(var2.c);
         }
      }

      return false;
   }
}
