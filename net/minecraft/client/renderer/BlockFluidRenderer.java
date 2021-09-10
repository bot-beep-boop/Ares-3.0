package net.minecraft.client.renderer;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.FaceBakery;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.src.Config;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.optifine.CustomColors;
import net.optifine.render.RenderEnv;
import net.optifine.shaders.SVertexBuilder;

public class BlockFluidRenderer {
   private TextureAtlasSprite[] atlasSpritesWater = new TextureAtlasSprite[2];
   private TextureAtlasSprite[] atlasSpritesLava = new TextureAtlasSprite[2];

   public boolean renderFluid(IBlockAccess var1, IBlockState var2, BlockPos var3, WorldRenderer var4) {
      boolean var5;
      try {
         if (Config.isShaders()) {
            SVertexBuilder.pushEntity(var2, var3, var1, var4);
         }

         BlockLiquid var6 = (BlockLiquid)var2.getBlock();
         var6.setBlockBoundsBasedOnState(var1, var3);
         TextureAtlasSprite[] var7 = var6.getMaterial() == Material.lava ? this.atlasSpritesLava : this.atlasSpritesWater;
         RenderEnv var8 = var4.getRenderEnv(var2, var3);
         int var9 = CustomColors.getFluidColor(var1, var2, var3, var8);
         float var10 = (float)(var9 >> 16 & 255) / 255.0F;
         float var11 = (float)(var9 >> 8 & 255) / 255.0F;
         float var12 = (float)(var9 & 255) / 255.0F;
         boolean var13 = var6.shouldSideBeRendered(var1, var3.up(), EnumFacing.UP);
         boolean var14 = var6.shouldSideBeRendered(var1, var3.down(), EnumFacing.DOWN);
         boolean[] var15 = var8.getBorderFlags();
         var15[0] = var6.shouldSideBeRendered(var1, var3.north(), EnumFacing.NORTH);
         var15[1] = var6.shouldSideBeRendered(var1, var3.south(), EnumFacing.SOUTH);
         var15[2] = var6.shouldSideBeRendered(var1, var3.west(), EnumFacing.WEST);
         var15[3] = var6.shouldSideBeRendered(var1, var3.east(), EnumFacing.EAST);
         if (var13 || var14 || var15[0] || var15[1] || var15[2] || var15[3]) {
            var5 = false;
            float var16 = 0.5F;
            float var17 = 1.0F;
            float var18 = 0.8F;
            float var19 = 0.6F;
            Material var20 = var6.getMaterial();
            float var21 = this.getFluidHeight(var1, var3, var20);
            float var22 = this.getFluidHeight(var1, var3.south(), var20);
            float var23 = this.getFluidHeight(var1, var3.east().south(), var20);
            float var24 = this.getFluidHeight(var1, var3.east(), var20);
            double var25 = (double)var3.getX();
            double var27 = (double)var3.getY();
            double var29 = (double)var3.getZ();
            float var31 = 0.001F;
            float var33;
            float var34;
            float var35;
            float var37;
            float var38;
            float var39;
            float var47;
            if (var13) {
               var5 = true;
               TextureAtlasSprite var32 = var7[0];
               var33 = (float)BlockLiquid.getFlowDirection(var1, var3, var20);
               if (var33 > -999.0F) {
                  var32 = var7[1];
               }

               var4.setSprite(var32);
               var21 -= var31;
               var22 -= var31;
               var23 -= var31;
               var24 -= var31;
               float var36;
               float var40;
               float var41;
               if (var33 < -999.0F) {
                  var34 = var32.getInterpolatedU(0.0D);
                  var38 = var32.getInterpolatedV(0.0D);
                  var35 = var34;
                  var39 = var32.getInterpolatedV(16.0D);
                  var36 = var32.getInterpolatedU(16.0D);
                  var40 = var39;
                  var37 = var36;
                  var41 = var38;
               } else {
                  float var42 = MathHelper.sin(var33) * 0.25F;
                  float var43 = MathHelper.cos(var33) * 0.25F;
                  float var44 = 8.0F;
                  var34 = var32.getInterpolatedU((double)(8.0F + (-var43 - var42) * 16.0F));
                  var38 = var32.getInterpolatedV((double)(8.0F + (-var43 + var42) * 16.0F));
                  var35 = var32.getInterpolatedU((double)(8.0F + (-var43 + var42) * 16.0F));
                  var39 = var32.getInterpolatedV((double)(8.0F + (var43 + var42) * 16.0F));
                  var36 = var32.getInterpolatedU((double)(8.0F + (var43 + var42) * 16.0F));
                  var40 = var32.getInterpolatedV((double)(8.0F + (var43 - var42) * 16.0F));
                  var37 = var32.getInterpolatedU((double)(8.0F + (var43 - var42) * 16.0F));
                  var41 = var32.getInterpolatedV((double)(8.0F + (-var43 - var42) * 16.0F));
               }

               int var74 = var6.getMixedBrightnessForBlock(var1, var3);
               int var75 = var74 >> 16 & '\uffff';
               int var77 = var74 & '\uffff';
               float var45 = var17 * var10;
               float var46 = var17 * var11;
               var47 = var17 * var12;
               var4.pos(var25 + 0.0D, var27 + (double)var21, var29 + 0.0D).color(var45, var46, var47, 1.0F).tex((double)var34, (double)var38).lightmap(var75, var77).endVertex();
               var4.pos(var25 + 0.0D, var27 + (double)var22, var29 + 1.0D).color(var45, var46, var47, 1.0F).tex((double)var35, (double)var39).lightmap(var75, var77).endVertex();
               var4.pos(var25 + 1.0D, var27 + (double)var23, var29 + 1.0D).color(var45, var46, var47, 1.0F).tex((double)var36, (double)var40).lightmap(var75, var77).endVertex();
               var4.pos(var25 + 1.0D, var27 + (double)var24, var29 + 0.0D).color(var45, var46, var47, 1.0F).tex((double)var37, (double)var41).lightmap(var75, var77).endVertex();
               if (var6.shouldRenderSides(var1, var3.up())) {
                  var4.pos(var25 + 0.0D, var27 + (double)var21, var29 + 0.0D).color(var45, var46, var47, 1.0F).tex((double)var34, (double)var38).lightmap(var75, var77).endVertex();
                  var4.pos(var25 + 1.0D, var27 + (double)var24, var29 + 0.0D).color(var45, var46, var47, 1.0F).tex((double)var37, (double)var41).lightmap(var75, var77).endVertex();
                  var4.pos(var25 + 1.0D, var27 + (double)var23, var29 + 1.0D).color(var45, var46, var47, 1.0F).tex((double)var36, (double)var40).lightmap(var75, var77).endVertex();
                  var4.pos(var25 + 0.0D, var27 + (double)var22, var29 + 1.0D).color(var45, var46, var47, 1.0F).tex((double)var35, (double)var39).lightmap(var75, var77).endVertex();
               }
            }

            if (var14) {
               var4.setSprite(var7[0]);
               float var63 = var7[0].getMinU();
               var33 = var7[0].getMaxU();
               var34 = var7[0].getMinV();
               var35 = var7[0].getMaxV();
               int var68 = var6.getMixedBrightnessForBlock(var1, var3.down());
               int var70 = var68 >> 16 & '\uffff';
               int var71 = var68 & '\uffff';
               var39 = FaceBakery.getFaceBrightness(EnumFacing.DOWN);
               var4.pos(var25, var27, var29 + 1.0D).color(var10 * var39, var11 * var39, var12 * var39, 1.0F).tex((double)var63, (double)var35).lightmap(var70, var71).endVertex();
               var4.pos(var25, var27, var29).color(var10 * var39, var11 * var39, var12 * var39, 1.0F).tex((double)var63, (double)var34).lightmap(var70, var71).endVertex();
               var4.pos(var25 + 1.0D, var27, var29).color(var10 * var39, var11 * var39, var12 * var39, 1.0F).tex((double)var33, (double)var34).lightmap(var70, var71).endVertex();
               var4.pos(var25 + 1.0D, var27, var29 + 1.0D).color(var10 * var39, var11 * var39, var12 * var39, 1.0F).tex((double)var33, (double)var35).lightmap(var70, var71).endVertex();
               var5 = true;
            }

            for(int var64 = 0; var64 < 4; ++var64) {
               int var65 = 0;
               int var66 = 0;
               if (var64 == 0) {
                  --var66;
               }

               if (var64 == 1) {
                  ++var66;
               }

               if (var64 == 2) {
                  --var65;
               }

               if (var64 == 3) {
                  ++var65;
               }

               BlockPos var67 = var3.add(var65, 0, var66);
               TextureAtlasSprite var69 = var7[1];
               var4.setSprite(var69);
               if (var15[var64]) {
                  double var72;
                  double var73;
                  double var76;
                  double var78;
                  if (var64 == 0) {
                     var37 = var21;
                     var38 = var24;
                     var72 = var25;
                     var76 = var25 + 1.0D;
                     var73 = var29 + (double)var31;
                     var78 = var29 + (double)var31;
                  } else if (var64 == 1) {
                     var37 = var23;
                     var38 = var22;
                     var72 = var25 + 1.0D;
                     var76 = var25;
                     var73 = var29 + 1.0D - (double)var31;
                     var78 = var29 + 1.0D - (double)var31;
                  } else if (var64 == 2) {
                     var37 = var22;
                     var38 = var21;
                     var72 = var25 + (double)var31;
                     var76 = var25 + (double)var31;
                     var73 = var29 + 1.0D;
                     var78 = var29;
                  } else {
                     var37 = var24;
                     var38 = var23;
                     var72 = var25 + 1.0D - (double)var31;
                     var76 = var25 + 1.0D - (double)var31;
                     var73 = var29;
                     var78 = var29 + 1.0D;
                  }

                  var5 = true;
                  var47 = var69.getInterpolatedU(0.0D);
                  float var48 = var69.getInterpolatedU(8.0D);
                  float var49 = var69.getInterpolatedV((double)((1.0F - var37) * 16.0F * 0.5F));
                  float var50 = var69.getInterpolatedV((double)((1.0F - var38) * 16.0F * 0.5F));
                  float var51 = var69.getInterpolatedV(8.0D);
                  int var52 = var6.getMixedBrightnessForBlock(var1, var67);
                  int var53 = var52 >> 16 & '\uffff';
                  int var54 = var52 & '\uffff';
                  float var55 = var64 < 2 ? FaceBakery.getFaceBrightness(EnumFacing.NORTH) : FaceBakery.getFaceBrightness(EnumFacing.WEST);
                  float var56 = var17 * var55 * var10;
                  float var57 = var17 * var55 * var11;
                  float var58 = var17 * var55 * var12;
                  var4.pos(var72, var27 + (double)var37, var73).color(var56, var57, var58, 1.0F).tex((double)var47, (double)var49).lightmap(var53, var54).endVertex();
                  var4.pos(var76, var27 + (double)var38, var78).color(var56, var57, var58, 1.0F).tex((double)var48, (double)var50).lightmap(var53, var54).endVertex();
                  var4.pos(var76, var27 + 0.0D, var78).color(var56, var57, var58, 1.0F).tex((double)var48, (double)var51).lightmap(var53, var54).endVertex();
                  var4.pos(var72, var27 + 0.0D, var73).color(var56, var57, var58, 1.0F).tex((double)var47, (double)var51).lightmap(var53, var54).endVertex();
                  var4.pos(var72, var27 + 0.0D, var73).color(var56, var57, var58, 1.0F).tex((double)var47, (double)var51).lightmap(var53, var54).endVertex();
                  var4.pos(var76, var27 + 0.0D, var78).color(var56, var57, var58, 1.0F).tex((double)var48, (double)var51).lightmap(var53, var54).endVertex();
                  var4.pos(var76, var27 + (double)var38, var78).color(var56, var57, var58, 1.0F).tex((double)var48, (double)var50).lightmap(var53, var54).endVertex();
                  var4.pos(var72, var27 + (double)var37, var73).color(var56, var57, var58, 1.0F).tex((double)var47, (double)var49).lightmap(var53, var54).endVertex();
               }
            }

            var4.setSprite((TextureAtlasSprite)null);
            boolean var60 = var5;
            return var60;
         }

         var5 = false;
      } finally {
         if (Config.isShaders()) {
            SVertexBuilder.popEntity(var4);
         }

      }

      return var5;
   }

   public BlockFluidRenderer() {
      this.initAtlasSprites();
   }

   private float getFluidHeight(IBlockAccess var1, BlockPos var2, Material var3) {
      int var4 = 0;
      float var5 = 0.0F;

      for(int var6 = 0; var6 < 4; ++var6) {
         BlockPos var7 = var2.add(-(var6 & 1), 0, -(var6 >> 1 & 1));
         if (var1.getBlockState(var7.up()).getBlock().getMaterial() == var3) {
            return 1.0F;
         }

         IBlockState var8 = var1.getBlockState(var7);
         Material var9 = var8.getBlock().getMaterial();
         if (var9 != var3) {
            if (!var9.isSolid()) {
               ++var5;
               ++var4;
            }
         } else {
            int var10 = (Integer)var8.getValue(BlockLiquid.LEVEL);
            if (var10 >= 8 || var10 == 0) {
               var5 += BlockLiquid.getLiquidHeightPercent(var10) * 10.0F;
               var4 += 10;
            }

            var5 += BlockLiquid.getLiquidHeightPercent(var10);
            ++var4;
         }
      }

      return 1.0F - var5 / (float)var4;
   }

   protected void initAtlasSprites() {
      TextureMap var1 = Minecraft.getMinecraft().getTextureMapBlocks();
      this.atlasSpritesLava[0] = var1.getAtlasSprite("minecraft:blocks/lava_still");
      this.atlasSpritesLava[1] = var1.getAtlasSprite("minecraft:blocks/lava_flow");
      this.atlasSpritesWater[0] = var1.getAtlasSprite("minecraft:blocks/water_still");
      this.atlasSpritesWater[1] = var1.getAtlasSprite("minecraft:blocks/water_flow");
   }
}
