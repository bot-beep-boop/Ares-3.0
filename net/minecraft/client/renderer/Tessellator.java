package net.minecraft.client.renderer;

import net.optifine.SmartAnimations;

public class Tessellator {
   private static final Tessellator instance = new Tessellator(2097152);
   private WorldRenderer worldRenderer;
   private WorldVertexBufferUploader vboUploader = new WorldVertexBufferUploader();

   public static Tessellator getInstance() {
      return instance;
   }

   public WorldRenderer getWorldRenderer() {
      return this.worldRenderer;
   }

   public void draw() {
      if (this.worldRenderer.animatedSprites != null) {
         SmartAnimations.spritesRendered(this.worldRenderer.animatedSprites);
      }

      this.worldRenderer.finishDrawing();
      this.vboUploader.draw(this.worldRenderer);
   }

   public Tessellator(int var1) {
      this.worldRenderer = new WorldRenderer(var1);
   }
}
