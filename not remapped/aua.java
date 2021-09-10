import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class aua {
   protected Map<String, ate> a = Maps.newHashMap();
   private atp b;
   private Map<String, Short> d = Maps.newHashMap();
   private List<ate> c = Lists.newArrayList();

   public void a() {
      for(int var1 = 0; var1 < this.c.size(); ++var1) {
         ate var2 = (ate)this.c.get(var1);
         if (var2.d()) {
            this.a(var2);
            var2.a(false);
         }
      }

   }

   public ate a(Class<? extends ate> var1, String var2) {
      ate var3 = (ate)this.a.get(var2);
      if (var3 != null) {
         return var3;
      } else {
         if (this.b != null) {
            try {
               File var4 = this.b.a(var2);
               if (var4 != null && var4.exists()) {
                  try {
                     var3 = (ate)var1.getConstructor(String.class).newInstance(var2);
                  } catch (Exception var7) {
                     throw new RuntimeException("Failed to instantiate " + var1.toString(), var7);
                  }

                  FileInputStream var5 = new FileInputStream(var4);
                  dn var6 = dx.a((InputStream)var5);
                  var5.close();
                  var3.a(var6.m("data"));
               }
            } catch (Exception var8) {
               var8.printStackTrace();
            }
         }

         if (var3 != null) {
            this.a.put(var2, var3);
            this.c.add(var3);
         }

         return var3;
      }
   }

   private void b() {
      try {
         this.d.clear();
         if (this.b == null) {
            return;
         }

         File var1 = this.b.a("idcounts");
         if (var1 != null && var1.exists()) {
            DataInputStream var2 = new DataInputStream(new FileInputStream(var1));
            dn var3 = dx.a(var2);
            var2.close();
            Iterator var4 = var3.c().iterator();

            while(var4.hasNext()) {
               String var5 = (String)var4.next();
               eb var6 = var3.a(var5);
               if (var6 instanceof dz) {
                  dz var7 = (dz)var6;
                  short var9 = var7.e();
                  this.d.put(var5, var9);
               }
            }
         }
      } catch (Exception var10) {
         var10.printStackTrace();
      }

   }

   public int a(String var1) {
      Short var2 = (Short)this.d.get(var1);
      if (var2 == null) {
         var2 = Short.valueOf((short)0);
      } else {
         var2 = (short)(var2 + 1);
      }

      this.d.put(var1, var2);
      if (this.b == null) {
         return var2;
      } else {
         try {
            File var3 = this.b.a("idcounts");
            if (var3 != null) {
               dn var4 = new dn();
               Iterator var5 = this.d.keySet().iterator();

               while(var5.hasNext()) {
                  String var6 = (String)var5.next();
                  short var7 = (Short)this.d.get(var6);
                  var4.a(var6, var7);
               }

               DataOutputStream var9 = new DataOutputStream(new FileOutputStream(var3));
               dx.a((dn)var4, (DataOutput)var9);
               var9.close();
            }
         } catch (Exception var8) {
            var8.printStackTrace();
         }

         return var2;
      }
   }

   public aua(atp var1) {
      this.b = var1;
      this.b();
   }

   private void a(ate var1) {
      if (this.b != null) {
         try {
            File var2 = this.b.a(var1.a);
            if (var2 != null) {
               dn var3 = new dn();
               var1.b(var3);
               dn var4 = new dn();
               var4.a((String)"data", (eb)var3);
               FileOutputStream var5 = new FileOutputStream(var2);
               dx.a((dn)var4, (OutputStream)var5);
               var5.close();
            }
         } catch (Exception var6) {
            var6.printStackTrace();
         }

      }
   }

   public void a(String var1, ate var2) {
      if (this.a.containsKey(var1)) {
         this.c.remove(this.a.remove(var1));
      }

      this.a.put(var1, var2);
      this.c.add(var2);
   }
}
