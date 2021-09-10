package net.minecraft.client.renderer.texture;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.StitcherException;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.data.AnimationMetadataSection;
import net.minecraft.client.resources.data.TextureMetadataSection;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.src.Config;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import net.optifine.BetterGrass;
import net.optifine.ConnectedTextures;
import net.optifine.CustomItems;
import net.optifine.EmissiveTextures;
import net.optifine.SmartAnimations;
import net.optifine.reflect.Reflector;
import net.optifine.reflect.ReflectorForge;
import net.optifine.shaders.ShadersTex;
import net.optifine.util.CounterInt;
import net.optifine.util.TextureUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextureMap extends AbstractTexture implements ITickableTextureObject {
   private CounterInt counterIndexInMap;
   public int atlasHeight;
   public static final ResourceLocation LOCATION_MISSING_TEXTURE = new ResourceLocation("missingno");
   private final Map<String, TextureAtlasSprite> mapRegisteredSprites;
   private final TextureAtlasSprite missingImage;
   private int frameCountAnimations;
   private static final Logger logger = LogManager.getLogger();
   private int iconGridCountX;
   private int iconGridCountY;
   private final Map<String, TextureAtlasSprite> mapUploadedSprites;
   private TextureAtlasSprite[] iconGrid;
   private int countAnimationsActive;
   private final List<TextureAtlasSprite> listAnimatedSprites;
   private boolean skipFirst;
   private double iconGridSizeV;
   public static final ResourceLocation locationBlocksTexture = new ResourceLocation("textures/atlas/blocks.png");
   private static final boolean ENABLE_SKIP = Boolean.parseBoolean(System.getProperty("fml.skipFirstTextureLoad", "true"));
   private int mipmapLevels;
   public int atlasWidth;
   private int iconGridSize;
   private double iconGridSizeU;
   private final String basePath;
   private final IIconCreator iconCreator;

   public boolean setTextureEntry(TextureAtlasSprite var1) {
      return this.setTextureEntry(var1.getIconName(), var1);
   }

   private void initMissingImage() {
      int var1 = this.getMinSpriteSize();
      int[] var2 = this.getMissingImageData(var1);
      this.missingImage.setIconWidth(var1);
      this.missingImage.setIconHeight(var1);
      int[][] var3 = new int[this.mipmapLevels + 1][];
      var3[0] = var2;
      this.missingImage.setFramesTextureData(Lists.newArrayList(new int[][][]{var3}));
      this.missingImage.setIndexInMap(this.counterIndexInMap.nextValue());
   }

   private int getMinSpriteSize() {
      int var1 = 1 << this.mipmapLevels;
      if (var1 < 8) {
         var1 = 8;
      }

      return var1;
   }

   public void updateAnimations() {
      if (Config.isShaders()) {
         ShadersTex.updatingTex = this.getMultiTexID();
      }

      boolean var1 = false;
      boolean var2 = false;
      TextureUtil.bindTexture(this.getGlTextureId());
      int var3 = 0;
      Iterator var5 = this.listAnimatedSprites.iterator();

      TextureAtlasSprite var4;
      while(var5.hasNext()) {
         var4 = (TextureAtlasSprite)var5.next();
         if (this.isTerrainAnimationActive(var4)) {
            var4.updateAnimation();
            if (var4.isAnimationActive()) {
               ++var3;
            }

            if (var4.spriteNormal != null) {
               var1 = true;
            }

            if (var4.spriteSpecular != null) {
               var2 = true;
            }
         }
      }

      if (Config.isMultiTexture()) {
         var5 = this.listAnimatedSprites.iterator();

         label184:
         while(true) {
            TextureAtlasSprite var6;
            do {
               do {
                  if (!var5.hasNext()) {
                     TextureUtil.bindTexture(this.getGlTextureId());
                     break label184;
                  }

                  var4 = (TextureAtlasSprite)var5.next();
               } while(!this.isTerrainAnimationActive(var4));

               var6 = var4.spriteSingle;
            } while(var6 == null);

            if (var4 == TextureUtils.iconClock || var4 == TextureUtils.iconCompass) {
               var6.frameCounter = var4.frameCounter;
            }

            var4.bindSpriteTexture();
            var6.updateAnimation();
            if (var6.isAnimationActive()) {
               ++var3;
            }
         }
      }

      if (Config.isShaders()) {
         if (var1) {
            TextureUtil.bindTexture(this.getMultiTexID().norm);
            var5 = this.listAnimatedSprites.iterator();

            label163:
            while(true) {
               do {
                  do {
                     if (!var5.hasNext()) {
                        break label163;
                     }

                     var4 = (TextureAtlasSprite)var5.next();
                  } while(var4.spriteNormal == null);
               } while(!this.isTerrainAnimationActive(var4));

               if (var4 == TextureUtils.iconClock || var4 == TextureUtils.iconCompass) {
                  var4.spriteNormal.frameCounter = var4.frameCounter;
               }

               var4.spriteNormal.updateAnimation();
               if (var4.spriteNormal.isAnimationActive()) {
                  ++var3;
               }
            }
         }

         if (var2) {
            TextureUtil.bindTexture(this.getMultiTexID().spec);
            var5 = this.listAnimatedSprites.iterator();

            label142:
            while(true) {
               do {
                  do {
                     if (!var5.hasNext()) {
                        break label142;
                     }

                     var4 = (TextureAtlasSprite)var5.next();
                  } while(var4.spriteSpecular == null);
               } while(!this.isTerrainAnimationActive(var4));

               if (var4 == TextureUtils.iconClock || var4 == TextureUtils.iconCompass) {
                  var4.spriteNormal.frameCounter = var4.frameCounter;
               }

               var4.spriteSpecular.updateAnimation();
               if (var4.spriteSpecular.isAnimationActive()) {
                  ++var3;
               }
            }
         }

         if (var1 || var2) {
            TextureUtil.bindTexture(this.getGlTextureId());
         }
      }

      int var7 = Config.getMinecraft().entityRenderer.frameCount;
      if (var7 != this.frameCountAnimations) {
         this.countAnimationsActive = var3;
         this.frameCountAnimations = var7;
      }

      if (SmartAnimations.isActive()) {
         SmartAnimations.resetSpritesRendered();
      }

      if (Config.isShaders()) {
         ShadersTex.updatingTex = null;
      }

   }

   public void loadSprites(IResourceManager var1, IIconCreator var2) {
      this.mapRegisteredSprites.clear();
      this.counterIndexInMap.reset();
      var2.registerSprites(this);
      if (this.mipmapLevels >= 4) {
         this.mipmapLevels = this.detectMaxMipmapLevel(this.mapRegisteredSprites, var1);
         Config.log("Mipmap levels: " + this.mipmapLevels);
      }

      this.initMissingImage();
      this.deleteGlTexture();
      this.loadTextureAtlas(var1);
   }

   public String getBasePath() {
      return this.basePath;
   }

   public TextureAtlasSprite getSpriteSafe(String var1) {
      ResourceLocation var2 = new ResourceLocation(var1);
      return (TextureAtlasSprite)this.mapRegisteredSprites.get(var2.toString());
   }

   public boolean setTextureEntry(String var1, TextureAtlasSprite var2) {
      if (!this.mapRegisteredSprites.containsKey(var1)) {
         this.mapRegisteredSprites.put(var1, var2);
         var2.updateIndexInMap(this.counterIndexInMap);
         return true;
      } else {
         return false;
      }
   }

   public void loadTextureAtlas(IResourceManager var1) {
      ShadersTex.resManager = var1;
      Config.dbg("Multitexture: " + Config.isMultiTexture());
      if (Config.isMultiTexture()) {
         Iterator var3 = this.mapUploadedSprites.values().iterator();

         while(var3.hasNext()) {
            TextureAtlasSprite var2 = (TextureAtlasSprite)var3.next();
            var2.deleteSpriteTexture();
         }
      }

      ConnectedTextures.updateIcons(this);
      CustomItems.updateIcons(this);
      BetterGrass.updateIcons(this);
      int var31 = TextureUtils.getGLMaximumTextureSize();
      Stitcher var32 = new Stitcher(var31, var31, true, 0, this.mipmapLevels);
      this.mapUploadedSprites.clear();
      this.listAnimatedSprites.clear();
      int var4 = Integer.MAX_VALUE;
      Reflector.callVoid(Reflector.ForgeHooksClient_onTextureStitchedPre, this);
      int var5 = this.getMinSpriteSize();
      this.iconGridSize = var5;
      int var6 = 1 << this.mipmapLevels;
      int var7 = 0;
      int var8 = 0;
      Iterator var9 = this.mapRegisteredSprites.entrySet().iterator();

      while(true) {
         int var40;
         if (var9.hasNext()) {
            Entry var10 = (Entry)var9.next();
            if (!this.skipFirst) {
               TextureAtlasSprite var34 = (TextureAtlasSprite)var10.getValue();
               ResourceLocation var36 = new ResourceLocation(var34.getIconName());
               ResourceLocation var39 = this.completeResourceLocation(var36, 0);
               var34.updateIndexInMap(this.counterIndexInMap);
               if (var34.hasCustomLoader(var1, var36)) {
                  if (!var34.load(var1, var36)) {
                     var4 = Math.min(var4, Math.min(var34.getIconWidth(), var34.getIconHeight()));
                     var32.addSprite(var34);
                     Config.detail("Custom loader (skipped): " + var34);
                     ++var8;
                  }

                  Config.detail("Custom loader: " + var34);
                  ++var7;
                  continue;
               }

               try {
                  IResource var41;
                  BufferedImage[] var44;
                  label346: {
                     var41 = var1.getResource(var39);
                     var44 = new BufferedImage[1 + this.mipmapLevels];
                     var44[0] = TextureUtil.readBufferedImage(var41.getInputStream());
                     int var46 = var44[0].getWidth();
                     int var48 = var44[0].getHeight();
                     if (var46 >= 1 && var48 >= 1) {
                        if (var46 < var5 || this.mipmapLevels > 0) {
                           int var51 = this.mipmapLevels > 0 ? TextureUtils.scaleToGrid(var46, var5) : TextureUtils.scaleToMin(var46, var5);
                           if (var51 != var46) {
                              if (!TextureUtils.isPowerOfTwo(var46)) {
                                 Config.log("Scaled non power of 2: " + var34.getIconName() + ", " + var46 + " -> " + var51);
                              } else {
                                 Config.log("Scaled too small texture: " + var34.getIconName() + ", " + var46 + " -> " + var51);
                              }

                              int var53 = var48 * var51 / var46;
                              var44[0] = TextureUtils.scaleImage(var44[0], var51);
                           }
                        }

                        TextureMetadataSection var52 = (TextureMetadataSection)var41.getMetadata("texture");
                        if (var52 == null) {
                           break label346;
                        }

                        List var54 = var52.getListMipmaps();
                        int var20;
                        if (!var54.isEmpty()) {
                           var20 = var44[0].getWidth();
                           int var21 = var44[0].getHeight();
                           if (MathHelper.roundUpToPowerOfTwo(var20) != var20 || MathHelper.roundUpToPowerOfTwo(var21) != var21) {
                              throw new RuntimeException("Unable to load extra miplevels, source-texture is not power of two");
                           }
                        }

                        Iterator var56 = var54.iterator();

                        while(true) {
                           if (!var56.hasNext()) {
                              break label346;
                           }

                           var20 = (Integer)var56.next();
                           if (var20 > 0 && var20 < var44.length - 1 && var44[var20] == null) {
                              ResourceLocation var22 = this.completeResourceLocation(var36, var20);

                              try {
                                 var44[var20] = TextureUtil.readBufferedImage(var1.getResource(var22).getInputStream());
                              } catch (IOException var28) {
                                 logger.error("Unable to load miplevel {} from: {}", new Object[]{var20, var22, var28});
                              }
                           }
                        }
                     }

                     Config.warn("Invalid sprite size: " + var34);
                     continue;
                  }

                  AnimationMetadataSection var55 = (AnimationMetadataSection)var41.getMetadata("animation");
                  var34.loadSprite(var44, var55);
               } catch (RuntimeException var29) {
                  logger.error("Unable to parse metadata from " + var39, var29);
                  ReflectorForge.FMLClientHandler_trackBrokenTexture(var39, var29.getMessage());
                  continue;
               } catch (IOException var30) {
                  logger.error("Using missing texture, unable to load " + var39 + ", " + var30.getClass().getName());
                  ReflectorForge.FMLClientHandler_trackMissingTexture(var39);
                  continue;
               }

               var4 = Math.min(var4, Math.min(var34.getIconWidth(), var34.getIconHeight()));
               var40 = Math.min(Integer.lowestOneBit(var34.getIconWidth()), Integer.lowestOneBit(var34.getIconHeight()));
               if (var40 < var6) {
                  logger.warn("Texture {} with size {}x{} limits mip level from {} to {}", new Object[]{var39, var34.getIconWidth(), var34.getIconHeight(), MathHelper.calculateLogBaseTwo(var6), MathHelper.calculateLogBaseTwo(var40)});
                  var6 = var40;
               }

               var32.addSprite(var34);
               continue;
            }
         }

         if (var7 > 0) {
            Config.dbg("Custom loader sprites: " + var7);
         }

         if (var8 > 0) {
            Config.dbg("Custom loader sprites (skipped): " + var8);
         }

         int var33 = Math.min(var4, var6);
         int var11 = MathHelper.calculateLogBaseTwo(var33);
         if (var11 < 0) {
            var11 = 0;
         }

         if (var11 < this.mipmapLevels) {
            logger.warn("{}: dropping miplevel from {} to {}, because of minimum power of two: {}", new Object[]{this.basePath, this.mipmapLevels, var11, var33});
            this.mipmapLevels = var11;
         }

         Iterator var13 = this.mapRegisteredSprites.values().iterator();

         while(var13.hasNext()) {
            TextureAtlasSprite var12 = (TextureAtlasSprite)var13.next();
            if (this.skipFirst) {
               break;
            }

            try {
               var12.generateMipmaps(this.mipmapLevels);
            } catch (Throwable var27) {
               CrashReport var15 = CrashReport.makeCrashReport(var27, "Applying mipmap");
               CrashReportCategory var16 = var15.makeCategory("Sprite being mipmapped");
               var16.addCrashSectionCallable("Sprite name", new Callable<String>(this, var12) {
                  final TextureMap this$0;
                  private final TextureAtlasSprite val$textureatlassprite1;

                  public String call() throws Exception {
                     return this.val$textureatlassprite1.getIconName();
                  }

                  {
                     this.this$0 = var1;
                     this.val$textureatlassprite1 = var2;
                  }

                  public Object call() throws Exception {
                     return this.call();
                  }
               });
               var16.addCrashSectionCallable("Sprite size", new Callable<String>(this, var12) {
                  final TextureMap this$0;
                  private final TextureAtlasSprite val$textureatlassprite1;

                  public String call() throws Exception {
                     return this.val$textureatlassprite1.getIconWidth() + " x " + this.val$textureatlassprite1.getIconHeight();
                  }

                  {
                     this.this$0 = var1;
                     this.val$textureatlassprite1 = var2;
                  }

                  public Object call() throws Exception {
                     return this.call();
                  }
               });
               var16.addCrashSectionCallable("Sprite frames", new Callable<String>(this, var12) {
                  final TextureMap this$0;
                  private final TextureAtlasSprite val$textureatlassprite1;

                  public String call() throws Exception {
                     return this.val$textureatlassprite1.getFrameCount() + " frames";
                  }

                  {
                     this.this$0 = var1;
                     this.val$textureatlassprite1 = var2;
                  }

                  public Object call() throws Exception {
                     return this.call();
                  }
               });
               var16.addCrashSection("Mipmap levels", this.mipmapLevels);
               throw new ReportedException(var15);
            }
         }

         this.missingImage.generateMipmaps(this.mipmapLevels);
         var32.addSprite(this.missingImage);
         this.skipFirst = false;

         try {
            var32.doStitch();
         } catch (StitcherException var26) {
            throw var26;
         }

         logger.info("Created: {}x{} {}-atlas", new Object[]{var32.getCurrentWidth(), var32.getCurrentHeight(), this.basePath});
         if (Config.isShaders()) {
            ShadersTex.allocateTextureMap(this.getGlTextureId(), this.mipmapLevels, var32.getCurrentWidth(), var32.getCurrentHeight(), var32, this);
         } else {
            TextureUtil.allocateTextureImpl(this.getGlTextureId(), this.mipmapLevels, var32.getCurrentWidth(), var32.getCurrentHeight());
         }

         HashMap var35 = Maps.newHashMap(this.mapRegisteredSprites);
         Iterator var14 = var32.getStichSlots().iterator();

         TextureAtlasSprite var37;
         while(var14.hasNext()) {
            var37 = (TextureAtlasSprite)var14.next();
            if (Config.isShaders()) {
               ShadersTex.setIconName(ShadersTex.setSprite(var37).getIconName());
            }

            String var42 = var37.getIconName();
            var35.remove(var42);
            this.mapUploadedSprites.put(var42, var37);

            try {
               if (Config.isShaders()) {
                  ShadersTex.uploadTexSubForLoadAtlas(var37.getFrameTextureData(0), var37.getIconWidth(), var37.getIconHeight(), var37.getOriginX(), var37.getOriginY(), false, false);
               } else {
                  TextureUtil.uploadTextureMipmap(var37.getFrameTextureData(0), var37.getIconWidth(), var37.getIconHeight(), var37.getOriginX(), var37.getOriginY(), false, false);
               }
            } catch (Throwable var25) {
               CrashReport var17 = CrashReport.makeCrashReport(var25, "Stitching texture atlas");
               CrashReportCategory var18 = var17.makeCategory("Texture being stitched together");
               var18.addCrashSection("Atlas path", this.basePath);
               var18.addCrashSection("Sprite", var37);
               throw new ReportedException(var17);
            }

            if (var37.hasAnimationMetadata()) {
               var37.setAnimationIndex(this.listAnimatedSprites.size());
               this.listAnimatedSprites.add(var37);
            }
         }

         var14 = var35.values().iterator();

         while(var14.hasNext()) {
            var37 = (TextureAtlasSprite)var14.next();
            var37.copyFrom(this.missingImage);
         }

         Config.log("Animated sprites: " + this.listAnimatedSprites.size());
         if (Config.isMultiTexture()) {
            int var38 = var32.getCurrentWidth();
            var40 = var32.getCurrentHeight();
            Iterator var45 = var32.getStichSlots().iterator();

            while(var45.hasNext()) {
               TextureAtlasSprite var43 = (TextureAtlasSprite)var45.next();
               var43.sheetWidth = var38;
               var43.sheetHeight = var40;
               var43.mipmapLevels = this.mipmapLevels;
               TextureAtlasSprite var47 = var43.spriteSingle;
               if (var47 != null) {
                  if (var47.getIconWidth() <= 0) {
                     var47.setIconWidth(var43.getIconWidth());
                     var47.setIconHeight(var43.getIconHeight());
                     var47.initSprite(var43.getIconWidth(), var43.getIconHeight(), 0, 0, false);
                     var47.clearFramesTextureData();
                     List var49 = var43.getFramesTextureData();
                     var47.setFramesTextureData(var49);
                     var47.setAnimationMetadata(var43.getAnimationMetadata());
                  }

                  var47.sheetWidth = var38;
                  var47.sheetHeight = var40;
                  var47.mipmapLevels = this.mipmapLevels;
                  var47.setAnimationIndex(var43.getAnimationIndex());
                  var43.bindSpriteTexture();
                  boolean var50 = false;
                  boolean var19 = true;

                  try {
                     TextureUtil.uploadTextureMipmap(var47.getFrameTextureData(0), var47.getIconWidth(), var47.getIconHeight(), var47.getOriginX(), var47.getOriginY(), var50, var19);
                  } catch (Exception var24) {
                     Config.dbg("Error uploading sprite single: " + var47 + ", parent: " + var43);
                     var24.printStackTrace();
                  }
               }
            }

            Config.getMinecraft().getTextureManager().bindTexture(locationBlocksTexture);
         }

         Reflector.callVoid(Reflector.ForgeHooksClient_onTextureStitchedPost, this);
         this.updateIconGrid(var32.getCurrentWidth(), var32.getCurrentHeight());
         if (Config.equals(System.getProperty("saveTextureMap"), "true")) {
            Config.dbg("Exporting texture map: " + this.basePath);
            TextureUtils.saveGlTexture("debug/" + this.basePath.replaceAll("/", "_"), this.getGlTextureId(), this.mipmapLevels, var32.getCurrentWidth(), var32.getCurrentHeight());
         }

         return;
      }
   }

   public TextureAtlasSprite getMissingSprite() {
      return this.missingImage;
   }

   private int detectMinimumSpriteSize(Map var1, IResourceManager var2, int var3) {
      HashMap var4 = new HashMap();
      Iterator var6 = var1.entrySet().iterator();

      int var14;
      while(var6.hasNext()) {
         Object var5 = var6.next();
         Entry var7 = (Entry)var5;
         TextureAtlasSprite var8 = (TextureAtlasSprite)var7.getValue();
         ResourceLocation var9 = new ResourceLocation(var8.getIconName());
         ResourceLocation var10 = this.completeResourceLocation(var9);
         if (!var8.hasCustomLoader(var2, var9)) {
            try {
               IResource var11 = var2.getResource(var10);
               if (var11 != null) {
                  InputStream var12 = var11.getInputStream();
                  if (var12 != null) {
                     Dimension var13 = TextureUtils.getImageSize(var12, "png");
                     if (var13 != null) {
                        var14 = var13.width;
                        int var15 = MathHelper.roundUpToPowerOfTwo(var14);
                        if (!var4.containsKey(var15)) {
                           var4.put(var15, 1);
                        } else {
                           int var16 = (Integer)var4.get(var15);
                           var4.put(var15, var16 + 1);
                        }
                     }
                  }
               }
            } catch (Exception var17) {
            }
         }
      }

      int var18 = 0;
      Set var19 = var4.keySet();
      TreeSet var20 = new TreeSet(var19);

      int var25;
      int var26;
      for(Iterator var23 = var20.iterator(); var23.hasNext(); var18 += var26) {
         Object var21 = var23.next();
         var25 = (Integer)var21;
         var26 = (Integer)var4.get(var25);
      }

      int var22 = 16;
      int var24 = 0;
      var25 = var18 * var3 / 100;
      Iterator var28 = var20.iterator();

      do {
         if (!var28.hasNext()) {
            return var22;
         }

         Object var27 = var28.next();
         int var29 = (Integer)var27;
         var14 = (Integer)var4.get(var29);
         var24 += var14;
         if (var29 > var22) {
            var22 = var29;
         }
      } while(var24 <= var25);

      return var22;
   }

   public TextureAtlasSprite getAtlasSprite(String var1) {
      TextureAtlasSprite var2 = (TextureAtlasSprite)this.mapUploadedSprites.get(var1);
      if (var2 == null) {
         var2 = this.missingImage;
      }

      return var2;
   }

   public int getCountAnimationsActive() {
      return this.countAnimationsActive;
   }

   public TextureAtlasSprite registerSprite(ResourceLocation var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("Location cannot be null!");
      } else {
         TextureAtlasSprite var2 = (TextureAtlasSprite)this.mapRegisteredSprites.get(var1.toString());
         if (var2 == null) {
            var2 = TextureAtlasSprite.makeAtlasSprite(var1);
            this.mapRegisteredSprites.put(var1.toString(), var2);
            var2.updateIndexInMap(this.counterIndexInMap);
            if (Config.isEmissiveTextures()) {
               this.checkEmissive(var1, var2);
            }
         }

         return var2;
      }
   }

   public int getCountAnimations() {
      return this.listAnimatedSprites.size();
   }

   private boolean isAbsoluteLocation(ResourceLocation var1) {
      String var2 = var1.getResourcePath();
      return this.isAbsoluteLocationPath(var2);
   }

   public int getCountRegisteredSprites() {
      return this.counterIndexInMap.getValue();
   }

   public TextureAtlasSprite getRegisteredSprite(ResourceLocation var1) {
      return (TextureAtlasSprite)this.mapRegisteredSprites.get(var1.toString());
   }

   public void loadTexture(IResourceManager var1) throws IOException {
      ShadersTex.resManager = var1;
      if (this.iconCreator != null) {
         this.loadSprites(var1, this.iconCreator);
      }

   }

   public void tick() {
      this.updateAnimations();
   }

   public TextureMap(String var1) {
      this(var1, (IIconCreator)null);
   }

   private int[] getMissingImageData(int var1) {
      BufferedImage var2 = new BufferedImage(16, 16, 2);
      var2.setRGB(0, 0, 16, 16, TextureUtil.missingTextureData, 0, 16);
      BufferedImage var3 = TextureUtils.scaleImage(var2, var1);
      int[] var4 = new int[var1 * var1];
      var3.getRGB(0, 0, var1, var1, var4, 0, var1);
      return var4;
   }

   private void updateIconGrid(int var1, int var2) {
      this.iconGridCountX = -1;
      this.iconGridCountY = -1;
      this.iconGrid = null;
      if (this.iconGridSize > 0) {
         this.iconGridCountX = var1 / this.iconGridSize;
         this.iconGridCountY = var2 / this.iconGridSize;
         this.iconGrid = new TextureAtlasSprite[this.iconGridCountX * this.iconGridCountY];
         this.iconGridSizeU = 1.0D / (double)this.iconGridCountX;
         this.iconGridSizeV = 1.0D / (double)this.iconGridCountY;
         Iterator var4 = this.mapUploadedSprites.values().iterator();

         while(var4.hasNext()) {
            TextureAtlasSprite var3 = (TextureAtlasSprite)var4.next();
            double var5 = 0.5D / (double)var1;
            double var7 = 0.5D / (double)var2;
            double var9 = (double)Math.min(var3.getMinU(), var3.getMaxU()) + var5;
            double var11 = (double)Math.min(var3.getMinV(), var3.getMaxV()) + var7;
            double var13 = (double)Math.max(var3.getMinU(), var3.getMaxU()) - var5;
            double var15 = (double)Math.max(var3.getMinV(), var3.getMaxV()) - var7;
            int var17 = (int)(var9 / this.iconGridSizeU);
            int var18 = (int)(var11 / this.iconGridSizeV);
            int var19 = (int)(var13 / this.iconGridSizeU);
            int var20 = (int)(var15 / this.iconGridSizeV);

            for(int var21 = var17; var21 <= var19; ++var21) {
               if (var21 >= 0 && var21 < this.iconGridCountX) {
                  for(int var22 = var18; var22 <= var20; ++var22) {
                     if (var22 >= 0 && var22 < this.iconGridCountX) {
                        int var23 = var22 * this.iconGridCountX + var21;
                        this.iconGrid[var23] = var3;
                     } else {
                        Config.warn("Invalid grid V: " + var22 + ", icon: " + var3.getIconName());
                     }
                  }
               } else {
                  Config.warn("Invalid grid U: " + var21 + ", icon: " + var3.getIconName());
               }
            }
         }
      }

   }

   private boolean isTerrainAnimationActive(TextureAtlasSprite var1) {
      if (var1 != TextureUtils.iconWaterStill && var1 != TextureUtils.iconWaterFlow) {
         if (var1 != TextureUtils.iconLavaStill && var1 != TextureUtils.iconLavaFlow) {
            if (var1 != TextureUtils.iconFireLayer0 && var1 != TextureUtils.iconFireLayer1) {
               if (var1 == TextureUtils.iconPortal) {
                  return Config.isAnimatedPortal();
               } else {
                  return var1 != TextureUtils.iconClock && var1 != TextureUtils.iconCompass ? Config.isAnimatedTerrain() : true;
               }
            } else {
               return Config.isAnimatedFire();
            }
         } else {
            return Config.isAnimatedLava();
         }
      } else {
         return Config.isAnimatedWater();
      }
   }

   public void setMipmapLevels(int var1) {
      this.mipmapLevels = var1;
   }

   public TextureMap(String var1, boolean var2) {
      this(var1, (IIconCreator)null, var2);
   }

   public TextureAtlasSprite getTextureExtry(String var1) {
      return (TextureAtlasSprite)this.mapRegisteredSprites.get(var1);
   }

   public ResourceLocation completeResourceLocation(ResourceLocation var1, int var2) {
      if (this.isAbsoluteLocation(var1)) {
         return new ResourceLocation(var1.getResourceDomain(), var1.getResourcePath() + ".png");
      } else {
         return var2 == 0 ? new ResourceLocation(var1.getResourceDomain(), String.format("%s/%s%s", this.basePath, var1.getResourcePath(), ".png")) : new ResourceLocation(var1.getResourceDomain(), String.format("%s/mipmaps/%s.%d%s", this.basePath, var1.getResourcePath(), var2, ".png"));
      }
   }

   public TextureAtlasSprite getIconByUV(double var1, double var3) {
      if (this.iconGrid == null) {
         return null;
      } else {
         int var5 = (int)(var1 / this.iconGridSizeU);
         int var6 = (int)(var3 / this.iconGridSizeV);
         int var7 = var6 * this.iconGridCountX + var5;
         return var7 >= 0 && var7 <= this.iconGrid.length ? this.iconGrid[var7] : null;
      }
   }

   public TextureMap(String var1, IIconCreator var2) {
      this(var1, var2, false);
   }

   private int detectMaxMipmapLevel(Map var1, IResourceManager var2) {
      int var3 = this.detectMinimumSpriteSize(var1, var2, 20);
      if (var3 < 16) {
         var3 = 16;
      }

      var3 = MathHelper.roundUpToPowerOfTwo(var3);
      if (var3 > 16) {
         Config.log("Sprite size: " + var3);
      }

      int var4 = MathHelper.calculateLogBaseTwo(var3);
      if (var4 < 4) {
         var4 = 4;
      }

      return var4;
   }

   public TextureMap(String var1, IIconCreator var2, boolean var3) {
      this.skipFirst = false;
      this.iconGrid = null;
      this.iconGridSize = -1;
      this.iconGridCountX = -1;
      this.iconGridCountY = -1;
      this.iconGridSizeU = -1.0D;
      this.iconGridSizeV = -1.0D;
      this.counterIndexInMap = new CounterInt(0);
      this.atlasWidth = 0;
      this.atlasHeight = 0;
      this.listAnimatedSprites = Lists.newArrayList();
      this.mapRegisteredSprites = Maps.newHashMap();
      this.mapUploadedSprites = Maps.newHashMap();
      this.missingImage = new TextureAtlasSprite("missingno");
      this.basePath = var1;
      this.iconCreator = var2;
      this.skipFirst = var3 && ENABLE_SKIP;
   }

   private void checkEmissive(ResourceLocation var1, TextureAtlasSprite var2) {
      String var3 = EmissiveTextures.getSuffixEmissive();
      if (var3 != null && !var1.getResourcePath().endsWith(var3)) {
         ResourceLocation var4 = new ResourceLocation(var1.getResourceDomain(), var1.getResourcePath() + var3);
         ResourceLocation var5 = this.completeResourceLocation(var4);
         if (Config.hasResource(var5)) {
            TextureAtlasSprite var6 = this.registerSprite(var4);
            var6.isEmissive = true;
            var2.spriteEmissive = var6;
         }
      }

   }

   private boolean isAbsoluteLocationPath(String var1) {
      String var2 = var1.toLowerCase();
      return var2.startsWith("mcpatcher/") || var2.startsWith("optifine/");
   }

   public ResourceLocation completeResourceLocation(ResourceLocation var1) {
      return this.completeResourceLocation(var1, 0);
   }

   public int getMipmapLevels() {
      return this.mipmapLevels;
   }

   public boolean isTextureBound() {
      int var1 = GlStateManager.getBoundTexture();
      int var2 = this.getGlTextureId();
      return var1 == var2;
   }
}
