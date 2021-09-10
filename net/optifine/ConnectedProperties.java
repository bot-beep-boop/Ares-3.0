package net.optifine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.init.Blocks;
import net.minecraft.src.Config;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.BiomeGenBase;
import net.optifine.config.ConnectedParser;
import net.optifine.config.MatchBlock;
import net.optifine.config.Matches;
import net.optifine.config.NbtTagValue;
import net.optifine.config.RangeInt;
import net.optifine.config.RangeListInt;
import net.optifine.util.MathUtils;
import net.optifine.util.TextureUtils;

public class ConnectedProperties {
   public static final int SYMMETRY_NONE = 1;
   public static final int FACE_WEST = 16;
   public static final int FACE_SOUTH = 8;
   public EnumWorldBlockLayer layer;
   public BiomeGenBase[] biomes = null;
   public static final int CONNECT_TILE = 2;
   public IBlockState tintBlockState;
   public int method = 0;
   public String[] tiles = null;
   public static final int METHOD_CTM = 1;
   public NbtTagValue nbtName = null;
   public static final String TILE_DEFAULT_PNG = "<default>.png";
   public static final int METHOD_HORIZONTAL_VERTICAL = 8;
   public String name = null;
   public static final int FACE_EAST = 32;
   public static final int FACE_BOTTOM = 1;
   public int width = 0;
   public TextureAtlasSprite[] matchTileIcons = null;
   public static final int METHOD_OVERLAY_CTM = 15;
   public static final int FACE_ALL = 63;
   public TextureAtlasSprite[] connectTileIcons = null;
   public static final int METHOD_VERTICAL = 6;
   public static final int SYMMETRY_ALL = 6;
   public static final int METHOD_OVERLAY_FIXED = 12;
   public static final String TILE_SKIP_PNG = "<skip>.png";
   public boolean innerSeams = false;
   public static final int CONNECT_BLOCK = 1;
   public int renderPass = 0;
   public static final int FACE_SIDES = 60;
   public static final int METHOD_OVERLAY_REPEAT = 14;
   public RangeListInt heights = null;
   public static final int METHOD_TOP = 3;
   public static final int METHOD_VERTICAL_HORIZONTAL = 9;
   public static final int CONNECT_UNKNOWN = 128;
   public static final int METHOD_RANDOM = 4;
   public int tintIndex = -1;
   public static final int METHOD_NONE = 0;
   public static final int FACE_TOP = 2;
   public static final int FACE_UNKNOWN = 128;
   public int[] ctmTileIndexes = null;
   public int[] sumWeights = null;
   public static final int SYMMETRY_UNKNOWN = 128;
   public int faces = 63;
   public static final int METHOD_OVERLAY = 11;
   public int randomLoops = 0;
   public TextureAtlasSprite[] tileIcons = null;
   public int sumAllWeights = 1;
   public int[] weights = null;
   public static final int SYMMETRY_OPPOSITE = 2;
   public String[] connectTiles = null;
   public int symmetry = 1;
   public static final int FACE_NORTH = 4;
   public String[] matchTiles = null;
   public static final int CONNECT_MATERIAL = 3;
   public boolean linked = false;
   public MatchBlock[] matchBlocks = null;
   public MatchBlock[] connectBlocks = null;
   public static final int METHOD_OVERLAY_RANDOM = 13;
   public static final int METHOD_REPEAT = 5;
   public static final int CONNECT_NONE = 0;
   public static final int METHOD_HORIZONTAL = 2;
   public int connect = 0;
   public static final int METHOD_FIXED = 7;
   public int height = 0;
   public static final int METHOD_CTM_COMPACT = 10;
   public String basePath = null;
   public int[] metadatas = null;

   private boolean isValidHorizontalVertical(String var1) {
      if (this.tiles == null) {
         Config.warn("No tiles defined for horizontal+vertical: " + var1);
         return false;
      } else if (this.tiles.length != 7) {
         Config.warn("Invalid tiles, must be exactly 7: " + var1);
         return false;
      } else {
         return true;
      }
   }

   private int[] detectMatchBlockIds() {
      if (!this.name.startsWith("block")) {
         return null;
      } else {
         int var1 = "block".length();

         int var2;
         for(var2 = var1; var2 < this.name.length(); ++var2) {
            char var3 = this.name.charAt(var2);
            if (var3 < '0' || var3 > '9') {
               break;
            }
         }

         if (var2 == var1) {
            return null;
         } else {
            String var5 = this.name.substring(var1, var2);
            int var4 = Config.parseInt(var5, -1);
            return var4 < 0 ? null : new int[]{var4};
         }
      }
   }

   private boolean isValidOverlay(String var1) {
      if (this.tiles == null) {
         this.tiles = this.parseTileNames("0-16");
      }

      if (this.tiles.length < 17) {
         Config.warn("Invalid tiles, must be at least 17: " + var1);
         return false;
      } else if (this.layer != null && this.layer != EnumWorldBlockLayer.SOLID) {
         return true;
      } else {
         Config.warn("Invalid overlay layer: " + this.layer);
         return false;
      }
   }

   public String toString() {
      return "CTM name: " + this.name + ", basePath: " + this.basePath + ", matchBlocks: " + Config.arrayToString((Object[])this.matchBlocks) + ", matchTiles: " + Config.arrayToString((Object[])this.matchTiles);
   }

   private String[] parseTileNames(String var1) {
      if (var1 == null) {
         return null;
      } else {
         ArrayList var2 = new ArrayList();
         String[] var3 = Config.tokenize(var1, " ,");

         label88:
         for(int var4 = 0; var4 < var3.length; ++var4) {
            String var5 = var3[var4];
            if (var5.contains("-")) {
               String[] var6 = Config.tokenize(var5, "-");
               if (var6.length == 2) {
                  int var7 = Config.parseInt(var6[0], -1);
                  int var8 = Config.parseInt(var6[1], -1);
                  if (var7 >= 0 && var8 >= 0) {
                     if (var7 > var8) {
                        Config.warn("Invalid interval: " + var5 + ", when parsing: " + var1);
                        continue;
                     }

                     int var9 = var7;

                     while(true) {
                        if (var9 > var8) {
                           continue label88;
                        }

                        var2.add(String.valueOf(var9));
                        ++var9;
                     }
                  }
               }
            }

            var2.add(var5);
         }

         String[] var10 = (String[])var2.toArray(new String[var2.size()]);

         for(int var11 = 0; var11 < var10.length; ++var11) {
            String var12 = var10[var11];
            var12 = TextureUtils.fixResourcePath(var12, this.basePath);
            if (!var12.startsWith(this.basePath) && !var12.startsWith("textures/") && !var12.startsWith("mcpatcher/")) {
               var12 = this.basePath + "/" + var12;
            }

            if (var12.endsWith(".png")) {
               var12 = var12.substring(0, var12.length() - 4);
            }

            if (var12.startsWith("/")) {
               var12 = var12.substring(1);
            }

            var10[var11] = var12;
         }

         return var10;
      }
   }

   public void updateIcons(TextureMap var1) {
      if (this.matchTiles != null) {
         this.matchTileIcons = registerIcons(this.matchTiles, var1, false, false);
      }

      if (this.connectTiles != null) {
         this.connectTileIcons = registerIcons(this.connectTiles, var1, false, false);
      }

      if (this.tiles != null) {
         this.tileIcons = registerIcons(this.tiles, var1, true, !isMethodOverlay(this.method));
      }

   }

   private boolean isValidVerticalHorizontal(String var1) {
      if (this.tiles == null) {
         Config.warn("No tiles defined for vertical+horizontal: " + var1);
         return false;
      } else if (this.tiles.length != 7) {
         Config.warn("Invalid tiles, must be exactly 7: " + var1);
         return false;
      } else {
         return true;
      }
   }

   private boolean isValidTop(String var1) {
      if (this.tiles == null) {
         this.tiles = this.parseTileNames("66");
      }

      if (this.tiles.length != 1) {
         Config.warn("Invalid tiles, must be exactly 1: " + var1);
         return false;
      } else {
         return true;
      }
   }

   private boolean isValidOverlayFixed(String var1) {
      if (!this.isValidFixed(var1)) {
         return false;
      } else if (this.layer != null && this.layer != EnumWorldBlockLayer.SOLID) {
         return true;
      } else {
         Config.warn("Invalid overlay layer: " + this.layer);
         return false;
      }
   }

   private static String parseBasePath(String var0) {
      int var1 = var0.lastIndexOf(47);
      return var1 < 0 ? "" : var0.substring(0, var1);
   }

   public boolean matchesBlockId(int var1) {
      return Matches.blockId(var1, this.matchBlocks);
   }

   private static boolean isMethodOverlay(int var0) {
      switch(var0) {
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
         return true;
      default:
         return false;
      }
   }

   public boolean isValid(String var1) {
      if (this.name != null && this.name.length() > 0) {
         if (this.basePath == null) {
            Config.warn("No base path found: " + var1);
            return false;
         } else {
            if (this.matchBlocks == null) {
               this.matchBlocks = this.detectMatchBlocks();
            }

            if (this.matchTiles == null && this.matchBlocks == null) {
               this.matchTiles = this.detectMatchTiles();
            }

            if (this.matchBlocks == null && this.matchTiles == null) {
               Config.warn("No matchBlocks or matchTiles specified: " + var1);
               return false;
            } else if (this.method == 0) {
               Config.warn("No method: " + var1);
               return false;
            } else if (this.tiles != null && this.tiles.length > 0) {
               if (this.connect == 0) {
                  this.connect = this.detectConnect();
               }

               if (this.connect == 128) {
                  Config.warn("Invalid connect in: " + var1);
                  return false;
               } else if (this.renderPass > 0) {
                  Config.warn("Render pass not supported: " + this.renderPass);
                  return false;
               } else if ((this.faces & 128) != 0) {
                  Config.warn("Invalid faces in: " + var1);
                  return false;
               } else if ((this.symmetry & 128) != 0) {
                  Config.warn("Invalid symmetry in: " + var1);
                  return false;
               } else {
                  switch(this.method) {
                  case 1:
                     return this.isValidCtm(var1);
                  case 2:
                     return this.isValidHorizontal(var1);
                  case 3:
                     return this.isValidTop(var1);
                  case 4:
                     return this.isValidRandom(var1);
                  case 5:
                     return this.isValidRepeat(var1);
                  case 6:
                     return this.isValidVertical(var1);
                  case 7:
                     return this.isValidFixed(var1);
                  case 8:
                     return this.isValidHorizontalVertical(var1);
                  case 9:
                     return this.isValidVerticalHorizontal(var1);
                  case 10:
                     return this.isValidCtmCompact(var1);
                  case 11:
                     return this.isValidOverlay(var1);
                  case 12:
                     return this.isValidOverlayFixed(var1);
                  case 13:
                     return this.isValidOverlayRandom(var1);
                  case 14:
                     return this.isValidOverlayRepeat(var1);
                  case 15:
                     return this.isValidOverlayCtm(var1);
                  default:
                     Config.warn("Unknown method: " + var1);
                     return false;
                  }
               }
            } else {
               Config.warn("No tiles specified: " + var1);
               return false;
            }
         }
      } else {
         Config.warn("No name found: " + var1);
         return false;
      }
   }

   public static IProperty getProperty(String var0, Collection var1) {
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         Object var2 = var3.next();
         IProperty var4 = (IProperty)var2;
         if (var0.equals(var4.getName())) {
            return var4;
         }
      }

      return null;
   }

   private boolean isValidOverlayRandom(String var1) {
      if (!this.isValidRandom(var1)) {
         return false;
      } else if (this.layer != null && this.layer != EnumWorldBlockLayer.SOLID) {
         return true;
      } else {
         Config.warn("Invalid overlay layer: " + this.layer);
         return false;
      }
   }

   private String[] parseMatchTiles(String var1) {
      if (var1 == null) {
         return null;
      } else {
         String[] var2 = Config.tokenize(var1, " ");

         for(int var3 = 0; var3 < var2.length; ++var3) {
            String var4 = var2[var3];
            if (var4.endsWith(".png")) {
               var4 = var4.substring(0, var4.length() - 4);
            }

            var4 = TextureUtils.fixResourcePath(var4, this.basePath);
            var2[var3] = var4;
         }

         return var2;
      }
   }

   public boolean matchesBiome(BiomeGenBase var1) {
      return Matches.biome(var1, this.biomes);
   }

   public boolean matchesBlock(int var1, int var2) {
      return !Matches.block(var1, var2, this.matchBlocks) ? false : Matches.metadata(var2, this.metadatas);
   }

   private static String parseName(String var0) {
      String var1 = var0;
      int var2 = var0.lastIndexOf(47);
      if (var2 >= 0) {
         var1 = var0.substring(var2 + 1);
      }

      int var3 = var1.lastIndexOf(46);
      if (var3 >= 0) {
         var1 = var1.substring(0, var3);
      }

      return var1;
   }

   public boolean matchesIcon(TextureAtlasSprite var1) {
      return Matches.sprite(var1, this.matchTileIcons);
   }

   private static int parseConnect(String var0) {
      if (var0 == null) {
         return 0;
      } else {
         var0 = var0.trim();
         if (var0.equals("block")) {
            return 1;
         } else if (var0.equals("tile")) {
            return 2;
         } else if (var0.equals("material")) {
            return 3;
         } else {
            Config.warn("Unknown connect: " + var0);
            return 128;
         }
      }
   }

   private boolean isValidRandom(String var1) {
      if (this.tiles != null && this.tiles.length > 0) {
         if (this.weights != null) {
            int[] var2;
            if (this.weights.length > this.tiles.length) {
               Config.warn("More weights defined than tiles, trimming weights: " + var1);
               var2 = new int[this.tiles.length];
               System.arraycopy(this.weights, 0, var2, 0, var2.length);
               this.weights = var2;
            }

            int var3;
            if (this.weights.length < this.tiles.length) {
               Config.warn("Less weights defined than tiles, expanding weights: " + var1);
               var2 = new int[this.tiles.length];
               System.arraycopy(this.weights, 0, var2, 0, this.weights.length);
               var3 = MathUtils.getAverage(this.weights);

               for(int var4 = this.weights.length; var4 < var2.length; ++var4) {
                  var2[var4] = var3;
               }

               this.weights = var2;
            }

            this.sumWeights = new int[this.weights.length];
            int var5 = 0;

            for(var3 = 0; var3 < this.weights.length; ++var3) {
               var5 += this.weights[var3];
               this.sumWeights[var3] = var5;
            }

            this.sumAllWeights = var5;
            if (this.sumAllWeights <= 0) {
               Config.warn("Invalid sum of all weights: " + var5);
               this.sumAllWeights = 1;
            }
         }

         if (this.randomLoops >= 0 && this.randomLoops <= 9) {
            return true;
         } else {
            Config.warn("Invalid randomLoops: " + this.randomLoops);
            return false;
         }
      } else {
         Config.warn("Tiles not defined: " + var1);
         return false;
      }
   }

   private static int parseFace(String var0) {
      var0 = var0.toLowerCase();
      if (!var0.equals("bottom") && !var0.equals("down")) {
         if (!var0.equals("top") && !var0.equals("up")) {
            if (var0.equals("north")) {
               return 4;
            } else if (var0.equals("south")) {
               return 8;
            } else if (var0.equals("east")) {
               return 32;
            } else if (var0.equals("west")) {
               return 16;
            } else if (var0.equals("sides")) {
               return 60;
            } else if (var0.equals("all")) {
               return 63;
            } else {
               Config.warn("Unknown face: " + var0);
               return 128;
            }
         } else {
            return 2;
         }
      } else {
         return 1;
      }
   }

   private boolean isValidFixed(String var1) {
      if (this.tiles == null) {
         Config.warn("Tiles not defined: " + var1);
         return false;
      } else if (this.tiles.length != 1) {
         Config.warn("Number of tiles should be 1 for method: fixed.");
         return false;
      } else {
         return true;
      }
   }

   public int getMetadataMax() {
      byte var1 = -1;
      int var4 = this.getMax(this.metadatas, var1);
      if (this.matchBlocks != null) {
         for(int var2 = 0; var2 < this.matchBlocks.length; ++var2) {
            MatchBlock var3 = this.matchBlocks[var2];
            var4 = this.getMax(var3.getMetadatas(), var4);
         }
      }

      return var4;
   }

   private boolean isValidHorizontal(String var1) {
      if (this.tiles == null) {
         this.tiles = this.parseTileNames("12-15");
      }

      if (this.tiles.length != 4) {
         Config.warn("Invalid tiles, must be exactly 4: " + var1);
         return false;
      } else {
         return true;
      }
   }

   private boolean isValidOverlayRepeat(String var1) {
      if (!this.isValidRepeat(var1)) {
         return false;
      } else if (this.layer != null && this.layer != EnumWorldBlockLayer.SOLID) {
         return true;
      } else {
         Config.warn("Invalid overlay layer: " + this.layer);
         return false;
      }
   }

   private boolean isValidRepeat(String var1) {
      if (this.tiles == null) {
         Config.warn("Tiles not defined: " + var1);
         return false;
      } else if (this.width <= 0) {
         Config.warn("Invalid width: " + var1);
         return false;
      } else if (this.height <= 0) {
         Config.warn("Invalid height: " + var1);
         return false;
      } else if (this.tiles.length != this.width * this.height) {
         Config.warn("Number of tiles does not equal width x height: " + var1);
         return false;
      } else {
         return true;
      }
   }

   private int detectConnect() {
      if (this.matchBlocks != null) {
         return 1;
      } else {
         return this.matchTiles != null ? 2 : 128;
      }
   }

   private boolean isValidCtmCompact(String var1) {
      if (this.tiles == null) {
         this.tiles = this.parseTileNames("0-4");
      }

      if (this.tiles.length < 5) {
         Config.warn("Invalid tiles, must be at least 5: " + var1);
         return false;
      } else {
         return true;
      }
   }

   private static TextureAtlasSprite getIcon(String var0) {
      TextureMap var1 = Minecraft.getMinecraft().getTextureMapBlocks();
      TextureAtlasSprite var2 = var1.getSpriteSafe(var0);
      if (var2 != null) {
         return var2;
      } else {
         var2 = var1.getSpriteSafe("blocks/" + var0);
         return var2;
      }
   }

   private static int parseSymmetry(String var0) {
      if (var0 == null) {
         return 1;
      } else {
         var0 = var0.trim();
         if (var0.equals("opposite")) {
            return 2;
         } else if (var0.equals("all")) {
            return 6;
         } else {
            Config.warn("Unknown symmetry: " + var0);
            return 1;
         }
      }
   }

   private static int parseMethod(String var0) {
      if (var0 == null) {
         return 1;
      } else {
         var0 = var0.trim();
         if (!var0.equals("ctm") && !var0.equals("glass")) {
            if (var0.equals("ctm_compact")) {
               return 10;
            } else if (!var0.equals("horizontal") && !var0.equals("bookshelf")) {
               if (var0.equals("vertical")) {
                  return 6;
               } else if (var0.equals("top")) {
                  return 3;
               } else if (var0.equals("random")) {
                  return 4;
               } else if (var0.equals("repeat")) {
                  return 5;
               } else if (var0.equals("fixed")) {
                  return 7;
               } else if (!var0.equals("horizontal+vertical") && !var0.equals("h+v")) {
                  if (!var0.equals("vertical+horizontal") && !var0.equals("v+h")) {
                     if (var0.equals("overlay")) {
                        return 11;
                     } else if (var0.equals("overlay_fixed")) {
                        return 12;
                     } else if (var0.equals("overlay_random")) {
                        return 13;
                     } else if (var0.equals("overlay_repeat")) {
                        return 14;
                     } else if (var0.equals("overlay_ctm")) {
                        return 15;
                     } else {
                        Config.warn("Unknown method: " + var0);
                        return 0;
                     }
                  } else {
                     return 9;
                  }
               } else {
                  return 8;
               }
            } else {
               return 2;
            }
         } else {
            return 1;
         }
      }
   }

   private int getMax(int[] var1, int var2) {
      if (var1 == null) {
         return var2;
      } else {
         for(int var3 = 0; var3 < var1.length; ++var3) {
            int var4 = var1[var3];
            if (var4 > var2) {
               var2 = var4;
            }
         }

         return var2;
      }
   }

   private static int parseFaces(String var0) {
      if (var0 == null) {
         return 63;
      } else {
         String[] var1 = Config.tokenize(var0, " ,");
         int var2 = 0;

         for(int var3 = 0; var3 < var1.length; ++var3) {
            String var4 = var1[var3];
            int var5 = parseFace(var4);
            var2 |= var5;
         }

         return var2;
      }
   }

   private boolean isValidOverlayCtm(String var1) {
      if (!this.isValidCtm(var1)) {
         return false;
      } else if (this.layer != null && this.layer != EnumWorldBlockLayer.SOLID) {
         return true;
      } else {
         Config.warn("Invalid overlay layer: " + this.layer);
         return false;
      }
   }

   private boolean isValidCtm(String var1) {
      if (this.tiles == null) {
         this.tiles = this.parseTileNames("0-11 16-27 32-43 48-58");
      }

      if (this.tiles.length < 47) {
         Config.warn("Invalid tiles, must be at least 47: " + var1);
         return false;
      } else {
         return true;
      }
   }

   private static TextureAtlasSprite[] registerIcons(String[] var0, TextureMap var1, boolean var2, boolean var3) {
      if (var0 == null) {
         return null;
      } else {
         ArrayList var4 = new ArrayList();

         for(int var5 = 0; var5 < var0.length; ++var5) {
            String var6 = var0[var5];
            ResourceLocation var7 = new ResourceLocation(var6);
            String var8 = var7.getResourceDomain();
            String var9 = var7.getResourcePath();
            if (!var9.contains("/")) {
               var9 = "textures/blocks/" + var9;
            }

            String var10 = var9 + ".png";
            if (var2 && var10.endsWith("<skip>.png")) {
               var4.add((Object)null);
            } else if (var3 && var10.endsWith("<default>.png")) {
               var4.add(ConnectedTextures.SPRITE_DEFAULT);
            } else {
               ResourceLocation var11 = new ResourceLocation(var8, var10);
               boolean var12 = Config.hasResource(var11);
               if (!var12) {
                  Config.warn("File not found: " + var10);
               }

               String var13 = "textures/";
               String var14 = var9;
               if (var9.startsWith(var13)) {
                  var14 = var9.substring(var13.length());
               }

               ResourceLocation var15 = new ResourceLocation(var8, var14);
               TextureAtlasSprite var16 = var1.registerSprite(var15);
               var4.add(var16);
            }
         }

         TextureAtlasSprite[] var17 = (TextureAtlasSprite[])var4.toArray(new TextureAtlasSprite[var4.size()]);
         return var17;
      }
   }

   private int[] parseCtmTileIndexes(Properties var1) {
      if (this.tiles == null) {
         return null;
      } else {
         HashMap var2 = new HashMap();
         Iterator var4 = var1.keySet().iterator();

         while(true) {
            while(true) {
               while(true) {
                  String var7;
                  String var8;
                  do {
                     String var5;
                     String var6;
                     do {
                        Object var3;
                        do {
                           if (!var4.hasNext()) {
                              if (var2.isEmpty()) {
                                 return null;
                              }

                              int[] var11 = new int[47];

                              for(int var12 = 0; var12 < var11.length; ++var12) {
                                 var11[var12] = -1;
                                 if (var2.containsKey(var12)) {
                                    var11[var12] = (Integer)var2.get(var12);
                                 }
                              }

                              return var11;
                           }

                           var3 = var4.next();
                        } while(!(var3 instanceof String));

                        var5 = (String)var3;
                        var6 = "ctm.";
                     } while(!var5.startsWith(var6));

                     var7 = var5.substring(var6.length());
                     var8 = var1.getProperty(var5);
                  } while(var8 == null);

                  var8 = var8.trim();
                  int var9 = Config.parseInt(var7, -1);
                  if (var9 >= 0 && var9 <= 46) {
                     int var10 = Config.parseInt(var8, -1);
                     if (var10 >= 0 && var10 < this.tiles.length) {
                        var2.put(var9, var10);
                     } else {
                        Config.warn("Invalid CTM tile index: " + var8);
                     }
                  } else {
                     Config.warn("Invalid CTM index: " + var7);
                  }
               }
            }
         }
      }
   }

   private String[] detectMatchTiles() {
      TextureAtlasSprite var1 = getIcon(this.name);
      return var1 == null ? null : new String[]{this.name};
   }

   private boolean isValidVertical(String var1) {
      if (this.tiles == null) {
         Config.warn("No tiles defined for vertical: " + var1);
         return false;
      } else if (this.tiles.length != 4) {
         Config.warn("Invalid tiles, must be exactly 4: " + var1);
         return false;
      } else {
         return true;
      }
   }

   public ConnectedProperties(Properties var1, String var2) {
      this.tintBlockState = Blocks.air.getDefaultState();
      this.layer = null;
      ConnectedParser var3 = new ConnectedParser("ConnectedTextures");
      this.name = var3.parseName(var2);
      this.basePath = var3.parseBasePath(var2);
      this.matchBlocks = var3.parseMatchBlocks(var1.getProperty("matchBlocks"));
      this.metadatas = var3.parseIntList(var1.getProperty("metadata"));
      this.matchTiles = this.parseMatchTiles(var1.getProperty("matchTiles"));
      this.method = parseMethod(var1.getProperty("method"));
      this.tiles = this.parseTileNames(var1.getProperty("tiles"));
      this.connect = parseConnect(var1.getProperty("connect"));
      this.faces = parseFaces(var1.getProperty("faces"));
      this.biomes = var3.parseBiomes(var1.getProperty("biomes"));
      this.heights = var3.parseRangeListInt(var1.getProperty("heights"));
      if (this.heights == null) {
         int var4 = var3.parseInt(var1.getProperty("minHeight"), -1);
         int var5 = var3.parseInt(var1.getProperty("maxHeight"), 1024);
         if (var4 != -1 || var5 != 1024) {
            this.heights = new RangeListInt(new RangeInt(var4, var5));
         }
      }

      this.renderPass = var3.parseInt(var1.getProperty("renderPass"), -1);
      this.innerSeams = var3.parseBoolean(var1.getProperty("innerSeams"), false);
      this.ctmTileIndexes = this.parseCtmTileIndexes(var1);
      this.width = var3.parseInt(var1.getProperty("width"), -1);
      this.height = var3.parseInt(var1.getProperty("height"), -1);
      this.weights = var3.parseIntList(var1.getProperty("weights"));
      this.randomLoops = var3.parseInt(var1.getProperty("randomLoops"), 0);
      this.symmetry = parseSymmetry(var1.getProperty("symmetry"));
      this.linked = var3.parseBoolean(var1.getProperty("linked"), false);
      this.nbtName = var3.parseNbtTagValue("name", var1.getProperty("name"));
      this.connectBlocks = var3.parseMatchBlocks(var1.getProperty("connectBlocks"));
      this.connectTiles = this.parseMatchTiles(var1.getProperty("connectTiles"));
      this.tintIndex = var3.parseInt(var1.getProperty("tintIndex"), -1);
      this.tintBlockState = var3.parseBlockState(var1.getProperty("tintBlock"), Blocks.air.getDefaultState());
      this.layer = var3.parseBlockRenderLayer(var1.getProperty("layer"), EnumWorldBlockLayer.CUTOUT_MIPPED);
   }

   private MatchBlock[] detectMatchBlocks() {
      int[] var1 = this.detectMatchBlockIds();
      if (var1 == null) {
         return null;
      } else {
         MatchBlock[] var2 = new MatchBlock[var1.length];

         for(int var3 = 0; var3 < var2.length; ++var3) {
            var2[var3] = new MatchBlock(var1[var3]);
         }

         return var2;
      }
   }
}
