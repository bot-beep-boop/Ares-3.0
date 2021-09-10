package net.optifine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockNewLeaf;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.src.Config;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.optifine.model.ModelUtils;

public class SmartLeaves {
   private static IBakedModel modelLeavesDoubleOak = null;
   private static IBakedModel modelLeavesCullBirch = null;
   private static IBakedModel modelLeavesDoubleBirch = null;
   private static List generalQuadsCullOak = null;
   private static IBakedModel modelLeavesCullAcacia = null;
   private static IBakedModel modelLeavesDoubleAcacia = null;
   private static IBakedModel modelLeavesDoubleDarkOak = null;
   private static List generalQuadsCullBirch = null;
   private static List generalQuadsCullSpruce = null;
   private static IBakedModel modelLeavesDoubleSpruce = null;
   private static List generalQuadsCullJungle = null;
   private static List generalQuadsCullDarkOak = null;
   private static IBakedModel modelLeavesCullSpruce = null;
   private static IBakedModel modelLeavesCullOak = null;
   private static IBakedModel modelLeavesCullJungle = null;
   private static IBakedModel modelLeavesCullDarkOak = null;
   private static List generalQuadsCullAcacia = null;
   private static IBakedModel modelLeavesDoubleJungle = null;

   public static boolean isSameLeaves(IBlockState var0, IBlockState var1) {
      if (var0 == var1) {
         return true;
      } else {
         Block var2 = var0.getBlock();
         Block var3 = var1.getBlock();
         if (var2 != var3) {
            return false;
         } else if (var2 instanceof BlockOldLeaf) {
            return ((BlockPlanks.EnumType)var0.getValue(BlockOldLeaf.VARIANT)).equals(var1.getValue(BlockOldLeaf.VARIANT));
         } else {
            return var2 instanceof BlockNewLeaf ? ((BlockPlanks.EnumType)var0.getValue(BlockNewLeaf.VARIANT)).equals(var1.getValue(BlockNewLeaf.VARIANT)) : false;
         }
      }
   }

   static IBakedModel getModelCull(String var0, List var1) {
      ModelManager var2 = Config.getModelManager();
      if (var2 == null) {
         return null;
      } else {
         ResourceLocation var3 = new ResourceLocation("blockstates/" + var0 + "_leaves.json");
         if (Config.getDefiningResourcePack(var3) != Config.getDefaultResourcePack()) {
            return null;
         } else {
            ResourceLocation var4 = new ResourceLocation("models/block/" + var0 + "_leaves.json");
            if (Config.getDefiningResourcePack(var4) != Config.getDefaultResourcePack()) {
               return null;
            } else {
               ModelResourceLocation var5 = new ModelResourceLocation(var0 + "_leaves", "normal");
               IBakedModel var6 = var2.getModel(var5);
               if (var6 != null && var6 != var2.getMissingModel()) {
                  List var7 = var6.getGeneralQuads();
                  if (var7.size() == 0) {
                     return var6;
                  } else if (var7.size() != 6) {
                     return null;
                  } else {
                     Iterator var9 = var7.iterator();

                     while(var9.hasNext()) {
                        Object var8 = var9.next();
                        BakedQuad var10 = (BakedQuad)var8;
                        List var11 = var6.getFaceQuads(var10.getFace());
                        if (var11.size() > 0) {
                           return null;
                        }

                        var11.add(var10);
                     }

                     var7.clear();
                     var1.add(var0 + "_leaves");
                     return var6;
                  }
               } else {
                  return null;
               }
            }
         }
      }
   }

   public static IBakedModel getLeavesModel(IBakedModel var0, IBlockState var1) {
      if (!Config.isTreesSmart()) {
         return var0;
      } else {
         List var2 = var0.getGeneralQuads();
         if (var2 == generalQuadsCullAcacia) {
            return modelLeavesDoubleAcacia;
         } else if (var2 == generalQuadsCullBirch) {
            return modelLeavesDoubleBirch;
         } else if (var2 == generalQuadsCullDarkOak) {
            return modelLeavesDoubleDarkOak;
         } else if (var2 == generalQuadsCullJungle) {
            return modelLeavesDoubleJungle;
         } else if (var2 == generalQuadsCullOak) {
            return modelLeavesDoubleOak;
         } else {
            return var2 == generalQuadsCullSpruce ? modelLeavesDoubleSpruce : var0;
         }
      }
   }

   private static List getGeneralQuadsSafe(IBakedModel var0) {
      return var0 == null ? null : var0.getGeneralQuads();
   }

   private static IBakedModel getModelDoubleFace(IBakedModel var0) {
      if (var0 == null) {
         return null;
      } else if (var0.getGeneralQuads().size() > 0) {
         Config.warn("SmartLeaves: Model is not cube, general quads: " + var0.getGeneralQuads().size() + ", model: " + var0);
         return var0;
      } else {
         EnumFacing[] var1 = EnumFacing.VALUES;

         for(int var2 = 0; var2 < var1.length; ++var2) {
            EnumFacing var3 = var1[var2];
            List var4 = var0.getFaceQuads(var3);
            if (var4.size() != 1) {
               Config.warn("SmartLeaves: Model is not cube, side: " + var3 + ", quads: " + var4.size() + ", model: " + var0);
               return var0;
            }
         }

         IBakedModel var12 = ModelUtils.duplicateModel(var0);
         List[] var13 = new List[var1.length];

         for(int var14 = 0; var14 < var1.length; ++var14) {
            EnumFacing var5 = var1[var14];
            List var6 = var12.getFaceQuads(var5);
            BakedQuad var7 = (BakedQuad)var6.get(0);
            BakedQuad var8 = new BakedQuad((int[])var7.getVertexData().clone(), var7.getTintIndex(), var7.getFace(), var7.getSprite());
            int[] var9 = var8.getVertexData();
            int[] var10 = (int[])var9.clone();
            int var11 = var9.length / 4;
            System.arraycopy(var9, 0 * var11, var10, 3 * var11, var11);
            System.arraycopy(var9, 1 * var11, var10, 2 * var11, var11);
            System.arraycopy(var9, 2 * var11, var10, 1 * var11, var11);
            System.arraycopy(var9, 3 * var11, var10, 0 * var11, var11);
            System.arraycopy(var10, 0, var9, 0, var10.length);
            var6.add(var8);
         }

         return var12;
      }
   }

   public static void updateLeavesModels() {
      ArrayList var0 = new ArrayList();
      modelLeavesCullAcacia = getModelCull("acacia", var0);
      modelLeavesCullBirch = getModelCull("birch", var0);
      modelLeavesCullDarkOak = getModelCull("dark_oak", var0);
      modelLeavesCullJungle = getModelCull("jungle", var0);
      modelLeavesCullOak = getModelCull("oak", var0);
      modelLeavesCullSpruce = getModelCull("spruce", var0);
      generalQuadsCullAcacia = getGeneralQuadsSafe(modelLeavesCullAcacia);
      generalQuadsCullBirch = getGeneralQuadsSafe(modelLeavesCullBirch);
      generalQuadsCullDarkOak = getGeneralQuadsSafe(modelLeavesCullDarkOak);
      generalQuadsCullJungle = getGeneralQuadsSafe(modelLeavesCullJungle);
      generalQuadsCullOak = getGeneralQuadsSafe(modelLeavesCullOak);
      generalQuadsCullSpruce = getGeneralQuadsSafe(modelLeavesCullSpruce);
      modelLeavesDoubleAcacia = getModelDoubleFace(modelLeavesCullAcacia);
      modelLeavesDoubleBirch = getModelDoubleFace(modelLeavesCullBirch);
      modelLeavesDoubleDarkOak = getModelDoubleFace(modelLeavesCullDarkOak);
      modelLeavesDoubleJungle = getModelDoubleFace(modelLeavesCullJungle);
      modelLeavesDoubleOak = getModelDoubleFace(modelLeavesCullOak);
      modelLeavesDoubleSpruce = getModelDoubleFace(modelLeavesCullSpruce);
      if (var0.size() > 0) {
         Config.dbg("Enable face culling: " + Config.arrayToString(var0.toArray()));
      }

   }
}
