import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.awt.image.BufferedImage;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bnm {
   public final bnk a;
   private ListenableFuture<Object> i;
   private static final Logger c = LogManager.getLogger();
   private static final FileFilter d = new FileFilter() {
      public boolean accept(File var1) {
         boolean var2 = var1.isFile() && var1.getName().endsWith(".zip");
         boolean var3 = var1.isDirectory() && (new File(var1, "pack.mcmeta")).isFile();
         return var2 || var3;
      }
   };
   private final ReentrantLock h = new ReentrantLock();
   private bnk g;
   public final bny b;
   private List<bnm.a> j = Lists.newArrayList();
   private List<bnm.a> k = Lists.newArrayList();
   private final File f;
   private final File e;

   public bnm(File var1, File var2, bnk var3, bny var4, avh var5) {
      this.e = var1;
      this.f = var2;
      this.a = var3;
      this.b = var4;
      this.g();
      this.a();
      Iterator var6 = var5.k.iterator();

      while(true) {
         while(var6.hasNext()) {
            String var7 = (String)var6.next();
            Iterator var8 = this.j.iterator();

            while(var8.hasNext()) {
               bnm.a var9 = (bnm.a)var8.next();
               if (var9.d().equals(var7)) {
                  if (var9.f() == 1 || var5.l.contains(var9.d())) {
                     this.k.add(var9);
                     break;
                  }

                  var6.remove();
                  c.warn("Removed selected resource pack {} because it's no longer compatible", new Object[]{var9.d()});
               }
            }
         }

         return;
      }
   }

   public File d() {
      return this.e;
   }

   public void f() {
      this.h.lock();

      try {
         if (this.i != null) {
            this.i.cancel(true);
         }

         this.i = null;
         if (this.g != null) {
            this.g = null;
            ave.A().B();
         }
      } finally {
         this.h.unlock();
      }

   }

   public ListenableFuture<Object> a(File var1) {
      this.g = new bnc(var1);
      return ave.A().B();
   }

   public List<bnm.a> c() {
      return ImmutableList.copyOf(this.k);
   }

   public ListenableFuture<Object> a(String var1, String var2) {
      String var3;
      if (var2.matches("^[a-f0-9]{40}$")) {
         var3 = var2;
      } else {
         var3 = "legacy";
      }

      File var4 = new File(this.f, var3);
      this.h.lock();

      ListenableFuture var9;
      try {
         this.f();
         if (var4.exists() && var2.length() == 40) {
            try {
               String var5 = Hashing.sha1().hashBytes(Files.toByteArray(var4)).toString();
               if (var5.equals(var2)) {
                  ListenableFuture var16 = this.a(var4);
                  return var16;
               }

               c.warn("File " + var4 + " had wrong hash (expected " + var2 + ", found " + var5 + "). Deleting it.");
               FileUtils.deleteQuietly(var4);
            } catch (IOException var13) {
               c.warn("File " + var4 + " couldn't be hashed. Deleting it.", var13);
               FileUtils.deleteQuietly(var4);
            }
         }

         this.i();
         axr var15 = new axr();
         Map var6 = ave.ak();
         ave var7 = ave.A();
         Futures.getUnchecked(var7.a(new Runnable(this, var7, var15) {
            final bnm c;
            final ave a;
            final axr b;

            {
               this.c = var1;
               this.a = var2;
               this.b = var3;
            }

            public void run() {
               this.a.a((axu)this.b);
            }
         }));
         SettableFuture var8 = SettableFuture.create();
         this.i = nj.a(var4, var1, var6, 52428800, var15, var7.O());
         Futures.addCallback(this.i, new FutureCallback<Object>(this, var4, var8) {
            final SettableFuture b;
            final File a;
            final bnm c;

            {
               this.c = var1;
               this.a = var2;
               this.b = var3;
            }

            public void onSuccess(Object var1) {
               this.c.a(this.a);
               this.b.set((Object)null);
            }

            public void onFailure(Throwable var1) {
               this.b.setException(var1);
            }
         });
         var9 = this.i;
      } finally {
         this.h.unlock();
      }

      return var9;
   }

   private List<File> h() {
      return this.e.isDirectory() ? Arrays.asList(this.e.listFiles(d)) : Collections.emptyList();
   }

   public void a() {
      ArrayList var1 = Lists.newArrayList();
      Iterator var2 = this.h().iterator();

      while(var2.hasNext()) {
         File var3 = (File)var2.next();
         bnm.a var4 = new bnm.a(this, var3);
         if (!this.j.contains(var4)) {
            try {
               var4.a();
               var1.add(var4);
            } catch (Exception var6) {
               var1.remove(var4);
            }
         } else {
            int var5 = this.j.indexOf(var4);
            if (var5 > -1 && var5 < this.j.size()) {
               var1.add(this.j.get(var5));
            }
         }
      }

      this.j.removeAll(var1);
      var2 = this.j.iterator();

      while(var2.hasNext()) {
         bnm.a var7 = (bnm.a)var2.next();
         var7.b();
      }

      this.j = var1;
   }

   public List<bnm.a> b() {
      return ImmutableList.copyOf(this.j);
   }

   public bnk e() {
      return this.g;
   }

   public void a(List<bnm.a> var1) {
      this.k.clear();
      this.k.addAll(var1);
   }

   private void g() {
      if (this.e.exists()) {
         if (!this.e.isDirectory() && (!this.e.delete() || !this.e.mkdirs())) {
            c.warn("Unable to recreate resourcepack folder, it exists but is not a directory: " + this.e);
         }
      } else if (!this.e.mkdirs()) {
         c.warn("Unable to create resourcepack folder: " + this.e);
      }

   }

   private void i() {
      ArrayList var1 = Lists.newArrayList(FileUtils.listFiles(this.f, TrueFileFilter.TRUE, (IOFileFilter)null));
      Collections.sort(var1, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
      int var2 = 0;
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         File var4 = (File)var3.next();
         if (var2++ >= 10) {
            c.info("Deleting old server resource pack " + var4.getName());
            FileUtils.deleteQuietly(var4);
         }
      }

   }

   public class a {
      private final File b;
      final bnm a;
      private jy f;
      private bnk c;
      private BufferedImage e;
      private boj d;

      public int f() {
         return this.d.b();
      }

      public String e() {
         return this.d == null ? .a.m + "Invalid pack.mcmeta (or missing 'pack' section)" : this.d.a().d();
      }

      public int hashCode() {
         return this.toString().hashCode();
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else {
            return var1 instanceof bnm.a ? this.toString().equals(var1.toString()) : false;
         }
      }

      public void a(bmj var1) {
         if (this.f == null) {
            this.f = var1.a("texturepackicon", new blz(this.e));
         }

         var1.a(this.f);
      }

      public void a() throws IOException {
         this.c = (bnk)(this.b.isDirectory() ? new bnd(this.b) : new bnc(this.b));
         this.d = (boj)this.c.a(this.a.b, "pack");

         try {
            this.e = this.c.a();
         } catch (IOException var2) {
         }

         if (this.e == null) {
            this.e = this.a.a.a();
         }

         this.b();
      }

      public String toString() {
         return String.format("%s:%s:%d", this.b.getName(), this.b.isDirectory() ? "folder" : "zip", this.b.lastModified());
      }

      private a(bnm var1, File var2) {
         this.a = var1;
         this.b = var2;
      }

      public void b() {
         if (this.c instanceof Closeable) {
            IOUtils.closeQuietly((Closeable)this.c);
         }

      }

      public String d() {
         return this.c.b();
      }

      a(bnm var1, File var2, Object var3) {
         this(var1, var2);
      }

      public bnk c() {
         return this.c;
      }
   }
}
