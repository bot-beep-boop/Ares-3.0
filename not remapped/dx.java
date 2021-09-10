import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class dx {
   public static void a(dn var0, DataOutput var1) throws IOException {
      a((eb)var0, (DataOutput)var1);
   }

   public static void a(dn var0, OutputStream var1) throws IOException {
      DataOutputStream var2 = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(var1)));

      try {
         a((dn)var0, (DataOutput)var2);
      } finally {
         var2.close();
      }

   }

   public static dn a(DataInput var0, dw var1) throws IOException {
      eb var2 = a(var0, 0, var1);
      if (var2 instanceof dn) {
         return (dn)var2;
      } else {
         throw new IOException("Root tag must be a named compound tag");
      }
   }

   public static dn a(File var0) throws IOException {
      if (!var0.exists()) {
         return null;
      } else {
         DataInputStream var1 = new DataInputStream(new FileInputStream(var0));

         dn var2;
         try {
            var2 = a((DataInput)var1, (dw)dw.a);
         } finally {
            var1.close();
         }

         return var2;
      }
   }

   public static void a(dn var0, File var1) throws IOException {
      File var2 = new File(var1.getAbsolutePath() + "_tmp");
      if (var2.exists()) {
         var2.delete();
      }

      b(var0, var2);
      if (var1.exists()) {
         var1.delete();
      }

      if (var1.exists()) {
         throw new IOException("Failed to delete " + var1);
      } else {
         var2.renameTo(var1);
      }
   }

   public static dn a(InputStream var0) throws IOException {
      DataInputStream var1 = new DataInputStream(new BufferedInputStream(new GZIPInputStream(var0)));

      dn var2;
      try {
         var2 = a((DataInput)var1, (dw)dw.a);
      } finally {
         var1.close();
      }

      return var2;
   }

   private static eb a(DataInput var0, int var1, dw var2) throws IOException {
      byte var3 = var0.readByte();
      if (var3 == 0) {
         return new dq();
      } else {
         var0.readUTF();
         eb var4 = eb.a(var3);

         try {
            var4.a(var0, var1, var2);
            return var4;
         } catch (IOException var8) {
            b var6 = b.a(var8, "Loading NBT data");
            c var7 = var6.a("NBT Tag");
            var7.a((String)"Tag name", (Object)"[UNNAMED TAG]");
            var7.a((String)"Tag type", (Object)var3);
            throw new e(var6);
         }
      }
   }

   private static void a(eb var0, DataOutput var1) throws IOException {
      var1.writeByte(var0.a());
      if (var0.a() != 0) {
         var1.writeUTF("");
         var0.a(var1);
      }
   }

   public static void b(dn var0, File var1) throws IOException {
      DataOutputStream var2 = new DataOutputStream(new FileOutputStream(var1));

      try {
         a((dn)var0, (DataOutput)var2);
      } finally {
         var2.close();
      }

   }

   public static dn a(DataInputStream var0) throws IOException {
      return a((DataInput)var0, (dw)dw.a);
   }
}
