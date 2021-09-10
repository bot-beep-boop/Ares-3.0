import com.google.common.collect.Lists;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;
import org.apache.commons.io.Charsets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ayc extends axu {
   private float s = 0.5F;
   private int h;
   private static final jy g = new jy("textures/misc/vignette.png");
   private static final Logger a = LogManager.getLogger();
   private static final jy f = new jy("textures/gui/title/minecraft.png");
   private int r;
   private List<String> i;

   protected void a(char var1, int var2) {
      if (var2 == 1) {
         this.a();
      }

   }

   public void e() {
      bpv var1 = this.j.r();
      bpz var2 = this.j.W();
      if (this.h == 0) {
         var1.a();
         var1.a(bpv.a.d);
         var2.e();
      }

      var2.c();
      ++this.h;
      float var3 = (float)(this.r + this.m + this.m + 24) / this.s;
      if ((float)this.h > var3) {
         this.a();
      }

   }

   private void b(int var1, int var2, float var3) {
      bfx var4 = bfx.a();
      bfd var5 = var4.c();
      this.j.P().a(avp.b);
      var5.a(7, bms.i);
      int var6 = this.l;
      float var7 = 0.0F - ((float)this.h + var3) * 0.5F * this.s;
      float var8 = (float)this.m - ((float)this.h + var3) * 0.5F * this.s;
      float var9 = 0.015625F;
      float var10 = ((float)this.h + var3 - 0.0F) * 0.02F;
      float var11 = (float)(this.r + this.m + this.m + 24) / this.s;
      float var12 = (var11 - 20.0F - ((float)this.h + var3)) * 0.005F;
      if (var12 < var10) {
         var10 = var12;
      }

      if (var10 > 1.0F) {
         var10 = 1.0F;
      }

      var10 *= var10;
      var10 = var10 * 96.0F / 255.0F;
      var5.b(0.0D, (double)this.m, (double)this.e).a(0.0D, (double)(var7 * var9)).a(var10, var10, var10, 1.0F).d();
      var5.b((double)var6, (double)this.m, (double)this.e).a((double)((float)var6 * var9), (double)(var7 * var9)).a(var10, var10, var10, 1.0F).d();
      var5.b((double)var6, 0.0D, (double)this.e).a((double)((float)var6 * var9), (double)(var8 * var9)).a(var10, var10, var10, 1.0F).d();
      var5.b(0.0D, 0.0D, (double)this.e).a(0.0D, (double)(var8 * var9)).a(var10, var10, var10, 1.0F).d();
      var4.b();
   }

   public void b() {
      if (this.i == null) {
         this.i = Lists.newArrayList();

         try {
            String var1 = "";
            String var2 = "" + a.p + a.q + a.k + a.l;
            short var3 = 274;
            InputStream var4 = this.j.Q().a(new jy("texts/end.txt")).b();
            BufferedReader var5 = new BufferedReader(new InputStreamReader(var4, Charsets.UTF_8));
            Random var6 = new Random(8124371L);

            int var7;
            while((var1 = var5.readLine()) != null) {
               String var8;
               String var9;
               for(var1 = var1.replaceAll("PLAYERNAME", this.j.L().c()); var1.contains(var2); var1 = var8 + a.p + a.q + "XXXXXXXX".substring(0, var6.nextInt(4) + 3) + var9) {
                  var7 = var1.indexOf(var2);
                  var8 = var1.substring(0, var7);
                  var9 = var1.substring(var7 + var2.length());
               }

               this.i.addAll(this.j.k.c(var1, var3));
               this.i.add("");
            }

            var4.close();

            for(var7 = 0; var7 < 8; ++var7) {
               this.i.add("");
            }

            var4 = this.j.Q().a(new jy("texts/credits.txt")).b();
            var5 = new BufferedReader(new InputStreamReader(var4, Charsets.UTF_8));

            while((var1 = var5.readLine()) != null) {
               var1 = var1.replaceAll("PLAYERNAME", this.j.L().c());
               var1 = var1.replaceAll("\t", "    ");
               this.i.addAll(this.j.k.c(var1, var3));
               this.i.add("");
            }

            var4.close();
            this.r = this.i.size() * 12;
         } catch (Exception var10) {
            a.error("Couldn't load credits", var10);
         }

      }
   }

   public boolean d() {
      return true;
   }

   private void a() {
      this.j.h.a.a((ff)(new ig(ig.a.a)));
      this.j.a((axu)null);
   }

   public void a(int var1, int var2, float var3) {
      this.b(var1, var2, var3);
      bfx var4 = bfx.a();
      bfd var5 = var4.c();
      short var6 = 274;
      int var7 = this.l / 2 - var6 / 2;
      int var8 = this.m + 50;
      float var9 = -((float)this.h + var3) * this.s;
      bfl.E();
      bfl.b(0.0F, var9, 0.0F);
      this.j.P().a(f);
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      this.b(var7, var8, 0, 0, 155, 44);
      this.b(var7 + 155, var8, 0, 45, 155, 44);
      int var10 = var8 + 200;

      int var11;
      for(var11 = 0; var11 < this.i.size(); ++var11) {
         if (var11 == this.i.size() - 1) {
            float var12 = (float)var10 + var9 - (float)(this.m / 2 - 6);
            if (var12 < 0.0F) {
               bfl.b(0.0F, -var12, 0.0F);
            }
         }

         if ((float)var10 + var9 + 12.0F + 8.0F > 0.0F && (float)var10 + var9 < (float)this.m) {
            String var13 = (String)this.i.get(var11);
            if (var13.startsWith("[C]")) {
               this.q.a(var13.substring(3), (float)(var7 + (var6 - this.q.a(var13.substring(3))) / 2), (float)var10, 16777215);
            } else {
               this.q.b.setSeed((long)var11 * 4238972211L + (long)(this.h / 4));
               this.q.a(var13, (float)var7, (float)var10, 16777215);
            }
         }

         var10 += 12;
      }

      bfl.F();
      this.j.P().a(g);
      bfl.l();
      bfl.b(0, 769);
      var11 = this.l;
      int var14 = this.m;
      var5.a(7, bms.i);
      var5.b(0.0D, (double)var14, (double)this.e).a(0.0D, 1.0D).a(1.0F, 1.0F, 1.0F, 1.0F).d();
      var5.b((double)var11, (double)var14, (double)this.e).a(1.0D, 1.0D).a(1.0F, 1.0F, 1.0F, 1.0F).d();
      var5.b((double)var11, 0.0D, (double)this.e).a(1.0D, 0.0D).a(1.0F, 1.0F, 1.0F, 1.0F).d();
      var5.b(0.0D, 0.0D, (double)this.e).a(0.0D, 0.0D).a(1.0F, 1.0F, 1.0F, 1.0F).d();
      var4.b();
      bfl.k();
      super.a(var1, var2, var3);
   }
}
