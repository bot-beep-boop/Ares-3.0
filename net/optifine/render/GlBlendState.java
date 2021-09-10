package net.optifine.render;

public class GlBlendState {
   private int dstFactorAlpha;
   private int srcFactor;
   private boolean enabled;
   private int srcFactorAlpha;
   private int dstFactor;

   public GlBlendState(boolean var1, int var2, int var3, int var4, int var5) {
      this.enabled = var1;
      this.srcFactor = var2;
      this.dstFactor = var3;
      this.srcFactorAlpha = var4;
      this.dstFactorAlpha = var5;
   }

   public int getSrcFactorAlpha() {
      return this.srcFactorAlpha;
   }

   public boolean isEnabled() {
      return this.enabled;
   }

   public int getDstFactorAlpha() {
      return this.dstFactorAlpha;
   }

   public void setEnabled() {
      this.enabled = true;
   }

   public void setEnabled(boolean var1) {
      this.enabled = var1;
   }

   public String toString() {
      return "enabled: " + this.enabled + ", src: " + this.srcFactor + ", dst: " + this.dstFactor + ", srcAlpha: " + this.srcFactorAlpha + ", dstAlpha: " + this.dstFactorAlpha;
   }

   public GlBlendState(boolean var1, int var2, int var3) {
      this(var1, var2, var3, var2, var3);
   }

   public void setDisabled() {
      this.enabled = false;
   }

   public int getDstFactor() {
      return this.dstFactor;
   }

   public GlBlendState() {
      this(false, 1, 0);
   }

   public int getSrcFactor() {
      return this.srcFactor;
   }

   public void setFactors(int var1, int var2) {
      this.srcFactor = var1;
      this.dstFactor = var2;
      this.srcFactorAlpha = var1;
      this.dstFactorAlpha = var2;
   }

   public boolean isSeparate() {
      return this.srcFactor != this.srcFactorAlpha || this.dstFactor != this.dstFactorAlpha;
   }

   public GlBlendState(boolean var1) {
      this(var1, 1, 0);
   }

   public void setState(boolean var1, int var2, int var3, int var4, int var5) {
      this.enabled = var1;
      this.srcFactor = var2;
      this.dstFactor = var3;
      this.srcFactorAlpha = var4;
      this.dstFactorAlpha = var5;
   }

   public void setFactors(int var1, int var2, int var3, int var4) {
      this.srcFactor = var1;
      this.dstFactor = var2;
      this.srcFactorAlpha = var3;
      this.dstFactorAlpha = var4;
   }

   public void setState(GlBlendState var1) {
      this.enabled = var1.enabled;
      this.srcFactor = var1.srcFactor;
      this.dstFactor = var1.dstFactor;
      this.srcFactorAlpha = var1.srcFactorAlpha;
      this.dstFactorAlpha = var1.dstFactorAlpha;
   }
}
