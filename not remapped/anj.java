import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class anj implements aud, and {
   private boolean e = false;
   private final File d;
   private static final Logger a = LogManager.getLogger();
   private Map<adg, dn> b = new ConcurrentHashMap();
   private Set<adg> c = Collections.newSetFromMap(new ConcurrentHashMap());

   public amy a(adm var1, int var2, int var3) throws IOException {
      adg var4 = new adg(var2, var3);
      dn var5 = (dn)this.b.get(var4);
      if (var5 == null) {
         DataInputStream var6 = ani.c(this.d, var2, var3);
         if (var6 == null) {
            return null;
         }

         var5 = dx.a(var6);
      }

      return this.a(var1, var2, var3, var5);
   }

   protected amy a(adm var1, int var2, int var3, dn var4) {
      if (!var4.b("Level", 10)) {
         a.error("Chunk file at " + var2 + "," + var3 + " is missing level data, skipping");
         return null;
      } else {
         dn var5 = var4.m("Level");
         if (!var5.b("Sections", 9)) {
            a.error("Chunk file at " + var2 + "," + var3 + " is missing block data, skipping");
            return null;
         } else {
            amy var6 = this.a(var1, var5);
            if (!var6.a(var2, var3)) {
               a.error("Chunk file at " + var2 + "," + var3 + " is in the wrong location; relocating. (Expected " + var2 + ", " + var3 + ", got " + var6.a + ", " + var6.b + ")");
               var5.a("xPos", var2);
               var5.a("zPos", var3);
               var6 = this.a(var1, var5);
            }

            return var6;
         }
      }
   }

   public void b(adm var1, amy var2) throws IOException {
   }

   public void a() {
   }

   protected void a(adg var1, dn var2) {
      if (!this.c.contains(var1)) {
         this.b.put(var1, var2);
      }

      auc.a().a(this);
   }

   public void a(adm var1, amy var2) throws adn, IOException {
      var1.I();

      try {
         dn var3 = new dn();
         dn var4 = new dn();
         var3.a((String)"Level", (eb)var4);
         this.a(var2, var1, var4);
         this.a(var2.j(), var3);
      } catch (Exception var5) {
         a.error("Failed to save chunk", var5);
      }

   }

   public void b() {
      try {
         this.e = true;

         while(true) {
            if (this.c()) {
               continue;
            }
         }
      } finally {
         this.e = false;
      }

   }

   public boolean c() {
      if (this.b.isEmpty()) {
         if (this.e) {
            a.info("ThreadedAnvilChunkStorage ({}): All chunks are saved", new Object[]{this.d.getName()});
         }

         return false;
      } else {
         adg var1 = (adg)this.b.keySet().iterator().next();

         boolean var3;
         try {
            this.c.add(var1);
            dn var2 = (dn)this.b.remove(var1);
            if (var2 != null) {
               try {
                  this.b(var1, var2);
               } catch (Exception var7) {
                  a.error("Failed to save chunk", var7);
               }
            }

            var3 = true;
         } finally {
            this.c.remove(var1);
         }

         return var3;
      }
   }

   private void a(amy var1, adm var2, dn var3) {
      var3.a("V", (byte)1);
      var3.a("xPos", var1.a);
      var3.a("zPos", var1.b);
      var3.a("LastUpdate", var2.K());
      var3.a("HeightMap", var1.q());
      var3.a("TerrainPopulated", var1.t());
      var3.a("LightPopulated", var1.u());
      var3.a("InhabitedTime", var1.w());
      amz[] var4 = var1.h();
      du var5 = new du();
      boolean var6 = !var2.t.o();
      amz[] var7 = var4;
      int var8 = var4.length;

      dn var11;
      for(int var9 = 0; var9 < var8; ++var9) {
         amz var10 = var7[var9];
         if (var10 != null) {
            var11 = new dn();
            var11.a("Y", (byte)(var10.d() >> 4 & 255));
            byte[] var12 = new byte[var10.g().length];
            amw var13 = new amw();
            amw var14 = null;

            for(int var15 = 0; var15 < var10.g().length; ++var15) {
               char var16 = var10.g()[var15];
               int var17 = var15 & 15;
               int var18 = var15 >> 8 & 15;
               int var19 = var15 >> 4 & 15;
               if (var16 >> 12 != 0) {
                  if (var14 == null) {
                     var14 = new amw();
                  }

                  var14.a(var17, var18, var19, var16 >> 12);
               }

               var12[var15] = (byte)(var16 >> 4 & 255);
               var13.a(var17, var18, var19, var16 & 15);
            }

            var11.a("Blocks", var12);
            var11.a("Data", var13.a());
            if (var14 != null) {
               var11.a("Add", var14.a());
            }

            var11.a("BlockLight", var10.h().a());
            if (var6) {
               var11.a("SkyLight", var10.i().a());
            } else {
               var11.a("SkyLight", new byte[var10.h().a().length]);
            }

            var5.a((eb)var11);
         }
      }

      var3.a((String)"Sections", (eb)var5);
      var3.a("Biomes", var1.k());
      var1.g(false);
      du var20 = new du();

      Iterator var22;
      for(var8 = 0; var8 < var1.s().length; ++var8) {
         var22 = var1.s()[var8].iterator();

         while(var22.hasNext()) {
            pk var24 = (pk)var22.next();
            var11 = new dn();
            if (var24.d(var11)) {
               var1.g(true);
               var20.a((eb)var11);
            }
         }
      }

      var3.a((String)"Entities", (eb)var20);
      du var21 = new du();
      var22 = var1.r().values().iterator();

      while(var22.hasNext()) {
         akw var25 = (akw)var22.next();
         var11 = new dn();
         var25.b(var11);
         var21.a((eb)var11);
      }

      var3.a((String)"TileEntities", (eb)var21);
      List var23 = var2.a(var1, false);
      if (var23 != null) {
         long var26 = var2.K();
         du var27 = new du();
         Iterator var28 = var23.iterator();

         while(var28.hasNext()) {
            adw var29 = (adw)var28.next();
            dn var30 = new dn();
            jy var31 = (jy)afh.c.c(var29.a());
            var30.a("i", var31 == null ? "" : var31.toString());
            var30.a("x", var29.a.n());
            var30.a("y", var29.a.o());
            var30.a("z", var29.a.p());
            var30.a("t", (int)(var29.b - var26));
            var30.a("p", var29.c);
            var27.a((eb)var30);
         }

         var3.a((String)"TileTicks", (eb)var27);
      }

   }

   public anj(File var1) {
      this.d = var1;
   }

   private void b(adg var1, dn var2) throws IOException {
      DataOutputStream var3 = ani.d(this.d, var1.a, var1.b);
      dx.a((dn)var2, (DataOutput)var3);
      var3.close();
   }

   private amy a(adm var1, dn var2) {
      int var3 = var2.f("xPos");
      int var4 = var2.f("zPos");
      amy var5 = new amy(var1, var3, var4);
      var5.a(var2.l("HeightMap"));
      var5.d(var2.n("TerrainPopulated"));
      var5.e(var2.n("LightPopulated"));
      var5.c(var2.g("InhabitedTime"));
      du var6 = var2.c("Sections", 10);
      byte var7 = 16;
      amz[] var8 = new amz[var7];
      boolean var9 = !var1.t.o();

      for(int var10 = 0; var10 < var6.c(); ++var10) {
         dn var11 = var6.b(var10);
         byte var12 = var11.d("Y");
         amz var13 = new amz(var12 << 4, var9);
         byte[] var14 = var11.k("Blocks");
         amw var15 = new amw(var11.k("Data"));
         amw var16 = var11.b("Add", 7) ? new amw(var11.k("Add")) : null;
         char[] var17 = new char[var14.length];

         for(int var18 = 0; var18 < var17.length; ++var18) {
            int var19 = var18 & 15;
            int var20 = var18 >> 8 & 15;
            int var21 = var18 >> 4 & 15;
            int var22 = var16 != null ? var16.a(var19, var20, var21) : 0;
            var17[var18] = (char)(var22 << 12 | (var14[var18] & 255) << 4 | var15.a(var19, var20, var21));
         }

         var13.a(var17);
         var13.a(new amw(var11.k("BlockLight")));
         if (var9) {
            var13.b(new amw(var11.k("SkyLight")));
         }

         var13.e();
         var8[var12] = var13;
      }

      var5.a(var8);
      if (var2.b("Biomes", 7)) {
         var5.a(var2.k("Biomes"));
      }

      du var23 = var2.c("Entities", 10);
      if (var23 != null) {
         for(int var24 = 0; var24 < var23.c(); ++var24) {
            dn var26 = var23.b(var24);
            pk var28 = pm.a(var26, var1);
            var5.g(true);
            if (var28 != null) {
               var5.a(var28);
               pk var32 = var28;

               for(dn var34 = var26; var34.b("Riding", 10); var34 = var34.m("Riding")) {
                  pk var37 = pm.a(var34.m("Riding"), var1);
                  if (var37 != null) {
                     var5.a(var37);
                     var32.a(var37);
                  }

                  var32 = var37;
               }
            }
         }
      }

      du var25 = var2.c("TileEntities", 10);
      if (var25 != null) {
         for(int var27 = 0; var27 < var25.c(); ++var27) {
            dn var30 = var25.b(var27);
            akw var33 = akw.c(var30);
            if (var33 != null) {
               var5.a(var33);
            }
         }
      }

      if (var2.b("TileTicks", 9)) {
         du var29 = var2.c("TileTicks", 10);
         if (var29 != null) {
            for(int var31 = 0; var31 < var29.c(); ++var31) {
               dn var35 = var29.b(var31);
               afh var36;
               if (var35.b("i", 8)) {
                  var36 = afh.b(var35.j("i"));
               } else {
                  var36 = afh.c(var35.f("i"));
               }

               var1.b(new cj(var35.f("x"), var35.f("y"), var35.f("z")), var36, var35.f("t"), var35.f("p"));
            }
         }
      }

      return var5;
   }
}
