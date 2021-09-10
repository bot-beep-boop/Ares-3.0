package net.minecraft.client.renderer;

import com.google.common.primitives.Floats;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.renderer.vertex.VertexFormatElement;
import net.minecraft.src.Config;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.MathHelper;
import net.optifine.SmartAnimations;
import net.optifine.render.RenderEnv;
import net.optifine.shaders.SVertexBuilder;
import net.optifine.util.TextureUtils;
import org.apache.logging.log4j.LogManager;
import org.lwjgl.opengl.GL11;

public class WorldRenderer {
   private boolean noColor;
   public FloatBuffer rawFloatBuffer;
   private int vertexFormatIndex;
   private double zOffset;
   public IntBuffer rawIntBuffer;
   private VertexFormatElement vertexFormatElement;
   public int vertexCount;
   public int drawMode;
   private ByteBuffer byteBufferTriangles;
   private TextureAtlasSprite[] quadSpritesPrev = null;
   private boolean modeTriangles = false;
   private double xOffset;
   private boolean[] drawnIcons = new boolean[256];
   public BitSet animatedSprites = null;
   private EnumWorldBlockLayer blockLayer = null;
   private TextureAtlasSprite quadSprite = null;
   private boolean isDrawing;
   public RenderEnv renderEnv = null;
   private VertexFormat vertexFormat;
   private ShortBuffer rawShortBuffer;
   public SVertexBuilder sVertexBuilder;
   private ByteBuffer byteBuffer;
   private double yOffset;
   private static int[] $SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType;
   private TextureAtlasSprite[] quadSprites = null;
   public BitSet animatedSpritesCached = new BitSet();

   public boolean isMultiTexture() {
      return this.quadSprites != null;
   }

   public int getDrawMode() {
      return this.modeTriangles ? 4 : this.drawMode;
   }

   public WorldRenderer(int var1) {
      this.byteBuffer = GLAllocation.createDirectByteBuffer(var1 * 4);
      this.rawIntBuffer = this.byteBuffer.asIntBuffer();
      this.rawShortBuffer = this.byteBuffer.asShortBuffer();
      this.rawFloatBuffer = this.byteBuffer.asFloatBuffer();
      SVertexBuilder.initVertexBuilder(this);
   }

   public void setSprite(TextureAtlasSprite var1) {
      if (this.animatedSprites != null && var1 != null && var1.getAnimationIndex() >= 0) {
         this.animatedSprites.set(var1.getAnimationIndex());
      }

      if (this.quadSprites != null) {
         this.quadSprite = var1;
      }

   }

   public void drawMultiTexture() {
      if (this.quadSprites != null) {
         int var1 = Config.getMinecraft().getTextureMapBlocks().getCountRegisteredSprites();
         if (this.drawnIcons.length <= var1) {
            this.drawnIcons = new boolean[var1 + 1];
         }

         Arrays.fill(this.drawnIcons, false);
         int var2 = 0;
         int var3 = -1;
         int var4 = this.vertexCount / 4;

         for(int var5 = 0; var5 < var4; ++var5) {
            TextureAtlasSprite var6 = this.quadSprites[var5];
            if (var6 != null) {
               int var7 = var6.getIndexInMap();
               if (!this.drawnIcons[var7]) {
                  if (var6 == TextureUtils.iconGrassSideOverlay) {
                     if (var3 < 0) {
                        var3 = var5;
                     }
                  } else {
                     var5 = this.drawForIcon(var6, var5) - 1;
                     ++var2;
                     if (this.blockLayer != EnumWorldBlockLayer.TRANSLUCENT) {
                        this.drawnIcons[var7] = true;
                     }
                  }
               }
            }
         }

         if (var3 >= 0) {
            this.drawForIcon(TextureUtils.iconGrassSideOverlay, var3);
            ++var2;
         }

         if (var2 > 0) {
         }
      }

   }

   private void nextVertexFormatIndex() {
      ++this.vertexFormatIndex;
      this.vertexFormatIndex %= this.vertexFormat.getElementCount();
      this.vertexFormatElement = this.vertexFormat.getElement(this.vertexFormatIndex);
      if (this.vertexFormatElement.getUsage() == VertexFormatElement.EnumUsage.PADDING) {
         this.nextVertexFormatIndex();
      }

   }

   public void putColorRGB_F(float var1, float var2, float var3, int var4) {
      int var5 = this.getColorIndex(var4);
      int var6 = MathHelper.clamp_int((int)(var1 * 255.0F), 0, 255);
      int var7 = MathHelper.clamp_int((int)(var2 * 255.0F), 0, 255);
      int var8 = MathHelper.clamp_int((int)(var3 * 255.0F), 0, 255);
      this.putColorRGBA(var5, var6, var7, var8, 255);
   }

   public void setVertexState(WorldRenderer.State var1) {
      this.rawIntBuffer.clear();
      this.growBuffer(var1.getRawBuffer().length);
      this.rawIntBuffer.put(var1.getRawBuffer());
      this.vertexCount = var1.getVertexCount();
      this.vertexFormat = new VertexFormat(var1.getVertexFormat());
      if (WorldRenderer.State.access$0(var1) != null) {
         if (this.quadSprites == null) {
            this.quadSprites = this.quadSpritesPrev;
         }

         if (this.quadSprites == null || this.quadSprites.length < this.getBufferQuadSize()) {
            this.quadSprites = new TextureAtlasSprite[this.getBufferQuadSize()];
         }

         TextureAtlasSprite[] var2 = WorldRenderer.State.access$0(var1);
         System.arraycopy(var2, 0, this.quadSprites, 0, var2.length);
      } else {
         if (this.quadSprites != null) {
            this.quadSpritesPrev = this.quadSprites;
         }

         this.quadSprites = null;
      }

   }

   public void setTranslation(double var1, double var3, double var5) {
      this.xOffset = var1;
      this.yOffset = var3;
      this.zOffset = var5;
   }

   public boolean isDrawing() {
      return this.isDrawing;
   }

   private void growBuffer(int var1) {
      if (var1 > this.rawIntBuffer.remaining()) {
         int var2 = this.byteBuffer.capacity();
         int var3 = var2 % 2097152;
         int var4 = var3 + (((this.rawIntBuffer.position() + var1) * 4 - var3) / 2097152 + 1) * 2097152;
         LogManager.getLogger().warn("Needed to grow BufferBuilder buffer: Old size " + var2 + " bytes, new size " + var4 + " bytes.");
         int var5 = this.rawIntBuffer.position();
         ByteBuffer var6 = GLAllocation.createDirectByteBuffer(var4);
         this.byteBuffer.position(0);
         var6.put(this.byteBuffer);
         var6.rewind();
         this.byteBuffer = var6;
         this.rawFloatBuffer = this.byteBuffer.asFloatBuffer();
         this.rawIntBuffer = this.byteBuffer.asIntBuffer();
         this.rawIntBuffer.position(var5);
         this.rawShortBuffer = this.byteBuffer.asShortBuffer();
         this.rawShortBuffer.position(var5 << 1);
         if (this.quadSprites != null) {
            TextureAtlasSprite[] var7 = this.quadSprites;
            int var8 = this.getBufferQuadSize();
            this.quadSprites = new TextureAtlasSprite[var8];
            System.arraycopy(var7, 0, this.quadSprites, 0, Math.min(var7.length, this.quadSprites.length));
            this.quadSpritesPrev = null;
         }
      }

   }

   public void begin(int var1, VertexFormat var2) {
      if (this.isDrawing) {
         throw new IllegalStateException("Already building!");
      } else {
         this.isDrawing = true;
         this.reset();
         this.drawMode = var1;
         this.vertexFormat = var2;
         this.vertexFormatElement = var2.getElement(this.vertexFormatIndex);
         this.noColor = false;
         this.byteBuffer.limit(this.byteBuffer.capacity());
         if (Config.isShaders()) {
            SVertexBuilder.endSetVertexFormat(this);
         }

         if (Config.isMultiTexture()) {
            if (this.blockLayer != null) {
               if (this.quadSprites == null) {
                  this.quadSprites = this.quadSpritesPrev;
               }

               if (this.quadSprites == null || this.quadSprites.length < this.getBufferQuadSize()) {
                  this.quadSprites = new TextureAtlasSprite[this.getBufferQuadSize()];
               }
            }
         } else {
            if (this.quadSprites != null) {
               this.quadSpritesPrev = this.quadSprites;
            }

            this.quadSprites = null;
         }

      }
   }

   public double getXOffset() {
      return this.xOffset;
   }

   public void putNormal(float var1, float var2, float var3) {
      int var4 = (byte)((int)(var1 * 127.0F)) & 255;
      int var5 = (byte)((int)(var2 * 127.0F)) & 255;
      int var6 = (byte)((int)(var3 * 127.0F)) & 255;
      int var7 = var4 | var5 << 8 | var6 << 16;
      int var8 = this.vertexFormat.getNextOffset() >> 2;
      int var9 = (this.vertexCount - 4) * var8 + this.vertexFormat.getNormalOffset() / 4;
      this.rawIntBuffer.put(var9, var7);
      this.rawIntBuffer.put(var9 + var8, var7);
      this.rawIntBuffer.put(var9 + var8 * 2, var7);
      this.rawIntBuffer.put(var9 + var8 * 3, var7);
   }

   public double getZOffset() {
      return this.zOffset;
   }

   public WorldRenderer normal(float var1, float var2, float var3) {
      int var4 = this.vertexCount * this.vertexFormat.getNextOffset() + this.vertexFormat.getOffset(this.vertexFormatIndex);
      switch($SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType()[this.vertexFormatElement.getType().ordinal()]) {
      case 1:
         this.byteBuffer.putFloat(var4, var1);
         this.byteBuffer.putFloat(var4 + 4, var2);
         this.byteBuffer.putFloat(var4 + 8, var3);
         break;
      case 2:
      case 3:
         this.byteBuffer.put(var4, (byte)((int)(var1 * 127.0F) & 255));
         this.byteBuffer.put(var4 + 1, (byte)((int)(var2 * 127.0F) & 255));
         this.byteBuffer.put(var4 + 2, (byte)((int)(var3 * 127.0F) & 255));
         break;
      case 4:
      case 5:
         this.byteBuffer.putShort(var4, (short)((int)(var1 * 32767.0F) & '\uffff'));
         this.byteBuffer.putShort(var4 + 2, (short)((int)(var2 * 32767.0F) & '\uffff'));
         this.byteBuffer.putShort(var4 + 4, (short)((int)(var3 * 32767.0F) & '\uffff'));
         break;
      case 6:
      case 7:
         this.byteBuffer.putInt(var4, (int)var1);
         this.byteBuffer.putInt(var4 + 4, (int)var2);
         this.byteBuffer.putInt(var4 + 8, (int)var3);
      }

      this.nextVertexFormatIndex();
      return this;
   }

   public void addVertexData(int[] var1) {
      if (Config.isShaders()) {
         SVertexBuilder.beginAddVertexData(this, var1);
      }

      this.growBuffer(var1.length);
      this.rawIntBuffer.position(this.getBufferSize());
      this.rawIntBuffer.put(var1);
      this.vertexCount += var1.length / this.vertexFormat.getIntegerSize();
      if (Config.isShaders()) {
         SVertexBuilder.endAddVertexData(this);
      }

   }

   private int drawForIcon(TextureAtlasSprite var1, int var2) {
      GL11.glBindTexture(3553, var1.glSpriteTextureId);
      int var3 = -1;
      int var4 = -1;
      int var5 = this.vertexCount / 4;

      for(int var6 = var2; var6 < var5; ++var6) {
         TextureAtlasSprite var7 = this.quadSprites[var6];
         if (var7 == var1) {
            if (var4 < 0) {
               var4 = var6;
            }
         } else if (var4 >= 0) {
            this.draw(var4, var6);
            if (this.blockLayer == EnumWorldBlockLayer.TRANSLUCENT) {
               return var6;
            }

            var4 = -1;
            if (var3 < 0) {
               var3 = var6;
            }
         }
      }

      if (var4 >= 0) {
         this.draw(var4, var5);
      }

      if (var3 < 0) {
         var3 = var5;
      }

      return var3;
   }

   public int getColorIndex(int var1) {
      return ((this.vertexCount - var1) * this.vertexFormat.getNextOffset() + this.vertexFormat.getColorOffset()) / 4;
   }

   public void setBlockLayer(EnumWorldBlockLayer var1) {
      this.blockLayer = var1;
      if (var1 == null) {
         if (this.quadSprites != null) {
            this.quadSpritesPrev = this.quadSprites;
         }

         this.quadSprites = null;
         this.quadSprite = null;
      }

   }

   public void endVertex() {
      ++this.vertexCount;
      this.growBuffer(this.vertexFormat.getIntegerSize());
      this.vertexFormatIndex = 0;
      this.vertexFormatElement = this.vertexFormat.getElement(this.vertexFormatIndex);
      if (Config.isShaders()) {
         SVertexBuilder.endAddVertex(this);
      }

   }

   public int getBufferSize() {
      return this.vertexCount * this.vertexFormat.getIntegerSize();
   }

   public void finishDrawing() {
      if (!this.isDrawing) {
         throw new IllegalStateException("Not building!");
      } else {
         this.isDrawing = false;
         this.byteBuffer.position(0);
         this.byteBuffer.limit(this.getBufferSize() * 4);
      }
   }

   public void putBrightness4(int var1, int var2, int var3, int var4) {
      int var5 = (this.vertexCount - 4) * this.vertexFormat.getIntegerSize() + this.vertexFormat.getUvOffsetById(1) / 4;
      int var6 = this.vertexFormat.getNextOffset() >> 2;
      this.rawIntBuffer.put(var5, var1);
      this.rawIntBuffer.put(var5 + var6, var2);
      this.rawIntBuffer.put(var5 + var6 * 2, var3);
      this.rawIntBuffer.put(var5 + var6 * 3, var4);
   }

   public void quadsToTriangles() {
      if (this.drawMode == 7) {
         if (this.byteBufferTriangles == null) {
            this.byteBufferTriangles = GLAllocation.createDirectByteBuffer(this.byteBuffer.capacity() * 2);
         }

         if (this.byteBufferTriangles.capacity() < this.byteBuffer.capacity() * 2) {
            this.byteBufferTriangles = GLAllocation.createDirectByteBuffer(this.byteBuffer.capacity() * 2);
         }

         int var1 = this.vertexFormat.getNextOffset();
         int var2 = this.byteBuffer.limit();
         this.byteBuffer.rewind();
         this.byteBufferTriangles.clear();

         for(int var3 = 0; var3 < this.vertexCount; var3 += 4) {
            this.byteBuffer.limit((var3 + 3) * var1);
            this.byteBuffer.position(var3 * var1);
            this.byteBufferTriangles.put(this.byteBuffer);
            this.byteBuffer.limit((var3 + 1) * var1);
            this.byteBuffer.position(var3 * var1);
            this.byteBufferTriangles.put(this.byteBuffer);
            this.byteBuffer.limit((var3 + 2 + 2) * var1);
            this.byteBuffer.position((var3 + 2) * var1);
            this.byteBufferTriangles.put(this.byteBuffer);
         }

         this.byteBuffer.limit(var2);
         this.byteBuffer.rewind();
         this.byteBufferTriangles.flip();
         this.modeTriangles = true;
      }

   }

   public RenderEnv getRenderEnv(IBlockState var1, BlockPos var2) {
      if (this.renderEnv == null) {
         this.renderEnv = new RenderEnv(var1, var2);
         return this.renderEnv;
      } else {
         this.renderEnv.reset(var1, var2);
         return this.renderEnv;
      }
   }

   public void putSprite(TextureAtlasSprite var1) {
      if (this.animatedSprites != null && var1 != null && var1.getAnimationIndex() >= 0) {
         this.animatedSprites.set(var1.getAnimationIndex());
      }

      if (this.quadSprites != null) {
         int var2 = this.vertexCount / 4;
         this.quadSprites[var2 - 1] = var1;
      }

   }

   public WorldRenderer tex(double var1, double var3) {
      if (this.quadSprite != null && this.quadSprites != null) {
         var1 = (double)this.quadSprite.toSingleU((float)var1);
         var3 = (double)this.quadSprite.toSingleV((float)var3);
         this.quadSprites[this.vertexCount / 4] = this.quadSprite;
      }

      int var5 = this.vertexCount * this.vertexFormat.getNextOffset() + this.vertexFormat.getOffset(this.vertexFormatIndex);
      switch($SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType()[this.vertexFormatElement.getType().ordinal()]) {
      case 1:
         this.byteBuffer.putFloat(var5, (float)var1);
         this.byteBuffer.putFloat(var5 + 4, (float)var3);
         break;
      case 2:
      case 3:
         this.byteBuffer.put(var5, (byte)((int)var3));
         this.byteBuffer.put(var5 + 1, (byte)((int)var1));
         break;
      case 4:
      case 5:
         this.byteBuffer.putShort(var5, (short)((int)var3));
         this.byteBuffer.putShort(var5 + 2, (short)((int)var1));
         break;
      case 6:
      case 7:
         this.byteBuffer.putInt(var5, (int)var1);
         this.byteBuffer.putInt(var5 + 4, (int)var3);
      }

      this.nextVertexFormatIndex();
      return this;
   }

   public double getYOffset() {
      return this.yOffset;
   }

   public WorldRenderer.State getVertexState() {
      this.rawIntBuffer.rewind();
      int var1 = this.getBufferSize();
      this.rawIntBuffer.limit(var1);
      int[] var2 = new int[var1];
      this.rawIntBuffer.get(var2);
      this.rawIntBuffer.limit(this.rawIntBuffer.capacity());
      this.rawIntBuffer.position(var1);
      TextureAtlasSprite[] var3 = null;
      if (this.quadSprites != null) {
         int var4 = this.vertexCount / 4;
         var3 = new TextureAtlasSprite[var4];
         System.arraycopy(this.quadSprites, 0, var3, 0, var4);
      }

      return new WorldRenderer.State(this, var2, new VertexFormat(this.vertexFormat), var3);
   }

   public EnumWorldBlockLayer getBlockLayer() {
      return this.blockLayer;
   }

   private void draw(int var1, int var2) {
      int var3 = var2 - var1;
      if (var3 > 0) {
         int var4 = var1 * 4;
         int var5 = var3 * 4;
         GL11.glDrawArrays(this.drawMode, var4, var5);
      }

   }

   public void putColorMultiplierRgba(float var1, float var2, float var3, float var4, int var5) {
      int var6 = this.getColorIndex(var5);
      int var7 = -1;
      if (!this.noColor) {
         var7 = this.rawIntBuffer.get(var6);
         int var8;
         int var9;
         int var10;
         int var11;
         if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
            var8 = (int)((float)(var7 & 255) * var1);
            var9 = (int)((float)(var7 >> 8 & 255) * var2);
            var10 = (int)((float)(var7 >> 16 & 255) * var3);
            var11 = (int)((float)(var7 >> 24 & 255) * var4);
            var7 = var11 << 24 | var10 << 16 | var9 << 8 | var8;
         } else {
            var8 = (int)((float)(var7 >> 24 & 255) * var1);
            var9 = (int)((float)(var7 >> 16 & 255) * var2);
            var10 = (int)((float)(var7 >> 8 & 255) * var3);
            var11 = (int)((float)(var7 & 255) * var4);
            var7 = var8 << 24 | var9 << 16 | var10 << 8 | var11;
         }
      }

      this.rawIntBuffer.put(var6, var7);
   }

   public int getVertexCount() {
      return this.modeTriangles ? this.vertexCount / 4 * 6 : this.vertexCount;
   }

   public boolean isColorDisabled() {
      return this.noColor;
   }

   private int getBufferQuadSize() {
      int var1 = this.rawIntBuffer.capacity() * 4 / (this.vertexFormat.getIntegerSize() * 4);
      return var1;
   }

   private static float getDistanceSq(FloatBuffer var0, float var1, float var2, float var3, int var4, int var5) {
      float var6 = var0.get(var5 + var4 * 0);
      float var7 = var0.get(var5 + var4 * 0 + 1);
      float var8 = var0.get(var5 + var4 * 0 + 2);
      float var9 = var0.get(var5 + var4 * 1);
      float var10 = var0.get(var5 + var4 * 1 + 1);
      float var11 = var0.get(var5 + var4 * 1 + 2);
      float var12 = var0.get(var5 + var4 * 2);
      float var13 = var0.get(var5 + var4 * 2 + 1);
      float var14 = var0.get(var5 + var4 * 2 + 2);
      float var15 = var0.get(var5 + var4 * 3);
      float var16 = var0.get(var5 + var4 * 3 + 1);
      float var17 = var0.get(var5 + var4 * 3 + 2);
      float var18 = (var6 + var9 + var12 + var15) * 0.25F - var1;
      float var19 = (var7 + var10 + var13 + var16) * 0.25F - var2;
      float var20 = (var8 + var11 + var14 + var17) * 0.25F - var3;
      return var18 * var18 + var19 * var19 + var20 * var20;
   }

   public VertexFormat getVertexFormat() {
      return this.vertexFormat;
   }

   public WorldRenderer color(float var1, float var2, float var3, float var4) {
      return this.color((int)(var1 * 255.0F), (int)(var2 * 255.0F), (int)(var3 * 255.0F), (int)(var4 * 255.0F));
   }

   static int[] $SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType() {
      int[] var10000 = $SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[VertexFormatElement.EnumType.values().length];

         try {
            var0[VertexFormatElement.EnumType.BYTE.ordinal()] = 3;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[VertexFormatElement.EnumType.FLOAT.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[VertexFormatElement.EnumType.INT.ordinal()] = 7;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[VertexFormatElement.EnumType.SHORT.ordinal()] = 5;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[VertexFormatElement.EnumType.UBYTE.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[VertexFormatElement.EnumType.UINT.ordinal()] = 6;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[VertexFormatElement.EnumType.USHORT.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType = var0;
         return var0;
      }
   }

   public ByteBuffer getByteBuffer() {
      return this.modeTriangles ? this.byteBufferTriangles : this.byteBuffer;
   }

   public void reset() {
      this.vertexCount = 0;
      this.vertexFormatElement = null;
      this.vertexFormatIndex = 0;
      this.quadSprite = null;
      if (SmartAnimations.isActive()) {
         if (this.animatedSprites == null) {
            this.animatedSprites = this.animatedSpritesCached;
         }

         this.animatedSprites.clear();
      } else if (this.animatedSprites != null) {
         this.animatedSprites = null;
      }

      this.modeTriangles = false;
   }

   public WorldRenderer pos(double var1, double var3, double var5) {
      if (Config.isShaders()) {
         SVertexBuilder.beginAddVertex(this);
      }

      int var7 = this.vertexCount * this.vertexFormat.getNextOffset() + this.vertexFormat.getOffset(this.vertexFormatIndex);
      switch($SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType()[this.vertexFormatElement.getType().ordinal()]) {
      case 1:
         this.byteBuffer.putFloat(var7, (float)(var1 + this.xOffset));
         this.byteBuffer.putFloat(var7 + 4, (float)(var3 + this.yOffset));
         this.byteBuffer.putFloat(var7 + 8, (float)(var5 + this.zOffset));
         break;
      case 2:
      case 3:
         this.byteBuffer.put(var7, (byte)((int)(var1 + this.xOffset)));
         this.byteBuffer.put(var7 + 1, (byte)((int)(var3 + this.yOffset)));
         this.byteBuffer.put(var7 + 2, (byte)((int)(var5 + this.zOffset)));
         break;
      case 4:
      case 5:
         this.byteBuffer.putShort(var7, (short)((int)(var1 + this.xOffset)));
         this.byteBuffer.putShort(var7 + 2, (short)((int)(var3 + this.yOffset)));
         this.byteBuffer.putShort(var7 + 4, (short)((int)(var5 + this.zOffset)));
         break;
      case 6:
      case 7:
         this.byteBuffer.putInt(var7, Float.floatToRawIntBits((float)(var1 + this.xOffset)));
         this.byteBuffer.putInt(var7 + 4, Float.floatToRawIntBits((float)(var3 + this.yOffset)));
         this.byteBuffer.putInt(var7 + 8, Float.floatToRawIntBits((float)(var5 + this.zOffset)));
      }

      this.nextVertexFormatIndex();
      return this;
   }

   public void putPosition(double var1, double var3, double var5) {
      int var7 = this.vertexFormat.getIntegerSize();
      int var8 = (this.vertexCount - 4) * var7;

      for(int var9 = 0; var9 < 4; ++var9) {
         int var10 = var8 + var9 * var7;
         int var11 = var10 + 1;
         int var12 = var11 + 1;
         this.rawIntBuffer.put(var10, Float.floatToRawIntBits((float)(var1 + this.xOffset) + Float.intBitsToFloat(this.rawIntBuffer.get(var10))));
         this.rawIntBuffer.put(var11, Float.floatToRawIntBits((float)(var3 + this.yOffset) + Float.intBitsToFloat(this.rawIntBuffer.get(var11))));
         this.rawIntBuffer.put(var12, Float.floatToRawIntBits((float)(var5 + this.zOffset) + Float.intBitsToFloat(this.rawIntBuffer.get(var12))));
      }

   }

   public void putColor4(int var1) {
      for(int var2 = 0; var2 < 4; ++var2) {
         this.putColor(var1, var2 + 1);
      }

   }

   public void putColorRGB_F4(float var1, float var2, float var3) {
      for(int var4 = 0; var4 < 4; ++var4) {
         this.putColorRGB_F(var1, var2, var3, var4 + 1);
      }

   }

   public WorldRenderer color(int var1, int var2, int var3, int var4) {
      if (this.noColor) {
         return this;
      } else {
         int var5 = this.vertexCount * this.vertexFormat.getNextOffset() + this.vertexFormat.getOffset(this.vertexFormatIndex);
         switch($SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType()[this.vertexFormatElement.getType().ordinal()]) {
         case 1:
            this.byteBuffer.putFloat(var5, (float)var1 / 255.0F);
            this.byteBuffer.putFloat(var5 + 4, (float)var2 / 255.0F);
            this.byteBuffer.putFloat(var5 + 8, (float)var3 / 255.0F);
            this.byteBuffer.putFloat(var5 + 12, (float)var4 / 255.0F);
            break;
         case 2:
         case 3:
            if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
               this.byteBuffer.put(var5, (byte)var1);
               this.byteBuffer.put(var5 + 1, (byte)var2);
               this.byteBuffer.put(var5 + 2, (byte)var3);
               this.byteBuffer.put(var5 + 3, (byte)var4);
            } else {
               this.byteBuffer.put(var5, (byte)var4);
               this.byteBuffer.put(var5 + 1, (byte)var3);
               this.byteBuffer.put(var5 + 2, (byte)var2);
               this.byteBuffer.put(var5 + 3, (byte)var1);
            }
            break;
         case 4:
         case 5:
            this.byteBuffer.putShort(var5, (short)var1);
            this.byteBuffer.putShort(var5 + 2, (short)var2);
            this.byteBuffer.putShort(var5 + 4, (short)var3);
            this.byteBuffer.putShort(var5 + 6, (short)var4);
            break;
         case 6:
         case 7:
            this.byteBuffer.putFloat(var5, (float)var1);
            this.byteBuffer.putFloat(var5 + 4, (float)var2);
            this.byteBuffer.putFloat(var5 + 8, (float)var3);
            this.byteBuffer.putFloat(var5 + 12, (float)var4);
         }

         this.nextVertexFormatIndex();
         return this;
      }
   }

   public WorldRenderer lightmap(int var1, int var2) {
      int var3 = this.vertexCount * this.vertexFormat.getNextOffset() + this.vertexFormat.getOffset(this.vertexFormatIndex);
      switch($SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType()[this.vertexFormatElement.getType().ordinal()]) {
      case 1:
         this.byteBuffer.putFloat(var3, (float)var1);
         this.byteBuffer.putFloat(var3 + 4, (float)var2);
         break;
      case 2:
      case 3:
         this.byteBuffer.put(var3, (byte)var2);
         this.byteBuffer.put(var3 + 1, (byte)var1);
         break;
      case 4:
      case 5:
         this.byteBuffer.putShort(var3, (short)var2);
         this.byteBuffer.putShort(var3 + 2, (short)var1);
         break;
      case 6:
      case 7:
         this.byteBuffer.putInt(var3, var1);
         this.byteBuffer.putInt(var3 + 4, var2);
      }

      this.nextVertexFormatIndex();
      return this;
   }

   public void noColor() {
      this.noColor = true;
   }

   public void sortVertexData(float var1, float var2, float var3) {
      int var4 = this.vertexCount / 4;
      float[] var5 = new float[var4];

      for(int var6 = 0; var6 < var4; ++var6) {
         var5[var6] = getDistanceSq(this.rawFloatBuffer, (float)((double)var1 + this.xOffset), (float)((double)var2 + this.yOffset), (float)((double)var3 + this.zOffset), this.vertexFormat.getIntegerSize(), var6 * this.vertexFormat.getNextOffset());
      }

      Integer[] var15 = new Integer[var4];

      for(int var7 = 0; var7 < var15.length; ++var7) {
         var15[var7] = var7;
      }

      Arrays.sort(var15, new Comparator<Integer>(this, var5) {
         private final float[] val$afloat;
         final WorldRenderer this$0;

         {
            this.this$0 = var1;
            this.val$afloat = var2;
         }

         public int compare(Object var1, Object var2) {
            return this.compare((Integer)var1, (Integer)var2);
         }

         public int compare(Integer var1, Integer var2) {
            return Floats.compare(this.val$afloat[var2], this.val$afloat[var1]);
         }
      });
      BitSet var16 = new BitSet();
      int var8 = this.vertexFormat.getNextOffset();
      int[] var9 = new int[var8];

      int var11;
      int var12;
      int var13;
      for(int var10 = 0; (var10 = var16.nextClearBit(var10)) < var15.length; ++var10) {
         var11 = var15[var10];
         if (var11 != var10) {
            this.rawIntBuffer.limit(var11 * var8 + var8);
            this.rawIntBuffer.position(var11 * var8);
            this.rawIntBuffer.get(var9);
            var12 = var11;

            for(var13 = var15[var11]; var12 != var10; var13 = var15[var13]) {
               this.rawIntBuffer.limit(var13 * var8 + var8);
               this.rawIntBuffer.position(var13 * var8);
               IntBuffer var14 = this.rawIntBuffer.slice();
               this.rawIntBuffer.limit(var12 * var8 + var8);
               this.rawIntBuffer.position(var12 * var8);
               this.rawIntBuffer.put(var14);
               var16.set(var12);
               var12 = var13;
            }

            this.rawIntBuffer.limit(var10 * var8 + var8);
            this.rawIntBuffer.position(var10 * var8);
            this.rawIntBuffer.put(var9);
         }

         var16.set(var10);
      }

      this.rawIntBuffer.limit(this.rawIntBuffer.capacity());
      this.rawIntBuffer.position(this.getBufferSize());
      if (this.quadSprites != null) {
         TextureAtlasSprite[] var17 = new TextureAtlasSprite[this.vertexCount / 4];
         var11 = this.vertexFormat.getNextOffset() / 4 * 4;

         for(var12 = 0; var12 < var15.length; ++var12) {
            var13 = var15[var12];
            var17[var12] = this.quadSprites[var13];
         }

         System.arraycopy(var17, 0, this.quadSprites, 0, var17.length);
      }

   }

   public void putColorRGBA(int var1, int var2, int var3, int var4, int var5) {
      if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
         this.rawIntBuffer.put(var1, var5 << 24 | var4 << 16 | var3 << 8 | var2);
      } else {
         this.rawIntBuffer.put(var1, var2 << 24 | var3 << 16 | var4 << 8 | var5);
      }

   }

   private void putColor(int var1, int var2) {
      int var3 = this.getColorIndex(var2);
      int var4 = var1 >> 16 & 255;
      int var5 = var1 >> 8 & 255;
      int var6 = var1 & 255;
      int var7 = var1 >> 24 & 255;
      this.putColorRGBA(var3, var4, var5, var6, var7);
   }

   public void putColorMultiplier(float var1, float var2, float var3, int var4) {
      int var5 = this.getColorIndex(var4);
      int var6 = -1;
      if (!this.noColor) {
         var6 = this.rawIntBuffer.get(var5);
         int var7;
         int var8;
         int var9;
         if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
            var7 = (int)((float)(var6 & 255) * var1);
            var8 = (int)((float)(var6 >> 8 & 255) * var2);
            var9 = (int)((float)(var6 >> 16 & 255) * var3);
            var6 &= -16777216;
            var6 = var6 | var9 << 16 | var8 << 8 | var7;
         } else {
            var7 = (int)((float)(var6 >> 24 & 255) * var1);
            var8 = (int)((float)(var6 >> 16 & 255) * var2);
            var9 = (int)((float)(var6 >> 8 & 255) * var3);
            var6 &= 255;
            var6 = var6 | var7 << 24 | var8 << 16 | var9 << 8;
         }
      }

      this.rawIntBuffer.put(var5, var6);
   }

   public class State {
      private final VertexFormat stateVertexFormat;
      private TextureAtlasSprite[] stateQuadSprites;
      private final int[] stateRawBuffer;
      final WorldRenderer this$0;

      public VertexFormat getVertexFormat() {
         return this.stateVertexFormat;
      }

      static TextureAtlasSprite[] access$0(WorldRenderer.State var0) {
         return var0.stateQuadSprites;
      }

      public int getVertexCount() {
         return this.stateRawBuffer.length / this.stateVertexFormat.getIntegerSize();
      }

      public State(WorldRenderer var1, int[] var2, VertexFormat var3) {
         this.this$0 = var1;
         this.stateRawBuffer = var2;
         this.stateVertexFormat = var3;
      }

      public State(WorldRenderer var1, int[] var2, VertexFormat var3, TextureAtlasSprite[] var4) {
         this.this$0 = var1;
         this.stateRawBuffer = var2;
         this.stateVertexFormat = var3;
         this.stateQuadSprites = var4;
      }

      public int[] getRawBuffer() {
         return this.stateRawBuffer;
      }
   }
}
