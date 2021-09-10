package net.optifine.entity.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;
import net.optifine.config.ConnectedParser;
import net.optifine.entity.model.anim.ModelUpdater;
import net.optifine.entity.model.anim.ModelVariableUpdater;
import net.optifine.player.PlayerItemParser;
import net.optifine.util.Json;

public class CustomEntityModelParser {
   public static final String MODEL_SUBMODEL = "submodel";
   public static final String MODEL_ID = "id";
   public static final String ITEM_ANIMATIONS = "animations";
   public static final String ITEM_TYPE = "type";
   public static final String ENTITY_MODEL_PART = "EntityModelPart";
   public static final String ENTITY = "entity";
   public static final String ITEM_TEXTURE_SIZE = "textureSize";
   public static final String MODEL_INVERT_AXIS = "invertAxis";
   public static final String MODEL_SCALE = "scale";
   public static final String TEXTURE = "texture";
   public static final String MODEL_BASE_ID = "baseId";
   public static final String BOX_COORDINATES = "coordinates";
   public static final String MODEL_SPRITES = "sprites";
   public static final String MODEL_TYPE = "type";
   public static final String MODEL_MIRROR_TEXTURE = "mirrorTexture";
   public static final String BOX_TEXTURE_OFFSET = "textureOffset";
   public static final String MODEL_MODEL = "model";
   public static final String MODEL_SUBMODELS = "submodels";
   public static final String SHADOW_SIZE = "shadowSize";
   public static final String MODEL_TRANSLATE = "translate";
   public static final String ITEM_USE_PLAYER_TEXTURE = "usePlayerTexture";
   public static final String MODEL_ROTATE = "rotate";
   public static final String ENTITY_MODEL = "EntityModel";
   public static final String MODEL_PART = "part";
   public static final String ITEM_MODELS = "models";
   public static final String BOX_SIZE_ADD = "sizeAdd";
   public static final String MODEL_ATTACH = "attach";
   public static final String MODEL_BOXES = "boxes";

   private static void checkNull(Object var0, String var1) {
      if (var0 == null) {
         throw new JsonParseException(var1);
      }
   }

   private static void processId(JsonObject var0, Map var1) {
      String var2 = Json.getString(var0, "id");
      if (var2 != null) {
         if (var2.length() < 1) {
            Config.warn("Empty model ID: " + var2);
         } else if (var1.containsKey(var2)) {
            Config.warn("Duplicate model ID: " + var2);
         } else {
            var1.put(var2, var0);
         }
      }

   }

   public static JsonObject loadJson(ResourceLocation var0) throws IOException, JsonParseException {
      InputStream var1 = Config.getResourceStream(var0);
      if (var1 == null) {
         return null;
      } else {
         String var2 = Config.readInputStream(var1, "ASCII");
         var1.close();
         JsonParser var3 = new JsonParser();
         JsonObject var4 = (JsonObject)var3.parse(var2);
         return var4;
      }
   }

   private static void copyJsonElements(JsonObject var0, JsonObject var1) {
      Iterator var3 = var0.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var2 = (Entry)var3.next();
         if (!((String)var2.getKey()).equals("id") && !var1.has((String)var2.getKey())) {
            var1.add((String)var2.getKey(), (JsonElement)var2.getValue());
         }
      }

   }

   public static ResourceLocation getResourceLocation(String var0, String var1, String var2) {
      if (!var1.endsWith(var2)) {
         var1 = var1 + var2;
      }

      if (!var1.contains("/")) {
         var1 = var0 + "/" + var1;
      } else if (var1.startsWith("./")) {
         var1 = var0 + "/" + var1.substring(2);
      } else if (var1.startsWith("~/")) {
         var1 = "optifine/" + var1.substring(2);
      }

      return new ResourceLocation(var1);
   }

   private static void processBaseId(JsonObject var0, Map var1) {
      String var2 = Json.getString(var0, "baseId");
      if (var2 != null) {
         JsonObject var3 = (JsonObject)var1.get(var2);
         if (var3 == null) {
            Config.warn("BaseID not found: " + var2);
         } else {
            copyJsonElements(var3, var0);
         }
      }

   }

   public static CustomModelRenderer parseCustomModelRenderer(JsonObject var0, int[] var1, String var2) {
      String var3 = Json.getString(var0, "part");
      checkNull(var3, "Model part not specified, missing \"replace\" or \"attachTo\".");
      boolean var4 = Json.getBoolean(var0, "attach", false);
      CustomEntityModel var5 = new CustomEntityModel();
      if (var1 != null) {
         var5.textureWidth = var1[0];
         var5.textureHeight = var1[1];
      }

      ModelUpdater var6 = null;
      JsonArray var7 = (JsonArray)var0.get("animations");
      if (var7 != null) {
         ArrayList var8 = new ArrayList();

         for(int var9 = 0; var9 < var7.size(); ++var9) {
            JsonObject var10 = (JsonObject)var7.get(var9);
            Iterator var12 = var10.entrySet().iterator();

            while(var12.hasNext()) {
               Entry var11 = (Entry)var12.next();
               String var13 = (String)var11.getKey();
               String var14 = ((JsonElement)var11.getValue()).getAsString();
               ModelVariableUpdater var15 = new ModelVariableUpdater(var13, var14);
               var8.add(var15);
            }
         }

         if (var8.size() > 0) {
            ModelVariableUpdater[] var17 = (ModelVariableUpdater[])var8.toArray(new ModelVariableUpdater[var8.size()]);
            var6 = new ModelUpdater(var17);
         }
      }

      ModelRenderer var16 = PlayerItemParser.parseModelRenderer(var0, var5, var1, var2);
      CustomModelRenderer var18 = new CustomModelRenderer(var3, var4, var16, var6);
      return var18;
   }

   private static void processExternalModel(JsonObject var0, Map var1, String var2) {
      String var3 = Json.getString(var0, "model");
      if (var3 != null) {
         ResourceLocation var4 = getResourceLocation(var2, var3, ".jpm");

         try {
            JsonObject var5 = loadJson(var4);
            if (var5 == null) {
               Config.warn("Model not found: " + var4);
               return;
            }

            copyJsonElements(var5, var0);
         } catch (IOException var6) {
            Config.error(var6.getClass().getName() + ": " + var6.getMessage());
         } catch (JsonParseException var7) {
            Config.error(var7.getClass().getName() + ": " + var7.getMessage());
         } catch (Exception var8) {
            var8.printStackTrace();
         }
      }

   }

   public static CustomEntityRenderer parseEntityRender(JsonObject var0, String var1) {
      ConnectedParser var2 = new ConnectedParser("CustomEntityModels");
      String var3 = var2.parseName(var1);
      String var4 = var2.parseBasePath(var1);
      String var5 = Json.getString(var0, "texture");
      int[] var6 = Json.parseIntArray(var0.get("textureSize"), 2);
      float var7 = Json.getFloat(var0, "shadowSize", -1.0F);
      JsonArray var8 = (JsonArray)var0.get("models");
      checkNull(var8, "Missing models");
      HashMap var9 = new HashMap();
      ArrayList var10 = new ArrayList();

      for(int var11 = 0; var11 < var8.size(); ++var11) {
         JsonObject var12 = (JsonObject)var8.get(var11);
         processBaseId(var12, var9);
         processExternalModel(var12, var9, var4);
         processId(var12, var9);
         CustomModelRenderer var13 = parseCustomModelRenderer(var12, var6, var4);
         if (var13 != null) {
            var10.add(var13);
         }
      }

      CustomModelRenderer[] var14 = (CustomModelRenderer[])var10.toArray(new CustomModelRenderer[var10.size()]);
      ResourceLocation var15 = null;
      if (var5 != null) {
         var15 = getResourceLocation(var4, var5, ".png");
      }

      CustomEntityRenderer var16 = new CustomEntityRenderer(var3, var4, var15, var14, var7);
      return var16;
   }
}
