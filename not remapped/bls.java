import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.lwjgl.util.vector.Matrix4f;

public class bls {
   private final List<Object> d = Lists.newArrayList();
   private final blq c;
   public final bfw b;
   private final List<Integer> g = Lists.newArrayList();
   private final List<String> e = Lists.newArrayList();
   public final bfw a;
   private final List<Integer> f = Lists.newArrayList();
   private Matrix4f h;

   private void d() {
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      bfl.k();
      bfl.i();
      bfl.c();
      bfl.n();
      bfl.f();
      bfl.h();
      bfl.w();
      bfl.i(0);
   }

   public void a(float var1) {
      this.d();
      this.a.e();
      float var2 = (float)this.b.a;
      float var3 = (float)this.b.b;
      bfl.b(0, 0, (int)var2, (int)var3);
      this.c.a("DiffuseSampler", this.a);

      for(int var4 = 0; var4 < this.d.size(); ++var4) {
         this.c.a((String)this.e.get(var4), this.d.get(var4));
         this.c.b("AuxSize" + var4).a((float)(Integer)this.f.get(var4), (float)(Integer)this.g.get(var4));
      }

      this.c.b("ProjMat").a(this.h);
      this.c.b("InSize").a((float)this.a.a, (float)this.a.b);
      this.c.b("OutSize").a(var2, var3);
      this.c.b("Time").a(var1);
      ave var9 = ave.A();
      this.c.b("ScreenSize").a((float)var9.d, (float)var9.e);
      this.c.c();
      this.b.f();
      this.b.a(false);
      bfl.a(false);
      bfl.a(true, true, true, true);
      bfx var5 = bfx.a();
      bfd var6 = var5.c();
      var6.a(7, bms.f);
      var6.b(0.0D, (double)var3, 500.0D).b(255, 255, 255, 255).d();
      var6.b((double)var2, (double)var3, 500.0D).b(255, 255, 255, 255).d();
      var6.b((double)var2, 0.0D, 500.0D).b(255, 255, 255, 255).d();
      var6.b(0.0D, 0.0D, 500.0D).b(255, 255, 255, 255).d();
      var5.b();
      bfl.a(true);
      bfl.a(true, true, true, true);
      this.c.b();
      this.b.e();
      this.a.d();
      Iterator var7 = this.d.iterator();

      while(var7.hasNext()) {
         Object var8 = var7.next();
         if (var8 instanceof bfw) {
            ((bfw)var8).d();
         }
      }

   }

   public void a(Matrix4f var1) {
      this.h = var1;
   }

   public void a(String var1, Object var2, int var3, int var4) {
      this.e.add(this.e.size(), var1);
      this.d.add(this.d.size(), var2);
      this.f.add(this.f.size(), var3);
      this.g.add(this.g.size(), var4);
   }

   public void b() {
      this.c.a();
   }

   public blq c() {
      return this.c;
   }

   public bls(bni var1, String var2, bfw var3, bfw var4) throws IOException {
      this.c = new blq(var1, var2);
      this.a = var3;
      this.b = var4;
   }
}
