import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.minecraft.realms.RealmsButton;
import net.minecraft.realms.RealmsScreen;

public class awr extends axu {
   private RealmsScreen a;

   public boolean d() {
      return super.d();
   }

   public void b_(int var1) {
      super.b_(var1);
   }

   public int c(String var1) {
      return this.q.a(var1);
   }

   public void m() {
      this.a.removed();
      super.m();
   }

   public void a(List<String> var1, int var2, int var3) {
      super.a(var1, var2, var3);
   }

   public void a(String var1, int var2, int var3, int var4) {
      super.a(this.q, var1, var2, var3, var4);
   }

   public void a(int var1, int var2, int var3, long var4) {
      this.a.mouseDragged(var1, var2, var3, var4);
   }

   public void k() {
      this.a.mouseEvent();
      super.k();
   }

   public void b(RealmsButton var1) {
      super.n.remove(var1.getProxy());
   }

   public void a(String var1, int var2, int var3, int var4, boolean var5) {
      if (var5) {
         super.c(this.q, var1, var2, var3, var4);
      } else {
         this.q.a(var1, var2, var3, var4);
      }

   }

   public void i() {
      super.n.clear();
   }

   public void e() {
      this.a.tick();
      super.e();
   }

   public void a(zx var1, int var2, int var3) {
      super.a(var1, var2, var3);
   }

   public List<String> a(String var1, int var2) {
      return this.q.c(var1, var2);
   }

   public final void a(avs var1) {
      this.a.buttonClicked(((awp)var1).f());
   }

   public void b(int var1, int var2, int var3) {
      this.a.mouseReleased(var1, var2, var3);
   }

   public void b(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.a.blit(var1, var2, var3, var4, var5, var6);
      super.b(var1, var2, var3, var4, var5, var6);
   }

   public void b() {
      this.a.init();
      super.b();
   }

   public void c() {
      super.c();
   }

   public int h() {
      return this.q.a;
   }

   public void a(int var1, int var2, int var3) {
      this.a.mouseClicked(var1, var2, var3);
      super.a(var1, var2, var3);
   }

   public void a(RealmsButton var1) {
      super.n.add(var1.getProxy());
   }

   public void a(char var1, int var2) {
      this.a.keyPressed(var1, var2);
   }

   public void a(String var1, int var2, int var3) {
      super.a(var1, var2, var3);
   }

   public void b(String var1, int var2, int var3, int var4) {
      this.q.a(var1, (float)var2, (float)var3, var4);
   }

   public awr(RealmsScreen var1) {
      this.a = var1;
      super.n = Collections.synchronizedList(Lists.newArrayList());
   }

   public void a(int var1, int var2, int var3, int var4, int var5, int var6) {
      super.a(var1, var2, var3, var4, var5, var6);
   }

   public List<RealmsButton> j() {
      ArrayList var1 = Lists.newArrayListWithExpectedSize(super.n.size());
      Iterator var2 = super.n.iterator();

      while(var2.hasNext()) {
         avs var3 = (avs)var2.next();
         var1.add(((awp)var3).f());
      }

      return var1;
   }

   public void a(int var1, int var2, float var3) {
      this.a.render(var1, var2, var3);
   }

   public RealmsScreen a() {
      return this.a;
   }

   public void a(boolean var1, int var2) {
      this.a.confirmResult(var1, var2);
   }

   public void l() {
      this.a.keyboardEvent();
      super.l();
   }
}
