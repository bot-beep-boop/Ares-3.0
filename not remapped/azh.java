import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

public class azh extends axu implements awx {
   private bpq.b B;
   private String y;
   private boolean w;
   private final bdg f = new bdg();
   private axu g;
   private boolean u;
   private boolean C;
   private bde z;
   private boolean v;
   private boolean x;
   private avs t;
   private bpq.c A;
   private bdf i;
   private azl h;
   private static final Logger a = LogManager.getLogger();
   private avs s;
   private avs r;

   public bdf h() {
      return this.i;
   }

   public azh(axu var1) {
      this.g = var1;
   }

   public void a() {
      this.n.add(this.r = new avs(7, this.l / 2 - 154, this.m - 28, 70, 20, bnq.a("selectServer.edit")));
      this.n.add(this.t = new avs(2, this.l / 2 - 74, this.m - 28, 70, 20, bnq.a("selectServer.delete")));
      this.n.add(this.s = new avs(1, this.l / 2 - 154, this.m - 52, 100, 20, bnq.a("selectServer.select")));
      this.n.add(new avs(4, this.l / 2 - 50, this.m - 52, 100, 20, bnq.a("selectServer.direct")));
      this.n.add(new avs(3, this.l / 2 + 4 + 50, this.m - 52, 100, 20, bnq.a("selectServer.add")));
      this.n.add(new avs(8, this.l / 2 + 4, this.m - 28, 70, 20, bnq.a("selectServer.refresh")));
      this.n.add(new avs(0, this.l / 2 + 4 + 76, this.m - 28, 75, 20, bnq.a("gui.cancel")));
      this.b(this.h.e());
   }

   public void m() {
      Keyboard.enableRepeatEvents(false);
      if (this.B != null) {
         this.B.interrupt();
         this.B = null;
      }

      this.f.b();
   }

   public boolean b(azk var1, int var2) {
      return var2 < this.i.c() - 1;
   }

   public void f() {
      awd.a var1 = this.h.e() < 0 ? null : this.h.b(this.h.e());
      if (var1 instanceof azk) {
         this.a(((azk)var1).a());
      } else if (var1 instanceof azj) {
         bpq.a var2 = ((azj)var1).a();
         this.a(new bde(var2.a(), var2.b(), true));
      }

   }

   protected void b(int var1, int var2, int var3) {
      super.b(var1, var2, var3);
      this.h.c(var1, var2, var3);
   }

   public void k() {
      super.k();
      this.h.p();
   }

   public void b(azk var1, int var2, boolean var3) {
      int var4 = var3 ? this.i.c() - 1 : var2 + 1;
      this.i.a(var2, var4);
      if (this.h.e() == var2) {
         this.b(var4);
      }

      this.h.a(this.i);
   }

   protected void a(avs var1) {
      if (var1.l) {
         awd.a var2 = this.h.e() < 0 ? null : this.h.b(this.h.e());
         if (var1.k == 2 && var2 instanceof azk) {
            String var9 = ((azk)var2).a().a;
            if (var9 != null) {
               this.u = true;
               String var4 = bnq.a("selectServer.deleteQuestion");
               String var5 = "'" + var9 + "' " + bnq.a("selectServer.deleteWarning");
               String var6 = bnq.a("selectServer.deleteButton");
               String var7 = bnq.a("gui.cancel");
               awy var8 = new awy(this, var4, var5, var6, var7, this.h.e());
               this.j.a((axu)var8);
            }
         } else if (var1.k == 1) {
            this.f();
         } else if (var1.k == 4) {
            this.x = true;
            this.j.a((axu)(new axg(this, this.z = new bde(bnq.a("selectServer.defaultName"), "", false))));
         } else if (var1.k == 3) {
            this.v = true;
            this.j.a((axu)(new axi(this, this.z = new bde(bnq.a("selectServer.defaultName"), "", false))));
         } else if (var1.k == 7 && var2 instanceof azk) {
            this.w = true;
            bde var3 = ((azk)var2).a();
            this.z = new bde(var3.a, var3.b, false);
            this.z.a(var3);
            this.j.a((axu)(new axi(this, this.z)));
         } else if (var1.k == 0) {
            this.j.a(this.g);
         } else if (var1.k == 8) {
            this.i();
         }

      }
   }

   private void a(bde var1) {
      this.j.a((axu)(new awz(this, this.j, var1)));
   }

   public void a(String var1) {
      this.y = var1;
   }

   public void a(int var1, int var2, float var3) {
      this.y = null;
      this.c();
      this.h.a(var1, var2, var3);
      this.a(this.q, bnq.a("multiplayer.title"), this.l / 2, 20, 16777215);
      super.a(var1, var2, var3);
      if (this.y != null) {
         this.a(Lists.newArrayList(Splitter.on("\n").split(this.y)), var1, var2);
      }

   }

   protected void a(char var1, int var2) {
      int var3 = this.h.e();
      awd.a var4 = var3 < 0 ? null : this.h.b(var3);
      if (var2 == 63) {
         this.i();
      } else {
         if (var3 >= 0) {
            if (var2 == 200) {
               if (r()) {
                  if (var3 > 0 && var4 instanceof azk) {
                     this.i.a(var3, var3 - 1);
                     this.b(this.h.e() - 1);
                     this.h.h(-this.h.r());
                     this.h.a(this.i);
                  }
               } else if (var3 > 0) {
                  this.b(this.h.e() - 1);
                  this.h.h(-this.h.r());
                  if (this.h.b(this.h.e()) instanceof azi) {
                     if (this.h.e() > 0) {
                        this.b(this.h.b() - 1);
                        this.h.h(-this.h.r());
                     } else {
                        this.b(-1);
                     }
                  }
               } else {
                  this.b(-1);
               }
            } else if (var2 == 208) {
               if (r()) {
                  if (var3 < this.i.c() - 1) {
                     this.i.a(var3, var3 + 1);
                     this.b(var3 + 1);
                     this.h.h(this.h.r());
                     this.h.a(this.i);
                  }
               } else if (var3 < this.h.b()) {
                  this.b(this.h.e() + 1);
                  this.h.h(this.h.r());
                  if (this.h.b(this.h.e()) instanceof azi) {
                     if (this.h.e() < this.h.b() - 1) {
                        this.b(this.h.b() + 1);
                        this.h.h(this.h.r());
                     } else {
                        this.b(-1);
                     }
                  }
               } else {
                  this.b(-1);
               }
            } else if (var2 != 28 && var2 != 156) {
               super.a(var1, var2);
            } else {
               this.a((avs)this.n.get(2));
            }
         } else {
            super.a(var1, var2);
         }

      }
   }

   public boolean a(azk var1, int var2) {
      return var2 > 0;
   }

   protected void a(int var1, int var2, int var3) {
      super.a(var1, var2, var3);
      this.h.b(var1, var2, var3);
   }

   private void i() {
      this.j.a((axu)(new azh(this.g)));
   }

   public void b() {
      Keyboard.enableRepeatEvents(true);
      this.n.clear();
      if (!this.C) {
         this.C = true;
         this.i = new bdf(this.j);
         this.i.a();
         this.A = new bpq.c();

         try {
            this.B = new bpq.b(this.A);
            this.B.start();
         } catch (Exception var2) {
            a.warn("Unable to start LAN server detection: " + var2.getMessage());
         }

         this.h = new azl(this, this.j, this.l, this.m, 32, this.m - 64, 36);
         this.h.a(this.i);
      } else {
         this.h.a(this.l, this.m, 32, this.m - 64);
      }

      this.a();
   }

   public bdg g() {
      return this.f;
   }

   public void b(int var1) {
      this.h.c(var1);
      awd.a var2 = var1 < 0 ? null : this.h.b(var1);
      this.s.l = false;
      this.r.l = false;
      this.t.l = false;
      if (var2 != null && !(var2 instanceof azi)) {
         this.s.l = true;
         if (var2 instanceof azk) {
            this.r.l = true;
            this.t.l = true;
         }
      }

   }

   public void e() {
      super.e();
      if (this.A.a()) {
         List var1 = this.A.c();
         this.A.b();
         this.h.a(var1);
      }

      this.f.a();
   }

   public void a(azk var1, int var2, boolean var3) {
      int var4 = var3 ? 0 : var2 - 1;
      this.i.a(var2, var4);
      if (this.h.e() == var2) {
         this.b(var4);
      }

      this.h.a(this.i);
   }

   public void a(boolean var1, int var2) {
      awd.a var3 = this.h.e() < 0 ? null : this.h.b(this.h.e());
      if (this.u) {
         this.u = false;
         if (var1 && var3 instanceof azk) {
            this.i.b(this.h.e());
            this.i.b();
            this.h.c(-1);
            this.h.a(this.i);
         }

         this.j.a((axu)this);
      } else if (this.x) {
         this.x = false;
         if (var1) {
            this.a(this.z);
         } else {
            this.j.a((axu)this);
         }
      } else if (this.v) {
         this.v = false;
         if (var1) {
            this.i.a(this.z);
            this.i.b();
            this.h.c(-1);
            this.h.a(this.i);
         }

         this.j.a((axu)this);
      } else if (this.w) {
         this.w = false;
         if (var1 && var3 instanceof azk) {
            bde var4 = ((azk)var3).a();
            var4.a = this.z.a;
            var4.b = this.z.b;
            var4.a(this.z);
            this.i.b();
            this.h.a(this.i);
         }

         this.j.a((axu)this);
      }

   }
}
