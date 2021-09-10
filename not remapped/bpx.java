import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import io.netty.util.internal.ThreadLocalRandom;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import paulscode.sound.SoundSystem;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.SoundSystemException;
import paulscode.sound.SoundSystemLogger;
import paulscode.sound.Source;
import paulscode.sound.codecs.CodecJOrbis;
import paulscode.sound.libraries.LibraryLWJGLOpenAL;

public class bpx {
   private int g = 0;
   private final Map<bpj, String> i;
   private bpx.a e;
   private Map<bpj, bpw> j;
   private final Map<bpj, Integer> m;
   private static final Marker a = MarkerManager.getMarker("SOUNDS");
   private final bpz c;
   private final Multimap<bpg, String> k;
   private final Map<String, bpj> h = HashBiMap.create();
   private boolean f;
   private final List<bpk> l;
   private final avh d;
   private final Map<String, Integer> n;
   private static final Logger b = LogManager.getLogger();

   private float a(bpg var1) {
      return var1 != null && var1 != bpg.a ? this.d.a(var1) : 1.0F;
   }

   private float a(bpj var1, bpw var2, bpg var3) {
      return (float)ns.a((double)var1.e() * var2.c(), 0.0D, 1.0D) * this.a(var3);
   }

   public void a() {
      this.b();
      this.i();
   }

   public void c() {
      if (this.f) {
         Iterator var1 = this.h.keySet().iterator();

         while(var1.hasNext()) {
            String var2 = (String)var1.next();
            this.e.stop(var2);
         }

         this.h.clear();
         this.m.clear();
         this.l.clear();
         this.k.clear();
         this.j.clear();
         this.n.clear();
      }

   }

   public void a(bpj var1, int var2) {
      this.m.put(var1, this.g + var2);
   }

   public boolean a(bpj var1) {
      if (!this.f) {
         return false;
      } else {
         String var2 = (String)this.i.get(var1);
         if (var2 == null) {
            return false;
         } else {
            return this.e.playing(var2) || this.n.containsKey(var2) && (Integer)this.n.get(var2) <= this.g;
         }
      }
   }

   static avh a(bpx var0) {
      return var0.d;
   }

   static boolean a(bpx var0, boolean var1) {
      return var0.f = var1;
   }

   private synchronized void i() {
      if (!this.f) {
         try {
            (new Thread(new Runnable(this) {
               final bpx a;

               public void run() {
                  SoundSystemConfig.setLogger(new SoundSystemLogger(this) {
                     final <undefinedtype> a;

                     public void errorMessage(String var1, String var2, int var3) {
                        if (!var2.isEmpty()) {
                           bpx.g().error("Error in class '" + var1 + "'");
                           bpx.g().error(var2);
                        }

                     }

                     public void importantMessage(String var1, int var2) {
                        if (!var1.isEmpty()) {
                           bpx.g().warn(var1);
                        }

                     }

                     {
                        this.a = var1;
                     }

                     public void message(String var1, int var2) {
                        if (!var1.isEmpty()) {
                           bpx.g().info(var1);
                        }

                     }
                  });
                  bpx.a(this.a, this.a.new a(this.a));
                  bpx.a(this.a, true);
                  bpx.b(this.a).setMasterVolume(bpx.a(this.a).a(bpg.a));
                  bpx.g().info(bpx.h(), "Sound engine started");
               }

               {
                  this.a = var1;
               }
            }, "Sound Library Loader")).start();
         } catch (RuntimeException var2) {
            b.error(a, "Error starting SoundSystem. Turning off sounds & music", var2);
            this.d.a(bpg.a, 0.0F);
            this.d.b();
         }

      }
   }

   public void b() {
      if (this.f) {
         this.c();
         this.e.cleanup();
         this.f = false;
      }

   }

   static bpx.a b(bpx var0) {
      return var0.e;
   }

   public void a(wn var1, float var2) {
      if (this.f && var1 != null) {
         float var3 = var1.B + (var1.z - var1.B) * var2;
         float var4 = var1.A + (var1.y - var1.A) * var2;
         double var5 = var1.p + (var1.s - var1.p) * (double)var2;
         double var7 = var1.q + (var1.t - var1.q) * (double)var2 + (double)var1.aS();
         double var9 = var1.r + (var1.u - var1.r) * (double)var2;
         float var11 = ns.b((var4 + 90.0F) * 0.017453292F);
         float var12 = ns.a((var4 + 90.0F) * 0.017453292F);
         float var13 = ns.b(-var3 * 0.017453292F);
         float var14 = ns.a(-var3 * 0.017453292F);
         float var15 = ns.b((-var3 + 90.0F) * 0.017453292F);
         float var16 = ns.a((-var3 + 90.0F) * 0.017453292F);
         float var17 = var11 * var13;
         float var19 = var12 * var13;
         float var20 = var11 * var15;
         float var22 = var12 * var15;
         this.e.setListenerPosition((float)var5, (float)var7, (float)var9);
         this.e.setListenerOrientation(var17, var14, var19, var20, var16, var22);
      }
   }

   static Logger g() {
      return b;
   }

   public void d() {
      ++this.g;
      Iterator var1 = this.l.iterator();

      String var3;
      while(var1.hasNext()) {
         bpk var2 = (bpk)var1.next();
         var2.c();
         if (var2.k()) {
            this.b((bpj)var2);
         } else {
            var3 = (String)this.i.get(var2);
            this.e.setVolume(var3, this.a(var2, (bpw)this.j.get(var2), this.c.a(var2.a()).d()));
            this.e.setPitch(var3, this.a((bpj)var2, (bpw)((bpw)this.j.get(var2))));
            this.e.setPosition(var3, var2.g(), var2.h(), var2.i());
         }
      }

      var1 = this.h.entrySet().iterator();

      bpj var4;
      while(var1.hasNext()) {
         Entry var9 = (Entry)var1.next();
         var3 = (String)var9.getKey();
         var4 = (bpj)var9.getValue();
         if (!this.e.playing(var3)) {
            int var5 = (Integer)this.n.get(var3);
            if (var5 <= this.g) {
               int var6 = var4.d();
               if (var4.b() && var6 > 0) {
                  this.m.put(var4, this.g + var6);
               }

               var1.remove();
               b.debug(a, "Removed channel {} because it's not playing anymore", new Object[]{var3});
               this.e.removeSource(var3);
               this.n.remove(var3);
               this.j.remove(var4);

               try {
                  this.k.remove(this.c.a(var4.a()).d(), var3);
               } catch (RuntimeException var8) {
               }

               if (var4 instanceof bpk) {
                  this.l.remove(var4);
               }
            }
         }
      }

      Iterator var10 = this.m.entrySet().iterator();

      while(var10.hasNext()) {
         Entry var11 = (Entry)var10.next();
         if (this.g >= (Integer)var11.getValue()) {
            var4 = (bpj)var11.getKey();
            if (var4 instanceof bpk) {
               ((bpk)var4).c();
            }

            this.c(var4);
            var10.remove();
         }
      }

   }

   private float a(bpj var1, bpw var2) {
      return (float)ns.a((double)var1.f() * var2.b(), 0.5D, 2.0D);
   }

   public void e() {
      Iterator var1 = this.h.keySet().iterator();

      while(var1.hasNext()) {
         String var2 = (String)var1.next();
         b.debug(a, "Pausing channel {}", new Object[]{var2});
         this.e.pause(var2);
      }

   }

   static Marker h() {
      return a;
   }

   private static URL a(jy var0) {
      String var1 = String.format("%s:%s:%s", "mcsounddomain", var0.b(), var0.a());
      URLStreamHandler var2 = new URLStreamHandler(var0) {
         final jy a;

         protected URLConnection openConnection(URL var1) {
            return new URLConnection(this, var1) {
               final <undefinedtype> a;

               {
                  this.a = var1;
               }

               public InputStream getInputStream() throws IOException {
                  return ave.A().Q().a(this.a.a).b();
               }

               public void connect() throws IOException {
               }
            };
         }

         {
            this.a = var1;
         }
      };

      try {
         return new URL((URL)null, var1, var2);
      } catch (MalformedURLException var4) {
         throw new Error("TODO: Sanely handle url exception! :D");
      }
   }

   static bpx.a a(bpx var0, bpx.a var1) {
      return var0.e = var1;
   }

   public void c(bpj var1) {
      if (this.f) {
         if (this.e.getMasterVolume() <= 0.0F) {
            b.debug(a, "Skipped playing soundEvent: {}, master volume was zero", new Object[]{var1.a()});
         } else {
            bpy var2 = this.c.a(var1.a());
            if (var2 == null) {
               b.warn(a, "Unable to play unknown soundEvent: {}", new Object[]{var1.a()});
            } else {
               bpw var3 = var2.b();
               if (var3 == bpz.a) {
                  b.warn(a, "Unable to play empty soundEvent: {}", new Object[]{var2.c()});
               } else {
                  float var4 = var1.e();
                  float var5 = 16.0F;
                  if (var4 > 1.0F) {
                     var5 *= var4;
                  }

                  bpg var6 = var2.d();
                  float var7 = this.a(var1, var3, var6);
                  double var8 = (double)this.a(var1, var3);
                  jy var10 = var3.a();
                  if (var7 == 0.0F) {
                     b.debug(a, "Skipped playing sound {}, volume was zero.", new Object[]{var10});
                  } else {
                     boolean var11 = var1.b() && var1.d() == 0;
                     String var12 = ns.a((Random)ThreadLocalRandom.current()).toString();
                     if (var3.d()) {
                        this.e.newStreamingSource(false, var12, a(var10), var10.toString(), var11, var1.g(), var1.h(), var1.i(), var1.j().a(), var5);
                     } else {
                        this.e.newSource(false, var12, a(var10), var10.toString(), var11, var1.g(), var1.h(), var1.i(), var1.j().a(), var5);
                     }

                     b.debug(a, "Playing sound {} for event {} as channel {}", new Object[]{var3.a(), var2.c(), var12});
                     this.e.setPitch(var12, (float)var8);
                     this.e.setVolume(var12, var7);
                     this.e.play(var12);
                     this.n.put(var12, this.g + 20);
                     this.h.put(var12, var1);
                     this.j.put(var1, var3);
                     if (var6 != bpg.a) {
                        this.k.put(var6, var12);
                     }

                     if (var1 instanceof bpk) {
                        this.l.add((bpk)var1);
                     }

                  }
               }
            }
         }
      }
   }

   public void b(bpj var1) {
      if (this.f) {
         String var2 = (String)this.i.get(var1);
         if (var2 != null) {
            this.e.stop(var2);
         }

      }
   }

   public void f() {
      Iterator var1 = this.h.keySet().iterator();

      while(var1.hasNext()) {
         String var2 = (String)var1.next();
         b.debug(a, "Resuming channel {}", new Object[]{var2});
         this.e.play(var2);
      }

   }

   public void a(bpg var1, float var2) {
      if (this.f) {
         if (var1 == bpg.a) {
            this.e.setMasterVolume(var2);
         } else {
            Iterator var3 = this.k.get(var1).iterator();

            while(var3.hasNext()) {
               String var4 = (String)var3.next();
               bpj var5 = (bpj)this.h.get(var4);
               float var6 = this.a(var5, (bpw)this.j.get(var5), var1);
               if (var6 <= 0.0F) {
                  this.b(var5);
               } else {
                  this.e.setVolume(var4, var6);
               }
            }

         }
      }
   }

   public bpx(bpz var1, avh var2) {
      this.i = ((BiMap)this.h).inverse();
      this.j = Maps.newHashMap();
      this.k = HashMultimap.create();
      this.l = Lists.newArrayList();
      this.m = Maps.newHashMap();
      this.n = Maps.newHashMap();
      this.c = var1;
      this.d = var2;

      try {
         SoundSystemConfig.addLibrary(LibraryLWJGLOpenAL.class);
         SoundSystemConfig.setCodec("ogg", CodecJOrbis.class);
      } catch (SoundSystemException var4) {
         b.error(a, "Error linking with the LibraryJavaSound plug-in", var4);
      }

   }

   class a extends SoundSystem {
      final bpx a;

      private a(bpx var1) {
         this.a = var1;
      }

      a(bpx var1, Object var2) {
         this(var1);
      }

      public boolean playing(String var1) {
         synchronized(SoundSystemConfig.THREAD_SYNC) {
            if (this.soundLibrary == null) {
               return false;
            } else {
               Source var3 = (Source)this.soundLibrary.getSources().get(var1);
               if (var3 == null) {
                  return false;
               } else {
                  return var3.playing() || var3.paused() || var3.preLoad;
               }
            }
         }
      }
   }
}
