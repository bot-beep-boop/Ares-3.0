package net.minecraft.client.renderer.block.model;

import net.minecraft.util.EnumFacing;
import org.lwjgl.util.vector.Vector3f;

public class BlockPartRotation {
   public final boolean rescale;
   public final EnumFacing.Axis axis;
   public final Vector3f origin;
   public final float angle;

   public BlockPartRotation(Vector3f var1, EnumFacing.Axis var2, float var3, boolean var4) {
      this.origin = var1;
      this.axis = var2;
      this.angle = var3;
      this.rescale = var4;
   }
}
