package net.optifine.shaders;

import java.util.Iterator;
import net.minecraft.client.renderer.ViewFrustum;
import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.util.BlockPos;
import net.optifine.BlockPosM;

public class IteratorRenderChunks implements Iterator<RenderChunk> {
   private ViewFrustum viewFrustum;
   private BlockPosM posBlock = new BlockPosM(0, 0, 0);
   private Iterator3d Iterator3d;

   public RenderChunk next() {
      BlockPos var1 = this.Iterator3d.next();
      this.posBlock.setXyz(var1.getX() << 4, var1.getY() << 4, var1.getZ() << 4);
      RenderChunk var2 = this.viewFrustum.getRenderChunk(this.posBlock);
      return var2;
   }

   public boolean hasNext() {
      return this.Iterator3d.hasNext();
   }

   public Object next() {
      return this.next();
   }

   public void remove() {
      throw new RuntimeException("Not implemented");
   }

   public IteratorRenderChunks(ViewFrustum var1, BlockPos var2, BlockPos var3, int var4, int var5) {
      this.viewFrustum = var1;
      this.Iterator3d = new Iterator3d(var2, var3, var4, var5);
   }
}
