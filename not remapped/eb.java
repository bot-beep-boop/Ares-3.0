import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public abstract class eb {
   public static final String[] a = new String[]{"END", "BYTE", "SHORT", "INT", "LONG", "FLOAT", "DOUBLE", "BYTE[]", "STRING", "LIST", "COMPOUND", "INT[]"};

   abstract void a(DataInput var1, int var2, dw var3) throws IOException;

   protected static eb a(byte var0) {
      switch(var0) {
      case 0:
         return new dq();
      case 1:
         return new dm();
      case 2:
         return new dz();
      case 3:
         return new dt();
      case 4:
         return new dv();
      case 5:
         return new dr();
      case 6:
         return new dp();
      case 7:
         return new dl();
      case 8:
         return new ea();
      case 9:
         return new du();
      case 10:
         return new dn();
      case 11:
         return new ds();
      default:
         return null;
      }
   }

   protected String a_() {
      return this.toString();
   }

   abstract void a(DataOutput var1) throws IOException;

   public abstract String toString();

   protected eb() {
   }

   public abstract eb b();

   public int hashCode() {
      return this.a();
   }

   public boolean equals(Object var1) {
      if (!(var1 instanceof eb)) {
         return false;
      } else {
         eb var2 = (eb)var1;
         return this.a() == var2.a();
      }
   }

   public abstract byte a();

   public boolean c_() {
      return false;
   }

   public abstract static class a extends eb {
      public abstract byte f();

      public abstract double g();

      public abstract int d();

      public abstract short e();

      public abstract float h();

      public abstract long c();

      protected a() {
      }
   }
}
