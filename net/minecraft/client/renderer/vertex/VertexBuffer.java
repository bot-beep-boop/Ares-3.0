package net.minecraft.client.renderer.vertex;

import java.nio.ByteBuffer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.optifine.render.VboRange;
import net.optifine.render.VboRegion;
import org.lwjgl.opengl.GL11;

public class VertexBuffer {
   private int glBufferId;
   private final VertexFormat vertexFormat;
   private int drawMode;
   private VboRange vboRange;
   private VboRegion vboRegion;
   private int count;

   public void bindBuffer() {
      OpenGlHelper.glBindBuffer(OpenGlHelper.GL_ARRAY_BUFFER, this.glBufferId);
   }

   public void deleteGlBuffers() {
      if (this.glBufferId >= 0) {
         OpenGlHelper.glDeleteBuffers(this.glBufferId);
         this.glBufferId = -1;
      }

   }

   public VertexBuffer(VertexFormat var1) {
      this.vertexFormat = var1;
      this.glBufferId = OpenGlHelper.glGenBuffers();
   }

   public void unbindBuffer() {
      OpenGlHelper.glBindBuffer(OpenGlHelper.GL_ARRAY_BUFFER, 0);
   }

   public int getDrawMode() {
      return this.drawMode;
   }

   public VboRange getVboRange() {
      return this.vboRange;
   }

   public void setDrawMode(int var1) {
      this.drawMode = var1;
   }

   public VboRegion getVboRegion() {
      return this.vboRegion;
   }

   public void bufferData(ByteBuffer var1) {
      if (this.vboRegion != null) {
         this.vboRegion.bufferData(var1, this.vboRange);
      } else {
         this.bindBuffer();
         OpenGlHelper.glBufferData(OpenGlHelper.GL_ARRAY_BUFFER, var1, 35044);
         this.unbindBuffer();
         this.count = var1.limit() / this.vertexFormat.getNextOffset();
      }

   }

   public void drawArrays(int var1) {
      if (this.drawMode > 0) {
         var1 = this.drawMode;
      }

      if (this.vboRegion != null) {
         this.vboRegion.drawArrays(var1, this.vboRange);
      } else {
         GL11.glDrawArrays(var1, 0, this.count);
      }

   }

   public void setVboRegion(VboRegion var1) {
      if (var1 != null) {
         this.deleteGlBuffers();
         this.vboRegion = var1;
         this.vboRange = new VboRange();
      }

   }
}
