package net.optifine.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.src.Config;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.optifine.entity.model.CustomEntityModelParser;
import net.optifine.util.Json;

public class PlayerItemParser {
   public static final String MODEL_TEXTURE = "texture";
   public static final String MODEL_BASE_ID = "baseId";
   public static final String MODEL_SCALE = "scale";
   public static final String BOX_UV_DOWN = "uvDown";
   public static final String BOX_TEXTURE_OFFSET = "textureOffset";
   public static final String ITEM_TYPE = "type";
   public static final String BOX_SIZE_ADD = "sizeAdd";
   public static final String MODEL_TYPE_BOX = "ModelBox";
   public static final String BOX_UV_EAST = "uvEast";
   public static final String BOX_UV_RIGHT = "uvRight";
   public static final String BOX_UV_NORTH = "uvNorth";
   public static final String MODEL_SUBMODEL = "submodel";
   public static final String ITEM_MODELS = "models";
   public static final String MODEL_TRANSLATE = "translate";
   public static final String BOX_UV_SOUTH = "uvSouth";
   public static final String BOX_UV_LEFT = "uvLeft";
   public static final String MODEL_MIRROR_TEXTURE = "mirrorTexture";
   public static final String ITEM_TEXTURE_SIZE = "textureSize";
   private static JsonParser jsonParser = new JsonParser();
   public static final String MODEL_BOXES = "boxes";
   public static final String MODEL_ID = "id";
   public static final String MODEL_ROTATE = "rotate";
   public static final String MODEL_TEXTURE_SIZE = "textureSize";
   public static final String BOX_UV_WEST = "uvWest";
   public static final String BOX_UV_BACK = "uvBack";
   public static final String BOX_COORDINATES = "coordinates";
   public static final String BOX_UV_FRONT = "uvFront";
   public static final String MODEL_TYPE = "type";
   public static final String MODEL_INVERT_AXIS = "invertAxis";
   public static final String ITEM_TYPE_MODEL = "PlayerItem";
   public static final String MODEL_SUBMODELS = "submodels";
   public static final String MODEL_ATTACH_TO = "attachTo";
   public static final String BOX_UV_UP = "uvUp";
   public static final String MODEL_SPRITES = "sprites";
   public static final String ITEM_USE_PLAYER_TEXTURE = "usePlayerTexture";

   public static ModelRenderer parseModelRenderer(JsonObject var0, ModelBase var1, int[] var2, String var3) {
      ModelRenderer var4 = new ModelRenderer(var1);
      String var5 = Json.getString(var0, "id");
      var4.setId(var5);
      float var6 = Json.getFloat(var0, "scale", 1.0F);
      var4.scaleX = var6;
      var4.scaleY = var6;
      var4.scaleZ = var6;
      String var7 = Json.getString(var0, "texture");
      if (var7 != null) {
         var4.setTextureLocation(CustomEntityModelParser.getResourceLocation(var3, var7, ".png"));
      }

      int[] var8 = Json.parseIntArray(var0.get("textureSize"), 2);
      if (var8 == null) {
         var8 = var2;
      }

      if (var8 != null) {
         var4.setTextureSize(var8[0], var8[1]);
      }

      String var9 = Json.getString(var0, "invertAxis", "").toLowerCase();
      boolean var10 = var9.contains("x");
      boolean var11 = var9.contains("y");
      boolean var12 = var9.contains("z");
      float[] var13 = Json.parseFloatArray(var0.get("translate"), 3, new float[3]);
      if (var10) {
         var13[0] = -var13[0];
      }

      if (var11) {
         var13[1] = -var13[1];
      }

      if (var12) {
         var13[2] = -var13[2];
      }

      float[] var14 = Json.parseFloatArray(var0.get("rotate"), 3, new float[3]);

      for(int var15 = 0; var15 < var14.length; ++var15) {
         var14[var15] = var14[var15] / 180.0F * MathHelper.PI;
      }

      if (var10) {
         var14[0] = -var14[0];
      }

      if (var11) {
         var14[1] = -var14[1];
      }

      if (var12) {
         var14[2] = -var14[2];
      }

      var4.setRotationPoint(var13[0], var13[1], var13[2]);
      var4.rotateAngleX = var14[0];
      var4.rotateAngleY = var14[1];
      var4.rotateAngleZ = var14[2];
      String var26 = Json.getString(var0, "mirrorTexture", "").toLowerCase();
      boolean var16 = var26.contains("u");
      boolean var17 = var26.contains("v");
      if (var16) {
         var4.mirror = true;
      }

      if (var17) {
         var4.mirrorV = true;
      }

      JsonArray var18 = var0.getAsJsonArray("boxes");
      JsonObject var20;
      float[] var23;
      float var24;
      if (var18 != null) {
         for(int var19 = 0; var19 < var18.size(); ++var19) {
            var20 = var18.get(var19).getAsJsonObject();
            int[] var21 = Json.parseIntArray(var20.get("textureOffset"), 2);
            int[][] var22 = parseFaceUvs(var20);
            if (var21 == null && var22 == null) {
               throw new JsonParseException("Texture offset not specified");
            }

            var23 = Json.parseFloatArray(var20.get("coordinates"), 6);
            if (var23 == null) {
               throw new JsonParseException("Coordinates not specified");
            }

            if (var10) {
               var23[0] = -var23[0] - var23[3];
            }

            if (var11) {
               var23[1] = -var23[1] - var23[4];
            }

            if (var12) {
               var23[2] = -var23[2] - var23[5];
            }

            var24 = Json.getFloat(var20, "sizeAdd", 0.0F);
            if (var22 != null) {
               var4.addBox(var22, var23[0], var23[1], var23[2], var23[3], var23[4], var23[5], var24);
            } else {
               var4.setTextureOffset(var21[0], var21[1]);
               var4.addBox(var23[0], var23[1], var23[2], (int)var23[3], (int)var23[4], (int)var23[5], var24);
            }
         }
      }

      JsonArray var27 = var0.getAsJsonArray("sprites");
      if (var27 != null) {
         for(int var28 = 0; var28 < var27.size(); ++var28) {
            JsonObject var29 = var27.get(var28).getAsJsonObject();
            int[] var32 = Json.parseIntArray(var29.get("textureOffset"), 2);
            if (var32 == null) {
               throw new JsonParseException("Texture offset not specified");
            }

            var23 = Json.parseFloatArray(var29.get("coordinates"), 6);
            if (var23 == null) {
               throw new JsonParseException("Coordinates not specified");
            }

            if (var10) {
               var23[0] = -var23[0] - var23[3];
            }

            if (var11) {
               var23[1] = -var23[1] - var23[4];
            }

            if (var12) {
               var23[2] = -var23[2] - var23[5];
            }

            var24 = Json.getFloat(var29, "sizeAdd", 0.0F);
            var4.setTextureOffset(var32[0], var32[1]);
            var4.addSprite(var23[0], var23[1], var23[2], (int)var23[3], (int)var23[4], (int)var23[5], var24);
         }
      }

      var20 = (JsonObject)var0.get("submodel");
      if (var20 != null) {
         ModelRenderer var30 = parseModelRenderer(var20, var1, var8, var3);
         var4.addChild(var30);
      }

      JsonArray var31 = (JsonArray)var0.get("submodels");
      if (var31 != null) {
         for(int var33 = 0; var33 < var31.size(); ++var33) {
            JsonObject var34 = (JsonObject)var31.get(var33);
            ModelRenderer var35 = parseModelRenderer(var34, var1, var8, var3);
            if (var35.getId() != null) {
               ModelRenderer var25 = var4.getChild(var35.getId());
               if (var25 != null) {
                  Config.warn("Duplicate model ID: " + var35.getId());
               }
            }

            var4.addChild(var35);
         }
      }

      return var4;
   }

   private static int[][] parseFaceUvs(JsonObject var0) {
      int[][] var1 = new int[][]{Json.parseIntArray(var0.get("uvDown"), 4), Json.parseIntArray(var0.get("uvUp"), 4), Json.parseIntArray(var0.get("uvNorth"), 4), Json.parseIntArray(var0.get("uvSouth"), 4), Json.parseIntArray(var0.get("uvWest"), 4), Json.parseIntArray(var0.get("uvEast"), 4)};
      if (var1[2] == null) {
         var1[2] = Json.parseIntArray(var0.get("uvFront"), 4);
      }

      if (var1[3] == null) {
         var1[3] = Json.parseIntArray(var0.get("uvBack"), 4);
      }

      if (var1[4] == null) {
         var1[4] = Json.parseIntArray(var0.get("uvLeft"), 4);
      }

      if (var1[5] == null) {
         var1[5] = Json.parseIntArray(var0.get("uvRight"), 4);
      }

      boolean var2 = false;

      for(int var3 = 0; var3 < var1.length; ++var3) {
         if (var1[var3] != null) {
            var2 = true;
         }
      }

      return !var2 ? null : var1;
   }

   private static int parseAttachModel(String var0) {
      if (var0 == null) {
         return 0;
      } else if (var0.equals("body")) {
         return 0;
      } else if (var0.equals("head")) {
         return 1;
      } else if (var0.equals("leftArm")) {
         return 2;
      } else if (var0.equals("rightArm")) {
         return 3;
      } else if (var0.equals("leftLeg")) {
         return 4;
      } else if (var0.equals("rightLeg")) {
         return 5;
      } else if (var0.equals("cape")) {
         return 6;
      } else {
         Config.warn("Unknown attachModel: " + var0);
         return 0;
      }
   }

   public static PlayerItemModel parseItemModel(JsonObject var0) {
      String var1 = Json.getString(var0, "type");
      if (!Config.equals(var1, "PlayerItem")) {
         throw new JsonParseException("Unknown model type: " + var1);
      } else {
         int[] var2 = Json.parseIntArray(var0.get("textureSize"), 2);
         checkNull(var2, "Missing texture size");
         Dimension var3 = new Dimension(var2[0], var2[1]);
         boolean var4 = Json.getBoolean(var0, "usePlayerTexture", false);
         JsonArray var5 = (JsonArray)var0.get("models");
         checkNull(var5, "Missing elements");
         HashMap var6 = new HashMap();
         ArrayList var7 = new ArrayList();
         new ArrayList();

         for(int var8 = 0; var8 < var5.size(); ++var8) {
            JsonObject var9 = (JsonObject)var5.get(var8);
            String var10 = Json.getString(var9, "baseId");
            if (var10 != null) {
               JsonObject var11 = (JsonObject)var6.get(var10);
               if (var11 == null) {
                  Config.warn("BaseID not found: " + var10);
                  continue;
               }

               Iterator var13 = var11.entrySet().iterator();

               while(var13.hasNext()) {
                  Entry var12 = (Entry)var13.next();
                  if (!var9.has((String)var12.getKey())) {
                     var9.add((String)var12.getKey(), (JsonElement)var12.getValue());
                  }
               }
            }

            String var15 = Json.getString(var9, "id");
            if (var15 != null) {
               if (!var6.containsKey(var15)) {
                  var6.put(var15, var9);
               } else {
                  Config.warn("Duplicate model ID: " + var15);
               }
            }

            PlayerItemRenderer var16 = parseItemRenderer(var9, var3);
            if (var16 != null) {
               var7.add(var16);
            }
         }

         PlayerItemRenderer[] var14 = (PlayerItemRenderer[])var7.toArray(new PlayerItemRenderer[var7.size()]);
         return new PlayerItemModel(var3, var4, var14);
      }
   }

   public static PlayerItemRenderer parseItemRenderer(JsonObject var0, Dimension var1) {
      String var2 = Json.getString(var0, "type");
      if (!Config.equals(var2, "ModelBox")) {
         Config.warn("Unknown model type: " + var2);
         return null;
      } else {
         String var3 = Json.getString(var0, "attachTo");
         int var4 = parseAttachModel(var3);
         ModelPlayerItem var5 = new ModelPlayerItem();
         var5.textureWidth = var1.width;
         var5.textureHeight = var1.height;
         ModelRenderer var6 = parseModelRenderer(var0, var5, (int[])null, (String)null);
         PlayerItemRenderer var7 = new PlayerItemRenderer(var4, var6);
         return var7;
      }
   }

   private static ResourceLocation makeResourceLocation(String var0) {
      int var1 = var0.indexOf(58);
      if (var1 < 0) {
         return new ResourceLocation(var0);
      } else {
         String var2 = var0.substring(0, var1);
         String var3 = var0.substring(var1 + 1);
         return new ResourceLocation(var2, var3);
      }
   }

   private static void checkNull(Object var0, String var1) {
      if (var0 == null) {
         throw new JsonParseException(var1);
      }
   }

   private PlayerItemParser() {
   }
}
