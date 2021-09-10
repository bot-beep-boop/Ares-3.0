import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import org.apache.logging.log4j.LogManager;

public enum el {
   b(0) {
      {
         this.a(fg.b, gn.class);
         this.a(fg.b, gt.class);
         this.a(fg.b, fy.class);
         this.a(fg.b, hu.class);
         this.a(fg.b, hn.class);
         this.a(fg.b, ht.class);
         this.a(fg.b, hp.class);
         this.a(fg.b, he.class);
         this.a(fg.b, fi.class);
         this.a(fg.b, hi.class);
         this.a(fg.b, ha.class);
         this.a(fg.b, fq.class);
         this.a(fg.b, fp.class);
         this.a(fg.b, hy.class);
         this.a(fg.b, fk.class);
         this.a(fg.b, fn.class);
         this.a(fg.b, fo.class);
         this.a(fg.b, fl.class);
         this.a(fg.b, hm.class);
         this.a(fg.b, hb.class);
         this.a(fg.b, gv.class);
         this.a(fg.b, gv.a.class);
         this.a(fg.b, gv.c.class);
         this.a(fg.b, gv.b.class);
         this.a(fg.b, hz.class);
         this.a(fg.b, hf.class);
         this.a(fg.b, gi.class);
         this.a(fg.b, hl.class);
         this.a(fg.b, hk.class);
         this.a(fg.b, ib.class);
         this.a(fg.b, hc.class);
         this.a(fg.b, ho.class);
         this.a(fg.b, ia.class);
         this.a(fg.b, go.class);
         this.a(fg.b, fz.class);
         this.a(fg.b, fv.class);
         this.a(fg.b, fu.class);
         this.a(fg.b, fs.class);
         this.a(fg.b, gp.class);
         this.a(fg.b, gk.class);
         this.a(fg.b, gq.class);
         this.a(fg.b, gs.class);
         this.a(fg.b, gr.class);
         this.a(fg.b, gm.class);
         this.a(fg.b, fm.class);
         this.a(fg.b, gc.class);
         this.a(fg.b, gb.class);
         this.a(fg.b, gf.class);
         this.a(fg.b, gd.class);
         this.a(fg.b, ge.class);
         this.a(fg.b, ga.class);
         this.a(fg.b, hw.class);
         this.a(fg.b, gu.class);
         this.a(fg.b, ft.class);
         this.a(fg.b, gw.class);
         this.a(fg.b, fr.class);
         this.a(fg.b, gz.class);
         this.a(fg.b, gx.class);
         this.a(fg.b, fx.class);
         this.a(fg.b, hq.class);
         this.a(fg.b, hs.class);
         this.a(fg.b, hj.class);
         this.a(fg.b, hr.class);
         this.a(fg.b, gg.class);
         this.a(fg.b, gh.class);
         this.a(fg.b, fw.class);
         this.a(fg.b, gy.class);
         this.a(fg.b, hh.class);
         this.a(fg.b, hg.class);
         this.a(fg.b, hv.class);
         this.a(fg.b, gl.class);
         this.a(fg.b, hx.class);
         this.a(fg.b, hd.class);
         this.a(fg.b, gj.class);
         this.a(fg.a, io.class);
         this.a(fg.a, ie.class);
         this.a(fg.a, in.class);
         this.a(fg.a, ip.class);
         this.a(fg.a, ip.a.class);
         this.a(fg.a, ip.c.class);
         this.a(fg.a, ip.b.class);
         this.a(fg.a, ir.class);
         this.a(fg.a, ja.class);
         this.a(fg.a, iv.class);
         this.a(fg.a, iy.class);
         this.a(fg.a, is.class);
         this.a(fg.a, it.class);
         this.a(fg.a, il.class);
         this.a(fg.a, ik.class);
         this.a(fg.a, ii.class);
         this.a(fg.a, iw.class);
         this.a(fg.a, ij.class);
         this.a(fg.a, ix.class);
         this.a(fg.a, iq.class);
         this.a(fg.a, id.class);
         this.a(fg.a, ih.class);
         this.a(fg.a, ig.class);
         this.a(fg.a, im.class);
         this.a(fg.a, iz.class);
         this.a(fg.a, iu.class);
      }
   },
   d(2) {
      {
         this.a(fg.b, jj.class);
         this.a(fg.b, jh.class);
         this.a(fg.b, jg.class);
         this.a(fg.b, ji.class);
         this.a(fg.a, jl.class);
         this.a(fg.a, jm.class);
      }
   },
   c(1) {
      {
         this.a(fg.a, jv.class);
         this.a(fg.b, jr.class);
         this.a(fg.a, ju.class);
         this.a(fg.b, jq.class);
      }
   };

   private static final el[] k = new el[]{a, b, c, d};
   private static final el[] g = new el[f - e + 1];
   a(-1) {
      {
         this.a(fg.a, jc.class);
      }
   };

   private static final Map<Class<? extends ff>, el> h = Maps.newHashMap();
   private static int f = 2;
   private final Map<fg, BiMap<Integer, Class<? extends ff>>> j;
   private final int i;
   private static int e = -1;

   public ff a(fg var1, int var2) throws InstantiationException, IllegalAccessException {
      Class var3 = (Class)((BiMap)this.j.get(var1)).get(var2);
      return var3 == null ? null : (ff)var3.newInstance();
   }

   private el(int var3) {
      this.j = Maps.newEnumMap(fg.class);
      this.i = var3;
   }

   public int a() {
      return this.i;
   }

   public Integer a(fg var1, ff var2) {
      return (Integer)((BiMap)this.j.get(var1)).inverse().get(var2.getClass());
   }

   static {
      el[] var0 = values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         el var3 = var0[var2];
         int var4 = var3.a();
         if (var4 < e || var4 > f) {
            throw new Error("Invalid protocol ID " + Integer.toString(var4));
         }

         g[var4 - e] = var3;
         Iterator var5 = var3.j.keySet().iterator();

         while(var5.hasNext()) {
            fg var6 = (fg)var5.next();

            Class var8;
            for(Iterator var7 = ((BiMap)var3.j.get(var6)).values().iterator(); var7.hasNext(); h.put(var8, var3)) {
               var8 = (Class)var7.next();
               if (h.containsKey(var8) && h.get(var8) != var3) {
                  throw new Error("Packet " + var8 + " is already assigned to protocol " + h.get(var8) + " - can't reassign to " + var3);
               }

               try {
                  var8.newInstance();
               } catch (Throwable var10) {
                  throw new Error("Packet " + var8 + " fails instantiation checks! " + var8);
               }
            }
         }
      }

   }

   protected el a(fg var1, Class<? extends ff> var2) {
      Object var3 = (BiMap)this.j.get(var1);
      if (var3 == null) {
         var3 = HashBiMap.create();
         this.j.put(var1, var3);
      }

      if (((BiMap)var3).containsValue(var2)) {
         String var4 = var1 + " packet " + var2 + " is already known to ID " + ((BiMap)var3).inverse().get(var2);
         LogManager.getLogger().fatal(var4);
         throw new IllegalArgumentException(var4);
      } else {
         ((BiMap)var3).put(((BiMap)var3).size(), var2);
         return this;
      }
   }

   public static el a(int var0) {
      return var0 >= e && var0 <= f ? g[var0 - e] : null;
   }

   public static el a(ff var0) {
      return (el)h.get(var0.getClass());
   }

   el(int var3, Object var4) {
      this(var3);
   }
}
