import com.google.common.base.Objects;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;

public class bdc {
   private String g;
   private jy f;
   private int j = 0;
   private eu h;
   private long m = 0L;
   private long l = 0L;
   private final GameProfile a;
   private int i = 0;
   private int c;
   private long k = 0L;
   private adp.a b;
   private jy e;
   private boolean d = false;

   static String a(bdc var0, String var1) {
      return var0.g = var1;
   }

   public adp.a b() {
      return this.b;
   }

   public long n() {
      return this.k;
   }

   static jy b(bdc var0, jy var1) {
      return var0.f = var1;
   }

   public void c(long var1) {
      this.m = var1;
   }

   public bdc(gz.b var1) {
      this.a = var1.a();
      this.b = var1.c();
      this.c = var1.b();
      this.h = var1.d();
   }

   public void a(long var1) {
      this.k = var1;
   }

   public void c(int var1) {
      this.j = var1;
   }

   public int m() {
      return this.j;
   }

   static String a(bdc var0) {
      return var0.g;
   }

   protected void a(adp.a var1) {
      this.b = var1;
   }

   public jy g() {
      if (this.e == null) {
         this.j();
      }

      return (jy)Objects.firstNonNull(this.e, bmz.a(this.a.getId()));
   }

   public eu k() {
      return this.h;
   }

   public void a(eu var1) {
      this.h = var1;
   }

   public void b(long var1) {
      this.l = var1;
   }

   public int c() {
      return this.c;
   }

   static jy a(bdc var0, jy var1) {
      return var0.e = var1;
   }

   public long o() {
      return this.l;
   }

   public aul i() {
      return ave.A().f.Z().h(this.a().getName());
   }

   public boolean e() {
      return this.e != null;
   }

   public bdc(GameProfile var1) {
      this.a = var1;
   }

   public jy h() {
      if (this.f == null) {
         this.j();
      }

      return this.f;
   }

   public GameProfile a() {
      return this.a;
   }

   public int l() {
      return this.i;
   }

   public String f() {
      return this.g == null ? bmz.b(this.a.getId()) : this.g;
   }

   protected void j() {
      synchronized(this) {
         if (!this.d) {
            this.d = true;
            ave.A().ab().a(this.a, new bnp.a(this) {
               final bdc a;

               public void a(Type var1, jy var2, MinecraftProfileTexture var3) {
                  switch(var1) {
                  case SKIN:
                     bdc.a(this.a, var2);
                     bdc.a(this.a, var3.getMetadata("model"));
                     if (bdc.a(this.a) == null) {
                        bdc.a(this.a, "default");
                     }
                     break;
                  case CAPE:
                     bdc.b(this.a, var2);
                  }

               }

               {
                  this.a = var1;
               }
            }, true);
         }

      }
   }

   public long p() {
      return this.m;
   }

   protected void a(int var1) {
      this.c = var1;
   }

   public void b(int var1) {
      this.i = var1;
   }
}
