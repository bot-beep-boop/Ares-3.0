package net.optifine.render;

public class GlAlphaState {
   private float ref;
   private int func;
   private boolean enabled;

   public void setState(boolean var1, int var2, float var3) {
      this.enabled = var1;
      this.func = var2;
      this.ref = var3;
   }

   public void setEnabled(boolean var1) {
      this.enabled = var1;
   }

   public GlAlphaState(boolean var1) {
      this(var1, 519, 0.0F);
   }

   public float getRef() {
      return this.ref;
   }

   public GlAlphaState(boolean var1, int var2, float var3) {
      this.enabled = var1;
      this.func = var2;
      this.ref = var3;
   }

   public void setState(GlAlphaState var1) {
      this.enabled = var1.enabled;
      this.func = var1.func;
      this.ref = var1.ref;
   }

   public void setFuncRef(int var1, float var2) {
      this.func = var1;
      this.ref = var2;
   }

   public void setEnabled() {
      this.enabled = true;
   }

   public GlAlphaState() {
      this(false, 519, 0.0F);
   }

   public boolean isEnabled() {
      return this.enabled;
   }

   public int getFunc() {
      return this.func;
   }

   public String toString() {
      return "enabled: " + this.enabled + ", func: " + this.func + ", ref: " + this.ref;
   }

   public void setDisabled() {
      this.enabled = false;
   }
}
