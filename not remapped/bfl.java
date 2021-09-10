import java.nio.FloatBuffer;
import org.lwjgl.opengl.GL11;

public class bfl {
   private static bfl.b e = new bfl.b();
   private static bfl.e t = new bfl.e();
   private static bfl.q k = new bfl.q();
   private static bfl.c r = new bfl.c(32826);
   private static bfl.f j = new bfl.f();
   private static bfl.c b = new bfl.c(2896);
   private static bfl.c[] c = new bfl.c[8];
   private static bfl.h d = new bfl.h();
   private static bfl.n m = new bfl.n();
   private static bfl.l i = new bfl.l();
   private static bfl.j f = new bfl.j();
   private static int q = 7425;
   private static bfl.c n = new bfl.c(2977);
   private static bfl.r[] p = new bfl.r[8];
   private static bfl.k g = new bfl.k();
   private static bfl.a a = new bfl.a();
   private static bfl.d l = new bfl.d();
   private static bfl.i h = new bfl.i();
   private static bfl.g s = new bfl.g();
   private static int o = 0;

   public static void f(int var0) {
      if (var0 != j.b) {
         j.b = var0;
         GL11.glLogicOp(var0);
      }

   }

   public static void v() {
      j.a.a();
   }

   public static void w() {
      p[o].a.b();
   }

   public static void F() {
      GL11.glPopMatrix();
   }

   public static void n(int var0) {
      GL11.glMatrixMode(var0);
   }

   public static void a(float var0, float var1, float var2, float var3) {
      if (var0 != l.b.a || var1 != l.b.b || var2 != l.b.c || var3 != l.b.d) {
         l.b.a = var0;
         l.b.b = var1;
         l.b.c = var2;
         l.b.d = var3;
         GL11.glClearColor(var0, var1, var2, var3);
      }

   }

   public static void h(int var0) {
      GL11.glDeleteTextures(var0);
      bfl.r[] var1 = p;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         bfl.r var4 = var1[var3];
         if (var4.b == var0) {
            var4.b = -1;
         }
      }

   }

   public static void G() {
      t.a = t.b = t.c = t.d = -1.0F;
   }

   public static void a(bfl.o var0, int var1) {
      bfl.p var2 = c(var0);
      if (var1 != var2.c) {
         var2.c = var1;
         GL11.glTexGeni(var2.b, 9472, var1);
      }

   }

   public static void b(float var0, float var1, float var2, float var3) {
      GL11.glRotatef(var0, var1, var2, var3);
   }

   public static void z() {
      n.b();
   }

   public static void c(float var0) {
      if (var0 != g.e) {
         g.e = var0;
         GL11.glFogf(2916, var0);
      }

   }

   public static void b() {
      GL11.glPopAttrib();
   }

   public static void m(int var0) {
      GL11.glClear(var0);
   }

   public static void i(int var0) {
      if (var0 != p[o].b) {
         p[o].b = var0;
         GL11.glBindTexture(3553, var0);
      }

   }

   public static void a() {
      GL11.glPushAttrib(8256);
   }

   public static void a(FloatBuffer var0) {
      GL11.glMultMatrix(var0);
   }

   public static void d() {
      a.a.b();
   }

   public static void E() {
      GL11.glPushMatrix();
   }

   public static void m() {
      g.a.b();
   }

   public static void a(int var0, int var1) {
      if (var0 != d.b || var1 != d.c) {
         d.b = var0;
         d.c = var1;
         GL11.glColorMaterial(var0, var1);
      }

   }

   public static void c(float var0, float var1, float var2, float var3) {
      if (var0 != t.a || var1 != t.b || var2 != t.c || var3 != t.d) {
         t.a = var0;
         t.b = var1;
         t.c = var2;
         t.d = var3;
         GL11.glColor4f(var0, var1, var2, var3);
      }

   }

   public static void f() {
      b.a();
   }

   public static void b(float var0, float var1, float var2) {
      GL11.glTranslatef(var0, var1, var2);
   }

   public static void l() {
      e.a.b();
   }

   public static void a(int var0) {
      c[var0].b();
   }

   public static void a(bfl.o var0, int var1, FloatBuffer var2) {
      GL11.glTexGen(c(var0).b, var1, var2);
   }

   public static void e(int var0) {
      if (var0 != h.b) {
         h.b = var0;
         GL11.glCullFace(var0);
      }

   }

   public static void a(double var0, double var2, double var4) {
      GL11.glScaled(var0, var2, var4);
   }

   public static void a(float var0, float var1) {
      if (var0 != i.c || var1 != i.d) {
         i.c = var0;
         i.d = var1;
         GL11.glPolygonOffset(var0, var1);
      }

   }

   static {
      int var0;
      for(var0 = 0; var0 < 8; ++var0) {
         c[var0] = new bfl.c(16384 + var0);
      }

      for(var0 = 0; var0 < 8; ++var0) {
         p[var0] = new bfl.r();
      }

   }

   public static void b(bfl.o var0) {
      c(var0).a.a();
   }

   public static void a(int var0, float var1) {
      if (var0 != a.b || var1 != a.c) {
         a.b = var0;
         a.c = var1;
         GL11.glAlphaFunc(var0, var1);
      }

   }

   public static void a(boolean var0) {
      if (var0 != f.b) {
         f.b = var0;
         GL11.glDepthMask(var0);
      }

   }

   public static void k() {
      e.a.a();
   }

   public static void i() {
      f.a.a();
   }

   public static void D() {
      GL11.glLoadIdentity();
   }

   public static void a(float var0) {
      if (var0 != g.c) {
         g.c = var0;
         GL11.glFogf(2914, var0);
      }

   }

   public static void q() {
      i.a.b();
   }

   public static void e() {
      b.b();
   }

   public static void n() {
      g.a.a();
   }

   public static void C() {
      r.a();
   }

   public static void o() {
      h.a.b();
   }

   public static void r() {
      i.a.a();
   }

   public static void b(int var0) {
      c[var0].a();
   }

   public static void a(double var0, double var2, double var4, double var6, double var8, double var10) {
      GL11.glOrtho(var0, var2, var4, var6, var8, var10);
   }

   public static void b(float var0) {
      if (var0 != g.d) {
         g.d = var0;
         GL11.glFogf(2915, var0);
      }

   }

   public static void a(double var0) {
      if (var0 != l.a) {
         l.a = var0;
         GL11.glClearDepth(var0);
      }

   }

   public static void h() {
      d.a.a();
   }

   public static void b(double var0, double var2, double var4) {
      GL11.glTranslated(var0, var2, var4);
   }

   public static void B() {
      r.b();
   }

   private static bfl.p c(bfl.o var0) {
      switch(var0) {
      case a:
         return k.a;
      case b:
         return k.b;
      case c:
         return k.c;
      case d:
         return k.d;
      default:
         return k.a;
      }
   }

   public static void a(int var0, int var1, int var2, int var3) {
      if (var0 != e.b || var1 != e.c || var2 != e.d || var3 != e.e) {
         e.b = var0;
         e.c = var1;
         e.d = var2;
         e.e = var3;
         bqs.c(var0, var1, var2, var3);
      }

   }

   public static void d(int var0) {
      if (var0 != g.b) {
         g.b = var0;
         GL11.glFogi(2917, var0);
      }

   }

   public static void x() {
      p[o].a.a();
   }

   public static void c(int var0) {
      if (var0 != f.c) {
         f.c = var0;
         GL11.glDepthFunc(var0);
      }

   }

   public static int y() {
      return GL11.glGenTextures();
   }

   public static void c() {
      a.a.a();
   }

   public static void b(int var0, int var1, int var2, int var3) {
      GL11.glViewport(var0, var1, var2, var3);
   }

   public static void g() {
      d.a.b();
   }

   public static void a(bfl.o var0) {
      c(var0).a.b();
   }

   public static void p() {
      h.a.a();
   }

   public static void A() {
      n.a();
   }

   public static void b(int var0, int var1) {
      if (var0 != e.b || var1 != e.c) {
         e.b = var0;
         e.c = var1;
         GL11.glBlendFunc(var0, var1);
      }

   }

   public static void a(int var0, FloatBuffer var1) {
      GL11.glGetFloat(var0, var1);
   }

   public static void g(int var0) {
      if (o != var0 - bqs.q) {
         o = var0 - bqs.q;
         bqs.k(var0);
      }

   }

   public static void a(float var0, float var1, float var2) {
      GL11.glScalef(var0, var1, var2);
   }

   public static void o(int var0) {
      GL11.glCallList(var0);
   }

   public static void c(float var0, float var1, float var2) {
      c(var0, var1, var2, 1.0F);
   }

   public static void u() {
      j.a.b();
   }

   public static void j() {
      f.a.b();
   }

   public static void j(int var0) {
      if (var0 != q) {
         q = var0;
         GL11.glShadeModel(var0);
      }

   }

   public static void a(boolean var0, boolean var1, boolean var2, boolean var3) {
      if (var0 != s.a || var1 != s.b || var2 != s.c || var3 != s.d) {
         s.a = var0;
         s.b = var1;
         s.c = var2;
         s.d = var3;
         GL11.glColorMask(var0, var1, var2, var3);
      }

   }

   static class j {
      public boolean b;
      public bfl.c a;
      public int c;

      j(Object var1) {
         this();
      }

      private j() {
         this.a = new bfl.c(2929);
         this.b = true;
         this.c = 513;
      }
   }

   static class i {
      public int b;
      public bfl.c a;

      i(Object var1) {
         this();
      }

      private i() {
         this.a = new bfl.c(2884);
         this.b = 1029;
      }
   }

   static class m {
      public int c;
      public int b;
      public int a;

      m(Object var1) {
         this();
      }

      private m() {
         this.a = 519;
         this.b = 0;
         this.c = -1;
      }
   }

   static class q {
      public bfl.p c;
      public bfl.p d;
      public bfl.p a;
      public bfl.p b;

      private q() {
         this.a = new bfl.p(8192, 3168);
         this.b = new bfl.p(8193, 3169);
         this.c = new bfl.p(8194, 3170);
         this.d = new bfl.p(8195, 3171);
      }

      q(Object var1) {
         this();
      }
   }

   static class f {
      public bfl.c a;
      public int b;

      private f() {
         this.a = new bfl.c(3058);
         this.b = 5379;
      }

      f(Object var1) {
         this();
      }
   }

   static class n {
      public int d;
      public bfl.m a;
      public int e;
      public int c;
      public int b;

      private n() {
         this.a = new bfl.m();
         this.b = -1;
         this.c = 7680;
         this.d = 7680;
         this.e = 7680;
      }

      n(Object var1) {
         this();
      }
   }

   static class h {
      public int b;
      public bfl.c a;
      public int c;

      private h() {
         this.a = new bfl.c(2903);
         this.b = 1032;
         this.c = 5634;
      }

      h(Object var1) {
         this();
      }
   }

   public static enum o {
      d,
      a,
      c;

      private static final bfl.o[] e = new bfl.o[]{a, b, c, d};
      b;
   }

   static class r {
      public int b;
      public bfl.c a;

      r(Object var1) {
         this();
      }

      private r() {
         this.a = new bfl.c(3553);
         this.b = 0;
      }
   }

   static class k {
      public float c;
      public float e;
      public int b;
      public float d;
      public bfl.c a;

      private k() {
         this.a = new bfl.c(2912);
         this.b = 2048;
         this.c = 1.0F;
         this.d = 0.0F;
         this.e = 1.0F;
      }

      k(Object var1) {
         this();
      }
   }

   static class a {
      public bfl.c a;
      public int b;
      public float c;

      private a() {
         this.a = new bfl.c(3008);
         this.b = 519;
         this.c = -1.0F;
      }

      a(Object var1) {
         this();
      }
   }

   static class g {
      public boolean c;
      public boolean b;
      public boolean a;
      public boolean d;

      private g() {
         this.a = true;
         this.b = true;
         this.c = true;
         this.d = true;
      }

      g(Object var1) {
         this();
      }
   }

   static class d {
      public int c;
      public double a;
      public bfl.e b;

      d(Object var1) {
         this();
      }

      private d() {
         this.a = 1.0D;
         this.b = new bfl.e(0.0F, 0.0F, 0.0F, 0.0F);
         this.c = 0;
      }
   }

   static class e {
      public float b = 1.0F;
      public float a = 1.0F;
      public float d = 1.0F;
      public float c = 1.0F;

      public e() {
      }

      public e(float var1, float var2, float var3, float var4) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
      }
   }

   static class p {
      public int c = -1;
      public int b;
      public bfl.c a;

      public p(int var1, int var2) {
         this.b = var1;
         this.a = new bfl.c(var2);
      }
   }

   static class l {
      public float d;
      public bfl.c b;
      public float c;
      public bfl.c a;

      l(Object var1) {
         this();
      }

      private l() {
         this.a = new bfl.c(32823);
         this.b = new bfl.c(10754);
         this.c = 0.0F;
         this.d = 0.0F;
      }
   }

   static class c {
      private final int a;
      private boolean b = false;

      public void a() {
         this.a(false);
      }

      public void b() {
         this.a(true);
      }

      public c(int var1) {
         this.a = var1;
      }

      public void a(boolean var1) {
         if (var1 != this.b) {
            this.b = var1;
            if (var1) {
               GL11.glEnable(this.a);
            } else {
               GL11.glDisable(this.a);
            }
         }

      }
   }

   static class b {
      public int e;
      public int d;
      public int c;
      public bfl.c a;
      public int b;

      b(Object var1) {
         this();
      }

      private b() {
         this.a = new bfl.c(3042);
         this.b = 1;
         this.c = 0;
         this.d = 1;
         this.e = 0;
      }
   }
}
