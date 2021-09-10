import com.google.common.collect.Lists;
import java.util.List;

public class bhq {
   public static final bhq a = new bhq() {
      public boolean a(cq var1, cq var2) {
         return false;
      }

      protected void a(adf var1) {
         throw new UnsupportedOperationException();
      }

      public void c(adf var1) {
         throw new UnsupportedOperationException();
      }
   };
   private final List<akw> e = Lists.newArrayList();
   private boolean d = true;
   private final boolean[] c = new boolean[adf.values().length];
   private bhx f = new bhx();
   private bfd.a g;
   private final boolean[] b = new boolean[adf.values().length];

   public boolean a(cq var1, cq var2) {
      return this.f.a(var1, var2);
   }

   public List<akw> b() {
      return this.e;
   }

   public void c(adf var1) {
      this.c[var1.ordinal()] = true;
   }

   public void a(akw var1) {
      this.e.add(var1);
   }

   public void a(bhx var1) {
      this.f = var1;
   }

   public boolean d(adf var1) {
      return this.c[var1.ordinal()];
   }

   public void a(bfd.a var1) {
      this.g = var1;
   }

   protected void a(adf var1) {
      this.d = false;
      this.b[var1.ordinal()] = true;
   }

   public boolean a() {
      return this.d;
   }

   public boolean b(adf var1) {
      return !this.b[var1.ordinal()];
   }

   public bfd.a c() {
      return this.g;
   }
}
