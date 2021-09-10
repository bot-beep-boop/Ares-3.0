import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Queues;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import javax.imageio.ImageIO;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.server.MinecraftServer;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.OpenGLException;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.util.glu.GLU;

public class ave implements os, od {
   private final boolean at;
   private or Z = new or("client", this, MinecraftServer.az());
   private pk ad;
   private int ar;
   public bda c;
   private static ave S;
   public boolean w;
   private boolean X = false;
   private bde Q;
   public avn l;
   private final PropertyMap P;
   public bdb f;
   private bmj R;
   private String aq;
   private long aN = 0L;
   public final nh y = new nh();
   private bjh ab;
   private int as;
   private bgd aQ;
   private final File N;
   int I;
   public boolean F = false;
   private boolean U = true;
   public avo q;
   long J = -1L;
   private int ah;
   private final Thread aO = Thread.currentThread();
   public boolean r;
   private boolean aw;
   private static final Logger K = LogManager.getLogger();
   private bou aP;
   private final Queue<FutureTask<?>> aM = Queues.newArrayDeque();
   private bpz aH;
   public static byte[] b;
   public bfr g;
   long x = J();
   private long ax = -1L;
   private final bny az = new bny();
   private final List<bnk> aA = Lists.newArrayList();
   public final nt A = new nt();
   public bfk o;
   public static final boolean a;
   public avh t;
   private int ap;
   private final boolean au;
   public bew h;
   private boolean V;
   private bng ay;
   private final File ak;
   private bnm aC;
   private biu aa;
   public boolean D = false;
   public int e;
   private bfn ac;
   private b W;
   public final File v;
   private static final jy L = new jy("textures/gui/title/mojang.png");
   public avn k;
   public String C = "";
   private bns aD;
   private final MinecraftSessionService aK;
   long z = System.nanoTime();
   public boolean G = true;
   private final PropertyMap O;
   private int ai;
   private final avm ae;
   public pk i;
   boolean B = true;
   private bmh aG;
   private ek av;
   public ayd p;
   public bec j;
   private bpv aI;
   private atr an;
   private static int ao;
   private final bna aB;
   public boolean E = false;
   private boolean T;
   private bpo aj;
   long H = J();
   private jy aJ;
   private final Proxy am;
   private final String al;
   public axu m;
   private int ag;
   private avl Y = new avl(20.0F);
   public avf u;
   private bnp aL;
   public auh s;
   private bfw aF;
   private bqm aE;
   private static final List<DisplayMode> M;
   public avi n;
   public int d;
   private String aR = "root";
   private boolean af;

   public void a() {
      this.B = true;

      b var2;
      try {
         this.am();
      } catch (Throwable var11) {
         var2 = b.a(var11, "Initializing game");
         var2.a("Initialization");
         this.c(this.b(var2));
         return;
      }

      while(true) {
         try {
            if (this.B) {
               if (!this.V || this.W == null) {
                  try {
                     this.av();
                  } catch (OutOfMemoryError var10) {
                     this.l();
                     this.a((axu)(new axo()));
                     System.gc();
                  }
                  continue;
               }

               this.c(this.W);
               return;
            }
         } catch (avk var12) {
         } catch (e var13) {
            this.b(var13.a());
            this.l();
            K.fatal("Reported exception thrown!", var13);
            this.c(var13.a());
         } catch (Throwable var14) {
            var2 = this.b(new b("Unexpected error", var14));
            this.l();
            K.fatal("Unreported exception thrown!", var14);
            this.c(var2);
         } finally {
            this.g();
         }

         return;
      }
   }

   private void aw() {
      if (this.ag <= 0) {
         this.h.bw();
         if (this.s == null) {
            K.error("Null returned as 'hitResult', this shouldn't happen!");
            if (this.c.g()) {
               this.ag = 10;
            }

         } else {
            switch(this.s.a) {
            case c:
               this.c.a((wn)this.h, (pk)this.s.d);
               break;
            case b:
               cj var1 = this.s.a();
               if (this.f.p(var1).c().t() != arm.a) {
                  this.c.b(var1, this.s.b);
                  break;
               }
            case a:
            default:
               if (this.c.g()) {
                  this.ag = 10;
               }
            }

         }
      }
   }

   public PropertyMap N() {
      if (this.P.isEmpty()) {
         GameProfile var1 = this.aa().fillProfileProperties(this.ae.e(), false);
         this.P.putAll(var1.getProperties());
      }

      return this.P;
   }

   public pk ac() {
      return this.ad;
   }

   public void a(bde var1) {
      this.Q = var1;
   }

   public void h() {
      this.A.a("display_update");
      Display.update();
      this.A.b();
      this.i();
   }

   public atr f() {
      return this.an;
   }

   private void ay() {
      this.aF.a(this.d, this.e);
      if (this.o != null) {
         this.o.a(this.d, this.e);
      }

   }

   public bde D() {
      return this.Q;
   }

   public avm L() {
      return this.ae;
   }

   public void m() {
      this.B = false;
   }

   public void g() {
      try {
         this.aE.f();
         K.info("Stopping!");

         try {
            this.a((bdb)null);
         } catch (Throwable var5) {
         }

         this.aH.d();
      } finally {
         Display.destroy();
         if (!this.V) {
            System.exit(0);
         }

      }

      System.gc();
   }

   public static long J() {
      return Sys.getTime() * 1000L / Sys.getTimerResolution();
   }

   public void b(or var1) {
      var1.b("opengl_version", GL11.glGetString(7938));
      var1.b("opengl_vendor", GL11.glGetString(7936));
      var1.b("client_brand", ClientBrandRetriever.getClientModName());
      var1.b("launched_version", this.al);
      ContextCapabilities var2 = GLContext.getCapabilities();
      var1.b("gl_caps[ARB_arrays_of_arrays]", var2.GL_ARB_arrays_of_arrays);
      var1.b("gl_caps[ARB_base_instance]", var2.GL_ARB_base_instance);
      var1.b("gl_caps[ARB_blend_func_extended]", var2.GL_ARB_blend_func_extended);
      var1.b("gl_caps[ARB_clear_buffer_object]", var2.GL_ARB_clear_buffer_object);
      var1.b("gl_caps[ARB_color_buffer_float]", var2.GL_ARB_color_buffer_float);
      var1.b("gl_caps[ARB_compatibility]", var2.GL_ARB_compatibility);
      var1.b("gl_caps[ARB_compressed_texture_pixel_storage]", var2.GL_ARB_compressed_texture_pixel_storage);
      var1.b("gl_caps[ARB_compute_shader]", var2.GL_ARB_compute_shader);
      var1.b("gl_caps[ARB_copy_buffer]", var2.GL_ARB_copy_buffer);
      var1.b("gl_caps[ARB_copy_image]", var2.GL_ARB_copy_image);
      var1.b("gl_caps[ARB_depth_buffer_float]", var2.GL_ARB_depth_buffer_float);
      var1.b("gl_caps[ARB_compute_shader]", var2.GL_ARB_compute_shader);
      var1.b("gl_caps[ARB_copy_buffer]", var2.GL_ARB_copy_buffer);
      var1.b("gl_caps[ARB_copy_image]", var2.GL_ARB_copy_image);
      var1.b("gl_caps[ARB_depth_buffer_float]", var2.GL_ARB_depth_buffer_float);
      var1.b("gl_caps[ARB_depth_clamp]", var2.GL_ARB_depth_clamp);
      var1.b("gl_caps[ARB_depth_texture]", var2.GL_ARB_depth_texture);
      var1.b("gl_caps[ARB_draw_buffers]", var2.GL_ARB_draw_buffers);
      var1.b("gl_caps[ARB_draw_buffers_blend]", var2.GL_ARB_draw_buffers_blend);
      var1.b("gl_caps[ARB_draw_elements_base_vertex]", var2.GL_ARB_draw_elements_base_vertex);
      var1.b("gl_caps[ARB_draw_indirect]", var2.GL_ARB_draw_indirect);
      var1.b("gl_caps[ARB_draw_instanced]", var2.GL_ARB_draw_instanced);
      var1.b("gl_caps[ARB_explicit_attrib_location]", var2.GL_ARB_explicit_attrib_location);
      var1.b("gl_caps[ARB_explicit_uniform_location]", var2.GL_ARB_explicit_uniform_location);
      var1.b("gl_caps[ARB_fragment_layer_viewport]", var2.GL_ARB_fragment_layer_viewport);
      var1.b("gl_caps[ARB_fragment_program]", var2.GL_ARB_fragment_program);
      var1.b("gl_caps[ARB_fragment_shader]", var2.GL_ARB_fragment_shader);
      var1.b("gl_caps[ARB_fragment_program_shadow]", var2.GL_ARB_fragment_program_shadow);
      var1.b("gl_caps[ARB_framebuffer_object]", var2.GL_ARB_framebuffer_object);
      var1.b("gl_caps[ARB_framebuffer_sRGB]", var2.GL_ARB_framebuffer_sRGB);
      var1.b("gl_caps[ARB_geometry_shader4]", var2.GL_ARB_geometry_shader4);
      var1.b("gl_caps[ARB_gpu_shader5]", var2.GL_ARB_gpu_shader5);
      var1.b("gl_caps[ARB_half_float_pixel]", var2.GL_ARB_half_float_pixel);
      var1.b("gl_caps[ARB_half_float_vertex]", var2.GL_ARB_half_float_vertex);
      var1.b("gl_caps[ARB_instanced_arrays]", var2.GL_ARB_instanced_arrays);
      var1.b("gl_caps[ARB_map_buffer_alignment]", var2.GL_ARB_map_buffer_alignment);
      var1.b("gl_caps[ARB_map_buffer_range]", var2.GL_ARB_map_buffer_range);
      var1.b("gl_caps[ARB_multisample]", var2.GL_ARB_multisample);
      var1.b("gl_caps[ARB_multitexture]", var2.GL_ARB_multitexture);
      var1.b("gl_caps[ARB_occlusion_query2]", var2.GL_ARB_occlusion_query2);
      var1.b("gl_caps[ARB_pixel_buffer_object]", var2.GL_ARB_pixel_buffer_object);
      var1.b("gl_caps[ARB_seamless_cube_map]", var2.GL_ARB_seamless_cube_map);
      var1.b("gl_caps[ARB_shader_objects]", var2.GL_ARB_shader_objects);
      var1.b("gl_caps[ARB_shader_stencil_export]", var2.GL_ARB_shader_stencil_export);
      var1.b("gl_caps[ARB_shader_texture_lod]", var2.GL_ARB_shader_texture_lod);
      var1.b("gl_caps[ARB_shadow]", var2.GL_ARB_shadow);
      var1.b("gl_caps[ARB_shadow_ambient]", var2.GL_ARB_shadow_ambient);
      var1.b("gl_caps[ARB_stencil_texturing]", var2.GL_ARB_stencil_texturing);
      var1.b("gl_caps[ARB_sync]", var2.GL_ARB_sync);
      var1.b("gl_caps[ARB_tessellation_shader]", var2.GL_ARB_tessellation_shader);
      var1.b("gl_caps[ARB_texture_border_clamp]", var2.GL_ARB_texture_border_clamp);
      var1.b("gl_caps[ARB_texture_buffer_object]", var2.GL_ARB_texture_buffer_object);
      var1.b("gl_caps[ARB_texture_cube_map]", var2.GL_ARB_texture_cube_map);
      var1.b("gl_caps[ARB_texture_cube_map_array]", var2.GL_ARB_texture_cube_map_array);
      var1.b("gl_caps[ARB_texture_non_power_of_two]", var2.GL_ARB_texture_non_power_of_two);
      var1.b("gl_caps[ARB_uniform_buffer_object]", var2.GL_ARB_uniform_buffer_object);
      var1.b("gl_caps[ARB_vertex_blend]", var2.GL_ARB_vertex_blend);
      var1.b("gl_caps[ARB_vertex_buffer_object]", var2.GL_ARB_vertex_buffer_object);
      var1.b("gl_caps[ARB_vertex_program]", var2.GL_ARB_vertex_program);
      var1.b("gl_caps[ARB_vertex_shader]", var2.GL_ARB_vertex_shader);
      var1.b("gl_caps[EXT_bindable_uniform]", var2.GL_EXT_bindable_uniform);
      var1.b("gl_caps[EXT_blend_equation_separate]", var2.GL_EXT_blend_equation_separate);
      var1.b("gl_caps[EXT_blend_func_separate]", var2.GL_EXT_blend_func_separate);
      var1.b("gl_caps[EXT_blend_minmax]", var2.GL_EXT_blend_minmax);
      var1.b("gl_caps[EXT_blend_subtract]", var2.GL_EXT_blend_subtract);
      var1.b("gl_caps[EXT_draw_instanced]", var2.GL_EXT_draw_instanced);
      var1.b("gl_caps[EXT_framebuffer_multisample]", var2.GL_EXT_framebuffer_multisample);
      var1.b("gl_caps[EXT_framebuffer_object]", var2.GL_EXT_framebuffer_object);
      var1.b("gl_caps[EXT_framebuffer_sRGB]", var2.GL_EXT_framebuffer_sRGB);
      var1.b("gl_caps[EXT_geometry_shader4]", var2.GL_EXT_geometry_shader4);
      var1.b("gl_caps[EXT_gpu_program_parameters]", var2.GL_EXT_gpu_program_parameters);
      var1.b("gl_caps[EXT_gpu_shader4]", var2.GL_EXT_gpu_shader4);
      var1.b("gl_caps[EXT_multi_draw_arrays]", var2.GL_EXT_multi_draw_arrays);
      var1.b("gl_caps[EXT_packed_depth_stencil]", var2.GL_EXT_packed_depth_stencil);
      var1.b("gl_caps[EXT_paletted_texture]", var2.GL_EXT_paletted_texture);
      var1.b("gl_caps[EXT_rescale_normal]", var2.GL_EXT_rescale_normal);
      var1.b("gl_caps[EXT_separate_shader_objects]", var2.GL_EXT_separate_shader_objects);
      var1.b("gl_caps[EXT_shader_image_load_store]", var2.GL_EXT_shader_image_load_store);
      var1.b("gl_caps[EXT_shadow_funcs]", var2.GL_EXT_shadow_funcs);
      var1.b("gl_caps[EXT_shared_texture_palette]", var2.GL_EXT_shared_texture_palette);
      var1.b("gl_caps[EXT_stencil_clear_tag]", var2.GL_EXT_stencil_clear_tag);
      var1.b("gl_caps[EXT_stencil_two_side]", var2.GL_EXT_stencil_two_side);
      var1.b("gl_caps[EXT_stencil_wrap]", var2.GL_EXT_stencil_wrap);
      var1.b("gl_caps[EXT_texture_3d]", var2.GL_EXT_texture_3d);
      var1.b("gl_caps[EXT_texture_array]", var2.GL_EXT_texture_array);
      var1.b("gl_caps[EXT_texture_buffer_object]", var2.GL_EXT_texture_buffer_object);
      var1.b("gl_caps[EXT_texture_integer]", var2.GL_EXT_texture_integer);
      var1.b("gl_caps[EXT_texture_lod_bias]", var2.GL_EXT_texture_lod_bias);
      var1.b("gl_caps[EXT_texture_sRGB]", var2.GL_EXT_texture_sRGB);
      var1.b("gl_caps[EXT_vertex_shader]", var2.GL_EXT_vertex_shader);
      var1.b("gl_caps[EXT_vertex_weighting]", var2.GL_EXT_vertex_weighting);
      var1.b("gl_caps[gl_max_vertex_uniforms]", GL11.glGetInteger(35658));
      GL11.glGetError();
      var1.b("gl_caps[gl_max_fragment_uniforms]", GL11.glGetInteger(35657));
      GL11.glGetError();
      var1.b("gl_caps[gl_max_vertex_attribs]", GL11.glGetInteger(34921));
      GL11.glGetError();
      var1.b("gl_caps[gl_max_vertex_texture_image_units]", GL11.glGetInteger(35660));
      GL11.glGetError();
      var1.b("gl_caps[gl_max_texture_image_units]", GL11.glGetInteger(34930));
      GL11.glGetError();
      var1.b("gl_caps[gl_max_texture_image_units]", GL11.glGetInteger(35071));
      GL11.glGetError();
      var1.b("gl_max_texture_size", C());
   }

   public int j() {
      return this.f == null && this.m != null ? 30 : this.t.g;
   }

   public PropertyMap M() {
      return this.O;
   }

   public void a(bdb var1, String var2) {
      if (var1 == null) {
         bcy var3 = this.u();
         if (var3 != null) {
            var3.b();
         }

         if (this.aj != null && this.aj.O()) {
            this.aj.w();
            this.aj.a();
         }

         this.aj = null;
         this.p.b();
         this.o.k().a();
      }

      this.ad = null;
      this.av = null;
      if (this.n != null) {
         this.n.b(var2);
         this.n.c("");
      }

      if (var1 == null && this.f != null) {
         this.aC.f();
         this.q.i();
         this.a((bde)null);
         this.aw = false;
      }

      this.aH.b();
      this.f = var1;
      if (var1 != null) {
         if (this.g != null) {
            this.g.a(var1);
         }

         if (this.j != null) {
            this.j.a((adm)var1);
         }

         if (this.h == null) {
            this.h = this.c.a((adm)var1, (nb)(new nb()));
            this.c.b(this.h);
         }

         this.h.I();
         var1.d(this.h);
         this.h.b = new bev(this.t);
         this.c.a((wn)this.h);
         this.ad = this.h;
      } else {
         this.an.d();
         this.h = null;
      }

      System.gc();
      this.x = 0L;
   }

   private void au() throws LWJGLException {
      HashSet var1 = Sets.newHashSet();
      Collections.addAll(var1, Display.getAvailableDisplayModes());
      DisplayMode var2 = Display.getDesktopDisplayMode();
      if (!var1.contains(var2) && g.a() == g.a.d) {
         Iterator var3 = M.iterator();

         label67:
         while(true) {
            while(true) {
               DisplayMode var4;
               boolean var5;
               Iterator var6;
               DisplayMode var7;
               do {
                  if (!var3.hasNext()) {
                     break label67;
                  }

                  var4 = (DisplayMode)var3.next();
                  var5 = true;
                  var6 = var1.iterator();

                  while(var6.hasNext()) {
                     var7 = (DisplayMode)var6.next();
                     if (var7.getBitsPerPixel() == 32 && var7.getWidth() == var4.getWidth() && var7.getHeight() == var4.getHeight()) {
                        var5 = false;
                        break;
                     }
                  }
               } while(var5);

               var6 = var1.iterator();

               while(var6.hasNext()) {
                  var7 = (DisplayMode)var6.next();
                  if (var7.getBitsPerPixel() == 32 && var7.getWidth() == var4.getWidth() / 2 && var7.getHeight() == var4.getHeight() / 2) {
                     var2 = var7;
                     break;
                  }
               }
            }
         }
      }

      Display.setDisplayMode(var2);
      this.d = var2.getWidth();
      this.e = var2.getHeight();
   }

   private void aq() throws LWJGLException {
      if (this.T) {
         Display.setFullscreen(true);
         DisplayMode var1 = Display.getDisplayMode();
         this.d = Math.max(1, var1.getWidth());
         this.e = Math.max(1, var1.getHeight());
      } else {
         Display.setDisplayMode(new DisplayMode(this.d, this.e));
      }

   }

   public boolean E() {
      return this.aw;
   }

   public static Map<String, String> ak() {
      HashMap var0 = Maps.newHashMap();
      var0.put("X-Minecraft-Username", A().L().c());
      var0.put("X-Minecraft-UUID", A().L().b());
      var0.put("X-Minecraft-Version", "1.8.9");
      return var0;
   }

   public void a(String var1, String var2, adp var3) {
      this.a((bdb)null);
      System.gc();
      atp var4 = this.an.a(var1, false);
      ato var5 = var4.d();
      if (var5 == null && var3 != null) {
         var5 = new ato(var3, var1);
         var4.a(var5);
      }

      if (var3 == null) {
         var3 = new adp(var5);
      }

      try {
         this.aj = new bpo(this, var1, var2, var3);
         this.aj.D();
         this.aw = true;
      } catch (Throwable var10) {
         b var7 = b.a(var10, "Starting integrated server");
         c var8 = var7.a("Starting integrated server");
         var8.a((String)"Level ID", (Object)var1);
         var8.a((String)"Level Name", (Object)var2);
         throw new e(var7);
      }

      this.n.a(bnq.a("menu.loadingLevel"));

      while(!this.aj.ar()) {
         String var6 = this.aj.j();
         if (var6 != null) {
            this.n.c(bnq.a(var6));
         } else {
            this.n.c("");
         }

         try {
            Thread.sleep(200L);
         } catch (InterruptedException var9) {
         }
      }

      this.a((axu)null);
      SocketAddress var11 = this.aj.aq().a();
      ek var12 = ek.a(var11);
      var12.a((ep)(new bcx(var12, this, (axu)null)));
      var12.a((ff)(new jc(47, var11.toString(), 0, el.d)));
      var12.a((ff)(new jl(this.L().e())));
      this.av = var12;
   }

   public void a(int var1) {
      this.f.g();
      this.f.a();
      int var2 = 0;
      String var3 = null;
      if (this.h != null) {
         var2 = this.h.F();
         this.f.e(this.h);
         var3 = this.h.w();
      }

      this.ad = null;
      bew var4 = this.h;
      this.h = this.c.a((adm)this.f, (nb)(this.h == null ? new nb() : this.h.x()));
      this.h.H().a(var4.H().c());
      this.h.am = var1;
      this.ad = this.h;
      this.h.I();
      this.h.f(var3);
      this.f.d(this.h);
      this.c.b(this.h);
      this.h.b = new bev(this.t);
      this.h.d(var2);
      this.c.a((wn)this.h);
      this.h.k(var4.cq());
      if (this.m instanceof axe) {
         this.a((axu)null);
      }

   }

   public boolean F() {
      return this.aw && this.aj != null;
   }

   public Proxy O() {
      return this.am;
   }

   public void p() {
      if (this.m == null) {
         this.a((axu)(new axp()));
         if (this.F() && !this.aj.b()) {
            this.aH.a();
         }

      }
   }

   public bnm R() {
      return this.aC;
   }

   public MinecraftSessionService aa() {
      return this.aK;
   }

   private void an() {
      this.az.a((bnx)(new boo()), (Class)bon.class);
      this.az.a((bnx)(new boe()), (Class)bod.class);
      this.az.a((bnx)(new bob()), (Class)boa.class);
      this.az.a((bnx)(new bok()), (Class)boj.class);
      this.az.a((bnx)(new boh()), (Class)bog.class);
   }

   public bfw b() {
      return this.aF;
   }

   public bnp ab() {
      return this.aL;
   }

   public static boolean x() {
      return S != null && S.t.j != 0;
   }

   public static int C() {
      for(int var0 = 16384; var0 > 0; var0 >>= 1) {
         GL11.glTexImage2D(32868, 0, 6408, var0, var0, 0, 6408, 5121, (ByteBuffer)null);
         int var1 = GL11.glGetTexLevelParameteri(32868, 0, 4096);
         if (var1 != 0) {
            return var0;
         }
      }

      return -1;
   }

   public void a(pk var1) {
      this.ad = var1;
      this.o.a(var1);
   }

   public void o() {
      if (this.w) {
         avb.a();
         this.w = false;
         this.u.b();
      }
   }

   public void q() {
      try {
         this.T = !this.T;
         this.t.s = this.T;
         if (this.T) {
            this.au();
            this.d = Display.getDisplayMode().getWidth();
            this.e = Display.getDisplayMode().getHeight();
            if (this.d <= 0) {
               this.d = 1;
            }

            if (this.e <= 0) {
               this.e = 1;
            }
         } else {
            Display.setDisplayMode(new DisplayMode(this.ah, this.ai));
            this.d = this.ah;
            this.e = this.ai;
            if (this.d <= 0) {
               this.d = 1;
            }

            if (this.e <= 0) {
               this.e = 1;
            }
         }

         if (this.m != null) {
            this.a(this.d, this.e);
         } else {
            this.ay();
         }

         Display.setFullscreen(this.T);
         Display.setVSyncEnabled(this.t.t);
         this.h();
      } catch (Exception var2) {
         K.error("Couldn't toggle fullscreen", var2);
      }

   }

   public void l() {
      try {
         b = new byte[0];
         this.g.k();
      } catch (Throwable var3) {
      }

      try {
         System.gc();
         this.a((bdb)null);
      } catch (Throwable var2) {
      }

      System.gc();
   }

   public static void H() {
      if (S != null) {
         bpo var0 = S.G();
         if (var0 != null) {
            var0.t();
         }

      }
   }

   public String c() {
      return this.al;
   }

   private void b(String var1) {
      if (this.U) {
         int var2 = GL11.glGetError();
         if (var2 != 0) {
            String var3 = GLU.gluErrorString(var2);
            K.error("########## GL ERROR ##########");
            K.error("@ " + var1);
            K.error(var2 + ": " + var3);
         }

      }
   }

   public void a(or var1) {
      var1.a("fps", ao);
      var1.a("vsync_enabled", this.t.t);
      var1.a("display_frequency", Display.getDisplayMode().getFrequency());
      var1.a("display_type", this.T ? "fullscreen" : "windowed");
      var1.a("run_time", (MinecraftServer.az() - var1.g()) / 60L * 1000L);
      var1.a("current_action", this.aA());
      String var2 = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN ? "little" : "big";
      var1.a("endianness", var2);
      var1.a("resource_packs", this.aC.c().size());
      int var3 = 0;
      Iterator var4 = this.aC.c().iterator();

      while(var4.hasNext()) {
         bnm.a var5 = (bnm.a)var4.next();
         var1.a("resource_pack[" + var3++ + "]", var5.d());
      }

      if (this.aj != null && this.aj.av() != null) {
         var1.a("snooper_partner", this.aj.av().f());
      }

   }

   public ListenableFuture<Object> a(Runnable var1) {
      Validate.notNull(var1);
      return this.a(Executors.callable(var1));
   }

   public boolean U() {
      return this.at;
   }

   private static boolean as() {
      String[] var0 = new String[]{"sun.arch.data.model", "com.ibm.vm.bitmode", "os.arch"};
      String[] var1 = var0;
      int var2 = var0.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         String var4 = var1[var3];
         String var5 = System.getProperty(var4);
         if (var5 != null && var5.contains("64")) {
            return true;
         }
      }

      return false;
   }

   public boolean al() {
      return this.X;
   }

   private void am() throws LWJGLException, IOException {
      this.t = new avh(this, this.v);
      this.aA.add(this.aB);
      this.at();
      if (this.t.C > 0 && this.t.B > 0) {
         this.d = this.t.B;
         this.e = this.t.C;
      }

      K.info("LWJGL Version: " + Sys.getVersion());
      this.ar();
      this.aq();
      this.ap();
      bqs.a();
      this.aF = new bfw(this.d, this.e, true);
      this.aF.a(0.0F, 0.0F, 0.0F, 0.0F);
      this.an();
      this.aC = new bnm(this.N, new File(this.v, "server-resource-packs"), this.aB, this.az, this.t);
      this.ay = new bnn(this.az);
      this.aD = new bns(this.az, this.t.aN);
      this.ay.a((bnj)this.aD);
      this.e();
      this.R = new bmj(this.ay);
      this.ay.a((bnj)this.R);
      this.a(this.R);
      this.ao();
      this.aL = new bnp(this.R, new File(this.ak, "skins"), this.aK);
      this.an = new atk(new File(this.v, "saves"));
      this.aH = new bpz(this.ay, this.t);
      this.ay.a((bnj)this.aH);
      this.aI = new bpv(this);
      this.k = new avn(this.t, new jy("textures/font/ascii.png"), this.R, false);
      if (this.t.aN != null) {
         this.k.a(this.d());
         this.k.b(this.aD.b());
      }

      this.l = new avn(this.t, new jy("textures/font/ascii_sga.png"), this.R, false);
      this.ay.a((bnj)this.k);
      this.ay.a((bnj)this.l);
      this.ay.a((bnj)(new bnf()));
      this.ay.a((bnj)(new bne()));
      mr.f.a(new ms(this) {
         final ave a;

         public String a(String var1) {
            try {
               return String.format(var1, avh.c(this.a.t.af.i()));
            } catch (Exception var3) {
               return "Error: " + var3.getLocalizedMessage();
            }
         }

         {
            this.a = var1;
         }
      });
      this.u = new avf();
      this.b("Pre startup");
      bfl.w();
      bfl.j(7425);
      bfl.a(1.0D);
      bfl.j();
      bfl.c(515);
      bfl.d();
      bfl.a(516, 0.1F);
      bfl.e(1029);
      bfl.n(5889);
      bfl.D();
      bfl.n(5888);
      this.b("Startup");
      this.aG = new bmh("textures");
      this.aG.a(this.t.J);
      this.R.a((jy)bmh.g, (bmn)this.aG);
      this.R.a(bmh.g);
      this.aG.a(false, this.t.J > 0);
      this.aP = new bou(this.aG);
      this.ay.a((bnj)this.aP);
      this.ab = new bjh(this.R, this.aP);
      this.aa = new biu(this.R, this.ab);
      this.ac = new bfn(this);
      this.ay.a((bnj)this.ab);
      this.o = new bfk(this, this.ay);
      this.ay.a((bnj)this.o);
      this.aQ = new bgd(this.aP.c(), this.t);
      this.ay.a((bnj)this.aQ);
      this.g = new bfr(this);
      this.ay.a((bnj)this.g);
      this.p = new ayd(this);
      bfl.b(0, 0, this.d, this.e);
      this.j = new bec(this.f, this.R);
      this.b("Post startup");
      this.q = new avo(this);
      if (this.aq != null) {
         this.a((axu)(new awz(new aya(), this, this.aq, this.ar)));
      } else {
         this.a((axu)(new aya()));
      }

      this.R.c(this.aJ);
      this.aJ = null;
      this.n = new avi(this);
      if (this.t.s && !this.T) {
         this.q();
      }

      try {
         Display.setVSyncEnabled(this.t.t);
      } catch (OpenGLException var2) {
         this.t.t = false;
         this.t.b();
      }

      this.g.b();
   }

   public <V> ListenableFuture<V> a(Callable<V> var1) {
      Validate.notNull(var1);
      if (!this.aJ()) {
         ListenableFutureTask var2 = ListenableFutureTask.create(var1);
         synchronized(this.aM) {
            this.aM.add(var2);
            return var2;
         }
      } else {
         try {
            return Futures.immediateFuture(var1.call());
         } catch (Exception var6) {
            return Futures.immediateFailedCheckedFuture(var6);
         }
      }
   }

   static String a(ave var0) {
      return var0.al;
   }

   public boolean aJ() {
      return Thread.currentThread() == this.aO;
   }

   public static boolean v() {
      return S == null || !S.t.aA;
   }

   public void n() {
      if (Display.isActive()) {
         if (!this.w) {
            this.w = true;
            this.u.a();
            this.a((axu)null);
            this.ag = 10000;
         }
      }
   }

   public void a(b var1) {
      this.V = true;
      this.W = var1;
   }

   public or I() {
      return this.Z;
   }

   private void a(int var1, int var2) {
      this.d = Math.max(1, var1);
      this.e = Math.max(1, var2);
      if (this.m != null) {
         avr var3 = new avr(this);
         this.m.b(this, var3.a(), var3.b());
      }

      this.n = new avi(this);
      this.ay();
   }

   private String aA() {
      if (this.aj != null) {
         return this.aj.b() ? "hosting_lan" : "singleplayer";
      } else if (this.Q != null) {
         return this.Q.d() ? "playing_lan" : "multiplayer";
      } else {
         return "out_of_game";
      }
   }

   private void b(int var1) {
      List var2 = this.A.b(this.aR);
      if (var2 != null && !var2.isEmpty()) {
         nt.a var3 = (nt.a)var2.remove(0);
         if (var1 == 0) {
            if (var3.c.length() > 0) {
               int var4 = this.aR.lastIndexOf(".");
               if (var4 >= 0) {
                  this.aR = this.aR.substring(0, var4);
               }
            }
         } else {
            --var1;
            if (var1 < var2.size() && !((nt.a)var2.get(var1)).c.equals("unspecified")) {
               if (this.aR.length() > 0) {
                  this.aR = this.aR + ".";
               }

               this.aR = this.aR + ((nt.a)var2.get(var1)).c;
            }
         }

      }
   }

   public bni Q() {
      return this.ay;
   }

   public bpo G() {
      return this.aj;
   }

   public ListenableFuture<Object> B() {
      return this.a(new Runnable(this) {
         final ave a;

         {
            this.a = var1;
         }

         public void run() {
            this.a.e();
         }
      });
   }

   public nh aj() {
      return this.y;
   }

   public bmj P() {
      return this.R;
   }

   private zx a(zw var1, int var2, akw var3) {
      zx var4 = new zx(var1, 1, var2);
      dn var5 = new dn();
      var3.b(var5);
      dn var6;
      if (var1 == zy.bX && var5.c("Owner")) {
         var6 = var5.m("Owner");
         dn var8 = new dn();
         var8.a((String)"SkullOwner", (eb)var6);
         var4.d(var8);
         return var4;
      } else {
         var4.a((String)"BlockEntityTag", (eb)var5);
         var6 = new dn();
         du var7 = new du();
         var7.a((eb)(new ea("(+NBT)")));
         var6.a((String)"Lore", (eb)var7);
         var4.a((String)"display", (eb)var6);
         return var4;
      }
   }

   public bcy u() {
      return this.h != null ? this.h.a : null;
   }

   private void az() {
      if (this.s != null) {
         boolean var1 = this.h.bA.d;
         int var3 = 0;
         boolean var4 = false;
         akw var5 = null;
         Object var2;
         zx var12;
         if (this.s.a == auh.a.b) {
            cj var6 = this.s.a();
            afh var7 = this.f.p(var6).c();
            if (var7.t() == arm.a) {
               return;
            }

            var2 = var7.c((adm)this.f, var6);
            if (var2 == null) {
               return;
            }

            if (var1 && axu.q()) {
               var5 = this.f.s(var6);
            }

            afh var8 = var2 instanceof yo && !var7.M() ? afh.a((zw)var2) : var7;
            var3 = var8.j(this.f, var6);
            var4 = ((zw)var2).k();
         } else {
            if (this.s.a != auh.a.c || this.s.d == null || !var1) {
               return;
            }

            if (this.s.d instanceof uq) {
               var2 = zy.an;
            } else if (this.s.d instanceof up) {
               var2 = zy.cn;
            } else if (this.s.d instanceof uo) {
               uo var9 = (uo)this.s.d;
               var12 = var9.o();
               if (var12 == null) {
                  var2 = zy.bP;
               } else {
                  var2 = var12.b();
                  var3 = var12.i();
                  var4 = true;
               }
            } else if (this.s.d instanceof va) {
               va var10 = (va)this.s.d;
               switch(var10.s()) {
               case c:
                  var2 = zy.aO;
                  break;
               case b:
                  var2 = zy.aN;
                  break;
               case d:
                  var2 = zy.ch;
                  break;
               case f:
                  var2 = zy.ci;
                  break;
               case g:
                  var2 = zy.cp;
                  break;
               default:
                  var2 = zy.az;
               }
            } else if (this.s.d instanceof ux) {
               var2 = zy.aE;
            } else if (this.s.d instanceof um) {
               var2 = zy.cj;
            } else {
               var2 = zy.bJ;
               var3 = pm.a(this.s.d);
               var4 = true;
               if (!pm.a.containsKey(var3)) {
                  return;
               }
            }
         }

         wm var11 = this.h.bi;
         if (var5 == null) {
            var11.a((zw)var2, var3, var4, var1);
         } else {
            var12 = this.a((zw)var2, var3, var5);
            var11.a(var11.c, var12);
         }

         if (var1) {
            int var13 = this.h.bj.c.size() - 9 + var11.c;
            this.c.a(var11.a(var11.c), var13);
         }

      }
   }

   public bpv.a X() {
      if (this.h != null) {
         if (this.h.o.t instanceof ann) {
            return bpv.a.e;
         } else if (this.h.o.t instanceof anp) {
            return bfc.c != null && bfc.b > 0 ? bpv.a.f : bpv.a.g;
         } else {
            return this.h.bA.d && this.h.bA.c ? bpv.a.c : bpv.a.b;
         }
      } else {
         return bpv.a.a;
      }
   }

   public b b(b var1) {
      var1.g().a("Launched Version", new Callable<String>(this) {
         final ave a;

         {
            this.a = var1;
         }

         public Object call() throws Exception {
            return this.a();
         }

         public String a() {
            return ave.a(this.a);
         }
      });
      var1.g().a("LWJGL", new Callable<String>(this) {
         final ave a;

         public String a() {
            return Sys.getVersion();
         }

         {
            this.a = var1;
         }

         public Object call() throws Exception {
            return this.a();
         }
      });
      var1.g().a("OpenGL", new Callable<String>(this) {
         final ave a;

         public Object call() throws Exception {
            return this.a();
         }

         public String a() {
            return GL11.glGetString(7937) + " GL version " + GL11.glGetString(7938) + ", " + GL11.glGetString(7936);
         }

         {
            this.a = var1;
         }
      });
      var1.g().a("GL Caps", new Callable<String>(this) {
         final ave a;

         public String a() {
            return bqs.c();
         }

         {
            this.a = var1;
         }

         public Object call() throws Exception {
            return this.a();
         }
      });
      var1.g().a("Using VBOs", new Callable<String>(this) {
         final ave a;

         {
            this.a = var1;
         }

         public String a() {
            return this.a.t.u ? "Yes" : "No";
         }

         public Object call() throws Exception {
            return this.a();
         }
      });
      var1.g().a("Is Modded", new Callable<String>(this) {
         final ave a;

         public Object call() throws Exception {
            return this.a();
         }

         {
            this.a = var1;
         }

         public String a() throws Exception {
            String var1 = ClientBrandRetriever.getClientModName();
            if (!var1.equals("vanilla")) {
               return "Definitely; Client brand changed to '" + var1 + "'";
            } else {
               return ave.class.getSigners() == null ? "Very likely; Jar signature invalidated" : "Probably not. Jar signature remains and client brand is untouched.";
            }
         }
      });
      var1.g().a("Type", new Callable<String>(this) {
         final ave a;

         public String a() throws Exception {
            return "Client (map_client.txt)";
         }

         public Object call() throws Exception {
            return this.a();
         }

         {
            this.a = var1;
         }
      });
      var1.g().a("Resource Packs", new Callable<String>(this) {
         final ave a;

         public String a() throws Exception {
            StringBuilder var1 = new StringBuilder();
            Iterator var2 = this.a.t.k.iterator();

            while(var2.hasNext()) {
               String var3 = (String)var2.next();
               if (var1.length() > 0) {
                  var1.append(", ");
               }

               var1.append(var3);
               if (this.a.t.l.contains(var3)) {
                  var1.append(" (incompatible)");
               }
            }

            return var1.toString();
         }

         public Object call() throws Exception {
            return this.a();
         }

         {
            this.a = var1;
         }
      });
      var1.g().a("Current Language", new Callable<String>(this) {
         final ave a;

         public String a() throws Exception {
            return ave.b(this.a).c().toString();
         }

         public Object call() throws Exception {
            return this.a();
         }

         {
            this.a = var1;
         }
      });
      var1.g().a("Profiler Position", new Callable<String>(this) {
         final ave a;

         public Object call() throws Exception {
            return this.a();
         }

         public String a() throws Exception {
            return this.a.A.a ? this.a.A.c() : "N/A (disabled)";
         }

         {
            this.a = var1;
         }
      });
      var1.g().a("CPU", new Callable<String>(this) {
         final ave a;

         public String a() {
            return bqs.j();
         }

         public Object call() throws Exception {
            return this.a();
         }

         {
            this.a = var1;
         }
      });
      if (this.f != null) {
         this.f.a(var1);
      }

      return var1;
   }

   public boolean V() {
      return this.af;
   }

   public void a(boolean var1) {
      this.X = var1;
   }

   private void ap() throws LWJGLException {
      Display.setResizable(true);
      Display.setTitle("Minecraft 1.8.9");

      try {
         Display.create((new PixelFormat()).withDepthBits(24));
      } catch (LWJGLException var4) {
         K.error("Couldn't set pixel format", var4);

         try {
            Thread.sleep(1000L);
         } catch (InterruptedException var3) {
         }

         if (this.T) {
            this.au();
         }

         Display.create();
      }

   }

   public bjh ag() {
      return this.ab;
   }

   public void e() {
      ArrayList var1 = Lists.newArrayList(this.aA);
      Iterator var2 = this.aC.c().iterator();

      while(var2.hasNext()) {
         bnm.a var3 = (bnm.a)var2.next();
         var1.add(var3.c());
      }

      if (this.aC.e() != null) {
         var1.add(this.aC.e());
      }

      try {
         this.ay.a((List)var1);
      } catch (RuntimeException var4) {
         K.info("Caught error stitching, removing all assigned resourcepacks", var4);
         var1.clear();
         var1.addAll(this.aA);
         this.aC.a(Collections.emptyList());
         this.ay.a((List)var1);
         this.t.k.clear();
         this.t.l.clear();
         this.t.b();
      }

      this.aD.a((List)var1);
      if (this.g != null) {
         this.g.a();
      }

   }

   public boolean ad() {
      return this.t.r;
   }

   public static boolean w() {
      return S != null && S.t.i;
   }

   public void a(axu var1) {
      if (this.m != null) {
         this.m.m();
      }

      if (var1 == null && this.f == null) {
         var1 = new aya();
      } else if (var1 == null && this.h.bn() <= 0.0F) {
         var1 = new axe();
      }

      if (var1 instanceof aya) {
         this.t.aC = false;
         this.q.d().a();
      }

      this.m = (axu)var1;
      if (var1 != null) {
         this.o();
         avr var2 = new avr(this);
         int var3 = var2.a();
         int var4 = var2.b();
         ((axu)var1).a(this, var3, var4);
         this.r = false;
      } else {
         this.aH.e();
         this.n();
      }

   }

   public static int ai() {
      return ao;
   }

   private void at() {
      Thread var1 = new Thread(this, "Timer hack thread") {
         final ave a;

         public void run() {
            while(this.a.B) {
               try {
                  Thread.sleep(2147483647L);
               } catch (InterruptedException var2) {
               }
            }

         }

         {
            this.a = var1;
         }
      };
      var1.setDaemon(true);
      var1.start();
   }

   public bpv r() {
      return this.aI;
   }

   public void a(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      float var11 = 0.00390625F;
      float var12 = 0.00390625F;
      bfd var13 = bfx.a().c();
      var13.a(7, bms.i);
      var13.b((double)var1, (double)(var2 + var6), 0.0D).a((double)((float)var3 * var11), (double)((float)(var4 + var6) * var12)).b(var7, var8, var9, var10).d();
      var13.b((double)(var1 + var5), (double)(var2 + var6), 0.0D).a((double)((float)(var3 + var5) * var11), (double)((float)(var4 + var6) * var12)).b(var7, var8, var9, var10).d();
      var13.b((double)(var1 + var5), (double)var2, 0.0D).a((double)((float)(var3 + var5) * var11), (double)((float)var4 * var12)).b(var7, var8, var9, var10).d();
      var13.b((double)var1, (double)var2, 0.0D).a((double)((float)var3 * var11), (double)((float)var4 * var12)).b(var7, var8, var9, var10).d();
      bfx.a().b();
   }

   public bpz W() {
      return this.aH;
   }

   public boolean d() {
      return this.aD.a() || this.t.aO;
   }

   public ave(bao var1) {
      S = this;
      this.v = var1.c.a;
      this.ak = var1.c.c;
      this.N = var1.c.b;
      this.al = var1.d.b;
      this.O = var1.a.b;
      this.P = var1.a.c;
      this.aB = new bna((new bmy(var1.c.c, var1.c.d)).a());
      this.am = var1.a.d == null ? Proxy.NO_PROXY : var1.a.d;
      this.aK = (new YggdrasilAuthenticationService(var1.a.d, UUID.randomUUID().toString())).createMinecraftSessionService();
      this.ae = var1.a.a;
      K.info("Setting user: " + this.ae.c());
      K.info("(Session ID is " + this.ae.a() + ")");
      this.au = var1.d.a;
      this.d = var1.b.a > 0 ? var1.b.a : 1;
      this.e = var1.b.b > 0 ? var1.b.b : 1;
      this.ah = var1.b.a;
      this.ai = var1.b.b;
      this.T = var1.b.c;
      this.at = as();
      this.aj = new bpo(this);
      if (var1.e.a != null) {
         this.aq = var1.e.a;
         this.ar = var1.e.b;
      }

      ImageIO.setUseCache(false);
      kb.c();
   }

   public bgd ae() {
      return this.aQ;
   }

   public bqm Y() {
      return this.aE;
   }

   private void ar() {
      g.a var1 = g.a();
      if (var1 != g.a.d) {
         InputStream var2 = null;
         InputStream var3 = null;

         try {
            var2 = this.aB.c(new jy("icons/icon_16x16.png"));
            var3 = this.aB.c(new jy("icons/icon_32x32.png"));
            if (var2 != null && var3 != null) {
               Display.setIcon(new ByteBuffer[]{this.a(var2), this.a(var3)});
            }
         } catch (IOException var8) {
            K.error("Couldn't set icon", var8);
         } finally {
            IOUtils.closeQuietly(var2);
            IOUtils.closeQuietly(var3);
         }
      }

   }

   private void av() {
      long var1 = System.nanoTime();
      this.A.a("root");
      if (Display.isCreated() && Display.isCloseRequested()) {
         this.m();
      }

      if (this.af && this.f != null) {
         float var3 = this.Y.c;
         this.Y.a();
         this.Y.c = var3;
      } else {
         this.Y.a();
      }

      this.A.a("scheduledExecutables");
      synchronized(this.aM) {
         while(!this.aM.isEmpty()) {
            g.a((FutureTask)this.aM.poll(), K);
         }
      }

      this.A.b();
      long var10 = System.nanoTime();
      this.A.a("tick");

      for(int var5 = 0; var5 < this.Y.b; ++var5) {
         this.s();
      }

      this.A.c("preRenderErrors");
      long var11 = System.nanoTime() - var10;
      this.b("Pre render");
      this.A.c("sound");
      this.aH.a((wn)this.h, this.Y.c);
      this.A.b();
      this.A.a("render");
      bfl.E();
      bfl.m(16640);
      this.aF.a(true);
      this.A.a("display");
      bfl.w();
      if (this.h != null && this.h.aj()) {
         this.t.aB = 0;
      }

      this.A.b();
      if (!this.r) {
         this.A.c("gameRenderer");
         this.o.a(this.Y.c, var1);
         this.A.b();
      }

      this.A.b();
      if (this.t.aC && this.t.aD && !this.t.aA) {
         if (!this.A.a) {
            this.A.a();
         }

         this.A.a = true;
         this.a(var11);
      } else {
         this.A.a = false;
         this.J = System.nanoTime();
      }

      this.p.a();
      this.aF.e();
      bfl.F();
      bfl.E();
      this.aF.c(this.d, this.e);
      bfl.F();
      bfl.E();
      this.o.b(this.Y.c);
      bfl.F();
      this.A.a("root");
      this.h();
      Thread.yield();
      this.A.a("stream");
      this.A.a("update");
      this.aE.g();
      this.A.c("submit");
      this.aE.h();
      this.A.b();
      this.A.b();
      this.b("Post render");
      ++this.I;
      this.af = this.F() && this.m != null && this.m.d() && !this.aj.b();
      long var7 = System.nanoTime();
      this.y.a(var7 - this.z);
      this.z = var7;

      while(J() >= this.H + 1000L) {
         ao = this.I;
         this.C = String.format("%d fps (%d chunk update%s) T: %s%s%s%s%s", ao, bht.a, bht.a != 1 ? "s" : "", (float)this.t.g == avh.a.i.f() ? "inf" : this.t.g, this.t.t ? " vsync" : "", this.t.i ? "" : " fast", this.t.h == 0 ? "" : (this.t.h == 1 ? " fast-clouds" : " fancy-clouds"), bqs.f() ? " vbo" : "");
         bht.a = 0;
         this.H += 1000L;
         this.I = 0;
         this.Z.b();
         if (!this.Z.d()) {
            this.Z.a();
         }
      }

      if (this.k()) {
         this.A.a("fpslimit_wait");
         Display.sync(this.j());
         this.A.b();
      }

      this.A.b();
   }

   public void c(b var1) {
      File var2 = new File(A().v, "crash-reports");
      File var3 = new File(var2, "crash-" + (new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date()) + "-client.txt");
      kb.a(var1.e());
      if (var1.f() != null) {
         kb.a("#@!@# Game crashed! Crash report saved to: #@!@# " + var1.f());
         System.exit(-1);
      } else if (var1.a(var3)) {
         kb.a("#@!@# Game crashed! Crash report saved to: #@!@# " + var3.getAbsolutePath());
         System.exit(-1);
      } else {
         kb.a("#@?@# Game crashed! Crash report could not be saved. #@?@#");
         System.exit(-2);
      }

   }

   public void Z() {
      int var1 = Keyboard.getEventKey() == 0 ? Keyboard.getEventCharacter() : Keyboard.getEventKey();
      if (var1 != 0 && !Keyboard.isRepeatEvent()) {
         if (!(this.m instanceof ayj) || ((ayj)this.m).g <= J() - 20L) {
            if (Keyboard.getEventKeyState()) {
               if (var1 == this.t.as.i()) {
                  if (this.Y().k()) {
                     this.Y().r();
                  } else if (this.Y().j()) {
                     this.a((axu)(new awy(new awx(this) {
                        final ave a;

                        {
                           this.a = var1;
                        }

                        public void a(boolean var1, int var2) {
                           if (var1) {
                              this.a.Y().q();
                           }

                           this.a.a((axu)null);
                        }
                     }, bnq.a("stream.confirm_start"), "", 0)));
                  } else if (this.Y().A() && this.Y().i()) {
                     if (this.f != null) {
                        this.q.d().a((eu)(new fa("Not ready to start streaming yet!")));
                     }
                  } else {
                     baa.a(this.m);
                  }
               } else if (var1 == this.t.at.i()) {
                  if (this.Y().k()) {
                     if (this.Y().l()) {
                        this.Y().o();
                     } else {
                        this.Y().n();
                     }
                  }
               } else if (var1 == this.t.au.i()) {
                  if (this.Y().k()) {
                     this.Y().m();
                  }
               } else if (var1 == this.t.av.i()) {
                  this.aE.a(true);
               } else if (var1 == this.t.aq.i()) {
                  this.q();
               } else if (var1 == this.t.an.i()) {
                  this.q.d().a(avj.a(this.v, this.d, this.e, this.aF));
               }
            } else if (var1 == this.t.av.i()) {
               this.aE.a(false);
            }

         }
      }
   }

   private ByteBuffer a(InputStream var1) throws IOException {
      BufferedImage var2 = ImageIO.read(var1);
      int[] var3 = var2.getRGB(0, 0, var2.getWidth(), var2.getHeight(), (int[])null, 0, var2.getWidth());
      ByteBuffer var4 = ByteBuffer.allocate(4 * var3.length);
      int[] var5 = var3;
      int var6 = var3.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         int var8 = var5[var7];
         var4.putInt(var8 << 8 | var8 >> 24 & 255);
      }

      var4.flip();
      return var4;
   }

   private void a(long var1) {
      if (this.A.a) {
         List var3 = this.A.b(this.aR);
         nt.a var4 = (nt.a)var3.remove(0);
         bfl.m(256);
         bfl.n(5889);
         bfl.g();
         bfl.D();
         bfl.a(0.0D, (double)this.d, (double)this.e, 0.0D, 1000.0D, 3000.0D);
         bfl.n(5888);
         bfl.D();
         bfl.b(0.0F, 0.0F, -2000.0F);
         GL11.glLineWidth(1.0F);
         bfl.x();
         bfx var5 = bfx.a();
         bfd var6 = var5.c();
         short var7 = 160;
         int var8 = this.d - var7 - 10;
         int var9 = this.e - var7 * 2;
         bfl.l();
         var6.a(7, bms.f);
         var6.b((double)((float)var8 - (float)var7 * 1.1F), (double)((float)var9 - (float)var7 * 0.6F - 16.0F), 0.0D).b(200, 0, 0, 0).d();
         var6.b((double)((float)var8 - (float)var7 * 1.1F), (double)(var9 + var7 * 2), 0.0D).b(200, 0, 0, 0).d();
         var6.b((double)((float)var8 + (float)var7 * 1.1F), (double)(var9 + var7 * 2), 0.0D).b(200, 0, 0, 0).d();
         var6.b((double)((float)var8 + (float)var7 * 1.1F), (double)((float)var9 - (float)var7 * 0.6F - 16.0F), 0.0D).b(200, 0, 0, 0).d();
         var5.b();
         bfl.k();
         double var10 = 0.0D;

         int var14;
         for(int var12 = 0; var12 < var3.size(); ++var12) {
            nt.a var13 = (nt.a)var3.get(var12);
            var14 = ns.c(var13.a / 4.0D) + 1;
            var6.a(6, bms.f);
            int var15 = var13.a();
            int var16 = var15 >> 16 & 255;
            int var17 = var15 >> 8 & 255;
            int var18 = var15 & 255;
            var6.b((double)var8, (double)var9, 0.0D).b(var16, var17, var18, 255).d();

            int var19;
            float var20;
            float var21;
            float var22;
            for(var19 = var14; var19 >= 0; --var19) {
               var20 = (float)((var10 + var13.a * (double)var19 / (double)var14) * 3.1415927410125732D * 2.0D / 100.0D);
               var21 = ns.a(var20) * (float)var7;
               var22 = ns.b(var20) * (float)var7 * 0.5F;
               var6.b((double)((float)var8 + var21), (double)((float)var9 - var22), 0.0D).b(var16, var17, var18, 255).d();
            }

            var5.b();
            var6.a(5, bms.f);

            for(var19 = var14; var19 >= 0; --var19) {
               var20 = (float)((var10 + var13.a * (double)var19 / (double)var14) * 3.1415927410125732D * 2.0D / 100.0D);
               var21 = ns.a(var20) * (float)var7;
               var22 = ns.b(var20) * (float)var7 * 0.5F;
               var6.b((double)((float)var8 + var21), (double)((float)var9 - var22), 0.0D).b(var16 >> 1, var17 >> 1, var18 >> 1, 255).d();
               var6.b((double)((float)var8 + var21), (double)((float)var9 - var22 + 10.0F), 0.0D).b(var16 >> 1, var17 >> 1, var18 >> 1, 255).d();
            }

            var5.b();
            var10 += var13.a;
         }

         DecimalFormat var23 = new DecimalFormat("##0.00");
         bfl.w();
         String var24 = "";
         if (!var4.c.equals("unspecified")) {
            var24 = var24 + "[0] ";
         }

         if (var4.c.length() == 0) {
            var24 = var24 + "ROOT ";
         } else {
            var24 = var24 + var4.c + " ";
         }

         var14 = 16777215;
         this.k.a(var24, (float)(var8 - var7), (float)(var9 - var7 / 2 - 16), var14);
         this.k.a(var24 = var23.format(var4.b) + "%", (float)(var8 + var7 - this.k.a(var24)), (float)(var9 - var7 / 2 - 16), var14);

         for(int var27 = 0; var27 < var3.size(); ++var27) {
            nt.a var25 = (nt.a)var3.get(var27);
            String var26 = "";
            if (var25.c.equals("unspecified")) {
               var26 = var26 + "[?] ";
            } else {
               var26 = var26 + "[" + (var27 + 1) + "] ";
            }

            var26 = var26 + var25.c;
            this.k.a(var26, (float)(var8 - var7), (float)(var9 + var7 / 2 + var27 * 8 + 20), var25.a());
            this.k.a(var26 = var23.format(var25.a) + "%", (float)(var8 + var7 - 50 - this.k.a(var26)), (float)(var9 + var7 / 2 + var27 * 8 + 20), var25.a());
            this.k.a(var26 = var23.format(var25.b) + "%", (float)(var8 + var7 - this.k.a(var26)), (float)(var9 + var7 / 2 + var27 * 8 + 20), var25.a());
         }

      }
   }

   private void b(boolean var1) {
      if (!var1) {
         this.ag = 0;
      }

      if (this.ag <= 0 && !this.h.bS()) {
         if (var1 && this.s != null && this.s.a == auh.a.b) {
            cj var2 = this.s.a();
            if (this.f.p(var2).c().t() != arm.a && this.c.c(var2, this.s.b)) {
               this.j.a(var2, this.s.b);
               this.h.bw();
            }

         } else {
            this.c.c();
         }
      }
   }

   public static ave A() {
      return S;
   }

   static {
      a = g.a() == g.a.d;
      b = new byte[10485760];
      M = Lists.newArrayList(new DisplayMode[]{new DisplayMode(2560, 1600), new DisplayMode(2880, 1800)});
   }

   public bmh T() {
      return this.aG;
   }

   static bns b(ave var0) {
      return var0.aD;
   }

   private void a(bmj var1) throws LWJGLException {
      avr var2 = new avr(this);
      int var3 = var2.e();
      bfw var4 = new bfw(var2.a() * var3, var2.b() * var3, true);
      var4.a(false);
      bfl.n(5889);
      bfl.D();
      bfl.a(0.0D, (double)var2.a(), (double)var2.b(), 0.0D, 1000.0D, 3000.0D);
      bfl.n(5888);
      bfl.D();
      bfl.b(0.0F, 0.0F, -2000.0F);
      bfl.f();
      bfl.n();
      bfl.i();
      bfl.w();
      InputStream var5 = null;

      try {
         var5 = this.aB.a(L);
         this.aJ = var1.a("logo", new blz(ImageIO.read(var5)));
         var1.a(this.aJ);
      } catch (IOException var12) {
         K.error("Unable to load logo: " + L, var12);
      } finally {
         IOUtils.closeQuietly(var5);
      }

      bfx var6 = bfx.a();
      bfd var7 = var6.c();
      var7.a(7, bms.i);
      var7.b(0.0D, (double)this.e, 0.0D).a(0.0D, 0.0D).b(255, 255, 255, 255).d();
      var7.b((double)this.d, (double)this.e, 0.0D).a(0.0D, 0.0D).b(255, 255, 255, 255).d();
      var7.b((double)this.d, 0.0D, 0.0D).a(0.0D, 0.0D).b(255, 255, 255, 255).d();
      var7.b(0.0D, 0.0D, 0.0D).a(0.0D, 0.0D).b(255, 255, 255, 255).d();
      var6.b();
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      short var8 = 256;
      short var9 = 256;
      this.a((var2.a() - var8) / 2, (var2.b() - var9) / 2, 0, 0, var8, var9, 255, 255, 255, 255);
      bfl.f();
      bfl.n();
      var4.e();
      var4.c(var2.a() * var3, var2.b() * var3);
      bfl.d();
      bfl.a(516, 0.1F);
      this.h();
   }

   public biu af() {
      return this.aa;
   }

   public void s() {
      if (this.ap > 0) {
         --this.ap;
      }

      this.A.a("gui");
      if (!this.af) {
         this.q.c();
      }

      this.A.b();
      this.o.a(1.0F);
      this.A.a("gameMode");
      if (!this.af && this.f != null) {
         this.c.e();
      }

      this.A.c("textures");
      if (!this.af) {
         this.R.e();
      }

      if (this.m == null && this.h != null) {
         if (this.h.bn() <= 0.0F) {
            this.a((axu)null);
         } else if (this.h.bJ() && this.f != null) {
            this.a((axu)(new axk()));
         }
      } else if (this.m != null && this.m instanceof axk && !this.h.bJ()) {
         this.a((axu)null);
      }

      if (this.m != null) {
         this.ag = 10000;
      }

      b var2;
      c var3;
      if (this.m != null) {
         try {
            this.m.p();
         } catch (Throwable var7) {
            var2 = b.a(var7, "Updating screen events");
            var3 = var2.a("Affected screen");
            var3.a("Screen name", new Callable<String>(this) {
               final ave a;

               public Object call() throws Exception {
                  return this.a();
               }

               {
                  this.a = var1;
               }

               public String a() throws Exception {
                  return this.a.m.getClass().getCanonicalName();
               }
            });
            throw new e(var2);
         }

         if (this.m != null) {
            try {
               this.m.e();
            } catch (Throwable var6) {
               var2 = b.a(var6, "Ticking screen");
               var3 = var2.a("Affected screen");
               var3.a("Screen name", new Callable<String>(this) {
                  final ave a;

                  {
                     this.a = var1;
                  }

                  public String a() throws Exception {
                     return this.a.m.getClass().getCanonicalName();
                  }

                  public Object call() throws Exception {
                     return this.a();
                  }
               });
               throw new e(var2);
            }
         }
      }

      if (this.m == null || this.m.p) {
         this.A.c("mouse");

         int var1;
         while(Mouse.next()) {
            var1 = Mouse.getEventButton();
            avb.a(var1 - 100, Mouse.getEventButtonState());
            if (Mouse.getEventButtonState()) {
               if (this.h.v() && var1 == 2) {
                  this.q.g().b();
               } else {
                  avb.a(var1 - 100);
               }
            }

            long var10 = J() - this.x;
            if (var10 <= 200L) {
               int var4 = Mouse.getEventDWheel();
               if (var4 != 0) {
                  if (this.h.v()) {
                     var4 = var4 < 0 ? -1 : 1;
                     if (this.q.g().a()) {
                        this.q.g().b(-var4);
                     } else {
                        float var5 = ns.a(this.h.bA.a() + (float)var4 * 0.005F, 0.0F, 0.2F);
                        this.h.bA.a(var5);
                     }
                  } else {
                     this.h.bi.d(var4);
                  }
               }

               if (this.m == null) {
                  if (!this.w && Mouse.getEventButtonState()) {
                     this.n();
                  }
               } else if (this.m != null) {
                  this.m.k();
               }
            }
         }

         if (this.ag > 0) {
            --this.ag;
         }

         this.A.c("keyboard");

         label638:
         while(true) {
            do {
               do {
                  do {
                     if (!Keyboard.next()) {
                        for(var1 = 0; var1 < 9; ++var1) {
                           if (this.t.aw[var1].f()) {
                              if (this.h.v()) {
                                 this.q.g().a(var1);
                              } else {
                                 this.h.bi.c = var1;
                              }
                           }
                        }

                        boolean var9 = this.t.m != wn.b.c;

                        while(this.t.af.f()) {
                           if (this.c.j()) {
                              this.h.u();
                           } else {
                              this.u().a((ff)(new ig(ig.a.c)));
                              this.a((axu)(new azc(this.h)));
                           }
                        }

                        while(this.t.ah.f()) {
                           if (!this.h.v()) {
                              this.h.a(axu.q());
                           }
                        }

                        while(this.t.ak.f() && var9) {
                           this.a((axu)(new awv()));
                        }

                        if (this.m == null && this.t.am.f() && var9) {
                           this.a((axu)(new awv("/")));
                        }

                        if (this.h.bS()) {
                           if (!this.t.ag.d()) {
                              this.c.c(this.h);
                           }

                           while(true) {
                              if (!this.t.ai.f()) {
                                 while(this.t.ag.f()) {
                                 }

                                 while(this.t.aj.f()) {
                                 }
                                 break;
                              }
                           }
                        } else {
                           while(this.t.ai.f()) {
                              this.aw();
                           }

                           while(this.t.ag.f()) {
                              this.ax();
                           }

                           while(this.t.aj.f()) {
                              this.az();
                           }
                        }

                        if (this.t.ag.d() && this.ap == 0 && !this.h.bS()) {
                           this.ax();
                        }

                        this.b(this.m == null && this.t.ai.d() && this.w);
                        break label638;
                     }

                     var1 = Keyboard.getEventKey() == 0 ? Keyboard.getEventCharacter() + 256 : Keyboard.getEventKey();
                     avb.a(var1, Keyboard.getEventKeyState());
                     if (Keyboard.getEventKeyState()) {
                        avb.a(var1);
                     }

                     if (this.ax > 0L) {
                        if (J() - this.ax >= 6000L) {
                           throw new e(new b("Manually triggered debug crash", new Throwable()));
                        }

                        if (!Keyboard.isKeyDown(46) || !Keyboard.isKeyDown(61)) {
                           this.ax = -1L;
                        }
                     } else if (Keyboard.isKeyDown(46) && Keyboard.isKeyDown(61)) {
                        this.ax = J();
                     }

                     this.Z();
                  } while(!Keyboard.getEventKeyState());

                  if (var1 == 62 && this.o != null) {
                     this.o.c();
                  }

                  if (this.m != null) {
                     this.m.l();
                  } else {
                     if (var1 == 1) {
                        this.p();
                     }

                     if (var1 == 32 && Keyboard.isKeyDown(61) && this.q != null) {
                        this.q.d().a();
                     }

                     if (var1 == 31 && Keyboard.isKeyDown(61)) {
                        this.e();
                     }

                     if (var1 == 17 && Keyboard.isKeyDown(61)) {
                     }

                     if (var1 == 18 && Keyboard.isKeyDown(61)) {
                     }

                     if (var1 == 47 && Keyboard.isKeyDown(61)) {
                     }

                     if (var1 == 38 && Keyboard.isKeyDown(61)) {
                     }

                     if (var1 == 22 && Keyboard.isKeyDown(61)) {
                     }

                     if (var1 == 20 && Keyboard.isKeyDown(61)) {
                        this.e();
                     }

                     if (var1 == 33 && Keyboard.isKeyDown(61)) {
                        this.t.a(avh.a.f, axu.r() ? -1 : 1);
                     }

                     if (var1 == 30 && Keyboard.isKeyDown(61)) {
                        this.g.a();
                     }

                     if (var1 == 35 && Keyboard.isKeyDown(61)) {
                        this.t.y = !this.t.y;
                        this.t.b();
                     }

                     if (var1 == 48 && Keyboard.isKeyDown(61)) {
                        this.aa.b(!this.aa.b());
                     }

                     if (var1 == 25 && Keyboard.isKeyDown(61)) {
                        this.t.z = !this.t.z;
                        this.t.b();
                     }

                     if (var1 == 59) {
                        this.t.aA = !this.t.aA;
                     }

                     if (var1 == 61) {
                        this.t.aC = !this.t.aC;
                        this.t.aD = axu.r();
                        this.t.aE = axu.s();
                     }

                     if (this.t.ao.f()) {
                        ++this.t.aB;
                        if (this.t.aB > 2) {
                           this.t.aB = 0;
                        }

                        if (this.t.aB == 0) {
                           this.o.a(this.ac());
                        } else if (this.t.aB == 1) {
                           this.o.a((pk)null);
                        }

                        this.g.m();
                     }

                     if (this.t.ap.f()) {
                        this.t.aG = !this.t.aG;
                     }
                  }
               } while(!this.t.aC);
            } while(!this.t.aD);

            if (var1 == 11) {
               this.b(0);
            }

            for(int var11 = 0; var11 < 9; ++var11) {
               if (var1 == 2 + var11) {
                  this.b(var11 + 1);
               }
            }
         }
      }

      if (this.f != null) {
         if (this.h != null) {
            ++this.as;
            if (this.as == 30) {
               this.as = 0;
               this.f.h(this.h);
            }
         }

         this.A.c("gameRenderer");
         if (!this.af) {
            this.o.e();
         }

         this.A.c("levelRenderer");
         if (!this.af) {
            this.g.j();
         }

         this.A.c("level");
         if (!this.af) {
            if (this.f.ac() > 0) {
               this.f.d(this.f.ac() - 1);
            }

            this.f.i();
         }
      } else if (this.o.a()) {
         this.o.b();
      }

      if (!this.af) {
         this.aI.c();
         this.aH.c();
      }

      if (this.f != null) {
         if (!this.af) {
            this.f.a(this.f.aa() != oj.a, true);

            try {
               this.f.c();
            } catch (Throwable var8) {
               var2 = b.a(var8, "Exception in world tick");
               if (this.f == null) {
                  var3 = var2.a("Affected level");
                  var3.a((String)"Problem", (Object)"Level is null!");
               } else {
                  this.f.a(var2);
               }

               throw new e(var2);
            }
         }

         this.A.c("animateTick");
         if (!this.af && this.f != null) {
            this.f.b(ns.c(this.h.s), ns.c(this.h.t), ns.c(this.h.u));
         }

         this.A.c("particles");
         if (!this.af) {
            this.j.a();
         }
      } else if (this.av != null) {
         this.A.c("pendingConnection");
         this.av.a();
      }

      this.A.b();
      this.x = J();
   }

   private void ax() {
      if (!this.c.m()) {
         this.ap = 4;
         boolean var1 = true;
         zx var2 = this.h.bi.h();
         if (this.s == null) {
            K.warn("Null returned as 'hitResult', this shouldn't happen!");
         } else {
            switch(this.s.a) {
            case c:
               if (this.c.a(this.h, (pk)this.s.d, (auh)this.s)) {
                  var1 = false;
               } else if (this.c.b((wn)this.h, (pk)this.s.d)) {
                  var1 = false;
               }
               break;
            case b:
               cj var3 = this.s.a();
               if (this.f.p(var3).c().t() != arm.a) {
                  int var4 = var2 != null ? var2.b : 0;
                  if (this.c.a(this.h, this.f, var2, var3, this.s.b, this.s.c)) {
                     var1 = false;
                     this.h.bw();
                  }

                  if (var2 == null) {
                     return;
                  }

                  if (var2.b == 0) {
                     this.h.bi.a[this.h.bi.c] = null;
                  } else if (var2.b != var4 || this.c.h()) {
                     this.o.c.b();
                  }
               }
            }
         }

         if (var1) {
            zx var5 = this.h.bi.h();
            if (var5 != null && this.c.a(this.h, (adm)this.f, (zx)var5)) {
               this.o.c.c();
            }
         }

      }
   }

   public boolean k() {
      return (float)this.j() < avh.a.i.f();
   }

   public boolean K() {
      return this.T;
   }

   protected void i() {
      if (!this.T && Display.wasResized()) {
         int var1 = this.d;
         int var2 = this.e;
         this.d = Display.getWidth();
         this.e = Display.getHeight();
         if (this.d != var1 || this.e != var2) {
            if (this.d <= 0) {
               this.d = 1;
            }

            if (this.e <= 0) {
               this.e = 1;
            }

            this.a(this.d, this.e);
         }
      }

   }

   public void a(bdb var1) {
      this.a(var1, "");
   }

   private void ao() {
      try {
         this.aE = new bqn(this, (Property)Iterables.getFirst(this.O.get("twitch_access_token"), (Object)null));
      } catch (Throwable var2) {
         this.aE = new bqo(var2);
         K.error("Couldn't initialize twitch stream");
      }

   }

   public bns S() {
      return this.aD;
   }

   public final boolean t() {
      return this.au;
   }

   public bfn ah() {
      return this.ac;
   }
}
