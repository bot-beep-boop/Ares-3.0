public class bpf extends bpa {
   public bpf(jy var1, float var2, float var3, float var4, float var5, float var6) {
      this(var1, var2, var3, false, 0, bpj.a.b, var4, var5, var6);
   }

   public static bpf a(jy var0) {
      return new bpf(var0, 1.0F, 1.0F, false, 0, bpj.a.a, 0.0F, 0.0F, 0.0F);
   }

   private bpf(jy var1, float var2, float var3, boolean var4, int var5, bpj.a var6, float var7, float var8, float var9) {
      super(var1);
      this.b = var2;
      this.c = var3;
      this.d = var7;
      this.e = var8;
      this.f = var9;
      this.g = var4;
      this.h = var5;
      this.i = var6;
   }

   public static bpf a(jy var0, float var1, float var2, float var3) {
      return new bpf(var0, 4.0F, 1.0F, false, 0, bpj.a.b, var1, var2, var3);
   }

   public static bpf a(jy var0, float var1) {
      return new bpf(var0, 0.25F, var1, false, 0, bpj.a.a, 0.0F, 0.0F, 0.0F);
   }
}
