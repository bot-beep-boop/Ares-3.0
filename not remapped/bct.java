import com.google.common.collect.Lists;
import java.util.List;
import org.lwjgl.opengl.GL11;

public class bct {
   public boolean i;
   private boolean t;
   public float q;
   public float o;
   private int u;
   public boolean k;
   public float h;
   public float c;
   public float d;
   public boolean j;
   public float e;
   private int s;
   public final String n;
   public float a;
   public float b;
   public List<bcr> l;
   public float p;
   public float g;
   public List<bct> m;
   public float f;
   private bbo v;
   private int r;

   public bct a(float var1, float var2, float var3, int var4, int var5, int var6, boolean var7) {
      this.l.add(new bcr(this, this.r, this.s, var1, var2, var3, var4, var5, var6, 0.0F, var7));
      return this;
   }

   public bct a(float var1, float var2, float var3, int var4, int var5, int var6) {
      this.l.add(new bcr(this, this.r, this.s, var1, var2, var3, var4, var5, var6, 0.0F));
      return this;
   }

   public void b(float var1) {
      if (!this.k) {
         if (this.j) {
            if (!this.t) {
               this.d(var1);
            }

            bfl.E();
            bfl.b(this.c * var1, this.d * var1, this.e * var1);
            if (this.g != 0.0F) {
               bfl.b(this.g * 57.295776F, 0.0F, 1.0F, 0.0F);
            }

            if (this.f != 0.0F) {
               bfl.b(this.f * 57.295776F, 1.0F, 0.0F, 0.0F);
            }

            if (this.h != 0.0F) {
               bfl.b(this.h * 57.295776F, 0.0F, 0.0F, 1.0F);
            }

            bfl.o(this.u);
            bfl.F();
         }
      }
   }

   public bct(bbo var1, String var2) {
      this.a = 64.0F;
      this.b = 32.0F;
      this.j = true;
      this.l = Lists.newArrayList();
      this.v = var1;
      var1.s.add(this);
      this.n = var2;
      this.b(var1.t, var1.u);
   }

   public bct a(String var1, float var2, float var3, float var4, int var5, int var6, int var7) {
      var1 = this.n + "." + var1;
      bcu var8 = this.v.a(var1);
      this.a(var8.a, var8.b);
      this.l.add((new bcr(this, this.r, this.s, var2, var3, var4, var5, var6, var7, 0.0F)).a(var1));
      return this;
   }

   public bct b(int var1, int var2) {
      this.a = (float)var1;
      this.b = (float)var2;
      return this;
   }

   public void a(float var1, float var2, float var3) {
      this.c = var1;
      this.d = var2;
      this.e = var3;
   }

   public bct(bbo var1) {
      this(var1, (String)null);
   }

   public bct(bbo var1, int var2, int var3) {
      this(var1);
      this.a(var2, var3);
   }

   public void a(float var1, float var2, float var3, int var4, int var5, int var6, float var7) {
      this.l.add(new bcr(this, this.r, this.s, var1, var2, var3, var4, var5, var6, var7));
   }

   public void c(float var1) {
      if (!this.k) {
         if (this.j) {
            if (!this.t) {
               this.d(var1);
            }

            if (this.f == 0.0F && this.g == 0.0F && this.h == 0.0F) {
               if (this.c != 0.0F || this.d != 0.0F || this.e != 0.0F) {
                  bfl.b(this.c * var1, this.d * var1, this.e * var1);
               }
            } else {
               bfl.b(this.c * var1, this.d * var1, this.e * var1);
               if (this.h != 0.0F) {
                  bfl.b(this.h * 57.295776F, 0.0F, 0.0F, 1.0F);
               }

               if (this.g != 0.0F) {
                  bfl.b(this.g * 57.295776F, 0.0F, 1.0F, 0.0F);
               }

               if (this.f != 0.0F) {
                  bfl.b(this.f * 57.295776F, 1.0F, 0.0F, 0.0F);
               }
            }

         }
      }
   }

   public void a(float var1) {
      if (!this.k) {
         if (this.j) {
            if (!this.t) {
               this.d(var1);
            }

            bfl.b(this.o, this.p, this.q);
            int var2;
            if (this.f == 0.0F && this.g == 0.0F && this.h == 0.0F) {
               if (this.c == 0.0F && this.d == 0.0F && this.e == 0.0F) {
                  bfl.o(this.u);
                  if (this.m != null) {
                     for(var2 = 0; var2 < this.m.size(); ++var2) {
                        ((bct)this.m.get(var2)).a(var1);
                     }
                  }
               } else {
                  bfl.b(this.c * var1, this.d * var1, this.e * var1);
                  bfl.o(this.u);
                  if (this.m != null) {
                     for(var2 = 0; var2 < this.m.size(); ++var2) {
                        ((bct)this.m.get(var2)).a(var1);
                     }
                  }

                  bfl.b(-this.c * var1, -this.d * var1, -this.e * var1);
               }
            } else {
               bfl.E();
               bfl.b(this.c * var1, this.d * var1, this.e * var1);
               if (this.h != 0.0F) {
                  bfl.b(this.h * 57.295776F, 0.0F, 0.0F, 1.0F);
               }

               if (this.g != 0.0F) {
                  bfl.b(this.g * 57.295776F, 0.0F, 1.0F, 0.0F);
               }

               if (this.f != 0.0F) {
                  bfl.b(this.f * 57.295776F, 1.0F, 0.0F, 0.0F);
               }

               bfl.o(this.u);
               if (this.m != null) {
                  for(var2 = 0; var2 < this.m.size(); ++var2) {
                     ((bct)this.m.get(var2)).a(var1);
                  }
               }

               bfl.F();
            }

            bfl.b(-this.o, -this.p, -this.q);
         }
      }
   }

   public void a(bct var1) {
      if (this.m == null) {
         this.m = Lists.newArrayList();
      }

      this.m.add(var1);
   }

   private void d(float var1) {
      this.u = avd.a(1);
      GL11.glNewList(this.u, 4864);
      bfd var2 = bfx.a().c();

      for(int var3 = 0; var3 < this.l.size(); ++var3) {
         ((bcr)this.l.get(var3)).a(var2, var1);
      }

      GL11.glEndList();
      this.t = true;
   }

   public bct a(int var1, int var2) {
      this.r = var1;
      this.s = var2;
      return this;
   }
}
