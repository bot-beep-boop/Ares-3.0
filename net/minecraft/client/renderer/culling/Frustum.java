package net.minecraft.client.renderer.culling;

import net.minecraft.util.AxisAlignedBB;

public class Frustum implements ICamera {
   private double zPosition;
   private double xPosition;
   private ClippingHelper clippingHelper;
   private double yPosition;

   public Frustum() {
      this(ClippingHelperImpl.getInstance());
   }

   public void setPosition(double var1, double var3, double var5) {
      this.xPosition = var1;
      this.yPosition = var3;
      this.zPosition = var5;
   }

   public boolean isBoundingBoxInFrustum(AxisAlignedBB var1) {
      return this.isBoxInFrustum(var1.minX, var1.minY, var1.minZ, var1.maxX, var1.maxY, var1.maxZ);
   }

   public boolean isBoxInFrustum(double var1, double var3, double var5, double var7, double var9, double var11) {
      return this.clippingHelper.isBoxInFrustum(var1 - this.xPosition, var3 - this.yPosition, var5 - this.zPosition, var7 - this.xPosition, var9 - this.yPosition, var11 - this.zPosition);
   }

   public boolean isBoxInFrustumFully(double var1, double var3, double var5, double var7, double var9, double var11) {
      return this.clippingHelper.isBoxInFrustumFully(var1 - this.xPosition, var3 - this.yPosition, var5 - this.zPosition, var7 - this.xPosition, var9 - this.yPosition, var11 - this.zPosition);
   }

   public Frustum(ClippingHelper var1) {
      this.clippingHelper = var1;
   }
}
