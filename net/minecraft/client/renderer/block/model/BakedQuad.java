package net.minecraft.client.renderer.block.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.src.Config;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.model.pipeline.IVertexConsumer;
import net.minecraftforge.client.model.pipeline.IVertexProducer;
import net.optifine.model.QuadBounds;
import net.optifine.reflect.Reflector;

public class BakedQuad implements IVertexProducer {
   private BakedQuad quadEmissive;
   protected TextureAtlasSprite sprite;
   private int[] vertexDataSingle = null;
   protected EnumFacing face;
   private boolean quadEmissiveChecked;
   private QuadBounds quadBounds;
   protected int[] vertexData;
   protected final int tintIndex;

   public BakedQuad getQuadEmissive() {
      if (this.quadEmissiveChecked) {
         return this.quadEmissive;
      } else {
         if (this.quadEmissive == null && this.sprite != null && this.sprite.spriteEmissive != null) {
            this.quadEmissive = new BreakingFour(this, this.sprite.spriteEmissive);
         }

         this.quadEmissiveChecked = true;
         return this.quadEmissive;
      }
   }

   protected void fixVertexData() {
      if (Config.isShaders()) {
         if (this.vertexData.length == 28) {
            this.vertexData = expandVertexData(this.vertexData);
         }
      } else if (this.vertexData.length == 56) {
         this.vertexData = compactVertexData(this.vertexData);
      }

   }

   public int[] getVertexData() {
      this.fixVertexData();
      return this.vertexData;
   }

   public BakedQuad(int[] var1, int var2, EnumFacing var3, TextureAtlasSprite var4) {
      this.vertexData = var1;
      this.tintIndex = var2;
      this.face = var3;
      this.sprite = var4;
      this.fixVertexData();
   }

   private static int[] expandVertexData(int[] var0) {
      int var1 = var0.length / 4;
      int var2 = var1 * 2;
      int[] var3 = new int[var2 * 4];

      for(int var4 = 0; var4 < 4; ++var4) {
         System.arraycopy(var0, var4 * var1, var3, var4 * var2, var1);
      }

      return var3;
   }

   public int getTintIndex() {
      return this.tintIndex;
   }

   private static int[] makeVertexDataSingle(int[] var0, TextureAtlasSprite var1) {
      int[] var2 = (int[])var0.clone();
      int var3 = var1.sheetWidth / var1.getIconWidth();
      int var4 = var1.sheetHeight / var1.getIconHeight();
      int var5 = var2.length / 4;

      for(int var6 = 0; var6 < 4; ++var6) {
         int var7 = var6 * var5;
         float var8 = Float.intBitsToFloat(var2[var7 + 4]);
         float var9 = Float.intBitsToFloat(var2[var7 + 4 + 1]);
         float var10 = var1.toSingleU(var8);
         float var11 = var1.toSingleV(var9);
         var2[var7 + 4] = Float.floatToRawIntBits(var10);
         var2[var7 + 4 + 1] = Float.floatToRawIntBits(var11);
      }

      return var2;
   }

   public BakedQuad(int[] var1, int var2, EnumFacing var3) {
      this.vertexData = var1;
      this.tintIndex = var2;
      this.face = var3;
      this.fixVertexData();
   }

   public boolean hasTintIndex() {
      return this.tintIndex != -1;
   }

   public void pipe(IVertexConsumer var1) {
      Reflector.callVoid(Reflector.LightUtil_putBakedQuad, var1, this);
   }

   public int[] getVertexDataSingle() {
      if (this.vertexDataSingle == null) {
         this.vertexDataSingle = makeVertexDataSingle(this.getVertexData(), this.getSprite());
      }

      return this.vertexDataSingle;
   }

   public boolean isFullQuad() {
      QuadBounds var1 = this.getQuadBounds();
      return var1.isFullQuad(this.face);
   }

   public double getMidY() {
      QuadBounds var1 = this.getQuadBounds();
      return (double)((var1.getMaxY() + var1.getMinY()) / 2.0F);
   }

   public EnumFacing getFace() {
      if (this.face == null) {
         this.face = FaceBakery.getFacingFromVertexData(this.getVertexData());
      }

      return this.face;
   }

   public String toString() {
      return "vertex: " + this.vertexData.length / 7 + ", tint: " + this.tintIndex + ", facing: " + this.face + ", sprite: " + this.sprite;
   }

   public float getMidX() {
      QuadBounds var1 = this.getQuadBounds();
      return (var1.getMaxX() + var1.getMinX()) / 2.0F;
   }

   public QuadBounds getQuadBounds() {
      if (this.quadBounds == null) {
         this.quadBounds = new QuadBounds(this.getVertexData());
      }

      return this.quadBounds;
   }

   private static int[] compactVertexData(int[] var0) {
      int var1 = var0.length / 4;
      int var2 = var1 / 2;
      int[] var3 = new int[var2 * 4];

      for(int var4 = 0; var4 < 4; ++var4) {
         System.arraycopy(var0, var4 * var1, var3, var4 * var2, var2);
      }

      return var3;
   }

   public TextureAtlasSprite getSprite() {
      if (this.sprite == null) {
         this.sprite = getSpriteByUv(this.getVertexData());
      }

      return this.sprite;
   }

   public boolean isFullFaceQuad() {
      return this.isFullQuad() && this.isFaceQuad();
   }

   public double getMidZ() {
      QuadBounds var1 = this.getQuadBounds();
      return (double)((var1.getMaxZ() + var1.getMinZ()) / 2.0F);
   }

   public boolean isFaceQuad() {
      QuadBounds var1 = this.getQuadBounds();
      return var1.isFaceQuad(this.face);
   }

   private static TextureAtlasSprite getSpriteByUv(int[] var0) {
      float var1 = 1.0F;
      float var2 = 1.0F;
      float var3 = 0.0F;
      float var4 = 0.0F;
      int var5 = var0.length / 4;

      for(int var6 = 0; var6 < 4; ++var6) {
         int var7 = var6 * var5;
         float var8 = Float.intBitsToFloat(var0[var7 + 4]);
         float var9 = Float.intBitsToFloat(var0[var7 + 4 + 1]);
         var1 = Math.min(var1, var8);
         var2 = Math.min(var2, var9);
         var3 = Math.max(var3, var8);
         var4 = Math.max(var4, var9);
      }

      float var10 = (var1 + var3) / 2.0F;
      float var11 = (var2 + var4) / 2.0F;
      TextureAtlasSprite var12 = Minecraft.getMinecraft().getTextureMapBlocks().getIconByUV((double)var10, (double)var11);
      return var12;
   }
}
